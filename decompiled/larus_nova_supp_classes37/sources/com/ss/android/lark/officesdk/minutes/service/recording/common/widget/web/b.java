package com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.lark.officewebview.bridge.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r6, xwb.d r7, com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r8) {
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "featureService");
        if (r6 != null) goto L28;
        return;
    L28:
        JSONArray r9 = new JSONObject(r6).optJSONArray("keys");     // Catch: Exception -> L25
        if (r9 != null) goto L8;
        return;
    L8:
        if (r9.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r9 = null;
    L14:
        if (r9 == null) goto L34;
        IntRange r3 = RangesKt.until(0, r9.length());     // Catch: Exception -> L25
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));     // Catch: Exception -> L25
        IntIterator r5 = r3.iterator();     // Catch: Exception -> L25
    L17:
        if (r5.hasNext() == false) goto L19;
        r4.add(JSONArrayProtectorUtils.getString(r9, r5.nextInt()));     // Catch: Exception -> L25
        goto L17
    L19:
        lvb.a.a("MmWebFgHandler", "[handle] keysList=" + r4);     // Catch: Exception -> L25
        int r10 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.a.f;     // Catch: Exception -> L25
        Map<String, Boolean> r11 = r8.a(r4, false);     // Catch: Exception -> L25
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L25
        Iterator r13 = ((LinkedHashMap) r11).entrySet().iterator();     // Catch: Exception -> L25
    L21:
        if (r13.hasNext() == false) goto L23;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Exception -> L25
        r12.put((String) r14.getKey(), ((Boolean) r14.getValue()).booleanValue());     // Catch: Exception -> L25
        goto L21
    L23:
        lvb.a.a("MmWebFgHandler", "[handle] result=" + r12);     // Catch: Exception -> L25
        r7.a(Status.SUCCESS, r12);     // Catch: Exception -> L25
        Unit r15 = Unit.INSTANCE;     // Catch: Exception -> L25
        return;
    L34:
        return;
    L10:
        r2 = false;
    L25:
        e = move-exception;
        lvb.a.b("MmWebFgHandler", "[handle] error: " + e);
        r7.a(Status.FAILURE, null);
        Unit r16 = Unit.INSTANCE;
    }
}
