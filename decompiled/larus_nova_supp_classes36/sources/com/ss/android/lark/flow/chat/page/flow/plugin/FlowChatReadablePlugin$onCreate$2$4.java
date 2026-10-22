package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerBannerType;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.FlowChatReadablePlugin$onCreate$2$4", f = "FlowChatReadablePlugin.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
public final class FlowChatReadablePlugin$onCreate$2$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c $chatApp;
    final /* synthetic */ i7b.a $initData;
    final /* synthetic */ BaseStrangerRelationViewModel $it;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c a;
        public final /* synthetic */ i7b.a b;

        public a(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r1, i7b.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            if (((Boolean) r3).booleanValue() == false) goto L6;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.c r5 = this.a;
            i7b.a r6 = this.b;
            m4b.a.a(r6.f, r6.g, w.a(r5).getUserId(), StrangerBannerType.NONE);
        L6:
            return Unit.INSTANCE;
        }
    }

    public FlowChatReadablePlugin$onCreate$2$4(BaseStrangerRelationViewModel r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3, Continuation<? super FlowChatReadablePlugin$onCreate$2$4> r4) {
        this.$it = r1;
        this.$chatApp = r2;
        this.$initData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowChatReadablePlugin$onCreate$2$4(this.$it, this.$chatApp, this.$initData, r5);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MutableSharedFlow r7 = this.$it.getCloseBannerActionFlow();
        a r2 = new a(this.$chatApp, this.$initData);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
