package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import android.app.Application;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.service.f;
import com.ss.android.lark.location.service.h;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingLocationHelper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo$opt$2$1$doGetLocation$1$onGetLocationSuccess$1", f = "MmRecordingLocationRepo.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLocationRepo$opt$2$1$doGetLocation$1$onGetLocationSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarkLocation $location;
    int label;
    final /* synthetic */ MmRecordingLocationRepo this$0;
    final /* synthetic */ MmRecordingLocationRepo$opt$2.AnonymousClass1 this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo$opt$2$1$doGetLocation$1$onGetLocationSuccess$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo$opt$2$1$doGetLocation$1$onGetLocationSuccess$1$1", f = "MmRecordingLocationRepo.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LarkLocation $location;
        int label;
        final /* synthetic */ MmRecordingLocationRepo this$0;
        final /* synthetic */ MmRecordingLocationRepo$opt$2.AnonymousClass1 this$1;

        public AnonymousClass1(MmRecordingLocationRepo r1, MmRecordingLocationRepo$opt$2.AnonymousClass1 r2, LarkLocation r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.this$1 = r2;
            this.$location = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.this$1, this.$location, r5);
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
            d r2 = d.a((d) this.this$1.m(), this.$location, null, null, false, false, 30);
            this.label = 1;
            if (r12.b(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public MmRecordingLocationRepo$opt$2$1$doGetLocation$1$onGetLocationSuccess$1(LarkLocation r1, MmRecordingLocationRepo r2, MmRecordingLocationRepo$opt$2.AnonymousClass1 r3, Continuation<? super MmRecordingLocationRepo$opt$2$1$doGetLocation$1$onGetLocationSuccess$1> r4) {
        this.$location = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingLocationRepo$opt$2$1$doGetLocation$1$onGetLocationSuccess$1(this.$location, this.this$0, this.this$1, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L15:
        Application r12 = LarkContext.getApplication();
        MmRecordingLocationHelper r2 = (MmRecordingLocationHelper) this.this$0.m.getValue();
        Intrinsics.checkNotNull(r12);
        double r3 = this.$location.getLatitude();
        double r5 = this.$location.getLongitude();
        final MmRecordingLocationRepo r7 = this.this$0;
        final MmRecordingLocationRepo$opt$2.AnonymousClass1 r8 = this.this$1;
        final LarkLocation r9 = this.$location;
        Function1<POIInfo, Unit> r4 = new AnonymousClass2(r7, r8, r9);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r4, "res");
        h r10 = f.a().getPOIService();
        r10.q0(r3, r5);
        r10.s0(r12, Scene.Minutes.INSTANCE, new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.b(r2, r4), 1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        if (this.$location != null) goto L12;
        lvb.a.b(this.this$0.l, "[doGetLocation] location is null");
        return Unit.INSTANCE;
    L12:
        lvb.a.e(this.this$0.l, "[doGetLocation] success: " + this.$location.getLatitude() + ", " + this.$location.getLongitude());
        MmRecordingLocationRepo r13 = this.this$0;
        AnonymousClass1 r6 = new AnonymousClass1(r13, this.this$1, this.$location, null);
        this.label = 1;
        if (r13.e.b(r6, this) != r0) goto L15;
        return r0;
    }
}
