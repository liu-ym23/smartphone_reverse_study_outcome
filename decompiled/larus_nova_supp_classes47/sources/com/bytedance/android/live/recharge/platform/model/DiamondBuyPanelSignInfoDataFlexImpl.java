package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.wallet.DiamondBuyPanelSignInfoResult.DiamondBuyPanelSignInfoData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/DiamondBuyPanelSignInfoDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/model/c;", "", "Lcom/bytedance/android/live/recharge/platform/model/h;", "<set-?>", "signInfos$delegate", "Ljava/lang/Object;", "getSignInfos", "()Ljava/util/List;", "setSignInfos", "(Ljava/util/List;)V", "signInfos", "", "renderDataInfo$delegate", "getRenderDataInfo", "()Ljava/lang/String;", "setRenderDataInfo", "(Ljava/lang/String;)V", "renderDataInfo", "", "type$delegate", "getType", "()I", "setType", "(I)V", "type", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DiamondBuyPanelSignInfoDataFlexImpl extends FlexModelBase<c> implements c, vh7.h {

    @SerializedName("render_data_info")
    protected String _$$renderDataInfo;

    @SerializedName("sign_info")
    protected List<? extends h> _$$signInfos;

    @SerializedName("type")
    protected int _$$type;

    public DiamondBuyPanelSignInfoDataFlexImpl() {
        super(c.class);
        this._$$signInfos = $defaultValue_signInfos$();
        this._$$renderDataInfo = "";
    }

    public final List<h> $defaultValue_signInfos$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.recharge.platform.model.c
    public final String getRenderDataInfo() {
        return this._$$renderDataInfo;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.c
    public final List<h> getSignInfos() {
        return this._$$signInfos;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.c
    public final int getType() {
        return this._$$type;
    }

    public DiamondBuyPanelSignInfoDataFlexImpl(am3.g r6) {
        super(c.class);
        this._$$signInfos = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$signInfos.add(vh7.f.a(r6, h.class));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$renderDataInfo = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$type = r6.i();
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$signInfos.isEmpty() == false) goto L19;
        this._$$signInfos = $defaultValue_signInfos$();
    L19:
        if (this._$$renderDataInfo != null) goto L34;
        this._$$renderDataInfo = "";
        return;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.c
    public final void setRenderDataInfo(String r1) {
        this._$$renderDataInfo = r1;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.c
    public final void setSignInfos(List<? extends h> r1) {
        this._$$signInfos = r1;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.c
    public final void setType(int r1) {
        this._$$type = r1;
    }
}
