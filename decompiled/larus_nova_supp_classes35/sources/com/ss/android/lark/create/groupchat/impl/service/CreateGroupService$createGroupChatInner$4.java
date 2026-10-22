package com.ss.android.lark.create.groupchat.impl.service;

import android.content.Context;
import com.bytedance.lark.pb.im.v1.CreateChatRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.CreateGroupService$createGroupChatInner$4", f = "CreateGroupService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreateGroupService$createGroupChatInner$4 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Chat> $callback;
    final /* synthetic */ hab.b $chatDependency;
    final /* synthetic */ Context $context;
    final /* synthetic */ CreateGroupService.b $createGroupContext;
    final /* synthetic */ CreateGroupService.c $param;
    final /* synthetic */ CreateChatRequest $request;
    final /* synthetic */ jab.c $sChatCreateGroupHitPoint;
    final /* synthetic */ CreateGroupScene $source;
    final /* synthetic */ String $sourceTag;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreateGroupService this$0;

    public CreateGroupService$createGroupChatInner$4(String r1, CreateGroupService r2, hab.b r3, CreateGroupService.b r4, CreateGroupScene r5, CreateGroupService.c r6, IGetDataCallback<Chat> r7, jab.c r8, CreateChatRequest r9, Context r10, Continuation<? super CreateGroupService$createGroupChatInner$4> r11) {
        this.$sourceTag = r1;
        this.this$0 = r2;
        this.$chatDependency = r3;
        this.$createGroupContext = r4;
        this.$source = r5;
        this.$param = r6;
        this.$callback = r7;
        this.$sChatCreateGroupHitPoint = r8;
        this.$request = r9;
        this.$context = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        CreateGroupService$createGroupChatInner$4 r12 = new CreateGroupService$createGroupChatInner$4(this.$sourceTag, this.this$0, this.$chatDependency, this.$createGroupContext, this.$source, this.$param, this.$callback, this.$sChatCreateGroupHitPoint, this.$request, this.$context, r15);
        r12.L$0 = r14;
        return r12;
    }

    public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ErrorResult) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r20);
        final ErrorResult r1 = (ErrorResult) this.L$0;
        Log.i("CreateGroupService", this.$sourceTag + ": create group failed. error is " + r1);
        CreateGroupService r2 = this.this$0;
        hab.b r3 = this.$chatDependency;
        CreateGroupService.b r4 = this.$createGroupContext;
        CreateGroupScene r5 = this.$source;
        CreateGroupService.c r7 = this.$param;
        final jab.c r6 = this.$sChatCreateGroupHitPoint;
        Function0<Unit> r8 = new AnonymousClass1(r6, r1);
        final CreateGroupService r10 = this.this$0;
        final String r11 = this.$sourceTag;
        final CreateChatRequest r12 = this.$request;
        final Context r13 = this.$context;
        final CreateGroupScene r14 = this.$source;
        final IGetDataCallback<Chat> r15 = this.$callback;
        final CreateGroupService.c r9 = this.$param;
        final hab.b r16 = this.$chatDependency;
        Function1<Boolean, Unit> r18 = new AnonymousClass2(r10, r11, r12, r13, r14, r15, r9, r16);
        int r17 = CreateGroupService.c;
        r2.b(r3, r4, r5, r1, r7, r8, r18);
        IGetDataCallback<Chat> r19 = this.$callback;
        if (r19 == null) goto L8;
        r19.onError(r1);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
