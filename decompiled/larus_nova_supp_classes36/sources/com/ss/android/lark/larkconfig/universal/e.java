package com.ss.android.lark.larkconfig.universal;

import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static final e a = null;

    public e() {
    }

    static {
        a = new e();
        new CopyOnWriteArrayList();
    }

    public final UniversalUserSetting a(String r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        a.a.getClass();
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        UniversalUserSetting r0 = (UniversalUserSetting) ((LinkedHashMap) a.b).get(r3);
        if (r0 != null) goto L6;
        Log.e("UniversalUserSettingManager", "no universal user setting for " + r3 + ", default values are used");
        return new UniversalUserSetting.Builder().key(r3).bool_value(Boolean.FALSE).int_value(0L).str_value("").build();
    L6:
        return r0;
    }
}
