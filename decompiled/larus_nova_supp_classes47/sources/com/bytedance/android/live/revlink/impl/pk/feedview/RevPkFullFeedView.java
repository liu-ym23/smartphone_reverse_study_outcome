package com.bytedance.android.live.revlink.impl.pk.feedview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevenueLayoutClient;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContextKt$sendDataToLynx$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiRegisterViewListenContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.pk.feedview.bridge.FeedPkBridgePresenter;
import com.bytedance.android.live.revlink.impl.pk.feedview.entrance.PkFeedEntrance;
import com.bytedance.android.live.revlink.impl.pk.feedview.layout.FeedPkService;
import com.bytedance.android.live.revlink.impl.pk.feedview.layout.FeedPkWindowManager;
import com.bytedance.android.live.revlink.impl.pk.feedview.lynx.FeedBreakThroughBarWidget;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkMachinePresenter;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkStateMachine;
import com.bytedance.android.live.revlink.impl.pk.ui.IMProgressBarLayout;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevPkFullFeedView extends FrameLayout implements qc0.f {
    public final c41.a a;
    public FeedPkWidget b;
    public long c;
    public boolean d;
    public IRoom e;
    public final b41.f f;
    public final b41.d g;
    public final b41.e h;
    public final boolean i;
    public String j;
    public final b41.c k;
    public qc0.a l;
    public final e41.a m;
    public final Lazy n;
    public final int o;
    public final kc0.d p;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.feedview.RevPkFullFeedView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/graphics/RectF;", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<RectF, Unit> {
        public AnonymousClass1(RevPkFullFeedView r8) {
            super(1, r8, RevPkFullFeedView.class, "onPkStreamDiff", "onPkStreamDiff(Landroid/graphics/RectF;)V", 0);
        }

        public final void invoke(RectF r4) {
            RevPkFullFeedView r0 = (RevPkFullFeedView) ((CallableReference) this).receiver;
            b41.d r1 = r0.g;
            r1.k = r4;
            if ((!r1.m) == false) goto L7;
            if (r4 != null) goto L6;
            com.bytedance.android.live.revenue.common.player.vendor.link.a r5 = null;
        L8:
            r1.i = r5;
            r0.f();
            return;
        L6:
            r5 = new com.bytedance.android.live.revenue.common.player.vendor.link.a.C0083a(r4);
            goto L8
        L7:
            r5 = com.bytedance.android.live.revenue.common.player.vendor.link.a.b.a;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((RectF) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.feedview.RevPkFullFeedView$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Float, Unit> {
        public AnonymousClass2(RevPkFullFeedView r8) {
            super(1, r8, RevPkFullFeedView.class, "onPkScaleUpdate", "onPkScaleUpdate(F)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).floatValue());
            return Unit.INSTANCE;
        }

        public final void invoke(float r3) {
            RevPkFullFeedView r0 = (RevPkFullFeedView) ((CallableReference) this).receiver;
            r0.g.j = r3;
            r0.f();
        }
    }

    public static final class a implements MessageQueue.IdleHandler {
        public final /* synthetic */ RevPkFullFeedView a;

        public a(RevPkFullFeedView r1) {
            this.a = r1;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            RevPkFullFeedView r0 = this.a;
            iq2.e r1 = vh6.c.b(er2.b.class).getKtvComponentFeedViewService();
            if (r1 == null) goto L5;
            iq2.d r2 = r1.a();
        L6:
            r0.l = r2;
            RevPkFullFeedView r3 = this.a;
            qc0.a r4 = r3.l;
            if (r4 == null) goto L11;
            r4.setAttachParent(r3, new FrameLayout.LayoutParams(-1, -2));
            return false;
        L11:
            return false;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b {
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public final /* synthetic */ RevPkFullFeedView a;

        public static final class a implements ttc.c {
            public final /* synthetic */ MutableLiveData a;
            public final /* synthetic */ Observer b;

            public a(MutableLiveData r1, b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void cancel() {
                MutableLiveData r0 = this.a;
                if (r0 == null) goto L6;
                r0.removeObserver(this.b);
                return;
            }
        }

        public static final class b<T> implements Observer {
            public final /* synthetic */ ObservableEmitter a;

            public b(ObservableEmitter r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                ObservableEmitter r0 = this.a;
                r0.onNext((pc0.d) r2);
            }
        }

        public c(RevPkFullFeedView r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<pc0.d> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            FeedPkWidget r0 = this.a.b;
            if (r0 == null) goto L5;
            MutableLiveData<pc0.d> r1 = r0.b.r;
        L6:
            b r2 = new b(r4);
            r4.setCancellable(new a(r1, r2));
            if (r1 == null) goto L10;
            r1.observeForever(r2);
            return;
        L10:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
    }

    public final void b() {
    }

    public final void c() {
    }

    public String getFeedViewName() {
        return "RevPkFullFeedView";
    }

    public qc0.b getIMultiFeedView() {
        return null;
    }

    public List<String> getImCacheTags() {
        return null;
    }

    public final void monitorLayouts(String r1) {
    }

    public final void onOnlineListChanged() {
    }

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
    }

    private final boolean getInnerMovePlayer() {
        kc0.d r0 = this.p;
        if (r0 != null) goto L5;
    L10:
        return true;
    L5:
        if (r0.getInnerMovePlayer() == true) goto L10;
        com.bytedance.android.live.revlink.impl.settings.live.a r1 = com.bytedance.android.live.revlink.impl.settings.live.a.j;
        r1.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.a.h.getValue(r1, com.bytedance.android.live.revlink.impl.settings.live.a.a[6])).booleanValue() == false) goto L10;
        return false;
    }

    public final void f() {
        String r2 = this.j;
        RevSeiFrame.a r0 = RevSeiFrame.G;
        if (r2 != null) goto L5;
        String r4 = "";
    L6:
        RevSeiFrame r5 = RevSeiFrame.a.a(r0, r4, false, 6);
        b41.d r7 = this.g;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r5, "seiFrame");
        r7.d = r5;
        if (r7.m == false) goto L21;
        Context r9 = r7.l.getContext();
        boolean r12 = !e5.n();
        int r13 = s1.y();
        if (rc0.b.a() != DeviceType.NORMAL_MOBILE) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == false) goto L14;
        int r15 = s1.A();
        Intrinsics.checkNotNullParameter(r9, "context");
        b03.a r16 = b03.a.a;
        int r10 = b03.c.a(r9, r12, r15);
    L15:
        if (r10 <= r13) goto L17;
        boolean r17 = true;
    L18:
        if (r12 == r17) goto L20;
        r13 = r10;
        r10 = r13;
    L20:
        Pair<Integer, Integer> r18 = TuplesKt.to(Integer.valueOf(r13), Integer.valueOf(r10));
    L28:
        r7.h = r18;
        RevSeiFrame r19 = r7.d;
        if (r19 != null) goto L31;
    L30:
        String r110 = "";
    L86:
        b41.e r3 = this.h;
        if (r3 == null) goto L89;
        Intrinsics.checkNotNullParameter(r5, "seiFrame");
        r3.c = r5;
        b41.b r6 = r3.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "seiFrame");
        r6.c = r5;
        r3.d();
    L89:
        FeedPkWidget r8 = this.b;
        if (r8 == null) goto L128;
        com.bytedance.android.live.revlink.impl.pk.feedview.sei.c r20 = r8.d.i;
        r20.getClass();
        if (r2 != null) goto L94;
        String r22 = r110;
    L138:
        RevSeiFrame r1 = RevSeiFrame.a.a(r0, r22, false, 6);     // Catch: Exception -> L108
        if (r2 != null) goto L99;
    L110:
        FeedPkLynxWidget r23 = r8.j;
        r23.getClass();
        if (r2 == null) goto L128;
        p0 r24 = null;
        if (StringsKt.contains$default(r2, "app_data", false, 2, null) != true) goto L129;
        JSONObject r25 = new JSONObject();
        r25.put("type", "sei_data");
        r25.put(Constants.Keys.DATA, r2);
        if (r23.v(r23.n, "sei_data") == false) goto L117;
        r23.x(r23.m, FeedPkLynxWidget.s(), r25.toString());
    L117:
        Iterator<String> r26 = r23.b.keySet().iterator();
    L119:
        if (r26.hasNext() == false) goto L129;
        String r27 = r26.next();
        if (r23.v(r23.b.get(r27), "sei_data") == false) goto L119;
        r23.x(r23.a.get(r27), FeedPkLynxWidget.s(), r25.toString());
        if (r23.f.contains(r27) == false) goto L119;
        ArrayList<JSONObject> r28 = r23.e.get(r27);
        if (r28 != null) goto L127;
        r28 = new ArrayList();
        r23.e.put(r27, r28);
    L127:
        r28.add(r25);
    L129:
        JSONObject r29 = r5.d();
        if (r29 == null) goto L132;
        p0 r111 = com.bytedance.android.live.revlink.impl.utils.h.a(r29);
    L133:
        if (r111 == null) goto L147;
        FeedPkWidget r30 = this.b;
        if (r30 == null) goto L148;
        r30.d(r111);
        return;
    L148:
        return;
    L147:
        return;
    L132:
        r111 = r24;
        goto L133
    L99:
        if (StringsKt.contains$default(r2, "app_data", false, 2, null) != true) goto L110;
        if (r20.c != null) goto L110;
        n0 r32 = r1.g();     // Catch: Exception -> L108
        if (r32 == null) goto L110;
        if (r32.g() == false) goto L110;
        r20.c = r32;     // Catch: Exception -> L108
    L108:
        e = move-exception;
        jy0.b.b("pk_preview", r110, e);
        goto L110
    L94:
        r22 = r2;
    L128:
        r24 = null;
        goto L129
    L31:
        if (r18 == null) goto L30;
        if (((Number) r18.getFirst()).intValue() == 0) goto L30;
        if (((Number) r18.getSecond()).intValue() == 0) goto L30;
        rx0.b r33 = r7.b;
        boolean r112 = !e5.n();
        Pair<Integer, Integer> r113 = r7.h;
        if (r113 == null) goto L46;
        com.bytedance.android.live.revenue.common.player.vendor.link.a r114 = r7.i;
        if (r114 == null) goto L46;
        IRoom r34 = r7.c;
        if (r34 == null) goto L46;
        boolean r35 = r34.isLiveTypeAudio();
        if (r34.getStreamType() != LiveMode.SCREEN_RECORD) goto L50;
        boolean r115 = true;
    L52:
        if (r34.isThirdParty() == false) goto L58;
        r110 = "";
        if (IRoomKtKt.getVrType(r34) != 1) goto L56;
    L57:
        boolean r36 = true;
    L60:
        RevenueLayoutClient r37 = r7.a;
        r37.i = r35;
        r37.j = r115;
        r37.h = r36;
        Intrinsics.checkNotNullParameter(r114, "mode");
        r37.e = r114;
        RevenueLayoutClient r38 = r7.a;
        r38.o = r7.j;
        DeviceType r39 = rc0.b.a();
        Intrinsics.checkNotNullParameter(r39, "deviceType");
        r38.f = r39;
        RevenueLayoutClient r40 = r7.a;
        int r42 = ((Number) r113.getFirst()).intValue();
        r40.b = ((Number) r113.getSecond()).intValue();
        r40.a = r42;
        RevenueLayoutClient r43 = r7.a;
        r43.g = r112;
        Intrinsics.checkNotNullParameter(r19, "seiFrame");
        r43.k = r19;
        r7.a.c();
        rx0.a r44 = r33.a;
        if (r44 == null) goto L74;
        r33.c.getClass();
        Intrinsics.checkNotNullParameter(r44, "client");
        sx0.a r45 = r44.a();
        if ((r45 instanceof sx0.a.e) == false) goto L67;
        yx0.d r46 = new yx0.a();
    L70:
        if (r46 == null) goto L72;
        tx0.a r47 = r46.a(r44);
    L73:
        r33.b = r47;
        goto L74
    L72:
        r47 = null;
        goto L73
    L67:
        if ((r45 instanceof sx0.b) == false) goto L69;
        r46 = new yx0.b();
        goto L70
    L69:
        r46 = null;
    L74:
        tx0.a r48 = r7.b.b;
        if (r48 == null) goto L77;
        RectF r49 = r48.a;
    L78:
        if (r48 == null) goto L80;
        RectF r50 = r48.b;
    L81:
        if (r48 == null) goto L84;
        Matrix r52 = r48.c;
        if (r52 == null) goto L84;
    L85:
        r7.e = r49;
        r7.f = r50;
        r7.g = r52;
    L84:
        r52 = new Matrix();
        goto L85
    L80:
        r50 = null;
        goto L81
    L77:
        r49 = null;
        goto L78
    L56:
        if (IRoomKtKt.getVrType(r34) == 2) goto L57;
    L59:
        r36 = false;
        goto L60
    L58:
        r110 = "";
        goto L59
    L50:
        r115 = false;
    L46:
        r110 = "";
        goto L74
    L17:
        r17 = false;
        goto L18
    L14:
        r10 = k31.p.a(r9, r12, false);
        goto L15
    L11:
        r14 = false;
        goto L12
    L21:
        FrameLayout r53 = r7.l.e;
        boolean r116 = !e5.n();
        int r117 = r53.getWidth();
        int r54 = r53.getHeight();
        if (r54 <= r117) goto L24;
        boolean r118 = true;
    L25:
        if (r116 == r118) goto L27;
        r117 = r54;
        r54 = r117;
    L27:
        r18 = TuplesKt.to(Integer.valueOf(r117), Integer.valueOf(r54));
        goto L28
    L24:
        r118 = false;
        goto L25
    L5:
        r4 = r2;
        goto L6
    }

    public List<ILinkPlayerInfoBridge> getOnlineList() {
        return new ArrayList();
    }

    public final Observable<pc0.d> observeFeedViewExposeData() {
        return Observable.create(new c(this));
    }

    public final void onViewHolderPause() {
        FeedPkWidget r0 = this.b;
        if (r0 == null) goto L47;
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r1 = r0.f;
        if (r1 == null) goto L7;
        r1.c();
    L7:
        FeedPkLynxWidget r2 = r0.j;
        boolean r3 = false;
        if (r2 == null) goto L20;
        r2.u = false;
        r2.g.clear();
        zy0.b r4 = r2.m;
        if (r4 == null) goto L12;
        r4.dispose();
    L12:
        r2.m = null;
        r2.y.removeAllViews();
        Iterator<zy0.b> r5 = r2.a.values().iterator();
    L14:
        if (r5.hasNext() == false) goto L20;
        zy0.b r6 = r5.next();
        if (r6 == null) goto L14;
        xy0.a<?> r7 = r6.g();
        if (r7 == null) goto L14;
        r7.dispose();
    L20:
        FeedPkWindowManager r8 = r0.d;
        if (r8 == null) goto L35;
        r8.g = false;
        z31.b r9 = r8.b();
        if (r8.g == false) goto L28;
        if (r8.f == false) goto L28;
        r3 = true;
    L28:
        if (r9.c == r3) goto L35;
        if (r9.c() == true) goto L33;
        r9.g.setVisibility(4);
    L33:
        r9.c = r3;
    L35:
        if (t41.a.m.a() == false) goto L48;
        FeedPkStateMachine r10 = r0.a;
        if (r10 == null) goto L49;
        r10.d.a();
        r10.e.a();
        r10.g.a();
        r10.f.a();
        return;
    L49:
        return;
    L48:
        return;
    }

    public final void onViewHolderResume() {
        FeedPkWidget r0 = this.b;
        if (r0 == null) goto L34;
        FeedPkMachinePresenter r1 = r0.a.h;
        if (r1.e == false) goto L10;
        IRoom r2 = r1.b;
        if (r2 == null) goto L10;
        r1.d(r2, new com.bytedance.android.live.revlink.impl.pk.feedview.machine.j(r1));
    L10:
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r3 = r0.f;
        if (r3 == null) goto L15;
        r3.d();
        FeedBreakThroughBarWidget r4 = r3.h;
        if (r4 == null) goto L15;
        FeedBreakThroughBarWidget.e(r4.c, r4.d);
    L15:
        FeedPkLynxWidget r5 = r0.j;
        boolean r6 = true;
        if (r5 == null) goto L18;
        r5.u = true;
        r5.q("resume");
    L18:
        FeedPkWindowManager r7 = r0.d;
        if (r7 == null) goto L35;
        r7.g = true;
        z31.b r8 = r7.b();
        if (r7.g == true) goto L23;
    L25:
        r6 = false;
    L27:
        if (r8.c != r6) goto L30;
        return;
    L30:
        if (r8.c() == true) goto L32;
        r8.g.setVisibility(4);
    L32:
        r8.c = r6;
        return;
    L23:
        if (r7.f == false) goto L25;
    L35:
        return;
    }

    public final void onViewHolderSelected() {
        h(C03651.INSTANCE);
    }

    public final void onViewHolderUnSelected() {
        h(C03661.INSTANCE);
    }

    public final void reset() {
        b41.f r0 = this.f;
        if (r0 == null) goto L13;
        b41.a r3 = r0.a;
        r3.a = false;
        ViewTreeObserver r4 = r3.e.getViewTreeObserver();
        if (r4 == null) goto L7;
        r4.removeOnGlobalLayoutListener(r3.d);
    L7:
        View r5 = r3.b;
        if (r5 == null) goto L12;
        ViewTreeObserver r6 = r5.getViewTreeObserver();
        if (r6 == null) goto L12;
        r6.removeOnGlobalLayoutListener(r3.d);
    L12:
        r3.b = null;
        r0.e.c.removeObserver(r0.b);
    L13:
        b41.e r1 = this.h;
        if (r1 == null) goto L27;
        r1.a.c = null;
        b41.d r7 = r1.h;
        r7.d = null;
        r7.e = null;
        r7.f = null;
        r7.g = null;
        r1.a();
        r1.g.b.setValue(null);
        r1.a.a(null);
        r1.d = false;
        IRenderView r2 = r1.b;
        if (r2 == null) goto L20;
        ViewParent r8 = r2.getParent();
        if (r8 == null) goto L20;
        ViewParent r9 = r8.getParent();
    L22:
        if ((r9 instanceof ViewGroup) == true) goto L24;
        r9 = null;
    L24:
        ViewGroup r10 = (ViewGroup) r9;
        if (r10 == null) goto L27;
        r10.setBackgroundColor(0);
    L20:
        r9 = null;
    L27:
        b41.c r12 = this.k;
        if (r12 == null) goto L34;
        kc0.d r13 = r12.c;
        if (r13 == null) goto L34;
        MediatorLiveData r14 = r13.getPlayerEvent();
        if (r14 == null) goto L34;
        r14.removeObserver(r12.a);
    L34:
        this.m.a();
        FeedPkWidget r15 = this.b;
        if (r15 == null) goto L94;
        r15.b.r.setValue(new pc0.d(0, 29));
        r15.c.e.removeObserver(r15.k);
        FeedPkLynxWidget r16 = r15.j;
        if (r16 == null) goto L52;
        zy0.b r17 = r16.m;
        if (r17 == null) goto L41;
        r17.dispose();
    L41:
        r16.m = null;
        r16.y.removeAllViews();
        Iterator<zy0.b> r18 = r16.a.values().iterator();
    L43:
        if (r18.hasNext() == false) goto L49;
        zy0.b r19 = r18.next();
        if (r19 == null) goto L43;
        xy0.a<?> r20 = r19.g();
        if (r20 == null) goto L43;
        r20.dispose();
        goto L43
    L49:
        r16.c.clear();
        r16.g.dispose();
        MultiRegisterViewListenContext r22 = r16.j;
        if (r22 == null) goto L52;
        r22.b();
    L52:
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r23 = r15.f;
        if (r23 == null) goto L55;
        r23.c();
    L55:
        FeedPkWindowManager r24 = r15.d;
        r24.f = false;
        z31.b r25 = r24.b();
        if (r24.f == true) goto L58;
    L60:
        boolean r26 = false;
    L62:
        if (r25.c != r26) goto L65;
    L68:
        a41.d r27 = (a41.d) r24.e.getValue();
        if (r27 == null) goto L73;
        IMProgressBarLayout r28 = r27.a;
        if (r28 == null) goto L73;
        r28.setVisibility(8);
    L73:
        com.bytedance.android.live.revlink.impl.pk.feedview.sei.c r29 = r24.i;
        ViewGroup r30 = r29.a();
        if (r30 == null) goto L78;
        ViewTreeObserver r32 = r30.getViewTreeObserver();
        if (r32 == null) goto L78;
        r32.removeOnGlobalLayoutListener(r29);
    L78:
        IRenderView r33 = r29.b;
        if (r33 == null) goto L81;
        r33.removeRenderViewMeasureListener(r29);
    L81:
        r29.b = null;
        com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r34 = r15.c;
        FeedPkStateMachine r35 = r34.s;
        r35.a = null;
        r35.b = null;
        r35.c = null;
        FeedPkBridgePresenter r36 = r34.a;
        r36.b = null;
        r36.a = false;
        Disposable r37 = r36.n;
        if (r37 == null) goto L85;
        r37.dispose();
    L85:
        if (r36.c != null) goto L87;
    L90:
        r34.f();
        qc0.e r38 = r15.h;
        if (r38 == null) goto L93;
        r38.onCouplePkEnd();
    L93:
        FeedPkStateMachine r39 = r15.a;
        r39.d.a();
        r39.e.a();
        r39.g.a();
        r39.f.a();
        r15.i.dispose();
        r15.l.b.removeObserver(r15.e);
        goto L94
    L87:
        if (r36.e == false) goto L90;
        r36.d.clear();
        r36.e = false;
        goto L90
    L65:
        if (r25.c() == true) goto L67;
        r25.g.setVisibility(4);
    L67:
        r25.c = r26;
        goto L68
    L58:
        if (r24.g == false) goto L60;
        r26 = true;
    L94:
        this.b = null;
        qc0.a r40 = this.l;
        if (r40 == null) goto L105;
        r40.reset();
        return;
    }

    public qc0.c getIPkFeedView() {
        return this.b;
    }

    public qc0.a getKtvComponentFeedView() {
        return this.l;
    }

    public final int getShowFrom() {
        return this.o;
    }

    public static JSONObject g(String r4) {
        if (r4 != null) goto L20;
        return null;
    L20:
        LiveSeiUtil.i.getClass();     // Catch: JSONException -> L17
        JSONObject r5 = LiveSeiUtil.c(r4);     // Catch: JSONException -> L17
        if (r5.has("info") == true) goto L8;
        return r5;
    L8:
        if (r5.has("source") == true) goto L10;
        return r5;
    L10:
        if (TextUtils.equals(r5.optString("source"), "zego") == false) goto L22;
        Object r6 = r5.get("info");     // Catch: JSONException -> L17
        if (r6 == null) goto L15;
        return (JSONObject) r6;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: JSONException -> L17
    L22:
        return r5;
    L17:
        e = move-exception;
        ALogger.e("RevPkFullFeedView", "getJsonObjectBySei exception = " + e);
        return null;
    }

    public final void a(u01.m r2) {
        FeedPkWidget r0 = this.b;
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    public final void d(u01.l r5) {
        Intrinsics.checkNotNullParameter(r5, "hub");
        FeedPkWidget r1 = this.b;
        if (r1 == null) goto L11;
        mx0.a r2 = new mx0.a(r5);
        Intrinsics.checkNotNullParameter(r2, "hub");
        FeedPkStateMachine r6 = r1.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r2, "hub");
        FeedPkMachinePresenter r7 = r6.h;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "hub");
        r7.c = r2;
        if (r7.e == false) goto L7;
        r7.c(r2);
    L7:
        com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r8 = r1.c;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r2, "hub");
        FeedPkBridgePresenter r9 = r8.a;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r2, "hub");
        r9.c = r2;
        if (r9.a == false) goto L12;
        r9.b(r2);
        return;
    L12:
        return;
    }

    public final void e(u01.k r3) {
        Intrinsics.checkNotNullParameter(r3, "caller");
        b41.e r1 = this.h;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "caller");
        r1.f = r3;
    L5:
        FeedPkWidget r2 = this.b;
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r3, "caller");
        r2.h = r3;
        return;
    }

    public final void h(Function1<? super RevPkFullFeedView, Unit> r8) {
        boolean r0 = this.d;
        r8.invoke(this);
        boolean r9 = this.d;
        if (r0 != r9) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (r9 == false) goto L42;
        FeedPkWidget r10 = this.b;
        if (r10 == null) goto L83;
        FeedPkLynxWidget r3 = r10.j;
        if (r3 == null) goto L16;
        r3.t = true;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a r4 = r3.d;
        if (r4.i == true) goto L15;
        r4.i = true;
        r4.k.a.l.observeForever(r4.g);
        r4.k.a.m.observeForever(r4.h);
    L15:
        r3.q("select");
    L16:
        FeedPkMachinePresenter r5 = r10.a.h;
        r5.e = true;
        mx0.a r6 = r5.c;
        if (r6 == null) goto L19;
        r5.c(r6);
    L19:
        IRoom r7 = r5.b;
        if (r7 == null) goto L22;
        r5.d(r7, new com.bytedance.android.live.revlink.impl.pk.feedview.machine.j(r5));
    L22:
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r12 = r10.f;
        if (r12 == null) goto L27;
        r12.f = true;
        if (r12.e() == true) goto L27;
        r12.d();
    L27:
        FeedPkWindowManager r13 = r10.d;
        if (r13 == null) goto L84;
        r13.f = true;
        z31.b r14 = r13.b();
        if (r13.f == true) goto L32;
    L34:
        r1 = false;
    L36:
        if (r14.c != r1) goto L39;
        return;
    L39:
        if (r14.c() == true) goto L41;
        r14.g.setVisibility(4);
    L41:
        r14.c = r1;
        return;
    L32:
        if (r13.g == false) goto L34;
    L84:
        return;
    L83:
        return;
    L42:
        FeedPkWidget r15 = this.b;
        if (r15 == null) goto L86;
        FeedPkLynxWidget r16 = r15.j;
        if (r16 == null) goto L51;
        r16.t = false;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a r17 = r16.d;
        if (r17.i == false) goto L50;
        r17.i = false;
        r17.k.a.m.removeObserver(r17.g);
        r17.k.a.l.removeObserver(r17.h);
    L50:
        r16.g.clear();
    L51:
        FeedPkStateMachine r18 = r15.a;
        r18.d.a();
        r18.e.a();
        r18.g.a();
        r18.f.a();
        FeedPkMachinePresenter r19 = r18.h;
        r19.e = false;
        r19.f = false;
        r19.g = null;
        r19.a.clear();
        if (r19.c != null) goto L54;
    L57:
        FeedPkWindowManager r20 = r15.d;
        if (r20 == null) goto L77;
        r20.f = false;
        z31.b r22 = r20.b();
        if (r20.f == true) goto L62;
    L64:
        r1 = false;
    L66:
        if (r22.c != r1) goto L69;
    L72:
        a41.d r2 = (a41.d) r20.e.getValue();
        if (r2 == null) goto L77;
        IMProgressBarLayout r23 = r2.a;
        if (r23 == null) goto L77;
        r23.setVisibility(8);
        goto L77
    L69:
        if (r22.c() == true) goto L71;
        r22.g.setVisibility(4);
    L71:
        r22.c = r1;
        goto L72
    L62:
        if (r20.g == false) goto L64;
    L77:
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r24 = r15.f;
        if (r24 == null) goto L87;
        r24.f = false;
        if (r24.e() == true) goto L88;
        r24.c();
        return;
    L88:
        return;
    L87:
        return;
    L54:
        if (r19.d == false) goto L57;
        r19.d = false;
        goto L57
    }

    public final void onSeiUpdatedRaw(String r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        Intrinsics.checkNotNullParameter(r15, "sei");
        boolean r1 = false;
        JSONObject r3 = null;
        if (StringsKt.contains$default(r15, "TTLiveSDK_Android", false, 2, null) == false) goto L7;
    L14:
        boolean r0 = true;
    L15:
        if (r0 == true) goto L17;
        return;
    L17:
        JSONObject r2 = g(r15);
        JSONObject r5 = g(r15);
        if (r5 != null) goto L20;
    L22:
        if (r3 == null) goto L44;
        long r9 = r3.optLong("timestamp");
        if (r9 != this.c) goto L41;
        if (r2 != null) goto L46;
    L36:
        if (r1 == false) goto L44;
        int r4 = e41.b.a;
        if (e41.b.a(this.e, this.i) == true) goto L41;
    L46:
    L34:
        e = move-exception;
        ALogger.e("RevPkFullFeedView", "isInPkMode exception = " + e);
        goto L36
    L27:
        if (r2.has("app_data") == false) goto L36;
        JSONObject r6 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r2, "app_data"), ""));     // Catch: JSONException -> L34
        if (r6.has("ver") == false) goto L36;
        if (r6.optInt("ver") != 2) goto L36;
        r1 = true;
    L41:
        if (r3.has("ver") == false) goto L44;
        this.c = r9;
        this.j = r15;
    L44:
        f();
        return;
    L20:
        if (r5.has("app_data") == false) goto L22;
        r3 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r5, "app_data"), ""));
        goto L22
    L7:
        if (StringsKt.contains$default(r15, "TTLiveSDK_IOS", false, 2, null) == true) goto L14;
        if (StringsKt.contains$default(r15, "TTLiveSDK_Windows", false, 2, null) == true) goto L14;
        if (StringsKt.contains$default(r15, "\\\"ver\\\":2", false, 2, null) == true) goto L14;
        r0 = false;
        goto L15
    }

    public final void putImCacheContent(Map<String, ? extends RevImCacheUnit> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public final void sendMessage(List<? extends yh6.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "msgList");
        FeedPkWidget r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNullParameter(r3, "msgList");
        FeedPkStateMachine r2 = r1.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "msgList");
        FeedPkMachinePresenter r4 = r2.h;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "msgList");
        if (r4.f == false) goto L7;
        r4.e();
        return;
    L7:
        r4.g = r3;
        return;
    }

    public void setJsBridgeMap(Map<String, ? extends com.bytedance.ies.web.jsbridge2.f.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        FeedPkWidget r1 = this.b;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "map");
        FeedPkLynxWidget r2 = r1.j;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "map");
        r2.s.putAll(r3);
        return;
    }

    public void setLivePlayerView(Object r7) {
        ViewParent r1 = null;
        if ((r7 instanceof IRenderView) == true) goto L5;
        r7 = null;
    L5:
        IRenderView r8 = (IRenderView) r7;
        b41.f r0 = this.f;
        if (r0 == null) goto L28;
        r0.c = r8;
        b41.a r2 = r0.a;
        if (r8 == null) goto L10;
        View r3 = r8.getSelfView();
    L12:
        if (r2.a == true) goto L15;
    L27:
        r0.a();
        goto L28
    L15:
        if (Intrinsics.areEqual(r2.b, r3) == true) goto L27;
        View r4 = r2.b;
        if (r4 == null) goto L22;
        ViewTreeObserver r5 = r4.getViewTreeObserver();
        if (r5 == null) goto L22;
        r5.removeOnGlobalLayoutListener(r2.d);
    L22:
        if (r3 == null) goto L26;
        ViewTreeObserver r6 = r3.getViewTreeObserver();
        if (r6 == null) goto L26;
        r6.addOnGlobalLayoutListener(r2.d);
    L26:
        r2.b = r3;
        goto L27
    L10:
        r3 = null;
    L28:
        b41.e r9 = this.h;
        if (r9 == null) goto L31;
        r9.b = r8;
        r9.a.d = r8;
        r9.d();
    L31:
        FeedPkWidget r10 = this.b;
        if (r10 == null) goto L51;
        com.bytedance.android.live.revlink.impl.pk.feedview.sei.c r12 = r10.d.i;
        r12.b = r8;
        if (r8 == null) goto L36;
        r8.addRenderViewMeasureListener(r12);
    L36:
        if (r8 == null) goto L40;
        ViewParent r13 = r8.getParent();
        if (r13 == null) goto L40;
        ViewParent r14 = r13.getParent();
    L42:
        if ((r14 instanceof ViewGroup) == false) goto L45;
        r1 = r14;
    L45:
        r12.e = (ViewGroup) r1;
        ViewGroup r15 = r12.a();
        if (r15 == null) goto L52;
        ViewTreeObserver r16 = r15.getViewTreeObserver();
        if (r16 == null) goto L53;
        r16.addOnGlobalLayoutListener(r12);
        return;
    L53:
        return;
    L52:
        return;
    L40:
        r14 = null;
        goto L42
    }

    public final void updateRoom(IRoom r9) {
        Intrinsics.checkNotNullParameter(r9, "room");
        this.e = r9;
        this.a.a = r9;
        b41.d r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "room");
        r1.c = r9;
        b41.e r2 = this.h;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNullParameter(r9, "room");
        b41.b r3 = r2.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r9, "room");
        r3.a = r9;
    L5:
        FeedPkWidget r4 = this.b;
        if (r4 == null) goto L24;
        Intrinsics.checkNotNullParameter(r9, "room");
        FeedPkLynxWidget r5 = r4.j;
        r5.q = r9;
        Iterator<String> r6 = r5.i.keySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        String r7 = r6.next();
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == true) goto L12;
        LiveData<?> r8 = r5.i.get(r7);
        if (r8 == null) goto L9;
        Intrinsics.checkNotNullParameter(r8, "$this$sendDataToLynx");
        Intrinsics.checkNotNullParameter(r7, "tag");
        MediatorLiveData r10 = new MediatorLiveData();
        r10.addSource(r8, new PkLynxDataContextKt$sendDataToLynx$$inlined$also$lambda$1(r10, r7));
        r10.observeForever(r5.w);
        goto L9
    L12:
        LiveData r12 = (LiveData) ((LinkedHashMap) r5.x).get(r7);
        if (r12 == null) goto L9;
        r12.observeForever(r5.w);
        goto L9
    L18:
        r5.q("room_update");
        FeedPkStateMachine r13 = r4.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r9, "room");
        FeedPkMachinePresenter r14 = r13.h;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r9, "room");
        r14.b = r9;
        if (r14.e == false) goto L21;
        r14.d(r9, new com.bytedance.android.live.revlink.impl.pk.feedview.machine.j(r14));
    L21:
        FeedPkWindowManager r15 = r4.d;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r9, "room");
        r15.b().getClass();
        Intrinsics.checkNotNullParameter(r9, "room");
        com.bytedance.android.live.revlink.impl.pk.feedview.sei.c r16 = r15.i;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r9, "room");
        r16.a = r9;
        com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r17 = r4.c;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r9, "room");
        r17.b = r9;
        FeedPkBridgePresenter r18 = r17.a;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r9, "room");
        r18.f = r9;
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r19 = r4.f;
        if (r19 == null) goto L24;
        Intrinsics.checkNotNullParameter(r9, "room");
        r19.e = r9;
        r19.d();
    L24:
        qc0.a r0 = this.l;
        if (r0 == null) goto L28;
        r0.updateRoom(r9);
    L28:
        if (this.j == null) goto L41;
        f();
        return;
    }

    public RevPkFullFeedView(Context r9, int r10, kc0.d r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9);
        this.o = r10;
        this.p = r12;
        c41.a r2 = new c41.a(r9, this);
        this.a = r2;
        e41.a r13 = new e41.a();
        this.m = r13;
        Lazy r0 = LazyKt.lazy(RevPkFullFeedView$isFeedHalfExpose$2.INSTANCE);
        this.n = r0;
        if (r10 == 5) goto L7;
        if (r10 == 1) goto L7;
        boolean r5 = false;
    L8:
        this.i = vh6.c.b(vr2.b.class).xd(r10);
        if (vh6.c.b(vr2.b.class).N7(r10) == true) goto L13;
        d51.c r1 = d51.c.A0;
        r1.getClass();
        if (((List) d51.c.G.getValue(r1, d51.c.a[31])).contains(Integer.valueOf(r10)) == true) goto L13;
    L17:
        b41.d r4 = new b41.d(r2, vh6.c.b(vr2.b.class).N7(r10));
        this.g = r4;
        b41.f r6 = null;
        if (getInnerMovePlayer() == false) goto L40;
        b41.e r14 = new b41.e(r2, r4, this.i);
        this.h = r14;
        r14.d = true;
        IRenderView r15 = r14.b;
        if (r15 == null) goto L24;
        ViewParent r16 = r15.getParent();
        if (r16 == null) goto L24;
        ViewParent r17 = r16.getParent();
    L26:
        if ((r17 instanceof ViewGroup) == true) goto L28;
        r17 = null;
    L28:
        ViewGroup r18 = (ViewGroup) r17;
        if (r18 == null) goto L32;
        r18.setBackgroundColor(ColorProtector.parseColor("#1F212C"));
    L32:
        if ((!r4.m) == false) goto L34;
        r6 = new b41.f(r2, this, new AnonymousClass1(this), new AnonymousClass2(this));
    L34:
        this.f = r6;
        if (r6 == null) goto L46;
        b41.a r19 = r6.a;
        r19.a = true;
        ViewTreeObserver r3 = r19.e.getViewTreeObserver();
        if (r3 == null) goto L39;
        r3.addOnGlobalLayoutListener(r19.d);
    L39:
        r6.e.c.observeForever(r6.b);
    L46:
        if (vh6.c.b(vr2.b.class).N7(r10) == true) goto L61;
        d51.c r110 = d51.c.A0;
        r110.getClass();
        if (((List) d51.c.G.getValue(r110, d51.c.a[31])).contains(Integer.valueOf(r10)) == true) goto L61;
        if (this.i == true) goto L53;
    L57:
        if (r10 == 1) goto L59;
    L62:
        FeedPkWidget r111 = this.b;
        if (r111 == null) goto L65;
        Intrinsics.checkNotNullParameter(r13, "initHandler");
        FeedPkLynxWidget r112 = r111.j;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r13, "initHandler");
        r112.h = r13;
    L65:
        FeedPkWidget r113 = this.b;
        if (r113 == null) goto L92;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r114 = r113.b;
        FeedPkWindowManager r7 = r113.d;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r7, "wm");
        r114.a = r7;
        if (r113.m == true) goto L70;
        r113.b.b = r113.f;
    L70:
        FeedPkWindowManager r115 = r113.d;
        a41.d r8 = r115.b().f;
        if (r8 == null) goto L75;
        IMProgressBarLayout r20 = r8.a;
        if (r20 == null) goto L75;
        r20.a(false, 0, 0);
    L75:
        r115.i.getClass();
        com.bytedance.android.live.revlink.impl.pk.feedview.sei.c r22 = r115.i;
        if (r115.j == false) goto L79;
        PkFeedEntrance r116 = PkFeedEntrance.ImCardLive;
    L82:
        r22.getClass();
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r22.g = r116;
        com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r117 = r113.c;
        FeedPkStateMachine r23 = r117.s;
        r23.a = r117;
        r23.b = r117;
        r23.c = r117;
        FeedPkBridgePresenter r24 = r117.a;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r117, "host");
        r24.b = r117;
        r24.a = true;
        mx0.a r118 = r24.c;
        if (r118 == null) goto L85;
        r24.b(r118);
    L85:
        Pair r119 = com.bytedance.live.datacontext.d.a(FeedPkWidget$onCreate$1.INSTANCE);
        FeedPkService r25 = (FeedPkService) r119.getFirst();
        if (r25 == null) goto L88;
        com.bytedance.live.datacontext.b.a(r25, "IFeedPkService");
    L88:
        ((FeedPkService) r119.getFirst()).setService(r113);
        r113.i.add((Disposable) r119.getSecond());
        if (z41.g.o.a() == false) goto L91;
        r113.c.e.observeForever(r113.k);
    L91:
        x.e(r113.l.b, r113.e);
        goto L92
    L79:
        if (r115.k == false) goto L81;
        r116 = PkFeedEntrance.SearchCard;
        goto L82
    L81:
        r116 = PkFeedEntrance.FullCard;
    L92:
        r13.c(new a(this));
        setFocusable(true);
        setContentDescription("点击进入直播间，按钮");
        return;
    L59:
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L62;
        this.b = new FeedPkWidget(r2, this, this.i, r5, !getInnerMovePlayer());
        goto L62
    L53:
        if (PadConfigUtils.a() == true) goto L57;
        if (FoldScreenUtils.f() == true) goto L57;
        this.b = new FeedPkWidget(r2, this, this.i, r5, !getInnerMovePlayer());
    L61:
        this.b = new FeedPkWidget(r2, this, this.i, r5, !getInnerMovePlayer());
    L24:
        r17 = null;
        goto L26
    L40:
        this.h = null;
        this.f = null;
        b41.c r26 = new b41.c(r2, r12);
        this.k = r26;
        kc0.d r120 = r26.c;
        if (r120 == null) goto L46;
        MediatorLiveData r121 = r120.getPlayerEvent();
        if (r121 == null) goto L46;
        x.e(r121, r26.a);
    L13:
        if (r10 != 7) goto L15;
    L16:
        this.i = true;
        goto L17
    L15:
        if (r10 != 8) goto L17;
    L7:
        r5 = true;
        goto L8
    }
}
