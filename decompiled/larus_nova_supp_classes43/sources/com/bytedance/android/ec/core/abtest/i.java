package com.bytedance.android.ec.core.abtest;

import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    public static void a(JSONObject r10, long r11, long r12) {
        JSONObject r13 = r10.optJSONObject("data");
        long r0 = 43200;
        if (r13 == null) goto L5;
        r0 = r13.optLong("valid_time", 43200);
    L5:
        yj.g r14 = null;
        if (r12 > ((r0 * ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR)) + r11)) goto L59;
        if (r13 == null) goto L9;
        Integer r15 = Integer.valueOf(r13.optInt("settings_type"));
    L10:
        if (r13 == null) goto L12;
        JSONObject r16 = r13.optJSONObject("exp");
    L13:
        if (r15 == null) goto L53;
        if (r16 == null) goto L53;
        if (r16.length() == 0) goto L53;
        if (r15.intValue() != 1) goto L30;
        Iterator<String> r17 = r16.keys();
        LinkedHashMap r18 = new LinkedHashMap();
    L22:
        if (r17.hasNext() == false) goto L27;
        String r19 = r17.next();
        if (r19 == null) goto L22;
        Object r1 = r16.opt(r19);
        SDKSettingsCacheManager.e.getClass();
        Intrinsics.checkNotNullParameter(r19, "key");
        SDKSettingsCacheManager.a.remove(r19);
        SDKSettingsCacheManager.b.put(r19, r1);
        dm.a.a("EcByteSync").a("sdkExpDisasterRecovery:" + r19 + ", " + r1 + ", " + r1.getClass());
        r18.put(r19, r1);
        goto L22
    L27:
        int r20 = com.bytedance.android.ec.core.abtest.a.a;
        Intrinsics.checkNotNullParameter(r18, "map");
        return;
    L30:
        if (r15.intValue() != 2) goto L52;
        IHybridHostService r21 = com.bytedance.android.ec.hybrid.a.h();
        if (r21 == null) goto L34;
        r14 = r21.getHostAB();
    L34:
        Iterator<String> r22 = r16.keys();
        LinkedHashMap r23 = new LinkedHashMap();
    L36:
        if (r22.hasNext() == false) goto L47;
        String r110 = r22.next();
        if (r110 == null) goto L36;
        Object r24 = r16.opt(r110);
        if (r24 == null) goto L36;
        r23.put(r110, r24);
        ConcurrentHashMap<String, Object> r25 = com.bytedance.android.ec.base.settings.d.a;
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r24, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        com.bytedance.android.ec.base.settings.d.a.remove(r110);
        com.bytedance.android.ec.base.settings.d.c.put(r110, r24);
        if (r14 == null) goto L46;
        r14.d(r110, r24);
    L46:
        dm.a.a("EcByteSync").a("hostExpDisasterRecovery:" + r110 + ", " + r24 + ", " + r24.getClass());
        goto L36
    L47:
        if (r14 == null) goto L50;
        return;
    L50:
        throw new Exception("business don't have experiment feature");
    L52:
        throw new Exception("invalid setting_type " + r15);
    L53:
        dm.a.a("EcByteSync").b("settingsType or experiments is null " + r15, null);
        if (r15 != null) goto L58;
        throw new Exception("settings_type is null");
    L58:
        throw new Exception("exp is null");
    L12:
        r16 = null;
        goto L13
    L9:
        r15 = null;
        goto L10
    L59:
        dm.a.a("EcByteSync").b("initTime: " + r12 + ", msg publishTime:" + r11, null);
        throw new Exception("initTime > publishTime");
    }
}
