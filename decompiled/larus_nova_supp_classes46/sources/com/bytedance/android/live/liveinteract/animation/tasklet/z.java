package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z extends com.bytedance.android.live.liveinteract.animation.tasklet.b {
    public static final /* synthetic */ int i = 0;
    public final m c;
    public HSImageView d;
    public boolean e;
    public final int f;
    public final o0 g;
    public final com.bytedance.android.live.liveinteract.animation.e h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FrameLayout a;
        public final /* synthetic */ HSImageView b;
        public final /* synthetic */ z c;

        public b(FrameLayout r1, HSImageView r2, z r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.removeView(this.b);     // Catch: Throwable -> L4
            m r0 = this.c.c;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            c0.a.remove(r0.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        StringBuilder r0 = new StringBuilder("SenderSeatTasklet.");
        o0 r1 = this.g;
        py.k r2 = null;
        if (r1 == null) goto L5;
        py.k r3 = r1.getTrayDynamicImg();
    L6:
        r0.append(r3);
        ALogger.i("InteractAnimation.SenderSeatTasklet", r0.toString());
        m r4 = this.c;
        r4.getClass();
        HashMap<String, HSImageView> r5 = c0.a;
        HSImageView r6 = r5.get(r4.a);
        if (r6 == null) goto L13;
        DraweeController r7 = r6.getController();
        if (r7 == null) goto L14;
        Animatable r8 = r7.getAnimatable();
        if (r8 == null) goto L14;
        r8.stop();
    L14:
        this.d = r6;
        FrameLayout r9 = this.h.vj();
        if (r6.getParent() != null) goto L17;
        r9.addView(r6);
    L17:
        int r10 = 0;
        boolean r11 = true;
        if (r6.getController() != null) goto L23;
        o0 r12 = this.g;
        if (r12 == null) goto L22;
        r2 = r12.getTrayDynamicImg();
    L22:
        r6.setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r2, 1)).setAutoPlayAnimations(false).setControllerListener(new b0(this, r6)).build());
    L28:
        int[] r13 = new int[2];
        this.h.vj().getLocationOnScreen(r13);
        ViewGroup.LayoutParams r14 = r6.getLayoutParams();
        r14.width = (int) s1.e(50.0f);
        r14.height = (int) s1.e(50.0f);
        r6.setLayoutParams(r14);
        PointF r15 = this.a.d.a;
        if (r15 == null) goto L74;
        r6.setX((r15.x - r13[0]) - (r6.getLayoutParams().width / 2));
        r6.setY((r15.y - r13[1]) - (r6.getLayoutParams().height / 2));
        String r16 = (String) ListProtector.get(this.a.d.b, 0);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.s r17 = this.a.b.m;
        EPointF r18 = this.h.Mj(r16);
        if (r18 != null) goto L35;
    L37:
        r11 = false;
    L38:
        float r19 = 0.0f;
        if (r11 == false) goto L56;
        r6.setScaleX(-1.0f);
        int r20 = ed0.a.a;
        if (r17 == null) goto L43;
        r10 = r17.a();
    L43:
        int r21 = -r10;
        int r22 = this.f;
        Intrinsics.checkNotNullParameter(r15, "centerPoint");
        if (r18 == null) goto L55;
        PointF r23 = new PointF();
        double r24 = Math.toRadians(r21);
        float r25 = r22 / 2.0f;
        if ((r21 % 90) != 0) goto L53;
        if (r21 >= 0) goto L50;
        r23.x = r15.x;
        r23.y = r15.y - (r22 / 2);
    L54:
        r19 = ed0.b.a(r15, r23, r18);
        goto L55
    L50:
        if (r21 != 0) goto L52;
        r23.x = r15.x - r25;
        r23.y = r15.y;
        goto L54
    L52:
        r23.x = r15.x;
        r23.y = r15.y + (r22 / 2);
        goto L54
    L53:
        r23.x = r15.x - r25;
        r23.y = (float) (((double) r15.y) + ((Math.tan(r24) * ((double) r22)) / ((double) 2.0f)));
    L55:
        r6.setRotation(r19);
        return;
    L56:
        r6.setScaleX(1.0f);
        int r26 = ed0.a.a;
        if (r17 == null) goto L59;
        r10 = r17.a();
    L59:
        int r27 = -r10;
        int r28 = this.f;
        Intrinsics.checkNotNullParameter(r15, "centerPoint");
        if (r18 == null) goto L71;
        double r29 = Math.toRadians(r27);
        float r30 = r28 / 2.0f;
        PointF r31 = new PointF();
        if ((r27 % 90) != 0) goto L69;
        if (r27 >= 0) goto L66;
        r31.x = r15.x;
        r31.y = r15.y - (r28 / 2);
    L70:
        r19 = ed0.b.a(r15, r31, r18);
        goto L71
    L66:
        if (r27 != 0) goto L68;
        r31.x = r15.x + r30;
        r31.y = r15.y;
        goto L70
    L68:
        r31.x = r15.x;
        r31.y = r15.y + (r28 / 2);
        goto L70
    L69:
        r31.x = r15.x + r30;
        r31.y = (float) (((double) r15.y) + (Math.tan(r29) * ((double) r30)));
    L71:
        r6.setRotation(r19);
        return;
    L35:
        if (r15.x <= ((PointF) r18).x) goto L37;
    L74:
        return;
    L23:
        DraweeController r32 = r6.getController();
        if (r32 == null) goto L28;
        AnimatedDrawable2 r33 = r32.getAnimatable();
        if (r33 == null) goto L28;
        AnimatedDrawable2 r34 = r33;
        r34.setAnimationListener(new a0(this, r6));
        com.bytedance.android.live.core.utils.fresco.c.b(r34);
        r33.start();
        goto L28
    L13:
        r6 = r4.b.b();
        r5.put(r4.a, r6);
        goto L14
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        HSImageView r0 = this.d;
        if (r0 == null) goto L15;
        DraweeController r1 = r0.getController();
        if (r1 == null) goto L9;
        Animatable r2 = r1.getAnimatable();
        if (r2 == null) goto L9;
        r2.stop();
    L9:
        DraweeController r3 = r0.getController();
        if (r3 == null) goto L12;
        Animatable r4 = r3.getAnimatable();
    L13:
        b(r0, r4);
        return;
    L12:
        r4 = null;
        goto L13
    }

    public final void b(HSImageView r3, Animatable r4) {
        StringBuilder r0 = new StringBuilder("onAnimationStop.Tasklet:");
        r0.append(hashCode());
        r0.append(",drawable:");
        if (r4 == null) goto L5;
        int r1 = r4.hashCode();
    L6:
        r0.append(r1);
        r0.append(",running:");
        if (r4 == null) goto L9;
        Boolean r5 = Boolean.valueOf(r4.isRunning());
    L10:
        r0.append(r5);
        ALogger.d("InteractAnimation.SenderSeatTasklet", r0.toString());
        if (this.e == false) goto L13;
        return;
    L13:
        DraweeController r6 = r3.getController();
        if (r6 == null) goto L19;
        Animatable r7 = r6.getAnimatable();
        if (r7 == null) goto L19;
        if (r7.isRunning() != true) goto L19;
    L20:
        this.e = true;
        return;
    L19:
        r3.setController(null);
        FrameLayout r8 = this.h.vj();
        r8.post(new b(r8, r3, this));
        goto L20
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public z(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r3, o0 r4, com.bytedance.android.live.liveinteract.animation.e r5, com.bytedance.android.live.liveinteract.animation.tasklet.a r6) {
        Intrinsics.checkNotNullParameter(r2, "revenueData");
        Intrinsics.checkNotNullParameter(r3, "animationData");
        Intrinsics.checkNotNullParameter(r5, "mSeatInfoProvider");
        Intrinsics.checkNotNullParameter(r6, "mAnimationViewProvider");
        super(r2, r3);
        this.g = r4;
        this.h = r5;
        String r7 = r2.b.b;
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        this.c = new m(r7, r6);
        this.f = (int) s1.e(50.0f);
    }
}
