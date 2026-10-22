package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class WebPAnimationTasklet extends b {
    public static final /* synthetic */ int l = 0;
    public HSImageView c;
    public FrameLayout d;
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.n e;
    public py.k f;
    public boolean g;
    public ImageRequest h;
    public final com.bytedance.android.live.liveinteract.animation.e i;
    public final com.bytedance.android.live.liveinteract.animation.tasklet.a j;
    public final Function2<d, Boolean, Unit> k;

    public static final class a {
    }

    static {
    }

    public final void d() {
        HSImageView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L5:
        DraweeController r1 = r0.getController();
        if (r1 == null) goto L10;
        Animatable r2 = r1.getAnimatable();
        if (r2 == null) goto L10;
        r2.stop();
    L10:
        HSImageView r3 = this.c;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L13:
        r3.setController(null);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r1 = this.a.c;
        if (r1 == null) goto L16;
        this.e = r1;
        List<py.k> r2 = this.b.getResources();
        if (r2 == null) goto L16;
        if (r2.isEmpty() == true) goto L16;
        py.k r3 = (py.k) ListProtector.get(r2, 0);
        if (r3 == null) goto L16;
        if (r3.isValid() == false) goto L16;
        this.f = r3;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r4 = this.a.a;
        if (r4 == null) goto L20;
        FrameLayout r5 = r4.a();
    L21:
        FrameLayout r6 = this.i.vj();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r7 = this.a.c;
        if (r7 == null) goto L26;
        Integer r8 = r7.f;
        if (r8 == null) goto L26;
        int r9 = r8.intValue();
    L28:
        if (this.b.getLevel() < r9) goto L31;
        if (r5 == null) goto L31;
    L32:
        this.d = r5;
        boolean r10 = true;
    L33:
        if (r10 == true) goto L36;
        ALogger.e("InteractAnimation.WebPAnimationTasklet", "start#resource parse failed.");
        return;
    L36:
        HSImageView r11 = this.j.b();
        this.c = r11;
        if (r11 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L39:
        r11.setVisibility(8);
        int r12 = this.b.getLevel();
        FrameLayout r13 = this.d;
        if (r13 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimContainer");
    L42:
        int r14 = r13.getChildCount();
        int r15 = 0;
    L43:
        if (r15 >= r14) goto L53;
        FrameLayout r16 = this.d;
        if (r16 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimContainer");
    L47:
        Object r17 = r16.getChildAt(r15).getTag();
        if ((r17 instanceof com.bytedance.android.live.liveinteract.animation.a) == false) goto L52;
        if (((com.bytedance.android.live.liveinteract.animation.a) r17).a <= r12) goto L52;
    L54:
        HSImageView r18 = this.c;
        if (r18 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L57:
        r18.setTag(new com.bytedance.android.live.liveinteract.animation.a(r12));
        FrameLayout r19 = this.d;
        if (r19 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimContainer");
    L60:
        HSImageView r20 = this.c;
        if (r20 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L63:
        r19.addView(r20, r15);
        HSImageView r21 = this.c;
        if (r21 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L66:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r22 = this.b;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r23 = this.e;
        if (r23 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mMP4Info");
    L69:
        PointF r24 = r23.a;
        int r110 = r23.b;
        int r111 = r23.c;
        double r112 = r23.d;
        double r25 = r110;
        double r113 = (r112 * 1.0d) / r25;
        double r26 = r23.e;
        double r114 = r111;
        double r115 = (r26 * 1.0d) / r114;
        py.k r27 = this.f;
        if (r27 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPImageModel");
    L72:
        int r28 = r27.getWidth();
        py.k r116 = this.f;
        if (r116 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPImageModel");
    L75:
        double r29 = ((double) r28) * r113;
        double r117 = ((double) r116.getHeight()) * r115;
        double r118 = ((((double) r22.getX()) * 1.0d) / r25) * r112;
        double r30 = ((((double) r22.getY()) * 1.0d) / r114) * r26;
        int[] r31 = new int[2];
        FrameLayout r32 = this.d;
        if (r32 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimContainer");
    L78:
        r32.getLocationOnScreen(r31);
        float r33 = 2;
        r21.setX((((float) (r118 + ((double) r24.x))) - (((float) r29) / r33)) - r31[0]);
        r21.setY((((float) (r30 + ((double) r24.y))) - (((float) r117) / r33)) - r31[1]);
        ViewGroup.LayoutParams r34 = r21.getLayoutParams();
        if (r34 != null) goto L81;
        r34 = new FrameLayout.LayoutParams(-2, -2);
    L81:
        r34.width = (int) r29;
        r34.height = (int) r117;
        r21.setLayoutParams(r34);
        final long r35 = SystemClock.uptimeMillis();
        Function1<Boolean, Unit> r36 = new AnonymousClass1(this, r35);
        HSImageView r37 = this.c;
        if (r37 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L84:
        r37.setVisibility(0);
        py.k r38 = this.f;
        if (r38 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPImageModel");
    L87:
        ImageRequest[] r39 = a1.b(r38, 1);
        if (this.h != null) goto L93;
        if (r39 == null) goto L91;
        ImageRequest r40 = r39[0];
    L92:
        this.h = r40;
        goto L93
    L91:
        r40 = null;
    L93:
        PipelineDraweeController r41 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r39).setAutoPlayAnimations(false).setControllerListener(new f0(this, r36)).build();
        if (vm2.d.G() == true) goto L96;
    L107:
        HSImageView r42 = this.c;
        if (r42 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L110:
        r42.setController(r41);
        return;
    L96:
        if ((r41 instanceof PipelineDraweeController) == false) goto L107;
        PipelineDraweeController r43 = r41;
        HSImageView r44 = this.c;
        if (r44 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L100:
        Context r45 = r44.getContext();
        if (r39 == null) goto L105;
        ImageRequest r46 = r39[0];
        if (r46 == null) goto L105;
        Uri r47 = r46.getSourceUri();
    L106:
        com.bytedance.android.live.core.utils.fresco.c.a(r43, r45, String.valueOf(r47));
    L105:
        r47 = null;
    L52:
        r15 = r15 + 1;
        goto L43
    L53:
        r15 = -1;
    L31:
        r5 = r6;
    L26:
        r9 = 5;
        goto L28
    L20:
        r5 = null;
    L16:
        r10 = false;
        goto L33
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        d();
        HSImageView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L5:
        r0.post(new g0(this));
    }

    public static final /* synthetic */ HSImageView b(WebPAnimationTasklet r1) {
        HSImageView r2 = r1.c;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L5:
        return r2;
    }

    public static final void c(WebPAnimationTasklet r2) {
        if (r2.g == true) goto L15;
        Function2<d, Boolean, Unit> r0 = r2.k;
        if (r0 == null) goto L8;
        Unit r1 = (Unit) r0.invoke(r2, Boolean.FALSE);
    L8:
        r2.stop();
        if (vm2.d.G() == false) goto L13;
        CountingMemoryCache r3 = com.bytedance.android.live.core.utils.fresco.e.a;
        if (r3 == null) goto L13;
        r3.removeAll(new d0(r2));
    L13:
        r2.g = true;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebPAnimationTasklet(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r2, com.bytedance.android.live.liveinteract.animation.c r3, com.bytedance.android.live.liveinteract.animation.e r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r5, com.bytedance.android.live.liveinteract.animation.tasklet.a r6, Function2<? super d, ? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "revenueData");
        Intrinsics.checkNotNullParameter(r3, "mTask");
        Intrinsics.checkNotNullParameter(r4, "mSeatInfoProvider");
        Intrinsics.checkNotNullParameter(r5, "animationData");
        Intrinsics.checkNotNullParameter(r6, "mViewProvider");
        super(r2, r5);
        this.i = r4;
        this.j = r6;
        this.k = r7;
    }
}
