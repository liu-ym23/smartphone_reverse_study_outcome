package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import com.google.gson.Gson;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y0 {
    public static final Pair<Integer, Integer> a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = r2.getTag();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Pair<kotlin.Int, kotlin.Int>");     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl((Pair) r3);     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r4) == false) goto L10;
        r4 = null;
    L10:
        Pair<Integer, Integer> r5 = (Pair) r4;
        if (r5 == null) goto L13;
        return r5;
    L13:
        return new Pair(0, 0);
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final String b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r2.getTag(2131388508) != null) goto L5;
        return null;
    L5:
        if ((r2.getTag(2131388508) instanceof String) == false) goto L10;
        Object r3 = r2.getTag(2131388508);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.String");
        return (String) r3;
    L10:
        return null;
    }

    public static final PromptContent.SuggestV2Extra c(String r3) {
    L6:
        e = move-exception;
        FLogger.a.e("WcbSugPromptCell", "getSuggestPromptExtra error >>> " + e);
        return null;
    L3:
        if (com.larus.utils.o0.d(r3) == false) goto L12;
        return (PromptContent.SuggestV2Extra) new Gson().fromJson(r3, PromptContent.SuggestV2Extra.class);
    L12:
        return null;
    }

    public static final String d(PromptContent.SuggestV2 r2) {
        if (r2 == null) goto L7;
        PromptContent.SuggestV2Extra r1 = r2.getSuggestV2Extra();
        if (r1 == null) goto L7;
        String r3 = r1.getDeepResearchId();
    L9:
        if (com.larus.utils.o0.d(r3) == false) goto L11;
        return "deep_research";
    L11:
        if (r2 == null) goto L15;
        PromptContent.SuggestV2Extra r4 = r2.getSuggestV2Extra();
        if (r4 == null) goto L15;
        String r5 = r4.getNeedDeepThink();
    L17:
        if (Intrinsics.areEqual(r5, "1") == false) goto L21;
        return "deep_think";
    L21:
        return null;
    L15:
        r5 = null;
    L7:
        r3 = null;
        goto L9
    }

    public static final String e(String r4) {
        String r5 = r4.toLowerCase(Locale.ROOT);
        if (r5 != null) goto L6;
        return null;
    L6:
        if (StringsKt.contains$default(r5, "text2image", false, 2, null) == false) goto L9;
    L10:
        String r6 = "pic";
    L18:
        return r6;
    L9:
        if (StringsKt.contains$default(r5, "image2image", false, 2, null) == true) goto L10;
        if (StringsKt.contains$default(r5, "text2video", false, 2, null) == false) goto L16;
    L17:
        r6 = "video";
        goto L18
    L16:
        if (StringsKt.contains$default(r5, "image2video", false, 2, null) == true) goto L17;
        return null;
    }
}
