package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.message.a4;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.u4;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.incentiveinfo.model.BizContentType;
import com.bytedance.android.live.room.incentiveinfo.model.BizStatus;
import com.bytedance.android.live.room.incentiveinfo.model.UpdateAreaType;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 extends y81.b {
    public static final a h0 = null;
    public BizContentType A;
    public BizContentType B;
    public BizContentType C;
    public RelativeLayout D;
    public StrokeTextView E;
    public LottieAnimationView F;
    public ValueAnimator G;
    public ValueAnimator H;
    public ValueAnimator I;
    public View J;
    public TextSwitcher K;
    public TextSwitcher L;
    public TextSwitcher M;
    public TextSwitcher N;
    public TextSwitcher O;
    public TextSwitcher P;
    public TextSwitcher Q;
    public String R;
    public List<TextSwitcher> S;
    public List<View> T;
    public List<View> U;
    public Disposable V;
    public final CompositeDisposable W;
    public long X;
    public IRoom Y;
    public long Z;
    public int a0;
    public int b0;
    public boolean c0;
    public boolean d0;
    public boolean e0;
    public long f0;
    public final Integer g0;
    public final int j;
    public ViewGroup k;
    public ViewGroup l;
    public ViewGroup m;
    public ViewGroup n;
    public ImageView o;
    public TextView p;
    public TextSwitcher q;
    public ImageView r;
    public ImageView s;
    public TextView t;
    public d u;
    public final List<String> v;
    public final List<py.k> w;
    public final List<String> x;
    public final List<py.k> y;
    public Disposable z;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ImageView a;

        public b(ImageView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Bitmap r3 = (Bitmap) r2;
            ImageView r0 = this.a;
            if (r0 == null) goto L6;
            r0.setImageBitmap(r3);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ImageView a;

        public c(ImageView r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            ImageView r0 = this.a;
            String r1 = null;
            if (r0 == null) goto L9;
            int r2 = r0.getId();
            ImageView r3 = this.a;
            if (r3 == null) goto L9;
            Resources r6 = r3.getResources();
            if (r6 == null) goto L9;
            String r7 = r6.getResourceEntryName(r2);
        L10:
            StringBuilder r8 = new StringBuilder();
            r8.append(r7);
            r8.append(" ----- load icon failed, reason is --- ");
            if (r5 == null) goto L13;
            r1 = r5.getMessage();
        L13:
            r8.append(r1);
            ALogger.i("RoomIndicatorHolder", r8.toString());
            return;
        L9:
            r7 = null;
            goto L10
        }
    }

    public static final class d extends Handler {
        public final /* synthetic */ d0 a;

        @Override // android.os.Handler
        public final void handleMessage(Message r9) {
            Intrinsics.checkNotNullParameter(r9, Constants.OperatorKey.MSG);
            super.handleMessage(r9);
            int r10 = r9.what;
            if (r10 == 1) goto L27;
            if (r10 != 2) goto L6;
            d0 r12 = this.a;
            ValueAnimator r3 = r12.G;
            if (r3 == null) goto L14;
            r3.cancel();
        L14:
            r12.G = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            Ref.IntRef r4 = new Ref.IntRef();
            r4.element = 0;
            ValueAnimator r5 = r12.G;
            if (r5 == null) goto L17;
            r5.addListener(new p0(r12, r4));
            r5.addUpdateListener(new q0(r5, r12, r4));
            r5.setDuration(200);
            r5.start();
        L17:
            ValueAnimator r6 = r12.I;
            if (r6 == null) goto L20;
            r6.cancel();
        L20:
            ValueAnimator r0 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#26000000")), Integer.valueOf(ColorProtector.parseColor("#80ff356f"))});
            r12.I = r0;
            if (r0 == null) goto L23;
            r0.addListener(new r0(r12));
            r0.addUpdateListener(new s0(r0, r12));
            r0.setDuration(200);
        L23:
            ValueAnimator r13 = r12.I;
            if (r13 == null) goto L38;
            r13.start();
            return;
        L38:
            return;
        L6:
            if (r10 != 3) goto L42;
            d0 r14 = this.a;
            if (r14.c0 == true) goto L36;
            r14.q();
            return;
        L36:
            return;
        L42:
            return;
        L27:
            if (this.a.o() == true) goto L31;
            d r15 = this.a.u;
            if (r15 == null) goto L40;
            r15.sendEmptyMessage(2);
            return;
        L40:
            return;
        L31:
            d r16 = this.a.u;
            if (r16 == null) goto L34;
            r16.sendEmptyMessageDelayed(1, 2000);
        L34:
            this.a.t(false);
        }

        public d(d0 r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ d0 a;

        public e(d0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            String r0 = null;
            if (Intrinsics.areEqual(u4.a.getValue(), Boolean.TRUE) == false) goto L19;
            d0 r7 = this.a;
            tlc.d r1 = r7.e;
            if ((r1 instanceof a4) == true) goto L7;
            r1 = null;
        L7:
            a4 r2 = (a4) r1;
            if (r2 == null) goto L12;
            mm2.b r3 = r2.E();
            if (r3 == null) goto L12;
            String r4 = r3.schema;
        L13:
            if (r4 == null) goto L19;
            if ((!StringsKt.isBlank(r4)) != true) goto L19;
            IBaseLiveActionHandler r5 = jc1.k.f(IBaseLiveActionHandler.class);
            if (r5 == null) goto L19;
            r5.handle(r7.g.getContext(), r4);
        L12:
            r4 = null;
        L19:
            d0 r8 = this.a;
            tlc.d r9 = r8.e;
            if ((r9 instanceof a4) == true) goto L22;
            r9 = null;
        L22:
            a4 r10 = (a4) r9;
            HashMap r12 = new HashMap();
            if (r10 == null) goto L25;
            r12.put("biz_type", String.valueOf(r10.G()));
        L25:
            int r13 = x81.c.a;
            DataCenter r14 = r8.f;
            if (r10 == null) goto L30;
            mm2.b r15 = r10.E();
            if (r15 == null) goto L30;
            r0 = r15.extra;
        L30:
            x81.c.a("livesdk_new_anchor_support_plan_click", r14, r0, r12);
        }
    }

    public static final class f extends AnimatorListenerAdapter {
        public final /* synthetic */ d0 a;
        public final /* synthetic */ Ref.IntRef b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationCancel(r2);
            StrokeTextView r3 = this.a.E;
            if (r3 == null) goto L6;
            r3.setGravity(1);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            d0 r5 = this.a;
            LottieAnimationView r0 = r5.F;
            if (r0 != null) goto L5;
            d0.l(r5);
        L6:
            d r6 = this.a.u;
            if (r6 == null) goto L9;
            r6.sendEmptyMessageDelayed(1, 4000);
        L9:
            StrokeTextView r7 = this.a.E;
            if (r7 == null) goto L13;
            r7.setGravity(1);
            return;
        L13:
            return;
        L5:
            r0.playAnimation();
            goto L6
        }

        public f(d0 r1, Ref.IntRef r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "animation");
            View r3 = this.a.J;
            if (r3 == null) goto L5;
            r3.setVisibility(8);
        L5:
            Ref.IntRef r4 = this.b;
            ViewGroup r5 = this.a.k;
            if (r5 == null) goto L8;
            int r6 = r5.getWidth();
        L9:
            r4.element = r6;
            StrokeTextView r7 = this.a.E;
            if (r7 == null) goto L12;
            r7.setGravity(8388611);
        L12:
            this.a.t(true);
            return;
        L8:
            r6 = 0;
            goto L9
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ d0 b;
        public final /* synthetic */ Ref.IntRef c;

        public g(ValueAnimator r1, d0 r2, Ref.IntRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r7) {
            Intrinsics.checkNotNullParameter(r7, "<anonymous parameter 0>");
            Object r8 = this.a.getAnimatedValue();
            if (r8 == null) goto L26;
            float r9 = ((Float) r8).floatValue();
            ViewGroup r0 = this.b.l;
            if (r0 == null) goto L9;
            float r3 = 52;
            if (this.c.element <= UtilityKotlinExtentionsKt.h(r3)) goto L9;
            ViewGroup.LayoutParams r2 = r0.getLayoutParams();
            r2.width = ((int) ((this.c.element - UtilityKotlinExtentionsKt.h(r3)) * r9)) + ((int) UtilityKotlinExtentionsKt.h(r3));
            r0.setLayoutParams(r2);
        L9:
            RelativeLayout r1 = this.b.D;
            if (r1 == null) goto L14;
            float r4 = 52;
            if (this.c.element <= UtilityKotlinExtentionsKt.h(r4)) goto L14;
            ViewGroup.LayoutParams r5 = r1.getLayoutParams();
            r5.width = (int) ((this.c.element - UtilityKotlinExtentionsKt.h(r4)) * (1 - r9));
            r1.setLayoutParams(r5);
        L14:
            d0.v(this.b.D, 1 - r9);
            TextSwitcher r6 = this.b.q;
            if (r6 == null) goto L17;
            r6.setAlpha(3 * r9);
        L17:
            int r10 = e0.a[this.b.C.ordinal()];
            if (r10 != 1) goto L20;
            d0.v(this.b.t, 3 * r9);
            return;
        L20:
            if (r10 == 2) goto L22;
            d0.v(this.b.t, 3 * r9);
            return;
        L22:
            d0.v(this.b.s, 3 * r9);
            return;
        L26:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class h extends AnimatorListenerAdapter {
        public final /* synthetic */ d0 a;

        public h(d0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            d0 r5 = this.a;
            d0.k(r5, r5.l, ColorProtector.parseColor("#29FF356F"), ColorProtector.parseColor("#80FF356F"));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            d0 r5 = this.a;
            d0.k(r5, r5.l, ColorProtector.parseColor("#29FF356F"), ColorProtector.parseColor("#29FF356F"));
        }
    }

    public static final class i implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ d0 b;

        public i(ValueAnimator r1, d0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = this.a.getAnimatedValue();
            if (r5 == null) goto L7;
            int r6 = ((Integer) r5).intValue();
            d0 r0 = this.b;
            d0.k(r0, r0.l, ColorProtector.parseColor("#29FF356F"), r6);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class j extends AnimatorListenerAdapter {
        public final /* synthetic */ d0 a;

        public j(d0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            d0 r5 = this.a;
            d0.k(r5, r5.l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#80ff356f"));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            d0 r5 = this.a;
            d0.k(r5, r5.l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
        }
    }

    public static final class k implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ d0 b;

        public k(ValueAnimator r1, d0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = this.a.getAnimatedValue();
            if (r5 == null) goto L7;
            int r6 = ((Integer) r5).intValue();
            d0 r0 = this.b;
            d0.k(r0, r0.l, ColorProtector.parseColor("#26000000"), r6);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class l extends AnimatorListenerAdapter {
        public final /* synthetic */ d0 a;

        public l(d0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            d0.v(this.a.m, 1.0f);
            d0 r5 = this.a;
            r5.d0 = false;
            r5.b0 = 10;
            if (r5.o() == false) goto L8;
            d r6 = this.a.u;
            if (r6 == null) goto L9;
            r6.sendEmptyMessageDelayed(3, 1000);
            return;
        L9:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            d0 r5 = this.a;
            r5.d0 = false;
            r5.b0 = 10;
            d0.l(r5);
            this.a.m();
            if (this.a.o() == false) goto L8;
            d r6 = this.a.u;
            if (r6 == null) goto L9;
            r6.sendEmptyMessageDelayed(3, 1000);
            return;
        L9:
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "animation");
            ViewGroup r3 = this.a.m;
            if (r3 == null) goto L5;
            r3.setVisibility(0);
        L5:
            d0.v(this.a.m, 0.0f);
        }
    }

    public static final class m implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ d0 b;

        public m(ValueAnimator r1, d0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = this.a.getAnimatedValue();
            if (r3 == null) goto L7;
            float r4 = ((Float) r3).floatValue();
            d0.v(this.b.m, r4);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    @Override // u81.d
    public final void f(String r1) {
    }

    public final void q() {
        i(1);
        this.W.clear();
        if (this.d0 == false) goto L6;
        this.c0 = false;
        return;
    L6:
        List<TextSwitcher> r1 = this.S;
        if (r1 == null) goto L22;
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L22;
        TextSwitcher r3 = (TextSwitcher) r2.next();
        if (r3 == null) goto L14;
        View r4 = r3.getCurrentView();
    L16:
        if ((r4 instanceof TextView) == false) goto L10;
        View r5 = r3.getCurrentView();
        if (r5 == null) goto L21;
        ((TextView) r5).setTextColor(s1.h(2131101254));
        goto L10
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L14:
        r4 = null;
    L22:
        this.c0 = true;
        ValueAnimator r6 = this.G;
        if (r6 == null) goto L25;
        r6.cancel();
    L25:
        this.G = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        Ref.IntRef r7 = new Ref.IntRef();
        r7.element = 0;
        ValueAnimator r8 = this.G;
        if (r8 == null) goto L28;
        r8.addListener(new f(this, r7));
        r8.addUpdateListener(new g(r8, this, r7));
        r8.setStartDelay(500);
        r8.setDuration(500);
        r8.start();
    L28:
        ValueAnimator r9 = this.I;
        if (r9 == null) goto L31;
        r9.cancel();
    L31:
        ValueAnimator r0 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#29FF356F")), Integer.valueOf(ColorProtector.parseColor("#80FF356F"))});
        this.I = r0;
        if (r0 == null) goto L34;
        r0.addListener(new h(this));
        r0.addUpdateListener(new i(r0, this));
        r0.setStartDelay(500);
        r0.setDuration(500);
    L34:
        ValueAnimator r10 = this.I;
        if (r10 == null) goto L44;
        r10.start();
        return;
    }

    public final void u() {
        this.a0 = -1;
        this.X = 0;
        this.R = null;
        ValueAnimator r1 = this.I;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        ValueAnimator r2 = this.G;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        this.Z = BizStatus.UNKNOW.getValue();
        this.b0 = 11;
        int r3 = 0;
        this.c0 = false;
        this.e0 = false;
        TextSwitcher r4 = this.Q;
        if (r4 == null) goto L11;
        r4.setCurrentText("");
    L11:
        TextSwitcher r5 = this.q;
        if (r5 == null) goto L14;
        r5.setCurrentText("");
    L14:
        ViewGroup r6 = this.l;
        if (r6 == null) goto L17;
        r6.setVisibility(8);
    L17:
        j();
        this.W.clear();
        Disposable r7 = this.V;
        if (r7 == null) goto L20;
        r7.dispose();
    L20:
        LottieAnimationView r8 = this.F;
        if (r8 == null) goto L23;
        r8.setVisibility(8);
    L23:
        List<TextSwitcher> r9 = this.S;
        if (r9 == null) goto L41;
        Iterator<T> r10 = r9.iterator();
    L27:
        if (r10.hasNext() == false) goto L41;
        TextSwitcher r12 = (TextSwitcher) r10.next();
        if (r12 == null) goto L31;
        View r13 = r12.getCurrentView();
    L33:
        if ((r13 instanceof TextView) == false) goto L39;
        View r14 = r12.getCurrentView();
        if (r14 == null) goto L38;
        ((TextView) r14).setTextColor(s1.h(2131101254));
        goto L39
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L39:
        if (r12 == null) goto L27;
        r12.setCurrentText("");
        goto L27
    L31:
        r13 = null;
    L41:
        TextSwitcher r15 = this.Q;
        if (r15 == null) goto L44;
        View r16 = r15.getCurrentView();
    L46:
        if ((r16 instanceof TextView) == true) goto L48;
        r16 = null;
    L48:
        TextView r17 = (TextView) r16;
        if (r17 == null) goto L51;
        r17.setTextColor(s1.h(2131101254));
    L51:
        List<View> r18 = this.T;
        if (r18 == null) goto L59;
        Iterator<T> r19 = r18.iterator();
    L55:
        if (r19.hasNext() == false) goto L59;
        View r20 = (View) r19.next();
        if (r20 == null) goto L55;
        UtilityKotlinExtentionsKt.z(r20, false);
    L59:
        List<View> r22 = this.U;
        if (r22 == null) goto L67;
        Iterator<T> r23 = r22.iterator();
    L63:
        if (r23.hasNext() == false) goto L67;
        View r24 = (View) r23.next();
        if (r24 == null) goto L63;
        UtilityKotlinExtentionsKt.z(r24, false);
    L67:
        TextSwitcher r25 = this.q;
        if (r25 == null) goto L79;
        int r26 = r25.getChildCount();
        if (r26 < 0) goto L79;
    L71:
        View r27 = r25.getChildAt(r3);
        if ((r27 instanceof TextView) == true) goto L74;
        r27 = null;
    L74:
        TextView r28 = (TextView) r27;
        if (r28 == null) goto L77;
        r28.setTextColor(s1.h(2131101254));
        r28.setMaxEms(6);
        r28.setEllipsize(TextUtils.TruncateAt.END);
        r28.setMaxLines(1);
        r28.setText("");
    L77:
        if (r3 == r26) goto L79;
        r3 = r3 + 1;
    L79:
        TextView r0 = this.p;
        if (r0 == null) goto L82;
        r0.setText("");
    L82:
        BizContentType r29 = BizContentType.UNKNOW;
        this.A = r29;
        this.B = r29;
        this.C = r29;
        ((ArrayList) this.w).clear();
        ((ArrayList) this.v).clear();
        ((ArrayList) this.x).clear();
        ((ArrayList) this.y).clear();
        return;
    L44:
        r16 = null;
        goto L46
    }

    static {
        h0 = new a();
    }

    @Override // u81.d
    public final com.bytedance.android.live.room.incentiveinfo.c c() {
        return new com.bytedance.android.live.room.incentiveinfo.c();
    }

    @Override // u81.d
    public final v81.b e() {
        return new v81.b();
    }

    public final void m() {
        tlc.d r0 = this.e;
        if ((r0 instanceof a4) == true) goto L5;
        r0 = null;
    L5:
        a4 r1 = (a4) r0;
        if (r1 == null) goto L8;
        Long r2 = r1.getStatus();
    L9:
        if (r2 == null) goto L147;
        r2.longValue();
        if (this.Z == r2.longValue()) goto L13;
        this.Z = r2.longValue();
    L13:
        tlc.d r3 = this.e;
        if ((r3 instanceof a4) == true) goto L16;
        r3 = null;
    L16:
        a4 r4 = (a4) r3;
        if (r4 == null) goto L21;
        mm2.b r5 = r4.E();
        if (r5 == null) goto L21;
        List r6 = r5.contents;
    L22:
        if (r6 == null) goto L168;
        Iterator r7 = r6.iterator();
        int r8 = 0;
    L25:
        if (r7.hasNext() == false) goto L169;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        mm2.a r12 = (mm2.a) r9;
        long r13 = r2.longValue();
        boolean r14 = true;
        if (r8 != UpdateAreaType.FIRST_LINE.getValue()) goto L68;
        int r15 = r12.contentType;
        BizContentType r16 = BizContentType.TEXT;
        if (r15 == r16.getValue()) goto L34;
        BizContentType r17 = BizContentType.IMAGE;
        if (r15 == r17.getValue()) goto L56;
    L145:
        Iterator r18 = r7;
    L146:
        r8 = r10;
        r7 = r18;
        goto L25
    L56:
        if (r13 != BizStatus.NEW_ORDER.getValue()) goto L61;
        py.k r19 = r12.icon;
        if (r19 == null) goto L60;
        ((ArrayList) this.w).add(r19);
    L60:
        this.B = r17;
        goto L145
    L61:
        ImageView r20 = this.o;
        if (r20 != null) goto L64;
    L66:
        this.A = r17;
        n(this.o, r12.icon);
        goto L145
    L64:
        if (r20.getVisibility() != 8) goto L66;
        s(this.o, this.T);
        goto L66
    L34:
        if (r13 != BizStatus.NEW_ORDER.getValue()) goto L44;
        String r22 = r12.content;
        if (r22 != null) goto L38;
    L43:
        this.B = r16;
        goto L145
    L38:
        if ((!StringsKt.isBlank(r22)) == true) goto L41;
        r22 = null;
    L41:
        if (r22 == null) goto L43;
        ((ArrayList) this.v).add(r22);
        goto L43
    L44:
        TextView r23 = this.p;
        if (r23 != null) goto L47;
    L49:
        TextView r24 = this.p;
        if (r24 == null) goto L52;
        r24.setText(r12.content);
    L52:
        this.A = r16;
        goto L145
    L47:
        if (r23.getVisibility() != 8) goto L49;
        s(this.p, this.T);
        goto L49
    L68:
        if (r8 != UpdateAreaType.SECOND_LINE.getValue()) goto L145;
        int r25 = r12.contentType;
        BizContentType r110 = BizContentType.TEXT;
        if (r25 == r110.getValue()) goto L72;
        r18 = r7;
        BizContentType r26 = BizContentType.IMAGE;
        if (r25 != r26.getValue()) goto L113;
        if (r13 != BizStatus.NEW_ORDER.getValue()) goto L146;
        py.k r27 = r12.icon;
        if (r27 == null) goto L111;
        ((ArrayList) this.y).add(r27);
    L111:
        this.C = r26;
        goto L146
    L113:
        if (r25 != BizContentType.NUMBER.getValue()) goto L124;
        long r28 = r12.number;
        if (r28 < this.X) goto L146;
        this.X = r28;
        ViewGroup r29 = this.n;
        if (r29 != null) goto L120;
    L122:
        p((int) r12.number);
        goto L146
    L120:
        if (r29.getVisibility() != 8) goto L122;
        s(this.n, this.U);
        goto L122
    L124:
        if (r25 != BizContentType.HOT_INFO.getValue()) goto L146;
        mm2.c r30 = r12.hotText;
        if (r30 == null) goto L146;
        String r32 = r30.showText;
        if (r32 != null) goto L130;
    L133:
        if (r14 == true) goto L146;
        long r33 = r30.number;
        if (r33 < this.X) goto L146;
        this.X = r33;
        TextSwitcher r34 = this.Q;
        if (r34 != null) goto L140;
    L142:
        TextSwitcher r35 = this.Q;
        if (r35 == null) goto L146;
        r35.setCurrentText(r30.showText);
        goto L146
    L140:
        if (r34.getVisibility() != 8) goto L142;
        s(this.Q, this.U);
        goto L142
    L130:
        if (StringsKt.isBlank(r32) == true) goto L133;
        r14 = false;
        goto L133
    L72:
        if (((Boolean) g81.d.a.getValue()).booleanValue() == false) goto L84;
        long r111 = r12.timestamp;
        r18 = r7;
        if (r111 == 0) goto L86;
        if (r111 <= (System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN))) goto L146;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L82
        String r37 = r12.endText;     // Catch: Throwable -> L82
        this.f0 = r111;     // Catch: Throwable -> L82
        Disposable r38 = this.z;     // Catch: Throwable -> L82
        if (r38 == null) goto L80;
        r38.dispose();     // Catch: Throwable -> L82
    L80:
        this.z = Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new t0(this, r37));     // Catch: Throwable -> L82
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L86:
        if (r13 != BizStatus.NEW_ORDER.getValue()) goto L96;
        String r40 = r12.content;
        if (r40 != null) goto L90;
    L95:
        this.C = r110;
        goto L146
    L90:
        if ((!StringsKt.isBlank(r40)) == true) goto L93;
        r40 = null;
    L93:
        if (r40 == null) goto L95;
        ((ArrayList) this.x).add(r40);
        goto L95
    L96:
        TextSwitcher r42 = this.Q;
        if (r42 != null) goto L99;
    L101:
        TextSwitcher r43 = this.Q;
        if (r43 == null) goto L146;
        r43.setCurrentText(r12.content);
        goto L146
    L99:
        if (r42.getVisibility() != 8) goto L101;
        s(this.Q, this.U);
        goto L101
    L84:
        r18 = r7;
        goto L86
    L169:
        return;
    L168:
        return;
    L21:
        r6 = null;
        goto L22
    L147:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final boolean o() {
        if ((!this.v.isEmpty()) == false) goto L7;
        if ((!this.x.isEmpty()) == false) goto L7;
        return true;
    L7:
        if ((!this.v.isEmpty()) == false) goto L11;
        if ((!this.y.isEmpty()) == false) goto L11;
        return true;
    L11:
        if ((!this.w.isEmpty()) == false) goto L15;
        if ((!this.x.isEmpty()) == false) goto L15;
        return true;
    L15:
        if ((!this.w.isEmpty()) == true) goto L17;
    L19:
        return false;
    L17:
        if ((!this.y.isEmpty()) == false) goto L19;
        return true;
    }

    @Override // u81.d
    public final void onInit() {
        View r0 = this.h;
        TextSwitcher r1 = null;
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
        this.F = r10;
        View r12 = this.g;
        if (r12 == null) goto L25;
        ImageView r13 = (ImageView) r12.findViewById(2131375235);
    L26:
        this.o = r13;
        View r14 = this.g;
        if (r14 == null) goto L29;
        TextView r15 = (TextView) r14.findViewById(2131375248);
    L30:
        this.p = r15;
        View r16 = this.g;
        if (r16 == null) goto L33;
        View r17 = r16.findViewById(2131375231);
    L34:
        this.J = r17;
        View r18 = this.h;
        if (r18 == null) goto L37;
        RelativeLayout r19 = (RelativeLayout) r18.findViewById(2131381481);
    L38:
        this.D = r19;
        View r20 = this.h;
        if (r20 == null) goto L41;
        StrokeTextView r22 = (StrokeTextView) r20.findViewById(2131381480);
    L42:
        this.E = r22;
        View r23 = this.g;
        if (r23 == null) goto L45;
        TextSwitcher r24 = (TextSwitcher) r23.findViewById(2131375240);
    L46:
        this.q = r24;
        View r25 = this.g;
        if (r25 == null) goto L49;
        TextView r26 = (TextView) r25.findViewById(2131375237);
    L50:
        this.t = r26;
        this.s = (ImageView) this.g.findViewById(2131375238);
        this.r = (ImageView) this.g.findViewById(2131375239);
        this.u = new d(this, Looper.getMainLooper());
        DataCenter r27 = this.f;
        if (r27 == null) goto L53;
        IRoom r28 = com.bytedance.android.live.core.utils.a0.m(r27).a;
    L54:
        this.Y = r28;
        View r29 = this.g;
        if (r29 == null) goto L57;
        TextSwitcher r30 = (TextSwitcher) r29.findViewById(2131382495);
    L58:
        this.P = r30;
        View r32 = this.g;
        if (r32 == null) goto L61;
        TextSwitcher r33 = (TextSwitcher) r32.findViewById(2131364256);
    L62:
        this.K = r33;
        View r34 = this.g;
        if (r34 == null) goto L65;
        TextSwitcher r35 = (TextSwitcher) r34.findViewById(2131368623);
    L66:
        this.L = r35;
        View r36 = this.g;
        if (r36 == null) goto L69;
        TextSwitcher r37 = (TextSwitcher) r36.findViewById(2131374633);
    L70:
        this.M = r37;
        View r38 = this.g;
        if (r38 == null) goto L73;
        TextSwitcher r39 = (TextSwitcher) r38.findViewById(2131388580);
    L74:
        this.N = r39;
        View r40 = this.g;
        if (r40 == null) goto L77;
        TextSwitcher r42 = (TextSwitcher) r40.findViewById(2131392997);
    L78:
        this.O = r42;
        View r43 = this.g;
        if (r43 == null) goto L81;
        r1 = (TextSwitcher) r43.findViewById(2131375285);
    L81:
        this.Q = r1;
        this.S = CollectionsKt.mutableListOf(new TextSwitcher[]{this.K, this.L, this.M, this.N, this.O, this.P});
        this.T = CollectionsKt.mutableListOf(new View[]{this.o, this.p, this.q, this.r});
        this.U = CollectionsKt.mutableListOf(new View[]{this.n, this.t, this.s, this.Q});
        ViewGroup r44 = this.m;
        if (r44 == null) goto L84;
        r44.setOnClickListener(new e(this));
    L84:
        u();
        return;
    L77:
        r42 = null;
        goto L78
    L73:
        r39 = null;
        goto L74
    L69:
        r37 = null;
        goto L70
    L65:
        r35 = null;
        goto L66
    L61:
        r33 = null;
        goto L62
    L57:
        r30 = null;
        goto L58
    L53:
        r28 = null;
        goto L54
    L49:
        r26 = null;
        goto L50
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

    public final void r() {
        ValueAnimator r0 = this.I;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.W.clear();
        ValueAnimator r1 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#26000000")), Integer.valueOf(ColorProtector.parseColor("#80ff356f"))});
        this.I = r1;
        if (r1 == null) goto L11;
        r1.addListener(new j(this));
        r1.addUpdateListener(new k(r1, this));
        if (this.c == true) goto L10;
        r1.setStartDelay(0);
        r1.setDuration(0);
        goto L11
    L10:
        r1.setStartDelay(200);
        r1.setDuration(300);
    L11:
        ValueAnimator r2 = this.I;
        if (r2 == null) goto L14;
        r2.start();
    L14:
        List<TextSwitcher> r3 = this.S;
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
        ValueAnimator r8 = this.H;
        if (r8 == null) goto L33;
        r8.cancel();
    L33:
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.H = r9;
        if (r9 == null) goto L36;
        r9.addListener(new l(this));
        r9.addUpdateListener(new m(r9, this));
        r9.setStartDelay(500);
        r9.setDuration(200);
    L36:
        ValueAnimator r10 = this.H;
        if (r10 == null) goto L46;
        r10.start();
        return;
    }

    @Override // y81.b, u81.d
    public final void onDestroy() {
        super.onDestroy();
        this.W.clear();
        Disposable r0 = this.V;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        LottieAnimationView r1 = this.F;
        if (r1 == null) goto L8;
        r1.cancelAnimation();
    L8:
        ValueAnimator r2 = this.G;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        ValueAnimator r3 = this.H;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        ValueAnimator r4 = this.I;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        Disposable r5 = this.z;
        if (r5 == null) goto L20;
        r5.dispose();
    L20:
        this.z = null;
        u();
    }

    @Override // y81.b, u81.d
    public final Integer b() {
        return this.g0;
    }

    @Override // u81.d
    public final int getItemType() {
        return this.j;
    }

    public static final void l(d0 r5) {
        LottieAnimationView r0 = r5.F;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        LottieAnimationView r1 = r5.F;
        if (r1 == null) goto L8;
        r1.addAnimatorListener(new u0(r1, r5));
        r1.setAnimation("rank_indicator_sweep.json");
        r1.setImageAssetsFolder("rank_indicator/");
        r1.loop(false);
    L8:
        r5.V = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.MINUTES).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r5.g))).subscribe(new v0(r5), RxUtil.getNoOpThrowable());
    }

    @Override // u81.d
    public final void g(w81.a r13) {
        View r0 = null;
        if (r13 == null) goto L5;
        tlc.d r1 = r13.a;
    L6:
        this.e = r1;
        if ((r1 instanceof a4) == true) goto L9;
        r1 = null;
    L9:
        a4 r2 = (a4) r1;
        StringBuilder r3 = new StringBuilder("process holder binding, status: ");
        if (r2 == null) goto L12;
        Long r4 = r2.getStatus();
    L13:
        r3.append(r4);
        r3.append(", curStatus: ");
        r3.append(this.Z);
        r3.append(", showStatus: ");
        r3.append(this.b0);
        ALogger.d("RoomIndicatorHolder", r3.toString());
        if (r2 != null) goto L17;
        return;
    L17:
        if (r13 == null) goto L21;
        Boolean r14 = r13.b;
        if (r14 == null) goto L21;
        boolean r15 = r14.booleanValue();
    L22:
        this.c = r15;
        Long r16 = r2.getStatus();
        BizStatus r5 = BizStatus.START;
        long r6 = r5.getValue();
        long r7 = 0;
        if (r16 != null) goto L26;
    L66:
        Long r17 = r2.getStatus();
        BizStatus r8 = BizStatus.END;
        long r9 = r8.getValue();
        if (r17 != null) goto L70;
    L124:
        Long r18 = r2.getStatus();
        long r10 = BizStatus.UPDATE.getValue();
        if (r18 != null) goto L128;
    L140:
        Long r19 = r2.getStatus();
        BizStatus r12 = BizStatus.NEW_ORDER;
        long r20 = r12.getValue();
        if (r19 != null) goto L144;
        return;
    L144:
        if (r19.longValue() == r20) goto L146;
        return;
    L146:
        if (this.Z != r8.getValue()) goto L148;
        return;
    L148:
        if (this.b0 != 10) goto L167;
        this.Z = r12.getValue();
        m();
        if (o() == true) goto L152;
        return;
    L152:
        if (this.c0 == true) goto L169;
        ALogger.i("RoomIndicatorHolder", "show new order");
        q();
        return;
    L169:
        return;
    L167:
        return;
    L128:
        if (r18.longValue() != r10) goto L140;
        if (this.Z == r8.getValue()) goto L140;
        if (this.b0 != 10) goto L140;
        Long r110 = r2.getStatus();
        if (r110 == null) goto L136;
        long r22 = r110.longValue();
    L137:
        this.Z = r22;
        if (this.c0 == true) goto L163;
        ALogger.i("RoomIndicatorHolder", "show update");
        m();
        return;
    L163:
        return;
    L136:
        r22 = BizStatus.UNKNOW.getValue();
        goto L137
    L70:
        if (r17.longValue() != r9) goto L124;
        if (this.Z == r8.getValue()) goto L124;
        if (this.b0 != 10) goto L124;
        Long r111 = r2.getStatus();
        if (r111 == null) goto L78;
        long r23 = r111.longValue();
    L79:
        this.Z = r23;
        this.X = 0;
        this.c0 = false;
        ALogger.i("RoomIndicatorHolder", "show end");
        i(1);
        Disposable r112 = this.V;
        if (r112 == null) goto L82;
        r112.dispose();
    L82:
        this.W.clear();
        LottieAnimationView r113 = this.F;
        if (r113 == null) goto L85;
        r113.cancelAnimation();
    L85:
        LottieAnimationView r114 = this.F;
        if (r114 == null) goto L88;
        r114.setVisibility(8);
    L88:
        ViewGroup r115 = this.n;
        if (r115 != null) goto L91;
    L108:
        TextSwitcher r116 = this.Q;
        if (r116 != null) goto L111;
    L123:
        CompositeDisposable r117 = this.W;
        Observable r24 = Observable.just(this);
        TimeUnit r25 = TimeUnit.MILLISECONDS;
        r117.add(r24.delay(5000, r25).compose(RxUtil.rxSchedulerHelper()).subscribe(new f0(this), RxUtil.getNoOpThrowable()));
        this.W.add(Observable.just(this).delay(9000, r25).compose(RxUtil.rxSchedulerHelper()).subscribe(new g0(this), RxUtil.getNoOpThrowable()));
        return;
    L111:
        if (r116.getVisibility() != 0) goto L123;
        TextSwitcher r118 = this.Q;
        if (r118 == null) goto L115;
        View r119 = r118.getCurrentView();
    L117:
        if ((r119 instanceof TextView) == false) goto L120;
        r0 = r119;
    L120:
        TextView r26 = (TextView) r0;
        if (r26 == null) goto L123;
        r26.setTextColor(s1.h(2131107305));
        goto L123
    L115:
        r119 = null;
        goto L117
    L91:
        if (r115.getVisibility() != 0) goto L108;
        List<TextSwitcher> r120 = this.S;
        if (r120 == null) goto L123;
        Iterator<T> r121 = r120.iterator();
    L96:
        if (r121.hasNext() == false) goto L123;
        TextSwitcher r27 = (TextSwitcher) r121.next();
        if (r27 == null) goto L100;
        View r28 = r27.getCurrentView();
    L102:
        if ((r28 instanceof TextView) == false) goto L96;
        View r29 = r27.getCurrentView();
        if (r29 == null) goto L107;
        ((TextView) r29).setTextColor(s1.h(2131107305));
        goto L96
    L107:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L100:
        r28 = null;
        goto L102
    L78:
        r23 = BizStatus.UNKNOW.getValue();
        goto L79
    L26:
        if (r16.longValue() != r6) goto L66;
        if (this.Z == r5.getValue()) goto L66;
        if (this.b0 != 11) goto L54;
        if (this.d0 == true) goto L54;
        Long r122 = r2.getStatus();
        if (r122 == null) goto L36;
        long r30 = r122.longValue();
    L37:
        this.Z = r30;
        ALogger.i("RoomIndicatorHolder", "show first start");
        this.d0 = true;
        ValueAnimator r123 = this.I;
        if (r123 == null) goto L40;
        r123.cancel();
    L40:
        ValueAnimator r124 = this.G;
        if (r124 == null) goto L43;
        r124.cancel();
    L43:
        this.W.clear();
        ValueAnimator r125 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.G = r125;
        if (r125 == null) goto L49;
        r125.addListener(new h0(this));
        r125.addUpdateListener(new i0(r125, this));
        if (this.c == true) goto L48;
        r125.setDuration(0);
        goto L49
    L48:
        r125.setDuration(500);
    L49:
        ValueAnimator r126 = this.G;
        if (r126 == null) goto L52;
        r126.start();
    L52:
        r();
    L62:
        Long r127 = r2.G();
        if (r127 == null) goto L65;
        r7 = r127.longValue();
    L65:
        String r128 = String.valueOf(r7);
        HashMap r32 = new HashMap();
        r32.put("biz_type", r128);
        int r129 = x81.c.a;
        x81.c.a("livesdk_audience_live_hot_indicator_show", this.f, null, r32);
        return;
    L36:
        r30 = BizStatus.UNKNOW.getValue();
    L54:
        if (this.Z != BizStatus.END.getValue()) goto L62;
        if (this.e0 == true) goto L62;
        Long r130 = r2.getStatus();
        if (r130 == null) goto L60;
        long r33 = r130.longValue();
    L61:
        this.Z = r33;
        ALogger.i("RoomIndicatorHolder", "show start after end");
        r();
        goto L62
    L60:
        r33 = BizStatus.UNKNOW.getValue();
    L21:
        r15 = true;
        goto L22
    L12:
        r4 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void p(int r4) {
        ViewGroup r0 = this.n;
        if (r0 != null) goto L5;
    L9:
        TextSwitcher r1 = this.Q;
        if (r1 == null) goto L20;
        if (r1.getVisibility() != 0) goto L20;
        TextSwitcher r2 = this.Q;
        if (r2 == null) goto L16;
        r2.setVisibility(8);
    L16:
        TextSwitcher r3 = this.Q;
        if (r3 == null) goto L20;
        r3.setCurrentText("");
    L20:
        if (TextUtils.equals("+", this.R) == true) goto L25;
        TextSwitcher r5 = this.P;
        if (r5 == null) goto L24;
        r5.setText("+");
    L24:
        this.R = "+";
    L25:
        w(this.K, r4, 1);
        w(this.L, r4, 10);
        w(this.M, r4, 100);
        w(this.N, r4, WebcastRedirectException.UNKNOWN);
        w(this.O, r4, 10000);
        this.a0 = r4;
        return;
    L5:
        if (r0.getVisibility() != 8) goto L9;
        ViewGroup r6 = this.n;
        if (r6 == null) goto L9;
        r6.setVisibility(0);
        goto L9
    }

    public final void t(boolean r7) {
        BizContentType r0 = this.B;
        int r1 = e0.d[r0.ordinal()];
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L6;
        ALogger.i("RoomIndicatorHolder", "first line ----- illegal new order data type");
    L15:
        BizContentType r8 = this.C;
        int r9 = e0.e[r8.ordinal()];
        if (r9 == 1) goto L20;
        if (r9 == 2) goto L19;
        ALogger.i("RoomIndicatorHolder", "second line ----- illegal new order data type");
        return;
    L19:
        s(this.s, this.U);
        py.k r10 = (py.k) ListProtector.remove(this.y, 0);
        n(this.s, r10);
        return;
    L20:
        s(this.t, this.U);
        String r12 = (String) ListProtector.remove(this.x, 0);
        TextView r2 = this.t;
        if (r2 == null) goto L26;
        r2.setText(r12);
        return;
    L26:
        return;
    L6:
        s(this.r, this.T);
        py.k r13 = (py.k) ListProtector.remove(this.w, 0);
        n(this.r, r13);
        goto L15
    L7:
        s(this.q, this.T);
        String r3 = (String) ListProtector.remove(this.v, 0);
        if (r7 == false) goto L12;
        TextSwitcher r14 = this.q;
        if (r14 == null) goto L15;
        r14.setCurrentText(r3);
        goto L15
    L12:
        TextSwitcher r15 = this.q;
        if (r15 == null) goto L15;
        r15.setText(r3);
        goto L15
    }

    public static void s(View r3, List r4) {
        if (r4 == null) goto L20;
        Iterator r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L38;
        View r0 = (View) r5.next();
        if (Intrinsics.areEqual(r0, r3) == false) goto L14;
        if (r0 == null) goto L11;
        if (r0.getVisibility() == 0) goto L14;
    L11:
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r0, true);
    L14:
        if ((!Intrinsics.areEqual(r0, r3)) == false) goto L5;
        if (r0 == null) goto L18;
        if (r0.getVisibility() == 8) goto L5;
    L18:
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r0, false);
        goto L5
    L38:
        return;
    }

    public static void v(View r3, float r4) {
        if ((r3 instanceof ViewGroup) == false) goto L8;
        ViewGroup r5 = (ViewGroup) r3;
        int r0 = r5.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        v(r5.getChildAt(r1), r4);
        r1 = r1 + 1;
        goto L5
    L13:
        return;
    L8:
        if ((r3 instanceof View) == false) goto L12;
        r3.setAlpha(r4);
        return;
    }

    public final void n(ImageView r4, py.k r5) {
        if (r5 == null) goto L22;
        if (r4 == null) goto L5;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
    L6:
        int r1 = -2;
        if (r0 != null) goto L9;
    L13:
        if (r0 != null) goto L15;
    L18:
        if (r4 == null) goto L20;
        r4.setLayoutParams(r0);
    L20:
        Disposable r6 = a1.k(r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r4), new c(r4));
        Intrinsics.checkNotNullParameter(r6, "$this$autoBind");
        this.b.add(r6);
        return;
    L15:
        if (r5.getHeight() <= 0) goto L17;
        r1 = UtilityKotlinExtentionsKt.i(r5.getHeight());
    L17:
        r0.height = r1;
        goto L18
    L9:
        if (r5.getWidth() <= 0) goto L11;
        int r2 = UtilityKotlinExtentionsKt.i(r5.getWidth());
    L12:
        r0.width = r2;
        goto L13
    L11:
        r2 = -2;
        goto L12
    L5:
        r0 = null;
        goto L6
    }

    public final void w(TextSwitcher r4, int r5, int r6) {
        if (r4 == null) goto L19;
        int r0 = this.a0;
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

    public static final void k(d0 r1, ViewGroup r2, int r3, int r4) {
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

    public d0(DataCenter r2, View r3, int r4, View r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r5, "parentView");
        super(r2, r3, r5);
        this.g0 = r6;
        this.j = r4;
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.y = new ArrayList();
        BizContentType r7 = BizContentType.UNKNOW;
        this.A = r7;
        this.B = r7;
        this.C = r7;
        this.W = new CompositeDisposable();
        this.Z = BizStatus.UNKNOW.getValue();
        this.a0 = -1;
        this.b0 = 11;
    }
}
