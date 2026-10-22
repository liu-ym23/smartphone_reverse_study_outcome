package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.google.gson.JsonArray;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import vka.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements vka.b<JsonArray> {
    public final Long a;
    public final CalendarEntity b;
    public final boolean c;

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        CalendarEntity r1 = this.b;
        Long r2 = r1.a;
        String r3 = r1.c;
        String r4 = r1.i;
        String r5 = r1.g;
        Integer r6 = r1.q;
        k r7 = new k();
        r7.a("_id", r2);
        r7.a("name", r3);
        r7.a("calendar_displayName", r4);
        r7.a("account_name", r5);
        r7.a("ownerAccount", r5);
        r7.a("deleted", Boolean.valueOf(this.c));
        r7.a("dirty", this.a);
        r7.a("visible", r6);
        Pair<String, String[]> r8 = r7.b();
        String r9 = (String) r8.component1();
        String[] r10 = (String[]) r8.component2();
        JsonArray r11 = new JsonArray();
        Cursor r12 = r0.query(new ala.a(null, 3), CalendarEntity.E, r9, r10, null);
        if (r12 == null) goto L17;
        Cursor r13 = r12;
        Cursor r14 = r13;     // Catch: Throwable -> L12
    L7:
        if (r14.moveToNext() == false) goto L10;
        String[] r15 = CalendarEntity.E;     // Catch: Exception -> L18 Throwable -> L12
        r11.add(CalendarEntity.a.a(r14).a());     // Catch: Exception -> L18 Throwable -> L12
        goto L7
    L10:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r13, null);
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L17:
        return r11;
    }

    public c(Boolean r2, Long r3, CalendarEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        this.a = r3;
        this.b = r4;
        if (r2 == null) goto L5;
        boolean r5 = r2.booleanValue();
    L6:
        this.c = r5;
        return;
    L5:
        r5 = false;
        goto L6
    }
}
