package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.google.gson.Gson;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmRtcInitInfo;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.pb.videochat.Bandwidth;
import com.ss.android.lark.pb.videochat.GetAdminSettingsResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.e0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService$initRtc$2", f = "MmRecordingAudioService.kt", i = {}, l = {164, 201}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingAudioService$initRtc$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ MinutesRecordingStartResponse $response;
    int label;
    final /* synthetic */ MmRecordingAudioService this$0;

    public MmRecordingAudioService$initRtc$2(MmRecordingAudioService r1, MinutesRecordingStartResponse r2, Continuation<? super MmRecordingAudioService$initRtc$2> r3) {
        this.this$0 = r1;
        this.$response = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingAudioService$initRtc$2(this.this$0, this.$response, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Boolean>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L71:
        boolean r13 = ((Boolean) r12).booleanValue();
        Result.Companion r2 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(Boxing.boxBoolean(r13)));
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L15:
        Gson r14 = e0.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.b r15 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.b) e0.a(this.$response.rtc_info, com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.b.class);
        if (r15 != null) goto L19;
        r15 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.b(0);
    L19:
        if (this.this$0.b.y().isFeishuBrand() == true) goto L30;
        GetAdminSettingsResponse r4 = this.this$0.b.E().e;
        if (r4 == null) goto L27;
        List<String> r5 = r4.mspeed_up_nodes;
        if (r5 == null) goto L27;
        if (r5.contains("china") != true) goto L27;
        boolean r6 = true;
    L28:
        if (r6 == false) goto L30;
        boolean r9 = true;
    L31:
        boolean r10 = !this.this$0.b.y().isChinaMainlandGeo();
        int r7 = (int) this.$response.vendor_type.longValue();
        MinutesRecordingStartResponse r8 = this.$response;
        String r11 = r8.rtc_app_id;
        String r16 = r8.business_id;
        if (r16 != null) goto L34;
        r16 = "";
    L34:
        MmRtcInitInfo r17 = new MmRtcInitInfo(r7, r11, r16, r9, r10);
        MmRecordingAudioService r18 = this.this$0;
        GetAdminSettingsResponse r19 = r18.b.E().e;
        if (r19 == null) goto L37;
        Bandwidth r20 = r19.mbandwidth;
    L38:
        r18.t = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a(r15, r17, r20);
        lvb.a.e(this.this$0.e, "init rtcData: " + this.this$0.t);
        if (this.this$0.z == false) goto L57;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.f r110 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.f) this.this$0.C.getValue();
        MmRtcInitInfo r21 = this.this$0.y;
        r110.getClass();
        if (r21 != null) goto L43;
    L53:
        boolean r111 = false;
    L54:
        if (r111 == false) goto L57;
        lvb.a.e(this.this$0.e, "initRtc: config matches preloaded config, skip init");
        Result.Companion r112 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(Boxing.boxBoolean(true)));
    L43:
        if (r21.getServerVendorType() != r17.getServerVendorType()) goto L53;
        if (Intrinsics.areEqual(r21.getRtcAppId(), r17.getRtcAppId()) == false) goto L53;
        if (Intrinsics.areEqual(r21.getBusinessId(), r17.getBusinessId()) == false) goto L53;
        if (r21.isMediaOversea() != r17.isMediaOversea()) goto L53;
        if (r21.isDataOversea() != r17.isDataOversea()) goto L53;
        r111 = true;
    L57:
        lvb.a.e(this.this$0.e, "initRtc: config mismatch or not preloaded, reinitialize");
        boolean r113 = this.this$0.z;
        if (r113 == false) goto L60;
        lvb.a.e(this.this$0.e, "initRtc: destroy previous preloaded engine");
        this.this$0.x.d();
        this.this$0.z = false;
        this.this$0.y = null;
    L60:
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.f r3 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.f) this.this$0.C.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r17, "initInfo");
        r3.b = r17;     // Catch: Exception -> L63
        r3.c = true;     // Catch: Exception -> L63
        r3.a.putString("key_rtc_preload_config", e0.c(r17));     // Catch: Exception -> L63
        lvb.a.e("MmRtcPreloadCache", "saveRtcConfig success");     // Catch: Exception -> L63
    L65:
        if (r113 == false) goto L67;
        String r114 = "reinitialize";
    L68:
        MmRecordingAudioService r22 = this.this$0;
        this.label = 2;
        r12 = r22.g(r17, r114, this);
        if (r12 != r0) goto L71;
        return r0;
    L67:
        r114 = "direct";
    L63:
        e = move-exception;
        lvb.a.b("MmRtcPreloadCache", "saveRtcConfig failed: " + e);
        goto L65
    L37:
        r20 = null;
    L27:
        r6 = false;
    L30:
        r9 = false;
        goto L31
    L10:
        ResultKt.throwOnFailure(r12);
        Job r115 = this.this$0.D;
        if (r115 == null) goto L15;
        this.label = 1;
        if (r115.join(this) != r0) goto L15;
        return r0;
    }
}
