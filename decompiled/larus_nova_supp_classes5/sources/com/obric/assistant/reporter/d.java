package com.obric.assistant.reporter;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class d implements Function0 {
    public /* synthetic */ d() {
    }

    public final Object invoke() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        RomInfo r1 = b.b().b();     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(MapsKt.mapOf(new Pair[]{TuplesKt.to("o_rom_build_type", r1.g()), TuplesKt.to("o_rom_version", r1.b()), TuplesKt.to("o_rom_full_version", r1.getOSVersion()), TuplesKt.to("o_rom_release_date", String.valueOf(r1.c())), TuplesKt.to("o_rom_release_region", r1.f())}));     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L9;
        FLogger.a.w("ObricPerformanceCostReporter", "get ROM categories failed", r3);
    L9:
        Map r4 = MapsKt.emptyMap();
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = r4;
    L13:
        return (Map) r2;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
