package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.FlowChatReadablePlugin$onCreate$2$5", f = "FlowChatReadablePlugin.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class FlowChatReadablePlugin$onCreate$2$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c $chatApp;
    final /* synthetic */ BaseStrangerRelationViewModel $it;
    int label;
    final /* synthetic */ FlowChatReadablePlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ FlowChatReadablePlugin a;
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c b;

        public a(FlowChatReadablePlugin r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            int r5 = ((Number) r3).intValue();
            if (r5 <= 0) goto L12;
            FlowChatReadablePlugin r6 = this.a;
            int r0 = FlowChatReadablePlugin.k;
            v r7 = ((BaseChatPlugin) r6).d;
            if (r7 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("chatContainer");
            r7 = null;
        L8:
            jdb.g r8 = r7.C();
            int r1 = l4b.a.a;
            Intrinsics.checkNotNullParameter(r8, "fgService");
            if (r8.isEnable("im.message.stranger") == false) goto L12;
            FlowToast.a r9 = FlowToast.a(this.b.getFragment().requireActivity());
            r9.e(r5);
            r9.c = UDIconUtils.getIconDrawable(r9.a, 2131235465);
            r9.d = 3000;
            r9.a().show();
        L12:
            return Unit.INSTANCE;
        }
    }

    public FlowChatReadablePlugin$onCreate$2$5(BaseStrangerRelationViewModel r1, FlowChatReadablePlugin r2, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3, Continuation<? super FlowChatReadablePlugin$onCreate$2$5> r4) {
        this.$it = r1;
        this.this$0 = r2;
        this.$chatApp = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowChatReadablePlugin$onCreate$2$5(this.$it, this.this$0, this.$chatApp, r5);
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
        MutableSharedFlow r7 = this.$it.getChatChangeToReadable();
        a r2 = new a(this.this$0, this.$chatApp);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
