package com.bytedance.android.annie.scheme.helper;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LiveSchemaUtil {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(LiveSchemaUtil$fixScheme$2.INSTANCE);
        b = LazyKt.lazy(LiveSchemaUtil$enableSchemePerformance$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a() {
        if (((Boolean) a.getValue()).booleanValue() == false) goto L7;
        if (((Boolean) b.getValue()).booleanValue() == false) goto L7;
    L8:
        return true;
    L7:
        if (AnnieConfigSettingKeys.ENABLE_OPTIMIZE_SCHEMA_PERFORMANCE.a().booleanValue() == true) goto L8;
        return false;
    }
}
