package io.noties.markwon.core.spans;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class j implements LineHeightSpan.WithDensity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f16470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f16471b;

    public j(float r1, float r2) {
        this.f16470a = r1;
        this.f16471b = r2;
    }

    public static boolean a(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L4:
        if (r1 >= r5.length()) goto L11;
        char r2 = r5.charAt(r1);
        if (Character.isWhitespace(r2) == true) goto L10;
        if (Character.isSpaceChar(r2) == true) goto L10;
        return false;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return true;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence r1, int r2, int r3, int r4, int r5, Paint.FontMetricsInt r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // android.text.style.LineHeightSpan.WithDensity
    public void chooseHeight(CharSequence r2, int r3, int r4, int r5, int r6, Paint.FontMetricsInt r7, TextPaint r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        Paint.FontMetricsInt r10 = r8.getFontMetricsInt();
        if ((r10.descent - r10.ascent) > 0) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r9, Spanned.class) == false) goto L16;
        ReplacementSpan[] r11 = (ReplacementSpan[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r9, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r3, r4, ReplacementSpan.class), ReplacementSpan[].class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L16;
        if (r11.length <= 0) goto L16;
        return;
    L16:
        if (a(r9.subSequence(r3, r4)) == false) goto L18;
        float r1 = this.f16470a;
    L19:
        r7.ascent = Math.round(r10.ascent * r1);
        r7.descent = Math.round(r10.descent * r1);
        r7.top = Math.round(r10.top * r1);
        r7.bottom = Math.round(r10.bottom * r1);
        return;
    L18:
        r1 = this.f16471b;
        goto L19
    }
}
