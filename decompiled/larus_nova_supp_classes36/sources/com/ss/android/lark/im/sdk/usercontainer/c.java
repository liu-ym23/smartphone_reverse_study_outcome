package com.ss.android.lark.im.sdk.usercontainer;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.chat.service.impl.RecallInterceptCallback;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin$pullFollowingMessages$1;
import com.ss.android.lark.im.sdk.service.a0;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.im.sdk.service.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mergeforward.ParseMergeForwardDataUtils$wrapCallback$1;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends c0c.b implements p {
    public final /* synthetic */ p b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<p> d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void B8(String r2, boolean r3, RecallInterceptCallback r4) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b.B8(r2, r3, r4);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Fe(List<String> r2, IGetDataCallback<Map<String, Message>> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.Fe(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Jc(String r2, List<String> r3, IGetDataCallback<Message> r4) {
        Intrinsics.checkNotNullParameter(r3, "ids");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b.Jc(r2, r3, r4);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Executor P0() {
        return this.b.P0();
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Q5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cId");
        this.b.Q5(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void W2(String r2, int r3, FlowMessageSelectPlugin$pullFollowingMessages$1 r4) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b.W2(r2, r3, r4);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Map<String, MessageInfo> W5(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageIds");
        return this.b.W5(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void X3(Message r2, IGetDataCallback<String> r3) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.X3(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Z8(List r2, ParseMergeForwardDataUtils$wrapCallback$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "messages");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.Z8(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void a7(p0 r2, MonitorMessageSendCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "messageParams");
        this.b.a7(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void ac(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        this.b.ac(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void e8(com.ss.android.lark.im.sdk.service.b r2, IGetDataCallback<List<MessageInfo>> r3) {
        Intrinsics.checkNotNullParameter(r2, "param");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.e8(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void f1(String r2, SendStatus r3) {
        Intrinsics.checkNotNullParameter(r2, "cId");
        Intrinsics.checkNotNullParameter(r3, "sendStatus");
        this.b.f1(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final ChatMessageResponse fd(String r2, List<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "positions");
        return this.b.fd(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void ib(MessageParams r2, MonitorMessageSendCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "messageParams");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.ib(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Map<String, Message> ie(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        return this.b.ie(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void j6(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        this.b.j6(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void k7(List<String> r2, IGetDataCallback<Map<String, Message>> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.k7(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void l9(Message.b r2, IGetDataCallback<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.l9(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void m5(Message r2, boolean r3, MessageFoldDetail r4) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        this.b.m5(r2, r3, r4);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void mb(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cId");
        this.b.mb(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final MessageInfo p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        return this.b.p(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void p2(Message.b r2, IGetDataCallback<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.p2(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void sendImages(String r2, List<String> r3, boolean r4, IGetDataCallback<String> r5) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "imagePaths");
        this.b.sendImages(r2, r3, r4, r5);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void sendMessage(MessageParams<?, ?> r2, IGetDataCallback<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "messageParams");
        this.b.sendMessage(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Map<String, Message> ta(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        return this.b.ta(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final ChatMessageResponse x2(com.ss.android.lark.im.sdk.service.a r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        return this.b.x2(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void yb(z r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.b.yb(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Message za(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        return this.b.za(r2);
    }

    public c(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<p> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), p.class), p.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (p) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        Log.i("ImSdkMessageServiceProxy", "preparing");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        p r6 = (p) k.b(r4.c(r5), p.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
