package eda;

import com.obric.assistant.chat.component.list.pipeline.update.RecordingOperationCardKind;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final a a = null;
    public static final Set<String> b = null;
    public static final Set<b> c = null;
    public static final Set<C0088a> d = null;
    public static final Map<String, Set<String>> e = null;

    /* JADX INFO: renamed from: eda.a$a, reason: collision with other inner class name */
    public static final class C0088a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0088a) == true) goto L8;
            return false;
        L8:
            C0088a r6 = (C0088a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "MultiSelectionProtocol(widgetId=" + this.a + ", type=" + this.b + ')';
        }

        public final String getType() {
            return this.b;
        }

        public C0088a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "widgetId");
            Intrinsics.checkNotNullParameter(r3, "type");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "SingleSelectionProtocol(widgetId=" + this.a + ", sourceIntent=" + this.b + ", type=" + this.c + ')';
        }

        public final String getType() {
            return this.c;
        }

        public b(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "widgetId");
            Intrinsics.checkNotNullParameter(r3, "sourceIntent");
            Intrinsics.checkNotNullParameter(r4, "type");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final JSONObject a;
        public final String b;
        public final JSONObject c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "WidgetDocument(widgetInfo=" + this.a + ", widgetId=" + this.b + ", widgetData=" + this.c + ", widgetDataEncodedAsString=" + this.d + ')';
        }

        public c(JSONObject r2, String r3, JSONObject r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "widgetInfo");
            Intrinsics.checkNotNullParameter(r3, "widgetId");
            Intrinsics.checkNotNullParameter(r4, "widgetData");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = SetsKt.setOf("appintent_alarm");
        c = SetsKt.setOf(new b[]{new b("appintent_contact", "Contacts_Update", "contact"), new b("appintent_contact", "Phone_Call", "telephone"), new b("appintent_contact", "Messages_Send", "telephone"), new b("appintent_contact", "Appfc_Handoff", "telephone")});
        d = SetsKt.setOf(new C0088a("appintent_contact", "contact"));
        e = MapsKt.mapOf(new Pair[]{TuplesKt.to("Contacts_Delete", SetsKt.setOf("appintent_contact")), TuplesKt.to("Phone_Delete", SetsKt.setOf("appintent_phone")), TuplesKt.to("Messages_Delete", SetsKt.setOf("appintent_message")), TuplesKt.to("Clock_DeleteAlarm", SetsKt.setOf("appintent_alarm")), TuplesKt.to("Clock_DeleteCountdown", SetsKt.setOf("appintent_countdown")), TuplesKt.to("Memory_Delete", SetsKt.setOf("appintent_memory")), TuplesKt.to("Photo_DeletePhoto", SetsKt.setOf("appintent_photo")), TuplesKt.to("Recorder_Delete", SetsKt.setOf("appintent_soundrecord"))});
    }

    public static JSONObject a(JSONObject r3) {
        Object r2 = null;
        if (r3.has("inputParam") == false) goto L6;
        Object r4 = r3.opt("inputParam");
    L13:
        if ((r4 instanceof JSONObject) == false) goto L16;
        return (JSONObject) r4;
    L16:
        if ((r4 instanceof String) == false) goto L30;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        Object r5 = Result.constructor-impl(new JSONObject((String) r4));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r5) == true) goto L26;
        r2 = r5;
    L26:
        return (JSONObject) r2;
    L19:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L30:
        return null;
    L6:
        if (r3.has("inputParams") == false) goto L9;
        r4 = r3.opt("inputParams");
        goto L13
    L9:
        if (r3.has("input_param") == false) goto L11;
        r4 = r3.opt("input_param");
        goto L13
    L11:
        r4 = null;
        goto L13
    }

    public static c b(String r5) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        Object r1 = null;
        if (r0 == false) goto L34;
        return null;
    L34:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L26
        JSONObject r3 = new JSONObject(r5);     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r3.optString("applet_id"), "ability.intent.card") == true) goto L14;
        return null;
    L14:
        String r6 = r3.optString("widget_id");     // Catch: Throwable -> L26
        Object r4 = r3.opt("widget_data");     // Catch: Throwable -> L26
        if (r4 != null) goto L18;
        return null;
    L18:
        if ((r4 instanceof JSONObject) == false) goto L21;
        JSONObject r7 = (JSONObject) r4;     // Catch: Throwable -> L26
    L23:
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L26
        Object r8 = Result.constructor-impl(new c(r3, r6, r7, r4 instanceof String));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r8) == true) goto L33;
        r1 = r8;
    L33:
        return (c) r1;
    L21:
        if ((r4 instanceof String) == false) goto L25;
        r7 = new JSONObject((String) r4);     // Catch: Throwable -> L26
        goto L23
    L25:
        return null;
    L26:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L4:
        if (StringsKt.isBlank(r5) == true) goto L7;
        r0 = false;
        goto L8
    }

    public static Set c(String r10, JSONObject r11) {
        if (Intrinsics.areEqual(r10, "appintent_soundrecord") == false) goto L5;
        LinkedHashSet r12 = new LinkedHashSet();
        JSONArray r13 = r11.optJSONArray("cards");
        if (r13 != null) goto L9;
        return r12;
    L9:
        int r0 = r13.length();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L83;
        JSONObject r3 = r13.optJSONObject(r2);
        if (r3 == null) goto L82;
        JSONArray r4 = r3.optJSONArray("items");
        if (r4 == null) goto L82;
        int r5 = r4.length();
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L82;
        JSONObject r7 = r4.optJSONObject(r6);
        if (r7 == null) goto L81;
        String r8 = r7.optString("intentName");
        if (StringsKt.isBlank(r8) == false) goto L24;
        r8 = r7.optString("intent_name");
    L24:
        if (Intrinsics.areEqual(r8, "Recorder_Operate") == false) goto L81;
        JSONObject r9 = a(r7);
        RecordingOperationCardKind r14 = null;
        if (r9 == null) goto L32;
        String r15 = d(r9, "action");
        if (r15 == null) goto L32;
        String r16 = StringsKt.trim(r15).toString();
        if (r16 == null) goto L32;
        String r17 = r16.toLowerCase(Locale.ROOT);
    L33:
        if (r17 != null) goto L35;
    L51:
        JSONObject r18 = r7.optJSONObject("entity");
        if (r18 == null) goto L58;
        String r19 = r18.optString("recordStatus");
        if (r19 == null) goto L58;
        String r20 = StringsKt.trim(r19).toString();
        if (r20 == null) goto L58;
        String r21 = r20.toLowerCase(Locale.ROOT);
    L59:
        if (r21 == null) goto L78;
        int r22 = r21.hashCode();
        if (r22 == (-995321554)) goto L75;
        if (r22 == 3227604) goto L71;
        if (r22 != 993558001) goto L78;
        if (r21.equals("recording") == false) goto L78;
    L77:
        r14 = RecordingOperationCardKind.TRANSIENT;
        goto L78
    L71:
        if (r21.equals("idle") == false) goto L78;
        r14 = RecordingOperationCardKind.TERMINAL;
        goto L78
    L75:
        if (r21.equals("paused") == true) goto L77;
    L78:
        RecordingOperationCardKind r23 = r14;
    L79:
        if (r23 == null) goto L81;
        r12.add(r23);
    L58:
        r21 = null;
        goto L59
    L35:
        switch(r17.hashCode()) {
            case -934426579: goto L48;
            case 3540994: goto L44;
            case 106440182: goto L41;
            case 109757538: goto L38;
            default: goto L51;
        };
    L38:
        if (r17.equals("start") == false) goto L51;
    L50:
        r23 = RecordingOperationCardKind.TRANSIENT;
        goto L79
    L41:
        if (r17.equals("pause") == false) goto L51;
    L44:
        if (r17.equals("stop") == false) goto L51;
        r23 = RecordingOperationCardKind.TERMINAL;
        goto L79
    L48:
        if (r17.equals("resume") == true) goto L50;
    L32:
        r17 = null;
    L81:
        r6 = r6 + 1;
    L82:
        r2 = r2 + 1;
        goto L10
    L83:
        return r12;
    L5:
        return SetsKt.emptySet();
    }

    public static String d(JSONObject r0, String r1) {
        Object r2 = r0.opt(r1);
        if ((r2 instanceof String) == false) goto L6;
        return (String) r2;
    L6:
        if ((r2 instanceof JSONObject) == false) goto L10;
        String r3 = ((JSONObject) r2).optString("value");
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == false) goto L10;
        return r3;
    L10:
        return null;
    }
}
