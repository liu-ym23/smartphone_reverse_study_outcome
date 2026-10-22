package com.larus.bmhome.music.edit;

import android.R;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.music.databinding.LarusDialogFragmentMusicEditBinding;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 @2\u00020\u0001:\u0001@By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\t\b\u0016¢\u0006\u0004\b\u0014\u0010\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J$\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010.\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020$H\u0002J\b\u00100\u001a\u00020$H\u0002J\b\u00101\u001a\u00020$H\u0002J\b\u00102\u001a\u00020$H\u0002J\b\u00103\u001a\u00020$H\u0002J\b\u0010:\u001a\u00020$H\u0002J\u0014\u0010;\u001a\u00020$2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020\u0012H\u0002J\b\u0010>\u001a\u00020$H\u0002J\b\u0010?\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0 X\u0082.¢\u0006\u0002\n\u0000R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107¨\u0006A"}, d2 = {"Lcom/larus/bmhome/music/edit/MusicEditDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "musicContent", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "lyricsSeekContent", "Lcom/larus/im/bean/message/block/LyricsSeekContent;", "messageId", "", "creationId", "message", "Lcom/larus/im/bean/message/Message;", "shareContainer", "Landroid/view/ViewGroup;", "taskScope", "Lkotlinx/coroutines/CoroutineScope;", "callback", "Lcom/larus/bmhome/music/edit/IMusicInfoEditCallback;", "isSaveCover", "", "canEditCover", "<init>", "(Lcom/larus/im/bean/message/block/MusicCreationContent;Lcom/larus/im/bean/message/block/LyricsSeekContent;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Landroid/view/ViewGroup;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/music/edit/IMusicInfoEditCallback;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()V", "Ljava/lang/Boolean;", "chatRepo", "Lcom/larus/bmhome/chat/model/repo/IChatRepoService;", "getChatRepo", "()Lcom/larus/bmhome/chat/model/repo/IChatRepoService;", "binding", "Lcom/larus/bmhome/music/databinding/LarusDialogFragmentMusicEditBinding;", "coverEditCallback", "editCoverLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "editCoverNewLauncher", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "initDialog", "initView", "initEditMusicNameItem", "initEditMusicCoverItem", "initSaveToAlbumItem", "initCancelItem", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "initResultLauncher", "uploadCoverFailed", "showLoading", "show", "onEditCoverSuccess", "buildCoverEditCallback", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicEditDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int t = 0;
    public final MusicCreationContent d;
    public final LyricsSeekContent e;
    public final String f;
    public final String g;
    public final Message h;
    public final ViewGroup i;
    public final CoroutineScope j;
    public final com.larus.bmhome.music.edit.a k;
    public final Boolean l;
    public final Boolean m;
    public final IChatRepoService n;
    public LarusDialogFragmentMusicEditBinding o;
    public final h p;
    public ActivityResultLauncher<String> q;
    public ActivityResultLauncher<Intent> r;
    public final Lazy s;

    public static final class a {
    }

    static {
    }

    public MusicEditDialogFragment() {
        this(new MusicCreationContent(), null, null, null, null, null, null, null, null, null, 1022);
        S90(this);     // Catch: IllegalStateException -> L5
        return;
    L5:
        FLogger.a.e("MusicEditDialogFragment", "fallback by dismiss failed");
    }

    public final l0 U90() {
        return (l0) this.s.getValue();
    }

    public static void S90(MusicEditDialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void T90(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void onCreate(Bundle r3) {
        setStyle(1, 2131954335);
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
    }

    public final void showLoading(boolean r3) {
        if (r3 == false) goto L10;
        l0 r4 = U90();
        if (r4 != null) goto L6;
        return;
    L6:
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L9:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        return;
    L10:
        l0 r5 = U90();
        boolean r0 = false;
        if (r5 != null) goto L13;
    L15:
        if (r0 == false) goto L26;
        l0 r6 = U90();
        if (r6 == null) goto L27;
        T90(r6);
        return;
    L27:
        return;
    L26:
        return;
    L13:
        if (r5.isShowing() != true) goto L15;
        r0 = true;
        goto L15
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        Dialog r8 = getDialog();
        if (r8 == null) goto L5;
        View r9 = r8.findViewById(2131368870);
    L6:
        if (r9 == null) goto L8;
        r9.setBackgroundResource(R.color.transparent);
    L8:
        LarusDialogFragmentMusicEditBinding r10 = this.o;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L11:
        e1.d(r10.d, new c(this));
        LarusDialogFragmentMusicEditBinding r11 = this.o;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L14:
        boolean r1 = false;
        if (r11.d.getVisibility() != 0) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == false) goto L23;
        LarusDialogFragmentMusicEditBinding r13 = this.o;
        if (r13 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L22:
        LinearLayout r14 = r13.d;
    L25:
        if (z2.a.musicCreateSupportCoverEdit() == true) goto L27;
    L35:
        if (r14 != null) goto L48;
        LarusDialogFragmentMusicEditBinding r3 = this.o;
        if (r3 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L40:
        if (r3.c.getVisibility() != 0) goto L42;
        boolean r4 = true;
    L43:
        if (r4 == false) goto L48;
        LarusDialogFragmentMusicEditBinding r15 = this.o;
        if (r15 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L47:
        r14 = r15.c;
        goto L48
    L42:
        r4 = false;
    L48:
        LarusDialogFragmentMusicEditBinding r5 = this.o;
        if (r5 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L51:
        e1.d(r5.e, new e(this));
        if (r14 != null) goto L64;
        LarusDialogFragmentMusicEditBinding r16 = this.o;
        if (r16 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L57:
        if (r16.e.getVisibility() != 0) goto L59;
        r1 = true;
    L59:
        if (r1 == false) goto L64;
        LarusDialogFragmentMusicEditBinding r17 = this.o;
        if (r17 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L63:
        r14 = r17.e;
    L64:
        LarusDialogFragmentMusicEditBinding r2 = this.o;
        if (r2 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L67:
        e1.d(r2.b, new b(this));
        if (r14 != null) goto L73;
        LarusDialogFragmentMusicEditBinding r18 = this.o;
        if (r18 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L72:
        r14 = r18.b;
    L73:
        r14.setBackground(ResourcesCompat.getDrawable(getResources(), v19.c.b(2130970558, getContext(), 2131238627), null));
        return;
    L27:
        if (Intrinsics.areEqual(this.m, Boolean.TRUE) == false) goto L35;
        LarusDialogFragmentMusicEditBinding r19 = this.o;
        if (r19 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L31:
        e1.d(r19.c, new f(this));
        LarusDialogFragmentMusicEditBinding r20 = this.o;
        if (r20 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L34:
        e1.x(r20.c);
        goto L35
    L23:
        r14 = null;
        goto L25
    L17:
        r12 = false;
        goto L18
    L5:
        r9 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562075, r10, false);
        int r13 = 2131365123;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131365123);
        if (r2 == null) goto L23;
        r13 = 2131365135;
        if (ViewBindings.findChildViewById(r12, 2131365135) == null) goto L23;
        r13 = 2131371417;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131371417);
        if (r3 == null) goto L23;
        r13 = 2131371418;
        if (ViewBindings.findChildViewById(r12, 2131371418) == null) goto L23;
        r13 = 2131371419;
        if (ViewBindings.findChildViewById(r12, 2131371419) == null) goto L23;
        r13 = 2131371420;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131371420);
        if (r4 == null) goto L23;
        r13 = 2131385115;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131385115);
        if (r5 == null) goto L23;
        r13 = 2131385116;
        if (ViewBindings.findChildViewById(r12, 2131385116) == null) goto L23;
        r13 = 2131386071;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131386071);
        if (r6 == null) goto L23;
        FrameLayout r14 = (FrameLayout) r12;
        this.o = new LarusDialogFragmentMusicEditBinding(r14, r2, r3, r4, r5, r6, r14);
        return r14;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }

    public MusicEditDialogFragment(MusicCreationContent r4, LyricsSeekContent r5, String r6, String r7, Message r8, ViewGroup r9, CoroutineScope r10, com.larus.bmhome.music.edit.a r11, Boolean r12, Boolean r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r6 = "";
    L9:
        if ((r14 & 8) == 0) goto L12;
        r7 = "";
    L12:
        if ((r14 & 16) == 0) goto L15;
        r8 = null;
    L15:
        if ((r14 & 32) == 0) goto L18;
        r9 = null;
    L18:
        if ((r14 & 64) == 0) goto L21;
        r10 = null;
    L21:
        if ((r14 & 128) == 0) goto L24;
        r11 = null;
    L24:
        if ((r14 & 256) == 0) goto L27;
        r12 = Boolean.TRUE;
    L27:
        if ((r14 & 512) == 0) goto L29;
        r13 = Boolean.TRUE;
    L29:
        Intrinsics.checkNotNullParameter(r4, "musicContent");
        Intrinsics.checkNotNullParameter(r6, "messageId");
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = zh8.a.a;
        h r15 = new h(this);
        this.p = r15;
        MusicInfoEditHelper r16 = MusicInfoEditHelper.a;
        this.q = MusicInfoEditHelper.h(this, r15);
        this.r = MusicInfoEditHelper.i(this, r15);
        this.s = LazyKt.lazy(new d(this));
    }
}
