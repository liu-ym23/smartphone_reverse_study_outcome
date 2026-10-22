package com.bytedance.framwork.core.sdklib.apm6.downgrade;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.framwork.core.sdklib.apm6.j;
import j3.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DowngradeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<LogType, a> f1913b;

    public static final enum LogType extends Enum<LogType> {
        private static final /* synthetic */ LogType[] $VALUES = null;
        public static final LogType OTHER_LOG_TYPE = null;
        public static final LogType SERVICE_MONITOR = null;
        public final String logType;

        static {
            LogType r10 = new LogType("OTHER_LOG_TYPE", 0, "other");
            OTHER_LOG_TYPE = r10;
            LogType r11 = new LogType("SERVICE_MONITOR", 1, "service_monitor");
            SERVICE_MONITOR = r11;
            $VALUES = new LogType[]{r10, r11};
        }

        private LogType(String r10, int r11, String r12) {
            super(r10, r11);
            this.logType = r12;
        }

        public static LogType valueOf(String r10) {
            return (LogType) Enum.valueOf(LogType.class, r10);
        }

        public static LogType[] values() {
            return (LogType[]) $VALUES.clone();
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, JSONObject> f1915b;

        a() {
            this.f1915b = new HashMap();
        }

        public static a a(JSONObject r10) {
            a r11 = new a();
            boolean r12 = true;
            if (r10.optInt(com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE, 1) == 1) goto L6;
            r12 = false;
        L6:
            r11.f1914a = r12;
            Iterator<String> r13 = r10.keys();
        L8:
            if (r13.hasNext() == false) goto L14;
            String r14 = r13.next();
            if (TextUtils.equals(r14, com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE) == true) goto L8;
            JSONObject r15 = r10.optJSONObject(r14);
            if (r15 == null) goto L8;
            r11.f1915b.put(r14, r15);
            goto L8
        L14:
            return r11;
        }

        @Nullable
        public JSONObject b() {
            JSONObject r10 = new JSONObject();     // Catch: JSONException -> L12
            if (this.f1914a == false) goto L5;
            int r11 = 1;
        L6:
            r10.put(com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE, r11);     // Catch: JSONException -> L12
            Iterator<Map.Entry<String, JSONObject>> r12 = this.f1915b.entrySet().iterator();     // Catch: JSONException -> L12
        L8:
            if (r12.hasNext() == false) goto L11;
            Map.Entry<String, JSONObject> r13 = r12.next();     // Catch: JSONException -> L12
            r10.put(r13.getKey(), r13.getValue());     // Catch: JSONException -> L12
            goto L8
        L11:
            return r10;
        L5:
            r11 = 0;
        L12:
            return null;
        }
    }

    public DowngradeInfo() {
        this.f1913b = new HashMap();
    }

    public static DowngradeInfo a(JSONObject r10) {
        if (j.f() == false) goto L5;
        c.d("APM-SDK", "DowngradeRule=" + r10.toString());
    L5:
        DowngradeInfo r11 = new DowngradeInfo();
        long r12 = r10.optLong("duration", 0);
        long r13 = r10.optLong(com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo.FIELD_EXPIRE_TIME, 0);
        if (r13 <= 0) goto L8;
        r11.f1912a = r13;
    L9:
        LogType r14 = LogType.OTHER_LOG_TYPE;
        JSONObject r15 = r10.optJSONObject(r14.logType);
        if (r15 == null) goto L12;
        r11.f1913b.put(r14, a.a(r15));
    L12:
        LogType r16 = LogType.SERVICE_MONITOR;
        JSONObject r17 = r10.optJSONObject(r16.logType);
        if (r17 == null) goto L15;
        r11.f1913b.put(r16, a.a(r17));
    L15:
        return r11;
    L8:
        r11.f1912a = System.currentTimeMillis() + (r12 * 1000);
        goto L9
    }

    @Nullable
    public JSONObject b() {
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L8
        r10.put(com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo.FIELD_EXPIRE_TIME, this.f1912a);     // Catch: JSONException -> L8
        Iterator<Map.Entry<LogType, a>> r11 = this.f1913b.entrySet().iterator();     // Catch: JSONException -> L8
    L4:
        if (r11.hasNext() == false) goto L7;
        Map.Entry<LogType, a> r12 = r11.next();     // Catch: JSONException -> L8
        r10.put(r12.getKey().logType, r12.getValue().b());     // Catch: JSONException -> L8
        goto L4
    L7:
        return r10;
    L8:
        return null;
    }
}
