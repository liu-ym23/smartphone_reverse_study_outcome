package com.larus.voicecall.impl.component.subtitle;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.subtitle.RealtimeSubtitleMenuPanelTrigger$handleDislikeMessage$1", f = "RealtimeSubtitleMenuPanelTrigger.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeSubtitleMenuPanelTrigger$handleDislikeMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ k0 this$0;

    public RealtimeSubtitleMenuPanelTrigger$handleDislikeMessage$1(k0 r1, Continuation<? super RealtimeSubtitleMenuPanelTrigger$handleDislikeMessage$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeSubtitleMenuPanelTrigger$handleDislikeMessage$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L20:
        Message r11 = (Message) r10;
    L47:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Message r12 = this.this$0.e;
        if (r12 != null) goto L11;
    L13:
        boolean r13 = false;
    L14:
        if (r13 == false) goto L21;
        k0 r14 = this.this$0;
        com.larus.voicecall.impl.component.feedback.e r2 = r14.c;
        if (r2 == null) goto L47;
        Message r15 = r14.e;
        this.label = 1;
        r10 = r2.eE(r15, this);
        if (r10 != r0) goto L20;
        return r0;
    L21:
        final k0 r16 = this.this$0;
        r16.getClass();
        com.larus.bmhome.chat.api.e0 r3 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r3 == null) goto L24;
        LaunchInfo r4 = r3.a;
    L25:
        ArrayList r5 = new ArrayList();
        if (r4 == null) goto L39;
        List r6 = r4.G0();
        if (r6 == null) goto L39;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L31:
        if (r8.hasNext() == false) goto L38;
        Object r9 = r8.next();
        if (((FeedbackMeta) r9).c() != MsgFeedbackType.MsgFeedbackTypeDislike.value) goto L35;
        boolean r17 = true;
    L36:
        if (r17 == false) goto L31;
        r7.add(r9);
        goto L31
    L35:
        r17 = false;
        goto L36
    L38:
        r5.addAll(r7);
    L39:
        if (r4 == null) goto L42;
        String r18 = r4.H0();
        if (r18 == null) goto L42;
    L43:
        com.larus.voicecall.impl.component.feedback.e r19 = r16.c;
        if (r19 == null) goto L47;
        FragmentActivity r20 = r16.a;
        r19.no(r20, r20.getSupportFragmentManager(), new com.larus.voicecall.impl.component.feedback.a(r5, r18, r16.e), new RealtimeSubtitleMenuPanelTrigger$tryShowDetailDialogAndDislike$3(r16));
    L42:
        r18 = NameKeys.UnloadStrategy_No_Strategy;
        goto L43
    L24:
        r4 = null;
        goto L25
    L11:
        if (com.larus.bmhome.chat.bean.d.h0(r12) != true) goto L13;
        r13 = true;
        goto L14
    }
}
