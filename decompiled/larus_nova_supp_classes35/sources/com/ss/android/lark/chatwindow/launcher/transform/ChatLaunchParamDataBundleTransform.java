package com.ss.android.lark.chatwindow.launcher.transform;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatLaunchParamData;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.LaunchInputParam;
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
public final class ChatLaunchParamDataBundleTransform implements a<ChatLaunchParamData> {
    public final b a;

    @Inject
    public ChatLaunchParamDataBundleTransform(b r2) {
        Intrinsics.checkNotNullParameter(r2, "chatLaunchService");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.a
    public final /* bridge */ /* synthetic */ Object a(ILaunchDataInput r1, BaseBundle r2, Continuation r3) {
        return c((ChatLaunchParamData) r1, r2, r3);
    }

    public final Object c(ChatLaunchParamData r6, BaseBundle r7, Continuation<? super Result<d>> r8) {
        if ((r8 instanceof ChatLaunchParamDataBundleTransform$transform$1) == false) goto L7;
        ChatLaunchParamDataBundleTransform$transform$1 r0 = (ChatLaunchParamDataBundleTransform$transform$1) r8;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Chat r10 = (Chat) r0.L$1;
        r7 = (BaseBundle) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L36:
        ChatBundleV2 r11 = TransformUtils.a(r10, (Chatter) r9, r7);
        Result.Companion r12 = Result.Companion;
        return Result.constructor-impl(new d(r11, r10));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = (BaseBundle) r0.L$0;
        ResultKt.throwOnFailure(r9);
        Object r13 = ((Result) r9).unbox-impl();
    L20:
        if (Result.isFailure-impl(r13) == false) goto L27;
        ErrorResult r14 = Result.exceptionOrNull-impl(r13);
        if (r14 != null) goto L25;
        r14 = new ErrorResult("unknown error");
    L25:
        return Result.constructor-impl(ResultKt.createFailure(r14));
    L27:
        if (Result.isFailure-impl(r13) == false) goto L29;
        r13 = null;
    L29:
        r10 = (Chat) r13;
        if (r10 == null) goto L32;
        CoroutineDispatcher r15 = Dispatchers.getIO();
        ChatLaunchParamDataBundleTransform$transform$chatter$1 r4 = new ChatLaunchParamDataBundleTransform$transform$chatter$1(r10, this, null);
        r0.L$0 = r7;
        r0.L$1 = r10;
        r0.label = 2;
        r9 = BuildersKt.withContext(r15, r4, r0);
        if (r9 != r2) goto L36;
        return r2;
    L32:
        return Result.constructor-impl(ResultKt.createFailure(new ErrorResult("fetch chat failed")));
    L16:
        ResultKt.throwOnFailure(r9);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "launch chat by chatLaunchParamData");
        LaunchInputParam r16 = r6.a;
        String r17 = r16.a;
        String r18 = r16.b;
        r7.c.getClass();
        r0.L$0 = r7;
        r0.label = 1;
        r13 = b(r17, r18, r7, r0);
        if (r13 != r2) goto L20;
        return r2;
    L7:
        r0 = new ChatLaunchParamDataBundleTransform$transform$1(this, r8);
        goto L8
    }

    public final Object b(String r11, String r12, BaseBundle r13, Continuation<? super Result<? extends Chat>> r14) {
        if ((r14 instanceof ChatLaunchParamDataBundleTransform$fetchChat$1) == false) goto L7;
        ChatLaunchParamDataBundleTransform$fetchChat$1 r0 = (ChatLaunchParamDataBundleTransform$fetchChat$1) r14;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L33:
        return ((Result) r15).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        boolean r16 = false;
        if (r12 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == false) goto L29;
        if (r11 != null) goto L24;
    L25:
        r16 = true;
    L26:
        if (r16 == false) goto L29;
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new ErrorResult("chatId and chatterId is empty")));
    L24:
        if (r11.length() != 0) goto L26;
    L29:
        CoroutineDispatcher r18 = Dispatchers.getIO();
        ChatLaunchParamDataBundleTransform$fetchChat$2 r5 = new ChatLaunchParamDataBundleTransform$fetchChat$2(r12, r11, this, r13, null);
        r0.label = 1;
        r15 = BuildersKt.withContext(r18, r5, r0);
        if (r15 != r2) goto L33;
        return r2;
    L17:
        if (r12.length() == 0) goto L20;
        r4 = false;
    L7:
        r0 = new ChatLaunchParamDataBundleTransform$fetchChat$1(this, r14);
        goto L8
    }
}
