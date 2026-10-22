package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmUploadLocationResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingLocationHelper;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1", f = "MmRecordingLocationRepo.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingSource $createSource;
    final /* synthetic */ LarkLocation $location;
    final /* synthetic */ b $locationIdentity;
    final /* synthetic */ String $poiName;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ MmRecordingLocationRepo this$0;
    final /* synthetic */ MmRecordingLocationRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1(MmRecordingLocationRepo r1, b r2, LarkLocation r3, String r4, MmRecordingSource r5, String r6, MmRecordingLocationRepo$opt$2.AnonymousClass1 r7, Continuation<? super MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1> r8) {
        this.this$0 = r1;
        this.$locationIdentity = r2;
        this.$location = r3;
        this.$poiName = r4;
        this.$createSource = r5;
        this.$source = r6;
        this.this$1 = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1(this.this$0, this.$locationIdentity, this.$location, this.$poiName, this.$createSource, this.$source, this.this$1, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
        Object r15 = ((Result) r14).unbox-impl();
    L11:
        MmRecordingLocationRepo r2 = this.this$0;
        String r3 = this.$source;
        MmRecordingLocationRepo$opt$2.AnonymousClass1 r4 = this.this$1;
        if (Result.isSuccess-impl(r15) == false) goto L14;
        lvb.a.e(r2.l, "[tryUploadLocation] source=" + r3 + ", onSuccess: " + ((MmUploadLocationResponse) r15));
        r2.j(new MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1$1$1(r2, r4, null));
    L14:
        MmRecordingLocationRepo r5 = this.this$0;
        String r6 = this.$source;
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L18;
        lvb.a.b(r5.l, "[tryUploadLocation] source=" + r6 + ", onError: " + r16);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        MmRecordingLocationHelper r7 = (MmRecordingLocationHelper) this.this$0.m.getValue();
        String r8 = this.$locationIdentity.a;
        double r9 = this.$location.getLatitude();
        double r10 = this.$location.getLongitude();
        String r11 = this.$poiName;
        MmRecordingSource r12 = this.$createSource;
        boolean r13 = this.this$0.j.a.v();
        this.label = 1;
        r15 = r7.a(r8, r9, r10, r11, r12, r13, this);
        if (r15 != r0) goto L11;
        return r0;
    }
}
