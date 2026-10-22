package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001cR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/bean/BotSearchResultItem;", "Landroid/os/Parcelable;", "bot", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "highlightInfos", "", "Lcom/larus/bmhome/chat/bean/SearchHighlightInfo;", "title", "", "<init>", "(Lcom/larus/bmhome/chat/bean/RecommendBot;Ljava/util/List;Ljava/lang/CharSequence;)V", "getBot", "()Lcom/larus/bmhome/chat/bean/RecommendBot;", "setBot", "(Lcom/larus/bmhome/chat/bean/RecommendBot;)V", "getHighlightInfos", "()Ljava/util/List;", "setHighlightInfos", "(Ljava/util/List;)V", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotSearchResultItem implements Parcelable {
    public static final Parcelable.Creator<BotSearchResultItem> CREATOR = null;
    public final CharSequence a;

    @SerializedName("bot_info")
    private RecommendBot bot;

    @SerializedName("search_high_light_infos")
    private List<SearchHighlightInfo> highlightInfos;

    public static final class a implements Parcelable.Creator<BotSearchResultItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotSearchResultItem createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            ArrayList r1 = null;
            if (r7.readInt() != 0) goto L5;
            RecommendBot r0 = null;
        L6:
            RecommendBot r2 = r0;
            if (r7.readInt() == 0) goto L18;
            int r3 = r7.readInt();
            ArrayList r4 = new ArrayList(r3);
            int r5 = 0;
        L10:
            if (r5 == r3) goto L16;
            if (r7.readInt() != 0) goto L14;
            SearchHighlightInfo r6 = null;
        L15:
            r4.add(r6);
            r5 = r5 + 1;
            goto L10
        L14:
            r6 = SearchHighlightInfo.CREATOR.createFromParcel(r7);
            goto L15
        L16:
            r1 = r4;
        L18:
            return new BotSearchResultItem(r2, r1, (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r7));
        L5:
            r0 = RecommendBot.CREATOR.createFromParcel(r7);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final BotSearchResultItem[] newArray(int r1) {
            return new BotSearchResultItem[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotSearchResultItem() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotSearchResultItem) == true) goto L8;
        return false;
    L8:
        BotSearchResultItem r6 = (BotSearchResultItem) r5;
        if (Intrinsics.areEqual(this.bot, r6.bot) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.highlightInfos, r6.highlightInfos) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        RecommendBot r0 = this.bot;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<SearchHighlightInfo> r4 = this.highlightInfos;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        CharSequence r7 = this.a;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotSearchResultItem(bot=" + this.bot + ", highlightInfos=" + this.highlightInfos + ", title=" + this.a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        RecommendBot r0 = this.bot;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        List<SearchHighlightInfo> r1 = this.highlightInfos;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L16:
        TextUtils.writeToParcel(this.a, r5, r6);
        return;
    L9:
        r5.writeInt(1);
        r5.writeInt(r1.size());
        Iterator<SearchHighlightInfo> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        SearchHighlightInfo r3 = r2.next();
        if (r3 == null) goto L14;
        r5.writeInt(1);
        r3.writeToParcel(r5, r6);
        goto L11
    L14:
        r5.writeInt(0);
        goto L11
    L5:
        r5.writeInt(1);
        r0.writeToParcel(r5, r6);
        goto L6
    }

    public BotSearchResultItem(RecommendBot r1, List<SearchHighlightInfo> r2, CharSequence r3) {
        this.bot = r1;
        this.highlightInfos = r2;
        this.a = r3;
    }
}
