package vka;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o implements b<JsonElement> {
    public final b<?> a;

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(f.a, "context");
        e = this.a.execute();     // Catch: Exception -> L7
        if (e != null) goto L8;
        e = new NullPointerException();     // Catch: Exception -> L7
    L8:
        int r1 = com.obric.miniapp.calendar.a.a;
        b<?> r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "operation");
        Intrinsics.checkNotNullParameter(e, "opResult");
        JsonObject r3 = new JsonObject();
        if ((e instanceof Unit) == false) goto L12;
        FLogger.a.i("CalendarHelper", "execute operation " + Reflection.getOrCreateKotlinClass(r2.getClass()).getSimpleName() + " ok with no result");
        r3.addProperty("status", 0);
    L30:
        return r3;
    L12:
        if ((e instanceof Exception) == false) goto L14;
        r3.addProperty("status", -1);
        FLogger.a.e("CalendarHelper", "execute operation " + Reflection.getOrCreateKotlinClass(r2.getClass()).getSimpleName() + " failed", (Throwable) e);
        r3.addProperty("content", e.toString());
        goto L30
    L14:
        FLogger.a.i("CalendarHelper", "execute operation " + Reflection.getOrCreateKotlinClass(r2.getClass()).getSimpleName() + " ok with result " + e);
        r3.addProperty("status", 0);
        if ((e instanceof Number) == false) goto L18;
        r3.addProperty("content", (Number) e);
        goto L30
    L18:
        if ((e instanceof Boolean) == false) goto L21;
        r3.addProperty("content", (Boolean) e);
        goto L30
    L21:
        if ((e instanceof Character) == false) goto L24;
        r3.addProperty("content", (Character) e);
        goto L30
    L24:
        if ((e instanceof String) == false) goto L27;
        r3.addProperty("content", (String) e);
        goto L30
    L27:
        if ((e instanceof JsonElement) == false) goto L29;
        r3.add("content", (JsonElement) e);
        goto L30
    L29:
        r3.addProperty("content", e.toString());
    L7:
        e = e;
        goto L8
    }

    public o(b<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        this.a = r2;
    }
}
