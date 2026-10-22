package com.bytedance.android.live.profile.ui.component;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import rs0.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w<T> implements ObservableOnSubscribe {
    public final /* synthetic */ ProfileSkinCustomComponent a;
    public final /* synthetic */ com.bytedance.android.live.profile.ui.base.h b;
    public final /* synthetic */ HSImageView c;

    public static final class a extends BaseControllerListener<Object> {
        public int a;
        public final /* synthetic */ w b;
        public final /* synthetic */ ObservableEmitter c;

        /* JADX INFO: renamed from: com.bytedance.android.live.profile.ui.component.w$a$a, reason: collision with other inner class name */
        public static final class C0016a extends BaseAnimationListener {
            public final /* synthetic */ a a;
            public final /* synthetic */ int b;
            public final /* synthetic */ Animatable c;

            public final void onAnimationFrame(AnimatedDrawable2 r4, int r5) {
                Intrinsics.checkNotNullParameter(r4, "drawable2");
                ALogger.i("ProfileSkinCustomComponent", "current frame: " + r5 + ", frameCount: " + this.b);
                if (r5 >= this.a.a) goto L5;
            L6:
                this.c.jumpToFrame(this.b - 1);
                this.c.stop();
                this.c.setAnimationListener(null);
                w r6 = this.a.b;
                ProfileSkinCustomComponent r1 = r6.a;
                py.k r7 = r6.b.getDressImageModelWithFallback(DressType.BorderLoopWebp);
                int r2 = ProfileSkinCustomComponent.d;
                r1.getClass();
                AbstractDraweeController r8 = ProfileSkinCustomComponent.h(r7);
                if (r8 == null) goto L17;
                ALogger.i("ProfileSkinCustomComponent", "second webp start");
                int r0 = com.bytedance.android.live.profile.ui.util.t.a;
                if (((ss0.a) b0.a.getValue()).n() == false) goto L13;
                GenericDraweeHierarchy r3 = this.a.b.c.getHierarchy();
                if (r3 == null) goto L13;
                r3.setPlaceholderImage((Drawable) this.c, ScalingUtils.ScaleType.FIT_CENTER);
            L13:
                GenericDraweeHierarchy r9 = this.a.b.c.getHierarchy();
                if (r9 == null) goto L16;
                r9.setFadeDuration(0);
            L16:
                this.a.b.c.setController(r8);
            L17:
                this.a.a = r5;
                return;
            L5:
                if (r5 < (this.b - 1)) goto L17;
                goto L6
            }

            public C0016a(a r1, int r2, Animatable r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        public a(w r1, ObservableEmitter r2) {
            this.b = r1;
            this.c = r2;
            this.a = -1;
        }

        public final void onFailure(String r1, Throwable r2) {
            this.c.onComplete();
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            if ((r4 instanceof AnimatedDrawable2) == false) goto L8;
            int r5 = com.bytedance.android.live.profile.ui.util.t.a;
            if (((ss0.a) b0.a.getValue()).m() == false) goto L7;
            int r6 = com.bytedance.android.live.profile.ui.util.p.a;
            AnimatedDrawable2 r7 = (AnimatedDrawable2) r4;
            Intrinsics.checkNotNullParameter(r7, "animatable");
            r7.setPrivateFrameSchedulerFactory(com.bytedance.android.live.profile.ui.util.o.a);
        L7:
            AnimatedDrawable2 r8 = (AnimatedDrawable2) r4;
            r8.setAnimationListener(new C0016a(this, r8.getFrameCount(), r4));
        L8:
            if (r4 == null) goto L10;
            r4.start();
        L10:
            this.c.onComplete();
            ALogger.i("ProfileSkinCustomComponent", "first webp start");
        }
    }

    public w(ProfileSkinCustomComponent r1, com.bytedance.android.live.profile.ui.base.h r2, HSImageView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(ObservableEmitter<Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileSkinCustomComponent enterWaitForOrRunImmediately run");
        ProfileSkinCustomComponent r0 = this.a;
        py.k r1 = this.b.getDressImageModelWithFallback(DressType.BorderEnterWebp);
        r0.getClass();
        AbstractDraweeController r2 = ProfileSkinCustomComponent.h(r1);
        if (r2 == null) goto L5;
        r2.addControllerListener(new a(this, r4));
        this.c.setController(r2);
        return;
    L5:
        r4.onComplete();
    }
}
