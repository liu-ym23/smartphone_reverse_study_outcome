package com.bytedance.android.live.liveinteract.plantform.core;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.g2;
import com.bytedance.android.live.base.model.message.h2;
import com.bytedance.android.live.base.model.message.i2;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.IMultiCommonService;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.liveinteract.plantform.model.m0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.model.u0;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.t0;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.liveinteract.wrdspreload.MultiLinkWRDSPreloadManager;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.bb0;
import com.bytedance.android.livesdk.config.rb0;
import com.bytedance.android.livesdk.config.z01;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.link.model.bridge.c1;
import com.bytedance.android.livesdk.link.model.bridge.e1;
import com.bytedance.android.livesdk.link.model.bridge.f1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.g9;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdk.message.linker.LinkerLockPositionContent;
import com.bytedance.android.livesdk.message.model.ec;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfo;
import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfoMainKt;
import com.bytedance.android.livesdkapi.depend.message.crossroom.UserInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContentKt;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLeaveContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y implements com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge>, vlc.l {
    public boolean A;
    public Disposable B;
    public h1 C;
    public final List<ILinkmicInteractEntrance> D;
    public final Map<String, List<ILinkmicInteractEntrance>> E;
    public Integer F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public long K;
    public boolean L;
    public final IRoom M;
    public final DataCenter N;
    public final String a;
    public final int b;
    public final CopyOnWriteArrayList<ILinkPlayerInfoBridge> c;
    public CopyOnWriteArrayList<ILinkPlayerInfoBridge> d;
    public final CopyOnWriteArrayList<LinkmicPositionItem> e;
    public final CopyOnWriteArrayList<ILinkPlayerInfoBridge> f;
    public final CopyOnWriteArrayList<ILinkPlayerInfoBridge> g;
    public final CopyOnWriteArrayList<ILinkPlayerInfoBridge> h;
    public final CopyOnWriteArrayList<ILinkPlayerInfoBridge> i;
    public final vlc.d j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final List<com.bytedance.android.live.liveinteract.plantform.base.i.b<ILinkPlayerInfoBridge>> n;
    public final CompositeDisposable o;
    public final Map<String, Long> p;
    public final Boolean q;
    public final Set<Integer> r;
    public a s;
    public long t;
    public long u;
    public final z01 v;
    public final boolean w;
    public final com.bytedance.android.live.liveinteract.plantform.utils.z x;
    public final List<String> y;
    public final Map<String, Boolean> z;

    public static final class a {
        public final long a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L14;
            a r7 = (a) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (r1 + r4) * 31;
            String r6 = this.c;
            if (r6 == null) goto L9;
            int r7 = r6.hashCode();
        L10:
            int r8 = (r5 + r7) * 31;
            String r9 = this.d;
            if (r9 == null) goto L14;
            r3 = r9.hashCode();
        L14:
            return r8 + r3;
        L9:
            r7 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            return "RefreshInfo(timestamp=" + this.a + ", from=" + this.b + ", logId=" + this.c + ", extra=" + this.d + ")";
        }

        public a(long r2, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "from");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ y a;

        public b(y r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            UserAttr r5 = (UserAttr) r4;
            if (je0.d.Y() == false) goto L5;
        L6:
            this.a.I(false, "adminRoleWaitingListChange");
        L8:
            if (((Boolean) vm2.e.f0.getValue(null, vm2.e.a[56])).booleanValue() == false) goto L11;
            this.a.R4(false);
            return;
        L11:
            return;
        L5:
            if (this.a.q.booleanValue() == false) goto L8;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ y a;

        public c(y r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IRoomLinkMicSyncData r3 = (IRoomLinkMicSyncData) r2;
            y r4 = this.a;
            if (r4.H == false) goto L6;
            r4.H = false;
            r4.H();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ y a;

        public d(y r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            y r0 = this.a;
            y.e(r0, (Throwable) r2);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ gm2.i b;

        public e(long r1, gm2.i r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.a r6 = (com.bytedance.android.live.network.response.a) r5;
            Intrinsics.checkNotNullParameter(r6, "response");
            long r0 = this.a;
            long r2 = System.currentTimeMillis() - r0;
            String r1 = r6.logId;
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            InteractLinkFullLinkMonitor.U(100101, r2, r1);
            int r3 = nd0.g.a;
            nd0.g.i(this.b, this.a, r6.logId);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ y a;
        public final /* synthetic */ long b;
        public final /* synthetic */ gm2.i c;

        public f(y r1, long r2, gm2.i r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            Intrinsics.checkNotNullParameter(r6, "throwable");
            long r0 = this.b;
            InteractLinkFullLinkMonitor.T(100101, System.currentTimeMillis() - r0, r6);
            int r1 = nd0.g.a;
            nd0.g.h(this.c, this.b, r6);
            ALogger.stacktrace(6, this.a.a, r6.getStackTrace());
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ gm2.i b;

        public g(long r1, gm2.i r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.a r6 = (com.bytedance.android.live.network.response.a) r5;
            Intrinsics.checkNotNullParameter(r6, "response");
            long r0 = this.a;
            long r2 = System.currentTimeMillis() - r0;
            String r1 = r6.logId;
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            InteractLinkFullLinkMonitor.U(100102, r2, r1);
            int r3 = nd0.g.a;
            nd0.g.i(this.b, this.a, r6.logId);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ y a;
        public final /* synthetic */ long b;
        public final /* synthetic */ gm2.i c;

        public h(y r1, long r2, gm2.i r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            Intrinsics.checkNotNullParameter(r6, "throwable");
            long r0 = this.b;
            InteractLinkFullLinkMonitor.T(100102, System.currentTimeMillis() - r0, r6);
            int r1 = nd0.g.a;
            nd0.g.h(this.c, this.b, r6);
            ALogger.stacktrace(6, this.a.a, r6.getStackTrace());
        }
    }

    public static final class i<T, R> implements Function {
        public final /* synthetic */ y a;
        public final /* synthetic */ boolean b;

        public i(y r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            y r0 = this.a;
            boolean r1 = this.b;
            r0.getClass();
            if (vm2.d.q0().isDisableWRDSWhenEnterRoom() == false) goto L6;
            if (r1 == false) goto L6;
            LinkMicRoomDataSyncModel r2 = null;
        L7:
            Set<Integer> r5 = LinkWRDSHelper.a;
            Intrinsics.checkNotNullParameter(r4, "response");
            return Single.create(new com.bytedance.android.live.liveinteract.wrds.c(r2, r4));
        L6:
            r2 = LinkWRDSHelper.b();
            goto L7
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ y a;
        public final /* synthetic */ long b;
        public final /* synthetic */ boolean c;

        public j(y r1, long r2, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r13) {
            com.bytedance.android.live.network.response.e r14 = (com.bytedance.android.live.network.response.e) r13;
            Intrinsics.checkNotNullParameter(r14, "response");
            this.a.l = false;
            long r0 = this.b;
            long r7 = System.currentTimeMillis() - r0;
            String r9 = r14.logId;
            Set<Long> r1 = InteractLinkFullLinkMonitor.a;
            Intrinsics.checkNotNullParameter(r9, "logId");
            JSONObject r10 = new JSONObject();
            nd0.c.s(nd0.c.a, LinkMonitorData.ListV2, null, r7, r9, r10, 98);
            this.a.s((w0) r14.data, "listV2");
            if (this.c == false) goto L8;
            y r15 = this.a;
            if (r15.I == true) goto L9;
            y.f(r15, r15.c);
            return;
        L9:
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ y a;
        public final /* synthetic */ long b;

        public k(y r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            Intrinsics.checkNotNullParameter(r10, "throwable");
            long r0 = this.b;
            long r3 = System.currentTimeMillis() - r0;
            Set<Long> r1 = InteractLinkFullLinkMonitor.a;
            JSONObject r6 = new JSONObject();
            nd0.c.r(nd0.c.a, LinkMonitorData.ListV2, null, r3, r10, r6, 34);
            com.bytedance.android.live.liveinteract.plantform.utils.x.H(r10, this.a.M.getId(), this.a.M.getOwnerUserIdString());
            y.e(this.a, r10);
            this.a.l = false;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ y a;
        public final /* synthetic */ long b;
        public final /* synthetic */ boolean c;

        public l(y r1, long r2, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            String r3 = r8.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.F(r1, r3);
            this.a.k = false;
            List<n0> r2 = ((m0) r8.data).getMWaitingUserInfo();
            if (r2 == null) goto L5;
            ArrayList<ILinkPlayerInfoBridge> r4 = je0.d.e0(r2);
        L6:
            long r5 = ((m0) r8.data).getTotalCount();
            if (Lists.isEmpty(r4) == false) goto L9;
            this.a.f.clear();
        L10:
            com.bytedance.android.live.liveinteract.plantform.utils.x.Q(r5, this.c, false);
            if (this.c == false) goto L13;
            y r6 = this.a;
            y.f(r6, r6.f);
        L13:
            y.g(this.a);
            tc0.c.h().getClass();
            Iterator r9 = ((ArrayList) this.a.n).iterator();
        L15:
            if (r9.hasNext() == false) goto L17;
            ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r9.next()).n(this.a.f, r5, ((m0) r8.data).getWaitingUser());
            goto L15
        L17:
            return;
        L9:
            this.a.f.clear();
            this.a.f.addAll(r4);
            goto L10
        L5:
            r4 = new ArrayList();
            goto L6
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ y a;
        public final /* synthetic */ long b;

        public m(y r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.E(r1, r5);
            y.e(this.a, r5);
            this.a.k = false;
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ y a;
        public final /* synthetic */ boolean b;

        public n(y r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            Intrinsics.checkNotNullParameter(r7, "response");
            this.a.k = false;
            List<ILinkPlayerInfoBridge> r0 = ((a1) r7.data).getPlayerInfo();
            long r2 = ((a1) r7.data).getTotalCount();
            if (Lists.isEmpty(r0) == false) goto L5;
            this.a.f.clear();
        L6:
            com.bytedance.android.live.liveinteract.plantform.utils.x.Q(r2, this.b, false);
            if (this.b == false) goto L9;
            y r8 = this.a;
            y.f(r8, r8.f);
        L9:
            y.g(this.a);
            tc0.c.h().getClass();
            Iterator r9 = ((ArrayList) this.a.n).iterator();
        L11:
            if (r9.hasNext() == false) goto L13;
            ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r9.next()).n(this.a.f, r2, null);
            goto L11
        L13:
            return;
        L5:
            this.a.f.clear();
            CopyOnWriteArrayList<ILinkPlayerInfoBridge> r10 = this.a.f;
            Intrinsics.checkNotNull(r0);
            r10.addAll(r0);
            goto L6
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ y a;

        public o(y r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            com.bytedance.android.live.liveinteract.plantform.utils.x.H(r5, this.a.M.getId(), this.a.M.getOwnerUserIdString());
            y.e(this.a, r5);
            this.a.k = false;
        }
    }

    public final void L() {
        Iterator<LinkmicPositionItem> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setStatus(LinkmicPositionItem.LinkmicPositionStatus.NORMAL.ordinal());
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final List<ILinkPlayerInfoBridge> V4() {
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r0 = this.f;
        ArrayList r1 = new ArrayList();
        Iterator<ILinkPlayerInfoBridge> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ILinkPlayerInfoBridge r3 = r2.next();
        if ((!k(this.g, r3)) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final void W4() {
        Iterator r0 = ((ArrayList) this.n).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r0.next()).onOnlineListChanged(this.c);
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final void X4() {
        this.g.clear();
        this.g.addAll(this.f);
        int r0 = fj0.e.a;
        if (fj0.c.a() == false) goto L8;
        cj0.c r1 = PaidLinkMicContext.Companion.a();
        if (r1 == null) goto L9;
        r1.clearIncreaseUserList();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final int b() {
        int r1 = 0;
        if (Lists.isEmpty(this.c) == false) goto L5;
        return 0;
    L5:
        Iterator<ILinkPlayerInfoBridge> r0 = this.c.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        ILinkPlayerInfoBridge r2 = r0.next();
        if (r2 == null) goto L7;
        if (r2.getRoleType() == 1) goto L7;
        r1 = r1 + 1;
        goto L7
    L13:
        return r1;
    }

    public final boolean h() {
        if (this.q.booleanValue() == false) goto L16;
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        MixStreamType r1 = null;
        if (r0 == null) goto L7;
        MixStreamType r2 = r0.getMixStreamType();
    L9:
        if (r2 == MixStreamType.CLIENT_MIX) goto L15;
        rj0.k r3 = rj0.k.a.a();
        if (r3 == null) goto L14;
        r1 = r3.getMixStreamType();
    L14:
        if (r1 != MixStreamType.RTC_CLIENT_MIX) goto L16;
    L15:
        return true;
    L7:
        r2 = null;
    L16:
        return false;
    }

    public final void i() {
        ALogger.i(this.a, "LinkUserInfoCenterV2=" + hashCode() + " attach, hasAttach=" + this.L);
        if (((Boolean) vm2.d.E1.getValue(null, vm2.d.a[132(0x84, float:1.85E-43)])).booleanValue() == true) goto L5;
    L8:
        this.L = true;
        vlc.d r2 = this.j;
        if (r2 == null) goto L11;
        r2.addMessageListener(MessageType.LINK_MIC.getKey(), this);
        this.j.addMessageListener(MessageType.LINKER.getKey(), this);
        this.j.addMessageListener(MessageType.LINK_MIC_SIGNAL.getKey(), this);
        this.j.addMessageListener(MessageType.LINKER_CONTRIBUTE_MESSAGE.getKey(), this);
        this.j.addMessageListener(MessageType.LINK_MIC_POSITION.getKey(), this);
    L11:
        this.m = true;
        boolean r4 = false;
        String r5 = "draw";
        if (vm2.h.S().b() == false) goto L101;
        if (MultiLinkLoadWidgetUtils.a() == false) goto L43;
        Lazy r3 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r6 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", this.M, false, 4, null);
        if (r6 == null) goto L43;
        if (vm2.h.S().d() == false) goto L20;
        f2.c("内流上下滑WRDS预拉取，wrds=" + r6, 0);
    L20:
        int r11 = t0.a;
        t0.a(this.a, "[InnerWRDSPreloadV2] roomId=" + this.M.getId() + ", get preload wrds data from store, wrds=" + r6);
        w0 r12 = (w0) vh7.f.c(w0.class);
        r12.setMPlayerInfo(r6.mLinkUsers);
        r12.setLinkerContentMap(r6.linkerContentMap);
        r12.setLockedPositions(r6.lockedPositions);
        r12.setPositions(r6.positions);
        r12.setHasMore(false);
        r12.setTotalCount(0);
        r12.setPreOnlineList(new ArrayList());
        s(r12, "wrdsPreload");
        DataCenter r7 = this.N;
        IRoom r10 = this.M;
        if (r10 == null) goto L23;
        Long r13 = Long.valueOf(r10.getId());
    L24:
        com.bytedance.android.livesdk.chatroom.u r8 = com.bytedance.android.live.liveinteract.api.utils.m.f(r7, Long.valueOf(r13.longValue()));
        if (r8 == null) goto L29;
        com.bytedance.live.datacontext.n r9 = r8.x();
        if (r9 == null) goto L29;
        Object r14 = r9.getValue();
    L31:
        if ((r14 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L33;
        r14 = null;
    L33:
        MultiSceneEnterRoomStatisticsUtils r15 = (MultiSceneEnterRoomStatisticsUtils) r14;
        if (r15 != null) goto L36;
        String r16 = "";
    L41:
        if (r16.equals("draw") == false) goto L101;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.r0(0);
        goto L101
    L36:
        if (r15.a != 1) goto L38;
        r16 = "click";
        goto L41
    L38:
        r16 = "draw";
    L29:
        r14 = null;
        goto L31
    L23:
        r13 = null;
    L43:
        MiddlewareRoomContext r17 = o3.b();
        if (r17 == null) goto L50;
        com.bytedance.live.datacontext.m r18 = r17.getInnerDrawEnterRoomWRDSPreloadUse();
        if (r18 == null) goto L50;
        if (((Boolean) r18.getValue()).booleanValue() == true) goto L101;
    L50:
        Set r19 = com.ss.ugc.live.sdk.msg.dispatch.j.a;
        long r110 = this.M.getId();
        String r20 = com.ss.ugc.live.sdk.msg.dispatch.j.a("RoomLinkMicSyncData", null);
        Map r111 = (Map) ((ConcurrentHashMap) com.ss.ugc.live.sdk.msg.dispatch.j.c).get(Long.valueOf(r110));
        if (r111 == null) goto L53;
        tlc.c r21 = (tlc.c) r111.get(r20);
    L55:
        if (vm2.h.S().d() == false) goto L57;
        f2.c("内流上下滑WRDS预拉取，dataSync=" + r21, 0);
    L57:
        int r112 = t0.a;
        String r113 = this.a;
        StringBuilder r114 = new StringBuilder("[InnerWRDSPreload] roomId=");
        r114.append(this.M.getId());
        r114.append(", get preload wrds data from store, dataSync=");
        r114.append(r21);
        r114.append(", data=");
        if (r21 == null) goto L60;
        Object r115 = r21.getData();
    L61:
        r114.append(r115);
        t0.a(r113, r114.toString());
        if (r21 == null) goto L64;
        Object r22 = r21.getData();
    L66:
        if ((r22 instanceof IRoomLinkMicSyncData) == true) goto L68;
        r22 = null;
    L68:
        IRoomLinkMicSyncData r23 = (IRoomLinkMicSyncData) r22;
        if (r23 == null) goto L71;
        w0 r116 = (w0) vh7.f.c(w0.class);
        r116.setMPlayerInfo(r23.getMLinkUsers());
        r116.setLinkerContentMap(r23.getLinkerContentMap());
        r116.setLockedPositions(r23.getLockedPositions());
        r116.setPositions(r23.getPositions());
        r116.setHasMore(false);
        r116.setTotalCount(0);
        r116.setPreOnlineList(new ArrayList());
        s(r116, "wrdsPreload");
        int r24 = 0;
    L72:
        DataCenter r117 = this.N;
        IRoom r118 = this.M;
        if (r118 == null) goto L75;
        Long r119 = Long.valueOf(r118.getId());
    L76:
        com.bytedance.android.livesdk.chatroom.u r120 = com.bytedance.android.live.liveinteract.api.utils.m.f(r117, Long.valueOf(r119.longValue()));
        if (r120 == null) goto L81;
        com.bytedance.live.datacontext.n r121 = r120.x();
        if (r121 == null) goto L81;
        Object r122 = r121.getValue();
    L83:
        if ((r122 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L85;
        r122 = null;
    L85:
        MultiSceneEnterRoomStatisticsUtils r123 = (MultiSceneEnterRoomStatisticsUtils) r122;
        if (r123 != null) goto L88;
        String r124 = "";
    L93:
        if (r124.equals("draw") == false) goto L95;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.r0(r24);
    L95:
        MiddlewareRoomContext r25 = o3.b();
        if (r25 == null) goto L101;
        com.bytedance.live.datacontext.m r26 = r25.getInnerDrawEnterRoomWRDSPreloadUse();
        if (r26 == null) goto L101;
        r26.setValue(Boolean.TRUE);
        goto L101
    L88:
        if (r123.a != 1) goto L90;
        r124 = "click";
        goto L93
    L90:
        r124 = "draw";
    L81:
        r122 = null;
        goto L83
    L75:
        r119 = null;
        goto L76
    L71:
        r24 = -1;
        goto L72
    L64:
        r22 = null;
        goto L66
    L60:
        r115 = null;
        goto L61
    L53:
        r21 = null;
    L101:
        if (MultiLinkLoadWidgetUtils.c() == false) goto L141;
        if (((Boolean) rb0.a.getValue()).booleanValue() == false) goto L111;
        DataCenter r27 = this.N;
        if (r27 == null) goto L107;
        Boolean r28 = (Boolean) r27.get("data_guest_receive_finish_msg", Boolean.FALSE);
    L109:
        if (Intrinsics.areEqual(r28, Boolean.TRUE) == false) goto L111;
        ALogger.i(this.a, "receive finish msg ignore old backend data");
    L147:
        ReadOnlyProperty r29 = vm2.h.M4;
        KProperty[] r30 = vm2.h.a;
        if (((Boolean) r29.getValue(null, r30[297(0x129, float:4.16E-43)])).booleanValue() == true) goto L150;
    L154:
        com.bytedance.android.livesdk.chatroom.u r31 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r31 == null) goto L160;
        com.bytedance.live.datacontext.m r32 = r31.A();
        if (r32 == null) goto L160;
        if (((Boolean) r32.getValue()).booleanValue() != true) goto L160;
    L166:
        r4 = true;
    L167:
        I(!r4, "interactiveModeStart");
        this.G = true;
        if (vm2.d.q0().isDisableWRDSWhenEnterRoom() == true) goto L179;
        LinkMicRoomDataSyncModel r1 = LinkWRDSHelper.b();
        if (r1 == null) goto L179;
        dc2.c r33 = r1.getTalkRoomListUserInfoPb();
        if (r33 == null) goto L179;
        Observable r34 = r33.d;
        if (r34 == null) goto L179;
        Disposable r35 = r34.subscribe(new z(this));
        if (r35 == null) goto L179;
        this.o.add(r35);
    L179:
        if (((Boolean) KtvSettingHelper.m1.getValue()).booleanValue() == false) goto L190;
        IMiddlewareUserService r36 = jc1.k.f(IMiddlewareUserService.class);
        if (r36 == null) goto L191;
        com.bytedance.android.livesdk.user.e r37 = r36.user();
        if (r37 == null) goto L192;
        Observable r38 = r37.u();
        if (r38 == null) goto L193;
        Disposable r39 = r38.subscribe(new b(this));
        if (r39 == null) goto L194;
        RxUtilKt.c(r39, this.o);
        return;
    L194:
        return;
    L193:
        return;
    L192:
        return;
    L191:
        return;
    L190:
        return;
    L160:
        com.bytedance.android.livesdk.chatroom.u r40 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r40 == null) goto L167;
        com.bytedance.live.datacontext.m r41 = r40.k();
        if (r41 == null) goto L167;
        if (((Boolean) r41.getValue()).booleanValue() != true) goto L167;
    L150:
        if (((Boolean) vm2.h.N4.getValue(null, r30[298(0x12a, float:4.18E-43)])).booleanValue() == false) goto L152;
    L153:
        y(0, 3000);
        goto L154
    L152:
        if (je0.d.r() == true) goto L154;
    L107:
        r28 = null;
    L111:
        final long r125 = System.currentTimeMillis();
        MultiLinkLoadWidgetUtils.n(this.N, "LinkUserInfoCenterV2", "call getListV2FromBackendApi");
        final Ref.ObjectRef r42 = new Ref.ObjectRef();
        r42.element = "";
        DataCenter r43 = this.N;
        IRoom r126 = this.M;
        if (r126 == null) goto L114;
        Long r127 = Long.valueOf(r126.getId());
    L115:
        com.bytedance.android.livesdk.chatroom.u r44 = com.bytedance.android.live.liveinteract.api.utils.m.f(r43, Long.valueOf(r127.longValue()));
        if (r44 == null) goto L120;
        com.bytedance.live.datacontext.n r45 = r44.x();
        if (r45 == null) goto L120;
        Object r46 = r45.getValue();
    L122:
        if ((r46 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L124;
        r46 = null;
    L124:
        MultiSceneEnterRoomStatisticsUtils r47 = (MultiSceneEnterRoomStatisticsUtils) r46;
        if (r47 != null) goto L127;
    L130:
        IRoomModuleService r48 = jc1.k.f(IRoomModuleService.class);
        if (r48 == null) goto L135;
        com.bytedance.android.livesdk.chatroom.room.backend.g r49 = r48.getLiveRoomBackendUtils();
        if (r49 == null) goto L135;
        r49.f(this.M.getId(), u0.class, new LinkUserInfoCenterV2$getListV2FromBackend$2(this, r125));
    L135:
        IRoomModuleService r50 = jc1.k.f(IRoomModuleService.class);
        if (r50 == null) goto L147;
        com.bytedance.android.livesdk.chatroom.room.backend.g r128 = r50.getLiveRoomBackendUtils();
        if (r128 == null) goto L147;
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r128, this.M.getId(), null, w0.class, new LinkUserInfoCenterV2$getListV2FromBackend$3(this, r125, r42), null, new LinkUserInfoCenterV2$getListV2FromBackend$4(this, r125, r42), null, null, this.o, false, true, 2640);
        goto L147
    L127:
        if (r47.a != 1) goto L129;
        r5 = "click";
    L129:
        r42.element = r5;
    L120:
        r46 = null;
        goto L122
    L114:
        r127 = null;
        goto L115
    L141:
        if (vm2.d.q0().isDisableWRDSWhenEnterRoom() == false) goto L144;
        R4(true);
        goto L147
    L144:
        if (vm2.e.i() == false) goto L146;
        H();
        goto L147
    L146:
        R4(true);
        goto L147
    L5:
        if (this.L == false) goto L8;
        ALogger.i(this.a, "repeat attach");
    }

    public final void l() {
        ALogger.i(this.a, "LinkUserInfoCenterV2=" + hashCode() + " detach");
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L7;
        this.m = false;
        vlc.d r0 = this.j;
        if (r0 == null) goto L12;
        r0.removeMessageListener(this);
    L12:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L15;
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.clear();
        this.i.clear();
        ((ArrayList) this.n).clear();
        return;
    L15:
        return;
    L7:
        this.o.clear();
        this.c.clear();
        ((ArrayList) this.n).clear();
        ((HashMap) this.p).clear();
        this.m = false;
        vlc.d r1 = this.j;
        if (r1 == null) goto L10;
        r1.removeMessageListener(this);
    L10:
        ((LinkedHashMap) this.E).clear();
        ((ArrayList) this.D).clear();
        this.L = false;
        goto L12
    }

    public final int n() {
        CopyOnWriteArrayList<LinkmicPositionItem> r0 = this.e;
        int r2 = 0;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        if ((!TextUtils.isEmpty(((LinkmicPositionItem) r1.next()).getActiveName())) == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        return r2;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final int q() {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((LinkmicPositionItem) r1).getPositionType() != LinkmicPositionItem.LinkmicPositionType.PERFORMER.ordinal()) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        LinkmicPositionItem r3 = (LinkmicPositionItem) r1;
        if (r3 != null) goto L22;
        return -1;
    L22:
        return (int) r3.getPosition();
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final void r0() {
        gm2.i r0 = new gm2.i();
        r0.type = 100102;
        String r2 = jc1.k.n(IMiddlewareUserService.class).user().n();
        r0.senderUserId = r2.toString();
        r0.senderInteractIdStr = tc0.c.h().f;
        r0.targetUserId = "0";
        r0.targetInteractId = "0";
        r0.targetInteractIdStr = "0";
        HashMap r3 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("shouldUpdateAllGuestActiveStatus", "1")});
        if (je0.d.N() == true) goto L5;
    L9:
        String r4 = "";
    L10:
        String r9 = r4;
        ALogger.w(this.a, "sendSignalV1 onEnterForeground " + r9);
        long r10 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.S(100102);
        this.o.add(RxCompatKt.b(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).sendSignalV1(this.M.getId(), GsonProtectorUtils.toJson(GsonHelper.get(), r0), null, null, r9).toObservable(), new com.bytedance.android.live.core.utils.rxutils.l(5, 3000)).subscribeOn(Schedulers.io()).subscribe(new g(r10, r0), new h(this, r10, r0)));
        return;
    L5:
        if (Intrinsics.areEqual(r2, this.M.getOwnerUserIdString()) == false) goto L9;
        if (h() == false) goto L9;
        r4 = JsonUtil.toJSONString(r3);
        goto L10
    }

    public final boolean u() {
        Integer r0 = this.F;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L7:
        if (r1 > this.c.size()) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = -1;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final void v() {
        gm2.i r0 = new gm2.i();
        r0.type = 100101;
        String r2 = jc1.k.n(IMiddlewareUserService.class).user().n();
        r0.senderUserId = r2.toString();
        r0.senderInteractIdStr = tc0.c.h().f;
        r0.targetUserId = "0";
        r0.targetInteractId = "0";
        r0.targetInteractIdStr = "0";
        HashMap r3 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("shouldUpdateAllGuestActiveStatus", "1")});
        if (je0.d.N() == true) goto L5;
    L9:
        String r4 = "";
    L10:
        String r9 = r4;
        ALogger.w(this.a, "sendSignalV1 onEnterBackground " + r9);
        long r10 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.S(100101);
        this.o.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).sendSignalV1(this.M.getId(), GsonProtectorUtils.toJson(GsonHelper.get(), r0), null, null, r9).subscribeOn(Schedulers.io()).subscribe(new e(r10, r0), new f(this, r10, r0)));
        return;
    L5:
        if (Intrinsics.areEqual(r2, this.M.getOwnerUserIdString()) == false) goto L9;
        if (h() == false) goto L9;
        r4 = JsonUtil.toJSONString(r3);
        goto L10
    }

    public final void H() {
        long r0 = System.currentTimeMillis();
        CompositeDisposable r2 = this.o;
        LinkMicRoomDataSyncModel r3 = LinkWRDSHelper.b();
        long r4 = System.currentTimeMillis();
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = (w0) vh7.f.c(w0.class);
        r2.add(Single.create(new com.bytedance.android.live.liveinteract.wrds.d(r3, r4, r6)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a0(this), new b0(this, r0)));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final /* bridge */ /* synthetic */ Boolean Z4() {
        return Boolean.valueOf(u());
    }

    public final void m() {
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L6;
        this.o.clear();
        this.c.clear();
        ((ArrayList) this.n).clear();
        ((HashMap) this.p).clear();
        ((LinkedHashMap) this.E).clear();
        ((ArrayList) this.D).clear();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final List<ILinkPlayerInfoBridge> a() {
        return this.f;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final List<ILinkPlayerInfoBridge> c() {
        return this.d;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final List<LinkmicPositionItem> d() {
        return this.e;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final long getLastVersion() {
        return this.t;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final List<ILinkPlayerInfoBridge> getOnlineUserList() {
        return this.c;
    }

    public static void F(List r4) {
        if (r4 == null) goto L9;
        Iterator r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L15;
        LinkmicPositionItem r0 = (LinkmicPositionItem) r5.next();
        if (r0.getPositionType() != LinkmicPositionItem.LinkmicPositionType.PERFORMER.ordinal()) goto L5;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.c.a("performerPosition", "ThemedCompetitionStatus = " + ThemedCompetitionContext.Companion.g() + ", performer position = " + r0.getPosition());
        goto L5
    L15:
        return;
    }

    public static void J(List r4) {
        ILinkPlayerInfoBridge r0 = null;
        Object r1 = null;
        if (r4 == null) goto L15;
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L14;
        Object r2 = r5.next();
        IBaseUser r3 = ((ILinkPlayerInfoBridge) r2).getUser();
        if (r3 == null) goto L10;
        String r6 = r3.getIdString();
    L12:
        if (Intrinsics.areEqual(r6, gh0.a.c()) == false) goto L6;
        r1 = r2;
        goto L14
    L10:
        r6 = null;
    L14:
        r0 = (ILinkPlayerInfoBridge) r1;
    L15:
        if (r0 == null) goto L23;
        String r7 = r0.getLinkMicUniqueIdStr();
        if (r7 == null) goto L24;
        tc0.c.h().w = r7;
        return;
    L24:
        return;
    }

    public static final void g(y r5) {
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r0 = r5.g;
        ArrayList r1 = new ArrayList();
        Iterator<ILinkPlayerInfoBridge> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ILinkPlayerInfoBridge r3 = r2.next();
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r4 = r5.f;
        if (k(r4, r3) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r5.g.clear();
        r5.g.addAll(r1);
    }

    public final void E(com.bytedance.android.livesdk.link.model.bridge.i0 r11) {
        Intrinsics.checkNotNullParameter(r11, "result");
        Intrinsics.checkNotNullParameter(r11, "$this$toEnterContent");
        f1 r0 = vh7.f.c(f1.class);
        r0.setApplyType(r11.getApplyType());
        r0.setCityEffect(r11.getICityEffect());
        r0.setMatchEffect(r11.getIMatchEffect());
        r0.setLinkUsers(r11.getLinkedUsers());
        r0.setUserIdString(je0.d.b0());
        r0.setVersion(r11.getVersion());
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1 = r11.getLinkedUsers();
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r2 = r1;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L34;
        Object r4 = null;
        if (((Boolean) vm2.d.u8.getValue(null, vm2.d.a[485(0x1e5, float:6.8E-43)])).booleanValue() == false) goto L25;
        Iterator<T> r5 = r1.iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.link.model.bridge.k) r6).getInteractId(), tc0.c.h().f) == false) goto L14;
        r4 = r6;
    L18:
        com.bytedance.android.livesdk.link.model.bridge.k r7 = (com.bytedance.android.livesdk.link.model.bridge.k) r4;
        if (r7 == null) goto L25;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L25;
        if (r8.isAnonymous() != true) goto L25;
        this.N.put("cmd_self_join_channel_anonymous", r7);
    L25:
        O(r0, r1);
        boolean r9 = R(r1, r11.getClientUIInfo(), r11.getVersion(), "joinChannel");
        N(r1, true);
        if (r9 == false) goto L32;
        this.s = new a(System.currentTimeMillis(), "joinChannel", "", null);
        ALogger.w(this.a, "refreshList from=joinChannel version=" + r11.getVersion() + " onOnlineListChanged callback");
        Iterator r12 = ((ArrayList) this.n).iterator();
    L29:
        if (r12.hasNext() == false) goto L31;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r12.next()).onOnlineListChanged(this.c);
        goto L29
    L31:
        J(this.c);
        tc0.c.h().v = b();
        return;
    L32:
        ALogger.e(this.a, "list not updated, from=joinChannel version=" + r11.getVersion() + " current=" + this.t);
        return;
    L34:
        ALogger.e(this.a, "onSelfJoinChannel user list is empty! " + r0);
        return;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public final void K(l6 r3) {
        if (r3 == null) goto L16;
        List r4 = r3.getMLinkUsers();
        if (r4 == null) goto L17;
        List r5 = CollectionsKt.toMutableList(r4);
        if (r5 == null) goto L18;
        ArrayList<ILinkPlayerInfoBridge> r6 = je0.d.f0(r5, true);
        this.c.addAll(r6);
        if (((Boolean) vm2.d.s8.getValue(null, vm2.d.a[483(0x1e3, float:6.77E-43)])).booleanValue() == false) goto L19;
        Iterator r7 = ((ArrayList) this.n).iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r7.next()).onOnlineListChanged(this.c);
        goto L11
    L13:
        J(this.c);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void M(int r7) {
        if (r7 >= 0) goto L5;
        r7 = 0;
    L5:
        Iterator<T> r1 = this.e.iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        if (((int) ((LinkmicPositionItem) r2).getPosition()) != r7) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L7;
    L15:
        LinkmicPositionItem r3 = (LinkmicPositionItem) r2;
        if (r3 != null) goto L18;
        LinkmicPositionItem r0 = (LinkmicPositionItem) vh7.f.c(LinkmicPositionItem.class);
        r0.setVerifyStatus(1);
        r0.setPosition(r7);
        this.e.add(r0);
    L19:
        Iterator r8 = ((ArrayList) this.n).iterator();
    L21:
        if (r8.hasNext() == false) goto L23;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r8.next()).e(this.e);
        goto L21
    L23:
        return;
    L18:
        r3.setVerifyStatus(1);
        goto L19
    L11:
        r4 = false;
        goto L12
    L14:
        r2 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final String N4(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        ILinkPlayerInfoBridge r4 = o(r3, "");
        if (r4 != null) goto L5;
        return "";
    L5:
        if (r4.getUser() == null) goto L13;
        String r5 = r4.getInteractId();
        if (r5 != null) goto L11;
        return "";
    L11:
        return r5;
    L13:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final int O4(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        Iterator<T> r0 = this.c.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        IBaseUser r3 = ((ILinkPlayerInfoBridge) r1).getUser();
        if (r3 == null) goto L9;
        r2 = r3.getIdString();
    L9:
        if (Intrinsics.areEqual(r2, r5) == false) goto L3;
        r2 = r1;
    L11:
        ILinkPlayerInfoBridge r4 = (ILinkPlayerInfoBridge) r2;
        if (r4 != null) goto L19;
        return -1;
    L19:
        return r4.getUserPosition();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final int P4(int r5) {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((int) ((LinkmicPositionItem) r1).getPosition()) != r5) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        LinkmicPositionItem r3 = (LinkmicPositionItem) r1;
        if (r3 == null) goto L16;
        return r3.getStatus();
    L16:
        return LinkmicPositionItem.LinkmicPositionStatus.NORMAL.ordinal();
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final void Q4(com.bytedance.android.live.liveinteract.plantform.base.i.b<ILinkPlayerInfoBridge> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.n).add(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final void R4(boolean r12) {
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        long r0 = System.currentTimeMillis();
        Set<Long> r2 = InteractLinkFullLinkMonitor.a;
        JSONObject r9 = new JSONObject();
        nd0.c.s(nd0.c.a, LinkMonitorData.StartListV2, null, 0, "", r9, 98);
        this.o.add(((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getLinkListV2(this.M.getId(), d5.c(this.M.getOwnerUserIdString()), this.M.getOwnerUserIdString()).subscribeOn(Schedulers.io()).flatMap(new i(this, r12)).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r0, r12), new k(this, r0)));
    }

    public final void S(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L5:
        boolean r2 = false;
        if (r10.hasNext() == false) goto L8;
        r0.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r10.next(), false));
        goto L5
    L8:
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r11 = this.i;
        if (r11.size() != r0.size()) goto L39;
        Iterator<ILinkPlayerInfoBridge> r12 = r11.iterator();
        Iterator r1 = r0.iterator();
    L12:
        if (r12.hasNext() == false) goto L37;
        if (r1.hasNext() == false) goto L37;
        ILinkPlayerInfoBridge r3 = r12.next();
        ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) r1.next();
        if (r3.getUser() != null) goto L21;
        if (r6.getUser() != null) goto L21;
        boolean r4 = true;
    L35:
        if (r4 == true) goto L12;
        boolean r13 = false;
    L38:
        boolean r14 = !r13;
    L40:
        if (r14 == false) goto L66;
        this.i.clear();
        this.i.addAll(r0);
        String r15 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Iterator<ILinkPlayerInfoBridge> r5 = this.i.iterator();
    L43:
        if (r5.hasNext() == false) goto L52;
        IBaseUser r7 = r5.next().getUser();
        if (r7 == null) goto L47;
        String r8 = r7.getIdString();
    L49:
        if (Intrinsics.areEqual(r8, r15) == false) goto L43;
        r2 = true;
        goto L52
    L47:
        r8 = null;
    L52:
        if ((!Intrinsics.areEqual((Boolean) hd0.c.f().h.getValue(), Boolean.valueOf(r2))) == false) goto L67;
        hd0.c.f().h.setValue(Boolean.valueOf(r2));
        return;
    L67:
        return;
    L66:
        return;
    L21:
        if (r3.getUser() != null) goto L23;
    L34:
        r4 = false;
        goto L35
    L23:
        if (r6.getUser() == null) goto L34;
        IBaseUser r16 = r3.getUser();
        if (r16 == null) goto L28;
        String r17 = r16.getIdString();
    L29:
        IBaseUser r18 = r6.getUser();
        if (r18 == null) goto L32;
        String r19 = r18.getIdString();
    L33:
        r4 = Intrinsics.areEqual(r17, r19);
        goto L35
    L32:
        r19 = null;
        goto L33
    L28:
        r17 = null;
    L37:
        r13 = true;
        goto L38
    L39:
        r14 = true;
        goto L40
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final void T4(com.bytedance.android.live.liveinteract.plantform.base.i.b<ILinkPlayerInfoBridge> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.n).remove(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final IBaseUser U4(String r5) {
        Iterator<ILinkPlayerInfoBridge> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        ILinkPlayerInfoBridge r1 = r0.next();
        if (r1 == null) goto L8;
        String r3 = r1.getInteractId();
    L10:
        if (Intrinsics.areEqual(r3, r5) == false) goto L4;
        if (r1 != null) goto L13;
        return null;
    L13:
        return r1.getUser();
    L8:
        r3 = null;
        goto L10
    L14:
        Iterator<ILinkPlayerInfoBridge> r2 = this.d.iterator();
    L16:
        if (r2.hasNext() == false) goto L26;
        ILinkPlayerInfoBridge r4 = r2.next();
        if (r4 == null) goto L20;
        String r6 = r4.getInteractId();
    L22:
        if (Intrinsics.areEqual(r6, r5) == false) goto L16;
        if (r4 != null) goto L25;
        return null;
    L25:
        return r4.getUser();
    L20:
        r6 = null;
        goto L22
    L26:
        Iterator<ILinkPlayerInfoBridge> r7 = this.f.iterator();
    L28:
        if (r7.hasNext() == false) goto L38;
        ILinkPlayerInfoBridge r8 = r7.next();
        if (r8 == null) goto L32;
        String r9 = r8.getInteractId();
    L34:
        if (Intrinsics.areEqual(r9, r5) == false) goto L28;
        if (r8 != null) goto L37;
        return null;
    L37:
        return r8.getUser();
    L32:
        r9 = null;
        goto L34
    L38:
        Iterator<ILinkPlayerInfoBridge> r10 = this.h.iterator();
    L40:
        if (r10.hasNext() == false) goto L66;
        ILinkPlayerInfoBridge r11 = r10.next();
        if (r11 == null) goto L44;
        String r12 = r11.getInteractId();
    L46:
        if (Intrinsics.areEqual(r12, r5) == false) goto L40;
        if (r11 != null) goto L49;
        return null;
    L49:
        return r11.getUser();
    L44:
        r12 = null;
        goto L46
    L66:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final boolean b5(String r5) {
        Intrinsics.checkNotNullParameter(r5, "targetUserId");
        Iterator<ILinkPlayerInfoBridge> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L24;
        ILinkPlayerInfoBridge r1 = r0.next();
        if (r1.getUser() == null) goto L4;
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L10;
        String r4 = r3.getIdString();
    L12:
        if (Intrinsics.areEqual(r4, r5) == false) goto L4;
        if (r1.getSilenceStatus() == 0) goto L23;
        return true;
    L23:
        return false;
    L10:
        r4 = null;
        goto L12
    L24:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final IBaseUser c5(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        Iterator<ILinkPlayerInfoBridge> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        ILinkPlayerInfoBridge r1 = r0.next();
        if (r1 == null) goto L10;
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L10;
        String r4 = r3.getIdString();
    L12:
        if (Intrinsics.areEqual(r4, r5) == false) goto L4;
        if (r1 != null) goto L15;
        return null;
    L15:
        return r1.getUser();
    L10:
        r4 = null;
        goto L12
    L16:
        Iterator<ILinkPlayerInfoBridge> r2 = this.f.iterator();
    L18:
        if (r2.hasNext() == false) goto L30;
        ILinkPlayerInfoBridge r6 = r2.next();
        if (r6 == null) goto L24;
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L24;
        String r8 = r7.getIdString();
    L26:
        if (Intrinsics.areEqual(r8, r5) == false) goto L18;
        if (r6 != null) goto L29;
        return null;
    L29:
        return r6.getUser();
    L24:
        r8 = null;
        goto L26
    L30:
        Iterator<ILinkPlayerInfoBridge> r9 = this.h.iterator();
    L32:
        if (r9.hasNext() == false) goto L44;
        ILinkPlayerInfoBridge r10 = r9.next();
        if (r10 == null) goto L38;
        IBaseUser r11 = r10.getUser();
        if (r11 == null) goto L38;
        String r12 = r11.getIdString();
    L40:
        if (Intrinsics.areEqual(r12, r5) == false) goto L32;
        if (r10 != null) goto L43;
        return null;
    L43:
        return r10.getUser();
    L38:
        r12 = null;
        goto L40
    L44:
        Iterator<ILinkPlayerInfoBridge> r13 = this.i.iterator();
    L46:
        if (r13.hasNext() == false) goto L57;
        ILinkPlayerInfoBridge r14 = r13.next();
        if (r14 == null) goto L52;
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L52;
        String r16 = r15.getIdString();
    L54:
        if (Intrinsics.areEqual(r16, r5) == false) goto L46;
        return r14.getUser();
    L52:
        r16 = null;
        goto L54
    L57:
        return null;
    }

    public final void j(RoomLinkMicSyncData r9) {
        int r0 = t0.a;
        t0.a(this.a, "[InnerWRDSPreloadV2]roomId=" + this.M.getId() + ", get preload wrds data, wrds=" + r9);
        if (r9 == null) goto L62;
        List r1 = r9.mLinkUsers;
        if (r1 == null) goto L7;
        ArrayList<ILinkPlayerInfoBridge> r2 = je0.d.f0(r1, true);
    L8:
        List<LinkmicPositionItem> r3 = r9.positions;
        Iterator<T> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        G((ILinkPlayerInfoBridge) r4.next(), r9.clientUIInfo);
        goto L10
    L12:
        Map r5 = r9.linkerContentMap;
        if (r5 == null) goto L15;
        int r6 = r5.size();
    L16:
        Integer r7 = null;
        if (r6 <= 1) goto L32;
        Map r8 = r9.linkerContentMap;
        if (r8 == null) goto L41;
        Collection r10 = r8.values();
        if (r10 == null) goto L41;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L24:
        if (r12.hasNext() == false) goto L31;
        RoomLinkerContent r13 = (RoomLinkerContent) r12.next();
        if (r13 == null) goto L29;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r14 = r13.linkedUsers;
        if (r14 == null) goto L29;
    L30:
        CollectionsKt.addAll(r11, r14);
    L29:
        r14 = CollectionsKt.emptyList();
        goto L30
    L31:
        ArrayList<ILinkPlayerInfoBridge> r15 = je0.d.f0(r11, true);
    L42:
        if (r15 == null) goto L47;
        Iterator<T> r16 = r15.iterator();
    L45:
        if (r16.hasNext() == false) goto L47;
        G((ILinkPlayerInfoBridge) r16.next(), r9.clientUIInfo);
    L47:
        int r17 = t0.a;
        String r18 = this.a;
        StringBuilder r19 = new StringBuilder("[InnerWRDSPreloadV2]roomId=");
        r19.append(this.M.getId());
        r19.append(", get preload wrds data, onlineListSize=");
        r19.append(r2.size());
        r19.append(", lockPositionListSize=");
        if (r3 == null) goto L50;
        Integer r20 = Integer.valueOf(r3.size());
    L51:
        r19.append(r20);
        r19.append(", peerOnlineListSize=");
        if (r15 == null) goto L54;
        r7 = Integer.valueOf(r15.size());
    L54:
        r19.append(r7);
        t0.a(r18, r19.toString());
        Iterator r21 = ((ArrayList) this.n).iterator();
    L56:
        if (r21.hasNext() == false) goto L71;
        com.bytedance.android.live.liveinteract.plantform.base.i.b r22 = (com.bytedance.android.live.liveinteract.plantform.base.i.b) r21.next();
        r22.e(r3);
        r22.onOnlineListChanged(r2);
        if (r15 == null) goto L60;
        List r23 = r15;
    L61:
        r22.d(r2, r23);
        goto L56
    L60:
        r23 = CollectionsKt.emptyList();
        goto L61
    L71:
        return;
    L50:
        r20 = null;
    L41:
        r15 = null;
        goto L42
    L32:
        Map r24 = r9.linkerContentMap;
        if (r24 == null) goto L41;
        Map.Entry r25 = z0.a(r24);
        if (r25 == null) goto L41;
        RoomLinkerContent r26 = (RoomLinkerContent) r25.getValue();
        if (r26 == null) goto L41;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r27 = r26.linkedUsers;
        if (r27 == null) goto L41;
        r15 = je0.d.f0(r27, true);
        goto L42
    L15:
        r6 = 0;
        goto L16
    L7:
        r2 = new ArrayList();
        goto L8
    }

    public final void onMessage(tlc.d r20) {
        Intrinsics.checkNotNullParameter(r20, MultiLinkOpenSource.MESSAGE);
        if (this.m == true) goto L5;
        return;
    L5:
        boolean r3 = true;
        List<LinkmicPositionItem> r10 = null;
        Long r11 = null;
        if ((r20 instanceof com.bytedance.android.livesdk.link.model.bridge.z0) == false) goto L60;
        com.bytedance.android.livesdk.link.model.bridge.z0 r0 = (com.bytedance.android.livesdk.link.model.bridge.z0) r20;
        com.bytedance.android.live.liveinteract.plantform.model.q r1 = r0.getLinkerBaseInfo();
        if (r1 == null) goto L18;
        Integer r2 = Integer.valueOf(r1.getMaxMemberCount());
        if (r2.intValue() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        this.F = Integer.valueOf(r2.intValue());
        goto L18
    L12:
        r4 = false;
    L18:
        String r5 = this.a;
        StringBuilder r6 = new StringBuilder("receive LinkmicMessage update currentMaxMemberCount=");
        com.bytedance.android.live.liveinteract.plantform.model.q r12 = r0.getLinkerBaseInfo();
        if (r12 == null) goto L21;
        Integer r13 = Integer.valueOf(r12.getMaxMemberCount());
    L22:
        r6.append(r13);
        ALogger.i(r5, r6.toString());
        int r7 = (int) r0.getType2();
        if (r7 == 5) goto L55;
        if (r7 == 6) goto L53;
        if (r7 == 7) goto L45;
        if (r7 == 10) goto L42;
        if (r7 == 11) goto L39;
        if (r7 == 16) goto L36;
        if (r7 != 17) goto L476;
        Q(r0.getLockedPositions(), true, true);
        return;
    L476:
        return;
    L36:
        if (vm2.c.f() == false) goto L452;
        R4(false);
        return;
    L452:
        return;
    L39:
        if (vm2.c.f() == false) goto L454;
        R4(false);
        return;
    L454:
        return;
    L42:
        if (vm2.c.f() == false) goto L456;
        R4(false);
        return;
    L456:
        return;
    L45:
        if (vm2.c.f() == true) goto L47;
        return;
    L47:
        if (je0.d.Y() == false) goto L49;
    L50:
        I(false, "messageOldLinkAndWaitingListChange");
    L51:
        R4(false);
        return;
    L49:
        if (this.q.booleanValue() == false) goto L51;
    L53:
        if (vm2.c.f() == false) goto L460;
        R4(false);
        return;
    L460:
        return;
    L55:
        com.bytedance.android.live.liveinteract.multianchor.model.b r8 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r0.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        Set<Long> r9 = InteractLinkFullLinkMonitor.a;
        JSONObject r14 = new JSONObject();
        if (r8 == null) goto L58;
        Intrinsics.checkNotNullParameter(r8, "$this$messageIdExt");
        r11 = Long.valueOf(r8.getMessageId2());
    L58:
        r14.put("msg_id", r11);
        nd0.c.o(nd0.c.a, LinkMonitorData.WaitingListMessage, r14, 0, null, false, 28);
        I(false, "messageWaitingListChange");
        return;
    L21:
        r13 = null;
        goto L22
    L60:
        if ((r20 instanceof h1) == false) goto L190;
        h1 r15 = (h1) r20;
        ILinkerUpdateUserContent r16 = r15.getMUpdateUser();
        if (r16 == null) goto L64;
        List r17 = r16.getMLinkUsers();
    L65:
        StringBuilder r18 = new StringBuilder("type:");
        r18.append(r15.getMType());
        r18.append("----");
        r18.append(r15.getMChangePlayModeContent());
        r18.append("---");
        if (r17 == null) goto L68;
        Integer r19 = Integer.valueOf(r17.size());
    L69:
        r18.append(r19);
        r18.append("--");
        if (r17 == null) goto L90;
        Iterator r21 = r17.iterator();
    L73:
        if (r21.hasNext() == false) goto L86;
        Object r22 = r21.next();
        com.bytedance.android.livesdk.link.model.bridge.k r110 = (com.bytedance.android.livesdk.link.model.bridge.k) r22;
        if (r110 == null) goto L83;
        k1 r111 = r110.getContent();
        if (r111 == null) goto L83;
        l1 r112 = r111.getLinkMicAudienceContent();
        if (r112 == null) goto L83;
        if (r112.isEnlarged() != true) goto L83;
        boolean r113 = true;
    L84:
        if (r113 == false) goto L73;
    L88:
        if (((com.bytedance.android.livesdk.link.model.bridge.k) r22) == null) goto L90;
        String r23 = "large";
    L91:
        r18.append(r23);
        ALogger.i("centerV2Link", r18.toString());
        com.bytedance.android.live.liveinteract.plantform.model.q r24 = r15.getLinkerBaseInfo();
        if (r24 == null) goto L102;
        Integer r25 = Integer.valueOf(r24.getMaxMemberCount());
        if (r25.intValue() <= 0) goto L96;
        boolean r26 = true;
    L97:
        if (r26 == true) goto L100;
        r25 = null;
    L100:
        if (r25 == null) goto L102;
        this.F = Integer.valueOf(r25.intValue());
        goto L102
    L96:
        r26 = false;
    L102:
        String r27 = this.a;
        StringBuilder r28 = new StringBuilder("receive LinkerMessage update currentMaxMemberCount=");
        com.bytedance.android.live.liveinteract.plantform.model.q r29 = r15.getLinkerBaseInfo();
        if (r29 == null) goto L105;
        Integer r30 = Integer.valueOf(r29.getMaxMemberCount());
    L106:
        r28.append(r30);
        ALogger.i(r27, r28.toString());
        if (vm2.c.f() == false) goto L110;
        return;
    L110:
        if (this.r.contains(Integer.valueOf((int) r15.getScene())) == true) goto L112;
        return;
    L112:
        ILinkerLinkedListChangeContent r31 = r15.getMLinkedListChange();
        if (r31 != null) goto L115;
    L117:
        boolean r32 = false;
    L118:
        if (r32 == false) goto L121;
        t(r15);
        return;
    L121:
        Set<Integer> r33 = LinkWRDSHelper.a;
        Intrinsics.checkNotNullParameter(r15, MultiLinkOpenSource.MESSAGE);
        Set<Integer> r34 = LinkWRDSHelper.a;
        if (((IMultiCommonService) jc1.k.n(IMultiCommonService.class)).checkCommonSetting(LinkWRDSHelper.b) == true) goto L125;
    L126:
        boolean r35 = false;
    L128:
        if (r35 == true) goto L131;
    L132:
        r3 = false;
    L133:
        if (r3 == false) goto L188;
        int r36 = r15.getMType();
        long r37 = 0;
        if (r36 == 6) goto L161;
        if (r36 == 7) goto L158;
        if (r36 != 11) goto L139;
        Long r38 = Long.valueOf(r15.getMLinkedListChange().getVersion());
    L165:
        if (r38 != null) goto L168;
    L170:
        Disposable r39 = this.B;
        if (r39 != null) goto L173;
    L181:
        this.C = r15;
        LinkMicRoomDataSyncModel r40 = LinkWRDSHelper.b();
        if (r40 != null) goto L184;
        t(r15);
        return;
    L184:
        long r41 = System.currentTimeMillis();
        dc2.c r42 = r40.getTalkRoomListUserInfoPb();
        if (r38 == null) goto L187;
        r37 = r38.longValue();
    L187:
        Long r43 = r38;
        this.B = r42.d(r37, LinkWRDSHelper.c()).take(1).subscribe(new e0(this, r15, r43, r41), new f0(this, r15, r43, r41));
        return;
    L173:
        if (r39.isDisposed() == true) goto L181;
        r39.dispose();
        h1 r114 = this.C;
        if (r114 == null) goto L181;
        t(r114);
        TalkRoomBusinessFullLinkMonitor r44 = TalkRoomBusinessFullLinkMonitor.a;
        if (r38 == null) goto L179;
        long r115 = r38.longValue();
    L180:
        TalkRoomBusinessFullLinkMonitor.WrdsStatusType r116 = TalkRoomBusinessFullLinkMonitor.WrdsStatusType.BackLog;
        r44.getClass();
        TalkRoomBusinessFullLinkMonitor.A0(r114, r115, 0, r116);
        goto L181
    L179:
        r115 = 0;
        goto L180
    L168:
        if (r38.longValue() != 0) goto L170;
        t(r15);
        TalkRoomBusinessFullLinkMonitor r45 = TalkRoomBusinessFullLinkMonitor.a;
        long r117 = r38.longValue();
        TalkRoomBusinessFullLinkMonitor.WrdsStatusType r118 = TalkRoomBusinessFullLinkMonitor.WrdsStatusType.Exception;
        r45.getClass();
        TalkRoomBusinessFullLinkMonitor.A0(r15, r117, 0, r118);
        return;
    L139:
        if (r36 != 12) goto L141;
        ILinkerUpdateUserContent r46 = r15.getMUpdateUser();
        if (r46 == null) goto L164;
        r38 = Long.valueOf(r46.getVersion());
    L164:
        r38 = null;
        goto L165
    L141:
        if (r36 == 33) goto L147;
        if (r36 == 41) goto L144;
        r38 = 0L;
        goto L165
    L144:
        com.bytedance.android.live.base.model.data.i r47 = r15.getLinkerCrossRoomUpdateContentExt();
        if (r47 == null) goto L164;
        r38 = Long.valueOf(r47.getVersion());
        goto L165
    L147:
        com.bytedance.android.livesdk.message.linker.d r48 = r15.getMChangePlayModeContent();
        if (r48 == null) goto L152;
        com.bytedance.android.livesdk.message.linker.c r49 = r48.getChangePlayModeData();
        if (r49 == null) goto L152;
        long r50 = r49.getVersion();
    L153:
        r38 = Long.valueOf(r50);
    L152:
        r50 = 0;
        goto L153
    L158:
        ILinkerLeaveContentBridge r51 = r15.getLeave();
        if (r51 == null) goto L164;
        r38 = Long.valueOf(r51.getVersion());
        goto L165
    L161:
        f1 r52 = r15.getEnter();
        if (r52 == null) goto L164;
        r38 = Long.valueOf(r52.getVersion());
        goto L165
    L188:
        t(r15);
        return;
    L131:
        if (LinkWRDSHelper.a.contains(Integer.valueOf((int) r15.getType2())) == true) goto L133;
    L125:
        if (((Boolean) vm2.d.o8.getValue(null, vm2.d.a[479(0x1df, float:6.71E-43)])).booleanValue() == false) goto L126;
        r35 = true;
        goto L128
    L115:
        if (r31.getUpdateMode() != 1) goto L117;
        r32 = true;
        goto L118
    L105:
        r30 = null;
    L83:
        r113 = false;
        goto L84
    L86:
        r22 = null;
    L90:
        r23 = null;
        goto L91
    L68:
        r19 = null;
        goto L69
    L64:
        r17 = null;
        goto L65
    L190:
        if ((r20 instanceof c1) == false) goto L222;
        gm2.i r53 = ((c1) r20).getLinkMicSignalFlex();
        if (r53 != null) goto L195;
        return;
    L195:
        if (TextUtils.isEmpty(r53.senderInteractId) == true) goto L197;
    L401:
        String r54 = r53.senderUserId;     // Catch: NumberFormatException -> L219
        String r55 = r53.senderInteractId;     // Catch: NumberFormatException -> L219
        if (TextUtils.isEmpty(r53.senderInteractIdStr) == true) goto L203;
        r55 = r53.senderInteractIdStr;     // Catch: NumberFormatException -> L219
    L203:
        int r56 = r53.type;     // Catch: NumberFormatException -> L219
        switch(r56) {
            case 100101: goto L211;
            case 100102: goto L211;
            case 101002: goto L206;
            default: goto L467;
        };     // Catch: NumberFormatException -> L219
    L206:
        Iterator r57 = ((ArrayList) this.n).iterator();     // Catch: NumberFormatException -> L219
    L208:
        if (r57.hasNext() == false) goto L477;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r57.next()).a(r54, r55);     // Catch: NumberFormatException -> L219
        goto L208
    L477:
        return;
    L467:
        return;
    L211:
        if (r56 == 100102) goto L214;
        r3 = false;
    L214:
        Iterator r58 = ((ArrayList) this.n).iterator();     // Catch: NumberFormatException -> L219
    L216:
        if (r58.hasNext() == false) goto L478;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r58.next()).b(r54, r55, r3);     // Catch: NumberFormatException -> L219
        goto L216
    L478:
        return;
    L219:
        e = move-exception;
        Logger.e(e.toString());
        return;
    L197:
        if (TextUtils.isEmpty(r53.senderInteractIdStr) == false) goto L401;
        LinkedHashMap r59 = new LinkedHashMap();
        r59.put("msg_id", Long.valueOf(r20.getMessageId()));
        r59.put("content", "Both senderInteractId and senderInteractIdStr are empty!");
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r59);
        return;
    L222:
        if ((r20 instanceof e1) == false) goto L265;
        if (((Boolean) vm2.c.B.getValue(null, vm2.c.a[26])).booleanValue() == false) goto L232;
        long r60 = ((e1) r20).getResetVersion();
        if (r60 < this.K) goto L229;
        r3 = false;
    L229:
        ALogger.i(this.a, "handle contribute message, resetVersion: " + r60 + ", last version: " + this.K);
        this.K = r60;
        if (r3 == false) goto L232;
        return;
    L232:
        ArrayList r61 = new ArrayList();
        e1 r62 = (e1) r20;
        List r63 = r62.getUserContributeList();
        if (r63 == null) goto L238;
        Iterator r65 = r63.iterator();
    L236:
        if (r65.hasNext() == false) goto L238;
        r61.add(((ec) r65.next()).getUserIdStr());
    L238:
        Iterator r66 = ((ArrayList) this.n).iterator();
    L240:
        if (r66.hasNext() == false) goto L242;
        com.bytedance.android.live.liveinteract.plantform.base.i.b r119 = (com.bytedance.android.live.liveinteract.plantform.base.i.b) r66.next();
        String r120 = r62.getUserIdStr();
        long r121 = r62.getTotalScore();
        int r67 = com.bytedance.android.live.liveinteract.utils.y.a;
        r119.g(r120, r121, com.bytedance.android.live.liveinteract.utils.y.a(r62.getUserIdStr(), r61, r62.getTotalScoreRealStr(), r62.getTotalScoreStr()), r62.getQuickInteract());
        goto L240
    L242:
        ILinkPlayerInfoBridge r68 = o(r62.getUserIdStr(), "");
        if (r68 == null) goto L245;
        r68.setFanTicket(r62.getTotalScore());
        int r69 = com.bytedance.android.live.liveinteract.utils.y.a;
        r68.setFanTicketDisplayStr(com.bytedance.android.live.liveinteract.utils.y.a(r62.getUserIdStr(), r61, r62.getTotalScoreRealStr(), r62.getTotalScoreStr()));
    L245:
        String r70 = r62.getUserIdStr();
        int r71 = com.bytedance.android.live.liveinteract.utils.y.a;
        String r72 = com.bytedance.android.live.liveinteract.utils.y.a(r62.getUserIdStr(), r61, r62.getTotalScoreRealStr(), r62.getTotalScoreStr());
        if (r72 == null) goto L259;
        List r73 = (List) this.N.get("data_online_changed_list", new ArrayList());
        Iterator r74 = r73.iterator();
    L250:
        if (r74.hasNext() == false) goto L258;
        ILinkPlayerInfoBridge r75 = (ILinkPlayerInfoBridge) r74.next();
        IBaseUser r76 = r75.getUser();
        if (r76 == null) goto L254;
        String r77 = r76.getIdString();
    L256:
        if (Intrinsics.areEqual(r77, r70) == false) goto L250;
        r75.setFanTicketDisplayStr(r72);
        goto L250
    L254:
        r77 = null;
        goto L256
    L258:
        this.N.put("data_online_changed_list", new ArrayList(r73));
    L259:
        com.bytedance.android.live.liveinteract.plantform.base.g r78 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r78 == null) goto L469;
        BehaviorSubject<Boolean> r79 = r78.U4();
        if (r79 == null) goto L470;
        r79.onNext(Boolean.TRUE);
        return;
    L470:
        return;
    L469:
        return;
    L265:
        if ((r20 instanceof g2) == false) goto L472;
        int r80 = nd0.g.a;
        g2 r81 = (g2) r20;
        Intrinsics.checkNotNullParameter(r81, MultiLinkOpenSource.MESSAGE);
        JSONObject r122 = new JSONObject();
        r122.put("msg_id", r81.getMessageId());
        int r82 = r81.getMessageTypeInt();
        if (r82 == 1) goto L271;
        if (r82 == 2) goto L270;
        String r83 = "unknown(" + r81.getMessageTypeInt() + ')';
    L272:
        r122.put("attribute_type", r83);
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceivePositionAttrMsgMonitorData, r122, 0, null, false, 28);
        int r84 = r81.getMessageTypeInt();
        if (r84 == 1) goto L396;
        if (r84 == 2) goto L276;
        return;
    L276:
        h2 r85 = r81.getVerifyContent();
        if (r85 == null) goto L279;
        List r86 = r85.getFinalPositionItems();
    L280:
        F(r86);
        boolean r87 = jc1.k.n(IMiddlewareUserService.class).user().c();
        if (this.q.booleanValue() == true) goto L283;
        if (r87 == true) goto L283;
        return;
    L283:
        h2 r88 = r81.getVerifyContent();
        if (r88 == null) goto L474;
        List r89 = r88.getVerifyPositionItems();
        if (r89 == null) goto L475;
        Iterator r90 = r89.iterator();
    L289:
        if (r90.hasNext() == false) goto L479;
        i2 r91 = (i2) r90.next();
        CopyOnWriteArrayList<LinkmicPositionItem> r92 = this.e;
        long r93 = r91.getPosition();
        if (r92 == null) goto L303;
        Iterator<LinkmicPositionItem> r94 = r92.iterator();
    L294:
        if (r94.hasNext() == false) goto L301;
        LinkmicPositionItem r123 = r94.next();
        if (r93 != r123.getPosition()) goto L298;
        boolean r124 = true;
    L299:
        if (r124 == false) goto L294;
    L302:
        LinkmicPositionItem r125 = r123;
    L304:
        if (r125 != null) goto L306;
        boolean r95 = true;
    L307:
        if (r95 == false) goto L315;
        LinkmicPositionItem r96 = (LinkmicPositionItem) vh7.f.c(LinkmicPositionItem.class);
        if (r96 == null) goto L311;
        r96.setPosition(r91.getPosition());
        r96.setVerifyStatus(r91.getVerifyStatus());
    L312:
        CopyOnWriteArrayList<LinkmicPositionItem> r97 = this.e;
        if (r97 == null) goto L315;
        r97.add(r96);
        goto L315
    L311:
        r96 = null;
    L315:
        h2 r98 = r81.getVerifyContent();
        if (r98 == null) goto L358;
        List r99 = r98.getVerifyPositionItems();
        if (r99 == null) goto L358;
        Iterator r100 = r99.iterator();
    L321:
        if (r100.hasNext() == false) goto L358;
        i2 r101 = (i2) r100.next();
        Iterator<LinkmicPositionItem> r102 = this.e.iterator();
    L324:
        if (r102.hasNext() == false) goto L336;
        LinkmicPositionItem r126 = r102.next();
        LinkmicPositionItem r127 = r126;
        int r128 = r127.getPositionType();
        LinkmicPositionItem.LinkmicPositionType r129 = LinkmicPositionItem.LinkmicPositionType.PERFORMER;
        if (r128 != r129.ordinal()) goto L333;
        if (r101 == null) goto L333;
        if (r101.getPositionType() != r129.ordinal()) goto L333;
        if (r127.getPosition() == r101.getPosition()) goto L333;
        boolean r130 = true;
    L334:
        if (r130 == false) goto L324;
    L337:
        LinkmicPositionItem r131 = r126;
        if (r131 == null) goto L321;
        h2 r103 = r81.getVerifyContent();
        if (r103 == null) goto L354;
        List r104 = r103.getFinalPositionItems();
        if (r104 == null) goto L354;
        Iterator r105 = r104.iterator();
    L345:
        if (r105.hasNext() == false) goto L352;
        Object r106 = r105.next();
        if (((LinkmicPositionItem) r106).getPosition() != r131.getPosition()) goto L349;
        boolean r132 = true;
    L350:
        if (r132 == false) goto L345;
    L353:
        LinkmicPositionItem r107 = (LinkmicPositionItem) r106;
    L355:
        if (r107 != null) goto L356;
        r131.setPositionType(LinkmicPositionItem.LinkmicPositionType.NORMAL.ordinal());
        r131.setActiveName("");
        r131.setVerifyStatus(0);
        goto L321
    L356:
        r131.setPositionType(r107.getPositionType());
        r131.setActiveName(r107.getActiveName());
        r131.setVerifyStatus(r107.getVerifyStatus());
        goto L321
    L349:
        r132 = false;
        goto L350
    L352:
        r106 = null;
    L354:
        r107 = null;
    L333:
        r130 = false;
        goto L334
    L336:
        r126 = null;
    L358:
        Iterator<LinkmicPositionItem> r108 = this.e.iterator();
    L360:
        if (r108.hasNext() == false) goto L367;
        LinkmicPositionItem r109 = r108.next();
        if (r109.getPosition() != r91.getPosition()) goto L364;
        boolean r133 = true;
    L365:
        if (r133 == false) goto L360;
    L368:
        LinkmicPositionItem r134 = r109;
        if (r134 == null) goto L392;
        r134.setVerifyStatus(r91.getVerifyStatus());
        r134.setPositionType((int) r91.getPositionType());
        if (r134.getVerifyStatus() != 3) goto L373;
        r134.setActiveName(r91.getPositionName());
        goto L392
    L373:
        h2 r135 = r81.getVerifyContent();
        if (r135 == null) goto L390;
        List r136 = r135.getFinalPositionItems();
        if (r136 == null) goto L390;
        Iterator r137 = r136.iterator();
    L379:
        if (r137.hasNext() == false) goto L386;
        Object r138 = r137.next();
        if (((LinkmicPositionItem) r138).getPosition() != r134.getPosition()) goto L383;
        boolean r139 = true;
    L384:
        if (r139 == false) goto L379;
    L387:
        LinkmicPositionItem r140 = (LinkmicPositionItem) r138;
        if (r140 == null) goto L390;
        String r141 = r140.getActiveName();
    L391:
        r134.setActiveName(r141);
        goto L392
    L383:
        r139 = false;
        goto L384
    L386:
        r138 = null;
    L390:
        r141 = null;
    L392:
        Iterator r142 = ((ArrayList) this.n).iterator();
    L394:
        if (r142.hasNext() == false) goto L289;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r142.next()).e(this.e);
        goto L394
    L364:
        r133 = false;
        goto L365
    L367:
        r109 = null;
        goto L368
    L306:
        r95 = false;
        goto L307
    L298:
        r124 = false;
        goto L299
    L301:
        r123 = null;
        goto L302
    L303:
        r125 = null;
        goto L304
    L479:
        return;
    L475:
        return;
    L474:
        return;
    L279:
        r86 = null;
        goto L280
    L396:
        com.bytedance.android.live.base.model.message.f2 r143 = r81.getListChangeContent();
        if (r143 == null) goto L399;
        r10 = r143.getPositions();
    L399:
        Q(r10, false, true);
        return;
    L270:
        r83 = "verify";
        goto L272
    L271:
        r83 = "list_change";
        goto L272
    }

    public final String r(String r3) {
        ILinkPlayerInfoBridge r4 = o("", r3);
        if (r4 != null) goto L5;
        return "";
    L5:
        if (r4.getUser() == null) goto L16;
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L15;
        String r6 = r5.getIdString();
        if (r6 != null) goto L13;
        return "";
    L13:
        return r6;
    L15:
        return "";
    L16:
        return "";
    }

    public final void t(h1 r9) {
        ArrayList r0 = new ArrayList(this.c);
        int r1 = r9.getMType();
        Long r5 = null;
        if (r1 == 6) goto L67;
        if (r1 != 7) goto L7;
        boolean r2 = B(r9, null);
    L72:
        if (r2 == true) goto L74;
        return;
    L74:
        Iterator r3 = r0.iterator();
    L76:
        if (r3.hasNext() == false) goto L89;
        ILinkPlayerInfoBridge r4 = (ILinkPlayerInfoBridge) r3.next();
        Iterator<ILinkPlayerInfoBridge> r6 = this.c.iterator();
    L79:
        if (r6.hasNext() == false) goto L83;
        ILinkPlayerInfoBridge r7 = r6.next();
        if (w(r7, r4) == false) goto L79;
    L84:
        if (r7 != null) goto L76;
        if (this.h.size() < this.b) goto L88;
        this.h.remove(0);
    L88:
        this.h.add(r4);
        goto L76
    L83:
        r7 = null;
        goto L84
    L89:
        ALogger.w(this.a, "message onOnlineListChanged callback");
        int r8 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r10 = this.N;
        IRoom r11 = this.M;
        if (r11 == null) goto L92;
        r5 = Long.valueOf(r11.getId());
    L92:
        MultiSceneEnterRoomStatisticsUtils r12 = MultiSceneEnterRoomStatisticsUtils.a.a(r10, Long.valueOf(r5.longValue()));
        if (r12 == null) goto L95;
        r12.c();
    L95:
        System.currentTimeMillis();
        Iterator r13 = ((ArrayList) this.n).iterator();
    L97:
        if (r13.hasNext() == false) goto L108;
        com.bytedance.android.live.liveinteract.plantform.base.i.b r14 = (com.bytedance.android.live.liveinteract.plantform.base.i.b) r13.next();
        ILinkerLinkedListChangeContent r15 = r9.getMLinkedListChange();
        if (r15 != null) goto L101;
    L103:
        boolean r16 = false;
    L104:
        if (r16 == false) goto L106;
        r14.l(this.c);
    L107:
        r14.d(this.c, this.d);
        goto L97
    L106:
        r14.onOnlineListChanged(this.c);
        goto L107
    L101:
        if (r15.getUpdateMode() != 1) goto L103;
        r16 = true;
        goto L104
    L108:
        J(this.c);
        tc0.c.h().v = je0.d.R();
        return;
    L7:
        if (r1 != 11) goto L9;
        r2 = C(r9, null);
        goto L72
    L9:
        if (r1 != 12) goto L11;
        r2 = D(r9, null);
        goto L72
    L11:
        if (r1 == 23) goto L27;
        if (r1 != 26) goto L15;
        LinkerLockPositionContent r17 = r9.getLockPositionContent();
        if (r17 == null) goto L24;
        List r18 = r17.getLockedPositions();
        if (r18 == null) goto L24;
        List<LinkmicPositionItem> r19 = CollectionsKt.toMutableList(r18);
        if (r19 == null) goto L24;
    L25:
        Q(r19, true, true);
    L61:
        r2 = true;
    L24:
        r19 = new ArrayList();
        goto L25
    L15:
        if (r1 == 41) goto L17;
        return;
    L17:
        r2 = z(r9, null);
        goto L72
    L27:
        if (r9.getApplyStrongReminderContent() == null) goto L62;
        com.bytedance.android.livesdk.message.linker.i r20 = r9.getApplyStrongReminderContent();
        if (r20 == null) goto L31;
        IBaseUser r21 = r20.getUser();
    L32:
        if (r21 == null) goto L62;
        com.bytedance.android.livesdk.message.linker.i r22 = r9.getApplyStrongReminderContent();
        if (r22 == null) goto L37;
        Integer r23 = Integer.valueOf(r22.getSource());
    L38:
        com.bytedance.android.livesdk.message.linker.i r24 = r9.getApplyStrongReminderContent();
        if (r24 == null) goto L41;
        r24.getUser();
    L41:
        if (r23 != null) goto L44;
    L46:
        if (r23 == null) goto L52;
        if (r23.intValue() == 2) goto L62;
    L52:
        if (com.bytedance.android.live.liveinteract.utils.r.a() == false) goto L62;
        com.bytedance.android.livesdk.message.linker.i r25 = r9.getApplyStrongReminderContent();
        if (r25 == null) goto L57;
        r25.getUser();
    L57:
        Iterator r26 = ((ArrayList) this.n).iterator();
    L59:
        if (r26.hasNext() == false) goto L61;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r26.next()).k();
        goto L59
    L44:
        if (r23.intValue() != 0) goto L46;
    L37:
        r23 = null;
        goto L38
    L31:
        r21 = null;
    L62:
        r2 = false;
        goto L72
    L67:
        if (je0.d.Y() == false) goto L69;
    L70:
        I(false, "messageLinkUserEnter");
    L71:
        r2 = A(r9, null);
        goto L72
    L69:
        if (this.q.booleanValue() == false) goto L71;
        goto L70
    }

    public y(IRoom r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "mRoom");
        Intrinsics.checkNotNullParameter(r6, "mDataCenter");
        this.M = r5;
        this.N = r6;
        this.a = "ttlive_link_list";
        this.b = 5;
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.j = (vlc.d) r6.get("data_message_manager");
        this.n = new ArrayList();
        this.o = new CompositeDisposable();
        this.p = new HashMap();
        this.q = (Boolean) r6.get("data_is_anchor", Boolean.FALSE);
        this.r = SetsKt.setOf(new Integer[]{4, 5, 8, 9, 10, 12, 16});
        z01 r7 = vm2.d.m();
        this.v = r7;
        this.w = r7.enable;
        this.x = new com.bytedance.android.live.liveinteract.plantform.utils.z();
        this.y = new ArrayList();
        this.z = new LinkedHashMap();
        this.D = new ArrayList();
        this.E = new LinkedHashMap();
        this.G = true;
        this.H = true;
    }

    public static void O(f1 r7, List r8) {
        Object r0 = null;
        if (r7 == null) goto L7;
        ICityEffect r1 = r7.getCityEffect();
        if (r1 == null) goto L7;
        List r2 = r1.getShowEffectUserIdList();
    L8:
        List r9 = r8;
        Iterator r3 = r9.iterator();
    L9:
        int r4 = 0;
        if (r3.hasNext() == false) goto L37;
        com.bytedance.android.livesdk.link.model.bridge.k r5 = (com.bytedance.android.livesdk.link.model.bridge.k) r3.next();
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L14;
        String r10 = r6.getIdString();
    L15:
        if (r7 == null) goto L17;
        String r11 = r7.getUserIdString();
    L19:
        if (Intrinsics.areEqual(r10, r11) == false) goto L24;
        if (r7 == null) goto L22;
        IMatchEffect r12 = r7.getMatchEffect();
    L23:
        r5.setMatchEffect(r12);
        r5.setJoinUser(true);
        goto L24
    L22:
        r12 = null;
    L24:
        List r13 = r2;
        if (r13 != null) goto L27;
    L28:
        r4 = 1;
    L29:
        if (r4 != 0) goto L9;
        List r14 = r2;
        IBaseUser r15 = r5.getUser();
        if (r15 == null) goto L33;
        String r16 = r15.getIdString();
    L35:
        if (CollectionsKt.contains(r14, r16) == false) goto L9;
        r5.setShowCityEffect(true);
        r5.setCityEffect(r7.getCityEffect());
        goto L9
    L33:
        r16 = null;
        goto L35
    L27:
        if (r13.isEmpty() == false) goto L29;
    L17:
        r11 = null;
        goto L19
    L14:
        r10 = null;
        goto L15
    L37:
        Iterator r17 = r9.iterator();
    L39:
        if (r17.hasNext() == false) goto L51;
        Object r18 = r17.next();
        com.bytedance.android.livesdk.link.model.bridge.k r19 = (com.bytedance.android.livesdk.link.model.bridge.k) r18;
        if (r7 == null) goto L43;
        String r20 = r7.getUserIdString();
    L44:
        IBaseUser r21 = r19.getUser();
        if (r21 == null) goto L47;
        String r22 = r21.getIdString();
    L49:
        if (Intrinsics.areEqual(r20, r22) == false) goto L39;
        r0 = r18;
        goto L51
    L47:
        r22 = null;
        goto L49
    L43:
        r20 = null;
    L51:
        com.bytedance.android.livesdk.link.model.bridge.k r23 = (com.bytedance.android.livesdk.link.model.bridge.k) r0;
        if (r23 == null) goto L67;
        if (r7 == null) goto L55;
        r4 = r7.getApplyType();
    L55:
        r23.setApplyType(r4);
        return;
    L67:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public static final void e(y r1, Throwable r2) {
        r1.getClass();
        ALogger.stacktrace(6, "ttlive_link", r2.getStackTrace());
    }

    public static final void f(y r8, List r9) {
        r8.getClass();
        if (vm2.e.b() == true) goto L5;
        return;
    L5:
        if (r8.q.booleanValue() == false) goto L8;
        return;
    L8:
        if (tc0.c.h().K == LinkApplyType.PREPARE_APPLY.getValue()) goto L48;
        int r0 = xe0.j.a;
        if (xe0.j.a() == false) goto L16;
        LinkmicApplyFloatWindowManager.d r1 = LinkmicApplyFloatWindowManager.y;
        if (LinkmicApplyFloatWindowManager.e.a().f == false) goto L16;
        return;
    L16:
        if (xe0.j.d() == false) goto L19;
        return;
    L19:
        if (((Number) ((ge1.a) hd0.c.f()).b).intValue() > 0) goto L51;
        String r2 = jc1.k.n(IMiddlewareUserService.class).user().n();
        CopyOnWriteArrayList r10 = (CopyOnWriteArrayList) r9;
        Iterator r3 = r10.iterator();
    L22:
        ILinkPlayerInfoBridge r4 = null;
        String r5 = null;
        if (r3.hasNext() == false) goto L34;
        ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) r3.next();
        if (r6 == null) goto L22;
        if (r6.getUser() == null) goto L22;
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L32;
        r5 = r7.getIdString();
    L32:
        if (Intrinsics.areEqual(r2, r5) == false) goto L22;
        r4 = r6;
    L34:
        if (r4 == null) goto L46;
        ALogger.e("ttlive_link", "removeSelfOnAttach " + r4.getLinkStatus());
        long r11 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.v("optimize_first_enter_in_list");
        r8.o.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).leave(r8.M.getId(), "optimize_first_enter_in_list").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c0(r11), new d0(r8, r11)));
        r10.remove(r4);
        return;
    L46:
        return;
    L51:
        return;
    }

    public static boolean k(List r3, ILinkPlayerInfoBridge r4) {
        Iterator r5 = ((CopyOnWriteArrayList) r3).iterator();
    L4:
        if (r5.hasNext() == false) goto L16;
        IBaseUser r0 = ((ILinkPlayerInfoBridge) r5.next()).getUser();
        String r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.getIdString();
    L9:
        IBaseUser r6 = r4.getUser();
        if (r6 == null) goto L13;
        r1 = r6.getIdString();
    L13:
        if (Intrinsics.areEqual(r2, r1) == false) goto L4;
        return true;
    L8:
        r2 = null;
        goto L9
    L16:
        return false;
    }

    public static boolean w(ILinkPlayerInfoBridge r2, ILinkPlayerInfoBridge r3) {
        if (r2 != null) goto L4;
    L26:
        return false;
    L4:
        if (r2.getUser() == null) goto L26;
        if (r3 == null) goto L26;
        if (r3.getUser() == null) goto L26;
        if (TextUtils.isEmpty(r2.getInteractId()) == false) goto L13;
    L14:
        IBaseUser r0 = r2.getUser();
        Intrinsics.checkNotNull(r0);
        if (r2.a(r0.getIdString()) == false) goto L26;
        IBaseUser r4 = r2.getUser();
        String r1 = null;
        if (r4 == null) goto L19;
        String r5 = r4.getIdString();
    L20:
        IBaseUser r6 = r3.getUser();
        if (r6 == null) goto L24;
        r1 = r6.getIdString();
    L24:
        if (Intrinsics.areEqual(r5, r1) == false) goto L26;
    L25:
        return true;
    L19:
        r5 = null;
        goto L20
    L13:
        if (TextUtils.equals(r2.getInteractId(), r3.getInteractId()) == true) goto L25;
        goto L14
    }

    public final boolean A(h1 r23, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r24) {
        if (r23.getEnter() != null) goto L5;
        return false;
    L5:
        f1 r9 = r23.getEnter();
        String r10 = null;
        if (r24 != null) goto L10;
        if (r9 == null) goto L9;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r6 = r9.getLinkUsers();
    L11:
        if (r9 == null) goto L13;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r0 = r9.getPreOnlineUsers();
    L14:
        S(r0);
        if (r9 == null) goto L21;
        IMessageBoardInfo r1 = r9.getMessageBoardInfo();
        if (r1 == null) goto L21;
        if (this.q.booleanValue() == false) goto L21;
        jc1.k.n(IInteractivityInjectService.class).sendMessageBoardPin(r1);
    L21:
        Long r11 = Long.valueOf(r23.getMessageId3());
        if (r9 == null) goto L25;
        String r2 = r9.getUserIdString();
        if (r2 == null) goto L25;
    L26:
        String r12 = r2;
        String r13 = String.valueOf(r9);
        if (r6 == null) goto L29;
        Integer r15 = Integer.valueOf(r6.size());
    L30:
        if (r9 == null) goto L32;
        String r3 = r9.getUserIdString();
    L33:
        boolean r16 = Intrinsics.areEqual(r3, je0.d.b0());
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r4 = r6;
        if (r4 != null) goto L36;
    L39:
        boolean r5 = true;
    L40:
        if (r5 == false) goto L42;
        String r14 = "enter linkUsers invalid";
    L43:
        com.bytedance.android.live.liveinteract.plantform.utils.x.T(r11, r12, r13, r14, r15, r16);
        if (r4 != null) goto L46;
    L49:
        boolean r7 = true;
    L51:
        if (r7 == true) goto L67;
        O(r9, r6);
        if (r9 == null) goto L55;
        ClientUIInfo r8 = r9.getClientUiInfo();
    L56:
        if (r9 == null) goto L58;
        long r17 = r9.getVersion();
    L59:
        int r18 = 1;
        boolean r19 = R(r6, r8, r17, "enterMsg");
        N(r6, true);
        if (r19 == false) goto L66;
        long r110 = System.currentTimeMillis();
        String r20 = String.valueOf(r23.getMessageId3());
        StringBuilder r21 = new StringBuilder("enterUser=");
        if (r9 == null) goto L64;
        String r22 = r9.getUserIdString();
    L65:
        r21.append(r22);
        this.s = new a(r110, "enterMsg", r20, r21.toString());
        goto L66
    L64:
        r22 = null;
    L66:
        boolean r111 = r19;
    L68:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r25 = CollectionsKt.emptyList();
        if (r9 == null) goto L105;
        Map r26 = r9.getLinkerContentMap();
        if (r26 == null) goto L105;
        Iterator r27 = r26.entrySet().iterator();
        if (r27 == null) goto L105;
        if (r27.hasNext() != r18) goto L105;
        Map r28 = r9.getLinkerContentMap();
        if (r28 == null) goto L79;
        int r29 = r28.size();
    L80:
        if (r29 <= r18) goto L96;
        Map r30 = r9.getLinkerContentMap();
        if (r30 == null) goto L95;
        Collection r31 = r30.values();
        if (r31 == null) goto L95;
        ArrayList r32 = new ArrayList();
        Iterator r33 = r31.iterator();
    L87:
        if (r33.hasNext() == false) goto L94;
        com.bytedance.android.livesdk.link.model.bridge.g2 r34 = (com.bytedance.android.livesdk.link.model.bridge.g2) r33.next();
        if (r34 == null) goto L92;
        List r35 = r34.getLinkedUsers();
        if (r35 == null) goto L92;
    L93:
        CollectionsKt.addAll(r32, r35);
    L92:
        r35 = CollectionsKt.emptyList();
        goto L93
    L94:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r36 = r32;
    L106:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r37 = r36;
        if (r37 != null) goto L109;
    L112:
        boolean r38 = true;
    L113:
        if (r38 == true) goto L130;
        O(r9, r36);
        if (r9 == null) goto L117;
        Map<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2> r39 = r9.getLinkerContentMap();
    L118:
        if (r9 == null) goto L120;
        ClientUIInfo r40 = r9.getClientUiInfo();
    L121:
        if (r9 == null) goto L123;
        long r41 = r9.getVersion();
    L124:
        boolean r42 = P(r39, r40, r41, "enterMsg", this.d);
        N(r36, false);
        if (r42 == false) goto L131;
        long r43 = System.currentTimeMillis();
        String r44 = String.valueOf(r23.getMessageId3());
        StringBuilder r45 = new StringBuilder("enterUser=");
        if (r9 == null) goto L129;
        r10 = r9.getUserIdString();
    L129:
        r45.append(r10);
        this.s = new a(r43, "enterMsg", r44, r45.toString());
    L131:
        if (r42 == true) goto L133;
        if (r111 == true) goto L133;
        return false;
    L133:
        return true;
    L123:
        r41 = 0;
        goto L124
    L120:
        r40 = null;
        goto L121
    L117:
        r39 = null;
        goto L118
    L130:
        this.d.clear();
        r42 = false;
        goto L131
    L109:
        if (r37.isEmpty() == true) goto L112;
        r38 = false;
    L95:
        r25 = CollectionsKt.emptyList();
        goto L105
    L96:
        Map r46 = r9.getLinkerContentMap();
        Intrinsics.checkNotNull(r46);
        Iterator r47 = r46.entrySet().iterator();
        if (r47 == null) goto L104;
        Map.Entry r48 = (Map.Entry) r47.next();
        if (r48 == null) goto L104;
        com.bytedance.android.livesdk.link.model.bridge.g2 r49 = (com.bytedance.android.livesdk.link.model.bridge.g2) r48.getValue();
        if (r49 == null) goto L104;
        r25 = r49.getLinkedUsers();
        if (r25 != null) goto L105;
    L104:
        r25 = CollectionsKt.emptyList();
        goto L105
    L79:
        r29 = 0;
    L105:
        r36 = r25;
        goto L106
    L58:
        r17 = 0;
        goto L59
    L55:
        r8 = null;
        goto L56
    L67:
        r18 = 1;
        r111 = false;
        goto L68
    L46:
        if (r4.isEmpty() == true) goto L49;
        r7 = false;
        goto L51
    L42:
        r14 = null;
        goto L43
    L36:
        if (r4.isEmpty() == true) goto L39;
        r5 = false;
        goto L40
    L32:
        r3 = null;
        goto L33
    L29:
        r15 = null;
    L25:
        r2 = "";
        goto L26
    L13:
        r0 = null;
        goto L14
    L9:
        r6 = null;
        goto L11
    L10:
        r6 = r24;
        goto L11
    }

    public final boolean B(h1 r23, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r24) {
        boolean r6 = false;
        if (r23.getLeave() != null) goto L5;
        return false;
    L5:
        LinkerLeaveContent r8 = r23.getLeave();
        Intrinsics.checkNotNull(r8);
        ILinkerLeaveContent r0 = r8.castTo(ILinkerLeaveContent.class);
        if (r24 != null) goto L8;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r9 = r0.getLinkUsers();
    L9:
        S(r8.getPreOnlineUsers());
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1 = r9;
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L17:
        if (r2 == true) goto L41;
        R(r9, r0.getClientUiInfo(), r8.getVersion(), "leaveMsg");
        N(r9, true);
        Iterator<ILinkPlayerInfoBridge> r3 = this.c.iterator();
    L20:
        if (r3.hasNext() == false) goto L28;
        ILinkPlayerInfoBridge r4 = r3.next();
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L24;
        String r7 = r5.getIdString();
    L26:
        if (Intrinsics.areEqual(r7, r8.getUserIdStr()) == false) goto L20;
    L29:
        ILinkPlayerInfoBridge r10 = r4;
        if (r10 == null) goto L32;
        this.c.remove(r10);
    L32:
        Long r14 = Long.valueOf(r23.getMessageId3());
        String r11 = r8.getUserIdStr();
        if (r11 != null) goto L35;
        String r15 = "";
    L36:
        String r16 = r8.toString();
        Integer r18 = Integer.valueOf(r9.size());
        if (r10 == null) goto L39;
        String r17 = "leaved user in list";
    L40:
        com.bytedance.android.live.liveinteract.plantform.utils.x.U(r14, r15, r16, r17, r18, false, null, 96);
        this.s = new a(System.currentTimeMillis(), "leaveMsg", String.valueOf(r23.getMessageId3()), "leaveUser=" + r8.getUserIdStr());
    L65:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r12 = CollectionsKt.emptyList();
        Map r13 = r8.getLinkerContentMap();
        if (r13 == null) goto L100;
        Iterator r19 = r13.entrySet().iterator();
        if (r19 == null) goto L100;
        if (r19.hasNext() != true) goto L100;
        Map r20 = r8.getLinkerContentMap();
        if (r20 == null) goto L74;
        int r21 = r20.size();
    L75:
        if (r21 <= 1) goto L91;
        Map r22 = r8.getLinkerContentMap();
        if (r22 == null) goto L90;
        Collection r25 = r22.values();
        if (r25 == null) goto L90;
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L82:
        if (r27.hasNext() == false) goto L89;
        com.bytedance.android.livesdk.link.model.bridge.g2 r28 = (com.bytedance.android.livesdk.link.model.bridge.g2) r27.next();
        if (r28 == null) goto L87;
        List r29 = r28.getLinkedUsers();
        if (r29 == null) goto L87;
    L88:
        CollectionsKt.addAll(r26, r29);
    L87:
        r29 = CollectionsKt.emptyList();
        goto L88
    L89:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r30 = r26;
    L101:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r31 = r30;
        if (r31 != null) goto L104;
    L105:
        r6 = true;
    L106:
        if (r6 == true) goto L120;
        Map<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2> r32 = r8.getLinkerContentMap();
        if ((r8 instanceof LinkerLeaveContent) == true) goto L110;
        LinkerLeaveContent r33 = null;
    L111:
        LinkerLeaveContent r34 = r33;
        if (r34 == null) goto L114;
        ClientUIInfo r35 = r34.getClientUIInfo();
    L115:
        P(r32, r35, r8.getVersion(), "leaveMsg", this.d);
        N(r30, true);
        Long r110 = Long.valueOf(r23.getMessageId3());
        String r36 = r8.getUserIdStr();
        if (r36 != null) goto L118;
        String r111 = "";
    L119:
        com.bytedance.android.live.liveinteract.plantform.utils.x.U(r110, r111, r8.toString(), null, Integer.valueOf(r30.size()), false, "_link_room_fight", 32);
        this.s = new a(System.currentTimeMillis(), "leaveMsg", String.valueOf(r23.getMessageId3()), "leaveUser=" + r8.getUserIdStr());
    L121:
        this.t = r8.getVersion();
        this.s = new a(System.currentTimeMillis(), "leaveMsg", String.valueOf(r23.getMessageId3()), "fallback leaveUser=" + r8.getUserIdStr());
        Long r112 = Long.valueOf(r23.getMessageId3());
        String r37 = r8.getUserIdStr();
        if (r37 != null) goto L124;
        String r113 = "";
    L125:
        com.bytedance.android.live.liveinteract.plantform.utils.x.U(r112, r113, r8.toString(), null, null, false, null, 120);
        return true;
    L124:
        r113 = r37;
        goto L125
    L118:
        r111 = r36;
        goto L119
    L114:
        r35 = null;
        goto L115
    L110:
        r33 = r8;
        goto L111
    L120:
        this.d.clear();
        goto L121
    L104:
        if (r31.isEmpty() == false) goto L106;
    L90:
        r12 = CollectionsKt.emptyList();
        goto L100
    L91:
        Map r38 = r8.getLinkerContentMap();
        Intrinsics.checkNotNull(r38);
        Iterator r39 = r38.entrySet().iterator();
        if (r39 == null) goto L99;
        Map.Entry r40 = (Map.Entry) r39.next();
        if (r40 == null) goto L99;
        com.bytedance.android.livesdk.link.model.bridge.g2 r41 = (com.bytedance.android.livesdk.link.model.bridge.g2) r40.getValue();
        if (r41 == null) goto L99;
        r12 = r41.getLinkedUsers();
        if (r12 != null) goto L100;
    L99:
        r12 = CollectionsKt.emptyList();
        goto L100
    L74:
        r21 = 0;
    L100:
        r30 = r12;
        goto L101
    L39:
        r17 = null;
        goto L40
    L35:
        r15 = r11;
        goto L36
    L24:
        r7 = null;
        goto L26
    L28:
        r4 = null;
        goto L29
    L41:
        Iterator<ILinkPlayerInfoBridge> r42 = this.c.iterator();
    L43:
        if (r42.hasNext() == false) goto L56;
        ILinkPlayerInfoBridge r43 = r42.next();
        IBaseUser r44 = r43.getUser();
        if (r44 == null) goto L47;
        String r45 = r44.getIdString();
    L49:
        if (Intrinsics.areEqual(r45, r8.getUserIdStr()) == true) goto L51;
    L53:
        boolean r46 = false;
    L54:
        if (r46 == false) goto L43;
    L57:
        ILinkPlayerInfoBridge r47 = r43;
        if (r47 != null) goto L64;
        Long r114 = Long.valueOf(r23.getMessageId3());
        String r48 = r8.getUserIdStr();
        if (r48 != null) goto L62;
        String r115 = "";
    L63:
        com.bytedance.android.live.liveinteract.plantform.utils.x.U(r114, r115, null, "leave user not found", null, r2.a(r8.getUserIdStr()), null, 84);
        goto L64
    L62:
        r115 = r48;
    L64:
        this.c.remove(r47);
        goto L65
    L51:
        if (r2.a(r8.getUserIdStr()) == false) goto L53;
        r46 = true;
        goto L54
    L47:
        r45 = null;
        goto L49
    L56:
        r43 = null;
        goto L57
    L12:
        if (r1.isEmpty() == true) goto L15;
        r2 = false;
        goto L17
    L8:
        r9 = r24;
        goto L9
    }

    public final boolean C(h1 r22, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r23) {
        LinkerLinkedListChangeContent r6 = r22.getMLinkedListChange();
        boolean r8 = r6.isTimerPush();
        if (r8 == true) goto L5;
    L7:
        S(r6.getPreOnlineUsers());
        if (r23 != null) goto L10;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r10 = r6.getLinkUsers();
    L11:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r0 = r10;
        if (r0 != null) goto L14;
    L17:
        boolean r1 = true;
    L19:
        if (r1 == false) goto L21;
        boolean r11 = false;
    L41:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r2 = CollectionsKt.emptyList();
        Map r3 = r6.getLinkerContentMap();
        if (r3 == null) goto L76;
        Iterator r4 = r3.entrySet().iterator();
        if (r4 == null) goto L76;
        if (r4.hasNext() != true) goto L76;
        Map r5 = r6.getLinkerContentMap();
        if (r5 == null) goto L50;
        int r7 = r5.size();
    L51:
        if (r7 <= 1) goto L67;
        Map r9 = r6.getLinkerContentMap();
        if (r9 == null) goto L66;
        Collection r12 = r9.values();
        if (r12 == null) goto L66;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L58:
        if (r14.hasNext() == false) goto L65;
        com.bytedance.android.livesdk.link.model.bridge.g2 r15 = (com.bytedance.android.livesdk.link.model.bridge.g2) r14.next();
        if (r15 == null) goto L63;
        List r16 = r15.getLinkedUsers();
        if (r16 == null) goto L63;
    L64:
        CollectionsKt.addAll(r13, r16);
    L63:
        r16 = CollectionsKt.emptyList();
        goto L64
    L65:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r17 = r13;
    L77:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r18 = r17;
        if (r18 != null) goto L80;
    L83:
        boolean r19 = true;
    L84:
        if (r19 == true) goto L104;
        Map<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2> r20 = r6.getLinkerContentMap();
        if ((r6 instanceof LinkerLinkedListChangeContent) == true) goto L88;
        LinkerLinkedListChangeContent r21 = null;
    L89:
        LinkerLinkedListChangeContent r24 = r21;
        if (r24 == null) goto L92;
        ClientUIInfo r25 = r24.getClientUiInfo();
    L93:
        long r26 = r6.getVersion();
        if (r8 == false) goto L96;
        String r27 = "timerPushMsg";
    L97:
        boolean r28 = P(r20, r25, r26, r27, this.d);
        N(r17, false);
        if (r28 == false) goto L105;
        long r29 = System.currentTimeMillis();
        if (r8 == false) goto L102;
        String r30 = "timerPushMsg";
    L103:
        this.s = new a(r29, r30, String.valueOf(r22.getMessageId3()), null);
        goto L105
    L102:
        r30 = "linkedListChangeMsg";
    L105:
        if (r28 == true) goto L107;
        if (r11 == true) goto L107;
        return false;
    L107:
        return true;
    L96:
        r27 = "linkedListChangeMsg";
        goto L97
    L92:
        r25 = null;
        goto L93
    L88:
        r21 = r6;
        goto L89
    L104:
        this.d.clear();
        r28 = false;
        goto L105
    L80:
        if (r18.isEmpty() == true) goto L83;
        r19 = false;
    L66:
        r2 = CollectionsKt.emptyList();
        goto L76
    L67:
        Map r31 = r6.getLinkerContentMap();
        Intrinsics.checkNotNull(r31);
        Iterator r32 = r31.entrySet().iterator();
        if (r32 == null) goto L75;
        Map.Entry r33 = (Map.Entry) r32.next();
        if (r33 == null) goto L75;
        com.bytedance.android.livesdk.link.model.bridge.g2 r34 = (com.bytedance.android.livesdk.link.model.bridge.g2) r33.getValue();
        if (r34 == null) goto L75;
        r2 = r34.getLinkedUsers();
        if (r2 != null) goto L76;
    L75:
        r2 = CollectionsKt.emptyList();
        goto L76
    L50:
        r7 = 0;
    L76:
        r17 = r2;
        goto L77
    L21:
        if ((r6 instanceof LinkerLinkedListChangeContent) == true) goto L23;
        LinkerLinkedListChangeContent r35 = null;
    L24:
        LinkerLinkedListChangeContent r36 = r35;
        if (r36 == null) goto L27;
        ClientUIInfo r37 = r36.getClientUiInfo();
    L28:
        long r38 = r6.getVersion();
        if (r8 == false) goto L31;
        String r39 = "timerPushMsg";
    L32:
        boolean r40 = R(r10, r37, r38, r39);
        N(r10, true);
        if (r40 == false) goto L39;
        long r110 = System.currentTimeMillis();
        if (r8 == false) goto L37;
        String r111 = "timerPushMsg";
    L38:
        this.s = new a(r110, r111, String.valueOf(r22.getMessageId3()), null);
        goto L39
    L37:
        r111 = "linkedListChangeMsg";
    L39:
        r11 = r40;
        goto L41
    L31:
        r39 = "linkedListChangeMsg";
        goto L32
    L27:
        r37 = null;
        goto L28
    L23:
        r35 = r6;
        goto L24
    L14:
        if (r0.isEmpty() == true) goto L17;
        r1 = false;
        goto L19
    L10:
        r10 = r23;
        goto L11
    L5:
        if (this.v.consumeTimerPush == true) goto L7;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean D(h1 r23, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r24) {
        Object r8 = null;
        if (r23 != null) goto L6;
        ALogger.i("printMsg", "msg is null");
    L100:
        if (r23.getMUpdateUser() != null) goto L102;
        return false;
    L102:
        ILinkerUpdateUserContent r11 = r23.getMUpdateUser();
        if (r24 != null) goto L107;
        if (r11 == null) goto L106;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r6 = r11.getMLinkUsers();
    L108:
        Long r0 = Long.valueOf(r23.getMessageId3());
        if (r11 == null) goto L112;
        String r1 = ILinkerUpdateUserContentKt.getToUserIdString(r11);
        if (r1 == null) goto L112;
    L113:
        String r2 = String.valueOf(r11);
        if (r6 == null) goto L116;
        Integer r3 = Integer.valueOf(r6.size());
    L117:
        com.bytedance.android.live.liveinteract.plantform.utils.x.V(r0, r1, r2, r3);
        if (r11 != null) goto L120;
    L254:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r4 = r6;
        if (r4 != null) goto L257;
    L260:
        boolean r5 = true;
    L262:
        if (r5 == true) goto L299;
        if (r11 == null) goto L265;
        ClientUIInfo r7 = r11.getClientUiInfo();
    L266:
        if (r11 == null) goto L268;
        long r9 = r11.getVersion();
    L269:
        R(r6, r7, r9, "updateMsg");
        N(r6, true);
        Iterator<ILinkPlayerInfoBridge> r10 = this.c.iterator();
    L271:
        if (r10.hasNext() == false) goto L282;
        ILinkPlayerInfoBridge r12 = r10.next();
        IBaseUser r13 = r12.getUser();
        if (r13 == null) goto L275;
        String r14 = r13.getIdString();
    L276:
        if (r11 == null) goto L278;
        String r15 = ILinkerUpdateUserContentKt.getToUserIdString(r11);
    L280:
        if (Intrinsics.areEqual(r14, r15) == false) goto L271;
    L283:
        ILinkPlayerInfoBridge r16 = r12;
        if (r16 == null) goto L291;
        if (r11 == null) goto L291;
        if (ILinkerUpdateUserContentKt.isMcStatusUpdate(r11) != true) goto L291;
        int r17 = ILinkerUpdateUserContentKt.getMcStatus(r11);
        if (r17 < 0) goto L291;
        r16.setMcStatus(r17);
    L291:
        long r18 = System.currentTimeMillis();
        String r19 = String.valueOf(r23.getMessageId3());
        if (r11 == null) goto L297;
        String r20 = ILinkerUpdateUserContentKt.getUpdateInfoStr(r11);
        if (r20 == null) goto L297;
        String r21 = r20;
    L298:
        this.s = new a(r18, "updateMsg", r19, r21);
        boolean r110 = true;
    L332:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r22 = CollectionsKt.emptyList();
        if (r11 == null) goto L371;
        Map r25 = r11.getLinkerContentMap();
        if (r25 == null) goto L371;
        Iterator r26 = r25.entrySet().iterator();
        if (r26 == null) goto L371;
        if (r26.hasNext() != true) goto L371;
        Map r27 = r11.getLinkerContentMap();
        if (r27 == null) goto L343;
        int r28 = r27.size();
    L344:
        if (r28 <= 1) goto L360;
        Map r29 = r11.getLinkerContentMap();
        if (r29 == null) goto L359;
        Collection r30 = r29.values();
        if (r30 == null) goto L359;
        ArrayList r31 = new ArrayList();
        Iterator r32 = r30.iterator();
    L351:
        if (r32.hasNext() == false) goto L358;
        com.bytedance.android.livesdk.link.model.bridge.g2 r33 = (com.bytedance.android.livesdk.link.model.bridge.g2) r32.next();
        if (r33 == null) goto L356;
        List r34 = r33.getLinkedUsers();
        if (r34 == null) goto L356;
    L357:
        CollectionsKt.addAll(r31, r34);
    L356:
        r34 = CollectionsKt.emptyList();
        goto L357
    L358:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r111 = r31;
    L372:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r35 = r111;
        if (r35 != null) goto L375;
    L378:
        boolean r36 = true;
    L379:
        if (r36 == true) goto L393;
        if (r11 == null) goto L382;
        Map<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2> r37 = r11.getLinkerContentMap();
    L383:
        if (r11 == null) goto L385;
        ClientUIInfo r38 = r11.getClientUiInfo();
    L386:
        if (r11 == null) goto L388;
        long r39 = r11.getVersion();
    L389:
        P(r37, r38, r39, "updateMsg", this.d);
        N(r111, false);
        long r112 = System.currentTimeMillis();
        String r210 = String.valueOf(r23.getMessageId3());
        if (r11 == null) goto L392;
        r8 = ILinkerUpdateUserContentKt.getUpdateInfoStr(r11);
    L392:
        this.s = new a(r112, "updateMsg", r210, r8);
        boolean r40 = true;
    L394:
        if (r40 == true) goto L396;
        if (r110 == true) goto L396;
        return false;
    L396:
        return true;
    L388:
        r39 = 0;
        goto L389
    L385:
        r38 = null;
        goto L386
    L382:
        r37 = null;
        goto L383
    L393:
        this.d.clear();
        r40 = false;
        goto L394
    L375:
        if (r35.isEmpty() == true) goto L378;
        r36 = false;
    L359:
        r22 = CollectionsKt.emptyList();
        goto L371
    L360:
        Map r41 = r11.getLinkerContentMap();
        if (r41 == null) goto L370;
        Iterator r42 = r41.entrySet().iterator();
        if (r42 == null) goto L370;
        Map.Entry r43 = (Map.Entry) r42.next();
        if (r43 == null) goto L370;
        com.bytedance.android.livesdk.link.model.bridge.g2 r44 = (com.bytedance.android.livesdk.link.model.bridge.g2) r43.getValue();
        if (r44 == null) goto L370;
        r22 = r44.getLinkedUsers();
        if (r22 != null) goto L371;
    L370:
        r22 = CollectionsKt.emptyList();
        goto L371
    L343:
        r28 = 0;
    L371:
        r111 = r22;
    L297:
        r21 = "";
        goto L298
    L278:
        r15 = null;
        goto L280
    L275:
        r14 = null;
        goto L276
    L282:
        r12 = null;
        goto L283
    L268:
        r9 = 0;
        goto L269
    L265:
        r7 = null;
        goto L266
    L299:
        Iterator<ILinkPlayerInfoBridge> r45 = this.c.iterator();
    L301:
        if (r45.hasNext() == false) goto L312;
        ILinkPlayerInfoBridge r46 = r45.next();
        IBaseUser r47 = r46.getUser();
        if (r47 == null) goto L305;
        String r48 = r47.getIdString();
    L306:
        if (r11 == null) goto L308;
        String r49 = ILinkerUpdateUserContentKt.getToUserIdString(r11);
    L310:
        if (Intrinsics.areEqual(r48, r49) == false) goto L301;
    L314:
        if (r46 != null) goto L327;
        Long r113 = Long.valueOf(r23.getMessageId3());
        if (r11 == null) goto L321;
        String r50 = ILinkerUpdateUserContentKt.getToUserIdString(r11);
        if (r50 == null) goto L321;
        String r114 = r50;
    L322:
        String r115 = String.valueOf(r11);
        if (r11 == null) goto L325;
        String r51 = ILinkerUpdateUserContentKt.getToUserIdString(r11);
    L326:
        com.bytedance.android.live.liveinteract.plantform.utils.x.W(r113, r114, "update user not found", r115, null, r2.a(r51), 16);
    L331:
        r110 = false;
        goto L332
    L325:
        r51 = null;
    L321:
        r114 = "";
        goto L322
    L327:
        if (r11 == null) goto L331;
        if (ILinkerUpdateUserContentKt.isSilenceStatusUpdate(r11) != true) goto L331;
        com.bytedance.android.live.liveinteract.plantform.utils.x.W(Long.valueOf(r23.getMessageId3()), ILinkerUpdateUserContentKt.getToUserIdString(r11), "fallback SilenceStatusUpdate", r11.toString(), 0, false, 32);
        goto L331
    L308:
        r49 = null;
        goto L310
    L305:
        r48 = null;
        goto L306
    L312:
        r46 = null;
        goto L314
    L257:
        if (r4.isEmpty() == true) goto L260;
        r5 = false;
        goto L262
    L120:
        if (ILinkerUpdateUserContentKt.isBackgroundStatusUpdate(r11) != true) goto L254;
        Iterator<ILinkPlayerInfoBridge> r52 = this.c.iterator();
    L123:
        if (r52.hasNext() == false) goto L131;
        ILinkPlayerInfoBridge r53 = r52.next();
        IBaseUser r54 = r53.getUser();
        if (r54 == null) goto L127;
        String r55 = r54.getIdString();
    L129:
        if (Intrinsics.areEqual(r55, ILinkerUpdateUserContentKt.getFromUserIdString(r11)) == false) goto L123;
    L132:
        ILinkPlayerInfoBridge r56 = r53;
        JsonObject r57 = JsonUtil.parseObject(r11.getExtra());
        if (r56 == null) goto L211;
        if (r57 == null) goto L211;
        if (r57.has("shouldUpdateAllGuestActiveStatus") == false) goto L211;
        if (Intrinsics.areEqual("1", r57.get("shouldUpdateAllGuestActiveStatus").getAsString()) == false) goto L211;
        ALogger.e(this.a, "shouldUpdateAllGuestActiveStatus, all user isBackground set to " + ILinkerUpdateUserContentKt.isBackground(r11));
        Iterator<ILinkPlayerInfoBridge> r58 = this.c.iterator();
    L141:
        if (r58.hasNext() == false) goto L210;
        ILinkPlayerInfoBridge r59 = r58.next();
        int r60 = this.c.indexOf(r59);
        ILinkPlayerInfoBridge r61 = com.bytedance.android.live.liveinteract.plantform.model.n.a(r59);
        if (ILinkerUpdateUserContentKt.isBackground(r11) == true) goto L183;
        String r62 = this.M.getOwnerUserIdString();
        IBaseUser r63 = r61.getUser();
        if (r63 == null) goto L147;
        String r65 = r63.getIdString();
    L149:
        if (Intrinsics.areEqual(r62, r65) == true) goto L183;
        List r66 = r11.getMLinkUsers();
        if (r66 == null) goto L175;
        Iterator r67 = r66.iterator();
    L155:
        if (r67.hasNext() == false) goto L169;
        Object r68 = r67.next();
        com.bytedance.android.livesdk.link.model.bridge.k r116 = (com.bytedance.android.livesdk.link.model.bridge.k) r68;
        if (r116 == null) goto L161;
        IBaseUser r117 = r116.getUser();
        if (r117 == null) goto L161;
        String r118 = r117.getIdString();
    L162:
        IBaseUser r119 = r61.getUser();
        if (r119 == null) goto L165;
        String r120 = r119.getIdString();
    L167:
        if (Intrinsics.areEqual(r118, r120) == false) goto L155;
    L170:
        com.bytedance.android.livesdk.link.model.bridge.k r69 = (com.bytedance.android.livesdk.link.model.bridge.k) r68;
        if (r69 == null) goto L175;
        if (r69.isBackground() != 1) goto L175;
        boolean r70 = true;
    L177:
        if (ILinkerUpdateUserContentKt.isBackground(r11) == true) goto L181;
        if (r70 == true) goto L181;
        boolean r71 = false;
    L182:
        r61.setBackground(r71);
        r61.setSelfBackground(r70);
    L209:
        this.c.set(r60, r61);
    L181:
        r71 = true;
        goto L182
    L165:
        r120 = null;
    L161:
        r118 = null;
        goto L162
    L169:
        r68 = null;
    L175:
        r70 = false;
        goto L177
    L147:
        r65 = null;
    L183:
        r61.setBackground(ILinkerUpdateUserContentKt.isBackground(r11));
        List r72 = r11.getMLinkUsers();
        if (r72 == null) goto L207;
        Iterator r73 = r72.iterator();
    L187:
        if (r73.hasNext() == false) goto L201;
        Object r74 = r73.next();
        com.bytedance.android.livesdk.link.model.bridge.k r121 = (com.bytedance.android.livesdk.link.model.bridge.k) r74;
        if (r121 == null) goto L193;
        IBaseUser r122 = r121.getUser();
        if (r122 == null) goto L193;
        String r123 = r122.getIdString();
    L194:
        IBaseUser r124 = r61.getUser();
        if (r124 == null) goto L197;
        String r125 = r124.getIdString();
    L199:
        if (Intrinsics.areEqual(r123, r125) == false) goto L187;
    L202:
        com.bytedance.android.livesdk.link.model.bridge.k r75 = (com.bytedance.android.livesdk.link.model.bridge.k) r74;
        if (r75 == null) goto L207;
        if (r75.isBackground() != 1) goto L207;
        boolean r76 = true;
    L208:
        r61.setSelfBackground(r76);
        goto L209
    L197:
        r125 = null;
    L193:
        r123 = null;
        goto L194
    L201:
        r74 = null;
    L207:
        r76 = false;
        goto L208
    L210:
        this.A = ILinkerUpdateUserContentKt.isBackground(r11);
        this.t = r11.getVersion();
        this.s = new a(System.currentTimeMillis(), "backgroundMsg", String.valueOf(r23.getMessageId3()), ILinkerUpdateUserContentKt.getUpdateInfoStr(r11));
    L248:
        return true;
    L211:
        if (r56 != null) goto L213;
    L249:
        String r77 = this.a;
        StringBuilder r78 = new StringBuilder("not consumeBackgroundMsg ");
        if (r56 == null) goto L252;
        r8 = Boolean.valueOf(r56.isBackground());
    L252:
        r78.append(r8);
        r78.append(' ');
        r78.append(this.A);
        r78.append(' ');
        r78.append(r11);
        ALogger.e(r77, r78.toString());
        return false;
    L213:
        if (r56.isBackground() == ILinkerUpdateUserContentKt.isBackground(r11)) goto L215;
    L216:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r79 = r11.getMLinkUsers();
        ALogger.w(this.a, ILinkerUpdateUserContentKt.getToUserIdString(r11) + " updateBackground " + r56.isBackground() + " to " + ILinkerUpdateUserContentKt.isBackground(r11));
        if (this.w == false) goto L246;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r80 = r79;
        if (r80 != null) goto L221;
    L224:
        boolean r81 = true;
    L225:
        if (r81 == true) goto L246;
        Iterator<T> r82 = r79.iterator();
    L228:
        if (r82.hasNext() == false) goto L238;
        Object r83 = r82.next();
        com.bytedance.android.livesdk.link.model.bridge.k r84 = (com.bytedance.android.livesdk.link.model.bridge.k) r83;
        if (r84 == null) goto L234;
        IBaseUser r85 = r84.getUser();
        if (r85 == null) goto L234;
        String r86 = r85.getIdString();
    L236:
        if (Intrinsics.areEqual(r86, ILinkerUpdateUserContentKt.getToUserIdString(r11)) == false) goto L228;
        r8 = r83;
    L234:
        r86 = null;
    L238:
        com.bytedance.android.livesdk.link.model.bridge.k r87 = (com.bytedance.android.livesdk.link.model.bridge.k) r8;
        if (r87 != null) goto L241;
    L245:
        R(r79, r11.getClientUiInfo(), r11.getVersion(), "backgroundMsg");
    L247:
        this.s = new a(System.currentTimeMillis(), "backgroundMsg", String.valueOf(r23.getMessageId3()), ILinkerUpdateUserContentKt.getUpdateInfoStr(r11));
        goto L248
    L241:
        if (ILinkerUpdateUserContentKt.isBackground(r11) == false) goto L243;
        long r88 = 1;
    L244:
        r87.setBackground(r88);
        goto L245
    L243:
        r88 = 0;
        goto L244
    L221:
        if (r80.isEmpty() == true) goto L224;
        r81 = false;
    L246:
        int r89 = this.c.indexOf(r56);
        ILinkPlayerInfoBridge r90 = com.bytedance.android.live.liveinteract.plantform.model.n.a(r56);
        r90.setBackground(ILinkerUpdateUserContentKt.isBackground(r11));
        this.c.set(r89, r90);
        goto L247
    L215:
        if (r56.isSelfBackground() == ILinkerUpdateUserContentKt.isBackground(r11)) goto L249;
    L127:
        r55 = null;
        goto L129
    L131:
        r53 = null;
        goto L132
    L116:
        r3 = null;
    L112:
        r1 = "";
        goto L113
    L106:
        r6 = null;
        goto L108
    L107:
        r6 = r24;
        goto L108
    L6:
        if (r23.getMType() != 12) goto L50;
        StringBuilder r91 = new StringBuilder("type:");
        r91.append(r23.getMType());
        r91.append("\nrtcmap size: ");
        com.bytedance.android.livesdk.message.linker.d r92 = r23.getMChangePlayModeContent();
        if (r92 == null) goto L18;
        com.bytedance.android.livesdk.message.linker.c r93 = r92.getChangePlayModeData();
        if (r93 == null) goto L18;
        v1 r94 = r93.getMultiRtcInfo();
        if (r94 == null) goto L18;
        g9 r95 = r94.getSingingChallengeRtcInfo();
        if (r95 == null) goto L18;
        Map r96 = r95.getRtcInfoMap();
        if (r96 == null) goto L18;
        Integer r97 = Integer.valueOf(r96.size());
    L19:
        r91.append(r97);
        r91.append("----\nuser count:");
        ILinkerUpdateUserContent r98 = r23.getMUpdateUser();
        if (r98 == null) goto L24;
        List r99 = r98.getMLinkUsers();
        if (r99 == null) goto L24;
        int r100 = r99.size();
    L25:
        r91.append(r100);
        r91.append("---user1 enlarge:");
        ILinkerUpdateUserContent r101 = r23.getMUpdateUser();
        if (r101 == null) goto L36;
        List r102 = r101.getMLinkUsers();
        if (r102 == null) goto L36;
        com.bytedance.android.livesdk.link.model.bridge.k r103 = (com.bytedance.android.livesdk.link.model.bridge.k) CollectionsKt.getOrNull(r102, 0);
        if (r103 == null) goto L36;
        k1 r104 = r103.getContent();
        if (r104 == null) goto L36;
        l1 r105 = r104.getLinkMicAudienceContent();
        if (r105 == null) goto L36;
        Boolean r106 = Boolean.valueOf(r105.isEnlarged());
    L37:
        r91.append(r106);
        r91.append("----\nuser2 enlarge:");
        ILinkerUpdateUserContent r107 = r23.getMUpdateUser();
        if (r107 == null) goto L48;
        List r108 = r107.getMLinkUsers();
        if (r108 == null) goto L48;
        com.bytedance.android.livesdk.link.model.bridge.k r109 = (com.bytedance.android.livesdk.link.model.bridge.k) CollectionsKt.getOrNull(r108, 1);
        if (r109 == null) goto L48;
        k1 r126 = r109.getContent();
        if (r126 == null) goto L48;
        l1 r127 = r126.getLinkMicAudienceContent();
        if (r127 == null) goto L48;
        Boolean r128 = Boolean.valueOf(r127.isEnlarged());
    L49:
        r91.append(r128);
        r91.append('\n');
        ALogger.i("printMsg", r91.toString());
    L48:
        r128 = null;
    L36:
        r106 = null;
    L24:
        r100 = 0;
    L18:
        r97 = null;
        goto L19
    L50:
        StringBuilder r129 = new StringBuilder("type:");
        r129.append(r23.getMType());
        r129.append("\nrtcmap size: ");
        com.bytedance.android.livesdk.message.linker.d r130 = r23.getMChangePlayModeContent();
        if (r130 == null) goto L61;
        com.bytedance.android.livesdk.message.linker.c r131 = r130.getChangePlayModeData();
        if (r131 == null) goto L61;
        v1 r132 = r131.getMultiRtcInfo();
        if (r132 == null) goto L61;
        g9 r133 = r132.getSingingChallengeRtcInfo();
        if (r133 == null) goto L61;
        Map r134 = r133.getRtcInfoMap();
        if (r134 == null) goto L61;
        Integer r135 = Integer.valueOf(r134.size());
    L62:
        r129.append(r135);
        r129.append("----\nuser count:");
        com.bytedance.android.livesdk.message.linker.d r136 = r23.getMChangePlayModeContent();
        if (r136 == null) goto L69;
        com.bytedance.android.livesdk.message.linker.c r137 = r136.getChangePlayModeData();
        if (r137 == null) goto L69;
        List r138 = r137.getLinkedUsers();
        if (r138 == null) goto L69;
        int r139 = r138.size();
    L70:
        r129.append(r139);
        r129.append("---\nuser1 enlarge:");
        com.bytedance.android.livesdk.message.linker.d r140 = r23.getMChangePlayModeContent();
        if (r140 == null) goto L83;
        com.bytedance.android.livesdk.message.linker.c r141 = r140.getChangePlayModeData();
        if (r141 == null) goto L83;
        List r142 = r141.getLinkedUsers();
        if (r142 == null) goto L83;
        com.bytedance.android.livesdk.link.model.bridge.k r143 = (com.bytedance.android.livesdk.link.model.bridge.k) CollectionsKt.getOrNull(r142, 0);
        if (r143 == null) goto L83;
        k1 r144 = r143.getContent();
        if (r144 == null) goto L83;
        l1 r145 = r144.getLinkMicAudienceContent();
        if (r145 == null) goto L83;
        Boolean r146 = Boolean.valueOf(r145.isEnlarged());
    L84:
        r129.append(r146);
        r129.append("----\nuser2 enlarge:");
        com.bytedance.android.livesdk.message.linker.d r147 = r23.getMChangePlayModeContent();
        if (r147 == null) goto L97;
        com.bytedance.android.livesdk.message.linker.c r148 = r147.getChangePlayModeData();
        if (r148 == null) goto L97;
        List r149 = r148.getLinkedUsers();
        if (r149 == null) goto L97;
        com.bytedance.android.livesdk.link.model.bridge.k r150 = (com.bytedance.android.livesdk.link.model.bridge.k) CollectionsKt.getOrNull(r149, 1);
        if (r150 == null) goto L97;
        k1 r151 = r150.getContent();
        if (r151 == null) goto L97;
        l1 r152 = r151.getLinkMicAudienceContent();
        if (r152 == null) goto L97;
        Boolean r153 = Boolean.valueOf(r152.isEnlarged());
    L98:
        r129.append(r153);
        r129.append('\n');
        ALogger.i("printMsg", r129.toString());
    L97:
        r153 = null;
    L83:
        r146 = null;
    L69:
        r139 = 0;
    L61:
        r135 = null;
        goto L62
    }

    public final void G(ILinkPlayerInfoBridge r6, ClientUIInfo r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION;
        r6.setClientUIPosition(ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION);
        if (((Boolean) bb0.a.getValue()).booleanValue() == true) goto L7;
        return;
    L7:
        String r2 = null;
        if (aj0.a.d() == false) goto L21;
        String r1 = this.a;
        StringBuilder r3 = new StringBuilder("clientUIInfo, processPlayerInfoClientUIPosition, crossRoomLinkmic: ");
        if (r7 == null) goto L14;
        CrossRoomLinkmicUIInfo r4 = r7.getCrossRoomLinkmic();
        if (r4 == null) goto L14;
        String r5 = r4.toString();
    L15:
        r3.append(r5);
        ALogger.d(r1, r3.toString());
        if (r7 == null) goto L18;
        CrossRoomLinkmicUIInfo r8 = r7.getCrossRoomLinkmic();
    L19:
        if (r8 != null) goto L21;
        ALogger.e(this.a, "clientUIInfo, processPlayerInfoClientUIPosition, crossRoomLinkmic is null, trace: " + Log.getStackTraceString(new Throwable()));
        goto L21
    L18:
        r8 = null;
    L14:
        r5 = null;
    L21:
        if (r7 == null) goto L34;
        CrossRoomLinkmicUIInfo r9 = r7.getCrossRoomLinkmic();
        if (r9 == null) goto L35;
        Map r10 = CrossRoomLinkmicUIInfoMainKt.getUserInfoString(r9);
        if (r10 == null) goto L32;
        IBaseUser r11 = r6.getUser();
        if (r11 == null) goto L29;
        r2 = r11.getIdString();
    L29:
        UserInfo r12 = (UserInfo) r10.get(r2);
        if (r12 == null) goto L32;
        r0 = (int) r12.getClientPosition();
    L32:
        r6.setClientUIPosition(r0);
        return;
    L35:
        return;
    }

    public final void I(boolean r13, String r14) {
        if (this.k == false) goto L5;
        return;
    L5:
        this.k = true;
        if (vm2.d.k() == false) goto L8;
        long r0 = System.currentTimeMillis();
        this.o.add(((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getLinkWaitingList(this.M.getId(), 50, "").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this, r0, r13), new m(this, r0)));
        return;
    L8:
        this.o.add(((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getAllList(this.M.getId(), this.M.getOwnerUserIdString(), d5.c(this.M.getOwnerUserIdString()), 1, 0, false, r14).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this, r13), new o(this)));
    }

    public final void N(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r6, boolean r7) {
        if (r7 == false) goto L18;
        Iterator r8 = ((ArrayList) this.y).iterator();
    L5:
        if (r8.hasNext() == false) goto L18;
        String r0 = (String) r8.next();
        Iterator<T> r1 = r6.iterator();
    L7:
        Object r3 = null;
        if (r1.hasNext() == false) goto L16;
        Object r2 = r1.next();
        IBaseUser r4 = ((com.bytedance.android.livesdk.link.model.bridge.k) r2).getUser();
        if (r4 == null) goto L13;
        r3 = r4.getIdString();
    L13:
        if (Intrinsics.areEqual(r0, r3) == false) goto L7;
        r3 = r2;
    L16:
        if (((com.bytedance.android.livesdk.link.model.bridge.k) r3) != null) goto L5;
        r8.remove();
    L18:
        Iterator<T> r9 = r6.iterator();
    L20:
        if (r9.hasNext() == false) goto L32;
        IBaseUser r10 = ((com.bytedance.android.livesdk.link.model.bridge.k) r9.next()).getUser();
        if (r10 == null) goto L20;
        String r11 = r10.getIdString();
        if (r11 == null) goto L20;
        if (this.z.containsKey(r11) == true) goto L20;
        if (((IInteractService) jc1.k.n(IInteractService.class)).tryGetTargetUserType(r11) != UserType.ANCHOR) goto L30;
        boolean r5 = true;
    L31:
        this.z.put(r11, Boolean.valueOf(r5));
        goto L20
    L30:
        r5 = false;
        goto L31
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final /* bridge */ /* synthetic */ com.bytedance.android.live.liveinteract.plantform.base.h a5(String r1, String r2) {
        return p(r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final /* bridge */ /* synthetic */ com.bytedance.android.live.liveinteract.plantform.base.h getGuestInfo(String r1, String r2) {
        return o(r1, r2);
    }

    public final ILinkPlayerInfoBridge o(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Iterator<ILinkPlayerInfoBridge> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ILinkPlayerInfoBridge r1 = r0.next();
        if (x(r4, r5, r1) == false) goto L4;
        return r1;
    L8:
        Iterator<ILinkPlayerInfoBridge> r2 = this.f.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        ILinkPlayerInfoBridge r3 = r2.next();
        if (x(r4, r5, r3) == false) goto L10;
        return r3;
    L14:
        Iterator<ILinkPlayerInfoBridge> r6 = this.h.iterator();
    L16:
        if (r6.hasNext() == false) goto L21;
        ILinkPlayerInfoBridge r7 = r6.next();
        if (x(r4, r5, r7) == false) goto L16;
        return r7;
    L21:
        if (je0.d.z() == false) goto L28;
        Iterator<ILinkPlayerInfoBridge> r8 = this.d.iterator();
    L24:
        if (r8.hasNext() == false) goto L42;
        ILinkPlayerInfoBridge r9 = r8.next();
        if (x(r4, r5, r9) == false) goto L24;
        return r9;
    L42:
        return null;
    L28:
        return null;
    }

    public final ILinkPlayerInfoBridge p(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Iterator<ILinkPlayerInfoBridge> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ILinkPlayerInfoBridge r1 = r0.next();
        if (x(r4, r5, r1) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public final void s(w0 r13, String r14) {
        List<com.bytedance.android.livesdk.link.model.bridge.k> r0 = r13.getMPlayerInfo();
        boolean r1 = true;
        if (r0 == null) goto L5;
        ArrayList<ILinkPlayerInfoBridge> r2 = je0.d.f0(r0, true);
    L6:
        List<LinkmicPositionItem> r3 = r13.getPositions();
        com.bytedance.android.live.liveinteract.plantform.model.q r4 = r13.getLinkerBaseInfo();
        Long r5 = null;
        if (r4 == null) goto L17;
        Integer r6 = Integer.valueOf(r4.getMaxMemberCount());
        if (r6.intValue() > 0) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L17;
        this.F = Integer.valueOf(r6.intValue());
    L17:
        String r7 = this.a;
        StringBuilder r8 = new StringBuilder("handleListV2ResponseData update currentMaxMemberCount=");
        com.bytedance.android.live.liveinteract.plantform.model.q r9 = r13.getLinkerBaseInfo();
        if (r9 == null) goto L20;
        Integer r10 = Integer.valueOf(r9.getMaxMemberCount());
    L21:
        r8.append(r10);
        ALogger.i(r7, r8.toString());
        S(r13.getPreOnlineList());
        if (Lists.isEmpty(r2) == false) goto L24;
        return;
    L24:
        List<com.bytedance.android.livesdk.link.model.bridge.k> r11 = r13.getMPlayerInfo();
        if (r11 == null) goto L28;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r12 = CollectionsKt.toList(r11);
        if (r12 == null) goto L28;
    L29:
        boolean r15 = R(r12, r13.getClientUiInfo(), r13.getVersion(), r14);
        if (P(r13.getLinkerContentMap(), r13.getClientUiInfo(), r13.getVersion(), r14, this.d) == true) goto L32;
        if (r15 == true) goto L32;
    L33:
        this.e.clear();
        if (r3 == null) goto L36;
        this.e.addAll(r3);
    L36:
        ALogger.w(this.a, "list onOnlineListChanged callback");
        int r16 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r17 = this.N;
        IRoom r18 = this.M;
        if (r18 == null) goto L39;
        Long r19 = Long.valueOf(r18.getId());
    L40:
        MultiSceneEnterRoomStatisticsUtils r20 = MultiSceneEnterRoomStatisticsUtils.a.a(r17, Long.valueOf(r19.longValue()));
        if (r20 == null) goto L43;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r20, "list_v2_time", 0, 2, null);
    L43:
        DataCenter r110 = this.N;
        IRoom r111 = this.M;
        if (r111 == null) goto L46;
        r5 = Long.valueOf(r111.getId());
    L46:
        MultiSceneEnterRoomStatisticsUtils r112 = MultiSceneEnterRoomStatisticsUtils.a.a(r110, Long.valueOf(r5.longValue()));
        if (r112 == null) goto L49;
        r112.c();
    L49:
        System.currentTimeMillis();
        Iterator r113 = ((ArrayList) this.n).iterator();
    L51:
        if (r113.hasNext() == false) goto L57;
        com.bytedance.android.live.liveinteract.plantform.base.i.b r114 = (com.bytedance.android.live.liveinteract.plantform.base.i.b) r113.next();
        r114.e(this.e);
        r114.onOnlineListChanged(this.c);
        int r21 = x.a;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r22 = this.c;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r23 = this.d;
        Intrinsics.checkNotNullParameter(r22, "selfList");
        Intrinsics.checkNotNullParameter(r23, "peerList");
        CopyOnWriteArrayList r24 = new CopyOnWriteArrayList();
        r24.addAll(r22);
        Iterator r25 = r24.iterator();
    L54:
        if (r25.hasNext() == false) goto L56;
        ILinkPlayerInfoBridge r26 = (ILinkPlayerInfoBridge) r25.next();
        ILinkPlayerInfoBridge r27 = com.bytedance.android.live.liveinteract.plantform.model.n.a(r26);
        r27.setUserPosition(r27.getUserPosition() + r22.size());
        r24.set(r24.indexOf(r26), r27);
        goto L54
    L56:
        ALogger.i("LinkRoomMock", "mockPeerList: " + r24);
        this.d = r23;
        r114.d(this.c, r23);
        goto L51
    L57:
        J(this.c);
        tc0.c.h().v = b();
        return;
    L39:
        r19 = null;
    L32:
        this.s = new a(System.currentTimeMillis(), r14, "", null);
    L28:
        r12 = CollectionsKt.emptyList();
        goto L29
    L20:
        r10 = null;
        goto L21
    L5:
        r2 = new ArrayList();
        goto L6
    }

    public final void y(long r2, long r4) {
        this.H = true;
        LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
        if (r0 == null) goto L14;
        dc2.c r1 = r0.getTalkRoomListUserInfoPb();
        if (r1 == null) goto L15;
        Observable r3 = r1.d(r2, r4);
        if (r3 == null) goto L16;
        Observable r5 = r3.take(1);
        if (r5 == null) goto L17;
        Disposable r6 = r5.subscribe(new c(this), new d(this));
        if (r6 == null) goto L18;
        this.o.add(r6);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public final boolean z(h1 r19, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r20) {
        LinkRoomFightUpdateContent r6 = r19.getLinkerCrossRoomUpdateContentExt();
        if (r6 != null) goto L5;
        return false;
    L5:
        if (r20 != null) goto L7;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r9 = r6.getLinkedUsers();
    L8:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r0 = r9;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L18;
        boolean r10 = false;
    L30:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r2 = CollectionsKt.emptyList();
        Map r3 = r6.getLinkerContentMap();
        if (r3 == null) goto L67;
        Iterator r4 = r3.entrySet().iterator();
        if (r4 == null) goto L67;
        if (r4.hasNext() != true) goto L67;
        Map r5 = r6.getLinkerContentMap();
        if (r5 == null) goto L39;
        int r7 = r5.size();
    L40:
        if (r7 <= 1) goto L56;
        Map r8 = r6.getLinkerContentMap();
        if (r8 == null) goto L55;
        Collection r11 = r8.values();
        if (r11 == null) goto L55;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L47:
        if (r13.hasNext() == false) goto L54;
        com.bytedance.android.livesdk.link.model.bridge.g2 r14 = (com.bytedance.android.livesdk.link.model.bridge.g2) r13.next();
        if (r14 == null) goto L52;
        List r15 = r14.getLinkedUsers();
        if (r15 == null) goto L52;
    L53:
        CollectionsKt.addAll(r12, r15);
    L52:
        r15 = CollectionsKt.emptyList();
        goto L53
    L54:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r16 = r12;
    L68:
        int r17 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Long r18 = Long.valueOf(r19.getMessageId3());
        String r21 = r6.toString();
        if (r16 == null) goto L71;
        Integer r22 = Integer.valueOf(r16.size());
    L72:
        com.bytedance.android.live.liveinteract.plantform.utils.x.S(r18, r21, r22, false, "_link_room_fight");
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r23 = r16;
        if (r23 != null) goto L75;
    L78:
        boolean r24 = true;
    L79:
        if (r24 == true) goto L91;
        Map<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2> r25 = r6.getLinkerContentMap();
        if ((r6 instanceof LinkRoomFightUpdateContent) == true) goto L83;
        LinkRoomFightUpdateContent r26 = null;
    L84:
        LinkRoomFightUpdateContent r27 = r26;
        if (r27 == null) goto L87;
        ClientUIInfo r28 = r27.getClientUIInfo();
    L88:
        boolean r29 = P(r25, r28, r6.getVersion(), "crossRoomUpdateMsg", this.d);
        N(r16, false);
        if (r29 == false) goto L92;
        this.s = new a(System.currentTimeMillis(), "crossRoomUpdateMsg", String.valueOf(r19.getMessageId3()), null);
    L92:
        if (r29 == true) goto L94;
        if (r10 == true) goto L94;
        return false;
    L94:
        return true;
    L87:
        r28 = null;
        goto L88
    L83:
        r26 = r6;
        goto L84
    L91:
        this.d.clear();
        r29 = false;
        goto L92
    L75:
        if (r23.isEmpty() == true) goto L78;
        r24 = false;
        goto L79
    L71:
        r22 = null;
    L55:
        r2 = CollectionsKt.emptyList();
        goto L67
    L56:
        Map r30 = r6.getLinkerContentMap();
        if (r30 == null) goto L66;
        Iterator r31 = r30.entrySet().iterator();
        if (r31 == null) goto L66;
        Map.Entry r32 = (Map.Entry) r31.next();
        if (r32 == null) goto L66;
        com.bytedance.android.livesdk.link.model.bridge.g2 r33 = (com.bytedance.android.livesdk.link.model.bridge.g2) r32.getValue();
        if (r33 == null) goto L66;
        r2 = r33.getLinkedUsers();
        if (r2 != null) goto L67;
    L66:
        r2 = CollectionsKt.emptyList();
        goto L67
    L39:
        r7 = 0;
    L67:
        r16 = r2;
        goto L68
    L18:
        if ((r6 instanceof LinkRoomFightUpdateContent) == true) goto L20;
        LinkRoomFightUpdateContent r34 = null;
    L21:
        LinkRoomFightUpdateContent r35 = r34;
        if (r35 == null) goto L24;
        ClientUIInfo r36 = r35.getClientUIInfo();
    L25:
        boolean r37 = R(r9, r36, r6.getVersion(), "crossRoomUpdateMsg");
        N(r9, true);
        if (r37 == false) goto L28;
        this.s = new a(System.currentTimeMillis(), "crossRoomUpdateMsg", String.valueOf(r19.getMessageId3()), null);
    L28:
        r10 = r37;
        goto L30
    L24:
        r36 = null;
        goto L25
    L20:
        r34 = r6;
        goto L21
    L11:
        if (r0.isEmpty() == true) goto L14;
        r1 = false;
        goto L16
    L7:
        r9 = r20;
        goto L8
    }

    public static boolean x(String r3, String r4, ILinkPlayerInfoBridge r5) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
    L13:
        if (r5 != null) goto L15;
    L30:
        return false;
    L15:
        if (r5.getUser() == null) goto L30;
        if (r2.a(r3) == false) goto L26;
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L22;
        String r7 = r6.getIdString();
    L24:
        if (Intrinsics.areEqual(r7, r3) == false) goto L26;
        return true;
    L22:
        r7 = null;
    L26:
        if (TextUtils.isEmpty(r4) == true) goto L30;
        if (TextUtils.equals(r5.getInteractId(), r4) == false) goto L30;
        return true;
    L11:
        if (TextUtils.isEmpty(r4) == false) goto L13;
        return false;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void Q(List<LinkmicPositionItem> r10, boolean r11, boolean r12) {
        F(r10);
        Iterator<LinkmicPositionItem> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        LinkmicPositionItem r1 = r0.next();
        if (r11 == true) goto L7;
        r1.setActiveName("");
        r1.setVerifyStatus(0);
        r1.setPositionType(LinkmicPositionItem.LinkmicPositionType.NORMAL.ordinal());
        goto L4
    L7:
        r1.setStatus(LinkmicPositionItem.LinkmicPositionStatus.NORMAL.ordinal());
        goto L4
    L9:
        if (r10 == null) goto L29;
        Iterator<T> r13 = r10.iterator();
    L12:
        if (r13.hasNext() == false) goto L29;
        LinkmicPositionItem r2 = (LinkmicPositionItem) r13.next();
        Iterator<LinkmicPositionItem> r3 = this.e.iterator();
    L15:
        if (r3.hasNext() == false) goto L22;
        LinkmicPositionItem r4 = r3.next();
        if (r4.getPosition() != r2.getPosition()) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L15;
    L23:
        LinkmicPositionItem r6 = r4;
        if (r6 == null) goto L25;
        if (r11 == true) goto L27;
        r6.setActiveName(r2.getActiveName());
        r6.setVerifyStatus(r2.getVerifyStatus());
        r6.setPositionType(r2.getPositionType());
        goto L12
    L27:
        r6.setStatus(r2.getStatus());
        goto L12
    L25:
        this.e.add(r2);
        goto L12
    L19:
        r5 = false;
        goto L20
    L22:
        r4 = null;
    L29:
        if (r12 == false) goto L34;
        Iterator r14 = ((ArrayList) this.n).iterator();
    L32:
        if (r14.hasNext() == false) goto L56;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r14.next()).e(this.e);
        goto L32
    L56:
        return;
    }

    public final void T(String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "targetUserId");
        Iterator<ILinkPlayerInfoBridge> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        ILinkPlayerInfoBridge r1 = r0.next();
        if (x(r4, r5, r1) == false) goto L4;
        r1.setSilenceStatus(r6);
        return;
    }

    public final boolean R(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r31, ClientUIInfo r32, long r33, String r35) {
        if (r31 == null) goto L6;
        List r5 = CollectionsKt.toMutableList(r31);
        if (r5 == null) goto L6;
    L8:
        if (this.w == true) goto L11;
        y r1 = this;
        Object r19 = "listV2";
    L191:
        if (r5.isEmpty() == false) goto L195;
        return false;
    L195:
        if (Intrinsics.areEqual(r35, r19) == false) goto L197;
    L275:
        r1.c.clear();
        r1.c.addAll(je0.d.f0(r5, true));
        Iterator<ILinkPlayerInfoBridge> r2 = r1.c.iterator();
    L277:
        if (r2.hasNext() == false) goto L279;
        r1.G(r2.next(), r32);
        goto L277
    L279:
        return true;
    L197:
        if (Intrinsics.areEqual(r35, "enter_backend") == true) goto L275;
        if (Intrinsics.areEqual(r35, "wrdsPreload") == true) goto L275;
        ArrayList r0 = new ArrayList();
        Iterator r3 = r5.iterator();
    L203:
        if (r3.hasNext() == false) goto L273;
        com.bytedance.android.livesdk.link.model.bridge.k r4 = (com.bytedance.android.livesdk.link.model.bridge.k) r3.next();
        Iterator<ILinkPlayerInfoBridge> r6 = r1.c.iterator();
    L206:
        if (r6.hasNext() == false) goto L218;
        ILinkPlayerInfoBridge r7 = r6.next();
        ILinkPlayerInfoBridge r8 = r7;
        IBaseUser r9 = r4.getUser();
        if (r9 == null) goto L210;
        String r10 = r9.getIdString();
    L211:
        IBaseUser r11 = r8.getUser();
        if (r11 == null) goto L214;
        String r12 = r11.getIdString();
    L216:
        if (Intrinsics.areEqual(r10, r12) == false) goto L206;
    L219:
        ILinkPlayerInfoBridge r13 = r7;
        if (r13 == null) goto L221;
        ILinkPlayerInfoBridge r14 = com.bytedance.android.live.liveinteract.plantform.model.n.a(r13);
        je0.d.h0(r14, r4);
        if (((Boolean) vm2.d.t8.getValue(null, vm2.d.a[484(0x1e4, float:6.78E-43)])).booleanValue() == false) goto L258;
        if (r4.isBackground() != 1) goto L251;
        boolean r15 = true;
    L252:
        r14.setBackground(r15);
        if (r4.isBackground() != 1) goto L255;
        boolean r16 = true;
    L256:
        r14.setSelfBackground(r16);
    L272:
        r0.add(r14);
        r1.G(r14, r32);
        goto L203
    L255:
        r16 = false;
        goto L256
    L251:
        r15 = false;
        goto L252
    L258:
        if (Intrinsics.areEqual(r35, "backgroundMsg") == true) goto L264;
        if (Intrinsics.areEqual(r35, "unSilence onResume") == false) goto L272;
    L264:
        if (r4.isBackground() != 1) goto L266;
        boolean r17 = true;
    L267:
        r14.setBackground(r17);
        if (r4.isBackground() != 1) goto L270;
        boolean r18 = true;
    L271:
        r14.setSelfBackground(r18);
        goto L272
    L270:
        r18 = false;
        goto L271
    L266:
        r17 = false;
        goto L267
    L221:
        ILinkPlayerInfoBridge r20 = je0.d.d0(r4, false);
        if (((Boolean) vm2.d.t8.getValue(null, vm2.d.a[484(0x1e4, float:6.78E-43)])).booleanValue() == false) goto L233;
        if (r4.isBackground() != 1) goto L226;
        boolean r21 = true;
    L227:
        r20.setBackground(r21);
        if (r4.isBackground() != 1) goto L230;
        boolean r22 = true;
    L231:
        r20.setSelfBackground(r22);
    L245:
        r0.add(r20);
        r1.G(r20, r32);
        goto L203
    L230:
        r22 = false;
        goto L231
    L226:
        r21 = false;
        goto L227
    L233:
        if (Intrinsics.areEqual(r35, "backgroundMsg") == true) goto L237;
        if (Intrinsics.areEqual(r35, "unSilence onResume") == false) goto L245;
    L237:
        if (r4.isBackground() != 1) goto L239;
        boolean r23 = true;
    L240:
        r20.setBackground(r23);
        if (r4.isBackground() != 1) goto L243;
        boolean r24 = true;
    L244:
        r20.setSelfBackground(r24);
        goto L245
    L243:
        r24 = false;
        goto L244
    L239:
        r23 = false;
        goto L240
    L214:
        r12 = null;
        goto L216
    L210:
        r10 = null;
        goto L211
    L218:
        r7 = null;
        goto L219
    L273:
        r1.c.clear();
        r1.c.addAll(r0);
        return true;
    L11:
        if (r33 <= 0) goto L154;
        long r110 = this.t;
        if (r33 >= r110) goto L154;
        com.bytedance.android.live.liveinteract.plantform.utils.z r111 = this.x;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r112 = this.c;
        a r25 = this.s;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r35, "from");
        Intrinsics.checkNotNullParameter(r5, "linkUsers");
        Intrinsics.checkNotNullParameter(r112, "currentLinkUsers");
        if ((!Intrinsics.areEqual(r35, "listV2")) == false) goto L22;
        if (r25 == null) goto L18;
        String r26 = r25.b;
    L20:
        if (Intrinsics.areEqual(r26, "listV2") == false) goto L22;
        ALogger.w("ttlive_link_list_version", "listV2 invalid rollback, [" + r35 + "] last=" + r25 + " current=" + r110 + ", new=" + r33);
        r5 = r5;
        r19 = "listV2";
    L108:
        boolean r27 = false;
    L109:
        r1 = this;
        if (r1.v.interceptOldVersion == false) goto L125;
        ALogger.e(r1.a, "interceptOldVersion");
        r5 = new ArrayList();
        goto L191
    L125:
        if (r27 == false) goto L153;
        ArrayList r28 = new ArrayList();
        Iterator r29 = r5.iterator();
    L128:
        if (r29.hasNext() == false) goto L148;
        com.bytedance.android.livesdk.link.model.bridge.k r30 = (com.bytedance.android.livesdk.link.model.bridge.k) r29.next();
        Iterator<ILinkPlayerInfoBridge> r34 = r1.c.iterator();
    L131:
        if (r34.hasNext() == false) goto L143;
        ILinkPlayerInfoBridge r36 = r34.next();
        ILinkPlayerInfoBridge r37 = r36;
        IBaseUser r38 = r30.getUser();
        if (r38 == null) goto L135;
        String r39 = r38.getIdString();
    L136:
        IBaseUser r40 = r37.getUser();
        if (r40 == null) goto L139;
        String r41 = r40.getIdString();
    L141:
        if (Intrinsics.areEqual(r39, r41) == false) goto L131;
    L144:
        ILinkPlayerInfoBridge r42 = r36;
        if (r42 != null) goto L146;
        r28.add(r30);
        goto L128
    L146:
        r30.setStatus(r42.getLinkStatus());
        r30.setLinkType(r42.getLinkType());
        r30.setUserPosition(r42.getUserPosition());
        r30.setSilenceStatus(r42.getSilenceStatus());
        r30.setMcStatus(r42.getMcStatus());
        r30.setBackground(r42.isBackground() ? 1 : 0);
        goto L128
    L139:
        r41 = null;
        goto L141
    L135:
        r39 = null;
        goto L136
    L143:
        r36 = null;
        goto L144
    L148:
        Iterator r43 = r28.iterator();
    L150:
        if (r43.hasNext() == false) goto L152;
        r5.remove((com.bytedance.android.livesdk.link.model.bridge.k) r43.next());
        goto L150
    L152:
        List r113 = r5;
        ALogger.e(r1.a, "correct link version data, removedUsers=" + r28.size() + ", corrected list=" + je0.d.g0(r113));
    L189:
        r5 = r113;
        goto L191
    L153:
        r113 = r5;
        goto L189
    L18:
        r26 = null;
    L22:
        r19 = "listV2";
        if (r5.size() == r112.size()) goto L25;
        ALogger.e("ttlive_link_list_version", "checkRollback: list size diff current=" + r112.size() + " new=" + r5.size());
        String r44 = "list size diff";
        r5 = r5;
    L103:
        if (r44.length() != 0) goto L105;
        boolean r45 = true;
    L106:
        if (r45 == false) goto L110;
        ALogger.e("ttlive_link_list_version", "invalid rollback, [" + r35 + "] last=" + r25 + " cnt=" + r111.b);
        goto L108
    L110:
        r111.b++;
        ALogger.e("ttlive_link_list_version", "[" + r35 + "] version rollback! type=" + r44 + "; cnt=" + r111.b + ", last=" + r25 + " current=" + r110 + ", new=" + r33);
        LinkedHashMap r46 = new LinkedHashMap();
        r46.put("new_list_version", Long.valueOf(r33));
        r46.put("version_diff", Long.valueOf(r110 - r33));
        r46.put("error_msg", r44);
        com.bytedance.android.live.liveinteract.plantform.utils.z.a(r46, r35, r110, r25);
        if ((r111.b % r111.a) != 0) goto L114;
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("fatal_list_version_rollback", r46);
    L121:
        r27 = true;
        goto L109
    L114:
        if (hd0.c.f().h() == false) goto L121;
        if ((System.currentTimeMillis() - r111.g) <= 60000) goto L121;
        r111.g = System.currentTimeMillis();
        if (r111.c == false) goto L120;
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("list_version_rollback", r46);
        goto L121
    L120:
        ALogger.w("ttlive_link_list_version", r46.toString());
        goto L121
    L105:
        r45 = false;
        goto L106
    L25:
        int r47 = r5.size();
        int r114 = 0;
    L26:
        if (r114 >= r47) goto L101;
        com.bytedance.android.livesdk.link.model.bridge.k r115 = (com.bytedance.android.livesdk.link.model.bridge.k) ListProtector.get(r5, r114);
        if (je0.d.y() == true) goto L46;
        Iterator<ILinkPlayerInfoBridge> r210 = r112.iterator();
    L31:
        if (r210.hasNext() == false) goto L44;
        ILinkPlayerInfoBridge r211 = r210.next();
        IBaseUser r212 = r211.getUser();
        if (r212 == null) goto L35;
        String r48 = r212.getIdString();
    L36:
        IBaseUser r213 = r115.getUser();
        if (r213 == null) goto L39;
        String r49 = r213.getIdString();
    L41:
        if (Intrinsics.areEqual(r48, r49) == true) goto L45;
        r47 = r47;
        r5 = r5;
    L45:
        ILinkPlayerInfoBridge r214 = r211;
    L47:
        if (r214 == null) goto L48;
        IBaseUser r50 = r115.getUser();
        if (r50 == null) goto L52;
        String r51 = r50.getIdString();
    L53:
        IBaseUser r52 = r214.getUser();
        if (r52 == null) goto L56;
        String r53 = r52.getIdString();
    L58:
        if ((!Intrinsics.areEqual(r51, r53)) == true) goto L87;
        if (r115.getStatus() != r214.getLinkStatus()) goto L87;
        if (r115.getLinkType() != r214.getLinkType()) goto L87;
        if (r115.getUserPosition() != r214.getUserPosition()) goto L87;
        if (r115.getSilenceStatus() != r214.getSilenceStatus()) goto L87;
        if (r115.getMcStatus() != r214.getMcStatus()) goto L87;
        long r215 = r115.isBackground();
        if (r214.isBackground() == false) goto L72;
        long r216 = 1;
    L74:
        if (r215 != r216) goto L87;
        k1 r54 = r115.getContent();
        if (r54 == null) goto L82;
        l1 r55 = r54.getLinkMicAudienceContent();
        if (r55 == null) goto L82;
        if (r55.isEnlarged() != true) goto L82;
        boolean r56 = true;
    L84:
        if (r56 != r214.isEnlarged()) goto L87;
        r114 = r114 + 1;
        r47 = r47;
        r5 = r5;
    L82:
        r56 = false;
        goto L84
    L72:
        r216 = 0;
    L87:
        StringBuilder r57 = new StringBuilder("checkRollback: user diff at ");
        r57.append(r114);
        r57.append(", current=");
        StringBuilder r58 = new StringBuilder("ILinkPlayerInfoBridge{uid=");
        IBaseUser r116 = r214.getUser();
        if (r116 == null) goto L90;
        String r117 = r116.getIdString();
    L91:
        r58.append(r117);
        r58.append(",linkId=");
        r58.append(r214.getInteractId());
        r58.append(",linkType=");
        r58.append(r214.getLinkType());
        r58.append(",silence=");
        r58.append(r214.getSilenceStatus());
        r58.append(",userPos=");
        r58.append(r214.getUserPosition());
        r58.append(",mc=");
        r58.append(r214.getMcStatus());
        r58.append(",isBg=");
        r58.append(r214.isBackground());
        r58.append(", isCPos=");
        r58.append(r214.isEnlarged());
        r58.append('}');
        r57.append(r58.toString());
        r57.append(", new=");
        r57.append(com.bytedance.android.live.liveinteract.plantform.utils.z.b(r115));
        ALogger.e("ttlive_link_list_version", r57.toString());
        if (r25 == null) goto L94;
        String r59 = r25.b;
    L96:
        if (Intrinsics.areEqual(r59, MultiLinkOpenSource.MESSAGE) == true) goto L98;
    L100:
        r44 = "list user diff at " + r114;
        goto L103
    L98:
        if (StringsKt.contains$default(r35, "Msg", false, 2, null) == false) goto L100;
        r44 = "list user diff at " + r114 + " message disorder";
        goto L103
    L94:
        r59 = null;
        goto L96
    L90:
        r117 = null;
        goto L91
    L56:
        r53 = null;
        goto L58
    L52:
        r51 = null;
        goto L53
    L48:
        ALogger.e("ttlive_link_list_version", "checkRollback: newUser doesn't exist in current list, new=" + com.bytedance.android.live.liveinteract.plantform.utils.z.b(r115));
        r44 = "current list no such user " + com.bytedance.android.live.liveinteract.plantform.utils.z.b(r115);
        goto L103
    L39:
        r49 = null;
        goto L41
    L35:
        r48 = null;
        goto L36
    L44:
        r5 = r5;
        r47 = r47;
        r211 = null;
        goto L45
    L46:
        r5 = r5;
        r47 = r47;
        r214 = (ILinkPlayerInfoBridge) ListProtector.get(r112, r114);
        goto L47
    L101:
        r5 = r5;
        r44 = "";
    L154:
        r1 = this;
        r113 = r5;
        r19 = "listV2";
        if (r33 != 0) goto L177;
        com.bytedance.android.live.liveinteract.plantform.utils.z r60 = r1.x;
        long r118 = r1.t;
        a r61 = r1.s;
        r60.getClass();
        Intrinsics.checkNotNullParameter(r35, "from");
        Intrinsics.checkNotNullParameter(r113, "linkUsers");
        r60.e++;
        ALogger.e("ttlive_link_list_version", "[" + r35 + "] listVersion zero, cnt=" + r60.e + ", current=" + r118 + ", list=" + je0.d.g0(r113));
        LinkedHashMap r62 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.plantform.utils.z.a(r62, r35, r118, r61);
        if ((r60.e % r60.d) != 0) goto L168;
        if (hd0.c.f().h() == false) goto L168;
        if (r60.f == false) goto L168;
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("fatal_zero_list_version", r62);
        if (r60.e > r60.d) goto L165;
        boolean r63 = true;
    L166:
        r60.f = r63;
    L185:
        r1.t = r33;
        com.bytedance.android.live.liveinteract.plantform.utils.z r65 = r1.x;
        r65.b = 0;
        if (r33 == 0) goto L188;
        r65.e = 0;
    L188:
        ALogger.i(r1.a, "processListWithVersion " + r35 + " list_version=" + r33);
        goto L189
    L165:
        r63 = false;
    L168:
        if (hd0.c.f().h() == false) goto L185;
        if (r60.f == false) goto L185;
        if ((System.currentTimeMillis() - r60.h) < 60000) goto L185;
        r60.h = System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("list_version_zero", r62);
        goto L185
    L177:
        if (r33 != r1.t) goto L185;
        com.bytedance.android.live.liveinteract.plantform.utils.z r66 = r1.x;
        a r67 = r1.s;
        r66.getClass();
        Intrinsics.checkNotNullParameter(r35, "from");
        ALogger.e("ttlive_link_list_version", "[" + r35 + "] same version, from=" + r35 + " version=" + r33 + " refresh=" + r67);
        if (hd0.c.f().h() == false) goto L185;
        if ((System.currentTimeMillis() - r66.i) < 60000) goto L185;
        r66.i = System.currentTimeMillis();
        LinkedHashMap r68 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.plantform.utils.z.a(r68, r35, r33, r67);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("list_version_same", r68);
    L6:
        r5 = new ArrayList();
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final void S4(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r7, ClientUIInfo r8, long r9, String r11) {
        Intrinsics.checkNotNullParameter(r11, "api");
        if (vm2.d.P() == true) goto L5;
        return;
    L5:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r0 = r7;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L16;
        ALogger.e(this.a, "refreshOnlineUserList list is empty! version=" + r9 + " from=" + r11);
        return;
    L16:
        if (R(r7, r8, r9, r11) == true) goto L19;
        ALogger.e(this.a, "list not updated, from=" + r11 + " version=" + r9 + " current=" + this.t);
        return;
    L19:
        ALogger.w(this.a, "refreshList from=" + r11 + " version=" + r9 + " onOnlineListChanged callback");
        this.s = new a(System.currentTimeMillis(), r11, "", null);
        Iterator r10 = ((ArrayList) this.n).iterator();
    L21:
        if (r10.hasNext() == false) goto L23;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.b) r10.next()).l(this.c);
        goto L21
    L23:
        J(this.c);
        tc0.c.h().v = b();
        return;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }

    public final boolean P(Map<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2> r10, ClientUIInfo r11, long r12, String r14, CopyOnWriteArrayList<ILinkPlayerInfoBridge> r15) {
        tc0.c.h().l(r10);
        if (r10 == null) goto L5;
        int r1 = r10.size();
    L7:
        if (r1 <= 1) goto L20;
        if (r10 == null) goto L26;
        Collection<? extends com.bytedance.android.livesdk.link.model.bridge.g2> r2 = r10.values();
        if (r2 == null) goto L26;
        Collection r4 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L27;
        com.bytedance.android.livesdk.link.model.bridge.g2 r5 = (com.bytedance.android.livesdk.link.model.bridge.g2) r3.next();
        if (r5 == null) goto L18;
        List r6 = r5.getLinkedUsers();
        if (r6 == null) goto L18;
    L19:
        CollectionsKt.addAll(r4, r6);
    L18:
        r6 = CollectionsKt.emptyList();
    L27:
        if (r4 != null) goto L30;
        return false;
    L30:
        if (r10 == null) goto L36;
        Map.Entry r13 = z0.a(r10);
        if (r13 == null) goto L36;
        com.bytedance.android.livesdk.link.model.bridge.g2 r16 = (com.bytedance.android.livesdk.link.model.bridge.g2) r13.getValue();
        if (r16 == null) goto L36;
        long r7 = r16.getVersion();
    L37:
        List r17 = CollectionsKt.toMutableList(r4);
        if (this.w == false) goto L52;
        if (r12 <= 0) goto L46;
        if (r12 >= this.t) goto L46;
        ALogger.e(this.a, "link room list version rollback, still use new list");
    L46:
        if (this.t == r12) goto L48;
    L50:
        this.t = r12;
        this.u = r7;
        ALogger.i(this.a, "processLinkRoomListWithVersion " + r14 + " list_version=" + r12);
        goto L52
    L48:
        if (r7 >= this.u) goto L50;
        r17 = new ArrayList();
    L52:
        if (r17.isEmpty() == false) goto L55;
        return false;
    L55:
        if (Intrinsics.areEqual(r14, "listV2") == false) goto L61;
        r15.clear();
        r15.addAll(je0.d.f0(r17, true));
        Iterator r18 = r15.iterator();
    L58:
        if (r18.hasNext() == false) goto L60;
        G((ILinkPlayerInfoBridge) r18.next(), r11);
        goto L58
    L60:
        return true;
    L61:
        ArrayList r19 = new ArrayList();
        Iterator r110 = r17.iterator();
    L63:
        if (r110.hasNext() == false) goto L99;
        com.bytedance.android.livesdk.link.model.bridge.k r111 = (com.bytedance.android.livesdk.link.model.bridge.k) r110.next();
        Iterator r112 = r15.iterator();
    L66:
        if (r112.hasNext() == false) goto L78;
        Object r8 = r112.next();
        ILinkPlayerInfoBridge r9 = (ILinkPlayerInfoBridge) r8;
        IBaseUser r20 = r111.getUser();
        if (r20 == null) goto L70;
        String r21 = r20.getIdString();
    L71:
        IBaseUser r22 = r9.getUser();
        if (r22 == null) goto L74;
        String r23 = r22.getIdString();
    L76:
        if (Intrinsics.areEqual(r21, r23) == false) goto L66;
    L79:
        ILinkPlayerInfoBridge r24 = (ILinkPlayerInfoBridge) r8;
        if (r24 == null) goto L81;
        ILinkPlayerInfoBridge r113 = com.bytedance.android.live.liveinteract.plantform.model.n.a(r24);
        je0.d.h0(r113, r111);
        if (r111.isBackground() != 1) goto L93;
        boolean r25 = true;
    L94:
        r113.setBackground(r25);
        if (r111.isBackground() != 1) goto L97;
        boolean r114 = true;
    L98:
        r113.setSelfBackground(r114);
        r19.add(r113);
        G(r113, r11);
        goto L63
    L97:
        r114 = false;
        goto L98
    L93:
        r25 = false;
        goto L94
    L81:
        ILinkPlayerInfoBridge r115 = je0.d.d0(r111, false);
        if (r111.isBackground() != 1) goto L84;
        boolean r26 = true;
    L85:
        r115.setBackground(r26);
        if (r111.isBackground() != 1) goto L88;
        boolean r116 = true;
    L89:
        r115.setSelfBackground(r116);
        r19.add(r115);
        G(r115, r11);
        goto L63
    L88:
        r116 = false;
        goto L89
    L84:
        r26 = false;
        goto L85
    L74:
        r23 = null;
        goto L76
    L70:
        r21 = null;
        goto L71
    L78:
        r8 = null;
        goto L79
    L99:
        r15.clear();
        r15.addAll(r19);
        return true;
    L36:
        r7 = 0;
    L26:
        r4 = null;
        goto L27
    L20:
        if (r10 == null) goto L26;
        Map.Entry r27 = z0.a(r10);
        if (r27 == null) goto L26;
        com.bytedance.android.livesdk.link.model.bridge.g2 r28 = (com.bytedance.android.livesdk.link.model.bridge.g2) r27.getValue();
        if (r28 == null) goto L26;
        r4 = r28.getLinkedUsers();
        goto L27
    L5:
        r1 = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i
    public final void Y4(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r10, ClientUIInfo r11, long r12, String r14, Map<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2> r15) {
        Intrinsics.checkNotNullParameter(r14, "api");
        if (r15 != null) goto L7;
        S4(r10, r11, r12, r14);
        return;
    L7:
        if (vm2.d.P() == true) goto L9;
        return;
    L9:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r0 = r10;
        boolean r1 = false;
        if (r0 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L20;
        ALogger.e(this.a, "refreshOnlineUserList list is empty! version=" + r12 + " from=" + r14);
        return;
    L20:
        if (R(r10, r11, r12, r14) == true) goto L23;
        ALogger.e(this.a, "list not updated, from=" + r14 + " version=" + r12 + " current=" + this.t);
        return;
    L23:
        ALogger.w(this.a, "refreshList from=" + r14 + " version=" + r12 + " onOnlineListChanged callback");
        this.s = new a(System.currentTimeMillis(), r14, "", null);
        List r13 = CollectionsKt.emptyList();
        Iterator<Map.Entry<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2>> r3 = r15.entrySet().iterator();
        if (r3 != null) goto L26;
    L51:
        List r16 = r13;
        if (r16 != null) goto L54;
    L55:
        r1 = true;
    L56:
        if (r1 == false) goto L58;
        this.d.clear();
    L61:
        Iterator r17 = ((ArrayList) this.n).iterator();
    L63:
        if (r17.hasNext() == false) goto L65;
        com.bytedance.android.live.liveinteract.plantform.base.i.b r18 = (com.bytedance.android.live.liveinteract.plantform.base.i.b) r17.next();
        r18.onOnlineListChanged(this.c);
        r18.d(this.c, this.d);
        goto L63
    L65:
        J(this.c);
        tc0.c.h().v = b();
        return;
    L58:
        if (P(r15, r11, r12, "enterMsg", this.d) == false) goto L61;
        this.s = new a(System.currentTimeMillis(), r14, "", null);
        goto L61
    L54:
        if (r16.isEmpty() == false) goto L56;
    L26:
        if (r3.hasNext() != true) goto L51;
        if (r15.size() <= 1) goto L42;
        Collection<? extends com.bytedance.android.livesdk.link.model.bridge.g2> r19 = r15.values();
        if (r19 == null) goto L41;
        ArrayList r4 = new ArrayList();
        Iterator<T> r110 = r19.iterator();
    L33:
        if (r110.hasNext() == false) goto L40;
        com.bytedance.android.livesdk.link.model.bridge.g2 r5 = (com.bytedance.android.livesdk.link.model.bridge.g2) r110.next();
        if (r5 == null) goto L38;
        List r6 = r5.getLinkedUsers();
        if (r6 == null) goto L38;
    L39:
        CollectionsKt.addAll(r4, r6);
    L38:
        r6 = CollectionsKt.emptyList();
        goto L39
    L40:
        r13 = r4;
        goto L51
    L41:
        r13 = CollectionsKt.emptyList();
        goto L51
    L42:
        Iterator<Map.Entry<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2>> r111 = r15.entrySet().iterator();
        if (r111 == null) goto L50;
        Map.Entry<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2> r112 = r111.next();
        if (r112 == null) goto L50;
        com.bytedance.android.livesdk.link.model.bridge.g2 r113 = r112.getValue();
        if (r113 == null) goto L50;
        r13 = r113.getLinkedUsers();
        if (r13 != null) goto L51;
    L50:
        r13 = CollectionsKt.emptyList();
        goto L51
    L12:
        if (r0.isEmpty() == true) goto L15;
        r2 = false;
        goto L16
    }
}
