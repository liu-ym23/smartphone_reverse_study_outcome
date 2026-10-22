package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import luc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s {
    public static final JsonEncodingException b(f r3) {
        Intrinsics.checkNotNullParameter(r3, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + r3.f() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + r3.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonEncodingException a(Number r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Intrinsics.checkNotNullParameter(r4, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + r3 + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + f(r4, -1));
    }

    public static final JsonDecodingException c(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (r3 < 0) goto L6;
        r4 = "Unexpected JSON token at offset " + r3 + ": " + r4;
    L6:
        return new JsonDecodingException(r4);
    }

    public static final void e(a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "entity");
        r2.l("Trailing comma before the end of JSON " + r3, r2.a - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static final CharSequence f(CharSequence r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() >= 200) goto L5;
        return r5;
    L5:
        String r1 = ".....";
        if (r6 != (-1)) goto L12;
        int r7 = r5.length() - 60;
        if (r7 > 0) goto L11;
        return r5;
    L11:
        return "....." + r5.subSequence(r7, r5.length()).toString();
    L12:
        int r0 = r6 - 30;
        int r8 = r6 + 30;
        if (r0 > 0) goto L15;
        String r3 = "";
    L17:
        if (r8 < r5.length()) goto L20;
        r1 = "";
    L20:
        return r3 + r5.subSequence(RangesKt.coerceAtLeast(r0, 0), RangesKt.coerceAtMost(r8, r5.length())).toString() + r1;
    L15:
        r3 = ".....";
        goto L17
    }

    public static final void g(a r3, Number r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "result");
        a.m(r3, "Unexpected special floating-point value " + r4 + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    public static final JsonDecodingException d(int r1, String r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "input");
        return c(r1, r2 + "\nJSON input: " + f(r3, r1));
    }

    public static final String h(Number r2, String r3, String r4) {
        return "Unexpected special floating-point value " + r2 + " with key " + r3 + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + f(r4, -1);
    }
}
