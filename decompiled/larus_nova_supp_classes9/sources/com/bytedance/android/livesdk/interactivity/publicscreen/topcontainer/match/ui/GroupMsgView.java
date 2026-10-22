package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncData;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.t;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import ec2.w;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qa2.l;
import ra2.j;
import ra2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002BCB\u0019\u0012\u0006\u0010=\u001a\u00020<\u0012\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010 \u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\"\u0010$\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00103\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006D"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView;", "Landroid/widget/FrameLayout;", "Lqa2/l;", "callback", BuildConfig.FLAVOR, "setCallback", BuildConfig.FLAVOR, "getCurCombo", BuildConfig.FLAVOR, "getEnterAnimStartPos", "getEnterAnimEndPos", "getBattleInPos", "getBattleOutPos", "getBattleInWithWebpPos", "getBattleOutWithWebpPos", "getContainerUpPos", "getContainerDownPos", BuildConfig.FLAVOR, "B", "Z", "getEntered", "()Z", "setEntered", "(Z)V", "entered", "C", "getWebpEntered", "setWebpEntered", "webpEntered", "D", "getBattleEnd", "setBattleEnd", "battleEnd", "E", "getDismissed", "setDismissed", "dismissed", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupAnimType;", "F", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupAnimType;", "getPos", "()Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupAnimType;", "setPos", "(Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupAnimType;)V", "pos", "G", "Ljava/lang/Boolean;", "getImgLoadStatus", "()Ljava/lang/Boolean;", "setImgLoadStatus", "(Ljava/lang/Boolean;)V", "imgLoadStatus", "Lio/reactivex/disposables/Disposable;", "H", "Lio/reactivex/disposables/Disposable;", "getLoadBgDisposable", "()Lio/reactivex/disposables/Disposable;", "setLoadBgDisposable", "(Lio/reactivex/disposables/Disposable;)V", "loadBgDisposable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "GroupAnimType", "GroupType", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupMsgView extends FrameLayout {
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public GroupAnimType F;
    public Boolean G;
    public Disposable H;
    public final ViewGroup a;
    public GroupType b;
    public final ViewGroup c;
    public final HSImageView d;
    public final ViewGroup e;
    public final ViewGroup f;
    public final HSImageView g;
    public final TextView h;
    public boolean i;
    public final TextView j;
    public final TextView k;
    public l l;
    public AnimatorSet m;
    public AnimatorSet n;
    public AnimatorSet o;
    public AnimatorSet p;
    public AnimatorSet q;
    public AnimatorSet r;
    public AnimatedDrawable2 s;
    public long t;
    public k u;
    public int v;
    public final int w;
    public final int x;
    public final int y;
    public boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupAnimType;", BuildConfig.FLAVOR, "TOP", "DOWN", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum GroupAnimType extends Enum<GroupAnimType> {
        public static final GroupAnimType DOWN = null;
        public static final GroupAnimType TOP = null;
        public static final /* synthetic */ GroupAnimType[] a = null;

        static {
            GroupAnimType r1 = new GroupAnimType("TOP", 0);
            TOP = r1;
            GroupAnimType r2 = new GroupAnimType("DOWN", 1);
            DOWN = r2;
            a = new GroupAnimType[]{r1, r2};
        }

        public static GroupAnimType valueOf(String r1) {
            return (GroupAnimType) r27.a.a(GroupAnimType.class, r1);
        }

        public static GroupAnimType[] values() {
            return (GroupAnimType[]) a.clone();
        }

        public GroupAnimType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "LEFT", "RIGHT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum GroupType extends Enum<GroupType> {
        public static final GroupType LEFT = null;
        public static final GroupType RIGHT = null;
        public static final /* synthetic */ GroupType[] a = null;
        private final int value;

        static {
            GroupType r1 = new GroupType("LEFT", 0, 0);
            LEFT = r1;
            GroupType r2 = new GroupType("RIGHT", 1, 1);
            RIGHT = r2;
            a = new GroupType[]{r1, r2};
        }

        public static GroupType valueOf(String r1) {
            return (GroupType) r27.a.a(GroupType.class, r1);
        }

        public static GroupType[] values() {
            return (GroupType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public GroupType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ GroupMsgView a;

        public a(GroupMsgView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.i();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ GroupMsgView a;

        public b(GroupMsgView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a.getDismissed() == true) goto L8;
            this.a.setBattleEnd(true);
            l r3 = this.a.l;
            if (r3 == null) goto L9;
            r3.c();
            return;
        L9:
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ GroupMsgView a;

        public c(GroupMsgView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a.getDismissed() == true) goto L8;
            this.a.setBattleEnd(true);
            l r3 = this.a.l;
            if (r3 == null) goto L9;
            r3.c();
            return;
        L9:
            return;
        }
    }

    public static final class d implements Animation.AnimationListener {
        public final /* synthetic */ GroupMsgView a;
        public final /* synthetic */ ScaleAnimation b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            ViewGroup r3 = this.a.f;
            if (r3 == null) goto L6;
            r3.startAnimation(this.b);
            return;
        }

        public d(GroupMsgView r1, ScaleAnimation r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ GroupMsgView a;

        public e(GroupMsgView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a.getDismissed() == true) goto L8;
            this.a.setEntered(true);
            l r3 = this.a.l;
            if (r3 == null) goto L9;
            r3.e();
            return;
        L9:
            return;
        }
    }

    public static final class f extends AnimatorListenerAdapter {
        public final /* synthetic */ GroupMsgView a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public f(GroupMsgView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setDismissed(true);
            l r3 = this.a.l;
            if (r3 == null) goto L6;
            r3.onEnd();
            return;
        }
    }

    public static final class g extends AnimatorListenerAdapter {
        public final /* synthetic */ GroupMsgView a;
        public final /* synthetic */ GroupAnimType b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setPos(this.b);
        }

        public g(GroupMsgView r1, GroupAnimType r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class h extends AnimatorListenerAdapter {
        public final /* synthetic */ GroupMsgView a;

        public h(GroupMsgView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a.getDismissed() == true) goto L9;
            this.a.setWebpEntered(true);
            l r3 = this.a.l;
            if (r3 == null) goto L7;
            r3.d();
        L7:
            this.a.v = 0;
            return;
        }
    }

    public final void l() {
        this.l = null;
        f(this.m);
        f(this.n);
        f(this.o);
        f(this.p);
        f(this.q);
        f(this.r);
        removeCallbacks(this.u);
        ViewGroup r0 = this.a;
        if (r0 == null) goto L5;
        r0.clearAnimation();
    L5:
        ViewGroup r1 = this.f;
        if (r1 == null) goto L8;
        r1.clearAnimation();
    L8:
        Disposable r2 = this.H;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        clearAnimation();
    }

    private final float getBattleInPos() {
        if (this.b != GroupType.LEFT) goto L6;
        int r0 = (this.w * (-1)) + this.y;
    L11:
        return r0;
    L6:
        ViewGroup r1 = this.a;
        if (r1 == null) goto L9;
        r0 = (r1.getLeft() + this.w) - this.y;
        goto L11
    L9:
        return 0.0f;
    }

    private final float getBattleInWithWebpPos() {
        if (this.b != GroupType.LEFT) goto L7;
        ViewGroup r0 = this.a;
        if (r0 == null) goto L12;
        int r1 = r0.getLeft() + this.y;
    L11:
        return r1;
    L12:
        return 0.0f;
    L7:
        ViewGroup r2 = this.a;
        if (r2 == null) goto L13;
        r1 = r2.getLeft() - this.y;
        goto L11
    L13:
        return 0.0f;
    }

    private final float getBattleOutPos() {
        if (this.b != GroupType.LEFT) goto L6;
        int r0 = this.w * (-1);
    L11:
        return r0;
    L6:
        ViewGroup r1 = this.a;
        if (r1 == null) goto L9;
        r0 = r1.getLeft() + this.w;
        goto L11
    L9:
        return 0.0f;
    }

    private final float getBattleOutWithWebpPos() {
        if (this.b != GroupType.LEFT) goto L7;
        ViewGroup r0 = this.a;
        if (r0 == null) goto L12;
        int r1 = r0.getLeft();
    L11:
        return r1;
    L12:
        return 0.0f;
    L7:
        ViewGroup r2 = this.a;
        if (r2 == null) goto L13;
        r1 = r2.getLeft();
        goto L11
    L13:
        return 0.0f;
    }

    private final float getContainerDownPos() {
        if (this.b != GroupType.LEFT) goto L7;
        ViewGroup r0 = this.a;
        if (r0 == null) goto L12;
        int r1 = r0.getTop() + this.x;
    L11:
        return r1;
    L12:
        return 0.0f;
    L7:
        ViewGroup r2 = this.a;
        if (r2 == null) goto L13;
        r1 = r2.getTop();
        goto L11
    L13:
        return 0.0f;
    }

    private final float getContainerUpPos() {
        if (this.b != GroupType.LEFT) goto L7;
        ViewGroup r0 = this.a;
        if (r0 == null) goto L12;
        int r1 = r0.getTop();
    L11:
        return r1;
    L12:
        return 0.0f;
    L7:
        ViewGroup r2 = this.a;
        if (r2 == null) goto L13;
        r1 = r2.getTop() - this.x;
        goto L11
    L13:
        return 0.0f;
    }

    private final float getEnterAnimEndPos() {
        if (this.b != GroupType.LEFT) goto L6;
        int r0 = (this.w * (-1)) + this.y;
    L11:
        return r0;
    L6:
        ViewGroup r1 = this.a;
        if (r1 == null) goto L9;
        r0 = (r1.getLeft() + this.w) - this.y;
        goto L11
    L9:
        return 0.0f;
    }

    private final float getEnterAnimStartPos() {
        if (this.b != GroupType.LEFT) goto L8;
        ViewGroup r0 = this.a;
        if (r0 == null) goto L15;
        int r1 = r0.getWidth() * (-1);
    L16:
        return r1;
    L15:
        return 0.0f;
    L8:
        ViewGroup r2 = this.a;
        if (r2 == null) goto L17;
        int r3 = r2.getLeft();
        ViewGroup r4 = this.a;
        if (r4 == null) goto L13;
        int r5 = r4.getWidth();
    L14:
        r1 = r3 + r5;
        goto L16
    L13:
        r5 = 0;
        goto L14
    L17:
        return 0.0f;
    }

    public final void b() {
        ViewGroup r0 = this.a;
        if (r0 == null) goto L5;
        r0.setAlpha(1.0f);
    L5:
        this.B = true;
        HSImageView r2 = this.g;
        if (r2 == null) goto L8;
        r2.setAlpha(1.0f);
    L8:
        AnimatedDrawable2 r1 = this.s;
        if (r1 == null) goto L11;
        r1.jumpToFrame(r1.getFrameCount() - 1);
    L11:
        int r3 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        ViewGroup r4 = this.a;
        if (r4 != null) goto L14;
        return;
    L14:
        com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r4, getBattleOutPos(), getBattleInWithWebpPos(), 0, 0.66f, 0.0f, 0.34f).start();
        this.C = true;
        postDelayed(new a(this), RiskAdviseSyncData.PRIORITY);
    }

    public final void c() {
        AnimatorSet r0 = new AnimatorSet();
        Animator[] r1 = new Animator[2];
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        ViewGroup r3 = this.a;
        if (r3 != null) goto L5;
        return;
    L5:
        r1[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r3, getBattleInWithWebpPos(), getBattleOutWithWebpPos(), 1000, 0.84f, 0.0f, 0.16f);
        ViewGroup r4 = this.a;
        if (r4 != null) goto L8;
        return;
    L8:
        r1[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r4, getBattleOutWithWebpPos(), getBattleInWithWebpPos(), 1000, 0.84f, 0.0f, 0.16f);
        r0.playSequentially(r1);
        Unit r5 = Unit.INSTANCE;
        this.o = r0;
        r0.addListener(new b(this));
        AnimatorSet r6 = this.o;
        if (r6 == null) goto L12;
        r6.start();
        return;
    }

    public final void d() {
        AnimatorSet r0 = new AnimatorSet();
        Animator[] r1 = new Animator[2];
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        View r3 = this.a;
        if (r3 != null) goto L6;
        r3 = new View(getContext());
    L6:
        r1[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r3, getBattleInPos(), getBattleOutPos(), 1000, 0.84f, 0.0f, 0.16f);
        View r4 = this.a;
        if (r4 != null) goto L10;
        r4 = new View(getContext());
    L10:
        r1[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r4, getBattleOutPos(), getBattleInPos(), 1000, 0.84f, 0.0f, 0.16f);
        r0.playSequentially(r1);
        Unit r5 = Unit.INSTANCE;
        this.q = r0;
        r0.addListener(new c(this));
        AnimatorSet r6 = this.q;
        if (r6 == null) goto L14;
        r6.start();
        return;
    }

    public final Float e() {
        TextView r0 = this.h;
        CharSequence r1 = null;
        if (r0 == null) goto L11;
        TextPaint r2 = r0.getPaint();
        if (r2 == null) goto L12;
        TextView r3 = this.h;
        if (r3 == null) goto L10;
        r1 = r3.getText();
    L10:
        return Float.valueOf(((r2.measureText(String.valueOf(r1)) + this.k.getPaint().measureText(this.k.getText().toString())) + this.j.getPaint().measureText(this.j.getText().toString())) + s1.f(71));
    L12:
        return null;
    L11:
        return null;
    }

    public final long getCurCombo() {
        return CastLongProtector.parseLong(this.k.getText().toString());
    L4:
        return 0;
    }

    public final void h() {
        AnimatorSet r0 = new AnimatorSet();
        Animator[] r1 = new Animator[2];
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        ViewGroup r3 = this.a;
        if (r3 != null) goto L5;
        return;
    L5:
        r1[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a(r3);
        ViewGroup r4 = this.a;
        if (r4 != null) goto L8;
        return;
    L8:
        r1[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r4, getEnterAnimStartPos(), getEnterAnimEndPos(), 1250, 0.14f, 1.0f, 0.34f);
        r0.playTogether(r1);
        Unit r5 = Unit.INSTANCE;
        this.m = r0;
        r0.addListener(new e(this));
        AnimatorSet r6 = this.m;
        if (r6 == null) goto L12;
        r6.start();
        return;
    }

    public final void i() {
        removeCallbacks(this.u);
        AnimatorSet r0 = new AnimatorSet();
        this.r = r0;
        ViewGroup r1 = this.a;
        if (r1 == null) goto L5;
        r0.play(ObjectAnimator.ofFloat(r1, "alpha", new float[]{1.0f, 0.0f}));
    L5:
        AnimatorSet r2 = this.r;
        if (r2 == null) goto L8;
        r2.setDuration(300);
    L8:
        AnimatorSet r3 = this.r;
        if (r3 == null) goto L11;
        r3.addListener(new f(this));
    L11:
        AnimatorSet r4 = this.r;
        if (r4 == null) goto L15;
        r4.start();
        return;
    }

    public final void n() {
        AnimatorSet r0 = new AnimatorSet();
        Animator[] r1 = new Animator[2];
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        HSImageView r3 = this.g;
        if (r3 != null) goto L5;
        return;
    L5:
        r1[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a(r3);
        ViewGroup r4 = this.a;
        if (r4 != null) goto L8;
        return;
    L8:
        int r5 = 1;
        r1[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r4, getBattleOutPos(), getBattleInWithWebpPos(), 1000, 0.66f, 0.0f, 0.34f);
        r0.playTogether(r1);
        Unit r6 = Unit.INSTANCE;
        this.p = r0;
        r0.addListener(new h(this));
        HSImageView r7 = this.g;
        Animatable r8 = null;
        if (r7 == null) goto L13;
        DraweeController r9 = r7.getController();
        if (r9 == null) goto L13;
        Animatable r10 = r9.getAnimatable();
    L15:
        if ((r10 instanceof AnimatedDrawable2) == false) goto L18;
        r8 = r10;
    L18:
        AnimatedDrawable2 r11 = (AnimatedDrawable2) r8;
        this.s = r11;
        if (r11 == null) goto L24;
        long r13 = r11.getLoopDurationMs();
        AnimatedDrawable2 r14 = this.s;
        if (r14 == null) goto L23;
        r5 = r14.getFrameCount();
    L23:
        long r15 = r13 / ((long) r5);
    L25:
        this.t = r15;
        post(this.u);
        AnimatorSet r16 = this.p;
        if (r16 == null) goto L29;
        r16.start();
        return;
    L29:
        return;
    L24:
        r15 = 50;
    L13:
        r10 = null;
        goto L15
    }

    public final void k() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = q.g();
        GroupType r1 = this.b;
        GroupType r2 = GroupType.LEFT;
        py.k r3 = null;
        if (r1 != r2) goto L10;
        if (r0 == null) goto L16;
        m<t> r4 = r0.getMatchChatInfo();
        if (r4 == null) goto L16;
        t r5 = (t) r4.getValue();
        if (r5 == null) goto L16;
        py.k r6 = r5.mainGroupBg;
    L18:
        if (this.b != r2) goto L25;
        if (r0 == null) goto L31;
        m<t> r7 = r0.getMatchChatInfo();
        if (r7 == null) goto L31;
        t r8 = (t) r7.getValue();
        if (r8 == null) goto L31;
        r3 = r8.mainGroupIcon;
    L31:
        if (r6 == null) goto L36;
        if (r3 == null) goto L36;
        a1.k(r6).observeOn(AndroidSchedulers.mainThread()).subscribe(new ra2.l(this));
        ImageLoader.bindGifImage(this.g, r3, new j(this));
        return;
    L36:
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("GroupMsgView image load failed. bg is null or icon is null");
        this.G = Boolean.FALSE;
        l r9 = this.l;
        if (r9 == null) goto L40;
        r9.a();
        return;
    L40:
        return;
    L25:
        if (r0 == null) goto L31;
        m<t> r10 = r0.getMatchChatInfo();
        if (r10 == null) goto L31;
        t r11 = (t) r10.getValue();
        if (r11 == null) goto L31;
        r3 = r11.guestGroupIcon;
    L16:
        r6 = null;
        goto L18
    L10:
        if (r0 == null) goto L16;
        m<t> r13 = r0.getMatchChatInfo();
        if (r13 == null) goto L16;
        t r14 = (t) r13.getValue();
        if (r14 == null) goto L16;
        r6 = r14.guestGroupBg;
        goto L18
    }

    public final boolean getBattleEnd() {
        return this.D;
    }

    public final boolean getDismissed() {
        return this.E;
    }

    public final boolean getEntered() {
        return this.B;
    }

    public final Boolean getImgLoadStatus() {
        return this.G;
    }

    public final Disposable getLoadBgDisposable() {
        return this.H;
    }

    public final GroupAnimType getPos() {
        return this.F;
    }

    public final boolean getWebpEntered() {
        return this.C;
    }

    public static final void a(GroupMsgView r2) {
        if (Intrinsics.areEqual(r2.G, Boolean.FALSE) == false) goto L7;
        l r3 = r2.l;
        if (r3 == null) goto L13;
        r3.a();
        return;
    L13:
        return;
    L7:
        int r0 = r2.A + 1;
        r2.A = r0;
        if (r0 != 2) goto L15;
        r2.G = Boolean.TRUE;
        l r4 = r2.l;
        if (r4 == null) goto L16;
        r4.b();
        return;
    L16:
        return;
    }

    public static void f(AnimatorSet r0) {
        if (r0 == null) goto L4;
        r0.removeAllListeners();
    L4:
        if (r0 == null) goto L7;
        r0.cancel();
        return;
    }

    public final void j(g3 r4) {
        if (this.i == true) goto L10;
        this.i = true;
        Typeface r0 = Typeface.createFromAsset(getContext().getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L8
        this.j.setTypeface(r0);     // Catch: Exception -> L8
        this.k.setTypeface(r0);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        this.i = false;
        String r1 = "load font asset exception: " + e.getMessage();
        int r2 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.a;
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.e("MatchMsgTAG", r1);
    L10:
        TextView r3 = this.h;
        Long r5 = null;
        if (r3 == null) goto L16;
        if (r4 == null) goto L14;
        String r6 = r4.getContent();
    L15:
        r3.setText(r6);
        goto L16
    L14:
        r6 = null;
    L16:
        TextView r7 = this.k;
        if (r7 == null) goto L24;
        if (r4 == null) goto L20;
        r5 = Long.valueOf(r4.getCount());
    L20:
        r7.setText(String.valueOf(r5));
        return;
    }

    public final void m(GroupAnimType r7) {
        Intrinsics.checkNotNullParameter(r7, "type");
        if (r7 != GroupAnimType.TOP) goto L8;
        AnimatorSet r0 = new AnimatorSet();
        Animator[] r2 = new Animator[1];
        int r3 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        ViewGroup r4 = this.a;
        if (r4 != null) goto L7;
        return;
    L7:
        r2[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.e(r4, getContainerDownPos(), getContainerUpPos());
        r0.playSequentially(r2);
        Unit r1 = Unit.INSTANCE;
    L12:
        this.n = r0;
        r0.addListener(new g(this, r7));
        AnimatorSet r8 = this.n;
        if (r8 == null) goto L16;
        r8.start();
        return;
    L16:
        return;
    L8:
        r0 = new AnimatorSet();
        Animator[] r5 = new Animator[1];
        int r6 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        ViewGroup r9 = this.a;
        if (r9 != null) goto L11;
        return;
    L11:
        r5[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.e(r9, getContainerUpPos(), getContainerDownPos());
        r0.playSequentially(r5);
        Unit r10 = Unit.INSTANCE;
        goto L12
    }

    public final void setBattleEnd(boolean r1) {
        this.D = r1;
    }

    public final void setCallback(l r1) {
        this.l = r1;
    }

    public final void setDismissed(boolean r1) {
        this.E = r1;
    }

    public final void setEntered(boolean r1) {
        this.B = r1;
    }

    public final void setImgLoadStatus(Boolean r1) {
        this.G = r1;
    }

    public final void setLoadBgDisposable(Disposable r1) {
        this.H = r1;
    }

    public final void setPos(GroupAnimType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.F = r2;
    }

    public final void setWebpEntered(boolean r1) {
        this.C = r1;
    }

    public GroupMsgView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        GroupType r0 = GroupType.LEFT;
        this.b = r0;
        this.t = 50;
        Integer r1 = (Integer) w.a.getValue();
        s1.j(2131168901);
        this.w = s1.j(2131168897);
        this.x = s1.j(2131168900);
        this.y = s1.j(2131168896);
        s1.j(2131168899);
        int r2 = s1.j(2131168898);
        GroupAnimType r3 = GroupAnimType.TOP;
        this.F = r3;
        LayoutInflater.from(r9).inflate(2131567680, this);
        this.a = (ViewGroup) findViewById(2131373939);
        this.c = (ViewGroup) findViewById(2131388410);
        this.d = findViewById(2131388411);
        ViewGroup r4 = (ViewGroup) findViewById(2131374543);
        this.e = r4;
        HSImageView r5 = findViewById(2131393135);
        this.g = r5;
        this.j = (TextView) findViewById(2131374538);
        this.k = (TextView) findViewById(2131374537);
        this.h = (TextView) findViewById(2131374540);
        this.f = (ViewGroup) findViewById(2131374536);
        if (r10 != null) goto L6;
    L21:
        this.u = new k(this);
        return;
    L6:
        if (r9.obtainStyledAttributes(r10, new int[]{2130974761}).getInt(0, 0) != 0) goto L8;
        GroupType r11 = r0;
    L9:
        this.b = r11;
        if (r11 != r0) goto L15;
        if (r5 == null) goto L13;
        com.bytedance.android.live.core.utils.a1.j(r5, 3);
    L13:
        this.F = r3;
        goto L21
    L15:
        if (r11 != GroupType.RIGHT) goto L21;
        if (r5 == null) goto L18;
        com.bytedance.android.live.core.utils.a1.j(r5, 5);
    L18:
        this.F = GroupAnimType.DOWN;
        if (r4 == null) goto L21;
        com.bytedance.android.live.core.utils.a1.m(r4, r2);
        goto L21
    L8:
        r11 = GroupType.RIGHT;
        goto L9
    }

    public final void g(Long r11, boolean r13) {
        TextView r0 = this.k;
        if (r11 == null) goto L5;
        String r14 = String.valueOf(r11.longValue());
    L6:
        r0.setText(r14);
        ViewGroup r15 = this.c;
        int r1 = 0;
        if (r15 == null) goto L13;
        Float r2 = e();
        if (r2 == null) goto L11;
        int r3 = (int) r2.floatValue();
    L12:
        q32.a.a(r15, r3);
        goto L13
    L11:
        r3 = 0;
    L13:
        HSImageView r16 = this.d;
        if (r16 == null) goto L20;
        Float r4 = e();
        if (r4 == null) goto L18;
        r1 = (int) r4.floatValue();
    L18:
        q32.a.a(r16, r1);
    L20:
        if (this.z == true) goto L30;
        ViewGroup r17 = this.f;
        float r5 = 0.0f;
        if (r17 == null) goto L24;
        r17.setPivotX(0.0f);
    L24:
        ViewGroup r18 = this.f;
        if (r18 == null) goto L29;
        if (r18 == null) goto L28;
        r5 = r18.getHeight();
    L28:
        r18.setPivotY(r5);
    L29:
        this.z = true;
    L30:
        if (r13 == false) goto L32;
        return;
    L32:
        int r19 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        ViewGroup r110 = this.f;
        if (r110 == null) goto L44;
        float r6 = r110.getPivotX();
        ViewGroup r111 = this.f;
        if (r111 == null) goto L45;
        ScaleAnimation r112 = new ScaleAnimation(1.0f, 1.15f, 1.0f, 1.15f, r6, r111.getPivotY());
        r112.setDuration(50);
        r112.setFillAfter(true);
        r112.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.83f, 0.83f));
        ViewGroup r7 = this.f;
        if (r7 == null) goto L46;
        float r8 = r7.getPivotX();
        ViewGroup r9 = this.f;
        if (r9 == null) goto L47;
        ScaleAnimation r10 = new ScaleAnimation(1.15f, 1.0f, 1.15f, 1.0f, r8, r9.getPivotY());
        r10.setDuration(200);
        r10.setFillAfter(true);
        r10.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.83f, 0.83f));
        r112.setAnimationListener(new d(this, r10));
        ViewGroup r113 = this.f;
        if (r113 == null) goto L48;
        r113.startAnimation(r112);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L5:
        r14 = null;
        goto L6
    }
}
