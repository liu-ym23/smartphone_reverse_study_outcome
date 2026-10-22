package com.bytedance.android.live.anchormodelink.impl;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.anchormodelink.BaseAnchorModeDynamicWidget;
import com.bytedance.android.live.anchormodelink.linkroom.LinkBasicJsbHandler$showLinkmicBeautyPanel$1;
import com.bytedance.android.live.anchormodelink.model.LinkerUserState;
import com.bytedance.android.live.anchormodelink.util.JsbParamParseUtil;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.live.effect.base.sharedpref.IEffectPluginPropertyService;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.jsbridge.method.s;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.l;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.utils.j1;
import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.bytedance.android.live.liveinteract.voicechat.toolbar.ToolbarRoomBattleBehavior;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.android.livesdk.chatroom.ui.z4;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.w60;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import iy.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import ly.t;
import ly.u;
import ny.n;
import org.json.JSONObject;
import uf2.m1;
import uf2.z;
import zg1.a1;
import zg1.g1;
import zg1.h1;
import zg1.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/anchormodelink/impl/AnchorModeLinkDynamicWidget;", "Lcom/bytedance/android/live/anchormodelink/BaseAnchorModeDynamicWidget;", "Liy/g;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorModeLinkDynamicWidget extends BaseAnchorModeDynamicWidget implements iy.g, Observer<KVData> {
    public final String a;
    public final CompositeDisposable b;
    public ly.h c;
    public IRoom d;
    public oy.f e;
    public com.bytedance.android.live.anchormodelink.gift.d f;
    public com.bytedance.android.live.anchormodelink.linkroom.e g;
    public com.bytedance.android.live.pushstream.d h;
    public int i;
    public final ToolbarRoomBattleBehavior j;
    public boolean k;
    public final Lazy l;
    public final Map<String, String> m;
    public final GestureDetector n;
    public final long o;
    public Disposable p;
    public final Lazy q;
    public final h r;
    public final d s;
    public Disposable t;
    public final c u;
    public final e v;
    public final f w;
    public final ViewGroup x;
    public final j y;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public long a;
        public final long b;
        public final /* synthetic */ AnchorModeLinkDynamicWidget c;

        public a(AnchorModeLinkDynamicWidget r3) {
            this.c = r3;
            this.b = ((Number) vm2.d.S7.getValue(null, vm2.d.a[457(0x1c9, float:6.4E-43)])).longValue();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            this.a = SystemClock.elapsedRealtime();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "e");
            if ((SystemClock.elapsedRealtime() - this.a) >= this.b) goto L5;
            return false;
        L5:
            AnchorModeLinkDynamicWidget r0 = this.c;
            r0.getClass();
            r0.Dd("onFloatLayoutSeatClicked", null);
            return false;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Runnable a;

        public b(Runnable r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.run();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements u {
        public final /* synthetic */ AnchorModeLinkDynamicWidget a;

        @Override // ly.u
        public final IRoom getRoom() {
            return je0.d.e(((Widget) this.a).dataCenter);
        }

        @Override // ly.u
        public final IBaseUser getUser() {
            return k.n(IMiddlewareUserService.class).user().b();
        }

        @Override // ly.u
        public final LivePlayerView R8() {
            as0.a r0 = LivePlatformPlayerManager.b();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getLivePlayerView();
        }

        @Override // ly.u
        public final String n6() {
            o r0 = j0.l().c(x.class);
            if (r0 == null) goto L9;
            Map r1 = r0.getMap();
            if (r1 == null) goto L9;
            String r2 = (String) r1.get("enter_from_merge");
            if (r2 == null) goto L9;
            return r2;
        L9:
            return null;
        }

        public c(AnchorModeLinkDynamicWidget r1) {
            this.a = r1;
        }
    }

    public static final class d implements s {
        public final /* synthetic */ AnchorModeLinkDynamicWidget a;

        public d(AnchorModeLinkDynamicWidget r1) {
            this.a = r1;
        }

        public final JsonObject C(my.b r2) {
            Intrinsics.checkNotNullParameter(r2, "getStatusData");
            return this.a.C(r2);
        }

        public final void P0(my.c r2, com.bytedance.android.live.liveinteract.jsbridge.method.k r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "updateStatus");
            Intrinsics.checkNotNullParameter(r3, "updateCallback");
            this.a.P0(r2, r3, r4);
        }
    }

    public static final class e implements oy.a {
        public final /* synthetic */ AnchorModeLinkDynamicWidget a;

        @Override // oy.a
        public final boolean a() {
            iy.f r0 = this.a.xq();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.ye();
        }

        @Override // oy.a
        public final int getCurrentScene() {
            return this.a.i;
        }

        @Override // oy.a
        public final my.a getLinkMicInfo() {
            iy.f r0 = this.a.xq();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getLinkMicInfo();
        }

        public e(AnchorModeLinkDynamicWidget r1) {
            this.a = r1;
        }
    }

    public static final class f implements iy.h {
        public final /* synthetic */ AnchorModeLinkDynamicWidget a;

        public static final class a<T> implements h80.a {
            public final /* synthetic */ Function0 a;
            public final /* synthetic */ Function0 b;

            public a(Function0 r1, Function0 r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // h80.a
            public final void accept(Object r1) {
                if (((Boolean) r1).booleanValue() == false) goto L5;
                this.a.invoke();
                return;
            L5:
                this.b.invoke();
            }
        }

        @Override // iy.h
        public final void A4(JsonObject r2) {
            Intrinsics.checkNotNullParameter(r2, "extra");
        }

        @Override // iy.h
        public final boolean C4() {
            return ((Boolean) vm2.d.b.getValue(null, vm2.d.a[0])).booleanValue();
        }

        @Override // iy.h
        public final void Q1() {
            if (je0.d.E(((Widget) this.a).dataCenter) == true) goto L10;
            AnchorModeLinkDynamicWidget r0 = this.a;
            oy.f r1 = r0.e;
            if (r1 == null) goto L11;
            SurfaceView r2 = (SurfaceView) r0.l.getValue();
            Intrinsics.checkNotNullParameter(r2, "surfaceView");
            String r3 = "addSurfaceView4SingleViewMode, add surfaceView width=" + r2.getWidth() + "-height=" + r2.getHeight() + " measuredWidth=" + r2.getMeasuredWidth() + "-measuredHeight=" + r2.getMeasuredHeight();
            boolean r4 = iy.b.a;
            iy.b.d("[SingleSurfaceViewManager] " + r3);
            UtilityKotlinExtentionsKt.q(r2);
            if (r1.a.indexOfChild(r2) != (-1)) goto L12;
            ViewGroup.LayoutParams r5 = new ConstraintLayout.LayoutParams(-1, -1);
            ((ConstraintLayout.LayoutParams) r5).leftToLeft = 0;
            ((ConstraintLayout.LayoutParams) r5).rightToRight = 0;
            ((ConstraintLayout.LayoutParams) r5).bottomToBottom = 0;
            ((ConstraintLayout.LayoutParams) r5).topToTop = 0;
            r1.a.addView(r2, r5);
            return;
        L12:
            return;
        L11:
            return;
        }

        public final com.bytedance.android.live.anchormodelink.handlers.a b() {
            ly.h r0 = this.a.c;
            if (r0 == null) goto L8;
            t r1 = r0.j;
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.b;
        L8:
            return null;
        }

        public final com.bytedance.android.live.anchormodelink.handlers.d c() {
            ly.h r0 = this.a.c;
            if (r0 == null) goto L8;
            t r1 = r0.j;
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.a;
        L8:
            return null;
        }

        @Override // iy.h
        public final int g() {
            if (((Boolean) w60.a.getValue()).booleanValue() == true) goto L5;
        L7:
            return 1;
        L5:
            if (com.bytedance.android.livesdk.sharedpref.d.c() <= 0) goto L7;
            return com.bytedance.android.livesdk.sharedpref.d.c();
        }

        @Override // iy.h
        public Context getContext() {
            return ((Widget) this.a).context;
        }

        @Override // iy.h
        public final IRoomBase getRoom() {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L8;
            IRoomBase r1 = a0.o(r0);
            if (r1 == null) goto L8;
            return r1;
        L8:
            return new Room();
        }

        @Override // iy.h
        public final void m4() {
            if (je0.d.E(((Widget) this.a).dataCenter) == true) goto L10;
            AnchorModeLinkDynamicWidget r0 = this.a;
            oy.f r1 = r0.e;
            if (r1 == null) goto L11;
            SurfaceView r2 = (SurfaceView) r0.l.getValue();
            Intrinsics.checkNotNullParameter(r2, "surfaceView");
            if (r1.a.indexOfChild(r2) == (-1)) goto L12;
            r1.a.removeView(r2);
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // iy.h
        public final void p4() {
            Intrinsics.checkNotNullParameter("Jsb invoke", "string");
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L6;
            r0.put("cmd_interact_state_change", new a1(4));
            return;
        }

        @Override // iy.h
        public final l r4() {
            return this.a.getScopeServiceInMultiLinkRoom(l.class);
        }

        @Override // iy.h
        public final boolean t4() {
            return ((Boolean) vm2.d.f.getValue(null, vm2.d.a[4])).booleanValue();
        }

        @Override // iy.h
        public final boolean v4() {
            return je0.d.E(((Widget) this.a).dataCenter);
        }

        @Override // iy.h
        public final void x4() {
            Intrinsics.checkNotNullParameter("Jsb invoke", "string");
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L6;
            r0.put("cmd_interact_state_change", new a1(3));
            return;
        }

        @Override // iy.h
        public final long y4() {
            boolean r0 = ky.a.a;
            return vm2.d.c0().getTalkingStateInterval();
        }

        @Override // iy.h
        public final Integer O0() {
            return je0.d.h();
        }

        public final ec6.a a() {
            if (v4() == false) goto L28;
            h70.b r0 = this.a.getComponentContext();
            if (r0 != null) goto L7;
        L19:
            z4 r1 = this.a.y;
            if (r1 == null) goto L22;
            v0 r2 = r1.a.Wa0();
        L23:
            if (r2 != null) goto L25;
            return null;
        L25:
            return gc6.b.c(r2, null);
        L22:
            r2 = null;
            goto L23
        L7:
            if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(r0) != true) goto L19;
            h70.b r3 = this.a.getComponentContext();
            if (r3 == null) goto L13;
            IAbilityCenter r4 = r3.a();
            if (r4 == null) goto L13;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r4.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        L14:
            if (r5 == null) goto L26;
            v0 r6 = r5.getLiveVideoClientFactory();
            if (r6 != null) goto L18;
            return null;
        L18:
            return gc6.b.c(r6, null);
        L26:
            return null;
        L13:
            r5 = null;
            goto L14
        L28:
            return null;
        }

        @Override // iy.h
        public final String d() {
            return j1.a();
        }

        @Override // iy.h
        public final /* bridge */ /* synthetic */ Object q4() {
            return a();
        }

        public f(AnchorModeLinkDynamicWidget r1) {
            this.a = r1;
        }

        @Override // iy.h
        public final void s4(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "seiObj");
            ly.h r0 = this.a.c;
            if (r0 == null) goto L10;
            Intrinsics.checkNotNullParameter(r3, "seiData");
            t r1 = r0.j;
            if (r1 == null) goto L11;
            ih0.c r2 = r1.d;
            if (r2 == null) goto L12;
            r2.sendJsEvent("H5_sei", r3);
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // iy.h
        public final void w4(JsonObject r3) {
            Intrinsics.checkNotNullParameter("liveLinkCallBack", "eventName");
            ly.h r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.h("liveLinkCallBack", r3);
            return;
        }

        @Override // iy.h
        public final ApiServerException B4(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errMsg");
            return new ApiServerException(r2);
        }

        @Override // iy.h
        public final void n4(Function0<Unit> r12, Function0<Unit> r13) {
            Intrinsics.checkNotNullParameter(r12, "success");
            Intrinsics.checkNotNullParameter(r13, "failed");
            IKtvService r0 = k.f(IKtvService.class);
            if (r0 == null) goto L6;
            r0.enableVideoChorus(new jd2.g(false, true, 0, 0, null, null, new a(r12, r13), 120));
            return;
        }

        @Override // iy.h
        public final void o4(ny.t r14, ei6.a r15) {
            boolean r0 = ky.a.a;
            boolean r2 = true;
            if (vm2.d.c0().getLogMixedInfo() == true) goto L6;
            r2 = false;
        L6:
            if (r2 == false) goto L10;
            if (r14 == null) goto L10;
            String r1 = r14.toString();
            if (r1 == null) goto L10;
        L11:
            boolean r3 = iy.b.a;
            String r4 = this.a.a;
            StringBuilder r5 = new StringBuilder("UpdateMixedStreamInfoParams， anchorInteractId:");
            iy.f r6 = this.a.xq();
            if (r6 == null) goto L16;
            my.a r7 = r6.getLinkMicInfo();
            if (r7 == null) goto L16;
            String r8 = r7.b;
        L17:
            r5.append(r8);
            r5.append(", selfInteractId: ");
            iy.f r9 = this.a.xq();
            if (r9 == null) goto L22;
            my.a r11 = r9.getLinkMicInfo();
            if (r11 == null) goto L22;
            String r12 = r11.a;
        L23:
            r5.append(r12);
            r5.append(", params=");
            r5.append(r1);
            iy.b.e(r4, r5.toString());
            if ((r15 instanceof ei6.a) == true) goto L26;
            r15 = null;
        L26:
            if (r14 == null) goto L128;
            List<n> r16 = r14.d;
            if (r16 == null) goto L138;
            Iterator<T> r17 = r16.iterator();
            int r13 = 0;
        L31:
            if (r17.hasNext() == false) goto L139;
            Object r18 = r17.next();
            int r19 = r13 + 1;
            if (r13 >= 0) goto L35;
            CollectionsKt.throwIndexOverflow();
        L35:
            n r21 = (n) r18;
            String r22 = r21.m;
            if (r22 == null) goto L127;
            oy.f r23 = this.a.e;
            if (r23 == null) goto L127;
            Intrinsics.checkNotNullParameter(r21, "region");
            Intrinsics.checkNotNullParameter(r22, "interactId");
            my.a r24 = r23.b.getLinkMicInfo();
            if (r24 == null) goto L42;
            String r25 = r24.a;
        L44:
            if (TextUtils.equals(r22, r25) == false) goto L51;
            if (r15 == null) goto L57;
            ji6.c r26 = r15.u();
            if (r26 == null) goto L57;
            z r27 = r26.C();
            if (r27 == null) goto L57;
            z.a r28 = r27.K0();
        L58:
            boolean r29 = iy.b.a;
            StringBuilder r31 = new StringBuilder("[SingleSurfaceViewManager] updateSingleViewLayer interactId：");
            r31.append(r22);
            r31.append(", callbackInteractId: ");
            my.a r32 = r23.b.getLinkMicInfo();
            if (r32 == null) goto L61;
            String r33 = r32.a;
        L62:
            r31.append(r33);
            r31.append(", layer:");
            r31.append(r28);
            iy.b.d(r31.toString());
            if (r28 == null) goto L127;
            my.a r34 = r23.b.getLinkMicInfo();
            if (r34 == null) goto L68;
            String r35 = r34.b;
        L70:
            if (TextUtils.equals(r22, r35) == false) goto L79;
            if (r15 == null) goto L73;
            ji6.c r36 = r15.u();
        L74:
            iy.b.d("[SingleSurfaceViewManager] setAnchorLayerToOriginLayer anchorLayer:" + r28.name() + ", liveAVClient:" + r36);
            if (r36 == null) goto L79;
            z r37 = r36.C();
            if (r37 == null) goto L79;
            r28.name();
            r37.e();
            goto L79
        L73:
            r36 = null;
        L79:
            float r38 = (float) r21.d;
            float r39 = (float) r21.e;
            float r41 = ((float) r21.f) + r38;
            float r42 = ((float) r21.g) + r39;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r110 = ILiveWrappedLivePusher.a.b();
            if (r110 == null) goto L84;
            m1.b r111 = r110.newVideoMixerDescription(null);
            if (r111 == null) goto L84;
            r111.e();
            r111.b();
            r111.c();
            r111.f();
            r111.i();
            r111.g();
            r111.h();
        L85:
            iy.b.d("[SingleSurfaceViewManager] left：" + r38 + ", top:" + r39 + ", right:" + r41 + ", bottom:" + r42);
            m1.b r43 = r28.Y();
            if (r43 == null) goto L127;
            if (r111 == null) goto L127;
            if (r43.isVisible() == false) goto L93;
        L95:
            if (r15 == null) goto L101;
            ji6.c r44 = r15.u();
            if (r44 == null) goto L101;
            z r45 = r44.C();
            if (r45 == null) goto L101;
            int r46 = r45.d();
        L102:
            if (r15 == null) goto L108;
            ji6.c r47 = r15.u();
            if (r47 == null) goto L108;
            z r48 = r47.C();
            if (r48 == null) goto L108;
            int r49 = r48.c();
        L109:
            if (r46 <= 0) goto L113;
            if (r49 <= 0) goto L113;
            Math.abs(r111.getRight() - r111.getLeft());
            Math.abs(r111.getBottom() - r111.getTop());
        L113:
            if (r43.getLeft() == r111.getLeft()) goto L115;
        L126:
            iy.b.d("[SingleSurfaceViewManager] logContent: " + ("updateLayerDescription, interactId: " + r22 + ", uiPosition: " + r13 + "\nparams[" + r111.getLeft() + ", " + r111.getTop() + ", " + r111.getRight() + ", " + r111.getBottom() + "], visible = " + r111.isVisible() + ", mode = " + r111.getMode() + ", zOrder = " + r111.d()));
            r28.b();
            goto L127
        L115:
            if (r43.getTop() != r111.getTop()) goto L126;
            if (r43.getRight() != r111.getRight()) goto L126;
            if (r43.getBottom() != r111.getBottom()) goto L126;
            if (r43.isVisible() != r111.isVisible()) goto L126;
            if (r43.getMode() != r43.getMode()) goto L126;
            if (r43.d() == r111.d()) goto L127;
        L108:
            r49 = 0;
        L101:
            r46 = 0;
            goto L102
        L93:
            if (r111.isVisible() == true) goto L95;
        L84:
            r111 = null;
            goto L85
        L68:
            r35 = null;
            goto L70
        L61:
            r33 = null;
        L57:
            r28 = null;
            goto L58
        L51:
            if (r15 == null) goto L57;
            ji6.c r51 = r15.u();
            if (r51 == null) goto L57;
            z r52 = r51.C();
            if (r52 == null) goto L57;
            r28 = r52.l();
            goto L58
        L42:
            r25 = null;
        L127:
            r13 = r19;
            goto L31
        L139:
            return;
        L138:
            return;
        L128:
            return;
        L22:
            r12 = null;
        L16:
            r8 = null;
        L10:
            r1 = "";
            goto L11
        }

        @Override // iy.h
        public final Object u4(String r5, ny.o r6) {
            Intrinsics.checkNotNullParameter(r5, "liveCoreSetting");
            Intrinsics.checkNotNullParameter(r6, "setupLiveLinkParams");
            Ref.ObjectRef r0 = new Ref.ObjectRef();
            r0.element = null;
            LivePluginSPIManager.e.getClass();
            LivePluginSPIManager.a().addOnSuccess(new com.bytedance.android.live.anchormodelink.impl.f(this, r0, r5, r6)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
            v0 r7 = (v0) r0.element;
            if (r7 != null) goto L5;
            return null;
        L5:
            return gc6.b.c(r7, null);
        }

        @Override // iy.h
        public final void z4(ny.e r11, ec6.a r12, Function0 r13, Function0 r14) {
            Intrinsics.checkNotNullParameter(r13, "onConfirm");
            Intrinsics.checkNotNullParameter(r14, "onCancel");
            com.bytedance.android.live.anchormodelink.linkroom.e r2 = this.a.g;
            if (r2 == null) goto L26;
            Intrinsics.checkNotNullParameter(r13, "onConfirm");
            Intrinsics.checkNotNullParameter(r14, "onCancel");
            InteractBeautyPreviewDialog r0 = r2.a;
            if (r0 != null) goto L7;
        L9:
            m90.a<Boolean> r1 = ((IEffectPluginPropertyService) k.n(IEffectPluginPropertyService.class)).getLIVE_BEAUTY_STICKER_TAB_DOT_SHOW();
            if (r1 == null) goto L13;
            r1.a(LiveEffectContextFactoryType.LINK, Boolean.FALSE);
        L13:
            if ((r12 instanceof ec6.a) == true) goto L15;
            r12 = null;
        L15:
            if (r12 == null) goto L17;
            v0 r9 = r12.p();
        L18:
            String r15 = r11.a;
            if (r15 != null) goto L21;
            r15 = s1.B(2131920806);
        L21:
            String r7 = r15;
            String r16 = r11.b;
            if (r16 != null) goto L24;
            r16 = s1.B(2131915442);
        L24:
            boolean r17 = r11.c;
            com.bytedance.android.live.anchormodelink.linkroom.d r18 = new com.bytedance.android.live.anchormodelink.linkroom.d(r2, r13, r14, r7, r16, r9);
            LivePluginSPIManager.e.getClass();
            LivePluginSPIManager.a().addOnSuccess(new LinkBasicJsbHandler$showLinkmicBeautyPanel$1(r2, r18, r17)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
            return;
        L17:
            r9 = null;
            goto L18
        L7:
            if (r0.isShowing() != true) goto L9;
            return;
        }
    }

    public static final class g implements Runnable {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            xs2.b.a().post(new com.bytedance.android.livesdk.event.t(1));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements InteractLiveCorePermissionGuarantor.a {
        public final /* synthetic */ AnchorModeLinkDynamicWidget a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ h a;
            public final /* synthetic */ boolean b;

            public a(h r1, boolean r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r3) {
                Long r4 = (Long) r3;
                if (this.b == false) goto L5;
                this.a.a.zq("on particular white page show");
                return;
            L5:
                this.a.a.yq("on particular white page close", false);
            }
        }

        public h(AnchorModeLinkDynamicWidget r1) {
            this.a = r1;
        }

        public final void a(boolean r4) {
            AnchorModeLinkDynamicWidget r0 = this.a;
            if (r0.i == 20) goto L5;
            return;
        L5:
            if (r4 == false) goto L8;
            r0.yq("on particular page show", true);
            return;
        L8:
            if (((Boolean) vm2.d.N.getValue(null, vm2.d.a[37])).booleanValue() == false) goto L11;
            WeakReference<Activity> r5 = com.bytedance.android.live.core.utils.a.a;
            if (com.bytedance.android.live.core.utils.a.e(this.a.getContext()) == true) goto L11;
            return;
        L11:
            this.a.zq("on particular page close");
        }

        public final void b(boolean r5) {
            jy0.b.a(this.a.a, "onKeepAudioTargetPageShow, isShow: " + r5 + ", mScene=" + this.a.i);
            AnchorModeLinkDynamicWidget r0 = this.a;
            if (r0.i == 20) goto L5;
            return;
        L5:
            Disposable r1 = r0.p;
            if (r1 == null) goto L8;
            r1.dispose();
        L8:
            AnchorModeLinkDynamicWidget r2 = this.a;
            r2.p = RxUtilKt.h(Observable.timer(r2.o, TimeUnit.MILLISECONDS)).subscribe(new a(this, r5));
        }
    }

    public final int getLayoutId() {
        return 2131565147;
    }

    public final int getScene() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        this.k = false;
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (vm2.e.p() == false) goto L6;
        wq().g();
    L6:
        if (this.i == 20) goto L8;
        return;
    L8:
        if (vm2.e.p() == true) goto L10;
    L13:
        zq("resume");
        return;
    L10:
        if (wq().p == false) goto L12;
        return;
    L12:
        if (wq().i == false) goto L13;
    }

    public final String tag() {
        return "AnchorModeLinkDynamicWidget";
    }

    public final InteractLiveCorePermissionGuarantor wq() {
        return (InteractLiveCorePermissionGuarantor) this.q.getValue();
    }

    public final boolean Aq() {
        return je0.d.E(((Widget) this).dataCenter);
    }

    @Override // iy.g
    public final boolean Bk() {
        ly.h r0 = this.c;
        if (r0 == null) goto L11;
        t r1 = r0.j;
        if (r1 == null) goto L9;
        ih0.c r2 = r1.d;
        if (r2 == null) goto L9;
        Boolean r3 = r2.A();
    L13:
        return Intrinsics.areEqual(r3, Boolean.TRUE);
    L9:
        r3 = null;
        goto L13
    L11:
        return false;
    }

    @Override // iy.g
    public final List<ILinkPlayerInfoBridge> L4() {
        com.bytedance.android.live.anchormodelink.gift.d r0 = this.f;
        if (r0 == null) goto L8;
        ArrayList<ILinkPlayerInfoBridge> r1 = r0.a;
        if (r1 == null) goto L8;
        return r1;
    L8:
        return CollectionsKt.emptyList();
    }

    @Override // iy.g
    public final boolean Rp() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        Integer r1 = (Integer) r0.get("data_new_video_linkmic_state", 0);
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L9:
        if (r2 <= LinkerUserState.Waiting.ordinal()) goto L12;
        return true;
    L12:
        return false;
    L7:
        r2 = 0;
        goto L9
    }

    @Override // iy.g
    public final int Ti() {
        com.bytedance.android.live.anchormodelink.linkroom.e r0 = this.g;
        if (r0 == null) goto L8;
        oy.d r1 = r0.b;
        if (r1 != null) goto L7;
        return -1;
    L7:
        return (int) r1.a;
    L8:
        return -1;
    }

    @Override // iy.g
    public final tf0.h getInteractAnimationService() {
        boolean r0 = iy.b.a;
        iy.b.e(this.a, "getInteractAnimationService");
        com.bytedance.android.live.anchormodelink.gift.d r1 = this.f;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.e;
    }

    @Override // iy.g
    public final boolean rb() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        Integer r1 = (Integer) r0.get("data_new_video_linkmic_state", 0);
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L9:
        if (r2 != LinkerUserState.Waiting.ordinal()) goto L12;
        return true;
    L12:
        return false;
    L7:
        r2 = 0;
        goto L9
    }

    @Override // iy.g
    public final boolean isEngineOn() {
        iy.f r0 = xq();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.ye();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget$initDynamicCenter$1] */
    public final void onCreate() {
        super.onCreate();
        com.bytedance.live.datacontext.j r0 = o3.g(this).getLiveStream();
        if (r0 == null) goto L5;
        com.bytedance.android.live.pushstream.d r1 = (com.bytedance.android.live.pushstream.d) r0.getValue();
    L6:
        this.h = r1;
        IRoom r2 = (IRoom) ((Widget) this).dataCenter.get("data_room", null);
        this.d = r2;
        boolean r3 = false;
        if (r2 == null) goto L15;
        Map r4 = r2.getLinkMap();
        if (r4 == null) goto L15;
        Set r5 = r4.keySet();
        if (r5 == null) goto L15;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L15;
        int r7 = CastIntegerProtector.parseInt(r6);
    L16:
        this.i = r7;
        boolean r8 = iy.b.a;
        String r9 = this.a;
        StringBuilder r11 = new StringBuilder("onCreate room:");
        r11.append(this.d);
        r11.append(", roomId:");
        IRoomBase r12 = this.d;
        if (r12 == null) goto L19;
        Long r13 = Long.valueOf(IRoomKtKt.getId(r12));
    L20:
        r11.append(r13);
        r11.append(", isAnchor:");
        r11.append(Aq());
        r11.append(", mScene:");
        r11.append(this.i);
        r11.append(", topContainer:");
        r11.append(this.x);
        iy.b.e(r9, r11.toString());
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L23;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.c(getComponentContext(), iy.d.class, this);
    L23:
        iy.b.e(this.a, "dataCenter=" + ((Widget) this).dataCenter);
        ((Widget) this).dataCenter.observe("cmd_new_video_link_invite", this);
        ((Widget) this).dataCenter.observe("data_new_video_linkmic_state", this);
        ((ObservableSubscribeProxy) xs2.b.a().b(h1.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new com.bytedance.android.live.anchormodelink.impl.e(this));
        ?? r14 = new AnchorModeLinkDynamicWidget$initDynamicCenter$1(this);
        if (Aq() == false) goto L26;
        r14.invoke(true);
    L36:
        this.e = new oy.f(findViewById(2131387772), this.v);
        com.bytedance.android.live.anchormodelink.gift.d r15 = new com.bytedance.android.live.anchormodelink.gift.d(((Widget) this).dataCenter, this.v);
        this.f = r15;
        this.g = new com.bytedance.android.live.anchormodelink.linkroom.e(((Widget) this).context, ((Widget) this).dataCenter, r15, this.u);
        int r16 = this.i;
        if (r16 != 20) goto L39;
        Bq(Integer.valueOf(r16));
    L39:
        IInteractService r17 = k.f(IInteractService.class);
        if (r17 == null) goto L47;
        com.bytedance.android.live.liveinteract.service.c r18 = r17.getAnchorModeOutService();
        if (r18 == null) goto L47;
        com.bytedance.android.live.liveinteract.service.c r19 = r18;
        ALogger.i("AnchorModeOutServiceImp", "clearLiveEndEvent");
        Disposable r21 = r19.b;
        if (r21 == null) goto L46;
        r21.dispose();
    L46:
        r19.b = null;
        r19.a = null;
    L47:
        DataCenter r22 = ((Widget) this).dataCenter;
        if (r22 == null) goto L51;
        r22.observe("cmd_anchor_broadcast_end", this);
    L51:
        if (vm2.e.p() == true) goto L53;
        return;
    L53:
        if ((getContext() instanceof FragmentActivity) == false) goto L60;
        InteractLiveCorePermissionGuarantor r23 = wq();
        FragmentActivity r24 = getContext();
        if (r24 == null) goto L58;
        r23.i(r24);
        return;
    L58:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L60:
        return;
    L26:
        MiddlewareRoomContext r25 = o3.c(((Widget) this).dataCenter);
        if (r25 == null) goto L33;
        com.bytedance.live.datacontext.n r26 = r25.isRoomVisible();
        if (r26 == null) goto L33;
        Boolean r27 = (Boolean) r26.getValue();
        if (r27 == null) goto L33;
        r3 = r27.booleanValue();
    L33:
        r14.invoke(r3);
        if (r3 == true) goto L36;
        runWithRoomVisible(new com.bytedance.android.live.anchormodelink.impl.d(this));
        goto L36
    L19:
        r13 = null;
    L15:
        r7 = 0;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        boolean r0 = iy.b.a;
        iy.b.e(this.a, "onDestroy");
        if (je0.d.E(((Widget) this).dataCenter) == true) goto L5;
        Dd("exitLive", null);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        r1.removeObserver("cmd_anchor_broadcast_end", this);
    L8:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L11;
        r2.removeObserver("cmd_new_video_link_invite", this);
    L11:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.d(getComponentContext(), iy.d.class);
        this.b.dispose();
        ly.h r3 = this.c;
        if (r3 == null) goto L14;
        r3.f();
    L14:
        com.bytedance.android.live.anchormodelink.gift.d r4 = this.f;
        if (r4 == null) goto L20;
        r4.a = null;
        r4.b.clear();
        kh0.a r5 = r4.d;
        if (r5 == null) goto L19;
        r5.b();
    L19:
        com.bytedance.android.live.anchormodelink.gift.a r6 = r4.e;
        com.bytedance.android.live.anchormodelink.gift.d r7 = r6.e;
        com.bytedance.android.live.anchormodelink.gift.a.c r8 = r6.c;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "listener");
        r7.b.remove(r8);
    L20:
        iy.g r9 = com.bytedance.android.live.anchormodelink.linkroom.a.a;
        DataCenter r11 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r11, "dataCenter");
        r11.put("data_new_link_dynamic_widget_service", null);
        com.bytedance.android.live.anchormodelink.linkroom.a.a = null;
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L23;
        r12.put("data_video_talk_dot_with_number_show", "");
    L23:
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L27;
        r13.removeObserver("data_new_video_linkmic_state", this);
    L27:
        if (vm2.e.p() == false) goto L29;
        wq().e();
    L29:
        Disposable r14 = this.p;
        if (r14 == null) goto L32;
        r14.dispose();
    L32:
        this.p = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        this.k = true;
        if (vm2.e.p() == false) goto L6;
        wq().f();
    L6:
        if (this.i == 20) goto L8;
        return;
    L8:
        if (vm2.e.p() == true) goto L10;
    L11:
        yq("pause", false);
        return;
    L10:
        if (wq().p == false) goto L11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (vm2.e.p() == false) goto L6;
        wq().h();
        return;
    }

    public final iy.f xq() {
        bn0.b r0 = getMultiLinkRoomScope();
        if (r0 != null) goto L5;
        return null;
    L5:
        return (iy.f) m.e.d(r0, iy.f.class);
    }

    @Override // iy.g
    public final int getCurrentScene() {
        return this.i;
    }

    public final void Bq(Integer r5) {
        Room r0 = this.d;
        if (r0 == null) goto L5;
        r0.setInNewVideoLinkScene(true);
    L5:
        if (r5 == null) goto L7;
        int r6 = r5.intValue();
    L8:
        this.i = r6;
        com.bytedance.android.live.anchormodelink.gift.d r7 = this.f;
        if (r7 == null) goto L19;
        r7.c |= 512;
        IMultiLinkServiceExternal r1 = (IMultiLinkServiceExternal) k.f(IMultiLinkServiceExternal.class);
        if (r1 == null) goto L15;
        yr0.a r2 = r1.getControlServiceExternal();
        if (r2 == null) goto L15;
        int r3 = r2.getCurrentMode();
    L16:
        DataCenter r4 = r7.f;
        if (r4 == null) goto L19;
        r4.put("data_link_state", Integer.valueOf(r7.c | r3));
    L15:
        r3 = 0;
    L19:
        boolean r8 = iy.b.a;
        iy.b.a(this.a, "onVideoLinkStart mScene=" + this.i);
        xs2.b.a().post(new com.bytedance.android.livesdk.event.t(2));
        AndroidSchedulers.mainThread().scheduleDirect(g.a, 100, TimeUnit.MILLISECONDS);
        return;
    L7:
        r6 = 20;
        goto L8
    }

    @Override // iy.g
    public final JsonObject C(my.b r4) {
        Intrinsics.checkNotNullParameter(r4, "getStatusData");
        boolean r0 = iy.b.a;
        iy.b.e(this.a, "getLinkMicStatus type=" + r4.getType());
        iy.f r1 = xq();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.C(r4);
    }

    @Override // iy.g
    public final boolean Do(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uid");
        Iterator<T> r0 = L4().iterator();
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
        if (r2 == null) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // iy.g
    public final void Io(String r4) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        boolean r0 = iy.b.a;
        iy.b.e(this.a, "kickOutUser userId=" + r4);
        JsonObject r1 = new JsonObject();
        r1.addProperty("user_id", r4);
        Unit r5 = Unit.INSTANCE;
        Dd("kickOutGuest", r1);
    }

    @Override // iy.g
    public final void Kp(iy.i r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.bytedance.android.live.anchormodelink.gift.d r1 = this.f;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.b.remove(r3);
        return;
    }

    @Override // iy.g
    public final void gk(dq2.k r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.bytedance.android.live.anchormodelink.gift.d r1 = this.f;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.b.add(r3);
        return;
    }

    public final void onChanged(Object r21) {
        KVData r1 = (KVData) r21;
        Long r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getKey();
    L7:
        if (Intrinsics.areEqual(r3, "cmd_new_video_link_invite") == false) goto L11;
        boolean r4 = iy.b.a;
        iy.b.e(this.a, "onChanged kvData=" + r1);
        IBaseUser r5 = (IBaseUser) r1.getData();
        if (r5 == null) goto L21;
        JsonObject r6 = new JsonObject();
        r6.addProperty("user_id", r5.getIdString());
        r6.addProperty("sec_uid", r5.getCastSecUid());
        Unit r7 = Unit.INSTANCE;
        Dd("invite", r6);
    L21:
        if (r1 == null) goto L23;
        String r8 = r1.getKey();
    L25:
        if (Intrinsics.areEqual(r8, "cmd_anchor_broadcast_end") == false) goto L53;
        ec6.a r9 = this.w.a();
        if (je0.d.E(((Widget) this).dataCenter) == false) goto L54;
        if (r9 != null) goto L30;
        return;
    L30:
        if (this.i != 20) goto L56;
        IRoom r11 = a0.o(((Widget) this).dataCenter);
        if (r11 == null) goto L34;
        r2 = Long.valueOf(r11.getRoomId());
    L34:
        if (r2 == null) goto L36;
        long r12 = r2.longValue();
    L37:
        LinkMonitor.a(this.a, "startFinish", null, null, null, false, 124);
        i97.a r13 = i97.a.a;
        long r14 = System.currentTimeMillis();
        int r15 = jy.a.a;
        Map r16 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter("anchor_live_end", "reqSource");
        Intrinsics.checkNotNullParameter(r16, "extraParams");
        an0.b r17 = an0.b.a;
        uz0.e r18 = new uz0.e();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "$this$beforeConfigureRequest");
        Map r19 = r18.e;
        Intrinsics.checkNotNullParameter(r19, "fieldsMap");
        String r22 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r22 == null) goto L40;
        r19.put("room_id", r22);
    L40:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r19.put("request_source", "anchor_live_end");
        Iterator r23 = r16.entrySet().iterator();
    L42:
        if (r23.hasNext() == false) goto L46;
        Map.Entry r24 = (Map.Entry) r23.next();
        String r25 = (String) r24.getKey();
        String r26 = (String) r24.getValue();
        Intrinsics.checkNotNullParameter(r25, "$this$setTo");
        if (r26 == null) goto L42;
        r19.put(r25, r26);
        goto L42
    L46:
        Intrinsics.checkNotNullParameter(r18, "$this$afterConfigureRequest");
        Observable r27 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/finish/v3/", TypesJVMKt.getJavaType(Reflection.typeOf(LinkFinishResult.class)), Extra.class, ((uz0.a) r18).d, ((uz0.a) r18).a, ((uz0.a) r18).b, ((uz0.a) r18).c, r18.e, r18.f, r18.g);
        int r28 = p.a;
        r27.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.anchormodelink.impl.b(this, r14), new com.bytedance.android.live.anchormodelink.impl.c(this, r14));
        return;
    L36:
        r12 = 0;
        goto L37
    L56:
        return;
    L54:
        return;
    L53:
        return;
    L23:
        r8 = null;
        goto L25
    L11:
        if (r1 == null) goto L13;
        String r29 = r1.getKey();
    L15:
        if (Intrinsics.areEqual(r29, "data_new_video_linkmic_state") == false) goto L21;
        if (r1 == null) goto L18;
        Integer r31 = (Integer) r1.getData();
    L19:
        if (r31 == null) goto L21;
        hd0.g.d.d(Integer.valueOf(r31.intValue()));
        goto L21
    L18:
        r31 = null;
        goto L19
    L13:
        r29 = null;
        goto L15
    L5:
        r3 = null;
        goto L7
    }

    @Override // iy.d
    public final void onSei(String r3) {
        boolean r0 = iy.b.a;
        iy.b.a("New_Link_SEI", "onSei sei: " + r3);
        if (r3 == null) goto L8;
        iy.f r1 = xq();
        if (r1 == null) goto L9;
        r1.I5(r3, null);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.anchormodelink.BaseAnchorModeDynamicWidget
    public final void p3(IRoom r4) {
        boolean r0 = iy.b.a;
        iy.b.e(this.a, "updateRoomAfterEnter room:" + r4);
        this.d = r4;
    }

    @Override // iy.g
    public final Map<String, String> to(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        return this.m;
    }

    @Override // iy.g
    public final void updateFullScreenDialogShowStatus(boolean r3) {
        if (this.i == 20) goto L5;
        return;
    L5:
        if (this.k == true) goto L9;
        JsonObject r0 = new JsonObject();
        r0.addProperty("enable", Boolean.valueOf(!r3));
        Unit r4 = Unit.INSTANCE;
        Dd("mediaCaptureLiveStatusChange", r0);
        return;
    }

    public final void zq(String r3) {
        jy0.b.d(this.a, "handleAVPermissionOnResume, reason: ".concat(r3));
        Disposable r4 = this.p;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        this.p = null;
        JsonObject r5 = new JsonObject();
        r5.addProperty("enable", Boolean.TRUE);
        Unit r0 = Unit.INSTANCE;
        Dd("mediaCaptureLiveStatusChange", r5);
    }

    public AnchorModeLinkDynamicWidget(ViewGroup r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "topContainer");
        this.x = r2;
        this.y = r3;
        this.a = "AnchorModeLinkDynamicWidget";
        this.b = new CompositeDisposable();
        this.j = new ToolbarRoomBattleBehavior();
        this.l = LazyKt.lazy(new AnchorModeLinkDynamicWidget$guestSingleViewSurfaceView$2(this));
        this.m = new LinkedHashMap();
        this.n = new GestureDetector(((Widget) this).context, new a(this));
        this.o = ((Number) vm2.d.I7.getValue(null, vm2.d.a[447(0x1bf, float:6.26E-43)])).longValue();
        this.q = LazyKt.lazy(new AnchorModeLinkDynamicWidget$mInteractLiveCorePermissionGuarantor$2(this));
        this.r = new h(this);
        this.s = new d(this);
        this.u = new c(this);
        this.v = new e(this);
        this.w = new f(this);
    }

    @Override // iy.g
    public final void Dd(String r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        ly.h r0 = this.c;
        if (r0 == null) goto L6;
        r0.h(r2, r3);
        return;
    }

    @Override // iy.d
    public final void a(View r6, MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "event");
        ly.h r8 = this.c;
        View r0 = null;
        if (r8 == null) goto L7;
        t r9 = r8.j;
        if (r9 == null) goto L7;
        com.bytedance.android.live.anchormodelink.handlers.d r11 = r9.a;
    L9:
        if ((r11 instanceof com.bytedance.android.live.anchormodelink.handlers.d) == true) goto L12;
        r11 = null;
    L12:
        if (r11 == null) goto L16;
        Integer r12 = r11.i;
        if (r12 == null) goto L16;
        boolean r13 = ((List) vm2.i.R.getValue(null, vm2.i.a[42])).contains(Integer.valueOf(r12.intValue()));
    L17:
        if (r13 == true) goto L19;
        return;
    L19:
        Rect r14 = new Rect();
        ly.h r2 = this.c;
        if (r2 == null) goto L36;
        Intrinsics.checkNotNullParameter(r14, "rect");
        int[] r3 = {0, 0};
        t r4 = r2.j;
        if (r4 == null) goto L26;
        ih0.c r5 = r4.d;
        if (r5 == null) goto L26;
        r0 = r5.S0();
    L26:
        if (r0 == null) goto L28;
        r0.getLocationOnScreen(r3);
    L28:
        if (r0 == null) goto L30;
        int r15 = r0.getWidth();
    L31:
        if (r0 == null) goto L33;
        int r1 = r0.getHeight();
    L34:
        int r16 = r3[0];
        r14.left = r16;
        int r17 = r3[1];
        r14.top = r17;
        r14.right = r16 + r15;
        r14.bottom = r17 + r1;
        goto L36
    L33:
        r1 = 0;
        goto L34
    L30:
        r15 = 0;
    L36:
        if (((int) r7.getRawX()) > r14.left) goto L38;
        return;
    L38:
        if (((int) r7.getRawX()) < r14.right) goto L40;
        return;
    L40:
        if (((int) r7.getRawY()) > r14.top) goto L42;
        return;
    L42:
        if (((int) r7.getRawY()) >= r14.bottom) goto L48;
        this.n.onTouchEvent(r7);
        return;
    L48:
        return;
    L16:
        r13 = false;
    L7:
        r11 = null;
        goto L9
    }

    @Override // iy.d
    public final void k(String r11, ye1.a r12) {
        Intrinsics.checkNotNullParameter(r11, "sei");
        Intrinsics.checkNotNullParameter(r12, "info");
        boolean r0 = iy.b.a;
        iy.b.a("New_Link_SEI", "onSeiV2 sei: " + r11);
        iy.f r1 = xq();
        if (r1 == null) goto L6;
        r1.I5(r11, new my.e(r12.a, r12.b, r12.c, r12.d, r12.f));
        return;
    }

    public final boolean qa(final Runnable r11, boolean r12) {
        boolean r0 = iy.b.a;
        iy.b.e(this.a, "native intercept leave room, skippingToOtherRoom=" + r12);
        if (je0.d.E(((Widget) this).dataCenter) == false) goto L5;
        return false;
    L5:
        if (this.i != 20) goto L25;
        ly.h r1 = this.c;
        if (r1 == null) goto L26;
        t r2 = r1.j;
        if (r2 == null) goto L13;
        ih0.c r3 = r2.d;
        if (r3 == null) goto L13;
        Boolean r4 = r3.A();
    L15:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) != true) goto L27;
        JsonObject r5 = new JsonObject();
        r5.addProperty("skippingToOtherRoom", Boolean.valueOf(r12));
        final long r6 = System.currentTimeMillis();
        iy.b.e(this.a, "native intercept leave room, send native callback to Lynx");
        Dh("onInterceptCloseRoom", r5, new AnchorModeLinkDynamicWidget$intercept$1(this, r6, r11));
        ReadOnlyProperty r13 = vm2.d.d;
        KProperty[] r7 = vm2.d.a;
        if (((Number) r13.getValue(null, r7[2])).longValue() <= 0) goto L22;
        Disposable r8 = this.t;
        if (r8 == null) goto L21;
        r8.dispose();
    L21:
        this.t = AndroidSchedulers.mainThread().scheduleDirect(new b(r11), ((Number) r13.getValue(null, r7[2])).longValue(), TimeUnit.MILLISECONDS);
    L22:
        return true;
    L27:
        return false;
    L13:
        r4 = null;
        goto L15
    L26:
        return false;
    L25:
        return false;
    }

    public final void yq(String r4, boolean r5) {
        jy0.b.d(this.a, "handleAVPermissionOnPause, reason: " + r4 + ", forceSilence: " + r5);
        Disposable r6 = this.p;
        if (r6 == null) goto L5;
        r6.dispose();
    L5:
        this.p = null;
        JsonObject r7 = new JsonObject();
        r7.addProperty("enable", Boolean.FALSE);
        Unit r8 = Unit.INSTANCE;
        Dd("mediaCaptureLiveStatusChange", r7);
    }

    @Override // iy.g
    public final void Dh(String r6, JsonObject r7, Function1<? super JsonObject, Unit> r8) {
        Intrinsics.checkNotNullParameter(r6, "method");
        Intrinsics.checkNotNullParameter(r8, "callBack");
        ly.h r2 = this.c;
        if (r2 == null) goto L10;
        Intrinsics.checkNotNullParameter(r6, "method");
        Intrinsics.checkNotNullParameter(r8, "callBack");
        String r1 = String.valueOf(r6.hashCode());
        boolean r3 = iy.b.a;
        iy.b.e("AnchorModeDynamicCardManager", "sendNativeCallWithBack method:" + r6 + ", params:" + r7 + ", callbackId:" + r1);
        r2.u.put(r1, r8);
        t r9 = r2.j;
        if (r9 == null) goto L11;
        ih0.c r11 = r9.d;
        if (r11 == null) goto L12;
        JsonObject r4 = new JsonObject();
        r4.addProperty("type", "nativeCallChannel");
        JsonObject r5 = new JsonObject();
        r5.addProperty("method", r6);
        r5.addProperty("cb_id", r1);
        r5.add("params", r7);
        Unit r12 = Unit.INSTANCE;
        r4.add("data", r5);
        r11.sendJsEvent("onLinkmicStatusChange", r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget$updateLinkMicStatus$1] */
    @Override // iy.g
    public final void P0(my.c r21, final com.bytedance.android.live.liveinteract.jsbridge.method.k r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r21, "updateStatus");
        Intrinsics.checkNotNullParameter(r22, "updateCallback");
        boolean r0 = iy.b.a;
        iy.b.e(this.a, "updateLinkMicStatus type=" + r21.getType());
        ?? r5 = new AnchorModeLinkDynamicWidget$updateLinkMicStatus$1(r22);
        String r9 = "";
        int r11 = 0;
        boolean r12 = false;
        boolean r13 = false;
        r11 = 0;
        r11 = 0;
        r11 = 0;
        u32.k r14 = null;
        switch(com.bytedance.android.live.anchormodelink.impl.a.a[r21.getType().ordinal()]) {
            case 1: goto L138;
            case 2: goto L115;
            case 3: goto L102;
            case 4: goto L99;
            case 5: goto L99;
            case 6: goto L99;
            case 7: goto L99;
            case 8: goto L69;
            case 9: goto L44;
            case 10: goto L7;
            default: goto L4;
        };
    L4:
        iy.f r1 = xq();
        if (r1 == null) goto L321;
        r1.P0(r21, r22, r23);
        return;
    L321:
        return;
    L7:
        JsonObject r2 = r21.b;
        if (r2 == null) goto L14;
        JsonElement r3 = r2.get("update");
        if (r3 == null) goto L14;
        JsonObject r4 = r3.getAsJsonObject();
        if (r4 == null) goto L14;
        GsonMap r6 = UtilsKt.i(r4);
    L15:
        JsonObject r7 = r21.b;
        if (r7 == null) goto L22;
        JsonElement r8 = r7.get("remove");
        if (r8 == null) goto L22;
        JsonArray r15 = r8.getAsJsonArray();
        if (r15 == null) goto L22;
        List r16 = CollectionsKt.toList(r15);
    L24:
        if ((r16 instanceof List) == true) goto L26;
        r16 = null;
    L26:
        if (r16 != null) goto L28;
        r16 = CollectionsKt.emptyList();
    L28:
        iy.b.e(this.a, "handleUpdateGlobalTracker update=" + r6 + ", removeKeys=" + r16 + ", extraInfo=" + r21.b);
        Map<String, String> r17 = this.m;
        if (r6 == null) goto L38;
        Iterator<Map.Entry<String, Object>> r18 = r6.entrySet().iterator();
    L32:
        if (r18.hasNext() == false) goto L38;
        Map.Entry<String, Object> r19 = r18.next();
        String r24 = r19.getKey();
        Object r25 = r19.getValue();
        if (r25 == null) goto L36;
        String r26 = r25.toString();
    L37:
        r17.put(r24, r26);
        goto L32
    L36:
        r26 = null;
    L38:
        if (r16 == null) goto L43;
        Iterator r27 = r16.iterator();
    L41:
        if (r27.hasNext() == false) goto L43;
        r17.remove((String) r27.next());
    L43:
        boolean r28 = iy.b.a;
        iy.b.e(this.a, "handleUpdateGlobalTracker end, mGlobalTrackerMap=" + this.m);
        r5.m14invoke();
        return;
    L22:
        r16 = null;
    L14:
        r6 = null;
        goto L15
    L44:
        DiggContext.a r29 = DiggContext.Companion;
        DataCenter r31 = ((Widget) this).dataCenter;
        r29.getClass();
        DiggContext r32 = DiggContext.a.a(r31);
        if (r32 == null) goto L49;
        com.bytedance.live.datacontext.n r33 = r32.getDiggWidget();
        if (r33 == null) goto L49;
        r14 = (u32.k) r33.getValue();
    L49:
        u32.k r110 = r14;
        JsonObject r34 = r21.b;
        if (r34 == null) goto L54;
        JsonElement r35 = r34.get("x");
        if (r35 == null) goto L54;
        double r36 = r35.getAsDouble();
    L55:
        JsonObject r37 = r21.b;
        if (r37 == null) goto L60;
        JsonElement r38 = r37.get("y");
        if (r38 == null) goto L60;
        double r39 = r38.getAsDouble();
    L62:
        if (r36 > 0.0d) goto L64;
    L68:
        r5.m14invoke();
        return;
    L64:
        if (r39 <= 0.0d) goto L68;
        PointF r41 = new PointF(UtilityKotlinExtentionsKt.h((float) r36), UtilityKotlinExtentionsKt.h((float) r39));
        if (r110 == null) goto L68;
        r110.Km(null, 700, r41, true, false, false);
    L60:
        r39 = 0.0d;
    L54:
        r36 = 0.0d;
        goto L55
    L69:
        int r42 = ny.a.f;
        JsonObject r43 = r21.b;
        ny.a r44 = new ny.a();
        if (r43 == null) goto L90;
        JsonElement r45 = r43.get("room_id");
        if (r45 == null) goto L74;
        String r46 = r45.getAsString();
    L75:
        r44.a = r46;
        JsonElement r47 = r43.get("is_anchor");
        if (r47 == null) goto L78;
        boolean r48 = r47.getAsBoolean();
    L79:
        r44.b = r48;
        JsonElement r49 = r43.get("video_mute");
        if (r49 == null) goto L82;
        r12 = r49.getAsBoolean();
    L82:
        r44.c = r12;
        JsonElement r51 = r43.get("schema");
        if (r51 == null) goto L85;
        String r52 = r51.getAsString();
    L86:
        r44.d = r52;
        JsonElement r53 = r43.get("close_schema");
        if (r53 == null) goto L89;
        r14 = r53.getAsString();
    L89:
        r44.e = r14;
        goto L90
    L85:
        r52 = null;
        goto L86
    L78:
        r48 = false;
        goto L79
    L74:
        r46 = null;
    L90:
        iy.b.e(this.a, "onSwitchRoomJsBridge info=" + r44);
        IInteractService r54 = k.f(IInteractService.class);
        if (r54 == null) goto L98;
        com.bytedance.android.live.liveinteract.service.c r55 = r54.getAnchorModeOutService();
        if (r55 == null) goto L98;
        com.bytedance.android.live.liveinteract.service.c r56 = r55;
        r56.a = r44;
        Disposable r57 = r56.b;
        if (r57 == null) goto L97;
        r57.dispose();
    L97:
        ALogger.i("AnchorModeOutServiceImp", "onSwitchRoomJsBridge info:" + r44);
        r56.b = xs2.b.a().b(g1.class).subscribe(new com.bytedance.android.live.liveinteract.service.b(r56));
    L98:
        r5.m14invoke();
        return;
    L99:
        com.bytedance.android.live.anchormodelink.linkroom.e r58 = this.g;
        if (r58 == null) goto L326;
        r58.a(r21, r22);
        return;
    L326:
        return;
    L102:
        ly.h r59 = this.c;
        if (r59 == null) goto L114;
        JsonObject r61 = r21.b;
        iy.b.e("AnchorModeDynamicCardManager", "onReceiveNativeCallback extra:" + r61);
        if (r61 == null) goto L114;
        String r62 = r61.get("cb_id").getAsString();
        if (r62 == null) goto L111;
        r9 = r62;
    L111:
        JsonObject r63 = r61.get("params").getAsJsonObject();
        Function1 r64 = (Function1) ((LinkedHashMap) r59.u).get(r9);
        if (r64 == null) goto L114;
        Unit r65 = (Unit) r64.invoke(r63);
    L114:
        r5.m14invoke();
        return;
    L115:
        com.bytedance.android.live.anchormodelink.gift.d r66 = this.f;
        if (r66 == null) goto L137;
        JsonObject r67 = r21.b;
        boolean r68 = Aq();
        if (r67 == null) goto L137;
        if (r66.d != null) goto L123;
        r66.d = new kh0.a(r68, null, "multi_seat_widget", new com.bytedance.android.live.anchormodelink.gift.c(r66));
    L123:
        JsonElement r69 = r67.get("effect_name");
        if (r69 == null) goto L130;
        String r71 = r69.getAsString();
        if (r71 == null) goto L130;
        r9 = r71;
    L130:
        if (TextUtils.isEmpty(r9) == true) goto L134;
        kh0.a r72 = r66.d;
        if (r72 == null) goto L137;
        r72.c(r9);
        goto L137
    L134:
        kh0.a r73 = r66.d;
        if (r73 == null) goto L137;
        r73.b();
    L137:
        r5.m14invoke();
        return;
    L138:
        JsonObject r74 = r21.b;
        if (r74 == null) goto L144;
        JsonElement r75 = r74.get("method");
        if (r75 == null) goto L144;
        String r76 = r75.getAsString();
        if (r76 == null) goto L144;
    L146:
        switch(r76.hashCode()) {
            case -404656754: goto L275;
            case 1176670249: goto L250;
            case 1239956894: goto L231;
            case 1776498390: goto L202;
            case 1829764357: goto L164;
            case 1979992149: goto L149;
            default: goto L302;
        };
    L302:
        iy.f r77 = xq();
        if (r77 == null) goto L305;
        r77.P0(r21, r22, r23);
    L305:
        r5.m14invoke();
        return;
    L149:
        if (r76.equals("videoLinkmicDidStart") == false) goto L302;
        if (Aq() == false) goto L153;
        ((Widget) this).dataCenter.put("cmd_video_talkroom_state_change", new l3(100));
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.PK.extended());
        c0 r78 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r79 = ToolbarButton.INTERACTION_ROOM_BATTLE;
        r78.p(r79.extended(), this.j);
        y3.m(((Widget) this).dataCenter).c(r79.extended());
        y3.m(((Widget) this).dataCenter).l(r79.extended(), "更多功能即将上线");
    L153:
        JsonObject r81 = r21.b;
        if (r81 == null) goto L162;
        JsonElement r82 = r81.get("params");
        if (r82 == null) goto L162;
        JsonObject r83 = r82.getAsJsonObject();
        if (r83 == null) goto L162;
        JsonElement r84 = r83.get("scene");
        if (r84 == null) goto L162;
        r14 = Integer.valueOf(r84.getAsInt());
    L162:
        Bq(r14);
        goto L302
    L164:
        if (r76.equals("layoutDidChange") == false) goto L302;
        JsonObject r85 = r21.b;
        if (r85 == null) goto L168;
        JsonElement r86 = r85.get("params");
    L169:
        if (r86 == null) goto L302;
        oy.f r87 = this.e;
        if (r87 == null) goto L302;
        int r111 = JsbParamParseUtil.a;
        JsonObject r88 = r86.getAsJsonObject();
        Intrinsics.checkNotNullParameter(r88, "params");
        JsonObject r89 = r88.get("to").getAsJsonObject();     // Catch: Exception -> L186
        if (r89 == null) goto L182;
        JsonElement r91 = r89.get("uiAttributes");     // Catch: Exception -> L186
        if (r91 == null) goto L182;
        JsonObject r92 = r91.getAsJsonObject();     // Catch: Exception -> L186
        if (r92 == null) goto L182;
        JsonElement r93 = r92.get("containerFrame");     // Catch: Exception -> L186
        if (r93 == null) goto L182;
        JsonObject r94 = r93.getAsJsonObject();     // Catch: Exception -> L186
    L183:
        if (r94 == null) goto L189;
        r14 = new oy.e(s1.e(r94.get("x").getAsFloat()), s1.e(r94.get("y").getAsFloat()), s1.e(r94.get("w").getAsFloat()), s1.e(r94.get("h").getAsFloat()));     // Catch: Exception -> L186
    L189:
        if (r87.a == null) goto L302;
        iy.b.d("[SingleSurfaceViewManager] updateSingleViewRect containerFrame=" + r14);
        if (r14 == null) goto L302;
        float r95 = r14.c;
        float r96 = r14.d;
        float r97 = r14.a;
        float r98 = r14.b;
        ViewGroup.LayoutParams r112 = r87.a.getLayoutParams();
        if (r112 == null) goto L197;
        r112.width = (int) r95;
    L197:
        ViewGroup.LayoutParams r99 = r87.a.getLayoutParams();
        if (r99 == null) goto L200;
        r99.height = (int) r96;
    L200:
        r87.a.setX(r97);
        r87.a.setY(r98);
        r87.a.requestLayout();
        iy.b.d("[SingleSurfaceViewManager] Set singleViewContainer1 relative to parent: x=" + r97 + ", y=" + r98);
    L182:
        r94 = null;
    L186:
        e = move-exception;
        boolean r100 = iy.b.a;
        iy.b.b("getSeatViewContainerConfig parseJson error: (cause:" + e.getCause() + " message:" + e.getMessage() + " stack: " + bytekn.foundation.utils.b.a(e, 3) + ')');
        goto L189
    L168:
        r86 = null;
        goto L169
    L202:
        if (r76.equals("giftInfoChanged") == false) goto L302;
        com.bytedance.android.live.anchormodelink.gift.d r101 = this.f;
        if (r101 == null) goto L302;
        JsonObject r102 = r21.b;
        if (r102 == null) goto L302;
        iy.b.d("[DynamicCenterGiftInfoManager] onGiftInfoChanged extraInfo=" + r102);
        com.bytedance.android.live.anchormodelink.gift.i r103 = JsbParamParseUtil.a(r102);
        if (r103 == null) goto L211;
        r13 = r103.a;
    L211:
        if (r103 == null) goto L213;
        ArrayList<ILinkPlayerInfoBridge> r104 = r103.b;
    L214:
        r101.a = r104;
        StringBuilder r105 = new StringBuilder("[DynamicCenterGiftInfoManager] gift users updated size=");
        ArrayList<ILinkPlayerInfoBridge> r106 = r101.a;
        if (r106 == null) goto L217;
        Integer r107 = Integer.valueOf(r106.size());
    L218:
        r105.append(r107);
        r105.append(", allowGift=");
        r105.append(r13);
        iy.b.d(r105.toString());
        boolean r108 = com.bytedance.android.live.revenue.core.util.h.a;
        ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).setAllowSendToGuest(r13);
        Iterator<T> r109 = r101.b.iterator();
    L220:
        if (r109.hasNext() == false) goto L302;
        iy.i r113 = (iy.i) r109.next();
        if (r103 == null) goto L226;
        ArrayList<ILinkPlayerInfoBridge> r114 = r103.b;     // Catch: Exception -> L224
    L227:
        r113.a(r114);     // Catch: Exception -> L224
    L224:
        e = move-exception;
        boolean r115 = iy.b.a;
        iy.b.b("[DynamicCenterGiftInfoManager] notify listener error:" + e.getMessage());
        goto L220
    L226:
        r114 = null;
        goto L227
    L217:
        r107 = null;
        goto L218
    L213:
        r104 = null;
        goto L214
    L231:
        if (r76.equals("applyUserCountChanged") == false) goto L302;
        JsonObject r116 = r21.b;
        if (r116 == null) goto L241;
        JsonElement r117 = r116.get("params");
        if (r117 == null) goto L241;
        JsonObject r118 = r117.getAsJsonObject();
        if (r118 == null) goto L241;
        JsonElement r119 = r118.get("applyUserCount");
        if (r119 == null) goto L241;
        r11 = r119.getAsInt();
    L241:
        iy.b.a(this.a, "applyUserCountChanged applyUserCount:" + r11);
        if (r11 <= 0) goto L246;
        DataCenter r120 = ((Widget) this).dataCenter;
        if (r120 == null) goto L302;
        r120.put("data_video_talk_dot_with_number_show", String.valueOf(r11));
        goto L302
    L246:
        DataCenter r121 = ((Widget) this).dataCenter;
        if (r121 == null) goto L302;
        r121.put("data_video_talk_dot_with_number_show", "");
        goto L302
    L250:
        if (r76.equals("userStateDidChange") == false) goto L302;
        JsonObject r122 = r21.b;
        if (r122 == null) goto L260;
        JsonElement r123 = r122.get("params");
        if (r123 == null) goto L260;
        JsonObject r124 = r123.getAsJsonObject();
        if (r124 == null) goto L260;
        JsonElement r125 = r124.get("from");
        if (r125 == null) goto L260;
        Object r126 = Integer.valueOf(r125.getAsInt());
    L261:
        JsonObject r127 = r21.b;
        if (r127 == null) goto L270;
        JsonElement r128 = r127.get("params");
        if (r128 == null) goto L270;
        JsonObject r129 = r128.getAsJsonObject();
        if (r129 == null) goto L270;
        JsonElement r130 = r129.get("to");
        if (r130 == null) goto L270;
        Object r131 = Integer.valueOf(r130.getAsInt());
    L271:
        iy.b.a(this.a, "userStateDidChange from:" + r126 + ", to:" + r131);
        DataCenter r132 = ((Widget) this).dataCenter;
        if (r132 == null) goto L302;
        r132.put("data_new_video_linkmic_state", r131);
    L270:
        r131 = LinkerUserState.None;
    L260:
        r126 = LinkerUserState.None;
        goto L261
    L275:
        if (r76.equals("videoLinkmicDidEnd") == false) goto L302;
        if (Aq() == false) goto L279;
        ((Widget) this).dataCenter.put("cmd_video_talkroom_state_change", new l3(1));
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.PK.extended());
        y3.m(((Widget) this).dataCenter).f(ToolbarButton.INTERACTION_ROOM_BATTLE.extended(), this.j);
    L279:
        Room r133 = this.d;
        if (r133 == null) goto L282;
        r133.setInNewVideoLinkScene(false);
    L282:
        com.bytedance.android.live.anchormodelink.gift.d r134 = this.f;
        if (r134 != null) goto L285;
    L296:
        this.i = 0;
        com.bytedance.android.live.anchormodelink.linkroom.e r135 = this.g;
        if (r135 == null) goto L301;
        DataCenter r136 = r135.e;
        if (r136 == null) goto L301;
        r136.put("data_common_talk_room_match_screen", 12);
    L301:
        iy.b.a(this.a, "onVideoLinkEnd mScene=" + this.i);
        xs2.b.a().post(new com.bytedance.android.livesdk.event.t(2));
        AndroidSchedulers.mainThread().scheduleDirect(com.bytedance.android.live.anchormodelink.impl.h.a, 100, TimeUnit.MILLISECONDS);
        goto L302
    L285:
        if (v.a(r134.c, 512) == false) goto L296;
        r134.c = v.b(r134.c, 512);
        IMultiLinkServiceExternal r137 = (IMultiLinkServiceExternal) k.f(IMultiLinkServiceExternal.class);
        if (r137 == null) goto L292;
        yr0.a r138 = r137.getControlServiceExternal();
        if (r138 == null) goto L292;
        int r139 = r138.getCurrentMode();
    L293:
        DataCenter r140 = r134.f;
        if (r140 == null) goto L296;
        r140.put("data_link_state", Integer.valueOf(r134.c | r139));
    L292:
        r139 = 0;
    L144:
        r76 = "";
        goto L146
    }
}
