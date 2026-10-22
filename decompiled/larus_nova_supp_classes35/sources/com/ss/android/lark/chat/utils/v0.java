package com.ss.android.lark.chat.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewKt;
import com.bytedance.lark.pb.basic.v1.ImageBaseAttribute;
import com.bytedance.lark.pb.basic.v1.ImageCropType;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.bytedance.lark.pb.basic.v1.SerCrypto;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.MarkdownImageSet;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v0 {

    public static class a {
        public final int a;
        public final ImageSetV2 b;

        public a(int r1, ImageSetV2 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static Drawable h(View r5) {
        if ((r5 instanceof ImageView) == false) goto L21;
        ukb.a r0 = ((ImageView) r5).getDrawable();
        if (r0 == null) goto L21;
        if ((r0 instanceof ukb.a) == false) goto L9;
        ukb.a r2 = new ukb.a(r5.getResources(), r0.getBitmap());
    L10:
        Drawable.ConstantState r3 = r0.getConstantState();
        if (r3 == null) goto L13;
        r2 = r3.newDrawable();
    L13:
        if (r2 == null) goto L21;
        r2.setBounds(r0.getBounds());
        return r2;
    L9:
        r2 = null;
    L21:
        return new BitmapDrawable(r5.getResources(), ViewKt.drawToBitmap(r5, Bitmap.Config.ARGB_8888));
    L18:
        e = move-exception;
        Log.e("PhotoUtils", "getThumbnailFromView: An Error Occurred " + e.getMessage());
        Log.e("PhotoUtils", "getThumbnailFromView: view is attached to window ? " + r5.isAttachedToWindow());
        return null;
    }

    public static boolean i(ImageSetV2 r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (TextUtils.isEmpty(r1.image_key) == true) goto L8;
        if (Boolean.TRUE.equals(r1.is_destroyed) == true) goto L8;
        return true;
    }

    public static ImageSet j(ImageSetV2 r6) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (i(r6) == false) goto L10;
        ImageSet r0 = new ImageSet();
        r0.setKey(r6.image_key);
        r0.setOrigin(b(r6, c(r6, new ImageCropType[]{ImageCropType.ORIGIN})));
        r0.setMiddle(b(r6, c(r6, new ImageCropType[]{ImageCropType.MIDDLE_WEBP, ImageCropType.MIDDLE})));
        r0.setThumbnail(b(r6, c(r6, new ImageCropType[]{ImageCropType.THUMB_WEBP, ImageCropType.THUMB})));
        r0.setIntact(b(r6, c(r6, new ImageCropType[]{ImageCropType.INTACT})));
        r0.setInlinePreview(r6.inline_preview);
        return r0;
    L10:
        return null;
    }

    public static Image b(ImageSetV2 r3, ImageSetV2.ImageAttribute r4) {
        ByteString r0 = null;
        if (r3 != null) goto L5;
    L25:
        return null;
    L5:
        if (TextUtils.isEmpty(r3.image_key) == true) goto L25;
        Image r1 = new Image();
        r1.setKey(r3.image_key);
        r1.setType(Image.Type.ENCRYPTED);
        r1.setFsUnit(r3.fs_unit);
        SerCrypto r5 = r3.crypto;
        if (r5 == null) goto L11;
        r0 = ByteString.of(r5.encode());
    L11:
        r1.setCrypto(r0);
        if (r4 == null) goto L24;
        ImageBaseAttribute r6 = r4.attribute;
        if (r6 == null) goto L24;
        Integer r7 = r6.width;
        Integer r8 = r6.height;
        int r2 = 0;
        if (r7 != null) goto L18;
        int r9 = 0;
    L19:
        r1.setWidth(r9);
        if (r8 == null) goto L23;
        r2 = r8.intValue();
    L23:
        r1.setHeight(r2);
        goto L24
    L18:
        r9 = r7.intValue();
    L24:
        return r1;
    }

    public static ImageSetV2.ImageAttribute c(ImageSetV2 r7, ImageCropType... r8) {
        if (CollectionUtils.isEmpty(r7.images) == false) goto L6;
        return null;
    L6:
        int r0 = r8.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L18;
        ImageCropType r3 = r8[r2];
        Iterator r4 = r7.images.iterator();
    L10:
        if (r4.hasNext() == false) goto L16;
        ImageSetV2.ImageAttribute r5 = (ImageSetV2.ImageAttribute) r4.next();
        if (r5 == null) goto L10;
        if (r5.type != r3) goto L10;
        return r5;
    L16:
        r2 = r2 + 1;
        goto L7
    L18:
        return (ImageSetV2.ImageAttribute) ListProtector.get(r7.images, 0);
    }

    public static PhotoItem g(ImageContentVO r1, String r2) {
        int r0 = com.ss.android.lark.widget.photo.preview.utils.d.a;
        return com.ss.android.lark.widget.photo.preview.utils.d.a(((ImageContent) r1.a).getImageSet(), r2);
    }

    public static List<ImageSet> e(RichText r4, boolean r5, String r6) {
        ArrayList r0 = new ArrayList();
        if (r4 != null) goto L5;
    L13:
        return r0;
    L5:
        if (com.ss.android.lark.widget.richtext.i.l(r4) == true) goto L13;
        if (CollectionUtils.isEmpty(r4.getElementIds()) == true) goto L13;
        List r1 = r4.getElementIds();
        Map r2 = r4.getElements().getDictionary();
        Iterator r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        k(r4, (RichTextElement) r2.get((String) r3.next()), r5, r0, r6);
        goto L11
    }

    public static ImageSet f(MessageInfo r2, StickerContent r3, boolean r4) {
        Image r0 = new Image();
        r0.setKey(r3.getKey());
        r0.setHeight(r3.getHeight());
        r0.setWidth(r3.getWidth());
        r0.setType(Image.Type.ENCRYPTED);
        r0.setResourceIsCleaned(r3.resourceIsCleaned());
        r0.setResourceCleanScene(r3.currentResourceScene());
        ImageSet r5 = new ImageSet();
        r5.setOrigin(r0);
        r5.setThumbnail(r0);
        r5.setKey(r0.getKey());
        r5.setMessageIdentity(r0.c(r2));
        r5.setTranslated(false);
        r5.setResourceIsCleaned(lpc.a.c(r2.getMessage()));
        r5.setResourceCleanScene(lpc.a.a(r2.getMessage()));
        r5.setHasPreviewPermission(r4);
        return r5;
    }

    public static void a(String r7, String r8, ImageSetV2 r9, List<a> r10) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return;
    L7:
        if (i(r9) == false) goto L55;
        int r1 = 0;
    L11:
        if (r1 >= r7.length()) goto L56;
        int r2 = r7.indexOf(r8, r1);
        if (r2 < 0) goto L14;
        int r3 = r7.lastIndexOf("](", r2);
        if (r3 < 0) goto L27;
        int r4 = r7.lastIndexOf("![", r3);
        if (r4 < 0) goto L27;
        if (r7.indexOf("](", r4 + 2) != r3) goto L27;
        if (r7.indexOf(")", r3 + 2) <= r2) goto L27;
    L28:
        if (r4 >= 0) goto L30;
        int r5 = r8.length();
    L42:
        r1 = r2 + r5;
        goto L11
    L30:
        ArrayList r6 = (ArrayList) r10;
        Iterator r11 = r6.iterator();
    L32:
        if (r11.hasNext() == false) goto L38;
        a r12 = (a) r11.next();
        if (r12.a != r4) goto L32;
        if (r12.b != r9) goto L32;
        boolean r13 = true;
    L39:
        if (r13 == true) goto L41;
        r6.add(new a(r4, r9));
    L41:
        r5 = r8.length();
        goto L42
    L38:
        r13 = false;
    L27:
        r4 = -1;
        goto L28
    L14:
        return;
    L56:
        return;
    }

    public static PhotoItem d(RichText r5, Image r6, String r7, boolean r8, String r9) {
        if (r5 == null) goto L44;
        if (r6 == null) goto L44;
        List<ImageSet> r10 = e(r5, r8, r9);
        if (CollectionUtils.isEmpty(r10) == false) goto L9;
        return null;
    L9:
        Iterator r11 = ((ArrayList) r10).iterator();
    L11:
        if (r11.hasNext() == false) goto L44;
        ImageSet r12 = (ImageSet) r11.next();
        String r13 = r6.getKey();
        Image r1 = r12.getOrigin();
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L15;
        String r3 = r12.getOrigin().getKey();
    L17:
        if (r12.getMiddle() == null) goto L19;
        String r4 = r12.getMiddle().getKey();
    L21:
        if (r12.getThumbnail() == null) goto L24;
        r2 = r12.getThumbnail().getKey();
    L24:
        if (TextUtils.isEmpty(r13) == true) goto L25;
        if (r13.equals(r3) == true) goto L43;
        if (r13.equals(r4) == true) goto L43;
        if (r13.equals(r2) == false) goto L11;
    L43:
        return com.ss.android.lark.widget.photo.preview.utils.d.a(r12, r7);
    L25:
        List r14 = r6.getUrls();
        Image r15 = r12.getOrigin();
        if (CollectionUtils.isNotEmpty(r14) == false) goto L11;
        if (r15 == null) goto L11;
        if (CollectionUtils.isNotEmpty(r15.getUrls()) == false) goto L11;
        String r16 = (String) ListProtector.get(r14, 0);
        if (TextUtils.isEmpty(r16) == true) goto L11;
        if (r16.equals(ListProtector.get(r15.getUrls(), 0)) == false) goto L11;
        return com.ss.android.lark.widget.photo.preview.utils.d.a(r12, r7);
    L19:
        r4 = BuildConfig.FLAVOR;
        goto L21
    L15:
        r3 = BuildConfig.FLAVOR;
    L44:
        return null;
    }

    public static void k(RichText r8, RichTextElement r9, boolean r10, List<ImageSet> r11, String r12) {
        Map r0 = r8.getElements().getDictionary();
        if (r9 != null) goto L5;
        return;
    L5:
        RichTextElement.MediaProperty r1 = r9.getProperty();
        boolean r3 = true;
        if ((r1 instanceof RichTextElement.MediaProperty) == false) goto L13;
        RichTextElement.MediaProperty r2 = r1;
        MediaImageSet r4 = new MediaImageSet();
        r4.setKey(r2.getKey());
        r4.setOrigin(com.ss.android.lark.parser.internal.i0.a(r2.getOriginImage()));
        r4.setThumbnail(com.ss.android.lark.parser.internal.i0.a(r2.getThumbImage()));
        r4.setFromMe(r10);
        r4.setSenderTenantId(r12);
        MediaExtra r5 = new MediaExtra();
        r5.setUrl(r2.getUrl());
        r5.setKey(r2.getKey());
        r5.setMime(r2.getMime());
        r5.setSize(r2.getSize());
        r5.setFilePath(r2.getOriginPath());
        r5.setDuration(r2.getDuration());
        r4.setMediaExtra(r5);
        r4.setResourceCleanScene(r2.getResourceCleanScene());
        if (r2.getResourceCleanScene() != null) goto L11;
        r3 = false;
    L11:
        r4.setResourceIsCleaned(r3);
        ((ArrayList) r11).add(r4);
    L56:
        List r13 = r9.getChildIds();
        if (r13 != null) goto L59;
        return;
    L59:
        if (r13.isEmpty() == true) goto L93;
        Iterator r14 = r13.iterator();
    L63:
        if (r14.hasNext() == false) goto L94;
        RichTextElement r6 = (RichTextElement) r0.get((String) r14.next());
        if (r6 == null) goto L63;
        k(r8, r6, r10, r11, r12);
        goto L63
    L94:
        return;
    L93:
        return;
    L13:
        if ((r1 instanceof RichTextElement.ImageProperty) == false) goto L20;
        RichTextElement.ImageProperty r7 = (RichTextElement.ImageProperty) r1;
        ImageSet r15 = new ImageSet();
        r15.setKey(r7.getOriginKey());
        com.ss.android.lark.widget.richtext.Image r16 = com.ss.android.lark.widget.richtext.d.h(r7, 0);
        com.ss.android.lark.widget.richtext.Image r17 = com.ss.android.lark.widget.richtext.d.h(r7, 1);
        com.ss.android.lark.widget.richtext.Image r18 = com.ss.android.lark.widget.richtext.d.h(r7, 2);
        r15.setOrigin(com.ss.android.lark.parser.internal.i0.a(r16));
        r15.setMiddle(com.ss.android.lark.parser.internal.i0.a(r17));
        r15.setThumbnail(com.ss.android.lark.parser.internal.i0.a(r18));
        r15.setOriginSource(r7.isOriginSource());
        r15.setOriginSize(r7.getOriginSize());
        r15.setInlinePreview(r7.getInlinePreview());
        r15.setFromMe(r10);
        r15.setSenderTenantId(r12);
        r15.setResourceCleanScene(r7.getResourceCleanScene());
        if (r7.getResourceCleanScene() != null) goto L18;
        r3 = false;
    L18:
        r15.setResourceIsCleaned(r3);
        ((ArrayList) r11).add(r15);
        goto L56
    L20:
        if ((r1 instanceof RichTextElement.MarkdownProperty) == false) goto L56;
        RichTextElement.MarkdownProperty r19 = (RichTextElement.MarkdownProperty) r1;
        ArrayList r20 = new ArrayList();
        Map r21 = r19.getImages();
        if (CollectionUtils.isEmpty(r21) == false) goto L24;
        HashMap r22 = new HashMap();
    L36:
        if (CollectionUtils.isEmpty(r22) == true) goto L55;
        String r23 = r19.getContent();
        ArrayList r24 = new ArrayList();
        if (TextUtils.isEmpty(r23) == true) goto L48;
        Iterator r25 = r22.entrySet().iterator();
    L42:
        if (r25.hasNext() == false) goto L48;
        Map.Entry r26 = (Map.Entry) r25.next();
        a(r23, (String) r26.getKey(), (ImageSetV2) r26.getValue(), r24);
        ImageSetV2 r27 = (ImageSetV2) r26.getValue();
        if (r27 == null) goto L42;
        if (TextUtils.equals((CharSequence) r26.getKey(), r27.image_key) == true) goto L42;
        a(r23, r27.image_key, r27, r24);
    L48:
        Collections.sort(r24, new u0());
        Iterator r28 = r24.iterator();
    L50:
        if (r28.hasNext() == false) goto L55;
        ImageSet r29 = j(((a) r28.next()).b);
        if (r29 == null) goto L50;
        r29.setFromMe(r10);
        r29.setSenderTenantId(r12);
        r20.add(r29);
    L55:
        ((ArrayList) r11).addAll(r20);
        goto L56
    L24:
        HashMap r30 = new HashMap(r21.size());
        Iterator r31 = r21.entrySet().iterator();
    L26:
        if (r31.hasNext() == false) goto L34;
        Map.Entry r32 = (Map.Entry) r31.next();
        MarkdownImageSet r33 = (MarkdownImageSet) r32.getValue();
        if (r33 == null) goto L26;
        ImageSetV2 r34 = r33.toImageSetV2();
        if (r34 == null) goto L26;
        r30.put((String) r32.getKey(), r34);
        goto L26
    L34:
        r22 = r30;
        goto L36
    }
}
