package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.MemberEntranceInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b+\u0010,R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010$8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/base/model/user/AnchorCommonVip;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/j;", "", "type", "J", "getType", "()J", "setType", "(J)V", "", "showEntrance", "Z", "getShowEntrance", "()Z", "setShowEntrance", "(Z)V", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "Lpy/k;", "singleEntranceIcon", "Lpy/k;", "getSingleEntranceIcon", "()Lpy/k;", "setSingleEntranceIcon", "(Lpy/k;)V", "doubleEntranceIcon", "getDoubleEntranceIcon", "setDoubleEntranceIcon", "isMember", "setMember", "", "trackingParams", "Ljava/util/Map;", "getTrackingParams", "()Ljava/util/Map;", "setTrackingParams", "(Ljava/util/Map;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorCommonVip extends FlexModelBase<j> implements j, vh7.h {

    @SerializedName("double_entrance_icon")
    protected py.k doubleEntranceIcon;

    @SerializedName("is_member")
    protected boolean isMember;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("show_entrance")
    protected boolean showEntrance;

    @SerializedName("single_entrance_icon")
    protected py.k singleEntranceIcon;

    @SerializedName("tracking_params")
    protected Map<String, String> trackingParams;

    @SerializedName("type")
    protected long type;

    public AnchorCommonVip() {
        super(j.class);
        this.type = -1;
        this.schema = "";
    }

    @Override // com.bytedance.android.live.base.model.user.j
    public py.k getDoubleEntranceIcon() {
        return this.doubleEntranceIcon;
    }

    @Override // com.bytedance.android.live.base.model.user.j
    public String getSchema() {
        return this.schema;
    }

    @Override // com.bytedance.android.live.base.model.user.j
    public boolean getShowEntrance() {
        return this.showEntrance;
    }

    @Override // com.bytedance.android.live.base.model.user.j
    public py.k getSingleEntranceIcon() {
        return this.singleEntranceIcon;
    }

    @Override // com.bytedance.android.live.base.model.user.j
    public Map<String, String> getTrackingParams() {
        return this.trackingParams;
    }

    @Override // com.bytedance.android.live.base.model.user.j
    public long getType() {
        return this.type;
    }

    @Override // com.bytedance.android.live.base.model.user.j
    public boolean isMember() {
        return this.isMember;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object, py.k] */
    public AnchorCommonVip(am3.g r12) {
        super(j.class);
        this.trackingParams = new HashMap();
        boolean r0 = false;
        setThreadSafe(false);
        long r1 = r12.c();
    L3:
        int r3 = r12.f();
        if (r3 == (-1)) goto L32;
        am3.g.a r6 = decodeExtensionFields(r3, r12);
        if (r3 != 50) goto L7;
        long r7 = r12.c();
        String r4 = null;
        String r8 = null;
    L16:
        int r9 = r12.f();
        if (r9 == (-1)) goto L24;
        if (r9 != 1) goto L20;
        r4 = am3.h.c(r12);
        goto L16
    L20:
        if (r9 != 2) goto L21;
        r8 = am3.h.c(r12);
        goto L16
    L21:
        am3.h.e(r12);
        goto L16
    L24:
        r12.d(r7);
        Map<String, String> r5 = this.trackingParams;
        if (r4 == null) goto L31;
        if (r8 == null) goto L29;
        r5.put(r4, r8);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L7:
        switch(r3) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        this.isMember = am3.h.a(r12);
        goto L3
    L10:
        this.doubleEntranceIcon = vh7.f.a(r12, py.k.class);
        goto L3
    L11:
        this.singleEntranceIcon = vh7.f.a(r12, py.k.class);
        goto L3
    L12:
        this.schema = am3.h.c(r12);
        goto L3
    L13:
        this.showEntrance = am3.h.a(r12);
        goto L3
    L14:
        this.type = r12.j();
        r0 = r0 | true;
        goto L3
    L8:
        am3.h.d(r6, r12);
        goto L3
    L32:
        r12.d(r1);
        setThreadSafe(true);
        if ((r0 & true) == true) goto L36;
        this.type = -1;
    L36:
        if (this.schema != null) goto L69;
        this.schema = "";
        return;
    }

    public void setDoubleEntranceIcon(py.k r1) {
        this.doubleEntranceIcon = r1;
    }

    public void setMember(boolean r1) {
        this.isMember = r1;
    }

    public void setSchema(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.schema = r2;
    }

    public void setShowEntrance(boolean r1) {
        this.showEntrance = r1;
    }

    public void setSingleEntranceIcon(py.k r1) {
        this.singleEntranceIcon = r1;
    }

    public void setTrackingParams(Map<String, String> r1) {
        this.trackingParams = r1;
    }

    public void setType(long r1) {
        this.type = r1;
    }
}
