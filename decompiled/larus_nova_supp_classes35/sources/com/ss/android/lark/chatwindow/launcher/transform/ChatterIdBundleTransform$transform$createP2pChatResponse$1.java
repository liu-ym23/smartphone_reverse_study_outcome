package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.feed.app.entity.RankConstants;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.transform.ChatterIdBundleTransform$transform$createP2pChatResponse$1", f = "ChatterIdBundleTransform.kt", i = {}, l = {RankConstants.PRIORITY_BANNER_ITEM}, m = "invokeSuspend", n = {}, s = {})
public final class ChatterIdBundleTransform$transform$createP2pChatResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Chat>>, Object> {
    final /* synthetic */ String $chatterId;
    final /* synthetic */ ProfileSource $profileSource;
    int label;
    final /* synthetic */ ChatterIdBundleTransform this$0;

    public ChatterIdBundleTransform$transform$createP2pChatResponse$1(ChatterIdBundleTransform r1, String r2, ProfileSource r3, Continuation<? super ChatterIdBundleTransform$transform$createP2pChatResponse$1> r4) {
        this.this$0 = r1;
        this.$chatterId = r2;
        this.$profileSource = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatterIdBundleTransform$transform$createP2pChatResponse$1(this.this$0, this.$chatterId, this.$profileSource, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends Chat>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L12:
        return Result.box-impl(r6);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        b r7 = this.this$0.a;
        String r2 = this.$chatterId;
        ProfileSource r3 = this.$profileSource;
        this.label = 1;
        r6 = r7.a(r2, r3, this);
        if (r6 != r0) goto L12;
        return r0;
    }
}
