package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 1, 1, 2, 2}, l = {882, 311, 314}, m = "pauseRecording", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
final class HardwareRecordingManager$pauseRecording$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$pauseRecording$1(d r1, Continuation<? super HardwareRecordingManager$pauseRecording$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        d r13 = this.this$0;
        r13.getClass();
        int r3 = this.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r3 - Integer.MIN_VALUE;
        HardwareRecordingManager$pauseRecording$1 r0 = this;
    L6:
        Object r4 = r0.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r0.label;
        if (r6 != 0) goto L9;
        ResultKt.throwOnFailure(r4);
        r0.L$0 = null;
        r0.label = 1;
        throw null;
    L9:
        if (r6 == 1) goto L29;
        if (r6 != 2) goto L12;
        e r14 = (e) r0.L$1;
        kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L27
    L39:
        if (((b) r4) != null) goto L42;
        d.k("pauseRecording", OfficeSDKPluginErrorCode.PLUGIN_UNSUPPORTED, "hardware recording device is empty: " + r14.b);     // Catch: Throwable -> L27
        throw null;     // Catch: Throwable -> L27
    L42:
        lvb.a.e(null, "[pauseRecording] session=" + r14);     // Catch: Throwable -> L27
        throw null;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Throwable th = th;
        kotlinx.coroutines.sync.a r15 = r1;
    L44:
        kotlinx.coroutines.sync.a r7 = r15;
    L47:
        r7.unlock(null);
        throw th;
    L12:
        if (r6 != 3) goto L23;
        e r16 = (e) r0.L$1;
        r15 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L20
        cvb.a r8 = (cvb.a) r4;     // Catch: Throwable -> L20
        if ((r8 instanceof cvb.a.C0133a) == false) goto L19;
        ((cvb.a.C0133a) r8).getClass();     // Catch: Throwable -> L20
        ((cvb.a.C0133a) r8).getClass();     // Catch: Throwable -> L20
        d.k("pauseRecording", 0, null);     // Catch: Throwable -> L20
        throw null;     // Catch: Throwable -> L20
    L19:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L20
    L20:
        th = th;
        goto L44
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L29:
        r7 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r4);
        e r9 = r13.a;     // Catch: Throwable -> L45
        if (r9 != null) goto L34;
        r5 = new a.b("no active hardware recording");     // Catch: Throwable -> L45
        r7.unlock(null);
    L36:
        return r5;
    L34:
        r0.L$0 = r7;     // Catch: Throwable -> L45
        r0.L$1 = r9;     // Catch: Throwable -> L45
        r0.label = 2;     // Catch: Throwable -> L45
        Object r17 = r13.n(r9, "pauseRecording", r0);     // Catch: Throwable -> L45
        if (r17 == r5) goto L36;
        r4 = r17;
        r14 = r9;
    L45:
        th = move-exception;
        th = th;
        goto L47
    L5:
        r0 = new HardwareRecordingManager$pauseRecording$1(r13, this);
        goto L6
    }
}
