package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.PinMostlyUsedPageTopResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/PinMostlyUsedPageTopResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/d3;", BuildConfig.FLAVOR, "<set-?>", "sortStrategy$delegate", "Ljava/lang/Object;", "getSortStrategy", "()J", "setSortStrategy", "(J)V", "sortStrategy", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PinMostlyUsedPageTopResponseFlexImpl extends FlexModelBase<d3> implements d3, vh7.h {

    @SerializedName("sort_strategy")
    protected long _$$sortStrategy;

    public PinMostlyUsedPageTopResponseFlexImpl() {
        super(d3.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.d3
    public final long getSortStrategy() {
        return this._$$sortStrategy;
    }

    public PinMostlyUsedPageTopResponseFlexImpl(am3.g r6) {
        super(d3.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$sortStrategy = r6.j();
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.d3
    public final void setSortStrategy(long r1) {
        this._$$sortStrategy = r1;
    }
}
