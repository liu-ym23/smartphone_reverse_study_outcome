package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.OpenFeatureScene;
import com.bytedance.android.live.broadcastgame.api.model.l0;
import com.bytedance.android.live.broadcastgame.api.model.n0;
import com.bytedance.android.live.broadcastgame.api.model.p;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.LiveOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenFeatureListHandler implements a20.i {
    public static final /* synthetic */ int i = 0;
    public p a;
    public InteractEntranceCell b;
    public final AtomicBoolean c;
    public final AtomicBoolean d;
    public final Map<String, InteractEntranceCell> e;
    public final AbsOpenFeaturePanelViewModel f;
    public final a20.k g;
    public final /* synthetic */ i20.a h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ OpenFeatureListHandler a;
        public final /* synthetic */ Function1 b;

        public b(OpenFeatureListHandler r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            p r4 = (p) r3;
            if (this.a.f.getHasReceivedOpenFeatureListData() == true) goto L7;
            this.a.a = r4;
            int r0 = q.a;
            q.g("loadOpenFeatureListFromLocal success", "OpenFeatureListHandler");
            this.b.invoke(r4);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.invoke();
            int r0 = q.a;
            q.i((Throwable) r3, "OpenFeatureListHandler", "loadOpenFeatureListFromLocal error");
        }
    }

    static {
    }

    @Override // a20.i
    public final void k() {
        this.b = null;
    }

    public final void n(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.h.a(r2);
    }

    @Override // a20.i
    public final void d() {
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        int r1 = 0;
        r0.element = false;
        su0.a r2 = yt0.c.g();
        if (r2 == null) goto L6;
        r1 = r2.pf();
    L6:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L13;
        a20.k r3 = this.g;
        long r4 = t();
        long r6 = s();
        int r8 = u();
        String r9 = q();
        p r11 = this.a;
        if (r11 == null) goto L11;
        String r12 = r11.hash;
        if (r12 == null) goto L11;
    L12:
        Observable<com.bytedance.android.live.network.response.e<p>> r5 = r3.d(r4, r6, r8, r9, r12, r1, "click");
    L19:
        he1.a r7 = new he1.a(r5);
        Function0<Unit> r13 = new OpenFeatureListHandler$fetchOpenFeatureList$$inlined$reqGoGo$lambda$1(this, r0);
        Intrinsics.checkNotNullParameter(r13, "onStart");
        r7.a = r13;
        Function1<com.bytedance.android.live.network.response.e<p>, Unit> r14 = new OpenFeatureListHandler$fetchOpenFeatureList$$inlined$reqGoGo$lambda$2(this, r0);
        Intrinsics.checkNotNullParameter(r14, "onSuccess");
        r7.b = r14;
        Function1<Throwable, Unit> r15 = new OpenFeatureListHandler$fetchOpenFeatureList$$inlined$reqGoGo$lambda$3(this, r0);
        Intrinsics.checkNotNullParameter(r15, "onFail");
        r7.c = r15;
        Unit r16 = Unit.INSTANCE;
        n(r7.a());
        return;
    L11:
        r12 = "0";
        goto L12
    L13:
        a20.k r17 = this.g;
        long r18 = t();
        long r19 = s();
        int r21 = u();
        String r22 = q();
        p r110 = this.a;
        if (r110 == null) goto L17;
        String r111 = r110.hash;
        if (r111 == null) goto L17;
    L18:
        r5 = r17.c(r18, r19, r21, r22, r1, r111);
    L17:
        r111 = "0";
        goto L18
    }

    @Override // a20.i
    public final boolean e() {
        p r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if ((!r0.entranceList.isEmpty()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L13;
        y(this, r0.entranceList, r0.groupProperty, r0.groupOrder, r0.tabOrder, r0.selectedGroup, true);
        return true;
    L13:
        return false;
    }

    @Override // a20.c
    public final void onDestroy() {
        this.h.b();
    }

    public final String p() {
        AbsOpenFeaturePanelViewModel r0 = this.f;
        if ((r0 instanceof LiveOpenFeaturePanelViewModel) == true) goto L5;
        r0 = null;
    L5:
        LiveOpenFeaturePanelViewModel r1 = (LiveOpenFeaturePanelViewModel) r0;
        if (r1 == null) goto L15;
        a20.b r2 = r1.getOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease();
        if (r2 != null) goto L10;
        return "";
    L10:
        if (r2.c() != null) goto L12;
        return "";
    L12:
        if (r() == null) goto L19;
        int r3 = i20.b.a;
        Context r4 = r2.c();
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter("open_feature_data", "dir");
        String r5 = FilesKt.resolve(FilesKt.resolve(r4.getCacheDir(), "broadcastgame"), "open_feature_data").getAbsolutePath();
        LiveMode r6 = r();
        int r7 = h1.a;
        return r5 + File.separator + i1.a(r6) + ".txt";
    L19:
        return "";
    L15:
        return "";
    }

    @Override // a20.i
    public final void h() {
        su0.a r0 = yt0.c.g();
        if (r0 == null) goto L5;
        int r1 = r0.pf();
    L7:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L14;
        a20.k r2 = this.g;
        long r3 = t();
        long r5 = s();
        int r7 = u();
        String r8 = q();
        p r9 = this.a;
        if (r9 == null) goto L12;
        String r11 = r9.hash;
        if (r11 == null) goto L12;
    L13:
        Observable<com.bytedance.android.live.network.response.e<p>> r4 = r2.d(r3, r5, r7, r8, r11, r1, "refresh");
    L20:
        he1.a r6 = new he1.a(r4);
        Function1<com.bytedance.android.live.network.response.e<p>, Unit> r12 = new OpenFeatureListHandler$refreshOpenFeatureList$$inlined$reqGoGo$lambda$1(this);
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        r6.b = r12;
        Function1<Throwable, Unit> r13 = new OpenFeatureListHandler$refreshOpenFeatureList$$inlined$reqGoGo$lambda$2(this);
        Intrinsics.checkNotNullParameter(r13, "onFail");
        r6.c = r13;
        Unit r14 = Unit.INSTANCE;
        n(r6.a());
        return;
    L12:
        r11 = "0";
        goto L13
    L14:
        a20.k r15 = this.g;
        long r16 = t();
        long r17 = s();
        int r18 = u();
        String r19 = q();
        p r21 = this.a;
        if (r21 == null) goto L18;
        String r22 = r21.hash;
        if (r22 == null) goto L18;
    L19:
        r4 = r15.c(r16, r17, r18, r19, r1, r22);
    L18:
        r22 = "0";
        goto L19
    L5:
        r1 = 0;
        goto L7
    }

    @Override // a20.i
    public final void l() {
        if (a20.c.a.a(this) == false) goto L24;
        su0.a r0 = yt0.c.g();
        if (r0 == null) goto L7;
        int r1 = r0.pf();
    L9:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L16;
        a20.k r2 = this.g;
        long r3 = t();
        long r5 = s();
        int r7 = u();
        String r8 = q();
        p r9 = this.a;
        if (r9 == null) goto L14;
        String r11 = r9.hash;
        if (r11 == null) goto L14;
    L15:
        Observable<com.bytedance.android.live.network.response.e<p>> r4 = r2.d(r3, r5, r7, r8, r11, r1, "create_room");
    L22:
        he1.a r6 = new he1.a(r4);
        Function1<com.bytedance.android.live.network.response.e<p>, Unit> r12 = new OpenFeatureListHandler$preloadOpenFeatureList$$inlined$reqGoGo$lambda$1(this);
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        r6.b = r12;
        Function1<Throwable, Unit> r13 = new OpenFeatureListHandler$preloadOpenFeatureList$$inlined$reqGoGo$lambda$2(this);
        Intrinsics.checkNotNullParameter(r13, "onFail");
        r6.c = r13;
        Unit r14 = Unit.INSTANCE;
        n(r6.a());
        return;
    L14:
        r11 = "0";
        goto L15
    L16:
        a20.k r15 = this.g;
        long r16 = t();
        long r17 = s();
        int r18 = u();
        String r19 = q();
        p r21 = this.a;
        if (r21 == null) goto L20;
        String r22 = r21.hash;
        if (r22 == null) goto L20;
    L21:
        r4 = r15.c(r16, r17, r18, r19, r1, r22);
    L20:
        r22 = "0";
        goto L21
    L7:
        r1 = 0;
        goto L9
    }

    public final String q() {
        if (a20.c.a.a(this) == false) goto L8;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r0 = ILiveWrappedEffectSDKService.a.a();
        if (r0 == null) goto L8;
        String r1 = r0.getSdkVersion();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return "";
    }

    public final LiveMode r() {
        if (a20.c.a.a(this) == false) goto L10;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.i r1 = r0.getLiveMode();
        if (r1 != null) goto L9;
        return null;
    L9:
        return (LiveMode) r1.getValue();
    L11:
        return null;
    L10:
        return null;
    }

    public final long s() {
        if (a20.c.a.a(this) == false) goto L12;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L13;
        m r1 = r0.getRoom();
        if (r1 == null) goto L14;
        Room r2 = (Room) r1.getValue();
        if (r2 != null) goto L11;
        return 0;
    L11:
        return r2.id;
    L14:
        return 0;
    L13:
        return 0;
    L12:
        return 0;
    }

    public final long t() {
        if (a20.c.a.a(this) == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    public final int u() {
        if (a20.c.a.a(this) == false) goto L11;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        m r1 = r0.getRoom();
        if (r1 == null) goto L11;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L11;
        return r2.getVisibilityRange();
    L11:
        return -1;
    }

    @Override // a20.c
    public final AbsOpenFeaturePanelViewModel f() {
        return this.f;
    }

    @Override // a20.i
    public final boolean b(InteractEntranceCell r2) {
        Intrinsics.checkNotNullParameter(r2, "interactEntranceCell");
        if (f().isInLive() == false) goto L5;
        this.b = r2;
        return true;
    L5:
        return false;
    }

    public final List<List<f10.f>> z(List<List<InteractEntranceCell>> r9) {
        ArrayList r0 = new ArrayList();
        this.f.getFeatureIconRunningStateManager().d();
        Iterator<T> r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        List r1 = (List) r11.next();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        InteractEntranceCell r4 = (InteractEntranceCell) r3.next();
        r2.add(this.f.getFeatureIconBehaviorController().c(r4, f().isInLive(), 1, false));
        goto L7
    L9:
        r0.add(r2);
        goto L4
    L10:
        return r0;
    }

    public OpenFeatureListHandler(AbsOpenFeaturePanelViewModel r2, a20.k r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "model");
        this.h = new i20.a();
        this.f = r2;
        this.g = r3;
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new LinkedHashMap();
    }

    public static final void m(OpenFeatureListHandler r7, List r8) {
        AbsOpenFeaturePanelViewModel r2 = null;
        if (r7.c.getAndSet(true) == true) goto L32;
        y50.c.d.b("preload_first_mini_app");
        Iterator r0 = r8.iterator();
    L6:
        if (r0.hasNext() == false) goto L20;
        Object r4 = r0.next();
        r r5 = ((InteractEntranceCell) r4).e();
        if (r5 == null) goto L16;
        String r6 = r5.C();
        if (r6 == null) goto L16;
        PluginType.Companion.getClass();
        if (PluginType.a.a(r6) != PluginType.MINI_APP) goto L14;
        boolean r9 = true;
    L15:
        Boolean r11 = Boolean.valueOf(r9);
    L18:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L6;
    L21:
        InteractEntranceCell r12 = (InteractEntranceCell) r4;
        if (r12 == null) goto L26;
        r r1 = r12.e();
        if (r1 == null) goto L26;
        String r3 = r1.C();
    L27:
        if (r3 == null) goto L31;
        int r13 = q.a;
        q.h("预加载小程序, schema: ".concat(r3));
        ya4.a r14 = ma4.c.a;
        List r15 = CollectionsKt.listOf(r3);
        ya4.e r16 = new ya4.e();
        r16.d = MiniAppConstants.Scene.INSTANCE.getAUDIENCE_IN_LIVE();
        Unit r17 = Unit.INSTANCE;
        ya4.a r18 = ma4.c.a;
        if (r18 == null) goto L31;
        r18.a(r15, r16);
    L31:
        y50.c.d.a("preload_first_mini_app");
    L26:
        r3 = null;
        goto L27
    L14:
        r9 = false;
    L16:
        r11 = null;
        goto L18
    L20:
        r4 = null;
    L32:
        AbsOpenFeaturePanelViewModel r19 = r7.f;
        if ((r19 instanceof LiveOpenFeaturePanelViewModel) == false) goto L36;
        r2 = r19;
    L36:
        LiveOpenFeaturePanelViewModel r21 = (LiveOpenFeaturePanelViewModel) r2;
        if (r21 == null) goto L52;
        a20.b r22 = r21.getOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease();
        if (r22 == null) goto L53;
        DataCenter r23 = r22.d();
        if (r23 == null) goto L54;
        List r24 = r8;
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L44:
        if (r26.hasNext() == false) goto L46;
        r25.add(((InteractEntranceCell) r26.next()).i());
        goto L44
    L46:
        r23.put("data_broadcast_game_list", r25);
        return;
    L54:
        return;
    L53:
        return;
    }

    public static List o(List r11, List r12) {
        ArrayList r0 = new ArrayList();
        Iterator r1 = r11.iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L21;
        Object r4 = r1.next();
        int r6 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ArrayList r7 = new ArrayList();
        Iterator r5 = ((List) r4).iterator();
    L10:
        if (r5.hasNext() == false) goto L18;
        Object r8 = r5.next();
        if (((InteractEntranceCell) r8).interactType == InteractID.OpenMicroApp.getValue()) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L10;
        r7.add(r8);
        goto L10
    L14:
        r9 = false;
        goto L15
    L18:
        if (r7.isEmpty() == false) goto L20;
        r0.add(ListProtector.get(r12, r3));
    L20:
        ListProtector.set(r11, r3, TypeIntrinsics.asMutableList(r7));
        r3 = r6;
        goto L4
    L21:
        ((ArrayList) r12).removeAll(r0);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r11.iterator();
    L23:
        if (r14.hasNext() == false) goto L28;
        Object r2 = r14.next();
        if ((!((List) r2).isEmpty()) == false) goto L23;
        r13.add(r2);
        goto L23
    L28:
        return TypeIntrinsics.asMutableList(r13);
    }

    @Override // a20.i
    public final void c(final String r5, final com.bytedance.android.live.broadcastgame.opengame.r r6) {
        Intrinsics.checkNotNullParameter(r5, "appid");
        Intrinsics.checkNotNullParameter(r6, "callBack");
        he1.a r1 = new he1.a(this.g.i(s(), q()));
        Function1<com.bytedance.android.live.network.response.e<l0>, Unit> r0 = new OpenFeatureListHandler$fetchGameItem$$inlined$reqGoGo$lambda$1(this, r6, r5);
        Intrinsics.checkNotNullParameter(r0, "onSuccess");
        r1.b = r0;
        Function1<Throwable, Unit> r2 = new OpenFeatureListHandler$fetchGameItem$$inlined$reqGoGo$lambda$2(this, r6, r5);
        Intrinsics.checkNotNullParameter(r2, "onFail");
        r1.c = r2;
        r1.a();
    }

    public final void v(@OpenFeatureScene long r3, Function1<? super p, Unit> r5, Function0<Unit> r6) {
        if (f().isInLive() == false) goto L11;
        Observable<p> r4 = this.g.e(r3, p());
        if (r4 == null) goto L9;
        Disposable r7 = r4.subscribe(new b(this, r5), new c(r6));
        if (r7 == null) goto L9;
        n(r7);
        return;
    L9:
        r6.invoke();
        return;
    }

    public final List<InteractEntranceCell> w(List<InteractEntranceCell> r6, long r7, long r9) {
        OpenFeatureListHandler$modifyRecentUsedList$1 r0 = OpenFeatureListHandler$modifyRecentUsedList$1.INSTANCE;
        ArrayList r1 = new ArrayList();
        this.f.getFeatureIconRecentUsedManager().d(r6);
        Iterator<T> r8 = this.f.getFeatureIconRecentUsedManager().a().iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        String r2 = (String) r8.next();
        if (r1.size() >= r7) goto L4;
        InteractEntranceCell r3 = OpenFeatureListHandler$modifyRecentUsedList$1.INSTANCE.invoke(r2, r9, this.e);
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L11:
        return r1;
    }

    public static /* synthetic */ void y(OpenFeatureListHandler r9, List r11, Map r12, List r13, List r14, long r15, boolean r16) {
        r9.x(r11, r12, r13, r14, r15, r16, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(List<InteractEntranceCell> r27, Map<Long, com.bytedance.android.live.broadcastgame.api.model.j> r28, List<Long> r29, List<Long> r31, long r32, boolean r33, boolean r34) {
        if (r27.isEmpty() == false) goto L6;
        this.f.showNoDataListReceive();
        return;
    L6:
        List r8 = this.f.getOpenFeatureFilter().filter(r27);
        if (r34 == false) goto L9;
        this.f.setGameDisplayItemList(r8);
        return;
    L9:
        String r9 = "version_type";
        ArrayList r12 = new ArrayList();
        ArrayList r14 = new ArrayList();
        ArrayList r11 = new ArrayList();
        ArrayList r13 = new ArrayList();
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        int r4 = r29.indexOf(1L);
        int r5 = r29.indexOf(2L);
        com.bytedance.android.live.broadcastgame.api.model.j r3 = r28.get(2L);
        if (r3 == null) goto L12;
        long r2 = r3.capacity;
    L13:
        LinkedHashMap r1 = new LinkedHashMap();
        ((LinkedHashMap) this.e).clear();
        Iterator r6 = r8.iterator();
    L15:
        if (r6.hasNext() == false) goto L20;
        List r21 = r8;
        Object r17 = r6.next();
        Iterator r35 = r6;
        InteractEntranceCell r7 = (InteractEntranceCell) r17;
        String r22 = r9;
        long r23 = r2;
        this.e.put(r7.h(), r7);
        Long r18 = Long.valueOf(r7.groupType);
        Object r19 = r1.get(r18);
        if (r19 != null) goto L19;
        r19 = new ArrayList();
        r1.put(r18, r19);
    L19:
        ((List) r19).add(r17);
        r6 = r35;
        r8 = r21;
        r9 = r22;
        r2 = r23;
        goto L15
    L20:
        long r24 = r2;
        List r25 = r8;
        String r26 = r9;
        Iterator<T> r0 = r29.iterator();
    L21:
        String r36 = "";
        if (r0.hasNext() == false) goto L41;
        long r210 = ((Number) r0.next()).longValue();
        List r37 = (List) r1.get(Long.valueOf(r210));
        if (r37 == null) goto L21;
        if ((!r37.isEmpty()) == false) goto L28;
        List r38 = r37;
    L29:
        if (r38 == null) goto L21;
        if (r210 == 1) goto L39;
        com.bytedance.android.live.broadcastgame.api.model.j r39 = r28.get(Long.valueOf(r210));
        if (r39 == null) goto L39;
        String r41 = r39.name;
        if (r41 == null) goto L39;
        r36 = r41;
    L39:
        r12.add(r36);
        r13.add(r38);
        goto L21
    L28:
        r38 = null;
        goto L29
    L41:
        Iterator r42 = r31.iterator();
    L43:
        if (r42.hasNext() == false) goto L81;
        long r43 = ((Number) r42.next()).longValue();
        final List r44 = (List) r1.get(Long.valueOf(r43));
        if (r44 != null) goto L47;
    L78:
        Iterator r310 = r42;
        r1 = r1;
    L79:
        r42 = r310;
        r1 = r1;
        goto L43
    L47:
        if ((!r44.isEmpty()) == true) goto L50;
        r44 = null;
    L50:
        if (r44 == null) goto L78;
        com.bytedance.android.live.broadcastgame.api.model.j r45 = r28.get(Long.valueOf(r43));
        if (r45 == null) goto L58;
        n0 r46 = r45.selector;
        if (r46 == null) goto L58;
        r310 = r42;
        r46.a = r46.defaultKey;
        List<String> r47 = r46.categoryKeyList;
        if (r47 == null) goto L59;
        CollectionsKt.removeAll(r47, new OpenFeatureListHandler$$special$$inlined$let$lambda$1(r44));
    L59:
        com.bytedance.android.live.broadcastgame.api.model.j r48 = r28.get(Long.valueOf(r43));
        if (r48 == null) goto L65;
        String r49 = r48.name;
        if (r49 == null) goto L65;
    L66:
        com.bytedance.android.live.broadcastgame.api.model.j r51 = r28.get(Long.valueOf(r43));
        if (r51 == null) goto L69;
        n0 r52 = r51.selector;
    L70:
        r14.add(new c20.d(r43, r49, r52));
        r15.add(new Pair(Long.valueOf(r43), r44));
        if (((k81) ft0.a.getValue()).b() == true) goto L79;
        com.bytedance.android.live.broadcastgame.api.model.j r53 = r28.get(Long.valueOf(r43));
        if (r53 == null) goto L76;
        String r54 = r53.name;
        if (r54 == null) goto L76;
    L77:
        r11.add(r54);
        r16.add(r44);
    L76:
        r54 = "";
        goto L77
    L69:
        r52 = null;
    L65:
        r49 = "";
    L58:
        r310 = r42;
        goto L59
    L81:
        if (r5 >= 0) goto L83;
    L91:
        int r55 = r4;
        ArrayList r211 = r11;
        if (r5 == (-1)) goto L94;
    L97:
        if (r12.contains("最近使用") == false) goto L99;
        this.f.getHasRecentUseGroup().postValue(Boolean.TRUE);
    L99:
        com.bytedance.android.live.broadcastgame.api.model.j r56 = r28.get(5L);
        if (r56 == null) goto L102;
        this.f.showFeatureDescTip(r56.beforeLiveDesc, r56.afterLiveDescLinkUrl);
    L102:
        InteractEntranceCell r57 = this.b;
        if (r57 == null) goto L107;
        if (r55 < 0) goto L107;
        ListProtector.add((List) ListProtector.get(r13, r55), 0, r57);
    L107:
        if (this.f.isHiding() == false) goto L136;
        List<List<InteractEntranceCell>> r110 = o(r13, r12);
        ArrayList r58 = new ArrayList();
        Iterator r59 = r15.iterator();
        int r61 = 0;
    L110:
        if (r59.hasNext() == false) goto L129;
        Object r62 = r59.next();
        int r63 = r61 + 1;
        if (r61 >= 0) goto L114;
        CollectionsKt.throwIndexOverflow();
    L114:
        Pair r64 = (Pair) r62;
        Iterable r65 = (Iterable) r64.getSecond();
        ArrayList r66 = new ArrayList();
        Iterator r67 = r65.iterator();
    L116:
        if (r67.hasNext() == false) goto L125;
        Object r68 = r67.next();
        if (((InteractEntranceCell) r68).interactType == InteractID.OpenMicroApp.getValue()) goto L120;
        boolean r69 = true;
    L121:
        if (r69 == false) goto L116;
        r66.add(r68);
        goto L116
    L120:
        r69 = false;
        goto L121
    L125:
        if (r66.isEmpty() == false) goto L128;
        r58.add(new c20.d(((Number) r64.getFirst()).longValue(), ((c20.d) ListProtector.get(r14, r61)).b, null));
    L128:
        ListProtector.set(r15, r61, new Pair(r64.getFirst(), TypeIntrinsics.asMutableList(r66)));
        r59 = r59;
        r61 = r63;
        goto L110
    L129:
        r14.removeAll(r58);
        ArrayList r71 = new ArrayList();
        Iterator r72 = r15.iterator();
    L131:
        if (r72.hasNext() == false) goto L135;
        Object r73 = r72.next();
        if ((!((Collection) ((Pair) r73).getSecond()).isEmpty()) == false) goto L131;
        r71.add(r73);
        goto L131
    L135:
        List r111 = TypeIntrinsics.asMutableList(r71);
        ArrayList r74 = r211;
        List<List<InteractEntranceCell>> r112 = r110;
        List r113 = r111;
        List<List<InteractEntranceCell>> r114 = o(r16, r74);
    L137:
        List<List<f10.f>> r75 = z(r112);
        ArrayList r76 = new ArrayList();
        this.f.getFeatureIconRunningStateManager().d();
        Iterator r77 = r113.iterator();
    L139:
        if (r77.hasNext() == false) goto L145;
        Pair r78 = (Pair) r77.next();
        ArrayList r79 = new ArrayList();
        Iterator r81 = ((Iterable) r78.getSecond()).iterator();
    L142:
        if (r81.hasNext() == false) goto L144;
        r79.add(this.f.getFeatureIconBehaviorController().c((InteractEntranceCell) r81.next(), f().isInLive(), 1, false));
        goto L142
    L144:
        r76.add(new c20.a(((Number) r78.getFirst()).longValue(), r79));
        goto L139
    L145:
        ArrayList r82 = new ArrayList();
        AbsOpenFeaturePanelViewModel r83 = this.f;
        if ((r83 instanceof LiveOpenFeaturePanelViewModel) == true) goto L148;
        r83 = null;
    L148:
        LiveOpenFeaturePanelViewModel r84 = (LiveOpenFeaturePanelViewModel) r83;
        if (r84 == null) goto L153;
        a20.b r85 = r84.getOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease();
        if (r85 == null) goto L153;
        DataCenter r86 = r85.d();
    L154:
        Iterator r87 = r76.iterator();
    L156:
        if (r87.hasNext() == false) goto L195;
        c20.a r88 = (c20.a) r87.next();
        if (r88.a == 6) goto L160;
        String r115 = r26;
    L193:
        r82.add(r88.b);
        r26 = r115;
        goto L156
    L160:
        if (r86 == null) goto L162;
        Boolean r89 = (Boolean) r86.get("data_broadcast_has_preview_interact_tool", Boolean.FALSE);
    L164:
        if ((!Intrinsics.areEqual(r89, Boolean.TRUE)) == false) goto L191;
        if (r86 == null) goto L191;
        Iterator<T> r91 = r88.b.iterator();
    L168:
        if (r91.hasNext() == false) goto L186;
        Object r116 = r91.next();
        String r117 = ((f10.f) r116).D.extra;     // Catch: JSONException -> L180
        if (r117 == null) goto L179;
        JSONObject r118 = new JSONObject(r117);     // Catch: JSONException -> L180
        r115 = r26;
        if (r118.has(r115) == false) goto L182;
        if (JSONObjectProtectorUtils.getInt(r118, r115) <= 0) goto L182;
        boolean r119 = true;
    L183:
        if (r119 == true) goto L187;
        r26 = r115;
    L187:
        if (r116 == null) goto L189;
        boolean r92 = true;
    L190:
        r86.put("data_broadcast_has_preview_interact_tool", Boolean.valueOf(r92));
        goto L193
    L189:
        r92 = false;
    L182:
        r119 = false;
        goto L183
    L179:
        r115 = r26;
    L180:
        r115 = r26;
        goto L182
    L186:
        r115 = r26;
        r116 = null;
    L191:
        r115 = r26;
        goto L193
    L162:
        r89 = null;
        goto L164
    L195:
        if (((k81) ft0.a.getValue()).b() == false) goto L197;
        this.f.showOpenFeatureListData(new c20.c(r75, r12, r76, r14, r32, r33));
    L198:
        AbsOpenFeaturePanelViewModel r93 = this.f;
        r93.getGameIconList().clear();
        r93.getGameIconList().addAll(CollectionsKt.plus(CollectionsKt.flatten(r75), CollectionsKt.flatten(r82)));
        r93.setGameDisplayItemList(r25);
        return;
    L197:
        this.f.showOpenFeatureListOldData(r75, r12, z(r114), r74, r33);
    L153:
        r86 = null;
        goto L154
    L136:
        r74 = r211;
        r112 = r13;
        r113 = r15;
        r114 = r16;
        goto L137
    L94:
        if ((!this.f.getFeatureIconRecentUsedManager().a().isEmpty()) == false) goto L97;
        List<InteractEntranceCell> r94 = w(CollectionsKt.emptyList(), r24, r5);
        r12.add("最近使用");
        r13.add(r94);
        goto L97
    L83:
        if (r5 >= r13.size()) goto L91;
        if ((!this.f.getFeatureIconRecentUsedManager().a().isEmpty()) == false) goto L87;
        r55 = r4;
        r211 = r11;
        ListProtector.set(r13, r5, w((List) ListProtector.get(r13, r5), r24, 2));
        goto L97
    L87:
        r55 = r4;
        r211 = r11;
        Iterator r95 = ((Iterable) ListProtector.get(r13, r5)).iterator();
    L89:
        if (r95.hasNext() == false) goto L97;
        this.f.getFeatureIconRecentUsedManager().b(((InteractEntranceCell) r95.next()).h());
        goto L89
    L12:
        r2 = 5;
        goto L13
    }
}
