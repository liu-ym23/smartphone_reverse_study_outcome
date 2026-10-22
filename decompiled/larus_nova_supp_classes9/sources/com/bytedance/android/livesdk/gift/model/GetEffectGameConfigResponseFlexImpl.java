package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.ugm.api.webcast_profit_freecell.GetEffectGameConfigResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GetEffectGameConfigResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/a0;", BuildConfig.FLAVOR, "forbiddenSwitch$delegate", "Ljava/lang/Object;", "getForbiddenSwitch", "()Z", "forbiddenSwitch", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetEffectGameConfigResponseFlexImpl extends FlexModelBase<a0> implements a0, vh7.h {

    @SerializedName("forbidden_switch")
    protected boolean _$$forbiddenSwitch;

    public GetEffectGameConfigResponseFlexImpl() {
        super(a0.class);
        this._$$forbiddenSwitch = false;
    }

    public GetEffectGameConfigResponseFlexImpl(am3.g r8) {
        super(a0.class);
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L9;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L7;
        this._$$forbiddenSwitch = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L7:
        am3.h.d(r5, r8);
        goto L3
    L9:
        r8.d(r1);
        setThreadSafe(true);
        if ((r3 & true) == true) goto L19;
        this._$$forbiddenSwitch = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a0
    public final boolean getForbiddenSwitch() {
        return this._$$forbiddenSwitch;
    }
}
