package com.larus.business.markdown.impl.markwon.custom.title;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.larus.business.markdown.api.FullScreenDetailType;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.TitleStyle;
import io.noties.markwon.core.CoreProps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lsc.m;
import psc.e;
import psc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MarkwonCustomTitleManager {
    public static final Lazy a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TitleStyle.values().length];
            r0[TitleStyle.LARGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TitleStyle.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = LazyKt.lazy(MarkwonCustomTitleManager$marginCodeLastButtonToEndAdjuster$2.INSTANCE);
    }

    public static com.larus.business.markdown.impl.markwon.custom.title.a a(TitleStyle r13) {
        if (r13 != null) goto L5;
        int r14 = -1;
    L6:
        if (r14 == (-1)) goto L16;
        if (r14 != 1) goto L10;
        int r1 = com.larus.business.markdown.impl.common.utils.d.a(9);
        int r5 = com.larus.business.markdown.impl.common.utils.d.a(7);
        return new com.larus.business.markdown.impl.markwon.custom.title.a(r1, 2131243911, 2131243912, com.larus.business.markdown.impl.common.utils.d.a(7), r5, com.larus.business.markdown.impl.common.utils.d.a(7), com.larus.business.markdown.impl.common.utils.d.a(7), com.larus.business.markdown.impl.common.utils.d.a(7), com.larus.business.markdown.impl.common.utils.d.a(7), com.larus.business.markdown.impl.common.utils.d.a(7), com.larus.business.markdown.impl.common.utils.d.a(7), com.larus.business.markdown.impl.common.utils.d.a(8));
    L10:
        if (r14 == 2) goto L16;
        throw new NoWhenBranchMatchedException();
    L16:
        return new com.larus.business.markdown.impl.markwon.custom.title.a(com.larus.business.markdown.impl.common.utils.d.a(6), 2131243910, null, 0, 0, com.larus.business.markdown.impl.common.utils.d.a(4), 0, 0, 0, 0, 0, com.larus.business.markdown.impl.common.utils.d.a(12));
    L5:
        r14 = a.a[r13.ordinal()];
        goto L6
    }

    public static void b(int r31, m r32, String r33, String r34, uvc.b r35, Context r36, lw8.d r37, boolean r38) {
        lw8.d r12 = r37;
        Intrinsics.checkNotNullParameter(r32, "visitor");
        Intrinsics.checkNotNullParameter(r34, "code");
        Intrinsics.checkNotNullParameter(r35, "node");
        Intrinsics.checkNotNullParameter(r36, "context");
        Intrinsics.checkNotNullParameter(r12, "customMarkDownInfo");
        if (Intrinsics.areEqual(r33, "STDOUT") == false) goto L5;
        return;
    L5:
        if (r34.length() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L204;
        r32.C(r35);
        int r9 = r32.length();
        if (r38 == false) goto L13;
    L16:
        boolean r8 = true;
    L17:
        CodeBlockConfig r4 = r12.v;
        if (r4 != null) goto L20;
    L22:
        boolean r5 = false;
    L24:
        if (r5 == true) goto L190;
        String r11 = " ";
        int r39 = r9;
    L150:
        int r0 = r32.length();
        CodeBlockConfig r1 = r12.v;
        if (r1 != null) goto L153;
    L155:
        boolean r2 = false;
    L156:
        if (r2 == false) goto L167;
        StringBuilder r6 = new StringBuilder();
        LinkedHashMap r10 = new LinkedHashMap();
        List r7 = StringsKt.split$default(r34, new String[]{"\n"}, false, 0, 6, null);
        Iterator r13 = r7.iterator();
        int r14 = 1;
    L159:
        if (r13.hasNext() == false) goto L166;
        String r15 = (String) r13.next();
        if (r15.length() <= 0) goto L163;
        boolean r16 = true;
    L164:
        if (r16 == false) goto L159;
        r6.append(r11);
        r10.put(Integer.valueOf(r6.length() - 1), Integer.valueOf(r14));
        r6.append(r15);
        r6.append("\n");
        r14 = r14 + 1;
        goto L159
    L163:
        r16 = false;
        goto L164
    L166:
        r32.r().c(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.d, Integer.valueOf(r7.size()));
        r32.r().c(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.e, r10);
        r32.builder().b(r32.B().b.a(r33, r6.toString()));
    L168:
        r32.a();
        r32.builder().a(160);
        r32.r().c(CoreProps.k, r33);
        r32.r().c(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.a, Integer.valueOf(r39));
        r32.r().c(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.b, Integer.valueOf(r32.length()));
        CodeBlockConfig r17 = r12.v;
        if (r17 == null) goto L173;
        Integer r18 = r17.getCodeContentSize();
        if (r18 == null) goto L173;
        int r19 = r18.intValue();
        r32.builder().setSpan(new AbsoluteSizeSpan(r19), r0, r32.length(), 17);
    L173:
        CodeBlockConfig r20 = r12.v;
        if (r20 != null) goto L176;
    L178:
        boolean r110 = false;
    L179:
        if (r110 == false) goto L181;
        ctc.a r21 = new ctc.a(0.0f);
        r32.r().c(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.c, r21);
        m r22 = r32;
        int r23 = r39;
        r22.o(r23, r21);
    L182:
        r22.G(r35, r23);
        r22.q(r35);
        return;
    L181:
        r22 = r32;
        r23 = r39;
        goto L182
    L176:
        if (r20.getEnableScroll() != true) goto L178;
        r110 = true;
        goto L179
    L167:
        r32.builder().b(r32.B().b.a(r33, r34));
        goto L168
    L153:
        if (r1.getEnableLineNumber() != true) goto L155;
        r2 = true;
        goto L156
    L190:
        CodeBlockConfig r24 = r12.v;     // Catch: Exception -> L146
        if (r24 != null) goto L28;
        boolean r111 = true;
    L31:
        if (r111 == false) goto L36;
        CodeBlockConfig r25 = r12.v;     // Catch: Exception -> L146
        if (r25 == null) goto L36;
        String r26 = r25.getCodeCopyTitle();     // Catch: Exception -> L146
        if (r26 == null) goto L36;
    L37:
        CodeBlockConfig r27 = r12.v;     // Catch: Exception -> L146
        if (r27 == null) goto L40;
        TitleStyle r28 = r27.getTitleStyle();     // Catch: Exception -> L146
    L41:
        com.larus.business.markdown.impl.markwon.custom.title.a r29 = a(r28);     // Catch: Exception -> L146
        SpannableStringBuilder r30 = new SpannableStringBuilder(r33 + "\r " + r26);     // Catch: Exception -> L146
        int r112 = r29.a;     // Catch: Exception -> L146
        CodeBlockConfig r40 = r12.v;     // Catch: Exception -> L146
        if (r40 == null) goto L44;
        int r41 = r40.getCodeTitleSize();     // Catch: Exception -> L146
    L45:
        int r113 = r41;
        int r114 = r29.f + r29.g;     // Catch: Exception -> L146
        if (r33 == null) goto L48;
        int r42 = r33.length();     // Catch: Exception -> L146
    L49:
        int r210 = r42 + 2;     // Catch: Exception -> L146
        int r211 = r210 + r26.length();     // Catch: Exception -> L146
        CodeBlockConfig r43 = r12.v;     // Catch: Exception -> L146
        if (r43 != null) goto L52;
    L54:
        boolean r44 = false;
    L55:
        if (r44 == false) goto L62;
        if (r33 == null) goto L59;
        boolean r45 = StringsKt.startsWith$default(r33, "html", false, 2, null);     // Catch: Exception -> L146
    L60:
        if (r45 == false) goto L63;
        boolean r46 = true;
    L64:
        if (r46 == true) goto L186;
        boolean r115 = r8;
        com.larus.business.markdown.impl.markwon.custom.title.a r47 = r29;
        String r212 = " ";
        r39 = r9;
        SpannableStringBuilder r116 = r30;
    L84:
        if (r111 == false) goto L98;
        int r48 = r47.b;     // Catch: Exception -> L96
        int r49 = r47.f;     // Catch: Exception -> L96
        int r50 = r47.g;     // Catch: Exception -> L96
        r11 = r212;
        r116.insert(r116.length(), r11);     // Catch: Exception -> L144
        int r117 = r116.length();     // Catch: Exception -> L144
        int r51 = r117 - 1;     // Catch: Exception -> L144
        Drawable r52 = ContextCompat.getDrawable(r36, r48);     // Catch: Exception -> L144
        if (r52 == null) goto L90;
        int r53 = r52.getIntrinsicWidth();     // Catch: Exception -> L144
    L91:
        int r118 = r114 + ((r53 + r49) + r50);     // Catch: Exception -> L144
        r116.setSpan(new e(r36, r48, r112, r49, r50, r115), r51, r117, 33);     // Catch: Exception -> L144
        if (r33 != null) goto L94;
        String r54 = "";
    L95:
        boolean r55 = r115;
        r116.setSpan(new psc.d(r54, r34, r55, false), r51, r117, 17);     // Catch: Exception -> L144
        r114 = r118;
    L99:
        Integer r56 = r47.c;     // Catch: Exception -> L144
        r12 = r37;
        CodeBlockConfig r57 = r12.v;     // Catch: Exception -> L142
        if (r57 != null) goto L104;
    L106:
        boolean r58 = false;
    L107:
        if (r58 == false) goto L118;
        if (r56 == null) goto L118;
        r116.insert(r116.length(), r11);     // Catch: Exception -> L142
        int r59 = r116.length();     // Catch: Exception -> L142
        int r60 = r59 - 1;     // Catch: Exception -> L142
        int r61 = r47.h;     // Catch: Exception -> L142
        int r62 = r47.i;     // Catch: Exception -> L142
        Context r119 = r36;
        Drawable r63 = ContextCompat.getDrawable(r119, r56.intValue());     // Catch: Exception -> L142
        if (r63 == null) goto L112;
        int r64 = r63.getIntrinsicWidth();     // Catch: Exception -> L142
    L113:
        int r120 = r114 + ((r64 + r61) + r62);     // Catch: Exception -> L142
        int r121 = 33;
        boolean r122 = r55;
        r116.setSpan(new e(r36, r56.intValue(), r112, r61, r62, r55), r60, r59, 33);     // Catch: Exception -> L142
        if (r33 != null) goto L116;
        String r65 = "";
    L117:
        r116.setSpan(new c(r65, r34, r34, FullScreenDetailType.CODE_BLOCK, r122), r60, r59, 17);     // Catch: Exception -> L142
        r114 = r120;
    L119:
        r116.insert(r116.length(), "\r\n");     // Catch: Exception -> L142
        r116.setSpan(new ForegroundColorSpan(ContextCompat.getColor(r119, 2131103684)), 0, r116.length(), 17);     // Catch: Exception -> L142
        r116.setSpan(new AbsoluteSizeSpan(r113, true), 0, r116.length(), 17);     // Catch: Exception -> L142
        int r66 = r47.l;     // Catch: Exception -> L142
        if (r33 == null) goto L122;
        int r67 = r33.length();     // Catch: Exception -> L142
    L123:
        int r68 = r67 + 1;     // Catch: Exception -> L142
        Pair[] r69 = new Pair[2];     // Catch: Exception -> L142
        if (r33 == null) goto L126;
        int r70 = r33.length();     // Catch: Exception -> L142
    L127:
        r69[0] = new Pair(0, Integer.valueOf(r70));     // Catch: Exception -> L142
        r69[1] = new Pair(Integer.valueOf(r210), Integer.valueOf(r211));     // Catch: Exception -> L142
        r116.setSpan(new g(r116, r31, CollectionsKt.listOf(r69), ((r32.B().a.q + r66) + r114) - ((Number) a.getValue()).intValue(), r112), r67, r68, r121);     // Catch: Exception -> L142
        int r71 = r116.length() - 2;     // Catch: Exception -> L142
        r116.setSpan(new psc.f(r66, r112), r71, r71 + 1, r121);     // Catch: Exception -> L142
        r32.builder().b(r116);     // Catch: Exception -> L142
        CodeBlockConfig r72 = r12.v;     // Catch: Exception -> L142
        if (r72 == null) goto L150;
        if (r72.getEnableTitleBottomLine() == false) goto L150;
        CodeBlockConfig r73 = r12.v;     // Catch: Exception -> L142
        if (r73 == null) goto L150;
        Integer r74 = r73.getTitleBottomLineColor();     // Catch: Exception -> L142
        if (r74 == null) goto L150;
        int r75 = r74.intValue();     // Catch: Exception -> L142
        SpannableStringBuilder r76 = new SpannableStringBuilder("\r\n");     // Catch: Exception -> L142
        r76.setSpan(new com.larus.business.markdown.impl.markwon.core.spans.codeblock.g(r119, r32.B().a.q, com.larus.business.markdown.impl.common.utils.d.a(1), r75), 0, r76.length(), 17);     // Catch: Exception -> L139
        r32.builder().b(r76);     // Catch: Exception -> L139
    L139:
        e = e;
    L148:
        e.getLocalizedMessage();
        goto L150
    L126:
        r70 = 0;
        goto L127
    L122:
        r67 = 0;
        goto L123
    L116:
        r65 = r33;
        goto L117
    L112:
        r64 = 0;
    L118:
        r119 = r36;
        r121 = 33;
        goto L119
    L104:
        if (r57.getEnableCodeFullScreenButton() != true) goto L106;
        r58 = true;
    L142:
        e = e;
        goto L148
    L94:
        r54 = r33;
        goto L95
    L90:
        r53 = 0;
    L144:
        e = e;
    L145:
        r12 = r37;
    L96:
        e = e;
        r11 = r212;
        goto L145
    L98:
        r55 = r115;
        r11 = r212;
        goto L99
    L186:
        int r77 = r29.d;     // Catch: Exception -> L81
        int r78 = r29.e;     // Catch: Exception -> L81
        r30.insert(r30.length(), " ");     // Catch: Exception -> L79
        int r79 = r30.length();     // Catch: Exception -> L79
        int r123 = r79 - 1;     // Catch: Exception -> L79
        Drawable r80 = ContextCompat.getDrawable(r36, 2131243921);     // Catch: Exception -> L79
        if (r80 == null) goto L70;
        int r81 = r80.getIntrinsicWidth();     // Catch: Exception -> L146
    L71:
        int r124 = r114 + ((r81 + r77) + r78);
        r47 = r29;
        r116 = r30;
        r212 = " ";
        r115 = r8;
        r39 = r9;
        r116.setSpan(new e(r36, 2131243921, r112, r77, r78, r115), r123, r79, 33);     // Catch: Exception -> L96
        if (r33 != null) goto L77;
        String r82 = "";
    L78:
        r116.setSpan(new c(r82, r34, r34, FullScreenDetailType.CODE_BLOCK, r115, true), r123, r79, 17);     // Catch: Exception -> L96
        r114 = r124;
        goto L84
    L77:
        r82 = r33;
        goto L78
    L70:
        r81 = 0;
    L79:
        e = e;
        r39 = r9;
        r12 = r37;
        r11 = " ";
    L81:
        e = e;
        r39 = r9;
        r12 = r37;
        r11 = " ";
    L63:
        r46 = false;
        goto L64
    L59:
        r45 = false;
        goto L60
    L62:
        r8 = r8;
        goto L63
    L52:
        if (r43.getEnablePreviewButton() != true) goto L54;
        r44 = true;
        goto L55
    L48:
        r42 = 0;
        goto L49
    L44:
        r41 = 0;
        goto L45
    L40:
        r28 = null;
    L36:
        r26 = "";
        goto L37
    L28:
        r111 = r24.getEnableCodeCopyButton();     // Catch: Exception -> L146
    L146:
        e = e;
        r11 = " ";
        r39 = r9;
        goto L148
    L20:
        if (r4.getEnableCodeHeader() != true) goto L22;
        r5 = true;
        goto L24
    L13:
        if (r35.e != null) goto L16;
        r8 = false;
        goto L17
    L204:
        return;
    L7:
        r3 = false;
        goto L8
    }
}
