package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.growth.touch.ListTouchPositionResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR/\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RG\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/ListTouchPositionResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/j;", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/p;", "<set-?>", "touchPositions$delegate", "Ljava/lang/Object;", "getTouchPositions", "()Ljava/util/List;", "setTouchPositions", "(Ljava/util/List;)V", "touchPositions", "", "touchPositionsStr$delegate", "getTouchPositionsStr", "()Ljava/lang/String;", "setTouchPositionsStr", "(Ljava/lang/String;)V", "touchPositionsStr", "", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/s;", "touchPositionMap$delegate", "getTouchPositionMap", "()Ljava/util/Map;", "setTouchPositionMap", "(Ljava/util/Map;)V", "touchPositionMap", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ListTouchPositionResponseFlexImpl extends FlexModelBase<j> implements j, vh7.h {

    @SerializedName("touch_positions_map")
    protected Map<Long, ? extends s> _$$touchPositionMap;

    @SerializedName("touch_positions")
    protected List<? extends p> _$$touchPositions;

    @SerializedName("touch_positions_str")
    protected String _$$touchPositionsStr;

    public ListTouchPositionResponseFlexImpl() {
        super(j.class);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.j
    public final Map<Long, s> getTouchPositionMap() {
        return this._$$touchPositionMap;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.j
    public final List<p> getTouchPositions() {
        return this._$$touchPositions;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.j
    public final String getTouchPositionsStr() {
        return this._$$touchPositionsStr;
    }

    public ListTouchPositionResponseFlexImpl(am3.g r12) {
        super(j.class);
        this._$$touchPositions = new ArrayList();
        this._$$touchPositionMap = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L30;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L8;
        this._$$touchPositions.add(vh7.f.a(r12, p.class));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$touchPositionsStr = am3.h.c(r12);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        long r7 = r12.c();
        Long r3 = null;
        Object r6 = null;
    L13:
        int r9 = r12.f();
        if (r9 == (-1)) goto L20;
        if (r9 != 1) goto L16;
        r3 = Long.valueOf(r12.j());
        goto L13
    L16:
        if (r9 != 2) goto L17;
        r6 = vh7.f.a(r12, s.class);
        goto L13
    L17:
        am3.h.e(r12);
        goto L13
    L20:
        r12.d(r7);
        Map<Long, ? extends s> r4 = this._$$touchPositionMap;
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

    @Override // com.bytedance.android.live.profit.privilege.model.touch.j
    public final void setTouchPositionMap(Map<Long, ? extends s> r1) {
        this._$$touchPositionMap = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.j
    public final void setTouchPositions(List<? extends p> r1) {
        this._$$touchPositions = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.j
    public final void setTouchPositionsStr(String r1) {
        this._$$touchPositionsStr = r1;
    }
}
