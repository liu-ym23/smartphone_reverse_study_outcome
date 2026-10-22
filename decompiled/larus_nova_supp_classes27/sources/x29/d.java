package x29;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public static final d a = null;
    public static final Regex b = null;

    public d() {
    }

    static {
        a = new d();
        b = new Regex("^[0-9]+$");
    }

    public static Long a(JsonElement r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.isJsonPrimitive() == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L40;
        JsonPrimitive r7 = r6.getAsJsonPrimitive();
        if (r7 == null) goto L43;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
        if (r7.isNumber() == false) goto L16;
        Long r8 = Long.valueOf(new BigDecimal(r7.getAsString()).toBigIntegerExact().longValueExact());     // Catch: Throwable -> L23
    L21:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r9) == false) goto L28;
        r9 = null;
    L28:
        Long r10 = (Long) r9;
        if (r10 != null) goto L31;
        return null;
    L31:
        if (r10.longValue() < 0) goto L33;
        boolean r2 = true;
    L34:
        if (r2 == true) goto L36;
        return null;
    L36:
        return r10;
    L33:
        r2 = false;
        goto L34
    L16:
        if (r7.isString() == true) goto L18;
    L20:
        r8 = null;
        goto L21
    L18:
        if (b.matches(r7.getAsString()) == false) goto L20;
        r8 = StringsKt.toLongOrNull(r7.getAsString());     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L43:
        return null;
    L40:
        return null;
    }
}
