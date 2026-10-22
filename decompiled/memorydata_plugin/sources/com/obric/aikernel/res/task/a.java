package com.obric.aikernel.res.task;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00052\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/obric/aikernel/res/task/NamedTaskScheduler;", "", "()V", "taskLock", "", "", "Lkotlinx/coroutines/sync/Mutex;", "executeWith", ExifInterface.GPS_DIRECTION_TRUE, LocationMonitorConst.TAG, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6099a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, kotlinx.coroutines.sync.a> f6100b = null;

    static {
        f6099a = new a();
        f6100b = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private a() {
    }

    public final <T> Object a(String r8, Function1<? super Continuation<? super T>, ? extends Object> r9, Continuation<? super T> r10) {
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, NamedTaskScheduler$executeWith$1.class) == false) goto L7;
        NamedTaskScheduler$executeWith$1 r0 = (NamedTaskScheduler$executeWith$1) ZeusTransformUtils.preCheckCast(r12, NamedTaskScheduler$executeWith$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        kotlinx.coroutines.sync.a r14 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
    L30:
        r14.b(r15);
        return r7;
    L15:
        Throwable th = th;
    L34:
        r14.b(r15);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r16 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r0.L$2, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        r11 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$1, Function1.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        kotlinx.coroutines.sync.a r17 = r16;
        r8 = r1;
    L36:
        r0.L$0 = r8;     // Catch: Throwable -> L32
        r0.L$1 = r17;     // Catch: Throwable -> L32
        r0.L$2 = null;     // Catch: Throwable -> L32
        r0.label = 2;     // Catch: Throwable -> L32
        Object r18 = r11.invoke(r0);     // Catch: Throwable -> L32
        if (r18 != r13) goto L29;
        return r13;
    L29:
        String r6 = r8;
        r14 = r17;
        r7 = r18;
        r15 = r6;
    L32:
        th = move-exception;
        String r19 = r8;
        r14 = r17;
        th = th;
        r15 = r19;
        goto L34
    L20:
        ResultKt.throwOnFailure(r7);
        Map<String, kotlinx.coroutines.sync.a> r20 = f6100b;
        kotlinx.coroutines.sync.a r3 = r20.get(r8);
        if (r3 != null) goto L23;
        r3 = kotlinx.coroutines.sync.c.a(false, 1, null);
        r20.put(r8, r3);
    L23:
        r17 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        r0.L$0 = r8;
        r0.L$1 = r11;
        r0.L$2 = r17;
        r0.label = 1;
        if (r17.a(r8, r0) != r13) goto L36;
        return r13;
    L7:
        r0 = new NamedTaskScheduler$executeWith$1(this, r12);
        goto L8
    }
}
