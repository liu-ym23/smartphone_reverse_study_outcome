package com.larus.avlink.simulInterpret.page.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/TextType;", "", "<init>", "(Ljava/lang/String;I)V", "ORIGINAL", "TRANSLATION", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum TextType extends Enum<TextType> {
    public static final TextType ORIGINAL = null;
    public static final TextType TRANSLATION = null;
    public static final /* synthetic */ TextType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TextType> getEntries() {
        return b;
    }

    static {
        TextType r0 = new TextType("ORIGINAL", 0);
        ORIGINAL = r0;
        TextType r1 = new TextType("TRANSLATION", 1);
        TRANSLATION = r1;
        TextType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TextType[] values() {
        return (TextType[]) a.clone();
    }

    public static TextType valueOf(String r1) {
        return (TextType) r27.a.a(TextType.class, r1);
    }

    public TextType(String r1, int r2) {
        super(r1, r2);
    }
}
