package com.ss.android.lark.chatwindow.launcher.transform;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatEntityLaunchData;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatBundleTransform implements a<ChatEntityLaunchData> {
    public final b a;

    @Inject
    public ChatBundleTransform(b r2) {
        Intrinsics.checkNotNullParameter(r2, "chatLaunchService");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.a
    public final /* bridge */ /* synthetic */ Object a(ILaunchDataInput r1, BaseBundle r2, Continuation r3) {
        return b((ChatEntityLaunchData) r1, r2, r3);
    }

    public final Object b(ChatEntityLaunchData r6, BaseBundle r7, Continuation<? super Result<d>> r8) {
        if ((r8 instanceof ChatBundleTransform$transform$1) == false) goto L7;
        ChatBundleTransform$transform$1 r0 = (ChatBundleTransform$transform$1) r8;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Chat r10 = (Chat) r0.L$1;
        r7 = (BaseBundle) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L21:
        ChatBundleV2 r11 = TransformUtils.a(r10, (Chatter) r9, r7);
        Result.Companion r12 = Result.Companion;
        return Result.constructor-impl(new d(r11, r10));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "launch chat by chat");
        r10 = r6.a;
        if (r10 != null) goto L18;
        Result.Companion r13 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new ErrorResult("chat input null failed")));
    L18:
        CoroutineDispatcher r14 = Dispatchers.getIO();
        ChatBundleTransform$transform$chatter$1 r4 = new ChatBundleTransform$transform$chatter$1(r10, this, null);
        r0.L$0 = r7;
        r0.L$1 = r10;
        r0.label = 1;
        r9 = BuildersKt.withContext(r14, r4, r0);
        if (r9 != r2) goto L21;
        return r2;
    L7:
        r0 = new ChatBundleTransform$transform$1(this, r8);
        goto L8
    }
}
