package com.larus.doc.impl;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockType;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$querySubConvLatestDocMsgId$1", f = "DocFragment.kt", i = {0}, l = {915}, m = "invokeSuspend", n = {"docMessage"}, s = {"L$1"})
public final class DocFragment$querySubConvLatestDocMsgId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DocFragment this$0;

    public DocFragment$querySubConvLatestDocMsgId$1(DocFragment r1, Continuation<? super DocFragment$querySubConvLatestDocMsgId$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DocFragment$querySubConvLatestDocMsgId$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r4 = null;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        Message r2 = (Message) this.L$1;
        DocFragment r3 = (DocFragment) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L94
    L62:
        Iterator r14 = ((List) r13).iterator();     // Catch: Exception -> L94
    L64:
        if (r14.hasNext() == false) goto L80;
        Object r6 = r14.next();     // Catch: Exception -> L94
        Iterator r7 = com.larus.im.bean.message.a.d((Message) r6).iterator();     // Catch: Exception -> L94
    L67:
        if (r7.hasNext() == false) goto L74;
        Object r8 = r7.next();     // Catch: Exception -> L94
        if (((Block) r8).getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L71;
        boolean r9 = true;
    L72:
        if (r9 == false) goto L67;
    L75:
        if (r8 == null) goto L77;
        boolean r10 = true;
    L78:
        if (r10 == false) goto L64;
    L81:
        Message r11 = (Message) r6;     // Catch: Exception -> L94
        if (r11 == null) goto L84;
        String r15 = r11.getMessageId();     // Catch: Exception -> L94
    L85:
        r3.F = r15;     // Catch: Exception -> L94
        FLogger r16 = FLogger.a;     // Catch: Exception -> L94
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L94
        r5.append("Message From DB: ");     // Catch: Exception -> L94
        if (r11 == null) goto L88;
        String r12 = r11.getMessageId();     // Catch: Exception -> L94
    L89:
        r5.append(r12);     // Catch: Exception -> L94
        r5.append(",  Message From Memory: ");     // Catch: Exception -> L94
        if (r2 == null) goto L92;
        r4 = r2.getMessageId();     // Catch: Exception -> L94
    L92:
        r5.append(r4);     // Catch: Exception -> L94
        r16.i("DocFragment", r5.toString());     // Catch: Exception -> L94
    L97:
        return Unit.INSTANCE;
    L88:
        r12 = null;
        goto L89
    L84:
        r15 = null;
        goto L85
    L77:
        r10 = false;
        goto L78
    L71:
        r9 = false;
        goto L72
    L74:
        r8 = null;
        goto L75
    L80:
        r6 = null;
        goto L81
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);
        Fragment r17 = this.this$0.h;     // Catch: Exception -> L94
        if (r17 != null) goto L14;
    L16:
        boolean r18 = false;
    L17:
        if (r18 == false) goto L97;
        Fragment r110 = this.this$0.h;     // Catch: Exception -> L94
        if (r110 == null) goto L25;
        t1a.b r111 = s1a.a.g(r110);     // Catch: Exception -> L94
        if (r111 == null) goto L25;
        com.larus.bmhome.chat.component.cvs.y r112 = r111.getAbility(com.larus.bmhome.chat.component.cvs.y.class);     // Catch: Exception -> L94
        if (r112 == null) goto L25;
        wc9.e r113 = r112.h();     // Catch: Exception -> L94
    L26:
        if (r113 == null) goto L97;
        if (ic8.n.r(r113) == true) goto L97;
        if (ic8.n.v(r113) == true) goto L97;
        Fragment r20 = this.this$0.h;     // Catch: Exception -> L94
        if (r20 == null) goto L97;
        t1a.b r21 = s1a.a.g(r20);     // Catch: Exception -> L94
        if (r21 == null) goto L97;
        u7 r22 = r21.getAbility(u7.class);     // Catch: Exception -> L94
        if (r22 == null) goto L97;
        MessageAdapter r23 = r22.MF();     // Catch: Exception -> L94
        if (r23 == null) goto L97;
        List r24 = r23.getCurrentList();     // Catch: Exception -> L94
        DocFragment r25 = this.this$0;     // Catch: Exception -> L94
        Iterator r26 = r24.iterator();     // Catch: Exception -> L94
    L41:
        if (r26.hasNext() == false) goto L57;
        Object r27 = r26.next();     // Catch: Exception -> L94
        Iterator r28 = com.larus.im.bean.message.a.d((Message) r27).iterator();     // Catch: Exception -> L94
    L44:
        if (r28.hasNext() == false) goto L51;
        Object r30 = r28.next();     // Catch: Exception -> L94
        if (((Block) r30).getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L48;
        boolean r114 = true;
    L49:
        if (r114 == false) goto L44;
    L52:
        if (r30 == null) goto L54;
        boolean r31 = true;
    L55:
        if (r31 == false) goto L41;
    L58:
        Message r32 = (Message) r27;     // Catch: Exception -> L94
        IChatRepoService r33 = zh8.a.a;     // Catch: Exception -> L94
        String r115 = r113.a;     // Catch: Exception -> L94
        this.L$0 = r25;     // Catch: Exception -> L94
        this.L$1 = r32;     // Catch: Exception -> L94
        this.label = 1;     // Catch: Exception -> L94
        r13 = r33.o1(r115, 20, this);     // Catch: Exception -> L94
        if (r13 != r0) goto L61;
        return r0;
    L61:
        r2 = r32;
        r3 = r25;
        goto L62
    L54:
        r31 = false;
        goto L55
    L48:
        r114 = false;
        goto L49
    L51:
        r30 = null;
        goto L52
    L57:
        r27 = null;
    L25:
        r113 = null;
        goto L26
    L14:
        if (r17.isAdded() != true) goto L16;
        r18 = true;
    L94:
        e = move-exception;
        FLogger.a.e("DocFragment", e.getMessage(), e);
        goto L97
    }
}
