package com.larus.bmhome.chat.list.cell.generate_image;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.adapter.h0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.list.u7$a;
import com.larus.bmhome.chat.component.showcase.x;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.image.i0;
import com.larus.bmhome.chat.list.cell.progress_loading.BaseProgressLoadingCell;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.n0;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lf8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class GenerateImageCell$c implements i0 {
    public final /* synthetic */ GenerateImageCell a;

    public GenerateImageCell$c(GenerateImageCell r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final boolean b(Message r7) {
        boolean r0 = false;
        if (r7 == null) goto L22;
        q0 r1 = a.b(this.a);
        Boolean r2 = null;
        if (r1 == null) goto L7;
        String r3 = r1.W();
    L8:
        com.larus.bmhome.instruction.g r4 = (com.larus.bmhome.instruction.g) this.a.s.getValue();
        if (r4 == null) goto L11;
        List r5 = r4.tq();
    L12:
        com.larus.bmhome.chat.component.collection.o r6 = (com.larus.bmhome.chat.component.collection.o) this.a.u.getValue();
        if (r6 == null) goto L15;
        r2 = Boolean.valueOf(r6.i0());
    L15:
        x r8 = (x) this.a.v.getValue();
        if (r8 == null) goto L21;
        if (r8.e6() != true) goto L21;
        r0 = true;
    L21:
        return h0.f(r7, r3, r5, r2, Boolean.valueOf(r0));
    L11:
        r5 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    L22:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final boolean c(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        q0 r0 = a.b(this.a);
        if (r0 == null) goto L9;
        List r1 = r0.getCurrentList();
        if (r1 == null) goto L9;
        if (r1.size() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        FLogger.a.e("Image4OrScrollHolder", "isMsgLatest handle ,currentList size is 0");
        return false;
    L13:
        q0 r3 = a.b(this.a);
        if (r3 == null) goto L20;
        List r5 = r3.getCurrentList();
        if (r5 == null) goto L20;
        Message r6 = (Message) ListProtector.get(r5, 0);
        if (r6 == null) goto L20;
        String r7 = r6.getMessageId();
    L22:
        return Intrinsics.areEqual(r7, r4.getMessageId());
    L20:
        r7 = null;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final void d(Message r8) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        Integer r9 = ic8.j.b(r8);
        if (r9 == null) goto L8;
        GenerateImageCell r0 = this.a;
        int r10 = r9.intValue();
        com.larus.bmhome.instruction.g r1 = (com.larus.bmhome.instruction.g) r0.s.getValue();
        if (r1 == null) goto L9;
        com.larus.bmhome.instruction.g.a.e(r1, null, Integer.valueOf(r10), null, 0, 13);
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final void a(final Message r23, ImageContentData r24, Message r25) {
        Intrinsics.checkNotNullParameter(r23, "msg");
        Integer r4 = null;
        if (r25 != null) goto L47;
        GenerateImageCell r1 = this.a;
        ConcurrentHashMap.KeySetView r5 = GenerateImageCell.A;
        com.larus.bmhome.chat.component.regen.a r6 = (com.larus.bmhome.chat.component.regen.a) r1.x.getValue();
        boolean r7 = true;
        if (r6 != null) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == false) goto L68;
        q0 r9 = a.b(r1);
        if (r9 == null) goto L19;
        ChatMessageList r10 = r9.B7();
        if (r10 == null) goto L19;
        Long r11 = r10.getChatUniqueKey();
        if (r11 == null) goto L19;
        long r12 = r11.longValue();
    L20:
        long r13 = r12;
        RepoDispatcher.a.getClass();
        ChatRepo r14 = RepoDispatcher.d;
        String r15 = r23.getLocalMessageId();
        String r16 = "";
        if (r15 != null) goto L23;
        r15 = "";
    L23:
        r14.r1(r15, new d(r23));
        u7 r17 = (u7) ((BaseProgressLoadingCell) r1).k.getValue();
        if (r17 == null) goto L64;
        y r18 = r1.s();
        if (r18 == null) goto L28;
        wc9.e r19 = r18.h();
    L29:
        by7.e r110 = a.d(r1);
        if ((r110 instanceof by7.e) == false) goto L32;
        by7.e r111 = r110;
    L33:
        de8.c r2 = (de8.c) ((BaseProgressLoadingCell) r1).l.getValue();
        if (r2 == null) goto L36;
        r4 = r2.m();
    L36:
        if (r4 != null) goto L39;
        r7 = false;
    L39:
        if (r24 == null) goto L46;
        List<ImageItem> r3 = r24.getImageList();
        if (r3 == null) goto L46;
        String r20 = CollectionsKt.joinToString$default(r3, ",", null, null, 0, null, new e(), 30, null);
        if (r20 == null) goto L46;
        r16 = r20;
    L46:
        u7$a.c(r17, r19, r23, "answer", r111, r7, r16, r13, null, 128);
        return;
    L32:
        r111 = null;
        goto L33
    L28:
        r19 = null;
        goto L29
    L64:
        return;
    L19:
        r12 = 0;
        goto L20
    L68:
        return;
    L7:
        if (r6.nS(r23) != true) goto L9;
        r8 = true;
        goto L10
    L47:
        int r21 = n0.a;
        GenerateImageCell r22 = this.a;
        ConcurrentHashMap.KeySetView r26 = GenerateImageCell.A;
        y r27 = r22.s();
        if (r27 == null) goto L50;
        String r28 = r27.getBotId();
    L51:
        y r29 = this.a.s();
        if (r29 == null) goto L54;
        wc9.e r30 = r29.h();
    L55:
        Integer r31 = a.d(this.a);
        if ((r31 instanceof by7.e) == false) goto L58;
        r4 = (by7.e) r31;
    L58:
        n0.a("pic", r28, r30, r4);
        GenerateImageCell r32 = this.a;
        r32.getClass();
        FLogger.a.i("Image4OrScrollHolder", "modifyAndRegenerate  " + r25.getMessageId());
        q0 r33 = a.b(r32);
        if (r33 == null) goto L66;
        ICoreInputAbility r34 = (ICoreInputAbility) r32.w.getValue();
        if (r34 == null) goto L67;
        r34.jm(r33, r25, false, MessageModifyMode.MODIFY_TO_REGENERATE);
        return;
    L67:
        return;
    L66:
        return;
    L54:
        r30 = null;
        goto L55
    L50:
        r28 = null;
        goto L51
    }
}
