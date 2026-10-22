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
@ProtoMessage("webcast.data.DiamondBuyPanelExtraInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b \u0010!R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R'\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/IPanelExtraInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/g;", "", "couponInfo$delegate", "Ljava/lang/Object;", "getCouponInfo", "()Ljava/lang/String;", "couponInfo", "confirmButtonUpperBubbleInfo$delegate", "getConfirmButtonUpperBubbleInfo", "confirmButtonUpperBubbleInfo", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/CouponBarInfoFlexImpl;", "couponBarInfo$delegate", "getCouponBarInfo", "()Lcom/bytedance/android/live/recharge/platform/business/model/diamond/CouponBarInfoFlexImpl;", "couponBarInfo", "diamondDesc$delegate", "getDiamondDesc", "diamondDesc", "confirmButtonDesc$delegate", "getConfirmButtonDesc", "confirmButtonDesc", "preCalcInfo$delegate", "getPreCalcInfo", "preCalcInfo", "", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/MetricsTagsFlexImpl;", "eventMap$delegate", "getEventMap", "()Ljava/util/Map;", "eventMap", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPanelExtraInfoFlexImpl extends FlexModelBase<g> implements g, vh7.h {

    @SerializedName("confirm_button_desc")
    protected String _$$confirmButtonDesc;

    @SerializedName("confirm_button_upper_right_bubble_info")
    protected String _$$confirmButtonUpperBubbleInfo;

    @SerializedName("coupon_bar_info")
    protected CouponBarInfoFlexImpl _$$couponBarInfo;

    @SerializedName("coupon_info")
    protected String _$$couponInfo;

    @SerializedName("diamond_desc")
    protected String _$$diamondDesc;

    @SerializedName("event_map")
    protected Map<String, MetricsTagsFlexImpl> _$$eventMap;

    @SerializedName("pre_calc_info")
    protected String _$$preCalcInfo;

    public IPanelExtraInfoFlexImpl() {
        super(g.class);
        this._$$eventMap = $defaultValue_eventMap$();
    }

    public IPanelExtraInfoFlexImpl(am3.g r12) {
        super(g.class);
        this._$$eventMap = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L37;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L8;
        this._$$couponInfo = am3.h.c(r12);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$confirmButtonUpperBubbleInfo = am3.h.c(r12);
        goto L3
    L10:
        if (r2 != 90) goto L12;
        this._$$preCalcInfo = am3.h.c(r12);
        goto L3
    L12:
        if (r2 != 200) goto L13;
        long r7 = r12.c();
        String r3 = null;
        MetricsTagsFlexImpl r6 = null;
    L19:
        int r9 = r12.f();
        if (r9 == (-1)) goto L26;
        if (r9 != 1) goto L22;
        r3 = am3.h.c(r12);
        goto L19
    L22:
        if (r9 != 2) goto L23;
        r6 = new MetricsTagsFlexImpl(r12);
        goto L19
    L23:
        am3.h.e(r12);
        goto L19
    L26:
        r12.d(r7);
        Map<String, MetricsTagsFlexImpl> r4 = this._$$eventMap;
        if (r3 == null) goto L33;
        if (r6 == null) goto L31;
        r4.put(r3, r6);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L13:
        switch(r2) {
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            default: goto L14;
        };
    L15:
        this._$$confirmButtonDesc = am3.h.c(r12);
        goto L3
    L16:
        this._$$diamondDesc = am3.h.c(r12);
        goto L3
    L17:
        this._$$couponBarInfo = new CouponBarInfoFlexImpl(r12);
        goto L3
    L14:
        am3.h.d(r5, r12);
        goto L3
    L37:
        r12.d(r0);
        setThreadSafe(true);
        if (this._$$eventMap != null) goto L74;
        this._$$eventMap = $defaultValue_eventMap$();
        return;
    }

    public final Map<String, MetricsTagsFlexImpl> $defaultValue_eventMap$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.g
    public /* bridge */ /* synthetic */ a getCouponBarInfo() {
        return getCouponBarInfo();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.g
    public final String getConfirmButtonDesc() {
        return this._$$confirmButtonDesc;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.g
    public final String getConfirmButtonUpperBubbleInfo() {
        return this._$$confirmButtonUpperBubbleInfo;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.g
    public final String getCouponInfo() {
        return this._$$couponInfo;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.g
    public final String getDiamondDesc() {
        return this._$$diamondDesc;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.g
    public final Map<String, MetricsTagsFlexImpl> getEventMap() {
        return this._$$eventMap;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.g
    public final String getPreCalcInfo() {
        return this._$$preCalcInfo;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.g
    public final CouponBarInfoFlexImpl getCouponBarInfo() {
        return this._$$couponBarInfo;
    }
}
