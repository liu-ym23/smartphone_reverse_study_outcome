package com.obric.aivoice.core.utils;

import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.IdlKeys;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f¨\u0006\u0012"}, d2 = {"bundle2json", "Lorg/json/JSONObject;", "args", "Landroid/os/Bundle;", "json2Bundle", "compressFloat", NameKeys.UnloadStrategy_No_Strategy, "saveArr", NameKeys.UnloadStrategy_No_Strategy, "arr", "Lorg/json/JSONArray;", "key", NameKeys.UnloadStrategy_No_Strategy, "bundle", "setErr", LynxResourceModule.CODE_KEY, NameKeys.UnloadStrategy_No_Strategy, "errInfo", "voicesdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BundleExtKt {
    public static final JSONObject bundle2json(Bundle r9) {
        Intrinsics.checkNotNullParameter(r9, "args");
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r9.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L78;
        String r2 = r1.next();
        Object r3 = r9.get(r2);
        if ((r3 instanceof Integer) == true) goto L7;
        if ((r3 instanceof int[]) == true) goto L10;
        if ((r3 instanceof Long) == true) goto L17;
        if ((r3 instanceof long[]) == true) goto L20;
        if ((r3 instanceof Boolean) == true) goto L27;
        if ((r3 instanceof boolean[]) == true) goto L30;
        if ((r3 instanceof Double) == true) goto L37;
        if ((r3 instanceof double[]) == true) goto L40;
        if ((r3 instanceof Float) == true) goto L47;
        if ((r3 instanceof float[]) == true) goto L50;
        if ((r3 instanceof String) == true) goto L57;
        if ((r3 instanceof Bundle) == true) goto L60;
        if ((r3 instanceof Object[]) == false) goto L4;
        Object[] r4 = (Object[]) r3;
        if (r4.length <= 0) goto L78;
        if ((r4[0] instanceof Bundle) == true) goto L68;
        JSONArray r5 = new JSONArray();
        IntIterator r6 = RangesKt.until(0, r4.length).iterator();
    L75:
        if (r6.hasNext() == false) goto L77;
        int r7 = r6.nextInt();
        r5.put(r7, r4[r7]);
        goto L75
    L77:
        Unit r8 = Unit.INSTANCE;
        r0.put(r2, r5);
        goto L4
    L68:
        JSONArray r10 = new JSONArray();
        IntIterator r11 = RangesKt.until(0, r4.length).iterator();
    L70:
        if (r11.hasNext() == false) goto L72;
        int r12 = r11.nextInt();
        Object r13 = r4[r12];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.os.Bundle");
        r10.put(r12, bundle2json((Bundle) r13));
        goto L70
    L72:
        Unit r14 = Unit.INSTANCE;
        r0.put(r2, r10);
        goto L4
    L60:
        r0.put(r2, bundle2json((Bundle) r3));
        goto L4
    L57:
        r0.put(r2, r3);
        goto L4
    L50:
        JSONArray r15 = new JSONArray();
        float[] r16 = (float[]) r3;
        IntIterator r17 = RangesKt.until(0, r16.length).iterator();
    L52:
        if (r17.hasNext() == false) goto L54;
        int r18 = r17.nextInt();
        r15.put(r18, Float.valueOf(r16[r18]));
        goto L52
    L54:
        Unit r19 = Unit.INSTANCE;
        r0.put(r2, r15);
        goto L4
    L47:
        r0.put(r2, r3);
        goto L4
    L40:
        JSONArray r20 = new JSONArray();
        double[] r21 = (double[]) r3;
        IntIterator r22 = RangesKt.until(0, r21.length).iterator();
    L42:
        if (r22.hasNext() == false) goto L44;
        int r23 = r22.nextInt();
        r20.put(r23, r21[r23]);
        goto L42
    L44:
        Unit r24 = Unit.INSTANCE;
        r0.put(r2, r20);
        goto L4
    L37:
        r0.put(r2, ((Number) r3).doubleValue());
        goto L4
    L30:
        JSONArray r25 = new JSONArray();
        boolean[] r26 = (boolean[]) r3;
        IntIterator r27 = RangesKt.until(0, r26.length).iterator();
    L32:
        if (r27.hasNext() == false) goto L34;
        int r28 = r27.nextInt();
        r25.put(r28, r26[r28]);
        goto L32
    L34:
        Unit r29 = Unit.INSTANCE;
        r0.put(r2, r25);
        goto L4
    L27:
        r0.put(r2, ((Boolean) r3).booleanValue());
        goto L4
    L20:
        JSONArray r30 = new JSONArray();
        long[] r31 = (long[]) r3;
        IntIterator r32 = RangesKt.until(0, r31.length).iterator();
    L22:
        if (r32.hasNext() == false) goto L24;
        int r33 = r32.nextInt();
        r30.put(r33, r31[r33]);
        goto L22
    L24:
        Unit r34 = Unit.INSTANCE;
        r0.put(r2, r30);
        goto L4
    L17:
        r0.put(r2, ((Number) r3).longValue());
        goto L4
    L10:
        JSONArray r35 = new JSONArray();
        int[] r36 = (int[]) r3;
        IntIterator r37 = RangesKt.until(0, r36.length).iterator();
    L12:
        if (r37.hasNext() == false) goto L14;
        int r38 = r37.nextInt();
        r35.put(r38, r36[r38]);
        goto L12
    L14:
        Unit r39 = Unit.INSTANCE;
        r0.put(r2, r35);
        goto L4
    L7:
        r0.put(r2, ((Number) r3).intValue());
    L78:
        return r0;
    }

    public static final Bundle json2Bundle(JSONObject r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "args");
        Bundle r0 = new Bundle();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L28;
        String r2 = r1.next();
        Object r3 = r5.get(r2);
        if ((r3 instanceof String) == true) goto L7;
        if ((r3 instanceof Integer) == true) goto L10;
        if ((r3 instanceof Long) == true) goto L13;
        if ((r3 instanceof Boolean) == true) goto L16;
        if ((r3 instanceof Double) == true) goto L19;
        if ((r3 instanceof JSONArray) == true) goto L24;
        if ((r3 instanceof JSONObject) == false) goto L4;
        r0.putBundle(r2, json2Bundle((JSONObject) r3, r6));
        goto L4
    L24:
        saveArr((JSONArray) r3, r2, r0, r6);
        goto L4
    L19:
        if (r6 == true) goto L20;
        r0.putDouble(r2, ((Number) r3).doubleValue());
        goto L4
    L20:
        r0.putFloat(r2, (float) ((Number) r3).doubleValue());
        goto L4
    L16:
        r0.putBoolean(r2, ((Boolean) r3).booleanValue());
        goto L4
    L13:
        r0.putLong(r2, ((Number) r3).longValue());
        goto L4
    L10:
        r0.putInt(r2, ((Number) r3).intValue());
        goto L4
    L7:
        r0.putString(r2, (String) r3);
        goto L4
    L28:
        return r0;
    }

    public static final Bundle setErr(Bundle r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.putInt(IdlKeys.ErrorCode, r2);
        r1.putString(IdlKeys.ErrorInfo, r3);
        r1.putBoolean(IdlKeys.IsFinish, true);
        return r1;
    }

    public static /* synthetic */ Bundle json2Bundle$default(JSONObject r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = true;
    L6:
        return json2Bundle(r0, r1);
    }

    public static final void saveArr(JSONArray r5, String r6, Bundle r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "arr");
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "bundle");
        if (r5.length() != 0) goto L5;
        return;
    L5:
        Object r1 = r5.opt(0);
        if (r1 != null) goto L8;
        return;
    L8:
        IntRange r2 = new IntRange(0, r5.length() - 1);
        if ((r1 instanceof String) == false) goto L16;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        IntIterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        r9.add(JSONArrayProtectorUtils.getString(r5, r3.nextInt()));
        goto L12
    L14:
        r7.putStringArray(r6, (String[]) r9.toArray(new String[0]));
        return;
    L16:
        if ((r1 instanceof Integer) == false) goto L23;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        IntIterator r0 = r2.iterator();
    L19:
        if (r0.hasNext() == false) goto L21;
        r10.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r5, r0.nextInt())));
        goto L19
    L21:
        r7.putIntArray(r6, CollectionsKt.toIntArray(r10));
        return;
    L23:
        if ((r1 instanceof Long) == false) goto L30;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        IntIterator r4 = r2.iterator();
    L26:
        if (r4.hasNext() == false) goto L28;
        r11.add(Long.valueOf(JSONArrayProtectorUtils.getLong(r5, r4.nextInt())));
        goto L26
    L28:
        r7.putLongArray(r6, CollectionsKt.toLongArray(r11));
        return;
    L30:
        if ((r1 instanceof Boolean) == false) goto L37;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        IntIterator r13 = r2.iterator();
    L33:
        if (r13.hasNext() == false) goto L35;
        r12.add(Boolean.valueOf(JSONArrayProtectorUtils.getBoolean(r5, r13.nextInt())));
        goto L33
    L35:
        r7.putBooleanArray(r6, CollectionsKt.toBooleanArray(r12));
        return;
    L37:
        if ((r1 instanceof Double) == false) goto L50;
        if (r8 == false) goto L44;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        IntIterator r15 = r2.iterator();
    L41:
        if (r15.hasNext() == false) goto L43;
        r14.add(Float.valueOf((float) JSONArrayProtectorUtils.getDouble(r5, r15.nextInt())));
        goto L41
    L43:
        r7.putFloatArray(r6, CollectionsKt.toFloatArray(r14));
        return;
    L44:
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        IntIterator r17 = r2.iterator();
    L46:
        if (r17.hasNext() == false) goto L48;
        r16.add(Double.valueOf(JSONArrayProtectorUtils.getDouble(r5, r17.nextInt())));
        goto L46
    L48:
        r7.putDoubleArray(r6, CollectionsKt.toDoubleArray(r16));
        return;
    L50:
        if ((r1 instanceof JSONObject) == false) goto L56;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        IntIterator r19 = r2.iterator();
    L53:
        if (r19.hasNext() == false) goto L55;
        r18.add(json2Bundle(JSONArrayProtectorUtils.getJSONObject(r5, r19.nextInt()), r8));
        goto L53
    L55:
        r7.putParcelableArray(r6, (Parcelable[]) r18.toArray(new Bundle[0]));
        return;
    L56:
        boolean r20 = r1 instanceof JSONArray;
    }
}
