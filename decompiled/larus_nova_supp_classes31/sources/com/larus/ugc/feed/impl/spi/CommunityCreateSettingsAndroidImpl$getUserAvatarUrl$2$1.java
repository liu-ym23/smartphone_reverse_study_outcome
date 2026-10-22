package com.larus.ugc.feed.impl.spi;

import com.larus.community.api.ICommunityService;
import com.tencent.open.log.TraceLevel;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.spi.CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$2$1", f = "CommunityCreateSettingsAndroidImpl.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
final class CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $userId;
    int label;

    public CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$2$1(String r1, Continuation<? super CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$2$1> r2) {
        this.$userId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$2$1(this.$userId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ICommunityService.Companion r5 = ICommunityService.a;
        String r2 = this.$userId;
        this.label = 1;
        r4 = r5.p1(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
