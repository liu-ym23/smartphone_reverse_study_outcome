package com.ss.android.lark.chatwindow.launcher.transform;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatIdLaunchData;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatIdBundleTransform implements a<ChatIdLaunchData> {
    public final b a;

    @Inject
    public ChatIdBundleTransform(b r2) {
        Intrinsics.checkNotNullParameter(r2, "chatLaunchService");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.a
    public final /* bridge */ /* synthetic */ Object a(ILaunchDataInput r1, BaseBundle r2, Continuation r3) {
        return b((ChatIdLaunchData) r1, r2, r3);
    }

    public final Object b(ChatIdLaunchData r8, BaseBundle r9, Continuation<? super Result<d>> r10) {
        if ((r10 instanceof ChatIdBundleTransform$transform$1) == false) goto L7;
        ChatIdBundleTransform$transform$1 r0 = (ChatIdBundleTransform$transform$1) r10;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Chat r12 = (Chat) r0.L$1;
        r9 = (BaseBundle) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L36:
        ChatBundleV2 r13 = TransformUtils.a(r12, (Chatter) r11, r9);
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(new d(r13, r12));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (BaseBundle) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L29:
        r12 = (Chat) r11;
        if (r12 != null) goto L33;
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new ErrorResult("fetch chat failed")));
    L33:
        CoroutineDispatcher r16 = Dispatchers.getIO();
        ChatIdBundleTransform$transform$chatter$1 r4 = new ChatIdBundleTransform$transform$chatter$1(r12, this, null);
        r0.L$0 = r9;
        r0.L$1 = r12;
        r0.label = 2;
        r11 = BuildersKt.withContext(r16, r4, r0);
        if (r11 != r2) goto L36;
        return r2;
    L16:
        ResultKt.throwOnFailure(r11);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "launch chat by chatId");
        String r17 = r8.a;
        int r5 = r9.c.a;
        Lazy r6 = TransformUtils.a;
        if (r5 != 2) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == false) goto L26;
        RealLaunchData r18 = new RealLaunchData(r17, null, RealLaunchData.ChatDirection.MY_AI);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "destination AI");
        Result.Companion r19 = Result.Companion;
        return Result.constructor-impl(new d(new ChatBundleV2(r18, r9.E()), null));
    L26:
        CoroutineDispatcher r110 = Dispatchers.getIO();
        ChatIdBundleTransform$transform$chat$1 r20 = new ChatIdBundleTransform$transform$chat$1(this, r17, null);
        r0.L$0 = r9;
        r0.label = 1;
        r11 = BuildersKt.withContext(r110, r20, r0);
        if (r11 != r2) goto L29;
        return r2;
    L19:
        if (r5 == 3) goto L22;
        r7 = false;
    L7:
        r0 = new ChatIdBundleTransform$transform$1(this, r10);
        goto L8
    }
}
