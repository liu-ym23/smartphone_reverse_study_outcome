package com.larus.drive.sdk.impl.view.chat.fileselect;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.drive.sdk.api.file.select.BaseFileSelectFromType;
import com.larus.drive.sdk.impl.databinding.LarusDialogChatFileSelectedListBinding;
import com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatFileSelectedAdapter;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0014\u0010\u001d\u001a\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0010\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u000eJ\b\u0010!\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0002J\f\u0010#\u001a\u00020$*\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/ChatFileSelectedListDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusDialogChatFileSelectedListBinding;", "hasShownAnim", "", "selectedList", "", "Lcom/larus/platform/api/FlowSelectedFileItem;", "selectedAdapter", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatFileSelectedAdapter;", "selectedListener", "Lcom/larus/platform/api/fileselect/IChatFileSelectedListListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onDestroyView", "setSelectedList", "list", "setSelectedListener", "listener", "startEnterAnimation", "setupView", "toBaseFileSelectConfig", "Lcom/larus/drive/sdk/api/file/select/BaseFileSelectConfig;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatFileSelectedListDialog extends DialogFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDialogChatFileSelectedListBinding d;
    public boolean e;
    public List<com.larus.platform.api.u> f;
    public ChatFileSelectedAdapter g;
    public aq9.c h;

    public static final class a {
    }

    static {
    }

    public ChatFileSelectedListDialog() {
        this.f = CollectionsKt.emptyList();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
        this.g = null;
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
        LarusDialogChatFileSelectedListBinding r2 = this.d;
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
        LarusDialogChatFileSelectedListBinding r5 = this.d;
        if (r5 == null) goto L30;
        final View r6 = r5.d;
        if (r6 == null) goto L32;
        final ConstraintLayout r7 = r5.e;
        if (r7 == null) goto L33;
        r6.setAlpha(0.0f);
        r7.post(new k(r7, r6));
        return;
    L33:
        return;
    L32:
        return;
    L30:
        return;
    }

    public final x79.a S90(com.larus.platform.api.u r11) {
        Map r0 = r11.m;
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("upload_way");
    L6:
        String r2 = r11.a;
        String r3 = r11.b;
        String r4 = r11.d;
        int r5 = r11.e;
        if (r11.f != FlowDriveFileType.IMAGE) goto L9;
        boolean r6 = true;
    L10:
        if (r1 == null) goto L30;
        int r12 = r1.hashCode();
        if (r12 == (-485349153)) goto L27;
        if (r12 == (-124477692)) goto L23;
        if (r12 != 229020005) goto L30;
        if (r1.equals("browser_folder") == false) goto L30;
        BaseFileSelectFromType r13 = BaseFileSelectFromType.LOCAL;
    L32:
        return new x79.a(r2, r3, r4, r5, r6, r13, 48);
    L23:
        if (r1.equals("input_ai_space") == false) goto L30;
        r13 = BaseFileSelectFromType.DRIVE;
        goto L32
    L27:
        if (r1.equals("recent_sent_file") == false) goto L30;
        r13 = BaseFileSelectFromType.RECENT;
    L30:
        r13 = BaseFileSelectFromType.LOCAL;
        goto L32
    L9:
        r6 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 != null) goto L13;
        setStyle(2, 2131952391);
        setCancelable(true);
        return;
    L13:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L15;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        final LarusDialogChatFileSelectedListBinding r6 = this.d;
        if (r6 == null) goto L12;
        ViewCompat.setOnApplyWindowInsetsListener(r6.a, new l(r6));
        ViewCompat.requestApplyInsets(r6.a);
        e1.d(r6.d, new m(this));
        e1.d(r6.b, new n(this));
        r6.f.setText(getString(2131900749));
        ChatFileSelectedAdapter r7 = new ChatFileSelectedAdapter(new o(this));
        List<com.larus.platform.api.u> r0 = this.f;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r1.add(S90((com.larus.platform.api.u) r2.next()));
        goto L7
    L9:
        r7.submitList(r1);
        this.g = r7;
        RecyclerView r8 = r6.c;
        r8.setLayoutManager(new LinearLayoutManager(r8.getContext(), 1, false));
        r8.setAdapter(this.g);
        r8.setItemAnimator(null);
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131562042, r11, false);
        int r14 = 2131365589;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r13, 2131365589);
        if (r3 == null) goto L25;
        r14 = 2131365591;
        RecyclerView r4 = ViewBindings.findChildViewById(r13, 2131365591);
        if (r4 == null) goto L25;
        r14 = 2131365594;
        View r5 = ViewBindings.findChildViewById(r13, 2131365594);
        if (r5 == null) goto L25;
        r14 = 2131365595;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r13, 2131365595);
        if (r6 == null) goto L25;
        r14 = 2131365597;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r13, 2131365597);
        if (r7 == null) goto L25;
        r14 = 2131365598;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131365598);
        if (r8 == null) goto L25;
        this.d = new LarusDialogChatFileSelectedListBinding(r13, r3, r4, r5, r6, r7, r8);
        Dialog r15 = getDialog();
        if (r15 == null) goto L19;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L19;
        r16.setBackgroundDrawable(new ColorDrawable(0));
        WindowCompat.setDecorFitsSystemWindows(r16, false);
    L19:
        LarusDialogChatFileSelectedListBinding r17 = this.d;
        if (r17 != null) goto L26;
        return null;
    L26:
        return r17.a;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
