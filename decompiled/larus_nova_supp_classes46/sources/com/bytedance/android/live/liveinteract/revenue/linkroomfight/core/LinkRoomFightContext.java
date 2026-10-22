package com.bytedance.android.live.liveinteract.revenue.linkroomfight.core;

import com.bytedance.android.live.base.model.data.i;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.chatroom.model.InviteSource;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import ti6.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001HB\u0007¢\u0006\u0004\bE\u0010FR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u0014R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u001eR3\u0010'\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!0 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010&R!\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b*\u0010\u0014R!\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010\u0014R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R#\u00109\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u000208078\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0005\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR!\u0010A\u001a\b\u0012\u0004\u0012\u00020(0\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\f\u001a\u0004\b@\u0010\u0014R\u0013\u0010D\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006I"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/core/LinkRoomFightContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/core/a;", "", "isDynamic", "Z", "()Z", "setDynamic", "(Z)V", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/core/b;", "widget$delegate", "Lcom/bytedance/live/datacontext/p;", "getWidget", "()Lcom/bytedance/live/datacontext/j;", "widget", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "fightInfo$delegate", "getFightInfo", "()Lcom/bytedance/live/datacontext/m;", "fightInfo", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/core/c$b;", "fightState$delegate", "getFightState", "fightState", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/base/model/data/i;", "linkRoomUpdateContent$delegate", "getLinkRoomUpdateContent", "()Lcom/bytedance/live/datacontext/n;", "linkRoomUpdateContent", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/core/c$a;", "", "stateChangeTransition$delegate", "getStateChangeTransition", "()Lcom/bytedance/live/datacontext/k;", "stateChangeTransition", "", "requestPage$delegate", "getRequestPage", "requestPage", "", "startFightTimestamp$delegate", "getStartFightTimestamp", "startFightTimestamp", "Lcom/bytedance/android/livesdk/chatroom/model/InviteSource;", "inviteSourceForLog", "Lcom/bytedance/android/livesdk/chatroom/model/InviteSource;", "getInviteSourceForLog", "()Lcom/bytedance/android/livesdk/chatroom/model/InviteSource;", "setInviteSourceForLog", "(Lcom/bytedance/android/livesdk/chatroom/model/InviteSource;)V", "", "", "dressLevelList", "Ljava/util/Map;", "getDressLevelList", "()Ljava/util/Map;", "isDressOn", "setDressOn", "dressId$delegate", "getDressId", "dressId", "getLinkRoomId", "()Ljava/lang/Long;", "linkRoomId", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRoomFightContext extends DataContext implements com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "link_room_fight";
    private final p dressId$delegate;
    private final Map<String, Integer> dressLevelList;
    private final p fightInfo$delegate;
    private final p fightState$delegate;
    private InviteSource inviteSourceForLog;
    private boolean isDressOn;
    private boolean isDynamic;
    private final p linkRoomUpdateContent$delegate;
    private final p requestPage$delegate;
    private final p startFightTimestamp$delegate;
    private final p stateChangeTransition$delegate;
    private final p widget$delegate;

    public static final class a {
        public a() {
        }

        public final LinkRoomFightContext getContext() {
            DataContext r0 = d.d(com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.a.class);
            if ((r0 instanceof LinkRoomFightContext) == true) goto L6;
            r0 = null;
        L6:
            return (LinkRoomFightContext) r0;
        }

        public final b a() {
            LinkRoomFightContext r0 = getContext();
            if (r0 == null) goto L7;
            j<b> r1 = r0.getWidget();
            if (r1 == null) goto L7;
            return (b) r1.getValue();
        L7:
            return null;
        }

        public final boolean c() {
            LinkRoomFightContext r0 = getContext();
            if (r0 != null) goto L5;
        L12:
            LinkRoomFightContext r1 = getContext();
            if (r1 == null) goto L24;
            m<c.b> r2 = r1.getFightState();
            if (r2 == null) goto L25;
            c.b r3 = (c.b) r2.getValue();
            if (r3 != null) goto L19;
            return false;
        L19:
            if (r3.a() != true) goto L27;
            return true;
        L27:
            return false;
        L25:
            return false;
        L24:
            return false;
        L5:
            if (r0.isDynamic() != true) goto L12;
            b r4 = a();
            if (r4 != null) goto L9;
            return false;
        L9:
            if (r4.isFightShowing() != true) goto L23;
            return true;
        L23:
            return false;
        }

        public static void b(f r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "region");
            Map.Entry r0 = tc0.c.h().p;
            Object r1 = null;
            if (r0 == null) goto L7;
            g2 r2 = (g2) r0.getValue();
            if (r2 == null) goto L7;
            List r3 = r2.getLinkedUsers();
        L8:
            if (r3 == null) goto L16;
            Iterator r4 = r3.iterator();
        L11:
            if (r4.hasNext() == false) goto L15;
            Object r7 = r4.next();
            if (Intrinsics.areEqual(((k) r7).getInteractId(), r5.b) == false) goto L11;
            r1 = r7;
        L15:
            r1 = (k) r1;
        L16:
            if (r1 == null) goto L32;
            Map.Entry r8 = tc0.c.h().p;
            if (r8 == null) goto L24;
            g2 r9 = (g2) r8.getValue();
            if (r9 == null) goto L24;
            boolean r10 = true;
            if (r9.getRoomLinkSilenceStatus() != 1) goto L24;
        L25:
            r5.m = r10;
            if (r6 == false) goto L33;
            r5.f = 0.1d;
            r5.g = 0.1d;
            r5.d = 1.0d;
            r5.e = 1.0d;
            return;
        L33:
            return;
        L24:
            r10 = false;
            goto L25
        L32:
            return;
        L7:
            r3 = null;
            goto L8
        }
    }

    public final m<String> getDressId() {
        return (m) this.dressId$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<com.bytedance.android.live.liveinteract.multiscene.a> getFightInfo() {
        return (m) this.fightInfo$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<c.b> getFightState() {
        return (m) this.fightState$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<i> getLinkRoomUpdateContent() {
        return (n) this.linkRoomUpdateContent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<String> getRequestPage() {
        return (m) this.requestPage$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Long> getStartFightTimestamp() {
        return (m) this.startFightTimestamp$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.k<StateMachine.c.b<c.b, c.a, Object>> getStateChangeTransition() {
        return (com.bytedance.live.datacontext.k) this.stateChangeTransition$delegate.a(this, $$delegatedProperties[4]);
    }

    public final j<b> getWidget() {
        return (j) this.widget$delegate.a(this, $$delegatedProperties[0]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkRoomFightContext.class, "widget", "getWidget()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRoomFightContext.class, "fightInfo", "getFightInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRoomFightContext.class, "fightState", "getFightState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRoomFightContext.class, "linkRoomUpdateContent", "getLinkRoomUpdateContent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRoomFightContext.class, "stateChangeTransition", "getStateChangeTransition()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRoomFightContext.class, "requestPage", "getRequestPage()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRoomFightContext.class, "startFightTimestamp", "getStartFightTimestamp()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRoomFightContext.class, "dressId", "getDressId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public LinkRoomFightContext() {
        this.widget$delegate = ConstantKt.c(this);
        this.fightInfo$delegate = q.d(this, vh7.f.c(com.bytedance.android.live.liveinteract.multiscene.a.class));
        this.fightState$delegate = q.d(this, c.b.C0093c.c);
        this.linkRoomUpdateContent$delegate = q.c(this);
        this.stateChangeTransition$delegate = e.a(this, LinkRoomFightContext$stateChangeTransition$2.INSTANCE);
        this.requestPage$delegate = q.d(this, "");
        this.startFightTimestamp$delegate = q.d(this, 0L);
        this.inviteSourceForLog = InviteSource.UNKNOWN;
        this.dressLevelList = new LinkedHashMap();
        this.dressId$delegate = q.d(this, "");
    }

    public final Long getLinkRoomId() {
        Map.Entry r0 = tc0.c.h().p;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Long) r0.getKey();
    }

    public final Map<String, Integer> getDressLevelList() {
        return this.dressLevelList;
    }

    public final InviteSource getInviteSourceForLog() {
        return this.inviteSourceForLog;
    }

    public final boolean isDressOn() {
        return this.isDressOn;
    }

    public final boolean isDynamic() {
        return this.isDynamic;
    }

    public final void setDressOn(boolean r1) {
        this.isDressOn = r1;
    }

    public final void setDynamic(boolean r1) {
        this.isDynamic = r1;
    }

    public final void setInviteSourceForLog(InviteSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inviteSourceForLog = r2;
    }
}
