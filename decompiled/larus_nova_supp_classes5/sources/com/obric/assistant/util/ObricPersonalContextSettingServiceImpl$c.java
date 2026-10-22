package com.obric.assistant.util;

import android.os.Build;
import bda.b;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.Domain;
import com.obric.assistant.settings.ToggleName;
import com.obric.assistant.settings.i;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricPersonalContextSettingServiceImpl$c implements b {
    public final /* synthetic */ ObricPersonalContextSettingServiceImpl a;

    public final String getScene() {
        return "Personal_Context_Setting";
    }

    public ObricPersonalContextSettingServiceImpl$c(ObricPersonalContextSettingServiceImpl r1) {
        this.a = r1;
    }

    public final Map<String, String> getExt(Map<String, String> r17, b.a r18) {
        Intrinsics.checkNotNullParameter(r17, "originExt");
        if (this.a.q() == false) goto L5;
        String r0 = "1";
    L6:
        String r2 = r0;
        JSONArray r3 = new JSONArray();
        ObricPersonalContextSettingServiceImpl r4 = this.a;
        Object[] r6 = Domain.getEntries().toArray(new Domain[0]);
        int r7 = r6.length;
        int r8 = 0;
    L8:
        if (r8 >= r7) goto L37;
        Domain r11 = (Domain) r6[r8];
        r4.getClass();
        ToggleName r12 = i.b(r11);
        if (ObricPersonalContextSettingServiceImpl.b.a[r12.ordinal()] == 1) goto L12;
        boolean r10 = r4.o(r12);
    L34:
        if (r10 == false) goto L36;
        r3.put(r11.getName());
    L36:
        r8 = r8 + 1;
        goto L8
    L12:
        if (Build.VERSION.SDK_INT >= 24) goto L39;
        boolean r1 = r4.o(ToggleName.AI_DIARY);
    L30:
        if (r1 == false) goto L32;
        r10 = r4.o(r12);
        goto L34
    L32:
        r10 = true;
        goto L34
    L39:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L17
        Object r9 = Result.constructor-impl((Boolean) BuildersKt.runBlocking$default(null, new ObricPersonalContextSettingServiceImpl.queryScreenMemoryEnabledWithTimeout.result.1.1(r4, null), 1, null));     // Catch: Throwable -> L17
    L19:
        Throwable r14 = Result.exceptionOrNull-impl(r9);
        if (r14 == null) goto L23;
        FLogger.a.w("ObricPersonalContextSettingKevaUtils", "queryScreenMemoryEnabledWithTimeout failed: " + r14.getMessage(), r14);
    L23:
        if (Result.isFailure-impl(r9) == false) goto L25;
        Object r13 = null;
    L26:
        Boolean r15 = (Boolean) r13;
        if (r15 == null) goto L29;
        r1 = r15.booleanValue();
        goto L30
    L29:
        r1 = r4.o(ToggleName.AI_DIARY);
        goto L30
    L25:
        r13 = r9;
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L37:
        Map<String, String> r19 = MapsKt.mapOf(new Pair[]{TuplesKt.to("o_local_global_search", r2), TuplesKt.to("o_data_source_permission", r3.toString())});
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "getExt called, scene = Personal_Context_Setting, return map = " + r19);
        return r19;
    L5:
        r0 = "0";
        goto L6
    }
}
