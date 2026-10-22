package com.bytedance.android.live.revlink.link.infra.rtcbiz;

import com.bytedance.android.live.revlink.impl.multianchor.connect.o;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0012\u0010\u0013R-\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/RTCManagerDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/b;", "Lcom/bytedance/live/datacontext/m;", "", "", "Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/d;", "renderFrames$delegate", "Lcom/bytedance/live/datacontext/p;", "getRenderFrames", "()Lcom/bytedance/live/datacontext/m;", "renderFrames", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/o;", "forwardInfo", "Lcom/bytedance/live/datacontext/n;", "getForwardInfo", "()Lcom/bytedance/live/datacontext/n;", "<init>", "(Lcom/bytedance/live/datacontext/n;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTCManagerDataContext extends DataContext implements b {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final n<o> forwardInfo;
    private final p renderFrames$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RTCManagerDataContext.class, "renderFrames", "getRenderFrames()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    @Override // com.bytedance.android.live.revlink.link.infra.rtcbiz.b
    public m<Map<String, d>> getRenderFrames() {
        return (m) this.renderFrames$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.android.live.revlink.link.infra.rtcbiz.b
    public n<o> getForwardInfo() {
        return this.forwardInfo;
    }

    public RTCManagerDataContext(n<o> r2) {
        Intrinsics.checkNotNullParameter(r2, "forwardInfo");
        this.forwardInfo = r2;
        this.renderFrames$delegate = q.a(this, MapsKt.emptyMap(), RTCManagerDataContext$renderFrames$2.INSTANCE);
    }
}
