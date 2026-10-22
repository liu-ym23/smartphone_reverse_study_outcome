package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.interfaces.DraweeController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u001c\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u001aR\u001b\u0010!\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u001a¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/ui/LikeEggView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/chatroom/likeegg/a;", BuildConfig.FLAVOR, "action", "setFinishAction", BuildConfig.FLAVOR, "g", "Z", "isRunning", "()Z", "setRunning", "(Z)V", "Landroid/view/animation/Animation;", "i", "Lkotlin/Lazy;", "getInAnimation", "()Landroid/view/animation/Animation;", "inAnimation", "j", "getOutAnimation", "outAnimation", "Lcom/facebook/drawee/interfaces/DraweeController;", "l", "getPrepareWebpController", "()Lcom/facebook/drawee/interfaces/DraweeController;", "prepareWebpController", "m", "getPrepareToActiveController", "prepareToActiveController", "n", "getActiveWebpController", "activeWebpController", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LikeEggView extends FrameLayout {
    public final LikeEggProgressBar a;
    public final HSImageView b;
    public final HSImageView c;
    public final TextView d;
    public ValueAnimator e;
    public ValueAnimator f;
    public boolean g;
    public int h;
    public final Lazy i;
    public final Lazy j;
    public Function1<? super com.bytedance.android.livesdk.chatroom.likeegg.a, Unit> k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;

    public static final class a {
    }

    static {
    }

    public LikeEggView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LikeEggView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final DraweeController getActiveWebpController() {
        return (DraweeController) this.n.getValue();
    }

    private final Animation getInAnimation() {
        return (Animation) this.i.getValue();
    }

    private final Animation getOutAnimation() {
        return (Animation) this.j.getValue();
    }

    private final DraweeController getPrepareToActiveController() {
        return (DraweeController) this.m.getValue();
    }

    private final DraweeController getPrepareWebpController() {
        return (DraweeController) this.l.getValue();
    }

    public final void f() {
        ValueAnimator r0 = this.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.f;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        Animation r2 = getInAnimation();
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        Animation r3 = getOutAnimation();
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        clearAnimation();
        this.g = false;
        setVisibility(8);
    }

    public static final /* synthetic */ DraweeController a(LikeEggView r0) {
        return r0.getActiveWebpController();
    }

    public static final void c(LikeEggView r3) {
        if (r3.h == 0) goto L17;
        r3.h = 0;
        HSImageView r1 = r3.b;
        if (r1 == null) goto L7;
        UtilityKotlinExtentionsKt.z(r1, true);
    L7:
        HSImageView r2 = r3.b;
        if (r2 == null) goto L10;
        r2.setController(null);
    L10:
        HSImageView r4 = r3.c;
        if (r4 == null) goto L13;
        UtilityKotlinExtentionsKt.A(r4, false);
    L13:
        HSImageView r5 = r3.c;
        if (r5 == null) goto L18;
        r5.setController(null);
        return;
    L18:
        return;
    }

    public final void e(final com.bytedance.android.livesdk.chatroom.likeegg.a r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        this.g = true;
        Function0<Unit> r0 = new LikeEggView$enter$1(this, r4);
        LikeEggView$enter$2 r5 = LikeEggView$enter$2.INSTANCE;
        Animation r1 = getInAnimation();
        if (r1 == null) goto L5;
        r1.setAnimationListener(new g(r1, r5, r0));
    L6:
        if (r1 == null) goto L9;
        clearAnimation();
        startAnimation(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setFinishAction(Function1<? super com.bytedance.android.livesdk.chatroom.likeegg.a, Unit> r1) {
        this.k = r1;
    }

    public final void setRunning(boolean r1) {
        this.g = r1;
    }

    public static final Animation b(LikeEggView r3, int r4) {
        r3.getClass();
        Animation r5 = AnimationUtils.loadAnimation(r3.getRootView().getContext(), r4);     // Catch: Exception -> L5
    L7:
        if (r5 == null) goto L9;
        r5.setInterpolator(PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f));
    L9:
        return r5;
    L5:
        e = move-exception;
        ALogger.e("LikeEggView", "load anim error-" + e);
        r5 = null;
        goto L7
    }

    public static final void d(final LikeEggView r9, final com.bytedance.android.livesdk.chatroom.likeegg.a r10) {
        int r0 = r9.h;
        boolean r1 = true;
        Animation r4 = null;
        if (r0 == 0) goto L67;
        if (r0 != 1) goto L6;
        ALogger.d("LikeEggView", "change state to active, duration: " + r10.duration);
        r9.h = 2;
        HSImageView r2 = r9.b;
        if (r2 == null) goto L30;
        UtilityKotlinExtentionsKt.A(r2, true);
    L30:
        HSImageView r3 = r9.c;
        if (r3 == null) goto L33;
        UtilityKotlinExtentionsKt.A(r3, false);
    L33:
        HSImageView r5 = r9.b;
        if (r5 == null) goto L36;
        r5.setController(r9.getPrepareToActiveController());
    L36:
        HSImageView r6 = r9.c;
        if (r6 == null) goto L39;
        r6.setController(null);
    L39:
        TextView r7 = r9.d;
        if (r7 == null) goto L52;
        String r8 = r10.content;
        if (r8 != null) goto L44;
    L47:
        boolean r11 = true;
    L48:
        if (r11 == false) goto L50;
        String r13 = "合力点赞解锁惊喜彩蛋";
    L51:
        r7.setText(r13);
        goto L52
    L50:
        r13 = r10.content;
        goto L51
    L44:
        if (r8.length() == 0) goto L47;
        r11 = false;
    L52:
        TextView r14 = r9.d;
        if (r14 == null) goto L55;
        a1.m(r14, UtilityKotlinExtentionsKt.i(2));
    L55:
        LikeEggProgressBar r15 = r9.a;
        if (r15 == null) goto L58;
        r15.setProgress(0);
    L58:
        LikeEggProgressBar r16 = r9.a;
        if (r16 == null) goto L61;
        r16.setProgressBackgroundColor(ColorProtector.parseColor("#33BA0021"));
    L61:
        ValueAnimator r17 = r9.e;
        if (r17 != null) goto L64;
    L66:
        ValueAnimator r18 = ValueAnimator.ofInt(new int[]{0, 10100});
        r18.setDuration(r10.duration);
        r18.setInterpolator(new DecelerateInterpolator());
        r18.addUpdateListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui.a(r9));
        r18.addListener(new b(r9, r10));
        r18.start();
        Unit r19 = Unit.INSTANCE;
        r9.e = r18;
        r9.postDelayed(new c(r9, r10), r10.duration);
        return;
    L64:
        if (r17.isRunning() != true) goto L66;
        return;
    L6:
        if (r0 == 2) goto L14;
        if (r0 != 3) goto L106;
        Function0<Unit> r20 = new LikeEggView$exit$1(r9, r10);
        Animation r110 = r9.getOutAnimation();
        if (r110 == null) goto L12;
        r110.setAnimationListener(new h(r110, r20, null));
        r4 = r110;
    L12:
        if (r4 == null) goto L102;
        r9.clearAnimation();
        r9.startAnimation(r4);
        return;
    L102:
        return;
    L106:
        return;
    L14:
        ALogger.d("LikeEggView", "change state to end, duration: " + r10.finishDuration);
        r9.h = 3;
        LikeEggProgressBar r21 = r9.a;
        if (r21 == null) goto L17;
        r21.setProgress(10000);
    L17:
        LikeEggProgressBar r23 = r9.a;
        if (r23 == null) goto L20;
        r23.setProgressBackgroundColor(ColorProtector.parseColor("#66FF3055"));
    L20:
        TextView r24 = r9.d;
        if (r24 == null) goto L23;
        r24.postDelayed(new f(r9, r10), 250);
    L23:
        ValueAnimator r25 = r9.f;
        if (r25 == null) goto L26;
        r25.cancel();
    L26:
        ValueAnimator r26 = ValueAnimator.ofInt(new int[]{UtilityKotlinExtentionsKt.i(62), UtilityKotlinExtentionsKt.i(12)});
        r26.setDuration(500);
        r26.setInterpolator(new PathInterpolator(0.84f, 0.0f, 0.16f, 1.0f));
        r26.addUpdateListener(new d(r9));
        r26.addListener(new e(r9));
        r26.start();
        Unit r27 = Unit.INSTANCE;
        r9.f = r26;
        r9.postDelayed(new k(r9, r10), r10.finishDuration);
        return;
    L67:
        ALogger.d("LikeEggView", "change state to prepare, duration: " + r10.prepareDuration);
        r9.h = 1;
        HSImageView r28 = r9.b;
        if (r28 == null) goto L70;
        UtilityKotlinExtentionsKt.A(r28, true);
    L70:
        HSImageView r29 = r9.c;
        if (r29 == null) goto L73;
        UtilityKotlinExtentionsKt.A(r29, false);
    L73:
        HSImageView r30 = r9.b;
        if (r30 == null) goto L76;
        r30.setController(r9.getPrepareWebpController());
    L76:
        HSImageView r31 = r9.c;
        if (r31 == null) goto L79;
        r31.setController(null);
    L79:
        TextView r33 = r9.d;
        if (r33 == null) goto L91;
        String r34 = r10.prepareContent;
        if (r34 != null) goto L84;
    L87:
        if (r1 == false) goto L89;
        String r35 = "即将进入点赞彩蛋时刻";
    L90:
        r33.setText(r35);
        goto L91
    L89:
        r35 = r10.prepareContent;
        goto L90
    L84:
        if (r34.length() == 0) goto L87;
        r1 = false;
    L91:
        TextView r36 = r9.d;
        if (r36 == null) goto L94;
        a1.m(r36, UtilityKotlinExtentionsKt.i(2));
    L94:
        LikeEggProgressBar r37 = r9.a;
        if (r37 == null) goto L97;
        r37.setProgress(0);
    L97:
        LikeEggProgressBar r38 = r9.a;
        if (r38 == null) goto L100;
        r38.setProgressBackgroundColor(ColorProtector.parseColor("#33BA0021"));
    L100:
        r9.postDelayed(new j(r9, r10), r10.prepareDuration);
    }

    public LikeEggView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567650, this, true);
        this.a = (LikeEggProgressBar) findViewById(2131383297);
        this.b = findViewById(2131369101);
        this.c = findViewById(2131369102);
        this.d = (TextView) findViewById(2131369099);
        setVisibility(8);
        this.i = LazyKt.lazy(new LikeEggView$inAnimation$2(this));
        this.j = LazyKt.lazy(new LikeEggView$outAnimation$2(this));
        this.l = LazyKt.lazy(LikeEggView$prepareWebpController$2.INSTANCE);
        this.m = LazyKt.lazy(new LikeEggView$prepareToActiveController$2(this, r2));
        this.n = LazyKt.lazy(new LikeEggView$activeWebpController$2(this));
    }

    public /* synthetic */ LikeEggView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
