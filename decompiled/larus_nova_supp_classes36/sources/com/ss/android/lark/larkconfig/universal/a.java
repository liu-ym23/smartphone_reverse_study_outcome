package com.ss.android.lark.larkconfig.universal;

import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final a a = null;
    public static final Map<String, UniversalUserSetting> b = null;

    public a() {
    }

    static {
        a = new a();
        b = new LinkedHashMap();
    }

    public static void a(String r1, UniversalUserSetting r2) {
        Intrinsics.checkNotNullParameter(r1, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r2, "data");
        b.put(r1, r2);
    }
}
