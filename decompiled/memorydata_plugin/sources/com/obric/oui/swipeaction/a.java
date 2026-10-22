package com.obric.oui.swipeaction;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewGroupKt;
import com.obric.oui.button.OIconButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001c\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0003FGHB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u00100\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0013H\u0016J\u0012\u00103\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u00104\u001a\u00020-H\u0016J\u0010\u0010\"\u001a\u00020-2\u0006\u00105\u001a\u00020\u0010H\u0016J\u0012\u00106\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00107\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J \u00108\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0016H\u0016J\b\u0010;\u001a\u00020-H\u0002J\u0010\u0010<\u001a\u00020-2\b\u0010=\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010>\u001a\u00020-2\b\u0010=\u001a\u0004\u0018\u00010#J\u0010\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\u0013H\u0002J \u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u0013H\u0002J\b\u0010E\u001a\u00020-H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper;", "Lcom/obric/oui/swipeaction/OSwipeLayout$SwipeListener;", "Lcom/obric/oui/swipeaction/OSwipeLayout$QuickDeleteListener;", "swipeLayout", "Lcom/obric/oui/swipeaction/OSwipeLayout;", "menuContainer", "Landroid/view/ViewGroup;", "(Lcom/obric/oui/swipeaction/OSwipeLayout;Landroid/view/ViewGroup;)V", "actionViews", "", "Landroid/view/View;", "animatorSet", "Landroid/animation/AnimatorSet;", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "isQuickDeleteState", "", "lastActionView", "lastCurrentOffset", "", "lastDragDistance", "lastItemOriginalBgColor", "", "Ljava/lang/Integer;", "lastItemOriginalMargin", "lastItemOriginalTint", "lastViewWidthProgress", "menuOriginalWidth", "onQuickDelete", "Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteListener;", "getOnQuickDelete", "()Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteListener;", "setOnQuickDelete", "(Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteListener;)V", "onQuickDeleteStateChanged", "Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteStateChangedListener;", "getOnQuickDeleteStateChanged", "()Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteStateChangedListener;", "setOnQuickDeleteStateChanged", "(Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteStateChangedListener;)V", "originalWidths", "", "othersAlphaProgress", "targetTransitionState", "captureOriginalState", "", "onClose", "layout", "onHandRelease", "xvel", "yvel", "onOpen", "onQuickDeleteAction", "isQuickDelete", "onStartClose", "onStartOpen", "onUpdate", "leftOffset", "topOffset", "resetButtons", "setOnQuickDeleteListener", "listener", "setOnQuickDeleteStateChangedListener", "startTransitionAnimation", TypedValues.AttributesType.S_TARGET, "updateViews", "currentOffset", "dragDistance", "progress", "updateViewsInternal", "Companion", "OnQuickDeleteListener", "OnQuickDeleteStateChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements OSwipeLayout.d, OSwipeLayout.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0778a f14513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OSwipeLayout f14514b;
    private final ViewGroup c;
    private b d;
    private c e;
    private final List<View> f;
    private final Map<View, Integer> g;
    private View h;
    private Integer i;
    private Integer j;
    private Integer k;
    private int l;
    private boolean m;
    private final ArgbEvaluator n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private AnimatorSet t;

    /* JADX INFO: renamed from: com.obric.oui.swipeaction.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0778a {
        private C0778a() {
        }

        public /* synthetic */ C0778a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteListener;", "", "onQuickDelete", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void onQuickDelete();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteStateChangedListener;", "", "onQuickDeleteStateChanged", "", "isQuickDelete", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a(boolean r1);
    }

    static {
        f14513a = new C0778a(null);
    }

    public a(OSwipeLayout r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "swipeLayout");
        Intrinsics.checkNotNullParameter(r5, "menuContainer");
        this.f14514b = r4;
        this.c = r5;
        this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.g = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.n = new ArgbEvaluator();
        r4.setShowMode(OSwipeLayout.ShowMode.LayDown);
        r4.a();
        r4.a((OSwipeLayout.g) ZeusTransformUtils.preCheckCast(this, OSwipeLayout.g.class, "com.obric.memorydata.plugin"));
        r4.setQuickDeleteListener((OSwipeLayout.d) ZeusTransformUtils.preCheckCast(this, OSwipeLayout.d.class, "com.obric.memorydata.plugin"));
        r4.setQuickDeleteEnabled(true);
        r4.setClipChildren(false);
        r4.setClipToPadding(false);
        r5.setClipChildren(false);
        r5.setClipToPadding(false);
        if (r5.getWidth() <= 0) goto L5;
        b();
    L5:
        r5.addOnLayoutChangeListener(new $$Lambda$a$nlNpgCFW0hgR2D9j9ZopdAGp8us(this));
    }

    private final void a(float r12) {
        if (this.q != r12) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.q = r12;
        AnimatorSet r1 = this.t;
        if (r1 == null) goto L12;
        r1.cancel();
    L12:
        this.t = new AnimatorSet();
        float r2 = 1.0f;
        if (r12 != 1.0f) goto L15;
        boolean r13 = true;
    L16:
        float[] r4 = new float[2];
        r4[0] = this.r;
        if (r13 == false) goto L19;
        float r6 = 1.0f;
    L20:
        r4[1] = r6;
        ValueAnimator r5 = ValueAnimator.ofFloat(r4);
        r5.setDuration(300);
        r5.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r5.addUpdateListener(new $$Lambda$a$t5LLy2CbAsZEb6iFKorlihU5eI0(this));
        float[] r8 = new float[2];
        r8[0] = this.s;
        if (r13 == true) goto L24;
        r2 = 0.0f;
    L24:
        r8[1] = r2;
        ValueAnimator r14 = ValueAnimator.ofFloat(r8);
        r14.setDuration(300);
        r14.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r14.addUpdateListener(new $$Lambda$a$ePb_A3UBBO5vMCu7gXtzItG8BCI(this));
        AnimatorSet r3 = this.t;
        if (r3 == null) goto L28;
        r3.playTogether(new Animator[]{(Animator) ZeusTransformUtils.preCheckCast(r5, Animator.class, "com.obric.memorydata.plugin"), (Animator) ZeusTransformUtils.preCheckCast(r14, Animator.class, "com.obric.memorydata.plugin")});
    L28:
        AnimatorSet r11 = this.t;
        if (r11 == null) goto L33;
        r11.start();
        return;
    L33:
        return;
    L19:
        r6 = 0.0f;
        goto L20
    L15:
        r13 = false;
        goto L16
    L5:
        r0 = false;
        goto L6
    }

    private final void a(float r10, float r11, float r12) {
        ViewGroup.MarginLayoutParams r1 = null;
        int r3 = 0;
        if (r12 > 1.0f) goto L43;
        float r13 = this.l - r10;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r15 = 0;
    L6:
        if (r14.hasNext() == false) goto L21;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r14.next(), View.class, "com.obric.memorydata.plugin");
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r5), Integer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        int r7 = r5.getWidth();
    L12:
        if (r5.getLayoutParams().width == r7) goto L14;
        r5.getLayoutParams().width = r7;
        r5.requestLayout();
    L14:
        r15 = r15 + r7;
        float r8 = r15 - r13;
        float r9 = 0.0f;
        if (r7 <= 0) goto L18;
        r9 = RangesKt.coerceIn(r8 / r7, 0.0f, 1.0f);
    L20:
        r5.setAlpha(r9);
        r5.setScaleX(r9);
        r5.setScaleY(r9);
        goto L6
    L18:
        if (r8 < 0.0f) goto L20;
        r9 = 1.0f;
        goto L20
    L10:
        r7 = r6.intValue();
        goto L12
    L21:
        View r16 = this.h;
        if (r16 == null) goto L36;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r17, ViewGroup.MarginLayoutParams.class) == false) goto L27;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r17, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L27:
        if (r1 == null) goto L36;
        if (this.i == null) goto L36;
        int r18 = r1.getMarginStart();
        Integer r19 = this.i;
        if (r19 != null) goto L34;
    L35:
        Integer r110 = this.i;
        Intrinsics.checkNotNull(r110);
        r1.setMarginStart(r110.intValue());
        r16.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        goto L36
    L34:
        if (r18 != r19.intValue()) goto L35;
    L36:
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.dropLast(this.f, 1), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L38:
        if (r111.hasNext() == false) goto L42;
        View r112 = (View) ZeusTransformUtils.preCheckCast(r111.next(), View.class, "com.obric.memorydata.plugin");
        if (r112.getVisibility() == 0) goto L38;
        r112.setVisibility(0);
        goto L38
    L42:
        this.c.requestLayout();
        return;
    L43:
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L45:
        if (r113.hasNext() == false) goto L52;
        View r20 = (View) ZeusTransformUtils.preCheckCast(r113.next(), View.class, "com.obric.memorydata.plugin");
        if (r20.getAlpha() != 1.0f) goto L49;
        boolean r21 = true;
    L50:
        if (r21 == true) goto L45;
        r20.setAlpha(1.0f);
        r20.setScaleX(1.0f);
        r20.setScaleY(1.0f);
        goto L45
    L49:
        r21 = false;
        goto L50
    L52:
        float r114 = RangesKt.coerceAtMost(r10 - r11, r11 * (this.f14514b.f14508b - 1.0f));
        View r115 = this.h;
        if (r115 != null) goto L55;
        return;
    L55:
        float r22 = 1.0f - this.r;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.dropLast(this.f, 1), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L57:
        if (r2.hasNext() == false) goto L65;
        View r23 = (View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.memorydata.plugin");
        r23.setAlpha(r22);
        r23.setScaleX(r22);
        r23.setScaleY(r22);
        Integer r24 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r23), Integer.class, "com.obric.memorydata.plugin");
        if (r24 != null) goto L61;
        int r25 = r23.getWidth();
    L62:
        int r26 = (int) (r25 * r22);
        if (r23.getLayoutParams().width == r26) goto L57;
        r23.getLayoutParams().width = r26;
        r23.requestLayout();
        goto L57
    L61:
        r25 = r24.intValue();
        goto L62
    L65:
        float r4 = this.s;
        ViewGroup.LayoutParams r27 = r115.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r27, ViewGroup.MarginLayoutParams.class) == false) goto L68;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r27, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L68:
        if (r1 == null) goto L76;
        Integer r28 = this.i;
        if (r28 == null) goto L73;
        r3 = r28.intValue();
    L73:
        int r0 = (int) (r3 * (1.0f - r4));
        if (r1.getMarginStart() == r0) goto L76;
        r1.setMarginStart(r0);
        r115.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L76:
        Integer r29 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r115), Integer.class, "com.obric.memorydata.plugin");
        if (r29 != null) goto L79;
        int r30 = r115.getWidth();
    L80:
        int r116 = (int) (r30 + r114);
        int r117 = (int) (r116 + ((((int) (r10 - (this.c.getPaddingLeft() + this.c.getPaddingRight()))) - r116) * r4));
        if (r115.getLayoutParams().width == r117) goto L84;
        r115.getLayoutParams().width = r117;
        r115.requestLayout();
    L84:
        if (ZeusTransformUtils.instanceOf(r115, ImageView.class) == false) goto L98;
        if (this.j == null) goto L98;
        Integer r118 = this.k;
        if (r118 == null) goto L93;
        ArgbEvaluator r31 = this.n;
        Intrinsics.checkNotNull(r118);
        Integer r32 = this.j;
        Intrinsics.checkNotNull(r32);
        Object r119 = r31.evaluate(r4, r118, r32);
        Objects.requireNonNull(r119, "null cannot be cast to non-null type kotlin.Int");
        int r120 = ((Integer) ZeusTransformUtils.preCheckCast(r119, Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (((ImageView) ZeusTransformUtils.preCheckCast(r115, ImageView.class, "com.obric.memorydata.plugin")).getBackgroundTintList() == null) goto L92;
        ((ImageView) ZeusTransformUtils.preCheckCast(r115, ImageView.class, "com.obric.memorydata.plugin")).setBackgroundTintList(ColorStateList.valueOf(r120));
        goto L93
    L92:
        r115.setBackgroundColor(r120);
    L93:
        ArgbEvaluator r121 = this.n;
        Integer r33 = this.j;
        Intrinsics.checkNotNull(r33);
        Object r34 = r121.evaluate(r4, r33, -1);
        Objects.requireNonNull(r34, "null cannot be cast to non-null type kotlin.Int");
        int r35 = ((Integer) ZeusTransformUtils.preCheckCast(r34, Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (((ImageView) ZeusTransformUtils.preCheckCast(r115, ImageView.class, "com.obric.memorydata.plugin")).getImageTintList() == null) goto L96;
        ((ImageView) ZeusTransformUtils.preCheckCast(r115, ImageView.class, "com.obric.memorydata.plugin")).setImageTintList(ColorStateList.valueOf(r35));
        goto L98
    L96:
        ((ImageView) ZeusTransformUtils.preCheckCast(r115, ImageView.class, "com.obric.memorydata.plugin")).setColorFilter(r35);
    L98:
        if (ZeusTransformUtils.instanceOf(r115, OIconButton.class) == false) goto L121;
        ((OIconButton) ZeusTransformUtils.preCheckCast(r115, OIconButton.class, "com.obric.memorydata.plugin")).setAlignmentProgress(r4);
        return;
    L121:
        return;
    L79:
        r30 = r29.intValue();
        goto L80
    }

    private static final void a(a r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "it");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.r = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue();
        r2.c();
    }

    private static final void a(a r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r1.getWidth() > 0) goto L5;
        return;
    L5:
        if (r0.l != 0) goto L8;
        r0.b();
        return;
    L8:
        boolean r10 = false;
        if (r0.f14514b.getIsBeingDragged() == false) goto L11;
    L15:
        boolean r11 = false;
    L16:
        AnimatorSet r12 = r0.t;
        if (r12 != null) goto L20;
    L22:
        boolean r13 = !r10;
        boolean r14 = r0.f14514b.m();
        if (r11 == false) goto L29;
        if (r13 == false) goto L30;
        if (r14 == true) goto L31;
        r0.b();
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L20:
        if (r12.isRunning() != true) goto L22;
        r10 = true;
        goto L22
    L11:
        if (r0.f14514b.getOpenStatus() != OSwipeLayout.Status.Close) goto L13;
    L14:
        r11 = true;
        goto L16
    L13:
        if (r0.f14514b.getOpenStatus() != OSwipeLayout.Status.Open) goto L15;
        goto L14
    }

    private final void b() {
        int r0 = this.c.getWidth();
        List r1 = SequencesKt.toList(SequencesKt.filter(ViewGroupKt.getChildren(this.c), (Function1) ZeusTransformUtils.preCheckCast(OSwipeQuickDeleteHelper$captureOriginalState$currentVisibleChildren$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")));
        if (r0 == this.l) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
    L25:
        if (r2 == true) goto L27;
        return;
    L27:
        this.l = r0;
        this.f.clear();
        this.g.clear();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L29:
        if (r3.hasNext() == false) goto L32;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.memorydata.plugin");
        this.f.add(r4);
        this.g.put(r4, Integer.valueOf(r4.getWidth()));
        goto L29
    L32:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L66;
        View r5 = (View) ZeusTransformUtils.preCheckCast(CollectionsKt.last(this.f), View.class, "com.obric.memorydata.plugin");
        this.h = r5;
        if (r5 == null) goto L66;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        Integer r7 = null;
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L39;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L40:
        if (r8 != null) goto L42;
        int r9 = 0;
    L43:
        this.i = r9;
        if (ZeusTransformUtils.instanceOf(r5, ImageView.class) == false) goto L51;
        ColorStateList r10 = ((ImageView) ZeusTransformUtils.preCheckCast(r5, ImageView.class, "com.obric.memorydata.plugin")).getImageTintList();
        if (r10 != null) goto L48;
        Integer r11 = null;
    L49:
        this.j = r11;
        goto L51
    L48:
        r11 = Integer.valueOf(r10.getDefaultColor());
    L51:
        if (r5.getBackgroundTintList() == null) goto L58;
        ColorStateList r12 = r5.getBackgroundTintList();
        if (r12 == null) goto L56;
    L55:
        r7 = Integer.valueOf(r12.getDefaultColor());
    L56:
        this.k = r7;
        goto L66
    L58:
        if (ZeusTransformUtils.instanceOf(r5.getBackground(), ColorDrawable.class) == false) goto L60;
        Drawable r13 = r5.getBackground();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        this.k = Integer.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r13, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor());
        goto L66
    L60:
        boolean r14 = ZeusTransformUtils.instanceOf(r5.getBackground(), GradientDrawable.class);
        Drawable r15 = r5.getBackground();
        if (r14 == false) goto L65;
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        r12 = ((GradientDrawable) ZeusTransformUtils.preCheckCast(r15, GradientDrawable.class, "com.obric.memorydata.plugin")).getColor();
        if (r12 != null) goto L55;
    L65:
        Log.e("OSwipeQuickDeleteHelper", Intrinsics.stringPlus("captureOriginalState : getLastItem bgColor failed: bg.class:", r15.getClass().getName()));
        goto L66
    L42:
        r9 = Integer.valueOf(r8.getMarginStart());
        goto L43
    L39:
        r8 = null;
    L66:
        ViewGroup.LayoutParams r16 = this.c.getLayoutParams();
        if (r16 == null) goto L69;
        r16.width = this.l;
        this.c.setLayoutParams(r16);
    L69:
        int r17 = RangesKt.coerceAtLeast(this.f14514b.getWidth() - this.l, 0);
        int r18 = this.l;
        float r19 = r18 + (r17 * 0.4f);
        if (r18 <= 0) goto L72;
        float r20 = r19 / r18;
    L73:
        float r21 = RangesKt.coerceAtLeast(r20, 1.1f);
        this.f14514b.setQuickDeleteThreshold(r21);
        this.f14514b.setQuickDeleteMax(r21 + 0.5f);
        this.f14514b.setOverrideDragDistance(this.l);
        return;
    L72:
        r20 = 1.5f;
        goto L73
    L8:
        if (r1.size() == this.f.size()) goto L10;
    L24:
        r2 = true;
        goto L25
    L10:
        if (r1.size() != this.g.size()) goto L24;
        int r22 = r1.size();
        int r23 = 0;
    L13:
        if (r23 >= r22) goto L25;
        int r24 = r23 + 1;
        if (Intrinsics.areEqual(r1.get(r23), this.f.get(r23)) == false) goto L24;
        int r25 = ((View) ZeusTransformUtils.preCheckCast(r1.get(r23), View.class, "com.obric.memorydata.plugin")).getWidth();
        Integer r26 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r1.get(r23)), Integer.class, "com.obric.memorydata.plugin");
        if (r26 != null) goto L20;
        int r27 = -1;
    L21:
        if (r25 != r27) goto L24;
        r23 = r24;
        goto L13
    L20:
        r27 = r26.intValue();
        goto L21
    L5:
        r2 = false;
        goto L6
    }

    private static final void b(a r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "it");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.s = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue();
        r2.c();
    }

    private final void c() {
        float r0 = this.p;
        if (r0 <= 0.0f) goto L6;
        float r1 = this.o;
        a(r1, r0, r1 / r0);
        return;
    }

    private final void d() {
        this.r = 0.0f;
        this.s = 0.0f;
        this.q = 0.0f;
        AnimatorSet r1 = this.t;
        if (r1 == null) goto L6;
        r1.cancel();
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.dropLast(this.f, 1), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.memorydata.plugin");
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r3), Integer.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L12;
        int r5 = r3.getWidth();
    L14:
        if (r3.getLayoutParams().width == r5) goto L16;
        r3.getLayoutParams().width = r5;
    L16:
        r3.setAlpha(1.0f);
        r3.setScaleX(1.0f);
        r3.setScaleY(1.0f);
        if (r3.getVisibility() == 0) goto L8;
        r3.setVisibility(0);
        goto L8
    L12:
        r5 = r4.intValue();
        goto L14
    L19:
        View r6 = this.h;
        if (r6 == null) goto L59;
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r6), Integer.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L25;
        int r8 = r6.getWidth();
    L27:
        if (r6.getLayoutParams().width == r8) goto L30;
        r6.getLayoutParams().width = r8;
    L30:
        if (ZeusTransformUtils.instanceOf(r6, OIconButton.class) == false) goto L32;
        ((OIconButton) ZeusTransformUtils.preCheckCast(r6, OIconButton.class, "com.obric.memorydata.plugin")).setAlignmentProgress(0.0f);
    L32:
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L35;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L36:
        if (r9 == null) goto L46;
        if (this.i == null) goto L46;
        int r10 = r9.getMarginStart();
        Integer r11 = this.i;
        if (r11 != null) goto L43;
    L44:
        Integer r12 = this.i;
        Intrinsics.checkNotNull(r12);
        r9.setMarginStart(r12.intValue());
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        goto L46
    L43:
        if (r10 != r11.intValue()) goto L44;
    L46:
        if (ZeusTransformUtils.instanceOf(r6, ImageView.class) == false) goto L59;
        if (this.j == null) goto L54;
        if (((ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.memorydata.plugin")).getImageTintList() == null) goto L52;
        ImageView r13 = (ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.memorydata.plugin");
        Integer r14 = this.j;
        Intrinsics.checkNotNull(r14);
        r13.setImageTintList(ColorStateList.valueOf(r14.intValue()));
        goto L54
    L52:
        ImageView r15 = (ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.memorydata.plugin");
        Integer r16 = this.j;
        Intrinsics.checkNotNull(r16);
        r15.setColorFilter(r16.intValue());
    L54:
        if (this.k == null) goto L59;
        if (((ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.memorydata.plugin")).getBackgroundTintList() == null) goto L58;
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.memorydata.plugin");
        Integer r18 = this.k;
        Intrinsics.checkNotNull(r18);
        r17.setBackgroundTintList(ColorStateList.valueOf(r18.intValue()));
        goto L59
    L58:
        Integer r19 = this.k;
        Intrinsics.checkNotNull(r19);
        r6.setBackgroundColor(r19.intValue());
        goto L59
    L35:
        r9 = null;
        goto L36
    L25:
        r8 = r7.intValue();
    L59:
        this.c.requestLayout();
    }

    public static /* synthetic */ void lambda$ePb_A3UBBO5vMCu7gXtzItG8BCI(a r0, ValueAnimator r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$nlNpgCFW0hgR2D9j9ZopdAGp8us(a r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void lambda$t5LLy2CbAsZEb6iFKorlihU5eI0(a r0, ValueAnimator r1) {
        a(r0, r1);
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.d
    public void a() {
        b r0 = this.d;
        if (r0 == null) goto L7;
        r0.onQuickDelete();
        return;
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.g
    public void a(OSwipeLayout r1) {
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.g
    public void a(OSwipeLayout r4, float r5, float r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        float r7 = ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        if (this.m == false) goto L7;
        return;
    L7:
        View r0 = this.h;
        boolean r1 = false;
        if (r0 == null) goto L17;
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r0), Integer.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L13;
        View r9 = this.h;
        Intrinsics.checkNotNull(r9);
        int r10 = r9.getWidth();
    L15:
        if (Math.abs(this.o) < (this.l - r10)) goto L17;
        r1 = true;
        goto L17
    L13:
        r10 = r8.intValue();
    L17:
        if (r1 == false) goto L19;
        r4.setDragDistance((int) (this.l / r7));
        r4.n();
        return;
    L19:
        r4.o();
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.g
    public void a(OSwipeLayout r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "layout");
        if (r3.c <= 0) goto L5;
        int r6 = r3.c;
    L6:
        float r7 = r6;
        float r0 = 0.0f;
        if (r7 != 0.0f) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return;
    L12:
        float r8 = Math.abs(r4);
        float r2 = r8 / r7;
        this.o = r8;
        this.p = r7;
        if (r2 < r3.f14507a) goto L15;
        r0 = 1.0f;
    L15:
        a(r0);
        a(r8, r7, r2);
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r6 = r3.getDragDistance();
        goto L6
    }

    public final void a(b r3) {
        this.d = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.d
    public void a(boolean r2) {
        if (this.m != r2) goto L5;
        return;
    L5:
        this.m = r2;
        c r0 = this.e;
        if (r0 == null) goto L10;
        r0.a(r2);
    L10:
        if (this.m == false) goto L13;
        com.obric.oui.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14514b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 3);
        return;
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.g
    public void b(OSwipeLayout r1) {
        d();
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.g
    public void c(OSwipeLayout r1) {
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.g
    public void d(OSwipeLayout r1) {
        d();
    }
}
