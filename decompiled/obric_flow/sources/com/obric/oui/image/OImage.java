package com.obric.oui.image;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import f9.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import l9.o;
import sr.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0012J\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/image/OImage;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/oui/image/OImageShape;", "shape", "", "setImageShape", "(Lcom/obric/oui/image/OImageShape;)V", "", "radiusDp", "setRadiusDp", "(F)V", "radiusPx", "setRadiusPx", "getImageShape", "()Lcom/obric/oui/image/OImageShape;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OImage extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f13371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f13372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f13373c;
    public final RectF d;
    public final c e;
    public final float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OImageShape f13374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f13376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f13377k;

    @JvmOverloads
    public OImage(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final OImageShape getImageShape() {
        return this.f13374h;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float r5 = getWidth();
        float r11 = getHeight();
        if (r5 > 0.0f) goto L5;
    L30:
        Log.w("OImage", "Skip draw due to invalid size width=" + r5 + " height=" + r11);
        return;
    L5:
        if (r11 <= 0.0f) goto L30;
        RectF r12 = this.f13372b;
        r12.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (r12.isEmpty() == false) goto L11;
        Log.w("OImage", Intrinsics.stringPlus("Skip draw due to empty clip bounds rect=", r12));
        return;
    L11:
        boolean r13 = this.e.f22001b;
        float r14 = this.f13376j;
        if (r13 == false) goto L14;
        float r15 = RangesKt.coerceAtLeast(this.f13375i - r14, 0.0f);
    L15:
        if (r13 == false) goto L20;
        RectF r16 = this.f13373c;
        r16.set(r12);
        r16.inset(r14, r14);
        if (r16.isEmpty() == false) goto L21;
        Log.w("OImage", Intrinsics.stringPlus("Stroke ON but skip content draw due to empty content bounds rect=", r16));
        return;
    L21:
        Path r17 = this.f13371a;
        r17.reset();
        r17.addRoundRect(r16, r15, r15, Path.Direction.CW);
        int r18 = r10.save();
        r10.clipPath(r17);
        super.onDraw(r10);
        r10.restoreToCount(r18);
        if (r13 == true) goto L24;
        return;
    L24:
        RectF r19 = this.d;
        r19.set(r12);
        float r20 = r14 / 2.0f;
        r19.inset(r20, r20);
        if (r19.isEmpty() == false) goto L28;
        Log.w("OImage", Intrinsics.stringPlus("Stroke ON but skip due to empty stroke bounds rect=", r19));
        return;
    L28:
        float r21 = RangesKt.coerceAtLeast(this.f13375i - r20, 0.0f);
        r10.drawRoundRect(r19, r21, r21, this.f13377k);
        return;
    L20:
        r16 = r12;
        goto L21
    L14:
        r15 = this.f13375i;
        goto L15
    }

    public final void setImageShape(OImageShape r5) {
        Intrinsics.checkNotNullParameter(r5, "shape");
        if (r5 != this.f13374h) goto L6;
        Log.d("OImage", Intrinsics.stringPlus("Skip setImageShape because shape is unchanged: ", r5));
        return;
    L6:
        this.f13374h = r5;
        this.f13375i = o.l(r5, this.g, this.f);
        Log.i("OImage", "Image shape changed to " + r5 + ", effectiveRadiusPx=" + this.f13375i);
        invalidate();
    }

    public final void setRadiusDp(float r5) {
        setRadiusPx(r5 * getContext().getResources().getDisplayMetrics().density);
    }

    public final void setRadiusPx(float r5) {
        if (this.g != r5) goto L5;
        return;
    L5:
        this.g = r5;
        this.f13375i = o.l(this.f13374h, r5, this.f);
        invalidate();
    }

    @JvmOverloads
    public OImage(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OImage(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OImage(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f13371a = new Path();
        this.f13372b = new RectF();
        this.f13373c = new RectF();
        this.d = new RectF();
        this.e = a.j(r5, r10, r11);
        this.f = r5.getResources().getDimension(R$dimen.oui_image_rounded_radius);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L6
        TypedArray r13 = r5.obtainStyledAttributes(r10, new int[]{R.attr.radius}, r11, 0);     // Catch: Throwable -> L6
        float r14 = r13.getDimension(0, 0.0f);     // Catch: Throwable -> L8
        r13.recycle();     // Catch: Throwable -> L6
        Object r15 = Result.m124constructorimpl(Float.valueOf(r14));     // Catch: Throwable -> L6
    L12:
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);
        if (r16 == null) goto L16;
        Log.w("OImage", "Failed to parse android:radius; fallback to 0", r16);
        r15 = Float.valueOf(0.0f);
    L16:
        float r17 = ((Number) r15).floatValue();
        this.g = r17;
        OImageShape r18 = this.e.f22000a;
        this.f13374h = r18;
        this.f13375i = o.l(r18, r17, this.f);
        float r19 = r5.getResources().getDimension(R$dimen.oui_image_stroke_width);
        this.f13376j = r19;
        Paint r20 = new Paint(1);
        r20.setStyle(Paint.Style.STROKE);
        r20.setColor(ContextCompat.getColor(r5, R$color.oui_line_1));
        r20.setStrokeWidth(r19);
        this.f13377k = r20;
        return;
    L8:
        th = move-exception;
        r13.recycle();     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
