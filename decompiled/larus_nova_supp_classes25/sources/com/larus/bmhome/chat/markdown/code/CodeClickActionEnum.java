package com.larus.bmhome.chat.markdown.code;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/markdown/code/CodeClickActionEnum;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLICK_ACTION_COPY", "CLICK_ACTION_FULL_SCREEN", "CLICK_ACTION_PREVIEW", "CLICK_ACTION_SWITCH_TAB_GRAPH", "CLICK_ACTION_SWITCH_TAB_CODE", "CLICK_ACTION_DOWNLOAD_PICTURE", "CLICK_ACTION_DOWNLOAD_CODE", "CLICK_ACTION_OTHERS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CodeClickActionEnum extends Enum<CodeClickActionEnum> {
    public static final CodeClickActionEnum CLICK_ACTION_COPY = null;
    public static final CodeClickActionEnum CLICK_ACTION_DOWNLOAD_CODE = null;
    public static final CodeClickActionEnum CLICK_ACTION_DOWNLOAD_PICTURE = null;
    public static final CodeClickActionEnum CLICK_ACTION_FULL_SCREEN = null;
    public static final CodeClickActionEnum CLICK_ACTION_OTHERS = null;
    public static final CodeClickActionEnum CLICK_ACTION_PREVIEW = null;
    public static final CodeClickActionEnum CLICK_ACTION_SWITCH_TAB_CODE = null;
    public static final CodeClickActionEnum CLICK_ACTION_SWITCH_TAB_GRAPH = null;
    public static final /* synthetic */ CodeClickActionEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<CodeClickActionEnum> getEntries() {
        return b;
    }

    static {
        CodeClickActionEnum r0 = new CodeClickActionEnum("CLICK_ACTION_COPY", 0, "copy");
        CLICK_ACTION_COPY = r0;
        CodeClickActionEnum r1 = new CodeClickActionEnum("CLICK_ACTION_FULL_SCREEN", 1, "full_screen");
        CLICK_ACTION_FULL_SCREEN = r1;
        CodeClickActionEnum r2 = new CodeClickActionEnum("CLICK_ACTION_PREVIEW", 2, "preview");
        CLICK_ACTION_PREVIEW = r2;
        CodeClickActionEnum r4 = new CodeClickActionEnum("CLICK_ACTION_SWITCH_TAB_GRAPH", 3, "to_graph");
        CLICK_ACTION_SWITCH_TAB_GRAPH = r4;
        CodeClickActionEnum r6 = new CodeClickActionEnum("CLICK_ACTION_SWITCH_TAB_CODE", 4, "to_code");
        CLICK_ACTION_SWITCH_TAB_CODE = r6;
        CodeClickActionEnum r8 = new CodeClickActionEnum("CLICK_ACTION_DOWNLOAD_PICTURE", 5, "download_picture");
        CLICK_ACTION_DOWNLOAD_PICTURE = r8;
        CodeClickActionEnum r10 = new CodeClickActionEnum("CLICK_ACTION_DOWNLOAD_CODE", 6, "download_code");
        CLICK_ACTION_DOWNLOAD_CODE = r10;
        CodeClickActionEnum r12 = new CodeClickActionEnum("CLICK_ACTION_OTHERS", 7, "others");
        CLICK_ACTION_OTHERS = r12;
        CodeClickActionEnum[] r14 = {r0, r1, r2, r4, r6, r8, r10, r12};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static CodeClickActionEnum[] values() {
        return (CodeClickActionEnum[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CodeClickActionEnum valueOf(String r1) {
        return (CodeClickActionEnum) r27.a.a(CodeClickActionEnum.class, r1);
    }

    public CodeClickActionEnum(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
