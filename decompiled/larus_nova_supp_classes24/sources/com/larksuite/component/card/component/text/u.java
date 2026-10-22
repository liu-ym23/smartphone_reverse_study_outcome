package com.larksuite.component.card.component.text;

import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.light.span.NoPreviewPlaceHolderSpan;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import com.ss.android.lark.widget.span.v;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u {
    public final b a;
    public final int b;
    public final f c;
    public Layout d;
    public int e;
    public boolean f;
    public int g;

    public static final class a {
    }

    static {
    }

    public u(b r27, int r29) {
        Intrinsics.checkNotNullParameter(r27, "renderEntity");
        this.a = r27;
        this.b = r29;
        f r3 = new f(r27, r29, UIHelper.dp2px(2.0f));
        this.c = r3;
        d r2 = r27.a.b;
        float r11 = (r27.d - r2.j) - r2.i;
        float r12 = r11 - UIHelper.dp2px(2.0f);
        r3.d = false;
        CharSequence r0 = r3.a.a.a;
        if (r0.length() != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L193;
        d r8 = r3.a.a.b;
        if (r8.b == Integer.MAX_VALUE) goto L12;
    L17:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L21;
    L36:
        CharSequence r9 = r0;
        if ((r9 instanceof ncc.g) == false) goto L166;
        SpannableStringBuilder r6 = (SpannableStringBuilder) r9;
        qcc.a[] r1 = (qcc.a[]) r6.getSpans(0, r6.length(), qcc.a.class);
        if (r1 != null) goto L41;
    L49:
        com.ss.android.lark.widget.light.span.m[] r7 = (com.ss.android.lark.widget.light.span.m[]) r6.getSpans(0, r6.length(), com.ss.android.lark.widget.light.span.m.class);
        if (r7 != null) goto L52;
    L60:
        com.ss.android.lark.widget.light.span.k[] r10 = (com.ss.android.lark.widget.light.span.k[]) r6.getSpans(0, r6.length(), com.ss.android.lark.widget.light.span.k.class);
        if (r10 != null) goto L63;
    L69:
        boolean r13 = true;
    L70:
        if (r13 == true) goto L75;
        Iterator r14 = ArrayIteratorKt.iterator(r10);
    L73:
        if (r14.hasNext() == false) goto L75;
        ((com.ss.android.lark.widget.light.span.k) r14.next()).b((int) r12);
    L75:
        v[] r15 = (v[]) r6.getSpans(0, r6.length(), v.class);
        if (r15 != null) goto L78;
    L84:
        boolean r16 = true;
    L85:
        if (r16 == true) goto L92;
        Iterator r17 = ArrayIteratorKt.iterator(r15);
    L88:
        if (r17.hasNext() == false) goto L92;
        v r19 = (v) r17.next();
        float r20 = r19.i / r19.j;
        int r110 = (int) (RangesKt.coerceAtMost(UIHelper.getWindowWidth(LarkContext.getApplication()), r12) - r19.y);
        r19.i = r110;
        int r21 = (int) (r110 / r20);
        r19.j = r21;
        r19.k = r110;
        r19.l = r21;
        r19.w = false;
        Drawable r22 = r19.getDrawable();
        if (r22 == null) goto L88;
        r22.setBounds(0, 0, r19.k, r19.l);
    L92:
        com.ss.android.lark.widget.light.span.j[] r23 = (com.ss.android.lark.widget.light.span.j[]) r6.getSpans(0, r6.length(), com.ss.android.lark.widget.light.span.j.class);
        Intrinsics.checkNotNull(r23);
        int r24 = r23.length;
        int r25 = 0;
    L93:
        if (r25 >= r24) goto L103;
        com.ss.android.lark.widget.light.span.j r111 = r23[r25];
        com.ss.android.lark.widget.light.span.j.a r112 = r111.c();
        if (r112 == null) goto L102;
        float r26 = ((Number) r112.a.getFirst()).intValue() / ((Number) r112.a.getSecond()).floatValue();
        float r113 = RangesKt.coerceAtMost(UIHelper.getWindowWidth(LarkContext.getApplication()), r12);
        NoPreviewPlaceHolderSpan.c r114 = r112.b;
        if (r114 == null) goto L100;
        int r115 = r114.a;
    L101:
        float r116 = r113 - r115;
        r111.d((int) r116, (int) (r116 / r26));
        goto L102
    L100:
        r115 = 0;
    L102:
        r25 = r25 + 1;
        goto L93
    L103:
        ncc.h[] r30 = (ncc.h[]) r6.getSpans(0, r6.length(), ncc.h.class);
        if (r30 == null) goto L166;
        if (r30.length != 0) goto L108;
        boolean r117 = true;
    L110:
        if ((!r117) == false) goto L166;
        int r31 = r30.length;
        int r32 = 0;
    L112:
        if (r32 >= r31) goto L166;
        TextStyleInfo r118 = r30[r32].a;
        if (r118 == null) goto L164;
        int r33 = r118.maxLines;
        if (r33 == Integer.MAX_VALUE) goto L164;
        if (r33 == 0) goto L164;
        int r34 = r6.length();
        int r119 = ((SpanInfo) r118).end;
        if (r34 >= r119) goto L124;
        Log.w("UniversalCardTextRender", "span length < text style length");
        if (((SpanInfo) r118).start < r6.length()) goto L123;
        Log.e("UniversalCardTextRender", "subSequence  error1 " + ((SpanInfo) r118).start + ' ' + r6.length());
    L127:
        CharSequence r120 = r6;
    L130:
        Intrinsics.checkNotNull(r120);
        float r35 = r8.h;
        boolean r121 = r8.m;
        ncc.h[] r122 = r30;
        TextLayoutBuilder r36 = new TextLayoutBuilder();     // Catch: NegativeArraySizeException -> L144
        r36.h(r120);     // Catch: NegativeArraySizeException -> L144
        int r123 = r31;
        r36.j(r118.textSize);     // Catch: NegativeArraySizeException -> L136
        r36.e(r118.maxLines);     // Catch: NegativeArraySizeException -> L136
        r36.d(TextUtils.TruncateAt.END);     // Catch: NegativeArraySizeException -> L136
        r36.k(r35);     // Catch: NegativeArraySizeException -> L136
        r36.f((int) r12);     // Catch: NegativeArraySizeException -> L136
        r36.c(Layout.Alignment.ALIGN_NORMAL);     // Catch: NegativeArraySizeException -> L136
        r36.f = false;     // Catch: NegativeArraySizeException -> L136
        int r37 = h18.e.a;     // Catch: NegativeArraySizeException -> L136
        r36.m(h18.e.a(LarkContext.getApplication()));     // Catch: NegativeArraySizeException -> L136
        TextLayoutBuilder.a r38 = r36.c;     // Catch: NegativeArraySizeException -> L136
        if (r38.h == r121) goto L138;
        r38.h = r121;     // Catch: NegativeArraySizeException -> L136
        r36.d = null;     // Catch: NegativeArraySizeException -> L136
    L138:
        r38.c = r3.c;     // Catch: NegativeArraySizeException -> L136
        if (r3.b <= 0) goto L141;
        boolean r39 = true;
    L142:
        r36.g(r39);     // Catch: NegativeArraySizeException -> L136
        Layout r40 = r36.a();     // Catch: NegativeArraySizeException -> L136
    L147:
        if (r40 != null) goto L149;
    L160:
        TextPaint r41 = lcc.a.a;
        CharSequence r42 = lcc.a.a.a(r120, r118.maxLines * r12, r118.textSize, r8.g);
    L162:
        if (((SpanInfo) r118).end >= r6.length()) goto L165;
        r6.replace(((SpanInfo) r118).start, ((SpanInfo) r118).end, r42);
    L165:
        r32 = r32 + 1;
        r30 = r122;
        r31 = r123;
        goto L112
    L149:
        if ((r40.getText() instanceof Spanned) == false) goto L160;
        CharSequence r43 = r40.getText();
        int r44 = r40.getLineCount();
        int r124 = r118.maxLines;
        if (r44 != r124) goto L158;
        int r45 = r40.getLineEnd(r124 - 1);
        if (r43.length() <= r45) goto L157;
        if (r45 > 0) goto L156;
        Log.e("UniversalCardTextRender", "subSequence size error3 " + r45);
        SpannableString r46 = new SpannableString(r43);
    L159:
        TextUtils.copySpansFrom((Spanned) r43, 0, r46.length(), Object.class, r46, 0);
        r42 = r46;
        goto L162
    L156:
        r46 = new SpannableString(r43.subSequence(0, r45));
        goto L159
    L157:
        r46 = new SpannableString(r43);
        goto L159
    L158:
        r46 = new SpannableString(r43);
        goto L159
    L141:
        r39 = false;
    L136:
        e = e;
    L146:
        Log.e("UniversalCardTextRender", "getTextStylePreLayout build Layout exception", e);
        Log.i("UniversalCardTextRender", "span length: " + r120.length() + "maxLine:" + r118.maxLines);
        r40 = null;
    L144:
        e = e;
        r123 = r31;
        goto L146
    L123:
        CharSequence r47 = r6.subSequence(((SpanInfo) r118).start, r6.length());
    L129:
        r120 = r47;
        goto L130
    L124:
        int r48 = ((SpanInfo) r118).start;
        if (r48 <= r119) goto L128;
        Log.e("UniversalCardTextRender", "subSequence  error2 " + ((SpanInfo) r118).start + ' ' + ((SpanInfo) r118).end);
        goto L127
    L128:
        r47 = r6.subSequence(r48, r119);
    L164:
        r122 = r30;
        r123 = r31;
        goto L165
    L108:
        r117 = false;
        goto L110
    L78:
        if (r15.length != 0) goto L80;
        boolean r49 = true;
    L81:
        if (r49 == true) goto L84;
        r16 = false;
        goto L85
    L80:
        r49 = false;
        goto L81
    L63:
        if (r10.length != 0) goto L65;
        boolean r50 = true;
    L66:
        if (r50 == true) goto L69;
        r13 = false;
        goto L70
    L65:
        r50 = false;
        goto L66
    L52:
        if (r7.length != 0) goto L54;
        boolean r51 = true;
    L56:
        if ((!r51) == false) goto L60;
        int r52 = r7.length;
        int r53 = 0;
    L58:
        if (r53 >= r52) goto L60;
        r7[r53].s = r12;
        r53 = r53 + 1;
        goto L58
    L54:
        r51 = false;
        goto L56
    L41:
        if (r1.length != 0) goto L43;
        boolean r54 = true;
    L45:
        if ((!r54) == false) goto L49;
        int r55 = r1.length;
        int r125 = 0;
    L47:
        if (r125 >= r55) goto L49;
        qcc.a r126 = r1[r125];
        r126.s = r12 - r126.t;
        r125 = r125 + 1;
        goto L47
    L43:
        r54 = false;
    L166:
        int r56 = r8.b;
        if (r56 == Integer.MAX_VALUE) goto L169;
    L174:
        boolean r57 = true;
    L175:
        if (r57 == false) goto L225;
        if (r56 == Integer.MAX_VALUE) goto L179;
    L182:
        if (r56 <= 0) goto L225;
        if (r56 > 0) goto L186;
        Log.d("UniversalCardTextEllipsizer", "doEllipsize lines is 0");
        goto L225
    L186:
        CharSequence r127 = r9;
        Layout r59 = r3.a(r9, r8, r12, r12, r56);
        if (r59 == null) goto L189;
        CharSequence r60 = r59.getText();
    L191:
        if ((r60 instanceof Spanned) == true) goto L195;
        Log.e("UniversalCardTextEllipsizer", "doEllipsize text is not Spanned");
        TextPaint r61 = lcc.a.a;
        r0 = lcc.a.a.a(r127, r56 * r12, r8.d, r8.g);
        goto L193
    L195:
        if (r59.getLineCount() >= r56) goto L198;
        Log.d("UniversalCardTextEllipsizer", "doEllipsize lineCount less than lines");
    L226:
        CharSequence r62 = r127;
    L227:
        this.f = this.c.d;
        TextLayoutBuilder r63 = new TextLayoutBuilder();
        r63.h(r62);
        r63.j(r2.d);
        int r64 = r2.e;
        if (r64 != 0) goto L231;
        r64 = UIHelper.getColor(2131106622);
    L231:
        r63.i(r64);
        r63.e(r2.a);
        r63.k(r2.h);
        r63.f((int) r11);
        boolean r65 = r2.c;
        TextLayoutBuilder.a r66 = r63.c;
        if (r66.m == r65) goto L234;
        r66.m = r65;
        r63.d = null;
    L234:
        r63.c(r2.f);
        r63.f = false;
        int r67 = h18.e.a;
        r63.m(h18.e.a(LarkContext.getApplication()));
        boolean r68 = r2.m;
        TextLayoutBuilder.a r69 = r63.c;
        if (r69.h == r68) goto L237;
        r69.h = r68;
        r63.d = null;
    L237:
        r63.c.c = UIHelper.dp2px(2.0f);
        if (this.b <= 0) goto L240;
        boolean r128 = true;
    L241:
        r63.g(r128);
        this.d = r63.a();
        this.g = (int) ((r2.h / 2) + 0.5f);
        this.e = -1;
        return;
    L240:
        r128 = false;
        goto L241
    L198:
        int r70 = r56 - 1;
        if (r59.getEllipsisCount(r70) != 0) goto L201;
        Log.d("UniversalCardTextEllipsizer", "doEllipsize lineCount equals to lines, but no need to ellipsize");
        goto L226
    L201:
        CharSequence r71 = r59.getText();
        if ((r71 instanceof Spanned) == false) goto L204;
        Spanned r72 = (Spanned) r71;
    L205:
        if (r72 == null) goto L212;
        LeadingMarginSpan[] r73 = (LeadingMarginSpan[]) r72.getSpans(r59.getLineStart(r70), r59.getLineEnd(r70), LeadingMarginSpan.class);
        if (r73 == null) goto L212;
        int r74 = r73.length;
        int r75 = 0;
        int r76 = 0;
    L209:
        if (r75 >= r74) goto L211;
        r76 = r76 + r73[r75].getLeadingMargin(true);
        r75 = r75 + 1;
        r59 = r59;
        goto L209
    L211:
        Layout r129 = r59;
    L213:
        if (r76 <= 0) goto L217;
        Layout r77 = r3.a(r127, r8, r12, RangesKt.coerceAtLeast(r12 - r76, 0.0f), r56);
        if (r77 == null) goto L226;
    L218:
        int r79 = r77.getLineStart(r70) + r77.getEllipsisStart(r70);
        if (idb.f.a().isEnable("universalcard.text.ellipsize.empty_line.fix.android") == false) goto L222;
        if (r79 >= 0) goto L224;
        Log.e("UniversalCardTextEllipsizer", "doEllipsize end is 0. lines is " + r56 + ", span length is " + r127.length() + ", layoutLineCount is " + r77.getLineCount());
    L224:
        r62 = new SpannableStringBuilder().append(StringsKt.subSequence(r77.getText(), RangesKt.until(0, r79))).append("…");
        r3.d = true;
        Intrinsics.checkNotNull(r62);
        goto L227
    L222:
        if (r79 > 0) goto L224;
        Log.e("UniversalCardTextEllipsizer", "doEllipsize end is 0. lines is " + r56 + ", span length is " + r127.length() + ", layoutLineCount is " + r77.getLineCount());
        goto L226
    L217:
        r77 = r129;
    L212:
        r129 = r59;
        r76 = 0;
        goto L213
    L204:
        r72 = null;
        goto L205
    L189:
        r60 = null;
        goto L191
    L179:
        if (r8.c == false) goto L181;
        r56 = 1;
        goto L182
    L181:
        r56 = r8.a;
    L225:
        r127 = r9;
        goto L226
    L169:
        if (r8.c == true) goto L174;
        if (r8.a != Integer.MAX_VALUE) goto L174;
        r57 = false;
        goto L175
    L21:
        if (StringsKt.last(r0) != ' ') goto L36;
        int r80 = r0.length() - 1;
        if (r80 < 0) goto L34;
    L25:
        int r81 = r80 - 1;
        if (r0.charAt(r80) != ' ') goto L28;
        boolean r82 = true;
    L29:
        if (r82 == false) goto L30;
        if (r81 < 0) goto L34;
        r80 = r81;
        goto L25
    L30:
        CharSequence r83 = r0.subSequence(0, r80 + 1);
    L35:
        r0 = new SpannableStringBuilder().append(r83).append(StringsKt.repeat(" ", r0.length() - r83.length()));
        goto L36
    L28:
        r82 = false;
    L34:
        r83 = "";
        goto L35
    L12:
        if (r8.c == true) goto L17;
        if (r8.a != Integer.MAX_VALUE) goto L17;
        r5 = false;
    L193:
        r62 = r0;
        goto L227
    L5:
        r4 = false;
        goto L7
    }
}
