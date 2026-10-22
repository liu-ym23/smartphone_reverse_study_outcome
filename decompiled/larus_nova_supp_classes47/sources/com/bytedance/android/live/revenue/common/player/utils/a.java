package com.bytedance.android.live.revenue.common.player.utils;

import com.bytedance.android.livesdk.model.n0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final JSONArray b(String r5) {
        String r0 = "";
        Intrinsics.checkNotNullParameter(r5, "sei");
        JSONObject r3 = j(r5);     // Catch: Throwable -> L11
        if (r3 != null) goto L7;
        return null;
    L7:
        if (r3.has("app_data") == true) goto L9;
        return null;
    L9:
        return new JSONArray(new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r3, "app_data"), "")).optString("grids"));
    L11:
        th = move-exception;
        jy0.b.d("SeiUtils", "parse sei: " + r5 + " failed");
        String r6 = th.getMessage();
        if (r6 == null) goto L16;
        r0 = r6;
    L16:
        jy0.b.d("SeiUtils", r0);
        return null;
    }

    public static final JSONArray c(JSONObject r3) {
        if (r3 != null) goto L15;
    L7:
        if (r3 == null) goto L13;
        String r4 = r3.optString("grids");     // Catch: Throwable -> L14
        if (r4 == null) goto L13;
        return new JSONArray(r4);
    L13:
        return null;
    L15:
        JSONArray r2 = r3.optJSONArray("grids");     // Catch: Throwable -> L14
        if (r2 == null) goto L7;
        return r2;
    }

    public static final double d(JSONArray r4) {
        Intrinsics.checkNotNullParameter(r4, "grids");
        return f(r4) - h(r4);
    }

    public static final double e(JSONArray r12) {
        Intrinsics.checkNotNullParameter(r12, "grids");
        if (r12.length() > 0) goto L5;
        return 0.0d;
    L5:
        if (r12.opt(0) == null) goto L38;
        IntRange r0 = RangesKt.until(0, r12.length());
        ArrayList r3 = new ArrayList();
        IntIterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L24;
        Object r4 = r12.opt(r1.nextInt());
        Double r6 = null;
        if ((r4 instanceof JSONObject) == true) goto L13;
        r4 = null;
    L13:
        JSONObject r5 = (JSONObject) r4;
        if (r5 == null) goto L22;
        float r7 = (float) r5.optDouble("w");
        float r8 = (float) r5.optDouble("h");
        double r9 = r5.optDouble("x");
        if (r7 <= 0.0f) goto L22;
        if (r8 <= 0.0f) goto L22;
        r6 = Double.valueOf(r9 + ((double) r7));
    L22:
        if (r6 == null) goto L9;
        r3.add(r6);
        goto L9
    L24:
        List r13 = CollectionsKt.sorted(r3);
        if (r13.isEmpty() == false) goto L27;
        return 0.0d;
    L27:
        Double r14 = (Double) CollectionsKt.lastOrNull(r13);
        if (r14 != null) goto L30;
        return 0.0d;
    L30:
        return r14.doubleValue();
    L38:
        return 0.0d;
    }

    public static final double f(JSONArray r10) {
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
        double r9 = r5.optDouble("y");
        if (r7 <= 0.0f) goto L22;
        if (r8 <= 0.0f) goto L22;
        r6 = Double.valueOf(r9 + ((double) r8));
    L22:
        if (r6 == null) goto L9;
        r3.add(r6);
        goto L9
    L24:
        List r12 = CollectionsKt.sorted(r3);
        if (r12.isEmpty() == false) goto L27;
        return 0.0d;
    L27:
        Double r13 = (Double) CollectionsKt.lastOrNull(r12);
        if (r13 != null) goto L30;
        return 0.0d;
    L30:
        return r13.doubleValue();
    L38:
        return 0.0d;
    }

    public static final double g(JSONArray r10) {
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
        double r9 = r5.optDouble("x");
        if (r7 <= 0.0f) goto L22;
        if (r8 <= 0.0f) goto L22;
        r6 = Double.valueOf(r9);
    L22:
        if (r6 == null) goto L9;
        r3.add(r6);
        goto L9
    L24:
        List r12 = CollectionsKt.sorted(r3);
        if (r12.isEmpty() == false) goto L27;
        return 0.0d;
    L27:
        Double r13 = (Double) CollectionsKt.firstOrNull(r12);
        if (r13 != null) goto L30;
        return 0.0d;
    L30:
        return r13.doubleValue();
    L38:
        return 0.0d;
    }

    public static final double h(JSONArray r10) {
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
        double r9 = r5.optDouble("y");
        if (r7 <= 0.0f) goto L22;
        if (r8 <= 0.0f) goto L22;
        r6 = Double.valueOf(r9);
    L22:
        if (r6 == null) goto L9;
        r3.add(r6);
        goto L9
    L24:
        List r12 = CollectionsKt.sorted(r3);
        if (r12.isEmpty() == false) goto L27;
        return 0.0d;
    L27:
        Double r13 = (Double) CollectionsKt.firstOrNull(r12);
        if (r13 != null) goto L30;
        return 0.0d;
    L30:
        return r13.doubleValue();
    L38:
        return 0.0d;
    }

    public static final double i(JSONArray r4) {
        Intrinsics.checkNotNullParameter(r4, "grids");
        return e(r4) - g(r4);
    }

    public static final JSONObject j(String r3) {
        if (r3.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L30;
        JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L19
        if (r4.has("info") == true) goto L10;
        return r4;
    L10:
        if (r4.has("source") == true) goto L12;
        return r4;
    L12:
        if (Intrinsics.areEqual(r4.optString("source"), "zego") == false) goto L28;
        Object r5 = r4.get("info");     // Catch: Throwable -> L19
        if (r5 == null) goto L17;
        return (JSONObject) r5;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Throwable -> L19
    L28:
        return r4;
    L19:
        th = move-exception;
        String r6 = th.getMessage();
        if (r6 != null) goto L23;
        r6 = "";
    L23:
        jy0.b.d("SeiUtils", r6);
        return null;
    L30:
        return null;
    L5:
        r2 = false;
        goto L6
    }

    public static final n0 a(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "sei");
        if (r4 == true) goto L5;
    L7:
        JSONObject r5 = j(r3);
        if (r5 != null) goto L11;
        return null;
    L11:
        if (r5.has("live_crop") == true) goto L13;
        return null;
    L13:
        int r6 = n0.a;
        n0 r7 = n0.a.a(JSONObjectProtectorUtils.getJSONObject(r5, "live_crop"));
        if (r7 != null) goto L16;
    L19:
        return null;
    L16:
        if (r7.g() == false) goto L19;
        return r7;
    L5:
        if (StringsKt.contains$default(r3, "live_crop", false, 2, null) == true) goto L7;
        return null;
    }
}
