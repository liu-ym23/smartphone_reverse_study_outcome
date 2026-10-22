package com.ss.android.lark.chat.message.menu.v2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chameleon.util.AppInfoUtils;
import com.ss.android.lark.chat.message.menu.v2.adapter.GridSpaceItemDecoration;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.MessageActionAdapter;
import com.ss.android.lark.chat.message.menu.v2.emoji.BuiltInEmojiPanelView;
import com.ss.android.lark.chat.message.menu.v2.emoji.BuiltInTopEmojiView;
import com.ss.android.lark.chat.utils.a1;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.EmojiListView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageActionPanel implements j0 {
    public static final /* synthetic */ int W = 0;
    public MessageActionAdapter A;
    public RecyclerView B;
    public View C;
    public View D;
    public RecyclerView E;
    public MessageActionAdapter F;
    public View G;
    public TextView H;
    public DragPanelLayout I;
    public UDShadowLayout J;
    public UDShadowLayout K;
    public MessageActionAdapter L;
    public RecyclerView M;
    public View N;
    public final Map<PanelType, com.ss.android.lark.chat.message.menu.v2.a> O;
    public m0 P;
    public boolean Q;
    public Function0<Unit> R;
    public boolean S;
    public n0 T;
    public f U;
    public final Lazy V;
    public final Activity a;
    public final zya.g b;
    public List<? extends zya.e> c;
    public final o0 d;
    public final d e;
    public final Lazy f;
    public int g;
    public float h;
    public float i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final int q;
    public final int r;
    public final Lazy s;
    public MessageActionPanelContainerLayout t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public DragPanelLayout x;
    public UDShadowLayout y;
    public FrameLayout z;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ MessageActionPanel a;

        public b(MessageActionPanel r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            ViewGroup r0 = this.a.K;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
            r0 = null;
        L5:
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
            r0.setAlpha(((Float) r4).floatValue());
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ MessageActionPanel a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Function0<Unit> c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MessageActionPanel r3 = this.a;
            r3.Q = false;
            r3.R.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b == true) goto L8;
            ViewGroup r3 = this.a.K;
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
            r3 = null;
        L7:
            r3.setVisibility(8);
        L8:
            this.c.invoke();
            MessageActionPanel r4 = this.a;
            r4.Q = false;
            r4.R.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MessageActionPanel r3 = this.a;
            r3.Q = true;
            if (this.b == false) goto L9;
            ViewGroup r4 = r3.K;
            if (r4 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
            r4 = null;
        L7:
            r4.setVisibility(0);
            return;
        }

        public c(MessageActionPanel r1, boolean r2, Function0<Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void j() {
        if (this.S == true) goto L6;
        Log.w("MessageActionPanel", "dismissImmediately: wrong state, isAddedAndroidContent=false, method return");
        return;
    L6:
        k(new MessageActionPanel$dismissImmediately$1(this));
    }

    public final int l() {
        return ((Number) this.j.getValue()).intValue();
    }

    public final int m() {
        return ((Number) this.f.getValue()).intValue();
    }

    public final boolean n() {
        if (this.P.d != PanelActionType.PARTIAL_ACTION) goto L5;
        return true;
    L5:
        return false;
    }

    public final Activity getContext() {
        return this.a;
    }

    public static final void g(MessageActionPanel r5) {
        int r0 = View.MeasureSpec.makeMeasureSpec(r5.m(), 1073741824);
        int r1 = View.MeasureSpec.makeMeasureSpec((int) r5.i, PluginList.LEVEL_NOT_SET);
        DragPanelLayout r2 = r5.x;
        View r4 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanel");
        r2 = null;
    L5:
        r2.measure(r0, r1);
        DragPanelLayout r3 = r5.x;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanel");
        r3 = null;
    L8:
        int r6 = r3.getMeasuredHeight();
        com.ss.android.lark.chat.message.menu.v2.a r7 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) r5.O).get(PanelType.ACTION);
        if (r7 == null) goto L11;
        r7.c = Math.min(r6, r5.h);
    L11:
        DragPanelLayout r8 = r5.x;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanel");
        r8 = null;
    L14:
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L23;
        r9.height = (int) r5.i;
        r8.setLayoutParams(r9);
        View r10 = r5.y;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanelShadow");
    L20:
        q(r4);
        return;
    L19:
        r4 = r10;
        goto L20
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static void q(View r2) {
        r2.measure(0, 0);
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 == null) goto L7;
        r0.height = r2.getMeasuredHeight();
        r2.setLayoutParams(r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void a(final PanelType r17) {
        Intrinsics.checkNotNullParameter(r17, "to");
        Log.i("MessageActionPanel", "switch panel, from =" + this.P.getType().name() + ", to = " + r17.name());
        if (this.P.getType() != r17) goto L5;
        return;
    L5:
        final float r9 = this.P.b;
        if (r17 != PanelType.ACTION) goto L20;
        com.ss.android.lark.chat.message.menu.v2.a r0 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(r17);
        if (r0 == null) goto L18;
        DragPanelLayout r1 = r0.a;
        if (r1 == null) goto L18;
        com.ss.android.lark.chat.message.menu.v2.a r2 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(this.P.getType());
        if (r2 == null) goto L16;
        DragPanelLayout r3 = r2.a;
        if (r3 == null) goto L16;
        boolean r4 = r3.getInterceptChildMove();
    L17:
        r1.setInterceptChildMove(r4);
    L16:
        r4 = true;
    L18:
        final float r11 = r9;
    L36:
        com.ss.android.lark.chat.message.menu.v2.a r5 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(this.P.getType());
        if (r5 == null) goto L53;
        UDShadowLayout r12 = r5.b;
        if (r12 == null) goto L56;
        com.ss.android.lark.chat.message.menu.v2.a r6 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(r17);
        if (r6 == null) goto L54;
        UDShadowLayout r13 = r6.b;
        if (r13 == null) goto L57;
        this.P = m0.a(this.P, r17, r11, false, null, 12);
        Function0<Unit> r7 = new MessageActionPanel$switchPanel$1(this, r17, r9, r11);
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{1000.0f});
        r10.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        r10.setDuration(200);
        r10.addUpdateListener(new j(r12, r13));
        r10.addListener(new k(this, r13, r9, r7, r11, r12));
        r10.start();
        f r8 = this.U;
        if (r8 == null) goto L49;
        r8.d(r9, r11, 200);
    L49:
        n0 r14 = this.T;
        if (r14 == null) goto L55;
        r14.a(this.P.getType(), r17);
        return;
    L55:
        return;
    L57:
        return;
    L54:
        return;
    L56:
        return;
    L53:
        return;
    L20:
        if (r17 == PanelType.EMOJI) goto L22;
    L29:
        com.ss.android.lark.chat.message.menu.v2.a r15 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(r17);
        if (r15 == null) goto L34;
        DragPanelLayout r16 = r15.a;
        if (r16 == null) goto L34;
        r16.setInterceptChildMove(false);
    L34:
        float r18 = this.i;
    L35:
        r11 = r18;
        goto L36
    L22:
        if (r9 > this.h) goto L29;
        com.ss.android.lark.chat.message.menu.v2.a r19 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(r17);
        if (r19 == null) goto L28;
        DragPanelLayout r20 = r19.a;
        if (r20 == null) goto L28;
        r20.setInterceptChildMove(true);
    L28:
        r18 = this.h;
        goto L35
    }

    public final void i(boolean r6) {
        View r0 = this.D;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsContainer");
        r0 = null;
    L5:
        int r2 = 0;
        if (r6 == false) goto L8;
        int r4 = 0;
    L9:
        r0.setVisibility(r4);
        View r3 = this.C;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("firstLevelActionsContainer");
    L14:
        if ((!r6) == true) goto L17;
        r2 = 8;
    L17:
        r1.setVisibility(r2);
        return;
    L12:
        r1 = r3;
        goto L14
    L8:
        r4 = 8;
        goto L9
    }

    public final void k(final Function0<Unit> r2) {
        if (this.Q == false) goto L5;
        this.R = new MessageActionPanel$doActionAfterAnimation$1(r2, this);
        return;
    L5:
        r2.invoke();
    }

    public final void s(int r4) {
        ViewGroup r0 = this.b.a();
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.getHeight());
    L6:
        ConstraintLayout r3 = this.t;
        if (r3 == null) goto L10;
        r1 = Integer.valueOf(r3.getHeight());
    L10:
        if (Intrinsics.areEqual(r2, r1) == false) goto L12;
        return;
    L12:
        Activity r5 = this.a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        WindowInsetsUtils.c(r5).b(r4);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final void f(MessageActionPanel r8, a1 r9) {
        ViewGroup r0 = r8.K;
        ViewGroup r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r0 = null;
    L5:
        int r1 = r0.getMeasuredWidth();
        ViewGroup r3 = r8.K;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r3 = null;
    L8:
        int r4 = r3.getMeasuredHeight();
        if (r9.e == false) goto L11;
        int r5 = r9.f + ((r9.c + r9.d) / 2);
        int r6 = r1 / 2;
    L12:
        int r7 = r5 - r6;
        if (r7 >= 0) goto L16;
        r7 = r8.l();
    L18:
        int r10 = (r4 - ((Number) r8.o.getValue()).intValue()) - ((Number) r8.p.getValue()).intValue();
        int r11 = r8.g - ((Number) r8.k.getValue()).intValue();
        int r12 = r9.b;
        if ((r12 + r10) >= r11) goto L22;
        int r13 = (r12 + ((Number) r8.m.getValue()).intValue()) - ((Number) r8.o.getValue()).intValue();
    L26:
        ViewGroup r14 = r8.K;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r14 = null;
    L29:
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L44;
        ViewGroup r16 = r8.b.a();
        if (r16 == null) goto L34;
        Integer r17 = Integer.valueOf(r16.getHeight());
    L35:
        ConstraintLayout r18 = r8.t;
        if (r18 == null) goto L38;
        Integer r19 = Integer.valueOf(r18.getHeight());
    L40:
        if (Intrinsics.areEqual(r17, r19) == false) goto L42;
        int r20 = 0;
    L43:
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r15;
        r21.topMargin = r13 - r20;
        r21.setMarginStart(r7);
        goto L44
    L42:
        r20 = DeviceUtils.getStatusHeight(r8.a);
        goto L43
    L38:
        r19 = null;
        goto L40
    L34:
        r17 = null;
    L44:
        ViewGroup r22 = r8.K;
        if (r22 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
    L48:
        r2.setLayoutParams(r15);
        return;
    L47:
        r2 = r22;
        goto L48
    L22:
        if ((r9.a - r10) <= ((Number) r8.l.getValue()).intValue()) goto L24;
        int r23 = (r9.a - r4) + ((Number) r8.p.getValue()).intValue();
        int r24 = ((Number) r8.n.getValue()).intValue();
    L25:
        r13 = r23 - r24;
        goto L26
    L24:
        r23 = ((Math.min(r9.b, r11) - r4) + ((Number) r8.p.getValue()).intValue()) - ((Number) r8.n.getValue()).intValue();
        r24 = ((Number) r8.m.getValue()).intValue();
        goto L25
    L16:
        if (r7 <= ((r8.m() - r1) - r8.l())) goto L18;
        r7 = (r8.m() - r1) - r8.l();
        goto L18
    L11:
        r5 = r8.m() / 2;
        r6 = r1 / 2;
        goto L12
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void c(zya.b r3, List<zya.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "parentAction");
        Intrinsics.checkNotNullParameter(r4, "childActions");
        TextView r0 = this.H;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelTitle");
        r0 = null;
    L5:
        r0.setText(r3.e);
        MessageActionAdapter r5 = this.F;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsAdapter");
        r5 = null;
    L8:
        r5.resetAll(r4);
        i(true);
        View r6 = this.D;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsContainer");
        r6 = null;
    L11:
        q(r6);
        View r7 = this.C;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("firstLevelActionsContainer");
        r7 = null;
    L14:
        View r2 = this.D;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsContainer");
    L18:
        o(r7, r1);
        return;
    L17:
        r1 = r2;
        goto L18
    }

    public final void o(View r4, View r5) {
        float r0 = this.P.b;
        int r6 = r4.getMeasuredHeight();
        int r7 = r5.getMeasuredHeight();
        com.ss.android.lark.chat.message.menu.v2.a r1 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(this.P.getType());
        if (r1 == null) goto L11;
        DragPanelLayout r2 = r1.a;
        if (r2 == null) goto L11;
        if (r7 <= r0) goto L9;
        boolean r3 = true;
    L10:
        r2.setInterceptChildMove(r3);
        goto L11
    L9:
        r3 = false;
    L11:
        float r8 = r7;
        if (r8 <= r0) goto L26;
        float r9 = this.i;
        if (r8 <= r9) goto L16;
        r7 = (int) r9;
    L16:
        if (r7 <= r6) goto L27;
        com.ss.android.lark.chat.message.menu.v2.a r10 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(this.P.getType());
        if (r10 == null) goto L28;
        DragPanelLayout r11 = r10.a;
        if (r11 == null) goto L29;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L25;
        r12.height = r7;
        r11.setLayoutParams(r12);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    public final void u(boolean r8, Function0<Unit> r9) {
        ViewGroup r0 = this.K;
        UDShadowLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r0 = null;
    L5:
        Animation r2 = r0.getAnimation();
        if (r2 == null) goto L9;
        r2.cancel();
    L9:
        if (r8 == false) goto L11;
        float r4 = 0.0f;
    L12:
        if (r8 == false) goto L14;
        float r5 = 1.0f;
    L15:
        UDShadowLayout r6 = this.K;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
    L19:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r1, AppInfoUtils.VERSION_TYPE.VERSION_ALPHA, new float[]{r4, r5});
        r3.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        r3.setDuration(200);
        r3.addUpdateListener(new b(this));
        r3.addListener(new c(this, r8, r9));
        r3.start();
        return;
    L18:
        r1 = r6;
        goto L19
    L14:
        r5 = 0.0f;
        goto L15
    L11:
        r4 = 1.0f;
        goto L12
    }

    public static final void h(MessageActionPanel r3, float r4, com.ss.android.lark.chat.message.menu.v2.a r5) {
        r3.getClass();
        float r0 = r5.a.getHeight();
        float r6 = r5.c;
        float r7 = Math.max(0.0f, (r4 - r6) / (r0 - r6)) * 0.7f;
        int r8 = ((Number) r3.w.getValue()).intValue();
        r3.s(ColorUtils.compositeColors(Color.argb((int) (Color.alpha(r8) * r7), Color.red(r8), Color.green(r8), Color.blue(r8)), ((Number) r3.v.getValue()).intValue()));
        ConstraintLayout r9 = r3.t;
        ColorDrawable r10 = null;
        if (r9 == null) goto L5;
        Drawable r11 = r9.getBackground();
    L7:
        if ((r11 instanceof ColorDrawable) == false) goto L9;
        r10 = (ColorDrawable) r11;
    L9:
        if (r10 == null) goto L13;
        r10.setAlpha((int) (r7 * 256));
        r10.invalidateSelf();
        return;
    L13:
        return;
    L5:
        r11 = null;
        goto L7
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void d(boolean r1, MessageActionType r2, boolean r3) {
        k(new MessageActionPanel$dismiss$1(this));
    }

    public final void r(List<? extends zya.e> r12, RecyclerView r13, final MessageActionAdapter r14) {
        ArrayList r1 = new ArrayList();
        Iterator<T> r0 = r12.iterator();
    L3:
        boolean r3 = true;
        if (r0.hasNext() == false) goto L11;
        Object r2 = r0.next();
        if (((zya.e) r2).a() == 5) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L3;
        r1.add(r2);
        goto L3
    L11:
        final int r4 = r1.size();
        if (r4 > 1) goto L15;
        r13.setLayoutManager(new LinearLayoutManager(this.a));
        r14.resetAll(r12);
        return;
    L15:
        GridLayoutManager r5 = new GridLayoutManager(this.a, r4);
        r5.setSpanSizeLookup(new MessageActionPanel$setActionListToRv$1(r14, r4));
        r13.setLayoutManager(r5);
        r13.addItemDecoration(new GridSpaceItemDecoration(r4, this.q, r4));
        int r15 = (((m() - (l() * 2)) - ((r4 - 1) * this.q)) / r4) - (this.r * 2);
        int r6 = a0.a;
        Activity r7 = this.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r1, Keys.API_RETURN_KEY_DATA);
        float r8 = UIUtils.sp2px(r7, 12.0f);
        int r9 = UIUtils.getColor(r7, 2131106622);
        Iterator r10 = r1.iterator();
    L17:
        if (r10.hasNext() == false) goto L27;
        zya.b r11 = (zya.e) r10.next();
        if ((r11 instanceof zya.b) == false) goto L17;
        TextLayoutBuilder r16 = new TextLayoutBuilder();
        zya.b r17 = r11;
        r16.h(r17.e);
        r16.f(r15);
        r16.j((int) r8);
        r16.i(r9);
        r16.g = true;
        Layout r18 = r16.a();
        if (r18 == null) goto L23;
        int r19 = r18.getLineCount();
    L24:
        if (r19 > 2) goto L25;
        r17.l = new zya.c(12.0f, 16.0f);
        goto L17
    L25:
        r17.l = new zya.c(10.0f, 14.0f);
        goto L17
    L23:
        r19 = 0;
        goto L24
    L27:
        r14.resetAll(r12);
    }

    public static void p(MessageActionPanel r0, View r1, int r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r1.measure(r2, 0);
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
        if (r4 == null) goto L14;
        r4.width = r1.getMeasuredWidth();
        r1.setLayoutParams(r4);
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        if (r5 == null) goto L12;
        r5.height = r1.getMeasuredHeight();
        r1.setLayoutParams(r5);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, android.view.ViewGroup, com.ss.android.lark.chat.message.menu.v2.MessageActionPanelContainerLayout] */
    public MessageActionPanel(Activity r8, i r9, List r10, o0 r11, boolean r12, d r13) {
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r13;
        this.f = LazyKt.lazy(new MessageActionPanel$rootWidth$2(this));
        this.j = LazyKt.lazy(MessageActionPanel$normalMargin$2.INSTANCE);
        this.k = LazyKt.lazy(MessageActionPanel$partialSelectMaxBottomOffset$2.INSTANCE);
        this.l = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MessageActionPanel$partialSelectMaxTopOffset$2(this));
        this.m = LazyKt.lazy(MessageActionPanel$partialSelectBottomOffset$2.INSTANCE);
        this.n = LazyKt.lazy(MessageActionPanel$partialSelectTopOffset$2.INSTANCE);
        this.o = LazyKt.lazy(MessageActionPanel$partialSelectTopShadowSize$2.INSTANCE);
        this.p = LazyKt.lazy(MessageActionPanel$partialSelectBottomShadowSize$2.INSTANCE);
        this.q = UIHelper.dp2px(6.0f);
        this.r = UIHelper.dp2px(2.0f);
        this.s = LazyKt.lazy(new MessageActionPanel$partialLabelPaint$2(this));
        Lazy r14 = LazyKt.lazy(new MessageActionPanel$triggerLongClickParentView$2(this));
        this.u = r14;
        this.v = LazyKt.lazy(new MessageActionPanel$statusBarColor$2(this));
        Lazy r15 = LazyKt.lazy(new MessageActionPanel$maskColor$2(this));
        this.w = r15;
        LinkedHashMap r16 = new LinkedHashMap();
        this.O = r16;
        PanelType r1 = PanelType.ACTION;
        this.P = new m0(r1, 0.0f, false, PanelActionType.ALL_ACTION);
        this.R = MessageActionPanel$actionAfterAnimator$1.INSTANCE;
        Lazy r0 = LazyKt.lazy(new MessageActionPanel$panelDragLayoutChangeListener$2(this));
        this.V = r0;
        Object r2 = LayoutInflater.from(r8).inflate(2131563360, null);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.chat.message.menu.v2.MessageActionPanelContainerLayout");
        ?? r3 = (MessageActionPanelContainerLayout) r2;
        r3.setParentOtherChildView((View) r14.getValue());
        r3.setPanelDependency(new m(this));
        ColorDrawable r17 = new ColorDrawable(((Number) r15.getValue()).intValue());
        r17.setAlpha(0);
        r3.setBackground(r17);
        this.C = r3.findViewById(2131372594);
        this.x = (DragPanelLayout) r3.findViewById(2131362125);
        this.y = r3.findViewById(2131362126);
        this.B = r3.findViewById(2131379964);
        DragPanelLayout r18 = this.x;
        if (r18 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanel");
        r18 = null;
    L5:
        r18.setListener((MessageActionPanel$panelDragLayoutChangeListener$2.AnonymousClass1) r0.getValue());
        DragPanelLayout r4 = this.x;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanel");
        r4 = null;
    L8:
        UDShadowLayout r19 = this.y;
        if (r19 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanelShadow");
        r19 = null;
    L11:
        r16.put(r1, new com.ss.android.lark.chat.message.menu.v2.a(r4, r19));
        this.N = r3.findViewById(2131362962);
        if (this.c.isEmpty() == false) goto L17;
        ViewGroup r20 = this.B;
        if (r20 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("allActionRv");
        r20 = null;
    L16:
        r20.setVisibility(8);
    L33:
        this.z = (FrameLayout) r3.findViewById(2131362127);
        if (r13 == null) goto L37;
        r13.b(this);
    L37:
        if (r12 == true) goto L42;
        FrameLayout r110 = this.z;
        if (r110 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanelTopContainer");
        r110 = null;
    L41:
        r110.setVisibility(8);
    L49:
        this.D = r3.findViewById(2131385680);
        this.E = r3.findViewById(2131385679);
        this.G = r3.findViewById(2131363784);
        this.H = (TextView) r3.findViewById(2131381928);
        MessageActionAdapter r111 = new MessageActionAdapter();
        r111.z2(this);
        this.F = r111;
        RecyclerView r112 = this.E;
        if (r112 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsRv");
        r112 = null;
    L52:
        r112.setLayoutManager(new LinearLayoutManager(r8));
        RecyclerView r113 = this.E;
        if (r113 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsRv");
        r113 = null;
    L55:
        RecyclerView.Adapter r114 = this.F;
        if (r114 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsAdapter");
        r114 = null;
    L58:
        r113.setAdapter(r114);
        View r115 = this.G;
        if (r115 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("backToFirstLevelIv");
        r115 = null;
    L61:
        r115.setOnClickListener(new o(this));
        this.I = (DragPanelLayout) r3.findViewById(2131371539);
        this.J = r3.findViewById(2131371542);
        PanelType r116 = PanelType.EMOJI;
        DragPanelLayout r117 = this.I;
        if (r117 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("emojiPanel");
        r117 = null;
    L64:
        UDShadowLayout r5 = this.J;
        if (r5 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("emojiPanelShadow");
        r5 = null;
    L67:
        r16.put(r116, new com.ss.android.lark.chat.message.menu.v2.a(r117, r5));
        DragPanelLayout r118 = this.I;
        if (r118 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("emojiPanel");
        r118 = null;
    L70:
        r118.setListener((MessageActionPanel$panelDragLayoutChangeListener$2.AnonymousClass1) r0.getValue());
        FrameLayout r119 = (FrameLayout) r3.findViewById(2131362512);
        EmojiListView r120 = new BuiltInEmojiPanelView(r8);
        r120.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r120.setOnEmojiSelectListener(new n(this));
        r119.addView(r120);
        this.K = r3.findViewById(2131381947);
        this.M = r3.findViewById(2131381945);
        View r21 = this.K;
        if (r21 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r21 = null;
    L73:
        View r121 = this.M;
        if (r121 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("partialActionRv");
        r121 = null;
    L76:
        Intrinsics.checkNotNullParameter(r21, "containerView");
        Intrinsics.checkNotNullParameter(r121, "actualTouchView");
        r3.l.put(r21, r121);
        MessageActionAdapter r22 = new MessageActionAdapter();
        r22.z2(this);
        this.L = r22;
        RecyclerView r23 = this.M;
        if (r23 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("partialActionRv");
        r23 = null;
    L79:
        RecyclerView.Adapter r122 = this.L;
        if (r122 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("partialActionAdapter");
        r122 = null;
    L82:
        r23.setAdapter(r122);
        RecyclerView r24 = this.M;
        if (r24 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("partialActionRv");
        r24 = null;
    L85:
        r24.setLayoutManager(new LinearLayoutManager(r8));
        RecyclerView r25 = this.M;
        if (r25 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("partialActionRv");
        r25 = null;
    L88:
        r25.setItemAnimator(null);
        this.t = r3;
        return;
    L42:
        FrameLayout r123 = this.z;
        if (r123 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanelTopContainer");
        r123 = null;
    L45:
        r123.setVisibility(0);
        BuiltInTopEmojiView r124 = new BuiltInTopEmojiView(r8);
        l r125 = new l(this);
        Intrinsics.checkNotNullParameter(this, "control");
        Intrinsics.checkNotNullParameter(r125, "reactionClickListener");
        r124.j = this;
        r124.k = r125;
        ViewGroup.LayoutParams r126 = new ViewGroup.LayoutParams(-1, -2);
        FrameLayout r6 = this.z;
        if (r6 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanelTopContainer");
        r6 = null;
    L48:
        r6.addView(r124, r126);
        goto L49
    L17:
        ViewGroup r26 = this.B;
        if (r26 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("allActionRv");
        r26 = null;
    L20:
        r26.setVisibility(0);
        MessageActionAdapter r27 = new MessageActionAdapter();
        r27.z2(this);
        this.A = r27;
        RecyclerView r28 = this.B;
        if (r28 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("allActionRv");
        r28 = null;
    L23:
        RecyclerView.Adapter r7 = this.A;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("allActionAdapter");
        r7 = null;
    L26:
        r28.setAdapter(r7);
        List<? extends zya.e> r29 = this.c;
        RecyclerView r30 = this.B;
        if (r30 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("allActionRv");
        r30 = null;
    L29:
        MessageActionAdapter r31 = this.A;
        if (r31 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("allActionAdapter");
        r31 = null;
    L32:
        r(r29, r30, r31);
        goto L33
    }

    public static void t(MessageActionPanel r13, PanelType r14, boolean r15, float r16, float r17, long r18, Function0 r20, Function0 r21, Function2 r22, int r23) {
        if ((r23 & 32) == 0) goto L5;
        Function0 r2 = MessageActionPanel$startPanelAnim$1.INSTANCE;
    L7:
        if ((r23 & 64) == 0) goto L9;
        Function0 r3 = MessageActionPanel$startPanelAnim$2.INSTANCE;
    L11:
        if ((r23 & 128) == 0) goto L13;
        Function2 r1 = MessageActionPanel$startPanelAnim$3.INSTANCE;
    L14:
        com.ss.android.lark.chat.message.menu.v2.a r4 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) r13.O).get(r14);
        if (r4 != null) goto L17;
        Log.e("MessageActionPanel", "start panel anim error: get panel null, panelType = " + r14.name());
        return;
    L17:
        ViewGroup.LayoutParams r5 = r4.a.getLayoutParams();
        if (r5 == null) goto L20;
        Number r6 = Integer.valueOf(r5.height);
    L21:
        float r7 = r6.floatValue();
        ViewGroup.LayoutParams r8 = r4.b.getLayoutParams();
        if (r8 == null) goto L24;
        Number r9 = Integer.valueOf(r8.height);
    L25:
        float r10 = r9.floatValue();
        if (r7 >= r16) goto L28;
        float r11 = 0.0f;
    L30:
        if (r7 >= r17) goto L32;
        float r12 = r7;
    L34:
        if (r11 != 0.0f) goto L36;
        boolean r19 = true;
    L37:
        if (r19 == false) goto L39;
        float r24 = r10;
    L41:
        if (r12 != 0.0f) goto L43;
        boolean r25 = true;
    L44:
        if (r25 == true) goto L47;
        r10 = r7 - r12;
    L47:
        ValueAnimator r26 = ValueAnimator.ofFloat(new float[]{1000.0f});
        r26.setInterpolator(new AccelerateDecelerateInterpolator());
        r26.setDuration(r18);
        r26.addUpdateListener(new r(r4, r24, r10 - r24, r16, r17 - r16, r1));
        r26.addListener(new s(r13, r4, r15, r2, r3));
        r26.start();
        return;
    L43:
        r25 = false;
        goto L44
    L39:
        r24 = r7 - r11;
        goto L41
    L36:
        r19 = false;
        goto L37
    L32:
        r12 = r17;
        goto L34
    L28:
        r11 = r16;
        goto L30
    L24:
        r9 = Float.valueOf(r13.i);
        goto L25
    L20:
        r6 = Float.valueOf(r13.i);
        goto L21
    L13:
        r1 = r22;
        goto L14
    L9:
        r3 = r21;
        goto L11
    L5:
        r2 = r20;
        goto L7
    }
}
