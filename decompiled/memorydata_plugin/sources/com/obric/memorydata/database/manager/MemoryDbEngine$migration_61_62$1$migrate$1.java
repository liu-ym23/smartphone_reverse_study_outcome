package com.obric.memorydata.database.manager;

import android.database.Cursor;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.database.index.bc;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.manager.MemoryDbEngine$migration_61_62$1$migrate$1", f = "MemoryDbEngine.kt", i = {}, l = {1001}, m = "invokeSuspend", n = {}, s = {})
final class MemoryDbEngine$migration_61_62$1$migrate$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    MemoryDbEngine$migration_61_62$1$migrate$1(Continuation<? super MemoryDbEngine$migration_61_62$1$migrate$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryDbEngine$migration_61_62$1$migrate$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryDbEngine$migration_61_62$1$migrate$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryDbEngine$migration_61_62$1$migrate$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r36) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r36);
    L11:
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryOldDataForContentTimeIndexPending(), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        Integer r5 = Boxing.boxInt(r0.getColumnIndex(OaidModel.KEY_ID));     // Catch: Throwable -> L45
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L19;
        r5 = null;
    L19:
        if (r5 == null) goto L42;
        int r7 = r5.intValue();     // Catch: Throwable -> L45
        Integer r8 = Boxing.boxInt(r0.getColumnIndex("timestamp"));     // Catch: Throwable -> L45
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L23;
        boolean r9 = true;
    L24:
        if (r9 == true) goto L27;
        r8 = null;
    L27:
        if (r8 == null) goto L42;
        int r10 = r8.intValue();     // Catch: Throwable -> L45
        Integer r11 = Boxing.boxInt(r0.getColumnIndex("createTime"));     // Catch: Throwable -> L45
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue() >= 0) goto L32;
        r3 = false;
    L32:
        if (r3 == true) goto L35;
        r11 = null;
    L35:
        if (r11 == null) goto L42;
        int r12 = r11.intValue();     // Catch: Throwable -> L45
    L38:
        if (r0.moveToNext() == false) goto L42;
        long r13 = r0.getLong(r7);     // Catch: Throwable -> L45
        long r14 = r0.getLong(r10);     // Catch: Throwable -> L45
        long r16 = r0.getLong(r12);     // Catch: Throwable -> L45
        if (MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMemoryEntityContentTimeDao().queryByRawDbId(r13) != null) goto L38;
        ao.f9372a.a(c.f9561a.a(NetError.ERR_INVALID_REDIRECT), new cd(0, r13, NetError.ERR_INVALID_REDIRECT, r14, r16, 0, 0, "insert_content_time_task", "content_time", 0, 0, null, true, 0, 0, 28257, null), (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L45
        goto L38
    L23:
        r9 = false;
    L42:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L45
        CloseableKt.closeFinally(r4, null);
        return Unit.INSTANCE;
    L15:
        r6 = false;
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r36);
        Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (au.a(60000, r17) != r1) goto L11;
        return r1;
    }
}
