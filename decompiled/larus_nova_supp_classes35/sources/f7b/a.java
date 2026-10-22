package f7b;

import android.os.Bundle;
import android.text.TextUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.flow.chatthread.page.FlowChatThreadViewModel;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.o;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e7b.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ b b;
    public final /* synthetic */ IGetDataCallback<c> c;

    /* JADX INFO: renamed from: f7b.a$a, reason: collision with other inner class name */
    public static final class RunnableC0220a implements Runnable {
        public final /* synthetic */ IGetDataCallback<c> a;
        public final /* synthetic */ c b;

        public RunnableC0220a(IGetDataCallback<c> r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onSuccess(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(Bundle r1, b r2, FlowChatThreadViewModel.parseBundle.1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        Bundle r0 = this.a;
        c r1 = null;
        if (r0 == null) goto L73;
        this.b.getClass();
        String r2 = r0.getString("extra.chat.id");
        String r3 = r0.getString("extra.message.id");
        ChatService r4 = ChatService.c.a;
        Chat r5 = r4.getLocalChat(r2);
        p r6 = ImSdkService.f();
        String r7 = BuildConfig.FLAVOR;
        if (r3 != null) goto L7;
        r3 = BuildConfig.FLAVOR;
    L7:
        MessageInfo r8 = r6.p(r3);
        if (r5 == null) goto L46;
        if (r8 == null) goto L46;
        Message.Status r9 = r8.getMessage().getStatus();
        Message.Status r10 = Message.Status.DELETED;
        if (r9 != r10) goto L24;
        TextContent r11 = new TextContent();
        ChatChatter r12 = r8.getRecallUser();
        if (Message.RecallerIdentity.ENTERPRISE_ADMINISTRATOR != r8.getMessage().getRecallerIdentity()) goto L16;
        r11.setRichText(com.ss.android.lark.widget.richtext.c.c(UIHelper.getString(2131891218)));
    L23:
        r8.getMessage().setStatus(r10);
        r8.getMessage().setType(Message.Type.TEXT);
        r8.getMessage().setMessageContent(r11);
        goto L24
    L16:
        if (r12 == null) goto L22;
        String r13 = o.a(r12.getId(), m.b(r12, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, false));
        if (r8.getMessage().getRecallerIdentity() != Message.RecallerIdentity.GROUP_ADMIN) goto L20;
        String r14 = UIHelper.mustacheFormat(2131891787, "GroupAdministrator", r13);
    L21:
        r11.setRichText(com.ss.android.lark.widget.richtext.c.c(r14));
        goto L23
    L20:
        r14 = UIHelper.mustacheFormat(2131891916, "recaller", r13);
        goto L21
    L22:
        r11.setRichText(com.ss.android.lark.widget.richtext.c.c(UIHelper.getString(2131891918)));
    L24:
        ChatChatter r15 = (ChatChatter) r0.getSerializable("extra.selfChatter");
        ChatChatter r16 = (ChatChatter) r0.getSerializable("extra.p2p.selfChatter");
        OpenApp r17 = r0.getSerializable("extra.open.app");
        int r18 = c.f;
        MessageInfo r19 = r8.getRootMessageInfo();
        if (r19 == null) goto L27;
        String r20 = r19.getId();
    L29:
        if (TextUtils.isEmpty(r20) == false) goto L32;
        r20 = r8.getMessage().getRootId();
    L32:
        if (TextUtils.isEmpty(r20) == false) goto L34;
        r20 = r8.getMessage().getId();
    L34:
        if (r20 != null) goto L36;
        r20 = BuildConfig.FLAVOR;
    L36:
        e7b.a r21 = new e7b.a(r5, r20);
        Intrinsics.checkNotNullParameter(r21, "baseData");
        c.a r22 = new c.a(r21.a, r21.b);
        r22.d = r8;
        r22.c = r15;
        c r23 = new c(r22);
        if (r23.e != null) goto L47;
        MessageInfo r24 = r23.d;
        if (r24 == null) goto L42;
        MessageInfo r25 = r24.getRootMessageInfo();
    L43:
        r23.e = r25;
        if (r25 != null) goto L47;
        r23.e = ImSdkService.f().p(r23.b);
        goto L47
    L42:
        r25 = null;
    L47:
        if (r23 == null) goto L49;
        MessageInfo r26 = r23.d;
    L50:
        if (r26 != null) goto L72;
        int r27 = e7b.b.c;
        Intrinsics.checkNotNullParameter(r0, "bundle");
        e7b.b.a r28 = new e7b.b.a();
        r28.a = r0.getString("chatId");
        String r29 = r0.getString("rootId");
        String r30 = r28.a;
        if (r30 == null) goto L55;
        if (r29 == null) goto L55;
        e7b.b r31 = new e7b.b(r30, r29);
    L57:
        if (r31 == null) goto L73;
        com.ss.android.lark.chat.entity.chat.a r32 = r4.f(r31.a);
        MessageInfo r33 = ImSdkService.f().p(r31.b);
        if (r32 == null) goto L71;
        Chat r34 = r32.a;
        if (r34 == null) goto L71;
        if (r34.getRole() != Chat.Role.MEMBER) goto L71;
        if (r33 == null) goto L71;
        Chat r35 = r32.a;
        ImSdkService.d().H5(r31.a, r35.getP2pChatterId());
        String r36 = ChatCoreModule.a().getPassportDependency().userId();
        if (r36 == null) goto L70;
        r7 = r36;
    L70:
        ChatChatter r37 = ImSdkService.d().H5(r31.a, r7);
        int r38 = c.f;
        Intrinsics.checkNotNull(r35);
        e7b.a r39 = new e7b.a(r35, r31.b);
        Intrinsics.checkNotNullParameter(r39, "baseData");
        c.a r40 = new c.a(r39.a, r39.b);
        r40.c = r37;
        r40.d = r33;
        r40.e = r33;
        r1 = new c(r40);
    L71:
        Log.e("ChatThreadBundle", "load init data failed, chatId: " + r31.a + ", rootId: " + r31.b);
    L55:
        r31 = null;
        goto L57
    L72:
        r1 = r23;
        goto L73
    L49:
        r26 = null;
        goto L50
    L27:
        r20 = null;
    L46:
        r23 = null;
    L73:
        UICallbackExecutor.execute(new RunnableC0220a(this.c, r1));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
