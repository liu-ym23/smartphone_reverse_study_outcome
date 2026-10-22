package com.larus.bmhome.chat.bubble.floating.runtime;

import com.larus.bmhome.chat.bubble.floating.network.BubbleBannerApi;
import com.larus.bmhome.chat.bubble.floating.network.ExperienceCommonBizData;
import com.larus.bmhome.chat.bubble.floating.network.ExperienceCommonBizRequest;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.bean.BizResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/bmhome/chat/bubble/floating/network/ExperienceCommonBizData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.bubble.floating.runtime.BubbleBannerManager$sendCommonRequest$1$result$1", f = "BubbleBannerManager.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
public final class BubbleBannerManager$sendCommonRequest$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dm9.a<? extends ExperienceCommonBizData>>, Object> {
    final /* synthetic */ Map<String, String> $actionData;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.bubble.floating.runtime.BubbleBannerManager$sendCommonRequest$1$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/bubble/floating/network/ExperienceCommonBizData;", "Lcom/larus/bmhome/chat/bubble/floating/network/BubbleBannerApi;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.bubble.floating.runtime.BubbleBannerManager$sendCommonRequest$1$result$1$1", f = "BubbleBannerManager.kt", i = {}, l = {347}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<BubbleBannerApi, Continuation<? super BizResponse<ExperienceCommonBizData>>, Object> {
        final /* synthetic */ Map<String, String> $actionData;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Map<String, String> r1, Continuation<? super AnonymousClass1> r2) {
            this.$actionData = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$actionData, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(BubbleBannerApi r1, Continuation<? super BizResponse<ExperienceCommonBizData>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((BubbleBannerApi) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L23:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            BubbleBannerApi r12 = (BubbleBannerApi) this.L$0;
            Map<String, String> r2 = this.$actionData;
            if (r2 == null) goto L11;
            String r5 = r2.get("biz_req_id");
        L12:
            Map<String, String> r3 = this.$actionData;
            if (r3 == null) goto L19;
            String r4 = r3.get("params");
            if (r4 == null) goto L19;
            if ((!StringsKt.isBlank(r4)) == false) goto L19;
            String r7 = r4;
        L20:
            ExperienceCommonBizRequest r6 = new ExperienceCommonBizRequest(r5, 0, r7, 2, null);
            this.label = 1;
            r11 = r12.sendCommonRequest(r6, this);
            if (r11 != r0) goto L23;
            return r0;
        L19:
            r7 = null;
            goto L20
        L11:
            r5 = null;
            goto L12
        }
    }

    public BubbleBannerManager$sendCommonRequest$1$result$1(Map<String, String> r1, Continuation<? super BubbleBannerManager$sendCommonRequest$1$result$1> r2) {
        this.$actionData = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BubbleBannerManager$sendCommonRequest$1$result$1(this.$actionData, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super dm9.a<ExperienceCommonBizData>> r2) {
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
        BubbleBannerApi.a r7 = BubbleBannerApi.a;
        AnonymousClass1 r2 = new AnonymousClass1(this.$actionData, null);
        this.label = 1;
        r7.getClass();
        r6 = BubbleBannerApi.a.a(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
