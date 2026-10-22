package com.ss.android.lark.flow.replyinthread.message;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment$initComponents$5;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import m5b.d;
import m5b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends j4b.a {
    public final FlowBaseReplyInThreadViewModel h;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.replyinthread.message.a$a, reason: collision with other inner class name */
    public static final class C0057a {
    }

    public static final class b extends j4b.a.f {
        public final /* synthetic */ e s;

        public final /* bridge */ /* synthetic */ void h(MessageInfo r1) {
            s(r1);
        }

        public final void s(MessageInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "preMessageInfo");
            super/*com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback*/.s(r2);
            AudioContent r3 = r2.getMessage().getContent();
            Integer r0 = this.s.v;
            if (r0 == null) goto L5;
            int r1 = r0.intValue();
        L6:
            r3.setDuration(r1);
            r3.setLocalFilePath(this.s.w);
            r3.setRecognizeFinished(true);
            r3.setNeedHideText(true);
            r3.setFileState(AudioContent.AudioState.DOWNLOAD);
            return;
        L5:
            r1 = 0;
            goto L6
        }

        public b(a r1, e r2) {
            this.s = r2;
            super(r1);
        }
    }

    static {
    }

    public final int y() {
        ThreadTopic r0 = (ThreadTopic) this.h.getThreadTopicLiveData().getValue();
        if (r0 != null) goto L10;
        Chat r1 = ((j4b.a) this).e;
        if (r1 != null) goto L11;
        return 0;
    L11:
        return r1.getLastMessagePosition();
    L10:
        return r0.getLastMsgPos();
    }

    public final Message a(d r7) {
        String r0 = null;
        z(r7, null);
        Chat r1 = ((j4b.a) this).e;
        if (r1 != null) goto L7;
        r1 = (Chat) this.h.getChatData().getValue();
        if (r1 != null) goto L7;
        return null;
    L7:
        ((j4b.a) this).d.o();
        if (r7 == null) goto L10;
        e r8 = r7.e;
    L11:
        h5b.a.a r2 = new h5b.a.a();
        ((MessageParams.a) r2).c = r1.getId();
        String r3 = "";
        if (r8 == null) goto L15;
        String r4 = r8.j;
        if (r4 == null) goto L15;
    L16:
        ((MessageParams.a) r2).a = r4;
        ((j4b.a) this).d.j(r2);
        if (r8 == null) goto L20;
        String r5 = r8.k;
        if (r5 == null) goto L20;
    L21:
        ((MessageParams.a) r2).b = r5;
        if (r8 == null) goto L24;
        String r6 = r8.p;
    L25:
        ((MessageParams.a) r2).i = r6;
        boolean r9 = false;
        if (r8 == null) goto L30;
        Boolean r10 = r8.q;
        if (r10 == null) goto L30;
        boolean r11 = r10.booleanValue();
    L31:
        ((MessageParams.a) r2).m = r11;
        if (r8 == null) goto L34;
        com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r12 = r8.t;
    L35:
        ((MessageParams.a) r2).s = r12;
        if (r8 == null) goto L38;
        Long r13 = r8.d;
    L39:
        ((MessageParams.a) r2).w = r13;
        if (r8 == null) goto L42;
        r9 = r8.b;
    L42:
        ((MessageParams.a) r2).v = r9;
        ((MessageParams.a) r2).e = y();
        if (r8 == null) goto L45;
        String r14 = r8.u;
    L46:
        ((MessageParams.a) r2).d = r14;
        if (r8 == null) goto L49;
        String r15 = r8.w;
    L50:
        r2.A = r15;
        r2.C = AudioContent.AudioState.RECORDING;
        h5b.a r16 = r2.b();
        if (r8 == null) goto L53;
        r0 = r8.u;
    L53:
        ChatChatter r17 = ((j4b.a) this).a.x1(r1.getId());
        if (r17 == null) goto L60;
        String r18 = r17.getId();
        if (r18 == null) goto L60;
        r3 = r18;
    L60:
        return r16.c(r0, r3);
    L49:
        r15 = null;
        goto L50
    L45:
        r14 = null;
        goto L46
    L38:
        r13 = null;
        goto L39
    L34:
        r12 = null;
    L30:
        r11 = false;
        goto L31
    L24:
        r6 = null;
    L20:
        r5 = "";
    L15:
        r4 = "";
        goto L16
    L10:
        r8 = null;
        goto L11
    }

    public final void b(d r6) {
        z(r6, null);
        Chat r0 = ((j4b.a) this).e;
        if (r0 != null) goto L5;
        r0 = (Chat) this.h.getChatData().getValue();
    L5:
        if (r0 != null) goto L8;
        Log.e("FlowReplyInThreadMsgSender", "sendAudioMessage: chat is null, fallback to super");
        super.b(r6);
        return;
    L8:
        if (r6 == null) goto L27;
        e r7 = r6.e;
        if (r7 == null) goto L28;
        Message r1 = r7.s;
        if (r1 != null) goto L15;
        return;
    L15:
        ((j4b.a) this).d.o();
        AudioContent r2 = r1.getContent();
        b r3 = r7.x;
        if (r3 != null) goto L18;
        r3 = new b(this, r7);
    L18:
        h5b.a.a r4 = new h5b.a.a();
        ((MessageParams.a) r4).c = r0.getId();
        ((MessageParams.a) r4).a = r7.j;
        ((MessageParams.a) r4).b = r7.k;
        ((MessageParams.a) r4).i = r7.p;
        Boolean r5 = r7.q;
        int r8 = 0;
        if (r5 == null) goto L21;
        boolean r9 = r5.booleanValue();
    L22:
        ((MessageParams.a) r4).m = r9;
        ((MessageParams.a) r4).e = y();
        ((MessageParams.a) r4).d = r7.u;
        r4.C = AudioContent.AudioState.DOWNLOAD;
        Integer r10 = r7.v;
        if (r10 == null) goto L25;
        r8 = r10.intValue();
    L25:
        r4.B = r8;
        r4.A = r7.w;
        ((MessageParams.a) r4).w = r7.d;
        ((MessageParams.a) r4).v = r7.b;
        r4.D = r2.getUploadId();
        ((j4b.a) this).d.j(r4);
        r4.E = r2.getAudioToken();
        ((MessageParams.a) r4).s = r7.t;
        MessageParams r11 = r4.b();
        p r12 = ((j4b.a) this).b;
        Intrinsics.checkNotNull(r11);
        r12.ib(r11, r3);
        return;
    L21:
        r9 = false;
        goto L22
    L28:
        return;
    }

    public final void g(d r6) {
        Map r0 = null;
        z(r6, null);
        Chat r1 = ((j4b.a) this).e;
        if (r1 != null) goto L5;
        r1 = (Chat) this.h.getChatData().getValue();
    L5:
        if (r1 != null) goto L8;
        Log.e("FlowReplyInThreadMsgSender", "sendTextMessage: chat is null, fallback to super");
        super.g(r6);
        return;
    L8:
        ((j4b.a) this).d.o();
        p r2 = ((j4b.a) this).b;
        j1.a r3 = new j1.a();
        ((MessageParams.a) r3).c = r1.getId();
        ((MessageParams.a) r3).e = y();
        ((MessageParams.a) r3).d = UUID.randomUUID().toString();
        e r4 = r6.e;
        if (r4 == null) goto L11;
        String r5 = r4.j;
    L12:
        ((MessageParams.a) r3).a = r5;
        if (r4 == null) goto L15;
        String r7 = r4.k;
    L16:
        ((MessageParams.a) r3).b = r7;
        if (r4 == null) goto L19;
        String r8 = r4.p;
    L20:
        ((MessageParams.a) r3).i = r8;
        boolean r9 = false;
        if (r4 == null) goto L25;
        Boolean r10 = r4.q;
        if (r10 == null) goto L25;
        boolean r11 = r10.booleanValue();
    L26:
        ((MessageParams.a) r3).m = r11;
        r3.A = r6.c;
        e r12 = r6.e;
        if (r12 == null) goto L29;
        boolean r13 = r12.c;
    L30:
        r3.B = r13;
        if (r12 == null) goto L33;
        r9 = r12.b;
    L33:
        ((MessageParams.a) r3).v = r9;
        if (r12 == null) goto L36;
        Long r14 = r12.d;
    L37:
        ((MessageParams.a) r3).w = r14;
        if (r12 == null) goto L42;
        xcb.a r15 = r12.z;
        if (r15 == null) goto L42;
        Map r16 = r15.a;
    L43:
        ((MessageParams.a) r3).y = r16;
        if (r12 == null) goto L48;
        xcb.a r17 = r12.z;
        if (r17 == null) goto L48;
        r0 = r17.b;
    L48:
        ((MessageParams.a) r3).z = r0;
        ((j4b.a) this).d.j(r3);
        r2.ib(r3.b(), new j4b.a.f(this));
        return;
    L42:
        r16 = null;
        goto L43
    L36:
        r14 = null;
        goto L37
    L29:
        r13 = false;
    L25:
        r11 = false;
        goto L26
    L19:
        r8 = null;
        goto L20
    L15:
        r7 = null;
        goto L16
    L11:
        r5 = null;
        goto L12
    }

    public final void j(d r2) {
        z(r2, null);
        super.j(r2);
    }

    public final void l(d r2) {
        z(r2, Boolean.FALSE);
        super.l(r2);
    }

    public final void n(d r2) {
        z(r2, null);
        super.n(r2);
    }

    public final void p(d r2) {
        z(r2, null);
        super.p(r2);
    }

    public final void z(d r4, Boolean r5) {
        Chat r0 = ((j4b.a) this).e;
        if (r0 == null) goto L5;
        Chat.ChatMode r1 = r0.getChatMode();
    L7:
        if (r1 != Chat.ChatMode.THREAD_V2) goto L9;
        boolean r2 = true;
    L10:
        if (r4 == null) goto L15;
        e r6 = r4.e;
        if (r6 == null) goto L15;
        r6.j = this.h.getThreadId();
        r6.k = this.h.getThreadId();
        r6.p = this.h.getThreadId();
        r6.q = Boolean.valueOf(!r2);
        r6.r = r5;
    L15:
        if (((j4b.a) this).e != null) goto L20;
        Chat r7 = (Chat) this.h.getChatData().getValue();
        if (r7 == null) goto L21;
        Intrinsics.checkNotNullParameter(r7, "chat");
        ((j4b.a) this).e = r7;
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final void r(StickerFileInfo r4, String r5, String r6, PartialReplyInfo r7) {
        Intrinsics.checkNotNullParameter(r4, "stickerFileInfo");
        Intrinsics.checkNotNullParameter(r5, "rootMsgId");
        Intrinsics.checkNotNullParameter(r6, "parentMsgId");
        Chat r8 = ((j4b.a) this).e;
        if (r8 != null) goto L5;
        r8 = (Chat) this.h.getChatData().getValue();
    L5:
        if (r8 != null) goto L8;
        Log.e("FlowReplyInThreadMsgSender", "sendStickerMsg, chat is null");
        return;
    L8:
        String r9 = this.h.getThreadId();
        if (r8.getChatMode() != Chat.ChatMode.THREAD_V2) goto L11;
        boolean r10 = true;
    L12:
        p r0 = ((j4b.a) this).b;
        h5b.b.a r2 = new h5b.b.a();
        ((MessageParams.a) r2).c = r8.getId();
        ((MessageParams.a) r2).a = r9;
        ((MessageParams.a) r2).b = r9;
        ((MessageParams.a) r2).i = r9;
        ((MessageParams.a) r2).m = !r10;
        r2.A = r4;
        ((MessageParams.a) r2).h = Message.Type.STICKER;
        r0.ib(new h5b.b(r2), new j4b.a.g(this, this, r4));
        return;
    L11:
        r10 = false;
        goto L12
    }

    public a(h r2, p r3, IChatService r4, FlowReplyInThreadFragment$initComponents$5.AnonymousClass1 r5, FlowBaseReplyInThreadViewModel r6) {
        Intrinsics.checkNotNullParameter(r2, "chatterService");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "legacyChatService");
        Intrinsics.checkNotNullParameter(r5, "listener");
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        super(r2, r3, r4, r5);
        this.h = r6;
        new x4b.b("lk-reply-in-thread");
    }
}
