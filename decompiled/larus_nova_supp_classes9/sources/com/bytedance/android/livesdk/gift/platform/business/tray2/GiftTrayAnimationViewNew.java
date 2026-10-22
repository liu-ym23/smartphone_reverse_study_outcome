package com.bytedance.android.livesdk.gift.platform.business.tray2;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.y;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR*\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u001a\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u00158\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8V@VX\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R$\u0010&\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0014¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/tray2/GiftTrayAnimationViewNew;", "Lcom/bytedance/android/livesdk/gift/platform/business/tray2/BaseGiftTrayAnimationView;", "Lcom/bytedance/android/livesdk/gift/platform/core/y;", "Lh02/a;", "dialog", BuildConfig.FLAVOR, "setAboveDialog", BuildConfig.FLAVOR, "e", "Ljava/lang/String;", "getGTAG", "()Ljava/lang/String;", "GTAG", BuildConfig.FLAVOR, "value", "g", "Z", "isPortrait", "()Z", "setPortrait", "(Z)V", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "h", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setMAnchor", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "mAnchor", "Ls02/d;", "i", "Ls02/d;", "getOnGiftTrayIdleStateListener", "()Ls02/d;", "setOnGiftTrayIdleStateListener", "(Ls02/d;)V", "onGiftTrayIdleStateListener", "u", "isContainerVisible", "setContainerVisible", "isAnchor", "setAnchor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTrayAnimationViewNew extends BaseGiftTrayAnimationView implements y {
    public final String e;
    public final n12.f f;
    public boolean g;
    public IBaseUser h;
    public s02.d i;
    public h02.a j;
    public final r02.b k;
    public final r02.b l;
    public Disposable m;
    public boolean n;
    public boolean o;
    public final b p;
    public final a q;
    public s02.c r;
    public s02.c s;
    public final CompositeDisposable t;
    public boolean u;

    public static final class a implements s02.b {
        public final /* synthetic */ GiftTrayAnimationViewNew a;

        @Override // s02.b
        public final void onPlay() {
            GiftTrayAnimationViewNew.p(this.a);
            s02.d r0 = this.a.getOnGiftTrayIdleStateListener();
            if (r0 == null) goto L5;
            r0.d();
        L5:
            s02.d r1 = this.a.getOnGiftTrayIdleStateListener();
            if (r1 == null) goto L8;
            r1.e();
        L8:
            GiftTrayAnimationViewNew r2 = this.a;
            if (r2.o == true) goto L11;
            r2.o = BaseGiftTrayAnimationView.f();
        L11:
            GiftTrayAnimationViewNew r3 = this.a;
            if (r3.o == true) goto L14;
            return;
        L14:
            if (r3.c == false) goto L23;
            Disposable r4 = r3.m;
            if (r4 == null) goto L18;
            r4.dispose();
        L18:
            float r5 = s1.f(2 * this.a.q());
            com.bytedance.android.livesdk.revenue.service.interactivity.a r6 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class);
            if (r6 == null) goto L24;
            r6.oe(r5);
            return;
        L24:
            return;
        }

        public a(GiftTrayAnimationViewNew r1) {
            this.a = r1;
        }

        @Override // s02.b
        public final void a(NormalGiftMessage r4) {
            Intrinsics.checkNotNullParameter(r4, "normalGiftMessage");
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.f(Long.valueOf(r4.a), "play onFinish");
            GiftTrayAnimationViewNew.p(this.a);
            this.a.l.c();
            s02.d r0 = this.a.getOnGiftTrayIdleStateListener();
            if (r0 == null) goto L6;
            r0.b();
        L6:
            if (this.a.e() == false) goto L10;
            s02.d r1 = this.a.getOnGiftTrayIdleStateListener();
            if (r1 == null) goto L10;
            r1.onIdle();
        L10:
            GiftTrayMessageManager r2 = GiftTrayMessageManager.r;
            GiftTrayMessageManager.a.a().j(r4);
            GiftTrayMessageManager.a.a().m();
            if (this.a.e() == false) goto L31;
            h02.a r5 = this.a.j;
            if (r5 == null) goto L31;
            Handler r3 = DialogLancet.resolveDialogHandler(r5);
            if (r3 != null) goto L17;
        L19:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L22 Exception -> L24
        L28:
            DialogLancet.afterDialogDismiss(r5);
            goto L31
        L22:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L24:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L22
            Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L22
            if (r6 == null) goto L28;
            com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
            goto L28
        L17:
            if (Looper.myLooper() == r3.getLooper()) goto L19;
            r3.post(DialogLancet.createDismissRunnable(r5));
        L31:
            GiftTrayAnimationViewNew r7 = this.a;
            if (r7.o == true) goto L34;
            return;
        L34:
            if (r7.c == false) goto L41;
            r7.o = false;
            GiftTrayAnimationViewNew.o(r7);
            return;
        }
    }

    public static final class b implements s02.b {
        public final /* synthetic */ GiftTrayAnimationViewNew a;

        @Override // s02.b
        public final void onPlay() {
            GiftTrayAnimationViewNew.p(this.a);
            s02.d r0 = this.a.getOnGiftTrayIdleStateListener();
            if (r0 == null) goto L5;
            r0.c();
        L5:
            s02.d r1 = this.a.getOnGiftTrayIdleStateListener();
            if (r1 == null) goto L8;
            r1.e();
        L8:
            GiftTrayAnimationViewNew r2 = this.a;
            if (r2.n == true) goto L11;
            r2.n = BaseGiftTrayAnimationView.f();
        L11:
            GiftTrayAnimationViewNew r3 = this.a;
            if (r3.n == true) goto L14;
            return;
        L14:
            if (r3.c == true) goto L16;
            return;
        L16:
            if (r3.l.b == false) goto L26;
            Disposable r4 = r3.m;
            if (r4 == null) goto L20;
            r4.dispose();
        L20:
            float r5 = s1.f(this.a.q());
            com.bytedance.android.livesdk.revenue.service.interactivity.a r6 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class);
            if (r6 == null) goto L27;
            r6.oe(r5);
            return;
        L27:
            return;
        }

        public b(GiftTrayAnimationViewNew r1) {
            this.a = r1;
        }

        @Override // s02.b
        public final void a(NormalGiftMessage r6) {
            Intrinsics.checkNotNullParameter(r6, "normalGiftMessage");
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.f(Long.valueOf(r6.a), "play onFinish " + r6.b);
            GiftTrayAnimationViewNew.p(this.a);
            this.a.k.c();
            s02.d r0 = this.a.getOnGiftTrayIdleStateListener();
            if (r0 == null) goto L6;
            r0.a();
        L6:
            if (this.a.e() == false) goto L10;
            s02.d r1 = this.a.getOnGiftTrayIdleStateListener();
            if (r1 == null) goto L10;
            r1.onIdle();
        L10:
            GiftTrayMessageManager r2 = GiftTrayMessageManager.r;
            GiftTrayMessageManager.a.a().j(r6);
            GiftTrayMessageManager.a.a().m();
            if (this.a.e() == false) goto L31;
            h02.a r7 = this.a.j;
            if (r7 == null) goto L31;
            Handler r3 = DialogLancet.resolveDialogHandler(r7);
            if (r3 != null) goto L17;
        L19:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L22 Exception -> L24
        L28:
            DialogLancet.afterDialogDismiss(r7);
            goto L31
        L24:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L22
            Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L22
            if (r4 == null) goto L28;
            com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L17:
            if (Looper.myLooper() == r3.getLooper()) goto L19;
            r3.post(DialogLancet.createDismissRunnable(r7));
        L31:
            GiftTrayAnimationViewNew r8 = this.a;
            if (r8.n == true) goto L34;
            return;
        L34:
            if (r8.c == false) goto L41;
            r8.n = false;
            GiftTrayAnimationViewNew.o(r8);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GiftTrayAnimationViewNew a;

        public c(GiftTrayAnimationViewNew r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L6;
            this.a.k.c();
            this.a.l.c();
            com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a.getGTAG(), "hide tray due to needShowGiftEffectSwitch is off");
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ GiftTrayAnimationViewNew a;

        public d(GiftTrayAnimationViewNew r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L6;
            this.a.k.c();
            this.a.l.c();
            com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a.getGTAG(), "hide tray due to needShowGiftTraySwitch is off");
            return;
        }
    }

    public GiftTrayAnimationViewNew(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftTrayAnimationViewNew(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void c() {
        GiftTrayMessageManager r0 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().c();
        this.k.h();
        this.l.h();
        if (BaseGiftTrayAnimationView.f() == false) goto L11;
        Disposable r1 = this.m;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        com.bytedance.android.livesdk.revenue.service.interactivity.a r2 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class);
        if (r2 == null) goto L12;
        r2.oe(0.0f);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void d() {
        this.k.h();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final boolean e() {
        if (this.k.b == true) goto L5;
    L7:
        return false;
    L5:
        if (this.l.b == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void g() {
        ALogger.e("PauseAnim", "pauseAnimation mTopController=" + this.k.b + ", mBottomController=" + this.l.b);
        r02.b r0 = this.k;
        if (r0.b == true) goto L5;
        r0.e.g();
    L5:
        r02.b r1 = this.l;
        if (r1.b == true) goto L9;
        r1.e.g();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void h() {
        ALogger.i("PauseAnim", "resumeAnimation mTopController=" + this.k.b + ", mBottomController=" + this.l.b);
        r02.b r0 = this.k;
        if (r0.b == true) goto L5;
        r0.e.l();
    L6:
        r02.b r1 = this.l;
        if (r1.b == true) goto L9;
        r1.e.l();
        return;
    L9:
        GiftTrayMessageManager r2 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().m();
        return;
    L5:
        GiftTrayMessageManager r3 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().m();
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void i() {
        r02.b r0 = this.k;
        r0.j = this.p;
        r0.k = this.r;
        int r1 = g.a;
        getDataCenter();
        if (g.a() == true) goto L6;
        r02.b r2 = this.l;
        r2.j = this.q;
        r2.k = this.s;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.c();
        GiftTrayMessageManager r0 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().c();
        GiftTrayMessageManager r1 = GiftTrayMessageManager.a.a();
        r1.k = null;
        r1.c();
        r02.b r2 = this.k;
        if (r2.j == null) goto L6;
        r2.j = null;
    L6:
        if (r2.k == null) goto L8;
        r2.k = null;
    L8:
        r2.h();
        r02.b r3 = this.l;
        if (r3.j == null) goto L12;
        r3.j = null;
    L12:
        if (r3.k == null) goto L14;
        r3.k = null;
    L14:
        r3.h();
        Disposable r4 = this.m;
        if (r4 == null) goto L17;
        r4.dispose();
    L17:
        h02.a r5 = this.j;
        if (r5 == null) goto L36;
        Handler r6 = DialogLancet.resolveDialogHandler(r5);
        if (r6 != null) goto L22;
    L24:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L27 Exception -> L29
    L33:
        DialogLancet.afterDialogDismiss(r5);
        goto L36
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L27
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L27
        if (r7 == null) goto L33;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L22:
        if (Looper.myLooper() == r6.getLooper()) goto L24;
        r6.post(DialogLancet.createDismissRunnable(r5));
    L36:
        this.t.clear();
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
    }

    public final float q() {
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.a.m.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[11])).booleanValue() == false) goto L11;
        DataCenter r0 = getDataCenter();
        int r1 = 0;
        if (r0 == null) goto L9;
        Integer r2 = (Integer) r0.get("cast_game_panel_height_change", 0);
        if (r2 == null) goto L9;
        r1 = r2.intValue();
    L9:
        if (r1 <= 0) goto L11;
        return 32.0f;
    L11:
        return 55.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void b() {
        RTLUtil.isAppRTL(getContext());
        this.k.getClass();
        this.l.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L11;
        m<Boolean> r1 = r0.getNeedShowGiftEffectSwitch();
        if (r1 == null) goto L11;
        Observable r2 = r1.a();
        if (r2 == null) goto L11;
        Disposable r3 = r2.subscribe(new c(this));
        if (r3 == null) goto L11;
        RxUtilKt.c(r3, this.t);
    L11:
        GiftContext r4 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r4 == null) goto L20;
        m<Boolean> r5 = r4.getNeedShowGiftTraySwitch();
        if (r5 == null) goto L20;
        Observable r6 = r5.a();
        if (r6 == null) goto L20;
        Disposable r7 = r6.subscribe(new d(this));
        if (r7 == null) goto L20;
        RxUtilKt.c(r7, this.t);
    L20:
        GiftTrayMessageManager r8 = GiftTrayMessageManager.r;
        GiftTrayMessageManager r9 = GiftTrayMessageManager.a.a();
        r9.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r9.k = this;
    }

    public final String getGTAG() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public s02.d getOnGiftTrayIdleStateListener() {
        return this.i;
    }

    public static final void o(GiftTrayAnimationViewNew r7) {
        r7.getClass();
        Ref.FloatRef r0 = new Ref.FloatRef();
        r0.element = -1.0f;
        if (r7.e() == false) goto L6;
        r0.element = 0.0f;
    L15:
        if (r0.element != (-1.0f)) goto L22;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.a.l.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[10])).booleanValue() == false) goto L22;
        if (BaseGiftTrayAnimationView.f() == true) goto L22;
        r0.element = 0.0f;
    L22:
        if (r0.element < 0.0f) goto L28;
        Disposable r1 = r7.m;
        if (r1 == null) goto L26;
        r1.dispose();
    L26:
        r7.m = Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.tray2.b(r0), com.bytedance.android.livesdk.gift.platform.business.tray2.c.a);
        return;
    L28:
        return;
    L6:
        if (r7.k.b == true) goto L15;
        if (r7.l.b == false) goto L15;
        if (BaseGiftTrayAnimationView.f() == false) goto L12;
    L13:
        r0.element = s1.f(r7.q());
        goto L15
    L12:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.a.l.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[10])).booleanValue() == true) goto L15;
        goto L13
    }

    public static final void p(GiftTrayAnimationViewNew r2) {
        r2.getClass();
        GiftTrayMessageManager r0 = GiftTrayMessageManager.r;
        GiftTrayMessageManager r1 = GiftTrayMessageManager.a.a();
        int r3 = g.a;
        r2.getDataCenter();
        if (g.a() == false) goto L6;
        boolean r4 = r2.k.b;
    L12:
        r1.j = r4;
        return;
    L6:
        if (r2.k.b == false) goto L8;
    L11:
        r4 = true;
        goto L12
    L8:
        if (r2.l.b == true) goto L11;
        r4 = false;
        goto L12
    }

    private final void setAnchor(boolean r1) {
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L6;
        ((k) r2.getMessageDispatcher().getValue()).getClass();
        return;
    }

    private final void setMAnchor(IBaseUser r2) {
        this.h = r2;
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L6;
        ((k) r0.getMessageDispatcher().getValue()).a = r2;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayAnimationViewNew] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayAnimationViewNew] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayAnimationViewNew] */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r23v0, types: [android.widget.FrameLayout, com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView, com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayAnimationViewNew] */
    @Override // com.bytedance.android.livesdk.gift.platform.core.y
    public final boolean Lc(NormalGiftMessage r24) {
        StringBuilder r2 = new StringBuilder();
        int r3 = g.a;
        getDataCenter();
        if (g.a() == false) goto L37;
        r02.b r4 = this.k;
        r02.b r6 = this.l;
        boolean r17 = BaseGiftTrayAnimationView.f();
        Intrinsics.checkNotNullParameter(r4, "mTopController");
        Intrinsics.checkNotNullParameter(r6, "mBottomController");
        Intrinsics.checkNotNullParameter(r2, "reason");
        if (r24 == null) goto L34;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a r0 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e;
        r0.b.d(Long.valueOf(r24.a), "onConsumeMessage");
        if (r17 == false) goto L20;
        r2.append("audioGiftTray;");
        if ((r24 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L13;
        if (b02.a.b(r24) == true) goto L13;
    L17:
        if (r4.b == false) goto L19;
        r4.c();
        GiftTrayMessageManager r1 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().g = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        r4.f(r24);
    L31:
        return true;
    L19:
        r2.append("mTop idle false ");
    L33:
        r0.b.d(Long.valueOf(r24.a), r24.b + " not consume this time");
    L13:
        if (r4.i(r24) == false) goto L15;
        GiftTrayMessageManager r5 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().g = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        goto L31
    L15:
        r2.append("mTop continue false;");
        goto L17
    L20:
        r2.append("not audio tray");
        if ((r24 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L25;
        if (b02.a.b(r24) == true) goto L25;
    L29:
        if (r6.b == false) goto L32;
        r6.c();
        r0.b.d(Long.valueOf(r24.a), "bottom new play success");
        GiftTrayMessageManager r7 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().h = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        r6.f(r24);
        goto L31
    L32:
        r2.append("bottom idle false;");
        r0.b.d(Long.valueOf(r24.a), "bottom not idle not play");
    L25:
        if (r6.i(r24) == false) goto L27;
        GiftTrayMessageManager r8 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().h = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        goto L31
    L27:
        r0.b.d(Long.valueOf(r24.a), "bottom continue false");
        r2.append("bottom continue false;");
    L34:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayAnimationViewNew", "Consume failed " + r24 + ' ' + r2);
        return false;
    L37:
        if (r24 == null) goto L178;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.d(Long.valueOf(r24.a), "onConsumeMessage");
        DataCenter r9 = getDataCenter();
        if (r9 == null) goto L43;
        Boolean r10 = (Boolean) r9.get("data_is_anchor");
        if (r10 == null) goto L43;
        boolean r11 = r10.booleanValue();
    L44:
        o7 r13 = r24.r();
        if (r13 == null) goto L53;
        o0 r14 = r13.getTrayInfo();
        if (r14 == null) goto L53;
        if (r14.getUserHighLayer() != true) goto L53;
        if (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.d(r11) == false) goto L53;
    L54:
        ?? r15 = this;
        if (r15.g == true) goto L59;
        ?? r16 = r15;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.j(getDataCenter()) == true) goto L59;
    L130:
        String r20 = "bottom idle false;";
        String r19 = "bottom not idle not play";
        String r18 = " not consume this time";
        ?? r21 = r16;
    L132:
        if (BaseGiftTrayAnimationView.f() == false) goto L155;
        r2.append("audioGiftTray;");
        if ((r24 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L138;
        if (b02.a.b(r24) == true) goto L138;
    L146:
        r02.b r23 = r21.k;
        if (r23.b == false) goto L150;
        r23.c();
        GiftTrayMessageManager r25 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().g = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        r21.k.f(r24);
        return true;
    L150:
        r2.append("mTop idle false ");
        r02.b r26 = r21.l;
        if (r26.b == false) goto L154;
        r26.c();
        GiftTrayMessageManager r27 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().h = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        r21.l.f(r24);
        return true;
    L154:
        r2.append("mBottom idle false");
    L177:
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.d(Long.valueOf(r24.a), r24.b + r18);
        ?? r28 = r21;
    L179:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(r28.e, "Consume failed " + r24 + ' ' + r2);
        return false;
    L138:
        if (r21.k.i(r24) == false) goto L141;
        GiftTrayMessageManager r29 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().g = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        return true;
    L141:
        r2.append("mTop continue false;");
        if (r21.l.i(r24) == false) goto L145;
        GiftTrayMessageManager r30 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().h = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        return true;
    L145:
        r2.append("mBottom continue false;");
        goto L146
    L155:
        r2.append("not audio tray");
        if ((r24 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L160;
        if (b02.a.b(r24) == true) goto L160;
    L168:
        r02.b r31 = r21.l;
        if (r31.b == false) goto L172;
        r31.c();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.d(Long.valueOf(r24.a), "bottom new play success");
        GiftTrayMessageManager r33 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().h = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        r21.l.f(r24);
        return true;
    L172:
        r2.append(r20);
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a r34 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e;
        r34.b.d(Long.valueOf(r24.a), r19);
        r02.b r35 = r21.k;
        if (r35.b == false) goto L176;
        r35.c();
        r34.b.d(Long.valueOf(r24.a), "top new play success");
        GiftTrayMessageManager r36 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().g = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        r21.k.f(r24);
        return true;
    L176:
        r2.append("top idle false;");
        r34.b.d(Long.valueOf(r24.a), "top not idle not play");
    L160:
        if (r21.l.i(r24) == false) goto L163;
        GiftTrayMessageManager r37 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().h = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        return true;
    L163:
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a r38 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e;
        r38.b.d(Long.valueOf(r24.a), "bottom continue false");
        r2.append("bottom continue false;");
        if (r21.k.i(r24) == false) goto L167;
        GiftTrayMessageManager r39 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r24, false);
        GiftTrayMessageManager.a.a().g = r24;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r24);
        return true;
    L167:
        r2.append("top continue false;");
        r38.b.d(Long.valueOf(r24.a), "top continue false");
    L59:
        ViewGroup.LayoutParams r40 = getLayoutParams();
        if ((r40 instanceof FrameLayout.LayoutParams) == true) goto L62;
        r40 = null;
    L62:
        FrameLayout.LayoutParams r41 = (FrameLayout.LayoutParams) r40;
        r16 = r15;
        if (r41 == null) goto L130;
        h02.a r110 = r15.j;
        if (r110 == null) goto L69;
        Window r111 = r110.getWindow();
        if (r111 == null) goto L69;
        WindowManager.LayoutParams r112 = r111.getAttributes();
    L70:
        if (r112 == null) goto L72;
        r112.height = r41.height;
    L72:
        if (r112 == null) goto L74;
        r112.width = r41.width;
    L74:
        int r113 = l.a;
        h02.a r114 = r15.j;
        if (r114 == null) goto L77;
        Activity r115 = r114.getActivity();
    L78:
        if (r115 != null) goto L80;
        r20 = "bottom idle false;";
        r19 = "bottom not idle not play";
        r18 = " not consume this time";
    L102:
        boolean r43 = false;
    L103:
        if (r43 == false) goto L106;
        if (r112 == null) goto L108;
        r112.y = r41.bottomMargin + s1.o();
    L108:
        h02.a r44 = r15.j;
        if (r44 == null) goto L113;
        Window r45 = r44.getWindow();
        if (r45 == null) goto L113;
        r45.setAttributes(r112);
    L113:
        h02.a r46 = r15.j;
        if (r46 != null) goto L116;
    L120:
        r02.b r47 = r15.k;
        h02.a r48 = r15.j;
        if (r48 == null) goto L123;
        FrameLayout r49 = r48.a;
    L124:
        r47.u = r49;
        r02.b r50 = r15.l;
        if (r48 == null) goto L127;
        FrameLayout r116 = r48.a;
    L128:
        r50.u = r116;
        r21 = r15;
        goto L132
    L127:
        r116 = null;
        goto L128
    L123:
        r49 = null;
        goto L124
    L116:
        if (DialogLancet.shouldBlockDialogShow(r46) == false) goto L182;
        DialogLancet.handleBlockedDialogShow(r46);
        goto L120
    L182:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L181
    L119:
        DialogLancet.beforeDialogShow(r46);
        r46.show();
        DialogLancet.afterDialogShow(r46);
        goto L120
    L106:
        if (r112 == null) goto L108;
        r112.y = r41.bottomMargin;
        goto L108
    L80:
        Window r117 = r115.getWindow();
        r18 = " not consume this time";
        Intrinsics.checkNotNullParameter(r117, "window");
        View r51 = r117.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L85;
        r19 = "bottom not idle not play";
        r20 = "bottom idle false;";
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r53 = ThreadMethodProxy.currentThread();
        if (r53 == com.larus.home.impl.utils.c.a) goto L87;
        com.larus.home.impl.utils.c.a(r53, "getDecorView");
    L87:
        if ((r51 instanceof ViewGroup) == true) goto L89;
        r51 = null;
    L89:
        ViewGroup r54 = (ViewGroup) r51;
        if (r54 == null) goto L102;
        int r55 = r54.getChildCount();
        int r56 = 0;
    L92:
        if (r56 >= r55) goto L102;
        int r118 = r54.getChildAt(r56).getId();
        int r210 = r55;
        if (r118 == (-1)) goto L101;
        if (Intrinsics.areEqual("navigationBarBackground", s1.getResources().getResourceEntryName(r118)) == false) goto L101;
        if (r54.getChildAt(r56).getVisibility() != 0) goto L101;
        r43 = true;
    L101:
        r56 = r56 + 1;
        r55 = r210;
        goto L92
    L85:
        r20 = "bottom idle false;";
        r19 = "bottom not idle not play";
        goto L87
    L77:
        r115 = null;
    L69:
        r112 = null;
    L53:
        if (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.e(r24) == true) goto L54;
        r16 = this;
    L43:
        r11 = false;
        goto L44
    L178:
        r28 = this;
        goto L179
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void l(boolean r3) {
        if (BaseGiftTrayAnimationView.f() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L14;
        boolean r4 = this.l.b;
        if (r4 == true) goto L10;
        int r5 = s1.f(2 * q());
    L13:
        float r6 = r5;
    L15:
        com.bytedance.android.livesdk.revenue.service.interactivity.a r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class);
        if (r0 == null) goto L19;
        r0.oe(r6);
        return;
    L19:
        return;
    L10:
        if (this.k.b == true) goto L14;
        if (r4 == false) goto L14;
        r5 = s1.f(q());
    L14:
        r6 = 0.0f;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public void setAboveDialog(h02.a r1) {
        this.j = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public void setContainerVisible(boolean r4) {
        if (this.u == r4) goto L7;
        DataCenter r0 = getDataCenter();
        if (r0 == null) goto L7;
        r0.put("data_gift_tray_visiable", Boolean.valueOf(r4));
    L7:
        this.u = r4;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public void setOnGiftTrayIdleStateListener(s02.d r1) {
        this.i = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public void setPortrait(boolean r2) {
        this.g = r2;
        boolean r3 = !r2;
        this.k.s = r3;
        this.l.s = r3;
        GiftContext r4 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r4 == null) goto L6;
        ((k) r4.getMessageDispatcher().getValue()).getClass();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void k(GiftTrayWidget.c r2, GiftTrayWidget.b r3) {
        Intrinsics.checkNotNullParameter(r2, "topListener");
        Intrinsics.checkNotNullParameter(r3, "bottomListener");
        this.r = r2;
        this.k.k = r2;
        int r4 = g.a;
        getDataCenter();
        if (g.a() == true) goto L5;
        this.s = r2;
        this.l.k = r2;
    L5:
        GiftTrayMessageManager r5 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GiftTrayAnimationViewNew(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.e = "GiftTrayAnimationViewNew";
        this.f = n12.e.a();
        this.g = true;
        r02.b r7 = new r02.b(r4, this, 2);
        this.k = r7;
        r02.b r0 = new r02.b(r4, this, 1);
        this.l = r0;
        b r8 = new b(this);
        this.p = r8;
        a r1 = new a(this);
        this.q = r1;
        this.t = new CompositeDisposable();
        r7.j = r8;
        int r9 = g.a;
        getDataCenter();
        if (g.a() == true) goto L5;
        r0.j = r1;
    L5:
        this.u = true;
    }

    public /* synthetic */ GiftTrayAnimationViewNew(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void j(int r3, boolean r4, boolean r5, User r6) {
        r02.b r0 = this.k;
        r0.l = r3;
        r0.r = r4;
        r0.t = r5;
        r0.j(r0.i);
        r02.b r1 = this.l;
        r1.l = r3;
        r1.r = r4;
        r1.t = r5;
        r1.j(r1.i);
        setMAnchor(r6);
    }
}
