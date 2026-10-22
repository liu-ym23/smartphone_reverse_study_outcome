package com.larus.ugc.feed.impl.spi;

import com.larus.platform.service.AccountService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.spi.CommunityCreateSettingsAndroidImpl", f = "CommunityCreateSettingsAndroidImpl.kt", i = {}, l = {65}, m = "getUserAvatarUrl", n = {}, s = {})
final class CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$1(a r1, Continuation<? super CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        a r8 = this.this$0;
        r8.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$1 r0 = this;
    L6:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L11
    L29:
        Object r10 = Result.constructor-impl((String) r9);     // Catch: Throwable -> L11
    L33:
        if (Result.isFailure-impl(r10) == false) goto L36;
    L42:
        return null;
    L36:
        return r10;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L18
        Object r12 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r12) == false) goto L23;
        r12 = null;
    L23:
        String r13 = (String) r12;
        if (r13 == null) goto L42;
        CoroutineDispatcher r4 = Dispatchers.getIO();     // Catch: Throwable -> L11
        CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$2$1 r5 = new CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$2$1(r13, null);     // Catch: Throwable -> L11
        r0.label = 1;     // Catch: Throwable -> L11
        r9 = BuildersKt.withContext(r4, r5, r0);     // Catch: Throwable -> L11
        if (r9 != r2) goto L29;
        return r2;
    L18:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L5:
        r0 = new CommunityCreateSettingsAndroidImpl$getUserAvatarUrl$1(r8, this);
        goto L6
    }
}
