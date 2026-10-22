package com.obric.miniapp.calendar.compatibility;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements vka.b<Long> {
    public static final /* synthetic */ int d = 0;
    public final boolean a;
    public final Long b;
    public final CalendarEntity c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Long, java.lang.String, java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v5, types: [vka.f] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        CalendarEntity r2 = this.c;
        boolean r8 = r2.b;
        Long r9 = r2.a;
        boolean r10 = r2.d;
        String r11 = r2.c;
        String r12 = r2.g;
        boolean r13 = r2.r;
        Integer r14 = r2.q;
        boolean r15 = r2.j;
        String r7 = r2.i;
        boolean r6 = r2.l;
        String r3 = r2.k;
        if (r3 == null) goto L5;
        Integer r4 = StringsKt.toIntOrNull(r3);
    L6:
        Pair r5 = TuplesKt.to(r4, this.c.k);
        Integer r16 = (Integer) r5.component1();
        String r17 = (String) r5.component2();
        CalendarEntity r18 = this.c;
        boolean r19 = r18.n;
        Integer r20 = r18.m;
        boolean r21 = r18.t;
        String r22 = r18.s;
        if (r9 == null) goto L32;
        r9.longValue();
        String r26 = r22;
        String r27 = r17;
        Integer r28 = r16;
        boolean r23 = r6;
        vka.f r24 = r0;
        String r29 = "cal_sync1";
        String r1 = r7;
        boolean r110 = r19;
        Long r111 = r9;
        Integer r25 = r20;
        boolean r112 = r21;
        Cursor r30 = r0.query(new ala.a(r9, 2), new String[]{"cal_sync1"}, null, null, null);
        if (r30 == null) goto L28;
        Cursor r31 = r30;
        Cursor r32 = r31;     // Catch: Throwable -> L22
        if (r32.moveToNext() == true) goto L14;
    L18:
        JsonElement r33 = null;
        String r34 = null;
    L19:
        CloseableKt.closeFinally(r31, r33);
        JsonElement r35 = r33;
        if (r34 == null) goto L29;
        ?? r36 = r33;
        JsonElement r37 = JsonParser.parseString(r34).getAsJsonObject();
    L30:
        if (r37 == null) goto L33;
    L34:
        CalendarEntity r38 = this.c;
        if (r38.f == false) goto L42;
        CalendarEntity.AccountType r39 = r38.e;
        if (r39 == null) goto L41;
        String r40 = r39.toString();
        if (r40 == null) goto L41;
        r37.addProperty("accountType", r40);
    L41:
        r37.remove("accountType");
    L42:
        CalendarEntity r41 = this.c;
        if (r41.p == false) goto L48;
        Long r42 = r41.o;
        if (r42 == null) goto L47;
        r37.addProperty("lastVersion", Long.valueOf(r42.longValue()));
        goto L48
    L47:
        r37.remove("lastVersion");
    L48:
        CalendarEntity r43 = this.c;
        if (r43.v == false) goto L54;
        String r44 = r43.u;
        if (r44 == null) goto L53;
        r37.addProperty("reminderSetting", r44);
        goto L54
    L53:
        r37.remove("reminderSetting");
    L54:
        CalendarEntity r45 = this.c;
        if (r45.x == false) goto L60;
        String r46 = r45.w;
        if (r46 == null) goto L59;
        r37.addProperty("userName", r46);
        goto L60
    L59:
        r37.remove("userName");
    L60:
        CalendarEntity r47 = this.c;
        if (r47.z == false) goto L66;
        String r48 = r47.y;
        if (r48 == null) goto L65;
        r37.addProperty("password", r48);
        goto L66
    L65:
        r37.remove("password");
    L66:
        CalendarEntity r49 = this.c;
        if (r49.B == false) goto L72;
        String r50 = r49.A;
        if (r50 == null) goto L71;
        r37.addProperty("serverUrl", r50);
        goto L72
    L71:
        r37.remove("serverUrl");
    L72:
        CalendarEntity r51 = this.c;
        if (r51.t == false) goto L78;
        String r52 = r51.s;
        if (r52 == null) goto L77;
        r37.addProperty("syncToken", r52);
        goto L78
    L77:
        r37.remove("syncToken");
    L78:
        String r53 = r37.toString();
        ContentValues r54 = new ContentValues();
        if (r10 == false) goto L81;
        r54.put("name", r11);
    L81:
        r54.put("account_type", AccountType.LOCAL);
        r54.put("account_name", r12);
        if (r23 == false) goto L84;
        r54.put("calendar_color", r28);
        r54.put("calendar_color_index", r27);
    L84:
        if (r112 == false) goto L86;
        r54.put("_sync_id", r26);
    L86:
        if (r15 == false) goto L88;
        r54.put("calendar_displayName", r1);
    L88:
        if (r8 == true) goto L90;
        r54.put("calendar_access_level", 800);
    L90:
        if (r13 == false) goto L92;
        r54.put("visible", r14);
    L92:
        r54.put("ownerAccount", r12);
        if (r110 == false) goto L95;
        r54.put("sync_events", r25);
    L95:
        r54.put(r29, r53);
        if (this.a == false) goto L102;
        Long r55 = this.b;
        if (r55 == null) goto L100;
        long r56 = r55.longValue();
    L101:
        r54.put("dirty", Long.valueOf(r56));
        goto L102
    L100:
        r56 = 0;
    L102:
        if (r8 == false) goto L108;
        Long r57 = r111;
        ?? r58 = r24;
        if (r58.update(new ala.a(r57, r12), r54, r36, r36) <= 0) goto L114;
        return r57;
    L114:
        return r36;
    L108:
        return r24.insert(new ala.a(r36, r12), r54);
    L33:
        r37 = new JsonObject();
    L29:
        r37 = r35;
        r36 = r35;
        goto L30
    L14:
        if (r32.isNull(0) == true) goto L18;
        r34 = r32.getString(0);     // Catch: Throwable -> L22
        r33 = null;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r31, th);
        throw th;
    L28:
        r35 = null;
        goto L29
    L32:
        r24 = r0;
        r26 = r22;
        r27 = r17;
        r28 = r16;
        r23 = r6;
        r29 = "cal_sync1";
        r1 = r7;
        r110 = r19;
        r36 = 0;
        r111 = r9;
        r25 = r20;
        r112 = r21;
        goto L33
    L5:
        r4 = null;
        goto L6
    }

    public f(boolean r2, Long r3, CalendarEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
