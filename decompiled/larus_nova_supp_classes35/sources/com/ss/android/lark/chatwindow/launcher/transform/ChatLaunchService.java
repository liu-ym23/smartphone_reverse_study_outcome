package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class ChatLaunchService implements b {
    public final ImSdkChatService a;
    public final h b;

    @Inject
    public ChatLaunchService(ImSdkChatService r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "chatService");
        Intrinsics.checkNotNullParameter(r3, "chatterService");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.b
    public final Object b(String r5, Continuation<? super Result<? extends Chat>> r6) {
        if ((r6 instanceof ChatLaunchService$fetchChat$1) == false) goto L7;
        ChatLaunchService$fetchChat$1 r0 = (ChatLaunchService$fetchChat$1) r6;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L23:
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = r5;
        r0.label = 1;
        j r9 = new j(IntrinsicsKt.intercepted(r0), 1);
        r9.C();
        Chat r4 = this.a.we(r5);
        if (r4 != null) goto L17;
        r4 = this.a.B2(r5);
    L17:
        r9.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(r4))));
        r7 = r9.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L20:
        if (r7 != r2) goto L23;
        return r2;
    L7:
        r0 = new ChatLaunchService$fetchChat$1(this, r6);
        goto L8
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.b
    public final Object c(String r5, Continuation<? super Result<? extends Chatter>> r6) {
        if ((r6 instanceof ChatLaunchService$getChatterById$1) == false) goto L7;
        ChatLaunchService$getChatterById$1 r0 = (ChatLaunchService$getChatterById$1) r6;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L20:
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = r5;
        r0.label = 1;
        j r9 = new j(IntrinsicsKt.intercepted(r0), 1);
        r9.C();
        r9.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(this.b.ue(r5)))));
        r7 = r9.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L17:
        if (r7 != r2) goto L20;
        return r2;
    L7:
        r0 = new ChatLaunchService$getChatterById$1(this, r6);
        goto L8
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.b
    public final Object a(String r6, ProfileSource r7, Continuation<? super Result<? extends Chat>> r8) {
        if ((r8 instanceof ChatLaunchService$getOrCreateP2PChat$1) == false) goto L7;
        ChatLaunchService$getOrCreateP2PChat$1 r0 = (ChatLaunchService$getOrCreateP2PChat$1) r8;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ProfileSource r10 = (ProfileSource) r0.L$1;
        String r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L24:
        return ((Result) r9).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.label = 1;
        final j r12 = new j(IntrinsicsKt.intercepted(r0), 1);
        r12.C();
        Chat r4 = this.a.xc(r6);
        if (r4 == null) goto L17;
        r12.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(r4))));
    L18:
        r9 = r12.B();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L21:
        if (r9 != r2) goto L24;
        return r2;
    L17:
        this.a.X5(r6, new ImSdkChatService.a(false, r7), new ChatLaunchService$getOrCreateP2PChat$2$1(r12));
    L7:
        r0 = new ChatLaunchService$getOrCreateP2PChat$1(this, r8);
        goto L8
    }
}
