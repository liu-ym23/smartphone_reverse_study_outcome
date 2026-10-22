package com.larus.bmhome.chat.layout.holder.progressloading;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/progressloading/ImageLoadingDrawPartType;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT_TOP_PART", "RIGHT_TOP_PART", "LEFT_BOTTOM_PART", "RIGHT_BOTTOM_PART", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ImageLoadingDrawPartType extends Enum<ImageLoadingDrawPartType> {
    public static final ImageLoadingDrawPartType LEFT_BOTTOM_PART = null;
    public static final ImageLoadingDrawPartType LEFT_TOP_PART = null;
    public static final ImageLoadingDrawPartType RIGHT_BOTTOM_PART = null;
    public static final ImageLoadingDrawPartType RIGHT_TOP_PART = null;
    public static final /* synthetic */ ImageLoadingDrawPartType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ImageLoadingDrawPartType> getEntries() {
        return b;
    }

    static {
        ImageLoadingDrawPartType r0 = new ImageLoadingDrawPartType("LEFT_TOP_PART", 0);
        LEFT_TOP_PART = r0;
        ImageLoadingDrawPartType r1 = new ImageLoadingDrawPartType("RIGHT_TOP_PART", 1);
        RIGHT_TOP_PART = r1;
        ImageLoadingDrawPartType r3 = new ImageLoadingDrawPartType("LEFT_BOTTOM_PART", 2);
        LEFT_BOTTOM_PART = r3;
        ImageLoadingDrawPartType r5 = new ImageLoadingDrawPartType("RIGHT_BOTTOM_PART", 3);
        RIGHT_BOTTOM_PART = r5;
        ImageLoadingDrawPartType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ImageLoadingDrawPartType[] values() {
        return (ImageLoadingDrawPartType[]) a.clone();
    }

    public static ImageLoadingDrawPartType valueOf(String r1) {
        return (ImageLoadingDrawPartType) r27.a.a(ImageLoadingDrawPartType.class, r1);
    }

    public ImageLoadingDrawPartType(String r1, int r2) {
        super(r1, r2);
    }
}
