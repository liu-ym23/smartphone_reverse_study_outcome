package ws9;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/larus/search/impl/global/model/GlobalSearchResultItem;", "", "bot", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "highlightInfos", "", "Lcom/larus/search/impl/global/model/SearchHighlightInfo;", "title", "", "<init>", "(Lcom/larus/bmhome/chat/bean/RecommendBot;Ljava/util/List;Ljava/lang/CharSequence;)V", "getBot", "()Lcom/larus/bmhome/chat/bean/RecommendBot;", "setBot", "(Lcom/larus/bmhome/chat/bean/RecommendBot;)V", "getHighlightInfos", "()Ljava/util/List;", "setHighlightInfos", "(Ljava/util/List;)V", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class b {
    public CharSequence a;

    @SerializedName("bot_info")
    private RecommendBot bot;

    @SerializedName("search_hight_light_infos")
    private List<e> highlightInfos;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        List<e> r4 = this.highlightInfos;
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
        return "GlobalSearchResultItem(bot=" + this.bot + ", highlightInfos=" + this.highlightInfos + ", title=" + this.a + ')';
    }

    public final RecommendBot a() {
        return this.bot;
    }

    public final List<e> b() {
        return this.highlightInfos;
    }

    public final void c(RecommendBot r1) {
        this.bot = r1;
    }

    public /* synthetic */ b(RecommendBot r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this(r2, null, null);
    }

    public b(RecommendBot r1, List<e> r2, CharSequence r3) {
        this.bot = r1;
        this.highlightInfos = r2;
        this.a = r3;
    }
}
