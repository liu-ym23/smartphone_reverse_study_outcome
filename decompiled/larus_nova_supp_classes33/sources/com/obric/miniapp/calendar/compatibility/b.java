package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.google.gson.JsonArray;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements vka.b<JsonArray> {
    public static final /* synthetic */ int b = 0;
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        JsonArray r6 = new JsonArray();
        Cursor r1 = r0.query(new ala.b(null, 3), EventEntity.w0, "visible != 0 AND deleted != 1 AND (description LIKE ? OR eventLocation LIKE ? OR title LIKE ?)", new String[]{"%" + this.a + '%', "%" + this.a + '%', "%" + this.a + '%'}, null);
        if (r1 == null) goto L17;
        Cursor r2 = r1;
        Cursor r3 = r2;     // Catch: Throwable -> L12
    L7:
        if (r3.moveToNext() == false) goto L10;
        String[] r4 = EventEntity.w0;     // Catch: Exception -> L18 Throwable -> L12
        r6.add(EventEntity.a.a(r3).a());     // Catch: Exception -> L18 Throwable -> L12
        goto L7
    L10:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r2, null);
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L17:
        return r6;
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        this.a = r2;
    }
}
