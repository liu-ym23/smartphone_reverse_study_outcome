package com.ss.android.lark.chatwindow.launcher.transform;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatterIdLaunchData;
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
public final class ChatterIdBundleTransform implements a<ChatterIdLaunchData> {
    public final b a;

    @Inject
    public ChatterIdBundleTransform(b r2) {
        Intrinsics.checkNotNullParameter(r2, "chatLaunchService");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.a
    public final /* bridge */ /* synthetic */ Object a(ILaunchDataInput r1, BaseBundle r2, Continuation r3) {
        return b((ChatterIdLaunchData) r1, r2, r3);
    }

    public final Object b(ChatterIdLaunchData r8, BaseBundle r9, Continuation<? super Result<d>> r10) {
        if ((r10 instanceof ChatterIdBundleTransform$transform$1) == false) goto L7;
        ChatterIdBundleTransform$transform$1 r0 = (ChatterIdBundleTransform$transform$1) r10;
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
    L19:
        Object r15 = ((Result) r11).unbox-impl();
        if (Result.isFailure-impl(r15) == false) goto L27;
        ErrorResult r16 = Result.exceptionOrNull-impl(r15);
        if (r16 != null) goto L25;
        r16 = new ErrorResult("create chat failed");
    L25:
        return Result.constructor-impl(ResultKt.createFailure(r16));
    L27:
        if (Result.isFailure-impl(r15) == false) goto L29;
        r15 = null;
    L29:
        r12 = (Chat) r15;
        if (r12 == null) goto L32;
        CoroutineDispatcher r17 = Dispatchers.getIO();
        ChatterIdBundleTransform$transform$chatter$1 r4 = new ChatterIdBundleTransform$transform$chatter$1(r12, this, null);
        r0.L$0 = r9;
        r0.L$1 = r12;
        r0.label = 2;
        r11 = BuildersKt.withContext(r17, r4, r0);
        if (r11 != r2) goto L36;
        return r2;
    L32:
        return Result.constructor-impl(ResultKt.createFailure(new ErrorResult("create chat failed")));
    L16:
        ResultKt.throwOnFailure(r11);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "launch chat by chatterId");
        String r18 = r8.a;
        ProfileSource r19 = r9.b.d;
        CoroutineDispatcher r5 = Dispatchers.getIO();
        ChatterIdBundleTransform$transform$createP2pChatResponse$1 r6 = new ChatterIdBundleTransform$transform$createP2pChatResponse$1(this, r18, r19, null);
        r0.L$0 = r9;
        r0.label = 1;
        r11 = BuildersKt.withContext(r5, r6, r0);
        if (r11 != r2) goto L19;
        return r2;
    L7:
        r0 = new ChatterIdBundleTransform$transform$1(this, r10);
        goto L8
    }
}
