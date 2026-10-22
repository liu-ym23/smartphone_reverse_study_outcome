package com.ss.android.lark.imageocr.utils;

import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "click");
        Intrinsics.checkNotNullParameter(r4, "target");
        Statistics.sendEvent("public_identity_select_accurate_character_click", new JSONObject().put("click", r3).put("target", r4));
    }

    public static void a(String r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "click");
        Intrinsics.checkNotNullParameter(r5, "target");
        Statistics.sendEvent("public_identity_select_content_click", new JSONObject().put("click", r3).put("has_select_content", r4).put("target", r5));
    }
}
