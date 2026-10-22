package com.ss.android.lark.chat.utils;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.impl.preload.ImagePreloadManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.player.LarkPlayerUtils;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q0 {
    static {
    }

    @JvmStatic
    public static final void a(MessageInfo r11) {
        Intrinsics.checkNotNullParameter(r11, "info");
        Message r12 = r11.getMessage();
        Intrinsics.checkNotNullParameter(r12, "msg");
        CopyOnWriteArraySet<String> r1 = f.a;
        Intrinsics.checkNotNullParameter("chat", "scene");
        Intrinsics.checkNotNullParameter(r12, "msg");
        Log.i("ImagePreloadUtils", "preload, scene:chat, msg:" + r12.getId());
        boolean r3 = false;
        if (r12.isPreMessage() == false) goto L5;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L78;
        CopyOnWriteArraySet<String> r4 = f.a;
        if (r4.contains(r12.getId()) == true) goto L78;
        if (ImagePreloadManager.isLimitCount("chat") == true) goto L78;
        r4.add(r12.getId());
        Message.Type r5 = r12.getType();
        if (r5 != null) goto L23;
        int r6 = -1;
    L24:
        if (r6 != 1) goto L26;
        Image r7 = MessengerImageLoadController.c(MessageImageMonitor.Scene.IMAGE_MESSAGE.getValue(), ((ImageContent) r12.getContent()).getImageSet());
        if (r7 == null) goto L78;
        ImagePreloadManager.preload("chat", r12.getChatId(), r7.getKey(), r7.getFsUnit(), r7.getCrypto());
        goto L78
    L26:
        if (r6 != 2) goto L28;
        Image r8 = MessengerImageLoadController.c(MessageImageMonitor.Scene.MEDIA_COVER.getValue(), ((MediaContent) r12.getContent()).getImageSet());
        if (r8 == null) goto L78;
        ImagePreloadManager.preload("chat", r12.getChatId(), r8.getKey(), r8.getFsUnit(), r8.getCrypto());
        goto L78
    L28:
        if (r6 != 3) goto L78;
        RichText r9 = ((PostContent) r12.getContent()).getRichText();
        if (r9 == null) goto L78;
        List r10 = r9.getImageIds();
        if (r10 == null) goto L50;
        List r13 = CollectionsKt.filterNotNull(r10);
        if (r13 == null) goto L50;
        Iterator r14 = r13.iterator();
    L38:
        if (r14.hasNext() == false) goto L50;
        String r15 = (String) r14.next();
        RichText.RichTextElements r16 = r9.getElements();
        if (r16 == null) goto L46;
        Map r17 = r16.getDictionary();
        if (r17 == null) goto L46;
        RichTextElement r18 = (RichTextElement) r17.get(r15);
        if (r18 == null) goto L46;
        RichTextElement.RichTextProperty r19 = r18.getProperty();
    L48:
        if ((r19 instanceof RichTextElement.ImageProperty) == false) goto L38;
        RichTextElement.ImageProperty r20 = (RichTextElement.ImageProperty) r19;
        ImagePreloadManager.preload("chat", r12.getChatId(), r20.getThumbKey(), r20.getFsUnit(), r20.getCrypto());
    L46:
        r19 = null;
    L50:
        List r21 = r9.getMediaIds();
        if (r21 == null) goto L78;
        List r22 = CollectionsKt.filterNotNull(r21);
        if (r22 == null) goto L78;
        Iterator r23 = r22.iterator();
    L56:
        if (r23.hasNext() == false) goto L78;
        String r24 = (String) r23.next();
        RichText.RichTextElements r25 = r9.getElements();
        if (r25 == null) goto L64;
        Map r26 = r25.getDictionary();
        if (r26 == null) goto L64;
        RichTextElement r27 = (RichTextElement) r26.get(r24);
        if (r27 == null) goto L64;
        RichTextElement.RichTextProperty r28 = r27.getProperty();
    L66:
        if ((r28 instanceof RichTextElement.MediaProperty) == false) goto L56;
        String r29 = r12.getChatId();
        RichTextElement.MediaProperty r30 = (RichTextElement.MediaProperty) r28;
        com.ss.android.lark.widget.richtext.Image r31 = r30.getOriginImage();
        if (r31 == null) goto L70;
        String r32 = r31.getKey();
    L71:
        ImagePreloadManager.preload("chat", r29, r32, r30.getFsUnit(), r30.getCrypto());
        goto L56
    L70:
        r32 = null;
    L64:
        r28 = null;
        goto L66
    L23:
        r6 = f.a.a[r5.ordinal()];
    L78:
        CopyOnWriteArraySet<String> r33 = h.a;
        Intrinsics.checkNotNullParameter(r12, "msg");
        String r0 = r12.getId();
        if (r12.isRemoved() == false) goto L81;
    L86:
        boolean r34 = true;
    L87:
        if (r34 == true) goto L89;
        return;
    L89:
        if (r12.getType() != Message.Type.MEDIA) goto L91;
    L92:
        r3 = true;
    L93:
        if (r3 == false) goto L111;
        CopyOnWriteArraySet<String> r110 = h.a;
        if (r110.contains(r0) == true) goto L112;
        r110.add(r0);
        LarkPlayerUtils r111 = LarkPlayerUtils.a;
        if (r0 == null) goto L113;
        CoreThreadPool.getSerialTaskHandler().post(new com.ss.android.lark.player.player.i(r0));
        return;
    L113:
        return;
    L112:
        return;
    L111:
        return;
    L91:
        if (r12.getType() != Message.Type.POST) goto L93;
    L81:
        if (r12.isRecalled() == true) goto L86;
        if (r12.isBurned() == true) goto L86;
        r34 = false;
        goto L87
    L5:
        if (r12.isRecalled() == true) goto L13;
        if (r12.isRemoved() == true) goto L13;
        if (r12.isBurned() == true) goto L13;
        if (r12.isSecret() == true) goto L13;
        r2 = true;
        goto L14
    }

    @JvmStatic
    public static final void b(List<? extends MessageInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "infoList");
        Log.i("MessageUpdateReceiver", "onUpdateMessageInfo, list size:" + r2.size());
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        a((MessageInfo) r3.next());
        goto L4
    }
}
