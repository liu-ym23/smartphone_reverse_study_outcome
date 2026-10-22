package tx9;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b2 {
    public static final boolean a(JSONObject r2) {
        if (r2 == null) goto L8;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (d(r2, "_mixed_richmedia_download_trace") != true) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public static final JSONObject b(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L11;
        String r2 = r1.next();
        if (Intrinsics.areEqual(r2, "_mixed_richmedia_download_trace") == true) goto L4;
        if (Intrinsics.areEqual(r2, "_mixed_richmedia_download_suppress") == true) goto L4;
        r0.put(r2, r4.opt(r2));
        goto L4
    L11:
        return r0;
    }

    public static final void c(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.put("_mixed_richmedia_download_trace", 1);
    }

    public static final boolean d(JSONObject r2, String r3) {
        Object r4 = r2.opt(r3);
        if (r4 != null) goto L6;
        return false;
    L6:
        if ((r4 instanceof Boolean) == false) goto L9;
        return ((Boolean) r4).booleanValue();
    L9:
        if ((r4 instanceof Number) == false) goto L14;
        if (((Number) r4).intValue() == 0) goto L22;
    L19:
        return true;
    L22:
        return false;
    L14:
        if ((r4 instanceof String) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(r4, "1") == true) goto L19;
        if (StringsKt.equals((String) r4, "true", true) == true) goto L19;
        return false;
    }

    public static final boolean e(Map<?, ?> r1, String r2) {
        if (r1 == null) goto L21;
        Object r3 = r1.get(r2);
        if (r3 == null) goto L21;
        if ((r3 instanceof Boolean) == false) goto L10;
        return ((Boolean) r3).booleanValue();
    L10:
        if ((r3 instanceof Number) == false) goto L15;
        if (((Number) r3).intValue() == 0) goto L21;
    L20:
        return true;
    L15:
        if ((r3 instanceof String) == false) goto L21;
        if (Intrinsics.areEqual(r3, "1") == true) goto L20;
        if (StringsKt.equals((String) r3, "true", true) == true) goto L20;
    L21:
        return false;
    }

    public static final void f(JSONObject r3, boolean r4) {
        boolean r0 = a(r3);
        if (r3 == null) goto L7;
        boolean r2 = true;
        if (d(r3, "_mixed_richmedia_download_suppress") != true) goto L7;
    L8:
        g(r3, r0, r2, r4);
        return;
    L7:
        r2 = false;
        goto L8
    }

    public static final void g(JSONObject r0, boolean r1, boolean r2, boolean r3) {
        if (r0 != null) goto L4;
        return;
    L4:
        if (r3 == false) goto L6;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        r0.remove("_mixed_richmedia_download_trace");
        r0.remove("_mixed_richmedia_download_suppress");
    L6:
        if (r1 == false) goto L11;
        if (r2 == true) goto L12;
        com.larus.platform.service.o.a.reportEvent("mixed_richmedia_download", b(r0));
        return;
    L12:
        return;
    }
}
