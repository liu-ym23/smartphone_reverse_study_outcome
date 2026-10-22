package com.larus.bmhome.view.screenmenu;

import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/MenuItemType;", "", "<init>", "(Ljava/lang/String;I)V", SuggestPromptErrorType.ERROR_TYPE_DEFAULT, "BUTTON", "SECTION_DIVIDER", "HEADER", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MenuItemType extends Enum<MenuItemType> {
    public static final MenuItemType BUTTON = null;
    public static final MenuItemType DEFAULT = null;
    public static final MenuItemType HEADER = null;
    public static final MenuItemType SECTION_DIVIDER = null;
    public static final /* synthetic */ MenuItemType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MenuItemType> getEntries() {
        return b;
    }

    static {
        MenuItemType r0 = new MenuItemType(SuggestPromptErrorType.ERROR_TYPE_DEFAULT, 0);
        DEFAULT = r0;
        MenuItemType r1 = new MenuItemType("BUTTON", 1);
        BUTTON = r1;
        MenuItemType r3 = new MenuItemType("SECTION_DIVIDER", 2);
        SECTION_DIVIDER = r3;
        MenuItemType r5 = new MenuItemType("HEADER", 3);
        HEADER = r5;
        MenuItemType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MenuItemType[] values() {
        return (MenuItemType[]) a.clone();
    }

    public static MenuItemType valueOf(String r1) {
        return (MenuItemType) r27.a.a(MenuItemType.class, r1);
    }

    public MenuItemType(String r1, int r2) {
        super(r1, r2);
    }
}
