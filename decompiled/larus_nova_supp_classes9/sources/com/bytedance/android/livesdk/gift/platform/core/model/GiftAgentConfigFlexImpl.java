package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.GiftAgentConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/GiftAgentConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/platform/core/model/d;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", BuildConfig.FLAVOR, "schema$delegate", "Ljava/lang/Object;", "getSchema", "()Ljava/lang/String;", "schema", "<init>", "()V", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftAgentConfigFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("schema")
    protected String _$$schema;

    @SerializedName("icon")
    protected py.k icon;

    public GiftAgentConfigFlexImpl() {
        super(d.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public GiftAgentConfigFlexImpl(am3.g r6) {
        super(d.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.icon = vh7.f.a(r6, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$schema = am3.h.c(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d
    public final String getSchema() {
        return this._$$schema;
    }

    public void setIcon(py.k r1) {
        this.icon = r1;
    }
}
