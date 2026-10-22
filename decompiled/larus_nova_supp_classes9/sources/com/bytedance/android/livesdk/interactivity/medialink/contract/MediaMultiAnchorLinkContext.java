package com.bytedance.android.livesdk.interactivity.medialink.contract;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import e92.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001MB\u0007¢\u0006\u0004\bJ\u0010KJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R!\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010&R!\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010&R!\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010&R!\u00101\u001a\b\u0012\u0004\u0012\u00020+0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b0\u0010&R!\u00107\u001a\b\u0012\u0004\u0012\u000203028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0012\u001a\u0004\b5\u00106R!\u0010:\u001a\b\u0012\u0004\u0012\u00020+028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0012\u001a\u0004\b9\u00106R!\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0007028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0012\u001a\u0004\b<\u00106R!\u0010@\u001a\b\u0012\u0004\u0012\u00020#0\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0012\u001a\u0004\b?\u0010&R!\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160A8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0012\u001a\u0004\bC\u0010DR!\u0010I\u001a\b\u0012\u0004\u0012\u00020F0\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0012\u001a\u0004\bH\u0010&¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/contract/MediaMultiAnchorLinkContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/interactivity/medialink/contract/c;", BuildConfig.FLAVOR, "newChannelId", BuildConfig.FLAVOR, "setChannelId", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "info", BuildConfig.FLAVOR, "clearMap", "setMultiChannelInfo", "Le92/l;", "parameters", "setLaunchParameters", "Lcom/bytedance/live/datacontext/j;", "Lx82/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", BuildConfig.FLAVOR, "commonService$delegate", "getCommonService", "commonService", "Lx82/d;", "enlargeService$delegate", "getEnlargeService", "enlargeService", "Lx82/e;", "layoutService$delegate", "getLayoutService", "layoutService", "Lcom/bytedance/live/datacontext/m;", BuildConfig.FLAVOR, "windowCount$delegate", "getWindowCount", "()Lcom/bytedance/live/datacontext/m;", "windowCount", "channelId$delegate", "getChannelId", "channelId", BuildConfig.FLAVOR, "linkerId$delegate", "getLinkerId", "linkerId", "inviteeList$delegate", "getInviteeList", "inviteeList", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/interactivity/medialink/contract/d;", "connectionContext$delegate", "getConnectionContext", "()Lcom/bytedance/live/datacontext/n;", "connectionContext", "rtcInfo$delegate", "getRtcInfo", "rtcInfo", "multiChannelInfo$delegate", "getMultiChannelInfo", "multiChannelInfo", "inviteType$delegate", "getInviteType", "inviteType", "Lcom/bytedance/live/datacontext/k;", "anchorLeave$delegate", "getAnchorLeave", "()Lcom/bytedance/live/datacontext/k;", "anchorLeave", "Ldy/a;", "unloadSource$delegate", "getUnloadSource", "unloadSource", "<init>", "()V", "Companion", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorLinkContext extends DataContext implements c {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p anchorLeave$delegate;
    private final p channelId$delegate;
    private final p commonService$delegate;
    private final p connectionContext$delegate;
    private final p enlargeService$delegate;
    private final p inviteType$delegate;
    private final p inviteeList$delegate;
    private final p layoutService$delegate;
    private final p linkerId$delegate;
    private final p multiChannelInfo$delegate;
    private final p rtcInfo$delegate;
    private final p service$delegate;
    private final p unloadSource$delegate;
    private final p windowCount$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final c getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(MediaMultiAnchorLinkContext.class);
            if ((r0 instanceof MediaMultiAnchorLinkContext) == true) goto L6;
            r0 = null;
        L6:
            return (MediaMultiAnchorLinkContext) r0;
        }

        public final long a() {
            c r0 = getContext();
            if (r0 == null) goto L9;
            m<? extends Long> r1 = r0.getChannelId();
            if (r1 == null) goto L9;
            Long r2 = (Long) r1.getValue();
            if (r2 == null) goto L9;
            return r2.longValue();
        L9:
            return 0;
        }

        public final String b() {
            c r0 = getContext();
            if (r0 == null) goto L7;
            m<? extends String> r1 = r0.getLinkerId();
            if (r1 == null) goto L7;
            return (String) r1.getValue();
        L7:
            return null;
        }

        public final MultiChannelInfo c() {
            c r0 = getContext();
            if (r0 == null) goto L7;
            n<? extends MultiChannelInfo> r1 = r0.getMultiChannelInfo();
            if (r1 == null) goto L7;
            return (MultiChannelInfo) r1.getValue();
        L7:
            return null;
        }
    }

    @JvmStatic
    public static final c getContext() {
        return Companion.getContext();
    }

    public k<Object> getAnchorLeave() {
        return (k) this.anchorLeave$delegate.a(this, $$delegatedProperties[12]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.c
    public m<Long> getChannelId() {
        return (m) this.channelId$delegate.a(this, $$delegatedProperties[5]);
    }

    public j<Object> getCommonService() {
        return (j) this.commonService$delegate.a(this, $$delegatedProperties[1]);
    }

    public n<d> getConnectionContext() {
        return (n) this.connectionContext$delegate.a(this, $$delegatedProperties[8]);
    }

    public j<x82.d> getEnlargeService() {
        return (j) this.enlargeService$delegate.a(this, $$delegatedProperties[2]);
    }

    public m<Integer> getInviteType() {
        return (m) this.inviteType$delegate.a(this, $$delegatedProperties[11]);
    }

    public final m<String> getInviteeList() {
        return (m) this.inviteeList$delegate.a(this, $$delegatedProperties[7]);
    }

    public j<x82.e> getLayoutService() {
        return (j) this.layoutService$delegate.a(this, $$delegatedProperties[3]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.c
    public m<String> getLinkerId() {
        return (m) this.linkerId$delegate.a(this, $$delegatedProperties[6]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.c
    public n<MultiChannelInfo> getMultiChannelInfo() {
        return (n) this.multiChannelInfo$delegate.a(this, $$delegatedProperties[10]);
    }

    public n<String> getRtcInfo() {
        return (n) this.rtcInfo$delegate.a(this, $$delegatedProperties[9]);
    }

    public j<x82.b> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public m<dy.a> getUnloadSource() {
        return (m) this.unloadSource$delegate.a(this, $$delegatedProperties[13]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.c
    public m<Integer> getWindowCount() {
        return (m) this.windowCount$delegate.a(this, $$delegatedProperties[4]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "commonService", "getCommonService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "enlargeService", "getEnlargeService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "layoutService", "getLayoutService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "windowCount", "getWindowCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "channelId", "getChannelId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "linkerId", "getLinkerId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "inviteeList", "getInviteeList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "connectionContext", "getConnectionContext()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "rtcInfo", "getRtcInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "multiChannelInfo", "getMultiChannelInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "inviteType", "getInviteType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "anchorLeave", "getAnchorLeave()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(MediaMultiAnchorLinkContext.class, "unloadSource", "getUnloadSource()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public MediaMultiAnchorLinkContext() {
        this.service$delegate = ConstantKt.c(this);
        this.commonService$delegate = ConstantKt.c(this);
        this.enlargeService$delegate = ConstantKt.c(this);
        this.layoutService$delegate = ConstantKt.c(this);
        this.windowCount$delegate = q.d(this, 0);
        this.channelId$delegate = q.d(this, 0L);
        this.linkerId$delegate = q.d(this, BuildConfig.FLAVOR);
        this.inviteeList$delegate = q.d(this, BuildConfig.FLAVOR);
        this.connectionContext$delegate = q.c(this);
        this.rtcInfo$delegate = q.c(this);
        this.multiChannelInfo$delegate = q.c(this);
        this.inviteType$delegate = q.d(this, 0);
        this.anchorLeave$delegate = com.bytedance.live.datacontext.e.a(this, MediaMultiAnchorLinkContext$anchorLeave$2.INSTANCE);
        this.unloadSource$delegate = q.d(this, dy.a.e.b);
    }

    public final void setChannelId(long r4) {
        ALogger.e("ttlive_anchor_link", "setChannelId " + ((Number) getChannelId().getValue()).longValue() + "->" + r4);
        getChannelId().setValue(Long.valueOf(r4));
    }

    public final void setLaunchParameters(l r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        getChannelId().setValue(Long.valueOf(r5.a));
        getLinkerId().setValue(r5.c);
        getInviteType().setValue(Integer.valueOf(r5.d));
        getInviteeList().setValue(r5.e);
        setMultiChannelInfo$default(this, r5.f, false, 2, null);
        getRtcInfo().setValue(r5.g);
        ALogger.e("MediaLinkTracer", "set launch parameter " + r5);
    }

    public final void setMultiChannelInfo(MultiChannelInfo r2, boolean r3) {
        if (r2 != null) goto L4;
        getMultiChannelInfo().setValue(r2);
        return;
    L4:
        if (getMultiChannelInfo().getValue() != null) goto L6;
        getMultiChannelInfo().setValue(r2);
        return;
    L6:
        if (r3 == false) goto L10;
        MultiChannelInfo r4 = (MultiChannelInfo) getMultiChannelInfo().getValue();
        if (r4 == null) goto L10;
        r4.setChannelMap(com.bytedance.revenue.platform.api.core.d.a(new Pair[0]));
    L10:
        MultiChannelInfo r5 = (MultiChannelInfo) getMultiChannelInfo().getValue();
        if (r5 == null) goto L27;
        MultiChannelInfo r0 = (MultiChannelInfo) getMultiChannelInfo().getValue();
        if (r0 == null) goto L22;
        Map r1 = r0.getChannelMap();
        if (r1 == null) goto L22;
        Map r6 = MapsKt.toMutableMap(r1);
        if (r6 == null) goto L22;
        Map r7 = r2.getChannelMap();
        if (r7 != null) goto L21;
        r7 = MapsKt.emptyMap();
    L21:
        r6.putAll(r7);
        Unit r8 = Unit.INSTANCE;
    L23:
        r5.setChannelMap(r6);
        return;
    L22:
        r6 = null;
        goto L23
    }

    public static /* synthetic */ void setMultiChannelInfo$default(MediaMultiAnchorLinkContext r0, MultiChannelInfo r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.setMultiChannelInfo(r1, r2);
    }
}
