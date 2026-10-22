package com.bytedance.android.live.profit.lottery;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.arch.mvvm.StateBuffer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import com.bytedance.android.livesdk.revenue.sti.RevStiElementType;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.model.CoinConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LotteryIconModel extends com.bytedance.android.live.revenue.common.a<g3.a> implements com.bytedance.android.scope.o {
    public String f;
    public String g;
    public int h;
    public xr2.g i;
    public boolean j;
    public boolean k;
    public final BehaviorSubject<y2> l;
    public final BehaviorSubject<Boolean> m;
    public final StateBuffer<g3.a> n;
    public final l2 o;
    public final LotteryContext p;
    public final g3 q;
    public final c01.a r;
    public final yz0.k s;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ LotteryIconModel d;
        public final /* synthetic */ t e;
        public final /* synthetic */ int f;

        public b(TextView r1, TextView r2, TextView r3, LotteryIconModel r4, t r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r10) {
            y2 r12 = (y2) r10;
            if (r12.a != this.e.a) goto L26;
            int r1 = (int) r12.e;
            int r0 = (int) r12.c;
            TextView r2 = this.a;
            if (r1 >= r0) goto L8;
            String r3 = com.bytedance.android.live.core.utils.s1.C(2131920154, new Object[]{Integer.valueOf(r1), Integer.valueOf(r0)});
        L18:
            r2.setText(r3);
            this.d.g = this.a.getText().toString();
            if (w2.b() == true) goto L21;
            return;
        L21:
            if (this.d.k == true) goto L23;
        L24:
            this.d.i(this.b, this.c, r12.d);
            return;
        L23:
            if (this.f != LotteryTempStatusStrategy.STRATEGY_HOST.getStrategyNum()) goto L24;
            return;
        L8:
            if (r1 > 100) goto L11;
            String r4 = String.valueOf(r1);
        L17:
            r3 = com.bytedance.android.live.core.utils.s1.C(2131920155, new Object[]{r4});
            goto L18
        L11:
            if (101 <= r1) goto L14;
        L16:
            r4 = (((double) (r1 / WebcastRedirectException.UNKNOWN)) / 10.0d) + "万+";
            goto L17
        L14:
            if (9999 < r1) goto L16;
            StringBuilder r5 = new StringBuilder();
            r5.append((r1 / 100) * 100);
            r5.append('+');
            r4 = r5.toString();
            goto L17
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LotteryIconModel a;

        public c(LotteryIconModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LotteryIconModel r0 = this.a;
            r0.moveToState((g3.a) r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void onDestroy() {
        this.i = null;
        this.s.getDataCenter().put("data_lottery_interest_count", 0L);
        LinkedHashMap<String, String> r0 = LotteryTraceMonitor.a;
        LinkedHashMap<String, String> r1 = LotteryTraceMonitor.a;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNull(r1);
        if (r1.size() <= 0) goto L9;
        r1.clear();
        return;
    L9:
        return;
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void g() {
        bindModel(this.n.subscribe(new c(this)));
        com.bytedance.android.live.core.arch.mvvm.f.b(this.q.c).subscribe(this.n);
        g3 r0 = this.q;
        bindModel(com.bytedance.android.live.core.arch.mvvm.f.b(r0.e).subscribe(new y0(this)));
        bindModel(com.bytedance.android.live.core.arch.mvvm.f.b(r0.g).subscribe(new z0(this)));
        bindModel(this.m.subscribe(new a1(this)));
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void onHideTempState() {
        xr2.g r0 = this.i;
        if (r0 == null) goto L5;
        r0.removeTempView();
    L5:
        this.j = true;
    }

    public final void onStart() {
        this.r.D9(LotteryIconModel.class, new AnonymousClass1(this));
    }

    public final void onClick() {
        g3.a r0 = getCurrentState();
        boolean r2 = true;
        if ((r0 instanceof g3.a.b) == false) goto L37;
        boolean r5 = this.s.isAnchor();
        t r6 = ((g3.a.b) r0).a;
        ParticipateStatus r7 = (ParticipateStatus) this.p.getCurCandidateState().getValue();
        Lottery r1 = (Lottery) this.p.getCurrentLottery().getValue();
        Object r3 = null;
        if (r1 == null) goto L7;
        LotteryState r8 = r1.getState();
    L8:
        Intrinsics.checkNotNullParameter(this, "$this$logClickLottery");
        Intrinsics.checkNotNullParameter(r6, "curStateInfo");
        Intrinsics.checkNotNullParameter(r7, "participateStatus");
        yz0.k r9 = this.s;
        i.B0.getClass();
        e3.d(r5, r6, r7, r8, r9, 0);
        IGiftService r4 = jc1.k.f(IGiftService.class);
        if (r4 == null) goto L13;
        ca0.o r10 = r4.getLiveRevenueEventCenter();
        if (r10 == null) goto L13;
        r10.e();
    L13:
        int r12 = this.h;
        if (r12 != 0) goto L16;
        com.bytedance.android.live.profit.util.e.a(this.o, com.bytedance.android.live.profit.util.m.a);
        goto L37
    L16:
        l2 r13 = this.o;
        int r14 = com.bytedance.android.live.profit.util.m.a;
        String r15 = String.valueOf(r12);
        long r16 = getTempShowTime(this.h);
        String r17 = this.f;
        String r18 = this.g;
        Map<Integer, String> r19 = com.bytedance.android.live.profit.util.e.a;
        Intrinsics.checkNotNullParameter(r13, "scope");
        Intrinsics.checkNotNullParameter(r15, "strategyId");
        Intrinsics.checkNotNullParameter(r17, "benefit");
        Intrinsics.checkNotNullParameter(r18, "extraMessage");
        com.bytedance.android.livesdk.revenue.service.sti.a r20 = (com.bytedance.android.livesdk.revenue.service.sti.a) com.bytedance.android.scope.m.e.d(r13, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r20 == null) goto L37;
        if (r20.f() == false) goto L37;
        Iterator r110 = r20.X8().getIcons().iterator();
    L24:
        if (r110.hasNext() == false) goto L31;
        Object r111 = r110.next();
        if (((xr2.i) r111).a != r14) goto L28;
        boolean r112 = true;
    L29:
        if (r112 == false) goto L24;
        r3 = r111;
        goto L31
    L28:
        r112 = false;
    L31:
        xr2.i r22 = (xr2.i) r3;
        if (r22 == null) goto L37;
        String r23 = com.bytedance.android.live.profit.util.e.a.get(Integer.valueOf(r22.a));
        if (r23 != null) goto L36;
        r23 = "";
    L36:
        r20.On(String.valueOf(r14), r23, r15, r16 / ((long) WebcastRedirectException.UNKNOWN), MapsKt.mutableMapOf(new Pair[]{new Pair("temp_benefit", r17), new Pair("temp_extra_message", r18)}));
        goto L37
    L7:
        r8 = null;
    L37:
        int r24 = this.h;
        if (r24 != LotteryTempStatusStrategy.STRATEGY_ENTER.getStrategyNum()) goto L40;
    L45:
        if (r2 == true) goto L47;
    L49:
        com.bytedance.live.datacontext.k<Integer> r25 = this.p.getOnIconClick();
        i.B0.getClass();
        r25.post(0);
        return;
    L47:
        if (w2.a() == false) goto L49;
        showNormalState();
        com.bytedance.live.datacontext.k<Integer> r26 = this.p.getOnIconClick();
        i.B0.getClass();
        r26.post(0);
        return;
    L40:
        if (r24 == LotteryTempStatusStrategy.STRATEGY_INTEREST.getStrategyNum()) goto L45;
        if (r24 == LotteryTempStatusStrategy.STRATEGY_BEHAVIOR.getStrategyNum()) goto L45;
        r2 = false;
        goto L45
    }

    public final xr2.h getViewForState(Object r12) {
        g3.a r13 = (g3.a) r12;
        Intrinsics.checkNotNullParameter(r13, "state");
        ALogger.i("HOT_LOTTERY", "getViewForState time = " + System.currentTimeMillis());
        String r1 = null;
        if ((r13 instanceof g3.a.b) == false) goto L58;
        g3.a.b r14 = (g3.a.b) r13;
        if (r14.b == false) goto L35;
        xr2.b r15 = createIconTemplate(xr2.b.class);
        xr2.h r0 = getCurrentView();
        if ((r0 instanceof xr2.a) == true) goto L9;
        r0 = null;
    L9:
        xr2.a r2 = (xr2.a) r0;
        if (r2 == null) goto L12;
        String r3 = r2.getLabel();
    L13:
        HSImageView r4 = new HSImageView(getContext());
        GenericDraweeHierarchyBuilder r5 = GenericDraweeHierarchyBuilder.newInstance(getContext().getResources()).setFadeDuration(0);
        xr2.h r6 = getCurrentView();
        if (r6 == null) goto L16;
        View r7 = r6.getView();
    L17:
        if (r7 == null) goto L28;
        int r8 = r7.getMeasuredWidth();
        int r9 = r7.getMeasuredHeight();
        if (r8 <= 0) goto L28;
        if (r9 <= 0) goto L28;
        Bitmap r10 = Bitmap.createBitmap(r8, r9, Bitmap.Config.ARGB_8888);
        Canvas r16 = new Canvas(r10);
        if (r2 == null) goto L24;
        r2.setLabel(null);
    L24:
        r7.layout(0, 0, r10.getWidth(), r10.getHeight());
        r7.draw(r16);
        if (r2 == null) goto L27;
        r2.setLabel(r3);
    L27:
        r5.setPlaceholderImage(new BitmapDrawable(getContext().getResources(), r10));
        r15.setBackgroundEnabled(false);
    L28:
        r4.setHierarchy(r5.build());
        Unit r17 = Unit.INSTANCE;
        r15.setContentView(r4);
        xr2.h r18 = getCurrentView();
        if ((r18 instanceof xr2.a) == true) goto L31;
        r18 = null;
    L31:
        xr2.a r19 = (xr2.a) r18;
        if (r19 == null) goto L34;
        r1 = r19.getLabel();
    L34:
        r15.setLabel(r1);
        return r15;
    L16:
        r7 = null;
        goto L17
    L12:
        r3 = null;
        goto L13
    L35:
        x2 r20 = f3.a;
        t r22 = r14.a;
        if (r22 == null) goto L38;
        Integer r23 = Integer.valueOf(r22.d);
    L40:
        if (f3.b(String.valueOf(r23.intValue())) != true) goto L53;
        x2 r110 = f3.a;
        if (r110 == null) goto L60;
        xr2.g r24 = this.i;
        if (r24 != null) goto L62;
        xr2.g r25 = createIconTemplate(xr2.g.class);
        FrameLayout.LayoutParams r26 = new FrameLayout.LayoutParams(com.bytedance.android.live.core.utils.s1.f(35.0f), com.bytedance.android.live.core.utils.s1.f(40.0f));
        HSImageView r27 = new HSImageView(getContext());
        r27.setLayoutParams(r26);
        Unit r28 = Unit.INSTANCE;
        u0 r111 = r110.iconConfig;
        if (r111 == null) goto L51;
        String r112 = r111.smallCardImage;
        if (r112 == null) goto L51;
        com.bytedance.android.livesdk.chatroom.utils.a1.n(r27, r112);
    L51:
        r25.setContentView(r27);
        r25.setContentRightMargin(com.bytedance.android.live.revenue.common.i.b(6));
        r25.setContentTopMargin(com.bytedance.android.live.revenue.common.i.b(5));
        this.i = r25;
        return r25;
    L62:
        return r24;
    L60:
        return null;
    L53:
        if (c1.a(r14.a) == false) goto L55;
        int r113 = 2131252193;
    L56:
        xr2.g r29 = createIconTemplate(xr2.g.class);
        r29.setContentView(imageViewOf(r113, 35.0f, 40.0f));
        r29.setContentRightMargin(com.bytedance.android.live.revenue.common.i.b(6));
        r29.setContentTopMargin(com.bytedance.android.live.revenue.common.i.b(5));
        this.i = r29;
        return r29;
    L55:
        r113 = 2131252297;
        goto L56
    L38:
        r23 = null;
        goto L40
    L58:
        return null;
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void onShowTempState(int r18) {
        g3.a r2 = getCurrentState();
        m3 r4 = null;
        if ((r2 instanceof g3.a.b) == true) goto L5;
        r2 = null;
    L5:
        g3.a.b r3 = (g3.a.b) r2;
        if (r3 == null) goto L8;
        t r5 = r3.a;
    L9:
        x2 r6 = f3.a;
        if (r5 == null) goto L12;
        int r7 = r5.d;
    L14:
        if (f3.b(String.valueOf(r7)) == true) goto L16;
    L19:
        if (r5 == null) goto L21;
        long r8 = r5.c - System.currentTimeMillis();
    L23:
        if (r8 <= 5) goto L25;
        boolean r9 = true;
    L26:
        if (r9 == false) goto L105;
        if (r5 != null) goto L29;
    L30:
        if (r5 == null) goto L32;
        int r10 = r5.d;
    L33:
        String r12 = String.valueOf(r10);
        Intrinsics.checkNotNullParameter(r12, "lotteryType");
        HashMap<String, x2> r13 = f3.b;
        if (r13.get(r12) == null) goto L41;
        x2 r14 = r13.get(r12);
        if (r14 == null) goto L38;
        l3 r15 = r14.tempStateConfig;
    L39:
        if (r15 == null) goto L41;
        boolean r16 = true;
    L42:
        if (r16 != true) goto L105;
    L43:
        xr2.g r17 = this.i;
        if (r17 != null) goto L46;
    L104:
        changeTempWidth();
        this.j = false;
        return;
    L46:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L48;
        int r19 = ToastUtil.a;
        ToastUtil.b("策略" + r18 + "触发", 0);
    L48:
        int r20 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("LotteryIconModel", "on show strategy" + r18);
        this.h = r18;
        if (r5 == null) goto L51;
        int r22 = r5.d;
    L53:
        if (f3.b(String.valueOf(r22)) != true) goto L97;
        r17.setTempShortTermView(LayoutInflater.from(getContext()).inflate(2131567769, null));
        View r23 = r17.getTempShortTermView();
        if ((r23 instanceof ViewGroup) == true) goto L57;
        r23 = null;
    L57:
        ViewGroup r24 = (ViewGroup) r23;
        if (r24 == null) goto L104;
        TextView r25 = (TextView) r24.findViewById(2131391077);
        TextView r26 = (TextView) r24.findViewById(2131390479);
        x2 r27 = f3.a;
        String r28 = "";
        if (((ParticipateStatus) this.p.getCurCandidateState().getValue()) != ParticipateStatus.PARTICIPATEINSUCCESS) goto L78;
        if (r27 == null) goto L65;
        l3 r29 = r27.tempStateConfig;
        if (r29 == null) goto L65;
        r4 = r29.doneText;
    L65:
        if (r25 == null) goto L72;
        if (r4 == null) goto L70;
        String r30 = r4.title;
        if (r30 == null) goto L70;
    L71:
        r25.setText(r30);
    L70:
        r30 = "";
    L72:
        if (r26 == null) goto L95;
        if (r4 == null) goto L77;
        String r32 = r4.desc;
        if (r32 == null) goto L77;
        r28 = r32;
    L77:
        r26.setText(r28);
    L95:
        com.bytedance.android.live.profit.util.e.c(this.o, com.bytedance.android.live.profit.util.m.a, String.valueOf(r18), getTempShowTime(r18), this.f, this.g);
        goto L104
    L78:
        if (r27 == null) goto L82;
        l3 r33 = r27.tempStateConfig;
        if (r33 == null) goto L82;
        r4 = r33.doingText;
    L82:
        if (r25 == null) goto L89;
        if (r4 == null) goto L87;
        String r34 = r4.title;
        if (r34 == null) goto L87;
    L88:
        r25.setText(r34);
    L87:
        r34 = "";
    L89:
        if (r26 == null) goto L95;
        if (r4 == null) goto L94;
        String r35 = r4.desc;
        if (r35 == null) goto L94;
        r28 = r35;
    L94:
        r26.setText(r28);
        goto L95
    L97:
        if (w2.a() == true) goto L99;
        if (r5 == null) goto L104;
        h(r17, r5, r18);
        goto L104
    L99:
        if (this.j == false) goto L104;
        if (r5 == null) goto L104;
        h(r17, r5, r18);
        goto L104
    L51:
        r22 = 0;
        goto L53
    L38:
        r15 = null;
    L41:
        r16 = false;
        goto L42
    L32:
        r10 = 0;
        goto L33
    L29:
        if (r5.d == 1) goto L43;
    L105:
        showNormalState();
        return;
    L25:
        r9 = false;
        goto L26
    L21:
        r8 = 0;
        goto L23
    L16:
        if (this.s.isAnchor() == false) goto L19;
        showNormalState();
        return;
    L12:
        r7 = 0;
        goto L14
    L8:
        r5 = null;
        goto L9
    }

    public final IRevIconModel.a getEntryViewForState(Object r7, Object r8) {
        g3.a r9 = (g3.a) r7;
        g3.a r10 = (g3.a) r8;
        Intrinsics.checkNotNullParameter(r9, "state");
        if ((r9 instanceof g3.a.b) == false) goto L27;
        x2 r12 = f3.a;
        g3.a.b r13 = (g3.a.b) r9;
        t r14 = r13.a;
        if (r14 == null) goto L7;
        Integer r15 = Integer.valueOf(r14.d);
    L9:
        if (f3.b(String.valueOf(r15.intValue())) != true) goto L22;
        x2 r16 = f3.a;
        if (r16 == null) goto L28;
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(com.bytedance.android.live.core.utils.s1.f(88.0f), com.bytedance.android.live.core.utils.s1.f(110.0f));
        HSImageView r0 = new HSImageView(getContext());
        r0.setLayoutParams(r17);
        GenericDraweeHierarchy r18 = r0.getHierarchy();
        if (r18 == null) goto L15;
        r18.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
    L15:
        u0 r19 = r16.iconConfig;
        if (r19 == null) goto L29;
        String r20 = r19.bigCardImage;
        if (r20 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.utils.a1.n(r0, r20);
    L29:
        return new IRevIconModel.a(r0, 0, 6);
    L28:
        return null;
    L22:
        if (c1.a(r13.a) == false) goto L24;
        int r22 = 2131252193;
    L26:
        return new IRevIconModel.a(imageViewOf(r22, 88.0f, 96.0f), 0, 6);
    L24:
        r22 = 2131252298;
        goto L26
    L7:
        r15 = null;
        goto L9
    L27:
        return null;
    }

    public final void c(Object r17, Object r18, final xr2.h r19) {
        g3.a r8 = (g3.a) r17;
        g3.a r9 = (g3.a) r18;
        Intrinsics.checkNotNullParameter(r9, "curState");
        if ((r9 instanceof g3.a.b) == false) goto L25;
        this.m.onNext(Boolean.valueOf(this.s.isAnchor()));
        if (w2.c() == false) goto L7;
    L9:
        StringBuilder r0 = new StringBuilder("显示倒计时 time = ");
        g3.a.b r1 = (g3.a.b) r9;
        r0.append(r1.a.c - System.currentTimeMillis());
        r0.append("   current = ");
        r0.append(System.currentTimeMillis());
        ALogger.i("HOT_LOTTERY", r0.toString());
        ALogger.i("HOT_LOTTERY", "本地开奖时间 time = " + r1.a.c + "   current = " + System.currentTimeMillis());
        startCountDown(r1.a.c - System.currentTimeMillis(), null, null, null);
    L10:
        bindModel(getCountDownObservable().subscribe(new x0(this)));
        g3.a.b r10 = (g3.a.b) r9;
        if (r10.b == false) goto L22;
        if ((r19 instanceof xr2.b) == false) goto L22;
        HSImageView r2 = ((xr2.b) r19).getContentView();
        if ((r2 instanceof HSImageView) == false) goto L20;
        HSImageView r3 = r2;
        PipelineDraweeControllerBuilder r4 = Fresco.newDraweeControllerBuilder();
        String r5 = (String) w2.c.getValue(null, w2.a[1]);
        if (r5 != null) goto L19;
        r5 = "";
    L19:
        r3.setController(r4.setUri(UriProtector.parse(r5)).setControllerListener(com.bytedance.android.live.profit.util.k.a(new LotteryIconModel$applyState$1(r19), new LotteryIconModel$applyState$2(this), true, 4)).build());
        r3.getHierarchy();
    L20:
        ObjectAnimator r6 = ObjectAnimator.ofFloat((xr2.a) r19, "templateAlpha", new float[]{1.0f, 0.0f});
        r6.setStartDelay(5000);
        r6.setDuration(400);
        r6.start();
        Unit r7 = Unit.INSTANCE;
        bindState(RxUtilKt.a(r6, false));
    L22:
        if ((r8 instanceof g3.a.b) == true) goto L33;
        boolean r12 = this.s.isAnchor();
        t r13 = r10.a;
        ParticipateStatus r14 = (ParticipateStatus) this.p.getCurCandidateState().getValue();
        Intrinsics.checkNotNullParameter(this, "$this$logLotteryShow");
        Intrinsics.checkNotNullParameter(r13, "curStateInfo");
        Intrinsics.checkNotNullParameter(r14, "participateStatus");
        mz0.n r15 = new mz0.n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        yz0.k r110 = this.s;
        i.B0.getClass();
        Map<String, String> r20 = e3.a(r12, r13, r14, null, r110, 0);
        Intrinsics.checkNotNullParameter(r20, "map");
        r16.putAll(r20);
        e3.e(new mz0.o(r15.a), r13.i);
        mz0.m r22 = new mz0.m();
        r22.b(LogCommon.ROOM);
        r22.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r15.b).addAll(r22.a);
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r24);
        ((mz0.i) ((f80.a) r24)).w3("lottery_show", r15.a, r15.b);
        com.bytedance.android.live.profit.util.e.b(this.o, com.bytedance.android.live.profit.util.m.a);
        return;
    L33:
        return;
    L7:
        if (((g3.a.b) r9).c == false) goto L9;
        showNormalState();
        this.h = 0;
        goto L10
    L25:
        if ((r9 instanceof g3.a.C0033a) == false) goto L35;
        showNormalState();
        this.h = 0;
        this.i = null;
        if (w2.a() == true) goto L29;
    L31:
        bindState(RxUtilKt.d(5000, 1000).filter(v0.a).take(1).subscribe(new w0(this)));
        return;
    L29:
        if (this.s.isAnchor() == true) goto L31;
        this.s.getDataCenter().put("data_lottery_interest_count", 0L);
        goto L31
    }

    public final void h(xr2.g r19, final t r20, final int r22) {
        View r2 = null;
        r19.setTempShortTermView(LayoutInflater.from(getContext()).inflate(2131567770, null));
        View r0 = r19.getTempShortTermView();
        if ((r0 instanceof ViewGroup) == false) goto L6;
        r2 = r0;
    L6:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L18;
        TextView r1 = (TextView) r3.findViewById(2131391077);
        final TextView r9 = (TextView) r3.findViewById(2131390479);
        final TextView r10 = (TextView) r3.findViewById(2131391017);
        bindModel(this.l.subscribe(new b(r1, r9, r10, this, r20, r22)));
        if (this.k == true) goto L11;
    L16:
        i(r9, r10, r20.e);
        com.bytedance.android.live.profit.util.e.c(this.o, com.bytedance.android.live.profit.util.m.a, String.valueOf(r22), getTempShowTime(r22), this.f, this.g);
        return;
    L11:
        if (r22 != LotteryTempStatusStrategy.STRATEGY_HOST.getStrategyNum()) goto L16;
        final Ref.BooleanRef r4 = new Ref.BooleanRef();
        r4.element = false;
        r9.setText(com.bytedance.android.live.core.utils.s1.B(2131920151));
        String r5 = this.s.getRoom().getAnchorId();
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        com.bytedance.android.livesdk.revenue.service.user.a r12 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        IBaseUser r6 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b();
        Ref.LongRef r15 = new Ref.LongRef();
        r15.element = 0;
        Ref.IntRef r14 = new Ref.IntRef();
        r14.element = 0;
        Ref.IntRef r7 = new Ref.IntRef();
        r7.element = 0;
        HashMap r13 = new HashMap();
        r13.put("target_uid", r6.getIdString());
        r13.put("request_from", "short_touch_temp_status");
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        r13.put("sec_target_uid", r6.getCastSecUid());
        r13.put("anchor_id", r5);
        com.bytedance.android.live.core.utils.rxutils.j.a r8 = com.bytedance.android.live.core.utils.rxutils.j.a;
        bindState(RxUtilKt.p(RxUtilKt.h(com.bytedance.android.live.core.utils.rxutils.j.c(2, TimeUnit.SECONDS).flatMap(new com.bytedance.android.live.profit.util.j(r12, r13, r14, r15, r7))), "LotteryIconModel", new LotteryIconModel$handleNomalLotteryView$$inlined$apply$lambda$2(r10, r4, r9, this, r20, r22)));
        return;
    }

    public final void i(TextView r4, TextView r5, long r6) {
        r4.setText(com.bytedance.android.live.core.utils.s1.B(2131920156));
        Object[] r0 = new Object[2];
        r0[0] = String.valueOf(r6);
        int r1 = r3.a;
        if (((CoinConfig) j40.m.a.getValue()).isNew() == false) goto L5;
        String r2 = r3.b();
    L6:
        r0[1] = r2;
        r5.setText(com.bytedance.android.live.core.utils.s1.C(2131920157, r0));
        if (w2.b() == false) goto L16;
        g3.a r3 = getCurrentState();
        if ((r3 instanceof g3.a.b) == true) goto L11;
        r3 = null;
    L11:
        g3.a.b r7 = (g3.a.b) r3;
        if (r7 == null) goto L16;
        t r8 = r7.a;
        if (r8 == null) goto L16;
        r8.e = r6;
    L16:
        this.f = r4.getText().toString() + r5.getText().toString();
        return;
    L5:
        r2 = "抖";
        goto L6
    }

    public LotteryIconModel(l2 r3, LotteryContext r4, g3 r5, c01.a r6, yz0.k r7) {
        Intrinsics.checkNotNullParameter(r3, "lotteryScope");
        Intrinsics.checkNotNullParameter(r4, "lotteryContext");
        Intrinsics.checkNotNullParameter(r5, "lotteryViewModel");
        Intrinsics.checkNotNullParameter(r6, "stiService");
        Intrinsics.checkNotNullParameter(r7, "roomDataService");
        super(g3.a.C0033a.a, RevStiElementType.Lottery.getTypeId());
        this.o = r3;
        this.p = r4;
        this.q = r5;
        this.r = r6;
        this.s = r7;
        this.f = "";
        this.g = "";
        this.j = true;
        this.l = BehaviorSubject.create();
        this.m = BehaviorSubject.create();
        int r8 = StateBuffer.d;
        this.n = StateBuffer.Companion.a(LotteryIconModel$stateBuffer$1.INSTANCE);
    }
}
