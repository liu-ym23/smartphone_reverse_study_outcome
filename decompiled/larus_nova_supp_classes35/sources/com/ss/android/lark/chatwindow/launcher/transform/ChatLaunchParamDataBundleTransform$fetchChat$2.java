package com.ss.android.lark.chatwindow.launcher.transform;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.chat.entity.chat.Chat;
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
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.transform.ChatLaunchParamDataBundleTransform$fetchChat$2", f = "ChatLaunchParamDataBundleTransform.kt", i = {}, l = {66, 70}, m = "invokeSuspend", n = {}, s = {})
public final class ChatLaunchParamDataBundleTransform$fetchChat$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Chat>>, Object> {
    final /* synthetic */ BaseBundle $baseBundle;
    final /* synthetic */ String $chatId;
    final /* synthetic */ String $chatterId;
    int label;
    final /* synthetic */ ChatLaunchParamDataBundleTransform this$0;

    public ChatLaunchParamDataBundleTransform$fetchChat$2(String r1, String r2, ChatLaunchParamDataBundleTransform r3, BaseBundle r4, Continuation<? super ChatLaunchParamDataBundleTransform$fetchChat$2> r5) {
        this.$chatterId = r1;
        this.$chatId = r2;
        this.this$0 = r3;
        this.$baseBundle = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatLaunchParamDataBundleTransform$fetchChat$2(this.$chatterId, this.$chatId, this.this$0, this.$baseBundle, r8);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L31:
        return Result.box-impl(r6);
    L10:
        ResultKt.throwOnFailure(r5);
        String r7 = this.$chatterId;
        if (r7 != null) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == true) goto L24;
        String r9 = this.$chatterId;
        if (r9 == null) goto L23;
        ChatLaunchParamDataBundleTransform r2 = this.this$0;
        BaseBundle r3 = this.$baseBundle;
        b r4 = r2.a;
        ProfileSource r10 = r3.b.d;
        this.label = 1;
        r6 = r4.a(r9, r10, this);
        if (r6 != r0) goto L31;
        return r0;
    L23:
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(new ErrorResult("chatterId is empty")));
        goto L31
    L24:
        String r12 = this.$chatId;
        if (r12 == null) goto L29;
        b r13 = this.this$0.a;
        this.label = 2;
        r6 = r13.b(r12, this);
        if (r6 != r0) goto L31;
        return r0;
    L29:
        Result.Companion r14 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(new ErrorResult("chatId is empty")));
        goto L31
    L13:
        if (r7.length() == 0) goto L16;
        r8 = false;
        goto L17
    }
}
