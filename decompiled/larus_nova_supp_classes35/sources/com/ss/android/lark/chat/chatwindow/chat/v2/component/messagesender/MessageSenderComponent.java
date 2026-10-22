package com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender;

import android.net.Uri;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.biz.im.api.g0;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.chatwindow.chat.data.content.MessageContentResolver;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m5b.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0014J\"\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H\u0016J\f\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0006\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/messagesender/MessageSenderComponent;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/messagesender/BaseMessageSenderComponent;", "container", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "isEnableInterceptMixMessage", BuildConfig.FLAVOR, "()Z", "isEnableInterceptMixMessage$delegate", "Lkotlin/Lazy;", "getMessageContentResolver", "Lcom/ss/android/lark/chat/chatwindow/chat/data/content/MessageContentResolver;", "onQuasiMessageSendStart", BuildConfig.FLAVOR, "cId", BuildConfig.FLAVOR, "messageParams", "Lcom/ss/android/lark/chat/entity/message/MessageParams;", "getMessageSender", "Lcom/ss/android/lark/chat/chatwindow/keyboard/KeyboardMessageSender;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/model/IMessageSender;", "GuardMessageSender", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MessageSenderComponent extends BaseMessageSenderComponent {
    public static final /* synthetic */ int r = 0;
    public final Lazy q;

    public static final class a implements q4b.a {
        public final q4b.a a;
        public final Function0<Chat> b;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.MessageSenderComponent$a$a, reason: collision with other inner class name */
        public static final class C0075a {
        }

        static {
        }

        @Override // m5b.a
        public final String m() {
            return this.a.m();
        }

        public final boolean v() {
            String r1 = null;
            Chat r2 = (Chat) this.b.invoke();     // Catch: Exception -> L5
        L7:
            String r3 = this.a.m();
            if (r2 == null) goto L14;
            if (Intrinsics.areEqual(r3, r2.getId()) == false) goto L14;
            return true;
        L14:
            if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == false) goto L20;
            StringBuilder r4 = new StringBuilder("Send message with wrong chat! send message chat id: ");
            r4.append(r3);
            r4.append(", current chat id: ");
            if (r2 == null) goto L18;
            r1 = r2.getId();
        L18:
            r4.append(r1);
            throw new IllegalStateException(r4.toString());
        L20:
            StringBuilder r5 = new StringBuilder("chat not match, cancel sending message. send message chat id: ");
            r5.append(r3);
            r5.append(", current chat id: ");
            if (r2 == null) goto L23;
            r1 = r2.getId();
        L23:
            r5.append(r1);
            Log.e("GuardMessageSender", r5.toString());
            JSONObject r0 = new JSONObject();
            r0.put("send_message_chat_id", m());
            if (r2 == null) goto L27;
            String r6 = r2.getId();
            if (r6 == null) goto L27;
        L28:
            r0.put("current_chat_id", r6);
            Statistics.sendEvent("im_send_message_chat_not_match", r0);
            return false;
        L27:
            r6 = BuildConfig.FLAVOR;
        L5:
            e = move-exception;
            Log.e("GuardMessageSender", "fail to get current chat, illegal state", e);
            r2 = null;
            goto L7
        }

        @Override // m5b.b
        public final Message a(d r2) {
            if (v() == true) goto L7;
            return null;
        L7:
            return this.a.a(r2);
        }

        @Override // m5b.b
        public final void b(d r2) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.b(r2);
        }

        @Override // m5b.a
        public final void c(g0 r2) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.c(r2);
        }

        @Override // m5b.b
        public final void g(d r2) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.g(r2);
        }

        @Override // q4b.a
        public final void i(List<? extends File> r2) {
            Intrinsics.checkNotNullParameter(r2, "files");
            if (v() == true) goto L5;
            return;
        L5:
            this.a.i(r2);
        }

        @Override // m5b.b
        public final void j(d r2) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.j(r2);
        }

        @Override // m5b.b
        public final void l(d r2) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.l(r2);
        }

        @Override // m5b.b
        public final void n(d r2) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.n(r2);
        }

        @Override // m5b.b
        public final void p(d r2) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.p(r2);
        }

        @Override // q4b.a
        public final void q(List<? extends Uri> r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            if (v() == true) goto L5;
            return;
        L5:
            this.a.q(r2);
        }

        @Override // m5b.a
        public final void s(g0 r2) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.s(r2);
        }

        public a(j4b.a r2, Function0 r3) {
            Intrinsics.checkNotNullParameter(r2, "real");
            Intrinsics.checkNotNullParameter(r3, "provideCurrentChat");
            this.a = r2;
            this.b = r3;
        }

        @Override // m5b.a
        public final void d(String r2, String r3, RichText r4) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.d(r2, r3, r4);
        }

        @Override // m5b.a
        public final void k(String r2, String r3, RichText r4) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.k(r2, r3, r4);
        }

        @Override // q4b.a
        public final void r(StickerFileInfo r2, String r3, String r4, PartialReplyInfo r5) {
            Intrinsics.checkNotNullParameter(r2, "stickerFileInfo");
            Intrinsics.checkNotNullParameter(r3, "rootMsgId");
            Intrinsics.checkNotNullParameter(r4, "parentMsgId");
            if (v() == true) goto L5;
            return;
        L5:
            this.a.r(r2, r3, r4, r5);
        }

        @Override // m5b.a
        public final void u(String r2, String r3, RichText r4, boolean r5) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.u(r2, r3, r4, r5);
        }

        @Override // q4b.a
        public final Message e(String r7, String r8, String r9, String r10, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r11) {
            Intrinsics.checkNotNullParameter(r7, "rootMsgId");
            Intrinsics.checkNotNullParameter(r8, "parentMsgId");
            Intrinsics.checkNotNullParameter(r9, "fileName");
            Intrinsics.checkNotNullParameter(r10, "cid");
            if (v() == true) goto L7;
            return null;
        L7:
            return this.a.e(r7, r8, r9, r10, r11);
        }

        @Override // q4b.a
        public final void h(List<? extends Photo> r8, String r9, String r10, int r11, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r12) {
            Intrinsics.checkNotNullParameter(r8, "photos");
            Intrinsics.checkNotNullParameter(r9, "rootMsgId");
            Intrinsics.checkNotNullParameter(r10, "parentMsgId");
            if (v() == true) goto L5;
            return;
        L5:
            this.a.h(r8, r9, r10, r11, r12);
        }

        @Override // q4b.a
        public final void f(List<String> r10, boolean r11, String r12, String r13, int r14, String r15, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r16) {
            Intrinsics.checkNotNullParameter(r10, "photos");
            Intrinsics.checkNotNullParameter(r12, "rootMsgId");
            Intrinsics.checkNotNullParameter(r13, "parentMsgId");
            if (v() == true) goto L5;
            return;
        L5:
            this.a.f(r10, r11, r12, r13, r14, r15, r16);
        }

        @Override // m5b.c
        public final void o(String r9, String r10, RichText r11, boolean r12, PartialReplyInfo r13, boolean r14, boolean r15) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.o(r9, r10, r11, r12, r13, r14, false);
        }

        @Override // m5b.a
        public final void t(String r11, String r12, RichText r13, String r14, String r15, Boolean r16, PartialReplyInfo r17, boolean r18) {
            if (v() == true) goto L5;
            return;
        L5:
            this.a.t(r11, r12, r13, r14, r15, r16, r17, r18);
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.BaseMessageSenderComponent, com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent
    public final q4b.a getMessageSender() {
        if (((Boolean) this.q.getValue()).booleanValue() == false) goto L7;
        return new a((j4b.a) this.n.getValue(), new AnonymousClass1(this));
    L7:
        return (j4b.a) this.n.getValue();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.BaseMessageSenderComponent
    public final MessageContentResolver E0() {
        return com.ss.android.lark.chat.chatwindow.chat.data.content.a.b;
    }

    public MessageSenderComponent(final v r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
        this.q = LazyKt.lazy(new MessageSenderComponent$isEnableInterceptMixMessage$2(r2));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.BaseMessageSenderComponent, j4b.a.d
    public void g(String r2, MessageParams<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "messageParams");
        Intrinsics.checkNotNullParameter(r3, "messageParams");
        if ((r3 instanceof j1) == false) goto L6;
        RichText r4 = ((j1) r3).A;
    L10:
        if (r3.v == false) goto L12;
    L14:
        this.l.p0().a(r3.d, r3.c);
        return;
    L12:
        if (com.ss.android.lark.widget.richtext.d.f(r4, false).isEmpty() == false) goto L14;
        return;
    L6:
        if ((r3 instanceof kya.a) == false) goto L8;
        r4 = ((kya.a) r3).B;
        goto L10
    L8:
        r4 = null;
        goto L10
    }
}
