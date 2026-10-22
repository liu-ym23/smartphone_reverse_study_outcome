package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.meeting_object.FeatureUpgradeInfo;
import com.ss.android.lark.pb.meeting_object.FeatureUpgradeType;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo$opt$2$1$observeFeatureUpgradePush$1", f = "MmRecordingQuotaCtaRepo.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingQuotaCtaRepo$opt$2$1$observeFeatureUpgradePush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingQuotaCtaRepo this$0;
    final /* synthetic */ MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 this$1;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingQuotaCtaRepo a;
        public final /* synthetic */ MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 b;

        public a(MmRecordingQuotaCtaRepo r1, MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r5, Continuation r6) {
            List<FeatureUpgradeType> r7 = ((FeatureUpgradeInfo) r5).mupgrade_type;
            Intrinsics.checkNotNull(r7);
            List<FeatureUpgradeType> r8 = r7;
            boolean r1 = false;
            if ((r8 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r9 = r8.iterator();
        L9:
            if (r9.hasNext() == false) goto L19;
            FeatureUpgradeType r0 = (FeatureUpgradeType) r9.next();
            if (r0 != FeatureUpgradeType.FeatureUpgradeType_AI) goto L13;
        L16:
            boolean r2 = true;
        L17:
            if (r2 == false) goto L9;
            r1 = true;
            goto L19
        L13:
            if (r0 == FeatureUpgradeType.FeatureUpgradeType_ASR) goto L16;
            r2 = false;
        L19:
            lvb.a.e(this.a.l, "[observeFeatureUpgradePush] upgradeTypes=" + r7 + ", shouldRefresh=" + r1);
            if (r1 == false) goto L23;
            this.b.B0("featureUpgradePush");
        L23:
            return Unit.INSTANCE;
        L5:
            if (r8.isEmpty() == false) goto L7;
            goto L7
        }
    }

    public MmRecordingQuotaCtaRepo$opt$2$1$observeFeatureUpgradePush$1(MmRecordingQuotaCtaRepo r1, MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingQuotaCtaRepo$opt$2$1$observeFeatureUpgradePush$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingQuotaCtaRepo$opt$2$1$observeFeatureUpgradePush$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        d1 r7 = this.this$0.j.Q().a(Command.MM_PUSH_FEATURE_UPGRADE, FeatureUpgradeInfo.class);
        a r2 = new a(this.this$0, this.this$1);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
