package com.bytedance.android.live.profit.fansclub.backend;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.FansclubBadge")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubBadgeFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubBadge;", "", "", "Lpy/k;", "icons", "Ljava/util/Map;", "getIcons", "()Ljava/util/Map;", "setIcons", "(Ljava/util/Map;)V", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IFansclubBadgeFlexImpl extends FlexModelBase<IFansclubBadge> implements IFansclubBadge, h {

    @SerializedName("Icons")
    protected Map<Long, ? extends k> icons;

    public IFansclubBadgeFlexImpl() {
        super(IFansclubBadge.class);
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubBadge
    public Map<Long, k> getIcons() {
        return this.icons;
    }

    public IFansclubBadgeFlexImpl(g r12) {
        super(IFansclubBadge.class);
        this.icons = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L25;
        g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L7;
        long r6 = r12.c();
        Long r3 = null;
        Object r7 = null;
    L9:
        int r8 = r12.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = Long.valueOf(r12.j());
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = f.a(r12, k.class);
        goto L9
    L14:
        am3.h.e(r12);
        goto L9
    L17:
        r12.d(r6);
        Map<Long, ? extends k> r4 = this.icons;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r5, r12);
        goto L3
    L25:
        r12.d(r0);
        setThreadSafe(true);
    }

    public void setIcons(Map<Long, ? extends k> r1) {
        this.icons = r1;
    }
}
