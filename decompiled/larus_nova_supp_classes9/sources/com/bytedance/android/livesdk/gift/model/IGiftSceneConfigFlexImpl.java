package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftSceneConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftSceneConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/z1;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfoFlexImpl;", "giftMarketingInfo$delegate", "Ljava/lang/Object;", "getGiftMarketingInfo", "()Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfoFlexImpl;", "giftMarketingInfo", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftSceneConfigFlexImpl extends FlexModelBase<z1> implements z1, vh7.h {

    @SerializedName("gift_marketing_info")
    protected IGiftMarketingInfoFlexImpl _$$giftMarketingInfo;

    @SerializedName("label")
    protected py.k icon;

    public IGiftSceneConfigFlexImpl() {
        super(z1.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IGiftSceneConfigFlexImpl(am3.g r6) {
        super(z1.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$giftMarketingInfo = new IGiftMarketingInfoFlexImpl(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.icon = vh7.f.a(r6, py.k.class);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.z1
    public /* bridge */ /* synthetic */ IGiftMarketingInfo getGiftMarketingInfo() {
        return getGiftMarketingInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.z1
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.z1
    public final IGiftMarketingInfoFlexImpl getGiftMarketingInfo() {
        return this._$$giftMarketingInfo;
    }

    public void setIcon(py.k r1) {
        this.icon = r1;
    }
}
