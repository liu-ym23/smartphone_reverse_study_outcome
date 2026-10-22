package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.AudienceActionSource")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/AudienceActionSource;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/f;", "", "inviteSource", "Ljava/lang/Integer;", "getInviteSource", "()Ljava/lang/Integer;", "setInviteSource", "(Ljava/lang/Integer;)V", "permitSource", "getPermitSource", "setPermitSource", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceActionSource extends FlexModelBase<f> implements f, vh7.h {

    @SerializedName("invite_source")
    protected Integer inviteSource;

    @SerializedName("permit_source")
    protected Integer permitSource;

    public AudienceActionSource() {
        super(f.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.f
    public Integer getInviteSource() {
        return this.inviteSource;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.f
    public Integer getPermitSource() {
        return this.permitSource;
    }

    public AudienceActionSource(am3.g r6) {
        super(f.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.inviteSource = Integer.valueOf(r6.i());
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.permitSource = Integer.valueOf(r6.i());
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setInviteSource(Integer r1) {
        this.inviteSource = r1;
    }

    public void setPermitSource(Integer r1) {
        this.permitSource = r1;
    }
}
