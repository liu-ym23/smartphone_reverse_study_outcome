package com.bytedance.android.live.revlink.link.domain.dependencyimpl;

import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e;
import com.bytedance.android.live.revlink.impl.multianchor.ui.b;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import f31.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\u0013R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/revlink/link/domain/dependencyimpl/DynamicContextDependencyImpl;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/context/e;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/b;", "", "source", "", "requestLayout", "Lcom/bytedance/live/datacontext/n;", "Lf31/i;", "windowStatus$delegate", "Lcom/bytedance/live/datacontext/p;", "getWindowStatus", "()Lcom/bytedance/live/datacontext/n;", "windowStatus", "Lcom/bytedance/live/datacontext/m;", "", "channelId$delegate", "getChannelId", "()Lcom/bytedance/live/datacontext/m;", "channelId", "", "changeScreenEvent$delegate", "getChangeScreenEvent", "changeScreenEvent", "Lcom/bytedance/live/datacontext/k;", "", "refreshWidgetEvent$delegate", "getRefreshWidgetEvent", "()Lcom/bytedance/live/datacontext/k;", "refreshWidgetEvent", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicContextDependencyImpl extends DataContext implements e, b {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p changeScreenEvent$delegate;
    private final p channelId$delegate;
    private final p refreshWidgetEvent$delegate;
    private final p windowStatus$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(DynamicContextDependencyImpl.class, "windowStatus", "getWindowStatus()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(DynamicContextDependencyImpl.class, "channelId", "getChannelId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DynamicContextDependencyImpl.class, "changeScreenEvent", "getChangeScreenEvent()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DynamicContextDependencyImpl.class, "refreshWidgetEvent", "getRefreshWidgetEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e
    public m<Boolean> getChangeScreenEvent() {
        return (m) this.changeScreenEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e
    public m<Long> getChannelId() {
        return (m) this.channelId$delegate.a(this, $$delegatedProperties[1]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e
    public k<Integer> getRefreshWidgetEvent() {
        return (k) this.refreshWidgetEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e
    public n<i> getWindowStatus() {
        return (n) this.windowStatus$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.b
    public void requestLayout(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public DynamicContextDependencyImpl() {
        this.windowStatus$delegate = q.b(this, DynamicContextDependencyImpl$windowStatus$2.INSTANCE);
        this.channelId$delegate = q.d(this, 0L);
        this.changeScreenEvent$delegate = q.a(this, Boolean.TRUE, DynamicContextDependencyImpl$changeScreenEvent$2.INSTANCE);
        this.refreshWidgetEvent$delegate = com.bytedance.live.datacontext.e.a(this, DynamicContextDependencyImpl$refreshWidgetEvent$2.INSTANCE);
    }
}
