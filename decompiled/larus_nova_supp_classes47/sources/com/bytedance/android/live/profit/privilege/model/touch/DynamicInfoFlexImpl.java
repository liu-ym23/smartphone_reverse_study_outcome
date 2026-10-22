package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.DynamicInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR;\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/DynamicInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/b;", "", "<set-?>", "showAfterTimeMs$delegate", "Ljava/lang/Object;", "getShowAfterTimeMs", "()Ljava/lang/Long;", "setShowAfterTimeMs", "(Ljava/lang/Long;)V", "showAfterTimeMs", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "text$delegate", "getText", "()Ljava/util/List;", "setText", "(Ljava/util/List;)V", "text", "durationMs$delegate", "getDurationMs", "setDurationMs", "durationMs", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicInfoFlexImpl extends FlexModelBase<b> implements b, vh7.h {

    @SerializedName("duration_ms")
    protected Long _$$durationMs;

    @SerializedName("show_after_time_ms")
    protected Long _$$showAfterTimeMs;

    @SerializedName("text")
    protected List<? extends n> _$$text;

    public DynamicInfoFlexImpl() {
        super(b.class);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.b
    public final Long getDurationMs() {
        return this._$$durationMs;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.b
    public final Long getShowAfterTimeMs() {
        return this._$$showAfterTimeMs;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.b
    public final List<n> getText() {
        return this._$$text;
    }

    public DynamicInfoFlexImpl(am3.g r6) {
        super(b.class);
        this._$$text = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$showAfterTimeMs = Long.valueOf(r6.j());
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$text.add(vh7.f.a(r6, n.class));
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$durationMs = Long.valueOf(r6.j());
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.b
    public final void setDurationMs(Long r1) {
        this._$$durationMs = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.b
    public final void setShowAfterTimeMs(Long r1) {
        this._$$showAfterTimeMs = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.b
    public final void setText(List<? extends n> r1) {
        this._$$text = r1;
    }
}
