package com.obric.assistant.settings.autogui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemBgType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "NORMAL", "TOP_CORNERS", "BOTTOM_CORNERS", "CORNERS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAutoGuiItemBgType extends Enum<ObricAutoGuiItemBgType> {
    public static final ObricAutoGuiItemBgType BOTTOM_CORNERS = null;
    public static final ObricAutoGuiItemBgType CORNERS = null;
    public static final ObricAutoGuiItemBgType NONE = null;
    public static final ObricAutoGuiItemBgType NORMAL = null;
    public static final ObricAutoGuiItemBgType TOP_CORNERS = null;
    public static final /* synthetic */ ObricAutoGuiItemBgType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ObricAutoGuiItemBgType> getEntries() {
        return b;
    }

    static {
        ObricAutoGuiItemBgType r0 = new ObricAutoGuiItemBgType("NONE", 0, 0);
        NONE = r0;
        ObricAutoGuiItemBgType r1 = new ObricAutoGuiItemBgType("NORMAL", 1, 1);
        NORMAL = r1;
        ObricAutoGuiItemBgType r3 = new ObricAutoGuiItemBgType("TOP_CORNERS", 2, 2);
        TOP_CORNERS = r3;
        ObricAutoGuiItemBgType r5 = new ObricAutoGuiItemBgType("BOTTOM_CORNERS", 3, 3);
        BOTTOM_CORNERS = r5;
        ObricAutoGuiItemBgType r7 = new ObricAutoGuiItemBgType("CORNERS", 4, 4);
        CORNERS = r7;
        ObricAutoGuiItemBgType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ObricAutoGuiItemBgType[] values() {
        return (ObricAutoGuiItemBgType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ObricAutoGuiItemBgType valueOf(String r1) {
        return (ObricAutoGuiItemBgType) r27.a.a(ObricAutoGuiItemBgType.class, r1);
    }

    public ObricAutoGuiItemBgType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
