package com.bytedance.android.livesdk.chatroom.ui.background;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.setting.x1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.e0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.HalfScreenBackgroundConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.generic.RootDrawable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public boolean a;
    public boolean b;
    public ILivePlayerClient c;
    public Disposable d;
    public final Context e;
    public final HSImageView f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.background.a$a, reason: collision with other inner class name */
    public static final class C0013a<T, R> implements Function {
        public final /* synthetic */ a a;

        public C0013a(a r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Long) r2, "it");
            return Observable.create(new BackgroundFrameBlur$triggerBackgroundUpdate$1$1(this));
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final Object apply(Object r6) {
            Bitmap r7 = (Bitmap) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            a r0 = this.a;
            if (r7 != null) goto L6;
            r0.getClass();
        L7:
            return null;
        L6:
            if (r0.d == null) goto L7;
            HalfScreenBackgroundConfig r1 = a.a();
            if (r1.mType != 0) goto L11;
            Bitmap r2 = Bitmap.createBitmap(r7, MathKt.roundToInt(r7.getWidth() * r1.mRegionX), MathKt.roundToInt(r7.getHeight() * r1.mRegionY), MathKt.roundToInt(r7.getWidth() * r1.mRegionWidth), MathKt.roundToInt(r7.getHeight() * r1.mRegionHeight));
        L13:
            if (a.a().mRadius <= 0) goto L15;
            int r3 = a.a().mRadius;
        L16:
            e0.a(r2, r2, r3);
            r7.recycle();
            return r2;
        L15:
            r3 = 2;
            goto L16
        L11:
            r2 = Bitmap.createScaledBitmap(r7, MathKt.roundToInt(r7.getWidth() * r1.scale), MathKt.roundToInt(r7.getHeight() * r1.scale), false);
            goto L13
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            Bitmap r12 = (Bitmap) r11;
            a r0 = this.a;
            if (r12 != null) goto L6;
            r0.getClass();
            return;
        L6:
            if (r0.d == null) goto L128;
            HSImageView r1 = r0.f;
            Drawable r3 = null;
            if (r1 == null) goto L11;
            View r2 = r1.findViewById(2131392252);
        L12:
            HSImageView r4 = (HSImageView) r2;
            if (r4 == null) goto L15;
            r4.setScaleType(ImageView.ScaleType.CENTER_CROP);
        L15:
            HSImageView r5 = r0.f;
            if (r5 == null) goto L18;
            View r6 = r5.findViewById(2131392252);
        L19:
            HSImageView r7 = (HSImageView) r6;
            if (r7 == null) goto L22;
            Drawable r8 = r7.getDrawable();
        L24:
            if ((r8 instanceof TransitionDrawable) == true) goto L26;
            r8 = null;
        L26:
            TransitionDrawable r9 = (TransitionDrawable) r8;
            if (r9 != null) goto L29;
        L48:
            HSImageView r10 = r0.f;
            if (r10 == null) goto L51;
            View r13 = r10.findViewById(2131392252);
        L52:
            HSImageView r14 = (HSImageView) r13;
            if (r14 == null) goto L55;
            Drawable r15 = r14.getDrawable();
        L57:
            if ((r15 instanceof RootDrawable) == true) goto L59;
            r15 = null;
        L59:
            RootDrawable r16 = (RootDrawable) r15;
            if (r16 == null) goto L62;
            Drawable r17 = r16.getDrawable();
        L64:
            if ((r17 instanceof FadeDrawable) == true) goto L66;
            r17 = null;
        L66:
            FadeDrawable r18 = (FadeDrawable) r17;
            if (r18 != null) goto L69;
            r12.recycle();
            return;
        L69:
            Drawable[] r19 = new Drawable[2];
            int r20 = r18.getNumberOfLayers() - 1;
        L70:
            if (r20 < 0) goto L84;
            if (r18.isLayerOn(r20) == false) goto L83;
            if (r18.getDrawable(r20) == null) goto L83;
            Drawable r21 = r18.getDrawable(r20);
            if ((r21 instanceof ScaleTypeDrawable) == true) goto L78;
            r21 = null;
        L78:
            ScaleTypeDrawable r22 = (ScaleTypeDrawable) r21;
            if (r22 == null) goto L84;
            Drawable r23 = r22.getDrawable();
            if (r23 == null) goto L84;
            Drawable r24 = r23.getCurrent();
        L85:
            if (r24 != null) goto L87;
            r12.recycle();
            return;
        L87:
            Context r25 = r0.e;
            if (r25 == null) goto L90;
            Resources r26 = r25.getResources();
        L91:
            r19[0] = new BitmapDrawable(r26, Bitmap.createBitmap(((BitmapDrawable) r24).getBitmap()));
            Context r27 = r0.e;
            if (r27 == null) goto L94;
            Resources r28 = r27.getResources();
        L95:
            r19[1] = new BitmapDrawable(r28, r12);
            TransitionDrawable r110 = new TransitionDrawable(r19);
            HSImageView r29 = r0.f;
            if (r29 == null) goto L98;
            View r30 = r29.findViewById(2131392252);
        L99:
            HSImageView r31 = (HSImageView) r30;
            if (r31 == null) goto L102;
            r31.setImageDrawable(r110);
        L102:
            r110.startTransition(a.a().animDuration);
        L104:
            if (Build.VERSION.SDK_INT >= 23) goto L106;
            return;
        L106:
            if (a.a().darkMask == false) goto L126;
            HSImageView r111 = r0.f;
            if (r111 == null) goto L110;
            View r112 = r111.findViewById(2131392252);
        L111:
            HSImageView r113 = (HSImageView) r112;
            if (r113 == null) goto L127;
            Context r32 = r0.e;
            if (r32 == null) goto L116;
            r3 = r32.getDrawable(2131108059);
        L116:
            r113.setForeground(r3);
            return;
        L127:
            return;
        L110:
            r112 = null;
            goto L111
        L126:
            return;
        L98:
            r30 = null;
            goto L99
        L94:
            r28 = null;
            goto L95
        L90:
            r26 = null;
        L83:
            r20 = r20 - 1;
        L84:
            r24 = null;
            goto L85
        L62:
            r17 = null;
            goto L64
        L55:
            r15 = null;
            goto L57
        L51:
            r13 = null;
            goto L52
        L29:
            if (r9.getNumberOfLayers() != 2) goto L48;
            HSImageView r33 = r0.f;
            if (r33 == null) goto L33;
            View r34 = r33.findViewById(2131392252);
        L34:
            HSImageView r35 = (HSImageView) r34;
            if (r35 == null) goto L37;
            Drawable r36 = r35.getDrawable();
        L38:
            if (r36 == null) goto L47;
            TransitionDrawable r37 = (TransitionDrawable) r36;
            if (Build.VERSION.SDK_INT < 23) goto L104;
            r37.setDrawable(0, r37.getDrawable(1));
            Context r38 = r0.e;
            if (r38 == null) goto L44;
            Resources r39 = r38.getResources();
        L45:
            r37.setDrawable(1, new BitmapDrawable(r39, r12));
            r37.startTransition(a.a().animDuration);
            goto L104
        L44:
            r39 = null;
            goto L45
        L47:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        L37:
            r36 = null;
            goto L38
        L33:
            r34 = null;
            goto L34
        L22:
            r8 = null;
            goto L24
        L18:
            r6 = null;
            goto L19
        L11:
            r2 = null;
            goto L12
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static HalfScreenBackgroundConfig a() {
        return (HalfScreenBackgroundConfig) x1.a.getValue();
    }

    public final void d() {
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
        this.a = true;
    L5:
        this.b = false;
        this.d = null;
    }

    public final void e() {
        if (this.a == true) goto L5;
        return;
    L5:
        if (this.b == false) goto L17;
        this.a = false;
        this.b = false;
        if (a().delay <= 0) goto L9;
        long r0 = a().delay;
    L11:
        if (a().mDuration <= 0) goto L13;
        long r2 = a().mDuration;
    L14:
        this.d = Observable.interval(r0, r2, TimeUnit.MILLISECONDS).flatMap(new C0013a(this)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).map(new b(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.a);
        return;
    L13:
        r2 = 30000;
        goto L14
    L9:
        r0 = 0;
        goto L11
    }

    public final void c() {
        if (a().mEnable == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        this.b = true;
        e();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        r0 = true;
        goto L8
    }

    public final Context getContext() {
        return this.e;
    }

    public final void b(LiveMode r6) {
        boolean r2 = false;
        if (a().mEnable == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        ILivePlayerClient r1 = this.c;
        if (r1 == null) goto L21;
        Pair r3 = r1.getVideoSize();
        if (r3 == null) goto L21;
        if (((Number) r3.getFirst()).intValue() <= 0) goto L21;
        if (((Number) r3.getSecond()).intValue() <= 0) goto L21;
        if (((Number) r3.getFirst()).intValue() <= ((Number) r3.getSecond()).intValue()) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == true) goto L34;
        ILivePlayerClient r5 = this.c;
        if (r5 == null) goto L28;
        IRenderView r7 = r5.getRenderView();
        if (r7 == null) goto L28;
        int r8 = r7.getHeight();
    L29:
        if (r8 <= 0) goto L34;
        if (r8 > (s1.w() * 0.7f)) goto L33;
        r4 = true;
        goto L34
    L33:
        r4 = false;
    L28:
        r8 = 0;
    L34:
        if (r4 == true) goto L36;
    L42:
        if (r2 == true) goto L44;
        return;
    L44:
        this.a = true;
        e();
        return;
    L36:
        if (r6 != LiveMode.SCREEN_RECORD) goto L38;
    L41:
        r2 = true;
        goto L42
    L38:
        if (r6 == LiveMode.THIRD_PARTY) goto L41;
        if (r6 != LiveMode.MEDIA) goto L42;
    L21:
        r4 = false;
        goto L22
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        r0 = true;
        goto L8
    }

    public a(Context r1, HSImageView r2) {
        this.e = r1;
        this.f = r2;
    }
}
