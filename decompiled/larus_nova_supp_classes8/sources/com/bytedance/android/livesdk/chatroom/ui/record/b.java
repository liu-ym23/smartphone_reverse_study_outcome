package com.bytedance.android.livesdk.chatroom.ui.record;

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
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordBasePresenter$showRecordShareDialog$1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends PopupWindow {
    public final View a;
    public final View b;
    public final View c;
    public final View d;
    public boolean e;
    public final FrameLayout f;
    public final Activity g;
    public final int h;
    public final int i;
    public final float j;
    public final float k;
    public final VideoViewParams l;
    public final View.OnClickListener m;
    public final boolean n;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.b$b, reason: collision with other inner class name */
    public static final class C0022b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ b a;

        public C0022b(b r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            View r0 = this.a.getContentView();
            if (r0 == null) goto L6;
            r0.setAlpha(1 - r4.getAnimatedFraction());
        L6:
            if (r4.getAnimatedFraction() != 1.0f) goto L9;
            b.a(this.a);
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b a;

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
            public final /* synthetic */ float j;
            public final /* synthetic */ Ref.IntRef k;
            public final /* synthetic */ Ref.IntRef l;
            public final /* synthetic */ Ref.IntRef m;
            public final /* synthetic */ Ref.IntRef n;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.b$c$a$a, reason: collision with other inner class name */
            public static final class C0023a<T> implements Consumer {
                public final /* synthetic */ a a;

                public C0023a(a r1) {
                    this.a = r1;
                }

                public final void accept(Object r1) {
                    Long r2 = (Long) r1;
                    b r3 = this.a.a.a;
                    PopupWindowLancet.handleDismissBeforeOrigin(r3);
                    r3.dismiss();
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.b$c$a$b, reason: collision with other inner class name */
            public static final class C0024b<T> implements Consumer {
                public static final C0024b a = null;

                static {
                    a = new C0024b();
                }

                public C0024b() {
                }

                public final void accept(Object r3) {
                    Throwable r4 = (Throwable) r3;
                    x8.a.b("LandscapeQuickShotWindow", "autodismiss Fail", false);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r7) {
                Intrinsics.checkNotNullParameter(r7, "animation");
                this.b.element = r7.getAnimatedFraction();
                Ref.FloatRef r8 = this.c;
                float r0 = 1;
                float r1 = r0 - this.d;
                Ref.FloatRef r2 = this.b;
                float r3 = r0 - (r1 * r2.element);
                r8.element = r3;
                this.e.element = (int) (this.f.element * r3);
                Ref.IntRef r9 = this.g;
                r9.element = (int) (this.h.element * r3);
                this.i.element = (int) (this.j * r3);
                Ref.IntRef r4 = this.k;
                int r5 = this.l.element;
                float r6 = r5;
                b r10 = this.a.a;
                float r11 = r10.h - r5;
                float r12 = r2.element;
                r4.element = (int) (r6 + (r11 * r12));
                Ref.IntRef r13 = this.m;
                int r14 = this.n.element;
                r13.element = (int) ((r14 + ((r10.i - r14) * r12)) - r9.element);
                View r15 = r10.d;
                if (r15 == null) goto L9;
                ViewGroup.LayoutParams r16 = r15.getLayoutParams();
                if (r16 == null) goto L8;
                r16.width = this.e.element;
                r16.height = this.g.element;
                r15.setLayoutParams(r16);
                goto L9
            L8:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            L9:
                b r17 = this.a.a;
                if (r17.n == false) goto L18;
                View r18 = r17.a;
                if (r18 == null) goto L18;
                UtilityKotlinExtentionsKt.w(r18);
                ViewGroup.LayoutParams r19 = r18.getLayoutParams();
                if (r19 == null) goto L17;
                r19.height = this.i.element;
                r18.setLayoutParams(r19);
                goto L18
            L17:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            L18:
                FrameLayout r20 = this.a.a.f;
                ViewGroup.LayoutParams r21 = r20.getLayoutParams();
                if (r21 == null) goto L25;
                r21.width = -2;
                r21.height = -2;
                r20.setLayoutParams(r21);
                r20.setX(this.k.element);
                r20.setY(this.m.element);
                if (this.b.element != 1.0f) goto L26;
                Observable.timer(3000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0023a(this), C0024b.a);
                return;
            L26:
                return;
            L25:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }

            public a(c r1, Ref.FloatRef r2, Ref.FloatRef r3, float r4, Ref.IntRef r5, Ref.IntRef r6, Ref.IntRef r7, Ref.IntRef r8, Ref.IntRef r9, float r10, Ref.IntRef r11, Ref.IntRef r12, Ref.IntRef r13, Ref.IntRef r14) {
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
                this.m = r13;
                this.n = r14;
            }
        }

        public c(b r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.l == null) goto L32;
            Ref.IntRef r6 = new Ref.IntRef();
            r6.element = this.a.l.a;
            Ref.IntRef r8 = new Ref.IntRef();
            r8.element = this.a.l.b;
            Ref.IntRef r12 = new Ref.IntRef();
            u r0 = r.u(null, null, 3);
            if (r0 == null) goto L11;
            n<Rect> r1 = r0.d();
            if (r1 == null) goto L11;
            Rect r2 = (Rect) r1.getValue();
            if (r2 == null) goto L11;
            int r3 = r2.left;
        L12:
            r12.element = r3;
            Ref.IntRef r14 = new Ref.IntRef();
            VideoViewParams r4 = this.a.l;
            r14.element = r4.c + r4.b;
            if (r6.element > 0) goto L15;
        L16:
            r6.element = s1.t();
            r8.element = s1.r();
            r12.element = 0;
            r14.element = s1.r();
        L17:
            int r5 = r6.element;
            int r7 = r8.element;
            if (r5 >= r7) goto L21;
            r5 = r7;
        L21:
            ValueAnimator r13 = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
            float r9 = this.a.j / r5;
            Ref.IntRef r11 = new Ref.IntRef();
            r11.element = 0;
            Ref.IntRef r10 = new Ref.IntRef();
            r10.element = 0;
            Ref.FloatRef r15 = new Ref.FloatRef();
            r15.element = 0.0f;
            Ref.IntRef r16 = new Ref.IntRef();
            r16.element = 0;
            Ref.IntRef r17 = new Ref.IntRef();
            r17.element = 0;
            Ref.FloatRef r18 = new Ref.FloatRef();
            r18.element = 0.0f;
            float r19 = this.a.k / r9;
            Ref.IntRef r20 = new Ref.IntRef();
            r20.element = 0;
            b r21 = this.a;
            if ((r21 instanceof PopupWindow) == false) goto L27;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r21) == false) goto L27;
            r21.update(0, 0, -1, -1);
        L30:
            r13.addUpdateListener(new a(this, r18, r15, r9, r16, r6, r17, r8, r20, r19, r11, r12, r10, r14));
            r13.setInterpolator(new AccelerateDecelerateInterpolator());
            r13.start();
            return;
        L27:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r21, 0, 0, -1, -1) == true) goto L30;
            r21.update(0, 0, -1, -1);
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
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(150);
        int[] r0 = new int[2];
        View r2 = getContentView();
        if (r2 == null) goto L8;
        r2.getLocationOnScreen(r0);
    L8:
        r1.addUpdateListener(new C0022b(this));
        r1.start();
    }

    public final Activity getContext() {
        return this.g;
    }

    public static final void a(b r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        super.dismiss();
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r8, int r9, int r10, int r11) {
        if (PopupWindowLancet.hasSubWindowToken(r8) == true) goto L13;
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L8;
        super.showAtLocation(r8, r9, r10, r11);
        goto L13
    L8:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r8, r0, r9, r10, r11) == true) goto L13;
        super.showAtLocation(r8, r9, r10, r11);
        PopupWindowLancet.trackAfterShow(this, r0, r8);
    L13:
        if (this.n == true) goto L17;
        View r12 = this.a;
        if (r12 == null) goto L17;
        UtilityKotlinExtentionsKt.z(r12, false);
    L17:
        if (r8 == null) goto L20;
        r8.post(new c(this));
        return;
    }

    public b(Activity r4, Bitmap r5, int r6, int r7, float r8, float r9, VideoViewParams r10, QuickRecordBasePresenter$showRecordShareDialog$1.a.ViewOnClickListenerC0026a r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "quickScreenShot");
        this.g = r4;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r12;
        LayoutInflater r13 = LayoutInflater.from(r4);
        int r14 = bs1.a.a;
        setContentView(r13.inflate(2131567958, null));
        FrameLayout r15 = (FrameLayout) getContentView().findViewById(2131389906);
        this.f = r15;
        ImageView r16 = (ImageView) getContentView().findViewById(2131389922);
        this.a = getContentView().findViewById(2131364832);
        this.b = getContentView().findViewById(2131389907);
        this.c = getContentView().findViewById(2131389920);
        this.d = getContentView().findViewById(2131389921);
        getContentView().setOnClickListener(new com.bytedance.android.livesdk.chatroom.ui.record.c(this));
        Bitmap r17 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), Bitmap.Config.ARGB_4444);
        Rect r18 = new Rect(0, 0, r5.getWidth(), r5.getHeight());
        RectF r19 = new RectF(r18);
        Canvas r110 = new Canvas(r17);
        r110.drawARGB(0, 0, 0, 0);
        Paint r111 = new Paint();
        r111.setAntiAlias(true);
        float r1 = 20;
        r110.drawRoundRect(r19, UtilityKotlinExtentionsKt.h(r1), UtilityKotlinExtentionsKt.h(r1), r111);
        r111.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r110.drawBitmap(r5, r18, r18, r111);
        if (r16 == null) goto L5;
        r16.setImageBitmap(r17);
    L5:
        if (r16 == null) goto L7;
        r16.setScaleType(ImageView.ScaleType.FIT_XY);
    L7:
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setOutsideTouchable(false);
        r15.setOnClickListener(new com.bytedance.android.livesdk.chatroom.ui.record.a(this));
    }
}
