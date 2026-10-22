package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import android.app.Application;
import android.text.TextUtils;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import iub.k;
import iub.x;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$onMeetingInfoReady$1", f = "MmRecordingSummaryRepo.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSummaryRepo$opt$2$1$onMeetingInfoReady$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmRecordingSummaryRepo this$0;
    final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingSummaryRepo$opt$2$1$onMeetingInfoReady$1(MmRecordingSummaryRepo r1, MmRecordingSummaryRepo$opt$2.AnonymousClass1 r2, String r3, Continuation<? super MmRecordingSummaryRepo$opt$2$1$onMeetingInfoReady$1> r4) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$meetingId = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingSummaryRepo$opt$2$1$onMeetingInfoReady$1(this.this$0, this.this$1, this.$meetingId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
    L40:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        MmRecordingSummaryRepo r3 = this.this$0;
        c r5 = (c) this.this$1.m();
        MmRecordingSummaryRepo$opt$2.AnonymousClass1 r4 = this.this$1;
        String r6 = this.$meetingId;
        r4.getClass();
        Application r7 = LarkContext.getApplication();
        String r8 = r4.h.k.J().d();
        k r9 = r4.h.j.a.f;
        if (r9 == null) goto L12;
        MmRecordingSource r10 = r9.a;
        if (r10 == null) goto L12;
    L13:
        x r11 = r10.getSummaryWebConfig();
        String r12 = r8 + "/webview/preload-service-page";
        String r13 = r4.h.k.getCurrentUserId();
        IDeviceInfoProvider r14 = OfficeSDKManager.getDeviceInfoProvider();
        if (r14 == null) goto L17;
        String r15 = r14.getDeviceId();
        if (r15 == null) goto L17;
    L18:
        String r16 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.a.a();
        StringBuilder r17 = new StringBuilder(r12);
        r17.append("?aid=" + OfficeSDKManager.getAppId());
        r17.append("&header=0");
        r17.append("&meetingId=" + r6);
        r17.append("&user_id=" + r13);
        r17.append("&device_id=".concat(r15));
        r17.append("&lang=" + r16);
        r17.append("&app_version=" + r11.c);
        r17.append("&os_type=android&device=mobile");
        r17.append("&app_brand=" + r11.b);
        if (r10 != MmRecordingSource.FEISHU_DOUBAO) goto L21;
        r17.append("&isDoubaoInLark=1");
    L21:
        int r19 = r4.h.k.y().envType();
        if (r19 != 2) goto L24;
    L27:
        String r20 = r4.h.k.getSettingsService().k.getAiSummaryMobileExtraQuery();
        if (TextUtils.isEmpty(r20) == true) goto L30;
        r17.append("&" + r20);
    L30:
        r17.append("&webviewEntry=" + StringsKt.removePrefix(r11.a, "/webview/"));
        if (r4.h.j.w().l().m().e.isInSummary() == true) goto L34;
        r17.append("&isHidden=1");
    L34:
        if (NetworkUtils.e(r7) == true) goto L36;
        r17.append("&disableUpdate=1");
    L36:
        String r21 = r17.toString();
        lvb.a.e(r4.h.l, "[buildSummaryUrl] url=" + r21);
        c r22 = c.a(r5, null, null, null, r21, null, null, false, false, false, null, 8127);
        this.label = 1;
        if (r3.b(r22, this) != r1) goto L40;
        return r1;
    L24:
        if (r19 == 3) goto L27;
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L30;
    L17:
        r15 = "";
    L12:
        r10 = MmRecordingSource.DOUBAO_PERSONAL;
        goto L13
    }
}
