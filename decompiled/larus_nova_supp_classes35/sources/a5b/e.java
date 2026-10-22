package a5b;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final String d(Object r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (Intrinsics.areEqual(r10, JSONObject.NULL) == false) goto L7;
        return null;
    L7:
        if ((r10 instanceof String) == false) goto L11;
        return (String) r10;
    L11:
        if ((r10 instanceof JSONArray) == false) goto L21;
        JSONArray r11 = (JSONArray) r10;
        IntRange r0 = RangesKt.until(0, r11.length());
        ArrayList r1 = new ArrayList();
        IntIterator r2 = r0.iterator();
    L14:
        if (r2.hasNext() == false) goto L19;
        String r3 = d(r11.opt(r2.nextInt()));
        if (r3 == null) goto L14;
        r1.add(r3);
        goto L14
    L19:
        return CollectionsKt.joinToString$default(r1, "\n", null, null, 0, null, null, 62, null);
    L21:
        if ((r10 instanceof JSONObject) == false) goto L27;
        return ((JSONObject) r10).toString(2);
    L25:
        return ((JSONObject) r10).toString();
    L27:
        return r10.toString();
    }

    public static final String a(JSONObject r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "json");
        Intrinsics.checkNotNullParameter(r5, "eventContent");
        String r6 = c(r4, new String[]{"delta", "text", "content_delta", "args_delta"});
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r5;
    L9:
        return r6;
    L5:
        r0 = false;
        goto L6
    }

    public static final Object b(JSONObject r5, String... r6) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r6, "keys");
        int r0 = r6.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L14;
        String r3 = r6[r1];
        if (r5.has(r3) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        Object r7 = r5.opt(r3);
        if (r7 != null) goto L10;
        return null;
    L10:
        if ((!Intrinsics.areEqual(r7, JSONObject.NULL)) == true) goto L12;
        return null;
    L12:
        return r7;
    L14:
        return null;
    }

    public static final String c(JSONObject r5, String... r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "keys");
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        String r3 = r6[r2];
        if (r5.has(r3) == false) goto L14;
        if (r5.isNull(r3) == true) goto L14;
        String r4 = r5.optString(r3);
        Intrinsics.checkNotNull(r4);
        if (r4.length() <= 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        return r4;
    L11:
        r7 = false;
    L14:
        r2 = r2 + 1;
        goto L3
    L15:
        return BuildConfig.FLAVOR;
    }
}
