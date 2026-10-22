package com.ss.android.lark.contact.base.contact_focus;

import a2b.h;
import com.ss.android.lark.chat.api.service.PrivateDescriptionSource;
import com.ss.android.lark.chat.api.service.Strategy;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Map;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chatter/UserPrivateDescription;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.base.contact_focus.SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1", f = "SpecialFocusModel.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
final class SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Map<String, ? extends UserPrivateDescription>>>, Object> {
    final /* synthetic */ List<String> $batchIds;
    final /* synthetic */ h $service;
    int label;

    public SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1(h r1, List<String> r2, Continuation<? super SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1> r3) {
        this.$service = r1;
        this.$batchIds = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1(this.$service, this.$batchIds, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends Map<String, UserPrivateDescription>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
        h r8 = this.$service;
        List<String> r2 = this.$batchIds;
        PrivateDescriptionSource r3 = PrivateDescriptionSource.CONTACT_IN_ORGANIZATION;
        Strategy r4 = Strategy.TRY_LOCAL;
        this.label = 1;
        r7 = r8.S0(r2, r3, r4, this);
        if (r7 != r0) goto L12;
        return r0;
    }
}
