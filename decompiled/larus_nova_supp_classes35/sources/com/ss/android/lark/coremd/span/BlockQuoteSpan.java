package com.ss.android.lark.coremd.span;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.BlockQuoteThemeData;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.utils.e;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\rH\u0016Jh\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010,\u001a\u00020-H\u0016J<\u0010.\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\rH\u0002J\u0010\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/ss/android/lark/coremd/span/BlockQuoteSpan;", "Landroid/text/style/LeadingMarginSpan;", "Landroid/text/style/LineHeightSpan;", "Landroid/text/style/ForegroundColorSpan;", "theme", "Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;", "context", "Landroid/content/Context;", "padding", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;Landroid/content/Context;I)V", "showTopPadding", BuildConfig.FLAVOR, "getShowTopPadding$core_md_release", "()Z", "setShowTopPadding$core_md_release", "(Z)V", "showBottomPadding", "getShowBottomPadding$core_md_release", "setShowBottomPadding$core_md_release", "paint", "Landroid/graphics/Paint;", "kotlin.jvm.PlatformType", "themeData", "Lcom/ss/android/lark/coremd/base/theme/BlockQuoteThemeData;", "quoteWidth", "quoteMargin", "getLeadingMargin", "first", "drawLeadingMargin", BuildConfig.FLAVOR, "c", "Landroid/graphics/Canvas;", "p", "x", "dir", "top", "baseline", "bottom", "text", BuildConfig.FLAVOR, "start", "end", "layout", "Landroid/text/Layout;", "chooseHeight", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "obtainTopPadding", "isFirst", "obtainBottomPadding", "isLast", "core-md_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockQuoteSpan extends ForegroundColorSpan implements LeadingMarginSpan, LineHeightSpan {
    public final Context a;
    public final int b;
    public boolean c;
    public boolean d;
    public final Paint e;
    public final BlockQuoteThemeData f;
    public final int g;
    public final int h;

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r2) {
        return this.g + this.h;
    }

    public BlockQuoteSpan(j r6, Context r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "theme");
        Intrinsics.checkNotNullParameter(r7, "context");
        k.a r0 = k.b;
        BlockQuoteThemeData r1 = r0.b(r6);
        c r2 = r1.i;
        KProperty<Object>[] r3 = BlockQuoteThemeData.j;
        super(UIUtils.getColor(r7, ((Number) r2.getValue(r1, r3[5])).intValue()));
        this.a = r7;
        this.b = r8;
        this.c = true;
        this.d = true;
        this.e = e.c;
        BlockQuoteThemeData r9 = r0.b(r6);
        this.f = r9;
        this.g = UIUtils.dp2px(r7, ((Number) r9.e.getValue(r9, r3[1])).intValue());
        this.h = UIUtils.dp2px(r7, ((Number) r9.h.getValue(r9, r3[4])).intValue());
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r3, int r4, int r5, int r6, int r7, Paint.FontMetricsInt r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.text.Spanned");
        Spanned r9 = (Spanned) r3;
        int r10 = r9.getSpanStart(this);
        int r11 = r9.getSpanEnd(this);
        boolean r0 = true;
        int r1 = 0;
        if (r10 != r4) goto L7;
        boolean r12 = true;
    L9:
        if (r11 != (r5 - 1)) goto L11;
    L14:
        int r13 = r8.descent;
        int r14 = r8.ascent;
        if ((r13 - r14) > 0) goto L18;
        return;
    L18:
        if (this.c == false) goto L21;
        if (r12 == false) goto L21;
        int r15 = this.b;
    L22:
        int r16 = r13 + r15;
        r8.descent = r16;
        if (this.d == false) goto L26;
        if (r0 == false) goto L26;
        r1 = this.b;
    L26:
        int r17 = r14 - r1;
        r8.ascent = r17;
        r8.top = r17;
        r8.bottom = r16;
        return;
    L21:
        r15 = 0;
        goto L22
    L11:
        if (r11 == r9.length()) goto L14;
        r0 = false;
        goto L14
    L7:
        r12 = false;
        goto L9
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r14, Paint r15, int r16, int r17, int r18, int r19, int r20, CharSequence r21, int r22, int r23, boolean r24, Layout r25) {
        Intrinsics.checkNotNullParameter(r14, "c");
        Intrinsics.checkNotNullParameter(r15, "p");
        Intrinsics.checkNotNullParameter(r21, "text");
        Intrinsics.checkNotNullParameter(r25, "layout");
        Spanned r3 = (Spanned) r21;
        int r5 = r3.getSpanStart(this);
        int r4 = r3.getSpanEnd(this);
        int r7 = 0;
        boolean r8 = true;
        if (r5 != r22) goto L5;
        boolean r6 = true;
    L6:
        if (r22 <= r4) goto L8;
    L10:
        r8 = false;
    L11:
        int r9 = this.g;
        this.e.set(r15);
        this.e.setStyle(Paint.Style.FILL);
        Paint r1 = this.e;
        Context r10 = this.a;
        BlockQuoteThemeData r11 = this.f;
        r1.setColor(UIUtils.getColor(r10, ((Number) r11.g.getValue(r11, BlockQuoteThemeData.j[3])).intValue()));
        float r2 = r16;
        float r12 = r18;
        if (this.c == false) goto L15;
        if (r6 == false) goto L15;
        int r13 = this.b;
    L16:
        float r26 = r12 + r13;
        float r27 = r16 + (r9 * r17);
        float r28 = r20;
        if (this.d == false) goto L20;
        if (r8 == false) goto L20;
        r7 = this.b;
    L20:
        r14.drawRect(r2, r26, r27, r28 - r7, this.e);
        return;
    L15:
        r13 = 0;
        goto L16
    L8:
        if (r4 > r23) goto L10;
    L5:
        r6 = false;
        goto L6
    }
}
