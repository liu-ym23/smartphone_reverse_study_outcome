package ic8;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nJ\u0012\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\rJ\b\u0010%\u001a\u0004\u0018\u00010\rJ\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\u001b\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003Jg\u0010,\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\u0013\u0010-\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020 HÖ\u0001J\t\u00100\u001a\u00020\rHÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0016\"\u0004\b\u001e\u0010\u0018¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/bean/RecommendBotData;", "", "botList", "", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "hasMore", "", "tagList", "Lcom/larus/platform/api/creation/TabTag;", "selectTagId", "", "traceMap", "", "", "isFromCache", "<init>", "(Ljava/util/List;ZLjava/util/List;JLjava/util/Map;Z)V", "getBotList", "()Ljava/util/List;", "setBotList", "(Ljava/util/List;)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "getTagList", "getSelectTagId", "()J", "getTraceMap", "()Ljava/util/Map;", "setFromCache", "selectIndex", "", "tagId", "setFrom", "", "scene", "getRequestId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class o0 {
    public final transient boolean a;

    @SerializedName("bot_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<RecommendBot> botList;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("selected_tag_id")
    private final long selectTagId;

    @SerializedName("tag_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<zp9.w> tagList;

    @SerializedName("trace_map")
    private final Map<String, String> traceMap;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r9 = (o0) r8;
        if (Intrinsics.areEqual(this.botList, r9.botList) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r9.hasMore) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tagList, r9.tagList) == true) goto L18;
        return false;
    L18:
        if (this.selectTagId == r9.selectTagId) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.traceMap, r9.traceMap) == true) goto L24;
        return false;
    L24:
        if (this.a == r9.a) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        List<RecommendBot> r0 = this.botList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.hasMore == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        List<zp9.w> r7 = this.tagList;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        long r9 = this.selectTagId;
        int r10 = (((r6 + r8) * 31) + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        Map<String, String> r11 = this.traceMap;
        if (r11 == null) goto L18;
        r1 = r11.hashCode();
    L18:
        int r12 = (r10 + r1) * 31;
        if (this.a == true) goto L23;
        r4 = 1237;
    L23:
        return r12 + r4;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecommendBotData(botList=" + this.botList + ", hasMore=" + this.hasMore + ", tagList=" + this.tagList + ", selectTagId=" + this.selectTagId + ", traceMap=" + this.traceMap + ", isFromCache=" + this.a + ')';
    }

    public final String d() {
        Map<String, String> r0 = this.traceMap;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("request_id");
    }

    public final int f() {
        List<zp9.w> r0 = this.tagList;
        if (r0 == null) goto L14;
        Iterator<zp9.w> r1 = r0.iterator();
        int r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L18;
        zp9.w r4 = r1.next();
        if (this.selectTagId != r4.a) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L17;
        r3 = r3 + 1;
        goto L6
    L17:
        return r3;
    L10:
        r5 = false;
        goto L11
    L18:
        return -1;
    L14:
        return -1;
    }

    public o0() {
        this(CollectionsKt.emptyList(), false, CollectionsKt.emptyList(), -1, MapsKt.emptyMap(), false);
    }

    public final List<RecommendBot> b() {
        return this.botList;
    }

    public final boolean c() {
        return this.hasMore;
    }

    public final List<zp9.w> e() {
        return this.tagList;
    }

    public final int g(long r8) {
        List<zp9.w> r0 = this.tagList;
        if (r0 == null) goto L14;
        Iterator<zp9.w> r1 = r0.iterator();
        int r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L18;
        if (r8 != r1.next().a) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L17;
        r3 = r3 + 1;
        goto L6
    L17:
        return r3;
    L10:
        r4 = false;
        goto L11
    L18:
        return -1;
    L14:
        return -1;
    }

    public final void h(List<RecommendBot> r1) {
        this.botList = r1;
    }

    public final void i(String r7) {
        Map<String, String> r0 = this.traceMap;
        if (r0 == null) goto L12;
        String r1 = r0.get("request_id");
        if (r1 == null) goto L14;
        List<RecommendBot> r2 = this.botList;
        if (r2 == null) goto L15;
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L16;
        RecommendBot r4 = (RecommendBot) r3.next();
        r4.a = new RecommendFrom(r7, r1, null, 4);
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public static o0 a(o0 r8, List r9, boolean r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r9 = r8.botList;
    L5:
        List r1 = r9;
        if ((r11 & 2) == 0) goto L8;
        boolean r2 = r8.hasMore;
    L10:
        if ((r11 & 4) == 0) goto L12;
        List<zp9.w> r3 = r8.tagList;
    L14:
        if ((r11 & 8) == 0) goto L16;
        long r4 = r8.selectTagId;
    L18:
        if ((r11 & 16) == 0) goto L20;
        Map<String, String> r6 = r8.traceMap;
    L22:
        if ((r11 & 32) == 0) goto L24;
        r10 = r8.a;
    L24:
        r8.getClass();
        return new o0(r1, r2, r3, r4, r6, r10);
    L20:
        r6 = null;
        goto L22
    L16:
        r4 = 0;
        goto L18
    L12:
        r3 = null;
        goto L14
    L8:
        r2 = false;
        goto L10
    }

    public o0(List<RecommendBot> r1, boolean r2, List<zp9.w> r3, long r4, Map<String, String> r6, boolean r7) {
        this.botList = r1;
        this.hasMore = r2;
        this.tagList = r3;
        this.selectTagId = r4;
        this.traceMap = r6;
        this.a = r7;
    }
}
