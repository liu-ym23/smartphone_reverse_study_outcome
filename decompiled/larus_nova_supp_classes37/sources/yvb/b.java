package yvb;

import android.app.Application;
import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.RichTextInlineTagData;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.f;
import com.ss.android.lark.widget.span.PrefixInfo;
import com.ss.android.lark.widget.span.PrefixSpan;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final d a;
    public final HashMap<Integer, a> b;
    public final SpannableStringBuilder c;

    public b() {
        d r0 = d.f;
        Intrinsics.checkNotNullParameter(r0, "style");
        this.a = r0;
        this.b = new HashMap();
        this.c = new SpannableStringBuilder();
    }

    private final Application getContext() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp().getContext();
    }

    public final void a(String r22) {
        b r1 = this;
        Intrinsics.checkNotNullParameter(r22, "text");
        boolean r9 = r1.a.e;
        Intrinsics.checkNotNullParameter(r22, "text");
        r1.b.clear();
        r1.c.clear();
        List r2 = StringsKt.split$default(r22, new String[]{"\n"}, false, 0, 6, null);
        int r3 = r2.size();
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L141;
        Integer r11 = Integer.valueOf(r5);
        HashMap<Integer, a> r12 = r1.b;
        a r13 = new a((String) ListProtector.get(r2, r5), r1.a);
        int r0 = r13.a.length();
        String r7 = "";
        int r15 = 0;
        boolean r16 = false;
        int r17 = 0;
    L7:
        if (r15 >= r0) goto L66;
        char r4 = r13.a.charAt(r15);
        if (r4 != ' ') goto L41;
        if (r16 == true) goto L11;
        List r18 = r2;
        int r19 = r3;
        r9 = r9;
        r17 = r17 + 1;
    L65:
        r15 = r15 + 1;
        r2 = r18;
        r3 = r19;
        r9 = r9;
        goto L7
    L11:
        r13.d = (r17 / 4) + 1;
        if (new Regex("\\d+\\.").matches(r7) == false) goto L30;
        int r6 = r13.d;
        List<SpanInfo> r8 = r13.c;
        int r110 = e.a;
        int r10 = r13.b().length();
        String r14 = r13.b();
        r18 = r2;
        d r20 = r13.b;
        Intrinsics.checkNotNullParameter(r14, "text");
        r19 = r3;
        Intrinsics.checkNotNullParameter(r7, "prefix");
        Intrinsics.checkNotNullParameter(r20, "style");
        r20.getClass();
        if (r6 >= 1) goto L16;
    L19:
        d.b r21 = null;
    L20:
        PrefixSpan.b r23 = new PrefixSpan.b();
        r23.b = true;
        r23.c = UIHelper.dp2px(((r6 - 1) * 24.0f) + 2.0f);
        r23.f = UIHelper.dp2px(10.0f);
        r23.d = UIHelper.dp2px(14.0f);
        if (r21 == null) goto L25;
        Integer r24 = r21.c;
        if (r24 == null) goto L25;
    L27:
        int r25 = r24.intValue();
    L29:
        r23.h = r25;
        r23.a = PrefixSpan.Type.LIST_NUM;
        r23.g = r7;
        PrefixInfo r26 = new PrefixInfo(r23);
        ((SpanInfo) r26).type = 12;
        ((SpanInfo) r26).start = 0;
        ((SpanInfo) r26).end = r10;
        ((SpanInfo) r26).text = r14;
        ((ArrayList) r8).add(r26);
    L36:
        boolean r27 = true;
    L38:
        if (r27 == false) goto L67;
        int r28 = r15 + 1;
    L68:
        r13.a = r13.a.substring(r28);
    L69:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a r29 = new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a(r13.a);
        r13.e = r29;
        String r30 = r29.a;
        int r31 = 0;
        int r32 = 0;
    L71:
        if (r31 >= r30.length()) goto L120;
        char r33 = r30.charAt(r31);
        int r34 = r32 + 1;
        r29.d.put(Integer.valueOf(r32), new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C0053a(r33));
        if (r33 != '*') goto L119;
        int r35 = r32 - 1;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C0053a r36 = r29.d.get(Integer.valueOf(r35));
        if (r36 != null) goto L77;
    L79:
        boolean r111 = false;
    L80:
        if (r111 == false) goto L119;
        if (r36 != null) goto L83;
    L85:
        boolean r37 = false;
    L86:
        if (r37 == false) goto L119;
        boolean r38 = true;
        RichTextInlineTagData r39 = new RichTextInlineTagData(CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(r35), Integer.valueOf(r32)}), RichTextInlineTagData.Style.BOLD);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C0053a r40 = r29.d.get(Integer.valueOf(r35));
        if (r40 == null) goto L90;
        r40.c = true;
    L90:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C0053a r41 = r29.d.get(Integer.valueOf(r32));
        if (r41 == null) goto L93;
        r41.c = true;
    L93:
        int r42 = r29.c;
        if (r42 > 0) goto L96;
        r29.c = r42 + 1;
        ((ArrayList) r29.b).add(r39);
    L96:
        if ((((ArrayList) r29.b).isEmpty() ^ r38) == false) goto L119;
        List<RichTextInlineTagData> r43 = r29.b;
        RichTextInlineTagData r44 = (RichTextInlineTagData) ListProtector.remove(r43, CollectionsKt.getLastIndex(r43));
        if (r44.b == r39.b) goto L99;
        r38 = true;
        goto L96
    L99:
        Iterator<T> r45 = r44.a.iterator();
    L101:
        if (r45.hasNext() == false) goto L105;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C0053a r46 = r29.d.get(Integer.valueOf(((Number) r45.next()).intValue()));
        if (r46 == null) goto L101;
        r46.b = false;
        goto L101
    L105:
        Iterator<T> r47 = r39.a.iterator();
    L107:
        if (r47.hasNext() == false) goto L111;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C0053a r48 = r29.d.get(Integer.valueOf(((Number) r47.next()).intValue()));
        if (r48 == null) goto L107;
        r48.b = false;
        goto L107
    L111:
        int r49 = e.a;
        int r50 = ((Number) CollectionsKt.last(r44.a)).intValue() + 1;
        int r51 = ((Number) CollectionsKt.first(r39.a)).intValue();
        Intrinsics.checkNotNullParameter("", "text");
        TextStyleInfo r52 = new TextStyleInfo();
        ((SpanInfo) r52).type = 4;
        ((SpanInfo) r52).start = r50;
        ((SpanInfo) r52).end = r51;
        ((SpanInfo) r52).text = "";
        r52.isBold = true;
        if (r50 >= r51) goto L114;
        ((ArrayList) r29.g).add(r52);
    L115:
        r29.c--;
        goto L119
    L114:
        int r53 = bwb.b.a;
        bwb.b.h(MmUiLogScene.SUMMARY, "onFoundPairedBoldStyle", "onFoundPairedBoldStyle start " + ((SpanInfo) r52).start + " end " + ((SpanInfo) r52).end + " skip", null);
        goto L115
    L83:
        if (r36.c == true) goto L85;
        r37 = true;
        goto L86
    L77:
        if (r36.a != '*') goto L79;
        r111 = true;
    L119:
        r31 = r31 + 1;
        r32 = r34;
        goto L71
    L120:
        int r54 = r29.f.length();
        int r55 = r29.a.length();
        int r56 = 0;
    L121:
        if (r56 >= r55) goto L128;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a.C0053a r57 = r29.d.get(Integer.valueOf(r56));
        if (r57 == null) goto L127;
        if (r57.b == false) goto L127;
        r29.e.put(Integer.valueOf(r56), Integer.valueOf(r54));
        r29.f.append(r57.a);
        r54 = r54 + 1;
    L127:
        r56 = r56 + 1;
        goto L121
    L128:
        ArrayList r58 = new ArrayList();
        Iterator r59 = ((ArrayList) r29.g).iterator();
    L130:
        if (r59.hasNext() == false) goto L140;
        SpanInfo r60 = (SpanInfo) r59.next();
        int r61 = r60.end;
        int r62 = r60.start;
        int r63 = r61 - r62;
        Integer r64 = r29.e.get(Integer.valueOf(r62));
        if (r64 == null) goto L134;
        int r65 = r64.intValue();
    L135:
        r60.start = r65;
        int r66 = r63 + r65;
        r60.end = r66;
        r60.text = r29.f.substring(r65, r66);     // Catch: Exception -> L138
        r58.add(r60);     // Catch: Exception -> L138
    L138:
        e = move-exception;
        int r67 = bwb.b.a;
        bwb.b.d(MmUiLogScene.SUMMARY, "generateNewContent", "generateNewContent origin start " + r62 + " new start " + r60.start + " origin end " + r60.end + " text length " + r29.f.length() + ' ' + e, null);
        goto L130
    L134:
        r65 = r60.start;
        goto L135
    L140:
        r29.g = r58;
        ((ArrayList) r29.b).clear();
        r29.d.clear();
        r12.put(r11, r13);
        r5 = r5 + 1;
        r1 = this;
        r2 = r18;
        r3 = r19;
        r9 = r9;
    L67:
        r28 = 0;
    L25:
        r24 = r20.c;
        if (r24 != null) goto L27;
        LarkAppContext.Companion.getClass();
        r25 = UDColorUtils.getColor(LarkAppContext.access$getInstance$cp().getContext(), 2131106622);
        goto L29
    L16:
        if (r6 > 3) goto L19;
        r21 = r20.d.get(Integer.valueOf(r6));
        goto L20
    L30:
        r18 = r2;
        r19 = r3;
        r9 = r9;
        if (Intrinsics.areEqual("*", r7) == false) goto L34;
        r13.a(r13.d);
        goto L36
    L34:
        if (Intrinsics.areEqual("-", r7) == false) goto L37;
        r13.a(r13.d);
        goto L36
    L37:
        r27 = false;
        goto L38
    L41:
        r18 = r2;
        r19 = r3;
        r9 = r9;
        if (r4 != '*') goto L48;
        if (r16 == true) goto L69;
        String r68 = r7 + r4;
    L46:
        r7 = r68;
        r16 = true;
        goto L65
    L48:
        if (r4 != '-') goto L53;
        if (r16 == true) goto L69;
        r68 = r7 + r4;
        goto L46
    L53:
        if (r4 != '.') goto L57;
        if (r16 == false) goto L69;
        r7 = r7 + r4;
        goto L65
    L57:
        if ('0' <= r4) goto L59;
    L61:
        boolean r69 = false;
    L62:
        if (r69 == false) goto L69;
        r68 = r7 + r4;
        goto L46
    L59:
        if (r4 >= ':') goto L61;
        r69 = true;
        goto L62
    L66:
        r18 = r2;
        r19 = r3;
        r9 = r9;
        goto L67
    L141:
        boolean r210 = r9;
        com.ss.android.lark.widget.light.e.a r70 = new com.ss.android.lark.widget.light.e.a(getContext());
        r70.g = (int) UIHelper.sp2px(this.a.a);
        com.ss.android.lark.widget.light.e r71 = new com.ss.android.lark.widget.light.e(r70);
        int r72 = 0;
    L143:
        if (this.b.get(Integer.valueOf(r72)) == null) goto L205;
        a r73 = this.b.get(Integer.valueOf(r72));
        if (r73 == null) goto L204;
        List<SpanInfo> r74 = r73.c;
        if (r74 == null) goto L204;
        PrefixInfo r75 = (SpanInfo) CollectionsKt.firstOrNull(r74);
        if (r75 == null) goto L204;
        if ((r75 instanceof PrefixInfo) == false) goto L153;
        PrefixInfo r76 = r75;
    L154:
        if (r76 == null) goto L204;
        if (r76.prefixParams.getType() != PrefixSpan.Type.LIST_NUM) goto L204;
        int r77 = CastIntegerProtector.parseInt(StringsKt.dropLast(r76.prefixParams.g, 1));     // Catch: NumberFormatException -> L159
        PrefixInfo r78 = null;
    L161:
        PrefixSpan.b r79 = r76.prefixParams;
        StringBuilder r80 = new StringBuilder();
        r80.append((r72 - r72) + r77);
        r80.append('.');
        r79.g = r80.toString();
        c.a(r76.prefixParams);
        int r81 = r73.d;
        int r82 = r72;
    L162:
        int r83 = r82 + 1;
        a r84 = this.b.get(Integer.valueOf(r83));
        if (r84 == null) goto L176;
        List<SpanInfo> r85 = r84.c;
        if (r85 == null) goto L176;
        PrefixInfo r86 = (SpanInfo) CollectionsKt.firstOrNull(r85);
        if (r86 == null) goto L176;
        if ((r86 instanceof PrefixInfo) == false) goto L171;
        PrefixInfo r87 = r86;
    L172:
        if (r87 == null) goto L176;
        PrefixSpan.b r88 = r87.prefixParams;
        if (r88 == null) goto L176;
        PrefixInfo r89 = r88.getType();
    L178:
        if (r89 != PrefixSpan.Type.LIST_NUM) goto L202;
        a r90 = this.b.get(Integer.valueOf(r83));
        if (r90 != null) goto L182;
    L184:
        boolean r91 = false;
    L185:
        if (r91 == false) goto L202;
        a r92 = this.b.get(Integer.valueOf(r83));
        if (r92 == null) goto L201;
        List<SpanInfo> r93 = r92.c;
        if (r93 == null) goto L201;
        PrefixInfo r94 = (SpanInfo) CollectionsKt.firstOrNull(r93);
        if (r94 == null) goto L201;
        if ((r94 instanceof PrefixInfo) == false) goto L195;
        PrefixInfo r95 = r94;
    L196:
        if (r95 == null) goto L201;
        PrefixSpan.b r96 = r95.prefixParams;
        if (r96 == null) goto L201;
        StringBuilder r97 = new StringBuilder();
        r97.append((r83 - r72) + r77);
        r97.append('.');
        r96.g = r97.toString();
        c.a(r96);
        goto L201
    L195:
        r95 = r78;
    L201:
        r82 = r83;
        goto L162
    L182:
        if (r90.d != r81) goto L184;
        r91 = true;
    L202:
        r72 = r82;
        goto L204
    L171:
        r87 = r78;
    L176:
        r89 = r78;
    L159:
        e = move-exception;
        int r98 = bwb.b.a;
        r78 = null;
        bwb.b.b(MmUiLogScene.SUMMARY, "parseBlocks", "Integer.parseInt " + r76.prefixParams.g + " error " + e, null, 8);
        r77 = 1;
        goto L161
    L153:
        r76 = null;
    L204:
        r72 = r72 + 1;
        goto L143
    L205:
        int r99 = 0;
    L207:
        if (this.b.get(Integer.valueOf(r99)) == null) goto L233;
        a r100 = this.b.get(Integer.valueOf(r99));
        if (r100 == null) goto L232;
        if (r100.b().length() <= 0) goto L213;
        boolean r101 = true;
    L214:
        if (r101 == true) goto L218;
        if ((!((ArrayList) r100.c).isEmpty()) == false) goto L232;
    L218:
        if (r100.f == true) goto L224;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a r102 = r100.e;
        if (r102 == null) goto L223;
        ((ArrayList) r100.c).addAll(r102.g);
    L223:
        r100.f = true;
    L224:
        String r103 = r100.b();
        if (this.b.get(Integer.valueOf(r99 + 1)) == null) goto L230;
        String r104 = r103 + '\n';
        if (r210 == false) goto L229;
        r103 = r104 + '\n';
        goto L230
    L229:
        r103 = r104;
    L230:
        this.c.append(f.a.a.b(getContext(), r103, r100.c, r71));
        goto L232
    L213:
        r101 = false;
    L232:
        r99 = r99 + 1;
        goto L207
    }
}
