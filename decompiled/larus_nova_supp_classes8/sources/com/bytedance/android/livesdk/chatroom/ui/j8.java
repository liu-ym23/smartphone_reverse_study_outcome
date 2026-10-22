package com.bytedance.android.livesdk.chatroom.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j8 extends PopupWindow implements View.OnTouchListener {
    public final HSImageView a;
    public final View b;
    public boolean c;
    public float d;
    public float e;
    public final FrameLayout f;
    public final Activity g;
    public final int h;
    public final int i;
    public final long j;
    public final float k;
    public final VideoViewParams l;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ j8 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public b(j8 r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Intrinsics.checkNotNullParameter(r5, "it");
            View r0 = this.a.getContentView();
            if (r0 == null) goto L6;
            int r1 = this.b;
            r0.setX(r1 + ((this.c - r1) * r5.getAnimatedFraction()));
        L6:
            if (r5.getAnimatedFraction() != 1.0f) goto L9;
            j8.a(this.a);
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ j8 a;

        public static final class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ c a;
            public final /* synthetic */ Ref.FloatRef b;
            public final /* synthetic */ Ref.FloatRef c;
            public final /* synthetic */ float d;
            public final /* synthetic */ Ref.IntRef e;
            public final /* synthetic */ Ref.IntRef f;
            public final /* synthetic */ Ref.IntRef g;
            public final /* synthetic */ Ref.IntRef h;
            public final /* synthetic */ Ref.IntRef i;
            public final /* synthetic */ Ref.IntRef j;
            public final /* synthetic */ Ref.IntRef k;
            public final /* synthetic */ Ref.IntRef l;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.j8$c$a$a, reason: collision with other inner class name */
            public static final class C0021a<T> implements Consumer {
                public final /* synthetic */ a a;

                public C0021a(a r1) {
                    this.a = r1;
                }

                public final void accept(Object r1) {
                    Long r2 = (Long) r1;
                    j8 r3 = this.a.a.a;
                    PopupWindowLancet.handleDismissBeforeOrigin(r3);
                    r3.dismiss();
                }
            }

            public static final class b<T> implements Consumer {
                public static final b a = null;

                static {
                    a = new b();
                }

                public b() {
                }

                public final void accept(Object r3) {
                    Throwable r4 = (Throwable) r3;
                    x8.a.b("QuickShotPopupWindow", "autodismiss Fail", false);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r9) {
                Intrinsics.checkNotNullParameter(r9, "animation");
                this.b.element = r9.getAnimatedFraction();
                Ref.FloatRef r10 = this.c;
                float r1 = 1;
                float r2 = r1 - this.d;
                Ref.FloatRef r3 = this.b;
                float r4 = r1 - (r2 * r3.element);
                r10.element = r4;
                this.e.element = (int) (this.f.element * r4);
                Ref.IntRef r11 = this.g;
                r11.element = (int) (this.h.element * r4);
                Ref.IntRef r5 = this.i;
                int r6 = this.j.element;
                float r7 = r6;
                j8 r8 = this.a.a;
                float r12 = r8.h - r6;
                float r13 = r3.element;
                r5.element = (int) (r7 + (r12 * r13));
                Ref.IntRef r14 = this.k;
                int r15 = this.l.element;
                r14.element = (int) ((r15 + ((r8.i - r15) * r13)) - r11.element);
                View r16 = r8.b;
                if (r16 == null) goto L9;
                r16.setAlpha(r1 - r13);
                ViewGroup.LayoutParams r17 = r16.getLayoutParams();
                if (r17 == null) goto L8;
                r17.width = this.e.element;
                r17.height = this.g.element;
                r16.setLayoutParams(r17);
                r16.setX(this.i.element);
                r16.setY(this.k.element);
                goto L9
            L8:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            L9:
                HSImageView r18 = this.a.a.a;
                if (r18 == null) goto L17;
                ViewGroup.LayoutParams r19 = r18.getLayoutParams();
                if (r19 == null) goto L15;
                r19.width = this.e.element;
                r19.height = this.g.element;
                r18.setLayoutParams(r19);
                r18.setX(this.i.element);
                r18.setY(this.k.element);
                goto L17
            L15:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            L17:
                if (this.b.element != 1.0f) goto L20;
                long r20 = this.a.a.j;
                int r21 = r9.a;
                Intrinsics.checkNotNullParameter("", "errorCode");
                Intrinsics.checkNotNullParameter("", "errorMsg");
                vr1.o r22 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
                Map<String, String> r23 = MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "1"), TuplesKt.to("sessionId", String.valueOf(r20))});
                am2.x r24 = new am2.x();
                r24.a = "live";
                r24.e = "show";
                r24.b = "live_detail";
                r22.sendLog("livesdk_quick_shot_anim", r23, new Object[]{r24, IRoom.class});
                Observable.timer(2000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0021a(this), b.a);
                return;
            }

            public a(c r1, Ref.FloatRef r2, Ref.FloatRef r3, float r4, Ref.IntRef r5, Ref.IntRef r6, Ref.IntRef r7, Ref.IntRef r8, Ref.IntRef r9, Ref.IntRef r10, Ref.IntRef r11, Ref.IntRef r12) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
                this.g = r7;
                this.h = r8;
                this.i = r9;
                this.j = r10;
                this.k = r11;
                this.l = r12;
            }
        }

        public c(j8 r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.l == null) goto L32;
            Ref.IntRef r6 = new Ref.IntRef();
            r6.element = this.a.l.a;
            Ref.IntRef r8 = new Ref.IntRef();
            r8.element = this.a.l.b;
            Ref.IntRef r10 = new Ref.IntRef();
            vr1.u r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, null, 3);
            if (r0 == null) goto L11;
            com.bytedance.live.datacontext.n<Rect> r1 = r0.d();
            if (r1 == null) goto L11;
            Rect r2 = (Rect) r1.getValue();
            if (r2 == null) goto L11;
            int r3 = r2.left;
        L12:
            r10.element = r3;
            Ref.IntRef r12 = new Ref.IntRef();
            VideoViewParams r4 = this.a.l;
            r12.element = r4.c + r4.b;
            if (r6.element > 0) goto L15;
        L16:
            r6.element = com.bytedance.android.live.core.utils.s1.t();
            r8.element = com.bytedance.android.live.core.utils.s1.r();
            r10.element = 0;
            r12.element = com.bytedance.android.live.core.utils.s1.r();
        L17:
            int r5 = r6.element;
            int r7 = r8.element;
            if (r5 >= r7) goto L21;
            r5 = r7;
        L21:
            ValueAnimator r14 = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(600);
            float r9 = this.a.k / r5;
            Ref.IntRef r11 = new Ref.IntRef();
            r11.element = 0;
            Ref.IntRef r13 = new Ref.IntRef();
            r13.element = 0;
            Ref.FloatRef r15 = new Ref.FloatRef();
            r15.element = 0.0f;
            Ref.IntRef r16 = new Ref.IntRef();
            r16.element = 0;
            Ref.IntRef r17 = new Ref.IntRef();
            r17.element = 0;
            Ref.FloatRef r18 = new Ref.FloatRef();
            r18.element = 0.0f;
            j8 r19 = this.a;
            if ((r19 instanceof PopupWindow) == false) goto L27;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r19) == false) goto L27;
            r19.update(0, 0, -1, -1);
        L30:
            r14.addUpdateListener(new a(this, r18, r15, r9, r16, r6, r17, r8, r11, r10, r13, r12));
            r14.setInterpolator(new AccelerateDecelerateInterpolator());
            r14.start();
            return;
        L27:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r19, 0, 0, -1, -1) == true) goto L30;
            r19.update(0, 0, -1, -1);
            goto L30
        L15:
            if (r8.element > 0) goto L17;
        L11:
            r3 = 0;
            goto L12
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
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

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = true;
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(150);
        int[] r0 = new int[2];
        View r2 = getContentView();
        if (r2 == null) goto L8;
        r2.getLocationOnScreen(r0);
    L8:
        int r3 = 0;
        int r4 = r0[0];
        View r5 = getContentView();
        if (r5 == null) goto L11;
        r3 = r5.getWidth();
    L11:
        r1.addUpdateListener(new b(this, r4, -r3));
        r1.start();
    }

    public final Activity getContext() {
        return this.g;
    }

    public static final void a(j8 r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        super.dismiss();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        if (r6 == null) goto L4;
        Integer r7 = Integer.valueOf(r6.getAction());
    L6:
        if (r7 == null) goto L12;
        if (r7.intValue() != 0) goto L12;
        this.d = r6.getX();
    L53:
        return true;
    L12:
        if (r7 != null) goto L15;
    L30:
        if (r7 != null) goto L33;
    L35:
        if (r7 == null) goto L53;
        if (r7.intValue() != 3) goto L53;
    L39:
        View r8 = getContentView();
        if (r8 == null) goto L42;
        int r9 = r8.getScrollX();
    L44:
        if (r9 <= com.bytedance.android.live.core.utils.s1.f(10.0f)) goto L46;
        boolean r10 = true;
    L47:
        if (r10 != true) goto L49;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        dismiss();
        goto L53
    L49:
        View r11 = getContentView();
        if (r11 == null) goto L52;
        r11.scrollTo(0, 0);
    L52:
        this.d = 0.0f;
        goto L53
    L46:
        r10 = false;
        goto L47
    L42:
        r9 = 0;
        goto L44
    L33:
        if (r7.intValue() != 1) goto L35;
    L15:
        if (r7.intValue() != 2) goto L30;
        this.e = r6.getX() - this.d;
        View r12 = getContentView();
        if (r12 == null) goto L19;
        r12.scrollBy(-((int) this.e), 0);
    L19:
        this.d = r6.getX();
        View r13 = getContentView();
        if (r13 == null) goto L22;
        int r14 = r13.getScrollX();
    L23:
        if (r14 <= 0) goto L25;
        boolean r15 = true;
    L26:
        if (r15 == true) goto L53;
        View r16 = getContentView();
        if (r16 == null) goto L53;
        r16.scrollTo(0, 0);
        goto L53
    L25:
        r15 = false;
        goto L26
    L22:
        r14 = 0;
        goto L23
    L4:
        r7 = null;
        goto L6
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r8, int r9, int r10, int r11) {
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L6;
    L12:
        if (r8 == null) goto L15;
        r8.post(new c(this));
        return;
    L15:
        return;
    L6:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L8;
        super.showAtLocation(r8, r9, r10, r11);
        goto L12
    L8:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r8, r0, r9, r10, r11) == true) goto L12;
        super.showAtLocation(r8, r9, r10, r11);
        PopupWindowLancet.trackAfterShow(this, r0, r8);
        goto L12
    }

    public j8(Activity r6, Bitmap r7, int r8, int r9, long r10, float r12, VideoViewParams r13) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "quickScreenShot");
        this.g = r6;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r12;
        this.l = r13;
        setContentView(LayoutInflater.from(r6).inflate(2131567959, null));
        FrameLayout r11 = (FrameLayout) getContentView().findViewById(2131389906);
        this.f = r11;
        HSImageView r14 = getContentView().findViewById(2131389922);
        this.a = r14;
        this.b = getContentView().findViewById(2131389923);
        r11.setOnClickListener(new k8(this));
        int r15 = ColorProtector.parseColor("#66FFFFFF");
        int r16 = (int) UtilityKotlinExtentionsKt.h(2.0f);
        Bitmap r17 = Bitmap.createBitmap(r7.getWidth(), r7.getHeight(), Bitmap.Config.ARGB_4444);
        Rect r18 = new Rect(0, 0, r7.getWidth(), r7.getHeight());
        RectF r19 = new RectF(r18);
        int r2 = r16 * 2;
        RectF r20 = new RectF(new Rect(r16, r16, r7.getWidth() - r2, r7.getHeight() - r2));
        Canvas r110 = new Canvas(r17);
        r110.drawARGB(0, 0, 0, 0);
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        float r3 = 20;
        r110.drawRoundRect(r19, UtilityKotlinExtentionsKt.h(r3), UtilityKotlinExtentionsKt.h(r3), r0);
        r0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r110.drawBitmap(r7, r18, r18, r0);
        Paint r21 = new Paint();
        r21.setAntiAlias(true);
        r21.setStyle(Paint.Style.STROKE);
        r21.setColor(r15);
        r21.setStrokeWidth(UtilityKotlinExtentionsKt.h(5));
        r110.drawRoundRect(r20, UtilityKotlinExtentionsKt.h(r3), UtilityKotlinExtentionsKt.h(r3), r21);
        if (r14 == null) goto L5;
        r14.setImageBitmap(r17);
    L5:
        if (r14 == null) goto L7;
        r14.setScaleType(ImageView.ScaleType.FIT_XY);
    L7:
        if (r14 == null) goto L9;
        r14.setOnTouchListener(this);
    L9:
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setOutsideTouchable(true);
    }
}
