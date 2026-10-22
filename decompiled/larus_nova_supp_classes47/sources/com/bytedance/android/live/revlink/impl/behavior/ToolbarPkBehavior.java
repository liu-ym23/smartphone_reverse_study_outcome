package com.bytedance.android.live.revlink.impl.behavior;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.service.RingDrawable;
import com.bytedance.android.live.revlink.impl.pk.service.ToolBarPic;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.livesdk.link.model.IPKIconBubble;
import com.bytedance.android.livesdk.link.model.a6;
import com.bytedance.android.livesdk.link.model.bridge.a1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.d2;
import com.bytedance.android.livesdk.link.model.d5;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.l5;
import com.bytedance.android.livesdk.link.model.t4;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.toolbar.BubbleOpenLocalPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ToolbarPkBehavior extends zr2.k implements com.bytedance.android.live.revlink.impl.pk.service.i, com.bytedance.android.live.revlink.impl.behavior.d {
    public final int b;
    public int c;
    public Context d;
    public boolean e;
    public IRoom f;
    public final yz0.l g;
    public final CompositeDisposable h;
    public yo2.e i;
    public View j;
    public LottieAnimationView k;
    public LottieAnimationView l;
    public LottieAnimationView m;
    public HSImageView n;
    public HSImageView o;
    public TextView p;
    public View q;
    public Disposable r;
    public Disposable s;
    public ObjectAnimator t;
    public boolean u;
    public int v;
    public boolean w;
    public final ToolbarPkIdleHolder x;
    public final b y;
    public final LifecycleOwner z;

    public static final class a {
    }

    public interface b {
        void Ne(int r1, u r2, boolean r3);
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ToolbarPkBehavior a;

        public c(ToolbarPkBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.f3();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ToolbarPkBehavior a;

        public d(ToolbarPkBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r24) {
            a1 r0 = (yh6.c) r24;
            ToolbarPkBehavior r2 = this.a;
            r2.getClass();
            if (r0 == null) goto L82;
            t4 r4 = null;
            if ((r0 instanceof a1) == false) goto L69;
            l5 r1 = r0.castTo(l5.class);
            if (r1 == null) goto L9;
            IPKIconBubble r3 = r1.getBubbleInfo();
        L11:
            if (r3 == null) goto L35;
            IPKIconBubble r5 = r1.getBubbleInfo();
            Intrinsics.checkNotNull(r5);
            if (r5.getBubbleType() != IPKIconBubble.PKIconBubbleType.PKIconBubbleTypeStarActivity.ordinal()) goto L35;
            IPKIconBubble r6 = r1.getBubbleInfo();
            if (r6 == null) goto L90;
            r2.f3();
            View r7 = LayoutInflater.from(r2.d).inflate(2131567816, null);
            TextView r8 = (TextView) r7.findViewById(2131390805);
            View r9 = r7.findViewById(2131376322);
            View r13 = r7.findViewById(2131374666);
            ImageView r12 = (ImageView) r7.findViewById(2131382782);
            if (r6.getDisplayTest() == null) goto L21;
            r8.setText(com.bytedance.android.live.revenue.core.util.e.a(ur2.a.class).Q9(r6.getDisplayTest()));
        L21:
            if (r6.getDisplayIcon() == null) goto L23;
            ImageUtil.loadRoundImage(r12, r6.getDisplayIcon());
            r12.setVisibility(0);
        L24:
            yo2.e r14 = new yo2.e(r2.d);
            ((yo2.d) r14).d = r7;
            ((yo2.d) r14).e = 0;
            ((yo2.d) r14).m = 3;
            ((yo2.d) r14).g = false;
            ((yo2.d) r14).f = false;
            r14.a();
            r2.i = r14;
            if (r6.getSchema() == null) goto L31;
            r13.setVisibility(0);
            yo2.e r10 = r2.i;
            if (r10 == null) goto L31;
            View r15 = r10.e();
            if (r15 == null) goto L31;
            r15.setOnClickListener(new r(r2, r6));
        L31:
            yo2.e r16 = r2.i;
            if (r16 == null) goto L34;
            View r17 = r2.j;
            Intrinsics.checkNotNull(r17);
            r16.i(r17, 1, 3, 0, s1.f(-4));
        L34:
            UIUtils.updateLayoutMargin(r9, s1.f(12.0f), -3, -3, -3);
            return;
        L23:
            r12.setVisibility(8);
            goto L24
        L90:
            return;
        L35:
            if (r1 == null) goto L37;
            IPKIconBubble r18 = r1.getBubbleInfo();
        L38:
            if (r18 == null) goto L91;
            String r19 = r18.getActivityType();
            int r20 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.toolbar.a.class).j3(r19);
            if (TextUtils.equals(r18.getActivityType(), "pk_season") == false) goto L43;
            r20 = 0;
        L43:
            int r22 = (int) r18.getShowCount();
            if (r22 <= 0) goto L84;
            if (r22 <= 0) goto L49;
            if (r20 < r22) goto L49;
            return;
        L49:
            if (TextUtils.equals(r18.getActivityType(), "pk_season") == true) goto L51;
            com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.toolbar.a.class).Wm(r19, r20 + 1);
        L51:
            r2.f3();
            View r23 = LayoutInflater.from(r2.d).inflate(2131567816, null);
            TextView r25 = (TextView) r23.findViewById(2131390805);
            View r26 = r23.findViewById(2131376322);
            ImageView r27 = (ImageView) r23.findViewById(2131382782);
            if (r18.getDisplayIcon() == null) goto L55;
            if (r27 == null) goto L55;
            ImageUtil.loadRoundImage(r27, r18.getDisplayIcon());
            r27.setVisibility(0);
        L57:
            if (r18.getDisplayTest() == null) goto L59;
            r25.setText(com.bytedance.android.live.revenue.core.util.e.a(ur2.a.class).Q9(r18.getDisplayTest()));
        L59:
            yo2.e r28 = new yo2.e(r2.d);
            ((yo2.d) r28).d = r23;
            ((yo2.d) r28).e = 0;
            ((yo2.d) r28).g = false;
            ((yo2.d) r28).f = false;
            if (r18.getShowTime() <= 0) goto L62;
            long r29 = r18.getShowTime();
        L63:
            ((yo2.d) r28).m = r29;
            r28.a();
            View r30 = r2.j;
            Intrinsics.checkNotNull(r30);
            r28.i(r30, 1, 0, s1.f(r2.b), s1.f(-4));
            r2.i = r28;
            r23.setOnClickListener(new q(r2, r28));
            View r32 = r2.j;
            Intrinsics.checkNotNull(r32);
            float r33 = r32.getX();
            View r34 = r2.j;
            Intrinsics.checkNotNull(r34);
            UIUtils.updateLayoutMargin(r26, (int) ((r33 + (r34.getWidth() / 2)) - s1.f(12.0f)), -3, -3, -3);
            HashMap r35 = new HashMap();
            r35.put("location_from", "pk_icon");
            r35.put("bubble_info", "activity");
            r35.put("activity_type", r19);
            if (r2.e == false) goto L66;
            String r36 = DataType.TRUE;
        L67:
            r35.put("is_anchor", r36);
            mz0.n r37 = new mz0.n();
            Map<String, String> r38 = r37.a;
            Intrinsics.checkNotNullParameter(r38, "map");
            Intrinsics.checkNotNullParameter(r35, "map");
            r38.putAll(r35);
            mz0.m r39 = new mz0.m();
            r39.b(LogCommon.ROOM);
            ((ArrayList) r37.b).addAll(r39.a);
            cy0.e.a.getClass();
            cy0.j r40 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r42 = com.bytedance.android.scope.m.b(r40).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r42);
            ((mz0.i) ((f80.a) r42)).w3("livesdk_room_bubble_show", r37.a, r37.b);
            return;
        L66:
            r36 = DataType.FALSE;
            goto L67
        L62:
            r29 = 3;
        L55:
            Intrinsics.checkNotNull(r27);
            r27.setVisibility(8);
            goto L57
        L84:
            return;
        L91:
            return;
        L37:
            r18 = null;
            goto L38
        L9:
            r3 = null;
            goto L11
        L69:
            if ((r0 instanceof r0) == false) goto L75;
            c5 r43 = ((r0) r0).castTo(c5.class);
            if (r43 == null) goto L73;
            r4 = r43.getLinkIconConfig();
        L73:
            r2.F(r4);
            return;
        L75:
            if ((r0 instanceof h1) == false) goto L87;
            i6 r44 = ((h1) r0).castTo(i6.class);
            if (((int) r44.getType2()) != 6) goto L88;
            a6 r45 = j6.b(r44);
            if (r45 == null) goto L89;
            r2.F(r45.getLinkIconConfig());
            return;
        L89:
            return;
        L88:
            return;
        L87:
            return;
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ ToolbarPkBehavior a;

        public e(ToolbarPkBehavior r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Context r0 = this.a.d;
            Intrinsics.checkNotNull(r0);
            AssetManager r1 = r0.getAssets();
            return Typeface.createFromAsset(r1, (String) r2);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ToolbarPkBehavior a;

        public f(ToolbarPkBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Typeface r3 = (Typeface) r2;
            if (r3 == null) goto L8;
            TextView r0 = this.a.p;
            if (r0 == null) goto L9;
            Intrinsics.checkNotNull(r0);
            r0.setTypeface(r3);
            return;
        L9:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ToolbarPkBehavior a;
        public final /* synthetic */ d5 b;

        public g(ToolbarPkBehavior r1, d5 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            this.a.c++;
            d2 r8 = this.b.getPrecisionMatch();
            if (r8 != null) goto L5;
        L7:
            long r0 = 15;
        L8:
            if (r8 != null) goto L10;
            return;
        L10:
            if (this.a.c != r0) goto L17;
            i41.r r1 = i41.r.c.a();
            long r2 = r8.getPrecisionMatchId();
            Iterator r9 = ((ArrayList) r1.a).iterator();
        L13:
            if (r9.hasNext() == false) goto L18;
            ((i41.q) r9.next()).a(r2);
            goto L13
        L18:
            return;
        L17:
            return;
        L5:
            if (r8.getWaitSeconds() <= 0) goto L7;
            r0 = r8.getWaitSeconds();
            goto L8
        }
    }

    static {
    }

    public final void I() {
        final ToolbarPkIdleHolder r0 = this.x;
        if (r0.d == true) goto L38;
        r0.a.getClass();
        if (k.j() == true) goto L9;
        r0.c(IvPkId.MAIN);
        r0.a.getClass();
        if (k.b() == true) goto L36;
        r0.a.getClass();
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = l51.a.H0;
        KProperty[] r5 = l51.a.a;
        r1.setValue(null, r5[97], null);
        Intrinsics.checkNotNullParameter("", "<set-?>");
        l51.a.I0.setValue(null, r5[98], "");
    L36:
        r0.d = true;
        return;
    L9:
        h r2 = r0.a.d();
        r0.a.getClass();
        PkPanelType.a r6 = PkPanelType.Companion;
        Integer r3 = (Integer) l51.a.H0.getValue(null, l51.a.a[97]);
        r6.getClass();
        final PkPanelType r4 = PkPanelType.a.a(r3);
        final PkPanelType r7 = r2.getType();
        String r8 = r2.c;
        String r9 = r2.d;
        if (r4 == null) goto L29;
        if (r7 == r4) goto L29;
        if (r7 != PkPanelType.Anchor) goto L17;
        r0.a.getClass();
        if (k.g() == false) goto L17;
        final boolean r10 = true;
    L18:
        PkPanelType r12 = PkPanelType.PK;
        if (r7 != r12) goto L22;
        if (r10 == false) goto L22;
        ToolbarPkIdleHolder.PkIconStatus r13 = ToolbarPkIdleHolder.PkIconStatus.WAITING_LINK_TO_PK_AND_PASS_LEAD;
    L28:
        r0.f = r13;
        final Function0<Unit> r14 = new ToolbarPkIdleHolder$onTypeChanged$1(r0, r10);
        Function0<Unit> r15 = new ToolbarPkIdleHolder$onTypeChanged$2(r0, r7, r10);
        r0.e.clear();
        Disposable r16 = Observable.concat(Observable.create(new e0(r0, r4)), Observable.create(new ToolbarPkIdleHolder$showWithEnterAnim$2(r0, r14, r7, r4))).subscribeOn(AndroidSchedulers.mainThread()).subscribe(f0.a, g0.a, new h0(r0, r7, r15));
        r0.e.add(r16);
    L22:
        if (r7 != r12) goto L25;
        if (r10 == true) goto L25;
        r13 = ToolbarPkIdleHolder.PkIconStatus.WAITING_LINK_TO_PK;
    L25:
        if (r10 == false) goto L27;
        r13 = ToolbarPkIdleHolder.PkIconStatus.WAITING_PK_TO_LINK_AND_PASS_LEAD;
        goto L28
    L27:
        r13 = ToolbarPkIdleHolder.PkIconStatus.WAITING_PK_TO_LINK;
    L17:
        r10 = false;
    L29:
        if (r4 != null) goto L31;
    L35:
        r0.f = ToolbarPkIdleHolder.PkIconStatus.OTHERS;
        r0.c(IvPkId.MAIN);
        r0.a.getClass();
        k.i(r7, r8, r9);
        goto L36
    L31:
        if (r7 != PkPanelType.Anchor) goto L35;
        r0.a.getClass();
        if (k.g() == false) goto L35;
        h r17 = r0.a.d();
        final PkPanelType r18 = r17.getType();
        final String r19 = r17.c;
        final String r20 = r17.d;
        r0.f = ToolbarPkIdleHolder.PkIconStatus.WAITING_LEAD_PK;
        final Function0<Unit> r22 = new ToolbarPkIdleHolder$onLeadPkShow$1(r0);
        Function0<Unit> r23 = new ToolbarPkIdleHolder$onLeadPkShow$2(r0, r18, r19, r20);
        r0.e.clear();
        Disposable r24 = Observable.concat(Observable.create(new i0(r0)), Observable.create(new ToolbarPkIdleHolder$showWithLeadPkAnim$2(r0, r22))).subscribeOn(AndroidSchedulers.mainThread()).subscribe(j0.a, k0.a, new l0(r0, r23));
        r0.e.add(r24);
        goto L36
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void V2() {
        ToolbarPkIdleHolder r0 = this.x;
        if (r0.d == false) goto L25;
        d0 r1 = r0.b;
        IvPkId r2 = IvPkId.MAIN;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "ivPkId");
        if (r2 != IvPkId.BAK) goto L9;
        com.bytedance.android.live.revlink.impl.behavior.a r3 = r1.a();
        if (r3 == null) goto L10;
        r3.n();
    L10:
        h r4 = r0.a.d();
        Disposable r5 = r0.b.e(r4.b, r2, false);
        if (r5 == null) goto L13;
        r0.e.add(r5);
    L13:
        ld.a r6 = ld.d.a();
        if (r6 == null) goto L18;
        NextLiveData r7 = r6.uf();
        if (r7 == null) goto L18;
        r7.setValue(0);
    L18:
        com.bytedance.android.livesdk.revenue.datacenter.e r8 = wq2.e.a();
        k r9 = r0.a;
        PkPanelType r10 = r4.getType();
        r9.getClass();
        r8.f(k.e(r10));
        ld.a r12 = ld.d.a();
        if (r12 == null) goto L23;
        NextLiveData r13 = r12.A4();
        if (r13 == null) goto L23;
        k r14 = r0.a;
        PkPanelType r15 = r4.getType();
        r14.getClass();
        r13.setValue(k.f(r15));
    L23:
        r0.d = false;
        return;
    L9:
        r1.b.n();
        goto L10
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void f3() {
        yo2.e r0 = this.i;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.d();
        this.i = null;
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void h() {
        LottieAnimationView r0 = this.k;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.setVisibility(8);
        LottieAnimationView r1 = this.k;
        Intrinsics.checkNotNull(r1);
        r1.setImageResource(0);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void h3() {
        if (this.n != null) goto L5;
        return;
    L5:
        Disposable r0 = this.r;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        if (r0.isDisposed() == true) goto L10;
        Disposable r1 = this.r;
        Intrinsics.checkNotNull(r1);
        r1.dispose();
        this.r = null;
    L10:
        ObjectAnimator r2 = this.t;
        if (r2 == null) goto L13;
        Intrinsics.checkNotNull(r2);
        r2.cancel();
        this.t = null;
    L13:
        HSImageView r3 = this.n;
        Intrinsics.checkNotNull(r3);
        r3.setRotation(0.0f);
        HSImageView r4 = this.o;
        Intrinsics.checkNotNull(r4);
        r4.setVisibility(8);
        HSImageView r5 = this.o;
        Intrinsics.checkNotNull(r5);
        r5.clearAnimation();
        HSImageView r6 = this.n;
        Intrinsics.checkNotNull(r6);
        r6.setVisibility(8);
        HSImageView r7 = this.n;
        Intrinsics.checkNotNull(r7);
        r7.clearAnimation();
        TextView r8 = this.p;
        Intrinsics.checkNotNull(r8);
        r8.setVisibility(8);
        I();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void i3() {
        HSImageView r0 = this.o;
        Intrinsics.checkNotNull(r0);
        if (r0.getVisibility() != 0) goto L6;
        HSImageView r1 = this.o;
        Intrinsics.checkNotNull(r1);
        r1.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final boolean k3() {
        yo2.e r0 = this.i;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        if (r0.h() == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void n() {
        LottieAnimationView r0 = this.k;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.clearAnimation();
        LottieAnimationView r1 = this.k;
        Intrinsics.checkNotNull(r1);
        r1.setVisibility(4);
        return;
    }

    public final void reset() {
        if (this.j != null) goto L5;
        return;
    L5:
        LottieAnimationView r0 = this.k;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        r0.clearAnimation();
    L8:
        LottieAnimationView r1 = this.k;
        Intrinsics.checkNotNull(r1);
        r1.setVisibility(0);
        I();
        HSImageView r2 = this.n;
        Intrinsics.checkNotNull(r2);
        r2.setController(null);
        HSImageView r3 = this.n;
        Intrinsics.checkNotNull(r3);
        r3.setVisibility(8);
        HSImageView r4 = this.n;
        Intrinsics.checkNotNull(r4);
        r4.setRotation(0.0f);
    }

    public final void A() {
        V2();
        ImageUtil.loadGifImage(this.k, "https://" + com.bytedance.android.live.revenue.common.k0.a + "/obj/live-android/anchor_online.webp");
    }

    public final void E(int r1) {
        V2();
        s(r1);
    }

    public final void F(t4 r9) {
        HashMap r0 = (HashMap) l51.a.E0.getValue(null, l51.a.a[92]);
        if (r9 == null) goto L5;
        List r1 = r9.getYellowDots();
    L7:
        if (r1 == null) goto L18;
        int r2 = r9.getYellowDots().size();
        int r5 = 0;
    L9:
        if (r5 >= r2) goto L18;
        String r6 = (String) ListProtector.get(r9.getYellowDots(), r5);
        if (r0.containsKey(r6) == true) goto L17;
        if (TextUtils.equals("breakthrough", r6) == false) goto L15;
    L16:
        r0.put(r6, Boolean.FALSE);
        goto L17
    L15:
        if (TextUtils.equals("common", r6) == true) goto L16;
    L17:
        r5 = r5 + 1;
    L18:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        l51.a.E0.setValue(null, l51.a.a[92], r0);
        Iterator r10 = r0.entrySet().iterator();
    L20:
        if (r10.hasNext() == false) goto L35;
        if (((Boolean) ((Map.Entry) r10.next()).getValue()).booleanValue() == true) goto L20;
        View r12 = this.q;
        if (r12 == null) goto L34;
        UIUtils.setViewVisibility(r12, 0);
        return;
    L34:
        return;
    L35:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void J2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        f3();
        View r0 = LayoutInflater.from(this.d).inflate(2131567816, null);
        TextView r1 = (TextView) r0.findViewById(2131390805);
        View r2 = r0.findViewById(2131376322);
        r1.setText(r10);
        yo2.e r3 = new yo2.e(this.d);
        ((yo2.d) r3).d = r0;
        ((yo2.d) r3).e = 0;
        ((yo2.d) r3).m = 5;
        ((yo2.d) r3).l = true;
        r3.a();
        this.i = r3;
        View r4 = this.j;
        Intrinsics.checkNotNull(r4);
        r3.i(r4, 1, 0, s1.f(this.b), s1.f(-4));
        View r12 = this.j;
        Intrinsics.checkNotNull(r12);
        float r13 = r12.getX();
        View r5 = this.j;
        Intrinsics.checkNotNull(r5);
        UIUtils.updateLayoutMargin(r2, (int) ((r13 + (r5.getWidth() / 2)) - s1.f(12.0f)), -3, -3, -3);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void P2(RingDrawable r6) {
        Intrinsics.checkNotNullParameter(r6, "type");
        if (p.a[r6.ordinal()] != 1) goto L7;
        HSImageView r7 = this.n;
        Intrinsics.checkNotNull(r7);
        r7.setVisibility(0);
        HSImageView r8 = this.n;
        Intrinsics.checkNotNull(r8);
        r8.setImageResource(2131251325);
        HSImageView r9 = this.n;
        Intrinsics.checkNotNull(r9);
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r9, "rotation", new float[]{0.0f, 360.0f}).setDuration(1000);
        this.t = r10;
        Intrinsics.checkNotNull(r10);
        r10.setRepeatMode(1);
        ObjectAnimator r12 = this.t;
        Intrinsics.checkNotNull(r12);
        r12.setRepeatCount(-1);
        ObjectAnimator r13 = this.t;
        Intrinsics.checkNotNull(r13);
        r13.setInterpolator(new PathInterpolator(0.53f, 0.15f, 0.48f, 0.81f));
        ObjectAnimator r14 = this.t;
        Intrinsics.checkNotNull(r14);
        r14.start();
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void R2(ToolBarPic r2) {
        Intrinsics.checkNotNullParameter(r2, "pic");
        int r3 = p.b[r2.ordinal()];
        if (r3 != 1) goto L5;
    L11:
        int r4 = 0;
    L12:
        s(r4);
        return;
    L5:
        if (r3 != 2) goto L7;
        r4 = 2131251183;
        goto L12
    L7:
        if (r3 != 3) goto L11;
        r4 = 2131251182;
        goto L12
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void S2(ToolBarPic r2) {
        Intrinsics.checkNotNullParameter(r2, "pic");
        int r3 = p.b[r2.ordinal()];
        if (r3 != 1) goto L5;
    L11:
        int r4 = 0;
    L12:
        E(r4);
        return;
    L5:
        if (r3 != 2) goto L7;
        r4 = 2131251183;
        goto L12
    L7:
        if (r3 != 3) goto L11;
        r4 = 2131251182;
        goto L12
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void W2(int r4) {
        if (this.j != null) goto L5;
        return;
    L5:
        if (r4 != 0) goto L7;
        f3();
        reset();
    L51:
        ((SingleSubscribeProxy) Single.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.z))).subscribe(new c(this));
        return;
    L7:
        if (r4 != 1) goto L9;
        f3();
        IPKLinkBizDataService r5 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (com.bytedance.android.live.revlink.impl.global.b.O() != null) goto L32;
    L38:
        com.bytedance.android.live.revlink.impl.precisefind.a r2 = com.bytedance.android.live.revlink.impl.global.b.K();
        if (r2 != null) goto L41;
    L44:
        HSImageView r1 = this.n;
        Intrinsics.checkNotNull(r1);
        r1.setVisibility(8);
        if (r5 != null) goto L47;
    L49:
        E(2131251183);
        goto L51
    L47:
        if (r5.getIsInviteVote() == false) goto L49;
        V2();
        ImageUtil.loadGifImage(this.k, "https://" + com.bytedance.android.live.revenue.common.k0.a + "/obj/live-android/anchor_waiting.webp");
        goto L51
    L41:
        if (r2.nl() != true) goto L44;
        ALogger.i("ToolbarPkBehavior", "disable waiting state when precise find people inviting");
        return;
    L32:
        if (com.bytedance.android.live.revlink.impl.pk.utils.j.b(1) != true) goto L38;
        if (r5 != null) goto L35;
    L37:
        J2(s1.B(2131917968));
        goto L38
    L35:
        if (r5.getIsInviteVote() == false) goto L37;
        J2(s1.B(2131917509));
        goto L38
    L9:
        if (r4 != 2) goto L11;
        f3();
        if (com.bytedance.android.live.revlink.impl.global.b.O() == null) goto L51;
        if (com.bytedance.android.live.revlink.impl.pk.utils.j.b(2) != true) goto L51;
        J2(s1.B(2131917862));
        goto L51
    L11:
        if (r4 != 4) goto L13;
        reset();
        goto L51
    L13:
        if (r4 != 5) goto L51;
        i41.a r6 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r6 != null) goto L18;
    L22:
        HSImageView r7 = this.n;
        Intrinsics.checkNotNull(r7);
        r7.setController(null);
        HSImageView r8 = this.n;
        Intrinsics.checkNotNull(r8);
        r8.setVisibility(8);
        E(2131251182);
        goto L51
    L18:
        if (r6.f != true) goto L22;
        i41.a r9 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r9 == null) goto L22;
        r9.b(AutoMatchSource.Manual);
        goto L22
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void Z2(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        HSImageView r0 = this.o;
        Intrinsics.checkNotNull(r0);
        if (r0.getVisibility() == 0) goto L6;
        HSImageView r1 = this.o;
        Intrinsics.checkNotNull(r1);
        r1.setVisibility(0);
        com.bytedance.android.live.revlink.impl.pk.utils.w.a(this.o, r3);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void a(zr2.n r23) {
        Intrinsics.checkNotNullParameter(r23, "command");
        if ((r23 instanceof zr2.e) == false) goto L96;
        yz0.k r2 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L97;
        zr2.e r1 = (zr2.e) r23;
        if (this.d != null) goto L14;
        return;
    L14:
        if (this.j == null) goto L99;
        f3();
        View r4 = LayoutInflater.from(this.d).inflate(2131567816, null);
        TextView r5 = (TextView) r4.findViewById(2131390805);
        TextView r7 = (TextView) r4.findViewById(2131390804);
        View r8 = r4.findViewById(2131374666);
        View r9 = r4.findViewById(2131376322);
        LinearLayout r10 = (LinearLayout) r4.findViewById(2131378737);
        LinearLayout r12 = (LinearLayout) r4.findViewById(2131378720);
        ImageView r13 = (ImageView) r4.findViewById(2131374683);
        py.k r14 = r1.m;
        if (r14 == null) goto L19;
        ImageUtil.loadImage(r13, r14);
        UIUtils.updateLayoutMargin(r10, -3, s1.f(46.0f), -3, -3);
        r13.setVisibility(0);
    L20:
        int r15 = r1.h;
        if (r15 == 12) goto L23;
        if (r15 == 13) goto L23;
    L24:
        py.k r16 = r1.n;
        if (r16 != null) goto L27;
    L31:
        ImageView r17 = (ImageView) r4.findViewById(2131382782);
        Map r18 = r1.i;
        if (r18 == null) goto L36;
        Intrinsics.checkNotNull(r18);
        if (r18.containsKey("linkmic_panel") == false) goto L36;
        this.u = true;
    L36:
        r17.setVisibility(8);
        if (r1.b == null) goto L39;
        ur2.a r6 = com.bytedance.android.live.revenue.core.util.e.a(ur2.a.class);
        a5 r19 = r1.b;
        Intrinsics.checkNotNull(r19);
        r5.setText(r6.Q9(r19));
    L45:
        if (TextUtils.isEmpty(r1.l) == true) goto L55;
        r7.setVisibility(0);
        r7.setText(r1.l);
        ViewGroup.LayoutParams r20 = r5.getLayoutParams();
        if (r20 == null) goto L54;
        LinearLayout.LayoutParams r22 = (LinearLayout.LayoutParams) r20;
        r22.height = s1.f(20.0f);
        r5.setLayoutParams(r22);
        ViewGroup.LayoutParams r24 = r12.getLayoutParams();
        if (r24 == null) goto L52;
        LinearLayout.LayoutParams r25 = (LinearLayout.LayoutParams) r24;
        r25.bottomMargin = s1.f(10.0f);
        r12.setLayoutParams(r25);
    L56:
        yo2.e r26 = new yo2.e(this.d);
        ((yo2.d) r26).d = r4;
        ((yo2.d) r26).e = 0;
        ((yo2.d) r26).g = false;
        ((yo2.d) r26).f = false;
        ((yo2.d) r26).m = r1.d;
        ((yo2.d) r26).k = new t(this, r1);
        r26.a();
        View r27 = this.j;
        Intrinsics.checkNotNull(r27);
        r26.i(r27, 1, 0, s1.f(this.b), s1.f(-4));
        BubbleOpenLocalPanel r28 = r1.k;
        if (TextUtils.isEmpty(r1.c) == false) goto L59;
        if (r28 != null) goto L59;
    L60:
        this.i = r26;
        r4.setOnClickListener(new s(this, r26, r1));
        View r29 = this.j;
        Intrinsics.checkNotNull(r29);
        float r30 = r29.getX();
        View r32 = this.j;
        Intrinsics.checkNotNull(r32);
        UIUtils.updateLayoutMargin(r9, (int) ((r30 + (r32.getWidth() / 2)) - s1.f(12.0f)), -3, -3, -3);
        HashMap r33 = new HashMap();
        r33.put("location_from", "pk_icon");
        r33.put("bubble_info", "activity");
        r33.put("message_type", "link_msg_guide");
        LinkCrossRoomDataHolder r34 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r34 == null) goto L63;
        Long r35 = Long.valueOf(r34.c());
    L64:
        r33.put("channel_id", String.valueOf(r35));
        d31.d r36 = com.bytedance.android.live.revlink.impl.global.b.c0();
        String r37 = "";
        if (r36 == null) goto L68;
        String r38 = r36.a();
        if (r38 == null) goto L68;
    L69:
        r33.put("anchor_connect_status", r38);
        d31.d r39 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r39 == null) goto L72;
        String r40 = r39.o();
    L73:
        r33.put("is_manager", r40);
        int r42 = r1.h;
        if (r42 != 12) goto L76;
    L79:
        r33.put("message_type", "to_cohost_game");
        r33.put("to_user_group", "cohost_game_fitted");
        Map r43 = r1.i;
        if (r43 == null) goto L85;
        Intrinsics.checkNotNull(r43);
        if (r43.containsKey("open_game_app_id") == false) goto L85;
        Map r44 = r1.i;
        Intrinsics.checkNotNull(r44);
        r37 = (String) r44.get("open_game_app_id");
    L85:
        if (TextUtils.isEmpty(r37) == true) goto L88;
        Intrinsics.checkNotNull(r37);
        r33.put("open_game_app_id", r37);
    L88:
        if (this.e == false) goto L90;
        String r45 = DataType.TRUE;
    L91:
        r33.put("is_anchor", r45);
        Map r46 = r1.i;
        if (r46 == null) goto L94;
        r33.putAll(r46);
    L94:
        mz0.n r47 = new mz0.n();
        Map<String, String> r48 = r47.a;
        Intrinsics.checkNotNullParameter(r48, "map");
        Intrinsics.checkNotNullParameter(r33, "map");
        r48.putAll(r33);
        mz0.m r49 = new mz0.m();
        r49.b(LogCommon.ROOM);
        ((ArrayList) r47.b).addAll(r49.a);
        cy0.e.a.getClass();
        cy0.j r50 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r52 = com.bytedance.android.scope.m.b(r50).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r52);
        ((mz0.i) ((f80.a) r52)).w3("livesdk_room_bubble_show", r47.a, r47.b);
        return;
    L90:
        r45 = DataType.FALSE;
        goto L91
    L76:
        if (r42 == 13) goto L79;
        r33.put("to_user_group", "entertainment_less_pk");
        r33.put("message_type", "link_msg_guide");
        goto L88
    L72:
        r40 = "";
    L68:
        r38 = "";
        goto L69
    L63:
        r35 = null;
    L59:
        r8.setVisibility(0);
        goto L60
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L54:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L55:
        r7.setVisibility(8);
        goto L56
    L39:
        String r53 = r1.a;
        if (r53 == null) goto L45;
        if (TextUtils.isEmpty(r53) == true) goto L45;
        r5.setText(r53);
        goto L45
    L27:
        if (this.m == null) goto L31;
        String r110 = w(r16);
        if (TextUtils.isEmpty(r110) == true) goto L31;
        ToolbarPkIdleHolder.b(this.x, PkPanelType.GAME);
        LottieAnimationView r111 = this.m;
        Intrinsics.checkNotNull(r111);
        r111.setVisibility(0);
        ImageUtil.loadImage(this.m, r110);
    L23:
        this.w = true;
        r9.setBackgroundResource(2131249445);
        r10.setBackground(s1.m(2131249448));
        goto L24
    L19:
        r13.setVisibility(8);
        goto L20
    L99:
        return;
    L97:
        return;
    L7:
        if (r2.isAnchor() == false) goto L9;
        r3 = true;
        goto L10
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void e3(py.k r2) {
        V2();
        ImageUtil.loadRoundImage(this.k, r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void f(py.k r3) {
        Intrinsics.checkNotNullParameter(r3, "image");
        if (this.k == null) goto L8;
        String r4 = w(r3);
        if (TextUtils.isEmpty(r4) == true) goto L9;
        LottieAnimationView r0 = this.k;
        Intrinsics.checkNotNull(r0);
        r0.setVisibility(0);
        ImageUtil.loadImage(this.k, r4);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void j(float r2) {
        LottieAnimationView r0 = this.k;
        Intrinsics.checkNotNull(r0);
        r0.setAlpha(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void m3(d5 r4) {
        Intrinsics.checkNotNullParameter(r4, "precisionMatchMessage");
        if (this.j != null) goto L5;
        return;
    L5:
        TextView r0 = this.p;
        Intrinsics.checkNotNull(r0);
        r0.setVisibility(8);
        HSImageView r1 = this.n;
        Intrinsics.checkNotNull(r1);
        r1.setVisibility(8);
        E(2131251183);
        this.c = 0;
        Disposable r2 = this.r;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNull(r2);
        r2.dispose();
    L8:
        this.r = du2.a.d(1, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r4));
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void n3(boolean r3) {
        if (this.n != null) goto L5;
        return;
    L5:
        Disposable r0 = this.r;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        if (r0.isDisposed() == true) goto L10;
        Disposable r1 = this.r;
        Intrinsics.checkNotNull(r1);
        r1.dispose();
        this.r = null;
    L10:
        ObjectAnimator r2 = this.t;
        if (r2 == null) goto L13;
        Intrinsics.checkNotNull(r2);
        r2.cancel();
        this.t = null;
    L13:
        HSImageView r4 = this.n;
        Intrinsics.checkNotNull(r4);
        r4.setRotation(0.0f);
        HSImageView r5 = this.o;
        Intrinsics.checkNotNull(r5);
        r5.setVisibility(8);
        HSImageView r6 = this.o;
        Intrinsics.checkNotNull(r6);
        r6.clearAnimation();
        HSImageView r7 = this.n;
        Intrinsics.checkNotNull(r7);
        r7.setVisibility(8);
        HSImageView r8 = this.n;
        Intrinsics.checkNotNull(r8);
        r8.clearAnimation();
        TextView r9 = this.p;
        Intrinsics.checkNotNull(r9);
        r9.setVisibility(8);
        if (r3 == false) goto L17;
        I();
        return;
    }

    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "v");
        if (this.y != null) goto L5;
    L34:
        this.u = false;
        i51.a r7 = i51.a.c;
        r7.getClass();
        int r8 = ((Number) i51.a.b.getValue(r7, i51.a.a[0])).intValue();
        com.bytedance.tools.kcp.spongepreference.runtime.a r3 = l51.a.b;
        KProperty[] r4 = l51.a.a;
        r3.setValue(null, r4[0], Integer.valueOf(r8));
        w31.c r9 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r9 != null) goto L37;
    L43:
        UIUtils.setViewVisibility(this.q, 8);
        return;
    L37:
        if (r9.o() != true) goto L43;
        HashMap r10 = (HashMap) l51.a.E0.getValue(null, r4[92]);
        Iterator r2 = r10.entrySet().iterator();
    L40:
        if (r2.hasNext() == false) goto L42;
        r10.put((String) ((Map.Entry) r2.next()).getKey(), Boolean.TRUE);
        goto L40
    L42:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        l51.a.E0.setValue(null, l51.a.a[92], r10);
        goto L43
    L5:
        if (this.u == true) goto L32;
        this.x.getClass();
        ld.a r12 = ld.d.a();
        if (r12 == null) goto L11;
        NextLiveData r13 = r12.uf();
        if (r13 == null) goto L11;
        Integer r14 = (Integer) r13.getValue();
    L12:
        if (r14 != null) goto L15;
    L16:
        ld.a r15 = ld.d.a();
        if (r15 == null) goto L21;
        NextLiveData r16 = r15.uf();
        if (r16 == null) goto L21;
        Integer r17 = (Integer) r16.getValue();
    L22:
        if (r17 != null) goto L25;
    L27:
        boolean r18 = false;
    L29:
        if (r18 == true) goto L32;
        boolean r19 = false;
    L33:
        this.y.Ne(1, null, r19);
        this.x.a();
        goto L34
    L25:
        if (r17.intValue() != 4) goto L27;
    L28:
        r18 = true;
    L21:
        r17 = null;
        goto L22
    L15:
        if (r14.intValue() == 1) goto L28;
    L11:
        r14 = null;
    L32:
        r19 = true;
        goto L33
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void onMultiAnchorStateChange(int r3) {
        if (this.e == true) goto L5;
        return;
    L5:
        this.v = r3;
        if (r3 != 1) goto L9;
        V2();
        LottieAnimationView r4 = this.k;
        StringBuilder r0 = new StringBuilder("https://");
        String r1 = com.bytedance.android.live.revenue.common.k0.a;
        r0.append(com.bytedance.android.live.revenue.common.k0.a);
        r0.append("/obj/live-android/anchor_waiting.webp");
        ImageUtil.loadGifImage(r4, r0.toString());
        return;
    L9:
        if (r3 != 2) goto L11;
        V2();
        LottieAnimationView r5 = this.k;
        StringBuilder r2 = new StringBuilder("https://");
        String r6 = com.bytedance.android.live.revenue.common.k0.a;
        r2.append(com.bytedance.android.live.revenue.common.k0.a);
        r2.append("/obj/live-android/anchor_online.webp");
        ImageUtil.loadGifImage(r5, r2.toString());
        return;
    L11:
        LottieAnimationView r7 = this.k;
        Intrinsics.checkNotNull(r7);
        r7.clearAnimation();
        I();
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final void s(int r3) {
        LottieAnimationView r0 = this.k;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.setVisibility(0);
        LottieAnimationView r1 = this.k;
        Intrinsics.checkNotNull(r1);
        r1.setImageResource(r3);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.i
    public final void setText(String r4) {
        Intrinsics.checkNotNullParameter(r4, "text");
        if (r4.length() > 2) goto L5;
        TextView r0 = this.p;
        Intrinsics.checkNotNull(r0);
        r0.setTextSize(1, 24.0f);
    L6:
        TextView r1 = this.p;
        Intrinsics.checkNotNull(r1);
        r1.setVisibility(0);
        TextView r2 = this.p;
        Intrinsics.checkNotNull(r2);
        r2.setText(r4);
        return;
    L5:
        TextView r3 = this.p;
        Intrinsics.checkNotNull(r3);
        r3.setTextSize(1, 18.0f);
        goto L6
    }

    public final String w(py.k r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        List r4 = r3.getUrls();
        if (r4 != null) goto L8;
    L12:
        return null;
    L8:
        if (r4.isEmpty() == true) goto L12;
        return (String) ListProtector.get(r4, 0);
    }

    public final void y(float r2) {
        View r0 = this.j;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.setAlpha(r2);
        return;
    }

    public ToolbarPkBehavior(b r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "mLifecycleOwner");
        this.y = r2;
        this.z = r3;
        this.b = 1;
        this.g = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        this.h = new CompositeDisposable();
        new CompositeDisposable();
        this.x = new ToolbarPkIdleHolder(this);
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.h.clear();
        n3(true);
        f3();
        Disposable r4 = this.s;
        if (r4 == null) goto L6;
        Intrinsics.checkNotNull(r4);
        r4.dispose();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.d
    public final com.bytedance.android.live.revlink.impl.behavior.b o(py.k r3, com.bytedance.android.live.revlink.impl.behavior.c r4) {
        Intrinsics.checkNotNullParameter(r3, "anim");
        if (this.k != null) goto L5;
        return null;
    L5:
        String r5 = w(r3);
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return null;
    L8:
        LottieAnimationView r0 = this.k;
        Intrinsics.checkNotNull(r0);
        r0.setVisibility(0);
        LottieAnimationView r1 = this.k;
        Intrinsics.checkNotNull(r1);
        r1.clearAnimation();
        LottieAnimationView r2 = this.k;
        Intrinsics.checkNotNull(r2);
        r2.setImageResource(0);
        LottieAnimationView r6 = this.k;
        Intrinsics.checkNotNull(r6);
        return o.a(r6, r5, r4);
    }

    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        yz0.l r8 = this.g;
        if (r8 == null) goto L5;
        CompositeDisposable r1 = this.h;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        r1.add(yz0.h.a.a(r8, com.bytedance.android.live.revenue.common.message.b.m, false, 4).subscribe(new d(this)));
    L5:
        com.bytedance.android.live.revenue.core.util.j.a r9 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r2 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r9.a(), yz0.k.class);
        this.j = r6;
        this.d = r6.getContext();
        if (r2 == null) goto L8;
        IRoom r3 = r2.getRoom();
    L9:
        this.f = r3;
        com.bytedance.android.livesdk.revenue.service.room.c r4 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r9.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.revenue.room.a r5 = r4.getRoomContext();
        if (r5 == null) goto L14;
        boolean r10 = r5.getCommonIsAnchor();
    L15:
        this.e = r10;
        View r12 = this.j;
        Intrinsics.checkNotNull(r12);
        this.n = r12.findViewById(2131376474);
        View r13 = this.j;
        Intrinsics.checkNotNull(r13);
        this.o = r13.findViewById(2131376473);
        View r14 = this.j;
        Intrinsics.checkNotNull(r14);
        this.k = r14.findViewById(2131376468);
        View r15 = this.j;
        Intrinsics.checkNotNull(r15);
        this.l = r15.findViewById(2131376469);
        View r16 = this.j;
        Intrinsics.checkNotNull(r16);
        this.m = r16.findViewById(2131376472);
        View r17 = this.j;
        Intrinsics.checkNotNull(r17);
        this.p = (TextView) r17.findViewById(2131390408);
        Observable.just("fonts/pk_random.ttf").subscribeOn(Schedulers.io()).map(new e(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), com.bytedance.android.live.revenue.common.h0.a);
        View r18 = this.j;
        Intrinsics.checkNotNull(r18);
        this.q = r18.findViewById(2131392581);
        Animation r19 = AnimationUtils.loadAnimation(r6.getContext(), 2130772728);
        if (r19 == null) goto L18;
        r19.setInterpolator(new LinearInterpolator());
    L18:
        ((ObservableSubscribeProxy) xs2.b.a().b(b30.o.class).as(AutoDispose.bind(this.z))).subscribe(new w(this));
        com.bytedance.tools.kcp.spongepreference.runtime.a r20 = l51.a.w0;
        KProperty[] r22 = l51.a.a;
        KProperty r23 = r22[84];
        Boolean r24 = Boolean.FALSE;
        r20.setValue(null, r23, r24);
        l51.a.x0.setValue(null, r22[85], r24);
        l51.a.y0.setValue(null, r22[86], 0);
        i51.a r25 = i51.a.c;
        r25.getClass();
        if (((Number) i51.a.b.getValue(r25, i51.a.a[0])).intValue() <= ((Number) l51.a.b.getValue(null, r22[0])).intValue()) goto L23;
        View r26 = this.q;
        if (r26 == null) goto L23;
        UIUtils.setViewVisibility(r26, 0);
    L23:
        Pair r27 = com.bytedance.live.datacontext.d.a(ToolbarPkBehavior$onLoad$pair$1.INSTANCE);
        ((ToolbarPKServiceContext) r27.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r27.getFirst(), "IToolbarPkService");
        this.s = (Disposable) r27.getSecond();
        lr2.a r28 = com.bytedance.android.live.revenue.core.util.f.d(r9.a(), lr2.a.class);
        if (this.f == null) goto L31;
        if (r28 == null) goto L31;
        if (r28.isPaidLive() == false) goto L31;
        View r29 = this.j;
        if (r29 == null) goto L31;
        Intrinsics.checkNotNull(r29);
        r29.setAlpha(0.34f);
    L31:
        this.x.b.a = this.l;
        return;
    L14:
        r10 = false;
        goto L15
    L8:
        r3 = null;
        goto L9
    }
}
