package com.bytedance.android.btm.impl.page.unknown;

import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.SharedPreferenceUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UnionChainRecorder {
    public static final Lazy a = null;
    public static boolean b;
    public static boolean c;
    public static final Map<String, String> d = null;
    public static final Map<String, String> e = null;

    static {
        a = LazyKt.lazy(UnionChainRecorder$sharePreference$2.INSTANCE);
        LinkedHashMap<String, String> r0 = new UnionChainRecorder$unionBtmMap$1();
        LinkedHashMap<String, String> r1 = new UnionChainRecorder$unionEventBtmMap$1();
        d = Collections.synchronizedMap(r0);
        e = Collections.synchronizedMap(r1);
    }

    public static void a() {
        if (BtmSetting.d.c().c().L() == 1) goto L5;
        return;
    L5:
        SharedPreferenceUtil r0 = (SharedPreferenceUtil) a.getValue();
        if (r0 == null) goto L19;
        JSONObject r10 = new JSONObject();
        Map<String, String> r11 = d;
        monitor-enter(r11);
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L16
    L11:
        if (r12.hasNext() == false) goto L13;
        Map.Entry<String, String> r13 = r12.next();     // Catch: Throwable -> L16
        r10.putOpt(r13.getKey(), r13.getValue());     // Catch: Throwable -> L16
        goto L11
    L13:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r11);
        r0.a("key_union_chain", r10.toString());
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
