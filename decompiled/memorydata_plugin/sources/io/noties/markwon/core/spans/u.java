package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class u implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f16483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f16484b;
    private final Paint c;

    public u(io.noties.markwon.core.c r2) {
        this.f16484b = n.a();
        this.c = n.c();
        this.f16483a = r2;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r2, Paint r3, int r4, int r5, int r6, int r7, int r8, CharSequence r9, int r10, int r11, boolean r12, Layout r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        int r15 = r6 + ((r8 - r6) / 2);
        this.c.set(r3);
        this.f16483a.h(this.c);
        int r16 = (int) ((((int) (this.c.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
        if (r5 <= 0) goto L5;
        int r17 = r2.getWidth();
    L6:
        this.f16484b.set(r4, r15 - r16, r17, r15 + r16);
        r2.drawRect(this.f16484b, this.c);
        return;
    L5:
        r17 = r4;
        r4 = r4 - r2.getWidth();
        goto L6
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        return 0;
    }
}
