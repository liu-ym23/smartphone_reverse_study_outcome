package xka;

import android.content.ContentValues;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p implements vka.b<Long> {
    public static final /* synthetic */ int S = 0;
    public final Boolean A;
    public final String B;
    public final String C;
    public final String D;
    public final Long E;
    public final String F;
    public final String G;
    public final String H;
    public final String I;
    public final String J;
    public final String K;
    public final String L;
    public final String M;
    public final String N;
    public final String O;
    public final String P;
    public final String Q;
    public final boolean R;
    public final String a;
    public final Long b;
    public final Long c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Integer h;
    public final Long i;
    public final Long j;
    public final String k;
    public final String l;
    public final String m;
    public final Boolean n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final Long u;
    public final Boolean v;
    public final Integer w;
    public final Integer x;
    public final Boolean y;
    public final Boolean z;

    public static final class a {
        public static p a(JsonObject r49) {
            Intrinsics.checkNotNullParameter(r49, "json");
            JsonElement r1 = r49.get("isException");
            String r2 = null;
            if (r1 == null) goto L5;
            Boolean r4 = Boolean.valueOf(r1.getAsBoolean());
        L6:
            String r6 = r49.get("accountName").getAsString();
            String r5 = r49.get("accountType").getAsString();
            JsonElement r3 = r49.get("id");
            if (r3 == null) goto L9;
            Long r7 = Long.valueOf(r3.getAsLong());
        L10:
            JsonElement r8 = r49.get("calendarId");
            if (r8 == null) goto L13;
            Long r9 = Long.valueOf(r8.getAsLong());
        L14:
            JsonElement r10 = r49.get("title");
            if (r10 == null) goto L17;
            String r11 = r10.getAsString();
        L18:
            JsonElement r12 = r49.get("organizer");
            if (r12 == null) goto L21;
            String r13 = r12.getAsString();
        L22:
            JsonElement r14 = r49.get("location");
            if (r14 == null) goto L25;
            String r15 = r14.getAsString();
        L26:
            JsonElement r16 = r49.get("description");
            if (r16 == null) goto L29;
            String r17 = r16.getAsString();
        L30:
            JsonElement r18 = r49.get("color");
            if (r18 == null) goto L33;
            Integer r19 = Integer.valueOf(r18.getAsInt());
        L34:
            JsonElement r20 = r49.get("startTime");
            if (r20 == null) goto L37;
            Long r110 = Long.valueOf(r20.getAsLong());
        L38:
            JsonElement r21 = r49.get("endTime");
            if (r21 == null) goto L41;
            Long r111 = Long.valueOf(r21.getAsLong());
        L42:
            JsonElement r22 = r49.get("timeZone");
            if (r22 == null) goto L45;
            String r112 = r22.getAsString();
        L46:
            JsonElement r23 = r49.get("endTimeZone");
            if (r23 == null) goto L49;
            String r113 = r23.getAsString();
        L50:
            JsonElement r24 = r49.get("duration");
            if (r24 == null) goto L53;
            String r114 = r24.getAsString();
        L54:
            JsonElement r25 = r49.get("allDay");
            if (r25 == null) goto L57;
            Boolean r115 = Boolean.valueOf(r25.getAsBoolean());
        L58:
            JsonElement r26 = r49.get("rRule");
            if (r26 == null) goto L61;
            String r27 = r26.getAsString();
        L62:
            JsonElement r28 = r49.get("rDate");
            if (r28 == null) goto L65;
            String r29 = r28.getAsString();
        L66:
            JsonElement r30 = r49.get("exRule");
            if (r30 == null) goto L69;
            String r210 = r30.getAsString();
        L70:
            JsonElement r31 = r49.get("exDate");
            if (r31 == null) goto L73;
            String r211 = r31.getAsString();
        L74:
            JsonElement r32 = r49.get("originalId");
            if (r32 == null) goto L77;
            String r212 = r32.getAsString();
        L78:
            JsonElement r33 = r49.get("originalSyncId");
            if (r33 == null) goto L81;
            String r213 = r33.getAsString();
        L82:
            JsonElement r34 = r49.get("originalInstanceTime");
            if (r34 == null) goto L85;
            Long r214 = Long.valueOf(r34.getAsLong());
        L86:
            JsonElement r35 = r49.get("originalAllDay");
            if (r35 == null) goto L89;
            Boolean r215 = Boolean.valueOf(r35.getAsBoolean());
        L90:
            JsonElement r36 = r49.get("accessLevel");
            if (r36 == null) goto L93;
            Integer r216 = Integer.valueOf(r36.getAsInt());
        L94:
            JsonElement r37 = r49.get("availability");
            if (r37 == null) goto L97;
            Integer r217 = Integer.valueOf(r37.getAsInt());
        L98:
            JsonElement r38 = r49.get("guestsCanModify");
            if (r38 == null) goto L101;
            Boolean r39 = Boolean.valueOf(r38.getAsBoolean());
        L102:
            JsonElement r40 = r49.get("guestsCanInviteOthers");
            if (r40 == null) goto L105;
            Boolean r310 = Boolean.valueOf(r40.getAsBoolean());
        L106:
            JsonElement r41 = r49.get("guestsCanSeeGuests");
            if (r41 == null) goto L109;
            Boolean r311 = Boolean.valueOf(r41.getAsBoolean());
        L110:
            JsonElement r42 = r49.get("customAppPackage");
            if (r42 == null) goto L113;
            String r312 = r42.getAsString();
        L114:
            JsonElement r43 = r49.get("customAppUri");
            if (r43 == null) goto L117;
            String r313 = r43.getAsString();
        L118:
            JsonElement r44 = r49.get("uid2445");
            if (r44 == null) goto L121;
            String r314 = r44.getAsString();
        L122:
            JsonElement r45 = r49.get("dirty");
            if (r45 == null) goto L125;
            Long r315 = Long.valueOf(r45.getAsLong());
        L126:
            JsonElement r46 = r49.get("mutators");
            if (r46 == null) goto L129;
            String r316 = r46.getAsString();
        L130:
            JsonElement r47 = r49.get("syncId");
            if (r47 == null) goto L133;
            String r317 = r47.getAsString();
        L134:
            JsonElement r48 = r49.get("extra1");
            if (r48 == null) goto L137;
            String r318 = r48.getAsString();
        L138:
            JsonElement r50 = r49.get("extra2");
            if (r50 == null) goto L141;
            String r410 = r50.getAsString();
        L142:
            JsonElement r51 = r49.get("extra3");
            if (r51 == null) goto L145;
            String r411 = r51.getAsString();
        L146:
            JsonElement r52 = r49.get("extra4");
            if (r52 == null) goto L149;
            String r412 = r52.getAsString();
        L150:
            JsonElement r53 = r49.get("extra5");
            if (r53 == null) goto L153;
            String r413 = r53.getAsString();
        L154:
            JsonElement r54 = r49.get("extra6");
            if (r54 == null) goto L157;
            String r414 = r54.getAsString();
        L158:
            JsonElement r55 = r49.get("extra7");
            if (r55 == null) goto L161;
            String r415 = r55.getAsString();
        L162:
            JsonElement r56 = r49.get("extra8");
            if (r56 == null) goto L165;
            String r416 = r56.getAsString();
        L166:
            JsonElement r57 = r49.get("extra9");
            if (r57 == null) goto L169;
            String r417 = r57.getAsString();
        L170:
            JsonElement r0 = r49.get("extra10");
            if (r0 == null) goto L174;
            r2 = r0.getAsString();
        L174:
            return new p(r4, r5, r6, r7, r9, r11, r13, r15, r17, r19, r110, r111, r112, r113, r114, r115, r27, r29, r210, r211, r212, r213, r214, r215, r216, r217, r39, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r2);
        L169:
            r417 = null;
            goto L170
        L165:
            r416 = null;
            goto L166
        L161:
            r415 = null;
            goto L162
        L157:
            r414 = null;
            goto L158
        L153:
            r413 = null;
            goto L154
        L149:
            r412 = null;
            goto L150
        L145:
            r411 = null;
            goto L146
        L141:
            r410 = null;
            goto L142
        L137:
            r318 = null;
            goto L138
        L133:
            r317 = null;
            goto L134
        L129:
            r316 = null;
            goto L130
        L125:
            r315 = null;
            goto L126
        L121:
            r314 = null;
            goto L122
        L117:
            r313 = null;
            goto L118
        L113:
            r312 = null;
            goto L114
        L109:
            r311 = null;
            goto L110
        L105:
            r310 = null;
            goto L106
        L101:
            r39 = null;
            goto L102
        L97:
            r217 = null;
            goto L98
        L93:
            r216 = null;
            goto L94
        L89:
            r215 = null;
            goto L90
        L85:
            r214 = null;
            goto L86
        L81:
            r213 = null;
            goto L82
        L77:
            r212 = null;
            goto L78
        L73:
            r211 = null;
            goto L74
        L69:
            r210 = null;
            goto L70
        L65:
            r29 = null;
            goto L66
        L61:
            r27 = null;
            goto L62
        L57:
            r115 = null;
            goto L58
        L53:
            r114 = null;
            goto L54
        L49:
            r113 = null;
            goto L50
        L45:
            r112 = null;
            goto L46
        L41:
            r111 = null;
            goto L42
        L37:
            r110 = null;
            goto L38
        L33:
            r19 = null;
            goto L34
        L29:
            r17 = null;
            goto L30
        L25:
            r15 = null;
            goto L26
        L21:
            r13 = null;
            goto L22
        L17:
            r11 = null;
            goto L18
        L13:
            r9 = null;
            goto L14
        L9:
            r7 = null;
            goto L10
        L5:
            r4 = null;
            goto L6
        }
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        ContentValues r1 = new ContentValues();
        r1.put("calendar_id", this.c);
        r1.put("title", this.d);
        r1.put("organizer", this.e);
        r1.put("eventLocation", this.f);
        r1.put("description", this.g);
        r1.put("eventColor", this.h);
        r1.put("dtstart", this.i);
        r1.put("dtend", this.j);
        r1.put("eventTimezone", this.k);
        r1.put("eventEndTimezone", this.l);
        r1.put("duration", this.m);
        r1.put("allDay", this.n);
        r1.put("rrule", this.o);
        r1.put("rdate", this.p);
        r1.put("exrule", this.q);
        r1.put("exdate", this.r);
        r1.put("original_id", this.s);
        r1.put("original_sync_id", this.t);
        r1.put("originalInstanceTime", this.u);
        r1.put("originalAllDay", this.v);
        r1.put("accessLevel", this.w);
        r1.put("availability", this.x);
        r1.put("guestsCanModify", this.y);
        r1.put("guestsCanInviteOthers", this.z);
        r1.put("guestsCanSeeGuests", this.A);
        r1.put("customAppPackage", this.B);
        r1.put("customAppUri", this.C);
        r1.put("uid2445", this.D);
        r1.put("dirty", this.E);
        r1.put("mutators", this.F);
        r1.put("_sync_id", this.G);
        r1.put("sync_data1", this.H);
        r1.put("sync_data2", this.I);
        r1.put("sync_data3", this.J);
        r1.put("sync_data4", this.K);
        r1.put("sync_data5", this.L);
        r1.put("sync_data6", this.M);
        r1.put("sync_data7", this.N);
        r1.put("sync_data8", this.O);
        r1.put("sync_data9", this.P);
        r1.put("sync_data10", this.Q);
        if (this.b == null) goto L8;
        if (r0.update(new ala.b(this.b, this.a), r1, null, null) > 0) goto L14;
        return null;
    L14:
        return this.b;
    L8:
        if (this.R == false) goto L10;
        r1.remove("original_id");
        String r3 = this.s;
        Intrinsics.checkNotNull(r3);
        ala.e r2 = new ala.c(CastLongProtector.parseLong(r3), this.a);
    L12:
        return r0.insert(r2, r1);
    L10:
        r2 = new ala.b(null, this.a);
        goto L12
    }

    public p(Boolean r5, String r6, String r7, Long r8, Long r9, String r10, String r11, String r12, String r13, Integer r14, Long r15, Long r16, String r17, String r18, String r19, Boolean r20, String r21, String r22, String r23, String r24, String r25, String r26, Long r27, Boolean r28, Integer r29, Integer r30, Boolean r31, Boolean r32, Boolean r33, String r34, String r35, String r36, Long r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49) {
        Intrinsics.checkNotNullParameter(r6, "accountType");
        Intrinsics.checkNotNullParameter(r7, "accountName");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r20;
        this.o = r21;
        this.p = r22;
        this.q = r23;
        this.r = r24;
        this.s = r25;
        this.t = r26;
        this.u = r27;
        this.v = r28;
        this.w = r29;
        this.x = r30;
        this.y = r31;
        this.z = r32;
        this.A = r33;
        this.B = r34;
        this.C = r35;
        this.D = r36;
        this.E = r37;
        this.F = r38;
        this.G = r39;
        this.H = r40;
        this.I = r41;
        this.J = r42;
        this.K = r43;
        this.L = r44;
        this.M = r45;
        this.N = r46;
        this.O = r47;
        this.P = r48;
        this.Q = r49;
        if (r5 == null) goto L5;
        boolean r1 = r5.booleanValue();
    L6:
        this.R = r1;
        return;
    L5:
        r1 = false;
        goto L6
    }
}
