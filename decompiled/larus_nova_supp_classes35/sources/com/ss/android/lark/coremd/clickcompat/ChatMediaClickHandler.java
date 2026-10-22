package com.ss.android.lark.coremd.clickcompat;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.chatwindow.view.photopreview.OperateListenerImpl;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.widget.photo.preview.EnterSource;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.utils.l;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.span.MediaInfo;
import eab.f;
import g3b.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w4b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatMediaClickHandler {
    public final m2b.a a;
    public final c.b b;
    public final v4b.d c;

    public ChatMediaClickHandler(m2b.a r2, g.b r3, v4b.d r4) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "messageProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public void a(final f r18, String r19, View r20, Rect r21, Drawable r22, pwa.a r23) {
        Intrinsics.checkNotNullParameter(r18, "mediaNode");
        Intrinsics.checkNotNullParameter(r19, "messageId");
        Intrinsics.checkNotNullParameter(r20, "view");
        Intrinsics.checkNotNullParameter(r21, "bounds");
        AuthorizationServiceV2 r6 = owa.a.c();
        r6.a(r23.a, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        r6.a(r23.b, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        y6b.a<?> r2 = this.b.getMessageById(r19);
        if (r2 != null) goto L6;
        return;
    L6:
        if ((r2.b() instanceof PostContentVO) == true) goto L8;
        return;
    L8:
        MediaInfo r5 = new MediaInfo();
        IMMediaExtend.a r7 = IMMediaExtend.q;
        r5.key = (String) r7.b(new ChatMediaClickHandler$handleMediaClick$mediaProperty$1$mediaInfo$1$1(r18));
        r5.url = (String) r7.b(new ChatMediaClickHandler$handleMediaClick$mediaProperty$1$mediaInfo$1$2(r18));
        RichTextElement.MediaProperty r1 = com.ss.android.lark.widget.richtext.d.b(((PostContentVO) r2.b()).g(), r5);
        if (r1 != null) goto L11;
        return;
    L11:
        MediaImageSet r3 = com.ss.android.lark.parser.internal.d.d(r2, r1);
        r r8 = (r) this.a.d0(r.class);
        if (r8 == null) goto L17;
        if (r3.getMessageIdentity() == null) goto L17;
        r3.getMessageIdentity().setSourceType(r8.e);
    L17:
        if (this.c == null) goto L19;
        MessageIdentity r9 = r3.getMessageIdentity();
        r9.setSourceId(r2.I());
        r9.setSourceType(r2.J());
    L19:
        List r4 = l.b(CollectionsKt.listOf(r3));
        if (CollectionUtils.isEmpty(r4) == true) goto L73;
        OperateListenerImpl r10 = new OperateListenerImpl(this.a.getChat());
        if (this.a.isSecretChat() == false) goto L25;
        Scene r11 = Scene.SecretChat;
    L31:
        ActivityTransitionLauncher.LocationInfo r12 = new ActivityTransitionLauncher.LocationInfo(r21.width(), r21.height(), r21.left, r21.top);
        boolean r13 = false;
        PhotoItem r14 = (PhotoItem) ListProtector.get(r4, 0);
        if (r14 == null) goto L34;
        r14.setThumbnail(r22);
    L34:
        int r15 = y0.a;
        boolean r16 = y0.d(this.a.getChat());
        if (this.a.isSecretChat() == false) goto L37;
    L39:
        boolean r17 = false;
    L41:
        if (y0.c(this.a.getChat()) == true) goto L43;
    L45:
        boolean r110 = false;
    L47:
        if (this.a.isSecretChat() == false) goto L49;
    L51:
        boolean r111 = false;
    L52:
        String r112 = ChatCoreModule.a().getMergeForwardDependnecy().a();
        if (TextUtils.isEmpty(r112) == true) goto L60;
        int r113 = ((ArrayList) r4).size();
        int r114 = 0;
    L55:
        if (r114 >= r113) goto L60;
        PhotoItem r115 = (PhotoItem) ListProtector.get(r4, r114);
        if (r115 == null) goto L59;
        r115.setEntityId(r112);
    L59:
        r114 = r114 + 1;
    L60:
        EnterSource.a r116 = EnterSource.Companion;
        Message.SourceType r24 = r2.J();
        r116.getClass();
        EnterSource r25 = EnterSource.a.a(r24);
        if (ChatCoreModule.a().getMergeForwardDependnecy().c() == false) goto L63;
        r25 = EnterSource.Favorite;
    L63:
        u r117 = MessagePermissionUtil.a;
        int r118 = k.a;
        k.c r26 = k.a.a(new ArrayList(r4), 0, r20);
        r26.d(false);
        r26.c = r12;
        boolean r27 = this.a.isSecretChat();
        r26.a.putBoolean("is_secret", r27);
        if (this.a.isSecretChat() == false) goto L66;
    L68:
        r26.j(r13);
        r26.g(r111);
        r26.a.putString("preview_id", null);
        r26.a.putString("msg_link_token", null);
        r26.l(r17);
        r26.n(r17);
        r26.m(r16);
        r26.f(r10);
        r26.q(Biz.Messenger, r11, 2);
        r26.h(r110);
        r26.b(r25);
        r26.u(Contexts.requireActivity(this.a.getContext()));
        return;
    L66:
        if (this.a.e0() == true) goto L68;
        r13 = true;
        goto L68
    L49:
        if (y0.a(this.a.getChat()) == false) goto L51;
        r111 = true;
        goto L52
    L43:
        if (r2.isPreMessage() == true) goto L45;
        r110 = true;
        goto L47
    L37:
        if (y0.b(this.a.getChat()) == false) goto L39;
        r17 = true;
        goto L41
    L25:
        if (this.a.r() == false) goto L27;
    L30:
        r11 = Scene.Thread;
        goto L31
    L27:
        if (this.a.q() == true) goto L30;
        r11 = Scene.Chat;
        goto L31
    }
}
