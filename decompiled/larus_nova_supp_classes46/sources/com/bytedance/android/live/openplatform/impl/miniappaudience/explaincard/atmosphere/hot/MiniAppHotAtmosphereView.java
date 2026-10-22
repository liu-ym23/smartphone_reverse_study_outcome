package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.utils.t6;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u0004\u0018\u00010\tR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/explaincard/atmosphere/hot/MiniAppHotAtmosphereView;", "Landroid/widget/LinearLayout;", "", "width", "", "setMaxWidth", "Lcom/bytedance/android/live/openplatform/impl/miniappaudience/explaincard/atmosphere/hot/a;", "cb", "setCallback", "Lcom/bytedance/android/livesdk/wrds/syncdata/openplatform/b;", "item", "setHotAtmosphereData", "getCurrentItem", "Landroid/graphics/Path;", "k", "Lkotlin/Lazy;", "getPath", "()Landroid/graphics/Path;", "path", "Landroid/graphics/Paint;", "l", "getSolidPaint", "()Landroid/graphics/Paint;", "solidPaint", "m", "getBorderPaint", "borderPaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppHotAtmosphereView extends LinearLayout {
    public static final /* synthetic */ int s = 0;
    public SimpleDraweeView a;
    public boolean b;
    public ViewGroup c;
    public TextView d;
    public Animator e;
    public float f;
    public Animator g;
    public final b h;
    public Integer i;
    public boolean j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public boolean n;
    public final LinkedList<com.bytedance.android.livesdk.wrds.syncdata.openplatform.b> o;
    public com.bytedance.android.livesdk.wrds.syncdata.openplatform.b p;
    public com.bytedance.android.livesdk.wrds.syncdata.openplatform.b q;
    public com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a r;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MiniAppHotAtmosphereView a;

        public static final class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r2) {
                Intrinsics.checkNotNullParameter(r2, "it");
                MiniAppHotAtmosphereView r0 = this.a.a;
                Object r3 = r2.getAnimatedValue();
                if (r3 == null) goto L7;
                r0.f = ((Float) r3).floatValue();
                this.a.a.invalidate();
                return;
            L7:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.MiniAppHotAtmosphereView$b$b, reason: collision with other inner class name */
        public static final class C0164b extends AnimatorListenerAdapter {
            public final /* synthetic */ b a;

            public C0164b(b r1) {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                this.a.a.f = 1.0f;
            }
        }

        public b(MiniAppHotAtmosphereView r1) {
            this.a = r1;
        }

        public final void a() {
            MiniAppHotAtmosphereView r0 = this.a;
            if (r0.n == true) goto L5;
            return;
        L5:
            ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r1.addUpdateListener(new a(this));
            r1.addListener(new C0164b(this));
            r1.setDuration(160);
            Unit r2 = Unit.INSTANCE;
            r0.g = r1;
            Animator r3 = this.a.g;
            if (r3 == null) goto L9;
            r3.start();
            return;
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

    public MiniAppHotAtmosphereView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MiniAppHotAtmosphereView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Paint getBorderPaint() {
        return (Paint) this.m.getValue();
    }

    private final Path getPath() {
        return (Path) this.k.getValue();
    }

    private final Paint getSolidPaint() {
        return (Paint) this.l.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasTransientState() {
        return false;
    }

    public final void d() {
        if (this.n == true) goto L5;
        return;
    L5:
        if (this.e != null) goto L34;
        final com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r0 = this.o.poll();
        if (r0 == null) goto L32;
        ViewGroup r1 = this.c;
        if (r1 == null) goto L33;
        this.p = r0;
        r1.setVisibility(0);
        String r3 = r0.c();
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r4 = this.p;
        if (r4 == null) goto L14;
        String r5 = r4.c();
    L16:
        if (Intrinsics.areEqual(r3, r5) == true) goto L18;
    L20:
        this.b = false;
        SimpleDraweeView r2 = this.a;
        if (r2 == null) goto L23;
        AbstractDraweeController r6 = Fresco.newDraweeControllerBuilder().setOldController(r2.getController()).setUri(r0.c()).setAutoPlayAnimations(true).build();
        r6.addControllerListener(new com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.b(this));
        Unit r7 = Unit.INSTANCE;
        r2.setController(r6);
    L23:
        TextView r8 = this.d;
        if (r8 == null) goto L29;
        final long r9 = r0.d();
        com.bytedance.android.live.openplatform.impl.base.utils.text.c r10 = new com.bytedance.android.live.openplatform.impl.base.utils.text.c(new SpannableStringBuilder());
        r10.d(12, MiniAppHotAtmosphereView$buildText$1$1.INSTANCE);
        com.bytedance.android.live.openplatform.impl.base.utils.text.b.a.a(r10, (int) a(1.0f));
        r10.d(20, new MiniAppHotAtmosphereView$buildText$$inlined$buildSpannedString$lambda$1(this, r9, r0));
        if (r0.d() < 10000) goto L28;
        com.bytedance.android.live.openplatform.impl.base.utils.text.b.a.a(r10, (int) a(2.5f));
        r10.d(13, MiniAppHotAtmosphereView$buildText$1$3.INSTANCE);
    L28:
        r8.setText(new SpannedString(r10.a));
    L29:
        AnimatorSet r11 = h.c(r1, new float[]{1.0f, 1.3f, 1.0f});
        r11.setDuration(250);
        h.a(r11, new MiniAppHotAtmosphereView$onTextChange$$inlined$let$lambda$1(this, r0));
        Unit r12 = Unit.INSTANCE;
        this.e = r11;
        r11.start();
        return;
    L18:
        if (this.b == false) goto L20;
    L14:
        r5 = null;
        goto L16
    L33:
        return;
    L32:
        return;
    }

    public final void c() {
        if (getChildCount() != 0) goto L6;
        setPadding(0, 0, (int) a(8.0f), 0);
        int r0 = (int) a(24.0f);
        LinearLayout r2 = new LinearLayout(getContext());
        r2.setOrientation(0);
        r2.setGravity(80);
        SimpleDraweeView r3 = new SimpleDraweeView(r2.getContext());
        this.a = r3;
        r3.setLayoutParams(new LinearLayout.LayoutParams((int) a(53.0f), r0));
        r3.getHierarchy().setFadeDuration(0);
        Unit r4 = Unit.INSTANCE;
        r2.addView(r3);
        FrameLayout r5 = new FrameLayout(r2.getContext());
        this.c = r5;
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, r0));
        r5.setPadding((int) a(2.0f), 0, 0, 0);
        ItalicTextView r1 = new ItalicTextView(r5.getContext(), null);
        this.d = r1;
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 16;
        r1.setLayoutParams(r6);
        r1.setIncludeFontPadding(false);
        r1.setTypeface(null, 1);
        r1.setTextColor(-1);
        r5.addView(r1);
        r2.addView(r5);
        addView(r2);
        return;
    }

    public final com.bytedance.android.livesdk.wrds.syncdata.openplatform.b getCurrentItem() {
        return this.p;
    }

    public static String b(long r5) {
        if (r5 <= 9999) goto L9;
        if (((r5 / ((long) 1000)) % ((long) 10)) == 0) goto L10;
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r5 / 10000.0d)}, 1));
    L10:
        return String.valueOf(r5 / ((long) 10000));
    L9:
        return String.valueOf(r5);
    }

    public static int e(String r4) {
        if (StringsKt.isBlank(r4) == false) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L16;
        return 0;
    L16:
    L14:
        return -16777216;
    L10:
        if (StringsKt.startsWith$default(r4, "#", false, 2, null) == true) goto L12;
        r4 = "#".concat(r4);     // Catch: Exception -> L14
    L12:
        return Color.parseColor(r4);
    L5:
        r1 = false;
        goto L6
    }

    public final float a(float r2) {
        return t6.a(getContext(), r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r23) {
        Intrinsics.checkNotNullParameter(r23, "canvas");
        super.onDraw(r23);
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r2 = this.p;
        if (r2 != null) goto L5;
        r2 = this.o.peek();
    L5:
        if (r2 != null) goto L7;
        return;
    L7:
        float r3 = getWidth() * this.f;
        int r4 = getHeight();
        boolean r5 = this.j;
        if (r5 == false) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r5 == false) goto L16;
    L19:
        boolean r15 = true;
    L20:
        this.q = r2;
        int r7 = e("#FFB11A");
        float r8 = 255;
        int r9 = (int) (0.8f * r8);
        int r10 = (int) (0.6f * r8);
        int[] r11 = {ColorUtils.setAlphaComponent(r7, r9), ColorUtils.setAlphaComponent(r7, r10), 0};
        int r12 = e("#FFDC60");
        int[] r13 = {ColorUtils.setAlphaComponent(r12, r9), ColorUtils.setAlphaComponent(r12, r10), 0};
        if (r6 == false) goto L23;
        char r14 = 3;
        getSolidPaint().setShader(new LinearGradient(0.0f, 0.0f, r3, 0.0f, r11, new float[]{0.0f, 0.8f, 1.0f}, Shader.TileMode.CLAMP));
        getBorderPaint().setShader(new LinearGradient(0.0f, 0.0f, r3, 0.0f, r13, new float[]{0.0f, 0.8f, 1.0f}, Shader.TileMode.CLAMP));
    L24:
        if (r15 == false) goto L26;
        float r16 = getHeight() / 2.0f;
        getPath().reset();
        Path r17 = getPath();
        RectF r18 = new RectF(0.0f, 0.0f, r3 + 0.0f, r4 + 0.0f);
        float[] r19 = new float[8];
        r19[0] = r16;
        r19[1] = r16;
        r19[2] = 0.0f;
        r19[r14] = 0.0f;
        r19[4] = 0.0f;
        r19[5] = 0.0f;
        r19[6] = r16;
        r19[7] = r16;
        r17.addRoundRect(r18, r19, Path.Direction.CW);
    L26:
        r23.drawPath(getPath(), getSolidPaint());
        r23.drawPath(getPath(), getBorderPaint());
        return;
    L23:
        r14 = 3;
        goto L24
    L16:
        if (this.q == null) goto L19;
        r15 = false;
        goto L20
    L10:
        if (this.q == null) goto L13;
        r6 = false;
        goto L14
    }

    public final void setCallback(com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a r1) {
        this.r = r1;
    }

    public final void setHotAtmosphereData(com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r0 = this.o.peekLast();
        if (r0 != null) goto L5;
        r0 = this.p;
    L5:
        boolean r1 = true;
        if (r0 != null) goto L8;
    L13:
        if (r1 == false) goto L16;
        this.o.offer(r8);
    L16:
        if (this.n == true) goto L18;
        return;
    L18:
        if (this.o.isEmpty() == true) goto L23;
        d();
        return;
    L23:
        return;
    L8:
        if (r0.d() < r8.d()) goto L10;
    L12:
        r1 = false;
        goto L13
    L10:
        if ((!Intrinsics.areEqual(b(r0.d()), b(r8.d()))) == false) goto L12;
        goto L12
    }

    public final void setMaxWidth(int r1) {
        this.i = Integer.valueOf(r1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION), r4);
        Integer r5 = this.i;
        if (r5 != null) goto L6;
        r5 = Integer.valueOf(View.MeasureSpec.getSize(r3));
    L6:
        if (getMeasuredWidth() <= r5.intValue()) goto L9;
        setMeasuredDimension(r5.intValue(), getMeasuredHeight());
    L9:
        if (getMeasuredWidth() <= 0) goto L21;
        TextView r6 = this.d;
        if (r6 == null) goto L22;
        int r7 = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
        SimpleDraweeView r0 = this.a;
        if (r0 == null) goto L15;
        int r1 = r0.getMeasuredWidth();
    L16:
        float r8 = (r7 - r1) / r6.getMeasuredWidth();
        if (r8 >= 1) goto L19;
        r6.setScaleX(r8);
        r6.setScaleY(r8);
        r6.setPivotX(0.0f);
        r6.setPivotY(r6.getMeasuredHeight() / 2.0f);
        return;
    L19:
        r6.setScaleX(1.0f);
        r6.setScaleY(1.0f);
        return;
    L15:
        r1 = 0;
        goto L16
    L22:
        return;
    }

    public MiniAppHotAtmosphereView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.h = new b(this);
        this.j = true;
        this.k = LazyKt.lazy(MiniAppHotAtmosphereView$path$2.INSTANCE);
        this.l = LazyKt.lazy(MiniAppHotAtmosphereView$solidPaint$2.INSTANCE);
        this.m = LazyKt.lazy(new MiniAppHotAtmosphereView$borderPaint$2(r2));
        this.o = new LinkedList();
        setWillNotDraw(false);
        setClipToPadding(false);
        setOrientation(1);
    }

    public /* synthetic */ MiniAppHotAtmosphereView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L6;
        this.j = true;
        return;
    }
}
