package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.ss.android.lark.picker.base.view.ItemViewType;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleNormalContentViewHolder$bindSpeakerInfo$1", f = "MmSubtitleNormalContentViewHolder.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
final class MmSubtitleNormalContentViewHolder$bindSpeakerInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $bindAvatar;
    final /* synthetic */ boolean $bindUserName;
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.c $displaySpeaker;
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h $item;
    int label;
    final /* synthetic */ MmSubtitleNormalContentViewHolder this$0;

    public MmSubtitleNormalContentViewHolder$bindSpeakerInfo$1(MmSubtitleNormalContentViewHolder r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.c r3, boolean r4, boolean r5, Continuation<? super MmSubtitleNormalContentViewHolder$bindSpeakerInfo$1> r6) {
        this.this$0 = r1;
        this.$item = r2;
        this.$displaySpeaker = r3;
        this.$bindAvatar = r4;
        this.$bindUserName = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MmSubtitleNormalContentViewHolder$bindSpeakerInfo$1(this.this$0, this.$item, this.$displaySpeaker, this.$bindAvatar, this.$bindUserName, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
    L11:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r3 = this.$item;
        MmSubtitleNormalContentViewHolder r4 = this.this$0;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.c r5 = this.$displaySpeaker;
        boolean r6 = this.$bindAvatar;
        boolean r7 = this.$bindUserName;
        if (Result.isSuccess-impl(r12) == false) goto L20;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i) r12;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r9 = r3.g;
        String r10 = r8.f;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.f = r10;
        if (r3.g.g.length() == 0) goto L17;
        r2 = false;
    L17:
        if (r2 == false) goto L19;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r13 = r3.g;
        String r14 = r8.g;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.g = r14;
    L19:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.c r15 = r5.b(r8);
        int r16 = MmSubtitleNormalContentViewHolder.B;
        r4.a4(r15, r6, r7);
    L20:
        MmSubtitleNormalContentViewHolder r17 = this.this$0;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.c r18 = this.$displaySpeaker;
        boolean r19 = this.$bindAvatar;
        boolean r20 = this.$bindUserName;
        if (Result.exceptionOrNull-impl(r12) == null) goto L24;
        int r110 = MmSubtitleNormalContentViewHolder.B;
        r17.a4(r18, r19, r20);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MmSubtitleNormalContentViewHolder r111 = this.this$0;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a r21 = r111.y;
        String r112 = r111.d;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i r22 = this.$item.g;
        this.label = 1;
        r12 = r21.c(r112, r22, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
