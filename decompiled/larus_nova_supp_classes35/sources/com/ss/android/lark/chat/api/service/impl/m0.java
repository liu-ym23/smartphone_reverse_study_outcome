package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.media.v1.ChatResourceType;
import com.bytedance.lark.pb.media.v1.GetChatResourcesResponse;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.chat.entity.doubao.DoubaoImageSet;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m0 implements SdkSender.IParser<ImageHistoryResponse> {
    public final /* synthetic */ String a;

    public m0(String r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r18) throws IOException {
        GetChatResourcesResponse r0 = (GetChatResourcesResponse) GetChatResourcesResponse.ADAPTER.decode(r18);
        String r2 = this.a;
        ImageHistoryResponse r3 = new ImageHistoryResponse();
        if (r0 == null) goto L55;
        r3.setHasMoreAfter(r0.has_more_after.booleanValue());
        r3.setHasMoreBefore(r0.has_more_before.booleanValue());
        ArrayList r4 = new ArrayList();
        int r5 = com.ss.android.lark.parser.internal.c.a;
        List r6 = r0.messages;
        if (r6 != null) goto L8;
        Log.e("FlowLoadMoreUtils", "getMessageWithMessageMeta, messageMetaList is null");
        Map r7 = MapsKt.emptyMap();
    L22:
        Iterator r1 = r0.messages.iterator();
    L24:
        if (r1.hasNext() == false) goto L54;
        GetChatResourcesResponse.MessageMeta r8 = (GetChatResourcesResponse.MessageMeta) r1.next();
        ArrayList r9 = new ArrayList();
        String r10 = r8.id;
        if (TextUtils.isEmpty(r10) == false) goto L28;
    L27:
        Iterator r16 = r1;
        r4.addAll(r9);
        r1 = r16;
        goto L24
    L28:
        Message r11 = (Message) r7.get(r10);
        if (r11 == null) goto L27;
        long r12 = r8.create_time.longValue();
        String r14 = r8.thread_id;
        int r15 = r8.thread_position.intValue();
        if (r11.getType() != Message.Type.DOUBAO) goto L34;
        DoubaoImageSet r13 = new DoubaoImageSet();
        r13.setId(r10);
        r13.setDoubaoContent(r11.getContent());
        MessageIdentity r17 = new MessageIdentity(r10, r2);
        r17.setCreateTime(r12);
        r17.setThreadId(r14);
        r17.setThreadPosition(r15);
        r17.setSourceType(Message.SourceType.TYPE_FROM_CHAT_HISTORY);
        r13.setMessageIdentity(r17);
        r9.add(r13);
        goto L27
    L34:
        Iterator r19 = r8.resources.iterator();
    L36:
        if (r19.hasNext() == false) goto L27;
        GetChatResourcesResponse.Resource r20 = (GetChatResourcesResponse.Resource) r19.next();
        ChatResourceType r21 = r20.type;
        if (r21 != ChatResourceType.IMAGE) goto L44;
        ImageSet r22 = new ImageSet();
        r22.setOriginSource(r20.is_origin_source.booleanValue());
        Iterator r110 = r1;
        r22.setOriginSize(r20.origin_size.longValue());
        if (r20.clean_resource_scene == null) goto L42;
        boolean r23 = true;
    L43:
        r22.setResourceIsCleaned(r23);
        ResourceCleanScene.a r24 = ResourceCleanScene.Companion;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r25 = r20.clean_resource_scene;
        r24.getClass();
        r22.setResourceCleanScene(ResourceCleanScene.a.a(r25));
        com.bytedance.lark.pb.basic.v1.ImageSet r26 = r20.image;
        ImageSet r27 = r22;
    L51:
        ResourceCleanScene.a r28 = ResourceCleanScene.Companion;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r29 = r20.clean_resource_scene;
        r28.getClass();
        com.ss.android.lark.parser.internal.o.b(r26, r27, ResourceCleanScene.a.a(r29));
        MessageIdentity r30 = new MessageIdentity(r10, r2);
        r30.setCreateTime(r12);
        r30.setThreadId(r14);
        r30.setThreadPosition(r15);
        r30.setSourceType(Message.SourceType.TYPE_FROM_CHAT_HISTORY);
        r27.setMessageIdentity(r30);
        r9.add(r27);
    L52:
        r1 = r110;
        goto L36
    L42:
        r23 = false;
        goto L43
    L44:
        r110 = r1;
        if (r21 != ChatResourceType.VIDEO) goto L52;
        MediaExtra r31 = com.ss.android.lark.parser.internal.h.b(r20.video);
        MediaImageSet r32 = new MediaImageSet();
        r32.setMediaExtra(r31);
        if (r20.clean_resource_scene == null) goto L49;
        boolean r33 = true;
    L50:
        r32.setResourceIsCleaned(r33);
        ResourceCleanScene.a r34 = ResourceCleanScene.Companion;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r35 = r20.clean_resource_scene;
        r34.getClass();
        r32.setResourceCleanScene(ResourceCleanScene.a.a(r35));
        r26 = r20.video.media_content.image;
        r27 = r32;
        goto L51
    L49:
        r33 = false;
        goto L50
    L54:
        r3.setImageSetList(r4);
        goto L55
    L8:
        ArrayList r111 = new ArrayList();
        Iterator r36 = r6.iterator();
    L10:
        if (r36.hasNext() == false) goto L17;
        Object r112 = r36.next();
        if (((GetChatResourcesResponse.MessageMeta) r112).id == null) goto L14;
        boolean r113 = true;
    L15:
        if (r113 == false) goto L10;
        r111.add(r112);
        goto L10
    L14:
        r113 = false;
        goto L15
    L17:
        ArrayList r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r114 = r111.iterator();
    L19:
        if (r114.hasNext() == false) goto L21;
        r37.add(((GetChatResourcesResponse.MessageMeta) r114.next()).id);
        goto L19
    L21:
        Map r115 = ImSdkService.f().ta(r37);
        Log.i("FlowLoadMoreUtils", "getMessageWithMessageMeta, messageMetaList: " + r6.size() + ", messageIds: " + r37.size() + ", messageList: " + r115.size());
        r7 = r115;
    L55:
        return r3;
    }
}
