package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.sdk.helper.q;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bBC\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;", "Ljava/io/Serializable;", "", "count", "", "showInSku", "(Ljava/lang/Long;)Z", "", "countQuota", "Ljava/lang/Integer;", "getCountQuota", "()Ljava/lang/Integer;", "", "guideText", "Ljava/lang/String;", "getGuideText", "()Ljava/lang/String;", "guideType", "getGuideType", "", "trackMeta", "Ljava/util/Map;", "getTrackMeta", "()Ljava/util/Map;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "Companion", "a", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuAddCartGuideInfo implements Serializable {
    public static final a Companion = null;

    @SerializedName("count_quota")
    private final Integer countQuota;

    @SerializedName("guide_text")
    private final String guideText;

    @SerializedName("guide_type")
    private final Integer guideType;

    @SerializedName("track_meta")
    private final Map<String, String> trackMeta;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SkuAddCartGuideInfo() {
        this(null, null, null, null, 15, null);
    }

    public final Integer getCountQuota() {
        return this.countQuota;
    }

    public final String getGuideText() {
        return this.guideText;
    }

    public final Integer getGuideType() {
        return this.guideType;
    }

    public final Map<String, String> getTrackMeta() {
        return this.trackMeta;
    }

    public final boolean showInSku(Long r10) {
        if (r10 == null) goto L27;
        r10.longValue();
        if (this.countQuota == null) goto L27;
        if (r10.longValue() > this.countQuota.intValue()) goto L27;
        if (a2.b(this.guideText) == false) goto L27;
        Integer r11 = this.guideType;
        if (r11 == null) goto L27;
        if (r11.intValue() != 1) goto L27;
        String r12 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));     // Catch: Exception -> L25
        q r13 = q.a;
        String r14 = r13.getString("add_cart_guide_show_date", "");
        int r15 = r13.getInt("add_cart_guide_show_times", 0);
        if (a2.b(r14) == true) goto L19;
    L21:
        r13.putString("add_cart_guide_show_date", r12);
        int r16 = 1;
    L22:
        r13.d("add_cart_guide_show_times", r16);
        if (ECSettingKeys.S().contains(String.valueOf(r16)) == false) goto L27;
        return true;
    L19:
        if (Intrinsics.areEqual(r12, r14) == false) goto L21;
        r16 = r15 + 1;
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L27:
        return false;
    }

    public SkuAddCartGuideInfo(Integer r1, String r10, Integer r11, Map<String, String> r12) {
        this.countQuota = r1;
        this.guideText = r10;
        this.guideType = r11;
        this.trackMeta = r12;
    }

    public /* synthetic */ SkuAddCartGuideInfo(Integer r10, String r11, Integer r12, Map r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
