package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.team.TeamUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import w3b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatDataPreLoaderV2 implements c<w3b.a, i7b.a> {
    public static final /* synthetic */ int d = 0;
    public final ImSdkChatService a;
    public final p b;
    public final com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c
    public final /* bridge */ /* synthetic */ Object a(d r1, Continuation<? super Result<? extends i7b.a>> r2) {
        return d((w3b.a) r1, r2);
    }

    public final Object c(String r7, Continuation<? super Result<? extends Chat>> r8) {
        if ((r8 instanceof ChatDataPreLoaderV2$fetchP2PChatIfNeed$1) == false) goto L7;
        ChatDataPreLoaderV2$fetchP2PChatIfNeed$1 r0 = (ChatDataPreLoaderV2$fetchP2PChatIfNeed$1) r8;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L30:
        return ((Result) r9).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r0.L$0 = r7;
        r0.label = 1;
        final SafeContinuation r11 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
        Chat r4 = this.a.xc(r7);
        if (r4 == null) goto L17;
        r11.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(r4))));
    L24:
        r9 = r11.getOrThrow();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L27:
        if (r9 != r2) goto L30;
        return r2;
    L17:
        final CountDownLatch r5 = new CountDownLatch(1);
        this.a.X5(r7, null, new ChatDataPreLoaderV2$fetchP2PChatIfNeed$2$1(r5, r11));
    L22:
        e = move-exception;
        r11.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(null))));
        e.printStackTrace();
        goto L24
    L19:
        if (r5.await(30000, TimeUnit.MILLISECONDS) == true) goto L24;
        r11.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(null))));     // Catch: InterruptedException -> L22
    L7:
        r0 = new ChatDataPreLoaderV2$fetchP2PChatIfNeed$1(this, r8);
        goto L8
    }

    public final Object d(w3b.a r14, Continuation<? super Result<? extends i7b.a>> r15) {
        if ((r15 instanceof ChatDataPreLoaderV2$preLoadData$1) == false) goto L7;
        ChatDataPreLoaderV2$preLoadData$1 r0 = (ChatDataPreLoaderV2$preLoadData$1) r15;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        com.ss.android.lark.chat.entity.chat.b r8 = null;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ErrorResult r17 = (ErrorResult) r0.L$2;
        String r5 = (String) r0.L$1;
        w3b.a r6 = (w3b.a) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L57:
        ChatWindowPrepareData r18 = (ChatWindowPrepareData) r16;
        w3b.a r7 = r6;
        String r9 = r5;
    L59:
        if (r18 != null) goto L61;
        Log.e("ChatDataPreLoaderV2", "getChatLauncherInfo failed, chatId is:" + r9);
    L61:
        if (r17 != null) goto L80;
        if (r18 == null) goto L64;
        Chat r10 = r18.chat;
    L65:
        if (r10 != null) goto L68;
        r17 = new ErrorResult(1);
        goto L80
    L68:
        if (r18.chat.getRole() == Chat.Role.MEMBER) goto L71;
        r4 = false;
    L71:
        boolean r11 = r18.chat.getHasVCChatPermission();
        if (r4 == true) goto L80;
        if (r11 == true) goto L80;
        fxa.b r19 = r7.a;
        TeamUtils.b(r18.chat);
        String r110 = r7.c;
        if (r110 == null) goto L77;
        r8 = this.a.I0(r110);
    L77:
        if (r8 == null) goto L79;
        r17 = new ErrorResult(4, r8.b);
        goto L80
    L79:
        r17 = new ErrorResult(3);
        goto L80
    L64:
        r10 = null;
    L80:
        i7b.a r111 = i7b.a.b(r7.f, r18);
        ChatCoreModule.a().getPerfEnterChatMonitor().h(false);
        if (r17 == null) goto L85;
        Result.Companion r112 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(r17));
    L85:
        return Result.constructor-impl(r111);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r17 = (ErrorResult) r0.L$2;
        r9 = (String) r0.L$1;
        r7 = (w3b.a) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L52:
        if (r9 == null) goto L58;
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b r113 = this.c;
        r0.L$0 = r7;
        r0.L$1 = r9;
        r0.L$2 = r17;
        r0.label = 3;
        r16 = r113.a(r9, r0);
        if (r16 != r2) goto L56;
        return r2;
    L56:
        r5 = r9;
        r6 = r7;
        goto L57
    L58:
        r18 = null;
        goto L59
    L17:
        String r114 = (String) r0.L$2;
        r9 = (String) r0.L$1;
        w3b.a r12 = (w3b.a) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L37:
        ErrorResult r115 = (ErrorResult) r16;
        w3b.a r13 = r12;
        String r20 = r114;
        r14 = r13;
    L40:
        if (TextUtils.isEmpty(r20) == true) goto L51;
        r0.L$0 = r14;
        r0.L$1 = r9;
        r0.L$2 = r115;
        r0.label = 2;
        if (r20 != null) goto L44;
        Unit r21 = Unit.INSTANCE;
    L49:
        if (r21 != r2) goto L51;
        return r2;
    L44:
        Message r22 = (Message) this.b.ta(CollectionsKt.listOf(r20)).get(r20);
        if (r22 == null) goto L47;
        int r23 = r22.getPosition();
        r14.f.r(r23);
        Log.i("ChatDataPreloadTaskV2", "setShowPosition:" + r23);
    L48:
        r21 = Unit.INSTANCE;
        goto L49
    L47:
        Log.e("ChatDataPreLoaderV2", "load init message position failed: ".concat(r20));
    L51:
        r7 = r14;
        r17 = r115;
        goto L52
    L18:
        ResultKt.throwOnFailure(r16);
        ChatCoreModule.a().getPerfEnterChatMonitor().h(true);
        String r116 = r14.e;
        r9 = r14.c;
        r20 = r14.d;
        if (r116 != null) goto L21;
    L24:
        boolean r117 = true;
    L25:
        if (r117 == true) goto L38;
        if (r9 != null) goto L28;
    L31:
        boolean r118 = true;
    L32:
        if (r118 == false) goto L38;
        Log.e("ChatDataPreLoaderV2", "should not fetch p2pChat in chatPreloader", new RuntimeException("should not fetch p2pChat in chatPreloader"), true);
        r0.L$0 = r14;
        r0.L$1 = r9;
        r0.L$2 = r20;
        r0.label = 1;
        r16 = b(this, r116, r14, r0);
        if (r16 != r2) goto L36;
        return r2;
    L36:
        r12 = r14;
        r114 = r20;
        goto L37
    L28:
        if (r9.length() == 0) goto L31;
        r118 = false;
    L38:
        r115 = null;
        goto L40
    L21:
        if (r116.length() == 0) goto L24;
        r117 = false;
    L7:
        r0 = new ChatDataPreLoaderV2$preLoadData$1(this, r15);
        goto L8
    }

    @Inject
    public ChatDataPreLoaderV2(ImSdkChatService r2, p r3, com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b r4) {
        Intrinsics.checkNotNullParameter(r2, "chatService");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "prepareDataLoader");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final Object b(ChatDataPreLoaderV2 r6, String r7, w3b.a r8, Continuation<? super ErrorResult> r9) {
        if ((r9 instanceof ChatDataPreLoaderV2$fetchP2PChat$1) == false) goto L7;
        ChatDataPreLoaderV2$fetchP2PChat$1 r0 = (ChatDataPreLoaderV2$fetchP2PChat$1) r9;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        ErrorResult r4 = null;
        boolean r5 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (w3b.a) r0.L$0;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L19:
        Result r12 = Result.box-impl(r11);
    L22:
        if (r12 != null) goto L24;
    L26:
        boolean r13 = false;
    L28:
        if (r13 == false) goto L38;
        Object r14 = r12.unbox-impl();
        if (Result.isFailure-impl(r14) == false) goto L32;
        r14 = null;
    L32:
        Chat r15 = (Chat) r14;
        if (r15 == null) goto L37;
        String r16 = r15.getId();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r16, "chatId");
        r8.c = r16;
        r8.f.z(r16);
        Log.i("ChatDataPreloadTaskV2", "setChatId:" + r16);
        return null;
    L37:
        return new ErrorResult(2);
    L38:
        if (r12 == null) goto L40;
        Throwable r17 = Result.exceptionOrNull-impl(r12.unbox-impl());
    L42:
        if ((r17 instanceof ErrorResult) == false) goto L44;
        r4 = (ErrorResult) r17;
    L44:
        if (r4 != null) goto L46;
    L48:
        boolean r18 = false;
    L49:
        if (r18 == true) goto L59;
        if (r4 != null) goto L52;
    L54:
        r5 = false;
    L55:
        if (r5 == false) goto L58;
        return r4;
    L58:
        return new ErrorResult(2);
    L52:
        if (r4.getErrorCode() != 5013) goto L54;
    L59:
        return r4;
    L46:
        if (r4.getErrorCode() != 4051) goto L48;
        r18 = true;
        goto L49
    L40:
        r17 = null;
        goto L42
    L24:
        if (Result.isSuccess-impl(r12.unbox-impl()) != true) goto L26;
        r13 = true;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (r7 == null) goto L20;
        r0.L$0 = r8;
        r0.label = 1;
        r11 = r6.c(r7, r0);
        if (r11 != r2) goto L19;
        return r2;
    L20:
        r12 = null;
    L7:
        r0 = new ChatDataPreLoaderV2$fetchP2PChat$1(this, r9);
        goto L8
    }
}
