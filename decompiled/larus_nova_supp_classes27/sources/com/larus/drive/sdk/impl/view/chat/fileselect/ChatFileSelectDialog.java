package com.larus.drive.sdk.impl.view.chat.fileselect;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.collection.LruCache;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common_ui.widget.ChatFileSelectorView;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.impl.databinding.LarusDialogChatFileSelectBinding;
import com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatRecentFileSelectAdapter;
import com.larus.drive.sdk.impl.view.chat.fileselect.data.ChatRecentFileLoadProcessor;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.fileselect.IChatFileSelectionStore;
import com.larus.platform.api.fileselect.SelectDialogParam;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 K2\u00020\u0001:\u0002KLB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\u0012\u00103\u001a\u00020\u001d2\b\u00104\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u00105\u001a\u00020\u001d2\b\u00104\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u00106\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>H\u0002J\u0014\u0010?\u001a\u0004\u0018\u00010\u000b2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0014\u0010@\u001a\u0004\u0018\u00010\u000b2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0018\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020:H\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020:H\u0002J\u000e\u0010F\u001a\u0004\u0018\u00010G*\u00020>H\u0002J\f\u0010H\u001a\u00020\u0007*\u00020:H\u0002J\u0010\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/ChatFileSelectDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusDialogChatFileSelectBinding;", "hasShownAnim", "", "recentUiState", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/ChatFileSelectDialog$RecentListUiState;", "conversationId", "", "lastChatTime", "", "Ljava/lang/Long;", "dialogParam", "Lcom/larus/platform/api/fileselect/SelectDialogParam;", "callback", "Lcom/larus/platform/api/fileselect/IChatFileSelectCallback;", "recentAdapter", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter;", "selectionStore", "Lcom/larus/platform/api/fileselect/IChatFileSelectionStore;", "lastRecentDisabled", "Ljava/lang/Boolean;", "localFileLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onDestroyView", "initArgs", "initStore", "initDrive", "startEnterAnimation", "setupView", "setupRecentList", "renderRecentList", "state", "launchLocalFilePicker", "handleLocalFileResult", "data", "handleLocalFileResultAndSend", "dispatchCurrentSelectionAndDismiss", "tag", "mobUploadAttachmentStatus", "select", "Lcom/larus/platform/api/FlowSelectedFileItem;", "source", "Lcom/larus/platform/api/fileselect/IChatFileSelectionStore$Source;", "selectedCount", "", "resolveUploadFrom", "resolveUploadWay", "showRejectionToast", "reason", "Lcom/larus/platform/api/fileselect/IChatFileSelectionStore$RejectionReason;", "item", "validateRecentLarkDocCapability", "toOfficeAskDoubaoType", "Lcom/larus/platform/model/OfficeAskDoubaoType;", "isLarkDocType", "getFileVisitTimeString", "visitTime", "Companion", "RecentListUiState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatFileSelectDialog extends DialogFragment {
    public static final /* synthetic */ int o = 0;
    public LarusDialogChatFileSelectBinding d;
    public boolean e;
    public RecentListUiState f;
    public String g;
    public Long h;
    public SelectDialogParam i;
    public aq9.b j;
    public ChatRecentFileSelectAdapter k;
    public final com.larus.platform.api.fileselect.a l;
    public Boolean m;
    public ActivityResultLauncher<Intent> n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/ChatFileSelectDialog$RecentListUiState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "SUCCESS", "EMPTY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RecentListUiState extends Enum<RecentListUiState> {
        public static final RecentListUiState EMPTY = null;
        public static final RecentListUiState LOADING = null;
        public static final RecentListUiState SUCCESS = null;
        public static final /* synthetic */ RecentListUiState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<RecentListUiState> getEntries() {
            return b;
        }

        static {
            RecentListUiState r0 = new RecentListUiState("LOADING", 0);
            LOADING = r0;
            RecentListUiState r1 = new RecentListUiState("SUCCESS", 1);
            SUCCESS = r1;
            RecentListUiState r3 = new RecentListUiState("EMPTY", 2);
            EMPTY = r3;
            RecentListUiState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static RecentListUiState[] values() {
            return (RecentListUiState[]) a.clone();
        }

        public static RecentListUiState valueOf(String r1) {
            return (RecentListUiState) r27.a.a(RecentListUiState.class, r1);
        }

        public RecentListUiState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[RecentListUiState.values().length];
            r0[RecentListUiState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[RecentListUiState.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[RecentListUiState.EMPTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[IChatFileSelectionStore.Source.values().length];
            r1[IChatFileSelectionStore.Source.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[IChatFileSelectionStore.Source.DRIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    static {
    }

    public ChatFileSelectDialog() {
        this.l = new com.larus.platform.api.fileselect.a();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L18;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L18;
        r1.setLayout(-1, -1);
        r1.setGravity(80);
        r1.clearFlags(2);
        LarusDialogChatFileSelectBinding r2 = this.d;
        if (r2 == null) goto L11;
        ConstraintLayout r3 = r2.a;
        if (r3 == null) goto L11;
    L16:
        new WindowInsetsControllerCompat(r1, r3).setAppearanceLightStatusBars(false);
    L11:
        r3 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L16;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L16;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L18:
        if (this.e == true) goto L31;
        this.e = true;
        LarusDialogChatFileSelectBinding r5 = this.d;
        if (r5 == null) goto L30;
        final View r6 = r5.h;
        if (r6 == null) goto L32;
        final ConstraintLayout r7 = r5.e;
        if (r7 == null) goto L33;
        r6.setAlpha(0.0f);
        r7.post(new f(r7, r6));
        return;
    L33:
        return;
    L32:
        return;
    L30:
        return;
    }

    public final void S90(String r45) {
        List r0 = this.l.snapshot();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r0.iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        com.larus.platform.api.u r5 = (com.larus.platform.api.u) r4.next();
        if (this.l.e(r5.a) == IChatFileSelectionStore.Source.LOCAL) goto L10;
        r3.add(r5);
        goto L7
    L10:
        r2.add(UriProtector.parse(r5.a));
        goto L7
    L13:
        if ((!r3.isEmpty()) == false) goto L82;
        FlowDriveSdkService.a.w(r45, r3);
        Iterator r6 = r3.iterator();
    L16:
        if (r6.hasNext() == false) goto L82;
        com.larus.platform.api.u r7 = (com.larus.platform.api.u) r6.next();
        IChatFileSelectionStore.Source r8 = this.l.e(r7.a);
        int r9 = r0.size();
        int r10 = com.larus.drive.sdk.impl.utils.n.a;
        Integer r11 = Integer.valueOf(r7.h);
        String r12 = r7.b;
        DriveFileType r13 = com.larus.drive.sdk.impl.utils.n.a(r11, r12);
        if (r13 == DriveFileType.BITABLE) goto L20;
        aq9.g r14 = null;
    L24:
        LruCache r15 = ko8.a.a;
        SelectDialogParam r16 = this.i;
        if (r16 == null) goto L27;
        String r17 = r16.getBotId();
    L29:
        if (r9 <= 1) goto L31;
        boolean r18 = true;
    L32:
        FlowDriveFileType r20 = r7.f;
        if (r20 != FlowDriveFileType.IMAGE) goto L35;
        boolean r110 = true;
    L37:
        if (r20 != FlowDriveFileType.AUDIO) goto L39;
        boolean r111 = true;
    L41:
        if (r20 != FlowDriveFileType.VIDEO) goto L43;
        boolean r112 = true;
    L44:
        String r21 = r7.a;
        String r22 = r7.b;
        SelectDialogParam r23 = this.i;
        if (r23 == null) goto L47;
        String r26 = r23.getPreviousPage();
    L48:
        Map r24 = r7.m;
        int r113 = -1;
        if (r24 == null) goto L52;
        String r25 = (String) r24.get("upload_from");
        if (r25 == null) goto L52;
    L60:
        String r33 = r25;
    L61:
        Map r27 = r7.m;
        if (r27 == null) goto L65;
        String r28 = (String) r27.get("upload_way");
        if (r28 == null) goto L65;
    L73:
        String r34 = r28;
    L74:
        if (r14 == null) goto L76;
        String r37 = r14.a;
    L77:
        if (r14 == null) goto L79;
        String r38 = r14.b;
    L80:
        ko8.a.m(r17, "chat", r18, null, r110, r111, r112, true, r21, r22, null, null, null, null, r26, null, null, null, null, null, null, r33, r34, null, null, r37, r38, null, null, null, null, 2040511496);
        goto L16
    L79:
        r38 = null;
        goto L80
    L76:
        r37 = null;
    L65:
        if (r8 == null) goto L68;
        r113 = b.b[r8.ordinal()];
    L68:
        if (r113 == 1) goto L72;
        if (r113 == 2) goto L71;
        r34 = null;
        goto L74
    L71:
        r28 = "input_ai_space";
        goto L73
    L72:
        r28 = "recent_sent_file";
    L52:
        if (r8 != null) goto L54;
        int r30 = -1;
    L55:
        if (r30 == 1) goto L59;
        if (r30 == 2) goto L58;
        r33 = null;
        goto L61
    L58:
        r25 = "drive";
        goto L60
    L59:
        r25 = "local";
        goto L60
    L54:
        r30 = b.b[r8.ordinal()];
        goto L55
    L47:
        r26 = null;
        goto L48
    L43:
        r112 = false;
        goto L44
    L39:
        r111 = false;
        goto L41
    L35:
        r110 = false;
        goto L37
    L31:
        r18 = false;
        goto L32
    L27:
        r17 = null;
        goto L29
    L20:
        String r114 = com.larus.drive.sdk.impl.utils.n.e(r13);
        if (r12 != null) goto L23;
        r12 = "";
    L23:
        r14 = new aq9.g(r114, com.larus.drive.sdk.impl.utils.n.c(r13, r12));
    L82:
        if ((!r2.isEmpty()) == false) goto L93;
        aq9.b r1 = this.j;
        if (r1 == null) goto L93;
        r1.a(r2);
    L93:
        dismissAllowingStateLoss();     // Catch: Exception -> L88
        return;
    L88:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r31 = DialogFragmentLancet.sLastShowStack;
        if (r31 == null) goto L104;
        com.bytedance.crash.d.d(r31, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(RecentListUiState r5) {
        if (this.f != r5) goto L5;
        return;
    L5:
        this.f = r5;
        LarusDialogChatFileSelectBinding r0 = this.d;
        if (r0 != null) goto L8;
        return;
    L8:
        int r6 = b.a[r5.ordinal()];
        if (r6 != 1) goto L11;
        r0.k.setVisibility(0);
        r0.l.setVisibility(8);
        r0.j.setVisibility(8);
        r0.i.setVisibility(8);
        return;
    L11:
        if (r6 != 2) goto L13;
        r0.k.setVisibility(8);
        r0.l.setVisibility(0);
        r0.j.setVisibility(0);
        r0.i.setVisibility(8);
        return;
    L13:
        if (r6 != 3) goto L16;
        r0.k.setVisibility(8);
        r0.l.setVisibility(8);
        r0.j.setVisibility(8);
        r0.i.setVisibility(0);
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        if (r8 != null) goto L35;
        this.n = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new com.larus.drive.sdk.impl.view.chat.fileselect.a(this));
        Bundle r9 = getArguments();
        SelectDialogParam r0 = null;
        if (r9 == null) goto L14;
        String r10 = r9.getString("arg_conversation_id");
    L15:
        this.g = r10;
        Bundle r11 = getArguments();
        if (r11 != null) goto L18;
    L23:
        Long r12 = null;
    L24:
        this.h = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L27;
        Serializable r14 = r13.getSerializable("arg_dialog_param");
    L29:
        if ((r14 instanceof SelectDialogParam) == false) goto L31;
        r0 = (SelectDialogParam) r14;
    L31:
        this.i = r0;
        setStyle(2, 2131952391);
        setCancelable(true);
        com.larus.platform.api.fileselect.a r15 = this.l;
        ImFileUtil.a.getClass();
        r15.d(new aq9.f(null, 0, ImFileUtil.k(), ImFileUtil.n(), ImFileUtil.l()));
        IOfficeSdkServiceV2 r16 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r16 == null) goto L39;
        IOfficeSdkServiceV2.a.b(r16, false, "chat_file_select", 5);
        return;
    L39:
        return;
    L27:
        r14 = null;
        goto L29
    L18:
        if (r11.containsKey("arg_last_chat_time") == true) goto L21;
        r11 = null;
    L21:
        if (r11 == null) goto L23;
        r12 = Long.valueOf(r11.getLong("arg_last_chat_time"));
        goto L24
    L14:
        r10 = null;
        goto L15
    L35:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r17 = DialogFragmentLancet.sLastShowStack;
        if (r17 == null) goto L37;
        com.bytedance.crash.d.d(r17, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void U90(IChatFileSelectionStore.a r10, com.larus.platform.api.u r11) {
        if ((r10 instanceof IChatFileSelectionStore.a.d) == false) goto L38;
        IChatFileSelectionStore.a.d r12 = (IChatFileSelectionStore.a.d) r10;
        FlowDriveFileType r13 = r12.a;
        FlowDriveFileType r0 = FlowDriveFileType.VIDEO;
        if (r13 == r0) goto L33;
        FlowDriveFileType r14 = r12.b;
        if (r14 == r0) goto L33;
        FlowDriveFileType r1 = FlowDriveFileType.AUDIO;
        if (r13 == r1) goto L30;
        if (r14 == r1) goto L30;
        FlowDriveFileType r2 = FlowDriveFileType.IMAGE;
        if (r13 == r2) goto L27;
        if (r14 == r2) goto L27;
        FlowDriveFileType r3 = FlowDriveFileType.FILE;
        if (r13 == r3) goto L24;
        if (r14 == r3) goto L24;
        Context r15 = getContext();
        if (r15 == null) goto L36;
        String r16 = r15.getString(2131900750);
    L65:
        FragmentActivity r17 = getActivity();
        if (r17 != null) goto L68;
        return;
    L68:
        if (r16 == null) goto L73;
        LifecycleOwnerKt.getLifecycleScope(r17).launchWhenResumed(new ChatFileSelectDialog$showRejectionToast$1$1(r17, r16, null));
        return;
    L73:
        return;
    L36:
        r16 = null;
    L24:
        Context r18 = getContext();
        if (r18 == null) goto L36;
        r16 = r18.getString(2131900813);
    L27:
        Context r110 = getContext();
        if (r110 == null) goto L36;
        r16 = r110.getString(2131909178);
    L30:
        Context r111 = getContext();
        if (r111 == null) goto L36;
        r16 = r111.getString(2131909177);
    L33:
        Context r112 = getContext();
        if (r112 == null) goto L36;
        r16 = r112.getString(2131909178);
        goto L65
    L38:
        if ((r10 instanceof IChatFileSelectionStore.a.c) == false) goto L47;
        if (r11.f != FlowDriveFileType.IMAGE) goto L42;
        int r113 = 2131907895;
    L43:
        Context r4 = getContext();
        if (r4 == null) goto L36;
        r16 = r4.getString(r113, new Object[]{String.valueOf(((IChatFileSelectionStore.a.c) r10).a)});
        goto L65
    L42:
        r113 = 2131907892;
        goto L43
    L47:
        if ((r10 instanceof IChatFileSelectionStore.a.a) == false) goto L56;
        if (r11.f != FlowDriveFileType.IMAGE) goto L51;
        int r114 = 2131907896;
    L52:
        Context r5 = getContext();
        if (r5 == null) goto L36;
        StringBuilder r6 = new StringBuilder();
        long r7 = 1024;
        r6.append((((IChatFileSelectionStore.a.a) r10).a / r7) / r7);
        r6.append("MB");
        r16 = r5.getString(r114, new Object[]{r6.toString()});
        goto L65
    L51:
        r114 = 2131907893;
        goto L52
    L56:
        if ((r10 instanceof IChatFileSelectionStore.a.e) == false) goto L61;
        Context r115 = getContext();
        if (r115 == null) goto L36;
        r16 = r115.getString(2131900750);
        goto L65
    L61:
        if (Intrinsics.areEqual(r10, IChatFileSelectionStore.a.b.a) == false) goto L72;
        Context r116 = getContext();
        if (r116 == null) goto L36;
        r16 = r116.getString(2131900750);
        goto L65
    L72:
        throw new NoWhenBranchMatchedException();
    }

    public final void onViewCreated(View r510, Bundle r60) {
        Intrinsics.checkNotNullParameter(r510, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r510, r60);
        final LarusDialogChatFileSelectBinding r1 = this.d;
        String r2 = null;
        if (r1 == null) goto L31;
        r1.g.setText(getString(2131900819));
        ViewCompat.setOnApplyWindowInsetsListener(r1.a, new com.larus.drive.sdk.impl.view.chat.fileselect.b(r1));
        ViewCompat.requestApplyInsets(r1.a);
        e1.d(r1.d, new c(this));
        e1.d(r1.b, new d(this));
        e1.d(r1.c, new e(this));
        LarusDialogChatFileSelectBinding r3 = this.d;
        if (r3 == null) goto L31;
        T90(RecentListUiState.LOADING);
        this.k = new ChatRecentFileSelectAdapter(this.g, this.h, LifecycleOwnerKt.getLifecycleScope(this), new i(this));
        r3.l.setText(getString(2131900817));
        RecyclerView r4 = r3.j;
        r4.setLayoutManager(new LinearLayoutManager(r4.getContext(), 1, false));
        r4.setAdapter(this.k);
        r4.setItemAnimator(null);
        r3.f.a(new ChatFileSelectorView.b(getTag(), this.l.snapshot(), new j(this)));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ChatFileSelectDialog$setupRecentList$4(this, r3, null), 3, null);
        ChatRecentFileSelectAdapter r5 = this.k;
        if (r5 == null) goto L31;
        String r6 = r5.b;
        Long r7 = r5.c;
        if (r7 == null) goto L13;
        long r8 = r7.longValue();
    L14:
        r5.h = new ChatRecentFileLoadProcessor(r6, r8);
        r5.i = false;
        r5.j = true;
        r5.k = true;
        if (r5.a.isEmpty() == true) goto L30;
        List r9 = CollectionsKt.toList(r5.a);
        r5.a.clear();
        Iterator r10 = r9.iterator();
    L19:
        if (r10.hasNext() == false) goto L30;
        String r11 = (String) r10.next();
        Iterator r12 = r5.getCurrentList().iterator();
        int r13 = 0;
    L22:
        if (r12.hasNext() == false) goto L27;
        if (Intrinsics.areEqual(((x79.a) r12.next()).a, r11) == true) goto L28;
        r13 = r13 + 1;
    L28:
        if (r13 < 0) goto L19;
        r5.notifyItemChanged(r13);
        goto L19
    L27:
        r13 = -1;
    L30:
        r5.submitList(CollectionsKt.emptyList());
        r5.l.clear();
        r5.m.clear();
        r5.D2();
        goto L31
    L13:
        r8 = System.currentTimeMillis();
    L31:
        SelectDialogParam r14 = this.i;
        if (r14 == null) goto L34;
        String r15 = r14.getBotId();
    L35:
        if (r15 != null) goto L37;
        r15 = "";
    L37:
        String r16 = r15;
        SelectDialogParam r17 = this.i;
        if (r17 == null) goto L40;
        r2 = r17.getPreviousPage();
    L40:
        a1.c(r16, null, null, null, null, "upload_file", null, null, "plus_panel", null, null, null, null, null, null, null, r2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049731, -1, 7);
        return;
    L34:
        r15 = null;
        goto L35
    }

    public final View onCreateView(LayoutInflater r110, ViewGroup r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        ConstraintLayout r1 = r110.inflate(2131562041, r20, false);
        int r2 = 2131365503;
        RoundFrameLayout r7 = (RoundFrameLayout) ViewBindings.findChildViewById(r1, 2131365503);
        if (r7 == null) goto L35;
        r2 = 2131365504;
        RoundFrameLayout r8 = (RoundFrameLayout) ViewBindings.findChildViewById(r1, 2131365504);
        if (r8 == null) goto L35;
        r2 = 2131365530;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r1, 2131365530);
        if (r9 == null) goto L35;
        r2 = 2131365531;
        ConstraintLayout r10 = ViewBindings.findChildViewById(r1, 2131365531);
        if (r10 == null) goto L35;
        r2 = 2131365532;
        ChatFileSelectorView r11 = (ChatFileSelectorView) ViewBindings.findChildViewById(r1, 2131365532);
        if (r11 == null) goto L35;
        r2 = 2131365533;
        AppCompatTextView r12 = ViewBindings.findChildViewById(r1, 2131365533);
        if (r12 == null) goto L35;
        r2 = 2131365575;
        View r13 = ViewBindings.findChildViewById(r1, 2131365575);
        if (r13 == null) goto L35;
        r2 = 2131365580;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131365580);
        if (r14 == null) goto L35;
        r2 = 2131365581;
        RecyclerView r15 = ViewBindings.findChildViewById(r1, 2131365581);
        if (r15 == null) goto L35;
        r2 = 2131365583;
        ProgressBar r16 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131365583);
        if (r16 == null) goto L35;
        r2 = 2131365584;
        AppCompatTextView r17 = ViewBindings.findChildViewById(r1, 2131365584);
        if (r17 == null) goto L35;
        this.d = new LarusDialogChatFileSelectBinding(r1, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        Dialog r3 = getDialog();
        if (r3 == null) goto L29;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L29;
        r4.setBackgroundDrawable(new ColorDrawable(0));
        WindowCompat.setDecorFitsSystemWindows(r4, false);
    L29:
        LarusDialogChatFileSelectBinding r5 = this.d;
        if (r5 != null) goto L36;
        return null;
    L36:
        return r5.a;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
