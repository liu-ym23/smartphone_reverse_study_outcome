package com.ss.android.lark.chatwindow.launcher;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatBundleInput;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.ChatLauncherV2$openChatActual$1", f = "ChatLauncherV2.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
final class ChatLauncherV2$openChatActual$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<c.a> $callback;
    final /* synthetic */ ChatBundleInput $chatBundleInput;
    final /* synthetic */ Context $context;
    final /* synthetic */ Fragment $fragment;
    int label;
    final /* synthetic */ ChatLauncherV2 this$0;

    public ChatLauncherV2$openChatActual$1(ChatBundleInput r1, ChatLauncherV2 r2, Context r3, Fragment r4, IGetDataCallback<c.a> r5, Continuation<? super ChatLauncherV2$openChatActual$1> r6) {
        this.$chatBundleInput = r1;
        this.this$0 = r2;
        this.$context = r3;
        this.$fragment = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatLauncherV2$openChatActual$1(this.$chatBundleInput, this.this$0, this.$context, this.$fragment, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        c.b r7 = (c.b) r6;
        if ((r7 instanceof c.b.C0118b) == false) goto L17;
        IGetDataCallback<c.a> r2 = this.$callback;
        if (r2 == null) goto L22;
        r2.onSuccess(((c.b.C0118b) r7).a);
    L22:
        return Unit.INSTANCE;
    L17:
        if ((r7 instanceof c.b.a) == false) goto L24;
        IGetDataCallback<c.a> r3 = this.$callback;
        if (r3 == null) goto L22;
        r3.onError(new ErrorResult(((c.b.a) r7).a));
        goto L22
    L24:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "openChat: start open chat " + this.$chatBundleInput.i.x0());
        ChatLauncherV2 r8 = this.this$0;
        Context r4 = this.$context;
        Fragment r5 = this.$fragment;
        ChatBundleInput r9 = this.$chatBundleInput;
        this.label = 1;
        r6 = r8.a(r4, r5, r9, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
