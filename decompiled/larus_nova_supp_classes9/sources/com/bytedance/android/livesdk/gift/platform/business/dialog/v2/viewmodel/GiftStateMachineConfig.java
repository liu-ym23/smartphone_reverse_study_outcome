package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.w0;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DIYCardSelectType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftStateMachineConfig {
    public static final /* synthetic */ int a = 0;

    public static abstract class Event {
        public boolean a;

        public static final class LazyEvent extends Event {
            public LazyEventState b;
            public final Event c;
            public final Class<? extends g> d;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/GiftStateMachineConfig$Event$LazyEvent$LazyEventState;", BuildConfig.FLAVOR, "INITIALIZE", "FINISH", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
            public static final enum LazyEventState extends Enum<LazyEventState> {
                public static final LazyEventState FINISH = null;
                public static final LazyEventState INITIALIZE = null;
                public static final /* synthetic */ LazyEventState[] a = null;

                static {
                    LazyEventState r1 = new LazyEventState("INITIALIZE", 0);
                    INITIALIZE = r1;
                    LazyEventState r2 = new LazyEventState("FINISH", 1);
                    FINISH = r2;
                    a = new LazyEventState[]{r1, r2};
                }

                public static LazyEventState valueOf(String r1) {
                    return (LazyEventState) r27.a.a(LazyEventState.class, r1);
                }

                public static LazyEventState[] values() {
                    return (LazyEventState[]) a.clone();
                }

                public LazyEventState(String r1, int r2) {
                    super(r1, r2);
                }
            }

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "LazyEvent";
            }

            public LazyEvent(j r2, Class r3) {
                Intrinsics.checkNotNullParameter(r2, "originEvent");
                Intrinsics.checkNotNullParameter(r3, "targetStateType");
                this.c = r2;
                this.d = r3;
                this.b = LazyEventState.INITIALIZE;
            }
        }

        public static final class a extends Event {
            public final IBaseUser b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ChangeDefaultReceiver";
            }

            public a(IBaseUser r1) {
                this.b = r1;
            }
        }

        public static final class a0 extends Event {
            public final AbsPanel<?> b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "TriggerGroup";
            }

            public a0(AbsPanel<?> r2) {
                Intrinsics.checkNotNullParameter(r2, "panel");
                this.b = r2;
            }
        }

        public static final class b extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ChangeAllMicReceiver";
            }
        }

        public static final class b0 extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UpdateAudienceReceiverList";
            }
        }

        public static final class c extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ChangeReceiver";
            }
        }

        public static final class c0 extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UpdateCurrentListItem";
            }

            static {
                new c0();
            }

            public c0() {
            }
        }

        public static final class d extends Event {
            public final int b;
            public final boolean c;
            public final boolean d;
            public final boolean e;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ChangeTab";
            }

            public /* synthetic */ d(int r9, boolean r10, int r11) {
                if ((r11 & 2) == 0) goto L5;
                boolean r4 = false;
            L7:
                if ((r11 & 8) == 0) goto L9;
                boolean r6 = true;
            L10:
                this(r9, r4, false, r6, false);
                return;
            L9:
                r6 = false;
                goto L10
            L5:
                r4 = r10;
                goto L7
            }

            public d(int r1, boolean r2, boolean r3, boolean r4, boolean r5) {
                this.b = r1;
                this.c = r2;
                this.d = r4;
                this.e = r5;
            }
        }

        public static final class d0 extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UpdateExtraInfo";
            }
        }

        public static final class e extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ClickBuffTab";
            }
        }

        public static final class e0 extends Event {
            public final w0 b;
            public final List<IBaseUser> c;
            public final boolean d;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UpdateGroupLiveList";
            }

            public e0(w0 r2, List r3) {
                Intrinsics.checkNotNullParameter(r3, "UserList");
                this.b = r2;
                this.c = r3;
                this.d = true;
            }
        }

        public static final class f extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ClickDIYGiftTab";
            }
        }

        public static final class f0 extends Event {
            public f0() {
                throw null;
            }

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UpdateReceiverLiveList";
            }
        }

        public static final class g extends Event {
            public final AbsPanel<?> b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ComboFinish";
            }

            public g(AbsPanel<?> r2) {
                Intrinsics.checkNotNullParameter(r2, "panel");
                this.b = r2;
            }
        }

        public static final class g0 extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "UserInteract";
            }

            public g0() {
            }
        }

        public static final class h extends Event {
            public final long b;
            public final String c;

            public h() {
                this(0, 7);
            }

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return this.c;
            }

            public h(long r2, int r4) {
                if ((r4 & 2) == 0) goto L6;
                r2 = 0;
            L6:
                if ((r4 & 4) == 0) goto L8;
                String r5 = "HideDialog";
            L9:
                Intrinsics.checkNotNullParameter(r5, "TAG");
                this.b = r2;
                this.c = r5;
                return;
            L8:
                r5 = null;
                goto L9
            }
        }

        public static final class i extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "LocateFirstGift";
            }

            public i() {
            }
        }

        public static final class j extends Event {
            public final LocateGiftInfo b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "LocateGift";
            }

            public j(LocateGiftInfo r2) {
                Intrinsics.checkNotNullParameter(r2, "locateGiftInfo");
                this.b = r2;
            }
        }

        public static final class k extends Event {
            public final int b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "Login";
            }

            public k(int r1) {
                this.b = r1;
            }
        }

        public static final class l extends Event {
            public static final l b = null;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "OpenDialog";
            }

            static {
                b = new l();
            }

            public l() {
            }
        }

        public static final class m extends Event {
            public final x2 b;
            public final boolean c;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "OpenRechargeDialog";
            }

            public m(x2 r1, boolean r2) {
                this.b = r1;
                this.c = r2;
            }
        }

        public static final class n extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "OpenRechargeRecommendDialog";
            }
        }

        public static final class o extends Event {
            public static final o b = null;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ResetDialog";
            }

            static {
                b = new o();
            }

            public o() {
            }
        }

        public static final class p extends Event {
            public final AbsPanel<?> b;
            public final AbsPanel.GiftPanelSelectType c;
            public final boolean d;
            public final boolean e;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SelectGift";
            }

            public p(AbsPanel<?> r2, AbsPanel.GiftPanelSelectType r3, boolean r4, boolean r5) {
                Intrinsics.checkNotNullParameter(r2, "panel");
                Intrinsics.checkNotNullParameter(r3, "selectType");
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }
        }

        public static final class q extends Event {
            public final AbsPanel<?> b;
            public final int c;
            public final int d;
            public final IBaseUser e;
            public final int f;
            public final boolean g;
            public final com.bytedance.android.livesdk.gift.platform.core.model.n h;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SendGift";
            }

            public /* synthetic */ q(AbsPanel r9, int r10, int r11, IBaseUser r13, com.bytedance.android.livesdk.gift.platform.core.model.n r14) {
                this(r9, r10, r11, r13, 0, false, r14);
            }

            public q(AbsPanel<?> r2, int r3, int r4, IBaseUser r5, int r6, boolean r7, com.bytedance.android.livesdk.gift.platform.core.model.n r8) {
                Intrinsics.checkNotNullParameter(r2, "panel");
                Intrinsics.checkNotNullParameter(r5, "toUser");
                Intrinsics.checkNotNullParameter(r8, "showInfo");
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
                this.g = r7;
                this.h = r8;
            }
        }

        public static final class r extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SendGroupGift";
            }
        }

        public static final class s extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ShowBuffWidget";
            }
        }

        public static final class t extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "ShowCustomGiftSelectPanel";
            }
        }

        public static final class u extends Event {
            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncGiftExtra";
            }
        }

        public static final class v extends Event {
            public c b;
            public final boolean c;
            public final boolean d;
            public final int e;
            public final boolean f;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncList";
            }

            public v(boolean r1, boolean r2, int r3, boolean r4) {
                this.c = r1;
                this.d = r2;
                this.e = r3;
                this.f = r4;
            }
        }

        public static final class w extends Event {
            public final c b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncListSuccess";
            }

            public w(c r2) {
                Intrinsics.checkNotNullParameter(r2, "GiftData");
                this.b = r2;
            }
        }

        public static final class x extends Event {
            public static final x b = null;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncListSuccessWithoutNotify";
            }

            static {
                b = new x();
            }

            public x() {
            }
        }

        public static final class y extends Event {
            public static final y b = null;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncProp";
            }

            static {
                b = new y();
            }

            public y() {
            }
        }

        public static final class z extends Event {
            public final List<? extends pz1.e> b;
            public final boolean c;
            public final boolean d;

            @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.Event
            public final String a() {
                return "SyncPropSuccess";
            }

            public z(List r2) {
                Intrinsics.checkNotNullParameter(r2, "propPanel");
                this.b = r2;
                this.c = false;
                this.d = true;
            }
        }

        public abstract String a();

        public Event() {
            this.a = true;
        }
    }

    public static abstract class a implements g {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig$a$a, reason: collision with other inner class name */
        public static final class C0022a extends a {
            public final AbsPanel<?> a;
            public final AbsPanel<?> b;
            public final List<AbsPanel<?>> c;

            public C0022a() {
                throw null;
            }

            public C0022a(AbsPanel r2, AbsPanel r3, List r4) {
                Intrinsics.checkNotNullParameter(r2, "curPanel");
                Intrinsics.checkNotNullParameter(r4, "buffPanelList");
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public static final class b extends a {
            public final AbsPanel<?> a;
            public final int b;
            public final boolean c;
            public final DIYCardSelectType d;
            public final n e;

            public b(AbsPanel r3, int r4) {
                Intrinsics.checkNotNullParameter(r3, "curPanel");
                Intrinsics.checkNotNullParameter(null, "selectType");
                this.a = r3;
                this.b = r4;
                this.c = false;
                this.d = null;
                this.e = null;
            }
        }

        public static final class c extends a {
            public final AbsPanel<?> a;
            public final int b;
            public final int c;
            public final p2 d;
            public final int e;

            public c(AbsPanel<?> r2, int r3, int r4, p2 r5, int r6) {
                Intrinsics.checkNotNullParameter(r2, "curPanel");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
            }
        }

        public static final class d extends a {
            public d() {
            }
        }

        public static final class e extends a {
            public final AbsPanel<?> a;
            public final boolean b;

            public e(AbsPanel<?> r2, boolean r3) {
                Intrinsics.checkNotNullParameter(r2, "curPanel");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class f extends a {
            public final AbsPanel<?> a;
            public final int b;
            public final int c;
            public final p2 d;

            public f() {
                throw null;
            }

            public f(int r3, int r4) {
                Intrinsics.checkNotNullParameter(null, "curPanel");
                this.a = null;
                this.b = r3;
                this.c = r4;
                this.d = null;
            }
        }

        public static final class g extends a {
            public final AbsPanel<?> a;

            public g(AbsPanel<?> r2) {
                Intrinsics.checkNotNullParameter(r2, "curPanel");
                this.a = r2;
            }
        }

        public static final class h extends a {
            public h() {
            }
        }

        public a() {
        }

        public final AbsPanel<?> a() {
            if ((this instanceof e) == false) goto L7;
            return ((e) this).a;
        L7:
            if ((this instanceof g) == false) goto L11;
            return ((g) this).a;
        L11:
            if ((this instanceof c) == false) goto L15;
            return ((c) this).a;
        L15:
            if ((this instanceof f) == false) goto L19;
            return ((f) this).a;
        L19:
            if ((this instanceof C0022a) == false) goto L23;
            return ((C0022a) this).a;
        L23:
            if ((this instanceof b) == true) goto L25;
            return null;
        L25:
            return ((b) this).a;
        }

        public final AbsPanel<?> b() {
            if ((this instanceof e) == false) goto L7;
            return ((e) this).a;
        L7:
            if ((this instanceof g) == false) goto L11;
            return ((g) this).a;
        L11:
            if ((this instanceof c) == false) goto L15;
            return ((c) this).a;
        L15:
            if ((this instanceof f) == false) goto L19;
            return ((f) this).a;
        L19:
            if ((this instanceof C0022a) == false) goto L25;
            C0022a r0 = (C0022a) this;
            AbsPanel<?> r1 = r0.b;
            if (r1 == null) goto L23;
            return r1;
        L23:
            return r0.a;
        L25:
            if ((this instanceof b) == true) goto L27;
            return null;
        L27:
            return ((b) this).a;
        }

        public final String c() {
            if ((this instanceof d) == false) goto L6;
            return "Dismiss";
        L6:
            if ((this instanceof h) == false) goto L9;
            return "IdleOpen";
        L9:
            if ((this instanceof e) == false) goto L12;
            StringBuilder r0 = new StringBuilder("GiftSelected:");
            e r6 = (e) this;
            r0.append(MapsKt.mapOf(new Pair[]{TuplesKt.to("panelId", Long.valueOf(r6.a.c())), TuplesKt.to("selectType", r6.a.d)}).toString());
            return r0.toString();
        L12:
            if ((this instanceof C0022a) == false) goto L22;
            StringBuilder r1 = new StringBuilder("BuffSelected:");
            Pair[] r9 = new Pair[5];
            C0022a r10 = (C0022a) this;
            r9[0] = TuplesKt.to("panelId", Long.valueOf(r10.a.c()));
            r9[1] = TuplesKt.to("selectType", r10.a.d);
            AbsPanel<?> r2 = r10.b;
            Integer r3 = null;
            if (r2 == null) goto L16;
            Long r4 = Long.valueOf(r2.c());
        L17:
            r9[2] = TuplesKt.to("buffPanelId", r4);
            if (r10.b == null) goto L20;
            r3 = 0;
        L20:
            r9[3] = TuplesKt.to("buffLevel", r3);
            r9[4] = TuplesKt.to("buffListSize", Integer.valueOf(r10.c.size()));
            r1.append(MapsKt.mapOf(r9).toString());
            return r1.toString();
        L16:
            r4 = null;
            goto L17
        L22:
            if ((this instanceof c) == false) goto L25;
            StringBuilder r5 = new StringBuilder("DialogGiftCombo:");
            c r11 = (c) this;
            r5.append(MapsKt.mapOf(new Pair[]{TuplesKt.to("panelId", Long.valueOf(r11.a.c())), TuplesKt.to("comboNum", Integer.valueOf(r11.b)), TuplesKt.to("sendNum", Integer.valueOf(r11.c)), TuplesKt.to("buffLevel", Integer.valueOf(r11.e))}).toString());
            return r5.toString();
        L25:
            if ((this instanceof g) == false) goto L28;
            return "GroupSelected:" + MapsKt.mapOf(TuplesKt.to("panelId", Long.valueOf(((g) this).a.c()))).toString();
        L28:
            if ((this instanceof f) == false) goto L31;
            StringBuilder r7 = new StringBuilder("GroupCombo:");
            f r8 = (f) this;
            r7.append(MapsKt.mapOf(new Pair[]{TuplesKt.to("panelId", Long.valueOf(r8.a.c())), TuplesKt.to("comboNum", Integer.valueOf(r8.b)), TuplesKt.to("sendNum", Integer.valueOf(r8.c))}).toString());
            return r7.toString();
        L31:
            if ((this instanceof b) == false) goto L35;
            StringBuilder r13 = new StringBuilder("DIYSelected:");
            b r14 = (b) this;
            r13.append(MapsKt.mapOf(new Pair[]{TuplesKt.to("panelId", Long.valueOf(r14.a.c())), TuplesKt.to("curIndex", Integer.valueOf(r14.b)), TuplesKt.to("needAnim", Boolean.valueOf(r14.c))}).toString());
            return r13.toString();
        L35:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static abstract class b implements g {

        public static final class a extends b {
            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig$b$b, reason: collision with other inner class name */
        public static final class C0023b extends b {
            public final Map<String, g0> a;

            /* JADX WARN: Multi-variable type inference failed */
            public C0023b(Map<String, ? extends g0> r2) {
                Intrinsics.checkNotNullParameter(r2, "giftExtrasMap");
                this.a = r2;
            }
        }

        public b() {
        }
    }

    public static final class c {
        public final List<w1> a;
        public final Map<w1, Map<Integer, List<AbsPanel<?>>>> b;
        public final List<pz1.e> c;
        public final List<List<AbsPanel<?>>> d;
        public final Map<Integer, Integer> e;
        public final boolean f;

        public c() {
            this(null, 63);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L18;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            List<w1> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Map<w1, Map<Integer, List<AbsPanel<?>>>> r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            List<pz1.e> r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            List<List<AbsPanel<?>>> r10 = this.d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r13 = (r9 + r11) * 31;
            Map<Integer, Integer> r14 = this.e;
            if (r14 == null) goto L21;
            r1 = r14.hashCode();
        L21:
            int r15 = (r13 + r1) * 31;
            boolean r16 = this.f;
            ?? r17 = r16;
            if (r16 == false) goto L25;
            r17 = 1;
        L25:
            return r15 + r17;
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "GiftListData(giftPages=" + this.a + ", mGiftPanelMap=" + this.b + ", propPanels=" + this.c + ", mGiftAllList=" + this.d + ", tabToPageMap=" + this.e + ", isSend=" + this.f + ")";
        }

        public /* synthetic */ c(List r10, int r11) {
            HashMap r1 = null;
            if ((r11 & 1) == 0) goto L5;
            ArrayList r3 = new ArrayList();
        L7:
            if ((r11 & 2) == 0) goto L9;
            HashMap r4 = new HashMap();
        L11:
            if ((r11 & 4) == 0) goto L13;
            List r5 = null;
        L15:
            if ((r11 & 8) == 0) goto L17;
            ArrayList r6 = new ArrayList();
        L19:
            if ((r11 & 16) == 0) goto L21;
            r1 = new HashMap();
        L21:
            this(r3, r4, r5, r6, r1, false);
            return;
        L17:
            r6 = null;
            goto L19
        L13:
            r5 = r10;
            goto L15
        L9:
            r4 = null;
            goto L11
        L5:
            r3 = null;
            goto L7
        }

        public static c a(c r7, List r8, List r9, boolean r10, int r11) {
            if ((r11 & 1) == 0) goto L5;
            r8 = r7.a;
        L5:
            List r1 = r8;
            if ((r11 & 2) == 0) goto L8;
            Map<w1, Map<Integer, List<AbsPanel<?>>>> r2 = r7.b;
        L10:
            if ((r11 & 4) == 0) goto L12;
            r9 = r7.c;
        L12:
            List r3 = r9;
            if ((r11 & 8) == 0) goto L15;
            List<List<AbsPanel<?>>> r4 = r7.d;
        L17:
            if ((r11 & 16) == 0) goto L19;
            Map<Integer, Integer> r5 = r7.e;
        L21:
            if ((r11 & 32) == 0) goto L23;
            r10 = r7.f;
        L23:
            Intrinsics.checkNotNullParameter(r1, "giftPages");
            Intrinsics.checkNotNullParameter(r2, "mGiftPanelMap");
            Intrinsics.checkNotNullParameter(r4, "mGiftAllList");
            Intrinsics.checkNotNullParameter(r5, "tabToPageMap");
            return new c(r1, r2, r3, r4, r5, r10);
        L19:
            r5 = null;
            goto L21
        L15:
            r4 = null;
            goto L17
        L8:
            r2 = null;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends w1> r2, Map<w1, Map<Integer, List<AbsPanel<?>>>> r3, List<? extends pz1.e> r4, List<List<AbsPanel<?>>> r5, Map<Integer, Integer> r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "giftPages");
            Intrinsics.checkNotNullParameter(r3, "mGiftPanelMap");
            Intrinsics.checkNotNullParameter(r5, "mGiftAllList");
            Intrinsics.checkNotNullParameter(r6, "tabToPageMap");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class d {
        public final List<IBaseUser> a;
        public final w0 b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L10;
            d r4 = (d) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<IBaseUser> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            w0 r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "GiftReceiverListData(userList=" + this.a + ", groupShowInfo=" + this.b + ")";
        }

        public d(List<? extends IBaseUser> r2, w0 r3) {
            Intrinsics.checkNotNullParameter(r2, "userList");
            this.a = r2;
            this.b = r3;
        }
    }

    public static abstract class e implements g {

        public static final class a extends e {
            public a() {
            }
        }

        public static final class b extends e {
            public final c a;
            public final boolean b;

            public b(c r1, boolean r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public static final class c extends e {
            public final c a;
            public final boolean b;

            public c(c r1, boolean r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public e() {
        }

        public final List<w1> a() {
            if ((this instanceof c) == false) goto L9;
            c r0 = ((c) this).a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a;
        L9:
            if ((this instanceof b) == false) goto L15;
            c r1 = ((b) this).a;
            if (r1 != null) goto L13;
            return null;
        L13:
            return r1.a;
        L15:
            return null;
        }

        public final Map<w1, Map<Integer, List<AbsPanel<?>>>> b() {
            if ((this instanceof c) == false) goto L8;
            c r0 = ((c) this).a;
            if (r0 == null) goto L12;
            Map<w1, Map<Integer, List<AbsPanel<?>>>> r1 = r0.b;
        L13:
            if (r1 == null) goto L15;
            return r1;
        L15:
            return new LinkedHashMap();
        L12:
            r1 = null;
            goto L13
        L8:
            if ((this instanceof b) == false) goto L12;
            c r2 = ((b) this).a;
            if (r2 == null) goto L12;
            r1 = r2.b;
            goto L13
        }

        public final List<pz1.e> c() {
            List<pz1.e> r1 = null;
            if ((this instanceof c) == false) goto L8;
            c r0 = ((c) this).a;
            if (r0 == null) goto L12;
            r1 = r0.c;
        L12:
            if (r1 == null) goto L14;
            return r1;
        L14:
            return CollectionsKt.emptyList();
        L8:
            if ((this instanceof b) == false) goto L12;
            c r2 = ((b) this).a;
            if (r2 == null) goto L12;
            r1 = r2.c;
            goto L12
        }

        public final String d() {
            if ((this instanceof a) == false) goto L6;
            return "IDLE";
        L6:
            if ((this instanceof c) == false) goto L9;
            return "OnSyncList:";
        L9:
            if ((this instanceof b) == false) goto L13;
            return "OnSyncFinish";
        L13:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static abstract class f {

        public static final class a extends f {
            public final boolean a;

            public a(boolean r1) {
                this.a = r1;
            }
        }

        public static final class b extends f {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends f {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends f {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public static final class e extends f {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig$f$f, reason: collision with other inner class name */
        public static final class C0037f extends f {
            public final boolean a;

            public C0037f(boolean r1) {
                this.a = r1;
            }
        }

        public f() {
        }
    }

    public interface g {
    }

    public static abstract class h implements g {

        public static final class a extends h {
            public final int a;
            public final boolean b;
            public final Map<Integer, Integer> c;

            public a(int r2, boolean r3, Map r4) {
                Intrinsics.checkNotNullParameter(r4, "orderRule");
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public h() {
        }

        public final String b() {
            if ((this instanceof a) == false) goto L7;
            StringBuilder r0 = new StringBuilder("TAB:");
            a r3 = (a) this;
            r0.append(MapsKt.mapOf(new Pair[]{TuplesKt.to("currentTab", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r3.a)), TuplesKt.to("isDefault", Boolean.valueOf(r3.b))}));
            return r0.toString();
        L7:
            throw new NoWhenBranchMatchedException();
        }

        public final int a(int r2) {
            Integer r3 = ((a) this).c.get(Integer.valueOf(r2));
            if (r3 != null) goto L7;
            return 0;
        L7:
            return r3.intValue();
        }
    }

    public GiftStateMachineConfig() {
    }

    static {
    }

    public static StateMachine a(final Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<a, Event, f>, Unit> r1 = new GiftStateMachineConfig$createDialogStateMachine$1(r2);
        r0.getClass();
        return StateMachine.a.a(r1);
    }

    public static StateMachine b(final Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<e, Event, f>, Unit> r1 = new GiftStateMachineConfig$createListStateMachine$1(r2);
        r0.getClass();
        return StateMachine.a.a(r1);
    }

    public static StateMachine c(final Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<h, Event, f>, Unit> r1 = new GiftStateMachineConfig$createTabStateMachine$1(r2);
        r0.getClass();
        return StateMachine.a.a(r1);
    }
}
