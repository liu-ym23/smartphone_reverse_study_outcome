package com.ss.android.lark.inline.ai;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final Map<String, Integer> a = null;
    public static final int b = 0;

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("CcmEditContinueOutlined", 2131254055), TuplesKt.to("MaybeOutlined", 2131255085), TuplesKt.to("TodoOutlined", 2131256017), TuplesKt.to("SlidesAnimationOutlined", 2131255763), TuplesKt.to("EffectsOutlined", 2131254291), TuplesKt.to("AddexpandOutlined", 2131253554), TuplesKt.to("AbbreviationOutlined", 2131253524), TuplesKt.to("EditDiscriptionOutlined", 2131254283), TuplesKt.to("NopictureFilled", 2131255225), TuplesKt.to("TranslateOutlined", 2131256049), TuplesKt.to("AdminMultistageOutlined", 2131253560), TuplesKt.to("EfficiencyOutlined", 2131254294), TuplesKt.to("CcmEditOutlined", 2131254056), TuplesKt.to("AddOutlined", 2131253548), TuplesKt.to("FileLinkFormOutlined", 2131254508), TuplesKt.to("TaskAddOutlined", 2131255963), TuplesKt.to("MoreOutlined", 2131255147), TuplesKt.to("HistoryOutlined", 2131254879), TuplesKt.to("DataSheetOutlined", 2131254184)});
        b = 2131254055;
    }

    public static int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "icon");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L14;
        Integer r3 = a.get(r2);
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
    L13:
        return kac.a.b(r4);
    L11:
        r4 = b;
        goto L13
    L14:
        return 0;
    L5:
        r0 = false;
        goto L6
    }
}
