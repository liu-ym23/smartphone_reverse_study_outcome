package com.ss.android.lark.chat.core.extension;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.e;
import com.ss.android.lark.chat.chatwindow.chat.perload.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.c;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.b;
import yya.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatCoreRuntimeProvider implements c {
    public static final ChatCoreRuntimeProvider a = null;
    public static final Lazy b = null;

    public ChatCoreRuntimeProvider() {
    }

    static {
        a = new ChatCoreRuntimeProvider();
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ChatCoreRuntimeProvider$proxy$2.INSTANCE);
    }

    public static c j() {
        return (c) b.getValue();
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final Collection<l> c() {
        return j().c();
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final Collection<b> e() {
        return j().e();
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final com.ss.android.lark.chat.core.api.b g() {
        return j().g();
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final Collection<d<? extends u3b.a, ?>> h() {
        return j().h();
    }

    @Override // com.ss.android.lark.chat.core.api.c, com.ss.android.lark.chat.chatwindow.biz.plugin.core.f
    public final e a(i7b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initChat");
        return j().a(r2);
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final com.ss.android.lark.chat.core.api.e i(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        return j().i(r2);
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final Object f(String r5, int r6, Continuation<? super Result<? extends ChatMessageResponse>> r7) {
        if ((r7 instanceof ChatCoreRuntimeProvider$getTeamVisitorChatWindowData$1) == false) goto L7;
        ChatCoreRuntimeProvider$getTeamVisitorChatWindowData$1 r0 = (ChatCoreRuntimeProvider$getTeamVisitorChatWindowData$1) r7;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        c r9 = j();
        r0.label = 1;
        Object r10 = r9.f(r5, r6, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new ChatCoreRuntimeProvider$getTeamVisitorChatWindowData$1(this, r7);
        goto L8
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final Object b(com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r5, String r6, int r7, Continuation<? super Result<? extends ChatMessageResponse>> r8) {
        if ((r8 instanceof ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1) == false) goto L7;
        ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1 r0 = (ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1) r8;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
        return ((Result) r9).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        c r10 = j();
        r0.label = 1;
        Object r11 = r10.b(r5, r6, r7, r0);
        if (r11 != r2) goto L18;
        return r2;
    L18:
        return r11;
    L7:
        r0 = new ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1(this, r8);
        goto L8
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final x4b.c d(v r8, m2b.a r9, boolean r10, boolean r11, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r12) {
        Intrinsics.checkNotNullParameter(r8, "chatContainer");
        return j().d(r8, r9, r10, r11, r12);
    }
}
