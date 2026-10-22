package com.obric.miniapp.calendar.compatibility;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Build;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vka.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g implements vka.b<Long> {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final boolean b;
    public final Long c;
    public final EventEntity d;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        EventEntity r2 = this.d;
        if (r2.M == null) goto L5;
        boolean r9 = true;
    L6:
        boolean r3 = r2.b;
        Long r10 = r2.a;
        boolean r11 = r2.d;
        Long r4 = r2.c;
        if (r4 == null) goto L9;
        String r13 = r4.toString();
    L10:
        EventEntity r5 = this.d;
        boolean r14 = r5.f;
        Long r15 = r5.e;
        boolean r7 = r5.h;
        String r6 = r5.g;
        boolean r8 = r5.z;
        String r12 = r5.y;
        boolean r16 = r5.j;
        Long r17 = r5.i;
        boolean r18 = r5.n;
        Long r19 = r5.m;
        boolean r20 = r5.t;
        Integer r21 = r5.s;
        boolean r22 = r5.x;
        String r23 = r5.w;
        boolean r24 = r5.B;
        String r25 = r5.A;
        if (r25 == null) goto L13;
        Integer r26 = StringsKt.toIntOrNull(r25);
    L14:
        EventEntity r27 = this.d;
        boolean r28 = r27.D;
        String r29 = r27.C;
        Integer r210 = r26;
        if (r27.F == true) goto L21;
        if (r3 == false) goto L18;
    L20:
        boolean r211 = false;
    L22:
        String r30 = r27.E;
        if (r30 != null) goto L40;
        if (r3 == false) goto L26;
    L39:
        r8 = r8;
        r6 = r6;
        r29 = r29;
        r9 = r9;
        String r31 = null;
    L42:
        EventEntity r32 = this.d;
        boolean r33 = r32.H;
        String r34 = r32.G;
        boolean r35 = r32.J;
        String r36 = r32.I;
        boolean r37 = r32.L;
        String r38 = r32.K;
        boolean r39 = r32.N;
        Long r40 = r32.M;
        if (r40 == null) goto L45;
        String r310 = r40.toString();
    L46:
        EventEntity r41 = this.d;
        boolean r42 = r41.P;
        Long r43 = r41.O;
        boolean r44 = r41.R;
        Integer r45 = r41.Q;
        boolean r46 = r41.r0;
        String r47 = r41.q0;
        boolean r48 = r41.v0;
        String r49 = r41.u0;
        boolean r212 = !r3;
        if (r10 == null) goto L71;
        r10.longValue();
        Integer r50 = r210;
        String r52 = r310;
        String r51 = r49;
        String r53 = "sync_data1";
        String r54 = r36;
        boolean r213 = r8;
        boolean r214 = r35;
        String r56 = r34;
        String r55 = r6;
        String r311 = r31;
        String r57 = r29;
        boolean r312 = r33;
        boolean r313 = r37;
        String r58 = r38;
        boolean r314 = r39;
        boolean r315 = r42;
        Long r59 = r43;
        boolean r316 = r44;
        Integer r510 = r45;
        boolean r317 = r46;
        String r60 = r47;
        boolean r318 = r48;
        vka.f r110 = r0;
        Long r1 = r17;
        Long r111 = r10;
        Long r112 = r19;
        boolean r215 = r11;
        String r113 = r23;
        String r216 = r13;
        Integer r114 = r21;
        Cursor r61 = r0.query(new ala.b(r10, 2), new String[]{"sync_data1"}, null, null, null);
        if (r61 == null) goto L68;
        Cursor r62 = r61;
        Cursor r63 = r62;     // Catch: Throwable -> L62
        if (r63.moveToNext() == true) goto L54;
    L58:
        String r64 = null;
    L59:
        CloseableKt.closeFinally(r62, null);
        if (r64 == null) goto L68;
        JsonObject r65 = JsonParser.parseString(r64).getAsJsonObject();
    L69:
        if (r65 == null) goto L72;
    L73:
        r65.addProperty("originalDtStart", this.d.i);
        EventEntity r66 = this.d;
        if (r66.l == false) goto L79;
        Long r67 = r66.k;
        if (r67 == null) goto L78;
        r65.addProperty("eTag", Long.valueOf(r67.longValue()));
        Unit r68 = Unit.INSTANCE;
        goto L79
    L78:
        r65.remove("eTag");
    L79:
        EventEntity r69 = this.d;
        if (r69.p == false) goto L85;
        Long r70 = r69.o;
        if (r70 == null) goto L84;
        r65.addProperty("dtStamp", Long.valueOf(r70.longValue()));
        Unit r71 = Unit.INSTANCE;
        goto L85
    L84:
        r65.remove("dtStamp");
    L85:
        EventEntity r72 = this.d;
        if (r72.r == false) goto L91;
        Long r73 = r72.q;
        if (r73 == null) goto L90;
        r65.addProperty("createTime", Long.valueOf(r73.longValue()));
        Unit r74 = Unit.INSTANCE;
        goto L91
    L90:
        r65.remove("createTime");
    L91:
        EventEntity r75 = this.d;
        if (r75.v == false) goto L97;
        EventEntity.EventType r76 = r75.u;
        if (r76 == null) goto L96;
        r65.addProperty("eventType", r76.toString());
        Unit r77 = Unit.INSTANCE;
        goto L97
    L96:
        r65.remove("eventType");
    L97:
        EventEntity r78 = this.d;
        if (r78.T == false) goto L103;
        String r79 = r78.S;
        if (r79 == null) goto L102;
        r65.addProperty("iCalStr", r79);
        Unit r80 = Unit.INSTANCE;
        goto L103
    L102:
        r65.remove("iCalStr");
    L103:
        EventEntity r81 = this.d;
        if (r81.V == false) goto L109;
        Integer r82 = r81.U;
        if (r82 == null) goto L108;
        r65.addProperty("isCompleted", Integer.valueOf(r82.intValue()));
        Unit r83 = Unit.INSTANCE;
        goto L109
    L108:
        r65.remove("isCompleted");
    L109:
        EventEntity r84 = this.d;
        if (r84.X == false) goto L115;
        EventEntity.EventFreq r85 = r84.W;
        if (r85 == null) goto L114;
        r65.addProperty("freq", r85.toString());
        Unit r86 = Unit.INSTANCE;
        goto L115
    L114:
        r65.remove("freq");
    L115:
        EventEntity r87 = this.d;
        if (r87.Z == false) goto L121;
        Integer r88 = r87.Y;
        if (r88 == null) goto L120;
        r65.addProperty("interval", Integer.valueOf(r88.intValue()));
        Unit r89 = Unit.INSTANCE;
        goto L121
    L120:
        r65.remove("interval");
    L121:
        EventEntity r90 = this.d;
        if (r90.b0 == false) goto L127;
        Long r91 = r90.a0;
        if (r91 == null) goto L126;
        r65.addProperty("until", Long.valueOf(r91.longValue()));
        Unit r92 = Unit.INSTANCE;
        goto L127
    L126:
        r65.remove("until");
    L127:
        EventEntity r93 = this.d;
        if (r93.d0 == false) goto L133;
        Integer r94 = r93.c0;
        if (r94 == null) goto L132;
        r65.addProperty("exStatus", Integer.valueOf(r94.intValue()));
        Unit r95 = Unit.INSTANCE;
        goto L133
    L132:
        r65.remove("exStatus");
    L133:
        EventEntity r96 = this.d;
        if (r96.f0 == false) goto L139;
        Integer r97 = r96.e0;
        if (r97 == null) goto L138;
        r65.addProperty("index", Integer.valueOf(r97.intValue()));
        Unit r98 = Unit.INSTANCE;
        goto L139
    L138:
        r65.remove("index");
    L139:
        EventEntity r99 = this.d;
        if (r99.h0 == false) goto L145;
        Long r100 = r99.g0;
        if (r100 == null) goto L144;
        r65.addProperty("exDtStart", Long.valueOf(r100.longValue()));
        Unit r101 = Unit.INSTANCE;
        goto L145
    L144:
        r65.remove("exDtStart");
    L145:
        EventEntity r102 = this.d;
        if (r102.j0 == false) goto L151;
        Long r103 = r102.i0;
        if (r103 == null) goto L150;
        r65.addProperty("exDtEnd", Long.valueOf(r103.longValue()));
        Unit r104 = Unit.INSTANCE;
        goto L151
    L150:
        r65.remove("exDtEnd");
    L151:
        EventEntity r105 = this.d;
        if (r105.l0 == false) goto L157;
        String r106 = r105.k0;
        if (r106 == null) goto L156;
        r65.addProperty("syncStatus", r106);
        Unit r107 = Unit.INSTANCE;
        goto L157
    L156:
        r65.remove("syncStatus");
    L157:
        EventEntity r108 = this.d;
        if (r108.p0 == false) goto L163;
        Boolean r109 = r108.o0;
        if (r109 == null) goto L162;
        r65.addProperty("isNoTimeTodo", Boolean.valueOf(r109.booleanValue()));
        Unit r115 = Unit.INSTANCE;
        goto L163
    L162:
        r65.remove("isNoTimeTodo");
    L163:
        EventEntity r116 = this.d;
        if (r116.t0 == false) goto L169;
        Long r117 = r116.s0;
        if (r117 == null) goto L168;
        r65.addProperty("completeTime", Long.valueOf(r117.longValue()));
        Unit r118 = Unit.INSTANCE;
        goto L169
    L168:
        r65.remove("completeTime");
    L169:
        String r119 = r65.toString();
        ContentValues r120 = new ContentValues();
        if (r14 == false) goto L172;
        r120.put("calendar_id", r15);
    L172:
        if (r7 == false) goto L174;
        r120.put("title", r55);
    L174:
        if (r213 == false) goto L176;
        r120.put("eventLocation", r12);
    L176:
        if (r22 == false) goto L178;
        r120.put("description", r113);
    L178:
        if (r24 == false) goto L180;
        r120.put("eventColor", r50);
    L180:
        if (r16 == false) goto L182;
        r120.put("dtstart", r1);
    L182:
        if (r18 == false) goto L184;
        r120.put("dtend", r112);
    L184:
        if (r212 == false) goto L186;
        r120.put("eventTimezone", "Asia/Shanghai");
    L186:
        if (r28 == false) goto L188;
        r120.put("duration", r57);
    L188:
        if (r20 == false) goto L190;
        r120.put("allDay", r114);
    L190:
        if (r211 == false) goto L192;
        r120.put("rrule", r311);
    L192:
        if (r312 == false) goto L194;
        r120.put("rdate", r56);
    L194:
        if (r214 == false) goto L196;
        r120.put("exrule", r54);
    L196:
        if (r313 == false) goto L199;
        r120.put("exdate", r58);
    L199:
        if (r314 == false) goto L201;
        r120.put("original_id", r52);
    L201:
        if (r315 == false) goto L203;
        r120.put("originalInstanceTime", r59);
    L203:
        if (r316 == false) goto L205;
        r120.put("originalAllDay", r510);
    L205:
        if (r318 == false) goto L207;
        r120.put("customAppPackage", r51);
    L207:
        if (r317 == false) goto L209;
        r120.put("customAppUri", r60);
    L209:
        if (r215 == false) goto L211;
        r120.put("_sync_id", r216);
    L211:
        r120.put(r53, r119);
        EventEntity r121 = this.d;
        if (r121.n0 == false) goto L215;
        r120.put("sync_data2", r121.m0);
    L215:
        if (this.b == false) goto L221;
        Long r122 = this.c;
        if (r122 == null) goto L219;
        long r123 = r122.longValue();
    L220:
        r120.put("dirty", Long.valueOf(r123));
        goto L221
    L219:
        r123 = 0;
    L221:
        if (r111 == null) goto L226;
        Long r124 = r111;
        if (r110.update(new ala.b(r124, this.a), r120, null, null) > 0) goto L236;
        return null;
    L236:
        return r124;
    L226:
        vka.f r125 = r110;
        if (r9 == false) goto L229;
        r120.remove("original_id");
        ala.e r126 = new ala.c(this.d.M.longValue(), this.a);
    L231:
        return r125.insert(r126, r120);
    L229:
        r126 = new ala.b(null, this.a);
    L72:
        r65 = new JsonObject();
        goto L73
    L54:
        if (r63.isNull(0) == true) goto L58;
        r64 = r63.getString(0);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        CloseableKt.closeFinally(r62, th);
        throw th;
    L68:
        r65 = null;
        goto L69
    L71:
        r51 = r49;
        r53 = "sync_data1";
        r54 = r36;
        r56 = r34;
        r50 = r210;
        r213 = r8;
        r55 = r6;
        r58 = r38;
        r52 = r310;
        r315 = r42;
        r59 = r43;
        r316 = r44;
        r510 = r45;
        r60 = r47;
        r214 = r35;
        r318 = r48;
        r311 = r31;
        r57 = r29;
        r312 = r33;
        r313 = r37;
        r314 = r39;
        r317 = r46;
        r110 = r0;
        r1 = r17;
        r111 = r10;
        r112 = r19;
        r215 = r11;
        r113 = r23;
        r216 = r13;
        r114 = r21;
        goto L72
    L45:
        r310 = null;
        goto L46
    L26:
        if (r27.W == null) goto L39;
        StringBuilder r127 = new StringBuilder();
        r127.append("FREQ=" + this.d.W);
        if (this.d.Y == null) goto L31;
        r127.append(";INTERVAL=" + this.d.Y);
    L31:
        if (this.d.a0 == null) goto L38;
        StringBuilder r128 = new StringBuilder(";UNTIL=");
        Lazy r129 = j.a;
        long r130 = this.d.a0.longValue();
        if (Build.VERSION.SDK_INT < 26) goto L35;
        DateTimeFormatter r131 = (DateTimeFormatter) j.a.getValue();
        Intrinsics.checkNotNull(r131);
        String r132 = r131.format(Instant.ofEpochMilli(r130).atZone(ZoneId.systemDefault()));
        Intrinsics.checkNotNull(r132);
    L36:
        r128.append(r132);
        r127.append(r128.toString());
        goto L38
    L35:
        r132 = ((SimpleDateFormat) j.b.getValue()).format(new Date(r130));
        Intrinsics.checkNotNull(r132);
    L38:
        r30 = r127.toString();
    L41:
        r31 = r30;
        goto L42
    L40:
        r6 = r6;
        r29 = r29;
        r9 = r9;
        goto L41
    L18:
        if (r27.X == false) goto L20;
    L21:
        r211 = true;
        goto L22
    L13:
        r26 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r9 = false;
        goto L6
    }

    public g(String r2, boolean r3, Long r4, EventEntity r5) {
        Intrinsics.checkNotNullParameter(r2, "accountName");
        Intrinsics.checkNotNullParameter(r5, "entity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
