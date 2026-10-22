package com.bytedance.android.live.revlink.impl.settings.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import r41.c;
import r41.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R&\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/PkPropCardConfigSerializableObjectImpl;", "Lr41/j;", "", "livePkPropCardEnable", "Z", "G1", "()Z", "", "livePkPropCardThreshold", "I", "r5", "()I", "livePkPropCardNewGuideCount", "t2", "", "selfFogUrl", "Ljava/lang/String;", "getSelfFogUrl", "()Ljava/lang/String;", "oppositeFogUrl", "getOppositeFogUrl", "allFogUrl", "getAllFogUrl", "fierceBuffUrl", "getFierceBuffUrl", "borrowBuffUrl", "getBorrowBuffUrl", "", "ratio2TextSizeMap", "Ljava/util/Map;", "getRatio2TextSizeMap", "()Ljava/util/Map;", "pkPropCardDetailLynxUrl", "getPkPropCardDetailLynxUrl", "pkPropCardUsingDetailLynxUrl", "getPkPropCardUsingDetailLynxUrl", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkPropCardConfigSerializableObjectImpl implements j {

    @SerializedName("all_fog_url")
    private final String allFogUrl;

    @SerializedName("borrow_buff_url")
    private final String borrowBuffUrl;

    @SerializedName("fierce_buff_url")
    private final String fierceBuffUrl;

    @SerializedName("live_pk_prop_card_enable")
    private final boolean livePkPropCardEnable;

    @SerializedName("live_pk_prop_card_new_guide_count")
    private final int livePkPropCardNewGuideCount;

    @SerializedName("live_pk_prop_card_threshold")
    private final int livePkPropCardThreshold;

    @SerializedName("opposite_fog_url")
    private final String oppositeFogUrl;

    @SerializedName("pk_prop_card_detail_lynx_url")
    private final String pkPropCardDetailLynxUrl;

    @SerializedName("pk_prop_card_using_detail_lynx_url")
    private final String pkPropCardUsingDetailLynxUrl;

    @SerializedName("ratio_2_text_size_map")
    private final Map<Integer, Integer> ratio2TextSizeMap;

    @SerializedName("self_fog_url")
    private final String selfFogUrl;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/PkPropCardConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PkPropCardConfigSerializableObjectImpl.class);
        }
    }

    public PkPropCardConfigSerializableObjectImpl() {
        this.livePkPropCardEnable = true;
        this.livePkPropCardThreshold = 299;
        this.livePkPropCardNewGuideCount = 3;
        int r0 = c.a;
        this.selfFogUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_prop_card_self_fog_anim.webp";
        this.oppositeFogUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_prop_card_opposite_fog_anim.webp";
        this.allFogUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_prop_card_all_fog_anim.webp";
        this.fierceBuffUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_prop_card_fierce_buff_anim2.webp";
        this.borrowBuffUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_prop_card_borrow_buff_anim.webp";
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put(150, 12);
        r1.put(300, 14);
        r1.put(500, 16);
        r1.put(35, 12);
        r1.put(65, 14);
        r1.put(100, 16);
        this.ratio2TextSizeMap = r1;
        this.pkPropCardDetailLynxUrl = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_douyin%2Fpages%2Fprop_card_desc%2Ftemplate.js&type=popup&gravity=bottom&width_percent=100&rate_height=382&radius=8&web_bg_color=%23ffffff";
        this.pkPropCardUsingDetailLynxUrl = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_panel_lynx_douyin%2Fpages%2Fprop_card_detail%2Ftemplate.js?business_type=rev_link&gravity=bottom&type=popup&rate_height=382&radius=8&pull_down_close=1&pull_down_indicator_not_show=1&compat_lynx_foldview=1";
    }

    @Override // r41.j
    public final boolean G1() {
        return this.livePkPropCardEnable;
    }

    @Override // r41.j
    public final int r5() {
        return this.livePkPropCardThreshold;
    }

    @Override // r41.j
    public final int t2() {
        return this.livePkPropCardNewGuideCount;
    }
}
