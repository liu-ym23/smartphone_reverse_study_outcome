package t3;

import com.google.gson.JsonPrimitive;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p0 {
    public static final p0 a = null;
    public static final List<String> b = null;

    public p0() {
    }

    static {
        a = new p0();
        b = CollectionsKt.listOf(new String[]{"Hardware", "Processor", "model name", "cpu model"});
    }

    public static Double a(Object r10) {
        if ((r10 instanceof Number) == false) goto L6;
        return Double.valueOf(((Number) r10).doubleValue());
    L6:
        if ((r10 instanceof String) == true) goto L24;
        Object r1 = null;
        if ((r10 instanceof JsonPrimitive) == false) goto L20;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r11 = Result.constructor-impl(Double.valueOf(((JsonPrimitive) r10).getAsDouble()));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r11) == true) goto L25;
        r1 = r11;
    L25:
        return (Double) r1;
    L12:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L20:
        return null;
    L24:
        return StringsKt.toDoubleOrNull((String) r10);
    }
}
