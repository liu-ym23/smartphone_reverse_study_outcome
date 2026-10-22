package xka;

import android.database.Cursor;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k implements vka.b<JsonArray> {
    public static final String[] b = null;
    public final long a;

    public static final class a {
    }

    static {
        b = new String[]{"_id", "event_id", "minutes", "method"};
    }

    public final JsonArray a() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        JsonArray r6 = new JsonArray();
        Cursor r1 = r0.query(new ala.d(null, 3), b, "event_id=?", new String[]{String.valueOf(this.a)}, null);
        if (r1 == null) goto L20;
        Cursor r2 = r1;
        Cursor r3 = r2;     // Catch: Throwable -> L15
    L7:
        if (r3.moveToNext() == false) goto L13;
        long r4 = r3.getLong(0);     // Catch: Throwable -> L15
        long r5 = r3.getLong(1);     // Catch: Throwable -> L15
        if (r3.isNull(2) == false) goto L11;
        Integer r11 = null;
    L12:
        int r12 = r3.getInt(3);     // Catch: Throwable -> L15
        JsonObject r13 = new JsonObject();     // Catch: Throwable -> L15
        r13.addProperty("id", Long.valueOf(r4));     // Catch: Throwable -> L15
        r13.addProperty("eventId", Long.valueOf(r5));     // Catch: Throwable -> L15
        r13.addProperty("minutes", r11);     // Catch: Throwable -> L15
        r13.addProperty("method", Integer.valueOf(r12));     // Catch: Throwable -> L15
        r6.add(r13);     // Catch: Throwable -> L15
        goto L7
    L11:
        r11 = Integer.valueOf(r3.getInt(2));     // Catch: Throwable -> L15
        goto L12
    L13:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r2, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L20:
        return r6;
    }

    @Override // vka.b
    public final /* bridge */ /* synthetic */ Object execute() {
        vka.f r0 = vka.f.a;
        return a();
    }

    public k(long r1) {
        this.a = r1;
    }
}
