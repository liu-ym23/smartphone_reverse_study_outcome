package com.obric.oui.segmentedtab;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.common.oea.foundation.animation.builder.c;
import com.obric.common.oea.foundation.animation.d.d;
import com.obric.common.oea.foundation.animation.spec.b;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.oui.common.style.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001NB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\tH\u0002J\u0016\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0004J\u0010\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020\u0004H\u0016J\b\u0010C\u001a\u00020\u0004H\u0016J\b\u0010D\u001a\u00020\u0004H\u0016J\b\u0010E\u001a\u00020\u0004H\u0017J\u0010\u0010F\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010G\u001a\u00020:2\b\u0010H\u001a\u0004\u0018\u00010\u0006J&\u0010I\u001a\u00020:2\u0006\u0010,\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tJ\u0012\u0010J\u001a\u00020:2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J&\u0010M\u001a\u00020:2\u0006\u0010,\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR&\u0010&\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8F@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u000e\u0010(\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "alpha", "", "animListener", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable$AnimListener;", TypedValues.Custom.S_COLOR, "currentHeight", "", "currentLeft", "currentTop", "currentWidth", "enableAnim", "", EventBody.KEY_VALUE, "enableAnimation", "getEnableAnimation", "()Z", "setEnableAnimation", "(Z)V", "height", "indicatorColor", "getIndicatorColor", "()I", "setIndicatorColor", "(I)V", "indicatorCornerRadius", "getIndicatorCornerRadius", "()F", "setIndicatorCornerRadius", "(F)V", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "inset", "getInset", "setInset", "isAnimRunning", "setAnimRunning", "lastHeight", "lastLeft", "lastTop", "lastWidth", "left", "mBounds", "Landroid/graphics/Rect;", "maxWidthScale", "minHeightScale", "paint", "Landroid/graphics/Paint;", "positionAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "radius", "sizeAnimator", "top", "width", "calculateSizeByFraction", "", "fraction", "checkAndInitHeightAndRadius", "parentHeight", "spacing", "draw", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "setAlpha", "setAnimListener", "listener", "setBound", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "updateBound", "AnimListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f14442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14443b;
    private float c;
    private float d;
    private float e;
    private float f;
    private Rect g;
    private int h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private boolean r;
    private boolean s;
    private InterfaceC0773a t;
    private final float u;
    private final float v;
    private d w;
    private d x;

    /* JADX INFO: renamed from: com.obric.oui.segmentedtab.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable$AnimListener;", "", "onAnimCancel", "", "onAnimEnd", "onAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface InterfaceC0773a {
        void a();

        void b();

        void c();
    }

    public a() {
        this.f14442a = new Paint();
        this.f14443b = 255;
        this.g = new Rect();
        this.r = true;
        this.u = 1.15f;
        this.v = 0.85f;
    }

    public static final /* synthetic */ float a(a r0) {
        return r0.c;
    }

    public static final /* synthetic */ void a(a r0, float r1) {
        r0.c = r1;
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ InterfaceC0773a b(a r0) {
        return r0.t;
    }

    public static final /* synthetic */ void b(a r0, float r1) {
        r0.c(r1);
    }

    private final void b(boolean r1) {
        this.s = r1;
    }

    private final void c(float r5) {
        float r0 = this.l * this.u;
        float r1 = r0 + ((this.p - r0) * r5);
        boolean r2 = true;
        if (this.e != r1) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L8;
        this.e = r1;
        invalidateSelf();
    L8:
        float r4 = this.q;
        float r6 = this.v * r4;
        float r7 = r6 + ((r4 - r6) * r5);
        if (this.f == r7) goto L12;
        r2 = false;
    L12:
        if (r2 == true) goto L15;
        this.f = r7;
        invalidateSelf();
        return;
    L15:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void a(float r2) {
        if (this.i != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.i = r2;
        invalidateSelf();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(float r1, float r2, float r3, float r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.j = r1;
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r1;
        this.o = r2;
        this.p = r3;
        this.q = r4;
    }

    public final void a(int r2) {
        if (this.h == r2) goto L6;
        this.h = r2;
        this.f14442a.setColor(r2);
        invalidateSelf();
        return;
    }

    public final void a(int r3, int r4) {
        if (d() >= 0.0f) goto L6;
        b(r3 - (r4 * 2.0f));
    L6:
        if (c() >= 0.0f) goto L8;
    L9:
        a(d());
        return;
    L8:
        if (c() > (d() / 2)) goto L9;
    }

    public final void a(InterfaceC0773a r3) {
        this.t = (InterfaceC0773a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0773a.class, "com.obric.memorydata.plugin");
    }

    public final void a(boolean r1) {
        this.r = r1;
    }

    public final boolean a() {
        return this.s;
    }

    public final int b() {
        return this.h;
    }

    public final void b(float r5) {
        boolean r1 = true;
        if (this.m != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.m = r5;
    L8:
        float r2 = this.q;
        if (r2 == r5) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L15;
        this.m = r2;
        this.q = r5;
        this.f = r5;
        invalidateSelf();
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void b(float r10, float r11, float r12, float r13) {
        float r0 = this.p;
        if (r0 <= 0.0f) goto L5;
        this.j = this.n;
        this.l = r0;
        this.k = this.o;
    L5:
        float r1 = this.q;
        if (r1 <= 0.0f) goto L8;
        this.m = r1;
    L8:
        this.o = r11;
        this.n = r10;
        this.p = r12;
        this.f = r13;
        if (this.j != r10) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == true) goto L14;
    L19:
        d r15 = this.w;
        if (r15 == null) goto L23;
        d.a(r15, false, 1, null);
    L23:
        d r16 = this.x;
        if (r16 == null) goto L27;
        d.a(r16, false, 1, null);
    L27:
        this.w = c.a.a(new c.a(), this.j + ((this.l * (1 - this.u)) / 2.0f), this.n, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new ONaviIndicatorDrawable$updateBound$1(this), Function3.class, "com.obric.memorydata.plugin")).a().a();
        this.x = c.a.a(new c.a(), 0.0f, 1.0f, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4, Token.Duration.OUI_ANIMATION_DURATION_VERY_LONG_2, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new ONaviIndicatorDrawable$updateBound$2(this), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new ONaviIndicatorDrawable$updateBound$3(this), Function2.class, "com.obric.memorydata.plugin")).a().a();
        InterfaceC0773a r9 = this.t;
        if (r9 == null) goto L33;
        r9.a();
        return;
    L33:
        return;
    L14:
        if (this.l != r12) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == false) goto L19;
        invalidateSelf();
        return;
    L16:
        r17 = false;
        goto L17
    L11:
        r14 = false;
        goto L12
    }

    public final float c() {
        return this.i;
    }

    public final float d() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        float r0 = this.k;
        float r1 = (r0 + r0) + this.m;
        float r2 = 2;
        float r3 = this.f;
        float r5 = (r1 / r2) - (r3 / r2);
        this.d = r5;
        float r4 = this.c;
        m.a(r11, r4, r5, r4 + this.e, r5 + r3, c(), this.f14442a);
    }

    public final boolean e() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f14443b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.e;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        if (this.f14443b != 255) goto L5;
        return -1;
    L5:
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (r2 == this.f14443b) goto L6;
        this.f14443b = r2;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
