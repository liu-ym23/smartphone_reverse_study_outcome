package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.larus.business.markdown.api.model.UnorderedSymbol;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class d implements LeadingMarginSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f16460b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.larus.business.markdown.api.model.g f16461a;
    private io.noties.markwon.core.c c;
    private final Paint d;
    private final RectF e;
    private final Rect f;
    private int g;
    private boolean h;
    private final int i;
    private ListMarginInfo j;
    private int k;

    /* JADX INFO: renamed from: io.noties.markwon.core.spans.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16462a = null;

        static {
            int[] r0 = new int[UnorderedSymbol.values().length];
            f16462a = r0;
            r0[UnorderedSymbol.DISC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f16462a[UnorderedSymbol.CIRCLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f16462a[UnorderedSymbol.SQUARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        int r0 = Build.VERSION.SDK_INT;
        if (24 != r0) goto L5;
    L8:
        boolean r1 = true;
    L9:
        f16460b = r1;
        return;
    L5:
        if (25 == r0) goto L8;
        r1 = false;
        goto L9
    }

    public d(io.noties.markwon.core.c r3, ListMarginInfo r4, int r5, int r6, boolean r7) {
        this.d = n.c();
        this.e = n.b();
        this.f = n.a();
        this.g = 0;
        this.h = true;
        this.j = null;
        this.k = 0;
        this.f16461a = null;
        this.c = r3;
        this.j = r4;
        this.i = r5;
        this.g = r6;
        this.h = r7;
    }

    private void a(Canvas r2, int r3, int r4, int r5, int r6) {
        this.f.set(r3, r4, r5, r6);
        this.d.setStyle(Paint.Style.FILL);
        r2.drawRect(this.f, this.d);
    }

    private void a(boolean r2, Canvas r3, int r4, int r5, int r6, int r7) {
        this.e.set(r4, r5, r6, r7);
        if (r2 == false) goto L5;
        Paint.Style r8 = Paint.Style.FILL;
    L6:
        this.d.setStyle(r8);
        r3.drawOval(this.e, this.d);
        return;
    L5:
        r8 = Paint.Style.STROKE;
        goto L6
    }

    public void a(int r1) {
        this.k = r1;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r12, Paint r13, int r14, int r15, int r16, int r17, int r18, CharSequence r19, int r20, int r21, boolean r22, Layout r23) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r19, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.h == true) goto L5;
        return;
    L5:
        if (r22 == true) goto L7;
        return;
    L7:
        if (io.noties.markwon.g.d.a(r20, r3, this) == false) goto L61;
        this.d.set(r13);
        m[] r2 = (m[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r3, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r20, Math.min(r20 + 1, r21), m.class), m[].class, "com.obric.memorydata.plugin");
        if (r2.length <= 0) goto L12;
        this.d.setAlpha((int) (this.d.getAlpha() * (r2[0].a() / 255.0f)));
    L12:
        int r4 = this.k;
        if (r4 == 0) goto L15;
        io.noties.markwon.core.c r5 = io.noties.markwon.core.c.a(this.c).f(r4).a();
    L16:
        r5.a(this.d, false);
        int r6 = r12.save();
        ListMarginInfo r7 = this.j;     // Catch: Throwable -> L56
        if (r7 == null) goto L20;
        int r8 = r7.getListMargin();     // Catch: Throwable -> L56
    L21:
        int r9 = (int) ((this.d.descent() - this.d.ascent()) + 0.5f);     // Catch: Throwable -> L56
        ListMarginInfo r10 = this.j;     // Catch: Throwable -> L56
        if (r10 == null) goto L24;
        int r11 = r10.getDotDiameter();     // Catch: Throwable -> L56
    L25:
        int r24 = ((r8 - r11) / 2) + this.g;     // Catch: Throwable -> L56
        ListMarginInfo r25 = this.j;     // Catch: Throwable -> L56
        if (r25 == null) goto L29;
        r24 = r24 + r25.getBulletDotOffset();     // Catch: Throwable -> L56
    L29:
        if (f16460b == false) goto L34;
        if (r15 >= 0) goto L32;
        int r26 = r14 - (r23.getWidth() - (r8 * this.i));     // Catch: Throwable -> L56
    L33:
        int r27 = (r24 * r15) + r14;     // Catch: Throwable -> L56
        int r28 = (r15 * r11) + r27;     // Catch: Throwable -> L56
        int r29 = r26 * r15;     // Catch: Throwable -> L56
        int r30 = Math.min(r27, r28) + r29;     // Catch: Throwable -> L56
        int r31 = Math.max(r27, r28) + r29;     // Catch: Throwable -> L56
        int r32 = r30;
    L38:
        int r33 = (r17 + ((int) (((this.d.descent() + this.d.ascent()) / 2.0f) + 0.5f))) - (r11 / 2);     // Catch: Throwable -> L56
        int r34 = r11 + r33;     // Catch: Throwable -> L56
        com.larus.business.markdown.api.model.g r35 = this.f16461a;     // Catch: Throwable -> L56
        if (r35 == null) goto L49;
        int r36 = AnonymousClass1.f16462a[r35.a(this.i).ordinal()];     // Catch: Throwable -> L56
        if (r36 == 1) goto L48;
        if (r36 != 2) goto L44;
    L47:
        a(false, r12, r32, r33, r31, r34);     // Catch: Throwable -> L56
    L54:
        r12.restoreToCount(r6);
        return;
    L44:
        if (r36 != 3) goto L54;
    L46:
        a(r12, r32, r33, r31, r34);     // Catch: Throwable -> L56
    L48:
        a(true, r12, r32, r33, r31, r34);     // Catch: Throwable -> L56
        goto L54
    L49:
        int r37 = this.i;     // Catch: Throwable -> L56
        if (r37 == 0) goto L48;
        if (r37 != 1) goto L46;
    L32:
        r26 = (r8 * this.i) - r14;     // Catch: Throwable -> L56
        goto L33
    L34:
        if (r15 <= 0) goto L36;
        r32 = r14 + r24;     // Catch: Throwable -> L56
    L37:
        r31 = r32 + r11;     // Catch: Throwable -> L56
        goto L38
    L36:
        r32 = (r14 - r8) + r24;     // Catch: Throwable -> L56
        goto L37
    L24:
        r11 = this.c.a(r9);     // Catch: Throwable -> L56
        goto L25
    L20:
        r8 = this.c.a();     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        r12.restoreToCount(r6);
        throw th;
    L15:
        r5 = this.c;
        goto L16
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        ListMarginInfo r2 = this.j;
        if (r2 == null) goto L5;
        int r3 = r2.getListMargin();
    L7:
        return this.g + r3;
    L5:
        r3 = this.c.a();
        goto L7
    }
}
