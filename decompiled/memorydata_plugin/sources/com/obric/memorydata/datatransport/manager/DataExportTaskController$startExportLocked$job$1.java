package com.obric.memorydata.datatransport.manager;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.manager.DataExportTaskController$startExportLocked$job$1", f = "DataExportTaskController.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
final class DataExportTaskController$startExportLocked$job$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $snapshot;
    final /* synthetic */ String $taskId;
    final /* synthetic */ h $taskStore;
    int label;

    DataExportTaskController$startExportLocked$job$1(String r3, d r4, h r5, Continuation<? super DataExportTaskController$startExportLocked$job$1> r6) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$taskId = r3;
        this.$snapshot = r4;
        this.$taskStore = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DataExportTaskController$startExportLocked$job$1(this.$taskId, this.$snapshot, this.$taskStore, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DataExportTaskController$startExportLocked$job$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DataExportTaskController$startExportLocked$job$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r27) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 != 0) goto L191;
        ResultKt.throwOnFailure(r27);
        l r3 = c.e();     // Catch: Throwable -> L7 CancellationException -> L9
        if (AppContext.INSTANCE.isDebug() == false) goto L17;
        String r6 = "";
    L18:
        String r7 = this.$taskId;     // Catch: Throwable -> L7 CancellationException -> L9
        String r8 = this.$snapshot.b();     // Catch: Throwable -> L7 CancellationException -> L9
        Continuation<? super s> r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9
        Object r4 = r3.a(r6, r7, r8, r9);     // Catch: Throwable -> L7 CancellationException -> L9
        if (r4 != r0) goto L21;
        return r0;
    L21:
        s r1 = (s) ZeusTransformUtils.preCheckCast(r4, s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
        if (r1 == null) goto L86;
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), this.$snapshot.b()) == true) goto L50;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataExportTask", "discard export after account changed: taskId=" + this.$taskId, null, 4, null);     // Catch: Throwable -> L7 CancellationException -> L9
        r1.a().delete();     // Catch: Throwable -> L7 CancellationException -> L9
        Object r5 = c.f();     // Catch: Throwable -> L7 CancellationException -> L9
        String r10 = this.$taskId;     // Catch: Throwable -> L7 CancellationException -> L9
        d r11 = this.$snapshot;     // Catch: Throwable -> L7 CancellationException -> L9
        h r12 = this.$taskStore;     // Catch: Throwable -> L7 CancellationException -> L9
        monitor-enter(r5);     // Catch: Throwable -> L7 CancellationException -> L9
        c.a(c.f9761a, r10, r11, r12);     // Catch: Throwable -> L47
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L47
        monitor-exit(r5);     // Catch: Throwable -> L7 CancellationException -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L7 CancellationException -> L9
        n.f9785a.b();
        Object r15 = c.f();
        String r16 = this.$taskId;
        monitor-enter(r15);
        d r17 = c.h();     // Catch: Throwable -> L44
        if (r17 == null) goto L35;
        String r18 = r17.a();     // Catch: Throwable -> L44
    L37:
        if (Intrinsics.areEqual(r18, r16) == false) goto L39;
    L40:
        c r19 = c.f9761a;     // Catch: Throwable -> L44
        c.a(null);     // Catch: Throwable -> L44
    L41:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(r15);
        return r14;
    L39:
        if (c.h() != null) goto L41;
    L35:
        r18 = null;
    L44:
        th = move-exception;
        throw th;
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7 CancellationException -> L9
    L50:
        Object r21 = c.f();     // Catch: Throwable -> L7 CancellationException -> L9
        d r22 = this.$snapshot;     // Catch: Throwable -> L7 CancellationException -> L9
        String r23 = this.$taskId;     // Catch: Throwable -> L7 CancellationException -> L9
        h r24 = this.$taskStore;     // Catch: Throwable -> L7 CancellationException -> L9
        monitor-enter(r21);     // Catch: Throwable -> L7 CancellationException -> L9
        d r25 = c.h();     // Catch: Throwable -> L82
        if (r25 != null) goto L55;
    L61:
        d r110 = r22;
    L62:
        d r26 = d.a(r110, null, null, DataExportPhase.SUCCESS, c.a(c.f9761a, ZeusTransformUtils.mapRes(R.string.data_transport_data_export_done_saved, TypedValues.Custom.S_STRING, "data_transport_data_export_done_saved"), new Object[]{r1.a().getAbsolutePath()}), Boxing.boxInt(100), 0, 0, System.currentTimeMillis(), CollectionsKt.emptyList(), w.f9804a.a(r1), null, 1123, null);     // Catch: Throwable -> L82
        c r28 = c.f9761a;     // Catch: Throwable -> L82
        c.a(r26);     // Catch: Throwable -> L82
        c.a(c.f9761a, r26, r24);     // Catch: Throwable -> L82
        c.g().b(new f.e(r26, r1));     // Catch: Throwable -> L82
        monitor-exit(r21);     // Catch: Throwable -> L7 CancellationException -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataExportTask", "export success: taskId=" + r26.a() + ", size=" + r1.a().length(), false, 4, null);     // Catch: Throwable -> L7 CancellationException -> L9
        n.f9785a.b();
        Object r29 = c.f();
        String r30 = this.$taskId;
        monitor-enter(r29);
        d r31 = c.h();     // Catch: Throwable -> L79
        if (r31 == null) goto L70;
        String r32 = r31.a();     // Catch: Throwable -> L79
    L72:
        if (Intrinsics.areEqual(r32, r30) == false) goto L74;
    L75:
        c r33 = c.f9761a;     // Catch: Throwable -> L79
        c.a(null);     // Catch: Throwable -> L79
    L76:
        Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L79
    L77:
        monitor-exit(r29);
        return Unit.INSTANCE;
    L74:
        if (c.h() != null) goto L76;
    L70:
        r32 = null;
    L79:
        th = move-exception;
        throw th;
    L55:
        if (Intrinsics.areEqual(r25.a(), r23) == true) goto L58;
        r25 = null;
    L58:
        if (r25 == null) goto L61;
        r110 = r25;
    L82:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7 CancellationException -> L9
    L86:
        throw new IllegalStateException(c.a(c.f9761a, ZeusTransformUtils.mapRes(R.string.data_transport_data_export_operation_busy, TypedValues.Custom.S_STRING, "data_transport_data_export_operation_busy"), new Object[0]));     // Catch: Throwable -> L7 CancellationException -> L9
    L17:
        r6 = "MemoryData_UT";
        goto L18
    L191:
        if (r2 != 1) goto L12;
        ResultKt.throwOnFailure(r27);     // Catch: Throwable -> L7 CancellationException -> L9
        r4 = r27;
        goto L21
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L155:
        th = move-exception;
        n.f9785a.b();
        Object r35 = c.f();
        String r36 = this.$taskId;
        monitor-enter(r35);
        d r37 = c.h();     // Catch: Throwable -> L170
        if (r37 == null) goto L161;
        String r38 = r37.a();     // Catch: Throwable -> L170
    L163:
        if (Intrinsics.areEqual(r38, r36) == false) goto L165;
    L166:
        c r39 = c.f9761a;     // Catch: Throwable -> L170
        c.a(null);     // Catch: Throwable -> L170
    L167:
        Unit r40 = Unit.INSTANCE;     // Catch: Throwable -> L170
        throw th;
    L165:
        if (c.h() != null) goto L167;
    L161:
        r38 = null;
    L170:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), this.$snapshot.b()) == true) goto L154;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataExportTask", "cancel export after account changed: taskId=" + this.$taskId, null, 4, null);     // Catch: Throwable -> L155
        Object r41 = c.f();     // Catch: Throwable -> L155
        String r42 = this.$taskId;     // Catch: Throwable -> L155
        d r43 = this.$snapshot;     // Catch: Throwable -> L155
        h r44 = this.$taskStore;     // Catch: Throwable -> L155
        monitor-enter(r41);     // Catch: Throwable -> L155
        c.a(c.f9761a, r42, r43, r44);     // Catch: Throwable -> L151
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L151
    L133:
        n.f9785a.b();
        r29 = c.f();
        String r46 = this.$taskId;
        monitor-enter(r29);
        d r47 = c.h();     // Catch: Throwable -> L148
        if (r47 == null) goto L138;
        String r48 = r47.a();     // Catch: Throwable -> L148
    L140:
        if (Intrinsics.areEqual(r48, r46) == false) goto L142;
    L143:
        c r49 = c.f9761a;     // Catch: Throwable -> L148
        c.a(null);     // Catch: Throwable -> L148
    L144:
        Unit r50 = Unit.INSTANCE;     // Catch: Throwable -> L148
        goto L77
    L142:
        if (c.h() != null) goto L144;
    L138:
        r48 = null;
    L148:
        th = move-exception;
        throw th;
    L151:
        th = move-exception;
        throw th;     // Catch: Throwable -> L155
    L154:
        throw e;     // Catch: Throwable -> L155
    L7:
        th = move-exception;
        RunLog.INSTANCE.error("DataExportTask", "export failed: taskId=" + this.$taskId, th);     // Catch: Throwable -> L155
        Object r51 = c.f();     // Catch: Throwable -> L155
        d r52 = this.$snapshot;     // Catch: Throwable -> L155
        String r53 = this.$taskId;     // Catch: Throwable -> L155
        h r54 = this.$taskStore;     // Catch: Throwable -> L155
        monitor-enter(r51);     // Catch: Throwable -> L155
    L124:
        th = move-exception;
        throw th;     // Catch: Throwable -> L155
    L90:
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r52.b()) == true) goto L92;
        c.a(c.f9761a, r53, r52, r54);     // Catch: Throwable -> L124
    L106:
        Unit r55 = Unit.INSTANCE;     // Catch: Throwable -> L124
    L108:
        n.f9785a.b();
        r29 = c.f();
        String r56 = this.$taskId;
        monitor-enter(r29);
        d r57 = c.h();     // Catch: Throwable -> L121
        if (r57 == null) goto L113;
        String r58 = r57.a();     // Catch: Throwable -> L121
    L115:
        if (Intrinsics.areEqual(r58, r56) == false) goto L117;
    L118:
        c r59 = c.f9761a;     // Catch: Throwable -> L121
        c.a(null);     // Catch: Throwable -> L121
    L119:
        Unit r60 = Unit.INSTANCE;     // Catch: Throwable -> L121
        goto L77
    L117:
        if (c.h() != null) goto L119;
    L113:
        r58 = null;
    L121:
        th = move-exception;
        throw th;
    L92:
        d r61 = c.h();     // Catch: Throwable -> L124
        if (r61 != null) goto L95;
    L101:
        d r111 = r52;
    L102:
        DataExportPhase r112 = DataExportPhase.FAILED;     // Catch: Throwable -> L124
        c r62 = c.f9761a;     // Catch: Throwable -> L124
        int r63 = ZeusTransformUtils.mapRes(R.string.data_transport_data_export_failed, TypedValues.Custom.S_STRING, "data_transport_data_export_failed");     // Catch: Throwable -> L124
        Object[] r64 = new Object[1];     // Catch: Throwable -> L124
        String r65 = th.getMessage();     // Catch: Throwable -> L124
        if (r65 != null) goto L105;
        r65 = th.getClass().getSimpleName();     // Catch: Throwable -> L124
    L105:
        r64[0] = r65;     // Catch: Throwable -> L124
        d r66 = d.a(r111, null, null, r112, c.a(r62, r63, r64), null, 0, 0, System.currentTimeMillis(), null, null, null, 1907, null);     // Catch: Throwable -> L124
        c r67 = c.f9761a;     // Catch: Throwable -> L124
        c.a(r66);     // Catch: Throwable -> L124
        c r68 = c.f9761a;     // Catch: Throwable -> L124
        c.a(r54);     // Catch: Throwable -> L124
        c.a(c.f9761a, r66, r54);     // Catch: Throwable -> L124
        c.g().b(new f.a(r66, r66.d()));     // Catch: Throwable -> L124
        goto L106
    L95:
        if (Intrinsics.areEqual(r61.a(), r53) == true) goto L98;
        r61 = null;
    L98:
        if (r61 == null) goto L101;
        r111 = r61;
        goto L102
    }
}
