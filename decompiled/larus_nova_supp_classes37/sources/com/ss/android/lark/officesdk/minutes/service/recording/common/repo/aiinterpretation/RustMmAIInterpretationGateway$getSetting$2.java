package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat.GetSISettingRequest;
import com.ss.android.lark.pb.videochat.GetSISettingResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationLanguage;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.RustMmAIInterpretationGateway$getSetting$2", f = "RustMmAIInterpretationGateway.kt", i = {}, l = {32, ItemViewType.ITEM_VIEW_TYPE_CALENDAR_INFO}, m = "invokeSuspend", n = {}, s = {})
public final class RustMmAIInterpretationGateway$getSetting$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends List<? extends g>>>, Object> {
    final /* synthetic */ String $breakoutRoomId;
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ RustMmAIInterpretationGateway this$0;

    public RustMmAIInterpretationGateway$getSetting$2(RustMmAIInterpretationGateway r1, String r2, String r3, Continuation<? super RustMmAIInterpretationGateway$getSetting$2> r4) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$breakoutRoomId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RustMmAIInterpretationGateway$getSetting$2(this.this$0, this.$meetingId, this.$breakoutRoomId, r5);
    }

    public final Object invoke(int r1, Continuation<? super Result<? extends List<g>>> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L33:
        return Result.box-impl(Result.constructor-impl(r14));
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        Object r15 = ((Result) r14).unbox-impl();
    L19:
        Throwable r2 = Result.exceptionOrNull-impl(r15);
        if (r2 != null) goto L35;
        GetSISettingResponse r16 = (GetSISettingResponse) r15;
        RustMmAIInterpretationGateway r3 = this.this$0;
        lvb.a.e(r3.b, "[getSetting] supportSI=" + r16.msupport_si + ", languageSize=" + r16.msupport_target_lang_list.size());
        if (Intrinsics.areEqual(r16.msupport_si, Boolean.TRUE) == true) goto L24;
        List r17 = CollectionsKt.emptyList();
    L29:
        Result.Companion r4 = Result.Companion;
        RustMmAIInterpretationGateway r5 = this.this$0;
        this.label = 2;
        r14 = RustMmAIInterpretationGateway.c(r5, r17, this);
        if (r14 != r0) goto L33;
        return r0;
    L24:
        List<GetSISettingResponse.Language> r18 = r16.msupport_target_lang_list;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r19 = r18.iterator();
    L26:
        if (r19.hasNext() == false) goto L28;
        GetSISettingResponse.Language r6 = (GetSISettingResponse.Language) r19.next();
        r12.add(new g(r6.mlanguage, r6.mdescription, r6.micon));
        goto L26
    L28:
        lvb.a.e(r3.b, "[getSetting] languages=" + CollectionsKt.joinToString$default(r12, null, "[", "]", 0, null, RustMmAIInterpretationGateway$parseSettingResponse$2$1.INSTANCE, 25, null));
        r17 = r12;
        goto L29
    L35:
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r2)));
    L10:
        ResultKt.throwOnFailure(r14);
        lvb.a.e(this.this$0.b, "[getSetting] request, meetingId=" + this.$meetingId + ", breakoutRoomId=" + this.$breakoutRoomId);
        GetSISettingRequest.Builder r110 = new GetSISettingRequest.Builder().meeting_id(this.$meetingId);
        if (this.$breakoutRoomId.length() <= 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        r110.breakout_room_id(this.$breakoutRoomId);
    L16:
        MmMockAwareRequestService r8 = this.this$0.a.M();
        Command r9 = Command.GET_MEETING_SI_SETTING;
        GetSISettingRequest r111 = r110.m3125build();
        this.label = 1;
        r15 = r8.a(r9, GetSISettingResponse.class, r111, this);
        if (r15 != r0) goto L19;
        return r0;
    L13:
        r7 = false;
        goto L14
    }
}
