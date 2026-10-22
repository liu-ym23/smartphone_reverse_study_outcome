package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R-\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\u0013R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\u0013R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\u0013R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\"R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\u0005\u0010\"R!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\"¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/EpisodeInteractiveContext;", "Lcom/bytedance/live/datacontext/DataContext;", BuildConfig.FLAVOR, "init", BuildConfig.FLAVOR, "isInteractConfigExist", "setUpForTemplate", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/chatroom/x;", BuildConfig.FLAVOR, "interactiveStorage$delegate", "Lcom/bytedance/live/datacontext/p;", "getInteractiveStorage", "()Lcom/bytedance/live/datacontext/j;", "interactiveStorage", "Lcom/bytedance/live/datacontext/n;", "Lkm1/a;", "liveInteractiveInfo$delegate", "getLiveInteractiveInfo", "()Lcom/bytedance/live/datacontext/n;", "liveInteractiveInfo", "Lcom/bytedance/android/livesdk/interactivity/interactive/c;", "liveInteractiveAnnieXInfo$delegate", "getLiveInteractiveAnnieXInfo", "liveInteractiveAnnieXInfo", "episodeInteractiveInfo$delegate", "getEpisodeInteractiveInfo", "episodeInteractiveInfo", "episodeInteractiveAnnieXInfo$delegate", "getEpisodeInteractiveAnnieXInfo", "episodeInteractiveAnnieXInfo", "Lcom/bytedance/live/datacontext/m;", "firstShowHasFirstResume$delegate", "getFirstShowHasFirstResume", "()Lcom/bytedance/live/datacontext/m;", "firstShowHasFirstResume", "isInteractConfigExist$delegate", "enableInteractive$delegate", "getEnableInteractive", "enableInteractive", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeInteractiveContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p enableInteractive$delegate;
    private final com.bytedance.live.datacontext.p episodeInteractiveAnnieXInfo$delegate;
    private final com.bytedance.live.datacontext.p episodeInteractiveInfo$delegate;
    private final com.bytedance.live.datacontext.p firstShowHasFirstResume$delegate;
    private final com.bytedance.live.datacontext.p interactiveStorage$delegate;
    private final com.bytedance.live.datacontext.p isInteractConfigExist$delegate;
    private final com.bytedance.live.datacontext.p liveInteractiveAnnieXInfo$delegate;
    private final com.bytedance.live.datacontext.p liveInteractiveInfo$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(EpisodeInteractiveContext.class, "interactiveStorage", "getInteractiveStorage()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(EpisodeInteractiveContext.class, "liveInteractiveInfo", "getLiveInteractiveInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(EpisodeInteractiveContext.class, "liveInteractiveAnnieXInfo", "getLiveInteractiveAnnieXInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(EpisodeInteractiveContext.class, "episodeInteractiveInfo", "getEpisodeInteractiveInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(EpisodeInteractiveContext.class, "episodeInteractiveAnnieXInfo", "getEpisodeInteractiveAnnieXInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(EpisodeInteractiveContext.class, "firstShowHasFirstResume", "getFirstShowHasFirstResume()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(EpisodeInteractiveContext.class, "isInteractConfigExist", "isInteractConfigExist()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(EpisodeInteractiveContext.class, "enableInteractive", "getEnableInteractive()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final com.bytedance.live.datacontext.m<Boolean> getEnableInteractive() {
        return (com.bytedance.live.datacontext.m) this.enableInteractive$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.n<c> getEpisodeInteractiveAnnieXInfo() {
        return (com.bytedance.live.datacontext.n) this.episodeInteractiveAnnieXInfo$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.n<km1.a> getEpisodeInteractiveInfo() {
        return (com.bytedance.live.datacontext.n) this.episodeInteractiveInfo$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getFirstShowHasFirstResume() {
        return (com.bytedance.live.datacontext.m) this.firstShowHasFirstResume$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.x<String, String>> getInteractiveStorage() {
        return (com.bytedance.live.datacontext.j) this.interactiveStorage$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.n<c> getLiveInteractiveAnnieXInfo() {
        return (com.bytedance.live.datacontext.n) this.liveInteractiveAnnieXInfo$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.n<km1.a> getLiveInteractiveInfo() {
        return (com.bytedance.live.datacontext.n) this.liveInteractiveInfo$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isInteractConfigExist() {
        return (com.bytedance.live.datacontext.m) this.isInteractConfigExist$delegate.a(this, $$delegatedProperties[6]);
    }

    public EpisodeInteractiveContext() {
        this.interactiveStorage$delegate = ConstantKt.b(this, EpisodeInteractiveContext$interactiveStorage$2.INSTANCE);
        this.liveInteractiveInfo$delegate = com.bytedance.live.datacontext.q.b(this, EpisodeInteractiveContext$liveInteractiveInfo$2.INSTANCE);
        this.liveInteractiveAnnieXInfo$delegate = com.bytedance.live.datacontext.q.b(this, EpisodeInteractiveContext$liveInteractiveAnnieXInfo$2.INSTANCE);
        this.episodeInteractiveInfo$delegate = com.bytedance.live.datacontext.q.b(this, EpisodeInteractiveContext$episodeInteractiveInfo$2.INSTANCE);
        this.episodeInteractiveAnnieXInfo$delegate = com.bytedance.live.datacontext.q.b(this, EpisodeInteractiveContext$episodeInteractiveAnnieXInfo$2.INSTANCE);
        Boolean r0 = Boolean.FALSE;
        this.firstShowHasFirstResume$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.isInteractConfigExist$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.enableInteractive$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.TRUE);
    }

    public final void init() {
        getInteractiveStorage().d(new km1.b());
    }

    public final void setUpForTemplate(boolean r2) {
        isInteractConfigExist().setValue(Boolean.valueOf(r2));
    }
}
