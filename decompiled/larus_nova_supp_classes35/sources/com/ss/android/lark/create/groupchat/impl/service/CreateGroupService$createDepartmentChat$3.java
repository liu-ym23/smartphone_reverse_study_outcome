package com.ss.android.lark.create.groupchat.impl.service;

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
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.CreateGroupService$createDepartmentChat$3", f = "CreateGroupService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreateGroupService$createDepartmentChat$3 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Chat> $callback;
    final /* synthetic */ hab.b $chatDependency;
    final /* synthetic */ CreateGroupService.b $createGroupContext;
    final /* synthetic */ CreateGroupScene $source;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreateGroupService this$0;

    public CreateGroupService$createDepartmentChat$3(CreateGroupService r1, hab.b r2, CreateGroupService.b r3, CreateGroupScene r4, IGetDataCallback<Chat> r5, Continuation<? super CreateGroupService$createDepartmentChat$3> r6) {
        this.this$0 = r1;
        this.$chatDependency = r2;
        this.$createGroupContext = r3;
        this.$source = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        CreateGroupService$createDepartmentChat$3 r7 = new CreateGroupService$createDepartmentChat$3(this.this$0, this.$chatDependency, this.$createGroupContext, this.$source, this.$callback, r10);
        r7.L$0 = r9;
        return r7;
    }

    public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ErrorResult) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r9);
        ErrorResult r10 = (ErrorResult) this.L$0;
        Log.i("CreateGroupService", "CREATE_DEPARTMENT_GROUP: create group failed. error is " + r10);
        CreateGroupService r0 = this.this$0;
        hab.b r1 = this.$chatDependency;
        CreateGroupService.b r2 = this.$createGroupContext;
        CreateGroupScene r3 = this.$source;
        int r4 = CreateGroupService.c;
        r0.b(r1, r2, r3, r10, null, null, null);
        IGetDataCallback<Chat> r5 = this.$callback;
        if (r5 == null) goto L8;
        r5.onError(r10);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
