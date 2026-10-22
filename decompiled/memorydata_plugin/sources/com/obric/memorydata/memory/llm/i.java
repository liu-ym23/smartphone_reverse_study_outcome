package com.obric.memorydata.memory.llm;

import com.obric.capabilitykit.entity.app.EntityType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012(\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014J\u000e\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u0010j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/llm/RejectedMemoryCleanup;", "", "deleteMemory", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntity;", "", "notifyRemoved", "Lkotlin/Function2;", "", "Lcom/obric/memorydata/memory/llm/MemorySafetyRemovalEvents$MemoryKey;", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "writtenMemories", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "recordWritten", "memories", "", "removeRejected", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<MemoryLLMBuildHelperV2.a, Boolean> f10291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2<Set<f.a>, Continuation<? super Unit>, Object> f10292b;
    private final LinkedHashMap<f.a, MemoryLLMBuildHelperV2.a> c;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10293a = null;

        static {
            int[] r0 = new int[MemoryLLMBuildHelperV2.ResultEntityType.values().length];
            r0[MemoryLLMBuildHelperV2.ResultEntityType.EPISODIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MemoryLLMBuildHelperV2.ResultEntityType.SEMANTIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MemoryLLMBuildHelperV2.ResultEntityType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10293a = r0;
        }
    }

    public i(Function1<? super MemoryLLMBuildHelperV2.a, Boolean> r3, Function2<? super Set<f.a>, ? super Continuation<? super Unit>, ? extends Object> r4) {
        Function1<MemoryLLMBuildHelperV2.a, Boolean> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function2<Set<f.a>, Continuation<? super Unit>, Object> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "deleteMemory");
        Intrinsics.checkNotNullParameter(r6, "notifyRemoved");
        this.f10291a = r5;
        this.f10292b = r6;
        this.c = new LinkedHashMap();
    }

    public final Object a(Continuation<? super Integer> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, RejectedMemoryCleanup$removeRejected$1.class) == false) goto L7;
        RejectedMemoryCleanup$removeRejected$1 r0 = (RejectedMemoryCleanup$removeRejected$1) ZeusTransformUtils.preCheckCast(r12, RejectedMemoryCleanup$removeRejected$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Set<f.a> r10 = (Set) ZeusTransformUtils.preCheckCast(r0.L$1, Set.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r0.L$0, Map.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L37:
        return Boxing.boxInt(r3.size() - r10.size());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        monitor-enter(this);
        Map r14 = MapsKt.toMap((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
        monitor-exit(this);
        Function1<MemoryLLMBuildHelperV2.a, Boolean> r4 = this.f10291a;
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r6 = r14.entrySet().iterator();
    L20:
        if (r6.hasNext() == false) goto L24;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke((MemoryLLMBuildHelperV2.a) r7.getValue()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L20;
        r5.put(r7.getKey(), r7.getValue());
        goto L20
    L24:
        Set<f.a> r8 = ((Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin")).keySet();
        monitor-enter(this);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        LinkedHashMap<f.a, MemoryLLMBuildHelperV2.a> r15 = this.c;     // Catch: Throwable -> L38
        Iterator r16 = r9.iterator();     // Catch: Throwable -> L38
    L28:
        if (r16.hasNext() == false) goto L30;
        r15.remove((f.a) ZeusTransformUtils.preCheckCast(r16.next(), f.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
        goto L28
    L30:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(this);
        Function2<Set<f.a>, Continuation<? super Unit>, Object> r18 = this.f10292b;
        r0.L$0 = r14;
        r0.L$1 = r8;
        r0.label = 1;
        if (r18.invoke(r8, r0) != r1) goto L35;
        return r1;
    L35:
        r3 = r14;
        r10 = r8;
    L38:
        th = move-exception;
        throw th;
    L41:
        th = move-exception;
        throw th;
    L7:
        r0 = new RejectedMemoryCleanup$removeRejected$1(this, r12);
        goto L8
    }

    public final synchronized void a(List<MemoryLLMBuildHelperV2.a> r6) {
        monitor-enter(this);
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r7, "memories");     // Catch: Throwable -> L26
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L26
    L5:
        if (r8.hasNext() == false) goto L24;
        MemoryLLMBuildHelperV2.a r0 = (MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(r8.next(), MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0.a(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        if (r0.c() == MemoryLLMBuildHelperV2.ResultOperateType.DELETE_CONFIRM) goto L5;
        MemoryLLMBuildHelperV2.ResultEntityType r1 = r0.b();     // Catch: Throwable -> L26
        int r2 = a.f10293a[r1.ordinal()];     // Catch: Throwable -> L26
        if (r2 == 1) goto L21;
        if (r2 != 2) goto L16;
        int r3 = EntityType.MEMORY_INFO_COMMON;
    L22:
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(new f.a(r0.a(), r3), r0);     // Catch: Throwable -> L26
        goto L5
    L16:
        if (r2 == 3) goto L5;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L26
    L21:
        r3 = EntityType.MEMORY_COMMON_TEXT;
        goto L22
    L24:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    }
}
