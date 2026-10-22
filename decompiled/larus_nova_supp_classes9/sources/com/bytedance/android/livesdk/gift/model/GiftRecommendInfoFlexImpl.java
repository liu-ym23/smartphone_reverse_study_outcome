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
@ProtoMessage("webcast.data.GiftRecommendInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\r\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftRecommendInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/m0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "changeGiftIdPool$delegate", "Ljava/lang/Object;", "getChangeGiftIdPool", "()Ljava/util/List;", "changeGiftIdPool", "comboCount$delegate", "getComboCount", "()I", "comboCount", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftRecommendInfoFlexImpl extends FlexModelBase<m0> implements m0, vh7.h {

    @SerializedName("change_gift_id_pool")
    protected List<Integer> _$$changeGiftIdPool;

    @SerializedName("combo_count")
    protected int _$$comboCount;

    public GiftRecommendInfoFlexImpl() {
        super(m0.class);
        this._$$changeGiftIdPool = $defaultValue_changeGiftIdPool$();
    }

    public final List<Integer> $defaultValue_changeGiftIdPool$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.m0
    public final List<Integer> getChangeGiftIdPool() {
        return this._$$changeGiftIdPool;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m0
    public final int getComboCount() {
        return this._$$comboCount;
    }

    public GiftRecommendInfoFlexImpl(am3.g r6) {
        super(m0.class);
        this._$$changeGiftIdPool = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$changeGiftIdPool.add(Integer.valueOf(r6.i()));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$comboCount = r6.i();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$changeGiftIdPool.isEmpty() == false) goto L25;
        this._$$changeGiftIdPool = $defaultValue_changeGiftIdPool$();
        return;
    }
}
