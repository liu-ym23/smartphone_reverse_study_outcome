package w09;

import com.larus.common.venue.impl.venue.api.Pocket;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final Integer a(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof Integer) == false) goto L9;
        return (Integer) r2;
    L9:
        if ((r2 instanceof Number) == false) goto L12;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Number");
        return Integer.valueOf(((Number) r2).intValue());
    L12:
        if ((r2 instanceof String) == true) goto L14;
        return null;
    L14:
        return StringsKt.toIntOrNull((String) r2);
    }

    public static final String b(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof String) == false) goto L9;
        return (String) r2;
    L9:
        if ((r2 instanceof Number) == false) goto L12;
        return ((Number) r2).toString();
    L12:
        if ((r2 instanceof Boolean) == true) goto L14;
        return null;
    L14:
        return String.valueOf(((Boolean) r2).booleanValue());
    }

    public static final Pocket c(Map<String, ? extends Object> r22) {
        Intrinsics.checkNotNullParameter(r22, "<this>");
        String r3 = b(r22.get("pocket_id"));
        String r4 = b(r22.get("prompt_for_display"));
        String r17 = b(r22.get("prompt_for_chat"));
        return new Pocket(r3, r4, null, null, a(r22.get("pocket_type")), a(r22.get("pocket_tag")), null, null, null, null, null, null, null, b(r22.get("ext")), r17, null, null, 106444, null);
    }
}
