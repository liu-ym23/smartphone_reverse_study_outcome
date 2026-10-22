package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.animation.Animator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right.WelfareProjectBottomRightCardWidget;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class WelfareLandscapeCardWindow extends v61.a {
    public ScaleAnimation m;
    public boolean n;
    public final DataCenter o;

    public static final class a implements t61.a {
        public final /* synthetic */ WelfareLandscapeCardWindow a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.welfare.WelfareLandscapeCardWindow$a$a, reason: collision with other inner class name */
        public static final class RunnableC0087a implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ View b;

            public RunnableC0087a(a r1, View r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WelfareLandscapeCardWindow.S(this.a.a, this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Animation.AnimationListener {
            public final /* synthetic */ t61.c a;
            public final /* synthetic */ View b;

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation r1) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation r2) {
                this.b.setVisibility(8);
                Function0 r3 = this.a.b;
                if (r3 == null) goto L6;
                Unit r4 = (Unit) r3.invoke();
                return;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation r1) {
                Function0 r2 = this.a.a;
                if (r2 == null) goto L6;
                Unit r3 = (Unit) r2.invoke();
                return;
            }

            public b(t61.c r1, View r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public final Animator a(View r1) {
            return null;
        }

        public final Animator c(View r1) {
            return null;
        }

        public a(WelfareLandscapeCardWindow r1) {
            this.a = r1;
        }

        public final boolean b(View r11, boolean r12, t61.c r13) {
            Intrinsics.checkNotNullParameter(r11, "animView");
            Intrinsics.checkNotNullParameter(r13, "listener");
            ScaleAnimation r0 = this.a.m;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            if (r12 == true) goto L7;
            WelfareLandscapeCardWindow r14 = this.a;
            if (r14.n == false) goto L30;
            ScaleAnimation r1 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.0f, 1, 0.8f);
            r1.setDuration(360);
            Unit r2 = Unit.INSTANCE;
            r14.m = r1;
            ScaleAnimation r15 = this.a.m;
            if (r15 == null) goto L29;
            r15.setAnimationListener(new b(r13, r11));
        L29:
            r11.startAnimation(this.a.m);
            return true;
        L30:
            UtilityKotlinExtentionsKt.t(r11);
            Function0 r16 = r13.a;
            if (r16 == null) goto L33;
            Unit r17 = (Unit) r16.invoke();
        L33:
            Function0 r18 = r13.b;
            if (r18 == null) goto L43;
            Unit r19 = (Unit) r18.invoke();
            return true;
        L43:
            return true;
        L7:
            if (this.a.n == false) goto L18;
            Function0 r110 = r13.a;
            if (r110 == null) goto L11;
            Unit r111 = (Unit) r110.invoke();
        L11:
            Function0 r112 = r13.b;
            if (r112 == null) goto L14;
            Unit r113 = (Unit) r112.invoke();
        L14:
            UtilityKotlinExtentionsKt.t(r11);
            if (qy0.a.getValue().h() == true) goto L17;
            WelfareLandscapeCardWindow.S(this.a, r11);
            return true;
        L17:
            i0.c().postDelayed(new RunnableC0087a(this, r11), 500);
            return true;
        L18:
            UtilityKotlinExtentionsKt.w(r11);
            r11.setScaleX(1.0f);
            r11.setScaleY(1.0f);
            r11.setAlpha(1.0f);
            Function0 r114 = r13.a;
            if (r114 == null) goto L21;
            Unit r115 = (Unit) r114.invoke();
        L21:
            Function0 r116 = r13.b;
            if (r116 == null) goto L40;
            Unit r117 = (Unit) r116.invoke();
            return true;
        L40:
            return true;
        }
    }

    public final void I() {
        CardConstraint r0 = ((v61.a) this).b;
        r0.getClass();
        CardConstraint r1 = new CardConstraint(r0);
        r1.b(CardConstraint.Position.BottomRight);
        r1.a(new WelfareLandscapeCardWindow$bottomRightConstraint$1(this));
        P(r1);
        c(new a(this));
    }

    public final void K() {
        DataCenter r0 = this.o;
        if (r0 == null) goto L6;
        r0.put("data_live_welfare_component_show", Boolean.FALSE);
        return;
    }

    public final void L() {
        DataCenter r0 = this.o;
        if (r0 == null) goto L6;
        r0.put("data_live_welfare_component_show", Boolean.TRUE);
        return;
    }

    public final x61.h<?, ?> content() {
        x61.h.a r0 = x61.h.a;
        Function1<WelfareProjectBottomRightCardWidget, Unit> r2 = new AnonymousClass1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(WelfareProjectBottomRightCardWidget.class, "widgetClz");
        return new x61.g(r2, WelfareProjectBottomRightCardWidget.class);
    }

    public final DataCenter getDataCenter() {
        return this.o;
    }

    public WelfareLandscapeCardWindow(DataCenter r3) {
        CardTypeAndPriority r0 = CardTypeAndPriority.WelfareProject;
        super(r3, r0.getType(), r0.getPriority());
        this.o = r3;
        this.n = true;
    }

    public static final void S(WelfareLandscapeCardWindow r10, View r11) {
        r10.getClass();
        if (r11 == null) goto L7;
        ScaleAnimation r9 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 0.8f);
        r9.setDuration(440);
        Unit r0 = Unit.INSTANCE;
        r10.m = r9;
        UtilityKotlinExtentionsKt.w(r11);
        r11.startAnimation(r10.m);
        return;
    }
}
