package com.larus.bmhome.chat.standarduikit.floatingthink.utils;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ClarificationAnswerAttachmentPreviewer {
    public static final ClarificationAnswerAttachmentPreviewer a = null;

    static {
        a = new ClarificationAnswerAttachmentPreviewer();
    }

    public ClarificationAnswerAttachmentPreviewer() {
    }

    public static String b(UplinkFileEntity r2) {
        if (n1.d(r2) == true) goto L5;
        return null;
    L5:
        UplinkEntityContent r3 = r2.getUplinkEntityContent();
        if (r3 == null) goto L22;
        Image r4 = r3.getUplinkImageInfo();
        if (r4 != null) goto L11;
        return null;
    L11:
        if (c(r4) == false) goto L13;
        return null;
    L13:
        String r5 = r4.key;
        if (r5 != null) goto L16;
        return null;
    L16:
        if (r5.length() <= 0) goto L18;
        boolean r0 = true;
    L19:
        if (r0 == true) goto L21;
        return null;
    L21:
        return r5;
    L18:
        r0 = false;
        goto L19
    L22:
        return null;
    }

    public static boolean c(Image r4) {
        ImageObj r0 = r4.imageThumb;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.url;
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L38;
        ImageObj r5 = r4.imageOri;
        if (r5 == null) goto L17;
        String r6 = r5.url;
    L18:
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == false) goto L39;
        ImageObj r8 = r4.previewImage;
        if (r8 == null) goto L28;
        r1 = r8.url;
    L28:
        if (r1 != null) goto L30;
    L33:
        boolean r9 = true;
    L34:
        if (r9 == false) goto L40;
        return false;
    L40:
        return true;
    L30:
        if (r1.length() == 0) goto L33;
        r9 = false;
        goto L34
    L39:
        return true;
    L20:
        if (r6.length() == 0) goto L23;
        r7 = false;
        goto L24
    L17:
        r6 = null;
        goto L18
    L38:
        return true;
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public static ImageObj a(ImageObj r8, String r9) {
        if (r8 == null) goto L6;
        ImageObj r10 = ImageObj.copy$default(r8, r9, 0, 0, null, null, 30, null);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return new ImageObj(r9, 0, 0, null, null, 30, null);
    }

    public final Object d(List<UplinkFileEntity> r43, Continuation<? super List<UplinkFileEntity>> r44) {
        List<UplinkFileEntity> r0 = r43;
        if ((r44 instanceof ClarificationAnswerAttachmentPreviewer$hydrateMissingImageUrls$1) == false) goto L7;
        ClarificationAnswerAttachmentPreviewer$hydrateMissingImageUrls$1 r2 = (ClarificationAnswerAttachmentPreviewer$hydrateMissingImageUrls$1) r44;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        r0 = (List) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L26:
        Map r6 = (Map) r1;
        if (r6.isEmpty() == false) goto L29;
        return r0;
    L29:
        List<UplinkFileEntity> r7 = r0;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L31:
        if (r9.hasNext() == false) goto L57;
        UplinkFileEntity r10 = (UplinkFileEntity) r9.next();
        String r11 = b(r10);
        if (r11 == null) goto L56;
        String r12 = (String) r6.get(r11);
        if (r12 == null) goto L56;
        if (r12.length() <= 0) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == true) goto L44;
        r12 = null;
    L44:
        if (r12 == null) goto L56;
        UplinkEntityContent r14 = r10.getUplinkEntityContent();
        if (r14 == null) goto L56;
        Image r15 = r14.getUplinkImageInfo();
        if (r15 == null) goto L56;
        if (c(r15) == true) goto L56;
        r10 = UplinkFileEntity.copy$default(r10, null, UplinkEntityContent.copy$default(r14, null, Image.copy$default(r15, null, null, a(r15.imageThumb, r12), a(r15.imageOri, r12), null, null, null, null, null, null, null, null, null, null, 16371, null), 1, null), null, null, null, null, null, null, null, false, null, null, null, null, 16381, null);
        goto L56
    L40:
        r13 = false;
    L56:
        r8.add(r10);
        goto L31
    L57:
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r0.iterator();
    L16:
        if (r17.hasNext() == false) goto L20;
        String r18 = b((UplinkFileEntity) r17.next());
        if (r18 == null) goto L16;
        r16.add(r18);
        goto L16
    L20:
        List r19 = CollectionsKt.distinct(r16);
        if (r19.isEmpty() == false) goto L23;
        return r0;
    L23:
        r2.L$0 = r0;
        r2.label = 1;
        r1 = BuildersKt.withContext(Dispatchers.getIO(), new ClarificationAnswerAttachmentPreviewer$fetchImageUrlMap$2(r19, null), r2);
        if (r1 != r4) goto L26;
        return r4;
    L7:
        r2 = new ClarificationAnswerAttachmentPreviewer$hydrateMissingImageUrls$1(this, r44);
        goto L8
    }
}
