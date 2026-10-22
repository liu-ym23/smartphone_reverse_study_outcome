package com.ss.android.lark.chat.chatwindow.chat.data.reply;

import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import m6b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.chat.chatwindow.chat.data.reply.b {
    public final g a;
    public final Chat b;
    public final com.ss.android.lark.chat.chatwindow.chat.data.reply.a c;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ MessageInfo b;
        public final /* synthetic */ IGetDataCallback<i7b.c> c;

        public a(c r1, MessageInfo r2, IGetDataCallback<i7b.c> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            c r0 = this.a;
            MessageInfo r1 = this.b;
            IGetDataCallback<i7b.c> r2 = this.c;
            r0.getClass();
            i7b.c r3 = new i7b.c();
            r3.d = true;
            MessageInfo r5 = r1.getParentMessageInfo();
            Message r4 = r1.getMessage();
            String r6 = r4.getParentId();
            if (r6 != null) goto L5;
            r6 = BuildConfig.FLAVOR;
        L5:
            if (r5 != null) goto L9;
            r5 = ImSdkService.f().p(r6);
            if (r5 != null) goto L9;
            r2.onError(new ErrorResult("messageinfo has no root message"));
            return;
        L9:
            Draft r7 = r0.a.b8(r6);
            Draft r8 = r0.a.Ea(r6);
            r3.a = r4.getRootId();
            r3.b = r6;
            r3.h = r4.getPartialReplyInfo();
            ChatChatter r9 = r5.getMessageSender();
            r3.c = r0.c.a(r9, r5, false, r4.getPartialReplyInfo());
            m.b(r9, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true);
            r5.getMessage().getPosition();
            if (r7 == null) goto L13;
            r3.e = r7.contentRichText;
        L16:
            if (r8 == null) goto L19;
            r3.f = r8.postRichText;
        L23:
            if (TextUtils.isEmpty(r3.c) == false) goto L25;
        L32:
            r2.onError(new ErrorResult("can not get reply info"));
            return;
        L25:
            if (r3.e == null) goto L27;
        L31:
            r2.onSuccess(r3);
            return;
        L27:
            if (r3.f != null) goto L31;
            if (r3.g != null) goto L31;
        L19:
            if (r4.getType() != Message.Type.POST) goto L21;
            r3.f = ((PostContent) r4.getContent()).getRichText();
            goto L23
        L21:
            Log.e(TitlebarViewModel.LOG_TAG, "cannot re-edit message type: " + r4.getType());
            goto L23
        L13:
            if (r4.getType() != Message.Type.TEXT) goto L15;
            r3.e = ((TextContent) r4.getContent()).getRichText();
            goto L16
        L15:
            Log.e(TitlebarViewModel.LOG_TAG, "cannot re-edit message type: " + r4.getType());
            goto L16
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

    public static final class b implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ MessageInfo b;
        public final /* synthetic */ IGetDataCallback<i7b.c> c;

        public b(c r1, MessageInfo r2, IGetDataCallback<i7b.c> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            c r0 = this.a;
            MessageInfo r1 = this.b;
            IGetDataCallback<i7b.c> r2 = this.c;
            r0.getClass();
            i7b.c r3 = new i7b.c();
            Message r4 = r1.getMessage();
            ChatChatter r5 = r1.getMessageSender();
            r3.b = r4.getId();
            if (TextUtils.isEmpty(r4.getRootId()) == true) goto L5;
            String r6 = r4.getRootId();
        L6:
            String r7 = ChatCoreModule.a().getLoginDependency().getUserId();
            Chat r8 = r0.b;
            Chat.Type r9 = null;
            if (r8 == null) goto L9;
            String r10 = r8.getAnonymousId();
        L10:
            boolean r11 = false;
            if (r10 != null) goto L13;
        L18:
            boolean r12 = false;
        L19:
            if (r12 == false) goto L21;
            r7 = r10;
        L21:
            if (r5 == null) goto L46;
            CharSequence r13 = r0.c.a(r5, r1, true, null);
            r3.c = r13;
            if (TextUtils.isEmpty(r13) == true) goto L46;
            r3.a = r6;
            ChatChatter r14 = r1.getMessageSender();
            String r15 = m.b(r14, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true);
            Intrinsics.checkNotNull(r14);
            boolean r16 = Intrinsics.areEqual(r14.getId(), r7);
            Draft r17 = r0.a.b8(r4.getId());
            String r18 = BuildConfig.FLAVOR;
            if (r17 != null) goto L36;
            r17 = new Draft();
            r17.title = BuildConfig.FLAVOR;
            if (r16 == true) goto L35;
            Chat r19 = r0.b;
            if (r19 == null) goto L32;
            r9 = r19.getType();
        L32:
            if (r9 == Chat.Type.P2P) goto L35;
            r17.contentRichText = com.ss.android.lark.widget.richtext.c.c(o.a(r14.getId(), r15) + ' ');
        L37:
            r3.e = r17.contentRichText;
            r3.d = r11;
            Draft r20 = r0.a.Ea(r4.getId());
            if (r20 == null) goto L41;
            r18 = r20.title;
        L41:
            r3.g = r18;
            if (r20 != null) goto L44;
            RichText r21 = com.ss.android.lark.widget.richtext.c.a();
        L45:
            r3.f = r21;
            r2.onSuccess(r3);
            return;
        L44:
            r21 = r20.postRichText;
        L35:
            r17.contentRichText = com.ss.android.lark.widget.richtext.c.a();
            goto L37
        L36:
            r11 = true;
        L46:
            r2.onError(new ErrorResult("reply info is error!"));
            return;
        L13:
            if (r10.length() <= 0) goto L15;
            boolean r110 = true;
        L16:
            if (r110 != true) goto L18;
            r12 = true;
            goto L19
        L15:
            r110 = false;
            goto L16
        L9:
            r10 = null;
            goto L10
        L5:
            r6 = r4.getId();
            goto L6
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.data.reply.c$c, reason: collision with other inner class name */
    public static final class RunnableC0039c implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ MessageInfo b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ IGetDataCallback<i7b.c> d;

        public RunnableC0039c(c r1, MessageInfo r2, boolean r3, IGetDataCallback<i7b.c> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            c r0 = this.a;
            MessageInfo r1 = this.b;
            boolean r2 = this.c;
            IGetDataCallback<i7b.c> r3 = this.d;
            r0.getClass();
            Message r4 = r1.getMessage();
            i7b.c r5 = new i7b.c();
            ChatChatter r6 = r1.getMessageSender();
            r5.b = r4.getId();
            if (r6 != null) goto L5;
            r3.onError(new ErrorResult("reply info is error!"));
            return;
        L5:
            boolean r9 = false;
            RichText r10 = null;
            CharSequence r7 = r0.c.a(r6, r1, false, null);
            if (r7 != null) goto L8;
        L11:
            boolean r11 = true;
        L12:
            if (r11 == false) goto L14;
            r3.onError(new ErrorResult("reply info is error!"));
            return;
        L14:
            String r8 = r4.getRootId();
            if (r8 != null) goto L17;
        L20:
            boolean r12 = true;
        L21:
            if (r12 == true) goto L23;
            String r13 = r4.getRootId();
        L24:
            r5.a = r13;
            r5.c = r7;
            String r14 = ChatCoreModule.a().getLoginDependency().getUserId();
            Chat r15 = r0.b;
            if (r15 == null) goto L27;
            String r16 = r15.getAnonymousId();
        L28:
            if (r16 != null) goto L30;
        L35:
            boolean r17 = false;
        L36:
            if (r17 == false) goto L38;
            r14 = r16;
        L38:
            boolean r18 = Intrinsics.areEqual(r6.getId(), r14);
            if (r2 == false) goto L48;
            if (r18 == true) goto L48;
            Chat r19 = r0.b;
            if (r19 == null) goto L44;
            Chat.Type r20 = r19.getType();
        L46:
            if (r20 != Chat.Type.GROUP) goto L48;
            RichText r21 = com.ss.android.lark.widget.richtext.c.c(o.a(r6.getId(), m.b(r6, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true)) + ' ');
        L49:
            m.b(r6, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true);
            Intrinsics.areEqual(r6.getId(), ChatCoreModule.a().getLoginDependency().getUserId());
            if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.chat.reset.sync") == false) goto L54;
            Draft r22 = r0.a.Na(r4.getId());
            if (r22 != null) goto L55;
            r22 = r0.a.Ea(r4.getId());
        L55:
            if (r22 == null) goto L58;
            r9 = true;
        L58:
            if (r22 == null) goto L60;
            String r23 = r22.title;
        L61:
            r5.g = r23;
            if (r22 == null) goto L64;
            RichText r24 = r22.postRichText;
        L66:
            if (i.l(r24) == false) goto L68;
            r10 = r21;
        L70:
            r5.f = r10;
            r5.d = r9;
            r3.onSuccess(r5);
            return;
        L68:
            if (r22 == null) goto L70;
            r10 = r22.postRichText;
            goto L70
        L64:
            r24 = null;
            goto L66
        L60:
            r23 = null;
            goto L61
        L54:
            r22 = r0.a.Ea(r4.getId());
            goto L55
        L44:
            r20 = null;
        L48:
            r21 = null;
            goto L49
        L30:
            if (r16.length() <= 0) goto L32;
            boolean r110 = true;
        L33:
            if (r110 != true) goto L35;
            r17 = true;
            goto L36
        L32:
            r110 = false;
            goto L33
        L27:
            r16 = null;
            goto L28
        L23:
            r13 = r4.getId();
            goto L24
        L17:
            if (r8.length() == 0) goto L20;
            r12 = false;
            goto L21
        L8:
            if (r7.length() == 0) goto L11;
            r11 = false;
            goto L12
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

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.reply.b
    public final CharSequence a(MessageInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "messageInfo");
        ChatChatter r0 = r5.getMessageSender();
        CharSequence r6 = this.c.a(r0, r5, false, null);
        if (r6 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r6;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.reply.b
    public final void c(MessageInfo r3, IGetDataCallback<i7b.c> r4) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        if (r4 != null) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(this, r3, r4));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.reply.b
    public final void d(MessageInfo r3, IGetDataCallback<i7b.c> r4) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        if (r4 != null) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(this, r3, r4));
    }

    public c(g r2, Chat r3, com.ss.android.lark.chat.chatwindow.chat.data.reply.a r4) {
        Intrinsics.checkNotNullParameter(r2, "draftService");
        Intrinsics.checkNotNullParameter(r4, "creator");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.reply.b
    public final void b(MessageInfo r3, boolean r4, IGetDataCallback<i7b.c> r5) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        if (r5 != null) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().submit(new RunnableC0039c(this, r3, r4, r5));
    }
}
