package com.bytedance.android.live.profit.fansclub;

import com.bytedance.live.datacontext.DataContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R-\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00150\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u001dR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u001dR!\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u001dR!\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007R!\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007¨\u00060"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/FansClubContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/profit/fansclub/g;", "profile$delegate", "Lcom/bytedance/live/datacontext/p;", "getProfile", "()Lcom/bytedance/live/datacontext/m;", "profile", "Lcom/bytedance/android/live/profit/fansclub/r;", "shopFansClubData$delegate", "getShopFansClubData", "shopFansClubData", "", "url$delegate", "getUrl", "url", "", "scene$delegate", "getScene", "scene", "", "extra$delegate", "getExtra", "extra", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/live/profit/fansclub/c;", "events$delegate", "getEvents", "()Lcom/bytedance/live/datacontext/k;", "events", "selfEvents$delegate", "getSelfEvents", "selfEvents", "", "guideEvent$delegate", "getGuideEvent", "guideEvent", "Lcom/bytedance/android/live/profit/fansclub/e;", "participateIncentive$delegate", "getParticipateIncentive", "participateIncentive", "Lcom/bytedance/android/live/profit/fansclub/l;", "fansGroupInfo$delegate", "getFansGroupInfo", "fansGroupInfo", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansClubContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p events$delegate;
    private final com.bytedance.live.datacontext.p extra$delegate;
    private final com.bytedance.live.datacontext.p fansGroupInfo$delegate;
    private final com.bytedance.live.datacontext.p guideEvent$delegate;
    private final com.bytedance.live.datacontext.p participateIncentive$delegate;
    private final com.bytedance.live.datacontext.p profile$delegate;
    private final com.bytedance.live.datacontext.p scene$delegate;
    private final com.bytedance.live.datacontext.p selfEvents$delegate;
    private final com.bytedance.live.datacontext.p shopFansClubData$delegate;
    private final com.bytedance.live.datacontext.p url$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(FansClubContext.class, "profile", "getProfile()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(FansClubContext.class, "shopFansClubData", "getShopFansClubData()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(FansClubContext.class, "url", "getUrl()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(FansClubContext.class, "scene", "getScene()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(FansClubContext.class, "extra", "getExtra()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(FansClubContext.class, "events", "getEvents()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(FansClubContext.class, "selfEvents", "getSelfEvents()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(FansClubContext.class, "guideEvent", "getGuideEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(FansClubContext.class, "participateIncentive", "getParticipateIncentive()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(FansClubContext.class, "fansGroupInfo", "getFansGroupInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final com.bytedance.live.datacontext.k<c> getEvents() {
        return (com.bytedance.live.datacontext.k) this.events$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.m<Map<String, String>> getExtra() {
        return (com.bytedance.live.datacontext.m) this.extra$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.m<l> getFansGroupInfo() {
        return (com.bytedance.live.datacontext.m) this.fansGroupInfo$delegate.a(this, $$delegatedProperties[9]);
    }

    public final com.bytedance.live.datacontext.k<Object> getGuideEvent() {
        return (com.bytedance.live.datacontext.k) this.guideEvent$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.m<e> getParticipateIncentive() {
        return (com.bytedance.live.datacontext.m) this.participateIncentive$delegate.a(this, $$delegatedProperties[8]);
    }

    public final com.bytedance.live.datacontext.m<g> getProfile() {
        return (com.bytedance.live.datacontext.m) this.profile$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getScene() {
        return (com.bytedance.live.datacontext.m) this.scene$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.k<c> getSelfEvents() {
        return (com.bytedance.live.datacontext.k) this.selfEvents$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.m<r> getShopFansClubData() {
        return (com.bytedance.live.datacontext.m) this.shopFansClubData$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<String> getUrl() {
        return (com.bytedance.live.datacontext.m) this.url$delegate.a(this, $$delegatedProperties[2]);
    }

    public FansClubContext() {
        this.profile$delegate = com.bytedance.live.datacontext.q.d(this, new g());
        this.shopFansClubData$delegate = com.bytedance.live.datacontext.q.d(this, new r());
        this.url$delegate = com.bytedance.live.datacontext.q.d(this, "");
        this.scene$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.extra$delegate = com.bytedance.live.datacontext.q.d(this, MapsKt.emptyMap());
        this.events$delegate = com.bytedance.live.datacontext.e.b(this);
        this.selfEvents$delegate = com.bytedance.live.datacontext.e.b(this);
        this.guideEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.participateIncentive$delegate = com.bytedance.live.datacontext.q.d(this, new e(0, null, 7));
        this.fansGroupInfo$delegate = com.bytedance.live.datacontext.q.d(this, new l(0));
    }
}
