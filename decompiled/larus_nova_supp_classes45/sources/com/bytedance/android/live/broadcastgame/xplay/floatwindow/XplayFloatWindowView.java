package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.xplay.l;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.n1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.dux.text.DuxTextView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0005\n\u000b\f\r\u000eB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/floatwindow/XplayFloatWindowView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "ViewHolder", "ViewState", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayFloatWindowView extends ConstraintLayout {
    public boolean a;
    public final CompositeDisposable b;
    public com.bytedance.android.live.broadcastgame.xplay.floatwindow.a c;
    public ViewHolder d;
    public vlc.d e;
    public i f;
    public final c g;
    public final b h;
    public boolean i;
    public boolean j;

    public final class ViewHolder {
        public ViewState a;
        public final CompositeDisposable b;
        public final DuxTextView c;
        public final NoMoreSpaceTextView d;
        public final FrameLayout e;
        public final View f;
        public final ViewGroup g;
        public final DuxTextView h;
        public final View i;
        public final ViewGroup j;
        public final float k;
        public final float l;
        public final float m;
        public final float n;
        public final float o;
        public boolean p;
        public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> q;
        public boolean r;
        public k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> s;
        public final com.bytedance.android.live.broadcastgame.xplay.floatwindow.a t;
        public final /* synthetic */ XplayFloatWindowView u;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.floatwindow.XplayFloatWindowView$ViewHolder$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
        final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<View, Unit> {
            public AnonymousClass1(ViewHolder r8) {
                super(1, r8, ViewHolder.class, "onClickToggleLiveInfoBtn", "onClickToggleLiveInfoBtn(Landroid/view/View;)V", 0);
            }

            public final void invoke(View r4) {
                Intrinsics.checkNotNullParameter(r4, "p1");
                ViewHolder r5 = (ViewHolder) ((CallableReference) this).receiver;
                r5.getClass();
                if (n1.a() == false) goto L7;
                XplayFloatWindowView.S5(r5.u, 1);
                XplayFloatWindowView r0 = r5.u;
                boolean r1 = true ^ r0.a;
                r0.a = r1;
                r5.t.b.a(Boolean.valueOf(r1));
                return;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                invoke((View) r1);
                return Unit.INSTANCE;
            }
        }

        public static final class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ ViewHolder a;
            public final /* synthetic */ int b;
            public final /* synthetic */ float c;
            public final /* synthetic */ int d;
            public final /* synthetic */ float e;
            public final /* synthetic */ boolean f;

            public a(ViewHolder r1, int r2, float r3, int r4, float r5, boolean r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r5) {
                Intrinsics.checkNotNullParameter(r5, "it");
                Object r6 = r5.getAnimatedValue();
                if (r6 == null) goto L10;
                float r7 = ((Float) r6).floatValue();
                int r0 = this.b;
                float r1 = r0 + ((this.c - r0) * r7);
                int r2 = this.d;
                float r3 = r2 + ((this.e - r2) * r7);
                ViewGroup r4 = this.a.j;
                ViewGroup.LayoutParams r8 = r4.getLayoutParams();
                r8.width = (int) r1;
                r8.height = (int) r3;
                Unit r9 = Unit.INSTANCE;
                r4.setLayoutParams(r8);
                if (this.f == false) goto L7;
                r7 = 1 - r7;
            L7:
                ViewHolder r11 = this.a;
                r11.c.setPadding(0, 0, (int) (r11.o * r7), 0);
                return;
            L10:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }

        public static final class b implements Animator.AnimatorListener {
            public final /* synthetic */ ViewHolder a;
            public final /* synthetic */ View b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ boolean d;

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r4) {
                Intrinsics.checkNotNullParameter(r4, "animator");
                View r5 = this.b;
                if (r5 == null) goto L6;
                r5.setVisibility(0);
                this.a.j.setBackground(null);
            L6:
                if (this.c == false) goto L8;
                this.a.c.setText("开启直播间清屏");
                this.a.c.setAlpha(1.0f);
                this.a.e.setForeground(null);
                this.a.f.setVisibility(8);
            L10:
                if (this.d == false) goto L16;
                RecyclerView r6 = this.a.j.findViewWithTag("messageRecyclerView");
                if (r6 == null) goto L16;
                RecyclerView.Adapter r0 = r6.getAdapter();
                if (r0 == null) goto L16;
                r6.smoothScrollToPosition(r0.getItemCount());
            L16:
                this.a.p = false;
                return;
            L8:
                this.a.c.setText("取消清屏");
                this.a.c.setAlpha(0.8f);
                this.a.e.setForeground(s1.m(2131253457));
                this.a.f.setVisibility(0);
                goto L10
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r4) {
                Intrinsics.checkNotNullParameter(r4, "animator");
                ViewHolder r5 = this.a;
                Bitmap r6 = Bitmap.createBitmap((int) r5.k, (int) r5.n, Bitmap.Config.RGB_565);
                Canvas r0 = new Canvas(r6);
                this.a.j.draw(r0);
                this.a.j.setBackground(new BitmapDrawable(this.a.u.getResources(), r6));
                View r7 = this.b;
                if (r7 == null) goto L6;
                r7.setVisibility(8);
                return;
            }

            public b(ViewHolder r1, View r2, boolean r3, boolean r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }
        }

        public final void c(ViewState r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            int r0 = XplayLog.a;
            XplayLog.a("XplayFloatWindowView", "switchState " + r4 + " (" + r4.ordinal() + ')');
            this.b.clear();
            this.a = r4;
            int r5 = e.b[r4.ordinal()];
            if (r5 != 1) goto L5;
            a(true, false);
            return;
        L5:
            if (r5 != 2) goto L7;
            a(false, false);
            return;
        L7:
            if (r5 != 3) goto L15;
            a(false, true);
            return;
        }

        public final void a(boolean r17, boolean r18) {
            this.p = true;
            Drawable r0 = this.i.getBackground();
            if (r0 == null) goto L28;
            GradientDrawable r1 = (GradientDrawable) r0;
            if (r17 == false) goto L7;
            int r2 = 12;
        L8:
            float r3 = UtilityKotlinExtentionsKt.h(r2);
            if (r17 == false) goto L11;
            float r11 = 1.0f;
        L12:
            if (r17 == false) goto L14;
            float r12 = 0.0f;
        L15:
            ObjectAnimator r14 = ObjectAnimator.ofFloat(r1, "cornerRadius", new float[]{r3});
            int r4 = this.j.getWidth();
            int r5 = this.j.getHeight();
            if (r17 == false) goto L19;
            float r6 = this.k;
        L18:
            float r7 = r6;
            if (r17 == false) goto L24;
            float r8 = this.n;
        L25:
            ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r9.addUpdateListener(new a(this, r4, r7, r5, r8, r17));
            ObjectAnimator r13 = ObjectAnimator.ofFloat(this.j, View.ALPHA, new float[]{r11});
            ObjectAnimator r15 = ObjectAnimator.ofFloat(this.g, View.ALPHA, new float[]{r11});
            ObjectAnimator r16 = ObjectAnimator.ofFloat(this.f, View.ROTATION, new float[]{r12});
            View r19 = this.j.getChildAt(0);
            AnimatorSet r21 = new AnimatorSet();
            r21.playTogether(new Animator[]{r14, r9, r13, r15, r16});
            r21.setDuration(200);
            r21.addListener(new b(this, r19, r18, r17));
            RxUtilKt.c(RxUtilKt.a(r21, true), this.b);
            r21.start();
            return;
        L24:
            r8 = 0.0f;
            goto L25
        L19:
            if (r18 == false) goto L21;
            r6 = this.m;
            goto L18
        L21:
            r6 = this.l;
            goto L18
        L14:
            r12 = -180.0f;
            goto L15
        L11:
            r11 = 0.0f;
            goto L12
        L7:
            r2 = 15;
            goto L8
        L28:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }

        public final void b(final IPublicScreenService r11, final k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r12) {
            Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r0 = this.q;
            if ((!r0.isEmpty()) == false) goto L5;
            LinkedList r1 = (LinkedList) r0;
            r11.renderLiveMessageWithPublicScreenProcessor(((com.bytedance.android.livesdk.interactivity.api.entity.f) r1.poll()).b, this.d, r12);
            this.d.setVisibility(0);
            boolean r2 = !r1.isEmpty();
            Function0<Unit> r3 = new XplayFloatWindowView$ViewHolder$showNextCollapsedAnim$1(this, r11, r12);
            ObjectAnimator r13 = ObjectAnimator.ofFloat(this.d, View.ALPHA, new float[]{0.0f});
            r13.setDuration(250);
            r13.addListener(new f(this, r3, r2));
            ObjectAnimator r14 = ObjectAnimator.ofFloat(this.d, View.TRANSLATION_Y, new float[]{-UtilityKotlinExtentionsKt.h(8), 0.0f});
            ObjectAnimator r4 = ObjectAnimator.ofFloat(this.d, View.ALPHA, new float[]{0.0f, 1.0f});
            AnimatorSet r5 = new AnimatorSet();
            r5.playTogether(new Animator[]{r14, r4});
            r5.addListener(new g(this, r13, r2));
            r5.setDuration(250);
            r5.start();
            this.r = true;
            return;
        L5:
            this.r = false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(XplayFloatWindowView r5, XplayFloatWindowView r6, com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r7) {
            Intrinsics.checkNotNullParameter(r6, "rootView");
            Intrinsics.checkNotNullParameter(r7, "floatWindowContext");
            this.u = r5;
            this.t = r7;
            this.b = new CompositeDisposable();
            DuxTextView r0 = r6.findViewById(2131393382);
            this.c = r0;
            this.d = r6.findViewById(2131393385);
            FrameLayout r1 = (FrameLayout) r6.findViewById(2131393386);
            this.e = r1;
            this.f = r6.findViewById(2131393384);
            ViewGroup r2 = (ViewGroup) r6.findViewById(2131393379);
            this.g = r2;
            this.h = r6.findViewById(2131393381);
            this.i = r6.findViewById(2131393383);
            this.j = (ViewGroup) r6.findViewById(2131393388);
            this.k = UtilityKotlinExtentionsKt.h(230);
            this.l = UtilityKotlinExtentionsKt.h(86);
            this.m = UtilityKotlinExtentionsKt.h(119);
            this.n = UtilityKotlinExtentionsKt.h(146);
            this.o = UtilityKotlinExtentionsKt.h(2);
            r0.setOnClickListener(new h(new AnonymousClass1(this)));
            r1.setOnClickListener(new com.bytedance.android.live.broadcastgame.xplay.floatwindow.d(this));
            r2.setOnClickListener(new AnonymousClass3(this));
            a1.n((HSImageView) r5.findViewById(2131393387), r7.c.h.e);
            this.q = new LinkedList();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/floatwindow/XplayFloatWindowView$ViewState;", "", "InteractiveExpanded", "InteractiveCollapsed", "NonInteractive", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ViewState extends Enum<ViewState> {
        public static final ViewState InteractiveCollapsed = null;
        public static final ViewState InteractiveExpanded = null;
        public static final ViewState NonInteractive = null;
        public static final /* synthetic */ ViewState[] a = null;

        static {
            ViewState r1 = new ViewState("InteractiveExpanded", 0);
            InteractiveExpanded = r1;
            ViewState r2 = new ViewState("InteractiveCollapsed", 1);
            InteractiveCollapsed = r2;
            ViewState r3 = new ViewState("NonInteractive", 2);
            NonInteractive = r3;
            a = new ViewState[]{r1, r2, r3};
        }

        public static ViewState valueOf(String r1) {
            return (ViewState) r27.a.a(ViewState.class, r1);
        }

        public static ViewState[] values() {
            return (ViewState[]) a.clone();
        }

        public ViewState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public final class b {
        public final int a;
        public j80.d b;
        public j80.d c;
        public final /* synthetic */ XplayFloatWindowView d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(XplayFloatWindowView r2) {
            this.d = r2;
            this.a = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
            this.b = new j80.d(0.0f, 0.0f);
            this.c = new j80.d(0.0f, 0.0f);
        }
    }

    public static final class c {
        public final KMutableProperty0 a;
        public final RectF b;
        public final RectF c;
        public final int[] d;
        public int[] e;
        public final View f;

        public final RectF c() {
            ViewParent r0 = this.f.getParent();
            if ((r0 instanceof ViewGroup) == true) goto L5;
            r0 = null;
        L5:
            ViewGroup r1 = (ViewGroup) r0;
            if (r1 == null) goto L8;
            this.c.set(0.0f, 0.0f, r1.getWidth(), r1.getHeight());
            return this.c;
        L8:
            return this.c;
        }

        public final RectF d() {
            this.b.set(0.0f, 0.0f, this.f.getWidth(), this.f.getHeight());
            this.b.offsetTo(((j80.d) this.a.get()).a().floatValue(), ((j80.d) this.a.get()).b().floatValue());
            return this.b;
        }

        public final j80.d a() {
            RectF r0 = d();
            j80.d r1 = b(r0, c());
            Intrinsics.checkNotNullParameter(r0, "$this$pos");
            j80.d r2 = new j80.d(r0.left, r0.top);
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.a.set(r2);
            return r1;
        }

        public c(final View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.f = r2;
            this.a = new XplayFloatWindowView$PositionManager$localPos$2(r2);
            this.b = new RectF();
            this.c = new RectF();
            this.d = new int[2];
        }

        public final void e(int[] r6) {
            ViewParent r0 = this.f.getParent();
            if ((r0 instanceof ViewGroup) == true) goto L5;
            r0 = null;
        L5:
            ViewGroup r1 = (ViewGroup) r0;
            if (r1 != null) goto L8;
            return;
        L8:
            int[] r2 = new int[2];
            r1.getLocationOnScreen(r2);
            j80.d r7 = j80.c.b(new j80.d(r6[0], r6[1]), new j80.d(r2[0], r2[1]));
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            this.a.set(r7);
        }

        public static j80.d b(RectF r5, RectF r6) {
            Intrinsics.checkNotNullParameter(r5, "$this$constrainWithinBorder");
            Intrinsics.checkNotNullParameter(r6, "border");
            float r0 = Math.max(0.0f, r6.left - r5.left);
            float r2 = Math.min(0.0f, r6.right - r5.right);
            float r1 = r0 + r2;
            float r3 = Math.max(0.0f, r6.top - r5.top) + Math.min(0.0f, r6.bottom - r5.bottom);
            r5.offset(r1, r3);
            return new j80.d(r1, r3);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ViewHolder a;

        public d(ViewHolder r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L5;
            this.a.c(ViewState.InteractiveExpanded);
            return;
        L5:
            this.a.c(ViewState.NonInteractive);
        }
    }

    static {
    }

    public XplayFloatWindowView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public XplayFloatWindowView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        ViewHolder r0 = this.d;
        if (r0 == null) goto L26;
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r1 = this.c;
        if (r1 == null) goto L26;
        IPublicScreenService r3 = jc1.k.f(IPublicScreenService.class);
        if (r3 == null) goto L22;
        View r2 = r3.createFloatTextMessageView(r1.a, getContext(), false, true, new XplayFloatWindowView$setupMessageArea$view$1(this));
        View r4 = null;
        if ((r2 instanceof ViewGroup) == true) goto L13;
        View r5 = null;
    L14:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L17;
        r4 = r6.getChildAt(0);
    L17:
        if (r4 == null) goto L21;
        int r7 = (int) UtilityKotlinExtentionsKt.h(6);
        r4.setPadding(r7, 0, r7, r7);
        if ((r4 instanceof RecyclerView) == false) goto L21;
        ((RecyclerView) r4).setTag("messageRecyclerView");
    L21:
        ViewGroup r8 = r0.j;
        r8.removeAllViews();
        r8.addView(r2);
    L23:
        this.f = new i(r0);
        vlc.d r9 = (vlc.d) r1.a.get("data_message_manager");
        this.e = r9;
        if (r9 == null) goto L26;
        d4.b(r9, "WebcastRoomStatsMessage", this.f);
        goto L26
    L13:
        r5 = r2;
        goto L14
    L22:
        XplayLog.b("XplayFloatWindowView", "failed to obtain IPublicScreenService");
    L26:
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r11 = this.c;
        if (r11 != null) goto L29;
        return;
    L29:
        ViewHolder r12 = this.d;
        if (r12 != null) goto L32;
        return;
    L32:
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(r11.b).subscribe(new d(r12)), this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ViewHolder r0 = this.d;
        if (r0 == null) goto L8;
        r0.j.removeAllViews();
        vlc.d r1 = this.e;
        if (r1 == null) goto L8;
        r1.removeMessageListener(this.f);
    L8:
        this.b.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        b r0 = this.h;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        int r1 = r5.getAction();
        if (r1 != 0) goto L5;
        r0.c = j80.b.c(r5);
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
        return true;
    L15:
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r5);
    L5:
        if (r1 != 2) goto L11;
        if (j80.c.a(j80.b.c(r5), r0.c) < r0.a) goto L11;
        r0.b = j80.b.c(r5);
        r0.d.requestDisallowInterceptTouchEvent(true);
        r0.d.getClass();
        R5(r0.d, j80.c.b(j80.b.c(r5), r0.c));
        r2 = true;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        b r1 = this.h;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getAction();
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L6;
        c r2 = r1.d.g;
        r2.f.getLocationOnScreen(r2.d);
        r1.d.performClick();
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L18;
        return true;
    L18:
        return super/*android.view.ViewGroup*/.onTouchEvent(r5);
    L6:
        if (r0 != 2) goto L8;
        j80.d r4 = j80.c.b(j80.b.c(r5), r1.b);
        r1.b = j80.b.c(r5);
        R5(r1.d, r4);
        goto L14
    L8:
        if (r0 == 3) goto L10;
        r3 = false;
        goto L15
    L10:
        c r6 = r1.d.g;
        r6.f.getLocationOnScreen(r6.d);
        goto L14
    L13:
        r1.b = j80.b.c(r5);
        r1.d.requestDisallowInterceptTouchEvent(true);
        r1.d.getClass();
        goto L14
    }

    public static final void R5(XplayFloatWindowView r2, j80.d r3) {
        c r4 = r2.g;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "offset");
        RectF r0 = r4.d();
        r0.offset(r3.a().floatValue(), r3.b().floatValue());
        c.b(r0, r4.c());
        Intrinsics.checkNotNullParameter(r0, "$this$pos");
        j80.d r5 = new j80.d(r0.left, r0.top);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r4.a.set(r5);
    }

    public static final void S5(XplayFloatWindowView r3, int r4) {
        r3.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r5 = r3.c;
        if (r5 == null) goto L5;
        T5(r0, r5);
    L5:
        r0.put("click_location", String.valueOf(r4));
        u.l().sendLog("livesdk_barrage_clear_screen_page_click", r0, new Object[]{Room.class});
    }

    public static void T5(Map r2, com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r3) {
        r2.put("is_clear_screen", m2.b(r3.b.getValue().booleanValue()));
        l r4 = r3.c.h;
        r2.put("game_name", r4.c);
        r2.put("game_app_id", r4.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "changedView");
        super/*android.view.ViewGroup*/.onVisibilityChanged(r4, r5);
        if (r5 != 0) goto L9;
        LinkedHashMap r6 = new LinkedHashMap();
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r7 = this.c;
        if (r7 == null) goto L7;
        T5(r6, r7);
    L7:
        u.l().sendLog("livesdk_barrage_clear_screen_page_show", r6, new Object[]{Room.class});
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XplayFloatWindowView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new CompositeDisposable();
        this.g = new c(this);
        this.h = new b(this);
    }

    public /* synthetic */ XplayFloatWindowView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onSizeChanged(r1, r2, r3, r4);
        this.i = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        super.onLayout(r4, r5, r6, r7, r8);
        boolean r9 = true;
        if (this.j == false) goto L18;
        this.j = false;
        c r11 = this.g;
        r11.e(r11.d);
        if (this.g.a().b().floatValue() == 0.0f) goto L16;
        XplayLog.a("XplayFloatWindowView", "window position restore failed, moving to default position");
        c r12 = this.g;
        int[] r0 = r12.e;
        if (r0 != null) goto L9;
        boolean r13 = false;
    L10:
        if (r13 == true) goto L15;
        float r14 = t6.a(getContext(), 132.0f);
        c r1 = this.g;
        j80.d r2 = new j80.d(0.0f, r14);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "pos");
        RectF r15 = r1.d();
        r15.offsetTo(r2.a().floatValue(), r2.b().floatValue());
        c.b(r15, r1.c());
        Intrinsics.checkNotNullParameter(r15, "$this$pos");
        j80.d r3 = new j80.d(r15.left, r15.top);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.a.set(r3);
        c r16 = this.g;
        if (r16.e != null) goto L15;
        int[] r17 = new int[2];
        r16.f.getLocationOnScreen(r17);
        r16.e = r17;
    L15:
        this.g.a();
        c r18 = this.g;
        r18.f.getLocationOnScreen(r18.d);
        goto L18
    L9:
        r12.e(r0);
        r13 = true;
        goto L10
    L16:
        c r19 = this.g;
        r19.f.getLocationOnScreen(r19.d);
        XplayLog.a("XplayFloatWindowView", "window position restored");
    L18:
        if (this.i == false) goto L28;
        this.i = false;
        j80.d r21 = this.g.a();
        Intrinsics.checkNotNullParameter(r21, "$this$isZero");
        if (r21.a().floatValue() == 0.0f) goto L22;
    L24:
        r9 = false;
    L25:
        if (r9 == true) goto L29;
        XplayLog.a("XplayFloatWindowView", "constrain after window resize");
        c r22 = this.g;
        r22.f.getLocationOnScreen(r22.d);
        return;
    L29:
        return;
    L22:
        if (r21.b().floatValue() != 0.0f) goto L24;
    }
}
