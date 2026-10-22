package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslTemplateType;", "", "<init>", "(Ljava/lang/String;I)V", "PRODUCT_ITEM", "HISTORY_DEVICE_LIST", "PRODUCT_DISPLAY", "SINGLE_DEVICE_PRODUCT_DISPLAY", "SIMPLE_TAB", "DUO_GROUP", "FUNCTION_INTRODUCTION_SET", "BANNER", "GENERAL_GROUP", "RECONNECT_UNBIND_PANEL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslTemplateType extends Enum<DslTemplateType> {

    @SerializedName("banner")
    public static final DslTemplateType BANNER = null;

    @SerializedName("duo_group")
    public static final DslTemplateType DUO_GROUP = null;

    @SerializedName("function_introduction_set")
    public static final DslTemplateType FUNCTION_INTRODUCTION_SET = null;

    @SerializedName("general_group")
    public static final DslTemplateType GENERAL_GROUP = null;

    @SerializedName("history_device_list")
    public static final DslTemplateType HISTORY_DEVICE_LIST = null;

    @SerializedName("product_display")
    public static final DslTemplateType PRODUCT_DISPLAY = null;

    @SerializedName("product_item")
    public static final DslTemplateType PRODUCT_ITEM = null;

    @SerializedName("reconnect_unbind_panel")
    public static final DslTemplateType RECONNECT_UNBIND_PANEL = null;

    @SerializedName("simple_tab")
    public static final DslTemplateType SIMPLE_TAB = null;

    @SerializedName("single_device_product_display")
    public static final DslTemplateType SINGLE_DEVICE_PRODUCT_DISPLAY = null;
    public static final /* synthetic */ DslTemplateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DslTemplateType> getEntries() {
        return b;
    }

    static {
        DslTemplateType r0 = new DslTemplateType("PRODUCT_ITEM", 0);
        PRODUCT_ITEM = r0;
        DslTemplateType r1 = new DslTemplateType("HISTORY_DEVICE_LIST", 1);
        HISTORY_DEVICE_LIST = r1;
        DslTemplateType r3 = new DslTemplateType("PRODUCT_DISPLAY", 2);
        PRODUCT_DISPLAY = r3;
        DslTemplateType r5 = new DslTemplateType("SINGLE_DEVICE_PRODUCT_DISPLAY", 3);
        SINGLE_DEVICE_PRODUCT_DISPLAY = r5;
        DslTemplateType r7 = new DslTemplateType("SIMPLE_TAB", 4);
        SIMPLE_TAB = r7;
        DslTemplateType r9 = new DslTemplateType("DUO_GROUP", 5);
        DUO_GROUP = r9;
        DslTemplateType r11 = new DslTemplateType("FUNCTION_INTRODUCTION_SET", 6);
        FUNCTION_INTRODUCTION_SET = r11;
        DslTemplateType r13 = new DslTemplateType("BANNER", 7);
        BANNER = r13;
        DslTemplateType r15 = new DslTemplateType("GENERAL_GROUP", 8);
        GENERAL_GROUP = r15;
        DslTemplateType r14 = new DslTemplateType("RECONNECT_UNBIND_PANEL", 9);
        RECONNECT_UNBIND_PANEL = r14;
        DslTemplateType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static DslTemplateType[] values() {
        return (DslTemplateType[]) a.clone();
    }

    public static DslTemplateType valueOf(String r1) {
        return (DslTemplateType) r27.a.a(DslTemplateType.class, r1);
    }

    public DslTemplateType(String r1, int r2) {
        super(r1, r2);
    }
}
