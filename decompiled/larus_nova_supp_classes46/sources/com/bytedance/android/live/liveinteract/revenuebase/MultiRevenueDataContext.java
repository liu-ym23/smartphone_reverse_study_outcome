package com.bytedance.android.live.liveinteract.revenuebase;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u001f\u0010 R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenuebase/MultiRevenueDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/android/live/liveinteract/revenuebase/b;", "linkRoomFightService$delegate", "Lcom/bytedance/live/datacontext/p;", "getLinkRoomFightService", "()Lcom/bytedance/live/datacontext/i;", "linkRoomFightService", "Lcom/bytedance/android/live/liveinteract/revenuebase/d;", "teamFightService$delegate", "getTeamFightService", "teamFightService", "Lcom/bytedance/android/live/liveinteract/revenuebase/a;", "guestBattleService$delegate", "getGuestBattleService", "guestBattleService", "Lcom/bytedance/android/live/liveinteract/revenuebase/c;", "paidLinkMicService$delegate", "getPaidLinkMicService", "paidLinkMicService", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/a;", "playModeManager$delegate", "getPlayModeManager", "()Lcom/bytedance/live/datacontext/j;", "playModeManager", "Lof0/a;", "interactiveSongService$delegate", "getInteractiveSongService", "interactiveSongService", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiRevenueDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "multi_revenue_data_context";
    private final p guestBattleService$delegate;
    private final p interactiveSongService$delegate;
    private final p linkRoomFightService$delegate;
    private final p paidLinkMicService$delegate;
    private final p playModeManager$delegate;
    private final p teamFightService$delegate;

    public static final class a {
        public a() {
        }

        public static MultiRevenueDataContext e() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(MultiRevenueDataContext.TAG);
            if ((r0 instanceof MultiRevenueDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (MultiRevenueDataContext) r0;
        }

        public static com.bytedance.android.live.liveinteract.revenuebase.a a() {
            MultiRevenueDataContext r0 = e();
            if (r0 == null) goto L7;
            i r1 = MultiRevenueDataContext.access$getGuestBattleService$p(r0);
            if (r1 == null) goto L7;
            return (com.bytedance.android.live.liveinteract.revenuebase.a) r1.getValue();
        L7:
            return null;
        }

        public static b b() {
            MultiRevenueDataContext r0 = e();
            if (r0 == null) goto L7;
            i r1 = MultiRevenueDataContext.access$getLinkRoomFightService$p(r0);
            if (r1 == null) goto L7;
            return (b) r1.getValue();
        L7:
            return null;
        }

        public static c c() {
            MultiRevenueDataContext r0 = e();
            if (r0 == null) goto L7;
            i r1 = MultiRevenueDataContext.access$getPaidLinkMicService$p(r0);
            if (r1 == null) goto L7;
            return (c) r1.getValue();
        L7:
            return null;
        }

        public static com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a d() {
            MultiRevenueDataContext r0 = e();
            if (r0 == null) goto L7;
            j<com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a> r1 = r0.getPlayModeManager();
            if (r1 == null) goto L7;
            return (com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a) r1.getValue();
        L7:
            return null;
        }

        public static d f() {
            MultiRevenueDataContext r0 = e();
            if (r0 == null) goto L7;
            i r1 = MultiRevenueDataContext.access$getTeamFightService$p(r0);
            if (r1 == null) goto L7;
            return (d) r1.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiRevenueDataContext.class, "linkRoomFightService", "getLinkRoomFightService()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiRevenueDataContext.class, "teamFightService", "getTeamFightService()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiRevenueDataContext.class, "guestBattleService", "getGuestBattleService()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiRevenueDataContext.class, "paidLinkMicService", "getPaidLinkMicService()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiRevenueDataContext.class, "playModeManager", "getPlayModeManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiRevenueDataContext.class, "interactiveSongService", "getInteractiveSongService()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0))};
        Companion = new a();
    }

    private final i<com.bytedance.android.live.liveinteract.revenuebase.a> getGuestBattleService() {
        return (i) this.guestBattleService$delegate.a(this, $$delegatedProperties[2]);
    }

    private final i<of0.a> getInteractiveSongService() {
        return (i) this.interactiveSongService$delegate.a(this, $$delegatedProperties[5]);
    }

    private final i<b> getLinkRoomFightService() {
        return (i) this.linkRoomFightService$delegate.a(this, $$delegatedProperties[0]);
    }

    private final i<c> getPaidLinkMicService() {
        return (i) this.paidLinkMicService$delegate.a(this, $$delegatedProperties[3]);
    }

    private final i<d> getTeamFightService() {
        return (i) this.teamFightService$delegate.a(this, $$delegatedProperties[1]);
    }

    public final j<com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a> getPlayModeManager() {
        return (j) this.playModeManager$delegate.a(this, $$delegatedProperties[4]);
    }

    public MultiRevenueDataContext() {
        this.linkRoomFightService$delegate = ConstantKt.d(this, new xi0.c());
        this.teamFightService$delegate = ConstantKt.d(this, new com.bytedance.android.live.liveinteract.revenue.fight.d());
        this.guestBattleService$delegate = ConstantKt.d(this, new com.bytedance.android.live.liveinteract.revenue.battle.p());
        this.paidLinkMicService$delegate = ConstantKt.d(this, new cj0.j());
        this.playModeManager$delegate = ConstantKt.c(this);
        this.interactiveSongService$delegate = ConstantKt.d(this, new com.bytedance.android.live.liveinteract.interactivesong.impl.a());
    }

    public static final /* synthetic */ i access$getGuestBattleService$p(MultiRevenueDataContext r0) {
        return r0.getGuestBattleService();
    }

    public static final /* synthetic */ i access$getInteractiveSongService$p(MultiRevenueDataContext r0) {
        return r0.getInteractiveSongService();
    }

    public static final /* synthetic */ i access$getLinkRoomFightService$p(MultiRevenueDataContext r0) {
        return r0.getLinkRoomFightService();
    }

    public static final /* synthetic */ i access$getPaidLinkMicService$p(MultiRevenueDataContext r0) {
        return r0.getPaidLinkMicService();
    }

    public static final /* synthetic */ i access$getTeamFightService$p(MultiRevenueDataContext r0) {
        return r0.getTeamFightService();
    }
}
