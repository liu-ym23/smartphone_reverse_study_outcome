package com.obric.assistant.block.common.reference_msg;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OReferenceMsgBlock;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.block.common.reference_msg.view.ObricChatReplyHeaderView;
import java.util.Iterator;
import java.util.List;
import kc8.y;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends com.obric.assistant.block.base.c<com.obric.assistant.block.common.reference_msg.a> {
    public final CoroutineScope e;
    public ObricChatReplyHeaderView f;
    public Job g;

    public static final class a {
    }

    static {
    }

    public final void i() {
        FLogger.a.i("ReferenceMsgBlockHolder", "onViewRecycled");
        Job r0 = this.g;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.g = null;
    }

    public d() {
        this.e = CoroutineScopeKt.MainScope();
    }

    @Override // com.obric.assistant.block.base.c
    public final void g(jc8.a r21) {
        final com.obric.assistant.block.common.reference_msg.a r5 = (com.obric.assistant.block.common.reference_msg.a) r21;
        Intrinsics.checkNotNullParameter(r5, "blockModel");
        super.g(r5);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("onBindBlockView, blockModel: ");
        BlockContent r3 = ((jc8.a) r5).a.getContent();
        Message r4 = null;
        Object r6 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        if (r3 == null) goto L5;
        OReferenceMsgBlock r7 = r3.getOReferenceMsgBlock();
    L6:
        r2.append(r7);
        r1.i("ReferenceMsgBlockHolder", r2.toString());
        Job r8 = this.g;
        boolean r9 = true;
        if (r8 == null) goto L9;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L9:
        this.g = null;
        final ObricChatReplyHeaderView r10 = this.f;
        if (r10 != null) goto L12;
        r1.w("ReferenceMsgBlockHolder", "replyHeaderView is null");
        return;
    L12:
        final String r11 = ((jc8.a) r5).a.getBlockId();
        String r12 = NameKeys.UnloadStrategy_No_Strategy;
        if (r11 != null) goto L15;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        BlockContent r13 = ((jc8.a) r5).a.getContent();
        if (r13 == null) goto L85;
        final OReferenceMsgBlock r14 = r13.getOReferenceMsgBlock();
        if (r14 == null) goto L85;
        String r15 = r14.referencedMessageId;
        if (r15 != null) goto L24;
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L24:
        if (r15.length() != 0) goto L26;
        boolean r16 = true;
    L27:
        if (r16 == false) goto L29;
        r1.w("ReferenceMsgBlockHolder", "refMsgId is empty, blockId: ".concat(r11));
        e1.o(r10);
        return;
    L29:
        kc8.b r17 = jc8.c.a(this, kc8.b.class);
        if (r17 == null) goto L84;
        y r18 = r17.a;
        if (r18 == null) goto L84;
        q0 r19 = r18.x;
        if (r19 == null) goto L84;
        j19.c.f(r10);
        boolean r110 = o0.d(r14.clickAction);
        r1.i("ReferenceMsgBlockHolder", "refMsgId = " + r15 + ", hasClickIntent: " + r110);
        if (r110 == false) goto L41;
        View r20 = r10.getClickView();
        if (r20 == null) goto L44;
        e1.d(r20, new b(r14, r10, r5, r11));
    L44:
        View r22 = r10.getClickView();
        if (r22 == null) goto L47;
        r22.setOnLongClickListener(new c(this));
    L47:
        kc8.b r23 = jc8.c.a(this, kc8.b.class);
        if (r23 == null) goto L66;
        y r24 = r23.a;
        if (r24 == null) goto L66;
        Fragment r25 = r24.a;
        if (r25 == null) goto L66;
        t1a.b r26 = s1a.a.g(r25);
        if (r26 == null) goto L66;
        u7 r27 = r26.getAbility(u7.class);
        if (r27 == null) goto L66;
        List r28 = r27.zj();
        if (r28 == null) goto L66;
        Iterator r29 = r28.iterator();
    L61:
        if (r29.hasNext() == false) goto L65;
        Object r30 = r29.next();
        if (Intrinsics.areEqual(r15, ((Message) r30).getMessageId()) == false) goto L61;
        r6 = r30;
    L65:
        r4 = (Message) r6;
    L66:
        if (r4 == null) goto L79;
        FLogger.a.i("ReferenceMsgBlockHolder", "found ref msg: " + r4);
        if (com.larus.bmhome.chat.bean.d.U(r4) == false) goto L73;
        String r31 = com.larus.bmhome.chat.bean.d.H(r4);
        if (r31 == null) goto L75;
        r12 = r31;
    L75:
        if (r19.I7() != null) goto L78;
        r9 = false;
    L78:
        r10.a(r12, Boolean.valueOf(r9), com.larus.bmhome.chat.bean.d.G0(r5.j()), r110);
        return;
    L73:
        r12 = r10.getContext().getString(2131908670);
        Intrinsics.checkNotNull(r12);
        goto L75
    L79:
        FLogger.a.i("ReferenceMsgBlockHolder", "not found ref msg");
        if (r19.I7() != null) goto L83;
        r9 = false;
    L83:
        r10.a(NameKeys.UnloadStrategy_No_Strategy, Boolean.valueOf(r9), com.larus.bmhome.chat.bean.d.G0(r5.j()), r110);
        this.g = BuildersKt.launch$default(this.e, null, null, new ReferenceMsgBlockHolder$onBindBlockView$3(r15, r10, r19, r5, r110, null), 3, null);
        return;
    L41:
        View r32 = r10.getClickView();
        if (r32 == null) goto L44;
        r32.setOnClickListener(null);
    L84:
        r1.w("ReferenceMsgBlockHolder", "msgAdapter is null, blockId: ".concat(r11));
        e1.o(r10);
        return;
    L26:
        r16 = false;
    L85:
        r1.w("ReferenceMsgBlockHolder", "refBlock is null, blockId: ".concat(r11));
        e1.o(r10);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final View h(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        FLogger.a.i("ReferenceMsgBlockHolder", "onCreatedBlockView");
        ObricChatReplyHeaderView r0 = new ObricChatReplyHeaderView(r5.getContext(), null, 6, 0);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f = r0;
        return r0;
    }
}
