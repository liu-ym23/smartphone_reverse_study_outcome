package com.larus.platform.uimodel;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003J!\u0010(\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J!\u0010)\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u008f\u0001\u00100\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00052 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u00101\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\rHÖ\u0001J\t\u00105\u001a\u00020\bHÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R.\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018¨\u00066"}, d2 = {"Lcom/larus/platform/uimodel/MediaEntityContainer;", "Ljava/io/Serializable;", "music_list", "Ljava/util/ArrayList;", "Lcom/larus/platform/uimodel/MediaEntity;", "Lkotlin/collections/ArrayList;", "video_list", "search_id", "", "query", "has_more", "", "offset", "", "limit", "queryParams", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;)V", "getMusic_list", "()Ljava/util/ArrayList;", "getVideo_list", "getSearch_id", "()Ljava/lang/String;", "setSearch_id", "(Ljava/lang/String;)V", "getQuery", "setQuery", "getHas_more", "()Z", "setHas_more", "(Z)V", "getOffset", "()I", "setOffset", "(I)V", "getLimit", "setLimit", "getQueryParams", "setQueryParams", "mediaList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaEntityContainer implements Serializable {
    private boolean has_more;
    private int limit;

    @SerializedName("music_list")
    private final ArrayList<MediaEntity> music_list;
    private int offset;
    private String query;
    private String queryParams;
    private String search_id;

    @SerializedName("video_list")
    private final ArrayList<MediaEntity> video_list;

    public MediaEntityContainer() {
        this(null, null, null, null, false, 0, 0, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MediaEntityContainer copy$default(MediaEntityContainer r9, ArrayList r10, ArrayList r11, String r12, String r13, boolean r14, int r15, int r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        ArrayList r2 = r9.music_list;
    L7:
        if ((r18 & 2) == 0) goto L9;
        ArrayList r3 = r9.video_list;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.search_id;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.query;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.has_more;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.offset;
    L27:
        if ((r18 & 64) == 0) goto L29;
        int r8 = r9.limit;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.queryParams;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final ArrayList<MediaEntity> component1() {
        return this.music_list;
    }

    public final ArrayList<MediaEntity> component2() {
        return this.video_list;
    }

    public final String component3() {
        return this.search_id;
    }

    public final String component4() {
        return this.query;
    }

    public final boolean component5() {
        return this.has_more;
    }

    public final int component6() {
        return this.offset;
    }

    public final int component7() {
        return this.limit;
    }

    public final String component8() {
        return this.queryParams;
    }

    public final MediaEntityContainer copy(ArrayList<MediaEntity> r11, ArrayList<MediaEntity> r12, String r13, String r14, boolean r15, int r16, int r17, String r18) {
        return new MediaEntityContainer(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MediaEntityContainer) == true) goto L8;
        return false;
    L8:
        MediaEntityContainer r6 = (MediaEntityContainer) r5;
        if (Intrinsics.areEqual(this.music_list, r6.music_list) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.video_list, r6.video_list) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.search_id, r6.search_id) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L21;
        return false;
    L21:
        if (this.has_more == r6.has_more) goto L24;
        return false;
    L24:
        if (this.offset == r6.offset) goto L27;
        return false;
    L27:
        if (this.limit == r6.limit) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.queryParams, r6.queryParams) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        ArrayList<MediaEntity> r0 = this.music_list;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ArrayList<MediaEntity> r4 = this.video_list;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.search_id;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.query;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.has_more == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (((((r12 + r13) * 31) + this.offset) * 31) + this.limit) * 31;
        String r15 = this.queryParams;
        if (r15 == null) goto L27;
        r1 = r15.hashCode();
    L27:
        return r14 + r1;
    L21:
        r13 = 1237;
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MediaEntityContainer(music_list=" + this.music_list + ", video_list=" + this.video_list + ", search_id=" + this.search_id + ", query=" + this.query + ", has_more=" + this.has_more + ", offset=" + this.offset + ", limit=" + this.limit + ", queryParams=" + this.queryParams + ')';
    }

    public final ArrayList<MediaEntity> mediaList() {
        ArrayList<MediaEntity> r0 = this.video_list;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.music_list;
    }

    public final boolean getHas_more() {
        return this.has_more;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final ArrayList<MediaEntity> getMusic_list() {
        return this.music_list;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getQueryParams() {
        return this.queryParams;
    }

    public final String getSearch_id() {
        return this.search_id;
    }

    public final ArrayList<MediaEntity> getVideo_list() {
        return this.video_list;
    }

    public final void setHas_more(boolean r1) {
        this.has_more = r1;
    }

    public final void setLimit(int r1) {
        this.limit = r1;
    }

    public final void setOffset(int r1) {
        this.offset = r1;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final void setQueryParams(String r1) {
        this.queryParams = r1;
    }

    public final void setSearch_id(String r1) {
        this.search_id = r1;
    }

    public MediaEntityContainer(ArrayList<MediaEntity> r1, ArrayList<MediaEntity> r2, String r3, String r4, boolean r5, int r6, int r7, String r8) {
        this.music_list = r1;
        this.video_list = r2;
        this.search_id = r3;
        this.query = r4;
        this.has_more = r5;
        this.offset = r6;
        this.limit = r7;
        this.queryParams = r8;
    }

    public /* synthetic */ MediaEntityContainer(ArrayList r10, ArrayList r11, String r12, String r13, boolean r14, int r15, int r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        ArrayList r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        ArrayList r3 = null;
    L10:
        String r5 = "";
        if ((r18 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r18 & 8) != 0) goto L18;
        r5 = r13;
    L18:
        int r7 = 0;
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = false;
    L23:
        if ((r18 & 32) != 0) goto L27;
        r7 = r15;
    L27:
        if ((r18 & 64) == 0) goto L29;
        int r8 = 1;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L21:
        r6 = r14;
        goto L23
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L10
    L5:
        r1 = r10;
        goto L7
    }
}
