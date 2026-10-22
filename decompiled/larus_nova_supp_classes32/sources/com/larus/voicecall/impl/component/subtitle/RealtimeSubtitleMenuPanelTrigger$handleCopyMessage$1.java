package com.larus.voicecall.impl.component.subtitle;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.layout.holder.helper.s0;
import com.larus.im.bean.message.Message;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.subtitle.RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1", f = "RealtimeSubtitleMenuPanelTrigger.kt", i = {}, l = {121, LynxTouchEvent.kPseudoStateFocusTransition}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ k0 this$0;

    public RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1(k0 r1, Message r2, Continuation<? super RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1> r3) {
        this.this$0 = r1;
        this.$msg = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1(this.this$0, this.$msg, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L22:
        t19.s r9 = t19.s.a;
        FragmentActivity r2 = this.this$0.a;
        r9.getClass();
        t19.s.o(r2, 2131910467, false);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        List r10 = (List) r8;
        if (r10 == null) goto L16;
        s0 r3 = ILegacyChatUiServiceDelegate.b.X8();
        if (r3 == null) goto L22;
        FragmentActivity r4 = this.this$0.a;
        this.label = 2;
        if (r3.e(r4, r10, null, this) != r0) goto L22;
        return r0;
    L16:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1$markdownContentList$1 r5 = new RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1$markdownContentList$1(this.this$0, this.$msg, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r11, r5, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
