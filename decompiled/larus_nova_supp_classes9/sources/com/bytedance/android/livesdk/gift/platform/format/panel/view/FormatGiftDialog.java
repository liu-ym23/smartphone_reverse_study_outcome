package com.bytedance.android.livesdk.gift.platform.format.panel.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftListViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftPanelDialogViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftTabViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.FormatGiftBottomWidget;
import com.bytedance.android.livesdk.gift.platform.format.panel.viewmodel.FormatGiftDialogViewModel;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.k;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/format/panel/view/FormatGiftDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatGiftDialog extends LiveDialogFragment implements com.bytedance.android.live.matchroom.b {
    public FormatGiftDialogViewModel d;
    public final LocateGiftInfo e;
    public final CompositeDisposable f;
    public View g;
    public View h;
    public final DataCenter i;
    public final Context j;
    public final GiftViewModelManager k;

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
        public final /* synthetic */ FormatGiftDialog a;

        public c(FormatGiftDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        }
    }

    static {
    }

    public final int getActualContentWidth() {
        return -1;
    }

    public final String getDegradeTag() {
        return "gift_format_panel";
    }

    public final boolean onBackPressed() {
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        return super.onBackPressed();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        com.bytedance.android.livesdk.gift.util.b.e(this);
        this.f.clear();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        k<Unit> r1 = r0.getHideDialog();
        if (r1 == null) goto L9;
        PublishSubject r2 = r1.onEvent();
        if (r2 == null) goto L9;
        Disposable r3 = r2.subscribe(new c(this));
    L10:
        if (r3 == null) goto L13;
        this.f.add(r3);
        return;
    L13:
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void onActivityCreated(Bundle r5) {
        ViewGroup.LayoutParams r0 = null;
        Dialog r1 = getDialog();     // Catch: Exception -> L9
        if (r1 == null) goto L11;
        Window r2 = r1.getWindow();     // Catch: Exception -> L9
        if (r2 == null) goto L11;
        r2.setDimAmount(0.0f);     // Catch: Exception -> L9
    L11:
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L14;
        Window r7 = r6.getWindow();
    L15:
        if (r7 == null) goto L30;
        r7.setGravity(80);
        r7.setSoftInputMode(48);
        r7.setLayout(-1, -1);
        View r8 = getView();
        if (r8 == null) goto L19;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L21:
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        View r10 = getView();
        if (r10 == null) goto L25;
        r0 = r10.getLayoutParams();
    L25:
        if (r0 == null) goto L27;
        r0.height = s1.s(getActivity());
    L27:
        View r11 = getView();
        if (r11 == null) goto L30;
        r11.setLayoutParams(r0);
        goto L30
    L19:
        r9 = null;
    L30:
        setBottomSheetSlideProcessor(b.a);
        Dialog r13 = getDialog();
        if (r13 == null) goto L43;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L44;
        r14.clearFlags(1024);
        View r15 = r14.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L39;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L39;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L39:
        r15.setSystemUiVisibility(0);
        return;
    L44:
        return;
    L43:
        return;
    L14:
        r7 = null;
    L9:
        e = move-exception;
        jy0.b.c("FormatGiftDialog", "request feature before set content, " + e.getMessage(), null, 4);
        goto L11
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setVertical(true);
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getContext(), isVertical(), false) == false) goto L5;
        int r0 = 2131954682;
    L6:
        setStyle(1, r0);
        FragmentActivity r5 = this.j;
        if ((r5 instanceof FragmentActivity) == false) goto L10;
        this.d = (FormatGiftDialogViewModel) ViewModelProviders.of(r5).get(FormatGiftDialogViewModel.class);
        return;
    L10:
        return;
    L5:
        r0 = 2131954680;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r1) {
        return super.onCreateDialog(r1);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static final void S90(FormatGiftDialog r1, GiftStateMachineConfig.g r2) {
        r1.getClass();
        if ((r2 instanceof GiftStateMachineConfig.e.c) == false) goto L6;
        return;
    L6:
        if ((r2 instanceof GiftStateMachineConfig.e.b) == false) goto L12;
        LocateGiftInfo r3 = r1.e;
        if (r3 != null) goto L10;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.i());
        return;
    L10:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.j(r3));
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        View r6 = this.g;
        GiftStateMachineConfig.g r7 = null;
        if (r6 == null) goto L5;
        View r8 = r6.findViewById(2131367009);
    L6:
        this.h = r8;
        Context r0 = this.j;
        if ((r0 instanceof FragmentActivity) == true) goto L10;
        r0 = null;
    L10:
        if (((FragmentActivity) r0) == null) goto L55;
        if (r8 == null) goto L13;
        r8.setOnClickListener(d.a);
    L13:
        s12.a r9 = new s12.a(this);
        q12.a r1 = q12.b.a;
        if (r1 == null) goto L16;
        Object r2 = m.e.d(r1, FormatGiftListViewModel.class);
    L17:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r3 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r2;
        if (r3 == null) goto L20;
        GiftStateMachineConfig.g r10 = r3.c(this, r9);
    L21:
        if (r10 == null) goto L23;
        r9.onChanged(r10);
    L23:
        s12.b r11 = new s12.b(this);
        q12.a r13 = q12.b.a;
        if (r13 == null) goto L26;
        Object r14 = m.e.d(r13, FormatGiftTabViewModel.class);
    L27:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r15 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r14;
        if (r15 == null) goto L30;
        GiftStateMachineConfig.g r16 = r15.c(this, r11);
    L31:
        if (r16 == null) goto L33;
        r11.onChanged(r16);
    L33:
        s12.c r17 = new s12.c(this);
        q12.a r18 = q12.b.a;
        if (r18 == null) goto L36;
        Object r19 = m.e.d(r18, FormatGiftPanelDialogViewModel.class);
    L37:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r20 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r19;
        if (r20 == null) goto L40;
        r7 = r20.c(this, r17);
    L40:
        if (r7 == null) goto L42;
        r17.onChanged(r7);
    L42:
        WidgetManager r21 = WidgetManager.of(this, getView());
        r21.setDataCenter(this.i);
        GiftContext r23 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r23 == null) goto L47;
        com.bytedance.live.datacontext.m<Boolean> r24 = r23.isVSPadUseVerticalStyle();
        if (r24 == null) goto L47;
        r24.setValue(Boolean.TRUE);
    L47:
        GiftViewModelManager r25 = this.k;
        r21.load(2131373668, new FormatGiftBottomWidget(r25));
        r21.load(2131373738, new FormatGiftListWidget(r25, this.d));
        return;
    L36:
        r19 = null;
        goto L37
    L30:
        r16 = null;
        goto L31
    L26:
        r14 = null;
        goto L27
    L20:
        r10 = null;
        goto L21
    L16:
        r2 = null;
        goto L17
    L55:
        dismissAllowingStateLoss();     // Catch: Exception -> L50
        return;
    L50:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r26 = DialogFragmentLancet.sLastShowStack;
        if (r26 == null) goto L58;
        com.bytedance.crash.d.d(r26, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L58:
        return;
    L5:
        r8 = null;
        goto L6
    }

    public FormatGiftDialog(DataCenter r2, Context r3, GiftViewModelManager r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "outerContext");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        setNoTitleAndCancelOutside(true);
        this.e = null;
        this.f = new CompositeDisposable();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131566018, r3, false);
        this.g = r5;
        return r5;
    }
}
