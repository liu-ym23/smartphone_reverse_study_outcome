package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatPageStateService;
import com.obric.assistant.chat.q;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.provider.hybrid.QueryChatPageStateFunctionality$call$1", f = "QueryChatPageStateFunctionality.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
public final class QueryChatPageStateFunctionality$call$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.provider.hybrid.QueryChatPageStateFunctionality$call$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.provider.hybrid.QueryChatPageStateFunctionality$call$1$1", f = "QueryChatPageStateFunctionality.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Bundle> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r8);
            boolean r9 = AppHost.a.a().isAppBackground();
            IObricChatPageStateService r0 = (IObricChatPageStateService) ServiceManager.get().getService(IObricChatPageStateService.class);
            if (r0 == null) goto L8;
            q r1 = r0.b();
            if (r1 == null) goto L8;
        L9:
            boolean r2 = r1.c;
            boolean r3 = r1.d;
            boolean r4 = r1.a;
            boolean r5 = r1.b;
            FLogger r6 = FLogger.a;
            StringBuilder r7 = new StringBuilder("ScreenshotExcludeTrace queryChatPageState appForeground=");
            boolean r10 = !r9;
            r7.append(r10);
            r7.append(", isInChatPage=");
            r7.append(r4);
            r7.append(", isMainConversation=");
            r7.append(r5);
            r7.append(", isChatWindow=");
            r7.append(r2);
            r7.append(", isFullScreen=");
            r7.append(r3);
            r6.i("QueryChatPageStateFunctionality", r7.toString());
            Bundle r11 = new Bundle();
            r11.putBoolean("app_is_foreground", r10);
            r11.putBoolean("is_in_chat_page", r4);
            r11.putBoolean("is_main_conversation", r5);
            r11.putBoolean("is_chat_window", r2);
            r11.putBoolean("is_full_screen", r3);
            return r11;
        L8:
            r1 = new q(false, false, false, false);
            goto L9
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public QueryChatPageStateFunctionality$call$1(Continuation<? super QueryChatPageStateFunctionality$call$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new QueryChatPageStateFunctionality$call$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bundle> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Deferred r11 = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(null), 3, null);
        this.label = 1;
        r10 = r11.await(this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
