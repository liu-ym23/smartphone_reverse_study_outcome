package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.GiftPanelEntranceDetail")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b<\u0010=R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR/\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R;\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR/\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010\"\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0007\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R;\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0007\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010\u000bR/\u0010-\u001a\u0004\u0018\u00010'2\b\u0010\u0005\u001a\u0004\u0018\u00010'8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0007\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R/\u00104\u001a\u0004\u0018\u00010.2\b\u0010\u0005\u001a\u0004\u0018\u00010.8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0007\u001a\u0004\b0\u00101\"\u0004\b2\u00103RG\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u0001052\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u0001058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0007\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelEntranceDetailFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelEntranceDetail;", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "<set-?>", "panelDetail$delegate", "Ljava/lang/Object;", "getPanelDetail", "()Ljava/util/List;", "setPanelDetail", "(Ljava/util/List;)V", "panelDetail", "", "panelUrl$delegate", "getPanelUrl", "()Ljava/lang/String;", "setPanelUrl", "(Ljava/lang/String;)V", "panelUrl", "bubbleText$delegate", "getBubbleText", "setBubbleText", "bubbleText", "Lpy/k;", "bubbleBackgroundImg$delegate", "getBubbleBackgroundImg", "()Lpy/k;", "setBubbleBackgroundImg", "(Lpy/k;)V", "bubbleBackgroundImg", "bubbleUrl$delegate", "getBubbleUrl", "setBubbleUrl", "bubbleUrl", "awardTips$delegate", "getAwardTips", "setAwardTips", "awardTips", "Lcom/bytedance/android/live/profit/privilege/model/touch/h;", "lightInfo$delegate", "getLightInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/h;", "setLightInfo", "(Lcom/bytedance/android/live/profit/privilege/model/touch/h;)V", "lightInfo", "Lcom/bytedance/android/live/profit/privilege/model/touch/b;", "dynamicInfo$delegate", "getDynamicInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/b;", "setDynamicInfo", "(Lcom/bytedance/android/live/profit/privilege/model/touch/b;)V", "dynamicInfo", "", "extra$delegate", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "extra", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPanelEntranceDetailFlexImpl extends FlexModelBase<GiftPanelEntranceDetail> implements GiftPanelEntranceDetail, vh7.h {

    @SerializedName("award_tips")
    protected List<? extends n> _$$awardTips;

    @SerializedName("bubble_background_img")
    protected py.k _$$bubbleBackgroundImg;

    @SerializedName("bubble_text")
    protected List<? extends n> _$$bubbleText;

    @SerializedName("bubble_url")
    protected String _$$bubbleUrl;

    @SerializedName("dynamic_info")
    protected b _$$dynamicInfo;

    @SerializedName("extra")
    protected Map<String, String> _$$extra;

    @SerializedName("light_info")
    protected h _$$lightInfo;

    @SerializedName("panel_detail")
    protected List<? extends n> _$$panelDetail;

    @SerializedName("panel_url")
    protected String _$$panelUrl;

    public GiftPanelEntranceDetailFlexImpl() {
        super(GiftPanelEntranceDetail.class);
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.profit.privilege.model.touch.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.bytedance.android.live.profit.privilege.model.touch.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public GiftPanelEntranceDetailFlexImpl(am3.g r12) {
        super(GiftPanelEntranceDetail.class);
        this._$$panelDetail = new ArrayList();
        this._$$bubbleText = new ArrayList();
        this._$$awardTips = new ArrayList();
        this._$$extra = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L34;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        switch(r2) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
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
        Map<String, String> r4 = this._$$extra;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this._$$dynamicInfo = vh7.f.a(r12, b.class);
        goto L3
    L26:
        this._$$lightInfo = vh7.f.a(r12, h.class);
        goto L3
    L27:
        List<? extends n> r9 = this._$$awardTips;
    L33:
        r9.add(vh7.f.a(r12, n.class));
        goto L3
    L28:
        this._$$bubbleUrl = am3.h.c(r12);
        goto L3
    L29:
        this._$$bubbleBackgroundImg = vh7.f.a(r12, py.k.class);
        goto L3
    L30:
        r9 = this._$$bubbleText;
        goto L33
    L31:
        this._$$panelUrl = am3.h.c(r12);
        goto L3
    L32:
        r9 = this._$$panelDetail;
        goto L33
    L7:
        am3.h.d(r5, r12);
        goto L3
    L34:
        r12.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final List<n> getAwardTips() {
        return this._$$awardTips;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final py.k getBubbleBackgroundImg() {
        return this._$$bubbleBackgroundImg;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final List<n> getBubbleText() {
        return this._$$bubbleText;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final String getBubbleUrl() {
        return this._$$bubbleUrl;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final b getDynamicInfo() {
        return this._$$dynamicInfo;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final Map<String, String> getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final h getLightInfo() {
        return this._$$lightInfo;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final List<n> getPanelDetail() {
        return this._$$panelDetail;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final String getPanelUrl() {
        return this._$$panelUrl;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final void setAwardTips(List<? extends n> r1) {
        this._$$awardTips = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final void setBubbleBackgroundImg(py.k r1) {
        this._$$bubbleBackgroundImg = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final void setBubbleText(List<? extends n> r1) {
        this._$$bubbleText = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final void setBubbleUrl(String r1) {
        this._$$bubbleUrl = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final void setDynamicInfo(b r1) {
        this._$$dynamicInfo = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final void setExtra(Map<String, String> r1) {
        this._$$extra = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final void setLightInfo(h r1) {
        this._$$lightInfo = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final void setPanelDetail(List<? extends n> r1) {
        this._$$panelDetail = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail
    public final void setPanelUrl(String r1) {
        this._$$panelUrl = r1;
    }
}
