package com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
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
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r8, xwb.d r9, com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b r10) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "settingsService");
        if (r8 != null) goto L40;
        return;
    L40:
        JSONArray r11 = new JSONObject(r8).optJSONArray("keys");     // Catch: Exception -> L37
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        r11 = null;
    L14:
        if (r11 == null) goto L51;
        IntRange r4 = RangesKt.until(0, r11.length());     // Catch: Exception -> L37
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Exception -> L37
        IntIterator r5 = r4.iterator();     // Catch: Exception -> L37
    L17:
        if (r5.hasNext() == false) goto L19;
        r6.add(JSONArrayProtectorUtils.getString(r11, r5.nextInt()));     // Catch: Exception -> L37
        goto L17
    L19:
        lvb.a.a("MmWebSettingsHandler", "[handle] keysList=" + r6);     // Catch: Exception -> L37
        r10.getClass();     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter(r6, "keys");     // Catch: Exception -> L37
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Exception -> L37
        Iterator r13 = r6.iterator();     // Catch: Exception -> L37
    L21:
        if (r13.hasNext() == false) goto L31;
        String r0 = (String) r13.next();     // Catch: Exception -> L37
        String r7 = SettingManager.getInstance().getSettingConfig(r0, true);     // Catch: Exception -> L37
        if (r7 != null) goto L25;
    L28:
        boolean r14 = true;
    L29:
        if (r14 == true) goto L21;
        r12.put(r0, r7);     // Catch: Exception -> L37
        goto L21
    L25:
        if (r7.length() == 0) goto L28;
        r14 = false;
        goto L29
    L31:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L37
        Iterator r16 = r12.entrySet().iterator();     // Catch: Exception -> L37
    L33:
        if (r16.hasNext() == false) goto L35;
        Map.Entry r1 = (Map.Entry) r16.next();     // Catch: Exception -> L37
        r15.put((String) r1.getKey(), (String) r1.getValue());     // Catch: Exception -> L37
        goto L33
    L35:
        lvb.a.a("MmWebSettingsHandler", "[handle] result=" + r15);     // Catch: Exception -> L37
        r9.a(Status.SUCCESS, r15);     // Catch: Exception -> L37
        Unit r17 = Unit.INSTANCE;     // Catch: Exception -> L37
        return;
    L51:
        return;
    L10:
        r3 = false;
    L37:
        e = move-exception;
        lvb.a.b("MmWebSettingsHandler", "[handle] error: " + e);
        r9.a(Status.FAILURE, null);
        Unit r18 = Unit.INSTANCE;
    }
}
