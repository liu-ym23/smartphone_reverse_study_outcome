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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {882, 329, 332}, m = "resumeRecording", n = {"$this$withLock_u24default$iv", "timestampSeconds", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "timestampSeconds", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION}, s = {"L$0", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1"})
final class HardwareRecordingManager$resumeRecording$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$resumeRecording$1(d r1, Continuation<? super HardwareRecordingManager$resumeRecording$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r14) {
        this.result = r14;
        this.label |= Integer.MIN_VALUE;
        d r15 = this.this$0;
        r15.getClass();
        int r3 = this.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r3 - Integer.MIN_VALUE;
        HardwareRecordingManager$resumeRecording$1 r0 = this;
    L6:
        Object r4 = r0.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r0.label;
        if (r6 != 0) goto L9;
        ResultKt.throwOnFailure(r4);
        r0.L$0 = null;
        r0.J$0 = 0;
        r0.label = 1;
        throw null;
    L9:
        if (r6 == 1) goto L29;
        if (r6 != 2) goto L12;
        long r7 = r0.J$0;
        e r16 = (e) r0.L$1;
        kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L27
    L39:
        if (((b) r4) != null) goto L42;
        d.k("resumeRecording", OfficeSDKPluginErrorCode.PLUGIN_UNSUPPORTED, "hardware recording device is empty: " + r16.b);     // Catch: Throwable -> L27
        throw null;     // Catch: Throwable -> L27
    L42:
        lvb.a.e(null, "[resumeRecording] session=" + r16 + ", timestampSeconds=" + r7);     // Catch: Throwable -> L27
        throw null;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Throwable th = th;
        kotlinx.coroutines.sync.a r17 = r1;
    L44:
        kotlinx.coroutines.sync.a r8 = r17;
    L47:
        r8.unlock(null);
        throw th;
    L12:
        if (r6 != 3) goto L23;
        e r18 = (e) r0.L$1;
        r17 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L20
        cvb.a r9 = (cvb.a) r4;     // Catch: Throwable -> L20
        if ((r9 instanceof cvb.a.C0133a) == false) goto L19;
        ((cvb.a.C0133a) r9).getClass();     // Catch: Throwable -> L20
        ((cvb.a.C0133a) r9).getClass();     // Catch: Throwable -> L20
        d.k("resumeRecording", 0, null);     // Catch: Throwable -> L20
        throw null;     // Catch: Throwable -> L20
    L19:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L20
    L20:
        th = th;
        goto L44
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L29:
        long r10 = r0.J$0;
        r8 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r4);
        e r11 = r15.a;     // Catch: Throwable -> L45
        if (r11 != null) goto L34;
        r5 = new a.b("no active hardware recording");     // Catch: Throwable -> L45
        r8.unlock(null);
    L36:
        return r5;
    L34:
        r0.L$0 = r8;     // Catch: Throwable -> L45
        r0.L$1 = r11;     // Catch: Throwable -> L45
        r0.J$0 = r10;     // Catch: Throwable -> L45
        r0.label = 2;     // Catch: Throwable -> L45
        Object r19 = r15.n(r11, "resumeRecording", r0);     // Catch: Throwable -> L45
        if (r19 == r5) goto L36;
        r7 = r10;
        r4 = r19;
        r16 = r11;
    L45:
        th = move-exception;
        th = th;
        goto L47
    L5:
        r0 = new HardwareRecordingManager$resumeRecording$1(r15, this);
        goto L6
    }
}
