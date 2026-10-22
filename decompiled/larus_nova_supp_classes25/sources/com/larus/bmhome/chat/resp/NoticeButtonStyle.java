package com.larus.bmhome.chat.resp;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/resp/NoticeButtonStyle;", "", "style", "", "<init>", "(Ljava/lang/String;II)V", "getStyle", "()I", "IMAGE", "TEXT", "RIGHT_ARROW", "JSON", "None", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum NoticeButtonStyle extends Enum<NoticeButtonStyle> {
    public static final NoticeButtonStyle IMAGE = null;
    public static final NoticeButtonStyle JSON = null;
    public static final NoticeButtonStyle None = null;
    public static final NoticeButtonStyle RIGHT_ARROW = null;
    public static final NoticeButtonStyle TEXT = null;
    public static final /* synthetic */ NoticeButtonStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int style;

    public static EnumEntries<NoticeButtonStyle> getEntries() {
        return b;
    }

    static {
        NoticeButtonStyle r0 = new NoticeButtonStyle("IMAGE", 0, 1);
        IMAGE = r0;
        NoticeButtonStyle r1 = new NoticeButtonStyle("TEXT", 1, 2);
        TEXT = r1;
        NoticeButtonStyle r4 = new NoticeButtonStyle("RIGHT_ARROW", 2, 3);
        RIGHT_ARROW = r4;
        NoticeButtonStyle r6 = new NoticeButtonStyle("JSON", 3, 4);
        JSON = r6;
        NoticeButtonStyle r8 = new NoticeButtonStyle("None", 4, 5);
        None = r8;
        NoticeButtonStyle[] r10 = {r0, r1, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static NoticeButtonStyle[] values() {
        return (NoticeButtonStyle[]) a.clone();
    }

    public final int getStyle() {
        return this.style;
    }

    public static NoticeButtonStyle valueOf(String r1) {
        return (NoticeButtonStyle) a.a(NoticeButtonStyle.class, r1);
    }

    public NoticeButtonStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.style = r3;
    }
}
