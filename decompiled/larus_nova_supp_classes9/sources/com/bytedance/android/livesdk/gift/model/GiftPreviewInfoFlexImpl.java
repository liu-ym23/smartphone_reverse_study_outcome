package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftPreviewInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R+\u0010!\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftPreviewInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/k0;", BuildConfig.FLAVOR, "<set-?>", "lockStatus$delegate", "Ljava/lang/Object;", "getLockStatus", "()J", "setLockStatus", "(J)V", "lockStatus", BuildConfig.FLAVOR, "clientBlockUseSchemeUrl$delegate", "getClientBlockUseSchemeUrl", "()Z", "setClientBlockUseSchemeUrl", "(Z)V", "clientBlockUseSchemeUrl", BuildConfig.FLAVOR, "blockSchemeUrl$delegate", "getBlockSchemeUrl", "()Ljava/lang/String;", "setBlockSchemeUrl", "(Ljava/lang/String;)V", "blockSchemeUrl", "clientCheckLeftDiamond$delegate", "getClientCheckLeftDiamond", "setClientCheckLeftDiamond", "clientCheckLeftDiamond", "blockToast$delegate", "getBlockToast", "setBlockToast", "blockToast", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPreviewInfoFlexImpl extends FlexModelBase<k0> implements k0, vh7.h {

    @SerializedName("block_scheme_url")
    protected String _$$blockSchemeUrl;

    @SerializedName("block_toast")
    protected String _$$blockToast;

    @SerializedName("client_block_use_scheme_url")
    protected boolean _$$clientBlockUseSchemeUrl;

    @SerializedName("client_check_left_diamond")
    protected boolean _$$clientCheckLeftDiamond;

    @SerializedName("lock_status")
    protected long _$$lockStatus;

    public GiftPreviewInfoFlexImpl() {
        super(k0.class);
        this._$$clientBlockUseSchemeUrl = false;
        this._$$blockSchemeUrl = BuildConfig.FLAVOR;
        this._$$clientCheckLeftDiamond = false;
        this._$$blockToast = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k0
    public final String getBlockSchemeUrl() {
        return this._$$blockSchemeUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k0
    public final String getBlockToast() {
        return this._$$blockToast;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k0
    public final boolean getClientBlockUseSchemeUrl() {
        return this._$$clientBlockUseSchemeUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k0
    public final boolean getClientCheckLeftDiamond() {
        return this._$$clientCheckLeftDiamond;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k0
    public final long getLockStatus() {
        return this._$$lockStatus;
    }

    public GiftPreviewInfoFlexImpl(am3.g r9) {
        super(k0.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L20;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L8;
        this._$$lockStatus = r9.j();
        r3 = r3 | 1;
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$clientBlockUseSchemeUrl = am3.h.a(r9);
        r3 = r3 | 2;
        goto L3
    L10:
        if (r4 != 3) goto L11;
        this._$$blockSchemeUrl = am3.h.c(r9);
        goto L3
    L11:
        if (r4 != 4) goto L13;
        this._$$clientCheckLeftDiamond = am3.h.a(r9);
        r3 = r3 | 4;
        goto L3
    L13:
        if (r4 != 5) goto L14;
        this._$$blockToast = am3.h.c(r9);
        goto L3
    L14:
        am3.h.d(r5, r9);
        goto L3
    L20:
        r9.d(r1);
        setThreadSafe(true);
        if ((r3 & 2) != 0) goto L24;
        this._$$clientBlockUseSchemeUrl = false;
    L24:
        if (this._$$blockSchemeUrl != null) goto L27;
        this._$$blockSchemeUrl = BuildConfig.FLAVOR;
    L27:
        if ((r3 & 4) != 0) goto L30;
        this._$$clientCheckLeftDiamond = false;
    L30:
        if (this._$$blockToast != null) goto L51;
        this._$$blockToast = BuildConfig.FLAVOR;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k0
    public final void setBlockSchemeUrl(String r1) {
        this._$$blockSchemeUrl = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k0
    public final void setBlockToast(String r1) {
        this._$$blockToast = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k0
    public final void setClientBlockUseSchemeUrl(boolean r1) {
        this._$$clientBlockUseSchemeUrl = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k0
    public final void setClientCheckLeftDiamond(boolean r1) {
        this._$$clientCheckLeftDiamond = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.k0
    public final void setLockStatus(long r1) {
        this._$$lockStatus = r1;
    }
}
