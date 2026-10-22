package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007R!\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayInternalContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/broadcastgame/api/xplay/XplayScene;", "currentScene$delegate", "Lcom/bytedance/live/datacontext/p;", "getCurrentScene", "()Lcom/bytedance/live/datacontext/m;", "currentScene", "", "openXplayStartId$delegate", "getOpenXplayStartId", "openXplayStartId", "openFeatureBinderId$delegate", "getOpenFeatureBinderId", "openFeatureBinderId", "", "openCapture$delegate", "getOpenCapture", "openCapture", "Lcom/bytedance/live/datacontext/k;", "", "showKeyBoard$delegate", "getShowKeyBoard", "()Lcom/bytedance/live/datacontext/k;", "showKeyBoard", "", "pushStreamType$delegate", "getPushStreamType", "pushStreamType", "showFloatWindow$delegate", "getShowFloatWindow", "showFloatWindow", "", "seiDelay$delegate", "getSeiDelay", "seiDelay", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayInternalContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p currentScene$delegate;
    private final com.bytedance.live.datacontext.p openCapture$delegate;
    private final com.bytedance.live.datacontext.p openFeatureBinderId$delegate;
    private final com.bytedance.live.datacontext.p openXplayStartId$delegate;
    private final com.bytedance.live.datacontext.p pushStreamType$delegate;
    private final com.bytedance.live.datacontext.p seiDelay$delegate;
    private final com.bytedance.live.datacontext.p showFloatWindow$delegate;
    private final com.bytedance.live.datacontext.p showKeyBoard$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(XplayInternalContext.class, "currentScene", "getCurrentScene()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayInternalContext.class, "openXplayStartId", "getOpenXplayStartId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayInternalContext.class, "openFeatureBinderId", "getOpenFeatureBinderId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayInternalContext.class, "openCapture", "getOpenCapture()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayInternalContext.class, "showKeyBoard", "getShowKeyBoard()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(XplayInternalContext.class, "pushStreamType", "getPushStreamType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayInternalContext.class, "showFloatWindow", "getShowFloatWindow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(XplayInternalContext.class, "seiDelay", "getSeiDelay()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final com.bytedance.live.datacontext.m<XplayScene> getCurrentScene() {
        return (com.bytedance.live.datacontext.m) this.currentScene$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getOpenCapture() {
        return (com.bytedance.live.datacontext.m) this.openCapture$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.m<String> getOpenFeatureBinderId() {
        return (com.bytedance.live.datacontext.m) this.openFeatureBinderId$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.m<String> getOpenXplayStartId() {
        return (com.bytedance.live.datacontext.m) this.openXplayStartId$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getPushStreamType() {
        return (com.bytedance.live.datacontext.m) this.pushStreamType$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.m<Long> getSeiDelay() {
        return (com.bytedance.live.datacontext.m) this.seiDelay$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getShowFloatWindow() {
        return (com.bytedance.live.datacontext.m) this.showFloatWindow$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.k<Unit> getShowKeyBoard() {
        return (com.bytedance.live.datacontext.k) this.showKeyBoard$delegate.a(this, $$delegatedProperties[4]);
    }

    public XplayInternalContext() {
        this.currentScene$delegate = com.bytedance.live.datacontext.q.d(this, XplayScene.Video);
        this.openXplayStartId$delegate = com.bytedance.live.datacontext.q.d(this, "");
        this.openFeatureBinderId$delegate = com.bytedance.live.datacontext.q.d(this, "");
        Boolean r0 = Boolean.TRUE;
        this.openCapture$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.showKeyBoard$delegate = com.bytedance.live.datacontext.e.b(this);
        this.pushStreamType$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.showFloatWindow$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.seiDelay$delegate = com.bytedance.live.datacontext.q.d(this, -1L);
    }
}
