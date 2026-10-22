package com.ss.android.lark.chat.plugin.adapter;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i7b.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "kotlin.jvm.PlatformType"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter$onCreate$1$initData$2", f = "ChatPluginFactoryAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatPluginFactoryAdapter$onCreate$1$initData$2 extends SuspendLambda implements Function2<a, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public ChatPluginFactoryAdapter$onCreate$1$initData$2(Continuation<? super ChatPluginFactoryAdapter$onCreate$1$initData$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ChatPluginFactoryAdapter$onCreate$1$initData$2 r0 = new ChatPluginFactoryAdapter$onCreate$1$initData$2(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(a r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((a) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        if (((a) this.L$0) == null) goto L7;
        boolean r3 = true;
    L9:
        return Boxing.boxBoolean(r3);
    L7:
        r3 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
