package io.noties.markwon.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class d extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f16394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f16395b;
    private final int c;
    private final boolean d;

    public d(io.noties.markwon.core.c r1, a r2, int r3, boolean r4) {
        this.f16394a = r1;
        this.f16395b = r2;
        this.c = r3;
        this.d = r4;
        if (TextUtils.isEmpty(r2.b()) == false) goto L8;
        if (r1.B == false) goto L8;
        r2.a(true);
    L8:
        if (r2.g() == true) goto L11;
        r2.j();
        return;
    }

    private static float a(int r0, int r1, Paint r2) {
        return (int) ((r0 + ((r1 - r0) / 2)) - (((r2.descent() + r2.ascent()) / 2.0f) + 0.5f));
    }

    public a a() {
        return this.f16395b;
    }

    public void a(float r1) {
    }

    public void a(Canvas r1) {
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r12, CharSequence r13, int r14, int r15, float r16, int r17, int r18, int r19, Paint r20) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        this.f16395b.a(io.noties.markwon.g.f.a(r12, r5), r20.getTextSize());
        a r7 = this.f16395b;
        if (r7.g() == false) goto L17;
        int r6 = r19 - r7.getBounds().bottom;
        a(Math.max(r7.f16391b - r16, 0.0f));
        int r8 = r12.save();
        int r9 = this.c;     // Catch: Throwable -> L14
        if (2 != r9) goto L10;
        int r2 = ((r19 - r17) - r7.getBounds().height()) / 2;     // Catch: Throwable -> L14
    L8:
        r6 = r6 - r2;     // Catch: Throwable -> L14
    L12:
        r12.translate(r16, r6);     // Catch: Throwable -> L14
        a(r12);     // Catch: Throwable -> L14
        r7.draw(r12);     // Catch: Throwable -> L14
        r12.restoreToCount(r8);
        return;
    L10:
        if (1 != r9) goto L12;
        r2 = r20.getFontMetricsInt().descent;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r12.restoreToCount(r8);
        throw th;
    L17:
        float r10 = a(r17, r19, r20);
        if (this.d == false) goto L20;
        this.f16394a.a(r20);
    L20:
        r12.drawText(r5, r14, r15, r16, r10, r20);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.f16395b.g() == false) goto L9;
        Rect r2 = this.f16395b.getBounds();
        if (r7 == null) goto L13;
        r7.ascent = -r2.bottom;
        r7.descent = 0;
        r7.top = r7.ascent;
        r7.bottom = 0;
    L13:
        return r2.width();
    L9:
        if (this.d == false) goto L12;
        this.f16394a.a(r3);
    L12:
        return (int) (r3.measureText(r8, r5, r6) + 0.5f);
    }
}
