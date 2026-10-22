package com.bytedance.android.live.rts.client_utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"traversalByJsonPath", "", "jsonObject", "path", "", "", "index", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class IESLiveRTSSettingUtils$getClientSetting$1 extends Lambda implements Function3<Object, List<? extends String>, Integer, Object> {
    public static final IESLiveRTSSettingUtils$getClientSetting$1 INSTANCE = null;

    static {
        INSTANCE = new IESLiveRTSSettingUtils$getClientSetting$1();
    }

    public IESLiveRTSSettingUtils$getClientSetting$1() {
        super(3);
    }

    public final Object invoke(Object r5, List<String> r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "path");
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r7 != r6.size()) goto L9;
        return r5;
    L9:
        if ((r5 instanceof JSONObject) == false) goto L15;
        String r1 = (String) ListProtector.get(r6, r7);
        JSONObject r8 = (JSONObject) r5;
        if (r8.has(r1) == false) goto L51;
        return invoke(r8.get(r1), r6, r7 + 1);
    L51:
        return null;
    L15:
        if ((r5 instanceof JSONArray) == false) goto L24;
        String r2 = (String) ListProtector.get(r6, r7);
        JSONArray r9 = (JSONArray) r5;
        int r3 = r9.length();
        Integer r4 = StringsKt.toIntOrNull(r2);
        if (r4 == null) goto L51;
        int r10 = r4.intValue();
        if (r10 < 0) goto L51;
        if (r3 <= r10) goto L51;
        return invoke(r9.get(r4.intValue()), r6, r7 + 1);
    L24:
        if ((r5 instanceof String) == false) goto L51;
        int r12 = IESLiveRTSSettingUtils.a;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L28
        Object r14 = Result.constructor-impl((JsonObject) GsonHelper.get().fromJson((String) r5, JsonObject.class));     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r14) == false) goto L33;
        r14 = null;
    L33:
        if (r14 != null) goto L53;
        int r15 = IESLiveRTSSettingUtils.a;
        Object r16 = Result.constructor-impl((JsonArray) GsonHelper.get().fromJson((String) r5, JsonArray.class));     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r16) == false) goto L43;
        r16 = null;
    L43:
        if (r16 == null) goto L51;
        return invoke(new JSONArray((String) r5), r6, r7);
    L38:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L53:
        return invoke(new JSONObject((String) r5), r6, r7);
    L28:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(r1, (List) r2, ((Number) r3).intValue());
    }
}
