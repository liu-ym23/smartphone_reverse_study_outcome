package com.larus.bmhome.chat.search;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/search/CardType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "Unknown", "Text", "Video", "Image", "MixedMedia", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CardType extends Enum<CardType> {
    public static final a Companion = null;

    @SerializedName("3")
    public static final CardType Image = null;

    @SerializedName("4")
    public static final CardType MixedMedia = null;

    @SerializedName("1")
    public static final CardType Text = null;

    @SerializedName("0")
    public static final CardType Unknown = null;

    @SerializedName("2")
    public static final CardType Video = null;
    public static final /* synthetic */ CardType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public final int value;

    public static final class a {
        public a() {
        }

        public static CardType a(int r1) {
            if (r1 == 0) goto L17;
            if (r1 == 1) goto L22;
            if (r1 == 2) goto L21;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L19;
            return null;
        L19:
            return CardType.MixedMedia;
        L20:
            return CardType.Image;
        L21:
            return CardType.Video;
        L22:
            return CardType.Text;
        L17:
            return CardType.Unknown;
        }
    }

    public static EnumEntries<CardType> getEntries() {
        return b;
    }

    static {
        CardType r0 = new CardType("Unknown", 0, 0);
        Unknown = r0;
        CardType r1 = new CardType("Text", 1, 1);
        Text = r1;
        CardType r3 = new CardType("Video", 2, 2);
        Video = r3;
        CardType r5 = new CardType("Image", 3, 3);
        Image = r5;
        CardType r7 = new CardType("MixedMedia", 4, 4);
        MixedMedia = r7;
        CardType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static CardType[] values() {
        return (CardType[]) a.clone();
    }

    public static CardType valueOf(String r1) {
        return (CardType) r27.a.a(CardType.class, r1);
    }

    public CardType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
