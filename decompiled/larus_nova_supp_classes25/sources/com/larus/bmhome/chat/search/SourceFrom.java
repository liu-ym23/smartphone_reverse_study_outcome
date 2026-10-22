package com.larus.bmhome.chat.search;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/search/SourceFrom;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "Unknown", "BaiKe", "TikTok", "DouYin", "Toutiao", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SourceFrom extends Enum<SourceFrom> {

    @SerializedName("1")
    public static final SourceFrom BaiKe = null;
    public static final a Companion = null;

    @SerializedName("3")
    public static final SourceFrom DouYin = null;

    @SerializedName("2")
    public static final SourceFrom TikTok = null;

    @SerializedName("4")
    public static final SourceFrom Toutiao = null;

    @SerializedName("0")
    public static final SourceFrom Unknown = null;
    public static final /* synthetic */ SourceFrom[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public final int value;

    public static EnumEntries<SourceFrom> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.search.SourceFrom$a] */
    static {
        SourceFrom r0 = new SourceFrom("Unknown", 0, 0);
        Unknown = r0;
        SourceFrom r1 = new SourceFrom("BaiKe", 1, 1);
        BaiKe = r1;
        SourceFrom r3 = new SourceFrom("TikTok", 2, 2);
        TikTok = r3;
        SourceFrom r5 = new SourceFrom("DouYin", 3, 3);
        DouYin = r5;
        SourceFrom r7 = new SourceFrom("Toutiao", 4, 4);
        Toutiao = r7;
        SourceFrom[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static SourceFrom[] values() {
        return (SourceFrom[]) a.clone();
    }

    public static SourceFrom valueOf(String r1) {
        return (SourceFrom) r27.a.a(SourceFrom.class, r1);
    }

    public SourceFrom(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
