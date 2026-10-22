package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.luckybox.BoxListResponse.ResponseData.DressInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/ILuckyBoxResponseData_IDressInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/redpacket/model/b$b;", "", "<set-?>", "dressId$delegate", "Ljava/lang/Object;", "getDressId", "()Ljava/lang/String;", "setDressId", "(Ljava/lang/String;)V", "dressId", "", "dressOfflineTime$delegate", "getDressOfflineTime", "()J", "setDressOfflineTime", "(J)V", "dressOfflineTime", "Lcom/bytedance/android/live/profit/redpacket/model/b$c;", "sameBoxJumpSchema$delegate", "getSameBoxJumpSchema", "()Lcom/bytedance/android/live/profit/redpacket/model/b$c;", "setSameBoxJumpSchema", "(Lcom/bytedance/android/live/profit/redpacket/model/b$c;)V", "sameBoxJumpSchema", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ILuckyBoxResponseData_IDressInfoFlexImpl extends FlexModelBase<b.InterfaceC0048b> implements b.InterfaceC0048b, vh7.h {

    @SerializedName("dress_id")
    protected String _$$dressId;

    @SerializedName("dress_offline_time")
    protected long _$$dressOfflineTime;

    @SerializedName("same_box_jump_schema")
    protected b.c _$$sameBoxJumpSchema;

    public ILuckyBoxResponseData_IDressInfoFlexImpl() {
        super(b.InterfaceC0048b.class);
        this._$$dressId = "";
        this._$$sameBoxJumpSchema = $defaultValue_sameBoxJumpSchema$();
    }

    public final b.c $defaultValue_sameBoxJumpSchema$() {
        return (b.c) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(b.c.class);
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b.InterfaceC0048b
    public final String getDressId() {
        return this._$$dressId;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b.InterfaceC0048b
    public final long getDressOfflineTime() {
        return this._$$dressOfflineTime;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b.InterfaceC0048b
    public final b.c getSameBoxJumpSchema() {
        return this._$$sameBoxJumpSchema;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.profit.redpacket.model.b$c, java.lang.Object] */
    public ILuckyBoxResponseData_IDressInfoFlexImpl(am3.g r6) {
        super(b.InterfaceC0048b.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$dressId = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$dressOfflineTime = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$sameBoxJumpSchema = vh7.f.a(r6, b.c.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$dressId != null) goto L19;
        this._$$dressId = "";
    L19:
        if (this._$$sameBoxJumpSchema != null) goto L34;
        this._$$sameBoxJumpSchema = $defaultValue_sameBoxJumpSchema$();
        return;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b.InterfaceC0048b
    public final void setDressId(String r1) {
        this._$$dressId = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b.InterfaceC0048b
    public final void setDressOfflineTime(long r1) {
        this._$$dressOfflineTime = r1;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b.InterfaceC0048b
    public final void setSameBoxJumpSchema(b.c r1) {
        this._$$sameBoxJumpSchema = r1;
    }
}
