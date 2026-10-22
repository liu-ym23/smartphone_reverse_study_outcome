package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.google.gson.Gson;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmRtcInitInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.e0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService$rtcPreload$1", f = "MmRecordingAudioService.kt", i = {0}, l = {146}, m = "invokeSuspend", n = {"cachedConfig"}, s = {"L$0"})
public final class MmRecordingAudioService$rtcPreload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingAudioService this$0;

    public MmRecordingAudioService$rtcPreload$1(MmRecordingAudioService r1, Continuation<? super MmRecordingAudioService$rtcPreload$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingAudioService$rtcPreload$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        MmRtcInitInfo r2 = (MmRtcInitInfo) this.L$0;
        ResultKt.throwOnFailure(r7);
    L43:
        if (((Boolean) r7).booleanValue() == false) goto L45;
        this.this$0.y = r2;
        this.this$0.z = true;
        lvb.a.e(this.this$0.e, "rtcPreload: preload success");
    L52:
        return Unit.INSTANCE;
    L45:
        lvb.a.b(this.this$0.e, "rtcPreload: preload failed");
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.f r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.f) this.this$0.C.getValue();
        r8.getClass();
        r8.b = null;     // Catch: Exception -> L48
        r8.c = true;     // Catch: Exception -> L48
        r8.a.remove("key_rtc_preload_config");     // Catch: Exception -> L48
        lvb.a.e("MmRtcPreloadCache", "clearRtcConfig success");     // Catch: Exception -> L48
    L48:
        e = move-exception;
        lvb.a.b("MmRtcPreloadCache", "clearRtcConfig failed: " + e);
        goto L52
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.f r9 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.f) this.this$0.C.getValue();
        if (r9.c == false) goto L56;
        lvb.a.e("MmRtcPreloadCache", "loadRtcConfig: hit memory cache");
        MmRtcInitInfo r3 = r9.b;
    L37:
        if (r3 == null) goto L50;
        lvb.a.e(this.this$0.e, "rtcPreload: found cached config, start preloading");
        MmRecordingAudioService r10 = this.this$0;
        this.L$0 = r3;
        this.label = 1;
        r7 = r10.g(r3, "preload", this);
        if (r7 != r0) goto L41;
        return r0;
    L41:
        r2 = r3;
        goto L43
    L50:
        lvb.a.e(this.this$0.e, "rtcPreload: no cached config found");
        goto L52
    L56:
        monitor-enter(r9);     // Catch: Exception -> L34
    L31:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L13:
        if (r9.c == false) goto L17;
        lvb.a.e("MmRtcPreloadCache", "loadRtcConfig: hit memory cache after lock");     // Catch: Throwable -> L31
        r3 = r9.b;     // Catch: Throwable -> L31
        monitor-exit(r9);     // Catch: Exception -> L34
        goto L37
    L17:
        String r4 = r9.a.getString("key_rtc_preload_config", "");     // Catch: Throwable -> L31
        if (r4 != null) goto L20;
    L23:
        boolean r5 = true;
    L24:
        if (r5 == false) goto L28;
        r9.b = null;     // Catch: Throwable -> L31
        r9.c = true;     // Catch: Throwable -> L31
        lvb.a.e("MmRtcPreloadCache", "loadRtcConfig: cache not exists");     // Catch: Throwable -> L31
        monitor-exit(r9);     // Catch: Exception -> L34
    L36:
        r3 = null;
        goto L37
    L28:
        Gson r6 = e0.a;     // Catch: Throwable -> L31
        r3 = (MmRtcInitInfo) e0.a(r4, MmRtcInitInfo.class);     // Catch: Throwable -> L31
        r9.b = r3;     // Catch: Throwable -> L31
        r9.c = true;     // Catch: Throwable -> L31
        lvb.a.e("MmRtcPreloadCache", "loadRtcConfig success from kv cache");     // Catch: Throwable -> L31
        monitor-exit(r9);     // Catch: Exception -> L34
        goto L37
    L20:
        if (r4.length() == 0) goto L23;
        r5 = false;
    L34:
        e = move-exception;
        lvb.a.b("MmRtcPreloadCache", "loadRtcConfig failed: " + e);
        goto L36
    }
}
