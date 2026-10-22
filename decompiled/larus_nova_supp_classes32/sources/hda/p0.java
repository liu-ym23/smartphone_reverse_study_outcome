package hda;

import com.obric.aivoice.core.data.NameKeys;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p0 {
    public static final String a(q0 r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        long r0 = r4.h;
        if (r0 > 0) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r0));
    }

    public static final String b(JSONObject r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        if (r2.has(r3) == true) goto L5;
        return null;
    L5:
        if (r2.isNull(r3) == true) goto L18;
        String r4 = r2.optString(r3);
        Intrinsics.checkNotNull(r4);
        boolean r0 = true;
        if ((!StringsKt.isBlank(r4)) == true) goto L10;
    L12:
        r0 = false;
    L13:
        if (r0 == true) goto L15;
        return null;
    L15:
        return r4;
    L10:
        if (Intrinsics.areEqual(r4, "null") == true) goto L12;
    L18:
        return null;
    }
}
