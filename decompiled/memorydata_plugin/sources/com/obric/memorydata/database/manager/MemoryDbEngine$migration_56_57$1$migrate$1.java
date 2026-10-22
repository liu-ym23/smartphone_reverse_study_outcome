package com.obric.memorydata.database.manager;

import android.database.Cursor;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.database.index.bc;
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
@DebugMetadata(c = "com.obric.memorydata.database.manager.MemoryDbEngine$migration_56_57$1$migrate$1", f = "MemoryDbEngine.kt", i = {}, l = {872}, m = "invokeSuspend", n = {}, s = {})
final class MemoryDbEngine$migration_56_57$1$migrate$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    MemoryDbEngine$migration_56_57$1$migrate$1(Continuation<? super MemoryDbEngine$migration_56_57$1$migrate$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryDbEngine$migration_56_57$1$migrate$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryDbEngine$migration_56_57$1$migrate$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryDbEngine$migration_56_57$1$migrate$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r42) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L8;
        if (r3 != 1) goto L7;
        ResultKt.throwOnFailure(r42);
    L11:
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMessageRawDbDao().queryOldDataForContentTimeIndexPending(), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L160
        Integer r5 = Boxing.boxInt(r0.getColumnIndex(OaidModel.KEY_ID));     // Catch: Throwable -> L160
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L43;
        int r7 = r5.intValue();     // Catch: Throwable -> L160
        Integer r11 = Boxing.boxInt(r0.getColumnIndex("timestamp"));     // Catch: Throwable -> L160
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L24;
        boolean r12 = true;
    L25:
        if (r12 == true) goto L28;
        r11 = null;
    L28:
        if (r11 == null) goto L43;
        int r13 = r11.intValue();     // Catch: Throwable -> L160
        Integer r14 = Boxing.boxInt(r0.getColumnIndex("createTime"));     // Catch: Throwable -> L160
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L32;
        boolean r15 = true;
    L33:
        if (r15 == true) goto L36;
        r14 = null;
    L36:
        if (r14 == null) goto L43;
        int r16 = r14.intValue();     // Catch: Throwable -> L160
    L39:
        if (r0.moveToNext() == false) goto L43;
        long r17 = r0.getLong(r7);     // Catch: Throwable -> L160
        long r20 = r0.getLong(r13);     // Catch: Throwable -> L160
        long r22 = r0.getLong(r16);     // Catch: Throwable -> L160
        if (MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMessageEntityContentTimeDao().queryByRawDbId(r17) != null) goto L39;
        ao.f9372a.a("PUBLIC", new cd(0, r17, 101, r20, r22, 0, 0, "insert_content_time_task", "content_time", 0, 0, null, true, 0, 0, 28257, null), (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L160
        goto L39
    L32:
        r15 = false;
        goto L33
    L24:
        r12 = false;
    L43:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L160
        CloseableKt.closeFinally(r4, null);
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao().queryOldDataForContentTimeIndexPending(), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r9 = (Cursor) ZeusTransformUtils.preCheckCast(r8, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L154
        Integer r10 = Boxing.boxInt(r9.getColumnIndex(OaidModel.KEY_ID));     // Catch: Throwable -> L154
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L48;
        boolean r18 = true;
    L49:
        if (r18 == true) goto L52;
        r10 = null;
    L52:
        if (r10 == null) goto L75;
        int r19 = r10.intValue();     // Catch: Throwable -> L154
        Integer r21 = Boxing.boxInt(r9.getColumnIndex("timestamp"));     // Catch: Throwable -> L154
        if (((Number) ZeusTransformUtils.preCheckCast(r21, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L56;
        boolean r23 = true;
    L57:
        if (r23 == true) goto L60;
        r21 = null;
    L60:
        if (r21 == null) goto L75;
        int r24 = r21.intValue();     // Catch: Throwable -> L154
        Integer r25 = Boxing.boxInt(r9.getColumnIndex("createTime"));     // Catch: Throwable -> L154
        if (((Number) ZeusTransformUtils.preCheckCast(r25, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L64;
        boolean r26 = true;
    L65:
        if (r26 == true) goto L68;
        r25 = null;
    L68:
        if (r25 == null) goto L75;
        int r27 = r25.intValue();     // Catch: Throwable -> L154
    L71:
        if (r9.moveToNext() == false) goto L75;
        long r110 = r9.getLong(r19);     // Catch: Throwable -> L154
        long r111 = r9.getLong(r24);     // Catch: Throwable -> L154
        long r112 = r9.getLong(r27);     // Catch: Throwable -> L154
        if (MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryEntityContentTimeDao().queryByRawDbId(r110) != null) goto L71;
        ao.f9372a.a("PUBLIC", new cd(0, r110, 202, r111, r112, 0, 0, "insert_content_time_task", "content_time", 0, 0, null, true, 0, 0, 28257, null), (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L154
        r9 = r9;
        goto L71
    L64:
        r26 = false;
        goto L65
    L56:
        r23 = false;
    L75:
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L154
        CloseableKt.closeFinally(r8, null);
        Closeable r29 = (Closeable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRawDbDao().queryOldDataForContentTimeIndexPending(), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r30 = (Cursor) ZeusTransformUtils.preCheckCast(r29, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L148
        Integer r31 = Boxing.boxInt(r30.getColumnIndex(OaidModel.KEY_ID));     // Catch: Throwable -> L148
        if (((Number) ZeusTransformUtils.preCheckCast(r31, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L80;
        boolean r32 = true;
    L81:
        if (r32 == true) goto L84;
        r31 = null;
    L84:
        if (r31 == null) goto L107;
        int r33 = r31.intValue();     // Catch: Throwable -> L148
        Integer r34 = Boxing.boxInt(r30.getColumnIndex("timestamp"));     // Catch: Throwable -> L148
        if (((Number) ZeusTransformUtils.preCheckCast(r34, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L88;
        boolean r35 = true;
    L89:
        if (r35 == true) goto L92;
        r34 = null;
    L92:
        if (r34 == null) goto L107;
        int r36 = r34.intValue();     // Catch: Throwable -> L148
        Integer r37 = Boxing.boxInt(r30.getColumnIndex("createTime"));     // Catch: Throwable -> L148
        if (((Number) ZeusTransformUtils.preCheckCast(r37, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L96;
        boolean r38 = true;
    L97:
        if (r38 == true) goto L100;
        r37 = null;
    L100:
        if (r37 == null) goto L107;
        int r39 = r37.intValue();     // Catch: Throwable -> L148
    L103:
        if (r30.moveToNext() == false) goto L107;
        long r113 = r30.getLong(r33);     // Catch: Throwable -> L148
        long r114 = r30.getLong(r36);     // Catch: Throwable -> L148
        long r115 = r30.getLong(r39);     // Catch: Throwable -> L148
        if (MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteEntityContentTimeDao().queryByRawDbId(r113) != null) goto L103;
        ao.f9372a.a("PUBLIC", new cd(0, r113, 601, r114, r115, 0, 0, "insert_content_time_task", "content_time", 0, 0, null, true, 0, 0, 28257, null), (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L148
        r30 = r30;
        goto L103
    L96:
        r38 = false;
        goto L97
    L88:
        r35 = false;
    L107:
        Unit r40 = Unit.INSTANCE;     // Catch: Throwable -> L148
        CloseableKt.closeFinally(r29, null);
        Closeable r41 = (Closeable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRecordingRawDbDao().queryOldDataForContentTimeIndexPending(), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r43 = (Cursor) ZeusTransformUtils.preCheckCast(r41, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L142
        Integer r44 = Boxing.boxInt(r43.getColumnIndex(OaidModel.KEY_ID));     // Catch: Throwable -> L142
        if (((Number) ZeusTransformUtils.preCheckCast(r44, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L112;
        boolean r45 = true;
    L113:
        if (r45 == true) goto L116;
        r44 = null;
    L116:
        if (r44 == null) goto L139;
        int r46 = r44.intValue();     // Catch: Throwable -> L142
        Integer r47 = Boxing.boxInt(r43.getColumnIndex("timestamp"));     // Catch: Throwable -> L142
        if (((Number) ZeusTransformUtils.preCheckCast(r47, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L120;
        boolean r48 = true;
    L121:
        if (r48 == true) goto L124;
        r47 = null;
    L124:
        if (r47 == null) goto L139;
        int r49 = r47.intValue();     // Catch: Throwable -> L142
        Integer r50 = Boxing.boxInt(r43.getColumnIndex("createTime"));     // Catch: Throwable -> L142
        if (((Number) ZeusTransformUtils.preCheckCast(r50, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L128;
        boolean r310 = true;
    L129:
        if (r310 == true) goto L132;
        r50 = null;
    L132:
        if (r50 == null) goto L139;
        int r51 = r50.intValue();     // Catch: Throwable -> L142
    L135:
        if (r43.moveToNext() == false) goto L139;
        long r116 = r43.getLong(r46);     // Catch: Throwable -> L142
        long r117 = r43.getLong(r49);     // Catch: Throwable -> L142
        long r118 = r43.getLong(r51);     // Catch: Throwable -> L142
        if (MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRecordingEntityContentTimeDao().queryByRawDbId(r116) != null) goto L135;
        ao.f9372a.a("PUBLIC", new cd(0, r116, 501, r117, r118, 0, 0, "insert_content_time_task", "content_time", 0, 0, null, true, 0, 0, 28257, null), (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L142
        goto L135
    L128:
        r310 = false;
        goto L129
    L120:
        r48 = false;
    L139:
        Unit r52 = Unit.INSTANCE;     // Catch: Throwable -> L142
        CloseableKt.closeFinally(r41, null);
        return Unit.INSTANCE;
    L112:
        r45 = false;
    L142:
        th = move-exception;
        throw th;     // Catch: Throwable -> L145
    L145:
        th = move-exception;
        CloseableKt.closeFinally(r41, th);
        throw th;
    L80:
        r32 = false;
    L148:
        th = move-exception;
        throw th;     // Catch: Throwable -> L151
    L151:
        th = move-exception;
        CloseableKt.closeFinally(r29, th);
        throw th;
    L48:
        r18 = false;
    L154:
        th = move-exception;
        throw th;     // Catch: Throwable -> L157
    L157:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    L15:
        r6 = false;
    L160:
        th = move-exception;
        throw th;     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r42);
        Continuation r53 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (au.a(60000, r53) != r2) goto L11;
        return r2;
    }
}
