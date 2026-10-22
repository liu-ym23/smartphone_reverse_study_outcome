package com.ss.android.lark.contact.customized.common;

import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b() {
        Intrinsics.checkNotNullParameter("profile_add_friend", "currentPage");
        Intrinsics.checkNotNullParameter("click_button", "enterMethod");
        Intrinsics.checkNotNullParameter("contact", "functionType");
        Statistics.sendEvent("click_search_button", new JSONObject().put("current_page", "profile_add_friend").put("enter_method", "click_button").put("function_type", "contact"));
    }

    public static void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "currentPage");
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        Statistics.sendEvent("click_add_friend", new JSONObject().put("current_page", r2).put("enter_method", r3));
    }

    public static void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "currentPage");
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        Statistics.sendEvent("enter_page", new JSONObject().put("current_page", r2).put("enter_method", r3));
    }
}
