package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.picker.base.view.ItemViewType;
import jvb.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper$setAudioSaveStatus$2", f = "MmRecordingNetHelper.kt", i = {}, l = {526}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingNetHelper$setAudioSaveStatus$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ jvb.a $audioSaveIdentity;
    final /* synthetic */ boolean $isSave;
    final /* synthetic */ MmRecordingSource $source;
    int label;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$setAudioSaveStatus$2(MmRecordingNetHelper r1, jvb.a r2, boolean r3, MmRecordingSource r4, Continuation<? super MmRecordingNetHelper$setAudioSaveStatus$2> r5) {
        this.this$0 = r1;
        this.$audioSaveIdentity = r2;
        this.$isSave = r3;
        this.$source = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingNetHelper$setAudioSaveStatus$2(this.this$0, this.$audioSaveIdentity, this.$isSave, this.$source, r8);
    }

    public final Object invoke(int r1, Continuation<? super Result<Unit>> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L12:
        if (Result.isSuccess-impl(r9) == false) goto L15;
        String r10 = (String) r9;
        r9 = Unit.INSTANCE;
    L15:
        return Result.box-impl(Result.constructor-impl(r9));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        MmMockAwareRequestService r11 = this.this$0.a.M();
        k r3 = new k(this.$audioSaveIdentity, this.$isSave, this.$source);
        this.label = 1;
        r9 = r11.c(String.class, r3, this);
        if (r9 != r0) goto L12;
        return r0;
    }
}
