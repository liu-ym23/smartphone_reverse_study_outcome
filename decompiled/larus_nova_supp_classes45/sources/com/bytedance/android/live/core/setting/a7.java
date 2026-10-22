package com.bytedance.android.live.core.setting;

import android.text.TextUtils;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a7 {
    public static JsonObject a;
    public static Disposable b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ JsonObject a;
        public final /* synthetic */ String b;

        public a(JsonObject r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            GsonMap r12 = UtilsKt.i((JsonObject) r11);
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator r13 = r12.b().iterator();
        L3:
            boolean r2 = false;
            if (r13.hasNext() == false) goto L10;
            Map.Entry r1 = (Map.Entry) r13.next();
            if (r1.getValue() == null) goto L8;
            r2 = true;
        L8:
            if (r2 == false) goto L3;
            r0.put(r1.getKey(), r1.getValue());
            goto L3
        L10:
            Set r14 = r0.keySet();
            Map<String, Object> r3 = SettingIncStrategy.a.c();
            LinkedHashMap r4 = new LinkedHashMap();
            Iterator<Map.Entry<String, Object>> r5 = r3.entrySet().iterator();
        L12:
            if (r5.hasNext() == false) goto L16;
            Map.Entry<String, Object> r6 = r5.next();
            if ((!StringsKt.startsWith$default(r6.getKey(), "__origin_Type__", false, 2, null)) == false) goto L12;
            r4.put(r6.getKey(), r6.getValue());
            goto L12
        L16:
            Set r7 = new HashMap(r4).keySet();
            int r8 = r14.size();
            int r9 = r7.size();
            JsonElement r15 = this.a.get("log_id");
            if (r15 == null) goto L20;
            String r16 = r15.getAsString();
            if (r16 == null) goto L20;
        L21:
            e7.a("check diff, server full setting count is " + r8 + ", current setting count is " + r9 + ", logId: " + r16);
            Set r17 = r7;
            Set r18 = r14;
            Set r19 = CollectionsKt.subtract(r17, r18);
            Set r110 = CollectionsKt.subtract(r18, r17);
            if (r8 == r9) goto L24;
        L27:
            JSONObject r21 = new JSONObject();
            r21.put("scene", this.b);
            JSONObject r22 = new JSONObject();
            r22.put("log_id", r16);
            r22.put("local_key_count", r9);
            r22.put("remote_key_count", r8);
            r22.put("local_only", TextUtils.join(",", r19));
            r22.put("remote_only", TextUtils.join(",", r110));
            JsonObject r111 = a7.a;
            LiveTracingMonitor.f("ttlive_setting_update_exist_diff", LiveTracingMonitor.EventModule.LIVE_MESSAGE, r21, new JSONObject(), r22);
            return;
        L24:
            if ((!r19.isEmpty()) == true) goto L27;
            if ((!r110.isEmpty()) == true) goto L27;
            return;
        L20:
            r16 = "";
            goto L21
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            StringBuilder r0 = new StringBuilder("check diff exception: ");
            if (r4 == null) goto L5;
            String r5 = r4.getMessage();
        L6:
            r0.append(r5);
            e7.a(r0.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    @JvmStatic
    public static final void update() {
        JsonObject r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        a = null;
        e7.a("update setting lite after room exit");
        TTLiveSettingUtil.updateSettingsV2FromFrontier(r0);
    }

    static {
    }

    @JvmStatic
    public static final void a(JsonObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (r3 != null) goto L5;
        return;
    L5:
        JsonElement r0 = r3.get("_full_setting");
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.isJsonObject() == true) goto L11;
        return;
    L11:
        JsonObject r1 = r0.getAsJsonObject();
        if (r1.size() != 0) goto L14;
        return;
    L14:
        JsonElement r2 = r3.get("setting_update_mode");
        if (r2 == null) goto L17;
        String r5 = r2.getAsString();
    L19:
        if (Intrinsics.areEqual(r5, "full") == false) goto L21;
        return;
    L21:
        Disposable r6 = b;
        if (r6 == null) goto L24;
        r6.dispose();
    L24:
        b = Single.just(r1).subscribeOn(Schedulers.io()).subscribe(new a(r3, r4), b.a);
        return;
    L17:
        r5 = null;
        goto L19
    }
}
