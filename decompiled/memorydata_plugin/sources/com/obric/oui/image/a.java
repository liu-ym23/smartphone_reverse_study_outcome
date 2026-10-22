package com.obric.oui.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0006H\u0016J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0017\u0010)\u001a\u00020\u00182\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00182\b\b\u0001\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/oui/image/AppIconDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "icon", "backgroundColor", "", "strokeColor", "strokeWidthPixels", "", "clipToMask", "", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;IFZ)V", "backgroundAvoidsStroke", "Ljava/lang/Integer;", "backgroundMaskPath", "Landroid/graphics/Path;", "backgroundPaint", "Landroid/graphics/Paint;", "maskPath", "pathMatrix", "Landroid/graphics/Matrix;", "strokePaint", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawClipMask", "drawMaskBackground", "drawNoClipMask", "getOpacity", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "refreshMaskPath", "setAlpha", "alpha", "setClipToMask", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setIconBackgroundColor", "(Ljava/lang/Integer;)V", "setStrokeColor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0753a f13889a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13890b;
    private final Drawable c;
    private Integer d;
    private int e;
    private final float f;
    private boolean g;
    private final Paint h;
    private final Paint i;
    private boolean j;
    private final Path k;
    private final Path l;
    private final Matrix m;

    /* JADX INFO: renamed from: com.obric.oui.image.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/image/AppIconDrawable$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0753a {
        private C0753a() {
        }

        public /* synthetic */ C0753a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13889a = new C0753a(null);
    }

    public a(Context r3, Drawable r4, Integer r5, int r6, float r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r4, "icon");
        this.f13890b = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        Paint r10 = new Paint(1);
        r10.setStyle(Paint.Style.STROKE);
        r10.setColor(this.e);
        this.h = r10;
        Paint r11 = new Paint(1);
        r11.setStyle(Paint.Style.FILL);
        this.i = r11;
        this.k = new Path();
        this.l = new Path();
        this.m = new Matrix();
        Integer r12 = this.d;
        if (r12 == null) goto L6;
        r11.setColor(((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue());
    L6:
        a();
    }

    public /* synthetic */ a(Context r10, Drawable r11, Integer r12, int r13, float r14, boolean r15, int r16, DefaultConstructorMarker r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if ((r16 & 4) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        int r6 = r3.getColor(ZeusTransformUtils.mapRes(R.color.oui_line_1, TypedValues.Custom.S_COLOR, "oui_line_1"));
    L11:
        if ((r16 & 16) == 0) goto L13;
        float r7 = ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_image_stroke_width, "dimen", "oui_image_stroke_width"));
    L15:
        if ((r16 & 32) == 0) goto L17;
        boolean r8 = false;
    L18:
        this(r3, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    private final void a() {
        this.k.reset();
        this.l.reset();
        if (getBounds().isEmpty() == false) goto L6;
        Log.w("OImageAppIcon", "refreshMaskPath skipped because bounds is empty, check if in whitelist");
        return;
    L6:
        Path r0 = new AdaptiveIconDrawable(null, null, null).getIconMask();
        if (r0.isEmpty() == false) goto L10;
        Log.w("OImageAppIcon", "refreshMaskPath found empty icon mask");
        return;
    L10:
        float r1 = getBounds().width();
        float r2 = getBounds().height();
        float r3 = Math.min(r1, r2);
        float r5 = 0.0f;
        if (r1 <= r2) goto L13;
        float r4 = (r1 - r2) / 2.0f;
    L15:
        if (r2 <= r1) goto L17;
        r5 = (r2 - r1) / 2.0f;
    L17:
        this.m.reset();
        float r6 = r3 / 100.0f;
        this.m.setScale(r6, r6);
        this.k.set(r0);
        this.k.transform(this.m);
        this.k.offset(getBounds().left + r4, getBounds().top + r5);
        float r7 = this.f + 1;
        this.m.reset();
        float r8 = (r3 - (2.0f * r7)) / 100.0f;
        this.m.setScale(r8, r8);
        this.l.set(r0);
        this.l.transform(this.m);
        this.l.offset((getBounds().left + r4) + r7, (getBounds().top + r5) + r7);
        return;
    L13:
        r4 = 0.0f;
        goto L15
    }

    private final void a(Canvas r5) {
        if (this.k.isEmpty() == false) goto L6;
        Log.w("OImageAppIcon", "draw skipped mask because maskPath is empty");
        this.c.draw(r5);
        return;
    L6:
        int r0 = r5.save();
        r5.clipPath(this.k);
        c(r5);
        this.c.draw(r5);
        float r2 = this.f;
        if (r2 > 0.0f) goto L10;
        Log.d("OImageAppIcon", Intrinsics.stringPlus("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r2)));
        r5.restoreToCount(r0);
        return;
    L10:
        this.h.setStrokeWidth(r2 * 2);
        this.h.setStrokeJoin(Paint.Join.ROUND);
        this.h.setStrokeCap(Paint.Cap.ROUND);
        r5.drawPath(this.k, this.h);
        r5.restoreToCount(r0);
    }

    private final void b(Canvas r5) {
        c(r5);
        this.c.draw(r5);
        if (this.k.isEmpty() == false) goto L6;
        Log.w("OImageAppIcon", "draw skipped stroke because maskPath is empty");
        return;
    L6:
        float r0 = this.f;
        if (r0 > 0.0f) goto L10;
        Log.d("OImageAppIcon", Intrinsics.stringPlus("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r0)));
        return;
    L10:
        int r1 = r5.save();
        r5.clipPath(this.k);
        this.h.setStrokeWidth(this.f * 2);
        this.h.setStrokeJoin(Paint.Join.ROUND);
        this.h.setStrokeCap(Paint.Cap.ROUND);
        r5.drawPath(this.k, this.h);
        r5.restoreToCount(r1);
    }

    private final void c(Canvas r2) {
        if (this.d != null) goto L6;
        return;
    L6:
        if (this.k.isEmpty() == false) goto L10;
        Log.w("OImageAppIcon", "draw skipped background because maskPath is empty");
        return;
    L10:
        if (this.j == false) goto L12;
        Path r0 = this.l;
    L13:
        r2.drawPath(r0, this.i);
        return;
    L12:
        r0 = this.k;
        goto L13
    }

    public final void a(int r2) {
        if (this.e != r2) goto L5;
        return;
    L5:
        this.e = r2;
        this.h.setColor(r2);
        invalidateSelf();
    }

    public final void a(Integer r3) {
        if (Intrinsics.areEqual(this.d, r3) == false) goto L5;
        return;
    L5:
        this.d = r3;
        if (r3 == null) goto L8;
        boolean r0 = true;
    L9:
        this.j = r0;
        Log.d("OImageAppIcon", Intrinsics.stringPlus("backgroundAvoidsStroke =  ", Boolean.valueOf(r0)));
        if (r3 == null) goto L13;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        this.i.setColor(r4);
    L13:
        invalidateSelf();
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final void a(boolean r2) {
        if (this.g != r2) goto L5;
        return;
    L5:
        this.g = r2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.g == true) goto L6;
        b(r2);
        return;
    L6:
        a(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        super.onBoundsChange(r2);
        this.c.setBounds(r2);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.c.setAlpha(r2);
        this.i.setAlpha(r2);
        this.h.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.c.setColorFilter(r2);
        this.i.setColorFilter(r2);
        this.h.setColorFilter(r2);
        invalidateSelf();
    }
}
