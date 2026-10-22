package com.bytedance.android.live.liveinteract.linkpanel.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.vm.VideoRoomAudiencePreApplyViewModel;
import com.bytedance.android.live.liveinteract.linkpanel.widget.GuestPreApplyContentWidget;
import com.bytedance.android.live.liveinteract.linkpanel.widget.GuestPreApplyTopBarWidget;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.DataContext;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/dialog/VideoRoomAudiencePreApplyDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/vm/VideoRoomAudiencePreApplyViewModel$b;", "Lxf0/a;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoRoomAudiencePreApplyDialog extends LiveDialogFragment implements VideoRoomAudiencePreApplyViewModel.b, xf0.a {
    public static final /* synthetic */ int m = 0;
    public IRoom d;
    public DataCenter e;
    public DataContext f;
    public GuestPreApplyTopBarWidget g;
    public GuestPreApplyContentWidget h;
    public final CompositeDisposable i;
    public VideoRoomAudiencePreApplyViewModel j;
    public boolean k;
    public String l;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VideoRoomAudiencePreApplyDialog a;

        public c(VideoRoomAudiencePreApplyDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((com.bytedance.android.livesdk.chatroom.viewmodel.j) r2).a != 0) goto L12;
            return;
        L12:
            this.a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L15;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {
        public final /* synthetic */ VideoRoomAudiencePreApplyDialog a;

        public d(VideoRoomAudiencePreApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            VideoRoomAudiencePreApplyDialog r4 = this.a;
            int r0 = VideoRoomAudiencePreApplyDialog.m;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L17;
            if (r2 == null) goto L21;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L18;
            View r6 = r5.getCurrentFocus();
            if (r6 == null) goto L22;
            InputMethodManager r7 = (InputMethodManager) r2.getSystemService("input_method");
            if (r7 != null) goto L14;
            return;
        L14:
            if (r7.isActive() == false) goto L20;
            r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L18:
            return;
        L21:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.vm.VideoRoomAudiencePreApplyViewModel.b
    public final void GB() {
        f2.b(2131918112, 0);
        DataCenter r0 = this.e;
        if (r0 == null) goto L12;
        r0.put("data_audience_pre_linkmic_waiting", Boolean.FALSE);
    L12:
        dismiss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L14;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.vm.VideoRoomAudiencePreApplyViewModel.b
    public final void e30() {
        VideoRoomAudiencePreApplyViewModel r0 = this.j;
        if (r0 == null) goto L5;
        r0.fetchList(this.d, true);
    L5:
        DataCenter r1 = this.e;
        if (r1 == null) goto L9;
        r1.put("data_audience_pre_linkmic_waiting", Boolean.TRUE);
        return;
    }

    public VideoRoomAudiencePreApplyDialog() {
        this.i = new CompositeDisposable();
        this.l = "";
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.i.dispose();
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L12;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L12;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L11:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setGravity(80);
        r7.setSoftInputMode(48);
        c1.b(r7, 0, 14);
    L12:
        setBottomSheetSlideProcessor(b.a);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
        Pair r3 = com.bytedance.live.datacontext.d.a(new AnonymousClass1(this));
        VideoRoomAudiencePreApplyViewModel r0 = (VideoRoomAudiencePreApplyViewModel) r3.component1();
        Disposable r4 = (Disposable) r3.component2();
        this.j = r0;
        this.i.add(r4);
        com.bytedance.live.datacontext.j r5 = m.g(this.f).getVideoTalkRoomSubScene();
        if (r5 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getValue();
        if (r6 == null) goto L13;
        BehaviorSubject r7 = r6.a();
        if (r7 == null) goto L14;
        Disposable r8 = r7.subscribe(new c(this));
        if (r8 == null) goto L15;
        this.i.add(r8);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new d(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        this.k = false;     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        VideoRoomAudiencePreApplyViewModel r3 = this.j;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.release();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        this.g = new GuestPreApplyTopBarWidget(this.j, this.d, this.l, this);
        WidgetManager.of(this, r4).load(2131389241, this.g);
        this.h = new GuestPreApplyContentWidget(this.j, this.d);
        WidgetManager.of(this, r4).load(2131374053, this.h);
        int r6 = c1.a;
        if (e5.n() == false) goto L11;
        FrameLayout r7 = (FrameLayout) r4.findViewById(2131374053);
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof ConstraintLayout.LayoutParams) == true) goto L7;
        r8 = null;
    L7:
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) r8;
        if (r9 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r9).height = s1.w() - s1.f(56.0f);
        r7.setLayoutParams(r9);
        return;
    L12:
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131565792, r2);
    }
}
