package com.bytedance.android.livesdk.interactivity.barrage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.artist.render.RenderRequest;
import com.bytedance.live.zdanmaku.render.canvas.RenderEngineView;
import ec2.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tc2.d;
import vk6.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010b\u001a\u00020a\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010c\u0012\b\b\u0002\u0010e\u001a\u00020\n¢\u0006\u0004\bf\u0010gJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010%\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010.\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u001a\u00104\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001a\u00107\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R\u001a\u0010:\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\u001a\u0010=\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u00103R\u001a\u0010@\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\b>\u00101\u001a\u0004\b?\u00103R\u001a\u0010C\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\bA\u00101\u001a\u0004\bB\u00103R\u001a\u0010F\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\bD\u00101\u001a\u0004\bE\u00103R\u001a\u0010I\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\bG\u00101\u001a\u0004\bH\u00103R'\u0010O\u001a\u0012\u0012\u0004\u0012\u00020/0Jj\b\u0012\u0004\u0012\u00020/`K8\u0006¢\u0006\f\n\u0004\b\u0018\u0010L\u001a\u0004\bM\u0010NR\u0017\u0010R\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\bP\u0010\u0018\u001a\u0004\bQ\u0010\u001aR\u0017\u0010U\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\bS\u0010\u0018\u001a\u0004\bT\u0010\u001aR\u0017\u0010W\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\bV\u0010\u001aR\u0017\u0010Z\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\bX\u0010\u0018\u001a\u0004\bY\u0010\u001aR'\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u00160Jj\b\u0012\u0004\u0012\u00020\u0016`K8\u0006¢\u0006\f\n\u0004\b[\u0010L\u001a\u0004\b\\\u0010NR\u001b\u0010`\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010(\u001a\u0004\b_\u0010*¨\u0006h"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/view/CarnivalRenderEngineView;", "Lcom/bytedance/live/zdanmaku/render/canvas/RenderEngineView;", BuildConfig.FLAVOR, "support", BuildConfig.FLAVOR, "setSupportRotate", "enable", "setEnableEdgeBlur", "setEnableMask", "setCanDrawDanmakuEdge", BuildConfig.FLAVOR, "i", "I", "getRealWidth", "()I", "setRealWidth", "(I)V", "realWidth", "j", "getRealHeight", "setRealHeight", "realHeight", BuildConfig.FLAVOR, "k", "F", "getAngle", "()F", "setAngle", "(F)V", "angle", "kotlin.jvm.PlatformType", "q", "Ljava/lang/Boolean;", "getDebug", "()Ljava/lang/Boolean;", "setDebug", "(Ljava/lang/Boolean;)V", "debug", "Landroid/graphics/Paint;", "r", "Lkotlin/Lazy;", "getDanmakuLinePaint", "()Landroid/graphics/Paint;", "danmakuLinePaint", "u", "getEdgePaint", "edgePaint", BuildConfig.FLAVOR, sz1.a.KEY_X, "Ljava/lang/String;", "getColor0", "()Ljava/lang/String;", "color0", sz1.a.KEY_Y, "getColor1", "color1", "z", "getColor2", "color2", "A", "getColor3", "color3", "B", "getColor4", "color4", "C", "getColor5", "color5", "D", "getColor6", "color6", "E", "getColor7", "color7", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getColorArr", "()Ljava/util/ArrayList;", "colorArr", "G", "getWidth0", "width0", "H", "getWidth2", "width2", "getWidth4", "width4", "J", "getWidth6", "width6", "K", "getWidthArr", "widthArr", "L", "getMaskEdgePaint", "maskEdgePaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CarnivalRenderEngineView extends RenderEngineView {
    public final String A;
    public final String B;
    public final String C;
    public final String D;
    public final String E;
    public final ArrayList<String> F;
    public final float G;
    public final float H;
    public final float I;
    public final float J;
    public final ArrayList<Float> K;
    public final Lazy L;
    public int M;
    public final com.bytedance.live.artist.utils.b h;
    public int i;
    public int j;
    public float k;
    public RenderRequest l;
    public final Map<String, a> m;
    public final long n;
    public boolean o;
    public boolean p;
    public Boolean q;
    public final Lazy r;
    public final LinearGradient s;
    public final Matrix t;
    public final Lazy u;
    public boolean v;
    public final RectF w;
    public final String x;
    public final String y;
    public final String z;

    public CarnivalRenderEngineView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CarnivalRenderEngineView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Paint getDanmakuLinePaint() {
        return (Paint) this.r.getValue();
    }

    private final Paint getEdgePaint() {
        return (Paint) this.u.getValue();
    }

    private final Paint getMaskEdgePaint() {
        return (Paint) this.L.getValue();
    }

    public final void setEnableEdgeBlur(boolean r1) {
    }

    public final float getAngle() {
        return this.k;
    }

    public final String getColor0() {
        return this.x;
    }

    public final String getColor1() {
        return this.y;
    }

    public final String getColor2() {
        return this.z;
    }

    public final String getColor3() {
        return this.A;
    }

    public final String getColor4() {
        return this.B;
    }

    public final String getColor5() {
        return this.C;
    }

    public final String getColor6() {
        return this.D;
    }

    public final String getColor7() {
        return this.E;
    }

    public final ArrayList<String> getColorArr() {
        return this.F;
    }

    public final Boolean getDebug() {
        return this.q;
    }

    public final int getRealHeight() {
        return this.j;
    }

    public final int getRealWidth() {
        return this.i;
    }

    public final float getWidth0() {
        return this.G;
    }

    public final float getWidth2() {
        return this.H;
    }

    public final float getWidth4() {
        return this.I;
    }

    public final float getWidth6() {
        return this.J;
    }

    public final ArrayList<Float> getWidthArr() {
        return this.K;
    }

    public final void e(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        float r0 = r9.getWidth();
        float r1 = r9.getHeight();
        if (this.p == false) goto L6;
        r9.restore();
    L6:
        if (this.o == false) goto L16;
        Iterator r2 = ((LinkedHashMap) this.m).entrySet().iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        a r3 = (a) ((Map.Entry) r2.next()).getValue();
        long r4 = System.currentTimeMillis();
        r3.getClass();
        if ((r4 - 0) >= this.n) goto L9;
        throw null;
    L16:
        if (this.v == false) goto L18;
        RectF r5 = this.w;
        r5.left = 0.0f;
        r5.top = 0.0f;
        r5.right = r0;
        r5.bottom = r1;
        this.t.reset();
        this.t.setTranslate(0.0f, 0.0f);
        this.t.postScale(r1, r1, 0.0f, 0.0f);
        float r6 = r1 * 0.5f;
        this.t.postRotate(90.0f, r6, r6);
        this.s.setLocalMatrix(this.t);
        getEdgePaint().setShader(this.s);
        r9.drawRect(this.w, getEdgePaint());
    L18:
        r9.restoreToCount(this.M);
    }

    public final void f(Canvas r14) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        float r4 = r14.getWidth();
        float r5 = r14.getHeight();
        if (this.p == false) goto L5;
        this.M = r14.saveLayer(0.0f, 0.0f, this.i, this.j, null, 31);
        r14.save();
        r14.translate((-(this.i - r4)) * 0.5f, (-(this.j - r5)) * 0.5f);
        r14.rotate(this.k, this.i / 2.0f, this.j / 2.0f);
        return;
    L5:
        this.M = r14.saveLayer(0.0f, 0.0f, r4, r5, null, 31);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (this.k != 0.0f) goto L15;
        RenderRequest r0 = this.l;
        if (r7.getAction() != 0) goto L15;
        if (r0 == null) goto L15;
        final float r1 = r7.getX();
        final float r2 = r7.getY();
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = null;
        final Ref.BooleanRef r4 = new Ref.BooleanRef();
        r4.element = false;
        r0.a(new AnonymousClass1(r4, r1, r2, r3));
        d r5 = (d) r3.element;
        if (r5 == null) goto L11;
        r5.onClick(this);
    L11:
        if (r4.element == false) goto L15;
        return true;
    L15:
        return super/*android.view.View*/.onTouchEvent(r7);
    }

    public final void setAngle(float r1) {
        this.k = r1;
    }

    public final void setCanDrawDanmakuEdge(boolean r2) {
        if (r2 == true) goto L4;
    L6:
        boolean r3 = false;
    L7:
        this.v = r3;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r3 = true;
        goto L7
    }

    public final void setDebug(Boolean r1) {
        this.q = r1;
    }

    public final void setEnableMask(boolean r1) {
        this.o = r1;
    }

    public final void setRealHeight(int r1) {
        this.j = r1;
    }

    public final void setRealWidth(int r1) {
        this.i = r1;
    }

    public final void setSupportRotate(boolean r1) {
        this.p = r1;
    }

    public final void g(Canvas r5, RenderRequest r6) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        Intrinsics.checkNotNullParameter(r6, "request");
        com.bytedance.live.artist.utils.b r0 = this.h;
        CarnivalRenderEngineView$render$1 r1 = new CarnivalRenderEngineView$render$1(this, r6, r5);
        r0.a.put("renderAllUnits", Long.valueOf(System.nanoTime()));
        r1.invoke();
        r0.a("renderAllUnits");
        this.l = r6;
    }

    public CarnivalRenderEngineView(Context r10, AttributeSet r11, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r13);
        g r14 = g.a;
        this.h = new com.bytedance.live.artist.utils.b();
        this.m = new LinkedHashMap();
        this.n = 500;
        this.o = true;
        this.p = true;
        this.q = (Boolean) v.a.getValue();
        LazyThreadSafetyMode r15 = LazyThreadSafetyMode.NONE;
        this.r = LazyKt.lazy(r15, CarnivalRenderEngineView$danmakuLinePaint$2.INSTANCE);
        PorterDuffXfermode r16 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r0 = new Paint();
        r0.setColor(-1);
        r0.setAntiAlias(true);
        r0.setDither(true);
        r0.setXfermode(r16);
        Unit r17 = Unit.INSTANCE;
        this.s = new LinearGradient(0.0f, 1.0f, 1.0f, 1.0f, new int[]{0, -1, -1, 0}, new float[]{0.0f, 0.05f, 0.95f, 1.0f}, Shader.TileMode.CLAMP);
        this.t = new Matrix();
        this.u = LazyKt.lazy(r15, CarnivalRenderEngineView$edgePaint$2.INSTANCE);
        this.v = true;
        this.w = new RectF();
        this.x = "#D9FFFFFF";
        this.y = "#B3FFFFFF";
        this.z = "#8CFFFFFF";
        this.A = "#66FFFFFF";
        this.B = "#52FFFFFF";
        this.C = "#40FFFFFF";
        this.D = "#26FFFFFF";
        this.E = "#19FFFFFF";
        this.F = CollectionsKt.arrayListOf(new String[]{"#D9FFFFFF", "#B3FFFFFF", "#8CFFFFFF", "#66FFFFFF"});
        float r1 = (int) UtilityKotlinExtentionsKt.h(6.0f);
        this.G = r1;
        float r2 = (int) UtilityKotlinExtentionsKt.h(4.0f);
        this.H = r2;
        float r3 = (int) UtilityKotlinExtentionsKt.h(2.0f);
        this.I = r3;
        float r4 = (int) UtilityKotlinExtentionsKt.h(1.0f);
        this.J = r4;
        this.K = CollectionsKt.arrayListOf(new Float[]{Float.valueOf(r1), Float.valueOf(r2), Float.valueOf(r3), Float.valueOf(r4)});
        this.L = LazyKt.lazy(r15, new CarnivalRenderEngineView$maskEdgePaint$2(this));
    }

    public /* synthetic */ CarnivalRenderEngineView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
