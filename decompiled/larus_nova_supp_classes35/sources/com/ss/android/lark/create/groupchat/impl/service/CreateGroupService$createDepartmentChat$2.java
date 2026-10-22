package com.ss.android.lark.create.groupchat.impl.service;

import android.content.Context;
import android.os.Bundle;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.ChatForsetiBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.CreateGroupService$createDepartmentChat$2", f = "CreateGroupService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreateGroupService$createDepartmentChat$2 extends SuspendLambda implements Function2<Chat, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Chat> $callback;
    final /* synthetic */ hab.b $chatDependency;
    final /* synthetic */ WeakReference<Context> $contextRef;
    /* synthetic */ Object L$0;
    int label;

    public CreateGroupService$createDepartmentChat$2(WeakReference<Context> r1, IGetDataCallback<Chat> r2, hab.b r3, Continuation<? super CreateGroupService$createDepartmentChat$2> r4) {
        this.$contextRef = r1;
        this.$callback = r2;
        this.$chatDependency = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CreateGroupService$createDepartmentChat$2 r0 = new CreateGroupService$createDepartmentChat$2(this.$contextRef, this.$callback, this.$chatDependency, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(Chat r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Chat) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r7);
        Chat r8 = (Chat) this.L$0;
        StringBuilder r0 = new StringBuilder("CREATE_DEPARTMENT_GROUP: create group success. chatId is ");
        if (r8 == null) goto L7;
        String r2 = r8.getId();
    L8:
        r0.append(r2);
        Log.i("CreateGroupService", r0.toString());
        if (r8 == null) goto L11;
        Bundle r1 = new Bundle();
        r1.putSerializable("key_forseti_bundle", new ChatForsetiBundle(true, false, 2, null));
        Context r3 = this.$contextRef.get();
        if (r3 == null) goto L15;
        hab.b r4 = this.$chatDependency;
        ChatBundle.a r5 = new ChatBundle.a();
        r5.a = r8.getId();
        r5.a(r8.getChatMode());
        r5.y = 1;
        r5.h = SourceType.PROFILE;
        r5.d = ChatFromType.GROUP_CREATE;
        r5.x = r1;
        ChatBundle r6 = new ChatBundle(r5);
        Intrinsics.checkNotNull(r6);
        r4.openChat(r3, r6);
    L15:
        IGetDataCallback<Chat> r9 = this.$callback;
        if (r9 == null) goto L19;
        r9.onSuccess(r8);
    L19:
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L7:
        r2 = null;
        goto L8
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
