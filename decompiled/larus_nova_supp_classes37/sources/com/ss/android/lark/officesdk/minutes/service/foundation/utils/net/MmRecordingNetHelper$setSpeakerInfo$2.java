package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat.Image;
import com.ss.android.lark.pb.videochat.LarkSpeakerInfo;
import com.ss.android.lark.pb.videochat.SetSpeakerInfoRequest;
import com.ss.android.lark.pb.videochat.SetSpeakerInfoResponse;
import com.ss.android.lark.pb.videochat.SpeakerInfo;
import com.ss.android.lark.pb.videochat.SpeakerInfoType;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/pb/videochat/SetSpeakerInfoResponse;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper$setSpeakerInfo$2", f = "MmRecordingNetHelper.kt", i = {}, l = {370}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingNetHelper$setSpeakerInfo$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends SetSpeakerInfoResponse>>, Object> {
    final /* synthetic */ String $clusterId;
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $operatorId;
    final /* synthetic */ d $payload;
    final /* synthetic */ long $segId;
    int label;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$setSpeakerInfo$2(String r1, String r2, String r3, long r4, d r6, MmRecordingNetHelper r7, Continuation<? super MmRecordingNetHelper$setSpeakerInfo$2> r8) {
        this.$meetingId = r1;
        this.$operatorId = r2;
        this.$clusterId = r3;
        this.$segId = r4;
        this.$payload = r6;
        this.this$0 = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MmRecordingNetHelper$setSpeakerInfo$2(this.$meetingId, this.$operatorId, this.$clusterId, this.$segId, this.$payload, this.this$0, r11);
    }

    public final Object invoke(int r1, Continuation<? super Result<SetSpeakerInfoResponse>> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L27:
        return Result.box-impl(r7);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        SetSpeakerInfoRequest.Builder r8 = new SetSpeakerInfoRequest.Builder().meeting_id(this.$meetingId).operator_id(this.$operatorId).cluster_id(this.$clusterId).seg_id(Boxing.boxLong(this.$segId));
        d r2 = this.$payload;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof d.b) == false) goto L12;
        SpeakerInfoType r3 = SpeakerInfoType.Real_Lark_User;
    L14:
        SetSpeakerInfoRequest.Builder r9 = r8.speaker_info_type(r3);
        d r4 = this.$payload;
        if ((r4 instanceof d.b) == false) goto L21;
        LarkSpeakerInfo.Builder r5 = new LarkSpeakerInfo.Builder().id(((d.b) this.$payload).b).name(((d.b) this.$payload).c).department(((d.b) this.$payload).d);
        Image r10 = ((d.b) this.$payload).f;
        if (r10 != null) goto L19;
        r10 = new Image.Builder().key(((d.b) this.$payload).e).m3146build();
    L19:
        r9.lark_speaker_info(r5.avatar(r10).m3149build());
    L23:
        MmMockAwareRequestService r11 = this.this$0.a.M();
        Command r12 = Command.SET_SPEAKER_INFO;
        SetSpeakerInfoRequest r13 = r9.m3185build();
        this.label = 1;
        r7 = r11.a(r12, SetSpeakerInfoResponse.class, r13, this);
        if (r7 != r0) goto L27;
        return r0;
    L21:
        if ((r4 instanceof d.c) == false) goto L29;
        r9.speaker_info(new SpeakerInfo.Builder().id(((d.c) this.$payload).b).name(((d.c) this.$payload).c).avatar(((d.c) this.$payload).d).m3191build());
        goto L23
    L29:
        throw new NoWhenBranchMatchedException();
    L12:
        if ((r2 instanceof d.c) == false) goto L31;
        r3 = SpeakerInfoType.Fake_Lark_User;
        goto L14
    L31:
        throw new NoWhenBranchMatchedException();
    }
}
