package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.graphics.Rect;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\rR!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/littlewindow/XplayLittleWindowContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/broadcastgame/xplay/littlewindow/g;", "littleWindowState$delegate", "Lcom/bytedance/live/datacontext/p;", "getLittleWindowState", "()Lcom/bytedance/live/datacontext/m;", "littleWindowState", "Lcom/bytedance/live/datacontext/k;", "", "littleWindowStateChangedExternally$delegate", "getLittleWindowStateChangedExternally", "()Lcom/bytedance/live/datacontext/k;", "littleWindowStateChangedExternally", "Landroid/graphics/Rect;", "littleWindowRect$delegate", "getLittleWindowRect", "littleWindowRect", "", "isHidden$delegate", "isHidden", "updateMixerParams$delegate", "getUpdateMixerParams", "updateMixerParams", "zoomButtonEnabled$delegate", "getZoomButtonEnabled", "zoomButtonEnabled", "showDragIndicator$delegate", "getShowDragIndicator", "showDragIndicator", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayLittleWindowContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p isHidden$delegate;
    private final p littleWindowRect$delegate;
    private final p littleWindowState$delegate;
    private final p littleWindowStateChangedExternally$delegate;
    private final p showDragIndicator$delegate;
    private final p updateMixerParams$delegate;
    private final p zoomButtonEnabled$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(XplayLittleWindowContext.class, "littleWindowState", "getLittleWindowState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayLittleWindowContext.class, "littleWindowStateChangedExternally", "getLittleWindowStateChangedExternally()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(XplayLittleWindowContext.class, "littleWindowRect", "getLittleWindowRect()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayLittleWindowContext.class, "isHidden", "isHidden()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayLittleWindowContext.class, "updateMixerParams", "getUpdateMixerParams()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(XplayLittleWindowContext.class, "zoomButtonEnabled", "getZoomButtonEnabled()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayLittleWindowContext.class, "showDragIndicator", "getShowDragIndicator()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Rect> getLittleWindowRect() {
        return (m) this.littleWindowRect$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<g> getLittleWindowState() {
        return (m) this.littleWindowState$delegate.a(this, $$delegatedProperties[0]);
    }

    public final k<Unit> getLittleWindowStateChangedExternally() {
        return (k) this.littleWindowStateChangedExternally$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> getShowDragIndicator() {
        return (m) this.showDragIndicator$delegate.a(this, $$delegatedProperties[6]);
    }

    public final k<Unit> getUpdateMixerParams() {
        return (k) this.updateMixerParams$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Boolean> getZoomButtonEnabled() {
        return (m) this.zoomButtonEnabled$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Boolean> isHidden() {
        return (m) this.isHidden$delegate.a(this, $$delegatedProperties[3]);
    }

    public XplayLittleWindowContext() {
        this.littleWindowState$delegate = q.d(this, h.a);
        this.littleWindowStateChangedExternally$delegate = com.bytedance.live.datacontext.e.b(this);
        this.littleWindowRect$delegate = q.d(this, new Rect());
        Boolean r0 = Boolean.FALSE;
        this.isHidden$delegate = q.d(this, r0);
        this.updateMixerParams$delegate = com.bytedance.live.datacontext.e.b(this);
        this.zoomButtonEnabled$delegate = q.d(this, Boolean.TRUE);
        this.showDragIndicator$delegate = q.d(this, r0);
    }
}
