package com.bytedance.android.live.liveinteract.banner;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.n;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/banner/KtvActivityLinkResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/n;", "", "", "Lcom/bytedance/android/live/liveinteract/banner/LabelBannerUrl;", "bannerUrl_links", "Ljava/util/Map;", "getBannerUrl_links", "()Ljava/util/Map;", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvActivityLinkResponse extends FlexModelBase<n> implements n, h {

    @SerializedName("activity_links")
    protected Map<Long, LabelBannerUrl> bannerUrl_links;

    public KtvActivityLinkResponse() {
        super(n.class);
        this.bannerUrl_links = MapsKt.emptyMap();
    }

    public Map<Long, LabelBannerUrl> getBannerUrl_links() {
        return this.bannerUrl_links;
    }

    public KtvActivityLinkResponse(g r11) {
        super(n.class);
        this.bannerUrl_links = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L25;
        g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 1) goto L7;
        long r6 = r11.c();
        Long r3 = null;
        LabelBannerUrl r7 = null;
    L9:
        int r8 = r11.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = Long.valueOf(r11.j());
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = new LabelBannerUrl(r11);
        goto L9
    L14:
        am3.h.e(r11);
        goto L9
    L17:
        r11.d(r6);
        Map<Long, LabelBannerUrl> r4 = this.bannerUrl_links;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r5, r11);
        goto L3
    L25:
        r11.d(r0);
        setThreadSafe(true);
        if (this.bannerUrl_links != null) goto L46;
        this.bannerUrl_links = MapsKt.emptyMap();
        return;
    }
}
