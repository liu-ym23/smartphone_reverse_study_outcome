package com.obric.assistant.cocreationreview.modules.memory;

import hda.q0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(JSONObject r1, String r2) {
        if (r1.has(r2) == true) goto L5;
    L15:
        return null;
    L5:
        if (r1.isNull(r2) == true) goto L15;
        String r3 = r1.optString(r2);
        Intrinsics.checkNotNull(r3);
        boolean r0 = true;
        if ((!StringsKt.isBlank(r3)) == true) goto L10;
    L12:
        r0 = false;
    L13:
        if (r0 == false) goto L15;
        return r3;
    L10:
        if (Intrinsics.areEqual(r3, "null") == true) goto L12;
        goto L12
    }

    public static List b(JSONArray r22, MemoryDataReviewModuleKey r23) {
        if (r22 == null) goto L5;
        ArrayList r1 = new ArrayList();
        int r2 = r22.length();
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L39;
        JSONObject r5 = r22.optJSONObject(r4);
        if (r5 == null) goto L38;
        MemoryDataReviewModuleKey.a r6 = MemoryDataReviewModuleKey.Companion;
        String r7 = a(r5, "module");
        r6.getClass();
        MemoryDataReviewModuleKey[] r8 = MemoryDataReviewModuleKey.values();
        int r9 = r8.length;
        int r10 = 0;
    L12:
        String r11 = null;
        if (r10 >= r9) goto L18;
        MemoryDataReviewModuleKey r12 = r8[r10];
        if (Intrinsics.areEqual(r12.getRaw(), r7) == true) goto L19;
        r10 = r10 + 1;
    L19:
        if (r12 != null) goto L21;
        MemoryDataReviewModuleKey r14 = r23;
    L22:
        String r13 = a(r5, "cardPayloadJson");
        if (r13 != null) goto L30;
        Object r15 = r5.opt("cardPayload");
        if (r15 == null) goto L27;
        r13 = r15.toString();
    L28:
        if (r13 != null) goto L30;
        r13 = "{}";
        goto L30
    L27:
        r13 = null;
    L30:
        String r17 = r13;
        String r16 = r5.optString("recordId");
        String r18 = a(r5, "title");
        String r19 = a(r5, "summary");
        MemoryReviewFeedbackState.a r20 = MemoryReviewFeedbackState.Companion;
        String r21 = a(r5, "feedbackState");
        r20.getClass();
        MemoryReviewFeedbackState r110 = MemoryReviewFeedbackState.a.a(r21);
        String r24 = a(r5, "traceJson");
        if (r24 != null) goto L36;
        Object r25 = r5.opt("trace");
        if (r25 == null) goto L35;
        r11 = r25.toString();
    L35:
        String r111 = r11;
    L37:
        r1.add(new q0(r16, r14, r18, r19, r17, r110, r111, r5.optLong("updateTimeMillis", 0)));
        goto L38
    L36:
        r111 = r24;
        goto L37
    L21:
        r14 = r12;
        goto L22
    L18:
        r12 = null;
    L38:
        r4 = r4 + 1;
        goto L7
    L39:
        return r1;
    L5:
        return CollectionsKt.emptyList();
    }
}
