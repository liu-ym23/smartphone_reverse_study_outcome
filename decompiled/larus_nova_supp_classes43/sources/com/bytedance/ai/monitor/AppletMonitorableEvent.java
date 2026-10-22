package com.bytedance.ai.monitor;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.utils.g;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mx7.c;
import org.json.JSONException;
import org.json.JSONObject;
import rx7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AppletMonitorableEvent {
    public final String a;
    public String b;
    public EventOrigin c;
    public boolean d;
    public long e;
    public String f;
    public String g;
    public JSONObject h;
    public JSONObject i;
    public JSONObject j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/monitor/AppletMonitorableEvent$EventOrigin;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Unknown", "Native", "MainJS", "UI", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EventOrigin extends Enum<EventOrigin> {
        public static final EventOrigin MainJS = null;
        public static final EventOrigin Native = null;
        public static final EventOrigin UI = null;
        public static final EventOrigin Unknown = null;
        public static final /* synthetic */ EventOrigin[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int type;

        public static EnumEntries<EventOrigin> getEntries() {
            return b;
        }

        static {
            EventOrigin r0 = new EventOrigin("Unknown", 0, 0);
            Unknown = r0;
            EventOrigin r1 = new EventOrigin("Native", 1, 1);
            Native = r1;
            EventOrigin r10 = new EventOrigin("MainJS", 2, 2);
            MainJS = r10;
            EventOrigin r11 = new EventOrigin("UI", 3, 3);
            UI = r11;
            EventOrigin[] r12 = {r0, r1, r10, r11};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static EventOrigin[] values() {
            return (EventOrigin[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public static EventOrigin valueOf(String r1) {
            return (EventOrigin) r27.a.a(EventOrigin.class, r1);
        }

        public EventOrigin(String r1, int r10, int r11) {
            super(r1, r10);
            this.type = r11;
        }
    }

    public static final class a {
    }

    static {
    }

    public boolean b() {
        if (this.a.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        if ((!StringsKt.isBlank(this.a)) == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public JSONObject n() {
        if (b() == false) goto L5;
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
        r0.put("event", this.a);     // Catch: JSONException -> L8
        r0.put("type", this.b);     // Catch: JSONException -> L8
        r0.put("origin", this.c.name());     // Catch: JSONException -> L8
        r0.put("timeStamp", this.e);     // Catch: JSONException -> L8
        l("description", null, r0);     // Catch: JSONException -> L8
        l("packageId", this.f, r0);     // Catch: JSONException -> L8
        l(BdpAwemeConstant.KEY_APP_ID, this.g, r0);     // Catch: JSONException -> L8
        c(this.h, r0);     // Catch: JSONException -> L8
        j(r0);     // Catch: JSONException -> L8
        return r0;
    L8:
        e = move-exception;
        g.a.d("AppletMonitorableEvent", "failed to convert event to json: " + e.getMessage());
        return new JSONObject();
    L5:
        return new JSONObject();
    }

    public JSONObject a() {
        return this.i;
    }

    public final String getType() {
        return this.b;
    }

    public /* synthetic */ AppletMonitorableEvent(String r10) {
        this(r10, EventOrigin.Unknown);
    }

    public static void j(JSONObject r10) throws JSONException {
        Intrinsics.checkNotNullParameter(r10, "json");
        h2.a r0 = f2.b.c;
        Object r1 = "";
        if (r0 == null) goto L6;
        String r11 = r0.b;
        if (r11 == null) goto L6;
    L8:
        if (r11.length() != 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L13;
        g.a.e("AppletMonitorableEvent", "did is Empty, AISDK isInitialized is false");
    L13:
        r10.put(com.bytedance.android.ec.core.event.a.KEY_DID, r11);
        int r13 = com.bytedance.ai.utils.a.a;
        Object r14 = "Product";
        if (f2.b.a() == false) goto L28;
        h2.a r15 = f2.b.c;
        if (r15 == null) goto L28;
        if (r15.n == false) goto L22;
        Object r16 = r15.o;
    L25:
        if (r16 == null) goto L28;
        r14 = r16;
        goto L28
    L22:
        if (r15.p == false) goto L24;
        r16 = r15.q;
        goto L25
    L24:
        r16 = "Product";
    L28:
        r10.put("http_env", r14);
        if (f2.b.a() == false) goto L35;
        Object[] r17 = {"boe", "test", "prd"};
        int r18 = h.a;
        int r19 = c.b().getSharedPreferences("gecko_settings", 0).getInt("gecko_env", 2);
        if (r19 >= 3) goto L35;
        if (r19 < 0) goto L35;
        r1 = r17[r19];
    L35:
        r10.put("gecko_env", r1);
        r10.put("ai_sdk_version", "1.15.0-rc.7");
        return;
    L10:
        r12 = false;
    L6:
        r11 = "";
        goto L8
    }

    public final void h(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
        if (this.h != null) goto L17;
        this.h = new JSONObject();
    L17:
        JSONObject r0 = this.h;     // Catch: JSONException -> L14
        if (r10 == null) goto L21;
        if (r0 == null) goto L22;
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();     // Catch: JSONException -> L14
    L11:
        if (r11.hasNext() == false) goto L23;
        Map.Entry<String, ? extends Object> r1 = r11.next();     // Catch: JSONException -> L14
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L14
        goto L11
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L14:
        e = move-exception;
        g.a.e("AppletMonitorableEvent", ExceptionsKt.stackTraceToString(e));
    }

    public final void i(JSONObject r10) {
        Intrinsics.checkNotNullParameter("pageInfo", "key");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (r10.length() <= 0) goto L6;
        k("pageInfo", r10);
        return;
    }

    public final void m(EventOrigin r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.c = r10;
    }

    public AppletMonitorableEvent(String r10, EventOrigin r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "origin");
        this.b = "common_event";
        this.e = -1;
        this.a = r10;
        this.c = r11;
    }

    public static void c(JSONObject r10, JSONObject r11) throws JSONException {
        Intrinsics.checkNotNullParameter(r11, "dst");
        if (r10 == null) goto L11;
        Iterator<String> r0 = r10.keys();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.hasNext() == false) goto L18;
        String r1 = r0.next();
        Object r12 = r10.opt(r1);
        if (r12 == null) goto L7;
        r11.put(r1, r12);
        goto L7
    L18:
        return;
    }

    public final void d(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        k(r10, Integer.valueOf(r11));
    }

    public final void e(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        k(r10, Long.valueOf(r11));
    }

    public final void f(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (r11.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if ((!StringsKt.isBlank(r11)) == false) goto L12;
        k(r10, r11);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void g(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        k(r10, Boolean.valueOf(r11));
    }

    public final void k(String r10, Object r11) {
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(r10) == true) goto L24;
    L17:
        e = move-exception;
        g.a.d("AppletMonitorableEvent", "error occurred when put extra info to event: " + e.getMessage());
        return;
    L11:
        if (this.h != null) goto L13;
        this.h = new JSONObject();     // Catch: JSONException -> L17
    L13:
        JSONObject r1 = this.h;     // Catch: JSONException -> L17
        if (r1 == null) goto L23;
        r1.putOpt(r10, r11);     // Catch: JSONException -> L17
        return;
    L23:
        return;
    L24:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void l(String r10, String r11, JSONObject r12) throws JSONException {
        Intrinsics.checkNotNullParameter(r12, "json");
        boolean r1 = true;
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L15;
        if (r11 != null) goto L9;
    L12:
        if (r1 == true) goto L16;
        r12.put(r10, r11);
        return;
    L16:
        return;
    L9:
        if (r11.length() == 0) goto L12;
        r1 = false;
        goto L12
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
