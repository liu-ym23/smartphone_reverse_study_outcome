package com.larus.bmhome.chat.layout.holder.image;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.creative.messagecard.bean.LoadingInfo;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ImageHolderDispatcher {
    public static final Lazy a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/image/ImageHolderDispatcher$GenerateImageType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE_SCROLL", "SINGLE_IMAGE", "IMAGE4", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum GenerateImageType extends Enum<GenerateImageType> {
        public static final GenerateImageType IMAGE4 = null;
        public static final GenerateImageType IMAGE_SCROLL = null;
        public static final GenerateImageType SINGLE_IMAGE = null;
        public static final /* synthetic */ GenerateImageType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<GenerateImageType> getEntries() {
            return b;
        }

        static {
            GenerateImageType r0 = new GenerateImageType("IMAGE_SCROLL", 0);
            IMAGE_SCROLL = r0;
            GenerateImageType r1 = new GenerateImageType("SINGLE_IMAGE", 1);
            SINGLE_IMAGE = r1;
            GenerateImageType r3 = new GenerateImageType("IMAGE4", 2);
            IMAGE4 = r3;
            GenerateImageType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static GenerateImageType[] values() {
            return (GenerateImageType[]) a.clone();
        }

        public static GenerateImageType valueOf(String r1) {
            return (GenerateImageType) r27.a.a(GenerateImageType.class, r1);
        }

        public GenerateImageType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            CreationTask r4 = (CreationTask) r2;
            int r0 = 0;
            if (r4 == null) goto L7;
            Integer r5 = r4.index;
            if (r5 == null) goto L7;
            int r6 = r5.intValue();
        L8:
            Integer r7 = Integer.valueOf(r6);
            CreationTask r8 = (CreationTask) r3;
            if (r8 == null) goto L14;
            Integer r9 = r8.index;
            if (r9 == null) goto L14;
            r0 = r9.intValue();
        L14:
            return ComparisonsKt.compareValues(r7, Integer.valueOf(r0));
        L7:
            r6 = 0;
            goto L8
        }
    }

    static {
        a = LazyKt.lazy(new l0());
    }

    public static ImageContentData a(Message r3) {
        if (r3 != null) goto L4;
    L13:
        return null;
    L4:
        if (r3.getContent() == null) goto L13;
    L11:
        e = move-exception;
        FLogger.a.e("ImageMessageUtil", String.valueOf(g2a.d.d(r3.getContent())), e);
        goto L13
    L7:
        if (com.larus.bmhome.chat.bean.d.a0(r3) == false) goto L10;
        r3 = b(r3);     // Catch: JsonSyntaxException -> L11
    L15:
        return r3;
    L10:
        r3 = (ImageContentData) GsonProtectorUtils.fromJson(new Gson(), r3.getContent(), ImageContentData.class);     // Catch: JsonSyntaxException -> L11
        goto L15
    }

    public static ImageContentData b(Message r25) {
        if (r25 == null) goto L60;
        CreationMsgContentData r1 = dp8.e.c(r25);
        if (r1 == null) goto L65;
        CreationInfo r2 = r1.creationInfo;
        if (r2 == null) goto L61;
        Map r3 = r2.taskInfo;
        if (r3 == null) goto L62;
        Collection r4 = r3.values();
        if (r4 == null) goto L63;
        List r5 = CollectionsKt.sortedWith(r4, new a());
        if (r5 == null) goto L64;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L54;
        CreationTask r8 = (CreationTask) r7.next();
        if (r8 == null) goto L21;
        Integer r9 = r8.status;
    L22:
        if (r9 != null) goto L25;
    L39:
        if (r9 != null) goto L42;
    L50:
        ImageItem r10 = null;
    L51:
        if (r10 == null) goto L17;
        r6.add(r10);
        goto L17
    L42:
        if (r9.intValue() != 4) goto L50;
        CreationAsset r11 = r8.asset;
        if (r11 == null) goto L50;
        UserCreationImage r12 = r11.imageContent;
        if (r12 == null) goto L50;
        ImageInfo r13 = r12.a;
        if (r13 == null) goto L50;
        r10 = new ImageItem(r13.e, r13.f, e0.a(r13.b), e0.a(r13.a), e0.a(r13.c), null, null, null, null, r13.g, r8.index, false, r8.id, null, 10720, null);
        goto L51
    L25:
        if (r9.intValue() != 1) goto L39;
        LoadingInfo r14 = r8.loadingInfo;
        if (r14 == null) goto L31;
        Long r15 = r14.width;
        if (r15 == null) goto L31;
        int r20 = (int) r15.longValue();
    L32:
        LoadingInfo r16 = r8.loadingInfo;
        if (r16 == null) goto L37;
        Long r17 = r16.height;
        if (r17 == null) goto L37;
        int r21 = (int) r17.longValue();
    L38:
        r10 = new ImageItem(null, null, null, new ImageEntity(null, null, r20, r21, null, 19, null), null, null, null, null, null, null, r8.index, true, r8.id, null, 9207, null);
    L37:
        r21 = 0;
    L31:
        r20 = 0;
        goto L32
    L21:
        r9 = null;
        goto L22
    L54:
        return new ImageContentData(r6);
    L64:
        return null;
    L63:
        return null;
    L62:
        return null;
    L61:
        return null;
    L65:
        return null;
    L60:
        return null;
    }

    public static GenerateImageType c(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        if (((Boolean) a.getValue()).booleanValue() == true) goto L19;
        if (com.larus.bmhome.chat.bean.d.a0(r1) == true) goto L19;
        ImageContentData r2 = a(r1);
        if (r2 == null) goto L14;
        List<ImageItem> r3 = r2.getImageList();
        if (r3 == null) goto L14;
        boolean r0 = true;
        if (r3.size() != 1) goto L14;
    L15:
        if (r0 == false) goto L21;
        return GenerateImageType.SINGLE_IMAGE;
    L21:
        return GenerateImageType.IMAGE4;
    L14:
        r0 = false;
    L19:
        return GenerateImageType.IMAGE_SCROLL;
    }
}
