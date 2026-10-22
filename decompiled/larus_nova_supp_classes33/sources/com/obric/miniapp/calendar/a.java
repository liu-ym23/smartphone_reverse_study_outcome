package com.obric.miniapp.calendar;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.calendar.compatibility.CalendarEntity;
import com.obric.miniapp.calendar.compatibility.EventEntity;
import com.obric.miniapp.calendar.compatibility.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vka.b;
import vka.n;
import wka.c;
import xka.e;
import xka.f;
import xka.g;
import xka.h;
import xka.i;
import xka.j;
import xka.k;
import xka.l;
import xka.o;
import xka.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.obric.miniapp.calendar.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0045a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CalendarOpType.values().length];
            r0[CalendarOpType.QUERY_CALENDAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L79:
            r0[CalendarOpType.MODIFY_CALENDAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L91:
            r0[CalendarOpType.SYNC_CALENDAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L57:
            r0[CalendarOpType.DELETE_CALENDAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L61:
            r0[CalendarOpType.QUERY_EVENT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L73:
            r0[CalendarOpType.ADD_EVENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L85:
            r0[CalendarOpType.UPDATE_EVENT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
        L65:
            r0[CalendarOpType.DELETE_EVENT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L34
        L81:
            r0[CalendarOpType.SYNC_EVENT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L35
        L83:
            r0[CalendarOpType.ADD_ATTENDEE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L36
        L51:
            r0[CalendarOpType.QUERY_REMINDER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L37
        L77:
            r0[CalendarOpType.ADD_REMINDER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L89:
            r0[CalendarOpType.UPDATE_REMINDER.ordinal()] = 13;     // Catch: NoSuchFieldError -> L39
        L49:
            r0[CalendarOpType.DELETE_REMINDER.ordinal()] = 14;     // Catch: NoSuchFieldError -> L40
        L63:
            r0[CalendarOpType.SYNC_REMINDER.ordinal()] = 15;     // Catch: NoSuchFieldError -> L41
        L87:
            r0[CalendarOpType.QUERY_INSTANCES.ordinal()] = 16;     // Catch: NoSuchFieldError -> L42
        L55:
            r0[CalendarOpType.QUERY_INSTANCES_BETWEEN.ordinal()] = 17;     // Catch: NoSuchFieldError -> L43
        L59:
            r0[CalendarOpType.QUERY_EVENT_IDS_OF_INSTANCES.ordinal()] = 18;     // Catch: NoSuchFieldError -> L44
        L75:
            r0[CalendarOpType.QUERY_ENABLE_EVENTS.ordinal()] = 19;     // Catch: NoSuchFieldError -> L45
        L53:
            r0[CalendarOpType.QUERY_BY_KEYWORD.ordinal()] = 20;     // Catch: NoSuchFieldError -> L46
        L69:
            r0[CalendarOpType.SYNC_COLORS.ordinal()] = 21;     // Catch: NoSuchFieldError -> L47
        L71:
            r0[CalendarOpType.MERGE_CALENDAR.ordinal()] = 22;     // Catch: NoSuchFieldError -> L48
        L25:
            a = r0;
        }
    }

    static {
    }

    public static b a(JsonObject r58) {
        CalendarOpType.a r1 = CalendarOpType.Companion;
        String r2 = r58.get("op").getAsString();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "string");
        switch(r2.hashCode()) {
            case -1952609388: goto L156;
            case -1891227502: goto L152;
            case -1862053898: goto L148;
            case -1707035679: goto L144;
            case -1649828730: goto L140;
            case -1508595048: goto L136;
            case -1501738090: goto L132;
            case -1492882381: goto L128;
            case -1309550766: goto L124;
            case -1259780487: goto L120;
            case -1226536152: goto L116;
            case -1145778257: goto L112;
            case -931252125: goto L108;
            case -841745960: goto L104;
            case -610430044: goto L100;
            case -597401775: goto L97;
            case -431523717: goto L94;
            case -430231802: goto L91;
            case -192108878: goto L88;
            case -167917723: goto L85;
            case -146074736: goto L82;
            case -73767274: goto L78;
            case 72746340: goto L74;
            case 131888173: goto L70;
            case 137154986: goto L67;
            case 205880856: goto L63;
            case 330666364: goto L60;
            case 351568987: goto L57;
            case 470601919: goto L54;
            case 472166137: goto L50;
            case 553293206: goto L47;
            case 893571170: goto L44;
            case 1228662051: goto L41;
            case 1243218073: goto L38;
            case 1279194458: goto L34;
            case 1619472422: goto L30;
            case 1640244203: goto L27;
            case 1658256414: goto L24;
            case 1723387709: goto L21;
            case 1725013584: goto L18;
            case 1760049673: goto L15;
            case 1947842503: goto L12;
            case 2063665673: goto L9;
            case 2100327637: goto L6;
            default: goto L159;
        };
    L159:
        CalendarOpType r3 = null;
    L160:
        if (r3 != null) goto L162;
        int r4 = -1;
    L164:
        switch(r4) {
            case -1: goto L529;
            case 0: goto L166;
            case 1: goto L510;
            case 2: goto L493;
            case 3: goto L346;
            case 4: goto L342;
            case 5: goto L320;
            case 6: goto L319;
            case 7: goto L318;
            case 8: goto L311;
            case 9: goto L300;
            case 10: goto L271;
            case 11: goto L261;
            case 12: goto L260;
            case 13: goto L259;
            case 14: goto L244;
            case 15: goto L231;
            case 16: goto L216;
            case 17: goto L202;
            case 18: goto L193;
            case 19: goto L186;
            case 20: goto L184;
            case 21: goto L179;
            case 22: goto L167;
            default: goto L166;
        };
    L167:
        FLogger.a.i("CalendarHelper", "merge calendar");
        int r5 = g.d;
        Intrinsics.checkNotNullParameter(r58, "json");
        JsonElement r6 = r58.get("accountName");
        if (r6 != null) goto L170;
        r6 = r58.get("account_name");
    L170:
        Intrinsics.checkNotNull(r6);
        String r7 = r6.getAsString();
        JsonElement r8 = r58.get("from");
        if (r8 == null) goto L173;
        Long r9 = Long.valueOf(r8.getAsLong());
    L174:
        JsonElement r0 = r58.get("to");
        if (r0 == null) goto L177;
        Long r10 = Long.valueOf(r0.getAsLong());
    L178:
        Intrinsics.checkNotNull(r7);
        return new g(r7, r9, r10);
    L177:
        r10 = null;
        goto L178
    L173:
        r9 = null;
        goto L174
    L179:
        FLogger.a.i("CalendarHelper", "sync colors");
        int r11 = o.f;
        Intrinsics.checkNotNullParameter(r58, "json");
        String r18 = r58.get("accountName").getAsString();
        String r19 = r58.get("accountType").getAsString();
        JsonElement r12 = r58.get("colorType");
        if (r12 == null) goto L182;
        Integer r20 = Integer.valueOf(r12.getAsInt());
    L183:
        b r13 = new o(r18, r19, r20, r58.get("colorKey").getAsString(), r58.get("color").getAsInt());
    L532:
        return r13;
    L182:
        r20 = null;
        goto L183
    L184:
        FLogger.a.i("CalendarHelper", "query by keyword");
        int r14 = com.obric.miniapp.calendar.compatibility.b.b;
        Intrinsics.checkNotNullParameter(r58, "json");
        JsonElement r15 = r58.get("keyword");
        Intrinsics.checkNotNull(r15);
        r13 = new com.obric.miniapp.calendar.compatibility.b(r15.getAsString());
        goto L532
    L186:
        FLogger.a.i("CalendarHelper", "query enable events");
        int r16 = d.b;
        Intrinsics.checkNotNullParameter(r58, "json");
        JsonElement r17 = r58.get("eventType");
        if (r17 == null) goto L191;
        String r21 = r17.getAsString();
        if (r21 == null) goto L191;
        EventEntity.EventType r22 = EventEntity.EventType.valueOf(r21);
    L533:
        return new d(r22);
    L191:
        r22 = null;
        goto L533
    L193:
        FLogger.a.i("CalendarHelper", "query event ids of instances");
        int r23 = wka.a.d;
        Intrinsics.checkNotNullParameter(r58, "json");
        JsonElement r24 = n.a(r58, "begin");
        if (r24 != null) goto L197;
        r24 = r58.get("start");
    L197:
        long r25 = r24.getAsLong();
        long r26 = r58.get("end").getAsLong();
        JsonElement r27 = n.a(r58, "hasReminder");
        if (r27 == null) goto L200;
        boolean r28 = r27.getAsBoolean();
    L201:
        r13 = new wka.a(r25, r26, r28);
        goto L532
    L200:
        r28 = false;
        goto L201
    L202:
        FLogger.a.i("CalendarHelper", "query instances between");
        int r29 = wka.b.d;
        Intrinsics.checkNotNullParameter(r58, "json");
        JsonElement r30 = n.a(r58, "event_id");
        if (r30 == null) goto L206;
        Long r31 = Long.valueOf(r30.getAsLong());
    L209:
        Long r110 = r31;
    L211:
        JsonElement r32 = n.a(r58, "begin");
        if (r32 != null) goto L534;
        r32 = r58.get("start");
    L534:
        return new wka.b(r110, r32.getAsLong(), r58.get("end").getAsLong());
    L206:
        JsonElement r33 = n.a(r58, "eventId");
        if (r33 == null) goto L210;
        r31 = Long.valueOf(r33.getAsLong());
        goto L209
    L210:
        r110 = null;
        goto L211
    L216:
        FLogger.a.i("CalendarHelper", "query instances");
        int r34 = j.e;
        Intrinsics.checkNotNullParameter(r58, "json");
        JsonElement r35 = r58.get("projection");
        if (r35 == null) goto L225;
        JsonArray r36 = r35.getAsJsonArray();
        if (r36 == null) goto L225;
        ArrayList r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
        Iterator r38 = r36.iterator();
    L222:
        if (r38.hasNext() == false) goto L224;
        r37.add(((JsonElement) r38.next()).getAsString());
        goto L222
    L224:
        String[] r39 = (String[]) r37.toArray(new String[0]);
    L226:
        JsonElement r40 = r58.get("eventId");
        if (r40 == null) goto L229;
        Long r41 = Long.valueOf(r40.getAsLong());
    L535:
        return new j(r39, r41, r58.get("start").getAsLong(), r58.get("end").getAsLong());
    L229:
        r41 = null;
    L225:
        r39 = null;
        goto L226
    L231:
        FLogger.a.i("CalendarHelper", "sync reminder");
        int r42 = c.h;
        Intrinsics.checkNotNullParameter(r58, "json");
        String r111 = r58.get("accountName").getAsString();
        JsonElement r43 = r58.get("id");
        if (r43 == null) goto L234;
        Long r112 = Long.valueOf(r43.getAsLong());
    L235:
        long r210 = r58.get("eventId").getAsLong();
        JsonElement r44 = r58.get("minutes");
        if (r44 == null) goto L238;
        Long r211 = Long.valueOf(r44.getAsLong());
    L239:
        boolean r212 = r58.has("minutes");
        JsonElement r45 = r58.get("method");
        if (r45 == null) goto L242;
        Integer r213 = Integer.valueOf(r45.getAsInt());
    L243:
        boolean r214 = r58.has("method");
        Intrinsics.checkNotNull(r111);
        return new c(r111, r112, r210, r211, r212, r213, r214);
    L242:
        r213 = null;
        goto L243
    L238:
        r211 = null;
        goto L239
    L234:
        r112 = null;
        goto L235
    L244:
        FLogger.a.i("CalendarHelper", "delete reminder");
        int r46 = f.d;
        Intrinsics.checkNotNullParameter(r58, "json");
        JsonElement r47 = r58.get("accountName");
        if (r47 != null) goto L247;
        r47 = r58.get("account_name");
    L247:
        if (r47 == null) goto L249;
        String r48 = r47.getAsString();
    L250:
        JsonElement r49 = r58.get("id");
        if (r49 == null) goto L253;
        Long r50 = Long.valueOf(r49.getAsLong());
    L254:
        JsonElement r51 = r58.get("eventId");
        if (r51 == null) goto L257;
        Long r52 = Long.valueOf(r51.getAsLong());
    L258:
        r13 = new f(r48, r50, r52);
        goto L532
    L257:
        r52 = null;
        goto L258
    L253:
        r50 = null;
        goto L254
    L249:
        r48 = null;
        goto L250
    L259:
        FLogger.a.i("CalendarHelper", "update reminder");
        int r53 = xka.c.e;
        return xka.c.a.a(r58, false);
    L260:
        FLogger.a.i("CalendarHelper", "add reminder");
        int r54 = xka.c.e;
        return xka.c.a.a(r58, true);
    L261:
        FLogger.a.i("CalendarHelper", "query reminder");
        int r55 = i.f;
        r13 = i.a.a(new ala.d(null, 3), r58);
        if (r13 != null) goto L532;
        String[] r56 = k.b;
        Intrinsics.checkNotNullParameter(r58, "json");
        JsonElement r57 = r58.get("eventId");
        if (r57 == null) goto L267;
        k r59 = new k(r57.getAsLong());
    L268:
        if (r59 == null) goto L540;
        return r59;
    L540:
        return new i(new ala.d(null, 3));
    L267:
        r59 = null;
        goto L268
    L271:
        FLogger.a.i("CalendarHelper", "add attendee");
        int r60 = xka.a.i;
        Intrinsics.checkNotNullParameter(r58, "json");
        long r113 = r58.get("eventId").getAsLong();
        JsonElement r61 = r58.get("name");
        if (r61 == null) goto L274;
        String r215 = r61.getAsString();
    L275:
        JsonElement r62 = r58.get("email");
        if (r62 == null) goto L278;
        String r216 = r62.getAsString();
    L279:
        JsonElement r63 = r58.get("relationship");
        if (r63 == null) goto L282;
        Integer r217 = Integer.valueOf(r63.getAsInt());
    L283:
        JsonElement r64 = r58.get("type");
        if (r64 == null) goto L286;
        Integer r218 = Integer.valueOf(r64.getAsInt());
    L287:
        JsonElement r65 = r58.get("status");
        if (r65 == null) goto L290;
        Integer r219 = Integer.valueOf(r65.getAsInt());
    L291:
        JsonElement r66 = r58.get("identity");
        if (r66 == null) goto L294;
        String r220 = r66.getAsString();
    L295:
        JsonElement r67 = r58.get("idNamespace");
        if (r67 == null) goto L298;
        String r221 = r67.getAsString();
    L299:
        r13 = new xka.a(r113, r215, r216, r217, r218, r219, r220, r221);
        goto L532
    L298:
        r221 = null;
        goto L299
    L294:
        r220 = null;
        goto L295
    L290:
        r219 = null;
        goto L291
    L286:
        r218 = null;
        goto L287
    L282:
        r217 = null;
        goto L283
    L278:
        r216 = null;
        goto L279
    L274:
        r215 = null;
        goto L275
    L300:
        FLogger.a.i("CalendarHelper", "sync event");
        int r68 = com.obric.miniapp.calendar.compatibility.g.e;
        Intrinsics.checkNotNullParameter(r58, "json");
        String r69 = r58.get("accountName").getAsString();
        boolean r70 = r58.has("dirty");
        JsonElement r71 = n.a(r58, "dirty");
        if (r71 == null) goto L303;
        Long r72 = Long.valueOf(r71.getAsLong());
    L304:
        String[] r73 = EventEntity.w0;
        EventEntity r74 = EventEntity.a.b(r58);
        if (r74 == null) goto L307;
        Intrinsics.checkNotNull(r69);
        com.obric.miniapp.calendar.compatibility.g r75 = new com.obric.miniapp.calendar.compatibility.g(r69, r70, r72, r74);
    L308:
        if (r75 != null) goto L541;
        int r76 = p.S;
        return p.a.a(r58);
    L541:
        return r75;
    L307:
        r75 = null;
        goto L308
    L303:
        r72 = null;
        goto L304
    L311:
        FLogger.a.i("CalendarHelper", "delete event");
        int r77 = e.c;
        Intrinsics.checkNotNullParameter(r58, "json");
        long r78 = r58.get("id").getAsLong();
        JsonElement r79 = r58.get("accountName");
        if (r79 != null) goto L314;
        r79 = r58.get("account_name");
    L314:
        if (r79 == null) goto L316;
        String r80 = r79.getAsString();
    L317:
        r13 = new e(r78, r80);
        goto L532
    L316:
        r80 = null;
        goto L317
    L318:
        FLogger.a.i("CalendarHelper", "update event");
        int r81 = xka.b.E;
        return xka.b.a.a(r58, false);
    L319:
        FLogger.a.i("CalendarHelper", "add event");
        int r82 = xka.b.E;
        return xka.b.a.a(r58, true);
    L320:
        FLogger.a.i("CalendarHelper", "query event");
        int r83 = i.f;
        r13 = i.a.a(new ala.b(null, 3), r58);
        if (r13 != null) goto L532;
        String[] r84 = EventEntity.w0;
        EventEntity r85 = EventEntity.a.b(r58);
        if (r85 == null) goto L338;
        JsonElement r86 = r58.get("deleted");
        if (r86 == null) goto L328;
        Boolean r87 = Boolean.valueOf(r86.getAsBoolean());
    L329:
        JsonElement r88 = r58.get("dirty");
        if (r88 == null) goto L332;
        Long r89 = Long.valueOf(r88.getAsLong());
    L333:
        JsonElement r90 = r58.get("enable");
        if (r90 == null) goto L336;
        Boolean r91 = Boolean.valueOf(r90.getAsBoolean());
    L337:
        com.obric.miniapp.calendar.compatibility.e r92 = new com.obric.miniapp.calendar.compatibility.e(r87, r91, r89, r85);
    L339:
        if (r92 == null) goto L546;
        return r92;
    L546:
        return new i(new ala.b(null, 3));
    L336:
        r91 = null;
        goto L337
    L332:
        r89 = null;
        goto L333
    L328:
        r87 = null;
        goto L329
    L338:
        r92 = null;
        goto L339
    L342:
        FLogger.a.i("CalendarHelper", "delete calendar");
        int r93 = xka.d.c;
        Intrinsics.checkNotNullParameter(r58, "json");
        long r94 = r58.get("id").getAsLong();
        JsonElement r95 = r58.get("accountName");
        if (r95 != null) goto L345;
        r95 = r58.get("account_name");
    L345:
        r13 = new xka.d(r94, r95.getAsString());
        goto L532
    L346:
        FLogger.a.i("CalendarHelper", "sync calendar");
        int r96 = com.obric.miniapp.calendar.compatibility.f.d;
        Intrinsics.checkNotNullParameter(r58, "json");
        boolean r97 = r58.has("dirty");
        JsonElement r98 = n.a(r58, "dirty");
        if (r98 == null) goto L349;
        Long r99 = Long.valueOf(r98.getAsLong());
    L350:
        String[] r100 = CalendarEntity.E;
        CalendarEntity r101 = CalendarEntity.a.b(r58, true);
        if (r101 == null) goto L353;
        com.obric.miniapp.calendar.compatibility.f r114 = new com.obric.miniapp.calendar.compatibility.f(r97, r99, r101);
    L354:
        if (r114 != null) goto L547;
        int r102 = l.I;
        Intrinsics.checkNotNullParameter(r58, "json");
        JsonElement r103 = r58.get("id");
        if (r103 == null) goto L359;
        Long r222 = Long.valueOf(r103.getAsLong());
    L360:
        JsonElement r104 = r58.get("name");
        if (r104 == null) goto L363;
        String r223 = r104.getAsString();
    L364:
        JsonElement r105 = r58.get("location");
        if (r105 == null) goto L367;
        String r224 = r105.getAsString();
    L368:
        JsonElement r106 = r58.get("accountName");
        if (r106 == null) goto L371;
        String r225 = r106.getAsString();
    L372:
        JsonElement r107 = r58.get("accountType");
        if (r107 == null) goto L375;
        String r226 = r107.getAsString();
    L376:
        JsonElement r108 = r58.get("color");
        if (r108 == null) goto L379;
        Integer r227 = Integer.valueOf(r108.getAsInt());
    L380:
        JsonElement r109 = r58.get("syncId");
        if (r109 == null) goto L383;
        String r310 = r109.getAsString();
    L384:
        JsonElement r115 = r58.get("dirty");
        if (r115 == null) goto L387;
        Long r311 = Long.valueOf(r115.getAsLong());
    L388:
        JsonElement r116 = r58.get("mutators");
        if (r116 == null) goto L391;
        String r312 = r116.getAsString();
    L392:
        JsonElement r117 = r58.get("deleted");
        if (r117 == null) goto L395;
        Long r313 = Long.valueOf(r117.getAsLong());
    L396:
        JsonElement r118 = r58.get("colorKey");
        if (r118 == null) goto L399;
        String r314 = r118.getAsString();
    L400:
        JsonElement r119 = r58.get("displayName");
        if (r119 == null) goto L403;
        String r315 = r119.getAsString();
    L404:
        JsonElement r120 = r58.get("accessLevel");
        if (r120 == null) goto L407;
        Integer r316 = Integer.valueOf(r120.getAsInt());
    L408:
        JsonElement r121 = r58.get("visible");
        if (r121 == null) goto L411;
        Long r317 = Long.valueOf(r121.getAsLong());
    L412:
        JsonElement r122 = r58.get("timeZone");
        if (r122 == null) goto L415;
        String r318 = r122.getAsString();
    L416:
        JsonElement r123 = r58.get("ownerAccount");
        if (r123 == null) goto L419;
        String r319 = r123.getAsString();
    L420:
        JsonElement r124 = r58.get("syncEvents");
        if (r124 == null) goto L423;
        Long r410 = Long.valueOf(r124.getAsLong());
    L424:
        JsonElement r125 = r58.get("canOrganizerRespond");
        if (r125 == null) goto L427;
        Long r411 = Long.valueOf(r125.getAsLong());
    L428:
        JsonElement r126 = r58.get("canModifyTimeZone");
        if (r126 == null) goto L431;
        Long r412 = Long.valueOf(r126.getAsLong());
    L432:
        JsonElement r127 = r58.get("maxReminders");
        if (r127 == null) goto L435;
        Integer r413 = Integer.valueOf(r127.getAsInt());
    L436:
        JsonElement r128 = r58.get("allowedReminders");
        if (r128 == null) goto L439;
        String r414 = r128.getAsString();
    L440:
        JsonElement r129 = r58.get("allowedAvailability");
        if (r129 == null) goto L443;
        String r415 = r129.getAsString();
    L444:
        JsonElement r130 = r58.get("allowedAttendeeTypes");
        if (r130 == null) goto L447;
        String r416 = r130.getAsString();
    L448:
        JsonElement r131 = r58.get("isPrimary");
        if (r131 == null) goto L451;
        Long r417 = Long.valueOf(r131.getAsLong());
    L452:
        JsonElement r132 = r58.get("extra1");
        if (r132 == null) goto L455;
        String r418 = r132.getAsString();
    L456:
        JsonElement r133 = r58.get("extra2");
        if (r133 == null) goto L459;
        String r419 = r133.getAsString();
    L460:
        JsonElement r134 = r58.get("extra3");
        if (r134 == null) goto L463;
        String r510 = r134.getAsString();
    L464:
        JsonElement r135 = r58.get("extra4");
        if (r135 == null) goto L467;
        String r511 = r135.getAsString();
    L468:
        JsonElement r136 = r58.get("extra5");
        if (r136 == null) goto L471;
        String r512 = r136.getAsString();
    L472:
        JsonElement r137 = r58.get("extra6");
        if (r137 == null) goto L475;
        String r513 = r137.getAsString();
    L476:
        JsonElement r138 = r58.get("extra7");
        if (r138 == null) goto L479;
        String r514 = r138.getAsString();
    L480:
        JsonElement r139 = r58.get("extra8");
        if (r139 == null) goto L483;
        String r515 = r139.getAsString();
    L484:
        JsonElement r140 = r58.get("extra9");
        if (r140 == null) goto L487;
        String r516 = r140.getAsString();
    L488:
        JsonElement r141 = r58.get("extra10");
        if (r141 == null) goto L491;
        String r517 = r141.getAsString();
    L548:
        return new l(r222, r223, r224, r225, r226, r227, r314, r310, r311, r312, r313, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517);
    L491:
        r517 = null;
        goto L548
    L487:
        r516 = null;
        goto L488
    L483:
        r515 = null;
        goto L484
    L479:
        r514 = null;
        goto L480
    L475:
        r513 = null;
        goto L476
    L471:
        r512 = null;
        goto L472
    L467:
        r511 = null;
        goto L468
    L463:
        r510 = null;
        goto L464
    L459:
        r419 = null;
        goto L460
    L455:
        r418 = null;
        goto L456
    L451:
        r417 = null;
        goto L452
    L447:
        r416 = null;
        goto L448
    L443:
        r415 = null;
        goto L444
    L439:
        r414 = null;
        goto L440
    L435:
        r413 = null;
        goto L436
    L431:
        r412 = null;
        goto L432
    L427:
        r411 = null;
        goto L428
    L423:
        r410 = null;
        goto L424
    L419:
        r319 = null;
        goto L420
    L415:
        r318 = null;
        goto L416
    L411:
        r317 = null;
        goto L412
    L407:
        r316 = null;
        goto L408
    L403:
        r315 = null;
        goto L404
    L399:
        r314 = null;
        goto L400
    L395:
        r313 = null;
        goto L396
    L391:
        r312 = null;
        goto L392
    L387:
        r311 = null;
        goto L388
    L383:
        r310 = null;
        goto L384
    L379:
        r227 = null;
        goto L380
    L375:
        r226 = null;
        goto L376
    L371:
        r225 = null;
        goto L372
    L367:
        r224 = null;
        goto L368
    L363:
        r223 = null;
        goto L364
    L359:
        r222 = null;
        goto L360
    L547:
        return r114;
    L353:
        r114 = null;
        goto L354
    L349:
        r99 = null;
        goto L350
    L493:
        FLogger.a.i("CalendarHelper", "modify calendar");
        int r142 = h.f;
        Intrinsics.checkNotNullParameter(r58, "json");
        long r143 = r58.get("id").getAsLong();
        JsonElement r144 = r58.get("name");
        if (r144 == null) goto L496;
        String r228 = r144.getAsString();
    L497:
        JsonElement r145 = r58.get("displayName");
        if (r145 == null) goto L500;
        String r229 = r145.getAsString();
    L501:
        JsonElement r146 = r58.get("visible");
        if (r146 == null) goto L504;
        Boolean r230 = Boolean.valueOf(r146.getAsBoolean());
    L505:
        JsonElement r147 = r58.get("syncEvents");
        if (r147 == null) goto L508;
        Boolean r231 = Boolean.valueOf(r147.getAsBoolean());
    L549:
        return new h(r143, r228, r229, r230, r231);
    L508:
        r231 = null;
        goto L549
    L504:
        r230 = null;
        goto L505
    L500:
        r229 = null;
        goto L501
    L496:
        r228 = null;
        goto L497
    L510:
        FLogger.a.i("CalendarHelper", "query calendar");
        int r148 = i.f;
        r13 = i.a.a(new ala.a(null, 3), r58);
        if (r13 != null) goto L532;
        String[] r149 = CalendarEntity.E;
        CalendarEntity r150 = CalendarEntity.a.b(r58, false);
        if (r150 == null) goto L524;
        JsonElement r151 = r58.get("deleted");
        if (r151 == null) goto L518;
        Boolean r152 = Boolean.valueOf(r151.getAsBoolean());
    L519:
        JsonElement r153 = r58.get("dirty");
        if (r153 == null) goto L522;
        Long r154 = Long.valueOf(r153.getAsLong());
    L523:
        com.obric.miniapp.calendar.compatibility.c r155 = new com.obric.miniapp.calendar.compatibility.c(r152, r154, r150);
    L525:
        if (r155 == null) goto L550;
        return r155;
    L550:
        return new i(new ala.a(null, 3));
    L522:
        r154 = null;
        goto L523
    L518:
        r152 = null;
        goto L519
    L524:
        r155 = null;
        goto L525
    L166:
        throw new NoWhenBranchMatchedException();
    L529:
        return new vka.g("No such op");
    L162:
        r4 = C0045a.a[r3.ordinal()];
        goto L164
    L6:
        if (r2.equals("query_calendar") == false) goto L159;
    L32:
        r3 = CalendarOpType.QUERY_CALENDAR;
        goto L160
    L9:
        if (r2.equals("deleteCalendar") == false) goto L159;
    L126:
        r3 = CalendarOpType.DELETE_CALENDAR;
        goto L160
    L12:
        if (r2.equals("query_instances") == false) goto L159;
    L80:
        r3 = CalendarOpType.QUERY_INSTANCES;
        goto L160
    L15:
        if (r2.equals("query_reminder") == false) goto L159;
    L36:
        r3 = CalendarOpType.QUERY_REMINDER;
        goto L160
    L18:
        if (r2.equals("add_reminder") == false) goto L159;
    L130:
        r3 = CalendarOpType.ADD_REMINDER;
        goto L160
    L21:
        if (r2.equals("deleteReminder") == false) goto L159;
    L142:
        r3 = CalendarOpType.DELETE_REMINDER;
        goto L160
    L24:
        if (r2.equals("query_enable_events") == false) goto L159;
    L76:
        r3 = CalendarOpType.QUERY_ENABLE_EVENTS;
        goto L160
    L27:
        if (r2.equals("syncColors") == false) goto L159;
    L158:
        r3 = CalendarOpType.SYNC_COLORS;
        goto L160
    L30:
        if (r2.equals("queryCalendar") == true) goto L32;
    L34:
        if (r2.equals("queryReminder") == true) goto L36;
    L38:
        if (r2.equals("query_event_ids_of_instances") == false) goto L159;
    L146:
        r3 = CalendarOpType.QUERY_EVENT_IDS_OF_INSTANCES;
        goto L160
    L41:
        if (r2.equals("modify_calendar") == false) goto L159;
    L65:
        r3 = CalendarOpType.MODIFY_CALENDAR;
        goto L160
    L44:
        if (r2.equals("sync_calendar") == false) goto L159;
    L52:
        r3 = CalendarOpType.SYNC_CALENDAR;
        goto L160
    L47:
        if (r2.equals("sync_reminder") == false) goto L159;
    L72:
        r3 = CalendarOpType.SYNC_REMINDER;
        goto L160
    L50:
        if (r2.equals("syncCalendar") == true) goto L52;
    L54:
        if (r2.equals("syncEvent") == false) goto L159;
    L150:
        r3 = CalendarOpType.SYNC_EVENT;
        goto L160
    L57:
        if (r2.equals("updateReminder") == false) goto L159;
    L118:
        r3 = CalendarOpType.UPDATE_REMINDER;
        goto L160
    L60:
        if (r2.equals("add_event") == false) goto L159;
    L122:
        r3 = CalendarOpType.ADD_EVENT;
        goto L160
    L63:
        if (r2.equals("modifyCalendar") == true) goto L65;
    L67:
        if (r2.equals("queryByKeyword") == false) goto L159;
    L106:
        r3 = CalendarOpType.QUERY_BY_KEYWORD;
        goto L160
    L70:
        if (r2.equals("syncReminder") == true) goto L72;
    L74:
        if (r2.equals("queryEnableEvents") == true) goto L76;
    L78:
        if (r2.equals("queryInstances") == true) goto L80;
    L82:
        if (r2.equals("query_instances_between") == false) goto L159;
    L154:
        r3 = CalendarOpType.QUERY_INSTANCES_BETWEEN;
        goto L160
    L85:
        if (r2.equals("merge_calendar") == false) goto L159;
    L134:
        r3 = CalendarOpType.MERGE_CALENDAR;
        goto L160
    L88:
        if (r2.equals("queryEvent") == false) goto L159;
    L110:
        r3 = CalendarOpType.QUERY_EVENT;
        goto L160
    L91:
        if (r2.equals("delete_event") == false) goto L159;
    L114:
        r3 = CalendarOpType.DELETE_EVENT;
        goto L160
    L94:
        if (r2.equals("addAttendee") == false) goto L159;
    L138:
        r3 = CalendarOpType.ADD_ATTENDEE;
        goto L160
    L97:
        if (r2.equals("updateEvent") == false) goto L159;
    L102:
        r3 = CalendarOpType.UPDATE_EVENT;
        goto L160
    L100:
        if (r2.equals("update_event") == true) goto L102;
    L104:
        if (r2.equals("query_by_keyword") == true) goto L106;
    L108:
        if (r2.equals("query_event") == true) goto L110;
    L112:
        if (r2.equals("deleteEvent") == true) goto L114;
    L116:
        if (r2.equals("update_reminder") == true) goto L118;
    L120:
        if (r2.equals("addEvent") == true) goto L122;
    L124:
        if (r2.equals("delete_calendar") == true) goto L126;
    L128:
        if (r2.equals("addReminder") == true) goto L130;
    L132:
        if (r2.equals("mergeCalendar") == true) goto L134;
    L136:
        if (r2.equals("add_attendee") == true) goto L138;
    L140:
        if (r2.equals("delete_reminder") == true) goto L142;
    L144:
        if (r2.equals("queryEventIdsOfInstances") == true) goto L146;
    L148:
        if (r2.equals("sync_event") == true) goto L150;
    L152:
        if (r2.equals("queryInstancesBetween") == true) goto L154;
    L156:
        if (r2.equals("sync_colors") == true) goto L158;
        goto L158
    }
}
