package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.privilege.model.touch.PrivilegeEntranceInfo;
import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDetailViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowDetail;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.text.RevRenderConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIDetailView extends BaseGiftMVIViewChildNode<GiftPanelState, GiftDetailViewState, GiftAction> {
    public PrivilegeEntranceInfo A;
    public com.bytedance.android.livesdk.gift.configmodel.m1 B;
    public boolean C;
    public boolean D;
    public final DataCenter E;
    public final Lazy m;
    public TextView n;
    public TextView o;
    public TextView p;
    public ConstraintLayout q;
    public View r;
    public ImageView s;
    public HSImageView t;
    public yo2.e u;
    public final Interpolator v;
    public IRoom w;
    public final CompositeDisposable x;
    public Disposable y;
    public final List<Animator> z;

    public static final class a {
    }

    public static final class b implements yo2.e.a {
        public final /* synthetic */ GiftMVIDetailView a;
        public final /* synthetic */ Spannable b;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                GiftMVIDetailView.u(this.a.a, 1);
                b r4 = this.a;
                r4.a.z("click", r4.b);
                yo2.e r5 = this.a.a.u;
                if (r5 == null) goto L6;
                r5.d();
                return;
            }
        }

        public b(GiftMVIDetailView r1, Spannable r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(View r1, yo2.e r2) {
            r1.setOnClickListener(new a(this));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GiftMVIDetailView a;

        public c(GiftMVIDetailView r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            yo2.e r3 = this.a.u;
            if (r3 == null) goto L6;
            r3.d();
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ GiftMVIDetailView a;

        public d(GiftMVIDetailView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            GiftMVIDetailView.u(this.a, 0);
        }
    }

    public static final class e implements yr2.a {
        public final /* synthetic */ GiftMVIDetailView a;
        public final /* synthetic */ a5 b;

        public final void a(py.k r2) {
            Intrinsics.checkNotNullParameter(r2, "image");
            Intrinsics.checkNotNullParameter(r2, "image");
        }

        public e(GiftMVIDetailView r1, a5 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b(Spannable r3, yr2.a.a r4) {
            Intrinsics.checkNotNullParameter(r3, "spannable");
            Intrinsics.checkNotNullParameter(r4, "info");
            TextView r5 = this.a.n;
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
        L5:
            r5.setText(r3);
            GiftMVIDetailView r6 = this.a;
            a5 r7 = this.b;
            if (r7 == null) goto L12;
            FrameLayout r0 = r6.x();
            h r1 = new h(r7, r6);
            if (PadConfigUtils.c() == false) goto L10;
            long r8 = 2000;
        L11:
            r0.postDelayed(r1, r8);
            return;
        L10:
            r8 = 50;
            goto L11
        L12:
            r6.getClass();
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ GiftMVIDetailView a;

        public f(GiftMVIDetailView r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            GiftMVIDetailView r8 = this.a;
            ImageView r0 = r8.s;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSweepImg");
        L5:
            r0.setVisibility(0);
            ImageView r1 = r8.s;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSweepImg");
        L8:
            ViewGroup.LayoutParams r2 = r1.getLayoutParams();
            TextView r3 = r8.n;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
        L11:
            r2.width = r3.getMeasuredWidth();
            ImageView r4 = r8.s;
            if (r4 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSweepImg");
        L14:
            ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, "translationX", new float[]{fm3.e.a(r8.getContext(), -52.0f), fm3.e.a(r8.getContext(), 52.0f)});
            r5.setDuration(750);
            r5.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
            r5.addListener(new j(r8));
            r5.setRepeatCount(0);
            r5.start();
            ((ArrayList) r8.z).add(r5);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ GiftMVIDetailView a;
        public final /* synthetic */ com.bytedance.android.live.profit.privilege.model.touch.i b;

        public g(GiftMVIDetailView r1, com.bytedance.android.live.profit.privilege.model.touch.i r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            GiftMVIDetailView r9 = this.a;
            py.k r0 = this.b.b;
            HSImageView r1 = r9.t;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSweepWebp");
        L5:
            r1.setVisibility(0);
            HSImageView r2 = r9.t;
            if (r2 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSweepWebp");
        L8:
            ViewGroup.LayoutParams r3 = r2.getLayoutParams();
            TextView r4 = r9.n;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
        L11:
            r3.width = r4.getMeasuredWidth();
            PipelineDraweeControllerBuilder r5 = Fresco.newDraweeControllerBuilder();
            if (r0 == null) goto L17;
            List r6 = r0.getUrls();
            if (r6 == null) goto L17;
            String r10 = (String) ListProtector.get(r6, 0);
            if (r10 == null) goto L17;
        L18:
            AbstractDraweeController r11 = r5.setUri(UriProtector.parse(r10)).setAutoPlayAnimations(true).build();
            HSImageView r13 = r9.t;
            if (r13 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSweepWebp");
        L21:
            r13.setController(r11);
            return;
        L17:
            r10 = BuildConfig.FLAVOR;
            goto L18
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131565785;
    }

    public final FrameLayout x() {
        return (FrameLayout) this.m.getValue();
    }

    public final void i() {
        if (this.x.isDisposed() == true) goto L5;
        this.x.dispose();
    L5:
        Disposable r0 = this.y;
        if (r0 == null) goto L16;
        if (r0.isDisposed() == true) goto L16;
        Disposable r1 = this.y;
        if (r1 == null) goto L12;
        r1.dispose();
    L12:
        yo2.e r2 = this.u;
        if (r2 == null) goto L16;
        r2.d();
    L16:
        if ((!this.z.isEmpty()) == false) goto L21;
        Iterator r3 = ((ArrayList) this.z).iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        ((Animator) r3.next()).cancel();
    L21:
        HSImageView r4 = this.t;
        if (r4 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mBtnSweepWebp");
    L24:
        r4.setController(null);
        com.bytedance.android.live.profit.privilege.a r5 = yt0.c.i();
        if (r5 == null) goto L29;
        com.bytedance.live.datacontext.m r6 = r5.getBubbleRefId();
        if (r6 == null) goto L29;
        r6.setValue(0L);
    L29:
        this.A = null;
    }

    public final void y() {
        TextView r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
    L5:
        com.bytedance.android.livesdk.gift.configmodel.m1 r1 = this.B;
        if (r1 == null) goto L10;
        String r2 = r1.mDetail;
        if (r2 == null) goto L10;
    L11:
        r0.setText(r2);
        r0.setTextColor(s1.h(2131107580));
        return;
    L10:
        r2 = s1.B(2131917366);
        goto L11
    }

    public final void g() {
        this.n = (TextView) r().findViewById(2131389140);
        this.o = (TextView) r().findViewById(2131389139);
        this.p = (TextView) r().findViewById(2131389145);
        this.q = r().findViewById(2131389141);
        this.s = (ImageView) r().findViewById(2131389142);
        this.t = r().findViewById(2131389143);
        this.r = r().findViewById(2131368886);
        PrivilegeEntranceInfo r2 = null;
        this.B = (com.bytedance.android.livesdk.gift.configmodel.m1) nz1.a.i.getValue(null, nz1.a.a[7]);
        TextView r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
    L5:
        r0.setOnClickListener(new d(this));
        this.C = false;
        y();
        this.w = (IRoom) this.E.get("data_room", null);
        com.bytedance.android.live.profit.privilege.a r1 = yt0.c.i();
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.m r3 = r1.getTouchPositionData();
        if (r3 == null) goto L12;
        TouchPositionData r4 = (TouchPositionData) r3.getValue();
        if (r4 == null) goto L12;
        r2 = r4.getPrivilegeEntranceInfo();
    L12:
        this.A = r2;
        com.bytedance.android.live.profit.privilege.a r5 = yt0.c.i();
        if (r5 == null) goto L24;
        com.bytedance.live.datacontext.m r6 = r5.getTouchPositionData();
        if (r6 == null) goto L25;
        Observable r7 = r6.a();
        if (r7 == null) goto L26;
        Observable r8 = r7.compose(RxUtil.rxSchedulerHelper());
        if (r8 == null) goto L27;
        Disposable r9 = r8.subscribe(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.e(this));
        if (r9 == null) goto L28;
        RxUtilKt.c(r9, this.x);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }

    public final void A(int r8) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L37
        IBaseUser r2 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b();     // Catch: Throwable -> L37
        if (r8 != 2) goto L6;
        String r9 = "livesdk_limitedprivilege_entrance_click";
    L7:
        Pair[] r3 = new Pair[3];     // Catch: Throwable -> L37
        if (r2 == null) goto L12;
        py.d r4 = r2.getUserHonor();     // Catch: Throwable -> L37
        if (r4 == null) goto L12;
        int r5 = r4.getLevel();     // Catch: Throwable -> L37
    L13:
        r3[0] = TuplesKt.to("privilege_level", String.valueOf(r5));     // Catch: Throwable -> L37
        r3[1] = TuplesKt.to("privilege_from", "1");     // Catch: Throwable -> L37
        PrivilegeEntranceInfo r6 = this.A;     // Catch: Throwable -> L37
        if (r6 == null) goto L23;
        a5 r7 = r6.getPanelDetail();     // Catch: Throwable -> L37
        if (r7 == null) goto L23;
        String r10 = r7.getDefaultPattern();     // Catch: Throwable -> L37
        if (r10 == null) goto L23;
        String r11 = new Regex("\\{\\d+:image\\}").replace(r10, BuildConfig.FLAVOR);     // Catch: Throwable -> L37
        if (r11 == null) goto L23;
        String r13 = StringsKt.trim(r11).toString();     // Catch: Throwable -> L37
        if (r13 == null) goto L23;
    L27:
        r3[2] = TuplesKt.to("entrance_content", r13);     // Catch: Throwable -> L37
        Map r14 = MapsKt.mutableMapOf(r3);     // Catch: Throwable -> L37
        PrivilegeEntranceInfo r15 = this.A;     // Catch: Throwable -> L37
        if (r15 == null) goto L35;
        Map r16 = r15.getExtra();     // Catch: Throwable -> L37
        if (r16 == null) goto L35;
        Iterator r17 = r16.entrySet().iterator();     // Catch: Throwable -> L37
    L33:
        if (r17.hasNext() == false) goto L35;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L37
        r14.put(r18.getKey(), r18.getValue());     // Catch: Throwable -> L37
    L35:
        mz0.n r19 = new mz0.n();     // Catch: Throwable -> L37
        Map r20 = r19.a;     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r20, "map");     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r14, "map");     // Catch: Throwable -> L37
        r20.putAll(r14);     // Catch: Throwable -> L37
        mz0.m r0 = new mz0.m();     // Catch: Throwable -> L37
        r0.b(LogCommon.ROOM);     // Catch: Throwable -> L37
        r0.b(LogCommon.PAGE_SOURCE_LOG);     // Catch: Throwable -> L37
        List r21 = r19.b;     // Catch: Throwable -> L37
        ArrayList r23 = (ArrayList) r21;     // Catch: Throwable -> L37
        r23.addAll(r0.a);     // Catch: Throwable -> L37
        cy0.e.a.getClass();     // Catch: Throwable -> L37
        cy0.j r24 = cy0.e.a.a;     // Catch: Throwable -> L37
        com.bytedance.android.scope.m.e.getClass();     // Catch: Throwable -> L37
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L37
        ((f80.a) r25).w3(r9, r19.a, r19.b);     // Catch: Throwable -> L37
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
        return;
    L23:
        TextView r26 = this.n;     // Catch: Throwable -> L37
        if (r26 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");     // Catch: Throwable -> L37
    L26:
        r13 = StringsKt.trim(r26.getText()).toString();     // Catch: Throwable -> L37
    L12:
        r5 = 0;
        goto L13
    L6:
        r9 = "livesdk_limitedprivilege_entrance_show";
    L37:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void C(boolean r2) {
        if (r2 == true) goto L14;
        Disposable r3 = this.y;
        if (r3 == null) goto L7;
        r3.dispose();
    L7:
        yo2.e r4 = this.u;
        if (r4 == null) goto L11;
        r4.d();
    L11:
        if (x().getVisibility() != 0) goto L17;
        x().setVisibility(8);
        return;
    L17:
        return;
    L14:
        if (x().getVisibility() != 8) goto L19;
        x().setVisibility(0);
        return;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIDetailView$bindToParent$1 r0 = GiftMVIDetailView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        if ((r2 instanceof ShowDetail) == false) goto L7;
        ShowDetail r3 = (ShowDetail) r2;
        this.D = r3.getVisible();
        C(r3.getVisible());
        return false;
    L7:
        return false;
    }

    public static final void t(GiftMVIDetailView r13, View r14) {
        TextView r0 = r13.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
    L5:
        int r7 = r0.getMeasuredWidth();
        int r6 = r13.x().getMeasuredWidth();
        ViewGroup.LayoutParams r5 = r13.x().getLayoutParams();
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r14, "alpha", new float[]{1.0f, 0.0f});
        r10.setDuration(200);
        r10.addUpdateListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.c(r10, r13, r5, r6, r7, r14));
        r10.addListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.d(r14));
        r10.start();
        TextView r15 = r13.n;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
    L8:
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r15, "alpha", new float[]{0.0f, 1.0f});
        r16.setDuration(50);
        r16.setStartDelay(150);
        r16.start();
        ((ArrayList) r13.z).add(r10);
        ((ArrayList) r13.z).add(r16);
    }

    public static final void u(GiftMVIDetailView r9, int r10) {
        r9.getClass();
        Long r3 = null;
        ay1.b.t.setValue(null, ay1.b.a[22], Boolean.TRUE);
        if (r9.w == null) goto L75;
        String r0 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId();
        HashMap r1 = new HashMap();
        r1.put("user_id", r0);
        mz0.n r4 = new mz0.n();
        Map r5 = r4.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r5.putAll(r1);
        mz0.m r2 = new mz0.m();
        r2.b(LogCommon.ROOM);
        r2.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r4.b).addAll(r2.a);
        cy0.e.a.getClass();
        cy0.j r6 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r7 = com.bytedance.android.scope.m.b(r6).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r7);
        ((f80.a) r7).w3("privilege_click", r4.a, r4.b);
        String r8 = BuildConfig.FLAVOR;
        if (r10 != 0) goto L8;
        PrivilegeEntranceInfo r11 = r9.A;
        if (r11 == null) goto L22;
        String r13 = r11.getPanelUrl();
    L24:
        if (TextUtils.isEmpty(r13) == true) goto L30;
        PrivilegeEntranceInfo r14 = r9.A;
        if (r14 == null) goto L34;
        String r15 = r14.getPanelUrl();
        if (r15 == null) goto L34;
    L35:
        Uri.Builder r16 = UriProtector.parse(r15).buildUpon();
        su0.a r17 = yt0.c.g();
        if (r17 == null) goto L38;
        int r18 = r17.pf();
    L39:
        IRoom r19 = r9.w;
        if (r19 == null) goto L43;
        String r20 = String.valueOf(r19.getId());
        if (r20 == null) goto L43;
    L44:
        Uri.Builder r110 = r16.appendQueryParameter("com.ss.android.ugc.live.intent.extra.ROOM_ID", r20);
        IRoom r21 = r9.w;
        if (r21 == null) goto L48;
        String r23 = r21.getRequestId();
        if (r23 == null) goto L48;
    L49:
        Uri.Builder r111 = r110.appendQueryParameter("com.ss.android.ugc.live.intent.extra.REQUEST_ID", r23);
        yz0.k r24 = com.bytedance.android.livesdk.gift.platform.core.utils.u.h();
        if (r24 == null) goto L55;
        String r25 = r24.getLogPb();
        if (r25 == null) goto L55;
        r8 = r25;
    L55:
        com.bytedance.android.live.revenue.common.x0 r26 = new com.bytedance.android.live.revenue.common.x0(r111.appendQueryParameter("com.ss.android.ugc.live.intent.extra.LOG_PB", r8).appendQueryParameter("user_id", r0).appendQueryParameter("request_page", "privilege_click").build().toString());
        r26.d("url").b("live_scene", String.valueOf(r18));
        String r112 = r26.toString();
        r9.A(2);
        com.bytedance.android.live.profit.privilege.a r27 = yt0.c.i();
        if (r27 == null) goto L61;
        PrivilegeEntranceInfo r28 = r9.A;
        if (r28 == null) goto L60;
        r3 = r28.getMetaId();
    L60:
        r27.nl(r3);
    L61:
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(r9.getContext(), r112);
        Disposable r113 = r9.y;
        if (r113 != null) goto L64;
        return;
    L64:
        if (r113.isDisposed() == true) goto L73;
        Disposable r114 = r9.y;
        if (r114 == null) goto L68;
        r114.dispose();
    L68:
        yo2.e r29 = r9.u;
        if (r29 == null) goto L74;
        r29.d();
        return;
    L74:
        return;
    L73:
        return;
    L48:
        r23 = BuildConfig.FLAVOR;
    L43:
        r20 = "0L";
        goto L44
    L38:
        r18 = 0;
    L34:
        r15 = BuildConfig.FLAVOR;
        goto L35
    L30:
        com.bytedance.android.livesdk.gift.configmodel.m1 r115 = r9.B;
        if (r115 == null) goto L34;
        r15 = r115.mDetailPageUrl;
        if (r15 != null) goto L35;
    L22:
        r13 = null;
        goto L24
    L8:
        if (r10 == 1) goto L14;
        com.bytedance.android.livesdk.gift.configmodel.m1 r116 = r9.B;
        if (r116 == null) goto L34;
        r15 = r116.mDetailPageUrl;
        if (r15 != null) goto L35;
    L14:
        PrivilegeEntranceInfo r117 = r9.A;
        if (r117 == null) goto L34;
        r15 = r117.getBubbleUrl();
        if (r15 != null) goto L35;
    }

    public static final void v(GiftMVIDetailView r5, Spannable r6) {
        View r0 = LayoutInflater.from(r5.getContext()).inflate(2131566128, null);
        if (com.bytedance.android.live.revenue.common.e0.a() == false) goto L7;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L15;
        r1.height = (int) fm3.e.a(r5.getContext(), 43.0f);
        r0.setLayoutParams(r1);
        goto L7
    L15:
        return;
    L7:
        View r2 = r0.findViewById(2131368901);
        if (r2 == null) goto L13;
        r2.setOnClickListener(new i(r5, r6));
        int r3 = r5.x().getMeasuredWidth();
        TextView r4 = r5.n;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
    L12:
        ViewUtilsKt.d(r2, r3 + r4.getPaddingLeft());
    L13:
        ((TextView) r0.findViewById(2131368902)).setText(r6);
        r5.w(r0, r6);
    }

    public final void B(a5 r4, a5 r5) {
        if (r4 != null) goto L5;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4 == null) goto L7;
        vh6.c.b(ur2.a.class).a4(r4, RevRenderConfig.SyncDecodeContext, new e(this, r5));
    L13:
        boolean r6 = true;
        if (this.C == true) goto L16;
        this.C = true;
        A(1);
    L16:
        PrivilegeEntranceInfo r7 = this.A;
        a5 r0 = null;
        if (r7 == null) goto L19;
        com.bytedance.android.live.profit.privilege.model.touch.i r8 = r7.getLightInfo();
    L20:
        PrivilegeEntranceInfo r1 = this.A;
        if (r1 == null) goto L23;
        r0 = r1.getAwardTips();
    L23:
        if (r0 == null) goto L33;
        TextView r2 = this.o;
        if (r2 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardDetailBtn");
    L28:
        if (r2.getVisibility() != 0) goto L33;
        TextView r9 = this.n;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
    L32:
        r9.setAlpha(0.0f);
        this.x.add(Single.timer(1700, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this)));
        return;
    L33:
        if (r8 != null) goto L35;
        return;
    L35:
        if (r8.a == false) goto L52;
        py.k r3 = r8.b;
        if (r3 != null) goto L39;
        return;
    L39:
        if (r3 == null) goto L43;
        List r10 = r3.getUrls();
        if (r10 == null) goto L43;
        int r11 = r10.size();
    L44:
        if (r11 > 0) goto L47;
        r6 = false;
    L47:
        if (r6 == false) goto L54;
        this.x.add(Single.timer(100, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r8)));
        return;
    L54:
        return;
    L43:
        r11 = 0;
        goto L44
    L52:
        return;
    L19:
        r8 = null;
        goto L20
    L7:
        if (r5 == null) goto L13;
        FrameLayout r13 = x();
        h r14 = new h(r5, this);
        if (PadConfigUtils.c() == false) goto L11;
        long r15 = 2000;
    L12:
        r13.postDelayed(r14, r15);
        goto L13
    L11:
        r15 = 50;
        goto L12
    }

    public final void b(com.bytedance.android.anya.k r2, MVIState r3) {
        GiftDetailViewState r4 = (GiftDetailViewState) r3;
        Intrinsics.checkNotNullParameter(r2, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r4, "state");
        com.bytedance.android.anya.r0<GiftDetailViewState, Boolean> r5 = r4.getNeedShowTopDetail();
        Object r0 = r2.c.a(r5);
        if (r0 == null) goto L6;
        r2.b.a.invoke(r5);
        boolean r6 = ((Boolean) r0).booleanValue();
        this.D = r6;
        C(r6);
        return;
    }

    public final void w(View r9, Spannable r10) {
        if (((BaseMVIView) this).a == true) goto L5;
        return;
    L5:
        yo2.e r7 = new yo2.e(getContext());
        ((yo2.d) r7).d = r9;
        ((yo2.d) r7).e = 0;
        ((yo2.d) r7).m = 3;
        ((yo2.d) r7).o = 2;
        ((yo2.d) r7).l = true;
        r7.x = new b(this, r10);
        r7.a();
        if (this.D == false) goto L11;
        ((yo2.d) r7).a.setAnimationStyle(2131954835);
        ConstraintLayout r2 = this.q;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mDetailBtnContainer");
    L10:
        r7.i(r2, 0, 2, 0, 0);
        z("show", r10);
    L11:
        Unit r11 = Unit.INSTANCE;
        this.u = r7;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.a.f.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[4])).booleanValue() == true) goto L15;
        this.y = Single.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        return;
    }

    public final void z(String r5, Spannable r6) {
        HashMap r0 = new HashMap();
        IBaseUser r1 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b();
        r0.put("user_id", r1.getIdString());
        r0.put("action_type", r5);
        py.d r7 = r1.getUserHonor();
        if (r7 == null) goto L5;
        int r8 = r7.getLevel();
    L6:
        r0.put("privilege_level", String.valueOf(r8));
        r0.put("bubble_content", r6.toString());
        PrivilegeEntranceInfo r9 = this.A;
        if (r9 == null) goto L14;
        Map r10 = r9.getExtra();
        if (r10 == null) goto L14;
        Iterator r11 = r10.entrySet().iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) r11.next();
        r0.put(r13.getKey(), r13.getValue());
    L14:
        mz0.n r14 = new mz0.n();
        Map r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r15.putAll(r0);
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.ROOM);
        r16.b(LogCommon.PAGE_SOURCE_LOG);
        List r2 = r14.b;
        ArrayList r3 = (ArrayList) r2;
        r3.addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((f80.a) r18).w3("livesdk_gift_top_bubble", r14.a, r14.b);
        return;
    L5:
        r8 = 0;
        goto L6
    }

    public GiftMVIDetailView(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2, r3);
        this.E = r4;
        this.m = LazyKt.lazy(new GiftMVIDetailView$mContainer$2(this));
        this.v = PathInterpolatorCompat.create(0.65f, 0.0f, 0.35f, 1.0f);
        this.x = new CompositeDisposable();
        this.z = new ArrayList();
        this.D = true;
    }
}
