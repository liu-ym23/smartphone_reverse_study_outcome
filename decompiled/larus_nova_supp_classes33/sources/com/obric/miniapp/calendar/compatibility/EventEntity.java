package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.common.UiType;
import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vka.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class EventEntity {
    public static final String[] w0 = null;
    public final String A;
    public final boolean B;
    public final String C;
    public final boolean D;
    public final String E;
    public final boolean F;
    public final String G;
    public final boolean H;
    public final String I;
    public final boolean J;
    public final String K;
    public final boolean L;
    public final Long M;
    public final boolean N;
    public final Long O;
    public final boolean P;
    public final Integer Q;
    public final boolean R;
    public final String S;
    public final boolean T;
    public final Integer U;
    public final boolean V;
    public final EventFreq W;
    public final boolean X;
    public final Integer Y;
    public final boolean Z;
    public final Long a;
    public final Long a0;
    public final boolean b;
    public final boolean b0;
    public final Long c;
    public final Integer c0;
    public final boolean d;
    public final boolean d0;
    public final Long e;
    public final Integer e0;
    public final boolean f;
    public final boolean f0;
    public final String g;
    public final Long g0;
    public final boolean h;
    public final boolean h0;
    public final Long i;
    public final Long i0;
    public final boolean j;
    public final boolean j0;
    public final Long k;
    public final String k0;
    public final boolean l;
    public final boolean l0;
    public final Long m;
    public final String m0;
    public final boolean n;
    public final boolean n0;
    public final Long o;
    public final Boolean o0;
    public final boolean p;
    public final boolean p0;
    public final Long q;
    public final String q0;
    public final boolean r;
    public final boolean r0;
    public final Integer s;
    public final Long s0;
    public final boolean t;
    public final boolean t0;
    public final EventType u;
    public final String u0;
    public final boolean v;
    public final boolean v0;
    public final String w;
    public final boolean x;
    public final String y;
    public final boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/miniapp/calendar/compatibility/EventEntity$EventFreq;", "", "<init>", "(Ljava/lang/String;I)V", "DAILY", "WEEKLY", "MONTHLY", "YEARLY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EventFreq extends Enum<EventFreq> {
        public static final EventFreq DAILY = null;
        public static final EventFreq MONTHLY = null;
        public static final EventFreq WEEKLY = null;
        public static final EventFreq YEARLY = null;
        public static final /* synthetic */ EventFreq[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<EventFreq> getEntries() {
            return b;
        }

        static {
            EventFreq r0 = new EventFreq("DAILY", 0);
            DAILY = r0;
            EventFreq r1 = new EventFreq("WEEKLY", 1);
            WEEKLY = r1;
            EventFreq r3 = new EventFreq("MONTHLY", 2);
            MONTHLY = r3;
            EventFreq r5 = new EventFreq("YEARLY", 3);
            YEARLY = r5;
            EventFreq[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static EventFreq[] values() {
            return (EventFreq[]) a.clone();
        }

        public static EventFreq valueOf(String r1) {
            return (EventFreq) r27.a.a(EventFreq.class, r1);
        }

        public EventFreq(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/miniapp/calendar/compatibility/EventEntity$EventType;", "", "<init>", "(Ljava/lang/String;I)V", AlarmSessionType.EVENT, AlarmSessionType.TODO, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EventType extends Enum<EventType> {
        public static final EventType EVENT = null;
        public static final EventType TODO = null;
        public static final /* synthetic */ EventType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<EventType> getEntries() {
            return b;
        }

        static {
            EventType r0 = new EventType(AlarmSessionType.EVENT, 0);
            EVENT = r0;
            EventType r1 = new EventType(AlarmSessionType.TODO, 1);
            TODO = r1;
            EventType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static EventType[] values() {
            return (EventType[]) a.clone();
        }

        public static EventType valueOf(String r1) {
            return (EventType) r27.a.a(EventType.class, r1);
        }

        public EventType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static EventEntity a(Cursor r67) {
            Intrinsics.checkNotNullParameter(r67, "c");
            long r1 = r67.getLong(0);
            Long r5 = null;
            if (r67.isNull(1) == false) goto L5;
            String r3 = null;
        L6:
            if (r3 == null) goto L8;
            Long r4 = StringsKt.toLongOrNull(r3);
        L9:
            long r47 = r67.getLong(2);
            if (r67.isNull(3) == false) goto L12;
            String r6 = null;
        L13:
            if (r6 != null) goto L16;
            r6 = "";
        L16:
            if (r67.isNull(4) == false) goto L18;
            String r49 = null;
        L20:
            if (r67.isNull(5) == false) goto L22;
            String r50 = null;
        L24:
            if (r67.isNull(6) == false) goto L26;
            Integer r7 = null;
        L27:
            if (r7 == null) goto L29;
            String r51 = r7.toString();
        L30:
            long r52 = r67.getLong(7);
            if (r67.isNull(8) == false) goto L33;
            Long r54 = null;
        L35:
            if (r67.isNull(9) == false) goto L37;
            String r55 = null;
        L39:
            if (r67.isNull(10) == false) goto L41;
            Integer r56 = null;
        L43:
            if (r67.isNull(11) == false) goto L45;
            String r57 = null;
        L47:
            if (r67.isNull(12) == false) goto L49;
            String r58 = null;
        L51:
            if (r67.isNull(13) == false) goto L53;
            String r59 = null;
        L55:
            if (r67.isNull(14) == false) goto L57;
            String r60 = null;
        L59:
            if (r67.isNull(15) == false) goto L61;
            String r8 = null;
        L62:
            if (r8 == null) goto L64;
            Long r61 = StringsKt.toLongOrNull(r8);
        L66:
            if (r67.isNull(16) == false) goto L68;
            Long r62 = null;
        L70:
            if (r67.isNull(17) == false) goto L72;
            Integer r63 = null;
        L74:
            if (r67.isNull(18) == false) goto L76;
            String r64 = null;
        L78:
            if (r67.isNull(19) == false) goto L80;
            String r65 = null;
        L82:
            if (r67.isNull(21) == false) goto L84;
            String r66 = null;
        L151:
            JsonObject r0 = JsonParser.parseString(r67.getString(20)).getAsJsonObject();     // Catch: Exception -> L149
            Intrinsics.checkNotNull(r0);     // Catch: Exception -> L149
            JsonElement r9 = n.a(r0, "originalDtStart");     // Catch: Exception -> L149
            if (r9 == null) goto L89;
            Long r10 = Long.valueOf(r9.getAsLong());     // Catch: Exception -> L149
        L90:
            JsonElement r11 = n.a(r0, "eTag");     // Catch: Exception -> L149
            if (r11 == null) goto L93;
            Long r12 = Long.valueOf(r11.getAsLong());     // Catch: Exception -> L149
        L94:
            long r13 = r0.get("dtStamp").getAsLong();     // Catch: Exception -> L149
            long r14 = r0.get("createTime").getAsLong();     // Catch: Exception -> L149
            EventType r17 = EventType.valueOf(r0.get("eventType").getAsString());     // Catch: Exception -> L149
            JsonElement r15 = n.a(r0, "iCalStr");     // Catch: Exception -> L149
            if (r15 == null) goto L97;
            String r29 = r15.getAsString();     // Catch: Exception -> L149
        L98:
            JsonElement r16 = n.a(r0, "isCompleted");     // Catch: Exception -> L149
            if (r16 == null) goto L101;
            Integer r30 = Integer.valueOf(r16.getAsInt());     // Catch: Exception -> L149
        L102:
            JsonElement r18 = n.a(r0, "freq");     // Catch: Exception -> L149
            if (r18 == null) goto L107;
            String r19 = r18.getAsString();     // Catch: Exception -> L149
            if (r19 == null) goto L107;
            EventFreq r31 = EventFreq.valueOf(r19);     // Catch: Exception -> L149
        L108:
            JsonElement r110 = n.a(r0, "interval");     // Catch: Exception -> L149
            if (r110 == null) goto L111;
            Integer r32 = Integer.valueOf(r110.getAsInt());     // Catch: Exception -> L149
        L112:
            JsonElement r111 = n.a(r0, "until");     // Catch: Exception -> L149
            if (r111 == null) goto L115;
            Long r33 = Long.valueOf(r111.getAsLong());     // Catch: Exception -> L149
        L116:
            JsonElement r112 = n.a(r0, "exStatus");     // Catch: Exception -> L149
            if (r112 == null) goto L119;
            Integer r34 = Integer.valueOf(r112.getAsInt());     // Catch: Exception -> L149
        L120:
            JsonElement r113 = n.a(r0, "index");     // Catch: Exception -> L149
            if (r113 == null) goto L123;
            Integer r35 = Integer.valueOf(r113.getAsInt());     // Catch: Exception -> L149
        L124:
            JsonElement r114 = n.a(r0, "exDtStart");     // Catch: Exception -> L149
            if (r114 == null) goto L127;
            Long r36 = Long.valueOf(r114.getAsLong());     // Catch: Exception -> L149
        L128:
            JsonElement r115 = n.a(r0, "exDtEnd");     // Catch: Exception -> L149
            if (r115 == null) goto L131;
            Long r37 = Long.valueOf(r115.getAsLong());     // Catch: Exception -> L149
        L132:
            JsonElement r116 = n.a(r0, "syncStatus");     // Catch: Exception -> L149
            if (r116 == null) goto L135;
            String r38 = r116.getAsString();     // Catch: Exception -> L149
        L136:
            JsonElement r117 = n.a(r0, "isNoTimeTodo");     // Catch: Exception -> L149
            if (r117 == null) goto L139;
            Boolean r40 = Boolean.valueOf(r117.getAsBoolean());     // Catch: Exception -> L149
        L140:
            JsonElement r2 = n.a(r0, "completeTime");     // Catch: Exception -> L149
            if (r2 == null) goto L143;
            r5 = Long.valueOf(r2.getAsLong());     // Catch: Exception -> L149
        L143:
            Long r42 = r5;
            if (r10 == null) goto L146;
            long r20 = r10.longValue();     // Catch: Exception -> L149
        L147:
            return new EventEntity(Long.valueOf(r1), r4, Long.valueOf(r47), r6, Long.valueOf(r20), r12, r54, Long.valueOf(r13), Long.valueOf(r14), r56, r17, r50, r49, r51, r55, r57, r58, r59, r60, r61, r62, r63, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r66, r40, r64, r42, r65, -1431655766, -1431655766, 682);
        L146:
            r20 = r52;
            goto L147
        L139:
            r40 = null;
            goto L140
        L135:
            r38 = null;
            goto L136
        L131:
            r37 = null;
            goto L132
        L127:
            r36 = null;
            goto L128
        L123:
            r35 = null;
            goto L124
        L119:
            r34 = null;
            goto L120
        L115:
            r33 = null;
            goto L116
        L111:
            r32 = null;
        L107:
            r31 = null;
            goto L108
        L101:
            r30 = null;
            goto L102
        L97:
            r29 = null;
            goto L98
        L93:
            r12 = null;
            goto L94
        L89:
            r10 = null;
        L150:
            return new EventEntity(Long.valueOf(r1), r4, Long.valueOf(r47), r6, Long.valueOf(r52), null, r54, 0L, 0L, r56, EventType.EVENT, r50, r49, r51, r55, r57, r58, r59, r60, r61, r62, r63, null, null, null, null, null, null, null, null, null, null, r66, null, r64, null, r65, -1431654742, -1366, 750);
        L84:
            r66 = r67.getString(21);
            goto L151
        L80:
            r65 = r67.getString(19);
            goto L82
        L76:
            r64 = r67.getString(18);
            goto L78
        L72:
            r63 = Integer.valueOf(r67.getInt(17));
            goto L74
        L68:
            r62 = Long.valueOf(r67.getLong(16));
            goto L70
        L64:
            r61 = null;
            goto L66
        L61:
            r8 = r67.getString(15);
            goto L62
        L57:
            r60 = r67.getString(14);
            goto L59
        L53:
            r59 = r67.getString(13);
            goto L55
        L49:
            r58 = r67.getString(12);
            goto L51
        L45:
            r57 = r67.getString(11);
            goto L47
        L41:
            r56 = Integer.valueOf(r67.getInt(10));
            goto L43
        L37:
            r55 = r67.getString(9);
            goto L39
        L33:
            r54 = Long.valueOf(r67.getLong(8));
            goto L35
        L29:
            r51 = null;
            goto L30
        L26:
            r7 = Integer.valueOf(r67.getInt(6));
            goto L27
        L22:
            r50 = r67.getString(5);
            goto L24
        L18:
            r49 = r67.getString(4);
            goto L20
        L12:
            r6 = r67.getString(3);
            goto L13
        L8:
            r4 = null;
            goto L9
        L5:
            r3 = r67.getString(1);
            goto L6
        }

        public static EventEntity b(JsonObject r114) {
            Intrinsics.checkNotNullParameter(r114, "json");
            boolean r41 = r114.has("id");     // Catch: Exception -> L158
            JsonElement r7 = n.a(r114, "id");     // Catch: Exception -> L158
            if (r7 == null) goto L6;
            Long r40 = Long.valueOf(r7.getAsLong());     // Catch: Exception -> L158
        L7:
            boolean r43 = r114.has("uuid");     // Catch: Exception -> L158
            JsonElement r6 = n.a(r114, "uuid");     // Catch: Exception -> L158
            if (r6 == null) goto L10;
            Long r42 = Long.valueOf(r6.getAsLong());     // Catch: Exception -> L158
        L11:
            boolean r45 = r114.has("calendar_id");     // Catch: Exception -> L158
            JsonElement r5 = n.a(r114, "calendar_id");     // Catch: Exception -> L158
            if (r5 == null) goto L14;
            Long r44 = Long.valueOf(r5.getAsLong());     // Catch: Exception -> L158
        L15:
            boolean r47 = r114.has("title");     // Catch: Exception -> L158
            JsonElement r4 = n.a(r114, "title");     // Catch: Exception -> L158
            if (r4 == null) goto L18;
            String r46 = r4.getAsString();     // Catch: Exception -> L158
        L19:
            boolean r49 = r114.has("dtstart");     // Catch: Exception -> L158
            JsonElement r3 = n.a(r114, "dtstart");     // Catch: Exception -> L158
            if (r3 == null) goto L22;
            Long r48 = Long.valueOf(r3.getAsLong());     // Catch: Exception -> L158
        L23:
            boolean r51 = r114.has("etag");     // Catch: Exception -> L158
            JsonElement r2 = n.a(r114, "etag");     // Catch: Exception -> L158
            if (r2 == null) goto L26;
            Long r50 = Long.valueOf(r2.getAsLong());     // Catch: Exception -> L158
        L27:
            boolean r53 = r114.has("dtend");     // Catch: Exception -> L158
            JsonElement r1 = n.a(r114, "dtend");     // Catch: Exception -> L158
            if (r1 == null) goto L30;
            Long r52 = Long.valueOf(r1.getAsLong());     // Catch: Exception -> L158
        L31:
            boolean r55 = r114.has("dtstamp");     // Catch: Exception -> L158
            JsonElement r8 = n.a(r114, "dtstamp");     // Catch: Exception -> L158
            if (r8 == null) goto L34;
            Long r54 = Long.valueOf(r8.getAsLong());     // Catch: Exception -> L158
        L35:
            boolean r57 = r114.has("create_time");     // Catch: Exception -> L158
            JsonElement r9 = n.a(r114, "create_time");     // Catch: Exception -> L158
            if (r9 == null) goto L38;
            Long r56 = Long.valueOf(r9.getAsLong());     // Catch: Exception -> L158
        L39:
            boolean r59 = r114.has("all_day");     // Catch: Exception -> L158
            JsonElement r10 = n.a(r114, "all_day");     // Catch: Exception -> L158
            if (r10 == null) goto L42;
            Integer r58 = Integer.valueOf(r10.getAsInt());     // Catch: Exception -> L158
        L43:
            boolean r61 = r114.has("event_type");     // Catch: Exception -> L158
            JsonElement r11 = n.a(r114, "event_type");     // Catch: Exception -> L158
            if (r11 == null) goto L48;
            String r12 = r11.getAsString();     // Catch: Exception -> L158
            if (r12 == null) goto L48;
            EventType r60 = EventType.valueOf(r12);     // Catch: Exception -> L158
        L49:
            boolean r63 = r114.has("description");     // Catch: Exception -> L158
            JsonElement r13 = n.a(r114, "description");     // Catch: Exception -> L158
            if (r13 == null) goto L52;
            String r62 = r13.getAsString();     // Catch: Exception -> L158
        L53:
            boolean r65 = r114.has("event_location");     // Catch: Exception -> L158
            JsonElement r14 = n.a(r114, "event_location");     // Catch: Exception -> L158
            if (r14 == null) goto L56;
            String r64 = r14.getAsString();     // Catch: Exception -> L158
        L57:
            boolean r67 = r114.has("event_color");     // Catch: Exception -> L158
            JsonElement r15 = n.a(r114, "event_color");     // Catch: Exception -> L158
            if (r15 == null) goto L60;
            String r66 = r15.getAsString();     // Catch: Exception -> L158
        L61:
            boolean r69 = r114.has("duration");     // Catch: Exception -> L158
            JsonElement r16 = n.a(r114, "duration");     // Catch: Exception -> L158
            if (r16 == null) goto L64;
            String r68 = r16.getAsString();     // Catch: Exception -> L158
        L65:
            boolean r71 = r114.has("rrule");     // Catch: Exception -> L158
            JsonElement r17 = n.a(r114, "rrule");     // Catch: Exception -> L158
            if (r17 == null) goto L68;
            String r70 = r17.getAsString();     // Catch: Exception -> L158
        L69:
            boolean r73 = r114.has("rdate");     // Catch: Exception -> L158
            JsonElement r18 = n.a(r114, "rdate");     // Catch: Exception -> L158
            if (r18 == null) goto L72;
            String r72 = r18.getAsString();     // Catch: Exception -> L158
        L73:
            boolean r75 = r114.has("exrule");     // Catch: Exception -> L158
            JsonElement r19 = n.a(r114, "exrule");     // Catch: Exception -> L158
            if (r19 == null) goto L76;
            String r74 = r19.getAsString();     // Catch: Exception -> L158
        L77:
            boolean r77 = r114.has("exdate");     // Catch: Exception -> L158
            JsonElement r20 = n.a(r114, "exdate");     // Catch: Exception -> L158
            if (r20 == null) goto L80;
            String r76 = r20.getAsString();     // Catch: Exception -> L158
        L81:
            boolean r79 = r114.has("original_id");     // Catch: Exception -> L158
            JsonElement r21 = n.a(r114, "original_id");     // Catch: Exception -> L158
            if (r21 == null) goto L84;
            Long r78 = Long.valueOf(r21.getAsLong());     // Catch: Exception -> L158
        L85:
            boolean r81 = r114.has("original_instance_time");     // Catch: Exception -> L158
            JsonElement r22 = n.a(r114, "original_instance_time");     // Catch: Exception -> L158
            if (r22 == null) goto L88;
            Long r80 = Long.valueOf(r22.getAsLong());     // Catch: Exception -> L158
        L89:
            boolean r83 = r114.has("original_all_day");     // Catch: Exception -> L158
            JsonElement r23 = n.a(r114, "original_all_day");     // Catch: Exception -> L158
            if (r23 == null) goto L92;
            Integer r82 = Integer.valueOf(r23.getAsInt());     // Catch: Exception -> L158
        L93:
            boolean r85 = r114.has("ical_str");     // Catch: Exception -> L158
            JsonElement r24 = n.a(r114, "ical_str");     // Catch: Exception -> L158
            if (r24 == null) goto L96;
            String r84 = r24.getAsString();     // Catch: Exception -> L158
        L97:
            boolean r87 = r114.has("is_completed");     // Catch: Exception -> L158
            JsonElement r25 = n.a(r114, "is_completed");     // Catch: Exception -> L158
            if (r25 == null) goto L100;
            Integer r86 = Integer.valueOf(r25.getAsInt());     // Catch: Exception -> L158
        L101:
            boolean r89 = r114.has("freq");     // Catch: Exception -> L158
            JsonElement r26 = n.a(r114, "freq");     // Catch: Exception -> L158
            if (r26 == null) goto L106;
            String r27 = r26.getAsString();     // Catch: Exception -> L158
            if (r27 == null) goto L106;
            EventFreq r88 = EventFreq.valueOf(r27);     // Catch: Exception -> L158
        L107:
            boolean r91 = r114.has("interval");     // Catch: Exception -> L158
            JsonElement r28 = n.a(r114, "interval");     // Catch: Exception -> L158
            if (r28 == null) goto L110;
            Integer r90 = Integer.valueOf(r28.getAsInt());     // Catch: Exception -> L158
        L111:
            boolean r93 = r114.has("until");     // Catch: Exception -> L158
            JsonElement r29 = n.a(r114, "until");     // Catch: Exception -> L158
            if (r29 == null) goto L114;
            Long r92 = Long.valueOf(r29.getAsLong());     // Catch: Exception -> L158
        L115:
            boolean r95 = r114.has("exstatus");     // Catch: Exception -> L158
            JsonElement r30 = n.a(r114, "exstatus");     // Catch: Exception -> L158
            if (r30 == null) goto L118;
            Integer r94 = Integer.valueOf(r30.getAsInt());     // Catch: Exception -> L158
        L119:
            boolean r97 = r114.has("index");     // Catch: Exception -> L158
            JsonElement r31 = n.a(r114, "index");     // Catch: Exception -> L158
            if (r31 == null) goto L122;
            Integer r96 = Integer.valueOf(r31.getAsInt());     // Catch: Exception -> L158
        L123:
            boolean r99 = r114.has("exdtstart");     // Catch: Exception -> L158
            JsonElement r32 = n.a(r114, "exdtstart");     // Catch: Exception -> L158
            if (r32 == null) goto L126;
            Long r98 = Long.valueOf(r32.getAsLong());     // Catch: Exception -> L158
        L127:
            boolean r101 = r114.has("exdtend");     // Catch: Exception -> L158
            JsonElement r33 = n.a(r114, "exdtend");     // Catch: Exception -> L158
            if (r33 == null) goto L130;
            Long r100 = Long.valueOf(r33.getAsLong());     // Catch: Exception -> L158
        L131:
            boolean r105 = r114.has("lark_uuid");     // Catch: Exception -> L158
            JsonElement r34 = n.a(r114, "lark_uuid");     // Catch: Exception -> L158
            if (r34 == null) goto L134;
            String r104 = r34.getAsString();     // Catch: Exception -> L158
        L135:
            boolean r103 = r114.has("sync_status");     // Catch: Exception -> L158
            JsonElement r35 = n.a(r114, "sync_status");     // Catch: Exception -> L158
            if (r35 == null) goto L138;
            String r102 = r35.getAsString();     // Catch: Exception -> L158
        L139:
            boolean r107 = r114.has("is_no_time_todo");     // Catch: Exception -> L158
            JsonElement r36 = n.a(r114, "is_no_time_todo");     // Catch: Exception -> L158
            if (r36 == null) goto L142;
            Boolean r106 = Boolean.valueOf(r36.getAsBoolean());     // Catch: Exception -> L158
        L143:
            boolean r109 = r114.has("memory_extra");     // Catch: Exception -> L158
            JsonElement r37 = n.a(r114, "memory_extra");     // Catch: Exception -> L158
            if (r37 == null) goto L146;
            String r108 = r37.getAsString();     // Catch: Exception -> L158
        L147:
            boolean r111 = r114.has("completed_time");     // Catch: Exception -> L158
            JsonElement r38 = n.a(r114, "completed_time");     // Catch: Exception -> L158
            if (r38 == null) goto L150;
            Long r110 = Long.valueOf(r38.getAsLong());     // Catch: Exception -> L158
        L151:
            boolean r113 = r114.has("extra_location_info");     // Catch: Exception -> L158
            JsonElement r0 = n.a(r114, "extra_location_info");     // Catch: Exception -> L158
            if (r0 == null) goto L154;
            String r112 = r0.getAsString();     // Catch: Exception -> L158
        L155:
            return new EventEntity(r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113);
        L154:
            r112 = null;
            goto L155
        L150:
            r110 = null;
            goto L151
        L146:
            r108 = null;
            goto L147
        L142:
            r106 = null;
            goto L143
        L138:
            r102 = null;
            goto L139
        L134:
            r104 = null;
            goto L135
        L130:
            r100 = null;
            goto L131
        L126:
            r98 = null;
            goto L127
        L122:
            r96 = null;
            goto L123
        L118:
            r94 = null;
            goto L119
        L114:
            r92 = null;
            goto L115
        L110:
            r90 = null;
        L106:
            r88 = null;
            goto L107
        L100:
            r86 = null;
            goto L101
        L96:
            r84 = null;
            goto L97
        L92:
            r82 = null;
            goto L93
        L88:
            r80 = null;
            goto L89
        L84:
            r78 = null;
            goto L85
        L80:
            r76 = null;
            goto L81
        L76:
            r74 = null;
            goto L77
        L72:
            r72 = null;
            goto L73
        L68:
            r70 = null;
            goto L69
        L64:
            r68 = null;
            goto L65
        L60:
            r66 = null;
            goto L61
        L56:
            r64 = null;
            goto L57
        L52:
            r62 = null;
        L48:
            r60 = null;
            goto L49
        L42:
            r58 = null;
            goto L43
        L38:
            r56 = null;
            goto L39
        L34:
            r54 = null;
            goto L35
        L30:
            r52 = null;
            goto L31
        L26:
            r50 = null;
            goto L27
        L22:
            r48 = null;
            goto L23
        L18:
            r46 = null;
            goto L19
        L14:
            r44 = null;
            goto L15
        L10:
            r42 = null;
            goto L11
        L6:
            r40 = null;
        L161:
            return null;
        }
    }

    public EventEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EventEntity) == true) goto L8;
        return false;
    L8:
        EventEntity r6 = (EventEntity) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (this.t == r6.t) goto L69;
        return false;
    L69:
        if (this.u == r6.u) goto L72;
        return false;
    L72:
        if (this.v == r6.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (this.x == r6.x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
        return false;
    L84:
        if (this.z == r6.z) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r6.A) == true) goto L90;
        return false;
    L90:
        if (this.B == r6.B) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r6.C) == true) goto L96;
        return false;
    L96:
        if (this.D == r6.D) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.E, r6.E) == true) goto L102;
        return false;
    L102:
        if (this.F == r6.F) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.G, r6.G) == true) goto L108;
        return false;
    L108:
        if (this.H == r6.H) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r6.I) == true) goto L114;
        return false;
    L114:
        if (this.J == r6.J) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.K, r6.K) == true) goto L120;
        return false;
    L120:
        if (this.L == r6.L) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.M, r6.M) == true) goto L126;
        return false;
    L126:
        if (this.N == r6.N) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.O, r6.O) == true) goto L132;
        return false;
    L132:
        if (this.P == r6.P) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.Q, r6.Q) == true) goto L138;
        return false;
    L138:
        if (this.R == r6.R) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.S, r6.S) == true) goto L144;
        return false;
    L144:
        if (this.T == r6.T) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.U, r6.U) == true) goto L150;
        return false;
    L150:
        if (this.V == r6.V) goto L153;
        return false;
    L153:
        if (this.W == r6.W) goto L156;
        return false;
    L156:
        if (this.X == r6.X) goto L159;
        return false;
    L159:
        if (Intrinsics.areEqual(this.Y, r6.Y) == true) goto L162;
        return false;
    L162:
        if (this.Z == r6.Z) goto L165;
        return false;
    L165:
        if (Intrinsics.areEqual(this.a0, r6.a0) == true) goto L168;
        return false;
    L168:
        if (this.b0 == r6.b0) goto L171;
        return false;
    L171:
        if (Intrinsics.areEqual(this.c0, r6.c0) == true) goto L174;
        return false;
    L174:
        if (this.d0 == r6.d0) goto L177;
        return false;
    L177:
        if (Intrinsics.areEqual(this.e0, r6.e0) == true) goto L180;
        return false;
    L180:
        if (this.f0 == r6.f0) goto L183;
        return false;
    L183:
        if (Intrinsics.areEqual(this.g0, r6.g0) == true) goto L186;
        return false;
    L186:
        if (this.h0 == r6.h0) goto L189;
        return false;
    L189:
        if (Intrinsics.areEqual(this.i0, r6.i0) == true) goto L192;
        return false;
    L192:
        if (this.j0 == r6.j0) goto L195;
        return false;
    L195:
        if (Intrinsics.areEqual(this.k0, r6.k0) == true) goto L198;
        return false;
    L198:
        if (this.l0 == r6.l0) goto L201;
        return false;
    L201:
        if (Intrinsics.areEqual(this.m0, r6.m0) == true) goto L204;
        return false;
    L204:
        if (this.n0 == r6.n0) goto L207;
        return false;
    L207:
        if (Intrinsics.areEqual(this.o0, r6.o0) == true) goto L210;
        return false;
    L210:
        if (this.p0 == r6.p0) goto L213;
        return false;
    L213:
        if (Intrinsics.areEqual(this.q0, r6.q0) == true) goto L216;
        return false;
    L216:
        if (this.r0 == r6.r0) goto L219;
        return false;
    L219:
        if (Intrinsics.areEqual(this.s0, r6.s0) == true) goto L222;
        return false;
    L222:
        if (this.t0 == r6.t0) goto L225;
        return false;
    L225:
        if (Intrinsics.areEqual(this.u0, r6.u0) == true) goto L228;
        return false;
    L228:
        if (this.v0 == r6.v0) goto L230;
        return false;
    L230:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.b == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.d == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        Long r12 = this.e;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        if (this.f == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (r14 + r15) * 31;
        String r17 = this.g;
        if (r17 != null) goto L29;
        int r18 = 0;
    L30:
        int r19 = (r16 + r18) * 31;
        if (this.h == false) goto L33;
        int r20 = 1231;
    L34:
        int r21 = (r19 + r20) * 31;
        Long r22 = this.i;
        if (r22 != null) goto L37;
        int r23 = 0;
    L38:
        int r24 = (r21 + r23) * 31;
        if (this.j == false) goto L41;
        int r25 = 1231;
    L42:
        int r26 = (r24 + r25) * 31;
        Long r27 = this.k;
        if (r27 != null) goto L45;
        int r28 = 0;
    L46:
        int r29 = (r26 + r28) * 31;
        if (this.l == false) goto L49;
        int r30 = 1231;
    L50:
        int r31 = (r29 + r30) * 31;
        Long r32 = this.m;
        if (r32 != null) goto L53;
        int r33 = 0;
    L54:
        int r34 = (r31 + r33) * 31;
        if (this.n == false) goto L57;
        int r35 = 1231;
    L58:
        int r36 = (r34 + r35) * 31;
        Long r37 = this.o;
        if (r37 != null) goto L61;
        int r38 = 0;
    L62:
        int r39 = (r36 + r38) * 31;
        if (this.p == false) goto L65;
        int r40 = 1231;
    L66:
        int r41 = (r39 + r40) * 31;
        Long r42 = this.q;
        if (r42 != null) goto L69;
        int r43 = 0;
    L70:
        int r44 = (r41 + r43) * 31;
        if (this.r == false) goto L73;
        int r45 = 1231;
    L74:
        int r46 = (r44 + r45) * 31;
        Integer r47 = this.s;
        if (r47 != null) goto L77;
        int r48 = 0;
    L78:
        int r49 = (r46 + r48) * 31;
        if (this.t == false) goto L81;
        int r50 = 1231;
    L82:
        int r51 = (r49 + r50) * 31;
        EventType r52 = this.u;
        if (r52 != null) goto L85;
        int r53 = 0;
    L86:
        int r54 = (r51 + r53) * 31;
        if (this.v == false) goto L89;
        int r55 = 1231;
    L90:
        int r56 = (r54 + r55) * 31;
        String r57 = this.w;
        if (r57 != null) goto L93;
        int r58 = 0;
    L94:
        int r59 = (r56 + r58) * 31;
        if (this.x == false) goto L97;
        int r60 = 1231;
    L98:
        int r61 = (r59 + r60) * 31;
        String r62 = this.y;
        if (r62 != null) goto L101;
        int r63 = 0;
    L102:
        int r64 = (r61 + r63) * 31;
        if (this.z == false) goto L105;
        int r65 = 1231;
    L106:
        int r66 = (r64 + r65) * 31;
        String r67 = this.A;
        if (r67 != null) goto L109;
        int r68 = 0;
    L110:
        int r69 = (r66 + r68) * 31;
        if (this.B == false) goto L113;
        int r70 = 1231;
    L114:
        int r71 = (r69 + r70) * 31;
        String r72 = this.C;
        if (r72 != null) goto L117;
        int r73 = 0;
    L118:
        int r74 = (r71 + r73) * 31;
        if (this.D == false) goto L121;
        int r75 = 1231;
    L122:
        int r76 = (r74 + r75) * 31;
        String r77 = this.E;
        if (r77 != null) goto L125;
        int r78 = 0;
    L126:
        int r79 = (r76 + r78) * 31;
        if (this.F == false) goto L129;
        int r80 = 1231;
    L130:
        int r81 = (r79 + r80) * 31;
        String r82 = this.G;
        if (r82 != null) goto L133;
        int r83 = 0;
    L134:
        int r84 = (r81 + r83) * 31;
        if (this.H == false) goto L137;
        int r85 = 1231;
    L138:
        int r86 = (r84 + r85) * 31;
        String r87 = this.I;
        if (r87 != null) goto L141;
        int r88 = 0;
    L142:
        int r89 = (r86 + r88) * 31;
        if (this.J == false) goto L145;
        int r90 = 1231;
    L146:
        int r91 = (r89 + r90) * 31;
        String r92 = this.K;
        if (r92 != null) goto L149;
        int r93 = 0;
    L150:
        int r94 = (r91 + r93) * 31;
        if (this.L == false) goto L153;
        int r95 = 1231;
    L154:
        int r96 = (r94 + r95) * 31;
        Long r97 = this.M;
        if (r97 != null) goto L157;
        int r98 = 0;
    L158:
        int r99 = (r96 + r98) * 31;
        if (this.N == false) goto L161;
        int r100 = 1231;
    L162:
        int r101 = (r99 + r100) * 31;
        Long r102 = this.O;
        if (r102 != null) goto L165;
        int r103 = 0;
    L166:
        int r104 = (r101 + r103) * 31;
        if (this.P == false) goto L169;
        int r105 = 1231;
    L170:
        int r106 = (r104 + r105) * 31;
        Integer r107 = this.Q;
        if (r107 != null) goto L173;
        int r108 = 0;
    L174:
        int r109 = (r106 + r108) * 31;
        if (this.R == false) goto L177;
        int r110 = 1231;
    L178:
        int r111 = (r109 + r110) * 31;
        String r112 = this.S;
        if (r112 != null) goto L181;
        int r113 = 0;
    L182:
        int r114 = (r111 + r113) * 31;
        if (this.T == false) goto L185;
        int r115 = 1231;
    L186:
        int r116 = (r114 + r115) * 31;
        Integer r117 = this.U;
        if (r117 != null) goto L189;
        int r118 = 0;
    L190:
        int r119 = (r116 + r118) * 31;
        if (this.V == false) goto L193;
        int r120 = 1231;
    L194:
        int r121 = (r119 + r120) * 31;
        EventFreq r122 = this.W;
        if (r122 != null) goto L197;
        int r123 = 0;
    L198:
        int r124 = (r121 + r123) * 31;
        if (this.X == false) goto L201;
        int r125 = 1231;
    L202:
        int r126 = (r124 + r125) * 31;
        Integer r127 = this.Y;
        if (r127 != null) goto L205;
        int r128 = 0;
    L206:
        int r129 = (r126 + r128) * 31;
        if (this.Z == false) goto L209;
        int r130 = 1231;
    L210:
        int r131 = (r129 + r130) * 31;
        Long r132 = this.a0;
        if (r132 != null) goto L213;
        int r133 = 0;
    L214:
        int r134 = (r131 + r133) * 31;
        if (this.b0 == false) goto L217;
        int r135 = 1231;
    L218:
        int r136 = (r134 + r135) * 31;
        Integer r137 = this.c0;
        if (r137 != null) goto L221;
        int r138 = 0;
    L222:
        int r139 = (r136 + r138) * 31;
        if (this.d0 == false) goto L225;
        int r140 = 1231;
    L226:
        int r141 = (r139 + r140) * 31;
        Integer r142 = this.e0;
        if (r142 != null) goto L229;
        int r143 = 0;
    L230:
        int r144 = (r141 + r143) * 31;
        if (this.f0 == false) goto L233;
        int r145 = 1231;
    L234:
        int r146 = (r144 + r145) * 31;
        Long r147 = this.g0;
        if (r147 != null) goto L237;
        int r148 = 0;
    L238:
        int r149 = (r146 + r148) * 31;
        if (this.h0 == false) goto L241;
        int r150 = 1231;
    L242:
        int r151 = (r149 + r150) * 31;
        Long r152 = this.i0;
        if (r152 != null) goto L245;
        int r153 = 0;
    L246:
        int r154 = (r151 + r153) * 31;
        if (this.j0 == false) goto L249;
        int r155 = 1231;
    L250:
        int r156 = (r154 + r155) * 31;
        String r157 = this.k0;
        if (r157 != null) goto L253;
        int r158 = 0;
    L254:
        int r159 = (r156 + r158) * 31;
        if (this.l0 == false) goto L257;
        int r160 = 1231;
    L258:
        int r161 = (r159 + r160) * 31;
        String r162 = this.m0;
        if (r162 != null) goto L261;
        int r163 = 0;
    L262:
        int r164 = (r161 + r163) * 31;
        if (this.n0 == false) goto L265;
        int r165 = 1231;
    L266:
        int r166 = (r164 + r165) * 31;
        Boolean r167 = this.o0;
        if (r167 != null) goto L269;
        int r168 = 0;
    L270:
        int r169 = (r166 + r168) * 31;
        if (this.p0 == false) goto L273;
        int r170 = 1231;
    L274:
        int r171 = (r169 + r170) * 31;
        String r172 = this.q0;
        if (r172 != null) goto L277;
        int r173 = 0;
    L278:
        int r174 = (r171 + r173) * 31;
        if (this.r0 == false) goto L281;
        int r175 = 1231;
    L282:
        int r176 = (r174 + r175) * 31;
        Long r177 = this.s0;
        if (r177 != null) goto L285;
        int r178 = 0;
    L286:
        int r179 = (r176 + r178) * 31;
        if (this.t0 == false) goto L289;
        int r180 = 1231;
    L290:
        int r181 = (r179 + r180) * 31;
        String r182 = this.u0;
        if (r182 == null) goto L294;
        r1 = r182.hashCode();
    L294:
        int r183 = (r181 + r1) * 31;
        if (this.v0 == true) goto L299;
        r4 = 1237;
    L299:
        return r183 + r4;
    L289:
        r180 = 1237;
        goto L290
    L285:
        r178 = r177.hashCode();
        goto L286
    L281:
        r175 = 1237;
        goto L282
    L277:
        r173 = r172.hashCode();
        goto L278
    L273:
        r170 = 1237;
        goto L274
    L269:
        r168 = r167.hashCode();
        goto L270
    L265:
        r165 = 1237;
        goto L266
    L261:
        r163 = r162.hashCode();
        goto L262
    L257:
        r160 = 1237;
        goto L258
    L253:
        r158 = r157.hashCode();
        goto L254
    L249:
        r155 = 1237;
        goto L250
    L245:
        r153 = r152.hashCode();
        goto L246
    L241:
        r150 = 1237;
        goto L242
    L237:
        r148 = r147.hashCode();
        goto L238
    L233:
        r145 = 1237;
        goto L234
    L229:
        r143 = r142.hashCode();
        goto L230
    L225:
        r140 = 1237;
        goto L226
    L221:
        r138 = r137.hashCode();
        goto L222
    L217:
        r135 = 1237;
        goto L218
    L213:
        r133 = r132.hashCode();
        goto L214
    L209:
        r130 = 1237;
        goto L210
    L205:
        r128 = r127.hashCode();
        goto L206
    L201:
        r125 = 1237;
        goto L202
    L197:
        r123 = r122.hashCode();
        goto L198
    L193:
        r120 = 1237;
        goto L194
    L189:
        r118 = r117.hashCode();
        goto L190
    L185:
        r115 = 1237;
        goto L186
    L181:
        r113 = r112.hashCode();
        goto L182
    L177:
        r110 = 1237;
        goto L178
    L173:
        r108 = r107.hashCode();
        goto L174
    L169:
        r105 = 1237;
        goto L170
    L165:
        r103 = r102.hashCode();
        goto L166
    L161:
        r100 = 1237;
        goto L162
    L157:
        r98 = r97.hashCode();
        goto L158
    L153:
        r95 = 1237;
        goto L154
    L149:
        r93 = r92.hashCode();
        goto L150
    L145:
        r90 = 1237;
        goto L146
    L141:
        r88 = r87.hashCode();
        goto L142
    L137:
        r85 = 1237;
        goto L138
    L133:
        r83 = r82.hashCode();
        goto L134
    L129:
        r80 = 1237;
        goto L130
    L125:
        r78 = r77.hashCode();
        goto L126
    L121:
        r75 = 1237;
        goto L122
    L117:
        r73 = r72.hashCode();
        goto L118
    L113:
        r70 = 1237;
        goto L114
    L109:
        r68 = r67.hashCode();
        goto L110
    L105:
        r65 = 1237;
        goto L106
    L101:
        r63 = r62.hashCode();
        goto L102
    L97:
        r60 = 1237;
        goto L98
    L93:
        r58 = r57.hashCode();
        goto L94
    L89:
        r55 = 1237;
        goto L90
    L85:
        r53 = r52.hashCode();
        goto L86
    L81:
        r50 = 1237;
        goto L82
    L77:
        r48 = r47.hashCode();
        goto L78
    L73:
        r45 = 1237;
        goto L74
    L69:
        r43 = r42.hashCode();
        goto L70
    L65:
        r40 = 1237;
        goto L66
    L61:
        r38 = r37.hashCode();
        goto L62
    L57:
        r35 = 1237;
        goto L58
    L53:
        r33 = r32.hashCode();
        goto L54
    L49:
        r30 = 1237;
        goto L50
    L45:
        r28 = r27.hashCode();
        goto L46
    L41:
        r25 = 1237;
        goto L42
    L37:
        r23 = r22.hashCode();
        goto L38
    L33:
        r20 = 1237;
        goto L34
    L29:
        r18 = r17.hashCode();
        goto L30
    L25:
        r15 = 1237;
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "EventEntity(id=" + this.a + ", hasId=" + this.b + ", uuid=" + this.c + ", hasUuid=" + this.d + ", calendarId=" + this.e + ", hasCalendarId=" + this.f + ", title=" + this.g + ", hasTitle=" + this.h + ", dtStart=" + this.i + ", hasDtStart=" + this.j + ", eTag=" + this.k + ", hasETag=" + this.l + ", dtEnd=" + this.m + ", hasDtEnd=" + this.n + ", dtStamp=" + this.o + ", hasDtStamp=" + this.p + ", createTime=" + this.q + ", hasCreateTime=" + this.r + ", allDay=" + this.s + ", hasAllDay=" + this.t + ", eventType=" + this.u + ", hasEventType=" + this.v + ", description=" + this.w + ", hasDescription=" + this.x + ", eventLocation=" + this.y + ", hasEventLocation=" + this.z + ", eventColor=" + this.A + ", hasEventColor=" + this.B + ", duration=" + this.C + ", hasDuration=" + this.D + ", rRule=" + this.E + ", hasRRule=" + this.F + ", rDate=" + this.G + ", hasRDate=" + this.H + ", exRule=" + this.I + ", hasExRule=" + this.J + ", exDate=" + this.K + ", hasExDate=" + this.L + ", originalId=" + this.M + ", hasOriginalId=" + this.N + ", originalInstanceTime=" + this.O + ", hasOriginalInstanceTime=" + this.P + ", originalAllDay=" + this.Q + ", hasOriginalAllDay=" + this.R + ", iCalStr=" + this.S + ", hasICalStr=" + this.T + ", isCompleted=" + this.U + ", hasIsCompleted=" + this.V + ", freq=" + this.W + ", hasFreq=" + this.X + ", interval=" + this.Y + ", hasInterval=" + this.Z + ", until=" + this.a0 + ", hasUntil=" + this.b0 + ", exStatus=" + this.c0 + ", hasExStatus=" + this.d0 + ", index=" + this.e0 + ", hasIndex=" + this.f0 + ", exDtStart=" + this.g0 + ", hasExDtStart=" + this.h0 + ", exDtEnd=" + this.i0 + ", hasExDtEnd=" + this.j0 + ", syncStatus=" + this.k0 + ", hasSyncStatus=" + this.l0 + ", larkUuid=" + this.m0 + ", hasLarkUuid=" + this.n0 + ", isNoTimeTodo=" + this.o0 + ", hasIsNoTimeTodo=" + this.p0 + ", memoryExtra=" + this.q0 + ", hasMemoryExtra=" + this.r0 + ", completeTime=" + this.s0 + ", hasCompleteTime=" + this.t0 + ", extraLocationInfo=" + this.u0 + ", hasExtraLocationInfo=" + this.v0 + ')';
    }

    static {
        w0 = new String[]{"_id", "_sync_id", "calendar_id", "title", "eventLocation", "description", "eventColor", "dtstart", "dtend", "duration", "allDay", "rrule", "rdate", "exrule", "exdate", "original_id", "originalInstanceTime", "originalAllDay", "customAppUri", "customAppPackage", "sync_data1", "sync_data2"};
    }

    public final JsonObject a() {
        JsonObject r0 = new JsonObject();
        if (this.b == false) goto L6;
        r0.addProperty("id", this.a);
    L6:
        if (this.d == false) goto L9;
        r0.addProperty("uuid", this.c);
    L9:
        if (this.f == false) goto L12;
        r0.addProperty("calendar_id", this.e);
    L12:
        if (this.h == false) goto L15;
        r0.addProperty("title", this.g);
    L15:
        if (this.j == false) goto L18;
        r0.addProperty("dtstart", this.i);
    L18:
        if (this.l == false) goto L21;
        r0.addProperty("etag", this.k);
    L21:
        if (this.n == false) goto L24;
        r0.addProperty("dtend", this.m);
    L24:
        if (this.p == false) goto L27;
        r0.addProperty("dtstamp", this.o);
    L27:
        if (this.r == false) goto L30;
        r0.addProperty("create_time", this.q);
    L30:
        if (this.t == false) goto L32;
        r0.addProperty("all_day", this.s);
    L32:
        String r2 = null;
        if (this.v == false) goto L40;
        EventType r1 = this.u;
        if (r1 == null) goto L37;
        String r3 = r1.name();
    L38:
        r0.addProperty("event_type", r3);
        goto L40
    L37:
        r3 = null;
    L40:
        if (this.x == false) goto L43;
        r0.addProperty("description", this.w);
    L43:
        if (this.z == false) goto L46;
        r0.addProperty("event_location", this.y);
    L46:
        if (this.B == false) goto L49;
        r0.addProperty("event_color", this.A);
    L49:
        if (this.D == false) goto L52;
        r0.addProperty("duration", this.C);
    L52:
        if (this.F == false) goto L55;
        r0.addProperty("rrule", this.E);
    L55:
        if (this.H == false) goto L58;
        r0.addProperty("rdate", this.G);
    L58:
        if (this.J == false) goto L61;
        r0.addProperty("exrule", this.I);
    L61:
        if (this.L == false) goto L64;
        r0.addProperty("exdate", this.K);
    L64:
        if (this.N == false) goto L67;
        r0.addProperty("original_id", this.M);
    L67:
        if (this.P == false) goto L70;
        r0.addProperty("original_instance_time", this.O);
    L70:
        if (this.R == false) goto L73;
        r0.addProperty("original_all_day", this.Q);
    L73:
        if (this.T == false) goto L76;
        r0.addProperty("ical_str", this.S);
    L76:
        if (this.V == false) goto L79;
        r0.addProperty("is_completed", this.U);
    L79:
        if (this.X == false) goto L85;
        EventFreq r4 = this.W;
        if (r4 == null) goto L83;
        r2 = r4.name();
    L83:
        r0.addProperty("freq", r2);
    L85:
        if (this.Z == false) goto L88;
        r0.addProperty("interval", this.Y);
    L88:
        if (this.b0 == false) goto L91;
        r0.addProperty("until", this.a0);
    L91:
        if (this.d0 == false) goto L94;
        r0.addProperty("exstatus", this.c0);
    L94:
        if (this.f0 == false) goto L97;
        r0.addProperty("index", this.e0);
    L97:
        if (this.h0 == false) goto L100;
        r0.addProperty("exdtstart", this.g0);
    L100:
        if (this.j0 == false) goto L103;
        r0.addProperty("exdtend", this.i0);
    L103:
        if (this.l0 == false) goto L106;
        r0.addProperty("sync_status", this.k0);
    L106:
        if (this.n0 == false) goto L109;
        r0.addProperty("lark_uuid", this.m0);
    L109:
        if (this.p0 == false) goto L112;
        r0.addProperty("is_no_time_todo", this.o0);
    L112:
        if (this.r0 == false) goto L115;
        r0.addProperty("memory_extra", this.q0);
    L115:
        if (this.t0 == false) goto L118;
        r0.addProperty("completed_time", this.s0);
    L118:
        if (this.v0 == false) goto L120;
        r0.addProperty("extra_location_info", this.u0);
    L120:
        return r0;
    }

    public /* synthetic */ EventEntity(Long r88, Long r89, Long r90, String r91, Long r92, Long r93, Long r94, Long r95, Long r96, Integer r97, EventType r98, String r99, String r100, String r101, String r102, String r103, String r104, String r105, String r106, Long r107, Long r108, Integer r109, String r110, Integer r111, EventFreq r112, Integer r113, Long r114, Integer r115, Integer r116, Long r117, Long r118, String r119, String r120, Boolean r121, String r122, Long r123, String r124, int r125, int r126, int r127) {
        if ((r125 & 1) == 0) goto L5;
        Long r6 = null;
    L7:
        if ((r125 & 2) == 0) goto L10;
        if (r6 == null) goto L10;
        boolean r3 = true;
    L12:
        if ((r125 & 4) == 0) goto L14;
        Long r8 = null;
    L16:
        if ((r125 & 8) == 0) goto L19;
        if (r8 == null) goto L19;
        boolean r9 = true;
    L21:
        if ((r125 & 16) == 0) goto L23;
        Long r10 = null;
    L25:
        if ((r125 & 32) == 0) goto L28;
        if (r10 == null) goto L28;
        boolean r11 = true;
    L30:
        if ((r125 & 64) == 0) goto L32;
        String r12 = null;
    L34:
        if ((r125 & 128) == 0) goto L37;
        if (r12 == null) goto L37;
        boolean r13 = true;
    L39:
        if ((r125 & 256) == 0) goto L41;
        Long r14 = null;
    L43:
        if ((r125 & 512) == 0) goto L46;
        if (r14 == null) goto L46;
        boolean r15 = true;
    L48:
        if ((r125 & 1024) == 0) goto L50;
        Long r4 = null;
    L52:
        if ((r125 & 2048) == 0) goto L55;
        if (r4 == null) goto L55;
        boolean r17 = true;
    L57:
        if ((r125 & 4096) == 0) goto L59;
        Long r18 = null;
    L61:
        if ((r125 & 8192) == 0) goto L64;
        if (r18 == null) goto L64;
        boolean r19 = true;
    L66:
        if ((r125 & 16384) == 0) goto L68;
        Long r20 = null;
    L70:
        if ((r125 & 32768) == 0) goto L73;
        if (r20 == null) goto L73;
        boolean r21 = true;
    L75:
        if ((r125 & UiType.FLAG_ALARM_CLOCK_CARD) == 0) goto L77;
        Long r23 = null;
    L79:
        if ((r125 & UiType.FLAG_PHONE_CARD) == 0) goto L82;
        if (r23 == null) goto L82;
        boolean r25 = true;
    L84:
        if ((r125 & UiType.FLAG_TIMER_CARD) == 0) goto L86;
        Integer r27 = null;
    L88:
        if ((r125 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L91;
        if (r27 == null) goto L91;
        boolean r29 = true;
    L93:
        if ((r125 & UiType.FLAG_APP_CHOOSER_CARD) == 0) goto L95;
        EventType r31 = null;
    L97:
        if ((r125 & UiType.FLAG_REMOTE_CARD) == 0) goto L100;
        if (r31 == null) goto L100;
        boolean r33 = true;
    L102:
        if ((r125 & UiType.FLAG_NO_FEEDBACK) == 0) goto L104;
        String r35 = null;
    L106:
        if ((r125 & UiType.FLAG_APPLET_CARD) == 0) goto L109;
        if (r35 == null) goto L109;
        boolean r37 = true;
    L111:
        if ((r125 & 16777216) == 0) goto L113;
        String r39 = null;
    L115:
        if ((r125 & 33554432) == 0) goto L118;
        if (r39 == null) goto L118;
        boolean r40 = true;
    L120:
        if ((r125 & 67108864) == 0) goto L122;
        String r41 = null;
    L124:
        if ((r125 & 134217728) == 0) goto L127;
        if (r41 == null) goto L127;
        boolean r42 = true;
    L129:
        if ((r125 & 268435456) == 0) goto L131;
        String r43 = null;
    L133:
        if ((r125 & 536870912) == 0) goto L136;
        if (r43 == null) goto L136;
        boolean r44 = true;
    L138:
        if ((r125 & 1073741824) == 0) goto L140;
        String r45 = null;
    L142:
        if ((r125 & Integer.MIN_VALUE) == 0) goto L145;
        if (r45 == null) goto L145;
        boolean r0 = true;
    L147:
        if ((r126 & 1) == 0) goto L149;
        String r46 = null;
    L151:
        if ((r126 & 2) == 0) goto L154;
        if (r46 == null) goto L154;
        boolean r47 = true;
    L156:
        if ((r126 & 4) == 0) goto L158;
        String r48 = null;
    L160:
        if ((r126 & 8) == 0) goto L163;
        if (r48 == null) goto L163;
        boolean r49 = true;
    L165:
        if ((r126 & 16) == 0) goto L167;
        String r50 = null;
    L169:
        if ((r126 & 32) == 0) goto L172;
        if (r50 == null) goto L172;
        boolean r51 = true;
    L174:
        if ((r126 & 64) == 0) goto L176;
        Long r52 = null;
    L178:
        if ((r126 & 128) == 0) goto L181;
        if (r52 == null) goto L181;
        boolean r54 = true;
    L183:
        if ((r126 & 256) == 0) goto L185;
        Long r55 = null;
    L187:
        if ((r126 & 512) == 0) goto L190;
        if (r55 == null) goto L190;
        boolean r56 = true;
    L192:
        if ((r126 & 1024) == 0) goto L194;
        Integer r57 = null;
    L196:
        if ((r126 & 2048) == 0) goto L199;
        if (r57 == null) goto L199;
        boolean r58 = true;
    L201:
        if ((r126 & 4096) == 0) goto L203;
        String r59 = null;
    L205:
        if ((r126 & 8192) == 0) goto L208;
        if (r59 == null) goto L208;
        boolean r60 = true;
    L210:
        if ((r126 & 16384) == 0) goto L212;
        Integer r61 = null;
    L214:
        if ((32768 & r126) == 0) goto L217;
        if (r61 == null) goto L217;
        boolean r62 = true;
    L219:
        if ((r126 & UiType.FLAG_ALARM_CLOCK_CARD) == 0) goto L221;
        EventFreq r63 = null;
    L223:
        if ((r126 & UiType.FLAG_PHONE_CARD) == 0) goto L226;
        if (r63 == null) goto L226;
        boolean r64 = true;
    L228:
        if ((r126 & UiType.FLAG_TIMER_CARD) == 0) goto L230;
        Integer r65 = null;
    L232:
        if ((r126 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L235;
        if (r65 == null) goto L235;
        boolean r66 = true;
    L237:
        if ((r126 & UiType.FLAG_APP_CHOOSER_CARD) == 0) goto L239;
        Long r67 = null;
    L241:
        if ((r126 & UiType.FLAG_REMOTE_CARD) == 0) goto L244;
        if (r67 == null) goto L244;
        boolean r68 = true;
    L246:
        if ((r126 & UiType.FLAG_NO_FEEDBACK) == 0) goto L248;
        Integer r69 = null;
    L250:
        if ((r126 & UiType.FLAG_APPLET_CARD) == 0) goto L253;
        if (r69 == null) goto L253;
        boolean r70 = true;
    L255:
        if ((r126 & 16777216) == 0) goto L257;
        Integer r71 = null;
    L259:
        if ((33554432 & r126) == 0) goto L262;
        if (r71 == null) goto L262;
        boolean r72 = true;
    L264:
        if ((67108864 & r126) == 0) goto L266;
        Long r73 = null;
    L268:
        if ((134217728 & r126) == 0) goto L271;
        if (r73 == null) goto L271;
        boolean r74 = true;
    L273:
        if ((268435456 & r126) == 0) goto L275;
        Long r75 = null;
    L277:
        if ((536870912 & r126) == 0) goto L280;
        if (r75 == null) goto L280;
        boolean r76 = true;
    L282:
        if ((1073741824 & r126) == 0) goto L284;
        String r77 = null;
    L286:
        if ((r126 & Integer.MIN_VALUE) == 0) goto L289;
        if (r77 == null) goto L289;
        boolean r1 = true;
    L291:
        if ((r127 & 1) == 0) goto L293;
        String r78 = null;
    L295:
        if ((r127 & 2) == 0) goto L298;
        if (r78 == null) goto L298;
        boolean r79 = true;
    L300:
        if ((r127 & 4) == 0) goto L302;
        Boolean r80 = null;
    L304:
        if ((r127 & 8) == 0) goto L307;
        if (r80 == null) goto L307;
        boolean r81 = true;
    L309:
        if ((r127 & 16) == 0) goto L311;
        String r82 = null;
    L313:
        if ((r127 & 32) == 0) goto L316;
        if (r82 == null) goto L316;
        boolean r83 = true;
    L318:
        if ((r127 & 64) == 0) goto L320;
        Long r84 = null;
    L322:
        if ((r127 & 128) == 0) goto L325;
        if (r84 == null) goto L325;
        boolean r85 = true;
    L327:
        if ((r127 & 256) == 0) goto L329;
        String r86 = null;
    L331:
        if ((r127 & 512) == 0) goto L334;
        if (r86 == null) goto L334;
        boolean r2 = true;
    L335:
        this(r6, r3, r8, r9, r10, r11, r12, r13, r14, r15, r4, r17, r18, r19, r20, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r40, r41, r42, r43, r44, r45, r0, r46, r47, r48, r49, r50, r51, r52, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r1, r78, r79, r80, r81, r82, r83, r84, r85, r86, r2);
        return;
    L334:
        r2 = false;
        goto L335
    L329:
        r86 = r124;
    L325:
        r85 = false;
        goto L327
    L320:
        r84 = r123;
    L316:
        r83 = false;
        goto L318
    L311:
        r82 = r122;
    L307:
        r81 = false;
        goto L309
    L302:
        r80 = r121;
    L298:
        r79 = false;
        goto L300
    L293:
        r78 = r120;
    L289:
        r1 = false;
        goto L291
    L284:
        r77 = r119;
    L280:
        r76 = false;
        goto L282
    L275:
        r75 = r118;
    L271:
        r74 = false;
        goto L273
    L266:
        r73 = r117;
    L262:
        r72 = false;
        goto L264
    L257:
        r71 = r116;
    L253:
        r70 = false;
        goto L255
    L248:
        r69 = r115;
    L244:
        r68 = false;
        goto L246
    L239:
        r67 = r114;
    L235:
        r66 = false;
        goto L237
    L230:
        r65 = r113;
    L226:
        r64 = false;
        goto L228
    L221:
        r63 = r112;
    L217:
        r62 = false;
        goto L219
    L212:
        r61 = r111;
    L208:
        r60 = false;
        goto L210
    L203:
        r59 = r110;
    L199:
        r58 = false;
        goto L201
    L194:
        r57 = r109;
    L190:
        r56 = false;
        goto L192
    L185:
        r55 = r108;
    L181:
        r54 = false;
        goto L183
    L176:
        r52 = r107;
    L172:
        r51 = false;
        goto L174
    L167:
        r50 = r106;
    L163:
        r49 = false;
        goto L165
    L158:
        r48 = r105;
    L154:
        r47 = false;
        goto L156
    L149:
        r46 = r104;
    L145:
        r0 = false;
        goto L147
    L140:
        r45 = r103;
    L136:
        r44 = false;
        goto L138
    L131:
        r43 = r102;
    L127:
        r42 = false;
        goto L129
    L122:
        r41 = r101;
    L118:
        r40 = false;
        goto L120
    L113:
        r39 = r100;
    L109:
        r37 = false;
        goto L111
    L104:
        r35 = r99;
    L100:
        r33 = false;
        goto L102
    L95:
        r31 = r98;
    L91:
        r29 = false;
        goto L93
    L86:
        r27 = r97;
    L82:
        r25 = false;
        goto L84
    L77:
        r23 = r96;
    L73:
        r21 = false;
        goto L75
    L68:
        r20 = r95;
    L64:
        r19 = false;
        goto L66
    L59:
        r18 = r94;
    L55:
        r17 = false;
        goto L57
    L50:
        r4 = r93;
    L46:
        r15 = false;
        goto L48
    L41:
        r14 = r92;
    L37:
        r13 = false;
        goto L39
    L32:
        r12 = r91;
    L28:
        r11 = false;
        goto L30
    L23:
        r10 = r90;
    L19:
        r9 = false;
        goto L21
    L14:
        r8 = r89;
    L10:
        r3 = false;
        goto L12
    L5:
        r6 = r88;
        goto L7
    }

    public EventEntity(Long r3, boolean r4, Long r5, boolean r6, Long r7, boolean r8, String r9, boolean r10, Long r11, boolean r12, Long r13, boolean r14, Long r15, boolean r16, Long r17, boolean r18, Long r19, boolean r20, Integer r21, boolean r22, EventType r23, boolean r24, String r25, boolean r26, String r27, boolean r28, String r29, boolean r30, String r31, boolean r32, String r33, boolean r34, String r35, boolean r36, String r37, boolean r38, String r39, boolean r40, Long r41, boolean r42, Long r43, boolean r44, Integer r45, boolean r46, String r47, boolean r48, Integer r49, boolean r50, EventFreq r51, boolean r52, Integer r53, boolean r54, Long r55, boolean r56, Integer r57, boolean r58, Integer r59, boolean r60, Long r61, boolean r62, Long r63, boolean r64, String r65, boolean r66, String r67, boolean r68, Boolean r69, boolean r70, String r71, boolean r72, Long r73, boolean r74, String r75, boolean r76) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
        this.A = r29;
        this.B = r30;
        this.C = r31;
        this.D = r32;
        this.E = r33;
        this.F = r34;
        this.G = r35;
        this.H = r36;
        this.I = r37;
        this.J = r38;
        this.K = r39;
        this.L = r40;
        this.M = r41;
        this.N = r42;
        this.O = r43;
        this.P = r44;
        this.Q = r45;
        this.R = r46;
        this.S = r47;
        this.T = r48;
        this.U = r49;
        this.V = r50;
        this.W = r51;
        this.X = r52;
        this.Y = r53;
        this.Z = r54;
        this.a0 = r55;
        this.b0 = r56;
        this.c0 = r57;
        this.d0 = r58;
        this.e0 = r59;
        this.f0 = r60;
        this.g0 = r61;
        this.h0 = r62;
        this.i0 = r63;
        this.j0 = r64;
        this.k0 = r65;
        this.l0 = r66;
        this.m0 = r67;
        this.n0 = r68;
        this.o0 = r69;
        this.p0 = r70;
        this.q0 = r71;
        this.r0 = r72;
        this.s0 = r73;
        this.t0 = r74;
        this.u0 = r75;
        this.v0 = r76;
    }
}
