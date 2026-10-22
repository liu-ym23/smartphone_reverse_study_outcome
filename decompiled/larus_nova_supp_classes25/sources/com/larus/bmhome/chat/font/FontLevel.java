package com.larus.bmhome.chat.font;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/font/FontLevel;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EXTRA_SMALL", "SMALL", "STANDARD", "LARGE", "EXTRA_LARGE", "SUPER_EXTRA_LARGE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum FontLevel extends Enum<FontLevel> {
    public static final FontLevel EXTRA_LARGE = null;
    public static final FontLevel EXTRA_SMALL = null;
    public static final FontLevel LARGE = null;
    public static final FontLevel SMALL = null;
    public static final FontLevel STANDARD = null;
    public static final FontLevel SUPER_EXTRA_LARGE = null;
    public static final /* synthetic */ FontLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<FontLevel> getEntries() {
        return b;
    }

    static {
        FontLevel r0 = new FontLevel("EXTRA_SMALL", 0, -2);
        EXTRA_SMALL = r0;
        FontLevel r1 = new FontLevel("SMALL", 1, -1);
        SMALL = r1;
        FontLevel r2 = new FontLevel("STANDARD", 2, 0);
        STANDARD = r2;
        FontLevel r4 = new FontLevel("LARGE", 3, 1);
        LARGE = r4;
        FontLevel r7 = new FontLevel("EXTRA_LARGE", 4, 2);
        EXTRA_LARGE = r7;
        FontLevel r9 = new FontLevel("SUPER_EXTRA_LARGE", 5, 3);
        SUPER_EXTRA_LARGE = r9;
        FontLevel[] r11 = {r0, r1, r2, r4, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static FontLevel[] values() {
        return (FontLevel[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FontLevel valueOf(String r1) {
        return (FontLevel) a.a(FontLevel.class, r1);
    }

    public FontLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
