package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.google.gson.JsonArray;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements vka.b<JsonArray> {
    public static final /* synthetic */ int b = 0;
    public final EventEntity.EventType a;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        JsonArray r6 = new JsonArray();
        StringBuilder r1 = new StringBuilder("visible != 0 AND deleted != 1");
        if (this.a == null) goto L5;
        r1.append(" AND sync_data1 LIKE '{%\"eventType\":\"");
        r1.append(this.a);
        r1.append("\"%}'");
    L5:
        String r3 = r1.toString();
        Cursor r2 = r0.query(new ala.b(null, 3), EventEntity.w0, r3, null, null);
        if (r2 == null) goto L20;
        Cursor r4 = r2;
        Cursor r5 = r4;     // Catch: Throwable -> L15
    L10:
        if (r5.moveToNext() == false) goto L13;
        String[] r7 = EventEntity.w0;     // Catch: Exception -> L21 Throwable -> L15
        r6.add(EventEntity.a.a(r5).a());     // Catch: Exception -> L21 Throwable -> L15
        goto L10
    L13:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r4, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L20:
        return r6;
    }

    public d(EventEntity.EventType r1) {
        this.a = r1;
    }
}
