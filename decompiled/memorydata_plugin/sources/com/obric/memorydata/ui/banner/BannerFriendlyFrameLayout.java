package com.obric.memorydata.ui.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.bouncelayout.h;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0002R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/ui/banner/BannerFriendlyFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bannerTouchChildren", "Ljava/util/LinkedHashSet;", "Landroid/view/View;", "Lkotlin/collections/LinkedHashSet;", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "addBannerTouchChild", "", "child", "removeBannerTouchChild", "findTouchedBannerChild", "isTouchInView", "view", "getAncestorBounceTranslationY", "", "stopAncestorScrollAnimations", "stopScrollAnimation", "abortOverScroller", "finishEdgeEffects", "finishEdgeEffectField", "fieldName", "", "getFieldValue", "", TypedValues.AttributesType.S_TARGET, "findField", "Ljava/lang/reflect/Field;", "Companion", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BannerFriendlyFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12986a = null;
    private static final List<String> c = null;
    private static final Set<String> d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashSet<View> f12987b;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/ui/banner/BannerFriendlyFrameLayout$Companion;", "", "<init>", "()V", "EDGE_EFFECT_FIELD_NAMES", "", "", "O_RECYCLER_VIEW_EDGE_EFFECT_FIELD_NAMES", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12986a = new a(null);
        c = CollectionsKt.listOf(new String[]{"mEdgeGlowTop", "mEdgeGlowBottom", "mTopGlow", "mBottomGlow", "mLeftGlow", "mRightGlow", "mHorizontalEdgeEffect", "mVerticalEdgeEffect"});
        d = SetsKt.setOf(new String[]{"mHorizontalEdgeEffect", "mVerticalEdgeEffect"});
    }

    public BannerFriendlyFrameLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public BannerFriendlyFrameLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public BannerFriendlyFrameLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f12987b = new LinkedHashSet();
    }

    public /* synthetic */ BannerFriendlyFrameLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final View a(MotionEvent r6) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.f12987b, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Object r1 = r0.next();
        View r3 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
        if (r3.isAttachedToWindow() == true) goto L8;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L4;
    L17:
        return (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
    L8:
        if (r3.getVisibility() != 0) goto L12;
        if (a(r3, r6) == false) goto L12;
        r4 = true;
        goto L13
    L15:
        r1 = null;
        goto L17
    }

    private final Object a(Object r4, String r5) {
        Field r6 = b(r4, r5);
        if (r6 != null) goto L14;
        return null;
    L14:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        BannerFriendlyFrameLayout r3 = (BannerFriendlyFrameLayout) ZeusTransformUtils.preCheckCast(this, BannerFriendlyFrameLayout.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        r6.setAccessible(true);     // Catch: Throwable -> L7
        Object r7 = Result.m1421constructorimpl(r6.get(r4));     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r7) == false) goto L13;
        return null;
    L13:
        return r7;
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void a(View r7, String r8) {
        Field r2 = b(r7, r8);
        if (r2 != null) goto L24;
        return;
    L24:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        BannerFriendlyFrameLayout r4 = (BannerFriendlyFrameLayout) ZeusTransformUtils.preCheckCast(this, BannerFriendlyFrameLayout.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        r2.setAccessible(true);     // Catch: Throwable -> L7
        Object r5 = Result.m1421constructorimpl(r2.get(r7));     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r5) == false) goto L12;
        r5 = null;
    L12:
        if (r5 != null) goto L15;
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r5, EdgeEffect.class) == false) goto L18;
        ((EdgeEffect) ZeusTransformUtils.preCheckCast(r5, EdgeEffect.class, "com.obric.memorydata.plugin")).finish();
        return;
    L18:
        if (d.contains(r8) == false) goto L29;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L21
        BannerFriendlyFrameLayout r6 = (BannerFriendlyFrameLayout) ZeusTransformUtils.preCheckCast(this, BannerFriendlyFrameLayout.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r2.set(r7, null);     // Catch: Throwable -> L21
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L29:
        return;
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final boolean a(View r7, MotionEvent r8) {
        int[] r0 = new int[2];
        r7.getLocationOnScreen(r0);
        float r6 = c(r7);
        if (r8.getRawX() >= r0[0]) goto L5;
        return false;
    L5:
        if (r8.getRawX() <= (r0[0] + r7.getWidth())) goto L7;
        return false;
    L7:
        if (r8.getRawY() >= (r0[1] + r6)) goto L9;
        return false;
    L9:
        if (r8.getRawY() <= ((r0[1] + r6) + r7.getHeight())) goto L11;
        return false;
    L11:
        return true;
    }

    private final Field b(Object r5, String r6) {
        Class<?> r7 = r5.getClass();
    L3:
        Object r1 = null;
        if (r7 == null) goto L17;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        BannerFriendlyFrameLayout r3 = (BannerFriendlyFrameLayout) ZeusTransformUtils.preCheckCast(this, BannerFriendlyFrameLayout.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Object r4 = Result.m1421constructorimpl(r7.getDeclaredField(r6));     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r4) == true) goto L13;
        r1 = r4;
    L13:
        Field r8 = (Field) ZeusTransformUtils.preCheckCast(r1, Field.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L15;
        r7 = r7.getSuperclass();
        goto L3
    L15:
        return r8;
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L17:
        return null;
    }

    private final float c(View r4) {
        ViewParent r3 = r4.getParent();
        float r0 = 0.0f;
    L4:
        if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L9;
        float r1 = ((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin")).getBounceTranslation();
    L12:
        r0 = r0 + r1;
        r3 = ((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).getParent();
        goto L4
    L9:
        if (ZeusTransformUtils.instanceOf(r3, RecyclerView.class) == false) goto L11;
        r1 = ((RecyclerView) ZeusTransformUtils.preCheckCast(r3, RecyclerView.class, "com.obric.memorydata.plugin")).getBounceTranslation();
        goto L12
    L11:
        r1 = 0.0f;
        goto L12
    L13:
        return r0;
    }

    private final void d(View r3) {
    L2:
        ViewParent r4 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r4, View.class) == false) goto L5;
        e((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
        r3 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        goto L2
    }

    private final void e(View r3) {
        if (ZeusTransformUtils.instanceOf(r3, RecyclerView.class) == false) goto L5;
        ((RecyclerView) ZeusTransformUtils.preCheckCast(r3, RecyclerView.class, "com.obric.memorydata.plugin")).stopScroll();
    L5:
        f(r3);
        g(r3);
        r3.invalidate();
    }

    private final void f(View r2) {
        Object r1 = a(r2, "mScroller");
        if (ZeusTransformUtils.instanceOf(r1, OverScroller.class) == false) goto L5;
        OverScroller r3 = (OverScroller) ZeusTransformUtils.preCheckCast(r1, OverScroller.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.isFinished() == true) goto L12;
        r3.abortAnimation();
        return;
    L12:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final void g(View r5) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a(r5, (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        this.f12987b.add(r2);
    }

    public final void b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        this.f12987b.remove(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (r2.getActionMasked() != 0) goto L8;
        View r0 = a(r2);
        if (r0 == null) goto L8;
        d(r0);
    L8:
        return super.dispatchTouchEvent(r2);
    }
}
