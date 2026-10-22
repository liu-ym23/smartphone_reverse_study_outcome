package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/b0;", "", "", "hasMore", "Z", "a", "()Z", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "musicList", "Ljava/util/List;", "b", "()Ljava/util/List;", "chorusList", "getChorusList", "", "searchId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "querySource", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b0 implements vh7.h {

    @SerializedName("chorusList")
    protected List<KtvMusic> chorusList;

    @SerializedName("has_more")
    protected boolean hasMore;

    @SerializedName("musiclist")
    protected List<KtvMusic> musicList;

    @SerializedName("query_source")
    protected Integer querySource;

    @SerializedName("search_id")
    protected String searchId;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b0) == false) goto L16;
        b0 r4 = (b0) r3;
        if (this.hasMore == r4.hasMore) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.musicList, r4.musicList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.chorusList, r4.chorusList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchId, r4.searchId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.querySource, r4.querySource) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r0 = this.hasMore;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<KtvMusic> r3 = this.musicList;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        List<KtvMusic> r7 = this.chorusList;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        String r11 = this.searchId;
        if (r11 == null) goto L16;
        int r12 = r11.hashCode();
    L17:
        int r13 = (r9 + r12) * 31;
        Integer r14 = this.querySource;
        if (r14 == null) goto L21;
        r4 = r14.hashCode();
    L21:
        return r13 + r4;
    L16:
        r12 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "KtvSearchSongsResponse(hasMore=" + this.hasMore + ", musicList=" + this.musicList + ", chorusList=" + this.chorusList + ", searchId=" + this.searchId + ", querySource=" + this.querySource + ")";
    }

    public b0() {
        this.hasMore = false;
        this.musicList = null;
        this.chorusList = null;
        this.searchId = null;
        this.querySource = null;
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final List<KtvMusic> b() {
        return this.musicList;
    }

    public final Integer c() {
        return this.querySource;
    }

    public final String d() {
        return this.searchId;
    }

    public b0(am3.g r8) {
        this.musicList = new ArrayList();
        this.chorusList = new ArrayList();
        long r0 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L21;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L9;
        this.hasMore = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L9:
        if (r4 != 3) goto L11;
        List<KtvMusic> r5 = this.chorusList;
        KtvMusic r6 = new KtvMusic(r8);
    L20:
        r5.add(r6);
        goto L3
    L11:
        if (r4 != 4) goto L13;
        this.searchId = am3.h.c(r8);
        goto L3
    L13:
        if (r4 != 5) goto L14;
        this.querySource = Integer.valueOf(r8.i());
        goto L3
    L14:
        am3.h.e(r8);
        goto L3
    L19:
        r5 = this.musicList;
        r6 = new KtvMusic(r8);
        goto L20
    L21:
        r8.d(r0);
        if ((r3 & true) == true) goto L25;
        this.hasMore = false;
    L25:
        if (this.musicList.isEmpty() == false) goto L28;
        this.musicList = null;
    L28:
        if (this.chorusList.isEmpty() == false) goto L31;
        this.chorusList = null;
    L31:
        if (this.searchId != null) goto L34;
        this.searchId = null;
    L34:
        if (this.querySource != null) goto L53;
        this.querySource = null;
        return;
    }
}
