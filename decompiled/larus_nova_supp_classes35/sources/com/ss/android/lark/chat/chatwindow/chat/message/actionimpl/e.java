package com.ss.android.lark.chat.chatwindow.chat.message.actionimpl;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.utils.v0;
import com.ss.android.lark.chat.utils.w;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v17, types: [v5b.a] */
    /* JADX WARN: Type inference failed for: r7v10, types: [v5b.a] */
    /* JADX WARN: Type inference failed for: r7v14, types: [v5b.a] */
    /* JADX WARN: Type inference failed for: r7v18, types: [v5b.a] */
    /* JADX WARN: Type inference failed for: r9v12, types: [v5b.a] */
    public static void a(m2b.a r16, Activity r17, View r18, nya.a r19) {
        Intrinsics.checkNotNullParameter(r17, "activity");
        Intrinsics.checkNotNullParameter(r18, "itemView");
        Intrinsics.checkNotNullParameter(r19, "params");
        y6b.a r3 = r19.b;
        Scene r4 = Scene.Chat;
        ArrayList r5 = new ArrayList();
        List r6 = CollectionsKt.listOfNotNull(r3);
        Intrinsics.checkNotNullParameter(r6, "messageVoList");
        Intrinsics.checkNotNullParameter(r5, "imageSetList");
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L3:
        boolean r10 = false;
        if (r8.hasNext() == false) goto L8;
        Object r9 = r8.next();
        if (CollectionsKt.listOf(new Message.Type[]{Message.Type.IMAGE, Message.Type.MEDIA, Message.Type.POST, Message.Type.STICKER}).contains(((y6b.a) r9).getType()) == false) goto L3;
        r7.add(r9);
        goto L3
    L8:
        Iterator r11 = r7.iterator();
    L9:
        ActivityTransitionLauncher.LocationInfo r12 = null;
        if (r11.hasNext() == false) goto L55;
        y6b.a r13 = (y6b.a) r11.next();
        Message.Type r14 = r13.getType();
        if (r14 == Message.Type.IMAGE) goto L13;
        if (r14 != Message.Type.MEDIA) goto L28;
        T r15 = r13.b();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.MediaContentVO");
        MediaImageSet r20 = com.ss.android.lark.parser.internal.d.a((MediaContentVO) r15);
        MessageIdentity r110 = new MessageIdentity(r13.getId(), r13.getChatId(), r13.I(), r13.J());
        r110.setHideStickerSave(false);
        r20.setMessageIdentity(r110);
        ActivityTransitionLauncher.LocationInfo r21 = r13.b().a;
        if ((r21 instanceof MediaContent) == false) goto L25;
        r12 = (MediaContent) r21;
    L25:
        if (r12 == null) goto L9;
        r20.setResourceIsCleaned(r12.resourceIsCleaned());
        r20.setResourceCleanScene(r12.currentResourceScene());
        Intrinsics.checkNotNull(r20);
        r5.add(r20);
        goto L9
    L28:
        if (r14 != Message.Type.POST) goto L41;
        T r22 = r13.b().a;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        PostContent r23 = (PostContent) r22;
        if (r23.isGroupAnnouncement() == true) goto L9;
        RichText r24 = r23.getRichText();
        boolean r25 = r13.h();
        y6b.b r111 = r13.a();
        if (r111 == null) goto L35;
        r12 = r111.w;
    L35:
        List r26 = CollectionsKt.filterNotNull(v0.e(r24, r25, r12));
        Iterator r27 = r26.iterator();
    L37:
        if (r27.hasNext() == false) goto L39;
        w.a((ImageSet) r27.next(), r13.N());
        goto L37
    L39:
        r5.addAll(r26);
        goto L9
    L41:
        if (r14 != Message.Type.STICKER) goto L9;
        T r28 = r13.b().a;
        if ((r28 instanceof StickerContent) == false) goto L9;
        StickerContent r29 = (StickerContent) r28;
        String r30 = r29.getStickerSetId();
        if (r30 != null) goto L47;
    L50:
        boolean r31 = true;
    L51:
        if (r31 == false) goto L9;
        Image r32 = new Image();
        r32.setKey(r29.getKey());
        r32.setHeight(r29.getHeight());
        r32.setWidth(r29.getWidth());
        r32.setType(Image.Type.ENCRYPTED);
        r32.setResourceCleanScene(r29.currentResourceScene());
        r32.setResourceIsCleaned(r29.resourceIsCleaned());
        ImageSet r33 = new ImageSet();
        r33.setOrigin(r32);
        r33.setKey(r32.getKey());
        r33.setTranslated(false);
        r33.setResourceCleanScene(r29.currentResourceScene());
        r33.setResourceIsCleaned(r29.resourceIsCleaned());
        r5.add(r33);
        goto L9
    L47:
        if (r30.length() == 0) goto L50;
        r31 = false;
        goto L51
    L13:
        T r34 = r13.b().a;
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.ImageContent");
        ImageContent r35 = (ImageContent) r34;
        ImageSet r36 = r35.getImageSet();
        if (r36 == null) goto L16;
        r36.setResourceIsCleaned(r35.resourceIsCleaned());
    L16:
        if (r36 == null) goto L18;
        r36.setResourceCleanScene(r35.currentResourceScene());
    L18:
        if (r36 == null) goto L9;
        r5.add(r36);
        goto L9
    L55:
        int r37 = com.ss.android.lark.widget.photo.preview.utils.d.a;
        if (r3 == null) goto L58;
        String r38 = r3.getId();
    L59:
        List r39 = com.ss.android.lark.widget.photo.preview.utils.d.b(r5, r38);
        if (((ArrayList) r39).isEmpty() == false) goto L62;
        return;
    L62:
        if (r3 == null) goto L64;
        Message.Type r40 = r3.getType();
    L66:
        if (r40 != Message.Type.POST) goto L74;
        T r41 = r3.b().a;
        Intrinsics.checkNotNull(r41, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        PostContent r42 = (PostContent) r41;
        if (r42.isGroupAnnouncement() == true) goto L74;
        RichText r43 = r42.getRichText();
        Image r44 = r19.c;
        String r45 = r3.getId();
        boolean r46 = r3.h();
        y6b.b r47 = r3.a();
        if (r47 == null) goto L72;
        String r48 = r47.w;
    L73:
        PhotoItem r49 = v0.d(r43, r44, r45, r46, r48);
        PhotoUtilsNew r50 = PhotoUtilsNew.a;
        int r51 = PhotoUtilsNew.g(r39, r49);
    L75:
        Rect r52 = r19.a;
        if (r52 == null) goto L78;
        r12 = new ActivityTransitionLauncher.LocationInfo();
        int r53 = r52.left;
        r12.left = r53;
        int r54 = r52.top;
        r12.top = r54;
        r12.height = r52.bottom - r54;
        r12.width = r52.right - r53;
    L78:
        if (r16 == null) goto L82;
        Chat r55 = r16.getChat();
        if (r55 == null) goto L82;
        r10 = y0.c(r55);
    L82:
        int r56 = k.a;
        k.c r1 = k.a.a(r39, r51, r18);
        r1.c = r12;
        r1.d(r19.d);
        r1.q(Biz.Messenger, r4, r19.e);
        r1.a.putString("preview_id", r19.f);
        r1.a.putString("msg_link_token", r19.g);
        r1.h(r10);
        r1.r(r17);
        return;
    L72:
        r48 = null;
    L74:
        r51 = 0;
        goto L75
    L64:
        r40 = null;
        goto L66
    L58:
        r38 = null;
        goto L59
    }

    public static void b(m2b.a r0, View r1, Rect r2, y6b.a r3, Image r4, boolean r5, int r6) {
        Intrinsics.checkNotNullParameter(r0, "chatContext");
        Intrinsics.checkNotNullParameter(r1, "itemView");
        Intrinsics.checkNotNullParameter(r3, "messageVO");
        nya.a.a r7 = new nya.a.a();
        r7.a = r2;
        r7.b = r3;
        r7.c = r4;
        r7.d = false;
        r7.e = r6;
        nya.a r8 = new nya.a(r7);
        a(r0, r0.getContext(), r1, r8);
    }
}
