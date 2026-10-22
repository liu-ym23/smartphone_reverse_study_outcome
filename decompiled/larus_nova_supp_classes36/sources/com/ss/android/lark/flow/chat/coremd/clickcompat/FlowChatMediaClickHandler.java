package com.ss.android.lark.flow.chat.coremd.clickcompat;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.larkfeed.impl.gallery.SocialGalleryRecallProvider;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.coremd.clickcompat.ChatMediaClickHandler;
import com.ss.android.lark.coremd.clickcompat.c;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.flow.chat.message.image.b;
import com.ss.android.lark.flow.chat.message.image.model.FlowMediaMessageType;
import com.ss.android.lark.flow.chat.message.image.model.FlowPhotoItem;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.utils.l;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.span.MediaInfo;
import eab.f;
import g3b.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kza.m;
import kza.n;
import v4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatMediaClickHandler extends ChatMediaClickHandler {
    public final m2b.a d;
    public final c.b e;
    public final d f;
    public final v g;
    public final Lazy h;
    public final Lazy i;

    public static final class a implements kza.c {
        public final /* synthetic */ FlowChatMediaClickHandler a;

        public a(FlowChatMediaClickHandler r1) {
            this.a = r1;
        }

        public final void a(SocialGalleryRecallProvider.observer.1 r3) {
            Intrinsics.checkNotNullParameter(r3, "observer");
            Chat r0 = this.a.d.getChat();
            if (r0 == null) goto L6;
            String r1 = r0.getId();
            if (r1 == null) goto L6;
        L8:
            if (TextUtils.isEmpty(r1) == true) goto L11;
            ((pgb.a) this.a.h.getValue()).a(r1, r3);
            return;
        L11:
            return;
        L6:
            r1 = "";
            goto L8
        }

        public final void d(SocialGalleryRecallProvider.observer.1 r3) {
            Intrinsics.checkNotNullParameter(r3, "observer");
            Chat r0 = this.a.d.getChat();
            if (r0 == null) goto L6;
            String r1 = r0.getId();
            if (r1 == null) goto L6;
        L8:
            if (TextUtils.isEmpty(r1) == true) goto L11;
            ((pgb.a) this.a.h.getValue()).b(r1, r3);
            return;
        L11:
            return;
        L6:
            r1 = "";
            goto L8
        }

        public final void b(FragmentActivity r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "localPath");
            Intrinsics.checkNotNullParameter(r4, "messageId");
        }

        public final void c(GallerySource r2, FragmentActivity r3, boolean r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "activity");
            b.a(r3, r4, r5);
        }
    }

    public FlowChatMediaClickHandler(m2b.a r2, g.b r3, v r4) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "messageProvider");
        Intrinsics.checkNotNullParameter(r4, "chatAppContainer");
        super(r2, r3, null);
        this.d = r2;
        this.e = r3;
        this.f = null;
        this.g = r4;
        this.h = LazyKt.lazy(new FlowChatMediaClickHandler$mediaPreviewObserverManager$2(this));
        this.i = LazyKt.lazy(FlowChatMediaClickHandler$openFeishuGalleryPreviewDependency$2.INSTANCE);
    }

    public final void a(final f r7, String r8, View r9, Rect r10, Drawable r11, pwa.a r12) {
        Intrinsics.checkNotNullParameter(r7, "mediaNode");
        Intrinsics.checkNotNullParameter(r8, "messageId");
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "bounds");
        AuthorizationServiceV2 r13 = owa.a.c();
        r13.a(r12.a, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        r13.a(r12.b, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        y6b.a r14 = this.e.getMessageById(r8);
        if (r14 != null) goto L6;
        return;
    L6:
        if ((r14.b() instanceof PostContentVO) == true) goto L8;
        return;
    L8:
        MediaInfo r15 = new MediaInfo();
        IMMediaExtend.a r16 = IMMediaExtend.q;
        r15.key = (String) r16.b(new FlowChatMediaClickHandler$handleMediaClick$mediaProperty$1$mediaInfo$1$1(r7));
        r15.url = (String) r16.b(new FlowChatMediaClickHandler$handleMediaClick$mediaProperty$1$mediaInfo$1$2(r7));
        RichTextElement.MediaProperty r17 = com.ss.android.lark.widget.richtext.d.b(r14.b().g(), r15);
        if (r17 != null) goto L11;
        return;
    L11:
        MediaImageSet r18 = com.ss.android.lark.parser.internal.d.d(r14, r17);
        r r19 = this.d.d0(r.class);
        if (r19 == null) goto L17;
        if (r18.getMessageIdentity() == null) goto L17;
        r18.getMessageIdentity().setSourceType(r19.e);
    L17:
        if (this.f == null) goto L19;
        MessageIdentity r20 = r18.getMessageIdentity();
        r20.setSourceId(r14.I());
        r20.setSourceType(r14.J());
    L19:
        List r21 = l.b(CollectionsKt.listOf(r18));
        FragmentActivity r22 = this.d.getContext();
        ArrayList r2 = new ArrayList();
        Intrinsics.checkNotNull(r21);
        Iterator r23 = ((ArrayList) r21).iterator();
    L21:
        if (r23.hasNext() == false) goto L32;
        PhotoItem r24 = (PhotoItem) r23.next();
        if ((r24 instanceof FlowPhotoItem) == true) goto L24;
        com.ss.android.lark.flow.chat.message.image.f r110 = com.ss.android.lark.flow.chat.message.image.f.a;
        Intrinsics.checkNotNull(r24);
        r2.add(com.ss.android.lark.flow.chat.message.image.f.e(r22, r24));
        goto L21
    L24:
        FlowPhotoItem r25 = (FlowPhotoItem) r24;
        if (r25.getMediaMessageType() == FlowMediaMessageType.Doubao) goto L28;
        if (r25.getMediaMessageType() != FlowMediaMessageType.Lark) goto L21;
    L28:
        m r26 = r25.getPreviewItem();
        if (r26 == null) goto L21;
        r2.add(r26);
        goto L21
    L32:
        int r27 = b.a;
        n r28 = new n(b.b(this.d), r2, false, new a(this), 8);
        ((kza.d) this.i.getValue()).T1(r28, r22);
    }
}
