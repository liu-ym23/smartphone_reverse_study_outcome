package com.larus.bmhome.video;

import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/video/ItemType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOAD_MORE", "UNDEFINED", InstructionHandlerType.VIDEO, "IMAGES", "ARTICLE", InstructionHandlerType.MUSIC, "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemType extends Enum<ItemType> {
    public static final ItemType ARTICLE = null;
    public static final a Companion = null;
    public static final ItemType IMAGES = null;
    public static final ItemType LOAD_MORE = null;
    public static final ItemType MUSIC = null;
    public static final ItemType UNDEFINED = null;
    public static final ItemType VIDEO = null;
    public static final /* synthetic */ ItemType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ItemType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.video.ItemType$a] */
    static {
        ItemType r0 = new ItemType("LOAD_MORE", 0, -1);
        LOAD_MORE = r0;
        ItemType r1 = new ItemType("UNDEFINED", 1, 0);
        UNDEFINED = r1;
        ItemType r3 = new ItemType(InstructionHandlerType.VIDEO, 2, 1);
        VIDEO = r3;
        ItemType r5 = new ItemType("IMAGES", 3, 2);
        IMAGES = r5;
        ItemType r7 = new ItemType("ARTICLE", 4, 3);
        ARTICLE = r7;
        ItemType r9 = new ItemType(InstructionHandlerType.MUSIC, 5, 4);
        MUSIC = r9;
        ItemType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static ItemType[] values() {
        return (ItemType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ItemType valueOf(String r1) {
        return (ItemType) r27.a.a(ItemType.class, r1);
    }

    public ItemType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
