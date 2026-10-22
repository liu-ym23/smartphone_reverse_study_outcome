package com.larus.profile.impl;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileRepo$saveProfileOverviewData$2", f = "ProfileRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileRepo$saveProfileOverviewData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fs9.u $recommendData;
    int label;
    final /* synthetic */ ProfileRepo this$0;

    public ProfileRepo$saveProfileOverviewData$2(fs9.u r1, ProfileRepo r2, Continuation<? super ProfileRepo$saveProfileOverviewData$2> r3) {
        this.$recommendData = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProfileRepo$saveProfileOverviewData$2(this.$recommendData, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        if (this.$recommendData == null) goto L7;
        ProfileRepo r4 = this.this$0;
        Lazy<ProfileRepo> r0 = ProfileRepo.b;
        ((Keva) r4.a.getValue()).storeString("key_profile_overview_data", GsonProtectorUtils.toJson(new Gson(), this.$recommendData));
        ((Keva) this.this$0.a.getValue()).storeBoolean("key_has_profile_overview_data", true);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
