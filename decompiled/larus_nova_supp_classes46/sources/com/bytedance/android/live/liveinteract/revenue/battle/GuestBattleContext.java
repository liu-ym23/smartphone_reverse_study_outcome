package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.message.model.f2;
import com.bytedance.android.livesdk.message.model.f9;
import com.bytedance.common.utility.Lists;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001GB\u0007¢\u0006\u0004\bD\u0010EJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0006\u0010\n\u001a\u00020\u0007R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0015R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u001fR!\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u001fR!\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000e\u001a\u0004\b'\u0010\u001fR)\u0010,\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u00070\u00070\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0015R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010\u0015R!\u00103\u001a\b\u0012\u0004\u0012\u0002000\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0015R\u0014\u00104\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00105R\u0014\u00107\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u0010:\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010;\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00105R\u0014\u0010=\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u00109R\u0016\u0010@\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010C\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/battle/GuestBattleContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/revenue/battle/b0;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c0;", "getDefaultSelectScoreInfo", "", "supportGuestBattle", "", "getSelectScoreType", "getCurrentScoreType", "getCurrentStage", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/revenue/battle/d0;", "widget$delegate", "Lcom/bytedance/live/datacontext/p;", "getWidget", "()Lcom/bytedance/live/datacontext/j;", "widget", "Lcom/bytedance/live/datacontext/m;", "battleState$delegate", "getBattleState", "()Lcom/bytedance/live/datacontext/m;", "battleState", "", "battleStartTime$delegate", "getBattleStartTime", "battleStartTime", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/a0;", "battleInfo$delegate", "getBattleInfo", "()Lcom/bytedance/live/datacontext/n;", "battleInfo", "Lcom/bytedance/android/livesdk/message/model/f9;", "chestGameStatus$delegate", "getChestGameStatus", "chestGameStatus", "Lcom/bytedance/android/livesdk/chatroom/model/interact/y;", "serverConfig$delegate", "getServerConfig", "serverConfig", "kotlin.jvm.PlatformType", "configLoserNum$delegate", "getConfigLoserNum", "configLoserNum", "onlineLoserNum$delegate", "getOnlineLoserNum", "onlineLoserNum", "", "dressId$delegate", "getDressId", "dressId", "isGameOnGoing", "()Z", "isGameShowing", "isChestOn", "getBottomUiHeight", "()I", "bottomUiHeight", "isChestUiShown", "getCurrentState", "currentState", "getCurrentBattleInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/a0;", "currentBattleInfo", "getSelectScoreInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/c0;", "selectScoreInfo", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestBattleContext extends DataContext implements b0 {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final com.bytedance.live.datacontext.p battleInfo$delegate;
    private final com.bytedance.live.datacontext.p battleStartTime$delegate;
    private final com.bytedance.live.datacontext.p battleState$delegate;
    private final com.bytedance.live.datacontext.p chestGameStatus$delegate;
    private final com.bytedance.live.datacontext.p configLoserNum$delegate;
    private final com.bytedance.live.datacontext.p dressId$delegate;
    private final com.bytedance.live.datacontext.p onlineLoserNum$delegate;
    private final com.bytedance.live.datacontext.p serverConfig$delegate;
    private final com.bytedance.live.datacontext.p widget$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final GuestBattleContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(b0.class);
            if ((r0 instanceof GuestBattleContext) == true) goto L6;
            r0 = null;
        L6:
            return (GuestBattleContext) r0;
        }

        @JvmStatic
        public final com.bytedance.android.livesdk.chatroom.model.interact.a0 a() {
            GuestBattleContext r0 = getContext();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getCurrentBattleInfo();
        }

        public final int b() {
            GuestBattleContext r0 = getContext();
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getCurrentStage();
        }

        @JvmStatic
        public final d0 c() {
            GuestBattleContext r0 = getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.j<d0> r1 = r0.m283getWidget();
            if (r1 == null) goto L7;
            return (d0) r1.getValue();
        L7:
            return null;
        }

        @JvmStatic
        public final boolean d() {
            GuestBattleContext r0 = getContext();
            if (r0 == null) goto L8;
            com.bytedance.live.datacontext.m<Integer> r1 = r0.getBattleState();
            if (r1 == null) goto L8;
            if (((Number) r1.getValue()).intValue() != 1) goto L8;
            return true;
        L8:
            GuestBattleContext r2 = getContext();
            if (r2 == null) goto L15;
            com.bytedance.live.datacontext.m<Integer> r3 = r2.getBattleState();
            if (r3 == null) goto L15;
            if (((Number) r3.getValue()).intValue() != 4) goto L15;
            return true;
        L15:
            return false;
        }

        public final boolean e() {
            GuestBattleContext r0 = getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.m<Integer> r1 = r0.getBattleState();
            if (r1 == null) goto L7;
            Integer r2 = (Integer) r1.getValue();
        L9:
            if (r2 != null) goto L12;
        L13:
            if (r2 != null) goto L16;
        L17:
            if (r2 != null) goto L20;
        L22:
            return false;
        L20:
            if (r2.intValue() != 2) goto L22;
            return true;
        L16:
            if (r2.intValue() != 4) goto L17;
            return true;
        L12:
            if (r2.intValue() != 1) goto L13;
            return true;
        L7:
            r2 = null;
            goto L9
        }
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.chatroom.model.interact.a0 currentBattleInfo() {
        return Companion.a();
    }

    @JvmStatic
    public static final GuestBattleContext getContext() {
        return Companion.getContext();
    }

    @JvmStatic
    public static final d0 getWidget() {
        return Companion.c();
    }

    @JvmStatic
    public static final boolean isGameOn() {
        return Companion.d();
    }

    public final com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.chatroom.model.interact.a0> getBattleInfo() {
        return (com.bytedance.live.datacontext.n) this.battleInfo$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.m<Long> getBattleStartTime() {
        return (com.bytedance.live.datacontext.m) this.battleStartTime$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getBattleState() {
        return (com.bytedance.live.datacontext.m) this.battleState$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.n<f9> getChestGameStatus() {
        return (com.bytedance.live.datacontext.n) this.chestGameStatus$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getConfigLoserNum() {
        return (com.bytedance.live.datacontext.m) this.configLoserNum$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.m<String> getDressId() {
        return (com.bytedance.live.datacontext.m) this.dressId$delegate.a(this, $$delegatedProperties[8]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getOnlineLoserNum() {
        return (com.bytedance.live.datacontext.m) this.onlineLoserNum$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.chatroom.model.interact.y> getServerConfig() {
        return (com.bytedance.live.datacontext.n) this.serverConfig$delegate.a(this, $$delegatedProperties[5]);
    }

    /* JADX INFO: renamed from: getWidget, reason: collision with other method in class */
    public final com.bytedance.live.datacontext.j<d0> m283getWidget() {
        return (com.bytedance.live.datacontext.j) this.widget$delegate.a(this, $$delegatedProperties[0]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GuestBattleContext.class, "widget", "getWidget()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GuestBattleContext.class, "battleState", "getBattleState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GuestBattleContext.class, "battleStartTime", "getBattleStartTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GuestBattleContext.class, "battleInfo", "getBattleInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GuestBattleContext.class, "chestGameStatus", "getChestGameStatus()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GuestBattleContext.class, "serverConfig", "getServerConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GuestBattleContext.class, "configLoserNum", "getConfigLoserNum()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GuestBattleContext.class, "onlineLoserNum", "getOnlineLoserNum()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GuestBattleContext.class, "dressId", "getDressId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    private final com.bytedance.android.livesdk.chatroom.model.interact.c0 getDefaultSelectScoreInfo() {
        Integer r0 = (Integer) b6.L.getValue();
        a r1 = Companion;
        GuestBattleContext r2 = r1.getContext();
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.chatroom.model.interact.y> r3 = r2.getServerConfig();
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.model.interact.y r4 = (com.bytedance.android.livesdk.chatroom.model.interact.y) r3.getValue();
        if (r4 == null) goto L9;
        Integer r5 = Integer.valueOf(r4.getRecommendScoreType());
    L10:
        GuestBattleContext r6 = r1.getContext();
        if (r6 == null) goto L17;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.chatroom.model.interact.y> r7 = r6.getServerConfig();
        if (r7 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.model.interact.y r8 = (com.bytedance.android.livesdk.chatroom.model.interact.y) r7.getValue();
        if (r8 == null) goto L17;
        List r9 = r8.getScoreInfoList();
    L18:
        if (r9 == null) goto L32;
        Iterator r10 = r9.iterator();
    L21:
        if (r10.hasNext() == false) goto L32;
        com.bytedance.android.livesdk.chatroom.model.interact.c0 r11 = (com.bytedance.android.livesdk.chatroom.model.interact.c0) r10.next();
        if (r11 == null) goto L25;
        Integer r12 = Integer.valueOf(r11.getScoreType());
    L26:
        int r13 = r12.intValue();
        if (r0 == null) goto L21;
        if (r13 != r0.intValue()) goto L21;
        return r11;
    L25:
        r12 = null;
    L32:
        if (r9 == null) goto L47;
        Iterator r14 = r9.iterator();
    L35:
        if (r14.hasNext() == false) goto L47;
        com.bytedance.android.livesdk.chatroom.model.interact.c0 r15 = (com.bytedance.android.livesdk.chatroom.model.interact.c0) r14.next();
        if (r15 == null) goto L39;
        Integer r16 = Integer.valueOf(r15.getScoreType());
    L40:
        int r17 = r16.intValue();
        if (r5 == null) goto L35;
        if (r17 != r5.intValue()) goto L35;
        return r15;
    L39:
        r16 = null;
    L47:
        if (Lists.isEmpty(r9) == true) goto L63;
        if (r9 != null) goto L50;
        return null;
    L50:
        return (com.bytedance.android.livesdk.chatroom.model.interact.c0) ListProtector.get(r9, 0);
    L63:
        return null;
    L17:
        r9 = null;
    L9:
        r5 = null;
        goto L10
    }

    @JvmStatic
    public static final ne0.c getStore() {
        d0 r0 = Companion.c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getStore();
    }

    @JvmStatic
    public static final boolean isGamePausing() {
        GuestBattleContext r0 = Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Integer> r1 = r0.getBattleState();
        if (r1 == null) goto L9;
        if (((Number) r1.getValue()).intValue() != 4) goto L9;
        return true;
    L9:
        return false;
    }

    public int getBottomUiHeight() {
        Companion.getClass();
        return com.bytedance.android.live.liveinteract.utils.g.a;
    }

    public boolean isChestOn() {
        GuestBattleContext r0 = Companion.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.chatroom.model.interact.a0> r1 = r0.getBattleInfo();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r2 = (com.bytedance.android.livesdk.chatroom.model.interact.a0) r1.getValue();
        if (r2 == null) goto L11;
        if (r2.getChestOn() != true) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.b0
    public boolean isChestUiShown() {
        a r0 = Companion;
        r0.getClass();
        int r1 = com.bytedance.android.live.liveinteract.utils.g.a;
        GuestBattleContext r2 = r0.getContext();
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.n<f9> r3 = r2.getChestGameStatus();
        if (r3 == null) goto L7;
        f9 r4 = (f9) r3.getValue();
    L8:
        if (r4 == null) goto L17;
        int r5 = r4.a();
        int r6 = f2.a;
        if (r5 != 20) goto L13;
    L18:
        return true;
    L13:
        if (r4.a() == 30) goto L18;
        if (r4.a() == 40) goto L18;
    L17:
        return false;
    L7:
        r4 = null;
        goto L8
    }

    public boolean isGameOnGoing() {
        return Companion.d();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.b0
    public boolean isGameShowing() {
        return Companion.e();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.b0
    public boolean supportGuestBattle() {
        ReadOnlyProperty r0 = vm2.d.r4;
        KProperty[] r1 = vm2.d.a;
        if (((Boolean) r0.getValue(null, r1[275(0x113, float:3.85E-43)])).booleanValue() == true) goto L5;
        return false;
    L5:
        Integer[] r2 = (Integer[]) vm2.d.o4.getValue(null, r1[272(0x110, float:3.81E-43)]);
        if (r2 != null) goto L8;
        return false;
    L8:
        return ArraysKt.contains(r2, Integer.valueOf(je0.d.f()));
    }

    public GuestBattleContext() {
        this.widget$delegate = ConstantKt.c(this);
        this.battleState$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.battleStartTime$delegate = com.bytedance.live.datacontext.q.d(this, 0L);
        this.battleInfo$delegate = com.bytedance.live.datacontext.q.c(this);
        this.chestGameStatus$delegate = com.bytedance.live.datacontext.q.c(this);
        this.serverConfig$delegate = com.bytedance.live.datacontext.q.c(this);
        com.bytedance.android.livesdk.sharedpref.e r1 = b6.i0;
        Integer r2 = (Integer) r1.getValue();
        if (r2 != null) goto L6;
    L8:
        Integer r3 = (Integer) r1.getValue();
    L9:
        this.configLoserNum$delegate = com.bytedance.live.datacontext.q.d(this, r3);
        this.onlineLoserNum$delegate = com.bytedance.live.datacontext.q.d(this, 1);
        this.dressId$delegate = com.bytedance.live.datacontext.q.d(this, "");
        return;
    L6:
        if (r2.intValue() != 0) goto L8;
        r3 = 1;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.b0
    public com.bytedance.android.livesdk.chatroom.model.interact.a0 getCurrentBattleInfo() {
        return (com.bytedance.android.livesdk.chatroom.model.interact.a0) getBattleInfo().getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.battle.b0
    public int getCurrentScoreType() {
        if (isGameShowing() == false) goto L8;
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r0 = getCurrentBattleInfo();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getScoreType();
    L8:
        return 0;
    }

    public final int getCurrentStage() {
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r0 = (com.bytedance.android.livesdk.chatroom.model.interact.a0) getBattleInfo().getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getBattleStage();
    }

    public int getCurrentState() {
        return ((Number) getBattleState().getValue()).intValue();
    }

    public com.bytedance.android.livesdk.chatroom.model.interact.c0 getSelectScoreInfo() {
        return getDefaultSelectScoreInfo();
    }

    public int getSelectScoreType() {
        com.bytedance.android.livesdk.chatroom.model.interact.c0 r0 = getDefaultSelectScoreInfo();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getScoreType();
    }
}
