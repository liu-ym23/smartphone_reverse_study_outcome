package com.obric.flow.cardlistpage.apm;

import android.os.Debug;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.utils.k;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.apm.ResourceMonitor$reportFullMemory$1", f = "ResourceMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResourceMonitor$reportFullMemory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $scene;
    int label;

    public ResourceMonitor$reportFullMemory$1(String r5, Continuation<? super ResourceMonitor$reportFullMemory$1> r10) {
        this.$scene = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new ResourceMonitor$reportFullMemory$1(this.$scene, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r23) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r23);
        Runtime r5 = Runtime.getRuntime();
        long r10 = r5.totalMemory();
        long r11 = r10 - r5.freeMemory();
        Debug.MemoryInfo r12 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r12);
        long r13 = ((long) r12.getTotalPss()) * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        long r14 = ((long) r12.nativePss) * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        long r15 = ((long) r12.dalvikPss) * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        String r16 = r12.getMemoryStat("summary.graphics");
        if (r16 == null) goto L9;
        Long r17 = StringsKt.toLongOrNull(r16);
        if (r17 == null) goto L9;
        long r18 = r17.longValue() * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    L10:
        String r19 = this.$scene;
        long r20 = r18 / 1048576;
        long r110 = r18;
        long r111 = r11 / 1048576;
        StringBuilder r21 = new StringBuilder("[");
        r21.append(r19);
        r21.append("] Memory Report:\n  - Total PSS: ");
        r21.append(r13 / 1048576);
        kotlin.collections.a.o(r21, "MB (进程实际占用物理内存)\n  - Native PSS: ", r14 / 1048576, "MB (C/C++及底层图片占用)\n  - Graphics: ");
        r21.append(r20);
        kotlin.collections.a.o(r21, "MB (GL纹理/渲染占用)\n  - Dalvik PSS: ", r15 / 1048576, "MB (Java堆PSS)\n  - Java Heap (Runtime): ");
        r21.append(r111);
        r21.append("MB / ");
        r21.append(r10 / 1048576);
        r21.append("MB");
        String r22 = r21.toString();
        Intrinsics.checkNotNullParameter("APM_ResourceMonitor", "tag");
        Intrinsics.checkNotNullParameter(r22, "msg");
        org.koin.core.a r24 = su.a.f22013b;
        if (r24 == null) goto L15;
        ((ju.b) r24.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("APM_ResourceMonitor", r22);
        JSONObject r25 = new JSONObject();
        r25.put("scene", this.$scene);
        r25.put("total_pss_kb", r12.getTotalPss());
        r25.put("native_pss_kb", r12.nativePss);
        r25.put("dalvik_pss_kb", r12.dalvikPss);
        r25.put("graphics_pss_kb", r110 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
        r25.put("java_heap_used_kb", r11 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
        r25.put("java_heap_total_kb", r10 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
        r25.put("metric_type", LynxMonitorService.KEY_MEMORY);
        k.r().a("apm_stat", r25);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("KoinApplication has not been started");
    L9:
        r18 = 0;
        goto L10
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((ResourceMonitor$reportFullMemory$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
