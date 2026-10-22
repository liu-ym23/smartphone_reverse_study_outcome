package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.ImFileAuthorityChecker;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.doubao.DoubaoImageSet;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.flow.chat.message.image.model.FlowMediaMessageType;
import com.ss.android.lark.flow.chat.message.image.model.FlowPhotoItem;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kza.l;
import kza.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List a(Context r26, Chat r27, String r28, String r29, ImageHistoryResponse.Direction r30, int r31, kza.d r32) {
        Intrinsics.checkNotNullParameter(r26, "context");
        Intrinsics.checkNotNullParameter(r27, "chat");
        Intrinsics.checkNotNullParameter(r28, "chatId");
        Intrinsics.checkNotNullParameter(r29, "messageId");
        Intrinsics.checkNotNullParameter(r30, "direction");
        Intrinsics.checkNotNullParameter(r32, "dependency");
        IChatService r7 = ChatAppContainerV1.a.j0();
        p r8 = ImSdkService.f();
        ImageHistoryResponse r9 = r7.Ne(r28, r29, r30, r31);
        StringBuilder r10 = new StringBuilder("loadMoreInner, response imageSetList: ");
        if (r9 == null) goto L7;
        List r12 = r9.getImageSetList();
        if (r12 == null) goto L7;
        Integer r13 = Integer.valueOf(r12.size());
    L8:
        r10.append(r13);
        r10.append(", hasMoreBefore: ");
        if (r9 == null) goto L11;
        Boolean r14 = Boolean.valueOf(r9.isHasMoreBefore());
    L12:
        r10.append(r14);
        r10.append(", hasMoreAfter: ");
        if (r9 == null) goto L15;
        Boolean r15 = Boolean.valueOf(r9.isHasMoreAfter());
    L16:
        r10.append(r15);
        r10.append(", messageId: ");
        r10.append(r29);
        r10.append(", direction: ");
        r10.append(r30);
        r10.append(", pageSize: ");
        r10.append(r31);
        Log.i("FlowLoadMoreUtils", r10.toString());
        if (r9 != null) goto L20;
        LinkedList r5 = new ArrayList();
    L42:
        Log.i("FlowLoadMoreUtils", "loadMoreInner, chatId: " + r28 + ", messageId: " + r29 + ", direction: " + r30 + ", ret size: " + r5.size());
        Log.i("FlowLoadMoreUtils", "loadMore, imageSetList: " + r5.size() + ", messageId: " + r29 + ", direction: " + r30 + ", pageSize: " + r31);
        kza.d r0 = r32;
        Intrinsics.checkNotNullParameter(r0, "dependency");
        ArrayList r1 = new ArrayList();
        if (r5.isEmpty() == true) goto L95;
        Iterator r6 = r5.iterator();
    L47:
        if (r6.hasNext() == false) goto L95;
        DoubaoImageSet r11 = (ImageSet) r6.next();
        if (r11 == null) goto L47;
        if ((r11 instanceof DoubaoImageSet) == false) goto L67;
        DoubaoImageSet r16 = r11;
        Object r17 = r16.getDoubaoContent();
        if (r17 == null) goto L47;
        List r18 = r0.x0(r17);
        if (r18 == null) goto L66;
        Iterator r19 = r18.iterator();
    L60:
        if (r19.hasNext() == false) goto L66;
        m r110 = (m) r19.next();
        GalleryType r111 = r110.getType();
        l r20 = r110.b;
        kza.p r2 = r110.c;
        String r112 = r16.getId();
        Iterator r24 = r6;
        if (r112 != null) goto L64;
        String r21 = "";
    L65:
        r1.add(new FlowPhotoItem(FlowMediaMessageType.Doubao, new m(r111, r20, r2, r21, r110.e, r110.f, r110.g)));
        r6 = r24;
        r16 = r16;
        goto L60
    L64:
        r21 = r112;
    L66:
        Iterator r25 = r6;
    L94:
        r0 = r32;
        r6 = r25;
        goto L47
    L67:
        r25 = r6;
        Image r3 = r11.getOrigin();
        if (r3 != null) goto L71;
        Log.e("FlowLoadMoreUtils", "PhotoItem getOrigin image is empty");
        goto L94
    L71:
        if (TextUtils.isEmpty(r3.getKey()) == true) goto L73;
        Object r22 = new EncryptImage(r3.getKey(), r3.getFsUnit(), r3.getCrypto());
    L84:
        String r23 = r3.getKey();
        String r33 = r3.getToken();
        MessageIdentity r113 = r11.getMessageIdentity();
        if (r113 != null) goto L87;
    L88:
        r113 = new MessageIdentity("", "");
    L89:
        r113.setSenderTenantId(r11.getSenderTenantId());
        PhotoItem r4 = new PhotoItem().setPaths(r3.getUrls()).setImageKey(r23).setLoadModel(r22);
        int r34 = com.ss.android.lark.widget.photo.preview.utils.d.a;
        PhotoItem r35 = r4.setIntactPicInfo(com.ss.android.lark.widget.photo.preview.utils.d.d(r11.getIntact())).setOriginPicInfo(com.ss.android.lark.widget.photo.preview.utils.d.d(r11.getOrigin())).setMiddlePicInfo(com.ss.android.lark.widget.photo.preview.utils.d.d(r11.getMiddle())).setThumbnailPicInfo(com.ss.android.lark.widget.photo.preview.utils.d.d(r11.getThumbnail())).setInlinePreview(r11.getInlinePreview()).setMessageIdentity(r113).setType(2).setToken(r33);
        Intrinsics.checkNotNullParameter(r11, "imageSet");
        if ((r11 instanceof MediaImageSet) == false) goto L92;
        MediaExtra r36 = ((MediaImageSet) r11).getMediaExtra();
    L93:
        PhotoItem r37 = r35.setMediaExtra(r36).setOriginSource(r11.isOriginSource()).setHasPreviewPermission(r11.isHasPreviewPermission()).setOriginSize(r11.getOriginSize()).setEntityId(r113.getSourceId()).setReceiveAuthorizationStateValue(r11.getReceiveAuthorizationStateValue()).setValidateIMFileResult(r11.getValidateIMFileResult()).setResourceIsCleaned(com.ss.android.lark.chat.entity.image.a.a(r11)).setResourceCleanScene(r11.getResourceCleanScene());
        r37.getTranslateProperty().setTranslated(r11.isTranslated());
        r37.getPhotoState().setFromMe(r11.isFromMe());
        r1.add(r37);
        goto L94
    L92:
        r36 = null;
        goto L93
    L87:
        if (TextUtils.isEmpty(r113.getMessageId()) == false) goto L89;
    L73:
        if (TextUtils.isEmpty(r3.getToken()) == true) goto L79;
        Log.e("FlowLoadMoreUtils", "PhotoItem secure key is empty, use token directly.");
        r3.setKey(r3.getToken());
        if (CollectionUtils.isEmpty(r3.getUrls()) == true) goto L81;
        r22 = ListProtector.get(r3.getUrls(), 0);
    L81:
        r22 = null;
        goto L84
    L79:
        if ((r11 instanceof MediaImageSet) == false) goto L82;
        Log.e("FlowLoadMoreUtils", "Media PhotoItem set imageSet null ");
        goto L81
    L82:
        Log.e("FlowLoadMoreUtils", "PhotoItem key and token is empty, filter");
    L95:
        Log.i("FlowLoadMoreUtils", "loadMore, photoItemList: " + r1.size() + ", messageId: " + r29 + ", direction: " + r30 + ", pageSize: " + r31);
        ArrayList r38 = new ArrayList();
        Iterator r39 = r1.iterator();
    L97:
        if (r39.hasNext() == false) goto L114;
        PhotoItem r40 = (PhotoItem) r39.next();
        if ((r40 instanceof FlowPhotoItem) == false) goto L111;
        FlowPhotoItem r41 = (FlowPhotoItem) r40;
        if (r41.getMediaMessageType() == FlowMediaMessageType.Doubao) goto L103;
    L106:
        StringBuilder r42 = new StringBuilder("transfer FlowPhotoItem error, mediaMessageType: ");
        r42.append(r41.getMediaMessageType());
        r42.append(", previewItem: ");
        if (r41.getPreviewItem() != null) goto L109;
        boolean r43 = true;
    L110:
        r42.append(r43);
        Log.e("FlowLoadMoreUtils", r42.toString());
        m r44 = null;
    L112:
        if (r44 == null) goto L97;
        r38.add(r44);
        goto L97
    L109:
        r43 = false;
        goto L110
    L103:
        if (r41.getPreviewItem() == null) goto L106;
        r44 = r41.getPreviewItem();
        goto L112
    L111:
        r44 = f.e(r26, r40);
        goto L112
    L114:
        Log.i("FlowLoadMoreUtils", "loadMore, result: " + r38.size() + ", messageId: " + r29 + ", direction: " + r30 + ", pageSize: " + r31);
        return r38;
    L20:
        List r45 = r9.getImageSetList();
        Chat r46 = r7.getChatById(r28);
        ArrayList r114 = new ArrayList(r45.size());
        Iterator r115 = r45.iterator();
    L22:
        if (r115.hasNext() == false) goto L24;
        r114.add(((ImageSet) r115.next()).getMessageIdentity().getMessageId());
        r115 = r115;
        goto L22
    L24:
        ArrayList r116 = new ArrayList(r8.W5(r114).values());
        Log.i("FlowLoadMoreUtils", "loadMoreInner, before doLocalAuthority, messageInfoList: " + r116.size() + ", messageId: " + r29 + ", direction: " + r30 + ", pageSize: " + r31);
        new com.ss.android.lark.chat.chatwindow.chat.model.viewdata.b(new ImFileAuthorityChecker("FlowLoadMoreUtils"), FeatureGatingModule.getFeatureGatingService(), ChatAppContainerV1.a.M()).a(r46, r116);
        Log.i("FlowLoadMoreUtils", "loadMoreInner, after doLocalAuthority, messageInfoList: " + r116.size() + ", messageId: " + r29 + ", direction: " + r30 + ", pageSize: " + r31);
        HashMap r47 = new HashMap(r116.size());
        Iterator r48 = r116.iterator();
    L26:
        if (r48.hasNext() == false) goto L28;
        MessageInfo r49 = (MessageInfo) r48.next();
        r47.put(r49.getId(), r49.getMessage());
        goto L26
    L28:
        r5 = new LinkedList();
        Iterator r50 = r45.iterator();
    L30:
        if (r50.hasNext() == false) goto L42;
        ImageSet r51 = (ImageSet) r50.next();
        String r117 = r51.getMessageIdentity().getMessageId();
        if (r47.containsKey(r117) == false) goto L34;
        Message r118 = (Message) r47.get(r117);
    L35:
        if (r118 == null) goto L37;
        ValidateIMFileResult r119 = r118.getValidateIMFileResult();
    L38:
        if (r119 == null) goto L40;
        IMFileResult r120 = r119.getResultType();
    L41:
        MessagePermissionUtil.ReceiveAuthorizationState r121 = MessagePermissionUtil.h(r120);
        r51.setHasPreviewPermission(MessagePermissionUtil.d(r118, r46.getAnonymousId(), null));
        r51.setReceiveAuthorizationStateValue(r121.getValue());
        r51.setValidateIMFileResult(r119);
        r5.addFirst(r51);
        r47 = r47;
        r46 = r46;
        goto L30
    L40:
        r120 = null;
        goto L41
    L37:
        r119 = null;
        goto L38
    L34:
        r118 = null;
        goto L35
    L15:
        r15 = null;
        goto L16
    L11:
        r14 = null;
    L7:
        r13 = null;
        goto L8
    }
}
