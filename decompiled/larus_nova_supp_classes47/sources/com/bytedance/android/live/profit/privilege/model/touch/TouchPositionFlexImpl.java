package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.TouchPosition")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011RG\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/TouchPositionFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/p;", "Lcom/bytedance/android/live/profit/privilege/model/touch/r;", "<set-?>", "meta$delegate", "Ljava/lang/Object;", "getMeta", "()Lcom/bytedance/android/live/profit/privilege/model/touch/r;", "setMeta", "(Lcom/bytedance/android/live/profit/privilege/model/touch/r;)V", "meta", "Lcom/bytedance/android/live/profit/privilege/model/touch/q;", "detail$delegate", "getDetail", "()Lcom/bytedance/android/live/profit/privilege/model/touch/q;", "setDetail", "(Lcom/bytedance/android/live/profit/privilege/model/touch/q;)V", "detail", "", "", "bizExtra$delegate", "getBizExtra", "()Ljava/util/Map;", "setBizExtra", "(Ljava/util/Map;)V", "bizExtra", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TouchPositionFlexImpl extends FlexModelBase<p> implements p, vh7.h {

    @SerializedName("biz_extra")
    protected Map<String, String> _$$bizExtra;

    @SerializedName("detail")
    protected q _$$detail;

    @SerializedName("meta")
    protected r _$$meta;

    public TouchPositionFlexImpl() {
        super(p.class);
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.profit.privilege.model.touch.q, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.profit.privilege.model.touch.r, java.lang.Object] */
    public TouchPositionFlexImpl(am3.g r12) {
        super(p.class);
        this._$$bizExtra = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L30;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L8;
        this._$$meta = vh7.f.a(r12, r.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$detail = vh7.f.a(r12, q.class);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        long r7 = r12.c();
        String r3 = null;
        String r6 = null;
    L13:
        int r9 = r12.f();
        if (r9 == (-1)) goto L20;
        if (r9 != 1) goto L16;
        r3 = am3.h.c(r12);
        goto L13
    L16:
        if (r9 != 2) goto L17;
        r6 = am3.h.c(r12);
        goto L13
    L17:
        am3.h.e(r12);
        goto L13
    L20:
        r12.d(r7);
        Map<String, String> r4 = this._$$bizExtra;
        if (r3 == null) goto L27;
        if (r6 == null) goto L25;
        r4.put(r3, r6);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.d(r5, r12);
        goto L3
    L30:
        r12.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.p
    public final Map<String, String> getBizExtra() {
        return this._$$bizExtra;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.p
    public final q getDetail() {
        return this._$$detail;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.p
    public final r getMeta() {
        return this._$$meta;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.p
    public final void setBizExtra(Map<String, String> r1) {
        this._$$bizExtra = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.p
    public final void setDetail(q r1) {
        this._$$detail = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.p
    public final void setMeta(r r1) {
        this._$$meta = r1;
    }
}
