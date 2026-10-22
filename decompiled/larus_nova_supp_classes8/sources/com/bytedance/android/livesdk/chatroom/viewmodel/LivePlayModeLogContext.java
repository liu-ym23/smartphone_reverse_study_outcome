package com.bytedance.android.livesdk.chatroom.viewmodel;

import com.bytedance.android.livesdk.chatroom.utils.g0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R'\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/LivePlayModeLogContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "clearPlayModesOnlySupportMultiPeople", "", "playMode", "", "removePlayMode", "addPlayMode", "hasPlayMode", "Lcom/bytedance/live/datacontext/m;", "", "playModes$delegate", "Lcom/bytedance/live/datacontext/p;", "getPlayModes", "()Lcom/bytedance/live/datacontext/m;", "playModes", "Lcom/bytedance/live/datacontext/k;", "addPlayModeEvent$delegate", "getAddPlayModeEvent", "()Lcom/bytedance/live/datacontext/k;", "addPlayModeEvent", "<init>", "()V", "Companion", "a", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayModeLogContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private static final Set<Integer> playModesLiveWithoutMultiPeople = null;
    private static final Set<Integer> playModesSupportCrossFunctionTypes = null;
    private final p addPlayModeEvent$delegate;
    private final p playModes$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LivePlayModeLogContext.class, "playModes", "getPlayModes()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LivePlayModeLogContext.class, "addPlayModeEvent", "getAddPlayModeEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
        playModesLiveWithoutMultiPeople = SetsKt.setOf(new Integer[]{8, 9, 10, Integer.MAX_VALUE, 21, 23});
        playModesSupportCrossFunctionTypes = SetsKt.setOf(new Integer[]{8, 9, 10, Integer.MAX_VALUE, 21});
    }

    public final com.bytedance.live.datacontext.k<Integer> getAddPlayModeEvent() {
        return (com.bytedance.live.datacontext.k) this.addPlayModeEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Set<Integer>> getPlayModes() {
        return (m) this.playModes$delegate.a(this, $$delegatedProperties[0]);
    }

    public final void clearPlayModesOnlySupportMultiPeople() {
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r1 = ((Set) getPlayModes().getValue()).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        int r2 = ((Number) r1.next()).intValue();
        if (playModesLiveWithoutMultiPeople.contains(Integer.valueOf(r2)) == false) goto L4;
        r0.add(Integer.valueOf(r2));
        goto L4
    L8:
        ((Set) getPlayModes().getValue()).clear();
        int r3 = g0.a;
        jc1.k.n(IPerformanceManager.class).onMultiModuleStop("play_mode");
        ((Set) getPlayModes().getValue()).addAll(r0);
    }

    public LivePlayModeLogContext() {
        this.playModes$delegate = q.d(this, new LinkedHashSet());
        this.addPlayModeEvent$delegate = com.bytedance.live.datacontext.e.b(this);
    }

    public static final /* synthetic */ Set access$getPlayModesLiveWithoutMultiPeople$cp() {
        return playModesLiveWithoutMultiPeople;
    }

    public static final /* synthetic */ Set access$getPlayModesSupportCrossFunctionTypes$cp() {
        return playModesSupportCrossFunctionTypes;
    }

    public final boolean addPlayMode(int r3) {
        if (((Set) getPlayModes().getValue()).contains(Integer.valueOf(r3)) == true) goto L5;
        boolean r4 = ((Set) getPlayModes().getValue()).add(Integer.valueOf(r3));
    L6:
        g0.f(CollectionsKt.toIntArray((Collection) getPlayModes().getValue()));
        return r4;
    L5:
        r4 = true;
        goto L6
    }

    public final boolean hasPlayMode(int r2) {
        return ((Set) getPlayModes().getValue()).contains(Integer.valueOf(r2));
    }

    public final boolean removePlayMode(int r2) {
        boolean r3 = ((Set) getPlayModes().getValue()).remove(Integer.valueOf(r2));
        g0.f(CollectionsKt.toIntArray((Collection) getPlayModes().getValue()));
        return r3;
    }
}
