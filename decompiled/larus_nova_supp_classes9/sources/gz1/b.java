package gz1;

import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.j;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final JSONObject b(j r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$convertToJSONObject");
        Float r0 = r6.a;
        Float r1 = r6.b;
        Float r2 = r6.c;
        Float r7 = r6.d;
        JSONObject r3 = new JSONObject();
        float r4 = 0.0f;
        if (r0 == null) goto L5;
        float r5 = r0.floatValue();
    L6:
        r3.put(sz1.a.KEY_X, Float.valueOf(r5));
        if (r1 == null) goto L9;
        float r8 = r1.floatValue();
    L10:
        r3.put(sz1.a.KEY_Y, Float.valueOf(r8));
        if (r2 == null) goto L13;
        float r9 = r2.floatValue();
    L14:
        r3.put(sz1.a.KEY_WIDTH, Float.valueOf(r9));
        if (r7 == null) goto L17;
        r4 = r7.floatValue();
    L17:
        r3.put(sz1.a.KEY_HEIGHT, Float.valueOf(r4));
        return r3;
    L13:
        r9 = 0.0f;
        goto L14
    L9:
        r8 = 0.0f;
        goto L10
    L5:
        r5 = 0.0f;
        goto L6
    }

    public static final void a(j r2, JSONObject r3) {
        if (r3 != null) goto L9;
        return;
    L9:
        r2.a = Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r3, sz1.a.KEY_X));     // Catch: Exception -> L6
        r2.b = Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r3, sz1.a.KEY_Y));     // Catch: Exception -> L6
        r2.c = Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r3, sz1.a.KEY_WIDTH));     // Catch: Exception -> L6
        r2.d = Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r3, sz1.a.KEY_HEIGHT));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        jy0.b.c(sz1.a.TAG, "cell frame convertToFrame exception: " + e.getMessage() + " source: " + r3, null, 4);
    }

    public static final boolean c(n r1, n r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSameCard");
        ArrayList<e3> r3 = c.g(r1);
        if (r2 == null) goto L5;
        ArrayList<e3> r4 = c.g(r2);
    L7:
        return c.h(r3, r4);
    L5:
        r4 = null;
        goto L7
    }

    public static final boolean d(n r2, ArrayList<e3> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$isSameCard");
        if (c.h(c.g(r2), r3) == true) goto L26;
        String r5 = r2.getCardName();
        if (r5 != null) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == true) goto L24;
        if (r4 != null) goto L14;
    L17:
        boolean r7 = true;
    L18:
        if (r7 == true) goto L24;
        String r8 = r2.getCardName();
        if (r8 == null) goto L24;
        if (r8.equals(r4) != true) goto L24;
        return true;
    L14:
        if (r4.length() == 0) goto L17;
        r7 = false;
    L24:
        return false;
    L7:
        if (r5.length() == 0) goto L10;
        r6 = false;
        goto L11
    L26:
        return true;
    }
}
