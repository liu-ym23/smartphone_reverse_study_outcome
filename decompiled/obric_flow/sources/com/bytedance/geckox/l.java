package com.bytedance.geckox;

import android.util.Log;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.core.EventSubType;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    public static void a(String r10, String r11) {
        AtomicBoolean r5 = df.c.f16648a;
        if (r10.length() != 0) goto L6;
    L7:
        GeckoLogger.b("gecko register failed, accessKey: " + r10 + ", root dir: " + r11);
        return;
    L6:
        if (r11.length() == 0) goto L7;
        ConcurrentHashMap r12 = df.c.d;
        String r13 = (String) r12.get(r10);
        if (r13 != null) goto L12;
    L21:
        r12.put(r10, r11);
        if (df.c.f16649b.get() == false) goto L24;
        com.bytedance.iesgurd.meta.e.e(r10, r11);
    L24:
        GeckoLogger.a("gecko register root dir, accessKey:" + r10 + ", root dir:" + r11);
        GeckoGlobalConfig r14 = df.c.f;
        if (r14 != null) goto L27;
        return;
    L27:
        if (StringsKt.P(r11, r14.getContext().getFilesDir().getAbsolutePath()) == true) goto L32;
        EventSubType r15 = EventSubType.d;
        JSONObject r16 = new JSONObject();
        r16.put("sub_type", r15.f6615a);
        r16.put("access_key", r10);
        r16.put("extra", r11);
        com.lynx.tasm.utils.j.g("geckosdk_event_message", r16);
        return;
    L32:
        return;
    L12:
        if (r13.length() == 0) goto L21;
        if (Intrinsics.areEqual(r13, r11) == true) goto L30;
        StringBuilder r17 = com.lynx.tasm.base.a.e("oldPath: ", r13, ", newPath: ", r11, ", stackTrace: ");
        r17.append(Log.getStackTraceString(new Throwable()));
        String r18 = r17.toString();
        GeckoLogger.a("registerAccessKey2Dir error for ak: " + r10 + ", " + r18);
        EventSubType r19 = EventSubType.e;
        JSONObject r20 = new JSONObject();
        r20.put("sub_type", r19.f6615a);
        if (r18 == null) goto L19;
        r20.put("err_msg", r18);
    L19:
        r20.put("extra", r10);
        com.lynx.tasm.utils.j.g("geckosdk_event_message", r20);
        return;
    }

    public static boolean b() {
        GlobalConfigSettings r5 = df.c.f16652i.d();
        if (r5 == null) goto L14;
        GlobalConfigSettings.ReqMeta r10 = r5.getReqMeta();
        if (r10 == null) goto L14;
        if (df.c.g == true) goto L9;
    L11:
        boolean r11 = false;
    L12:
        df.c.g = r11;
        goto L14
    L9:
        if (r10.getEnable() == false) goto L11;
        r11 = true;
    L14:
        return df.c.g;
    }
}
