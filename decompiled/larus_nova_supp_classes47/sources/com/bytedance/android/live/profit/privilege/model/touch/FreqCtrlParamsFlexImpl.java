package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.FreqCtrlParams")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R/\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R/\u0010!\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/FreqCtrlParamsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/d;", "", "<set-?>", "strategy$delegate", "Ljava/lang/Object;", "getStrategy", "()I", "setStrategy", "(I)V", "strategy", "", "limit$delegate", "getLimit", "()Ljava/lang/Long;", "setLimit", "(Ljava/lang/Long;)V", "limit", "", "key$delegate", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "key", "cur$delegate", "getCur", "setCur", "cur", "duration$delegate", "getDuration", "setDuration", Constants.Keys.duration, "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FreqCtrlParamsFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("cur")
    protected Long _$$cur;

    @SerializedName(Constants.Keys.duration)
    protected Long _$$duration;

    @SerializedName("key")
    protected String _$$key;

    @SerializedName("limit")
    protected Long _$$limit;

    @SerializedName("strategy")
    protected int _$$strategy;

    public FreqCtrlParamsFlexImpl() {
        super(d.class);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.d
    public final Long getCur() {
        return this._$$cur;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.d
    public final Long getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.d
    public final String getKey() {
        return this._$$key;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.d
    public final Long getLimit() {
        return this._$$limit;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.d
    public final int getStrategy() {
        return this._$$strategy;
    }

    public FreqCtrlParamsFlexImpl(am3.g r6) {
        super(d.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$strategy = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$limit = Long.valueOf(r6.j());
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$key = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$cur = Long.valueOf(r6.j());
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this._$$duration = Long.valueOf(r6.j());
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.d
    public final void setCur(Long r1) {
        this._$$cur = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.d
    public final void setDuration(Long r1) {
        this._$$duration = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.d
    public final void setKey(String r1) {
        this._$$key = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.d
    public final void setLimit(Long r1) {
        this._$$limit = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.d
    public final void setStrategy(int r1) {
        this._$$strategy = r1;
    }
}
