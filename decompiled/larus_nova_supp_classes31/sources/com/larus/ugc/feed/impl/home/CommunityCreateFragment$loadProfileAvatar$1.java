package com.larus.ugc.feed.impl.home;

import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.community.api.ICommunityService;
import com.larus.image.loader.ImageLoaderKt;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.home.CommunityCreateFragment$loadProfileAvatar$1", f = "CommunityCreateFragment.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
final class CommunityCreateFragment$loadProfileAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SimpleDraweeView $draweeView;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;

    public CommunityCreateFragment$loadProfileAvatar$1(SimpleDraweeView r1, String r2, Continuation<? super CommunityCreateFragment$loadProfileAvatar$1> r3) {
        this.$draweeView = r1;
        this.$userId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CommunityCreateFragment$loadProfileAvatar$1 r0 = new CommunityCreateFragment$loadProfileAvatar$1(this.$draweeView, this.$userId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L15
    L13:
        Object r6 = Result.constructor-impl((String) r5);     // Catch: Throwable -> L15
    L17:
        String r2 = this.$userId;
        Throwable r3 = Result.exceptionOrNull-impl(r6);
        if (r3 == null) goto L21;
        boolean r4 = w0a.a.a;
        w0a.a.b("CommunityCreateFragment[Kmp]", "loadProfileAvatar: getUserAvatarUrl failed userId=" + r2 + ", err=" + r3.getMessage());
    L21:
        if (Result.isFailure-impl(r6) == false) goto L23;
        r6 = null;
    L23:
        String r7 = (String) r6;
        if (r7 == null) goto L26;
        ImageLoaderKt.u(this.$draweeView, r7, "bot_ic_avatar_tag");
        return Unit.INSTANCE;
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        String r9 = this.$userId;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L15
        ICommunityService.Companion r11 = ICommunityService.a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r5 = r11.p1(r9, this);     // Catch: Throwable -> L15
        if (r5 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
