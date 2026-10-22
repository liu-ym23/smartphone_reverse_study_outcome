package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.MessageListDecorationController;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager$keyboardEventCenterHandler$2;
import com.ss.android.lark.scaffold.IComponent;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements l3c.c {

    public interface a {
        <T extends IComponent> T a(Class<T> r1);
    }

    public static final class b implements IMessageListComponent.f {
        public final IKeyboardComponent a;

        public final void c() {
            this.a.Xm();
        }

        public final Integer d() {
            View r0 = this.a.getContainerView();
            if (r0 != null) goto L7;
            return null;
        L7:
            return Integer.valueOf(r0.getHeight());
        }

        public final int e() {
            return this.a.UJ();
        }

        public final boolean g() {
            return this.a.gI();
        }

        public final boolean h() {
            return this.a.Hx();
        }

        public b(IKeyboardComponent r2) {
            Intrinsics.checkNotNullParameter(r2, "keyboardComponent");
            this.a = r2;
        }

        public final void b(MessageActionPanelManager$keyboardEventCenterHandler$2.a r2) {
            Intrinsics.checkNotNullParameter(r2, "handler");
            this.a.lD(r2);
        }

        public final void i(y6b.a<? extends v5b.a<?>> r2) {
            Intrinsics.checkNotNullParameter(r2, "messageVO");
            this.a.K6(r2);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.f
        public final void a(MessageInfo r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "messageInfo");
            this.a.oN(r1);
        }

        public final boolean f(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "chatterId");
            Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
            Intrinsics.checkNotNullParameter(r4, "chatterOriginName");
            return this.a.m10(r2, r3, r4);
        }

        public final void j(MessageInfo r9, int r10, PartialReplyInfo r11) {
            Intrinsics.checkNotNullParameter(r9, "messageInfo");
            IKeyboardComponent.CC.onReplyMessage$default(this.a, r9, r10, r11, null, 8, null);
        }

        public final void k(String r2, String r3, RichText r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r4, "content");
            this.a.P3(r2, r3, r4, r5);
        }
    }

    public static final class c implements IBannerComponent.a, ITitlebarComponent.b, ITitlebarComponent.f, ITitlebarComponent.a {
        public final IMessageListComponent a;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void c() {
            this.a.cN(new MessageListDecorationController.c(MessageListDecorationController.Scene.SCENE_BANNER, new MessageListDecorationController.d(0, 14)));
        }

        public c(IMessageListComponent r2) {
            Intrinsics.checkNotNullParameter(r2, "messageListComponent");
            this.a = r2;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void a(int r6) {
            this.a.cN(new MessageListDecorationController.c(MessageListDecorationController.Scene.SCENE_BANNER, new MessageListDecorationController.d(Integer.valueOf(r6), 14)));
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void b(int r6) {
            this.a.cN(new MessageListDecorationController.c(MessageListDecorationController.Scene.SCENE_BANNER, new MessageListDecorationController.d(Integer.valueOf(r6), 14)));
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d$d, reason: collision with other inner class name */
    public static final class C0062d implements a {
        public final /* synthetic */ l3c.f a;

        public C0062d(l3c.f r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.a
        public final <T extends IComponent> T a(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "clz");
            return (T) this.a.a(r2);
        }

        public final <T extends l3c.g> T b(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "clz");
            return (T) this.a.b(r2);
        }
    }

    public d() {
    }

    public final void a(l3c.f r6) {
        Intrinsics.checkNotNullParameter(r6, "rt");
        C0062d r0 = new C0062d(r6);
        Intrinsics.checkNotNullParameter(r0, "dependency");
        IMessageListComponent r7 = (IMessageListComponent) r0.a(IMessageListComponent.class);
        if (r7 == null) goto L17;
        IMessageSenderComponent r1 = (IMessageSenderComponent) r0.a(IMessageSenderComponent.class);
        ChatWindowOpenViewModel r2 = r0.b(ChatWindowOpenViewModel.class);
        r7.IB(new g(r1, r0));
        if (r2 == null) goto L8;
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r2.getChat(), r7, new h(r0, r7));
    L8:
        if (r2 == null) goto L15;
        MutableLiveData r3 = r2.getChat();
        if (r3 == null) goto L15;
        Chat r4 = (Chat) r3.getValue();
        if (r4 == null) goto L15;
        if (r1 == null) goto L15;
        r1.updateChat(r4);
    L15:
        r7.m(new i(r1, r2));
        return;
    }
}
