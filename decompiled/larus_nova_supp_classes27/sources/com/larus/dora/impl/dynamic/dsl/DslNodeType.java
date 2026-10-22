package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslNodeType;", "", "<init>", "(Ljava/lang/String;I)V", "PAGE", "LAYER", "CARD", "TABS", "TAB", "SUBPAGE", "SUBPAGES", "NAV_BAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslNodeType extends Enum<DslNodeType> {

    @SerializedName("card")
    public static final DslNodeType CARD = null;

    @SerializedName("layer")
    public static final DslNodeType LAYER = null;

    @SerializedName("nav_bar")
    public static final DslNodeType NAV_BAR = null;

    @SerializedName("page")
    public static final DslNodeType PAGE = null;

    @SerializedName("subpage")
    public static final DslNodeType SUBPAGE = null;

    @SerializedName("subpages")
    public static final DslNodeType SUBPAGES = null;

    @SerializedName("tab")
    public static final DslNodeType TAB = null;

    @SerializedName("tabs")
    public static final DslNodeType TABS = null;
    public static final /* synthetic */ DslNodeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DslNodeType> getEntries() {
        return b;
    }

    static {
        DslNodeType r0 = new DslNodeType("PAGE", 0);
        PAGE = r0;
        DslNodeType r1 = new DslNodeType("LAYER", 1);
        LAYER = r1;
        DslNodeType r3 = new DslNodeType("CARD", 2);
        CARD = r3;
        DslNodeType r5 = new DslNodeType("TABS", 3);
        TABS = r5;
        DslNodeType r7 = new DslNodeType("TAB", 4);
        TAB = r7;
        DslNodeType r9 = new DslNodeType("SUBPAGE", 5);
        SUBPAGE = r9;
        DslNodeType r11 = new DslNodeType("SUBPAGES", 6);
        SUBPAGES = r11;
        DslNodeType r13 = new DslNodeType("NAV_BAR", 7);
        NAV_BAR = r13;
        DslNodeType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static DslNodeType[] values() {
        return (DslNodeType[]) a.clone();
    }

    public static DslNodeType valueOf(String r1) {
        return (DslNodeType) r27.a.a(DslNodeType.class, r1);
    }

    public DslNodeType(String r1, int r2) {
        super(r1, r2);
    }
}
