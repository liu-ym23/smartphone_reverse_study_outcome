package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.livesdk.gift.model.a2;
import com.bytedance.android.livesdk.gift.model.f2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.j1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR.\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@GX\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00078\u0006@GX\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR.\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@GX\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/i;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/h1;", "<set-?>", "giftList", "Ljava/util/List;", "Lcom/bytedance/android/livesdk/gift/platform/core/model/u;", "giftsInfo", "Lcom/bytedance/android/livesdk/gift/platform/core/model/u;", "Lcom/bytedance/android/livesdk/gift/model/w1;", "giftPages", BuildConfig.FLAVOR, "defaultTabId", "Ljava/lang/Long;", "Lcom/bytedance/android/livesdk/gift/model/j1;", "giftBaseData", "Lcom/bytedance/android/livesdk/gift/model/j1;", "Lcom/bytedance/android/livesdk/gift/model/a2;", "giftSortStrategyList", "Lcom/bytedance/android/livesdk/gift/model/f2;", "imageTemplate", "Lcom/bytedance/android/livesdk/gift/model/f2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "eventTrack", "Ljava/util/Map;", "fetchStrategy", "<init>", "()V", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i implements vh7.h {

    @SerializedName("default_tab_id")
    public Long defaultTabId;

    @SerializedName("event_track")
    public Map<String, String> eventTrack;

    @SerializedName("fetch_strategy")
    public Long fetchStrategy;

    @SerializedName("gift_base_data")
    public j1 giftBaseData;

    @SerializedName("gifts")
    public List<? extends h1> giftList;

    @SerializedName("pages")
    public List<? extends w1> giftPages;

    @SerializedName("gift_sort_strategy")
    public List<? extends a2> giftSortStrategyList;

    @SerializedName("gifts_info")
    public u giftsInfo;

    @SerializedName("image_template")
    public f2 imageTemplate;

    public i() {
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.bytedance.android.livesdk.gift.model.f2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.gift.platform.core.model.u, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.livesdk.gift.model.j1, java.lang.Object] */
    public i(am3.g r10) {
        this.giftList = new ArrayList();
        this.giftPages = new ArrayList();
        this.giftSortStrategyList = new ArrayList();
        this.eventTrack = new HashMap();
        long r0 = r10.c();
    L3:
        int r2 = r10.f();
        if (r2 == (-1)) goto L34;
        switch(r2) {
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L6;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L26;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.fetchStrategy = Long.valueOf(r10.i());
        goto L3
    L8:
        long r4 = r10.c();
        String r3 = null;
        String r6 = null;
    L9:
        int r7 = r10.f();
        if (r7 == (-1)) goto L18;
        if (r7 != 1) goto L14;
        r3 = am3.h.c(r10);
        goto L9
    L14:
        if (r7 != 2) goto L15;
        r6 = am3.h.c(r10);
        goto L9
    L15:
        am3.h.e(r10);
        goto L9
    L18:
        r10.d(r4);
        Map<String, String> r5 = this.eventTrack;
        if (r3 == null) goto L25;
        if (r6 == null) goto L23;
        r5.put(r3, r6);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L26:
        this.imageTemplate = vh7.f.a(r10, f2.class);
        goto L3
    L27:
        List r8 = this.giftSortStrategyList;
        Class r9 = a2.class;
    L32:
        r8.add(vh7.f.a(r10, r9));
        goto L3
    L28:
        this.giftBaseData = vh7.f.a(r10, j1.class);
        goto L3
    L29:
        this.defaultTabId = Long.valueOf(r10.j());
        goto L3
    L30:
        r8 = this.giftPages;
        r9 = w1.class;
        goto L32
    L31:
        r8 = this.giftList;
        r9 = h1.class;
        goto L32
    L33:
        this.giftsInfo = vh7.f.a(r10, u.class);
        goto L3
    L6:
        am3.h.e(r10);
        goto L3
    L34:
        r10.d(r0);
    }
}
