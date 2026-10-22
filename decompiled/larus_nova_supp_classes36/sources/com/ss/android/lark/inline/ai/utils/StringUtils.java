package com.ss.android.lark.inline.ai.utils;

import androidx.core.content.ContextCompat;
import com.larksuite.framework.utils.l0;
import com.ss.android.lark.inline.ai.api.InlineAIErrorCode;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class StringUtils {
    public static final StringUtils a = null;
    public static final String b = null;

    public StringUtils() {
    }

    static {
        a = new StringUtils();
        b = "<span style='color: #" + Integer.toHexString(ContextCompat.getColor(LarkContext.getApplication(), 2131102121)).substring(2).toUpperCase(Locale.ROOT) + "'>";
    }

    public static String a() {
        return ((xzb.a) ApiUtils.getApi(xzb.a.class)).getUserId() + "-" + l0.a().toString();
    }

    public static String b(int r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl((nsb.b) LarkContext.spiByDwarf(nsb.b.class));     // Catch: Throwable -> L4
    L6:
        String r2 = null;
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        nsb.b r3 = (nsb.b) r1;
        if (r3 == null) goto L14;
        i1<String> r5 = r3.a();
        if (r5 == null) goto L14;
        r2 = (String) r5.getValue();
    L14:
        if (r3 == null) goto L19;
        i1<com.ss.android.lark.myai.export.c> r6 = r3.W();
        if (r6 == null) goto L19;
        com.ss.android.lark.myai.export.c r7 = (com.ss.android.lark.myai.export.c) r6.getValue();
    L19:
        if (r2 != null) goto L22;
        r2 = "AiNickname";
    L22:
        if (r4 != InlineAIErrorCode.INLINEAI_ADMINDEACTIVATED_CODE.getValue()) goto L25;
        String r8 = UIHelper.mustacheFormat(UIHelper.getString(2131889148), "aiName", r2);
        Intrinsics.checkNotNull(r8);
        return r8;
    L25:
        if (r4 != InlineAIErrorCode.InlineAI_CROSS_REGION_ERROR.getValue()) goto L28;
        String r9 = UIHelper.mustacheFormat(UIHelper.getString(2131889147), "aiName", r2);
        Intrinsics.checkNotNull(r9);
        return r9;
    L28:
        if (r4 != InlineAIErrorCode.InlineAI_CROSS_BRAND_ERROR.getValue()) goto L30;
        String r10 = UIHelper.mustacheFormat(UIHelper.getString(2131889146), "aiName", r2);
        Intrinsics.checkNotNull(r10);
        return r10;
    L30:
        String r11 = UIHelper.mustacheFormat(2131889153, "AiNickname", r2);
        Intrinsics.checkNotNull(r11);
        return r11;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static String d(int r1) {
        return LarkContext.getApplication().getString(r1);
    }

    public static String c(String r7, String r8) {
        if (r7 == null) goto L30;
        if (r8 == null) goto L30;
        Regex r0 = new Regex(r8);
        int r9 = 0;
        List r1 = SequencesKt.toList(SequencesKt.map(Regex.findAll$default(r0, r7, 0, 2, null), StringUtils$highlightAsHtml$indexes$1.INSTANCE));
        ArrayList r2 = new ArrayList();
        IntRange r3 = IntRange.Companion.getEMPTY();
        Iterator r4 = r1.iterator();
    L7:
        if (r4.hasNext() == false) goto L16;
        IntRange r5 = (IntRange) r4.next();
        IntRange.Companion r6 = IntRange.Companion;
        if (Intrinsics.areEqual(r3, r6.getEMPTY()) == true) goto L10;
        if (r5.getFirst() <= r3.getLast()) goto L13;
        r2.add(r3);
        r3 = r6.getEMPTY();
        goto L7
    L13:
        r3 = new IntRange(r3.getFirst(), r5.getLast());
        goto L7
    L10:
        r3 = r5;
        goto L7
    L16:
        if (Intrinsics.areEqual(r3, IntRange.Companion.getEMPTY()) == true) goto L18;
        r2.add(r3);
    L18:
        StringBuilder r10 = new StringBuilder();
        Iterator r11 = r2.iterator();
    L20:
        if (r11.hasNext() == false) goto L26;
        IntRange r12 = (IntRange) r11.next();
        if (r9 >= r12.getFirst()) goto L24;
        r10.append(r7.substring(r9, r12.getFirst()));
    L24:
        r10.append(b);
        r10.append(StringsKt.substring(r7, r12));
        r10.append("</span>");
        r9 = r12.getLast() + 1;
        goto L20
    L26:
        if (r9 >= r7.length()) goto L29;
        r10.append(r7.substring(r9, r7.length()));
    L29:
        return r10.toString();
    L30:
        if (r7 != null) goto L45;
        return "";
    L45:
        return r7;
    }
}
