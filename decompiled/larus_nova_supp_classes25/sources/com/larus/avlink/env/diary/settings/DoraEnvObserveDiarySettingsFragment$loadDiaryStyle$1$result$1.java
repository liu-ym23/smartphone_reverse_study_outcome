package com.larus.avlink.env.diary.settings;

import android.os.Bundle;
import com.larus.avlink.env.diary.style.api.DoraEnvObserveDiaryStyleApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/avlink/env/diary/style/api/DiaryStyleListData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.settings.DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1$result$1", f = "DoraEnvObserveDiarySettingsFragment.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
public final class DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dm9.a<? extends m98.c>>, Object> {
    int label;
    final /* synthetic */ DoraEnvObserveDiarySettingsFragment this$0;

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.settings.DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/env/diary/style/api/DiaryStyleListData;", "Lcom/larus/avlink/env/diary/style/api/DoraEnvObserveDiaryStyleApi;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.settings.DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1$result$1$1", f = "DoraEnvObserveDiarySettingsFragment.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<DoraEnvObserveDiaryStyleApi, Continuation<? super BizResponse<m98.c>>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraEnvObserveDiarySettingsFragment this$0;

        public AnonymousClass1(DoraEnvObserveDiarySettingsFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(DoraEnvObserveDiaryStyleApi r1, Continuation<? super BizResponse<m98.c>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((DoraEnvObserveDiaryStyleApi) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L14:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            DoraEnvObserveDiaryStyleApi r9 = (DoraEnvObserveDiaryStyleApi) this.L$0;
            FlowDoraSubBizType.a r3 = FlowDoraSubBizType.Companion;
            DoraEnvObserveDiarySettingsFragment r4 = this.this$0;
            int r5 = DoraEnvObserveDiarySettingsFragment.i;
            Bundle r6 = r4.getArguments();
            int r7 = 16;
            if (r6 == null) goto L11;
            r7 = r6.getInt("product_id", 16);
        L11:
            Integer r10 = Boxing.boxInt(r7);
            r3.getClass();
            m98.d r2 = new m98.d(Boxing.boxInt(FlowDoraSubBizType.a.b(r10)));
            this.label = 1;
            r8 = r9.getDiaryStyleList(r2, this);
            if (r8 != r0) goto L14;
            return r0;
        }
    }

    public DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1$result$1(DoraEnvObserveDiarySettingsFragment r1, Continuation<? super DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1$result$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1$result$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super dm9.a<m98.c>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DoraEnvObserveDiaryStyleApi.a r7 = DoraEnvObserveDiaryStyleApi.a;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        r7.getClass();
        r6 = DoraEnvObserveDiaryStyleApi.a.a(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
