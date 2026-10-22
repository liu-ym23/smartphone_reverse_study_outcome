package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.google.gson.JsonArray;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import vka.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e implements vka.b<JsonArray> {
    public final Boolean a;
    public final Long b;
    public final EventEntity c;
    public final boolean d;

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        EventEntity r1 = this.c;
        Long r2 = r1.a;
        Long r3 = r1.c;
        Long r4 = r1.e;
        Long r5 = r1.M;
        if (r5 == null) goto L5;
        String r6 = r5.toString();
    L6:
        EventEntity r7 = this.c;
        Long r8 = r7.O;
        String r9 = r7.m0;
        k r10 = new k();
        r10.a("_id", r2);
        r10.a("calendar_id", r4);
        r10.a("_sync_id", r3);
        r10.a("original_id", r6);
        r10.a("originalInstanceTime", r8);
        r10.a("sync_data2", r9);
        r10.a("deleted", Boolean.valueOf(this.d));
        r10.a("dirty", this.b);
        Boolean r11 = this.a;
        if (r11 == null) goto L9;
        r10.a("visible", r11);
    L9:
        Pair<String, String[]> r12 = r10.b();
        String r13 = (String) r12.component1();
        String[] r14 = (String[]) r12.component2();
        JsonArray r15 = new JsonArray();
        Cursor r16 = r0.query(new ala.b(null, 3), EventEntity.w0, r13, r14, null);
        if (r16 == null) goto L24;
        Cursor r17 = r16;
        Cursor r18 = r17;     // Catch: Throwable -> L19
    L14:
        if (r18.moveToNext() == false) goto L17;
        String[] r19 = EventEntity.w0;     // Catch: Exception -> L25 Throwable -> L19
        r15.add(EventEntity.a.a(r18).a());     // Catch: Exception -> L25 Throwable -> L19
        goto L14
    L17:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r17, null);
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);
        throw th;
    L24:
        return r15;
    L5:
        r6 = null;
        goto L6
    }

    public e(Boolean r2, Boolean r3, Long r4, EventEntity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        if (r2 == null) goto L5;
        boolean r6 = r2.booleanValue();
    L6:
        this.d = r6;
        return;
    L5:
        r6 = false;
        goto L6
    }
}
