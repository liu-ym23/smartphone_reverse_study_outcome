package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.flow.chat.message.image.model.FlowImageSet;
import com.ss.android.lark.flow.chat.message.image.model.FlowMediaMessageType;
import com.ss.android.lark.flow.chat.message.image.model.FlowPhotoItem;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kza.l;
import kza.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMediaPreviewUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(List r8, PhotoItem r9) {
        Intrinsics.checkNotNullParameter(r8, "photoItems");
        if (CollectionUtils.isEmpty(r8) == false) goto L6;
        Log.e("FlowMediaPreviewUtils", "photoItems is empty, jump to first Item");
        return -1;
    L6:
        if (r9 != null) goto L9;
        Log.e("FlowMediaPreviewUtils", "targetPhotoItem is null, jump to first Item");
        return -1;
    L9:
        int r3 = 0;
        if ((r9 instanceof FlowPhotoItem) == false) goto L73;
        FlowPhotoItem r10 = (FlowPhotoItem) r9;
        if (r10.getMediaMessageType() != FlowMediaMessageType.Lark) goto L51;
        m r11 = r10.getPreviewItem();
        if (r11 == null) goto L18;
        l r1 = r11.b;
        if (r1 == null) goto L18;
        Object r2 = r1.e;
    L20:
        if ((r2 instanceof ogb.a) == false) goto L100;
        Iterator r12 = r8.iterator();
    L23:
        if (r12.hasNext() == false) goto L130;
        int r4 = r3 + 1;
        PhotoItem r5 = (PhotoItem) r12.next();
        if ((r5 instanceof FlowPhotoItem) == false) goto L50;
        FlowPhotoItem r6 = (FlowPhotoItem) r5;
        if (r6.getMediaMessageType() != FlowMediaMessageType.Lark) goto L50;
        m r7 = r6.getPreviewItem();
        if (r7 == null) goto L31;
        l r13 = r7.b;
    L32:
        if (r13 == null) goto L34;
        Object r14 = r13.e;
    L36:
        if ((r14 instanceof ogb.a) == false) goto L50;
        if (Intrinsics.areEqual(r6.getPreviewItem().d, r11.d) == false) goto L50;
        DocImageProperty r15 = ((ogb.a) r14).a;
        if (r15 == null) goto L42;
        String r16 = r15.getToken();
    L43:
        DocImageProperty r17 = ((ogb.a) r2).a;
        if (r17 == null) goto L46;
        String r18 = r17.getToken();
    L48:
        if (Intrinsics.areEqual(r16, r18) == false) goto L50;
    L129:
        return r3;
    L46:
        r18 = null;
        goto L48
    L42:
        r16 = null;
        goto L43
    L34:
        r14 = null;
        goto L36
    L31:
        r13 = null;
    L50:
        r3 = r4;
        goto L23
    L130:
        return -1;
    L100:
        return -1;
    L18:
        r2 = null;
        goto L20
    L51:
        Iterator r19 = r8.iterator();
        int r0 = 0;
    L53:
        if (r19.hasNext() == false) goto L131;
        int r20 = r0 + 1;
        PhotoItem r21 = (PhotoItem) r19.next();
        if ((r21 instanceof FlowPhotoItem) == false) goto L72;
        FlowPhotoItem r22 = (FlowPhotoItem) r21;
        if (r22.getMediaMessageType() != r10.getMediaMessageType()) goto L72;
        if (r22.getPreviewItem() == null) goto L72;
        if (r10.getPreviewItem() == null) goto L72;
        if (r10.getPreviewItem().d.length() <= 0) goto L65;
        boolean r23 = true;
    L66:
        if (r23 == false) goto L72;
        if (Intrinsics.areEqual(r22.getPreviewItem().d, r10.getPreviewItem().d) == false) goto L72;
        if (r22.getPreviewItem().f != r10.getPreviewItem().f) goto L72;
        return r0;
    L65:
        r23 = false;
    L72:
        r0 = r20;
        goto L53
    L131:
        return -1;
    L73:
        Serializable r24 = r9.getLoadModel();
        Iterator r25 = r8.iterator();
    L75:
        if (r25.hasNext() == false) goto L132;
        int r26 = r3 + 1;
        PhotoItem r27 = (PhotoItem) r25.next();
        if ((r27 instanceof FlowPhotoItem) == true) goto L99;
        if (r27 == null) goto L99;
        PhotoUtilsNew r28 = PhotoUtilsNew.a;
        if (PhotoUtilsNew.b(r9, r27) == false) goto L99;
        if (PhotoUtilsNew.k(r27, r9) == true) goto L85;
        if (r24 != null) goto L88;
    L90:
        if (r24 != null) goto L99;
        if (r27.isVideo() == false) goto L99;
        if (r9.isVideo() == false) goto L99;
        if (Intrinsics.areEqual(r27.getMediaExtra(), r9.getMediaExtra()) == false) goto L99;
        Log.i("FlowMediaPreviewUtils", "find target media item by media extra index = " + r3);
        goto L129
    L88:
        if (r24.equals(r27.getLoadModel()) == false) goto L90;
        Log.i("FlowMediaPreviewUtils", "find target item by loadModel index = " + r3);
        goto L129
    L85:
        Log.i("FlowMediaPreviewUtils", "find target item by token index = " + r3);
    L99:
        r3 = r26;
        goto L75
    L132:
        return -1;
    }

    public static List b(Context r5, String r6, List r7, IMessageListViewModel r8, kza.d r9) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "clickedMsgId");
        Intrinsics.checkNotNullParameter(r9, "openFeishuGalleryPreviewDependency");
        List r0 = CollectionsKt.listOf(new Message.Type[]{Message.Type.IMAGE, Message.Type.MEDIA, Message.Type.DOUBAO, Message.Type.TEXT, Message.Type.STICKER, Message.Type.POST});
        h r1 = new h(r6, r7, r9, r5);
        if (r8 == null) goto L5;
        List r10 = r8.getAllImage(r6, false, r0, r1);
    L6:
        StringBuilder r11 = new StringBuilder("getAllPhotoItems, imageSetList: ");
        if (r10 == null) goto L9;
        Integer r12 = Integer.valueOf(r10.size());
    L10:
        r11.append(r12);
        Log.i("FlowMediaPreviewUtils", r11.toString());
        ArrayList r13 = new ArrayList();
        if (r10 == null) goto L24;
        Iterator r14 = r10.iterator();
    L14:
        if (r14.hasNext() == false) goto L24;
        ImageSet r15 = (ImageSet) r14.next();
        if ((r15 instanceof FlowImageSet) == true) goto L17;
        int r2 = com.ss.android.lark.widget.photo.preview.utils.d.a;
        Intrinsics.checkNotNullParameter(r15, "imageSet");
        List r16 = com.ss.android.lark.widget.photo.preview.utils.d.b(CollectionsKt.listOf(r15), "");
        if ((!((ArrayList) r16).isEmpty()) == false) goto L21;
        PhotoItem r17 = (PhotoItem) ListProtector.get(r16, 0);
    L22:
        if (r17 == null) goto L14;
        r13.add(r17);
        goto L14
    L21:
        r17 = null;
        goto L22
    L17:
        FlowImageSet r18 = (FlowImageSet) r15;
        r13.add(new FlowPhotoItem(r18.getMediaMessageType(), r18.getPreviewItem()));
    L24:
        Log.i("FlowMediaPreviewUtils", "getAllPhotoItems, photoItems: " + r13.size());
        return r13;
    L9:
        r12 = null;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    public static void c(Context r15, Fragment r16, List r17, m2b.a r18, int r19, IMessageListViewModel r20, kza.d r21, pgb.a r22) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "fragment");
        Intrinsics.checkNotNullParameter(r17, "photoItems");
        Intrinsics.checkNotNullParameter(r21, "openFeishuGalleryPreviewDependency");
        Intrinsics.checkNotNullParameter(r22, "mediaPreviewObserverManager");
        Log.i("FlowMediaPreviewUtils", "openGalleryPreview, photoItems: " + r17.size() + ", currentPosition: " + r19);
        if (r20 == null) goto L10;
        MutableLiveData r0 = r20.getCurrentChat();
        if (r0 == null) goto L10;
        Chat r1 = (Chat) r0.getValue();
        if (r1 == null) goto L10;
    L9:
        Chat r9 = r1;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r16), Dispatchers.getMain(), null, new FlowMediaPreviewUtils$openGalleryPreview$1(r17, r18, r19, r9.getId(), r21, r16, r15, r9, r22, null), 2, null);
        return;
    L10:
        if (r18 == null) goto L12;
        r1 = r18.getChat();
    L13:
        if (r1 != null) goto L9;
        return;
    L12:
        r1 = null;
        goto L13
    }
}
