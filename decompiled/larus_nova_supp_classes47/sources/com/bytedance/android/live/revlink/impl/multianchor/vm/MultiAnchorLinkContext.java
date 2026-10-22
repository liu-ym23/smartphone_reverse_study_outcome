package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenuelink.i;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0081\u0001B\u001b\u0012\b\u0010u\u001a\u0004\u0018\u00010t\u0012\b\u0010x\u001a\u0004\u0018\u00010w¢\u0006\u0004\b~\u0010\u007fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR!\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR!\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001eR!\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010\u001eR!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010/R!\u00103\u001a\b\u0012\u0004\u0012\u00020\b0,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010/R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001c\u001a\u0004\b5\u0010/R!\u00109\u001a\b\u0012\u0004\u0012\u0002060,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u001c\u001a\u0004\b8\u0010/R\u001b\u0010?\u001a\u00020:8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R!\u0010B\u001a\b\u0012\u0004\u0012\u0002060,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u001c\u001a\u0004\bA\u0010/R!\u0010E\u001a\b\u0012\u0004\u0012\u0002060,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001c\u001a\u0004\bD\u0010/R!\u0010K\u001a\b\u0012\u0004\u0012\u00020G0F8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u001c\u001a\u0004\bI\u0010JR!\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000b0F8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u001c\u001a\u0004\bM\u0010JR!\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00130F8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u001c\u001a\u0004\bP\u0010JR!\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00040,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u001c\u001a\u0004\bS\u0010/R!\u0010Z\u001a\b\u0012\u0004\u0012\u00020V0U8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u001c\u001a\u0004\bX\u0010YR!\u0010^\u001a\b\u0012\u0004\u0012\u00020[0\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u001c\u001a\u0004\b]\u0010\u001eR!\u0010b\u001a\b\u0012\u0004\u0012\u00020_0,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u001c\u001a\u0004\ba\u0010/R!\u0010f\u001a\b\u0012\u0004\u0012\u00020c0,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\u001c\u001a\u0004\be\u0010/R!\u0010i\u001a\b\u0012\u0004\u0012\u0002060,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bg\u0010\u001c\u001a\u0004\bh\u0010/R!\u0010m\u001a\b\u0012\u0004\u0012\u00020j0F8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u001c\u001a\u0004\bl\u0010JR!\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00040U8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\u001c\u001a\u0004\bo\u0010YR!\u0010s\u001a\b\u0012\u0004\u0012\u00020\r0,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\u001c\u001a\u0004\br\u0010/R\u0016\u0010u\u001a\u0004\u0018\u00010t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010x\u001a\u0004\u0018\u00010w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010}\u001a\u0004\u0018\u00010z8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|¨\u0006\u0082\u0001"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/vm/MultiAnchorLinkContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/multianchor/vm/b;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/context/e;", "", "matchType", "", "initConnectionSubType", "", "newChannelId", "setAudienceChannelId", "Lcom/bytedance/android/livesdk/link/model/b7;", "info", "", "clearMap", "setMultiChannelInfo", "Lcom/bytedance/android/live/revlink/impl/control/launchcontext/a;", "launchContext", "setLaunchContext", "Lcom/bytedance/android/livesdk/link/model/p0;", "battleAttachedInfo", "updateLaunchBattleAttachedInfo", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/u;", "parameters", "setAnchorLaunchParameters", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Ln21/a;", "commonService$delegate", "getCommonService", "commonService", "", "linkScoreService$delegate", "getLinkScoreService", "linkScoreService", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/h;", "layoutService$delegate", "getLayoutService", "layoutService", "Lcom/bytedance/live/datacontext/m;", "windowCount$delegate", "getWindowCount", "()Lcom/bytedance/live/datacontext/m;", "windowCount", "channelId$delegate", "getChannelId", "channelId", "matchType$delegate", "getMatchType", "", "linkerId$delegate", "getLinkerId", "linkerId", "Lp21/c;", "multiLinkLogger$delegate", "Lkotlin/Lazy;", "getMultiLinkLogger", "()Lp21/c;", "multiLinkLogger", "inviteeList$delegate", "getInviteeList", "inviteeList", "connectionSubType$delegate", "getConnectionSubType", "connectionSubType", "Lcom/bytedance/live/datacontext/n;", "Lf21/a;", "connectionContext$delegate", "getConnectionContext", "()Lcom/bytedance/live/datacontext/n;", "connectionContext", "multiChannelInfo$delegate", "getMultiChannelInfo", "multiChannelInfo", "launchBattleAttachInfo$delegate", "getLaunchBattleAttachInfo", "launchBattleAttachInfo", "inviteType$delegate", "getInviteType", "inviteType", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/live/revlink/impl/multianchor/vm/a;", "anchorLeave$delegate", "getAnchorLeave", "()Lcom/bytedance/live/datacontext/k;", "anchorLeave", "Lcom/bytedance/android/live/revlink/impl/control/launchcontext/b;", "audienceLaunchContext$delegate", "getAudienceLaunchContext", "audienceLaunchContext", "Lcom/bytedance/android/live/revenuelink/i;", "unloadSource$delegate", "getUnloadSource", "unloadSource", "Lcom/bytedance/android/live/revenuelink/h;", "audienceUnloadSource$delegate", "getAudienceUnloadSource", "audienceUnloadSource", "connectionSource$delegate", "getConnectionSource", "connectionSource", "Lf31/i;", "windowStatus$delegate", "getWindowStatus", "windowStatus", "refreshWidgetEvent$delegate", "getRefreshWidgetEvent", "refreshWidgetEvent", "changeScreenEvent$delegate", "getChangeScreenEvent", "changeScreenEvent", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/w;", "getMultiLinkUtil", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/w;", "multiLinkUtil", "<init>", "(Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;)V", "Companion", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorLinkContext extends DataContext implements b, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String ShareTAG = "MultiAnchorLinkContext";
    public static final String TAG = "ttlive_anchor_link_data";
    private final p anchorLeave$delegate;
    private final p audienceLaunchContext$delegate;
    private final p audienceUnloadSource$delegate;
    private final p changeScreenEvent$delegate;
    private final p channelId$delegate;
    private final p commonService$delegate;
    private final p connectionContext$delegate;
    private final p connectionSource$delegate;
    private final p connectionSubType$delegate;
    private final p inviteType$delegate;
    private final p inviteeList$delegate;
    private final p launchBattleAttachInfo$delegate;
    private final p layoutService$delegate;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final p linkScoreService$delegate;
    private final p linkerId$delegate;
    private final p matchType$delegate;
    private final p multiChannelInfo$delegate;
    private final Lazy multiLinkLogger$delegate;
    private final p refreshWidgetEvent$delegate;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final p service$delegate;
    private final p unloadSource$delegate;
    private final p windowCount$delegate;
    private final p windowStatus$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "commonService", "getCommonService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "linkScoreService", "getLinkScoreService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "layoutService", "getLayoutService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "windowCount", "getWindowCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "channelId", "getChannelId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "matchType", "getMatchType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "linkerId", "getLinkerId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "inviteeList", "getInviteeList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "connectionSubType", "getConnectionSubType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "connectionContext", "getConnectionContext()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "multiChannelInfo", "getMultiChannelInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "launchBattleAttachInfo", "getLaunchBattleAttachInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "inviteType", "getInviteType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "anchorLeave", "getAnchorLeave()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "audienceLaunchContext", "getAudienceLaunchContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "unloadSource", "getUnloadSource()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "audienceUnloadSource", "getAudienceUnloadSource()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "connectionSource", "getConnectionSource()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "windowStatus", "getWindowStatus()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "refreshWidgetEvent", "getRefreshWidgetEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorLinkContext.class, "changeScreenEvent", "getChangeScreenEvent()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public k<com.bytedance.android.live.revlink.impl.multianchor.vm.a> getAnchorLeave() {
        return (k) this.anchorLeave$delegate.a(this, $$delegatedProperties[14]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public j<com.bytedance.android.live.revlink.impl.control.launchcontext.b> getAudienceLaunchContext() {
        return (j) this.audienceLaunchContext$delegate.a(this, $$delegatedProperties[15]);
    }

    public m<com.bytedance.android.live.revenuelink.h> getAudienceUnloadSource() {
        return (m) this.audienceUnloadSource$delegate.a(this, $$delegatedProperties[17]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e
    public m<Boolean> getChangeScreenEvent() {
        return (m) this.changeScreenEvent$delegate.a(this, $$delegatedProperties[21]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e
    public m<Long> getChannelId() {
        return (m) this.channelId$delegate.a(this, $$delegatedProperties[5]);
    }

    public j<n21.a> getCommonService() {
        return (j) this.commonService$delegate.a(this, $$delegatedProperties[1]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public n<f21.a> getConnectionContext() {
        return (n) this.connectionContext$delegate.a(this, $$delegatedProperties[10]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public m<String> getConnectionSource() {
        return (m) this.connectionSource$delegate.a(this, $$delegatedProperties[18]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public m<String> getConnectionSubType() {
        return (m) this.connectionSubType$delegate.a(this, $$delegatedProperties[9]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public m<Integer> getInviteType() {
        return (m) this.inviteType$delegate.a(this, $$delegatedProperties[13]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public m<String> getInviteeList() {
        return (m) this.inviteeList$delegate.a(this, $$delegatedProperties[8]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public n<p0> getLaunchBattleAttachInfo() {
        return (n) this.launchBattleAttachInfo$delegate.a(this, $$delegatedProperties[12]);
    }

    public j<com.bytedance.android.live.revlink.impl.multianchor.ui.h> getLayoutService() {
        return (j) this.layoutService$delegate.a(this, $$delegatedProperties[3]);
    }

    public j<Object> getLinkScoreService() {
        return (j) this.linkScoreService$delegate.a(this, $$delegatedProperties[2]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public m<String> getLinkerId() {
        return (m) this.linkerId$delegate.a(this, $$delegatedProperties[7]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public m<Integer> getMatchType() {
        return (m) this.matchType$delegate.a(this, $$delegatedProperties[6]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public n<b7> getMultiChannelInfo() {
        return (n) this.multiChannelInfo$delegate.a(this, $$delegatedProperties[11]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public p21.c getMultiLinkLogger() {
        return (p21.c) this.multiLinkLogger$delegate.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e
    public k<Integer> getRefreshWidgetEvent() {
        return (k) this.refreshWidgetEvent$delegate.a(this, $$delegatedProperties[20]);
    }

    public j<com.bytedance.android.live.revlink.impl.multianchor.service.b> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.vm.b
    public m<i> getUnloadSource() {
        return (m) this.unloadSource$delegate.a(this, $$delegatedProperties[16]);
    }

    public m<Integer> getWindowCount() {
        return (m) this.windowCount$delegate.a(this, $$delegatedProperties[4]);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.e
    public n<f31.i> getWindowStatus() {
        return (n) this.windowStatus$delegate.a(this, $$delegatedProperties[19]);
    }

    private final w getMultiLinkUtil() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkUtil();
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.global.c access$getLinkFakeGlobalService$p(MultiAnchorLinkContext r0) {
        return r0.linkFakeGlobalService;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.revenue.service.room.c access$getRoomService$p(MultiAnchorLinkContext r0) {
        return r0.roomService;
    }

    private final void initConnectionSubType(int r5) {
        m<String> r0 = getConnectionSubType();
        if (r5 != 4) goto L5;
        String r1 = "random_nlink";
    L25:
        r0.setValue(r1);
        return;
    L5:
        if (r5 != 6) goto L7;
        r1 = "random_npk";
        goto L25
    L7:
        if (r5 == 7) goto L22;
        f21.a r6 = (f21.a) getConnectionContext().getValue();
        r1 = "";
        if (r6 == null) goto L25;
        if (r6.a() == false) goto L21;
        w r7 = getMultiLinkUtil();
        if (r7 == null) goto L18;
        i11.b r8 = r7.a();
        if (r8 == null) goto L18;
        List<com.bytedance.android.livesdk.link.model.p> r9 = r8.d();
        if (r9 == null) goto L18;
    L20:
        if (r9.size() <= 2) goto L25;
    L18:
        r9 = CollectionsKt.emptyList();
    L21:
        r1 = "manual_nlink";
        goto L25
    L22:
        r1 = "random_individual";
        goto L25
    }

    public final void setAnchorLaunchParameters(u r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        getChannelId().setValue(Long.valueOf(r5.a));
        getMatchType().setValue(Integer.valueOf(r5.b));
        getLinkerId().setValue(r5.c);
        getInviteType().setValue(Integer.valueOf(r5.d));
        getInviteeList().setValue(r5.e);
        setMultiChannelInfo$default(this, r5.f, false, 2, null);
        initConnectionSubType(r5.b);
        jy0.b.c("ttlive_anchor_link", "set launch parameter " + r5, null, 4);
    }

    public final void setAudienceChannelId(long r5) {
        jy0.b.c("ttlive_anchor_link", "setAudienceChannelId " + ((Number) getChannelId().getValue()).longValue() + "->" + r5, null, 4);
        getChannelId().setValue(Long.valueOf(r5));
    }

    public final void setLaunchContext(com.bytedance.android.live.revlink.impl.control.launchcontext.a r2) {
        n<p0> r0 = getLaunchBattleAttachInfo();
        if (r2 == null) goto L5;
        p0 r3 = r2.d;
    L6:
        r0.setValue(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void updateLaunchBattleAttachedInfo(p0 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        getLaunchBattleAttachInfo().setValue(r2);
    }

    public MultiAnchorLinkContext(com.bytedance.android.livesdk.revenue.service.room.c r3, com.bytedance.android.live.revlink.impl.global.c r4) {
        this.roomService = r3;
        this.linkFakeGlobalService = r4;
        this.service$delegate = ConstantKt.c(this);
        this.commonService$delegate = ConstantKt.c(this);
        this.linkScoreService$delegate = ConstantKt.c(this);
        this.layoutService$delegate = ConstantKt.c(this);
        this.windowCount$delegate = q.d(this, 0);
        this.channelId$delegate = q.d(this, 0L);
        this.matchType$delegate = q.d(this, 0);
        this.linkerId$delegate = q.d(this, "");
        this.multiLinkLogger$delegate = LazyKt.lazy(new MultiAnchorLinkContext$multiLinkLogger$2(this));
        this.inviteeList$delegate = q.d(this, "");
        this.connectionSubType$delegate = q.d(this, "");
        this.connectionContext$delegate = q.c(this);
        this.multiChannelInfo$delegate = q.c(this);
        this.launchBattleAttachInfo$delegate = q.b(this, MultiAnchorLinkContext$launchBattleAttachInfo$2.INSTANCE);
        this.inviteType$delegate = q.d(this, 0);
        this.anchorLeave$delegate = com.bytedance.live.datacontext.e.a(this, MultiAnchorLinkContext$anchorLeave$2.INSTANCE);
        this.audienceLaunchContext$delegate = ConstantKt.c(this);
        this.unloadSource$delegate = q.d(this, i.f.b);
        this.audienceUnloadSource$delegate = q.d(this, com.bytedance.android.live.revenuelink.h.b.b);
        this.connectionSource$delegate = q.d(this, DataType.Normal);
        this.windowStatus$delegate = q.b(this, MultiAnchorLinkContext$windowStatus$2.INSTANCE);
        this.refreshWidgetEvent$delegate = com.bytedance.live.datacontext.e.a(this, MultiAnchorLinkContext$refreshWidgetEvent$2.INSTANCE);
        this.changeScreenEvent$delegate = q.a(this, Boolean.TRUE, MultiAnchorLinkContext$changeScreenEvent$2.INSTANCE);
    }

    public final void setMultiChannelInfo(b7 r5, boolean r6) {
        y41.b r0 = y41.b.d;
        r0.getClass();
        if (((Boolean) y41.b.b.getValue(r0, y41.b.a[0])).booleanValue() == false) goto L30;
        if (r5 == null) goto L30;
        if (r5.getChannelMap() == null) goto L30;
        if (getMultiChannelInfo().getValue() != null) goto L10;
        getMultiChannelInfo().setValue(r5);
        return;
    L10:
        if (r6 == false) goto L15;
        b7 r7 = (b7) getMultiChannelInfo().getValue();
        if (r7 == null) goto L15;
        r7.setChannelMap(new LinkedHashMap());
    L15:
        if (r5.getChannelMap() == null) goto L33;
        b7 r8 = (b7) getMultiChannelInfo().getValue();
        if (r8 == null) goto L34;
        b7 r1 = (b7) getMultiChannelInfo().getValue();
        if (r1 == null) goto L28;
        Map r2 = r1.getChannelMap();
        if (r2 == null) goto L28;
        Map r3 = MapsKt.toMutableMap(r2);
        if (r3 == null) goto L28;
        Map r9 = r5.getChannelMap();
        if (r9 != null) goto L27;
        r9 = MapsKt.emptyMap();
    L27:
        r3.putAll(r9);
        Unit r10 = Unit.INSTANCE;
    L29:
        r8.setChannelMap(r3);
        return;
    L28:
        r3 = MapsKt.emptyMap();
        goto L29
    L34:
        return;
    L33:
        return;
    L30:
        getMultiChannelInfo().setValue(r5);
    }

    public static /* synthetic */ void setMultiChannelInfo$default(MultiAnchorLinkContext r0, b7 r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.setMultiChannelInfo(r1, r2);
    }
}
