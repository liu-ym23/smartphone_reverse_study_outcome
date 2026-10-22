package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/menu/item/MenuActionType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "SAVE_IMAGE", "SAVE_SEARCH_IMAGE", "SHARE_MESSAGE", "SHARE_IMAGE", "SHARE_SEARCH_IMAGE", "REPORT", "REPORT_MUSIC", "EXPORT_FILE", "MORE", "SAVE_VIDEO", "SHARE_VIDEO", "PODCAST", "DOWNLOAD_FILE", "FULLSCREEN_CODE", "COPY_CODE", "SAVE_CODE_IMAGE", "COPY_CODE_IMAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MenuActionType extends Enum<MenuActionType> {
    public static final MenuActionType COPY_CODE = null;
    public static final MenuActionType COPY_CODE_IMAGE = null;
    public static final MenuActionType DOWNLOAD_FILE = null;
    public static final MenuActionType EXPORT_FILE = null;
    public static final MenuActionType FULLSCREEN_CODE = null;
    public static final MenuActionType MORE = null;
    public static final MenuActionType PODCAST = null;
    public static final MenuActionType REPORT = null;
    public static final MenuActionType REPORT_MUSIC = null;
    public static final MenuActionType SAVE_CODE_IMAGE = null;
    public static final MenuActionType SAVE_IMAGE = null;
    public static final MenuActionType SAVE_SEARCH_IMAGE = null;
    public static final MenuActionType SAVE_VIDEO = null;
    public static final MenuActionType SHARE_IMAGE = null;
    public static final MenuActionType SHARE_MESSAGE = null;
    public static final MenuActionType SHARE_SEARCH_IMAGE = null;
    public static final MenuActionType SHARE_VIDEO = null;
    public static final /* synthetic */ MenuActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<MenuActionType> getEntries() {
        return b;
    }

    static {
        MenuActionType r0 = new MenuActionType("SAVE_IMAGE", 0, 3);
        SAVE_IMAGE = r0;
        MenuActionType r1 = new MenuActionType("SAVE_SEARCH_IMAGE", 1, 4);
        SAVE_SEARCH_IMAGE = r1;
        MenuActionType r4 = new MenuActionType("SHARE_MESSAGE", 2, 5);
        SHARE_MESSAGE = r4;
        MenuActionType r7 = new MenuActionType("SHARE_IMAGE", 3, 6);
        SHARE_IMAGE = r7;
        MenuActionType r10 = new MenuActionType("SHARE_SEARCH_IMAGE", 4, 7);
        SHARE_SEARCH_IMAGE = r10;
        MenuActionType r12 = new MenuActionType("REPORT", 5, 8);
        REPORT = r12;
        MenuActionType r14 = new MenuActionType("REPORT_MUSIC", 6, 9);
        REPORT_MUSIC = r14;
        MenuActionType r9 = new MenuActionType("EXPORT_FILE", 7, 10);
        EXPORT_FILE = r9;
        MenuActionType r11 = new MenuActionType("MORE", 8, 11);
        MORE = r11;
        MenuActionType r13 = new MenuActionType("SAVE_VIDEO", 9, 12);
        SAVE_VIDEO = r13;
        MenuActionType r15 = new MenuActionType("SHARE_VIDEO", 10, 13);
        SHARE_VIDEO = r15;
        MenuActionType r6 = new MenuActionType("PODCAST", 11, 14);
        PODCAST = r6;
        MenuActionType r3 = new MenuActionType("DOWNLOAD_FILE", 12, 15);
        DOWNLOAD_FILE = r3;
        MenuActionType r8 = new MenuActionType("FULLSCREEN_CODE", 13, 16);
        FULLSCREEN_CODE = r8;
        MenuActionType r5 = new MenuActionType("COPY_CODE", 14, 17);
        COPY_CODE = r5;
        MenuActionType r16 = new MenuActionType("SAVE_CODE_IMAGE", 15, 18);
        SAVE_CODE_IMAGE = r16;
        MenuActionType r2 = new MenuActionType("COPY_CODE_IMAGE", 16, 19);
        COPY_CODE_IMAGE = r2;
        MenuActionType[] r17 = {r0, r1, r4, r7, r10, r12, r14, r9, r11, r13, r15, r6, r3, r8, r5, r16, r2};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
    }

    public static MenuActionType[] values() {
        return (MenuActionType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static MenuActionType valueOf(String r1) {
        return (MenuActionType) r27.a.a(MenuActionType.class, r1);
    }

    public MenuActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
