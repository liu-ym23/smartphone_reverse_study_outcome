package com.bytedance.android.live.base.abtest;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final Map<String, Object> a = null;
    public static final a b = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static Object a(ClientABTestKey r1) {
            Intrinsics.checkNotNullParameter(r1, "key");
            return b(r1, true);
        }

        @JvmStatic
        public static Object c(ClientABTestKey r6) {
            String r0 = r6.a;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            if (r3 == true) goto L33;
            ClientABTestKey.a r7 = r6.d;
            if (r7 == null) goto L33;
            if (r7.a != 1) goto L33;
            Lazy r8 = ABTestConfigMapper.a;
            Intrinsics.checkNotNullParameter(r0, "key");
            if (((Boolean) SettingUtil.getValue("key_ttlive_sdk_setting", "live_ab_host_config_v2", Boolean.TYPE, Boolean.TRUE)).booleanValue() == false) goto L31;
            Lazy r9 = ABTestConfigMapper.b;
            if (((Map) r9.getValue()).isEmpty() == true) goto L31;
            String r11 = (String) ((Map) r9.getValue()).get(r0);
            Lazy r4 = ABTestConfigMapper.a;
            if (((Class) ((ConcurrentHashMap) r4.getValue()).get(r0)) != null) goto L31;
            if (r11 != null) goto L24;
        L25:
            r1 = true;
        L26:
            if (r1 == true) goto L31;
            Class r12 = ABTestConfigMapper.a(r11);     // Catch: Exception -> L29
            ((ConcurrentHashMap) r4.getValue()).put(r0, r12);     // Catch: Exception -> L29
        L29:
            e = move-exception;
            e.printStackTrace();
            goto L31
        L24:
            if (StringsKt.isBlank(r11) == false) goto L26;
        L31:
            Object r13 = ((ConcurrentHashMap) b.a).get(r0);
            if ((r13 instanceof Object) == false) goto L33;
            return r13;
        L33:
            return null;
        L5:
            if (StringsKt.isBlank(r0) == true) goto L8;
            r3 = false;
            goto L9
        }

        @JvmStatic
        public static Object b(ClientABTestKey r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "key");
            Object r0 = null;
            r0 = SettingUtil.getValue("key_ttlive_sdk_setting", r4.a, r4.b, null);     // Catch: Throwable -> L5
        L6:
            if (r0 == null) goto L32;
        L26:
            if (r0 == null) goto L28;
            return r0;
        L28:
            return r4.c;
        L32:
            Object r1 = c(r4);     // Catch: Throwable -> L24
            if (r1 == null) goto L10;
            r0 = r1;
            goto L26
        L10:
            r0 = k.n(IHostContext.class).getClientABTestValue(r4, r5);     // Catch: Throwable -> L24
            String r6 = r4.a;     // Catch: Throwable -> L24
            if (r6 != null) goto L13;
        L16:
            boolean r2 = true;
        L17:
            if (r2 == true) goto L26;
            ClientABTestKey.a r3 = r4.d;     // Catch: Throwable -> L24
            if (r3 == null) goto L26;
            if (r3.a != 1) goto L26;
            ((ConcurrentHashMap) b.a).put(r6, r0);     // Catch: Throwable -> L24
            goto L26
        L13:
            if (StringsKt.isBlank(r6) == true) goto L16;
            r2 = false;
        L24:
            th = move-exception;
            ALogger.e("LiveClientABUtils", th);
            goto L26
        }
    }

    static {
        b = new a();
        a = new ConcurrentHashMap();
    }
}
