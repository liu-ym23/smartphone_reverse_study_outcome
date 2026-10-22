package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.PluginInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRG\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/PluginInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/e3;", BuildConfig.FLAVOR, "<set-?>", "pluginId$delegate", "Ljava/lang/Object;", "getPluginId", "()J", "setPluginId", "(J)V", "pluginId", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "itemPotentialValueHint$delegate", "getItemPotentialValueHint", "()Ljava/util/Map;", "setItemPotentialValueHint", "(Ljava/util/Map;)V", "itemPotentialValueHint", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PluginInfoFlexImpl extends FlexModelBase<e3> implements e3, vh7.h {

    @SerializedName(e3.KEY_ITEM_POTENTIAL_VALUE_HINT)
    protected Map<String, String> _$$itemPotentialValueHint;

    @SerializedName(e3.KEY_PLUGIN_ID)
    protected long _$$pluginId;

    public PluginInfoFlexImpl() {
        super(e3.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.e3
    public final Map<String, String> getItemPotentialValueHint() {
        return this._$$itemPotentialValueHint;
    }

    @Override // com.bytedance.android.livesdk.gift.model.e3
    public final long getPluginId() {
        return this._$$pluginId;
    }

    public PluginInfoFlexImpl(am3.g r11) {
        super(e3.class);
        this._$$itemPotentialValueHint = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L27;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 1) goto L8;
        this._$$pluginId = r11.j();
        goto L3
    L8:
        if (r2 != 2) goto L9;
        long r7 = r11.c();
        String r3 = null;
        String r6 = null;
    L11:
        int r9 = r11.f();
        if (r9 == (-1)) goto L18;
        if (r9 != 1) goto L14;
        r3 = am3.h.c(r11);
        goto L11
    L14:
        if (r9 != 2) goto L15;
        r6 = am3.h.c(r11);
        goto L11
    L15:
        am3.h.e(r11);
        goto L11
    L18:
        r11.d(r7);
        Map<String, String> r4 = this._$$itemPotentialValueHint;
        if (r3 == null) goto L25;
        if (r6 == null) goto L23;
        r4.put(r3, r6);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r5, r11);
        goto L3
    L27:
        r11.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.e3
    public final void setItemPotentialValueHint(Map<String, String> r1) {
        this._$$itemPotentialValueHint = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.e3
    public final void setPluginId(long r1) {
        this._$$pluginId = r1;
    }
}
