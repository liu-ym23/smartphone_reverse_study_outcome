package com.obric.oui.texteffects.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.widget.TextView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020$H\u0016J\u0018\u0010(\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0016J$\u0010+\u001a\u00020$*\u00020,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0002J\f\u0010/\u001a\u00020\u0006*\u00020,H\u0002J\f\u00100\u001a\u00020\u0006*\u00020,H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\b¨\u00061"}, d2 = {"Lcom/obric/oui/texteffects/host/AndroidTextViewEffectHost;", "Lcom/obric/oui/texteffects/host/TextViewEffectHost;", "view", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "baseline", "", "getBaseline", "()I", "currentTextColor", "getCurrentTextColor", "density", "", "getDensity", "()F", "height", "getHeight", "layout", "Landroid/text/Layout;", "getLayout", "()Landroid/text/Layout;", "measuredWidth", "getMeasuredWidth", "paint", "Landroid/text/TextPaint;", "getPaint", "()Landroid/text/TextPaint;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "getText", "()Ljava/lang/CharSequence;", "getView", "()Landroid/widget/TextView;", "width", "getWidth", "drawCompoundDrawables", "", "canvas", "Landroid/graphics/Canvas;", "invalidate", "setInternalText", "bufferType", "Landroid/widget/TextView$BufferType;", "drawAt", "Landroid/graphics/drawable/Drawable;", "left", "top", "drawableHeight", "drawableWidth", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f14580a;

    public a(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.f14580a = r2;
    }

    private final int a(Drawable r3) {
        Integer r2 = Integer.valueOf(r3.getBounds().width());
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L12;
        return RangesKt.coerceAtLeast(r3.getIntrinsicWidth(), 0);
    L12:
        return r2.intValue();
    L5:
        r0 = false;
        goto L6
    }

    private final void a(Drawable r1, Canvas r2, int r3, int r4) {
        int r0 = r2.save();
        r2.translate(r3, r4);     // Catch: Throwable -> L6
        r1.draw(r2);     // Catch: Throwable -> L6
        r2.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r2.restoreToCount(r0);
        throw th;
    }

    private final int b(Drawable r3) {
        Integer r2 = Integer.valueOf(r3.getBounds().height());
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L12;
        return RangesKt.coerceAtLeast(r3.getIntrinsicHeight(), 0);
    L12:
        return r2.intValue();
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.oui.texteffects.a.b
    public TextView a() {
        return this.f14580a;
    }

    @Override // com.obric.oui.texteffects.a.b
    public void a(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        Drawable[] r0 = a().getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r0, "view.compoundDrawables");
        int r1 = a().getCompoundPaddingLeft();
        int r2 = a().getCompoundPaddingTop();
        int r3 = a().getWidth() - a().getCompoundPaddingRight();
        int r4 = a().getHeight() - a().getCompoundPaddingBottom();
        int r5 = RangesKt.coerceAtLeast(r3 - r1, 0);
        int r6 = RangesKt.coerceAtLeast(r4 - r2, 0);
        Drawable r7 = r0[0];
        if (r7 == null) goto L6;
        int r8 = a().getPaddingLeft();
        Drawable r9 = r0[0];
        Intrinsics.checkNotNullExpressionValue(r9, "drawables[0]");
        a(r7, r11, r8, ((r6 - b(r9)) / 2) + r2);
    L6:
        Drawable r10 = r0[1];
        if (r10 == null) goto L10;
        Drawable r12 = r0[1];
        Intrinsics.checkNotNullExpressionValue(r12, "drawables[1]");
        a(r10, r11, ((r5 - a(r12)) / 2) + r1, a().getPaddingTop());
    L10:
        Drawable r13 = r0[2];
        if (r13 == null) goto L14;
        int r14 = a().getWidth() - a().getPaddingRight();
        Drawable r15 = r0[2];
        Intrinsics.checkNotNullExpressionValue(r15, "drawables[2]");
        int r16 = r14 - a(r15);
        Drawable r17 = r0[2];
        Intrinsics.checkNotNullExpressionValue(r17, "drawables[2]");
        a(r13, r11, r16, r2 + ((r6 - b(r17)) / 2));
    L14:
        Drawable r18 = r0[3];
        if (r18 == null) goto L19;
        Drawable r19 = r0[3];
        Intrinsics.checkNotNullExpressionValue(r19, "drawables[3]");
        int r20 = r1 + ((r5 - a(r19)) / 2);
        int r21 = a().getHeight() - a().getPaddingBottom();
        Drawable r22 = r0[3];
        Intrinsics.checkNotNullExpressionValue(r22, "drawables[3]");
        a(r18, r11, r20, r21 - b(r22));
        return;
    }

    @Override // com.obric.oui.texteffects.a.b
    public void a(CharSequence r3, TextView.BufferType r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r4, "bufferType");
        a().setText(r5, r4);
    }

    @Override // com.obric.oui.texteffects.a.b
    public CharSequence b() {
        CharSequence r2 = a().getText();
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.texteffects.a.b
    public TextPaint c() {
        TextPaint r1 = a().getPaint();
        Intrinsics.checkNotNullExpressionValue(r1, "view.paint");
        return r1;
    }

    @Override // com.obric.oui.texteffects.a.b
    public Layout d() {
        return a().getLayout();
    }

    @Override // com.obric.oui.texteffects.a.b
    public int e() {
        return a().getWidth();
    }

    @Override // com.obric.oui.texteffects.a.b
    public int f() {
        return a().getHeight();
    }

    @Override // com.obric.oui.texteffects.a.b
    public int g() {
        return a().getBaseline();
    }

    @Override // com.obric.oui.texteffects.a.b
    public int h() {
        return a().getCurrentTextColor();
    }

    @Override // com.obric.oui.texteffects.a.b
    public float i() {
        return ZeusTransformUtils.getResources(a(), "com.obric.memorydata.plugin").getDisplayMetrics().density;
    }
}
