package com.larus.bmhome.chat.resp;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/resp/ContentDistType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Normal", "Aweme", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ContentDistType extends Enum<ContentDistType> {
    public static final ContentDistType Aweme = null;
    public static final ContentDistType Normal = null;
    public static final /* synthetic */ ContentDistType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ContentDistType> getEntries() {
        return b;
    }

    static {
        ContentDistType r0 = new ContentDistType("Normal", 0, 0);
        Normal = r0;
        ContentDistType r1 = new ContentDistType("Aweme", 1, 1);
        Aweme = r1;
        ContentDistType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ContentDistType[] values() {
        return (ContentDistType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ContentDistType valueOf(String r1) {
        return (ContentDistType) a.a(ContentDistType.class, r1);
    }

    public ContentDistType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
