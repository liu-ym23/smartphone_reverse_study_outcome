package com.larus.audio.call.arch;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import kotlin.Deprecated;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c {
    com.larus.audio.call.mgr.f a();

    <T extends e> T b(KClass<T> r1, a<?> r2);

    <T extends e> T c(KClass<T> r1, a<?> r2);

    com.larus.audio.call.tracer.b i();

    id9.d j();

    @Deprecated(message = "尽量将Dora与Audio的埋点区分开，不建议通过统一的接口约束")
    IRealtimeCallTracer k();

    LLMCallController<?> n();

    RealtimeCallParam params();

    CoroutineScope r();
}
