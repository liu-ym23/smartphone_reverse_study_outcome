package z82;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdkapi.model.CropSeiData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final CropSeiData a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "sei");
        JSONObject r4 = g(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.has("live_crop") == true) goto L8;
        return null;
    L8:
        CropSeiData r5 = CropSeiData.parseCropSei(JSONObjectProtectorUtils.getJSONObject(r4, "live_crop"));
        if (r5 != null) goto L11;
    L14:
        return null;
    L11:
        if (r5.isLegalCropSei() == false) goto L14;
        return r5;
    }

    public static final JSONArray b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sei");
        JSONObject r2 = g(r4);     // Catch: JSONException -> L11
        if (r2 != null) goto L7;
        return null;
    L7:
        if (r2.has("app_data") == true) goto L9;
        return null;
    L9:
        return new JSONArray(new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r2, "app_data"), BuildConfig.FLAVOR)).optString("grids"));
    L11:
        e = move-exception;
        ALogger.i("SeiUtils", "parse sei: " + r4 + " failed");
        ALogger.i("SeiUtils", e.getMessage());
        return null;
    }

    public static final double c(JSONArray r8) {
        Intrinsics.checkNotNullParameter(r8, "grids");
        Intrinsics.checkNotNullParameter(r8, "grids");
        if (r8.length() > 0) goto L5;
    L30:
        double r0 = 0.0d;
    L32:
        return r0 - e(r8);
    L5:
        if (r8.opt(0) == null) goto L30;
        IntRange r1 = RangesKt.until(0, r8.length());
        ArrayList r2 = new ArrayList();
        IntIterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L24;
        Object r4 = r8.opt(r3.nextInt());
        Double r5 = null;
        if ((r4 instanceof JSONObject) == true) goto L13;
        r4 = null;
    L13:
        JSONObject r6 = (JSONObject) r4;
        if (r6 == null) goto L22;
        float r7 = (float) r6.optDouble("w");
        float r9 = (float) r6.optDouble("h");
        double r10 = r6.optDouble(sz1.a.KEY_Y);
        if (r7 <= 0.0f) goto L22;
        if (r9 <= 0.0f) goto L22;
        r5 = Double.valueOf(r10 + ((double) r9));
    L22:
        if (r5 == null) goto L9;
        r2.add(r5);
        goto L9
    L24:
        List r11 = CollectionsKt.sorted(r2);
        if (r11.isEmpty() == true) goto L30;
        Double r13 = (Double) CollectionsKt.lastOrNull(r11);
        if (r13 == null) goto L30;
        r0 = r13.doubleValue();
        goto L32
    }

    public static final double d(JSONArray r10) {
        Intrinsics.checkNotNullParameter(r10, "grids");
        if (r10.length() > 0) goto L5;
        return 0.0d;
    L5:
        if (r10.opt(0) == null) goto L38;
        IntRange r0 = RangesKt.until(0, r10.length());
        ArrayList r3 = new ArrayList();
        IntIterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L24;
        Object r4 = r10.opt(r1.nextInt());
        Double r6 = null;
        if ((r4 instanceof JSONObject) == true) goto L13;
        r4 = null;
    L13:
        JSONObject r5 = (JSONObject) r4;
        if (r5 == null) goto L22;
        float r7 = (float) r5.optDouble("w");
        float r8 = (float) r5.optDouble("h");
        double r9 = r5.optDouble(sz1.a.KEY_X);
        if (r7 <= 0.0f) goto L22;
        if (r8 <= 0.0f) goto L22;
        r6 = Double.valueOf(r9);
    L22:
        if (r6 == null) goto L9;
        r3.add(r6);
        goto L9
    L24:
        List r11 = CollectionsKt.sorted(r3);
        if (r11.isEmpty() == false) goto L27;
        return 0.0d;
    L27:
        Double r13 = (Double) CollectionsKt.firstOrNull(r11);
        if (r13 != null) goto L30;
        return 0.0d;
    L30:
        return r13.doubleValue();
    L38:
        return 0.0d;
    }

    public static final double e(JSONArray r10) {
        Intrinsics.checkNotNullParameter(r10, "grids");
        if (r10.length() > 0) goto L5;
        return 0.0d;
    L5:
        if (r10.opt(0) == null) goto L38;
        IntRange r0 = RangesKt.until(0, r10.length());
        ArrayList r3 = new ArrayList();
        IntIterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L24;
        Object r4 = r10.opt(r1.nextInt());
        Double r6 = null;
        if ((r4 instanceof JSONObject) == true) goto L13;
        r4 = null;
    L13:
        JSONObject r5 = (JSONObject) r4;
        if (r5 == null) goto L22;
        float r7 = (float) r5.optDouble("w");
        float r8 = (float) r5.optDouble("h");
        double r9 = r5.optDouble(sz1.a.KEY_Y);
        if (r7 <= 0.0f) goto L22;
        if (r8 <= 0.0f) goto L22;
        r6 = Double.valueOf(r9);
    L22:
        if (r6 == null) goto L9;
        r3.add(r6);
        goto L9
    L24:
        List r11 = CollectionsKt.sorted(r3);
        if (r11.isEmpty() == false) goto L27;
        return 0.0d;
    L27:
        Double r13 = (Double) CollectionsKt.firstOrNull(r11);
        if (r13 != null) goto L30;
        return 0.0d;
    L30:
        return r13.doubleValue();
    L38:
        return 0.0d;
    }

    public static final double f(JSONArray r9) {
        Intrinsics.checkNotNullParameter(r9, "grids");
        Intrinsics.checkNotNullParameter(r9, "grids");
        if (r9.length() > 0) goto L5;
    L30:
        double r0 = 0.0d;
    L32:
        return r0 - d(r9);
    L5:
        if (r9.opt(0) == null) goto L30;
        IntRange r1 = RangesKt.until(0, r9.length());
        ArrayList r2 = new ArrayList();
        IntIterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L24;
        Object r4 = r9.opt(r3.nextInt());
        Double r5 = null;
        if ((r4 instanceof JSONObject) == true) goto L13;
        r4 = null;
    L13:
        JSONObject r6 = (JSONObject) r4;
        if (r6 == null) goto L22;
        float r7 = (float) r6.optDouble("w");
        float r8 = (float) r6.optDouble("h");
        double r10 = r6.optDouble(sz1.a.KEY_X);
        if (r7 <= 0.0f) goto L22;
        if (r8 <= 0.0f) goto L22;
        r5 = Double.valueOf(r10 + ((double) r7));
    L22:
        if (r5 == null) goto L9;
        r2.add(r5);
        goto L9
    L24:
        List r11 = CollectionsKt.sorted(r2);
        if (r11.isEmpty() == true) goto L30;
        Double r13 = (Double) CollectionsKt.lastOrNull(r11);
        if (r13 == null) goto L30;
        r0 = r13.doubleValue();
        goto L32
    }

    public static final JSONObject g(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L24;
        LiveSeiUtil.i.getClass();     // Catch: JSONException -> L16
        JSONObject r4 = LiveSeiUtil.c(r3);     // Catch: JSONException -> L16
        if (r4.has("info") == true) goto L7;
        return r4;
    L7:
        if (r4.has("source") == true) goto L9;
        return r4;
    L9:
        if (TextUtils.equals(r4.optString("source"), "zego") == false) goto L22;
        Object r5 = r4.get("info");     // Catch: JSONException -> L16
        if (r5 == null) goto L14;
        return (JSONObject) r5;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: JSONException -> L16
    L22:
        return r4;
    L16:
        e = move-exception;
        ALogger.i("SeiUtils", e.getMessage());
        return null;
    L24:
        return null;
    }
}
