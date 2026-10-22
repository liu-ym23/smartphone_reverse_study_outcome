package com.obric.memorydata.memory.ui.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 {2\u00020\u0001:\u0002{|B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010L\u001a\u00020M2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020?2\b\b\u0002\u0010P\u001a\u00020\u0007J \u0010Q\u001a\u00020M2\u0018\u0010R\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00070T0SJ \u0010U\u001a\u00020M2\u0006\u0010O\u001a\u00020?2\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010WJ \u0010X\u001a\u00020M2\u0006\u0010P\u001a\u00020\u00072\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010WJ\u0018\u0010Y\u001a\u00020M2\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010WJ\u001a\u0010Z\u001a\u00020M2\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010WH\u0007J\u0018\u0010[\u001a\u00020M2\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010WJ\b\u0010\\\u001a\u00020MH\u0002J*\u0010]\u001a\u00020M2\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u00072\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010WH\u0002J\u0018\u0010`\u001a\u00020M2\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010WH\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J*\u0010b\u001a\u00020M2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u00072\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010WH\u0002J*\u0010e\u001a\u00020M2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u00072\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010WH\u0002J\b\u0010f\u001a\u00020\u0007H\u0002J\b\u0010g\u001a\u00020MH\u0002J\u0018\u0010h\u001a\u00020M2\u0006\u0010i\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0007H\u0014J\u0018\u0010k\u001a\u00020M2\u0006\u0010i\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0007H\u0002J\u0018\u0010l\u001a\u00020M2\u0006\u0010i\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0007H\u0002J0\u0010m\u001a\u00020M2\u0006\u0010n\u001a\u00020\u001c2\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u0007H\u0014J\b\u0010s\u001a\u00020MH\u0002J\b\u0010t\u001a\u00020MH\u0002J\u0012\u0010u\u001a\u00020v2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010w\u001a\u00020vH\u0014J\u0012\u0010u\u001a\u00020v2\b\u0010x\u001a\u0004\u0018\u00010vH\u0014J\u0012\u0010y\u001a\u00020\u001c2\b\u0010x\u001a\u0004\u0018\u00010vH\u0014J\b\u0010z\u001a\u00020MH\u0014R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010%\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR$\u0010(\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0>0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00070>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020G0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020?0IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/FlowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", EventBody.KEY_VALUE, "horizontalSpacing", "getHorizontalSpacing", "()I", "setHorizontalSpacing", "(I)V", "verticalSpacing", "getVerticalSpacing", "setVerticalSpacing", "orientation", "getOrientation", "setOrientation", "horizontalAlign", "getHorizontalAlign", "setHorizontalAlign", "verticalAlign", "getVerticalAlign", "setVerticalAlign", "", "singleLine", "getSingleLine", "()Z", "setSingleLine", "(Z)V", "maxLines", "getMaxLines", "setMaxLines", "childVerticalAlign", "getChildVerticalAlign", "setChildVerticalAlign", "allowChildClip", "getAllowChildClip", "setAllowChildClip", "childAnimDuration", "", "getChildAnimDuration", "()J", "setChildAnimDuration", "(J)V", "heightAnimDuration", "getHeightAnimDuration", "setHeightAnimDuration", "moveAnimDuration", "getMoveAnimDuration", "setMoveAnimDuration", "animInterpolator", "Landroid/view/animation/Interpolator;", "getAnimInterpolator", "()Landroid/view/animation/Interpolator;", "setAnimInterpolator", "(Landroid/view/animation/Interpolator;)V", "lineViews", "", "Landroid/view/View;", "lineHeights", "lineWidths", "heightAnimator", "Landroid/animation/ValueAnimator;", "animatedHeight", "preLayoutBounds", "", "Lcom/obric/memorydata/memory/ui/list/FlowLayout$ChildBounds;", "pendingAddViews", "", "pendingRemoveView", "isAnimatingLayout", "initAttributes", "", "addViewWithAnim", "child", "index", "addViewsWithAnim", "children", "", "Lkotlin/Pair;", "removeViewWithAnim", "onEnd", "Lkotlin/Function0;", "removeViewAtWithAnim", "removeAllViewsWithAnim", "animateShow", "animateHide", "recordPreLayoutBounds", "animateLayoutChanges", "startHeight", "endHeight", "finishLayoutAnimation", "currentHeight", "animateLayoutHeight", "from", TypedValues.TransitionType.S_TO, "animateHeightInternal", "measureNaturalHeight", "cancelAllAnimations", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureHorizontal", "measureVertical", "onLayout", "changed", "l", "t", "r", "b", "layoutHorizontal", "layoutVertical", "generateLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "p", "checkLayoutParams", "onDetachedFromWindow", "Companion", "ChildBounds", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11003a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11004b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private int i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private Interpolator n;
    private final List<List<View>> o;
    private final List<Integer> p;
    private final List<Integer> q;
    private ValueAnimator r;
    private int s;
    private final Map<View, a> t;
    private Set<View> u;
    private View v;
    private boolean w;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/FlowLayout$ChildBounds;", "", "left", "", "top", "right", "bottom", "<init>", "(IIII)V", "getLeft", "()I", "getTop", "getRight", "getBottom", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11006b;
        private final int c;
        private final int d;

        public a(int r1, int r2, int r3, int r4) {
            this.f11005a = r1;
            this.f11006b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final int a() {
            return this.f11005a;
        }

        public final int b() {
            return this.f11006b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f11005a == r6.f11005a) goto L12;
            return false;
        L12:
            if (this.f11006b == r6.f11006b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f11005a) * 31) + Integer.hashCode(this.f11006b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "ChildBounds(left=" + this.f11005a + ", top=" + this.f11006b + ", right=" + this.c + ", bottom=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/FlowLayout$Companion;", "", "<init>", "()V", "HORIZONTAL", "", "VERTICAL", "ALIGN_LEFT", "ALIGN_CENTER", "ALIGN_RIGHT", "ALIGN_TOP", "ALIGN_MIDDLE", "ALIGN_BOTTOM", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/list/FlowLayout$animateHeightInternal$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlowLayout f11007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f11008b;

        c(FlowLayout r3, Function0<Unit> r4) {
            Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            this.f11007a = r3;
            this.f11008b = r5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            FlowLayout.a(this.f11007a, -1);
            Function0<Unit> r1 = this.f11008b;
            if (r1 == null) goto L6;
            r1.invoke();
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/list/FlowLayout$animateLayoutHeight$2$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f11009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FlowLayout f11010b;
        final /* synthetic */ Function0<Unit> c;

        d(int r3, FlowLayout r4, Function0<Unit> r5) {
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            this.f11009a = r3;
            this.f11010b = r4;
            this.c = r6;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            if (this.f11009a <= 0) goto L5;
            FlowLayout r4 = this.f11010b;
            ViewGroup.LayoutParams r0 = r4.getLayoutParams();
            r0.height = -2;
            r4.setLayoutParams(r0);
        L5:
            Function0<Unit> r2 = this.c;
            if (r2 == null) goto L9;
            r2.invoke();
            return;
        }
    }

    static {
        f11003a = new b(null);
    }

    public FlowLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public FlowLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public FlowLayout(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r7);
        this.h = Integer.MAX_VALUE;
        this.k = 200;
        this.l = 250;
        this.m = 250;
        this.n = (Interpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), Interpolator.class, "com.obric.memorydata.plugin");
        this.o = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.p = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.q = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.s = -1;
        this.t = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.u = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        a(r9);
    }

    public /* synthetic */ FlowLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private static final Unit a(final FlowLayout r3, long r4, Function0 r6) {
        final Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        r3.postDelayed(new $$Lambda$FlowLayout$TBHV9OWFmOzpVFLwJRcqW0mPtb0(r3, r7), Math.max(0, r4 - r3.l));
        return Unit.INSTANCE;
    }

    private static final Unit a(FlowLayout r2, View r3, Function0 r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        r2.removeView(r3);
        if (r5 == null) goto L6;
        r5.invoke();
    L6:
        return Unit.INSTANCE;
    }

    private final void a() {
        this.t.clear();
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        View r3 = getChildAt(r2);
        Intrinsics.checkNotNull(r3);
        if (r3.getVisibility() != 8) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L14;
        if (r3.getWidth() <= 0) goto L14;
        if (r3.getHeight() <= 0) goto L14;
        this.t.put(r3, new a(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom()));
    L14:
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = false;
        goto L8
    }

    private final void a(int r24, int r25) {
        int r7 = View.MeasureSpec.getMode(r24);
        int r8 = View.MeasureSpec.getSize(r24);
        int r9 = View.MeasureSpec.getMode(r25);
        int r10 = View.MeasureSpec.getSize(r25);
        this.o.clear();
        this.p.clear();
        this.q.clear();
        List<View> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r12 = (r8 - getPaddingLeft()) - getPaddingRight();
        int r13 = getChildCount();
        List<View> r15 = r0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r5 >= r13) goto L43;
        View r1 = getChildAt(r5);
        Intrinsics.checkNotNull(r1);
        if (r1.getVisibility() != 8) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L42;
        int r21 = r3;
        int r22 = r4;
        measureChildWithMargins(r1, r24, 0, r25, 0);
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r14 = (r1.getMeasuredWidth() + r11.leftMargin) + r11.rightMargin;
        int r18 = (r1.getMeasuredHeight() + r11.topMargin) + r11.bottomMargin;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L13;
        int r19 = this.f11004b;
    L15:
        if (this.g == true) goto L23;
        int r20 = r22;
        if (((r20 + r14) + r19) > r12) goto L19;
    L24:
        boolean r23 = false;
    L25:
        if (r23 == false) goto L31;
        this.o.add(r15);
        this.p.add(Integer.valueOf(r17));
        this.q.add(Integer.valueOf(r20));
        int r26 = Math.max(r21, r20);
        if (this.o.size() <= 1) goto L29;
        int r27 = this.c;
    L30:
        r16 = r16 + (r17 + r27);
        r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r4 = 0;
        r3 = r26;
        int r28 = 0;
    L33:
        if (this.o.size() >= this.h) goto L35;
    L37:
        r15.add(r1);
        if (r15.size() <= 1) goto L40;
        int r29 = this.f11004b;
    L41:
        r4 = r4 + (r14 + r29);
        r17 = Math.max(r28, r18);
        goto L42
    L40:
        r29 = 0;
        goto L41
    L35:
        if (r15.isEmpty() == false) goto L37;
        r17 = r28;
    L45:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L51;
        this.o.add(r15);
        this.p.add(Integer.valueOf(r17));
        this.q.add(Integer.valueOf(r4));
        r3 = Math.max(r3, r4);
        if (this.o.size() <= 1) goto L49;
        int r110 = this.c;
    L50:
        r16 = r16 + (r17 + r110);
        goto L51
    L49:
        r110 = 0;
    L51:
        int r30 = r3 + (getPaddingLeft() + getPaddingRight());
        int r111 = r16 + (getPaddingTop() + getPaddingBottom());
        if (r7 == 1073741824) goto L55;
        r8 = r30;
    L55:
        if (r9 == 1073741824) goto L58;
        r10 = r111;
    L58:
        setMeasuredDimension(r8, r10);
        return;
    L29:
        r27 = 0;
        goto L30
    L31:
        r4 = r20;
        r3 = r21;
        r28 = r17;
        goto L33
    L19:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L24;
        if (this.o.size() >= this.h) goto L24;
        r23 = true;
        goto L25
    L23:
        r20 = r22;
        goto L24
    L13:
        r19 = 0;
    L42:
        r5 = r5 + 1;
        goto L3
    L7:
        r2 = false;
        goto L8
    L43:
        r3 = r3;
        goto L45
    }

    private final void a(int r10, int r11, Function0<Unit> r12) {
        final Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        this.w = true;
        int r2 = getChildCount();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L21;
        View r5 = getChildAt(r4);
        if (this.u.contains(r5) == true) goto L20;
        if (Intrinsics.areEqual(r5, this.v) == true) goto L20;
        Intrinsics.checkNotNull(r5);
        if (r5.getVisibility() != 8) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L20;
        a r7 = (a) ZeusTransformUtils.preCheckCast(this.t.get(r5), a.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L20;
        int r8 = r7.a() - r5.getLeft();
        int r9 = r7.b() - r5.getTop();
        if (r8 != 0) goto L19;
        if (r9 == 0) goto L20;
    L19:
        r5.setTranslationX(r8);
        r5.setTranslationY(r9);
        r5.animate().translationX(0.0f).translationY(0.0f).setDuration(this.m).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.n, TimeInterpolator.class, "com.obric.memorydata.plugin")).start();
        goto L20
    L12:
        r6 = false;
    L20:
        r4 = r4 + 1;
        goto L3
    L21:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.u, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r0.hasNext() == false) goto L25;
        ((View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.memorydata.plugin")).animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(this.k).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.n, TimeInterpolator.class, "com.obric.memorydata.plugin")).start();
        goto L23
    L25:
        final long r1 = Math.max(this.m, this.k);
        if (r10 == r11) goto L29;
        if (r10 <= 0) goto L29;
        c(r10, r11, new $$Lambda$FlowLayout$yrSKufafGrivwNVzCuVgt3zzxko(this, r1, r13));
        return;
    L29:
        postDelayed(new $$Lambda$FlowLayout$xdp4KpKJe8zGCNQ0DoodEZB6kI(this, r13), r1);
    }

    private final void a(AttributeSet r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L10;
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r6, R.styleable.FlowLayout);
        Intrinsics.checkNotNullExpressionValue(r7, "obtainStyledAttributes(...)");
        setHorizontalSpacing(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_horizontalSpacing, "styleable", "FlowLayout_horizontalSpacing"), 0));     // Catch: Throwable -> L7
        setVerticalSpacing(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_verticalSpacing, "styleable", "FlowLayout_verticalSpacing"), 0));     // Catch: Throwable -> L7
        setOrientation(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_orientation, "styleable", "FlowLayout_orientation"), 0));     // Catch: Throwable -> L7
        setHorizontalAlign(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_horizontalAlign, "styleable", "FlowLayout_horizontalAlign"), 0));     // Catch: Throwable -> L7
        setVerticalAlign(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_verticalAlign, "styleable", "FlowLayout_verticalAlign"), 0));     // Catch: Throwable -> L7
        setSingleLine(r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_singleLine, "styleable", "FlowLayout_singleLine"), false));     // Catch: Throwable -> L7
        setMaxLines(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_maxLines, "styleable", "FlowLayout_maxLines"), Integer.MAX_VALUE));     // Catch: Throwable -> L7
        setChildVerticalAlign(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_childVerticalAlign, "styleable", "FlowLayout_childVerticalAlign"), 0));     // Catch: Throwable -> L7
        setAllowChildClip(r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_allowChildClip, "styleable", "FlowLayout_allowChildClip"), false));     // Catch: Throwable -> L7
        r7.recycle();
        return;
    L7:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    public static final /* synthetic */ void a(FlowLayout r0, int r1) {
        r0.s = r1;
    }

    static /* synthetic */ void a(FlowLayout r1, int r2, int r3, Function0 r4, int r5, Object r6) {
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = null;
    L5:
        r1.a(r2, r3, r7);
    }

    private static final void a(FlowLayout r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        Object r5 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
        r0.height = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue();
        r3.setLayoutParams(r0);
    }

    public static /* synthetic */ void a(FlowLayout r1, View r2, Function0 r3, int r4, Object r5) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.a(r2, r6);
    }

    private static final void a(FlowLayout r2, Function0 r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        r2.b(0, r2.c(), r4);
    }

    public static /* synthetic */ void a(FlowLayout r1, Function0 r2, int r3, Object r4) {
        Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.a(r5);
    }

    private final int b() {
        int r0 = this.s;
        if (r0 < 0) goto L6;
        return r0;
    L6:
        return getHeight();
    }

    private static final Unit b(FlowLayout r2, Function0 r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        r2.setVisibility(8);
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        r0.height = -2;
        r2.setLayoutParams(r0);
        if (r4 == null) goto L6;
        r4.invoke();
    L6:
        return Unit.INSTANCE;
    }

    private final void b(int r24, int r25) {
        int r7 = View.MeasureSpec.getMode(r24);
        int r8 = View.MeasureSpec.getSize(r24);
        int r9 = View.MeasureSpec.getMode(r25);
        int r10 = View.MeasureSpec.getSize(r25);
        this.o.clear();
        this.p.clear();
        this.q.clear();
        List<View> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r12 = (r10 - getPaddingTop()) - getPaddingBottom();
        int r13 = getChildCount();
        List<View> r15 = r0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r5 >= r13) goto L43;
        View r1 = getChildAt(r5);
        Intrinsics.checkNotNull(r1);
        if (r1.getVisibility() != 8) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L42;
        int r21 = r3;
        int r22 = r4;
        measureChildWithMargins(r1, r24, 0, r25, 0);
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r14 = (r1.getMeasuredWidth() + r11.leftMargin) + r11.rightMargin;
        int r18 = (r1.getMeasuredHeight() + r11.topMargin) + r11.bottomMargin;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L13;
        int r19 = this.c;
    L15:
        if (this.g == true) goto L23;
        int r20 = r22;
        if (((r20 + r18) + r19) > r12) goto L19;
    L24:
        boolean r23 = false;
    L25:
        if (r23 == false) goto L31;
        this.o.add(r15);
        this.p.add(Integer.valueOf(r20));
        this.q.add(Integer.valueOf(r17));
        if (this.o.size() <= 1) goto L29;
        int r26 = this.f11004b;
    L30:
        r16 = r16 + (r17 + r26);
        int r27 = Math.max(r21, r20);
        r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r4 = 0;
        r3 = r27;
        int r28 = 0;
    L33:
        if (this.o.size() >= this.h) goto L35;
    L37:
        r15.add(r1);
        if (r15.size() <= 1) goto L40;
        int r29 = this.c;
    L41:
        r4 = r4 + (r18 + r29);
        r17 = Math.max(r28, r14);
        goto L42
    L40:
        r29 = 0;
        goto L41
    L35:
        if (r15.isEmpty() == false) goto L37;
        r17 = r28;
    L45:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L51;
        this.o.add(r15);
        this.p.add(Integer.valueOf(r4));
        this.q.add(Integer.valueOf(r17));
        if (this.o.size() <= 1) goto L49;
        int r110 = this.f11004b;
    L50:
        r16 = r16 + (r17 + r110);
        r3 = Math.max(r3, r4);
        goto L51
    L49:
        r110 = 0;
    L51:
        int r111 = r16 + (getPaddingLeft() + getPaddingRight());
        int r30 = r3 + (getPaddingTop() + getPaddingBottom());
        if (r7 == 1073741824) goto L55;
        r8 = r111;
    L55:
        if (r9 == 1073741824) goto L58;
        r10 = r30;
    L58:
        setMeasuredDimension(r8, r10);
        return;
    L29:
        r26 = 0;
        goto L30
    L31:
        r4 = r20;
        r3 = r21;
        r28 = r17;
        goto L33
    L19:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L24;
        if (this.o.size() >= this.h) goto L24;
        r23 = true;
        goto L25
    L23:
        r20 = r22;
        goto L24
    L13:
        r19 = 0;
    L42:
        r5 = r5 + 1;
        goto L3
    L7:
        r2 = false;
        goto L8
    L43:
        r3 = r3;
        goto L45
    }

    private final void b(int r5, int r6, Function0<Unit> r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        ValueAnimator r0 = this.r;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        if (r5 != r6) goto L11;
        if (r6 <= 0) goto L8;
        ViewGroup.LayoutParams r9 = getLayoutParams();
        r9.height = -2;
        setLayoutParams(r9);
    L8:
        if (r8 == null) goto L13;
        r8.invoke();
        return;
    L13:
        return;
    L11:
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{r5, r6});
        r10.setDuration(this.l);
        r10.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.n, TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r10.addUpdateListener(new $$Lambda$FlowLayout$sLFFyk5XDL9Q5weStqA2qMaaLWg(this));
        r10.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new d(r6, this, r8), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r10.start();
        this.r = r10;
    }

    private static final void b(FlowLayout r6, int r7) {
        a(r6, r7, r6.c(), null, 4, null);
    }

    private static final void b(FlowLayout r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
        r2.s = ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin")).intValue();
        r2.requestLayout();
    }

    private final int c() {
        if (getWidth() <= 0) goto L5;
        int r0 = getWidth();
    L12:
        if (r0 != 0) goto L14;
        return 0;
    L14:
        int r2 = this.s;
        this.s = -1;
        measure(View.MeasureSpec.makeMeasureSpec(r0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.s = r2;
        return getMeasuredHeight();
    L5:
        ViewParent r1 = getParent();
        if (ZeusTransformUtils.instanceOf(r1, View.class) == false) goto L8;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
    L9:
        if (r3 == null) goto L11;
        r0 = r3.getWidth();
        goto L12
    L11:
        r0 = 0;
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    private final void c(int r5, int r6, Function0<Unit> r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        ValueAnimator r0 = this.r;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        if (r5 != r6) goto L10;
        this.s = -1;
        if (r8 == null) goto L12;
        r8.invoke();
        return;
    L12:
        return;
    L10:
        this.s = r5;
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{r5, r6});
        r9.setDuration(this.l);
        r9.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.n, TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r9.addUpdateListener(new $$Lambda$FlowLayout$1MYDYBr6UKs3X5R9LqeFg4PTeo8(this));
        r9.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new c(this, r8), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r9.start();
        this.r = r9;
    }

    private static final void c(FlowLayout r2, Function0 r3) {
        r2.c((Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin"));
    }

    private final void c(Function0<Unit> r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        this.w = false;
        this.u.clear();
        this.v = null;
        this.t.clear();
        if (r4 == null) goto L6;
        r4.invoke();
        return;
    }

    private final void d() {
        ValueAnimator r0 = this.r;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        int r1 = getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        getChildAt(r2).animate().cancel();
        r2 = r2 + 1;
        goto L6
    L8:
        this.w = false;
        this.u.clear();
        this.v = null;
        this.t.clear();
        this.s = -1;
    }

    private static final void d(FlowLayout r2, Function0 r3) {
        r2.c((Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin"));
    }

    private final void e() {
        int r1 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r2 = getPaddingTop();
        int r3 = this.f;
        int r4 = 2;
        int r5 = 1;
        if (r3 != 1) goto L6;
        int r7 = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - (CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.p, Iterable.class, "com.obric.memorydata.plugin")) + ((this.p.size() - 1) * this.c))) / 2;
    L5:
        r2 = r2 + r7;
    L8:
        int r6 = ((Collection) ZeusTransformUtils.preCheckCast(this.o, Collection.class, "com.obric.memorydata.plugin")).size();
        int r8 = 0;
    L9:
        if (r8 >= r6) goto L31;
        List r9 = (List) ZeusTransformUtils.preCheckCast(this.o.get(r8), List.class, "com.obric.memorydata.plugin");
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(this.p.get(r8), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r11 = ((Number) ZeusTransformUtils.preCheckCast(this.q.get(r8), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r12 = getPaddingLeft();
        int r13 = this.e;
        if (r13 == r5) goto L15;
        if (r13 != r4) goto L17;
        int r14 = r1 - r11;
    L16:
        r12 = r12 + r14;
    L17:
        int r15 = ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).size();
        int r16 = 0;
    L18:
        if (r16 >= r15) goto L30;
        View r17 = (View) ZeusTransformUtils.preCheckCast(r9.get(r16), View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r18, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r110 = r17.getMeasuredWidth();
        int r111 = r17.getMeasuredHeight();
        int r20 = r19.leftMargin + r12;
        int r21 = r19.topMargin + r2;
        int r112 = r1;
        int r22 = this.i;
        int r113 = r6;
        if (r22 != 1) goto L22;
        r21 = r21 + ((((r10 - r111) - r19.topMargin) - r19.bottomMargin) / 2);
    L26:
        r17.layout(r20, r21, r20 + r110, r21 + r111);
        r12 = r12 + ((r110 + r19.leftMargin) + r19.rightMargin);
        if (r16 >= (r9.size() - 1)) goto L29;
        r12 = r12 + this.f11004b;
    L29:
        r16 = r16 + 1;
        r5 = 1;
        r1 = r112;
        r6 = r113;
        goto L18
    L22:
        if (r22 != 2) goto L26;
        r21 = r21 + (((r10 - r111) - r19.topMargin) - r19.bottomMargin);
        goto L26
    L30:
        r2 = r2 + (r10 + this.c);
        r8 = r8 + 1;
        r1 = r1;
        r6 = r6;
        r4 = 2;
        goto L9
    L15:
        r14 = (r1 - r11) / r4;
        goto L16
    L31:
        return;
    L6:
        if (r3 != 2) goto L8;
        r7 = ((getHeight() - getPaddingTop()) - getPaddingBottom()) - (CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.p, Iterable.class, "com.obric.memorydata.plugin")) + ((this.p.size() - 1) * this.c));
        goto L5
    }

    private final void f() {
        int r1 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r2 = getPaddingLeft();
        int r3 = this.e;
        int r4 = 2;
        int r5 = 1;
        if (r3 != 1) goto L6;
        int r7 = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.q, Iterable.class, "com.obric.memorydata.plugin")) + ((this.q.size() - 1) * this.f11004b))) / 2;
    L5:
        r2 = r2 + r7;
    L8:
        int r6 = ((Collection) ZeusTransformUtils.preCheckCast(this.o, Collection.class, "com.obric.memorydata.plugin")).size();
        int r8 = 0;
    L9:
        if (r8 >= r6) goto L31;
        List r9 = (List) ZeusTransformUtils.preCheckCast(this.o.get(r8), List.class, "com.obric.memorydata.plugin");
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(this.p.get(r8), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r11 = ((Number) ZeusTransformUtils.preCheckCast(this.q.get(r8), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r12 = getPaddingTop();
        int r13 = this.f;
        if (r13 == r5) goto L15;
        if (r13 != r4) goto L17;
        int r14 = r1 - r10;
    L16:
        r12 = r12 + r14;
    L17:
        int r15 = ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).size();
        int r16 = 0;
    L18:
        if (r16 >= r15) goto L30;
        View r17 = (View) ZeusTransformUtils.preCheckCast(r9.get(r16), View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r18, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r110 = r17.getMeasuredWidth();
        int r111 = r17.getMeasuredHeight();
        int r20 = r19.leftMargin + r2;
        int r21 = r19.topMargin + r12;
        int r112 = r1;
        int r22 = this.i;
        int r113 = r6;
        if (r22 == 1) goto L25;
        int r23 = 2;
        if (r22 != 2) goto L26;
        r20 = r20 + (((r11 - r110) - r19.leftMargin) - r19.rightMargin);
        r23 = 2;
    L26:
        r17.layout(r20, r21, r110 + r20, r21 + r111);
        r12 = r12 + ((r111 + r19.topMargin) + r19.bottomMargin);
        if (r16 >= (r9.size() - 1)) goto L29;
        r12 = r12 + this.c;
    L29:
        r16 = r16 + 1;
        r5 = 1;
        r1 = r112;
        r4 = r23;
        r6 = r113;
        goto L18
    L25:
        r23 = 2;
        r20 = r20 + ((((r11 - r110) - r19.leftMargin) - r19.rightMargin) / 2);
        goto L26
    L30:
        r2 = r2 + (r11 + this.f11004b);
        r8 = r8 + 1;
        r1 = r1;
        r4 = r4;
        r6 = r6;
        goto L9
    L15:
        r14 = (r1 - r10) / r4;
        goto L16
    L31:
        return;
    L6:
        if (r3 != 2) goto L8;
        r7 = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.q, Iterable.class, "com.obric.memorydata.plugin")) + ((this.q.size() - 1) * this.f11004b));
        goto L5
    }

    /* JADX INFO: renamed from: lambda$-xdp4KpKJe8zGCNQ0DoodEZB6kI, reason: not valid java name */
    public static /* synthetic */ void m872lambda$xdp4KpKJe8zGCNQ0DoodEZB6kI(FlowLayout r0, Function0 r1) {
        d(r0, r1);
    }

    public static /* synthetic */ void lambda$1MYDYBr6UKs3X5R9LqeFg4PTeo8(FlowLayout r0, ValueAnimator r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Hlno84Hd-3NQT-crzrVe3Mn5aQs, reason: not valid java name */
    public static /* synthetic */ Unit m873lambda$Hlno84Hd3NQTcrzrVe3Mn5aQs(FlowLayout r0, Function0 r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ void lambda$SW1dzqXi5U9Xhzbc3C45J8rZYec(FlowLayout r0, Function0 r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$TBHV9OWFmOzpVFLwJRcqW0mPtb0(FlowLayout r0, Function0 r1) {
        c(r0, r1);
    }

    public static /* synthetic */ void lambda$Yeqso58JwPQtLneli2trr72xozM(FlowLayout r0, int r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$sLFFyk5XDL9Q5weStqA2qMaaLWg(FlowLayout r0, ValueAnimator r1) {
        a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$yrSKufafGrivwNVzCuVgt3zzxko(FlowLayout r0, long r1, Function0 r3) {
        return a(r0, r1, r3);
    }

    public static /* synthetic */ Unit lambda$zvJMmBJ3Q6WFp4EEMDBJfVnk7Qs(FlowLayout r0, View r1, Function0 r2) {
        return a(r0, r1, r2);
    }

    public final void a(final View r8, Function0<Unit> r9) {
        final Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "child");
        if (indexOfChild(r8) >= 0) goto L8;
        if (r10 == null) goto L27;
        r10.invoke();
        return;
    L27:
        return;
    L8:
        if (this.w == false) goto L13;
        removeView(r8);
        if (r10 == null) goto L28;
        r10.invoke();
        return;
    L28:
        return;
    L13:
        a();
        int r0 = b();
        this.v = r8;
        int r2 = r8.getVisibility();
        r8.setVisibility(8);
        if (getWidth() <= 0) goto L16;
        int r3 = getWidth();
    L23:
        if (r3 <= 0) goto L25;
        measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(getLeft(), getTop(), getRight(), getBottom());
    L25:
        int r4 = getMeasuredHeight();
        r8.setVisibility(r2);
        a(r0, r4, new $$Lambda$FlowLayout$zvJMmBJ3Q6WFp4EEMDBJfVnk7Qs(this, r8, r10));
        r8.animate().alpha(0.0f).scaleX(0.8f).scaleY(0.8f).setDuration(this.k).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.n, TimeInterpolator.class, "com.obric.memorydata.plugin")).start();
        return;
    L16:
        ViewParent r5 = getParent();
        if (ZeusTransformUtils.instanceOf(r5, View.class) == false) goto L19;
        View r6 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin");
    L20:
        if (r6 == null) goto L22;
        r3 = r6.getWidth();
        goto L23
    L22:
        r3 = 0;
        goto L23
    L19:
        r6 = null;
        goto L20
    }

    public final void a(List<? extends Pair<? extends View, Integer>> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "children");
        if (r7.isEmpty() == false) goto L6;
        return;
    L6:
        if (((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")).getVisibility() != 8) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        setVisibility(0);
    L12:
        if (this.w == false) goto L21;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r8.hasNext() == false) goto L20;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.memorydata.plugin");
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1.component1(), View.class, "com.obric.memorydata.plugin");
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(r1.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r3 >= 0) goto L18;
        addView(r2);
        goto L15
    L18:
        addView(r2, r3);
        goto L15
    L20:
        return;
    L21:
        a();
        final int r4 = b();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r9.hasNext() == false) goto L28;
        Pair r5 = (Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.memorydata.plugin");
        View r10 = (View) ZeusTransformUtils.preCheckCast(r5.component1(), View.class, "com.obric.memorydata.plugin");
        int r11 = ((Number) ZeusTransformUtils.preCheckCast(r5.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        this.u.add(r10);
        r10.setAlpha(0.0f);
        r10.setScaleX(0.8f);
        r10.setScaleY(0.8f);
        if (r11 >= 0) goto L26;
        addView(r10);
        goto L23
    L26:
        addView(r10, r11);
        goto L23
    L28:
        post(new $$Lambda$FlowLayout$Yeqso58JwPQtLneli2trr72xozM(this, r4));
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final void a(Function0<Unit> r3) {
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if (((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        if (r4 == null) goto L12;
        r4.invoke();
        return;
    L12:
        return;
    L10:
        d();
        ViewGroup.LayoutParams r1 = getLayoutParams();
        r1.height = 0;
        setLayoutParams(r1);
        setVisibility(0);
        post(new $$Lambda$FlowLayout$SW1dzqXi5U9Xhzbc3C45J8rZYec(this, r4));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void b(Function0<Unit> r4) {
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if (getVisibility() == 0) goto L7;
        if (r5 == null) goto L9;
        r5.invoke();
        return;
    L9:
        return;
    L7:
        d();
        b(getHeight(), 0, new $$Lambda$FlowLayout$Hlno84Hd3NQTcrzrVe3Mn5aQs(this, r5));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(r2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    public final boolean getAllowChildClip() {
        return this.j;
    }

    public final Interpolator getAnimInterpolator() {
        return this.n;
    }

    public final long getChildAnimDuration() {
        return this.k;
    }

    public final int getChildVerticalAlign() {
        return this.i;
    }

    public final long getHeightAnimDuration() {
        return this.l;
    }

    public final int getHorizontalAlign() {
        return this.e;
    }

    public final int getHorizontalSpacing() {
        return this.f11004b;
    }

    public final int getMaxLines() {
        return this.h;
    }

    public final long getMoveAnimDuration() {
        return this.m;
    }

    public final int getOrientation() {
        return this.d;
    }

    public final boolean getSingleLine() {
        return this.g;
    }

    public final int getVerticalAlign() {
        return this.f;
    }

    public final int getVerticalSpacing() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (this.d != 0) goto L5;
        e();
        return;
    L5:
        f();
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        if (this.d != 0) goto L5;
        a(r2, r3);
    L7:
        if (this.s < 0) goto L10;
        setMeasuredDimension(getMeasuredWidth(), this.s);
        return;
    L10:
        return;
    L5:
        b(r2, r3);
        goto L7
    }

    public final void setAllowChildClip(boolean r1) {
        this.j = r1;
        requestLayout();
    }

    public final void setAnimInterpolator(Interpolator r3) {
        Interpolator r4 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r3, Interpolator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.n = r4;
    }

    public final void setChildAnimDuration(long r1) {
        this.k = r1;
    }

    public final void setChildVerticalAlign(int r1) {
        this.i = r1;
        requestLayout();
    }

    public final void setHeightAnimDuration(long r1) {
        this.l = r1;
    }

    public final void setHorizontalAlign(int r1) {
        this.e = r1;
        requestLayout();
    }

    public final void setHorizontalSpacing(int r1) {
        this.f11004b = r1;
        requestLayout();
    }

    public final void setMaxLines(int r2) {
        this.h = Math.max(1, r2);
        requestLayout();
    }

    public final void setMoveAnimDuration(long r1) {
        this.m = r1;
    }

    public final void setOrientation(int r1) {
        this.d = r1;
        requestLayout();
    }

    public final void setSingleLine(boolean r1) {
        this.g = r1;
        requestLayout();
    }

    public final void setVerticalAlign(int r1) {
        this.f = r1;
        requestLayout();
    }

    public final void setVerticalSpacing(int r1) {
        this.c = r1;
        requestLayout();
    }
}
