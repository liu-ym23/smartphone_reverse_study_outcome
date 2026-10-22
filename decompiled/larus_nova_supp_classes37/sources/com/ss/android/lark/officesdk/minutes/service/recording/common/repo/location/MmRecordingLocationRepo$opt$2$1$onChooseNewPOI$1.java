package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import android.location.Location;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo$opt$2$1$onChooseNewPOI$1", f = "MmRecordingLocationRepo.kt", i = {}, l = {274}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLocationRepo$opt$2$1$onChooseNewPOI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ POIInfo $poiInfo;
    int label;
    final /* synthetic */ MmRecordingLocationRepo this$0;
    final /* synthetic */ MmRecordingLocationRepo$opt$2.AnonymousClass1 this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo$opt$2$1$onChooseNewPOI$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo$opt$2$1$onChooseNewPOI$1$1", f = "MmRecordingLocationRepo.kt", i = {}, l = {275}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ POIInfo $poiInfo;
        final /* synthetic */ LarkLocation $selectedLocation;
        int label;
        final /* synthetic */ MmRecordingLocationRepo this$0;
        final /* synthetic */ MmRecordingLocationRepo$opt$2.AnonymousClass1 this$1;

        public AnonymousClass1(MmRecordingLocationRepo r1, MmRecordingLocationRepo$opt$2.AnonymousClass1 r2, POIInfo r3, LarkLocation r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.this$1 = r2;
            this.$poiInfo = r3;
            this.$selectedLocation = r4;
            super(1, r5);
        }

        public final Continuation<Unit> create(Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.this$1, this.$poiInfo, this.$selectedLocation, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            MmRecordingLocationRepo r12 = this.this$0;
            d r2 = (d) this.this$1.m();
            String r6 = this.$poiInfo.getLocationName();
            LarkLocation r5 = this.$selectedLocation;
            POIInfo r7 = this.$poiInfo;
            r2.getClass();
            d r3 = new d(r5, r6, r7, false, false);
            this.label = 1;
            if (r12.b(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public MmRecordingLocationRepo$opt$2$1$onChooseNewPOI$1(MmRecordingLocationRepo r1, MmRecordingLocationRepo$opt$2.AnonymousClass1 r2, POIInfo r3, Continuation<? super MmRecordingLocationRepo$opt$2$1$onChooseNewPOI$1> r4) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$poiInfo = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingLocationRepo$opt$2$1$onChooseNewPOI$1(this.this$0, this.this$1, this.$poiInfo, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        this.this$1.U0("onChooseNewPOI");
        MmRecordingLocationRepo.l(this.this$0).i(Boxing.boxDouble(this.$poiInfo.getLatitude()), Boxing.boxDouble(this.$poiInfo.getLongitude()), "choosePOI");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        LarkLocation r7 = new LarkLocation(new Location("minutes_poi"));
        POIInfo r11 = this.$poiInfo;
        r7.setLatitude(r11.getLatitude());
        r7.setLongitude(r11.getLongitude());
        r7.a = r11.getLocationName();
        MmRecordingLocationRepo r12 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(r12, this.this$1, this.$poiInfo, r7, null);
        this.label = 1;
        if (r12.e.b(r2, this) != r0) goto L11;
        return r0;
    }
}
