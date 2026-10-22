package com.bytedance.android.livesdk.gift.biggift.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainer;
import com.bytedance.android.livesdk.gift.biggift.viewModel.BigGiftViewModel;
import com.bytedance.android.livesdk.gift.biggift.viewModel.CurrentState;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.EXGaugeLevel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.GiftComboView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.z;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.b0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.d0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.m;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.n;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BigGiftComboDialog extends Dialog implements View.OnClickListener, WeakHandler.IHandler {
    public final boolean A;
    public final int B;
    public FrameLayout a;
    public BaseGiftComboView b;
    public View c;
    public BuffDescribeView d;
    public CustomGiftView e;
    public ConstraintLayout f;
    public View g;
    public AnimatorSet h;
    public com.bytedance.android.livesdk.revenue.service.toolbar.d i;
    public zy0.b j;
    public final WeakHandler k;
    public final int l;
    public final Boolean m;
    public final c n;
    public final d o;
    public final e p;
    public final f q;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.c r;
    public final Activity s;
    public final boolean t;
    public final boolean u;
    public final BigGiftViewModel v;
    public final DataCenter w;
    public final String x;
    public final boolean y;
    public final boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/biggift/view/BigGiftComboDialog$AnimType;", BuildConfig.FLAVOR, "ENTER", "EXIT", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnimType extends Enum<AnimType> {
        public static final AnimType ENTER = null;
        public static final AnimType EXIT = null;
        public static final /* synthetic */ AnimType[] a = null;

        static {
            AnimType r1 = new AnimType("ENTER", 0);
            ENTER = r1;
            AnimType r2 = new AnimType("EXIT", 1);
            EXIT = r2;
            a = new AnimType[]{r1, r2};
        }

        public static AnimType valueOf(String r1) {
            return (AnimType) r27.a.a(AnimType.class, r1);
        }

        public static AnimType[] values() {
            return (AnimType[]) a.clone();
        }

        public AnimType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/biggift/view/BigGiftComboDialog$DismissType;", BuildConfig.FLAVOR, "NORMAL", "USER_CANCEL", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DismissType extends Enum<DismissType> {
        public static final DismissType NORMAL = null;
        public static final DismissType USER_CANCEL = null;
        public static final /* synthetic */ DismissType[] a = null;

        static {
            DismissType r1 = new DismissType("NORMAL", 0);
            NORMAL = r1;
            DismissType r2 = new DismissType("USER_CANCEL", 1);
            USER_CANCEL = r2;
            a = new DismissType[]{r1, r2};
        }

        public static DismissType valueOf(String r1) {
            return (DismissType) r27.a.a(DismissType.class, r1);
        }

        public static DismissType[] values() {
            return (DismissType[]) a.clone();
        }

        public DismissType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public final class b implements Animator.AnimatorListener {
        public final AnimType a;
        public final /* synthetic */ BigGiftComboDialog b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            AnimType r3 = this.a;
            int r4 = com.bytedance.android.livesdk.gift.biggift.view.a.a[r3.ordinal()];
            if (r4 != 1) goto L5;
            BigGiftComboDialog.b(this.b);
            return;
        L5:
            if (r4 != 2) goto L11;
            this.b.d(DismissType.NORMAL);
            return;
        }

        public b(BigGiftComboDialog r2, AnimType r3) {
            Intrinsics.checkNotNullParameter(r3, "animType");
            this.b = r2;
            this.a = r3;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ BigGiftComboDialog a;

        public c(BigGiftComboDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            com.bytedance.android.livesdk.gift.biggift.viewModel.a r6 = (com.bytedance.android.livesdk.gift.biggift.viewModel.a) r5;
            if (r6 != null) goto L6;
            return;
        L6:
            if (r6.a != CurrentState.Combo) goto L28;
            View r0 = this.a.g;
            if (r0 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mDummy");
        L10:
            UtilityKotlinExtentionsKt.w(r0);
            UtilityKotlinExtentionsKt.w(BigGiftComboDialog.a(this.a));
            BigGiftComboDialog.a(this.a).setComboCount(r6.b);
            ViewParent r1 = BigGiftComboDialog.a(this.a);
            if ((r1 instanceof z) == true) goto L13;
            r1 = null;
        L13:
            z r2 = (z) r1;
            if (r2 == null) goto L18;
            BigGiftViewModel r3 = this.a.v;
            EXGaugeLevel r4 = r2.getCurrentEXGaugeLevel();
            r3.getClass();
            Intrinsics.checkNotNullParameter(r4, "currentEXGaugeLevel");
            t r7 = r3.a;
            if (r7 == null) goto L18;
            r7.isDisposed();
        L18:
            BigGiftComboDialog.a(this.a).c(new com.bytedance.android.livesdk.gift.biggift.view.d(this), r6.c, r6.b);
            BigGiftComboDialog r8 = this.a;
            boolean r9 = r8.z;
            BaseGiftComboView r10 = r8.b;
            if (r10 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("mComboView");
        L21:
            if (r9 == false) goto L23;
            r10.f();
        L24:
            BigGiftComboDialog.b(this.a);
            com.bytedance.android.livesdk.gift.biggift.viewModel.e r11 = r6.d;
            if (r11 == null) goto L28;
            this.a.c(r11);
            goto L28
        L23:
            r10.g();
        L28:
            if (r6.a != CurrentState.DisMiss) goto L31;
            this.a.d(DismissType.NORMAL);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ BigGiftComboDialog a;

        public d(BigGiftComboDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Long r4 = (Long) r3;
            if (r4 == null) goto L8;
            long r0 = r4.longValue();
            BigGiftComboDialog.b(this.a);
            BaseGiftComboView r5 = BigGiftComboDialog.a(this.a);
            if (r5 == null) goto L9;
            r5.b(GiftManagerKt.l(r0));
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ BigGiftComboDialog a;

        public e(BigGiftComboDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Pair r5 = (Pair) r4;
            if (r5 == null) goto L10;
            BigGiftComboDialog.b(this.a);
            if (((Boolean) r5.getSecond()).booleanValue() == false) goto L11;
            BaseGiftComboView r0 = BigGiftComboDialog.a(this.a);
            if (r0 == null) goto L12;
            r0.a(((Number) r5.getFirst()).longValue());
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ BigGiftComboDialog a;

        public f(BigGiftComboDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            Map r8 = (Map) r7;
            if ((!r8.isEmpty()) == false) goto L27;
            FrameLayout r0 = this.a.a;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mComboTrayView");
        L7:
            UtilityKotlinExtentionsKt.w(r0);
            BigGiftComboDialog r1 = this.a;
            if (r1.j != null) goto L28;
            BaseGiftComboView r2 = r1.b;
            if (r2 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mComboView");
        L13:
            if ((r2 instanceof GiftComboView) == false) goto L30;
            com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r3 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(r1.getContext(), UriProtector.parse(com.bytedance.android.livesdk.gift.platform.business.b.f().a()), null);
            r1.j = r3;
            if (r3 == null) goto L23;
            FrameLayout r4 = r1.a;
            if (r4 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("mComboTrayView");
        L20:
            r4.addView((View) ((BaseHybridComponentContainer) r3).d);
            xy0.a r5 = r3.g();
            if (r5 == null) goto L23;
            r5.load(null, r8);
        L23:
            View r9 = r1.findViewById(2131370389);
            if (r9 == null) goto L29;
            r9.setVisibility(8);
            return;
        L29:
            return;
        L30:
            return;
        L28:
            return;
        }
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        com.bytedance.android.livesdk.revenue.service.toolbar.d r0 = this.i;
        if (r0 == null) goto L5;
        r0.unlock(this);
    L5:
        zy0.b r1 = this.j;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        FrameLayout r2 = this.a;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mComboTrayView");
    L11:
        r2.removeAllViews();
        this.j = null;
        BigGiftViewModel r3 = this.v;
        d r4 = this.o;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "observer");
        r3.f.removeObserver(r4);
        BigGiftViewModel r5 = this.v;
        e r6 = this.p;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "observer");
        r5.g.removeObserver(r6);
        this.v.c();
        BigGiftViewModel r7 = this.v;
        c r8 = this.n;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "observer");
        r7.c.removeObserver(r8);
        BigGiftViewModel r9 = this.v;
        f r10 = this.q;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "observer");
        r9.e.removeObserver(r10);
        this.k.removeCallbacksAndMessages(null);
        AnimatorSet r11 = this.h;
        if (r11 == null) goto L22;
        if (r11.isStarted() != true) goto L22;
        AnimatorSet r13 = this.h;
        if (r13 == null) goto L18;
        r13.removeAllListeners();
    L18:
        AnimatorSet r14 = this.h;
        if (r14 == null) goto L22;
        r14.cancel();
    L22:
        if (((Boolean) b02.a.c.getValue(null, b02.a.a[1])).booleanValue() == false) goto L24;
    L25:
        BaseGiftComboView r15 = this.b;
        if (r15 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L28:
        r15.d();
    L30:
        if (u.p() == false) goto L35;
        if (((Number) com.bytedance.android.livesdk.gift.biggift.e.b.getValue(null, com.bytedance.android.livesdk.gift.biggift.e.a[0])).intValue() != 1) goto L35;
        this.w.put("data_vs_room_big_gift_combo_dialog_show", Boolean.FALSE);
    L35:
        if (isShowing() == true) goto L37;
        return;
    L37:
        if (this.s.isFinishing() == false) goto L39;
        return;
    L39:
        if (this.s.isDestroyed() == true) goto L62;
        Handler r16 = DialogLancet.resolveDialogHandler(this);
        if (r16 != null) goto L43;
    L45:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L48 Exception -> L50
    L54:
        DialogLancet.afterDialogDismiss(this);
        return;
    L50:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L48
        Throwable r17 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L48
        if (r17 == null) goto L54;
        com.bytedance.crash.d.d(r17, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L43:
        if (Looper.myLooper() == r16.getLooper()) goto L45;
        r16.post(DialogLancet.createDismissRunnable(this));
        return;
    L62:
        return;
    L24:
        if (this.m.booleanValue() == false) goto L30;
        goto L25
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.revenue.service.toolbar.d r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.toolbar.d.class);
        if (r0 == null) goto L10;
        r0.lock(this);
        Unit r1 = Unit.INSTANCE;
    L11:
        this.i = r0;
        BaseGiftComboView r2 = this.b;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L14:
        long r3 = 200;
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r2, "scaleX", new float[]{0.0f, 1.0f}).setDuration(r3);
        BaseGiftComboView r5 = this.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L17:
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r5, "scaleY", new float[]{0.0f, 1.0f}).setDuration(r3);
        AnimatorSet r7 = new AnimatorSet();
        this.h = r7;
        r7.playTogether(new Animator[]{r4, r6});
        AnimatorSet r8 = this.h;
        if (r8 == null) goto L20;
        r8.addListener(new b(this, AnimType.ENTER));
    L20:
        AnimatorSet r9 = this.h;
        if (r9 == null) goto L27;
        r9.start();
        return;
    L27:
        return;
    L10:
        r0 = null;
        goto L11
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final Activity getActivity() {
        return this.s;
    }

    public static final /* synthetic */ BaseGiftComboView a(BigGiftComboDialog r1) {
        BaseGiftComboView r2 = r1.b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L5:
        return r2;
    }

    public static final void b(BigGiftComboDialog r6) {
        if (r6.k.hasMessages(110) == false) goto L5;
        r6.k.removeMessages(110);
    L5:
        r6.k.sendEmptyMessageDelayed(110, ((long) r6.l) * 1000);
    }

    public final void c(com.bytedance.android.livesdk.gift.biggift.viewModel.e r6) {
        if (r6.b > 0) goto L17;
        CustomGiftView r0 = this.e;
        if (r0 == null) goto L7;
        r0.setDialogData(r6.a);
    L7:
        View r1 = this.g;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L10:
        UtilityKotlinExtentionsKt.t(r1);
        BaseGiftComboView r2 = this.b;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L13:
        UtilityKotlinExtentionsKt.t(r2);
        if (this.k.hasMessages(110) == false) goto L16;
        this.k.removeMessages(110);
    L16:
        jy0.b.d("CustomSpecialGiftEffects", "combo showConfirm dialog relate id: " + r6.a.getRelatedGiftId());
    L17:
        CustomGiftView r3 = this.e;
        if (r3 == null) goto L24;
        int r7 = r6.b;
        TextView r4 = r3.c;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftCount");
    L22:
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r4.setText(String.format(r3.getContext().getString(2131916119), Arrays.copyOf(new Object[]{Integer.valueOf(r7)}, 1)));
        return;
    }

    public final void d(DismissType r9) {
        if (r9 == DismissType.USER_CANCEL) goto L19;
        BigGiftViewModel r10 = this.v;
        n r0 = r10.m;
        if (r0 != null) goto L7;
    L13:
        d0 r11 = r10.n;
        if (r11 == null) goto L19;
        if (r11.b <= 0) goto L19;
        r11.b = 0;
        r11.d = Observable.timer(com.bytedance.android.livesdk.gift.platform.business.b.c().a().a(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b0(r11));
        goto L19
    L7:
        if (r0.b <= 0) goto L13;
        if (((System.currentTimeMillis() - r0.b) + com.bytedance.android.livesdk.gift.platform.business.b.c().b().a()) <= com.bytedance.android.livesdk.gift.platform.business.b.c().b().c()) goto L12;
        r0.a();
        goto L13
    L12:
        r0.b = 0;
        r0.a = Observable.timer(com.bytedance.android.livesdk.gift.platform.business.b.c().b().a(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r0));
    L19:
        Handler r13 = DialogLancet.resolveDialogHandler(this);
        if (r13 != null) goto L22;
    L24:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L27 Exception -> L29
    L33:
        DialogLancet.afterDialogDismiss(this);
        return;
    L27:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L27
        Throwable r14 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L27
        if (r14 == null) goto L33;
        com.bytedance.crash.d.d(r14, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
        goto L33
    L22:
        if (Looper.myLooper() == r13.getLooper()) goto L24;
        r13.post(DialogLancet.createDismissRunnable(this));
    }

    public final long e(com.bytedance.android.livesdk.gift.biggift.viewModel.a r3) {
        l1 r0 = r3.e;
        if (r0 != null) goto L5;
        com.bytedance.android.livesdk.gift.biggift.viewModel.e r4 = r3.d;
        if (r4 != null) goto L9;
        t r5 = this.v.a;
        if (r5 == null) goto L13;
        com.bytedance.android.livesdk.gift.platform.core.model.b0 r6 = r5.i();
    L14:
        if (r6 != null) goto L18;
        return 0;
    L18:
        return r6.b;
    L13:
        r6 = null;
        goto L14
    L9:
        return r4.a.getRelatedGiftId();
    L5:
        return r0.getBuffGiftId();
    }

    public final void handleMsg(Message r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.what != 110) goto L11;
        BuffDescribeView r3 = this.d;
        if (r3 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r3);
    L9:
        d(DismissType.NORMAL);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        BigGiftViewModel r0 = this.v;
        n r1 = r0.m;
        if (r1 == null) goto L7;
        r1.a();
    L7:
        d0 r2 = r0.n;
        if (r2 == null) goto L11;
        r2.c();
        r2.a();
    L11:
        if (r3.getId() != 2131387069) goto L14;
        d(DismissType.USER_CANCEL);
        return;
    L14:
        if (r3.getId() != 2131370390) goto L16;
        BigGiftViewModel.g(this.v);
        return;
    L16:
        r3.getId();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r19) {
        super.onCreate(r19);
        Window r1 = getWindow();
        if (r1 == null) goto L5;
        r1.requestFeature(1);
        r1.setLayout(-1, -1);
        r1.setGravity(80);
        r1.setDimAmount(0.0f);
    L5:
        setContentView(LayoutInflater.from(this.s).inflate(2131565403, null));
        if (r1 == null) goto L22;
        if (this.t == true) goto L10;
    L15:
        r1.addFlags(1024);
        if (this.t == false) goto L18;
    L20:
        r1.setLayout(-1, -1);
        goto L22
    L18:
        if (PadConfigUtils.c() == true) goto L20;
        t8.d(r1);
        goto L20
    L10:
        if (this.u == false) goto L12;
    L14:
        r1.clearFlags(1024);
        goto L20
    L12:
        if (DigHoleScreenUtil.isDigHole(getContext()) == true) goto L14;
    L22:
        if (u.r() == false) goto L25;
        BaseGiftComboView r2 = (BaseGiftComboView) findViewById(2131387070);
    L31:
        this.b = r2;
        this.f = findViewById(2131387069);
        this.a = (FrameLayout) findViewById(2131373675);
        this.g = findViewById(2131370390);
        BaseGiftComboView r3 = this.b;
        if (r3 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L34:
        this.c = r3.findViewById(2131367262);
        View r4 = this.g;
        if (r4 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L37:
        UtilityKotlinExtentionsKt.t(r4);
        BaseGiftComboView r5 = this.b;
        if (r5 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L40:
        UtilityKotlinExtentionsKt.t(r5);
        if (b02.a.e() == true) goto L43;
    L48:
        View r6 = this.g;
        if (r6 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L51:
        r6.setOnClickListener(this);
    L52:
        ConstraintLayout r7 = this.f;
        if (r7 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mDialogLayout");
    L55:
        r7.setOnClickListener(this);
        BaseGiftComboView r8 = this.b;
        if (r8 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L58:
        r8.setCountDownTime(((long) this.l) * 1000);
        BaseGiftComboView r9 = this.b;
        if (r9 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L61:
        r9.setGiftType(this.x);
        BigGiftViewModel r10 = this.v;
        LifecycleOwner r11 = this.s;
        if (r11 == null) goto L277;
        LifecycleOwner r13 = r11;
        f r14 = this.q;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r13, "owner");
        Intrinsics.checkNotNullParameter(r14, "observer");
        r10.e.observe(r13, r14);
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r15 = (com.bytedance.android.livesdk.gift.biggift.viewModel.a) this.v.c.getValue();
        if (r15 == null) goto L75;
        BaseGiftComboView r16 = this.b;
        if (r16 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L68:
        r16.e(GiftManagerKt.l(e(r15)), r15.e, r15.f);
        BaseGiftComboView r17 = this.b;
        if (r17 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L71:
        r17.setIsGroupSend(this.y);
        BaseGiftComboView r18 = this.b;
        if (r18 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L74:
        r18.setIsSeriesSend(this.A);
    L75:
        BigGiftViewModel r20 = this.v;
        LifecycleOwner r21 = this.s;
        if (r21 == null) goto L275;
        LifecycleOwner r23 = r21;
        c r24 = this.n;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r23, "owner");
        Intrinsics.checkNotNullParameter(r24, "observer");
        r20.c.observe(r23, r24);
        Object r25 = r20.c.getValue();
        Intrinsics.checkNotNull(r25);
        r24.onChanged(r25);
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r26 = (com.bytedance.android.livesdk.gift.biggift.viewModel.a) r20.c.getValue();
        if (r26 == null) goto L210;
        com.bytedance.android.livesdk.gift.biggift.viewModel.e r27 = r26.d;
        if (r27 != null) goto L83;
    L128:
        l1 r28 = r26.e;
        if (r28 != null) goto L132;
    L206:
        BaseGiftComboView r29 = this.b;
        if (r29 != null) goto L209;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L209:
        r29.e(GiftManagerKt.l(e(r26)), r26.e, r26.f);
        goto L210
    L132:
        if (this.d != null) goto L206;
        if (r28.getBuffLevel() < 0) goto L206;
        BuffDescribeView r30 = new BuffDescribeView(this.s);
        this.d = r30;
        if (u.p() == false) goto L161;
        if (this.t == true) goto L161;
        BaseGiftComboView r31 = this.b;
        if (r31 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L144:
        if ((r31.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L206;
        BaseGiftComboView r33 = this.b;
        if (r33 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L148:
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        if (r34 == null) goto L159;
        ViewGroup.MarginLayoutParams r35 = (ViewGroup.MarginLayoutParams) r34;
        RectF r36 = (RectF) this.w.get("data_vs_interactive_widget_region", null);
        if (r36 == null) goto L153;
        float r37 = (s1.q(getContext()).widthPixels - r36.right) + ((r36.width() - r35.width) / 2);
    L154:
        r35.rightMargin = (int) r37;
        BaseGiftComboView r38 = this.b;
        if (r38 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L157:
        r38.setLayoutParams(r35);
        goto L206
    L153:
        r37 = s1.e(144.0f);
        goto L154
    L159:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L161:
        if (r26.e.getBuffLevel() <= 0) goto L206;
        View r39 = this.c;
        if (r39 != null) goto L165;
        Intrinsics.throwUninitializedPropertyAccessException("mComboTitle");
    L165:
        a1.l(r39, UtilityKotlinExtentionsKt.i(34));
        if (this.t == false) goto L183;
        HSImageView r40 = r30.a;
        if (r40 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L171:
        if ((r40.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L199;
        HSImageView r41 = r30.a;
        if (r41 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L175:
        ViewGroup.LayoutParams r43 = r41.getLayoutParams();
        if (r43 == null) goto L182;
        ViewGroup.MarginLayoutParams r44 = (ViewGroup.MarginLayoutParams) r43;
        r44.rightMargin = (int) s1.e(9.0f);
        r44.bottomMargin = (int) s1.e(11.0f);
        HSImageView r45 = r30.a;
        if (r45 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L180:
        r45.setLayoutParams(r44);
        goto L199
    L182:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L199:
        l1 r46 = r26.e;
        Intrinsics.checkNotNullParameter(r46, "buffInfo");
        k r47 = r46.getBuffDescribeImg();
        HSImageView r48 = r30.a;
        if (r48 != null) goto L202;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L202:
        ImageLoader.bindImage(r48, r47);
        ConstraintLayout r49 = this.f;
        if (r49 != null) goto L205;
        Intrinsics.throwUninitializedPropertyAccessException("mDialogLayout");
    L205:
        r49.addView(r30);
        goto L206
    L183:
        HSImageView r50 = r30.a;
        if (r50 != null) goto L187;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L187:
        if ((r50.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L199;
        HSImageView r51 = r30.a;
        if (r51 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L191:
        ViewGroup.LayoutParams r53 = r51.getLayoutParams();
        if (r53 == null) goto L198;
        ViewGroup.MarginLayoutParams r54 = (ViewGroup.MarginLayoutParams) r53;
        r54.rightMargin = (int) s1.e(32.0f);
        r54.bottomMargin = (int) s1.e(110.0f);
        HSImageView r55 = r30.a;
        if (r55 != null) goto L196;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L196:
        r55.setLayoutParams(r54);
        goto L199
    L198:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L83:
        if (this.e != null) goto L128;
        if (r27.a.getLeftScores() < 0) goto L128;
        CustomGiftView r56 = new CustomGiftView(this.s);
        this.e = r56;
        View r57 = this.c;
        if (r57 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mComboTitle");
    L90:
        a1.l(r57, UtilityKotlinExtentionsKt.i(34));
        if (this.t == false) goto L108;
        FrameLayout r58 = r56.a;
        if (r58 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L96:
        if ((r58.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L124;
        FrameLayout r59 = r56.a;
        if (r59 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L100:
        ViewGroup.LayoutParams r60 = r59.getLayoutParams();
        if (r60 == null) goto L107;
        ViewGroup.MarginLayoutParams r61 = (ViewGroup.MarginLayoutParams) r60;
        r61.rightMargin = (int) s1.e(8.0f);
        r61.bottomMargin = (int) s1.e(10.5f);
        FrameLayout r63 = r56.a;
        if (r63 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L105:
        r63.setLayoutParams(r61);
        goto L124
    L107:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L124:
        c(r26.d);
        r56.setOnCustomGiftDialogListener(new com.bytedance.android.livesdk.gift.biggift.view.b(r56, this));
        ConstraintLayout r64 = this.f;
        if (r64 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("mDialogLayout");
    L127:
        r64.addView(r56);
        goto L128
    L108:
        FrameLayout r65 = r56.a;
        if (r65 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L112:
        if ((r65.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L124;
        FrameLayout r66 = r56.a;
        if (r66 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L116:
        ViewGroup.LayoutParams r67 = r66.getLayoutParams();
        if (r67 == null) goto L123;
        ViewGroup.MarginLayoutParams r68 = (ViewGroup.MarginLayoutParams) r67;
        r68.rightMargin = (int) s1.e(32.0f);
        r68.bottomMargin = (int) s1.e(110.0f);
        FrameLayout r69 = r56.a;
        if (r69 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L121:
        r69.setLayoutParams(r68);
        goto L124
    L123:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L210:
        BigGiftViewModel r70 = this.v;
        LifecycleOwner r71 = this.s;
        if (r71 == null) goto L273;
        LifecycleOwner r73 = r71;
        d r74 = this.o;
        r70.getClass();
        Intrinsics.checkNotNullParameter(r73, "owner");
        Intrinsics.checkNotNullParameter(r74, "observer");
        r70.f.observe(r73, r74);
        BigGiftViewModel r75 = this.v;
        LifecycleOwner r76 = this.s;
        if (r76 == null) goto L271;
        LifecycleOwner r77 = r76;
        e r78 = this.p;
        r75.getClass();
        Intrinsics.checkNotNullParameter(r77, "owner");
        Intrinsics.checkNotNullParameter(r78, "observer");
        r75.g.observe(r77, r78);
        if (u.p() == false) goto L220;
        if (((Number) com.bytedance.android.livesdk.gift.biggift.e.b.getValue(null, com.bytedance.android.livesdk.gift.biggift.e.a[0])).intValue() != 1) goto L220;
        this.w.put("data_vs_room_big_gift_combo_dialog_show", Boolean.TRUE);
    L220:
        if (u.r() == false) goto L226;
        View r79 = this.g;
        if (r79 != null) goto L224;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L224:
        a1.l(r79, UtilityKotlinExtentionsKt.i(11));
        return;
    L226:
        if (this.B != 1) goto L241;
        View r80 = this.g;
        if (r80 != null) goto L230;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L230:
        ViewGroup.LayoutParams r81 = r80.getLayoutParams();
        if ((r81 instanceof ViewGroup.MarginLayoutParams) == true) goto L233;
        ViewGroup.LayoutParams r83 = null;
    L234:
        ViewGroup.MarginLayoutParams r84 = (ViewGroup.MarginLayoutParams) r83;
        if (r84 == null) goto L279;
        r84.rightMargin = UtilityKotlinExtentionsKt.i(26);
        r84.bottomMargin = UtilityKotlinExtentionsKt.i(70);
        View r85 = this.g;
        if (r85 != null) goto L239;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L239:
        r85.setLayoutParams(r84);
        return;
    L279:
        return;
    L233:
        r83 = r81;
        goto L234
    L241:
        if (this.t == true) goto L243;
        return;
    L243:
        if (b02.a.e() == false) goto L282;
        int r86 = ((Number) b02.a.b.getValue(null, b02.a.a[0])).intValue();
        if (r86 <= 0) goto L247;
    L250:
        View r87 = this.g;
        if (r87 != null) goto L253;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L253:
        ViewGroup.LayoutParams r88 = r87.getLayoutParams();
        if ((r88 instanceof ViewGroup.MarginLayoutParams) == true) goto L256;
        ViewGroup.LayoutParams r89 = null;
    L257:
        ViewGroup.MarginLayoutParams r90 = (ViewGroup.MarginLayoutParams) r89;
        if (r90 == null) goto L263;
        r90.rightMargin = UtilityKotlinExtentionsKt.i(27);
        r90.bottomMargin = UtilityKotlinExtentionsKt.i(62);
        View r91 = this.g;
        if (r91 != null) goto L262;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L262:
        r91.setLayoutParams(r90);
    L263:
        if (r86 != 2) goto L265;
    L266:
        View r93 = findViewById(2131370389);
        if (r93 == null) goto L284;
        r93.setOnClickListener(this);
        r93.setVisibility(0);
        return;
    L284:
        return;
    L265:
        if (this.m.booleanValue() == true) goto L266;
        return;
    L256:
        r89 = r88;
        goto L257
    L247:
        if (this.m.booleanValue() == false) goto L263;
    L282:
        return;
    L271:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L273:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L275:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L277:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L43:
        if (this.z == false) goto L48;
        View r94 = this.g;
        if (r94 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L47:
        r94.setOnTouchListener(new com.bytedance.android.livesdk.gift.biggift.view.c(this));
        goto L52
    L25:
        if (this.B != 1) goto L28;
        r2 = (BaseGiftComboView) findViewById(2131383691);
        goto L31
    L28:
        if (b02.a.e() == false) goto L30;
        r2 = (BaseGiftComboView) findViewById(2131387071);
        goto L31
    L30:
        r2 = (BaseGiftComboView) findViewById(2131387070);
        goto L31
    }

    public BigGiftComboDialog(Activity r2, boolean r3, boolean r4, BigGiftViewModel r5, DataCenter r6, String r7, boolean r8, boolean r9, boolean r10, int r11) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "giftType");
        if (r3 == false) goto L8;
        if (r4 == false) goto L6;
    L7:
        int r0 = 2131954803;
    L9:
        super(r2, r0);
        this.s = r2;
        this.t = r3;
        this.u = r4;
        this.v = r5;
        this.w = r6;
        this.x = r7;
        this.y = r8;
        this.z = r9;
        this.A = r10;
        this.B = r11;
        this.k = new WeakHandler(this);
        if (nz1.a.e() != 0) goto L12;
        int r13 = 10;
    L13:
        this.l = r13;
        this.m = (Boolean) vh6.c.b(wh6.a.class).getClientABValue(q41.a.h);
        this.n = new c(this);
        this.o = new d(this);
        this.p = new e(this);
        this.q = new f(this);
        this.r = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.c(new BigGiftComboDialog$touchController$1(this), new BigGiftComboDialog$touchController$2(this), new BigGiftComboDialog$touchController$3(this), new BigGiftComboDialog$touchController$4(this));
        return;
    L12:
        r13 = nz1.a.e();
        goto L13
    L6:
        if (DigHoleScreenUtil.isDigHole(r2) == true) goto L7;
    L8:
        r0 = 2131954802;
        goto L9
    }
}
