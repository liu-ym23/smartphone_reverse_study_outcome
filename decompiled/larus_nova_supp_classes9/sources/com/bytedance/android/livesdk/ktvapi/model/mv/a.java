package com.bytedance.android.livesdk.ktvapi.model.mv;

import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/mv/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/message/model/od;", "officialMVList", "Ljava/util/List;", "d", "()Ljava/util/List;", "personalMVList", "e", BuildConfig.FLAVOR, "minCursor", "J", "c", "()J", "maxCursor", "b", BuildConfig.FLAVOR, "hasMore", "Z", "a", "()Z", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements vh7.h {

    @SerializedName("has_more")
    protected boolean hasMore;

    @SerializedName("max_cursor")
    protected long maxCursor;

    @SerializedName("min_cursor")
    protected long minCursor;

    @SerializedName("official_mv_list")
    protected List<od> officialMVList;

    @SerializedName("personal_mv_list")
    protected List<od> personalMVList;

    public a() {
        this.officialMVList = null;
        this.personalMVList = null;
        this.minCursor = 0;
        this.maxCursor = 0;
        this.hasMore = false;
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final long b() {
        return this.maxCursor;
    }

    public final long c() {
        return this.minCursor;
    }

    public final List<od> d() {
        return this.officialMVList;
    }

    public final List<od> e() {
        return this.personalMVList;
    }

    public a(am3.g r8) {
        this.officialMVList = new ArrayList();
        this.personalMVList = new ArrayList();
        long r0 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L21;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L10;
        List<od> r5 = this.personalMVList;
        od r6 = new od(r8);
    L20:
        r5.add(r6);
        goto L3
    L10:
        if (r4 != 3) goto L11;
        this.minCursor = r8.j();
        r3 = r3 | 1;
        goto L3
    L11:
        if (r4 != 4) goto L13;
        this.maxCursor = r8.j();
        r3 = r3 | 2;
        goto L3
    L13:
        if (r4 != 5) goto L14;
        this.hasMore = am3.h.a(r8);
        r3 = r3 | 4;
        goto L3
    L14:
        am3.h.e(r8);
        goto L3
    L19:
        r5 = this.officialMVList;
        r6 = new od(r8);
        goto L20
    L21:
        r8.d(r0);
        if (this.officialMVList.isEmpty() == false) goto L25;
        this.officialMVList = null;
    L25:
        if (this.personalMVList.isEmpty() == false) goto L28;
        this.personalMVList = null;
    L28:
        if ((r3 & 1) != 0) goto L31;
        this.minCursor = 0;
    L31:
        if ((r3 & 2) != 0) goto L34;
        this.maxCursor = 0;
    L34:
        if ((r3 & 4) != 0) goto L53;
        this.hasMore = false;
        return;
    }
}
