package com.bytedance.ai.model.objects;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import w2.m;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/model/objects/PageType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FULL_PAGE", "POPUP_PAGE", "WIDGET_PAGE", "GEN_CARD", "FLOATING_VIEW", "OTHER", "toString", "", "toStringChn", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PageType extends Enum<PageType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PageType[] $VALUES = null;
    public static final PageType FLOATING_VIEW = null;
    public static final PageType FULL_PAGE = null;
    public static final PageType GEN_CARD = null;
    public static final PageType OTHER = null;
    public static final PageType POPUP_PAGE = null;
    public static final PageType WIDGET_PAGE = null;
    private final int value;

    private static final /* synthetic */ PageType[] $values() {
        return new PageType[]{FULL_PAGE, POPUP_PAGE, WIDGET_PAGE, GEN_CARD, FLOATING_VIEW, OTHER};
    }

    static {
        FULL_PAGE = new PageType("FULL_PAGE", 0, 0);
        POPUP_PAGE = new PageType("POPUP_PAGE", 1, 1);
        WIDGET_PAGE = new PageType("WIDGET_PAGE", 2, 2);
        GEN_CARD = new PageType("GEN_CARD", 3, 3);
        FLOATING_VIEW = new PageType("FLOATING_VIEW", 4, 4);
        OTHER = new PageType("OTHER", 5, 5);
        PageType[] r5 = $values();
        $VALUES = r5;
        $ENTRIES = EnumEntriesKt.enumEntries(r5);
    }

    private PageType(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static EnumEntries<PageType> getEntries() {
        return $ENTRIES;
    }

    public static PageType valueOf(String r5) {
        return (PageType) Enum.valueOf(PageType.class, r5);
    }

    public static PageType[] values() {
        return (PageType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(m.f22701a[ordinal()]) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "OTHER";
    L8:
        return "FLOATING_VIEW";
    L10:
        return "GEN_CARD";
    L12:
        return "WIDGET_PAGE";
    L14:
        return "POPUP_PAGE";
    L16:
        return "FULL_PAGE";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final String toStringChn() {
        switch(m.f22701a[ordinal()]) {
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "Other";
    L8:
        return "FLOATING_VIEW";
    L10:
        return "Widget";
    L11:
        return "Popup Page";
    L13:
        return "Full Page";
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
