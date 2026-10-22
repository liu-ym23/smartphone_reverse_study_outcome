package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.midi.KSongToneLinesView;
import com.bytedance.android.live.ktv.common.midi.j;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/v2/KtvMidiViewV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lqb0/b;", "Lkotlin/Pair;", "", "getTimeRange", "Lcom/bytedance/android/live/ktv/common/midi/g;", "strategy", "", "setPerformStrategy", "interval", "setScoreInterval", "Ljava/text/DecimalFormat;", "H", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "df", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiViewV2 extends ConstraintLayout implements qb0.b {
    public static final /* synthetic */ int O = 0;
    public final int A;
    public final Handler B;
    public ConstraintLayout C;
    public TextView D;
    public ImageView E;
    public View F;
    public float G;
    public final DecimalFormat H;
    public com.bytedance.android.live.ktv.common.midi.g I;
    public int J;
    public com.bytedance.android.live.ktv.common.midi.f K;
    public MidiSkinDressInfo L;
    public k M;
    public final i N;
    public final com.bytedance.android.live.ktv.common.midi.d a;
    public final boolean b;
    public long c;
    public db0.a d;
    public Disposable e;
    public ValueAnimator f;
    public int g;
    public int h;
    public Integer i;
    public Disposable j;
    public long k;
    public ImageView l;
    public ImageView m;
    public HSImageView n;
    public KSongToneLinesView o;
    public int p;
    public int q;
    public int r;
    public int s;
    public final com.bytedance.android.live.ktv.common.midi.d t;
    public final int u;
    public int v;
    public AnimatorSet w;
    public AnimatorSet x;
    public boolean y;
    public final int z;

    public static final class a implements Handler.Callback {
        public final /* synthetic */ KtvMidiViewV2 a;

        /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.midi.v2.KtvMidiViewV2$a$a, reason: collision with other inner class name */
        public static final class RunnableC0209a implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ Ref.IntRef b;

            /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.midi.v2.KtvMidiViewV2$a$a$a, reason: collision with other inner class name */
            public static final class C0210a implements ValueAnimator.AnimatorUpdateListener {
                public final /* synthetic */ RunnableC0209a a;

                public C0210a(RunnableC0209a r1) {
                    this.a = r1;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator r5) {
                    Intrinsics.checkNotNullParameter(r5, "it");
                    ImageView r0 = this.a.a.a.m;
                    if (r0 == null) goto L9;
                    Object r2 = r5.getAnimatedValue();
                    if (r2 == null) goto L8;
                    r0.setY(((Float) r2).floatValue());
                    goto L9
                L8:
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                L9:
                    ImageView r1 = this.a.a.a.l;
                    if (r1 == null) goto L16;
                    Object r3 = r5.getAnimatedValue();
                    if (r3 == null) goto L15;
                    float r4 = ((Float) r3).floatValue();
                    ImageView r6 = this.a.a.a.m;
                    Intrinsics.checkNotNull(r6);
                    float r7 = r4 + (r6.getHeight() / 2);
                    ImageView r8 = this.a.a.a.l;
                    Intrinsics.checkNotNull(r8);
                    r1.setY(r7 - (r8.getHeight() / 2));
                    goto L16
                L15:
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                L16:
                    ConstraintLayout r9 = this.a.a.a.C;
                    if (r9 == null) goto L23;
                    Object r11 = r5.getAnimatedValue();
                    if (r11 == null) goto L22;
                    float r12 = ((Float) r11).floatValue();
                    ConstraintLayout r13 = this.a.a.a.C;
                    Intrinsics.checkNotNull(r13);
                    r9.setY(r12 - r13.getHeight());
                    return;
                L22:
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
            }

            public RunnableC0209a(a r1, Ref.IntRef r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                Ref.LongRef r0 = new Ref.LongRef();
                int r1 = this.a.a.p;
                int r2 = this.b.element;
                long r3 = 100;
                if (r1 > r2) goto L6;
                r3 = Math.max((long) (Math.abs(r1 - r2) * 4.0f), 100);
            L6:
                r0.element = r3;
                KtvMidiViewV2 r4 = this.a.a;
                if (KtvSettingHelper.z() == false) goto L9;
                ValueAnimator r5 = LiveDegradeFpsAnimator.ofFloat(new float[]{this.a.a.p, this.b.element});
            L10:
                r5.setDuration(r0.element);
                r5.setInterpolator(new LinearInterpolator());
                r5.setEvaluator(new com.bytedance.android.live.ktv.common.midi.v2.h());
                r5.addUpdateListener(new C0210a(this));
                Unit r6 = Unit.INSTANCE;
                r4.f = r5;
                ValueAnimator r7 = this.a.a.f;
                if (r7 == null) goto L13;
                r7.start();
            L13:
                this.a.a.p = this.b.element;
                return;
            L9:
                r5 = ValueAnimator.ofFloat(new float[]{this.a.a.p, this.b.element});
                goto L10
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(KtvMidiViewV2 r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r11v1, types: [android.view.ViewGroup, com.bytedance.android.live.ktv.common.midi.v2.KtvMidiViewV2] */
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r11) {
            Intrinsics.checkNotNullParameter(r11, "msg");
            int r0 = r11.what;
            if (r0 == 0) goto L41;
            if (r0 != 1) goto L6;
            KtvMidiViewV2 r12 = this.a;
            r12.y = false;
            AnimatorSet r1 = r12.x;
            if (r1 != null) goto L18;
        L20:
            AnimatorSet r2 = r12.w;
            if (r2 != null) goto L23;
        L27:
            Ref.ObjectRef r3 = new Ref.ObjectRef();
            if (KtvSettingHelper.z() == false) goto L30;
            ValueAnimator r7 = LiveDegradeFpsAnimator.ofFloat(r12.l, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
        L31:
            r7.setDuration(500);
            r7.setInterpolator(new LinearInterpolator());
            Unit r8 = Unit.INSTANCE;
            r3.element = r7;
            Ref.ObjectRef r9 = new Ref.ObjectRef();
            if (KtvSettingHelper.z() == false) goto L34;
            ValueAnimator r4 = LiveDegradeFpsAnimator.ofFloat(r12.n, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
        L35:
            r4.setDuration(500);
            r4.setInterpolator(new LinearInterpolator());
            r9.element = r4;
            com.bytedance.android.live.ktv.common.midi.g r5 = r12.I;
            if (r5 != null) goto L38;
        L40:
            AnimatorSet r6 = new AnimatorSet();
            r6.playTogether(new Animator[]{(ValueAnimator) r3.element, (ValueAnimator) r9.element});
            r6.addListener(new com.bytedance.android.live.ktv.common.midi.v2.c(r12));
            r12.x = r6;
            r6.start();
        L106:
            return true;
        L38:
            if (r5.getCurrentMode() != 1) goto L40;
            AnimatorSet r13 = new AnimatorSet();
            r13.playTogether(new Animator[]{(ValueAnimator) r3.element});
            r13.addListener(new com.bytedance.android.live.ktv.common.midi.v2.b(r12));
            r12.x = r13;
            r13.start();
            goto L106
        L34:
            r4 = ObjectAnimator.ofFloat(r12.n, View.ALPHA, new float[]{1.0f, 0.0f});
            goto L35
        L30:
            r7 = ObjectAnimator.ofFloat(r12.l, View.ALPHA, new float[]{1.0f, 0.0f});
            goto L31
        L23:
            if (r2.isRunning() != true) goto L27;
            AnimatorSet r14 = r12.w;
            if (r14 == null) goto L27;
            r14.cancel();
            goto L27
        L18:
            if (r1.isRunning() != true) goto L20;
        L6:
            if (r0 != 3) goto L106;
            Ref.IntRef r15 = new Ref.IntRef();
            Object r16 = r11.obj;
            if (r16 == null) goto L14;
            r15.element = ((Integer) r16).intValue();
            com.bytedance.android.live.ktv.common.midi.e.b("KtvMidiViewV2", "tonePoint?.post");
            ImageView r17 = this.a.m;
            if (r17 == null) goto L106;
            r17.post(new RunnableC0209a(this, r15));
            goto L106
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L41:
            ?? r18 = this.a;
            r18.y = true;
            AnimatorSet r19 = r18.w;
            if (r19 != null) goto L44;
        L46:
            AnimatorSet r21 = r18.x;
            if (r21 == null) goto L54;
            if (r21.isRunning() != true) goto L54;
            AnimatorSet r22 = r18.x;
            if (r22 == null) goto L54;
            r22.cancel();
        L54:
            if (KtvSettingHelper.z() == false) goto L56;
            ValueAnimator r23 = LiveDegradeFpsAnimator.ofFloat(r18.l, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
        L57:
            r23.setDuration(500);
            r23.setInterpolator(new LinearInterpolator());
            Unit r24 = Unit.INSTANCE;
            if (KtvSettingHelper.z() == false) goto L60;
            ValueAnimator r25 = LiveDegradeFpsAnimator.ofFloat(r18.n, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
        L61:
            r25.setDuration(500);
            r25.setInterpolator(new LinearInterpolator());
            com.bytedance.android.live.ktv.common.midi.g r26 = r18.I;
            if (r26 != null) goto L64;
        L77:
            AnimatorSet r27 = new AnimatorSet();
            r27.playTogether(new Animator[]{r23, r25});
            r18.w = r27;
            com.bytedance.android.live.ktv.common.midi.g r28 = r18.I;
            if (r28 == null) goto L81;
            k r29 = r28.G();
            if (r29 == null) goto L81;
        L90:
            if (r18.b == false) goto L97;
            if (r29 == null) goto L97;
            if (Intrinsics.areEqual(r18.M, r29) == false) goto L97;
            com.bytedance.android.live.ktv.common.midi.d r110 = r18.a;
            if (r110 == null) goto L106;
            r110.onFinalImageSet("", null, null);
        L97:
            r18.M = r29;
            if (r18.T5() == false) goto L100;
            FrescoLoader.with(r18.getContext()).load(r29).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(r18.a).into(r18.n);
            goto L106
        L100:
            com.bytedance.android.live.ktv.common.midi.g r31 = r18.I;
            if (r31 != null) goto L103;
        L105:
            FrescoLoader.with(r18.getContext()).load(com.bytedance.android.live.ktv.common.midi.c.d).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(r18.t).into(r18.n);
            goto L106
        L103:
            if (r31.getCurrentMode() != 2) goto L105;
            FrescoLoader.with(r18.getContext()).load(j.c).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(r18.t).into(r18.n);
        L81:
            MidiSkinDressInfo r32 = r18.L;
            if (r32 == null) goto L88;
            MidiSkinMaterial r33 = r32.getMaterial();
            if (r33 == null) goto L88;
            BackgroundMaterial r34 = r33.getBg();
            if (r34 == null) goto L88;
            r29 = r34.getBuoyAreaBg();
        L88:
            r29 = null;
            goto L90
        L64:
            if (r26.getCurrentMode() != 1) goto L77;
            AnimatorSet r35 = new AnimatorSet();
            r35.playTogether(new Animator[]{r23});
            r18.w = r35;
            com.bytedance.android.live.ktv.common.midi.f r36 = r18.K;
            if (r36 != null) goto L69;
        L73:
            KtvMidiViewV2.S5(r18.l);
        L74:
            AnimatorSet r111 = r18.w;
            if (r111 == null) goto L106;
            r111.start();
            goto L106
        L69:
            if (r36.c() != true) goto L73;
            ImageView r37 = r18.l;
            if (r37 == null) goto L74;
            r37.setVisibility(0);
            goto L74
        L60:
            r25 = ObjectAnimator.ofFloat(r18.n, View.ALPHA, new float[]{0.0f, 1.0f});
            goto L61
        L56:
            r23 = ObjectAnimator.ofFloat(r18.l, View.ALPHA, new float[]{0.0f, 1.0f});
            goto L57
        L44:
            if (r19.isRunning() != true) goto L46;
            goto L46
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ KtvMidiViewV2 a;

        public c(KtvMidiViewV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(this.a.N);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvMidiViewV2 a;
        public final /* synthetic */ long b;

        public d(KtvMidiViewV2 r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            List<cb0.c> r5 = (List) r4;
            KSongToneLinesView r0 = this.a.o;
            if (r0 == null) goto L6;
            r0.d(this.b, r5);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ KtvMidiViewV2 a;

        public f(KtvMidiViewV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(this.a.N);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ KtvMidiViewV2 a;

        public g(KtvMidiViewV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r17) {
            cb0.c r0 = (cb0.c) r17;
            KtvMidiViewV2 r2 = this.a;
            int r3 = KtvMidiViewV2.O;
            r2.getClass();
            List<cb0.a> r4 = r0.c;
            if (r4 != null) goto L5;
            r4 = new CopyOnWriteArrayList();
        L5:
            long r5 = r2.c;
            r4.add(new cb0.a(r5, Math.min(r2.k + r5, r0.a.b)));
            int r6 = 1;
            if (r4.size() <= 1) goto L16;
            CopyOnWriteArrayList r7 = new CopyOnWriteArrayList();
            long r8 = ((cb0.a) ListProtector.get(r4, 0)).a;
            long r9 = ((cb0.a) ListProtector.get(r4, 0)).b;
            cb0.a r11 = new cb0.a(r8, r9);
            r7.add(r11);
            int r12 = r4.size();
        L9:
            if (r6 >= r12) goto L15;
            cb0.a r13 = (cb0.a) ListProtector.get(r4, r6);
            long r14 = r13.a;
            KtvMidiViewV2 r18 = r2;
            if (r14 > ((r2.k * ((long) 2)) + r9)) goto L13;
            long r1 = Math.max(r13.b, r9);
            r11.b = r1;
        L14:
            r9 = r1;
            r6 = r6 + 1;
            r2 = r18;
            goto L9
        L13:
            r1 = r13.b;
            r11 = new cb0.a(r14, r1);
            r7.add(r11);
            goto L14
        L15:
            r4 = r7;
        L16:
            r0.c = r4;
        }
    }

    public static final class h<T> implements Consumer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class i implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ KtvMidiViewV2 a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            com.bytedance.android.live.ktv.common.midi.g r0 = this.a.I;
            if (r0 != null) goto L5;
        L7:
            KtvMidiViewV2.R5(this.a, 1360, 3470);
        L8:
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L5:
            if (r0.getCurrentMode() != 1) goto L7;
            KtvMidiViewV2.R5(this.a, 1000, 2500);
            goto L8
        }

        public i(KtvMidiViewV2 r1) {
            this.a = r1;
        }
    }

    static {
    }

    public KtvMidiViewV2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvMidiViewV2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // qb0.b
    public final void detach() {
        this.d = null;
        this.I = null;
        Handler r0 = this.B;
        if (r0 == null) goto L5;
        r0.removeMessages(0);
    L5:
        Handler r1 = this.B;
        if (r1 == null) goto L9;
        r1.removeMessages(1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qb0.b
    public final void show() {
        setVisibility(0);
    }

    @Override // qb0.b
    public final void S3() {
        db0.a r0 = this.d;
        if (r0 == null) goto L13;
        Disposable r1 = this.j;
        if (r1 != null) goto L7;
    L11:
        this.j = r0.findMidiSegment(this.c).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this), h.a);
        return;
    L7:
        if (r1.isDisposed() == true) goto L11;
        Disposable r2 = this.j;
        if (r2 == null) goto L11;
        r2.dispose();
        goto L11
    }

    public final boolean T5() {
        MidiSkinDressInfo r0 = this.L;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getDressId();
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        MidiSkinDressInfo r3 = this.L;
        if (r3 == null) goto L12;
        r1 = r3.getDressId();
    L12:
        if ((!Intrinsics.areEqual(r1, "0")) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    @Override // qb0.b
    public final void clear() {
        KSongToneLinesView r0 = this.o;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        qb0.b.a.a(this, 0.0f, this.h, 0.0f, false, false, 28);
        this.G = -1.0f;
        this.J = 1;
        S5(this.n);
        S5(this.l);
        TextView r1 = this.D;
        if (r1 == null) goto L8;
        r1.setText(s1.B(2131918567));
    L8:
        Integer r2 = this.i;
        if (r2 != null) goto L12;
    L13:
        TextView r3 = this.D;
        if (r3 == null) goto L16;
        r3.setTypeface(Typeface.defaultFromStyle(0));
    L16:
        this.i = 0;
    L17:
        com.bytedance.android.live.ktv.common.midi.g r4 = this.I;
        if (r4 != null) goto L20;
    L31:
        ImageView r5 = this.E;
        if (r5 == null) goto L34;
        r5.setImageResource(2131252046);
    L34:
        TextView r6 = this.D;
        if (r6 == null) goto L40;
        r6.setTextColor(s1.h(2131107710));
        return;
    L40:
        return;
    L20:
        if (r4.getCurrentMode() != 2) goto L31;
        ImageView r7 = this.E;
        if (r7 == null) goto L24;
        r7.setImageResource(2131252041);
    L24:
        TextView r8 = this.D;
        if (r8 == null) goto L38;
        com.bytedance.android.live.ktv.common.midi.g r9 = this.I;
        if (r9 == null) goto L29;
        int r11 = r9.B();
    L30:
        r8.setTextColor(r11);
        return;
    L29:
        r11 = s1.h(2131106997);
        goto L30
    L38:
        return;
    L12:
        if (r2.intValue() == 0) goto L17;
        goto L13
    }

    public final Pair<Long, Long> getTimeRange() {
        com.bytedance.android.live.ktv.common.midi.g r0 = this.I;
        if (r0 == null) goto L8;
        if (r0.getCurrentMode() != 1) goto L8;
        return new Pair(1000L, 2500L);
    L8:
        return new Pair(1360L, 3470L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qb0.b
    public final void hide() {
        setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.j;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        ValueAnimator r2 = this.f;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        AnimatorSet r3 = this.x;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        AnimatorSet r4 = this.w;
        if (r4 == null) goto L18;
        r4.cancel();
        return;
    }

    public final DecimalFormat getDf() {
        return this.H;
    }

    public static void S5(View r1) {
        if (r1 == null) goto L5;
        r1.setVisibility(8);
        return;
    }

    @Override // qb0.b
    public final void D3(long r6) {
        this.c = r6;
        Disposable r0 = this.e;
        if (r0 != null) goto L5;
    L9:
        db0.a r1 = this.d;
        if (r1 == null) goto L23;
        com.bytedance.android.live.ktv.common.midi.g r2 = this.I;
        if (r2 != null) goto L14;
    L18:
        Single<List<cb0.c>> r3 = r1.findMidiSegments(r6 - 1360, 3470 + r6);
        if (r3 != null) goto L21;
        return;
    L21:
        this.e = r3.compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r6), e.a);
        return;
    L14:
        if (r2.getCurrentMode() != 1) goto L18;
        r3 = r1.findMidiSegments(r6 - 1000, 2500 + r6);
        if (r3 != null) goto L21;
        return;
    L23:
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r4 = this.e;
        if (r4 == null) goto L9;
        r4.dispose();
        goto L9
    }

    @Override // qb0.b
    public final void J3(long r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPerformStrategy(com.bytedance.android.live.ktv.common.midi.g r3) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        this.I = r3;
        TextView r0 = this.D;
        if (r0 == null) goto L5;
        r0.setTextColor(r3.B());
    L5:
        y(r3.z());
        postDelayed(new f(this), 100);
    }

    @Override // qb0.b
    public void setScoreInterval(long r1) {
        this.k = r1;
    }

    @Override // qb0.b
    public final void y(MidiSkinDressInfo r4) {
        this.L = r4;
        String r0 = null;
        if (T5() == false) goto L38;
        ImageView r5 = this.l;
        MidiSkinDressInfo r1 = this.L;
        if (r1 == null) goto L11;
        MidiSkinMaterial r2 = r1.getMaterial();
        if (r2 == null) goto L11;
        BuoyMaterial r3 = r2.getBuoy();
        if (r3 == null) goto L11;
        k r6 = r3.getBuoyTailing();
    L12:
        ImageUtil.loadImage(r5, r6, 0);
        ImageView r7 = this.m;
        MidiSkinDressInfo r8 = this.L;
        if (r8 == null) goto L19;
        MidiSkinMaterial r9 = r8.getMaterial();
        if (r9 == null) goto L19;
        BuoyMaterial r11 = r9.getBuoy();
        if (r11 == null) goto L19;
        k r12 = r11.getBuoyBall();
    L20:
        ImageUtil.loadImage(r7, r12, 0);
        KSongToneLinesView r13 = this.o;
        if (r13 == null) goto L60;
        MidiSkinDressInfo r14 = this.L;
        if (r14 == null) goto L29;
        MidiSkinMaterial r15 = r14.getMaterial();
        if (r15 == null) goto L29;
        BackgroundMaterial r16 = r15.getBg();
        if (r16 == null) goto L29;
        String r17 = r16.getToneLineStart();
    L30:
        MidiSkinDressInfo r18 = this.L;
        if (r18 == null) goto L37;
        MidiSkinMaterial r19 = r18.getMaterial();
        if (r19 == null) goto L37;
        BackgroundMaterial r21 = r19.getBg();
        if (r21 == null) goto L37;
        r0 = r21.getToneLineEnd();
    L37:
        r13.o = TuplesKt.to(r17, r0);
    L29:
        r17 = null;
    L60:
        TextView r22 = this.D;
        if (r22 == null) goto L68;
        com.bytedance.android.live.ktv.common.midi.g r23 = this.I;
        if (r23 == null) goto L65;
        int r24 = r23.B();
    L66:
        r22.setTextColor(r24);
        return;
    L65:
        r24 = s1.h(2131106997);
        goto L66
    L68:
        return;
    L19:
        r12 = null;
    L11:
        r6 = null;
        goto L12
    L38:
        com.bytedance.android.live.ktv.common.midi.g r25 = this.I;
        if (r25 != null) goto L41;
    L51:
        ImageView r26 = this.l;
        if (r26 == null) goto L54;
        r26.setImageResource(2131252080);
    L54:
        ImageView r27 = this.m;
        if (r27 == null) goto L57;
        r27.setImageResource(2131252079);
    L57:
        KSongToneLinesView r28 = this.o;
        if (r28 == null) goto L60;
        r28.o = null;
        goto L60
    L41:
        if (r25.getCurrentMode() != 2) goto L51;
        ImageView r29 = this.l;
        if (r29 == null) goto L45;
        r29.setImageResource(2131250224);
    L45:
        KSongToneLinesView r31 = this.o;
        if (r31 == null) goto L60;
        com.bytedance.android.live.ktv.common.midi.g r32 = this.I;
        if (r32 == null) goto L50;
        r0 = r32.E();
    L50:
        r31.o = r0;
        goto L60
    }

    @Override // qb0.b
    public final void D5(int r3, int r4) {
        this.g = r3;
        this.h = r4;
        KSongToneLinesView r0 = this.o;
        if (r0 == null) goto L6;
        r0.g = r3;
        r0.h = r4;
        r0.m = r0.n / (r4 - r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qb0.b
    public final void f0(db0.a r7, com.bytedance.android.live.ktv.common.midi.g r8) {
        Intrinsics.checkNotNullParameter(r7, "midiDataHolder");
        Intrinsics.checkNotNullParameter(r8, "strategy");
        this.d = r7;
        this.I = r8;
        if (r8 != null) goto L5;
    L12:
        com.bytedance.android.live.ktv.common.midi.g r9 = this.I;
        if (r9 != null) goto L15;
    L22:
        KSongToneLinesView r11 = this.o;
        if (r11 == null) goto L25;
        r11.e(1360, 3470);
    L25:
        ConstraintLayout r12 = this.C;
        if (r12 == null) goto L28;
        r12.setVisibility(8);
    L28:
        com.bytedance.android.live.ktv.common.midi.g r13 = this.I;
        if (r13 != null) goto L31;
    L38:
        this.v = 0 - this.u;
    L39:
        postDelayed(new c(this), 100);
        com.bytedance.android.live.ktv.common.midi.e.b("KtvMidiViewV2", "initView topAdapter : " + this.v);
        return;
    L31:
        if (r13.L() != true) goto L38;
        com.bytedance.android.live.ktv.common.midi.g r14 = this.I;
        if (r14 != null) goto L35;
    L37:
        this.v = s1.f(19.0f) - this.u;
        goto L39
    L35:
        if (r14.getCurrentMode() != 2) goto L37;
        this.v = 0 - this.u;
        goto L39
    L15:
        if (r9.getCurrentMode() != 1) goto L22;
        KSongToneLinesView r15 = this.o;
        if (r15 == null) goto L19;
        r15.e(1000, 2500);
    L19:
        View r16 = this.F;
        if (r16 == null) goto L28;
        r16.setVisibility(8);
        goto L28
    L5:
        if (r8.getCurrentMode() != 2) goto L12;
        UIUtils.updateLayout(this.o, -3, -1);
        KSongToneLinesView r17 = this.o;
        if (r17 == null) goto L9;
        r17.n = s1.f(18.0f);
    L9:
        KSongToneLinesView r18 = this.o;
        if (r18 == null) goto L12;
        r18.d = s1.j(2131169113);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvMidiViewV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvMidiViewV2$midiHitAnimCallback$1(this));
        this.b = ((Boolean) vm2.h.G1.getValue(null, vm2.h.a[135(0x87, float:1.89E-43)])).booleanValue();
        this.g = 58;
        this.h = 90;
        this.k = vm2.h.D();
        this.t = com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvMidiViewV2$hitAnimationCallback$1(this));
        this.u = s1.f(9.0f);
        this.v = s1.f(14.0f);
        s1.f(92.0f);
        this.z = vm2.h.H();
        this.A = vm2.h.J();
        this.G = -1.0f;
        this.H = new DecimalFormat("#0.0");
        this.J = 1;
        this.N = new i(this);
        this.B = new Handler(Looper.getMainLooper(), new a(this));
        ViewGroup.inflate(r2, 2131566502, this);
        this.n = (HSImageView) findViewById(2131380108);
        this.m = (ImageView) findViewById(2131389046);
        this.l = (ImageView) findViewById(2131389047);
        this.o = (KSongToneLinesView) findViewById(2131389045);
        this.C = findViewById(2131376909);
        this.D = (TextView) findViewById(2131376910);
        this.E = (ImageView) findViewById(2131376908);
        this.F = findViewById(2131380102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void R5(KtvMidiViewV2 r5, long r6, long r8) {
        long r9 = r8 + r6;
        int r0 = r5.getWidth();
        if (r0 == 0) goto L36;
        ImageView r1 = r5.m;
        ViewGroup.LayoutParams r2 = null;
        if (r1 == null) goto L8;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
    L10:
        if ((r3 instanceof ConstraintLayout.LayoutParams) == true) goto L12;
        r3 = null;
    L12:
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
        ImageView r7 = r5.l;
        if (r7 == null) goto L15;
        ViewGroup.LayoutParams r11 = r7.getLayoutParams();
    L17:
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        r2 = r11;
    L20:
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r2;
        float r13 = (r0 * r6) / r9;
        ImageView r14 = r5.m;
        if (r14 == null) goto L23;
        int r15 = r14.getWidth();
    L24:
        if (r4 == null) goto L26;
        r4.setMarginStart((int) (r13 - (r15 / 2)));
    L26:
        if (r12 == null) goto L28;
        r12.setMarginStart((int) (r13 - s1.e(55.0f)));
    L28:
        ImageView r16 = r5.m;
        if (r16 == null) goto L31;
        r16.setLayoutParams(r4);
    L31:
        ImageView r17 = r5.l;
        if (r17 == null) goto L35;
        r17.setLayoutParams(r12);
        return;
    L35:
        return;
    L23:
        r15 = 0;
        goto L24
    L15:
        r11 = null;
        goto L17
    L8:
        r3 = null;
        goto L10
    }

    public /* synthetic */ KtvMidiViewV2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qb0.b
    public final Pair<Float, Float> l1(float r8, float r9, float r11, boolean r12, boolean r13) {
        com.bytedance.android.live.ktv.common.midi.g r0 = this.I;
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentMode();
    L7:
        if (r1 != 1) goto L14;
        com.bytedance.android.live.ktv.common.midi.f r2 = this.K;
        if (r2 != null) goto L11;
    L13:
        boolean r3 = false;
    L15:
        com.bytedance.android.live.ktv.common.midi.g r4 = this.I;
        if (r4 != null) goto L18;
    L24:
        boolean r5 = false;
    L25:
        Message r6 = null;
        if (r3 == false) goto L65;
        if (r12 == true) goto L65;
        float r14 = 0;
        if (r8 > r14) goto L31;
    L35:
        boolean r15 = false;
    L37:
        if (r15 == true) goto L39;
    L51:
        if (r15 == true) goto L65;
        if (this.y == false) goto L65;
        Handler r16 = this.B;
        if (r16 == null) goto L57;
        Message r17 = r16.obtainMessage(1);
    L58:
        Handler r7 = this.B;
        if (r7 == null) goto L61;
        r7.removeMessages(0);
    L61:
        if (r17 == null) goto L65;
        Handler r18 = this.B;
        if (r18 == null) goto L65;
        r18.sendMessageDelayed(r17, 300);
        goto L65
    L57:
        r17 = null;
        goto L58
    L39:
        if (this.y == true) goto L51;
        Handler r19 = this.B;
        if (r19 == null) goto L43;
        Message r110 = r19.obtainMessage(0);
    L44:
        Handler r21 = this.B;
        if (r21 == null) goto L47;
        r21.removeMessages(1);
    L47:
        if (r110 == null) goto L65;
        Handler r22 = this.B;
        if (r22 == null) goto L65;
        r22.sendMessageDelayed(r110, 300);
        goto L65
    L43:
        r110 = null;
        goto L44
    L31:
        if (r9 <= r14) goto L35;
        if (Math.abs(r8 - r9) > ((Number) KtvSettingHelper.C0.getValue()).intValue()) goto L35;
        r15 = true;
    L65:
        if (r5 == false) goto L147;
        ConstraintLayout r111 = this.C;
        if (r111 == null) goto L70;
        r111.setVisibility(0);
    L70:
        if (r11 > 0) goto L72;
    L149:
        int r112 = this.r % this.z;
        this.r = r112 + 1;
        if (r112 != 0) goto L185;
        if (getVisibility() != 0) goto L185;
        if (r8 >= this.g) goto L157;
    L160:
        int r23 = this.s + 1;
        this.s = r23;
        if (r23 < this.A) goto L163;
    L164:
        KSongToneLinesView r24 = this.o;
        Intrinsics.checkNotNull(r24);
        int r25 = r24.f((int) r9) + this.v;
        this.q = r25;
        ValueAnimator r26 = this.f;
        if (r26 == null) goto L169;
        if (r26.isRunning() != true) goto L169;
    L183:
        return new Pair(Float.valueOf(s1.f(92.0f)), Float.valueOf(this.q));
    L169:
        if (this.p == r25) goto L183;
        Handler r27 = this.B;
        if (r27 == null) goto L173;
        r6 = r27.obtainMessage(3);
    L173:
        if (r6 == null) goto L175;
        r6.obj = Integer.valueOf(this.q);
    L175:
        Handler r28 = this.B;
        if (r28 == null) goto L178;
        r28.removeMessages(3);
    L178:
        if (r6 == null) goto L183;
        Handler r29 = this.B;
        if (r29 == null) goto L183;
        r29.sendMessage(r6);
        goto L183
    L163:
        return new Pair(Float.valueOf(s1.f(92.0f)), Float.valueOf(this.q));
    L157:
        if (r8 > this.h) goto L160;
        this.s = 0;
    L185:
        return new Pair(Float.valueOf(s1.f(92.0f)), Float.valueOf(this.q));
    L72:
        if (r11 == this.G) goto L149;
        if (r11 == 0.0f) goto L149;
        this.G = r11;
        ConstraintLayout r113 = this.C;
        if (r113 == null) goto L78;
        r113.setVisibility(0);
    L78:
        Integer r114 = this.i;
        if (r114 != null) goto L82;
    L83:
        TextView r115 = this.D;
        if (r115 == null) goto L86;
        r115.setTypeface(Typeface.defaultFromStyle(2));
    L86:
        this.i = 2;
    L87:
        float r116 = this.G;
        if (((int) r116) < 100) goto L92;
        TextView r117 = this.D;
        if (r117 == null) goto L95;
        r117.setText("100");
    L95:
        ImageView r118 = this.E;
        if (r118 == null) goto L98;
        r118.setVisibility(0);
    L98:
        TextView r119 = this.D;
        if (r119 == null) goto L101;
        r119.setBackground(null);
    L101:
        com.bytedance.android.live.ktv.common.midi.g r120 = this.I;
        if (r120 != null) goto L104;
    L115:
        int r121 = this.J;
        if (r121 == 1) goto L134;
        if (r121 != 2) goto L149;
        if (this.G < vm2.h.z()) goto L127;
        ImageView r122 = this.E;
        if (r122 == null) goto L124;
        r122.setImageResource(2131252042);
    L124:
        TextView r123 = this.D;
        if (r123 == null) goto L149;
        r123.setTextColor(s1.h(2131107709));
        goto L149
    L127:
        ImageView r124 = this.E;
        if (r124 == null) goto L130;
        r124.setImageResource(2131252044);
    L130:
        TextView r125 = this.D;
        if (r125 == null) goto L149;
        r125.setTextColor(s1.h(2131107710));
        goto L149
    L134:
        if (this.G < vm2.h.z()) goto L141;
        ImageView r126 = this.E;
        if (r126 == null) goto L138;
        r126.setImageResource(2131252043);
    L138:
        TextView r127 = this.D;
        if (r127 == null) goto L149;
        r127.setTextColor(s1.h(2131107709));
        goto L149
    L141:
        ImageView r128 = this.E;
        if (r128 == null) goto L144;
        r128.setImageResource(2131252041);
    L144:
        TextView r129 = this.D;
        if (r129 == null) goto L149;
        r129.setTextColor(s1.h(2131107710));
        goto L149
    L104:
        if (r120.getCurrentMode() != 2) goto L115;
        ImageView r130 = this.E;
        if (r130 == null) goto L108;
        r130.setImageResource(2131252041);
    L108:
        TextView r131 = this.D;
        if (r131 == null) goto L149;
        com.bytedance.android.live.ktv.common.midi.g r132 = this.I;
        if (r132 == null) goto L113;
        int r133 = r132.B();
    L114:
        r131.setTextColor(r133);
        goto L149
    L113:
        r133 = s1.h(2131106997);
        goto L114
    L92:
        TextView r134 = this.D;
        if (r134 == null) goto L95;
        r134.setText(this.H.format(Float.valueOf(r116)));
        goto L95
    L82:
        if (2 == r114.intValue()) goto L87;
    L147:
        if (r13 == true) goto L149;
        S5(this.C);
        goto L149
    L18:
        if (r4.L() != true) goto L24;
        com.bytedance.android.live.ktv.common.midi.f r31 = this.K;
        if (r31 == null) goto L24;
        if (r31.b() != true) goto L24;
        r5 = true;
        goto L25
    L11:
        if (r2.c() != true) goto L13;
    L14:
        r3 = true;
        goto L15
    L5:
        r1 = -1;
        goto L7
    }
}
