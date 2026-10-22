package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import zg1.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l extends y81.b {
    public static final /* synthetic */ int U = 0;
    public TextSwitcher A;
    public TextSwitcher B;
    public TextSwitcher C;
    public TextSwitcher D;
    public TextSwitcher E;
    public TextSwitcher F;
    public TextView G;
    public TextSwitcher H;
    public String I;
    public List<TextSwitcher> J;
    public Disposable K;
    public final CompositeDisposable L;
    public Dialog M;
    public int N;
    public IRoom O;
    public Integer P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public final int j;
    public ViewGroup k;
    public ViewGroup l;
    public ViewGroup m;
    public ViewGroup n;
    public HSImageView o;
    public TextSwitcher p;
    public TextView q;
    public b r;
    public final List<String> s;
    public RelativeLayout t;
    public StrokeTextView u;
    public LottieAnimationView v;
    public ValueAnimator w;
    public ValueAnimator x;
    public ValueAnimator y;
    public View z;

    public static final class a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ l a;

        @Override // android.os.Handler
        public final void handleMessage(Message r9) {
            Intrinsics.checkNotNullParameter(r9, Constants.OperatorKey.MSG);
            super.handleMessage(r9);
            int r10 = r9.what;
            if (r10 == 1) goto L26;
            if (r10 != 2) goto L6;
            l r12 = this.a;
            ValueAnimator r3 = r12.w;
            if (r3 == null) goto L14;
            r3.cancel();
        L14:
            r12.w = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            Ref.IntRef r4 = new Ref.IntRef();
            r4.element = 0;
            ValueAnimator r5 = r12.w;
            if (r5 == null) goto L17;
            r5.addListener(new x(r12, r4));
            r5.addUpdateListener(new y(r5, r12, r4));
            r5.setDuration(200);
            r5.start();
        L17:
            ValueAnimator r6 = r12.y;
            if (r6 == null) goto L20;
            r6.cancel();
        L20:
            ValueAnimator r0 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#26000000")), Integer.valueOf(ColorProtector.parseColor("#80ff356f"))});
            r12.y = r0;
            if (r0 == null) goto L23;
            r0.addListener(new z(r12));
            r0.addUpdateListener(new a0(r0, r12));
            r0.setDuration(200);
        L23:
            ValueAnimator r13 = r12.y;
            if (r13 == null) goto L48;
            r13.start();
            return;
        L48:
            return;
        L6:
            if (r10 != 3) goto L54;
            l r14 = this.a;
            if (r14.S == true) goto L46;
            r14.o();
            return;
        L46:
            return;
        L54:
            return;
        L26:
            List<String> r15 = this.a.s;
            if (r15 != null) goto L29;
        L33:
            b r16 = this.a.r;
            if (r16 == null) goto L36;
            r16.sendEmptyMessageDelayed(1, 2000);
        L36:
            l r17 = this.a;
            TextSwitcher r1 = r17.p;
            if (r1 == null) goto L52;
            List<String> r18 = r17.s;
            if (r18 == null) goto L41;
            String r19 = (String) CollectionsKt.firstOrNull(r18);
        L42:
            r1.setText(r19);
            List<String> r20 = this.a.s;
            if (r20 == null) goto L53;
            String r22 = (String) ListProtector.remove(r20, 0);
            return;
        L53:
            return;
        L41:
            r19 = null;
            goto L42
        L52:
            return;
        L29:
            if (((ArrayList) r15).isEmpty() != true) goto L33;
            b r23 = this.a.r;
            if (r23 == null) goto L50;
            r23.sendEmptyMessage(2);
            return;
        }

        public b(l r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ l a;

        public c(l r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r23) {
            l r1 = this.a;
            String r2 = (String) LiveInfraSettingKeys.DOU_PLUS_INDICATOR_DATA_URL.getValue();
            IRoom r3 = this.a.O;
            if (r3 == null) goto L5;
            Long r4 = Long.valueOf(r3.getId());
        L6:
            IRoom r5 = this.a.O;
            if (r5 == null) goto L12;
            IBaseUser r6 = r5.getOwner();
            if (r6 == null) goto L12;
            Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
            String r7 = r6.getCastSecUid();
            if (r7 == null) goto L12;
        L13:
            r1.getClass();
            if (com.bytedance.android.live.core.utils.a.d() != null) goto L16;
        L36:
            Object r19 = "dou_plus_order_type";
        L37:
            ILiveDouPlusService r8 = jc1.k.n(ILiveDouPlusService.class);
            HashMap r9 = new HashMap();
            r9.put("target_step", DataType.FALSE);
            if (((Boolean) this.a.f.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L40;
            Object r10 = "my_group";
        L41:
            r9.put("dou_plus_serving_type", r10);
            r9.put("dou_plus_medium", "live_indicator");
            r9.put("dou_plus_entrance_type", DataType.FALSE);
            r9.put("dou_plus_entrance_level", DataType.TRUE);
            r9.put("dou_plus_referer", "live");
            r9.put(r19, "live");
            r8.logEvent(false, "click_dou_plus", "", r9);
            return;
        L40:
            r10 = "other_group";
            goto L41
        L16:
            if (TextUtils.isEmpty(r2) == true) goto L36;
            Uri.Builder r12 = UriProtector.parse(r2).buildUpon().appendQueryParameter("entrance_type", "live_play").appendQueryParameter("enter_from", "live_play");
            if (r4 == null) goto L21;
            String r13 = String.valueOf(r4.longValue());
        L22:
            Uri.Builder r14 = r12.appendQueryParameter("room_id", r13).appendQueryParameter("sec_anchor_id", r7).appendQueryParameter("is_in_live", DataType.TRUE);
            if (((Boolean) r1.f.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L25;
            String r15 = "my_group";
        L26:
            Uri.Builder r16 = r14.appendQueryParameter("dou_plus_serving_type", r15).appendQueryParameter("dou_plus_medium", "live_indicator").appendQueryParameter("dou_plus_entrance_type", DataType.FALSE).appendQueryParameter("dou_plus_entrance_level", DataType.TRUE).appendQueryParameter("dou_plus_referer", "live").appendQueryParameter("dou_plus_order_type", "live");
            if (PadConfigUtils.c() == false) goto L29;
        L30:
            r16.appendQueryParameter("is_pad", DataType.TRUE);
        L31:
            q r17 = new q(r1);
            r19 = "dou_plus_order_type";
            HashMap r18 = new HashMap();
            r18.put("is_live", DataType.TRUE);
            r18.put("scene", "dou_plus");
            r18.put("sec_anchor_id", r7);
            ILiveMode r20 = (ILiveMode) r1.f.get("data_live_mode", LiveMode.VIDEO);
            int r22 = h1.a;
            r18.put("live_type", i1.a(r20));
            ILiveDouPlusService r24 = jc1.k.f(ILiveDouPlusService.class);
            if (r24 == null) goto L34;
            Dialog r25 = r24.showDouPlusDialog(ContextUtil.contextToFragmentActivity(com.bytedance.android.live.core.utils.a.d()), r18, r16.build().toString(), r17);
        L35:
            r1.M = r25;
            goto L37
        L34:
            r25 = null;
            goto L35
        L29:
            if (FoldScreenUtils.e() == false) goto L31;
        L25:
            r15 = "other_group";
            goto L26
        L21:
            r13 = null;
        L12:
            r7 = "";
            goto L13
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ l a;

        public d(l r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            w1 r8 = (w1) r7;
            Dialog r0 = this.a.M;
            if (r0 == null) goto L12;
            IRoomContextService r1 = jc1.k.n(IRoomContextService.class);
            l r2 = this.a;
            DataCenter r3 = r2.f;
            IRoom r4 = r2.O;
            if (r4 == null) goto L7;
            long r5 = r4.getId();
        L8:
            com.bytedance.android.livesdk.chatroom.r r6 = r1.getRoomExpService(r3, r5);
            if (r6 == null) goto L13;
            r6.o(r0, r8.b);
            return;
        L13:
            return;
        L7:
            r5 = 0;
            goto L8
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ l a;
        public final /* synthetic */ Ref.IntRef b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationCancel(r2);
            StrokeTextView r3 = this.a.u;
            if (r3 == null) goto L6;
            r3.setGravity(1);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            l r5 = this.a;
            LottieAnimationView r0 = r5.v;
            if (r0 != null) goto L5;
            l.l(r5);
        L6:
            b r6 = this.a.r;
            if (r6 == null) goto L9;
            r6.sendEmptyMessageDelayed(1, 4000);
        L9:
            StrokeTextView r7 = this.a.u;
            if (r7 == null) goto L13;
            r7.setGravity(1);
            return;
        L13:
            return;
        L5:
            r0.playAnimation();
            goto L6
        }

        public e(l r1, Ref.IntRef r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ViewGroup r4 = this.a.n;
            if (r4 == null) goto L5;
            r4.setVisibility(8);
        L5:
            TextSwitcher r5 = this.a.H;
            if (r5 == null) goto L8;
            r5.setVisibility(8);
        L8:
            View r6 = this.a.z;
            if (r6 == null) goto L11;
            r6.setVisibility(8);
        L11:
            HSImageView r7 = this.a.o;
            if (r7 == null) goto L14;
            r7.setVisibility(8);
        L14:
            TextSwitcher r8 = this.a.p;
            if (r8 == null) goto L17;
            r8.setVisibility(0);
        L17:
            TextView r9 = this.a.q;
            if (r9 == null) goto L20;
            r9.setVisibility(0);
        L20:
            Ref.IntRef r10 = this.b;
            ViewGroup r0 = this.a.k;
            if (r0 == null) goto L23;
            int r1 = r0.getWidth();
        L24:
            r10.element = r1;
            l r12 = this.a;
            TextSwitcher r13 = r12.p;
            if (r13 == null) goto L33;
            List<String> r14 = r12.s;
            if (r14 == null) goto L29;
            String r15 = (String) CollectionsKt.firstOrNull(r14);
        L30:
            r13.setCurrentText(r15);
            List<String> r16 = this.a.s;
            if (r16 == null) goto L33;
            String r17 = (String) ListProtector.remove(r16, 0);
            goto L33
        L29:
            r15 = null;
        L33:
            StrokeTextView r18 = this.a.u;
            if (r18 == null) goto L37;
            r18.setGravity(8388611);
            return;
        L37:
            return;
        L23:
            r1 = 0;
            goto L24
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ l b;
        public final /* synthetic */ Ref.IntRef c;

        public f(ValueAnimator r1, l r2, Ref.IntRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r7) {
            Intrinsics.checkNotNullParameter(r7, "<anonymous parameter 0>");
            Object r8 = this.a.getAnimatedValue();
            if (r8 == null) goto L19;
            float r9 = ((Float) r8).floatValue();
            ViewGroup r0 = this.b.l;
            if (r0 == null) goto L9;
            float r3 = 52;
            if (this.c.element <= UtilityKotlinExtentionsKt.h(r3)) goto L9;
            ViewGroup.LayoutParams r2 = r0.getLayoutParams();
            r2.width = ((int) ((this.c.element - UtilityKotlinExtentionsKt.h(r3)) * r9)) + ((int) UtilityKotlinExtentionsKt.h(r3));
            r0.setLayoutParams(r2);
        L9:
            RelativeLayout r1 = this.b.t;
            if (r1 == null) goto L14;
            float r4 = 52;
            if (this.c.element <= UtilityKotlinExtentionsKt.h(r4)) goto L14;
            ViewGroup.LayoutParams r5 = r1.getLayoutParams();
            r5.width = (int) ((this.c.element - UtilityKotlinExtentionsKt.h(r4)) * (1 - r9));
            r1.setLayoutParams(r5);
        L14:
            l r6 = this.b;
            r6.r(r6.t, 1 - r9);
            l r10 = this.b;
            float r12 = 3 * r9;
            r10.r(r10.q, r12);
            TextSwitcher r13 = this.b.p;
            if (r13 == null) goto L20;
            r13.setAlpha(r12);
            return;
        L20:
            return;
        L19:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class g extends AnimatorListenerAdapter {
        public final /* synthetic */ l a;

        public g(l r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            l r5 = this.a;
            l.k(r5, r5.l, ColorProtector.parseColor("#29FF356F"), ColorProtector.parseColor("#80FF356F"));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            l r5 = this.a;
            l.k(r5, r5.l, ColorProtector.parseColor("#29FF356F"), ColorProtector.parseColor("#29FF356F"));
        }
    }

    public static final class h implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ l b;

        public h(ValueAnimator r1, l r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = this.a.getAnimatedValue();
            if (r5 == null) goto L7;
            int r6 = ((Integer) r5).intValue();
            l r0 = this.b;
            l.k(r0, r0.l, ColorProtector.parseColor("#29FF356F"), r6);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class i extends AnimatorListenerAdapter {
        public final /* synthetic */ l a;

        public i(l r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            l r5 = this.a;
            l.k(r5, r5.l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#80ff356f"));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            l r5 = this.a;
            l.k(r5, r5.l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
        }
    }

    public static final class j implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ l b;

        public j(ValueAnimator r1, l r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = this.a.getAnimatedValue();
            if (r5 == null) goto L7;
            int r6 = ((Integer) r5).intValue();
            l r0 = this.b;
            l.k(r0, r0.l, ColorProtector.parseColor("#26000000"), r6);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class k extends AnimatorListenerAdapter {
        public final /* synthetic */ l a;

        public k(l r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            l r5 = this.a;
            r5.r(r5.m, 1.0f);
            l r6 = this.a;
            r6.T = false;
            r6.R = 10;
            List<String> r7 = r6.s;
            if (r7 != null) goto L5;
            return;
        L5:
            if (((ArrayList) r7).isEmpty() == true) goto L11;
            b r8 = this.a.r;
            if (r8 == null) goto L12;
            r8.sendEmptyMessageDelayed(3, 1000);
            return;
        L12:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            l r5 = this.a;
            r5.T = false;
            r5.R = 10;
            l.l(r5);
            Integer r6 = this.a.P;
            if (r6 != null) goto L6;
        L13:
            Integer r7 = this.a.P;
            if (r7 != null) goto L17;
        L21:
            List<String> r8 = this.a.s;
            if (r8 != null) goto L24;
            return;
        L24:
            if (((ArrayList) r8).isEmpty() == true) goto L30;
            b r9 = this.a.r;
            if (r9 == null) goto L31;
            r9.sendEmptyMessageDelayed(3, 1000);
            return;
        L31:
            return;
        L30:
            return;
        L17:
            if (r7.intValue() != 4) goto L21;
            TextSwitcher r10 = this.a.H;
            if (r10 == null) goto L21;
            r10.setCurrentText(s1.B(2131916253));
            goto L21
        L6:
            if (r6.intValue() != 1) goto L13;
            TextSwitcher r12 = this.a.H;
            if (r12 == null) goto L10;
            r12.setCurrentText(s1.B(2131916257));
        L10:
            l r13 = this.a;
            int r0 = r13.N;
            if (r0 <= 0) goto L21;
            r13.m(r0);
            goto L21
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ViewGroup r4 = this.a.m;
            if (r4 == null) goto L5;
            r4.setVisibility(0);
        L5:
            l r5 = this.a;
            r5.r(r5.m, 0.0f);
        }
    }

    /* JADX INFO: renamed from: y81.l$l, reason: collision with other inner class name */
    public static final class C0351l implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ l b;

        public C0351l(ValueAnimator r1, l r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            Object r4 = this.a.getAnimatedValue();
            if (r4 == null) goto L7;
            float r5 = ((Float) r4).floatValue();
            l r0 = this.b;
            r0.r(r0.m, r5);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public final void o() {
        i(1);
        this.L.clear();
        if (this.T == false) goto L6;
        this.S = false;
        return;
    L6:
        List<TextSwitcher> r1 = this.J;
        if (r1 == null) goto L22;
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L22;
        TextSwitcher r4 = (TextSwitcher) r2.next();
        if (r4 == null) goto L14;
        View r5 = r4.getCurrentView();
    L16:
        if ((r5 instanceof TextView) == false) goto L10;
        View r6 = r4.getCurrentView();
        if (r6 == null) goto L21;
        ((TextView) r6).setTextColor(s1.h(2131101254));
        goto L10
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L14:
        r5 = null;
    L22:
        TextView r3 = this.G;
        if (r3 == null) goto L25;
        r3.setTextColor(s1.h(2131101254));
    L25:
        this.S = true;
        ValueAnimator r7 = this.w;
        if (r7 == null) goto L28;
        r7.cancel();
    L28:
        this.w = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        Ref.IntRef r8 = new Ref.IntRef();
        r8.element = 0;
        ValueAnimator r9 = this.w;
        if (r9 == null) goto L31;
        r9.addListener(new e(this, r8));
        r9.addUpdateListener(new f(r9, this, r8));
        r9.setStartDelay(500);
        r9.setDuration(500);
        r9.start();
    L31:
        ValueAnimator r10 = this.y;
        if (r10 == null) goto L34;
        r10.cancel();
    L34:
        ValueAnimator r0 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#29FF356F")), Integer.valueOf(ColorProtector.parseColor("#80FF356F"))});
        this.y = r0;
        if (r0 == null) goto L37;
        r0.addListener(new g(this));
        r0.addUpdateListener(new h(r0, this));
        r0.setStartDelay(500);
        r0.setDuration(500);
    L37:
        ValueAnimator r12 = this.y;
        if (r12 == null) goto L47;
        r12.start();
        return;
    }

    public final void q() {
        this.Q = -1;
        this.N = 0;
        this.I = null;
        ValueAnimator r3 = this.y;
        if (r3 == null) goto L5;
        r3.cancel();
    L5:
        ValueAnimator r4 = this.w;
        if (r4 == null) goto L8;
        r4.cancel();
    L8:
        this.P = -1;
        this.R = 11;
        this.S = false;
        TextSwitcher r0 = this.H;
        if (r0 == null) goto L11;
        r0.setCurrentText("");
    L11:
        TextSwitcher r1 = this.p;
        if (r1 == null) goto L14;
        r1.setCurrentText("");
    L14:
        ViewGroup r2 = this.l;
        if (r2 == null) goto L17;
        r2.setVisibility(8);
    L17:
        j();
        this.L.clear();
        Disposable r5 = this.K;
        if (r5 == null) goto L20;
        r5.dispose();
    L20:
        LottieAnimationView r6 = this.v;
        if (r6 == null) goto L23;
        r6.setVisibility(8);
    L23:
        List<TextSwitcher> r7 = this.J;
        if (r7 == null) goto L41;
        Iterator<T> r8 = r7.iterator();
    L27:
        if (r8.hasNext() == false) goto L41;
        TextSwitcher r9 = (TextSwitcher) r8.next();
        if (r9 == null) goto L31;
        View r10 = r9.getCurrentView();
    L33:
        if ((r10 instanceof TextView) == false) goto L39;
        View r12 = r9.getCurrentView();
        if (r12 == null) goto L38;
        ((TextView) r12).setTextColor(s1.h(2131101254));
        goto L39
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L39:
        if (r9 == null) goto L27;
        r9.setCurrentText("");
        goto L27
    L31:
        r10 = null;
    L41:
        TextView r13 = this.G;
        if (r13 == null) goto L44;
        r13.setTextColor(s1.h(2131101254));
    L44:
        TextSwitcher r14 = this.p;
        if (r14 == null) goto L57;
        int r15 = r14.getChildCount();
        if (r15 < 0) goto L57;
        int r16 = 0;
    L49:
        View r17 = r14.getChildAt(r16);
        if ((r17 instanceof TextView) == true) goto L52;
        r17 = null;
    L52:
        TextView r18 = (TextView) r17;
        if (r18 == null) goto L55;
        r18.setTextColor(s1.h(2131101254));
        r18.setMaxEms(6);
        r18.setEllipsize(TextUtils.TruncateAt.END);
        r18.setMaxLines(1);
        r18.setText("");
    L55:
        if (r16 == r15) goto L57;
        r16 = r16 + 1;
    L57:
        ViewGroup r19 = this.n;
        if (r19 != null) goto L60;
    L64:
        TextSwitcher r20 = this.H;
        if (r20 != null) goto L67;
        return;
    L67:
        if (r20.getVisibility() != 8) goto L80;
        TextSwitcher r22 = this.H;
        if (r22 == null) goto L81;
        r22.setVisibility(0);
        return;
    L81:
        return;
    L80:
        return;
    L60:
        if (r19.getVisibility() != 0) goto L64;
        ViewGroup r23 = this.n;
        if (r23 == null) goto L64;
        r23.setVisibility(8);
        goto L64
    }

    @Override // u81.d
    public final com.bytedance.android.live.room.incentiveinfo.c c() {
        return new com.bytedance.android.live.room.incentiveinfo.c();
    }

    @Override // u81.d
    public final v81.b e() {
        return new v81.b();
    }

    @Override // u81.d
    public final void onInit() {
        View r0 = this.h;
        TextView r1 = null;
        if (r0 == null) goto L5;
        ViewGroup r2 = (ViewGroup) r0.findViewById(2131381482);
    L6:
        this.k = r2;
        View r3 = this.h;
        if (r3 == null) goto L9;
        ViewGroup r4 = (ViewGroup) r3.findViewById(2131370089);
    L10:
        this.l = r4;
        View r5 = this.g;
        if (r5 == null) goto L13;
        ViewGroup r6 = (ViewGroup) r5.findViewById(2131362539);
    L14:
        this.m = r6;
        View r7 = this.g;
        if (r7 == null) goto L17;
        ViewGroup r8 = (ViewGroup) r7.findViewById(2131368530);
    L18:
        this.n = r8;
        View r9 = this.h;
        if (r9 == null) goto L21;
        LottieAnimationView r10 = (LottieAnimationView) r9.findViewById(2131387807);
    L22:
        this.v = r10;
        View r12 = this.g;
        if (r12 == null) goto L25;
        HSImageView r13 = (HSImageView) r12.findViewById(2131375233);
    L26:
        this.o = r13;
        View r14 = this.g;
        if (r14 == null) goto L29;
        View r15 = r14.findViewById(2131375231);
    L30:
        this.z = r15;
        View r16 = this.h;
        if (r16 == null) goto L33;
        RelativeLayout r17 = (RelativeLayout) r16.findViewById(2131381481);
    L34:
        this.t = r17;
        View r18 = this.h;
        if (r18 == null) goto L37;
        StrokeTextView r19 = (StrokeTextView) r18.findViewById(2131381480);
    L38:
        this.u = r19;
        View r20 = this.g;
        if (r20 == null) goto L41;
        TextSwitcher r22 = (TextSwitcher) r20.findViewById(2131375240);
    L42:
        this.p = r22;
        View r23 = this.g;
        if (r23 == null) goto L45;
        TextView r24 = (TextView) r23.findViewById(2131375237);
    L46:
        this.q = r24;
        SpannableString r25 = new SpannableString("dou+");
        Drawable r26 = s1.m(2131250094);
        r26.setBounds(0, 0, (int) UtilityKotlinExtentionsKt.h(21), (int) UtilityKotlinExtentionsKt.h(9));
        r25.setSpan(new ImageSpan(r26, 1), 0, r25.length(), 17);
        TextView r27 = this.q;
        if (r27 == null) goto L49;
        r27.append(s1.B(2131916254));
        r27.append(r25);
        r27.append(s1.B(2131916255));
    L49:
        this.r = new b(this, Looper.getMainLooper());
        DataCenter r28 = this.f;
        if (r28 == null) goto L52;
        IRoom r29 = com.bytedance.android.live.core.utils.a0.m(r28).a;
    L53:
        this.O = r29;
        View r30 = this.g;
        if (r30 == null) goto L56;
        TextSwitcher r32 = (TextSwitcher) r30.findViewById(2131382495);
    L57:
        this.F = r32;
        View r33 = this.g;
        if (r33 == null) goto L60;
        TextSwitcher r34 = (TextSwitcher) r33.findViewById(2131364256);
    L61:
        this.B = r34;
        View r35 = this.g;
        if (r35 == null) goto L64;
        TextSwitcher r36 = (TextSwitcher) r35.findViewById(2131368623);
    L65:
        this.C = r36;
        View r37 = this.g;
        if (r37 == null) goto L68;
        TextSwitcher r38 = (TextSwitcher) r37.findViewById(2131374633);
    L69:
        this.D = r38;
        View r39 = this.g;
        if (r39 == null) goto L72;
        TextSwitcher r40 = (TextSwitcher) r39.findViewById(2131388580);
    L73:
        this.E = r40;
        View r42 = this.g;
        if (r42 == null) goto L76;
        TextSwitcher r43 = (TextSwitcher) r42.findViewById(2131391875);
    L77:
        this.A = r43;
        View r44 = this.g;
        if (r44 == null) goto L80;
        TextSwitcher r45 = (TextSwitcher) r44.findViewById(2131375285);
    L81:
        this.H = r45;
        View r46 = this.g;
        if (r46 == null) goto L84;
        r1 = (TextView) r46.findViewById(2131382745);
    L84:
        this.G = r1;
        this.J = CollectionsKt.mutableListOf(new TextSwitcher[]{this.A, this.B, this.C, this.D, this.E, this.F});
        ViewGroup r47 = this.m;
        if (r47 == null) goto L87;
        r47.setOnClickListener(new c(this));
    L87:
        Disposable r48 = xs2.b.a().b(w1.class).subscribe(new d(this));
        if (r48 == null) goto L90;
        Intrinsics.checkNotNullParameter(r48, "$this$autoBind");
        this.b.add(r48);
    L90:
        q();
        return;
    L80:
        r45 = null;
        goto L81
    L76:
        r43 = null;
        goto L77
    L72:
        r40 = null;
        goto L73
    L68:
        r38 = null;
        goto L69
    L64:
        r36 = null;
        goto L65
    L60:
        r34 = null;
        goto L61
    L56:
        r32 = null;
        goto L57
    L52:
        r29 = null;
        goto L53
    L45:
        r24 = null;
        goto L46
    L41:
        r22 = null;
        goto L42
    L37:
        r19 = null;
        goto L38
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L25:
        r13 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void p() {
        ValueAnimator r0 = this.y;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.L.clear();
        ValueAnimator r1 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#26000000")), Integer.valueOf(ColorProtector.parseColor("#80ff356f"))});
        this.y = r1;
        if (r1 == null) goto L11;
        r1.addListener(new i(this));
        r1.addUpdateListener(new j(r1, this));
        if (this.c == true) goto L10;
        r1.setStartDelay(0);
        r1.setDuration(0);
        goto L11
    L10:
        r1.setStartDelay(200);
        r1.setDuration(300);
    L11:
        ValueAnimator r2 = this.y;
        if (r2 == null) goto L14;
        r2.start();
    L14:
        List<TextSwitcher> r3 = this.J;
        if (r3 == null) goto L30;
        Iterator<T> r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L30;
        TextSwitcher r5 = (TextSwitcher) r4.next();
        if (r5 == null) goto L22;
        View r6 = r5.getCurrentView();
    L24:
        if ((r6 instanceof TextView) == false) goto L18;
        View r7 = r5.getCurrentView();
        if (r7 == null) goto L29;
        ((TextView) r7).setTextColor(s1.h(2131101254));
        goto L18
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L22:
        r6 = null;
    L30:
        TextView r8 = this.G;
        if (r8 == null) goto L33;
        r8.setTextColor(s1.h(2131101254));
    L33:
        ValueAnimator r9 = this.x;
        if (r9 == null) goto L36;
        r9.cancel();
    L36:
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.x = r10;
        if (r10 == null) goto L39;
        r10.addListener(new k(this));
        r10.addUpdateListener(new C0351l(r10, this));
        r10.setStartDelay(500);
        r10.setDuration(200);
    L39:
        ValueAnimator r12 = this.x;
        if (r12 == null) goto L49;
        r12.start();
        return;
    }

    @Override // y81.b, u81.d
    public final void onDestroy() {
        super.onDestroy();
        this.L.clear();
        Disposable r0 = this.K;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        LottieAnimationView r1 = this.v;
        if (r1 == null) goto L8;
        r1.cancelAnimation();
    L8:
        ValueAnimator r2 = this.w;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        ValueAnimator r3 = this.x;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        ValueAnimator r4 = this.y;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        q();
    }

    @Override // u81.d
    public final int getItemType() {
        return this.j;
    }

    public static final void l(l r5) {
        LottieAnimationView r0 = r5.v;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        LottieAnimationView r1 = r5.v;
        if (r1 == null) goto L8;
        r1.addAnimatorListener(new b0(r1, r5));
        r1.setAnimation("rank_indicator_sweep.json");
        r1.setImageAssetsFolder("rank_indicator/");
        r1.loop(false);
    L8:
        r5.K = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.MINUTES).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r5.g))).subscribe(new c0(r5), RxUtil.getNoOpThrowable());
    }

    @Override // u81.d
    public final void f(String r2) {
        this.d = "";
        HSImageView r3 = this.o;
        if (r3 == null) goto L6;
        r3.setImageResource(2131250094);
        return;
    }

    @Override // u81.d
    public final void g(w81.a r12) {
        if (r12 == null) goto L5;
        tlc.d r1 = r12.a;
    L7:
        if ((r1 instanceof com.bytedance.android.live.base.model.message.s0) == true) goto L9;
        r1 = null;
    L9:
        com.bytedance.android.live.base.model.message.s0 r2 = (com.bytedance.android.live.base.model.message.s0) r1;
        StringBuilder r3 = new StringBuilder("process holder binding, status: ");
        if (r2 == null) goto L12;
        Long r4 = r2.getStatus();
    L13:
        r3.append(r4);
        r3.append(", curStatus: ");
        r3.append(this.P);
        r3.append(", showStatus: ");
        r3.append(this.R);
        ALogger.d("DouPlusHolder", r3.toString());
        if (r2 != null) goto L17;
        return;
    L17:
        if (r12 == null) goto L21;
        Boolean r13 = r12.b;
        if (r13 == null) goto L21;
        boolean r14 = r13.booleanValue();
    L22:
        this.c = r14;
        Long r15 = r2.getStatus();
        if (r15 == null) goto L25;
        long r5 = r15.longValue();
    L26:
        int r16 = (int) r5;
        Long r6 = r2.getNumber();
        if (r6 == null) goto L29;
        long r7 = r6.longValue();
    L30:
        int r8 = (int) r7;
        if (r16 == 1) goto L34;
        if (r16 == 4) goto L34;
    L56:
        if (r16 != 2) goto L93;
        Integer r9 = this.P;
        if (r9 == null) goto L63;
        if (r9.intValue() == 2) goto L93;
    L63:
        if (this.R != 10) goto L93;
        this.P = Integer.valueOf(r16);
        this.N = 0;
        this.S = false;
        i(1);
        Disposable r17 = this.K;
        if (r17 == null) goto L67;
        r17.dispose();
    L67:
        this.L.clear();
        LottieAnimationView r18 = this.v;
        if (r18 == null) goto L70;
        r18.cancelAnimation();
    L70:
        LottieAnimationView r19 = this.v;
        if (r19 == null) goto L73;
        r19.setVisibility(8);
    L73:
        List<TextSwitcher> r110 = this.J;
        if (r110 == null) goto L89;
        Iterator<T> r111 = r110.iterator();
    L77:
        if (r111.hasNext() == false) goto L89;
        TextSwitcher r10 = (TextSwitcher) r111.next();
        if (r10 == null) goto L81;
        View r20 = r10.getCurrentView();
    L83:
        if ((r20 instanceof TextView) == false) goto L77;
        View r22 = r10.getCurrentView();
        if (r22 == null) goto L88;
        ((TextView) r22).setTextColor(s1.h(2131107305));
        goto L77
    L88:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L81:
        r20 = null;
    L89:
        TextView r112 = this.G;
        if (r112 == null) goto L92;
        r112.setTextColor(s1.h(2131108314));
    L92:
        CompositeDisposable r113 = this.L;
        Observable r0 = Observable.just(this);
        TimeUnit r23 = TimeUnit.MILLISECONDS;
        r113.add(r0.delay(5000, r23).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(this), RxUtil.getNoOpThrowable()));
        this.L.add(Observable.just(this).delay(9000, r23).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(this), RxUtil.getNoOpThrowable()));
        return;
    L93:
        if (r16 == 1) goto L95;
    L108:
        if (r16 != 4) goto L124;
        if (this.R != 10) goto L124;
        Integer r24 = this.P;
        if (r24 != null) goto L115;
    L117:
        this.P = Integer.valueOf(r16);
        if (this.S == false) goto L122;
        TextSwitcher r114 = this.H;
        if (r114 == null) goto L168;
        r114.setCurrentText(s1.B(2131916253));
        return;
    L168:
        return;
    L122:
        n(s1.B(2131916253));
        return;
    L115:
        if (r24.intValue() != 2) goto L117;
        this.P = Integer.valueOf(r16);
        p();
        return;
    L124:
        if (r16 != 3) goto L146;
        if (TextUtils.isEmpty(r2.getBuyerNickname()) == true) goto L146;
        String r115 = r2.getBuyerNickname();
        if (r115 == null) goto L133;
        List<String> r25 = this.s;
        if (r25 == null) goto L133;
        ((ArrayList) r25).add(r115);
    L133:
        if (this.N >= r8) goto L136;
        this.N = r8;
    L136:
        if (this.R == 10) goto L138;
        return;
    L138:
        this.P = 3;
        List<String> r116 = this.s;
        if (r116 != null) goto L141;
        return;
    L141:
        if (((ArrayList) r116).size() == 1) goto L143;
        return;
    L143:
        if (this.S == true) goto L173;
        o();
        return;
    L173:
        return;
    L146:
        if (r16 == 6) goto L150;
        if (r16 == 5) goto L150;
        return;
    L150:
        if (TextUtils.isEmpty(r2.getToast()) == true) goto L176;
        String r117 = r2.getToast();
        if (r117 == null) goto L177;
        String r26 = rm3.c.a;
        rm3.c.g(com.bytedance.android.live.core.utils.a.d(), r117, 0, false, 28);
        return;
    L177:
        return;
    L176:
        return;
    L95:
        if (this.R != 10) goto L108;
        this.N = r8;
        Integer r27 = this.P;
        if (r27 != null) goto L100;
    L102:
        this.P = Integer.valueOf(r16);
    L104:
        if (this.S == true) goto L164;
        if (r8 <= 0) goto L107;
        m(r8);
        return;
    L107:
        n(s1.B(2131916257));
        return;
    L164:
        return;
    L100:
        if (r27.intValue() != 2) goto L102;
        this.P = Integer.valueOf(r16);
        p();
    L34:
        if (this.R != 11) goto L56;
        if (this.T == true) goto L56;
        this.P = Integer.valueOf(r16);
        this.T = true;
        ValueAnimator r118 = this.y;
        if (r118 == null) goto L40;
        r118.cancel();
    L40:
        ValueAnimator r119 = this.w;
        if (r119 == null) goto L43;
        r119.cancel();
    L43:
        this.L.clear();
        ValueAnimator r120 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.w = r120;
        if (r120 == null) goto L49;
        r120.addListener(new o(this));
        r120.addUpdateListener(new p(r120, this));
        if (this.c == true) goto L48;
        r120.setDuration(0);
        goto L49
    L48:
        r120.setDuration(500);
    L49:
        ValueAnimator r121 = this.w;
        if (r121 == null) goto L52;
        r121.start();
    L52:
        p();
        if (r8 <= 0) goto L161;
        this.N = r8;
        return;
    L161:
        return;
    L29:
        r7 = 0;
        goto L30
    L25:
        r5 = 0;
    L21:
        r14 = true;
        goto L22
    L12:
        r4 = null;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public final void m(int r7) {
        ViewGroup r0 = this.n;
        if (r0 != null) goto L5;
    L9:
        TextSwitcher r1 = this.H;
        if (r1 == null) goto L20;
        if (r1.getVisibility() != 0) goto L20;
        TextSwitcher r2 = this.H;
        if (r2 == null) goto L16;
        r2.setVisibility(8);
    L16:
        TextSwitcher r3 = this.H;
        if (r3 == null) goto L20;
        r3.setCurrentText("");
    L20:
        if (TextUtils.equals("+", this.I) == true) goto L26;
        TextSwitcher r4 = this.F;
        if (r4 == null) goto L24;
        r4.setText("+");
    L24:
        this.I = "+";
    L26:
        if (r7 < 10000) goto L56;
        TextView r5 = this.G;
        if (r5 == null) goto L30;
        r5.setVisibility(0);
    L30:
        TextSwitcher r6 = this.A;
        if (r6 != null) goto L33;
    L37:
        TextSwitcher r8 = this.A;
        if (r8 == null) goto L41;
        r8.setText("万");
    L41:
        if (r7 < 10000000) goto L43;
        r7 = 9999000;
    L43:
        if (r7 < 100000) goto L53;
        Integer r9 = (Integer) com.bytedance.android.live.core.setting.k0.a.getValue();
        if (r9 == null) goto L53;
        if (r9.intValue() != 1) goto L53;
        TextSwitcher r10 = this.A;
        if (r10 == null) goto L52;
        r10.setText("万+");
    L52:
        r7 = 100000;
    L53:
        int r12 = r7 / WebcastRedirectException.UNKNOWN;
        if ((r7 % WebcastRedirectException.UNKNOWN) < 500) goto L66;
        r12 = r12 + 1;
    L66:
        if (r7 < 100000) goto L78;
        Integer r13 = (Integer) com.bytedance.android.live.core.setting.k0.a.getValue();
        if (r13 == null) goto L78;
        if (r13.intValue() != 1) goto L78;
        TextView r14 = this.G;
        if (r14 == null) goto L75;
        r14.setVisibility(8);
    L75:
        TextSwitcher r15 = this.B;
        if (r15 == null) goto L79;
        r15.setVisibility(8);
    L79:
        s(this.C, r12, 10);
        s(this.D, r12, 100);
        s(this.E, r12, WebcastRedirectException.UNKNOWN);
        this.Q = r12;
        return;
    L78:
        s(this.B, r12, 1);
        goto L79
    L33:
        if (r6.getVisibility() != 8) goto L37;
        TextSwitcher r16 = this.A;
        if (r16 == null) goto L37;
        r16.setVisibility(0);
        goto L37
    L56:
        TextView r17 = this.G;
        if (r17 == null) goto L59;
        r17.setVisibility(8);
    L59:
        TextSwitcher r18 = this.A;
        if (r18 == null) goto L62;
        r18.setText("");
    L62:
        TextSwitcher r19 = this.A;
        if (r19 == null) goto L65;
        r19.setVisibility(8);
    L65:
        r12 = r7;
        goto L66
    L5:
        if (r0.getVisibility() != 8) goto L9;
        ViewGroup r20 = this.n;
        if (r20 == null) goto L9;
        r20.setVisibility(0);
        goto L9
    }

    public final void n(String r3) {
        ViewGroup r0 = this.n;
        if (r0 != null) goto L5;
    L9:
        TextSwitcher r1 = this.H;
        if (r1 != null) goto L12;
    L16:
        TextSwitcher r2 = this.H;
        if (r2 == null) goto L20;
        r2.setCurrentText(r3);
        return;
    L20:
        return;
    L12:
        if (r1.getVisibility() != 8) goto L16;
        TextSwitcher r4 = this.H;
        if (r4 == null) goto L16;
        r4.setVisibility(0);
        goto L16
    L5:
        if (r0.getVisibility() != 0) goto L9;
        ViewGroup r5 = this.n;
        if (r5 == null) goto L9;
        r5.setVisibility(8);
        goto L9
    }

    public final void r(View r4, float r5) {
        if ((r4 instanceof ViewGroup) == false) goto L8;
        ViewGroup r6 = (ViewGroup) r4;
        int r0 = r6.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        r(r6.getChildAt(r1), r5);
        r1 = r1 + 1;
        goto L5
    L13:
        return;
    L8:
        if ((r4 instanceof View) == false) goto L12;
        r4.setAlpha(r5);
        return;
    }

    public final void s(TextSwitcher r4, int r5, int r6) {
        if (r4 == null) goto L19;
        int r0 = this.Q;
        if (r0 == (-1)) goto L7;
        r0 = (r0 / r6) % 10;
    L7:
        int r1 = (r5 / r6) % 10;
        if (r1 != 0) goto L14;
        if (r5 >= (r6 * 10)) goto L14;
        r4.setText("");
        r4.setVisibility(8);
        return;
    L14:
        if (r4.getVisibility() != 8) goto L16;
        r4.setVisibility(0);
    L16:
        if (r1 == r0) goto L21;
        r4.setText(String.valueOf(r1));
        return;
    L21:
        return;
    }

    public l(DataCenter r2, View r3, int r4, View r5) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r5, "parentView");
        super(r2, r3, r5);
        this.j = r4;
        this.s = new ArrayList();
        this.L = new CompositeDisposable();
        this.P = -1;
        this.Q = -1;
        this.R = 11;
    }

    public static final void k(l r1, ViewGroup r2, int r3, int r4) {
        r1.getClass();
        Drawable r5 = null;
        if (r2 == null) goto L5;
        Drawable r0 = r2.getBackground();
    L7:
        if ((r0 instanceof GradientDrawable) == false) goto L14;
        if (r2 == null) goto L10;
        r5 = r2.getBackground();
    L10:
        GradientDrawable r6 = (GradientDrawable) r5;
        if (r6 == null) goto L15;
        r6.setColors(new int[]{r3, r4});
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r0 = null;
        goto L7
    }
}
