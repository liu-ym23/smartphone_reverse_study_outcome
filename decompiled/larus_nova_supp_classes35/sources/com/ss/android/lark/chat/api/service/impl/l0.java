package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.media.v1.ChatResourceType;
import com.bytedance.lark.pb.media.v1.GetChatResourcesResponse;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l0 implements SdkSender.IParser<ImageHistoryResponse> {
    public final /* synthetic */ String a;

    public l0(String r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r18) throws IOException {
        GetChatResourcesResponse r0 = (GetChatResourcesResponse) GetChatResourcesResponse.ADAPTER.decode(r18);
        String r2 = this.a;
        ImageHistoryResponse r3 = new ImageHistoryResponse();
        if (r0 == null) goto L29;
        r3.setHasMoreAfter(r0.has_more_after.booleanValue());
        r3.setHasMoreBefore(r0.has_more_before.booleanValue());
        ArrayList r4 = new ArrayList();
        Iterator r1 = r0.messages.iterator();
    L7:
        if (r1.hasNext() == false) goto L28;
        GetChatResourcesResponse.MessageMeta r5 = (GetChatResourcesResponse.MessageMeta) r1.next();
        String r6 = r5.id;
        long r7 = r5.create_time.longValue();
        String r9 = r5.thread_id;
        int r10 = r5.thread_position.intValue();
        ArrayList r11 = new ArrayList();
        Iterator r8 = r5.resources.iterator();
    L10:
        if (r8.hasNext() == false) goto L27;
        GetChatResourcesResponse.Resource r12 = (GetChatResourcesResponse.Resource) r8.next();
        ChatResourceType r13 = r12.type;
        boolean r15 = true;
        if (r13 != ChatResourceType.IMAGE) goto L18;
        ImageSet r14 = new ImageSet();
        r14.setOriginSource(r12.is_origin_source.booleanValue());
        Iterator r19 = r1;
        r14.setOriginSize(r12.origin_size.longValue());
        if (r12.clean_resource_scene != null) goto L17;
        r15 = false;
    L17:
        r14.setResourceIsCleaned(r15);
        ResourceCleanScene.a r16 = ResourceCleanScene.Companion;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r17 = r12.clean_resource_scene;
        r16.getClass();
        r14.setResourceCleanScene(ResourceCleanScene.a.a(r17));
        com.bytedance.lark.pb.basic.v1.ImageSet r20 = r12.image;
        ImageSet r110 = r14;
    L25:
        ResourceCleanScene.a r21 = ResourceCleanScene.Companion;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r111 = r12.clean_resource_scene;
        r21.getClass();
        com.ss.android.lark.parser.internal.o.b(r20, r110, ResourceCleanScene.a.a(r111));
        MessageIdentity r22 = new MessageIdentity(r6, r2);
        r22.setCreateTime(r7);
        r22.setThreadId(r9);
        r22.setThreadPosition(r10);
        r22.setSourceType(Message.SourceType.TYPE_FROM_CHAT_HISTORY);
        r110.setMessageIdentity(r22);
        r11.add(r110);
    L26:
        r1 = r19;
        goto L10
    L18:
        r19 = r1;
        if (r13 != ChatResourceType.VIDEO) goto L26;
        MediaExtra r23 = com.ss.android.lark.parser.internal.h.b(r12.video);
        MediaImageSet r112 = new MediaImageSet();
        r112.setMediaExtra(r23);
        if (r12.clean_resource_scene != null) goto L24;
        r15 = false;
    L24:
        r112.setResourceIsCleaned(r15);
        ResourceCleanScene.a r24 = ResourceCleanScene.Companion;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r25 = r12.clean_resource_scene;
        r24.getClass();
        r112.setResourceCleanScene(ResourceCleanScene.a.a(r25));
        r20 = r12.video.media_content.image;
        r110 = r112;
        goto L25
    L27:
        r4.addAll(r11);
        goto L7
    L28:
        r3.setImageSetList(r4);
    L29:
        ImSdkProxy.d().b(r3.getImageSetList());
        return r3;
    }
}
