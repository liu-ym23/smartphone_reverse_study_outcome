package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$putOfflineRecordingIndex$1", f = "MmRecordingStatesSyncService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingStatesSyncService$putOfflineRecordingIndex$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $hardwareDeviceId;
    final /* synthetic */ String $sessionKey;
    final /* synthetic */ long $startTimeMs;
    int label;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public MmRecordingStatesSyncService$putOfflineRecordingIndex$1(MmRecordingStatesSyncService r1, String r2, long r3, String r5, Continuation<? super MmRecordingStatesSyncService$putOfflineRecordingIndex$1> r6) {
        this.this$0 = r1;
        this.$sessionKey = r2;
        this.$startTimeMs = r3;
        this.$hardwareDeviceId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MmRecordingStatesSyncService$putOfflineRecordingIndex$1(this.this$0, this.$sessionKey, this.$startTimeMs, this.$hardwareDeviceId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r9);
        MmRecordingStatesSyncService r10 = this.this$0;
        MmRecordingStatesSyncService.Companion r0 = MmRecordingStatesSyncService.q;
        e r11 = r10.l();
        String r1 = this.$sessionKey;
        long r2 = this.$startTimeMs;
        String r3 = this.$hardwareDeviceId;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r1, "sessionKey");
        Intrinsics.checkNotNullParameter(r3, "hardwareDeviceId");
        if (StringsKt.isBlank(r1) == true) goto L20;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L17
        if ((!StringsKt.isBlank(r3)) == true) goto L10;
    L15:
        Map<String, Long> r4 = r11.x();     // Catch: Throwable -> L17
        r4.put(r1, Long.valueOf(r2));     // Catch: Throwable -> L17
        r11.y(r4);     // Catch: Throwable -> L17
        lvb.a.e(r11.b, "[offlineIndex] put, sessionKey:" + r1 + ", startTimeMs:" + r2);     // Catch: Throwable -> L17
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        goto L20
    L10:
        if (StringsKt.isBlank(r1) == true) goto L15;
        if (StringsKt.isBlank(r3) == true) goto L15;
        r11.a.H().putString("minutes_recording_v2_offline_hardware_device_id_" + r1, r3);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
