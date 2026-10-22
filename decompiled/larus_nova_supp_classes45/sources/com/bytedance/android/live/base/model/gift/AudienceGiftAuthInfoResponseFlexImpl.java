package com.bytedance.android.live.base.model.gift;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.gift.AudienceGiftAuthInfoResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/base/model/gift/AudienceGiftAuthInfoResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/gift/a;", "", "hasAudienceAuthSwitch$delegate", "Ljava/lang/Object;", "getHasAudienceAuthSwitch", "()Z", "hasAudienceAuthSwitch", "", "authSwitch$delegate", "getAuthSwitch", "()J", "authSwitch", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudienceGiftAuthInfoResponseFlexImpl extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("auth_switch")
    protected long _$$authSwitch;

    @SerializedName("has_audience_auth_switch")
    protected boolean _$$hasAudienceAuthSwitch;

    public AudienceGiftAuthInfoResponseFlexImpl() {
        super(a.class);
        this._$$hasAudienceAuthSwitch = $defaultValue_hasAudienceAuthSwitch$();
        this._$$authSwitch = $defaultValue_authSwitch$();
    }

    public final long $defaultValue_authSwitch$() {
        return 2;
    }

    public final boolean $defaultValue_hasAudienceAuthSwitch$() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.gift.a
    public final long getAuthSwitch() {
        return this._$$authSwitch;
    }

    @Override // com.bytedance.android.live.base.model.gift.a
    public final boolean getHasAudienceAuthSwitch() {
        return this._$$hasAudienceAuthSwitch;
    }

    public AudienceGiftAuthInfoResponseFlexImpl(am3.g r8) {
        super(a.class);
        int r0 = 0;
        setThreadSafe(false);
        long r1 = r8.c();
    L3:
        int r3 = r8.f();
        if (r3 == (-1)) goto L11;
        am3.g.a r4 = decodeExtensionFields(r3, r8);
        if (r3 != 1) goto L7;
        this._$$hasAudienceAuthSwitch = am3.h.a(r8);
        r0 = r0 | 1;
        goto L3
    L7:
        if (r3 != 2) goto L8;
        this._$$authSwitch = r8.j();
        r0 = r0 | 2;
        goto L3
    L8:
        am3.h.d(r4, r8);
        goto L3
    L11:
        r8.d(r1);
        setThreadSafe(true);
        if ((r0 & 1) != 0) goto L15;
        this._$$hasAudienceAuthSwitch = $defaultValue_hasAudienceAuthSwitch$();
    L15:
        if ((r0 & 2) != 0) goto L27;
        this._$$authSwitch = $defaultValue_authSwitch$();
        return;
    }
}
