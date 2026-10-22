package com.larus.bmhome.chat.layout.holder.image.bean;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageShareClickMethod;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OverviewClick", "LongPressMenuClick", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ImageShareClickMethod extends Enum<ImageShareClickMethod> {
    public static final ImageShareClickMethod LongPressMenuClick = null;
    public static final ImageShareClickMethod OverviewClick = null;
    public static final /* synthetic */ ImageShareClickMethod[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ImageShareClickMethod> getEntries() {
        return b;
    }

    static {
        ImageShareClickMethod r0 = new ImageShareClickMethod("OverviewClick", 0, "overview_click");
        OverviewClick = r0;
        ImageShareClickMethod r1 = new ImageShareClickMethod("LongPressMenuClick", 1, "overview_long_press");
        LongPressMenuClick = r1;
        ImageShareClickMethod[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static ImageShareClickMethod[] values() {
        return (ImageShareClickMethod[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ImageShareClickMethod valueOf(String r1) {
        return (ImageShareClickMethod) a.a(ImageShareClickMethod.class, r1);
    }

    public ImageShareClickMethod(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
