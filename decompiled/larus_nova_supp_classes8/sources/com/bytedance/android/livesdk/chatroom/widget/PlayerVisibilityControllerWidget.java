package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.business.VSInjectWidgetType;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/PlayerVisibilityControllerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerVisibilityControllerWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int A = 0;
    public final String a;
    public WidgetManager b;
    public boolean c;
    public boolean d;
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> e;
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> f;
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> g;
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> h;
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> i;
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> j;
    public final Map<PlayerViewControl.KEY, com.bytedance.android.livesdk.chatroom.vsplayer.model.c> k;
    public Observable<Long> l;
    public Disposable m;
    public IVSPlayerService n;
    public VSPlayerViewControlContext o;
    public CompositeDisposable p;
    public int q;
    public int r;
    public int s;
    public int t;
    public final List<Animator> u;
    public boolean v;
    public int w;
    public long x;
    public long y;
    public final e z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ VSPlayerViewControlContext a;
        public final /* synthetic */ PlayerVisibilityControllerWidget b;

        public b(VSPlayerViewControlContext r1, PlayerVisibilityControllerWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r18) {
            Boolean r1 = (Boolean) r18;
            PlayerVisibilityControllerWidget r2 = this.b;
            if (r2.c == true) goto L5;
            r2.d = true;
            return;
        L5:
            Boolean r3 = Boolean.FALSE;
            if (Intrinsics.areEqual(r1, r3) == false) goto L11;
            if (((Boolean) this.a.isLocked().getValue()).booleanValue() == true) goto L11;
            w1.a(this.b.g);
            w1.a(this.b.h);
            w1.a(this.b.i);
            w1.a(this.b.j);
            this.b.Lq();
        L11:
            if (((Number) this.a.getCustomAnimDuration().getValue()).longValue() == (-1)) goto L13;
            long r5 = ((Number) this.a.getCustomAnimDuration().getValue()).longValue();
            this.a.getCustomAnimDuration().setValue(-1L);
        L14:
            PlayerVisibilityControllerWidget r4 = this.b;
            boolean r13 = r1.booleanValue();
            if (r4.isViewValid() == false) goto L39;
            if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(((Widget) r4).dataCenter, true) == true) goto L25;
            if (r13 == false) goto L21;
            r4.x = System.currentTimeMillis();
            r4.w++;
        L21:
            if (r13 == true) goto L25;
            if (r4.x == 0) goto L25;
            r4.y += System.currentTimeMillis() - r4.x;
            r4.x = 0;
        L25:
            String r6 = r4.a;
            StringBuilder r7 = new StringBuilder(" start changeInteractionVisibility to ");
            r7.append(r13);
            r7.append(",lock state=");
            VSPlayerViewControlContext r8 = r4.o;
            if (r8 == null) goto L30;
            com.bytedance.live.datacontext.m<Boolean> r9 = r8.isLocked();
            if (r9 == null) goto L30;
            Boolean r10 = (Boolean) r9.getValue();
        L31:
            r7.append(r10);
            ALogger.d(r6, r7.toString());
            ((ArrayList) r4.u).clear();
            long r11 = r5;
            r4.Gq(r4.e, r13, false, r11);
            r4.Eq(r4.f, r13, false, r11);
            r4.Kq(r4.g, r13, false, r11);
            r4.Fq(r4.h, r13, false, r11);
            r4.Iq(r4.i, r13, false, r11);
            r4.Jq(r4.j, r13, false, r11);
            AnimatorSet r12 = new AnimatorSet();
            r12.playTogether(r4.u);
            r12.addListener(new t1(r4, r13, r12));
            r12.start();
            if (r3.l(((Widget) r4).context) == false) goto L39;
            Context r14 = ((Widget) r4).context;
            if (r13 == false) goto L36;
            String r15 = "已显示播放控制栏";
        L37:
            r3.q(r14, r15);
            goto L39
        L36:
            r15 = "已隐藏播放控制栏";
        L30:
            r10 = null;
        L39:
            if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L42;
            this.b.Nq();
        L42:
            if (Intrinsics.areEqual(r1, r3) == false) goto L46;
            this.a.getPlayerViewVisibleTriggeredByUser().setValue(r3);
            return;
        L46:
            return;
        L13:
            r5 = 300;
            goto L14
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PlayerVisibilityControllerWidget a;

        public c(PlayerVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            ALogger.d(this.a.a, "receive resetHideTaskEvent");
            this.a.Nq();
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ PlayerVisibilityControllerWidget a;

        public d(PlayerVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L19;
            PlayerVisibilityControllerWidget r3 = this.a;
            if (r3.v == true) goto L8;
            return;
        L8:
            if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(((Widget) r3).dataCenter, true) == true) goto L16;
            PlayerVisibilityControllerWidget r4 = this.a;
            IVSPlayerService r0 = r4.n;
            if (r0 == null) goto L17;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r5 = r0.provideVSPlayerViewControlService(((Widget) r4).dataCenter);
            if (r5 == null) goto L18;
            r5.setVisibilityStatus(false);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public static final class e implements com.bytedance.android.livesdk.chatroom.vsplayer.api.d {
        public final /* synthetic */ PlayerVisibilityControllerWidget a;

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void C5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void D5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void H5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void P1() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void g5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void k2() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void l3() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void onRenderStart() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void z() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void E5() {
            PlayerVisibilityControllerWidget r0 = this.a;
            int r1 = PlayerVisibilityControllerWidget.A;
            r0.Nq();
        }

        public e(PlayerVisibilityControllerWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void G5(boolean r2) {
            if (r2 == false) goto L5;
            PlayerVisibilityControllerWidget r3 = this.a;
            int r0 = PlayerVisibilityControllerWidget.A;
            r3.Nq();
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void v2(EpisodeHighLight r2) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void F5(EpisodeHighLight r2, Pair<Integer, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r3, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.a(r2, r3);
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void I5(EpisodeHighLight r2, Pair<Integer, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r3, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.b(r2, r3);
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void Nq() {
        ALogger.d(this.a, "--resetHideViewTask");
        Disposable r0 = null;
        this.l = null;
        this.l = Observable.timer(5000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper());
        Disposable r1 = this.m;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        Observable<Long> r2 = this.l;
        if (r2 == null) goto L8;
        r0 = RxUtilKt.n(r2, new PlayerVisibilityControllerWidget$resetHideViewTask$1(this));
    L8:
        this.m = r0;
    }

    public final void onUnload() {
        String r0 = this.a;
        StringBuilder r1 = new StringBuilder("start onUnload: dataCenter:");
        r1.append(((Widget) this).dataCenter.hashCode());
        r1.append(", viewControlService:");
        IVSPlayerService r2 = this.n;
        if (r2 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r3 = r2.provideVSPlayerViewControlService(((Widget) this).dataCenter);
    L7:
        if (r3 == null) goto L9;
        int r4 = r3.hashCode();
    L10:
        r1.append(r4);
        ALogger.d(r0, r1.toString());
        VSPlayerViewControlContext r5 = this.o;
        if (r5 == null) goto L20;
        com.bytedance.live.datacontext.m<Boolean> r6 = r5.getPlayerViewVisible();
        if (r6 != null) goto L15;
    L17:
        boolean r7 = false;
    L18:
        r5.setInitVisible(r7);
        goto L20
    L15:
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L17;
        r7 = true;
    L20:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(((Widget) this).dataCenter, true) == false) goto L23;
    L26:
        ((Widget) this).dataCenter.removeObserver(this);
        this.v = false;
        this.b = null;
        ((LinkedHashMap) this.k).clear();
        ((ArrayList) this.e).clear();
        ((ArrayList) this.f).clear();
        ((ArrayList) this.g).clear();
        ((ArrayList) this.h).clear();
        ((ArrayList) this.i).clear();
        ((ArrayList) this.j).clear();
        this.o = null;
        IVSPlayerService r8 = this.n;
        if (r8 == null) goto L31;
        IPlayerProgressService r9 = r8.provideVSProgressService(((Widget) this).dataCenter);
        if (r9 == null) goto L31;
        r9.removeProgressChangeListener(this.z);
    L31:
        IVSPlayerService r10 = this.n;
        if (r10 == null) goto L36;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r11 = r10.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r11 == null) goto L36;
        r11.clearControlWidget();
    L36:
        this.n = null;
        ((ArrayList) this.u).clear();
        Disposable r12 = this.m;
        if (r12 != null) goto L39;
    L44:
        this.m = null;
        this.p.dispose();
        return;
    L39:
        if (r12.isDisposed() == false) goto L42;
        r12 = null;
    L42:
        if (r12 == null) goto L44;
        r12.dispose();
        goto L44
    L23:
        if (this.x == 0) goto L25;
        this.y += System.currentTimeMillis() - this.x;
        this.x = 0;
    L25:
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().w(((Widget) this).dataCenter, this.w, this.y);
        this.y = 0;
        goto L26
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public PlayerVisibilityControllerWidget() {
        this.a = "PlayerVisibilityControllerWidget[" + hashCode() + ']';
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new LinkedHashMap();
        this.p = new CompositeDisposable();
        this.u = new ArrayList();
        this.z = new e(this);
    }

    public final void Lq() {
        Class<? extends Widget> r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.B().getWidgetClass(VSInjectWidgetType.LIVE_SHADOW_PLAYER);
        if (r0 == null) goto L8;
        WidgetInfo r1 = getWidgetInfo(r0);
        if (r1 == null) goto L9;
        int[] r2 = r1.getLocationOnScreen();
        int r3 = r2[0];
        this.s = r3;
        this.q = r2[1];
        this.t = r3 + r1.getContentViewWidth();
        this.r = this.q + r1.getContentViewHeight();
        return;
    L9:
        return;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        this.v = false;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        Nq();
        VSPlayerViewControlContext r0 = this.o;
        if (r0 == null) goto L5;
        r0.getPlayerViewVisibleTriggeredByUser().setValue(Boolean.FALSE);
    L5:
        this.v = true;
    }

    public final void Bq(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        ALogger.d(this.a, "start addControl Item for " + r10.g.getDescribe());
        Mq(r10.g);
        switch(s1.b[r10.getType().ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L11;
        };
    L5:
        ((ArrayList) this.f).add(r10);
        goto L11
    L6:
        ((ArrayList) this.e).add(r10);
        goto L11
    L7:
        ((ArrayList) this.j).add(r10);
        goto L11
    L8:
        ((ArrayList) this.i).add(r10);
        goto L11
    L9:
        ((ArrayList) this.h).add(r10);
        goto L11
    L10:
        ((ArrayList) this.g).add(r10);
    L11:
        View r0 = r10.i;
        r0.setTag(r10.g.getDescribe());
        r0.setAlpha(1.0f);
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        this.k.put(r10.g, r10);
        VSPlayerViewControlContext r1 = this.o;
        int r2 = 0;
        if (r1 == null) goto L18;
        com.bytedance.live.datacontext.m<Boolean> r3 = r1.getPlayerViewVisible();
        if (r3 == null) goto L18;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == true) goto L21;
    L23:
        int r5 = r2 ^ 1;
        Integer r6 = (Integer) r10.f.getValue();
        if (r6 != null) goto L27;
    L29:
        ((ArrayList) this.u).clear();
        switch(s1.a[r10.getType().ordinal()]) {
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            default: goto L38;
        };
    L32:
        Eq(CollectionsKt.listOf(r10), r4, false, 0);
        goto L38
    L33:
        Gq(CollectionsKt.listOf(r10), r4, false, 0);
        goto L38
    L34:
        Jq(CollectionsKt.listOf(r10), r4, false, 0);
        goto L38
    L35:
        Iq(CollectionsKt.listOf(r10), r4, false, 0);
        goto L38
    L36:
        Fq(CollectionsKt.listOf(r10), r4, false, 0);
        goto L38
    L37:
        Kq(CollectionsKt.listOf(r10), r4, false, 0);
    L38:
        AnimatorSet r7 = new AnimatorSet();
        r7.playTogether(this.u);
        r7.start();
        ALogger.d(this.a, "add control item and init it's status Item:[" + r10.g.getDescribe() + "] Visibility to [" + r4 + ']');
        return;
    L27:
        if (r6.intValue() != r5) goto L29;
        return;
    L21:
        if (r10.o == true) goto L23;
        r2 = 1;
    L18:
        r4 = false;
        goto L19
    }

    public final void Mq(PlayerViewControl.KEY r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r4 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.c) ((LinkedHashMap) this.k).get(r3);
        if (r4 == null) goto L15;
        PlayerViewControl.Type r0 = r4.getType();
        switch(s1.c[r0.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        ((ArrayList) this.f).remove(r4);
        return;
    L9:
        ((ArrayList) this.e).remove(r4);
        return;
    L10:
        ((ArrayList) this.j).remove(r4);
        return;
    L11:
        ((ArrayList) this.i).remove(r4);
        return;
    L12:
        ((ArrayList) this.h).remove(r4);
        return;
    L13:
        ((ArrayList) this.g).remove(r4);
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public final void onChanged(Object r18) {
        KVData r1 = (KVData) r18;
        if (r1 == null) goto L72;
        String r2 = r1.getKey();
        switch(r2.hashCode()) {
            case -1836833765: goto L17;
            case -1575056762: goto L14;
            case -67504953: goto L11;
            case 1440046856: goto L8;
            default: goto L79;
        };
    L79:
        return;
    L8:
        if (r2.equals("cmd_p2_widget_loaded") == false) goto L73;
    L18:
        Lq();
        WidgetManager r3 = this.b;
        if (r3 == null) goto L77;
        Iterator r4 = r3.widgetViewGroupHashMap.entrySet().iterator();
    L21:
        com.bytedance.android.livesdk.chatroom.vsplayer.model.a r5 = null;
        if (r4.hasNext() == false) goto L37;
        Map.Entry r6 = (Map.Entry) r4.next();
        com.bytedance.android.livesdk.chatroom.vsplayer.model.a r7 = (Widget) r6.getKey();
        PlayerViewControl r8 = (PlayerViewControl) r7.getClass().getAnnotation(PlayerViewControl.class);
        if (r8 == null) goto L21;
        if ((true ^ this.k.containsKey(r8.key())) == true) goto L29;
        r8 = null;
    L29:
        if (r8 == null) goto L21;
        ViewGroup r10 = (ViewGroup) r6.getValue();
        if (r10 == null) goto L21;
        PlayerViewControl.KEY r9 = r8.key();
        if ((r7 instanceof com.bytedance.android.livesdk.chatroom.vsplayer.model.a) == false) goto L36;
        r5 = r7;
    L36:
        Bq(new com.bytedance.android.livesdk.chatroom.vsplayer.model.c(r9, r5, r10, r8.type(), r8.style(), r8.attachMarginDp(), r8.needDynamicControl(), r8.ignoreLock(), r8.reverse()));
        goto L21
    L37:
        VSPlayerViewControlContext r11 = this.o;
        if (r11 == null) goto L44;
        ALogger.d(this.a, "initViewList: tmp list size:" + r11.getTmpControlItemList().size());
        Iterator<T> r12 = r11.getTmpControlItemList().iterator();
    L41:
        if (r12.hasNext() == false) goto L43;
        Bq((com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r12.next());
        goto L41
    L43:
        r11.getTmpControlItemList().clear();
    L44:
        this.c = true;
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L55;
        IRoom r14 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r13);
        if (r14 == null) goto L55;
        if (r14.isMergeVSRoom() != true) goto L55;
        vr1.u r15 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(((Widget) this).dataCenter, null, 2);
        if (r15 == null) goto L55;
        com.bytedance.live.datacontext.k<Boolean> r16 = r15.Y0();
        if (r16 == null) goto L55;
        r16.post(Boolean.TRUE);
    L55:
        ALogger.d(this.a, "init complete. size: \ndirect[" + ((ArrayList) this.e).size() + "]\nalpha[" + ((ArrayList) this.f).size() + "]\ntop[" + ((ArrayList) this.g).size() + "]\nbottom[" + ((ArrayList) this.h).size() + "]\nleft[" + ((ArrayList) this.i).size() + "]\nright[" + ((ArrayList) this.j).size() + "]\n");
        if (this.d == false) goto L78;
        VSPlayerViewControlContext r17 = this.o;
        if (r17 == null) goto L60;
        r17.getPlayerViewVisible().setValue(r17.getPlayerViewVisible().getValue());
        ALogger.w(this.a, "beforeInitStatusChangeFlag == true, refresh status");
    L60:
        this.d = false;
        return;
    L78:
        return;
    L77:
        return;
    L73:
        return;
    L11:
        if (r2.equals("cmd_p1_widget_loaded") == true) goto L18;
        return;
    L14:
        if (r2.equals("cmd_p0_widget_loaded") == true) goto L18;
        return;
    L17:
        if (r2.equals("cmd_widget_loaded") == true) goto L18;
        return;
    }

    public final void onLoad(Object[] r5) {
        IVSPlayerService r6 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        this.n = r6;
        if (r6 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r7 = r6.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r7 == null) goto L7;
        r7.f(this);
    L7:
        String r8 = this.a;
        StringBuilder r0 = new StringBuilder("start onLoad: dataCenter:");
        r0.append(((Widget) this).dataCenter.hashCode());
        r0.append(", viewControlService:");
        IVSPlayerService r1 = this.n;
        VSPlayerViewControlContext r2 = null;
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r3 = r1.provideVSPlayerViewControlService(((Widget) this).dataCenter);
    L12:
        if (r3 == null) goto L14;
        int r4 = r3.hashCode();
    L15:
        r0.append(r4);
        ALogger.d(r8, r0.toString());
        this.c = false;
        this.d = false;
        IVSPlayerService r9 = this.n;
        if (r9 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r10 = r9.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r10 == null) goto L20;
        WidgetManager r11 = r10.getWidgetManager();
    L21:
        this.b = r11;
        this.v = false;
        this.p = new CompositeDisposable();
        ((ArrayList) this.u).clear();
        IVSPlayerService r12 = this.n;
        if (r12 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r13 = r12.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r13 == null) goto L26;
        r2 = r13.provideContext();
    L26:
        this.o = r2;
        this.x = System.currentTimeMillis();
        this.w++;
        VSPlayerViewControlContext r14 = this.o;
        if (r14 == null) goto L34;
        r14.isLocked().setValue(Boolean.FALSE);
        r14.getPlayerViewVisible().setValue(Boolean.valueOf(r14.getInitVisible()));
        Disposable r15 = r14.getPlayerViewVisible().a().subscribe(new b(r14, this));
        if (r15 == null) goto L31;
        RxUtilKt.c(r15, this.p);
    L31:
        Disposable r16 = r14.getResetHideTaskEvent().onEvent().subscribe(new c(this));
        if (r16 == null) goto L34;
        RxUtilKt.c(r16, this.p);
    L34:
        ((Widget) this).dataCenter.observe("cmd_widget_loaded", this).observe("cmd_p0_widget_loaded", this).observe("cmd_p1_widget_loaded", this).observe("cmd_p2_widget_loaded", this);
        IVSPlayerService r17 = this.n;
        if (r17 == null) goto L39;
        IPlayerProgressService r18 = r17.provideVSProgressService(((Widget) this).dataCenter);
        if (r18 == null) goto L39;
        r18.addProgressChangeListener(this.z);
    L39:
        com.bytedance.android.livesdk.f.d().a.observe(this, new d(this));
        return;
    L20:
        r11 = null;
        goto L21
    L14:
        r4 = 0;
        goto L15
    L10:
        r3 = null;
        goto L12
    }

    public static final Animator wq(PlayerVisibilityControllerWidget r2, View r3, float r4, long r5) {
        r2.getClass();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{r3.getAlpha(), r4});
        r6.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r6.setDuration(r5);
        return r6;
    }

    public final void Cq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r8, Function1<? super com.bytedance.android.livesdk.chatroom.vsplayer.model.c, Unit> r9, boolean r10, boolean r11) {
        ArrayList r0 = new ArrayList();
        r0.addAll(r8);
        VSPlayerViewControlContext r12 = this.o;
        List r1 = r0;
        if (r12 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r13 = r12.isLocked();
        r1 = r0;
        if (r13 == null) goto L16;
        r1 = r0;
        r1 = r0;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L16;
        if (r10 == false) goto L16;
        ArrayList r14 = new ArrayList();
        Iterator r2 = r0.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        if (((com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r3).n == false) goto L11;
        r14.add(r3);
        goto L11
    L15:
        r1 = CollectionsKt.toMutableList(r14);
    L16:
        Iterator r15 = r1.iterator();
    L18:
        if (r15.hasNext() == false) goto L36;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r4 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r15.next();
        if (r4.m == false) goto L21;
        if (r11 == true) goto L23;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.a r5 = r4.h;     // Catch: Exception -> L30
        if ((r5 instanceof com.bytedance.android.livesdk.chatroom.vsplayer.model.a) == false) goto L32;
        if (r5 == null) goto L29;
        boolean r6 = r5.canControlByPlayer(r4.g);     // Catch: Exception -> L30
    L33:
        if (r6 == true) goto L34;
        ALogger.i(this.a, "dynamic check failed, skip action [" + r10 + "] for " + r4.g.getDescribe());
        goto L18
    L34:
        ALogger.i(this.a, "dynamic check success, start do action [" + r10 + "] for " + r4.g.getDescribe());
        r9.invoke(r4);
        goto L18
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.vsplayer.model.IPlayerViewControlFlag");     // Catch: Exception -> L30
    L32:
        r6 = true;
    L30:
        e = move-exception;
        ALogger.e(this.a, "canHandleByAnnotation: " + e);
        goto L32
    L23:
        r9.invoke(r4);
        ALogger.w(this.a, "skip dynamic check for " + r4.g.getDescribe() + " when visible [" + r10 + ']');
        goto L18
    L21:
        ALogger.i(this.a, "start do action [" + r10 + "] for " + r4.g.getDescribe());
        r9.invoke(r4);
        goto L18
    }

    public final void Eq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.f).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r2, new PlayerVisibilityControllerWidget$handleAlphaViews$2(new PlayerVisibilityControllerWidget$handleAlphaViews$1(this, r3, r5)), r3, r4);
    }

    public final void Fq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.h).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r2, new PlayerVisibilityControllerWidget$handleBottomViews$2(new PlayerVisibilityControllerWidget$handleBottomViews$1(this, r3, r5)), r3, r4);
    }

    public final void Gq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.e).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r2, new PlayerVisibilityControllerWidget$handleDirectHideViews$2(new PlayerVisibilityControllerWidget$handleDirectHideViews$1(this, r3, r5)), r3, r4);
    }

    public final void Iq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.i).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r2, new PlayerVisibilityControllerWidget$handleLeftViews$2(new PlayerVisibilityControllerWidget$handleLeftViews$1(this, r3, r5)), r3, r4);
    }

    public final void Jq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.j).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r2, new PlayerVisibilityControllerWidget$handleRightViews$2(new PlayerVisibilityControllerWidget$handleRightViews$1(this, r3, r5)), r3, r4);
    }

    public final void Kq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.g).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r2, new PlayerVisibilityControllerWidget$handleTopViews$2(new PlayerVisibilityControllerWidget$handleTopViews$1(this, r3, r5)), r3, r4);
    }

    public final void Pq(PlayerViewControl.KEY r14, boolean r15, long r16, boolean r18) {
        Intrinsics.checkNotNullParameter(r14, "key");
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r0 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.c) ((LinkedHashMap) this.k).get(r14);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r18 == false) goto L52;
        Iterator r1 = ((ArrayList) this.u).iterator();
    L9:
        if (r1.hasNext() == false) goto L42;
        Animator r2 = (Animator) r1.next();
        String r3 = this.a;
        StringBuilder r4 = new StringBuilder("cancelObjectAnimator item[");
        r4.append(r0.g.getDescribe());
        r4.append("] view tag[");
        boolean r5 = r2 instanceof ObjectAnimator;
        Object r10 = null;
        if (r5 == true) goto L13;
        Animator r11 = null;
    L14:
        ObjectAnimator r12 = (ObjectAnimator) r11;
        if (r12 == null) goto L17;
        Object r13 = r12.getTarget();
    L19:
        if ((r13 instanceof View) == true) goto L21;
        r13 = null;
    L21:
        View r17 = (View) r13;
        if (r17 == null) goto L24;
        Object r19 = r17.getTag();
    L25:
        r4.append(r19);
        r4.append(']');
        ALogger.w(r3, r4.toString());
        if (r5 == true) goto L28;
        Animator r6 = null;
    L29:
        ObjectAnimator r7 = (ObjectAnimator) r6;
        if (r7 == null) goto L32;
        Object r8 = r7.getTarget();
    L34:
        if ((r8 instanceof View) == true) goto L36;
        r8 = null;
    L36:
        View r9 = (View) r8;
        if (r9 == null) goto L40;
        r10 = r9.getTag();
    L40:
        if (Intrinsics.areEqual(r10, r0.g.getDescribe()) == false) goto L9;
        r2.cancel();
        ((ArrayList) this.u).remove(r2);
        goto L42
    L32:
        r8 = null;
        goto L34
    L28:
        r6 = r2;
        goto L29
    L24:
        r19 = null;
        goto L25
    L17:
        r13 = null;
        goto L19
    L13:
        r11 = r2;
    L42:
        NextLiveData<Integer> r20 = r0.f;
        if (r0.o == false) goto L47;
        if (r15 == true) goto L46;
        boolean r21 = true;
    L48:
        if (r21 == false) goto L50;
        int r22 = 1;
    L51:
        r20.setValue(r22);
        goto L52
    L50:
        r22 = 0;
        goto L51
    L46:
        r21 = false;
        goto L48
    L47:
        r21 = r15;
    L52:
        ((ArrayList) this.u).clear();
        switch(s1.d[r0.getType().ordinal()]) {
            case 1: goto L60;
            case 2: goto L59;
            case 3: goto L58;
            case 4: goto L57;
            case 5: goto L56;
            case 6: goto L55;
            default: goto L61;
        };
    L55:
        Eq(CollectionsKt.listOf(r0), r15, true, r16);
        goto L61
    L56:
        Gq(CollectionsKt.listOf(r0), r15, true, r16);
        goto L61
    L57:
        Jq(CollectionsKt.listOf(r0), r15, true, r16);
        goto L61
    L58:
        Iq(CollectionsKt.listOf(r0), r15, true, r16);
        goto L61
    L59:
        Fq(CollectionsKt.listOf(r0), r15, true, r16);
        goto L61
    L60:
        Kq(CollectionsKt.listOf(r0), r15, true, r16);
    L61:
        AnimatorSet r23 = new AnimatorSet();
        r23.playTogether(this.u);
        r23.start();
        ALogger.d(this.a, "start change Item:[" + r14.getDescribe() + "] Visibility to [" + r15 + ']');
    }

    public static final Animator Aq(PlayerVisibilityControllerWidget r1, View r2, float r3, float r4, long r5) {
        r1.getClass();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r2, "translationY", new float[]{r3, r4});
        r6.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r6.setDuration(r5);
        return r6;
    }

    public static final Animator zq(PlayerVisibilityControllerWidget r1, View r2, float r3, float r4, long r5) {
        r1.getClass();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r2, "translationX", new float[]{r3, r4});
        r6.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r6.setDuration(r5);
        return r6;
    }

    public static final Animator xq(PlayerVisibilityControllerWidget r1, View r2, float r3, float r4, float r5, long r6) {
        r1.getClass();
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{r3, r4});
        r7.addUpdateListener(new u1(r5, r2));
        r7.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r7.setDuration(r6);
        return r7;
    }

    public static final Animator yq(PlayerVisibilityControllerWidget r1, View r2, float r3, float r4, float r5, long r6) {
        r1.getClass();
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{r3, r4});
        r7.addUpdateListener(new v1(r5, r2));
        r7.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r7.setDuration(r6);
        return r7;
    }
}
