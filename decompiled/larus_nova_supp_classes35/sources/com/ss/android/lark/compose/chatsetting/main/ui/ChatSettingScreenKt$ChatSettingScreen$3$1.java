package com.ss.android.lark.compose.chatsetting.main.ui;

import android.content.Context;
import com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.ui.ChatSettingScreenKt$ChatSettingScreen$3$1", f = "ChatSettingScreen.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSettingScreenKt$ChatSettingScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ChatSettingViewModel $viewModel;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Context a;

        public a(Context r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            ((Boolean) r1).booleanValue();
            int r3 = d8b.a.a;
            d8b.a.a(this.a);
            return Unit.INSTANCE;
        }
    }

    public ChatSettingScreenKt$ChatSettingScreen$3$1(ChatSettingViewModel r1, Context r2, Continuation<? super ChatSettingScreenKt$ChatSettingScreen$3$1> r3) {
        this.$viewModel = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatSettingScreenKt$ChatSettingScreen$3$1(this.$viewModel, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        final i1<com.ss.android.lark.compose.chatsetting.main.viewmodel.a> r6 = this.$viewModel.getUiState();
        Flow r7 = e.n(new ChatSettingScreenKt$ChatSettingScreen$3$1$invokeSuspend$$inlined$map$1(r6));
        a r2 = new a(this.$context);
        this.label = 1;
        Object r8 = r7.collect(new ChatSettingScreenKt$ChatSettingScreen$3$1$invokeSuspend$$inlined$filter$1$2(r2), this);
        if (r8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r8 = Unit.INSTANCE;
    L12:
        if (r8 != r0) goto L15;
        return r0;
    }
}
