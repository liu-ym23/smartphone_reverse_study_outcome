package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingSyncSubtitlesRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingSyncSubtitlesResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/pb/minutes/v1/MinutesRecordingSyncSubtitlesResponse;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper$syncSubtitles$2", f = "MmRecordingNetHelper.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingNetHelper$syncSubtitles$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends MinutesRecordingSyncSubtitlesResponse>>, Object> {
    final /* synthetic */ boolean $forceSync;
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $translateLanguage;
    int label;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$syncSubtitles$2(String r1, boolean r2, String r3, MmRecordingNetHelper r4, Continuation<? super MmRecordingNetHelper$syncSubtitles$2> r5) {
        this.$meetingId = r1;
        this.$forceSync = r2;
        this.$translateLanguage = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingNetHelper$syncSubtitles$2(this.$meetingId, this.$forceSync, this.$translateLanguage, this.this$0, r8);
    }

    public final Object invoke(int r1, Continuation<? super Result<MinutesRecordingSyncSubtitlesResponse>> r2) {
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
    L12:
        return Result.box-impl(r7);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MinutesRecordingSyncSubtitlesRequest r8 = new MinutesRecordingSyncSubtitlesRequest.Builder().session_id(this.$meetingId).force_sync(Boxing.boxBoolean(this.$forceSync)).language(this.$translateLanguage).m1892build();
        MmMockAwareRequestService r2 = this.this$0.a.M();
        Command r3 = Command.MINUTES_RECORDING_SYNC_SUBTITLES;
        Intrinsics.checkNotNull(r8);
        this.label = 1;
        r7 = r2.b(r3, MinutesRecordingSyncSubtitlesResponse.class, r8, this);
        if (r7 != r0) goto L12;
        return r0;
    }
}
