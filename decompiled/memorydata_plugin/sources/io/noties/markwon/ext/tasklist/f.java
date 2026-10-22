package io.noties.markwon.ext.tasklist;

import android.R;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class f implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f16538a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f16539b = null;
    private final io.noties.markwon.core.c c;
    private final Drawable d;
    private boolean e;

    static {
        f16538a = new int[]{R.attr.state_checked};
        f16539b = new int[0];
    }

    public f(io.noties.markwon.core.c r1, Drawable r2, boolean r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r2, Paint r3, int r4, int r5, int r6, int r7, int r8, CharSequence r9, int r10, int r11, boolean r12, Layout r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 == true) goto L5;
        return;
    L5:
        if (io.noties.markwon.g.d.a(r10, r14, this) == false) goto L28;
        float r15 = r3.descent();
        float r16 = r3.ascent();
        int r17 = r2.save();
        int r18 = this.c.a();     // Catch: Throwable -> L22
        int r19 = (int) ((r15 - r16) + 0.5f);     // Catch: Throwable -> L22
        int r110 = (int) ((r18 * 0.75f) + 0.5f);     // Catch: Throwable -> L22
        int r111 = (int) ((r19 * 0.75f) + 0.5f);     // Catch: Throwable -> L22
        this.d.setBounds(0, 0, r110, r111);     // Catch: Throwable -> L22
        if (this.d.isStateful() == true) goto L11;
    L15:
        int r20 = r18 - r110;     // Catch: Throwable -> L22
        if (r5 <= 0) goto L18;
        int r21 = r4 + (r20 / 2);     // Catch: Throwable -> L22
    L19:
        r2.translate(r21, ((int) ((r7 + r16) + 0.5f)) + ((r19 - r111) / 2));     // Catch: Throwable -> L22
        this.d.draw(r2);     // Catch: Throwable -> L22
        r2.restoreToCount(r17);
        return;
    L18:
        r21 = (r4 - (r20 / 2)) - r110;     // Catch: Throwable -> L22
        goto L19
    L11:
        if (this.e == false) goto L13;
        int[] r112 = f16538a;     // Catch: Throwable -> L22
    L14:
        this.d.setState(r112);     // Catch: Throwable -> L22
        goto L15
    L13:
        r112 = f16539b;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r2.restoreToCount(r17);
        throw th;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        return this.c.a();
    }
}
