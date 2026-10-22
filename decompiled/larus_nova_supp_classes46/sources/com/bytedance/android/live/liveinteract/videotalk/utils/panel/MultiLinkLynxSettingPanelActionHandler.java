package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import android.app.Application;
import android.content.SharedPreferences;
import com.bytedance.android.live.browser.jsbridge.newmethods.v5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.SettingUtilExtensionKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkLynxSettingPanelActionHandler {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(MultiLinkLynxSettingPanelActionHandler$switchSceneFrequencyUtil$2.INSTANCE);
    }

    public static JsonObject a(JsonObject r5) {
        if (r5.has("local_data") == false) goto L17;
        JsonObject r1 = new JsonObject();     // Catch: Exception -> L10
        Application r2 = jc1.a.b();     // Catch: Exception -> L10
        ExecutorService r3 = v5.a;     // Catch: Exception -> L10
        SharedPreferences r4 = r2.getSharedPreferences("js_kv_methods_20191113", 0);     // Catch: Exception -> L10
        Iterator r6 = r5.get("local_data").getAsJsonArray().iterator();     // Catch: Exception -> L10
    L6:
        if (r6.hasNext() == false) goto L9;
        String r0 = ((JsonElement) r6.next()).getAsString();     // Catch: Exception -> L10
        r1.addProperty(r0, r4.getString(r0, ""));     // Catch: Exception -> L10
        goto L6
    L9:
        return r1;
    L10:
        ALogger.w("LynxSettingPanelHandler", "handleLinkLynxPanelJsbGetAction call local_data not array");
        return null;
    L17:
        return null;
    }

    public static JsonObject b(JsonObject r3) {
        if (r3.has("setting_list") == false) goto L22;
        JsonObject r1 = new JsonObject();     // Catch: Exception -> L14
        JsonArray r4 = r3.get("setting_list").getAsJsonArray();     // Catch: Exception -> L14
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Exception -> L14
        Iterator r5 = r4.iterator();     // Catch: Exception -> L14
    L6:
        if (r5.hasNext() == false) goto L8;
        r0.add(((JsonElement) r5.next()).getAsString());     // Catch: Exception -> L14
        goto L6
    L8:
        Iterator r6 = SettingUtilExtensionKt.getSettingsValue(r0).iterator();     // Catch: Exception -> L14
    L9:
        if (r6.hasNext() == false) goto L13;
        Pair r2 = (Pair) r6.next();     // Catch: Exception -> L14
        r1.add((String) r2.getFirst(), (JsonElement) r2.getSecond());     // Catch: Exception -> L14
        goto L9
    L13:
        return r1;
    L14:
        e = move-exception;
        ALogger.w("LynxSettingPanelHandler", "getSettingRecordFromLocal call fail " + e.getMessage());
        return null;
    L22:
        return null;
    }
}
