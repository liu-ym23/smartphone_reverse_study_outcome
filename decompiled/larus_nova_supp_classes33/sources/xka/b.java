package xka;

import android.content.ContentValues;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements vka.b<Object> {
    public static final /* synthetic */ int E = 0;
    public final String A;
    public final String B;
    public final String C;
    public final boolean D;
    public final Long a;
    public final Long b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Integer g;
    public final Long h;
    public final Long i;
    public final String j;
    public final String k;
    public final String l;
    public final Boolean m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final Long t;
    public final Boolean u;
    public final Integer v;
    public final Integer w;
    public final Boolean x;
    public final Boolean y;
    public final Boolean z;

    public static final class a {
        public static b a(JsonObject r34, boolean r35) {
            Intrinsics.checkNotNullParameter(r34, "json");
            JsonElement r1 = r34.get("id");
            String r2 = null;
            if (r1 == null) goto L5;
            Long r5 = Long.valueOf(r1.getAsLong());
        L6:
            if (r35 == false) goto L11;
            if (r5 == null) goto L11;
            throw new IllegalArgumentException("add event with non-null id");
        L11:
            JsonElement r3 = r34.get("isException");
            if (r3 == null) goto L14;
            Boolean r4 = Boolean.valueOf(r3.getAsBoolean());
        L15:
            JsonElement r6 = r34.get("calendarId");
            if (r6 == null) goto L18;
            Long r7 = Long.valueOf(r6.getAsLong());
        L19:
            JsonElement r8 = r34.get("title");
            if (r8 == null) goto L22;
            String r9 = r8.getAsString();
        L23:
            JsonElement r10 = r34.get("organizer");
            if (r10 == null) goto L26;
            String r11 = r10.getAsString();
        L27:
            JsonElement r12 = r34.get("location");
            if (r12 == null) goto L30;
            String r13 = r12.getAsString();
        L31:
            JsonElement r14 = r34.get("description");
            if (r14 == null) goto L34;
            String r15 = r14.getAsString();
        L35:
            JsonElement r16 = r34.get("color");
            if (r16 == null) goto L38;
            Integer r17 = Integer.valueOf(r16.getAsInt());
        L39:
            JsonElement r18 = r34.get("startTime");
            if (r18 == null) goto L42;
            Long r19 = Long.valueOf(r18.getAsLong());
        L43:
            JsonElement r20 = r34.get("endTime");
            if (r20 == null) goto L46;
            Long r110 = Long.valueOf(r20.getAsLong());
        L47:
            JsonElement r21 = r34.get("timeZone");
            if (r21 == null) goto L50;
            String r111 = r21.getAsString();
        L51:
            JsonElement r22 = r34.get("endTimeZone");
            if (r22 == null) goto L54;
            String r112 = r22.getAsString();
        L55:
            JsonElement r23 = r34.get("duration");
            if (r23 == null) goto L58;
            String r113 = r23.getAsString();
        L59:
            JsonElement r24 = r34.get("allDay");
            if (r24 == null) goto L62;
            Boolean r114 = Boolean.valueOf(r24.getAsBoolean());
        L63:
            JsonElement r25 = r34.get("rRule");
            if (r25 == null) goto L66;
            String r115 = r25.getAsString();
        L67:
            JsonElement r26 = r34.get("rDate");
            if (r26 == null) goto L70;
            String r116 = r26.getAsString();
        L71:
            JsonElement r27 = r34.get("exRule");
            if (r27 == null) goto L74;
            String r28 = r27.getAsString();
        L75:
            JsonElement r29 = r34.get("exDate");
            if (r29 == null) goto L78;
            String r210 = r29.getAsString();
        L79:
            JsonElement r30 = r34.get("originalId");
            if (r30 == null) goto L82;
            String r211 = r30.getAsString();
        L83:
            JsonElement r31 = r34.get("originalSyncId");
            if (r31 == null) goto L86;
            String r212 = r31.getAsString();
        L87:
            JsonElement r32 = r34.get("originalInstanceTime");
            if (r32 == null) goto L90;
            Long r213 = Long.valueOf(r32.getAsLong());
        L91:
            JsonElement r33 = r34.get("originalAllDay");
            if (r33 == null) goto L94;
            Boolean r214 = Boolean.valueOf(r33.getAsBoolean());
        L95:
            JsonElement r36 = r34.get("accessLevel");
            if (r36 == null) goto L98;
            Integer r215 = Integer.valueOf(r36.getAsInt());
        L99:
            JsonElement r37 = r34.get("availability");
            if (r37 == null) goto L102;
            Integer r216 = Integer.valueOf(r37.getAsInt());
        L103:
            JsonElement r38 = r34.get("guestsCanModify");
            if (r38 == null) goto L106;
            Boolean r217 = Boolean.valueOf(r38.getAsBoolean());
        L107:
            JsonElement r39 = r34.get("guestsCanInviteOthers");
            if (r39 == null) goto L110;
            Boolean r218 = Boolean.valueOf(r39.getAsBoolean());
        L111:
            JsonElement r40 = r34.get("guestsCanSeeGuests");
            if (r40 == null) goto L114;
            Boolean r310 = Boolean.valueOf(r40.getAsBoolean());
        L115:
            JsonElement r41 = r34.get("customAppPackage");
            if (r41 == null) goto L118;
            String r311 = r41.getAsString();
        L119:
            JsonElement r42 = r34.get("customAppUri");
            if (r42 == null) goto L122;
            String r312 = r42.getAsString();
        L123:
            JsonElement r0 = r34.get("uid2445");
            if (r0 == null) goto L127;
            r2 = r0.getAsString();
        L127:
            return new b(r4, r5, r7, r9, r11, r13, r15, r17, r19, r110, r111, r112, r113, r114, r115, r116, r28, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r2);
        L122:
            r312 = null;
            goto L123
        L118:
            r311 = null;
            goto L119
        L114:
            r310 = null;
            goto L115
        L110:
            r218 = null;
            goto L111
        L106:
            r217 = null;
            goto L107
        L102:
            r216 = null;
            goto L103
        L98:
            r215 = null;
            goto L99
        L94:
            r214 = null;
            goto L95
        L90:
            r213 = null;
            goto L91
        L86:
            r212 = null;
            goto L87
        L82:
            r211 = null;
            goto L83
        L78:
            r210 = null;
            goto L79
        L74:
            r28 = null;
            goto L75
        L70:
            r116 = null;
            goto L71
        L66:
            r115 = null;
            goto L67
        L62:
            r114 = null;
            goto L63
        L58:
            r113 = null;
            goto L59
        L54:
            r112 = null;
            goto L55
        L50:
            r111 = null;
            goto L51
        L46:
            r110 = null;
            goto L47
        L42:
            r19 = null;
            goto L43
        L38:
            r17 = null;
            goto L39
        L34:
            r15 = null;
            goto L35
        L30:
            r13 = null;
            goto L31
        L26:
            r11 = null;
            goto L27
        L22:
            r9 = null;
            goto L23
        L18:
            r7 = null;
            goto L19
        L14:
            r4 = null;
            goto L15
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        if (this.D == false) goto L5;
        String r3 = this.r;
        Intrinsics.checkNotNull(r3);
        ala.e r1 = new ala.c(CastLongProtector.parseLong(r3), null);
    L6:
        ContentValues r4 = new ContentValues();
        r4.put("calendar_id", this.b);
        r4.put("title", this.c);
        r4.put("organizer", this.d);
        r4.put("eventLocation", this.e);
        r4.put("description", this.f);
        r4.put("eventColor", this.g);
        r4.put("dtstart", this.h);
        r4.put("dtend", this.i);
        r4.put("eventTimezone", this.j);
        r4.put("eventEndTimezone", this.k);
        r4.put("duration", this.l);
        r4.put("allDay", this.m);
        r4.put("rrule", this.n);
        r4.put("rdate", this.o);
        r4.put("exrule", this.p);
        r4.put("exdate", this.q);
        r4.put("original_id", this.r);
        r4.put("original_sync_id", this.s);
        r4.put("originalInstanceTime", this.t);
        r4.put("originalAllDay", this.u);
        r4.put("accessLevel", this.v);
        r4.put("availability", this.w);
        r4.put("guestsCanModify", this.x);
        r4.put("guestsCanInviteOthers", this.y);
        r4.put("guestsCanSeeGuests", this.z);
        r4.put("customAppPackage", this.A);
        r4.put("customAppUri", this.B);
        r4.put("uid2445", this.C);
        if (this.a == null) goto L14;
        if (r0.update(r1, r4, null, null) <= 0) goto L11;
        boolean r2 = true;
    L15:
        return Boolean.valueOf(r2);
    L11:
        r2 = false;
        goto L15
    L14:
        return r0.insert(r1, r4);
    L5:
        r1 = new ala.b(this.a, 2);
        goto L6
    }

    public b(Boolean r3, Long r4, Long r5, String r6, String r7, String r8, String r9, Integer r10, Long r11, Long r12, String r13, String r14, String r15, Boolean r16, String r17, String r18, String r19, String r20, String r21, String r22, Long r23, Boolean r24, Integer r25, Integer r26, Boolean r27, Boolean r28, Boolean r29, String r30, String r31, String r32) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.s = r22;
        this.t = r23;
        this.u = r24;
        this.v = r25;
        this.w = r26;
        this.x = r27;
        this.y = r28;
        this.z = r29;
        this.A = r30;
        this.B = r31;
        this.C = r32;
        if (r3 == null) goto L5;
        boolean r1 = r3.booleanValue();
    L6:
        this.D = r1;
        return;
    L5:
        r1 = false;
        goto L6
    }
}
