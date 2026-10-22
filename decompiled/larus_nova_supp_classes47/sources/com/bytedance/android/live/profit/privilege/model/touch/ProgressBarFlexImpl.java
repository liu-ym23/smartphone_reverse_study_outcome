package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.ProgressBar")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/ProgressBarFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/k;", "", "<set-?>", "currentvalue$delegate", "Ljava/lang/Object;", "getCurrentvalue", "()Ljava/lang/String;", "setCurrentvalue", "(Ljava/lang/String;)V", "currentvalue", "targetvalue$delegate", "getTargetvalue", "setTargetvalue", "targetvalue", "", "progressRate$delegate", "getProgressRate", "()Ljava/lang/Long;", "setProgressRate", "(Ljava/lang/Long;)V", "progressRate", "color$delegate", "getColor", "setColor", "color", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProgressBarFlexImpl extends FlexModelBase<k> implements k, vh7.h {

    @SerializedName("color")
    protected String _$$color;

    @SerializedName("current_value")
    protected String _$$currentvalue;

    @SerializedName("progress_rate")
    protected Long _$$progressRate;

    @SerializedName("target_value")
    protected String _$$targetvalue;

    public ProgressBarFlexImpl() {
        super(k.class);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.k
    public final String getColor() {
        return this._$$color;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.k
    public final String getCurrentvalue() {
        return this._$$currentvalue;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.k
    public final Long getProgressRate() {
        return this._$$progressRate;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.k
    public final String getTargetvalue() {
        return this._$$targetvalue;
    }

    public ProgressBarFlexImpl(am3.g r6) {
        super(k.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$currentvalue = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$targetvalue = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$progressRate = Long.valueOf(r6.j());
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$color = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.k
    public final void setColor(String r1) {
        this._$$color = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.k
    public final void setCurrentvalue(String r1) {
        this._$$currentvalue = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.k
    public final void setProgressRate(Long r1) {
        this._$$progressRate = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.k
    public final void setTargetvalue(String r1) {
        this._$$targetvalue = r1;
    }
}
