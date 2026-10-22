package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.interceptor.GroupMemberLimitInterceptor$intercept$1", f = "GroupMemberLimitInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GroupMemberLimitInterceptor$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ErrorResult $err;
    final /* synthetic */ CreateGroupScene $scene;
    int label;

    public GroupMemberLimitInterceptor$intercept$1(ErrorResult r1, Context r2, CreateGroupScene r3, Continuation<? super GroupMemberLimitInterceptor$intercept$1> r4) {
        this.$err = r1;
        this.$context = r2;
        this.$scene = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GroupMemberLimitInterceptor$intercept$1(this.$err, this.$context, this.$scene, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        String r5 = this.$err.getDisplayMsg(this.$context.getString(2131890924));
        int r0 = GroupMemberLimitInterceptor.a;
        Context r1 = this.$context;
        Intrinsics.checkNotNull(r5);
        CreateGroupScene r2 = this.$scene;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r5, "displayMsg");
        Intrinsics.checkNotNullParameter(r2, "scene");
        e r3 = new e(r2);
        new UDDialogBuilder(r1).message(r5).addActionButton(2131391777, 2131890749, r3).show();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
