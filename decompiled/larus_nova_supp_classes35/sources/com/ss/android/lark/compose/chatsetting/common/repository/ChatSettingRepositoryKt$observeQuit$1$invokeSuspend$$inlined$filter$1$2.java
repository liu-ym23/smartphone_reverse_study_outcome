package com.ss.android.lark.compose.chatsetting.common.repository;

import com.lark.kmp.pb.im.v1.PushChatChattersResponse;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatSettingRepositoryKt$observeQuit$1$invokeSuspend$$inlined$filter$1$2<T> implements FlowCollector {
    public final /* synthetic */ FlowCollector a;
    public final /* synthetic */ String b;

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepositoryKt$observeQuit$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepositoryKt$observeQuit$1$invokeSuspend$$inlined$filter$1$2", f = "ChatSettingRepository.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatSettingRepositoryKt$observeQuit$1$invokeSuspend$$inlined$filter$1$2 this$0;

        public AnonymousClass1(ChatSettingRepositoryKt$observeQuit$1$invokeSuspend$$inlined$filter$1$2 r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= PluginList.LEVEL_NOT_SET;
            return this.this$0.emit(null, this);
        }
    }

    public ChatSettingRepositoryKt$observeQuit$1$invokeSuspend$$inlined$filter$1$2(FlowCollector r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object emit(Object r6, Continuation r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
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
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        FlowCollector r9 = this.a;
        if (Intrinsics.areEqual(((PushChatChattersResponse) r6).getChat().getId(), this.b) == false) goto L20;
        r0.label = 1;
        if (r9.emit(r6, r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }
}
