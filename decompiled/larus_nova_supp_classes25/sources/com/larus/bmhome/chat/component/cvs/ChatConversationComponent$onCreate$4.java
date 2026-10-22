package com.larus.bmhome.chat.component.cvs;

import androidx.fragment.app.Fragment;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.ChatDoubleTabFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.immerse.ChatImmersActivity;
import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.platform.model.showcase.Case;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import va8.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onCreate$4", f = "ChatConversationComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationComponent$onCreate$4 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatConversationComponent this$0;

    public ChatConversationComponent$onCreate$4(ChatConversationComponent r1, Continuation<? super ChatConversationComponent$onCreate$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatConversationComponent$onCreate$4 r0 = new ChatConversationComponent$onCreate$4(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (Continuation) r2);
    }

    public final Object invoke(String r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L91;
        ResultKt.throwOnFailure(r9);
        String r10 = (String) this.L$0;
        ChatConversationComponent r0 = this.this$0;
        int r1 = ChatConversationComponent.r;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        com.larus.bmhome.chat.component.immerse.a r2 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(r0, r0)).getAbility(com.larus.bmhome.chat.component.immerse.a.class);
        if (r2 == null) goto L7;
        ChatImmersFragment r3 = r2.Z5();
    L8:
        int r4 = 1;
        boolean r5 = false;
        if (r3 == null) goto L26;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        com.larus.bmhome.chat.component.immerse.a r6 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(r0, r0)).getAbility(com.larus.bmhome.chat.component.immerse.a.class);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r0, r0).isResumed() == true) goto L25;
        if (r6 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L27;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(r0, r0).getActivity() instanceof ChatImmersActivity) == true) goto L25;
        if (r3.C != true) goto L23;
        boolean r8 = true;
    L24:
        if (r8 == false) goto L27;
    L23:
        r8 = false;
    L27:
        de8.c r11 = this.this$0.f1();
        if (r11 != null) goto L30;
    L32:
        boolean r12 = false;
    L33:
        if (r12 == false) goto L35;
    L84:
        Iterator r13 = ((CopyOnWriteArrayList) this.this$0.p).iterator();
    L86:
        if (r13.hasNext() == false) goto L89;
        ((va8.z) r13.next()).k2(r10);
        goto L86
    L89:
        return Unit.INSTANCE;
    L35:
        if (com.larus.bmhome.b0.b(s1a.a.c(this.this$0)) == false) goto L84;
        if (o0.d(r10) == false) goto L84;
        com.larus.bmhome.chat.component.showcase.x r14 = (com.larus.bmhome.chat.component.showcase.x) this.this$0.m.getValue();
        if (r14 != null) goto L41;
    L43:
        boolean r15 = false;
    L45:
        if (r15 == false) goto L59;
        com.larus.bmhome.chat.component.showcase.x r16 = (com.larus.bmhome.chat.component.showcase.x) this.this$0.m.getValue();
        if (r16 == null) goto L51;
        Case r17 = r16.mz(false);
        if (r17 == null) goto L51;
        String r18 = r17.getCaseId();
    L53:
        if (o0.d(r18) == false) goto L84;
        FLogger.a.i("ChatConversationComponent", "selectSideBarCase " + r18);
        com.larus.bmhome.a0 r19 = com.larus.bmhome.b0.a(s1a.a.c(this.this$0));
        if (r19 == null) goto L84;
        if (r18 != null) goto L58;
        r18 = "";
    L58:
        r19.J90(12, null, r18, "chat_conversation");
    L51:
        r18 = null;
        goto L53
    L59:
        f0 r20 = (f0) this.this$0.n.getValue();
        if (r20 != null) goto L62;
    L64:
        boolean r21 = false;
    L65:
        if (r21 == true) goto L84;
        f0 r22 = (f0) this.this$0.n.getValue();
        if (r22 != null) goto L69;
    L71:
        if (r5 == true) goto L84;
        FLogger.a.i("ChatConversationComponent", "selectSideBarConversation " + r10);
        Fragment r23 = s1a.a.c(this.this$0).getParentFragment();
        if ((r23 instanceof ChatImmersFragment) == false) goto L76;
        r4 = 8;
    L81:
        com.larus.bmhome.a0 r24 = com.larus.bmhome.b0.a(s1a.a.c(this.this$0));
        if (r24 == null) goto L84;
        r24.J90(r4, null, r10, "chat_conversation");
        goto L84
    L76:
        if ((r23 instanceof ChatDoubleTabFragment) == false) goto L79;
        r4 = 10;
        goto L81
    L79:
        if ((r23 instanceof ci8.d) == false) goto L81;
        r4 = 15;
        goto L81
    L69:
        if (r22.aD() != true) goto L71;
        r5 = true;
        goto L71
    L62:
        if (r20.R() != true) goto L64;
        r21 = true;
        goto L65
    L41:
        if (r14.e6() != true) goto L43;
        r15 = true;
        goto L45
    L30:
        if (r11.o == true) goto L32;
        r12 = true;
        goto L33
    L14:
        if (r6.b50() != true) goto L16;
        r7 = true;
    L25:
        AudioServiceDelegate.a.i0().b(r10);
        goto L27
    L26:
        AudioServiceDelegate.a.i0().b(r10);
        goto L27
    L7:
        r3 = null;
        goto L8
    L91:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
