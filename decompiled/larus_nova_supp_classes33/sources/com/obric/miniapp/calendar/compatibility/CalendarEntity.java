package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import vka.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class CalendarEntity {
    public static final String[] E = null;
    public final String A;
    public final boolean B;
    public final Long C;
    public final boolean D;
    public final Long a;
    public final boolean b;
    public final String c;
    public final boolean d;
    public final AccountType e;
    public final boolean f;
    public final String g;
    public final boolean h;
    public final String i;
    public final boolean j;
    public final String k;
    public final boolean l;
    public final Integer m;
    public final boolean n;
    public final Long o;
    public final boolean p;
    public final Integer q;
    public final boolean r;
    public final String s;
    public final boolean t;
    public final String u;
    public final boolean v;
    public final String w;
    public final boolean x;
    public final String y;
    public final boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/miniapp/calendar/compatibility/CalendarEntity$AccountType;", "", "<init>", "(Ljava/lang/String;I)V", com.obric.miniapp.alarm.AccountType.MAIN, com.obric.miniapp.alarm.AccountType.LARK, com.obric.miniapp.alarm.AccountType.LOCAL, com.obric.miniapp.alarm.AccountType.OTHERS, com.obric.miniapp.alarm.AccountType.ALL, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AccountType extends Enum<AccountType> {
        public static final AccountType ALL = null;
        public static final AccountType LARK = null;
        public static final AccountType LOCAL = null;
        public static final AccountType MAIN = null;
        public static final AccountType OTHERS = null;
        public static final /* synthetic */ AccountType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AccountType> getEntries() {
            return b;
        }

        static {
            AccountType r0 = new AccountType(com.obric.miniapp.alarm.AccountType.MAIN, 0);
            MAIN = r0;
            AccountType r1 = new AccountType(com.obric.miniapp.alarm.AccountType.LARK, 1);
            LARK = r1;
            AccountType r3 = new AccountType(com.obric.miniapp.alarm.AccountType.LOCAL, 2);
            LOCAL = r3;
            AccountType r5 = new AccountType(com.obric.miniapp.alarm.AccountType.OTHERS, 3);
            OTHERS = r5;
            AccountType r7 = new AccountType(com.obric.miniapp.alarm.AccountType.ALL, 4);
            ALL = r7;
            AccountType[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static AccountType[] values() {
            return (AccountType[]) a.clone();
        }

        public static AccountType valueOf(String r1) {
            return (AccountType) r27.a.a(AccountType.class, r1);
        }

        public AccountType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static CalendarEntity a(Cursor r28) {
            Intrinsics.checkNotNullParameter(r28, "c");
            long r1 = r28.getLong(0);
            Long r5 = null;
            if (r28.isNull(1) == false) goto L5;
            String r3 = null;
        L7:
            if (r28.isNull(2) == false) goto L9;
            String r4 = null;
        L11:
            if (r28.isNull(6) == false) goto L13;
            String r23 = null;
        L15:
            if (r28.isNull(3) == false) goto L17;
            Long r6 = null;
        L18:
            if (r6 == null) goto L22;
            String r7 = r6.toString();
            if (r7 == null) goto L22;
        L25:
            String r24 = r7;
        L27:
            if (r28.isNull(8) == false) goto L29;
            Integer r25 = null;
        L31:
            if (r28.isNull(7) == false) goto L33;
            Integer r26 = null;
        L35:
            if (r28.isNull(4) == false) goto L37;
            String r27 = null;
        L66:
            JsonObject r0 = JsonParser.parseString(r28.getString(9)).getAsJsonObject();     // Catch: Exception -> L64
            AccountType r9 = AccountType.valueOf(r0.get("accountType").getAsString());     // Catch: Exception -> L64
            Intrinsics.checkNotNull(r0);     // Catch: Exception -> L64
            JsonElement r8 = n.a(r0, "lastVersion");     // Catch: Exception -> L64
            if (r8 == null) goto L42;
            Long r14 = Long.valueOf(r8.getAsLong());     // Catch: Exception -> L64
        L43:
            JsonElement r10 = n.a(r0, "reminderSetting");     // Catch: Exception -> L64
            if (r10 == null) goto L46;
            String r17 = r10.getAsString();     // Catch: Exception -> L64
        L47:
            JsonElement r11 = n.a(r0, "userName");     // Catch: Exception -> L64
            if (r11 == null) goto L50;
            String r18 = r11.getAsString();     // Catch: Exception -> L64
        L51:
            JsonElement r12 = n.a(r0, "password");     // Catch: Exception -> L64
            if (r12 == null) goto L54;
            String r19 = r12.getAsString();     // Catch: Exception -> L64
        L55:
            JsonElement r13 = n.a(r0, "serverUrl");     // Catch: Exception -> L64
            if (r13 == null) goto L58;
            String r20 = r13.getAsString();     // Catch: Exception -> L64
        L59:
            JsonElement r2 = n.a(r0, "syncTime");     // Catch: Exception -> L64
            if (r2 == null) goto L62;
            r5 = Long.valueOf(r2.getAsLong());     // Catch: Exception -> L64
        L62:
            return new CalendarEntity(Long.valueOf(r1), r3, r9, r4, r23, r24, r25, r14, r26, r27, r17, r18, r19, r20, r5, 715827882);
        L58:
            r20 = null;
            goto L59
        L54:
            r19 = null;
            goto L55
        L50:
            r18 = null;
            goto L51
        L46:
            r17 = null;
            goto L47
        L42:
            r14 = null;
        L65:
            return new CalendarEntity(Long.valueOf(r1), r3, AccountType.OTHERS, r4, r23, r24, r25, null, r26, r27, null, null, null, null, null, 1073408682);
        L37:
            r27 = r28.getString(4);
            goto L66
        L33:
            r26 = Integer.valueOf(r28.getInt(7));
            goto L35
        L29:
            r25 = Integer.valueOf(r28.getInt(8));
        L22:
            if (r28.isNull(5) == false) goto L24;
            r24 = null;
            goto L27
        L24:
            r7 = r28.getString(5);
            goto L25
        L17:
            r6 = Long.valueOf(r28.getLong(3));
            goto L18
        L13:
            r23 = r28.getString(6);
            goto L15
        L9:
            r4 = r28.getString(2);
            goto L11
        L5:
            r3 = r28.getString(1);
            goto L7
        }

        public static CalendarEntity b(JsonObject r48, boolean r49) {
            Intrinsics.checkNotNullParameter(r48, "json");
            boolean r19 = r48.has("id");     // Catch: Exception -> L94
            JsonElement r15 = n.a(r48, "id");     // Catch: Exception -> L94
            if (r15 == null) goto L6;
            Long r18 = Long.valueOf(r15.getAsLong());     // Catch: Exception -> L94
        L7:
            boolean r21 = r48.has("calendar_id");     // Catch: Exception -> L94
            if (r49 == false) goto L13;
            if (r21 == true) goto L13;
            throw new NullPointerException("calendar_id is null");     // Catch: Exception -> L94
        L13:
            JsonElement r14 = n.a(r48, "calendar_id");     // Catch: Exception -> L94
            if (r14 == null) goto L16;
            String r20 = r14.getAsString();     // Catch: Exception -> L94
        L17:
            boolean r23 = r48.has("account_type");     // Catch: Exception -> L94
            if (r49 == false) goto L23;
            if (r23 == true) goto L23;
            throw new NullPointerException("account_type is null");     // Catch: Exception -> L94
        L23:
            JsonElement r13 = n.a(r48, "account_type");     // Catch: Exception -> L94
            if (r13 == null) goto L30;
            String r16 = r13.getAsString();     // Catch: Exception -> L94
            if (r16 == null) goto L30;
            String r17 = r16.toUpperCase(Locale.ROOT);     // Catch: Exception -> L94
            if (r17 == null) goto L30;
            AccountType r22 = AccountType.valueOf(r17);     // Catch: Exception -> L94
        L31:
            boolean r25 = r48.has("calendar_account");     // Catch: Exception -> L94
            if (r49 == false) goto L37;
            if (r25 == true) goto L37;
            throw new NullPointerException("calendar_account is null");     // Catch: Exception -> L94
        L37:
            JsonElement r12 = n.a(r48, "calendar_account");     // Catch: Exception -> L94
            if (r12 == null) goto L40;
            String r24 = r12.getAsString();     // Catch: Exception -> L94
        L41:
            boolean r27 = r48.has("calendar_name");     // Catch: Exception -> L94
            if (r49 == false) goto L47;
            if (r27 == true) goto L47;
            throw new NullPointerException("calendar_name is null");     // Catch: Exception -> L94
        L47:
            JsonElement r11 = n.a(r48, "calendar_name");     // Catch: Exception -> L94
            if (r11 == null) goto L50;
            String r26 = r11.getAsString();     // Catch: Exception -> L94
        L51:
            boolean r29 = r48.has("calendar_color");     // Catch: Exception -> L94
            JsonElement r10 = n.a(r48, "calendar_color");     // Catch: Exception -> L94
            if (r10 == null) goto L54;
            String r28 = r10.getAsString();     // Catch: Exception -> L94
        L55:
            boolean r31 = r48.has("sync_events");     // Catch: Exception -> L94
            JsonElement r9 = n.a(r48, "sync_events");     // Catch: Exception -> L94
            if (r9 == null) goto L58;
            Integer r30 = Integer.valueOf(r9.getAsInt());     // Catch: Exception -> L94
        L59:
            boolean r33 = r48.has("last_version");     // Catch: Exception -> L94
            JsonElement r8 = n.a(r48, "last_version");     // Catch: Exception -> L94
            if (r8 == null) goto L62;
            Long r32 = Long.valueOf(r8.getAsLong());     // Catch: Exception -> L94
        L63:
            boolean r35 = r48.has("enable");     // Catch: Exception -> L94
            JsonElement r7 = n.a(r48, "enable");     // Catch: Exception -> L94
            if (r7 == null) goto L66;
            Integer r34 = Integer.valueOf(r7.getAsInt());     // Catch: Exception -> L94
        L67:
            boolean r37 = r48.has("sync_token");     // Catch: Exception -> L94
            JsonElement r6 = n.a(r48, "sync_token");     // Catch: Exception -> L94
            if (r6 == null) goto L70;
            String r36 = r6.getAsString();     // Catch: Exception -> L94
        L71:
            boolean r39 = r48.has("reminder_setting");     // Catch: Exception -> L94
            JsonElement r5 = n.a(r48, "reminder_setting");     // Catch: Exception -> L94
            if (r5 == null) goto L74;
            String r38 = r5.getAsString();     // Catch: Exception -> L94
        L75:
            boolean r41 = r48.has("userName");     // Catch: Exception -> L94
            JsonElement r4 = n.a(r48, "userName");     // Catch: Exception -> L94
            if (r4 == null) goto L78;
            String r40 = r4.getAsString();     // Catch: Exception -> L94
        L79:
            boolean r43 = r48.has("password");     // Catch: Exception -> L94
            JsonElement r3 = n.a(r48, "password");     // Catch: Exception -> L94
            if (r3 == null) goto L82;
            String r42 = r3.getAsString();     // Catch: Exception -> L94
        L83:
            boolean r45 = r48.has("server_url");     // Catch: Exception -> L94
            JsonElement r2 = n.a(r48, "server_url");     // Catch: Exception -> L94
            if (r2 == null) goto L86;
            String r44 = r2.getAsString();     // Catch: Exception -> L94
        L87:
            boolean r47 = r48.has("sync_time");     // Catch: Exception -> L94
            JsonElement r0 = n.a(r48, "sync_time");     // Catch: Exception -> L94
            if (r0 == null) goto L90;
            Long r46 = Long.valueOf(r0.getAsLong());     // Catch: Exception -> L94
        L93:
            return new CalendarEntity(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47);
        L90:
            r46 = null;
            goto L93
        L86:
            r44 = null;
            goto L87
        L82:
            r42 = null;
            goto L83
        L78:
            r40 = null;
            goto L79
        L74:
            r38 = null;
            goto L75
        L70:
            r36 = null;
            goto L71
        L66:
            r34 = null;
            goto L67
        L62:
            r32 = null;
            goto L63
        L58:
            r30 = null;
            goto L59
        L54:
            r28 = null;
            goto L55
        L50:
            r26 = null;
            goto L51
        L40:
            r24 = null;
        L30:
            r22 = null;
            goto L31
        L16:
            r20 = null;
            goto L17
        L6:
            r18 = null;
            goto L7
        L96:
            return null;
        }
    }

    public CalendarEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073741823);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CalendarEntity) == true) goto L8;
        return false;
    L8:
        CalendarEntity r6 = (CalendarEntity) r5;
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
        if (this.e == r6.e) goto L24;
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
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
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
        if (this.D == r6.D) goto L98;
        return false;
    L98:
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
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.d == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        AccountType r12 = this.e;
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
        String r22 = this.i;
        if (r22 != null) goto L37;
        int r23 = 0;
    L38:
        int r24 = (r21 + r23) * 31;
        if (this.j == false) goto L41;
        int r25 = 1231;
    L42:
        int r26 = (r24 + r25) * 31;
        String r27 = this.k;
        if (r27 != null) goto L45;
        int r28 = 0;
    L46:
        int r29 = (r26 + r28) * 31;
        if (this.l == false) goto L49;
        int r30 = 1231;
    L50:
        int r31 = (r29 + r30) * 31;
        Integer r32 = this.m;
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
        Integer r42 = this.q;
        if (r42 != null) goto L69;
        int r43 = 0;
    L70:
        int r44 = (r41 + r43) * 31;
        if (this.r == false) goto L73;
        int r45 = 1231;
    L74:
        int r46 = (r44 + r45) * 31;
        String r47 = this.s;
        if (r47 != null) goto L77;
        int r48 = 0;
    L78:
        int r49 = (r46 + r48) * 31;
        if (this.t == false) goto L81;
        int r50 = 1231;
    L82:
        int r51 = (r49 + r50) * 31;
        String r52 = this.u;
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
        Long r72 = this.C;
        if (r72 == null) goto L118;
        r1 = r72.hashCode();
    L118:
        int r73 = (r71 + r1) * 31;
        if (this.D == true) goto L123;
        r4 = 1237;
    L123:
        return r73 + r4;
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
        return "CalendarEntity(id=" + this.a + ", hasId=" + this.b + ", calendarId=" + this.c + ", hasCalendarId=" + this.d + ", accountType=" + this.e + ", hasAccountType=" + this.f + ", calendarAccount=" + this.g + ", hasCalendarAccount=" + this.h + ", calendarName=" + this.i + ", hasCalendarName=" + this.j + ", calendarColor=" + this.k + ", hasCalendarColor=" + this.l + ", syncEvents=" + this.m + ", hasSyncEvents=" + this.n + ", lastVersion=" + this.o + ", hasLastVersion=" + this.p + ", enable=" + this.q + ", hasEnable=" + this.r + ", syncToken=" + this.s + ", hasSyncToken=" + this.t + ", reminderSetting=" + this.u + ", hasReminderSetting=" + this.v + ", userName=" + this.w + ", hasUserName=" + this.x + ", password=" + this.y + ", hasPassword=" + this.z + ", serverUrl=" + this.A + ", hasServerUrl=" + this.B + ", syncTime=" + this.C + ", hasSyncTime=" + this.D + ')';
    }

    static {
        E = new String[]{"_id", "name", "account_name", "calendar_color", "_sync_id", "calendar_color_index", "calendar_displayName", "visible", "sync_events", "cal_sync1"};
    }

    public final JsonObject a() {
        JsonObject r0 = new JsonObject();
        if (this.b == false) goto L6;
        r0.addProperty("id", this.a);
    L6:
        if (this.d == false) goto L9;
        r0.addProperty("calendar_id", this.c);
    L9:
        if (this.f == false) goto L16;
        AccountType r1 = this.e;
        if (r1 == null) goto L13;
        String r2 = r1.name();
    L14:
        r0.addProperty("account_type", r2);
        goto L16
    L13:
        r2 = null;
    L16:
        if (this.h == false) goto L19;
        r0.addProperty("calendar_account", this.g);
    L19:
        if (this.j == false) goto L22;
        r0.addProperty("calendar_name", this.i);
    L22:
        if (this.l == false) goto L25;
        r0.addProperty("calendar_color", this.k);
    L25:
        if (this.n == false) goto L28;
        r0.addProperty("sync_events", this.m);
    L28:
        if (this.p == false) goto L31;
        r0.addProperty("last_version", this.o);
    L31:
        if (this.r == false) goto L34;
        r0.addProperty("enable", this.q);
    L34:
        if (this.t == false) goto L37;
        r0.addProperty("sync_token", this.s);
    L37:
        if (this.v == false) goto L40;
        r0.addProperty("reminder_setting", this.u);
    L40:
        if (this.x == false) goto L43;
        r0.addProperty("userName", this.w);
    L43:
        if (this.z == false) goto L46;
        r0.addProperty("password", this.y);
    L46:
        if (this.B == false) goto L49;
        r0.addProperty("server_url", this.A);
    L49:
        if (this.D == false) goto L51;
        r0.addProperty("sync_time", this.C);
    L51:
        return r0;
    }

    public /* synthetic */ CalendarEntity(Long r35, String r36, AccountType r37, String r38, String r39, String r40, Integer r41, Long r42, Integer r43, String r44, String r45, String r46, String r47, String r48, Long r49, int r50) {
        if ((r50 & 1) == 0) goto L5;
        Long r4 = null;
    L7:
        if ((r50 & 2) == 0) goto L10;
        if (r4 == null) goto L10;
        boolean r1 = true;
    L12:
        if ((r50 & 4) == 0) goto L14;
        String r6 = null;
    L16:
        if ((r50 & 8) == 0) goto L19;
        if (r6 == null) goto L19;
        boolean r7 = true;
    L21:
        if ((r50 & 16) == 0) goto L23;
        AccountType r8 = null;
    L25:
        if ((r50 & 32) == 0) goto L28;
        if (r8 == null) goto L28;
        boolean r9 = true;
    L30:
        if ((r50 & 64) == 0) goto L32;
        String r10 = null;
    L34:
        if ((r50 & 128) == 0) goto L37;
        if (r10 == null) goto L37;
        boolean r11 = true;
    L39:
        if ((r50 & 256) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r50 & 512) == 0) goto L46;
        if (r12 == null) goto L46;
        boolean r13 = true;
    L48:
        if ((r50 & 1024) == 0) goto L50;
        String r14 = null;
    L52:
        if ((r50 & 2048) == 0) goto L55;
        if (r14 == null) goto L55;
        boolean r15 = true;
    L57:
        if ((r50 & 4096) == 0) goto L59;
        Integer r2 = null;
    L61:
        if ((r50 & 8192) == 0) goto L64;
        if (r2 == null) goto L64;
        boolean r17 = true;
    L66:
        if ((r50 & 16384) == 0) goto L68;
        Long r18 = null;
    L70:
        if ((32768 & r50) == 0) goto L73;
        if (r18 == null) goto L73;
        boolean r19 = true;
    L75:
        if ((65536 & r50) == 0) goto L77;
        Integer r20 = null;
    L79:
        if ((131072 & r50) == 0) goto L82;
        if (r20 == null) goto L82;
        boolean r21 = true;
    L84:
        if ((262144 & r50) == 0) goto L86;
        String r22 = null;
    L88:
        if ((524288 & r50) == 0) goto L91;
        if (r22 == null) goto L91;
        boolean r23 = true;
    L93:
        if ((1048576 & r50) == 0) goto L95;
        String r24 = null;
    L97:
        if ((2097152 & r50) == 0) goto L100;
        if (r24 == null) goto L100;
        boolean r25 = true;
    L102:
        if ((4194304 & r50) == 0) goto L104;
        String r26 = null;
    L106:
        if ((8388608 & r50) == 0) goto L109;
        if (r26 == null) goto L109;
        boolean r27 = true;
    L111:
        if ((16777216 & r50) == 0) goto L113;
        String r28 = null;
    L115:
        if ((33554432 & r50) == 0) goto L118;
        if (r28 == null) goto L118;
        boolean r29 = true;
    L120:
        if ((67108864 & r50) == 0) goto L122;
        String r30 = null;
    L124:
        if ((134217728 & r50) == 0) goto L127;
        if (r30 == null) goto L127;
        boolean r31 = true;
    L129:
        if ((268435456 & r50) == 0) goto L131;
        Long r32 = null;
    L133:
        if ((r50 & 536870912) == 0) goto L136;
        if (r32 == null) goto L136;
        boolean r33 = true;
    L137:
        this(r4, r1, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33);
        return;
    L136:
        r33 = false;
        goto L137
    L131:
        r32 = r49;
    L127:
        r31 = false;
        goto L129
    L122:
        r30 = r48;
    L118:
        r29 = false;
        goto L120
    L113:
        r28 = r47;
    L109:
        r27 = false;
        goto L111
    L104:
        r26 = r46;
    L100:
        r25 = false;
        goto L102
    L95:
        r24 = r45;
    L91:
        r23 = false;
        goto L93
    L86:
        r22 = r44;
    L82:
        r21 = false;
        goto L84
    L77:
        r20 = r43;
    L73:
        r19 = false;
        goto L75
    L68:
        r18 = r42;
    L64:
        r17 = false;
        goto L66
    L59:
        r2 = r41;
    L55:
        r15 = false;
        goto L57
    L50:
        r14 = r40;
    L46:
        r13 = false;
        goto L48
    L41:
        r12 = r39;
    L37:
        r11 = false;
        goto L39
    L32:
        r10 = r38;
    L28:
        r9 = false;
        goto L30
    L23:
        r8 = r37;
    L19:
        r7 = false;
        goto L21
    L14:
        r6 = r36;
    L10:
        r1 = false;
        goto L12
    L5:
        r4 = r35;
        goto L7
    }

    public CalendarEntity(Long r3, boolean r4, String r5, boolean r6, AccountType r7, boolean r8, String r9, boolean r10, String r11, boolean r12, String r13, boolean r14, Integer r15, boolean r16, Long r17, boolean r18, Integer r19, boolean r20, String r21, boolean r22, String r23, boolean r24, String r25, boolean r26, String r27, boolean r28, String r29, boolean r30, Long r31, boolean r32) {
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
    }
}
