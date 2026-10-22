package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.AudienceReceiverListResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/AudienceReceiverListResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/e;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/d0;", "<set-?>", "audienceReceiverList$delegate", "Ljava/lang/Object;", "getAudienceReceiverList", "()Ljava/util/List;", "setAudienceReceiverList", "(Ljava/util/List;)V", "audienceReceiverList", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudienceReceiverListResponseFlexImpl extends FlexModelBase<e> implements e, vh7.h {

    @SerializedName("audience_receiver_list")
    protected List<? extends d0> _$$audienceReceiverList;

    public AudienceReceiverListResponseFlexImpl() {
        super(e.class);
    }

    public AudienceReceiverListResponseFlexImpl(am3.g r6) {
        super(e.class);
        this._$$audienceReceiverList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$audienceReceiverList.add(vh7.f.a(r6, d0.class));
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.e
    public final List<d0> getAudienceReceiverList() {
        return this._$$audienceReceiverList;
    }

    @Override // com.bytedance.android.livesdk.gift.model.e
    public final void setAudienceReceiverList(List<? extends d0> r1) {
        this._$$audienceReceiverList = r1;
    }
}
