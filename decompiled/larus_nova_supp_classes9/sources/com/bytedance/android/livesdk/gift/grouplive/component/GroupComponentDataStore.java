package com.bytedance.android.livesdk.gift.grouplive.component;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.t;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.room.RevPadOrientation;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GroupComponentDataStore extends BaseMVIDataStore<GroupComponentDataStore> implements o {
    public static final /* synthetic */ KProperty[] D = null;
    public final uy1.e A;
    public final com.bytedance.android.livesdk.revenue.room.a B;
    public final yz0.k C;
    public final ReadOnlyProperty e;
    public final ReadOnlyProperty f;
    public final ReadOnlyProperty g;
    public final ReadOnlyProperty h;
    public final ReadOnlyProperty i;
    public final ReadOnlyProperty j;
    public final ReadOnlyProperty k;
    public final ReadOnlyProperty l;
    public final ReadOnlyProperty m;
    public final ReadOnlyProperty n;
    public final ReadOnlyProperty o;
    public final t p;
    public final t q;
    public final t r;
    public final t s;
    public final t t;
    public final t u;
    public final CompositeDisposable v;
    public final boolean w;
    public GroupComponentState.Style x;
    public final b y;
    public final k z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ GroupComponentDataStore a;

        public b(GroupComponentDataStore r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) ((KVData) r3).getData();
            if (r4 != null) goto L5;
            r4 = Boolean.FALSE;
        L5:
            final boolean r5 = r4.booleanValue();
            jy0.b.a("GroupComponentView", "observer Status, isHide: " + r5);
            this.a.g(null, new GroupComponentDataStore$observer$1$1(this, r5));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GroupComponentDataStore a;

        public c(GroupComponentDataStore r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final Integer r4 = (Integer) r3;
            this.a.g(null, new GroupComponentDataStore$onStart$2$1(this, r4));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ GroupComponentDataStore a;

        public d(GroupComponentDataStore r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final Integer r4 = (Integer) r3;
            this.a.g(null, new GroupComponentDataStore$onStart$3$1(this, r4));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ GroupComponentDataStore a;

        public e(GroupComponentDataStore r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final Boolean r4 = (Boolean) r3;
            jy0.b.a("GroupComponentView", "isPortraitInteractionChanged, isPortrait: " + r4);
            this.a.g(null, new GroupComponentDataStore$onStart$4$1(this, r4));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ GroupComponentDataStore a;

        public f(GroupComponentDataStore r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final RevPadOrientation r4 = (RevPadOrientation) r3;
            this.a.g(null, new GroupComponentDataStore$onStart$5$1(this, r4));
        }
    }

    static {
        D = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "currentShowComponentItem", "getCurrentShowComponentItem()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "currentComponentList", "getCurrentComponentList()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "currentShowMode", "getCurrentShowMode()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "currentShowPosition", "getCurrentShowPosition()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "currentShowStyle", "getCurrentShowStyle()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "currentShowUrl", "getCurrentShowUrl()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "currentPayload", "getCurrentPayload()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "currentPlaceHolderHeight", "getCurrentPlaceHolderHeight()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "enableDrag", "getEnableDrag()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "currentVisibility", "getCurrentVisibility()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "isAnchorSide", "isAnchorSide()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "_currentShowItem", "get_currentShowItem()Lcom/bytedance/android/livesdk/gift/grouplive/component/model/GroupContainerItem;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "_placeHolderHeight", "get_placeHolderHeight()I", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "_currentShowModel", "get_currentShowModel()Lcom/bytedance/android/livesdk/gift/grouplive/component/GroupComponentState$Mode;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "_currentShowStyle", "get_currentShowStyle()Lcom/bytedance/android/livesdk/gift/grouplive/component/GroupComponentState$Style;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "_currentLayout", "get_currentLayout()Lcom/bytedance/android/livesdk/gift/grouplive/component/model/Layout;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentDataStore.class, "_currentPayload", "get_currentPayload()Ljava/lang/String;", 0))};
    }

    public final t<GroupComponentDataStore, ty1.c> F() {
        return (t) this.h.getValue(this, D[3]);
    }

    public final t<GroupComponentDataStore, GroupComponentState.Style> I() {
        return (t) this.i.getValue(this, D[4]);
    }

    public final t<GroupComponentDataStore, String> J() {
        return (t) this.j.getValue(this, D[5]);
    }

    public final ty1.b L() {
        return (ty1.b) this.p.getValue(this, D[11]);
    }

    public final GroupComponentState.Style R() {
        return (GroupComponentState.Style) this.s.getValue(this, D[14]);
    }

    public final t<GroupComponentDataStore, String> q() {
        return (t) this.k.getValue(this, D[6]);
    }

    public final t<GroupComponentDataStore, Integer> s() {
        return (t) this.l.getValue(this, D[7]);
    }

    public final t<GroupComponentDataStore, ty1.b> w() {
        return (t) this.e.getValue(this, D[0]);
    }

    public final t<GroupComponentDataStore, GroupComponentState.Mode> y() {
        return (t) this.g.getValue(this, D[2]);
    }

    public final void onStart() {
        g(null, new AnonymousClass1(this));
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L11;
        com.bytedance.live.datacontext.m r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).hj(this.C.getDataCenter());
        if (r0 == null) goto L18;
        Observable r1 = r0.a();
        if (r1 == null) goto L18;
        Disposable r2 = r1.subscribe(new c(this));
        if (r2 == null) goto L18;
        RxUtilKt.c(r2, this.v);
    L18:
        RxUtilKt.c(this.C.Z2().subscribe(new e(this)), this.v);
        this.C.getDataCenter().observe("data_is_hiding_landscape_buttons", this.y);
        if (PadConfigUtils.c() == false) goto L26;
        Observable r3 = this.B.getPadOrientation();
        if (r3 == null) goto L27;
        Disposable r4 = r3.subscribe(new f(this));
        if (r4 == null) goto L28;
        RxUtilKt.c(r4, this.v);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L11:
        com.bytedance.live.datacontext.m r5 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).Wc();
        if (r5 == null) goto L18;
        Observable r6 = r5.a();
        if (r6 == null) goto L18;
        Disposable r7 = r6.subscribe(new d(this));
        if (r7 == null) goto L18;
        RxUtilKt.c(r7, this.v);
        goto L18
    }

    public final void onStop() {
        this.v.clear();
        this.x = null;
        this.C.getDataCenter().removeObserver(this.y);
    }

    public final void S(final List<ty1.b> r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        if (r8.isEmpty() == false) goto L6;
        k(false, null);
        return;
    L6:
        final ty1.b r0 = (ty1.b) ListProtector.get(r8, 0);
        final ty1.b r3 = L();
        ty1.b r4 = L();
        if (r4 == null) goto L9;
        int r5 = r4.getType();
    L11:
        if (r5 != r0.getType()) goto L13;
    L28:
        boolean r6 = true;
    L29:
        if (r6 == true) goto L31;
        return;
    L31:
        ty1.b r7 = L();
        if (r7 == null) goto L35;
        r7.getType();
    L35:
        if (r0.e.length() != 0) goto L37;
        boolean r9 = true;
    L38:
        if (r9 == true) goto L40;
    L50:
        boolean r10 = false;
    L51:
        if (r10 == false) goto L53;
        k(false, r0);
        return;
    L53:
        k(true, r0);
        jy0.b.a("GroupComponentView", "setCurrentComponentList, layout:" + r0.d.a());
        jy0.b.a("GroupComponentView", "setCurrentComponentList, timestamp" + r0.i + ", Payload:" + r0.c);
        g(null, new GroupComponentDataStore$setCurrentComponentList$1(this, r3, r0, r8));
        return;
    L40:
        if (r0.f.length() != 0) goto L42;
        boolean r11 = true;
    L43:
        if (r11 == false) goto L50;
        if (r0.g.length() != 0) goto L47;
        boolean r13 = true;
    L48:
        if (r13 == false) goto L50;
        r10 = true;
        goto L51
    L47:
        r13 = false;
        goto L48
    L42:
        r11 = false;
        goto L43
    L37:
        r9 = false;
        goto L38
    L13:
        if (r0.e.length() != 0) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == false) goto L28;
        if (r0.f.length() != 0) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L28;
        if (r0.g.length() != 0) goto L25;
        boolean r16 = true;
    L26:
        if (r16 == false) goto L28;
        r6 = false;
        goto L29
    L25:
        r16 = false;
        goto L26
    L20:
        r15 = false;
        goto L21
    L15:
        r14 = false;
        goto L16
    L9:
        r5 = 0;
        goto L11
    }

    public final void o(int r4) {
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        GroupComponentState.Mode r1 = GroupComponentState.Mode.EXPAND;
        r0.element = r1;
        if (r4 != r1.getValue()) goto L5;
        r0.element = r1;
    L8:
        ty1.b r5 = L();
        if (r5 == null) goto L14;
        ty1.a r6 = r5.d;
        if (r6 == null) goto L14;
        final String r7 = r6.e();
        if (r7 == null) goto L14;
    L15:
        g(null, new GroupComponentDataStore$changeShowMode$1(this, r0, r7));
        return;
    L14:
        r7 = GroupComponentState.Style.DEFAULT.getValue();
        goto L15
    L5:
        GroupComponentState.Mode r2 = GroupComponentState.Mode.CLOSE;
        if (r4 != r2.getValue()) goto L8;
        r0.element = r2;
        goto L8
    }

    public final void k(boolean r17, ty1.b r18) {
        if (r17 == false) goto L82;
        if (r18 == null) goto L82;
        uy1.e r4 = this.A;
        boolean r5 = this.w;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r18, "showData");
        if (r4.d != null) goto L89;
        vy1.a r6 = new vy1.a(r4.h);
        com.bytedance.android.livesdk.revenue.service.ui.c r8 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.c.class);
        DataCenter r9 = r4.i.getDataCenter();
        int r10 = (int) r18.b;
        Context r11 = r4.h;
        ConstraintLayout r13 = r6.h;
        int r7 = r18.getType();
        boolean r3 = ((Boolean) com.bytedance.android.livesdk.gift.platform.core.g.p.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[13])).booleanValue();
        if (r5 == false) goto L11;
        int r2 = s1.f(12.0f);
        int r15 = s1.f(12.0f);
        aq2.a r14 = new aq2.a(new aq2.b(r2, s1.f(8.0f), r15, s1.f(8.0f)), false, 9);
    L13:
        aq2.a r16 = r14;
    L39:
        com.bytedance.android.livesdk.revenue.service.ui.f r19 = r8.C9(r9, r10, r11, r13, r16);
        r4.d = r19;
        if (r19 == null) goto L42;
        r19.b(new uy1.a(r4, r6));
    L42:
        r4.f = new CompositeDisposable();
        if (r5 == false) goto L45;
    L79:
        com.bytedance.android.livesdk.revenue.service.ui.b r20 = r4.d;
        if (r20 == null) goto L89;
        r20.show();
        goto L89
    L45:
        if (uy1.e.d(r18.getType()) == true) goto L79;
        k r21 = r4.g;
        com.bytedance.android.scope.m r23 = com.bytedance.android.scope.m.e;
        com.bytedance.android.livesdk.revenue.service.sti.a r24 = (com.bytedance.android.livesdk.revenue.service.sti.a) r23.d(r21, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r24 == null) goto L57;
        com.bytedance.live.datacontext.m r25 = r24.cd();
        if (r25 == null) goto L57;
        Observable r26 = r25.a();
        if (r26 == null) goto L57;
        Disposable r27 = r26.subscribe(new uy1.b(r4, r18));
        if (r27 == null) goto L57;
        CompositeDisposable r28 = r4.f;
        if (r28 == null) goto L57;
        r28.add(r27);
    L57:
        com.bytedance.android.livesdk.revenue.service.sti.a r29 = (com.bytedance.android.livesdk.revenue.service.sti.a) r23.d(r4.g, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r29 == null) goto L68;
        com.bytedance.live.datacontext.m r30 = r29.u8();
        if (r30 == null) goto L68;
        Observable r31 = r30.a();
        if (r31 == null) goto L68;
        Disposable r33 = r31.subscribe(new uy1.c(r4, r18));
        if (r33 == null) goto L68;
        CompositeDisposable r34 = r4.f;
        if (r34 == null) goto L68;
        r34.add(r33);
    L68:
        com.bytedance.android.livesdk.revenue.service.sti.a r35 = (com.bytedance.android.livesdk.revenue.service.sti.a) r23.d(r4.g, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r35 == null) goto L79;
        com.bytedance.live.datacontext.m r36 = r35.sh();
        if (r36 == null) goto L79;
        Observable r37 = r36.a();
        if (r37 == null) goto L79;
        Disposable r38 = r37.subscribe(new uy1.d(r4, r18));
        if (r38 == null) goto L79;
        CompositeDisposable r39 = r4.f;
        if (r39 == null) goto L79;
        r39.add(r38);
        goto L79
    L11:
        if (r3 == true) goto L14;
        int r40 = s1.f(12.0f);
        int r110 = s1.f(12.0f);
        r14 = new aq2.a(new aq2.b(r40, s1.f(8.0f), r110, 0), false, 9);
        goto L13
    L14:
        k r41 = r4.g;
        com.bytedance.android.scope.m r43 = com.bytedance.android.scope.m.e;
        com.bytedance.android.livesdk.revenue.service.sti.a r44 = (com.bytedance.android.livesdk.revenue.service.sti.a) r43.d(r41, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r44 == null) goto L21;
        com.bytedance.live.datacontext.m r45 = r44.cd();
        if (r45 == null) goto L21;
        Integer r46 = (Integer) r45.getValue();
        if (r46 == null) goto L21;
        int r111 = r46.intValue();
    L22:
        com.bytedance.android.livesdk.revenue.service.sti.a r47 = (com.bytedance.android.livesdk.revenue.service.sti.a) r43.d(r4.g, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r47 == null) goto L29;
        com.bytedance.live.datacontext.m r48 = r47.u8();
        if (r48 == null) goto L29;
        Integer r49 = (Integer) r48.getValue();
        if (r49 == null) goto L29;
        int r50 = r49.intValue();
    L30:
        com.bytedance.android.livesdk.revenue.service.sti.a r51 = (com.bytedance.android.livesdk.revenue.service.sti.a) r43.d(r4.g, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r51 == null) goto L37;
        com.bytedance.live.datacontext.m r53 = r51.sh();
        if (r53 == null) goto L37;
        Integer r54 = (Integer) r53.getValue();
        if (r54 == null) goto L37;
        int r55 = r54.intValue();
    L38:
        r16 = r4.c(r111, r50, r55, r7);
    L37:
        r55 = 0;
    L29:
        r50 = 0;
    L21:
        r111 = 0;
    L89:
        k r56 = this.z;
        i r57 = (i) com.bytedance.android.scope.m.e.d(r56, i.class);
        if (r17 == false) goto L95;
        if (r18 == null) goto L95;
        if (r57 == null) goto L98;
        r57.a(new fa0.a(true, Integer.valueOf(r18.getType()), r18.c));
        return;
    L98:
        return;
    L95:
        if (r57 == null) goto L100;
        r57.a(new fa0.a(0));
        return;
    L100:
        return;
    L82:
        uy1.e r58 = this.A;
        CompositeDisposable r59 = r58.f;
        if (r59 == null) goto L85;
        r59.dispose();
    L85:
        r58.f = null;
        com.bytedance.android.livesdk.revenue.service.ui.b r60 = r58.d;
        if (r60 == null) goto L88;
        r60.dismiss();
    L88:
        r58.d = null;
        g(null, new GroupComponentDataStore$clear$1(this));
        goto L89
    }

    public final void n(final ty1.c r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "layout");
        g(null, new GroupComponentDataStore$changeContainerPosition$1(this, r10));
        if (r11 == false) goto L52;
        Object r13 = BuildConfig.FLAVOR;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L26
        ty1.a r1 = new ty1.a();     // Catch: Throwable -> L26
        ty1.b r2 = L();     // Catch: Throwable -> L26
        if (r2 == null) goto L11;
        ty1.a r3 = r2.d;     // Catch: Throwable -> L26
        if (r3 == null) goto L11;
        String r4 = r3.b();     // Catch: Throwable -> L26
        if (r4 == null) goto L11;
    L12:
        r1.g(r4);     // Catch: Throwable -> L26
        ty1.b r5 = L();     // Catch: Throwable -> L26
        if (r5 == null) goto L17;
        ty1.a r6 = r5.d;     // Catch: Throwable -> L26
        if (r6 == null) goto L17;
        int r7 = r6.d();     // Catch: Throwable -> L26
    L18:
        r1.i(r7);     // Catch: Throwable -> L26
        ty1.b r8 = L();     // Catch: Throwable -> L26
        if (r8 == null) goto L23;
        ty1.a r9 = r8.d;     // Catch: Throwable -> L26
        if (r9 == null) goto L23;
        int r14 = r9.c();     // Catch: Throwable -> L26
    L24:
        r1.h(r14);     // Catch: Throwable -> L26
        r1.j(R().getValue());     // Catch: Throwable -> L26
        r1.f(r10);     // Catch: Throwable -> L26
        Object r15 = Result.constructor-impl(GsonHelper.get().toJson(r1));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r15) == true) goto L32;
        r13 = r15;
    L32:
        String r16 = (String) r13;
        jy0.b.a("GroupComponentView", "position: " + r16);
        tz0.b r17 = tz0.b.a;
        uz0.c r18 = new uz0.c();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "$this$beforeConfigureRequest");
        Map r19 = ((uz0.a) r18).b;
        Intrinsics.checkNotNullParameter(r19, "queriesMap");
        String r20 = Long.valueOf(((IRoom) this.B.getRoom().getValue()).getRoomId()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r20 == null) goto L35;
        r19.put("room_id", r20);
    L35:
        String r21 = ((IRoom) this.B.getRoom().getValue()).getAnchorId();
        Intrinsics.checkNotNullParameter("anchor_id", "$this$setTo");
        if (r21 == null) goto L38;
        r19.put("anchor_id", r21);
    L38:
        Intrinsics.checkNotNullParameter("position", "$this$setTo");
        if (r16 == null) goto L41;
        r19.put("position", r16);
    L41:
        ty1.b r110 = L();
        if (r110 == null) goto L44;
        int r111 = r110.getType();
    L45:
        String r112 = Integer.valueOf(r111).toString();
        Intrinsics.checkNotNullParameter("type", "$this$setTo");
        if (r112 == null) goto L48;
        r19.put("type", r112);
    L48:
        Intrinsics.checkNotNullParameter(r18, "$this$afterConfigureRequest");
        RxUtilKt.c(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/anchor/interaction_container/update_container_position/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, ((uz0.a) r18).d, ((uz0.a) r18).a, ((uz0.a) r18).b, ((uz0.a) r18).c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(com.bytedance.android.livesdk.gift.grouplive.component.d.a, com.bytedance.android.livesdk.gift.grouplive.component.e.a), this.v);
        return;
    L44:
        r111 = 0;
    L23:
        r14 = (int) 812.0f;     // Catch: Throwable -> L26
    L17:
        r7 = (int) 375.0f;     // Catch: Throwable -> L26
    L11:
        r4 = BuildConfig.FLAVOR;
    L26:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    public GroupComponentDataStore(k r3, uy1.e r4, com.bytedance.android.livesdk.revenue.room.a r5, yz0.k r6) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "cardCreateService");
        Intrinsics.checkNotNullParameter(r5, "roomContext");
        Intrinsics.checkNotNullParameter(r6, "roomDataService");
        this.z = r3;
        this.A = r4;
        this.B = r5;
        this.C = r6;
        com.bytedance.android.anya.internal.k r7 = j(null).a();
        KProperty[] r8 = D;
        this.e = r7.a(r8[0]);
        this.f = i(new ArrayList()).a().a(r8[1]);
        this.g = i(GroupComponentState.Mode.EXPAND).a().a(r8[2]);
        this.h = i(new ty1.c(0)).a().a(r8[3]);
        this.i = i(GroupComponentState.Style.DEFAULT).a().a(r8[4]);
        this.j = j(BuildConfig.FLAVOR).a().a(r8[5]);
        this.k = i(BuildConfig.FLAVOR).a().a(r8[6]);
        this.l = i(0).a().a(r8[7]);
        Boolean r9 = Boolean.FALSE;
        this.m = i(r9).a().a(r8[8]);
        this.n = i(Boolean.TRUE).a().a(r8[9]);
        this.o = i(r9).a().a(r8[10]);
        this.p = w();
        this.q = s();
        this.r = y();
        this.s = I();
        this.t = F();
        this.u = q();
        this.v = new CompositeDisposable();
        this.w = ((Boolean) r5.isAnchor().getValue()).booleanValue();
        this.y = new b(this);
    }
}
