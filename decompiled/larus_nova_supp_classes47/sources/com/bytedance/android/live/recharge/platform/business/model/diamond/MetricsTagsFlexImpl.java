package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.DiamondBuyPanelExtraInfo.MetricsTags")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR)\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/MetricsTagsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/i;", "", "", "metrics$delegate", "Ljava/lang/Object;", "getMetrics", "()Ljava/util/Map;", "metrics", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MetricsTagsFlexImpl extends FlexModelBase<i> implements i, vh7.h {

    @SerializedName("tags_map")
    protected Map<String, String> _$$metrics;

    public MetricsTagsFlexImpl() {
        super(i.class);
    }

    public MetricsTagsFlexImpl(am3.g r12) {
        super(i.class);
        this._$$metrics = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L25;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L7;
        long r6 = r12.c();
        String r3 = null;
        String r7 = null;
    L9:
        int r8 = r12.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = am3.h.c(r12);
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = am3.h.c(r12);
        goto L9
    L14:
        am3.h.e(r12);
        goto L9
    L17:
        r12.d(r6);
        Map<String, String> r4 = this._$$metrics;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r5, r12);
        goto L3
    L25:
        r12.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.i
    public final Map<String, String> getMetrics() {
        return this._$$metrics;
    }
}
