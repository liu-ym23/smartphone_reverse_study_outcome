package com.larus.voicecall.impl.component.subtitle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.subtitle.RealtimeSubtitleComponent$tryShowPopupMenu$1", f = "RealtimeSubtitleComponent.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeSubtitleComponent$tryShowPopupMenu$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.voicecall.impl.subtitle.c $data;
    final /* synthetic */ CustomMarkdownTextView $view;
    int label;
    final /* synthetic */ RealtimeSubtitleComponent this$0;

    public RealtimeSubtitleComponent$tryShowPopupMenu$1(RealtimeSubtitleComponent r1, CustomMarkdownTextView r2, com.larus.voicecall.impl.subtitle.c r3, Continuation<? super RealtimeSubtitleComponent$tryShowPopupMenu$1> r4) {
        this.this$0 = r1;
        this.$view = r2;
        this.$data = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RealtimeSubtitleComponent$tryShowPopupMenu$1(this.this$0, this.$view, this.$data, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r136) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r136);
        Object r3 = r136;
    L11:
        Message r11 = (Message) r3;
        if (r11 != null) goto L15;
        FLogger.a.i("RealtimeSubtitleComponent", "[tryShowPopupMenu]: message is null");
        return Unit.INSTANCE;
    L15:
        FragmentActivity r7 = s1a.a.c(this.this$0).getActivity();
        if (r7 != null) goto L18;
    L27:
        FLogger.a.i("RealtimeSubtitleComponent", "[tryShowPopupMenu]: activity is null or destroyed or finishing");
        return Unit.INSTANCE;
    L18:
        if (r7.isDestroyed() == true) goto L27;
        if (r7.isFinishing() == true) goto L27;
        FLogger.a.i("RealtimeSubtitleComponent", "[tryShowPopupMenu]: before show pop menu");
        RealtimeSubtitleComponent r4 = this.this$0;
        int r5 = RealtimeSubtitleComponent.J;
        r4.getClass();
        ArrayList r6 = new ArrayList();
        int r8 = v19.c.b(2130971819, null, 2131241946);
        com.larus.bmhome.view.screenmenu.l0 r9 = new com.larus.bmhome.view.screenmenu.l0(2131907405, 2131907405, null, null, null, null, null, null, null, com.larus.bmhome.chat.bean.d.q0(r11), false, null, Integer.valueOf(r8), null, false, false, null, null, "like", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528900, 127);
        int r10 = v19.c.b(2130971815, null, 2131241934);
        r6.add(new com.larus.bmhome.view.screenmenu.y(r9, new com.larus.bmhome.view.screenmenu.l0(2131907403, 2131907403, null, null, null, null, null, null, null, com.larus.bmhome.chat.bean.d.h0(r11), false, null, Integer.valueOf(r10), null, false, false, null, null, "dislike", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528900, 127)));
        FragmentActivity r12 = s1a.a.getActivity(r4);
        Intrinsics.checkNotNullParameter(r12, "context");
        r6.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r12, v19.c.b(2130972086, null, 2131103159))));
        r6.add(new com.larus.bmhome.view.screenmenu.l0(2131907401, 2131907401, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971813, null, 2131241927)), null, false, false, null, null, "copy", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127));
        r6.add(new com.larus.bmhome.view.screenmenu.l0(2131907407, 2131907407, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971828, null, 2131241970)), null, false, false, null, null, "choose_text", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127));
        com.larus.voicecall.impl.component.window.b r13 = (com.larus.voicecall.impl.component.window.b) this.this$0.A.getValue();
        if (r13 == null) goto L26;
        CustomMarkdownTextView r14 = this.$view;
        r13.bw(r14, r6, r14.getClickX(), this.$view.getClickY(), new k0(r7, LifecycleOwnerKt.getLifecycleScope(this.this$0), (com.larus.voicecall.impl.component.feedback.e) this.this$0.B.getValue(), this.$view, r11, this.this$0.p3().H0, this.this$0.H3(), (RealtimeCallParam) this.this$0.p.getValue()));
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r136);
        FLogger.a.i("RealtimeSubtitleComponent", "[tryShowPopupMenu] invoke...");
        CoroutineDispatcher r15 = Dispatchers.getIO();
        RealtimeSubtitleComponent$tryShowPopupMenu$1$message$1 r16 = new RealtimeSubtitleComponent$tryShowPopupMenu$1$message$1(this.$data, null);
        this.label = 1;
        r3 = BuildersKt.withContext(r15, r16, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
