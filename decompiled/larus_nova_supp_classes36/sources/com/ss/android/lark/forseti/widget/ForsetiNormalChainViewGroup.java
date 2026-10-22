package com.ss.android.lark.forseti.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.api.bean.ForsetiNodeMode;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.api.ui.NavigationMode;
import com.ss.android.lark.api.ui.f;
import com.ss.android.lark.api.ui.h;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainHelper;
import com.ss.android.lark.forseti.chain.ForsetiChainState;
import com.ss.android.lark.forseti.global.i;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.forsetiutils.BizType;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiEmbeddedUtils;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u008a\u00012\u00020\u0001:\u0004\u008a\u0001\u008b\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0014J\b\u0010K\u001a\u00020HH\u0002J\b\u0010L\u001a\u00020HH\u0002J\u0012\u0010M\u001a\u00020H2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\u0018\u0010P\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0002J\u0018\u0010Q\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0002J\u001a\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\b\u0010T\u001a\u0004\u0018\u00010\u001bH\u0002J\u0018\u0010U\u001a\u00020H2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u001bH\u0002J \u0010V\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000bH\u0002J0\u0010Z\u001a\u00020H2\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0007H\u0014J\u0010\u0010`\u001a\u00020H2\u0006\u0010a\u001a\u00020bH\u0014J\b\u0010c\u001a\u00020HH\u0002J\b\u0010d\u001a\u00020HH\u0002J\b\u0010e\u001a\u00020HH\u0014J\b\u0010f\u001a\u00020HH\u0002J\b\u0010g\u001a\u00020HH\u0002J\b\u0010h\u001a\u00020HH\u0002J\b\u0010i\u001a\u00020HH\u0002J\b\u0010j\u001a\u00020HH\u0002J\b\u0010k\u001a\u00020HH\u0002J\b\u0010l\u001a\u00020HH\u0002J\b\u0010m\u001a\u00020HH\u0014J\b\u0010n\u001a\u00020HH\u0002J\u000e\u0010o\u001a\u00020H2\u0006\u0010p\u001a\u00020\u000bJ\u000e\u0010q\u001a\u00020H2\u0006\u0010r\u001a\u00020\u0013J\u000e\u0010s\u001a\u00020H2\u0006\u0010t\u001a\u00020\u001eJ\u000e\u0010u\u001a\u00020H2\u0006\u0010t\u001a\u00020\u001eJ\u0006\u0010v\u001a\u00020HJ\u000e\u0010w\u001a\u00020H2\u0006\u0010t\u001a\u00020 J\u000e\u0010x\u001a\u00020H2\u0006\u0010t\u001a\u00020 J\u0006\u0010y\u001a\u00020HJ\u000e\u0010z\u001a\u00020H2\u0006\u0010t\u001a\u00020\"J\u000e\u0010{\u001a\u00020H2\u0006\u0010t\u001a\u00020\"J\u0006\u0010|\u001a\u00020HJ\u000e\u0010}\u001a\u00020H2\u0006\u0010t\u001a\u00020$J\u000e\u0010~\u001a\u00020H2\u0006\u0010t\u001a\u00020$J\u0006\u0010\u007f\u001a\u00020HJ\u0016\u0010\u0080\u0001\u001a\u00030\u0081\u00012\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0014J\n\u0010\u0083\u0001\u001a\u00030\u0081\u0001H\u0014J\t\u0010\u0089\u0001\u001a\u00020HH\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b<\u0010=R\u000e\u0010@\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010?\u001a\u0004\bB\u0010\fR\u000e\u0010D\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0084\u0001\u001a\n\u0012\u0005\u0012\u00030\u0086\u00010\u0085\u0001*\u00020\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainViewGroup;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isCMode", "", "()Z", "setCMode", "(Z)V", "isApplyLeftNavigation", "setApplyLeftNavigation", "chainVisible", "chainState", "Lcom/ss/android/lark/forseti/chain/ForsetiChainState;", "lastNavMode", "Lcom/ss/android/lark/api/ui/NavigationMode;", "getLastNavMode", "()Lcom/ss/android/lark/api/ui/NavigationMode;", "setLastNavMode", "(Lcom/ss/android/lark/api/ui/NavigationMode;)V", "lastWidthLevel", "Lcom/ss/android/lark/api/bean/ForsetiWidth;", "forsetiNodeWidthListeners", "", "Lcom/ss/android/lark/api/ui/IForsetiNodeWidthListener;", "forsetiNodeLeftChangeListeners", "Lcom/ss/android/lark/api/ui/IForsetiNodeLeftChangeListener;", "forsetiNavigationModeChangedListeners", "Lcom/ss/android/lark/api/ui/IForsetiNavigationModeChangedListener;", "forsetiSplitRatioChangedListeners", "Lcom/ss/android/lark/api/ui/IForsetiSplitRatioChangedListener;", "draggingHelper", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "getDraggingHelper", "()Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "setDraggingHelper", "(Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;)V", "chainHelper", "Lcom/ss/android/lark/forseti/chain/ForsetiChainHelper;", "getChainHelper", "()Lcom/ss/android/lark/forseti/chain/ForsetiChainHelper;", "setChainHelper", "(Lcom/ss/android/lark/forseti/chain/ForsetiChainHelper;)V", "chainConfig", "Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;", "getChainConfig", "()Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;", "setChainConfig", "(Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;)V", "isSupportedFoldDisplay", "lastOrientation", "contentView", "forsetiWidthObserver", "Lcom/ss/android/lark/forseti/global/ForsetiWidthObserver;", "getForsetiWidthObserver", "()Lcom/ss/android/lark/forseti/global/ForsetiWidthObserver;", "forsetiWidthObserver$delegate", "Lkotlin/Lazy;", "hasLoggedNavMode", "dispatchDisplayModeAfterDrawEnabled", "getDispatchDisplayModeAfterDrawEnabled", "dispatchDisplayModeAfterDrawEnabled$delegate", "hasPendingListenersCallback", "pendingListenersCallback", "Ljava/lang/Runnable;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "updateFullWidthIfNeed", "onNavigationModeChangeImpl", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "measureFrameLayout", "measureLinearLayout", "calculateMockWidthSpec", "globalWidthSize", "forsetiWidth", "onSplitRatioChangedImpl", "calculateExactlyWidthSpec", "lp", "Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainViewGroup$ForsetiChainLayoutParams;", "isFirstChild", "onLayout", "changed", "l", "t", "r", "b", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "scheduleListenersCallbackAfterDraw", "cancelPendingListenersCallback", "layoutFrameLayout", "layoutLinearLayoutV2", "layoutLinearLayout", "triggerDisplayModeChanged", "triggerListenersCallback", "triggerFrameDisplayModeChanged", "triggerLinearDisplayModeChanged", "triggerLinearDisplayModeChangedV2", "onDetachedFromWindow", "unregisterListeners", "updateChainVisible", "visible", "updateChainState", "state", "addForsetiNodeWidthChangeListener", "listener", "removeForsetiNodeWidthChangeListener", "removeForsetiNodeWidthChangeListeners", "addLastNodeLeftChangeListener", "removeLastNodeLeftChangeListener", "removeLastNodeLeftChangeListeners", "addNavigationModeChangedListener", "removeNavigationModeChangedListener", "removeNavigationModeChangedListeners", "addSplitRatioChangedListener", "removeSplitRatioChangedListener", "removeSplitRatioChangedListeners", "generateLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "p", "generateDefaultLayoutParams", "children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "requestLayout", "Companion", "ForsetiChainLayoutParams", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class ForsetiNormalChainViewGroup extends ViewGroup {
    public boolean a;
    public boolean b;
    public boolean c;
    public ForsetiChainState d;
    public NavigationMode e;
    public ForsetiWidth f;
    public final List<f> g;
    public final List<com.ss.android.lark.api.ui.d> h;
    public final List<com.ss.android.lark.api.ui.b> i;
    public final List<h> j;
    public ForsetiColumnsDraggingHelper k;
    public ForsetiChainHelper l;
    public com.ss.android.lark.api.bean.config.a m;
    public final boolean n;
    public int o;
    public final ViewGroup p;
    public final Lazy q;
    public boolean r;
    public final Lazy s;
    public boolean t;
    public final c u;

    public static final class a {
    }

    public static final class b extends ViewGroup.MarginLayoutParams {
        public ForsetiWidth a;

        public b(Context r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r3, r4);
            this.a = ForsetiWidth.AVERAGE_LEVEL;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ForsetiNormalChainViewGroup a;

        public c(ForsetiNormalChainViewGroup r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ForsetiNormalChainViewGroup r0 = this.a;     // Catch: Throwable -> L6
            r0.t = false;     // Catch: Throwable -> L6
            if (r0.isAttachedToWindow() == false) goto L9;
            this.a.c();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public ForsetiNormalChainViewGroup(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ForsetiNormalChainViewGroup(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final boolean getDispatchDisplayModeAfterDrawEnabled() {
        return ((Boolean) this.s.getValue()).booleanValue();
    }

    private final i getForsetiWidthObserver() {
        return (i) this.q.getValue();
    }

    public final void b() {
        Lazy r0 = ForsetiConfig.a;
        this.b = ForsetiConfig.c(getContext());
        Context r1 = getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        int r2 = ForsetiEmbeddedUtils.e(r1);
        com.ss.android.lark.forsetiutils.b.a.getClass();
        int r3 = com.ss.android.lark.forsetiutils.b.b(r2, r1);
        if (((Boolean) ForsetiConfig.e.getValue()).booleanValue() == true) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (this.b == false) goto L13;
        if (r4 == false) goto L12;
        NavigationMode r5 = NavigationMode.LEFT_WIDE_MODE;
    L15:
        if (((ArrayList) this.i).isEmpty() == false) goto L18;
        Log.e("FST_ChainViewGroup", "forsetiNavigationModeChangedListeners is empty.");
        return;
    L18:
        Iterator r6 = ((ArrayList) this.i).iterator();
    L20:
        if (r6.hasNext() == false) goto L30;
        com.ss.android.lark.api.ui.b r7 = (com.ss.android.lark.api.ui.b) r6.next();
        if (((Boolean) ForsetiConfig.e.getValue()).booleanValue() == false) goto L20;
        if (this.e != r5) goto L26;
        if (this.r == true) goto L20;
        Log.i("FST_ChainViewGroup", "lastNavMode and currentNavMode are equal: " + r5);
        this.r = true;
        goto L20
    L26:
        Log.i("FST_ChainViewGroup", "onNavigationModeChange, lastNavMode: " + this.e + ", currentNavMode: " + r5);
        r7.a();
        this.e = r5;
        this.r = false;
        goto L20
    L30:
        return;
    L12:
        r5 = NavigationMode.LEFT_NARROW_MODE;
        goto L15
    L13:
        r5 = NavigationMode.BOTTOM_MODE;
        goto L15
    L5:
        if (r3 < 1194.0f) goto L7;
        r4 = true;
        goto L9
    }

    public final void c() {
        if (this.c == true) goto L26;
        int r0 = 0;
    L6:
        if (r0 >= getChildCount()) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L157;
        int r5 = r0 + 1;
        com.ss.android.lark.api.ui.c r1 = getChildAt(r0);
        if (r1 == null) goto L24;
        if ((r1 instanceof com.ss.android.lark.api.ui.c) == false) goto L15;
        com.ss.android.lark.api.ui.c r2 = r1;
    L16:
        if (r2 == null) goto L22;
        if (this.a == false) goto L20;
        ForsetiNodeMode r6 = ForsetiNodeMode.INVISIBLE_C;
    L21:
        r2.a(r6);
        goto L22
    L20:
        r6 = ForsetiNodeMode.INVISIBLE_R;
    L22:
        r0 = r5;
        goto L6
    L15:
        r2 = null;
        goto L16
    L24:
        throw new IndexOutOfBoundsException();
    L157:
        Lazy r3 = ForsetiFGHelpers.a;
        if (ForsetiFGHelpers.c(BizType.IM, "opt_nav_width") == false) goto L172;
        ForsetiChainState r7 = this.d;
        if (r7 == null) goto L167;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7.getValue() <= ForsetiChainState.STOPPED.getValue()) goto L164;
        boolean r8 = true;
    L165:
        if (r8 == true) goto L167;
        return;
    L164:
        r8 = false;
    L167:
        if (r7 == null) goto L169;
    L174:
        i r9 = getForsetiWidthObserver();
        List<f> r10 = this.g;
        d r11 = new d(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "forsetiNodeWidthListeners");
        Intrinsics.checkNotNullParameter(r11, "children");
        View r12 = (View) SequencesKt.elementAtOrNull(r11, 0);
        if (r12 == null) goto L177;
        r12.getWidth();
    L177:
        View r13 = (View) SequencesKt.elementAtOrNull(r11, 1);
        if (r13 == null) goto L180;
        int r14 = r13.getWidth();
    L181:
        Iterator r15 = ((ArrayList) r10).iterator();
    L183:
        if (r15.hasNext() == false) goto L185;
        f r16 = (f) r15.next();
        r16.b();
        r16.a(r14);
        goto L183
    L185:
        Iterator r17 = ((ArrayList) this.h).iterator();
    L187:
        if (r17.hasNext() == false) goto L193;
        com.ss.android.lark.api.ui.d r18 = (com.ss.android.lark.api.ui.d) r17.next();
        View r19 = (View) SequencesKt.lastOrNull(new d(this));
        if (r19 == null) goto L191;
        int r20 = r19.getLeft();
    L192:
        r18.a(r20);
        goto L187
    L191:
        r20 = 0;
        goto L192
    L193:
        return;
    L180:
        r14 = 0;
        goto L181
    L169:
        if (this.c == true) goto L174;
        return;
    L172:
        if (this.c == true) goto L174;
        return;
    L8:
        r4 = false;
        goto L9
    L26:
        if (this.a == false) goto L65;
        int r21 = getChildCount() - 1;
        boolean r22 = false;
    L28:
        if ((-1) >= r21) goto L157;
        com.ss.android.lark.api.ui.c r23 = getChildAt(r21);
        if (r23.getVisibility() != 0) goto L48;
        int r24 = getMeasuredWidth();
        int r25 = r23.getLeft();
        if (r25 < 0) goto L35;
        if (r25 >= r24) goto L35;
        boolean r26 = true;
    L36:
        if (r26 == false) goto L48;
        if (r23.getMeasuredWidth() <= 0) goto L48;
        int r27 = getMeasuredHeight();
        int r28 = r23.getTop();
        if (r28 < 0) goto L43;
        if (r28 >= r27) goto L43;
        boolean r29 = true;
    L44:
        if (r29 == false) goto L48;
        if (r23.getMeasuredHeight() <= 0) goto L48;
        boolean r30 = true;
    L49:
        if (r30 == false) goto L59;
        if (r22 == true) goto L59;
        if ((r23 instanceof com.ss.android.lark.api.ui.c) == false) goto L54;
        com.ss.android.lark.api.ui.c r31 = r23;
    L55:
        if (r31 == null) goto L57;
        r31.a(ForsetiNodeMode.NORMAL_C);
    L57:
        r22 = true;
    L64:
        r21 = r21 - 1;
        goto L28
    L54:
        r31 = null;
    L59:
        if ((r23 instanceof com.ss.android.lark.api.ui.c) == false) goto L61;
        com.ss.android.lark.api.ui.c r32 = r23;
    L62:
        if (r32 == null) goto L64;
        r32.a(ForsetiNodeMode.INVISIBLE_C);
        goto L64
    L61:
        r32 = null;
    L43:
        r29 = false;
    L35:
        r26 = false;
    L48:
        r30 = false;
        goto L49
    L65:
        int r33 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.open_full_page") == true) goto L109;
        int r34 = getChildCount() - 1;
        boolean r35 = false;
    L68:
        if ((-1) >= r34) goto L157;
        com.ss.android.lark.api.ui.c r36 = getChildAt(r34);
        if (r36.getVisibility() != 0) goto L88;
        int r37 = getMeasuredWidth();
        int r38 = r36.getLeft();
        if (r38 < 0) goto L75;
        if (r38 >= r37) goto L75;
        boolean r39 = true;
    L76:
        if (r39 == false) goto L88;
        if (r36.getMeasuredWidth() <= 0) goto L88;
        int r40 = getMeasuredHeight();
        int r41 = r36.getTop();
        if (r41 < 0) goto L83;
        if (r41 >= r40) goto L83;
        boolean r42 = true;
    L84:
        if (r42 == false) goto L88;
        if (r36.getMeasuredHeight() <= 0) goto L88;
        boolean r43 = true;
    L89:
        if (r43 == false) goto L100;
        if (r36.getMeasuredWidth() != getMeasuredWidth()) goto L100;
        if ((r36 instanceof com.ss.android.lark.api.ui.c) == false) goto L95;
        com.ss.android.lark.api.ui.c r44 = r36;
    L96:
        if (r44 == null) goto L98;
        r44.a(ForsetiNodeMode.FULL_R);
    L98:
        r35 = true;
    L108:
        r34 = r34 - 1;
        goto L68
    L95:
        r44 = null;
    L100:
        if ((r36 instanceof com.ss.android.lark.api.ui.c) == false) goto L102;
        com.ss.android.lark.api.ui.c r45 = r36;
    L103:
        if (r45 == null) goto L108;
        if (r35 == false) goto L106;
        ForsetiNodeMode r46 = ForsetiNodeMode.INVISIBLE_R;
    L107:
        r45.a(r46);
        goto L108
    L106:
        r46 = ForsetiNodeMode.NORMAL_R;
        goto L107
    L102:
        r45 = null;
    L83:
        r42 = false;
    L75:
        r39 = false;
    L88:
        r43 = false;
        goto L89
    L109:
        int r47 = 0;
    L111:
        if (r47 >= getChildCount()) goto L113;
        boolean r48 = true;
    L114:
        if (r48 == false) goto L157;
        int r49 = r47 + 1;
        com.ss.android.lark.api.ui.c r50 = getChildAt(r47);
        if (r50 == null) goto L156;
        if (r50.getVisibility() != 0) goto L136;
        int r51 = getMeasuredWidth();
        int r52 = r50.getLeft();
        if (r52 < 0) goto L123;
        if (r52 >= r51) goto L123;
        boolean r53 = true;
    L124:
        if (r53 == false) goto L136;
        if (r50.getMeasuredWidth() <= 0) goto L136;
        int r54 = getMeasuredHeight();
        int r55 = r50.getTop();
        if (r55 < 0) goto L131;
        if (r55 >= r54) goto L131;
        boolean r56 = true;
    L132:
        if (r56 == false) goto L136;
        if (r50.getMeasuredHeight() <= 0) goto L136;
        boolean r57 = true;
    L137:
        if (r57 == false) goto L149;
        if ((r50 instanceof com.ss.android.lark.api.ui.c) == false) goto L141;
        com.ss.android.lark.api.ui.c r58 = r50;
    L142:
        if (r58 == null) goto L154;
        if (r50.getMeasuredWidth() != getMeasuredWidth()) goto L146;
        ForsetiNodeMode r59 = ForsetiNodeMode.FULL_R;
    L147:
        r58.a(r59);
        goto L154
    L146:
        r59 = ForsetiNodeMode.NORMAL_R;
    L154:
        r47 = r49;
        goto L111
    L141:
        r58 = null;
        goto L142
    L149:
        if ((r50 instanceof com.ss.android.lark.api.ui.c) == false) goto L151;
        com.ss.android.lark.api.ui.c r60 = r50;
    L152:
        if (r60 == null) goto L154;
        r60.a(ForsetiNodeMode.INVISIBLE_R);
        goto L154
    L151:
        r60 = null;
    L131:
        r56 = false;
    L123:
        r53 = false;
    L136:
        r57 = false;
        goto L137
    L156:
        throw new IndexOutOfBoundsException();
    L113:
        r48 = false;
        goto L114
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b(getContext(), -1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.t == false) goto L6;
        removeCallbacks(this.u);
        this.t = false;
    L6:
        super.onDetachedFromWindow();
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.navigation.fallback_removal_listeners") == false) goto L9;
        ((ArrayList) this.g).clear();
        ((ArrayList) this.h).clear();
        ((ArrayList) this.i).clear();
        ((ArrayList) this.j).clear();
    L9:
        Log.i("FST_ChainViewGroup", "onDetachedFromWindow");
    }

    public void a() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L18;
        View r3 = getChildAt(r2);
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        ViewGroup.MarginLayoutParams r6 = null;
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
    L8:
        if (r5 == null) goto L10;
        int r7 = r5.leftMargin;
    L11:
        ViewGroup.LayoutParams r8 = r3.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        r6 = (ViewGroup.MarginLayoutParams) r8;
    L14:
        if (r6 == null) goto L16;
        int r9 = r6.topMargin;
    L17:
        r3.layout(r7, r9, r3.getMeasuredWidth() + r7, r3.getMeasuredHeight() + r9);
        r2 = r2 + 1;
        goto L3
    L16:
        r9 = 0;
        goto L17
    L10:
        r7 = 0;
        goto L11
    L7:
        r5 = null;
        goto L8
    }

    public final com.ss.android.lark.api.bean.config.a getChainConfig() {
        return this.m;
    }

    public final ForsetiChainHelper getChainHelper() {
        return this.l;
    }

    public final ForsetiColumnsDraggingHelper getDraggingHelper() {
        return this.k;
    }

    public final NavigationMode getLastNavMode() {
        return this.e;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.dispatchDraw(r2);
        if (getDispatchDisplayModeAfterDrawEnabled() == true) goto L7;
        c();
        return;
    L7:
        if (this.t == true) goto L14;
        this.t = true;
        if (post(this.u) == true) goto L13;
        this.t = false;
        return;
    L13:
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        Context r1 = getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        int r2 = 0;
        if (r5 == null) goto L5;
        int r3 = r5.width;
    L6:
        if (r5 == null) goto L9;
        r2 = r5.height;
    L9:
        return new b(r1, r3, r2);
    L5:
        r3 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        int r0 = 0;
        if (r4 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L14;
        b();
        if (r4 == null) goto L12;
        r0 = r4.orientation;
    L12:
        this.o = r0;
        return;
    L14:
        return;
    L5:
        if (r4.orientation != this.o) goto L7;
        r1 = true;
        goto L8
    }

    public final void setApplyLeftNavigation(boolean r1) {
        this.b = r1;
    }

    public final void setCMode(boolean r1) {
        this.a = r1;
    }

    public final void setChainConfig(com.ss.android.lark.api.bean.config.a r1) {
        this.m = r1;
    }

    public final void setChainHelper(ForsetiChainHelper r1) {
        this.l = r1;
    }

    public final void setDraggingHelper(ForsetiColumnsDraggingHelper r1) {
        this.k = r1;
    }

    public final void setLastNavMode(NavigationMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    @Override // android.view.View
    public final void onMeasure(int r18, int r19) {
        setMeasuredDimension(ViewGroup.getDefaultSize(getSuggestedMinimumWidth(), r18), ViewGroup.getDefaultSize(getSuggestedMinimumHeight(), r19));
        int r10 = 1;
        int r11 = 0;
        if (fib.a.a() == false) goto L11;
        int r0 = cib.c.a;
        Context r1 = getContext();
        if ((r1 instanceof Activity) == false) goto L7;
        Activity r2 = (Activity) r1;
    L9:
        if (cib.c.a(r2, Integer.valueOf(getMeasuredWidth())) == ForsetiMode.Compact) goto L29;
    L30:
        boolean r3 = false;
    L31:
        this.a = r3;
        if (getChildCount() == 1) goto L34;
    L41:
        b();
        if (this.a == false) goto L46;
        int r9 = getChildCount();
    L44:
        if (r11 >= r9) goto L145;
        measureChildWithMargins(getChildAt(r11), r18, 0, r19, 0);
        r11 = r11 + 1;
        goto L44
    L145:
        return;
    L46:
        int r7 = View.MeasureSpec.getSize(r18);
        int r13 = getChildCount();
        int r14 = 0;
    L47:
        if (r14 >= r13) goto L157;
        View r15 = getChildAt(r14);
        ViewGroup.LayoutParams r4 = r15.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup.ForsetiChainLayoutParams");
        b r5 = (b) r4;
        com.ss.android.lark.forseti.util.dragging.d r6 = com.ss.android.lark.forseti.util.dragging.d.a;
        if (r14 != 0) goto L51;
        boolean r8 = true;
    L52:
        int r12 = getChildCount();
        com.ss.android.lark.api.bean.config.a r16 = this.m;
        ForsetiChainHelper r17 = this.l;
        if (r17 == null) goto L57;
        Integer r20 = Integer.valueOf(getChildCount());
        int r110 = ForsetiChainHelper.p;
        if (r17.a(r20, false) != r10) goto L57;
        boolean r21 = true;
    L58:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "lp");
        if (r12 != r10) goto L61;
        ForsetiWidth r22 = ForsetiWidth.FULL;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r5.a = r22;
    L103:
        if (r14 >= (getChildCount() - r10)) goto L132;
        ForsetiColumnsDraggingHelper r23 = this.k;
        if (r23 == null) goto L107;
        int r24 = r23.g(r7, r5.a);
    L108:
        measureChildWithMargins(r15, View.MeasureSpec.makeMeasureSpec(r24, 1073741824), 0, r19, 0);
        r15.getMeasuredWidth();
        ForsetiWidth r25 = r5.a;
        if (this.f == r25) goto L144;
        ForsetiColumnsDraggingHelper r26 = this.k;
        Intrinsics.checkNotNullParameter(r25, "forsetiWidth");
        ForsetiWidth r27 = com.ss.android.lark.forseti.util.dragging.d.b;
        if (r27 != null) goto L113;
    L124:
        Float r28 = null;
    L125:
        Log.i("FST_ChainViewGroup", "split ratio: " + r28 + '.');
        Iterator r29 = ((ArrayList) this.j).iterator();
    L127:
        if (r29.hasNext() == false) goto L131;
        h r30 = (h) r29.next();
        if (r28 == null) goto L127;
        r28.floatValue();
        r30.a();
        goto L127
    L131:
        this.f = r25;
        goto L144
    L113:
        if (com.ss.android.lark.forseti.util.dragging.d.c == null) goto L124;
        ForsetiWidth r31 = ForsetiWidth.FULL;
        if (r27 == r31) goto L124;
        if (r7 == 0) goto L124;
        float r32 = 0.0f;
        if (com.ss.android.lark.forseti.util.dragging.d.c != r31) goto L121;
        r28 = Float.valueOf(0.0f);
        goto L125
    L121:
        if (r26 == null) goto L123;
        r32 = r26.g(r7, r25);
    L123:
        r28 = Float.valueOf(r32 / r7);
    L144:
        r14 = r14 + 1;
        r10 = 1;
        goto L47
    L107:
        r24 = 0;
        goto L108
    L132:
        ForsetiWidth r33 = r5.a;
        if (r33 != ForsetiWidth.FULL) goto L139;
        ForsetiColumnsDraggingHelper r34 = this.k;
        if (r34 == null) goto L137;
        int r35 = r34.g(r7, r33);
    L138:
        measureChildWithMargins(r15, View.MeasureSpec.makeMeasureSpec(r35, 1073741824), 0, r19, 0);
        goto L144
    L137:
        r35 = 0;
        goto L138
    L139:
        ForsetiColumnsDraggingHelper r36 = this.k;
        if (r36 == null) goto L142;
        int r37 = r36.g(r7, r33);
    L143:
        measureChildWithMargins(r15, View.MeasureSpec.makeMeasureSpec(r37, 1073741824), 0, r19, 0);
        goto L144
    L142:
        r37 = 0;
        goto L143
    L61:
        if (r16 == null) goto L67;
        com.ss.android.lark.api.bean.config.b r38 = r16.f;
        if (r38 == null) goto L67;
        if (r38.c == true) goto L67;
        boolean r39 = true;
    L69:
        if (r39 == false) goto L88;
        int r40 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.dragging_disabled_and_average_width_disabled") == true) goto L103;
        if (r21 == false) goto L84;
        Log.i("DraggingNodeWidthManager", "dragging enabled is false, and current orientation supports dragging, updating new width.");
        if (r8 == false) goto L78;
        ForsetiWidth r41 = com.ss.android.lark.forseti.util.dragging.d.b;
    L79:
        if (r41 == null) goto L103;
        if (r5.a == ForsetiWidth.FULL) goto L103;
        Intrinsics.checkNotNullParameter(r41, "<set-?>");
        r5.a = r41;
        goto L103
    L78:
        r41 = com.ss.android.lark.forseti.util.dragging.d.c;
        goto L79
    L84:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.average_width_disabled") == true) goto L103;
        if (r5.a == ForsetiWidth.FULL) goto L103;
        Log.i("DraggingNodeWidthManager", "dragging enabled is false, and current orientation not supports dragging, updating new width to AVERAGE_LEVEL.");
        ForsetiWidth r42 = ForsetiWidth.AVERAGE_LEVEL;
        Intrinsics.checkNotNullParameter(r42, "<set-?>");
        r5.a = r42;
        goto L103
    L88:
        int r43 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.average_width_disabled") == true) goto L95;
        if (r21 == true) goto L95;
        if (r5.a == ForsetiWidth.FULL) goto L103;
        ForsetiWidth r44 = ForsetiWidth.AVERAGE_LEVEL;
        Intrinsics.checkNotNullParameter(r44, "<set-?>");
        r5.a = r44;
    L95:
        if (r8 == false) goto L97;
        ForsetiWidth r45 = com.ss.android.lark.forseti.util.dragging.d.b;
    L98:
        if (r45 == null) goto L103;
        if (r5.a == ForsetiWidth.FULL) goto L103;
        Intrinsics.checkNotNullParameter(r45, "<set-?>");
        r5.a = r45;
        goto L103
    L97:
        r45 = com.ss.android.lark.forseti.util.dragging.d.c;
    L67:
        r39 = false;
    L57:
        r21 = false;
        goto L58
    L51:
        r8 = false;
        goto L52
    L157:
        return;
    L34:
        if (this.n == false) goto L41;
        ViewGroup.LayoutParams r46 = getChildAt(0).getLayoutParams();
        if ((r46 instanceof b) == false) goto L38;
        b r47 = (b) r46;
    L39:
        if (r47 == null) goto L41;
        ForsetiWidth r48 = ForsetiWidth.FULL;
        Intrinsics.checkNotNullParameter(r48, "<set-?>");
        r47.a = r48;
        goto L41
    L38:
        r47 = null;
    L29:
        r3 = true;
        goto L31
    L7:
        r2 = null;
        goto L9
    L11:
        ViewGroup r49 = this.p;
        if (r49 == null) goto L26;
        int r50 = cib.c.a;
        Context r51 = getContext();
        if ((r51 instanceof Activity) == false) goto L16;
        Activity r52 = (Activity) r51;
    L17:
        int r53 = r49.getMeasuredWidth();
        int r54 = r49.getMeasuredHeight();
        if (r52 != null) goto L20;
        ForsetiMode r55 = ForsetiMode.Unknown;
    L28:
        if (r55 != ForsetiMode.Compact) goto L30;
    L20:
        com.ss.android.lark.base.embedded.e r56 = cib.c.b(r52, r53);
        if (r53 >= r56.a) goto L23;
    L25:
        r55 = ForsetiMode.Compact;
        goto L28
    L23:
        if (Math.min(r53, r54) < r56.b) goto L25;
        r55 = ForsetiMode.Regular;
        goto L28
    L16:
        r52 = null;
        goto L17
    L26:
        r55 = null;
        goto L28
    }

    public ForsetiNormalChainViewGroup(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = true;
        this.e = NavigationMode.BOTTOM_MODE;
        this.f = ForsetiWidth.FULL;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.n = com.ss.android.lark.base.embedded.b.g();
        ViewGroup r5 = null;
        if ((r2 instanceof Activity) == false) goto L5;
        Activity r6 = (Activity) r2;
    L6:
        if (r6 == null) goto L8;
        r5 = (ViewGroup) r6.findViewById(R.id.content);
    L8:
        this.p = r5;
        this.q = LazyKt.lazy(ForsetiNormalChainViewGroup$forsetiWidthObserver$2.INSTANCE);
        this.s = LazyKt.lazy(ForsetiNormalChainViewGroup$dispatchDisplayModeAfterDrawEnabled$2.INSTANCE);
        this.u = new c(this);
        setWillNotDraw(false);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public /* synthetic */ ForsetiNormalChainViewGroup(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        if (this.a == false) goto L5;
        a();
        return;
    L5:
        int r13 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.exit_full_screen_flash_disabled") == true) goto L36;
        int r14 = getChildCount();
        int r15 = 0;
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r15 >= r14) goto L147;
        View r2 = getChildAt(r15);
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
    L13:
        if (r4 == null) goto L15;
        int r5 = ((ViewGroup.MarginLayoutParams) r4).leftMargin;
    L16:
        if (r4 == null) goto L18;
        int r6 = ((ViewGroup.MarginLayoutParams) r4).topMargin;
    L19:
        if (r4 == null) goto L21;
        ForsetiWidth r7 = r4.a;
    L23:
        if (r7 != ForsetiWidth.FULL) goto L25;
        r2.layout(r5, r6, r2.getMeasuredWidth() + r5, r2.getMeasuredHeight() + r6);
    L35:
        r15 = r15 + 1;
        goto L8
    L25:
        if (r15 != 1) goto L27;
        r1 = r0;
    L27:
        int r16 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.dragging_view_splash_disabled") == true) goto L31;
        if (r15 <= 1) goto L31;
        boolean r17 = true;
    L32:
        if (r17 == false) goto L34;
        int r18 = r5 + r1;
        r2.layout(r18, r6, r2.getMeasuredWidth() + r18, r2.getMeasuredHeight() + r6);
        goto L35
    L34:
        int r19 = r5 + r0;
        r2.layout(r19, r6, r2.getMeasuredWidth() + r19, r2.getMeasuredHeight() + r6);
        r0 = r0 + r2.getMeasuredWidth();
    L31:
        r17 = false;
        goto L32
    L21:
        r7 = null;
        goto L23
    L18:
        r6 = 0;
        goto L19
    L15:
        r5 = 0;
        goto L16
    L12:
        r4 = null;
        goto L13
    L147:
        return;
    L36:
        View r110 = null;
        int r20 = 0;
    L38:
        if (r20 >= getChildCount()) goto L40;
        boolean r21 = true;
    L41:
        if (r21 == false) goto L53;
        int r22 = r20 + 1;
        View r23 = getChildAt(r20);
        if (r23 == null) goto L52;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup.ForsetiChainLayoutParams");
        if (((b) r24).a != ForsetiWidth.FULL) goto L47;
        boolean r25 = true;
    L48:
        if (r25 == false) goto L50;
        r110 = r23;
    L50:
        r20 = r22;
        goto L38
    L47:
        r25 = false;
        goto L48
    L52:
        throw new IndexOutOfBoundsException();
    L53:
        if (r110 == null) goto L96;
        int r26 = 0;
        int r27 = 0;
    L56:
        if (r26 >= getChildCount()) goto L58;
        boolean r28 = true;
    L59:
        if (r28 == false) goto L148;
        int r29 = r26 + 1;
        View r30 = getChildAt(r26);
        if (r30 == null) goto L95;
        int r31 = r27 + 1;
        if (r27 >= 0) goto L65;
        CollectionsKt.throwIndexOverflow();
    L65:
        ViewGroup.LayoutParams r32 = r30.getLayoutParams();
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == false) goto L68;
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;
    L69:
        if (r33 == null) goto L71;
        int r34 = r33.leftMargin;
    L72:
        ViewGroup.LayoutParams r35 = r30.getLayoutParams();
        if ((r35 instanceof ViewGroup.MarginLayoutParams) == false) goto L75;
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r35;
    L76:
        if (r36 == null) goto L78;
        int r37 = r36.topMargin;
    L80:
        if (Intrinsics.areEqual(r30, r110) == false) goto L82;
        r30.layout(r34, r37, r30.getMeasuredWidth() + r34, r30.getMeasuredHeight() + r37);
    L93:
        r26 = r29;
        r27 = r31;
        goto L56
    L82:
        ForsetiChainHelper r38 = this.l;
        if (r38 != null) goto L85;
    L87:
        boolean r39 = false;
    L88:
        if (r39 == false) goto L90;
        r30.layout(-r30.getMeasuredWidth(), r37, 0, r30.getMeasuredHeight() + r37);
        goto L93
    L90:
        if (r27 != 0) goto L92;
        r30.layout(-r30.getMeasuredWidth(), r37, 0, r30.getMeasuredHeight() + r37);
        goto L93
    L92:
        r30.layout(r110.getRight(), r37, r110.getRight() + r30.getMeasuredWidth(), r30.getMeasuredHeight() + r37);
        goto L93
    L85:
        if (r38.m != true) goto L87;
        r39 = true;
        goto L88
    L78:
        r37 = 0;
        goto L80
    L75:
        r36 = null;
        goto L76
    L71:
        r34 = 0;
        goto L72
    L68:
        r33 = null;
        goto L69
    L95:
        throw new IndexOutOfBoundsException();
    L148:
        return;
    L58:
        r28 = false;
        goto L59
    L96:
        int r40 = getChildCount();
        int r111 = 0;
        int r41 = 0;
    L97:
        if (r111 >= r40) goto L149;
        View r42 = getChildAt(r111);
        ViewGroup.LayoutParams r43 = r42.getLayoutParams();
        if ((r43 instanceof ViewGroup.MarginLayoutParams) == false) goto L101;
        ViewGroup.MarginLayoutParams r44 = (ViewGroup.MarginLayoutParams) r43;
    L102:
        if (r44 == null) goto L104;
        int r45 = r44.leftMargin;
    L105:
        r41 = r41 + r45;
        ViewGroup.LayoutParams r46 = r42.getLayoutParams();
        if ((r46 instanceof ViewGroup.MarginLayoutParams) == false) goto L108;
        ViewGroup.MarginLayoutParams r47 = (ViewGroup.MarginLayoutParams) r46;
    L109:
        if (r47 == null) goto L111;
        int r48 = r47.topMargin;
    L112:
        r42.layout(r41, r48, r42.getMeasuredWidth() + r41, r42.getMeasuredHeight() + r48);
        if (r111 != 0) goto L115;
    L124:
        boolean r49 = false;
    L125:
        if (r49 == true) goto L128;
        r41 = r41 + r42.getMeasuredWidth();
    L128:
        r111 = r111 + 1;
        goto L97
    L115:
        if (r111 == (getChildCount() - 1)) goto L124;
        ForsetiChainHelper r50 = this.l;
        if (r50 != null) goto L119;
    L121:
        boolean r51 = false;
    L122:
        if (r51 == false) goto L124;
        r49 = true;
        goto L125
    L119:
        if (r50.m != true) goto L121;
        r51 = true;
        goto L122
    L111:
        r48 = 0;
        goto L112
    L108:
        r47 = null;
        goto L109
    L104:
        r45 = 0;
        goto L105
    L101:
        r44 = null;
        goto L102
    L149:
        return;
    L40:
        r21 = false;
        goto L41
    }
}
