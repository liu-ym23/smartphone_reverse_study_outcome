package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.GiftSearchConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/GiftSearchConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/platform/core/model/m;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", BuildConfig.FLAVOR, "schema$delegate", "Ljava/lang/Object;", "getSchema", "()Ljava/lang/String;", "schema", BuildConfig.FLAVOR, "closeGiftPanel$delegate", "getCloseGiftPanel", "()Ljava/lang/Boolean;", "closeGiftPanel", "isNormalSearch$delegate", "isNormalSearch", "<init>", "()V", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftSearchConfigFlexImpl extends FlexModelBase<m> implements m, vh7.h {

    @SerializedName("close_gift_panel")
    protected Boolean _$$closeGiftPanel;

    @SerializedName("is_normal_search")
    protected Boolean _$$isNormalSearch;

    @SerializedName("schema")
    protected String _$$schema;

    @SerializedName("icon")
    protected py.k icon;

    public GiftSearchConfigFlexImpl() {
        super(m.class);
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public GiftSearchConfigFlexImpl(am3.g r6) {
        super(m.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.icon = vh7.f.a(r6, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$schema = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$closeGiftPanel = Boolean.valueOf(am3.h.a(r6));
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$isNormalSearch = Boolean.valueOf(am3.h.a(r6));
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.m
    public final Boolean getCloseGiftPanel() {
        return this._$$closeGiftPanel;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.m
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.m
    public final String getSchema() {
        return this._$$schema;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.m
    public final Boolean isNormalSearch() {
        return this._$$isNormalSearch;
    }

    public void setIcon(py.k r1) {
        this.icon = r1;
    }
}
