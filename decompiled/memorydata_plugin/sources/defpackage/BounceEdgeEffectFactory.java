package defpackage;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.crash.entity.EventBody;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u001c\u0018\u00002\u00020\u0001:\u0002 !B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0003H\u0014J\r\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"LBounceEdgeEffectFactory;", "Landroidx/recyclerview/widget/RecyclerView$EdgeEffectFactory;", "maxOverscrollDistanceVerticalPx", "", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "<init>", "(ILandroidx/viewpager2/widget/ViewPager2;)V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "viewPager2Ref", "touchHelper", "LBounceEdgeEffectFactory$TouchHelper;", "scrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", EventBody.KEY_VALUE, "", "allowViewPager2Fling", "getAllowViewPager2Fling", "()Z", "setAllowViewPager2Fling", "(Z)V", "createEdgeEffect", "Landroid/widget/EdgeEffect;", "recyclerView", "direction", "createScrollListener", "BounceEdgeEffectFactory$createScrollListener$1", "()LBounceEdgeEffectFactory$createScrollListener$1;", "release", "", "TouchHelper", "BounceEdgeEffect", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BounceEdgeEffectFactory extends RecyclerView.EdgeEffectFactory {
    private boolean allowViewPager2Fling;
    private final int maxOverscrollDistanceVerticalPx;
    private WeakReference<RecyclerView> recyclerViewRef;
    private RecyclerView.OnScrollListener scrollListener;
    private TouchHelper touchHelper;
    private final ViewPager2 viewPager2;
    private final WeakReference<ViewPager2> viewPager2Ref;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0006\u0010 \u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0014\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"LBounceEdgeEffectFactory$TouchHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "maxDistance", "", "viewPager2Ref", "Landroidx/viewpager2/widget/ViewPager2;", "getAllowViewPager2Fling", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/ref/WeakReference;ILjava/lang/ref/WeakReference;Lkotlin/jvm/functions/Function0;)V", "lastY", "", "isIntercepting", "activePointerId", EventBody.KEY_VALUE, "isOverscrollActive", "()Z", "isPulling", "setPulling", "(Z)V", "onInterceptTouchEvent", "rv", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "", "setOverscrollActive", "active", "springBack", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class TouchHelper implements RecyclerView.OnItemTouchListener {
        private int activePointerId;
        private final Function0<Boolean> getAllowViewPager2Fling;
        private boolean isIntercepting;
        private boolean isOverscrollActive;
        private boolean isPulling;
        private float lastY;
        private final int maxDistance;
        private final WeakReference<RecyclerView> recyclerViewRef;
        private final WeakReference<ViewPager2> viewPager2Ref;

        public TouchHelper(WeakReference<RecyclerView> r3, int r4, WeakReference<ViewPager2> r5, Function0<Boolean> r6) {
            Function0<Boolean> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "recyclerViewRef");
            Intrinsics.checkNotNullParameter(r7, "getAllowViewPager2Fling");
            this.recyclerViewRef = r3;
            this.maxDistance = r4;
            this.viewPager2Ref = r5;
            this.getAllowViewPager2Fling = r7;
            this.activePointerId = -1;
        }

        public static /* synthetic */ void lambda$Of5YxpeFZGdVEkI69P2LUGURGcg(TouchHelper r0) {
            springBack$lambda$1(r0);
        }

        private final void setOverscrollActive(boolean r4) {
            if (this.isOverscrollActive != r4) goto L5;
            return;
        L5:
            this.isOverscrollActive = r4;
            WeakReference<ViewPager2> r0 = this.viewPager2Ref;
            if (r0 == null) goto L14;
            ViewPager2 r1 = (ViewPager2) ZeusTransformUtils.preCheckCast(r0.get(), ViewPager2.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L15;
            if (r4 == false) goto L11;
            boolean r3 = false;
        L12:
            r1.setUserInputEnabled(r3);
            return;
        L11:
            r3 = ((Boolean) ZeusTransformUtils.preCheckCast(this.getAllowViewPager2Fling.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            goto L12
        L15:
            return;
        }

        private static final void springBack$lambda$1(TouchHelper r1) {
            r1.setOverscrollActive(false);
        }

        public final boolean isOverscrollActive() {
            return this.isOverscrollActive;
        }

        public final boolean isPulling() {
            return this.isPulling;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView r6, MotionEvent r7) {
            Intrinsics.checkNotNullParameter(r6, "rv");
            Intrinsics.checkNotNullParameter(r7, "e");
            int r0 = r7.getActionMasked();
            if (r0 == 0) goto L20;
            if (r0 != 1) goto L6;
        L19:
            this.isIntercepting = false;
            this.isPulling = false;
        L27:
            return false;
        L6:
            if (r0 == 2) goto L11;
            if (r0 == 3) goto L19;
        L11:
            if (r6.getTranslationY() != 0.0f) goto L13;
            boolean r8 = true;
        L14:
            if (r8 == true) goto L27;
            if (this.isIntercepting == true) goto L27;
            this.isIntercepting = true;
            setOverscrollActive(true);
            this.lastY = r7.getY();
            return true;
        L13:
            r8 = false;
            goto L14
        L20:
            this.activePointerId = r7.getPointerId(0);
            this.lastY = r7.getY();
            this.isIntercepting = false;
            if (r6.getTranslationY() != 0.0f) goto L23;
            boolean r9 = true;
        L24:
            if (r9 == true) goto L27;
            r6.animate().cancel();
            this.isIntercepting = true;
            setOverscrollActive(true);
            return true;
        L23:
            r9 = false;
            goto L24
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean r1) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView r8, MotionEvent r9) {
            Intrinsics.checkNotNullParameter(r8, "rv");
            Intrinsics.checkNotNullParameter(r9, "e");
            int r0 = r9.getActionMasked();
            int r1 = 1;
            if (r0 != 1) goto L5;
        L45:
            this.isIntercepting = false;
            this.isPulling = false;
            springBack();
            return;
        L5:
            if (r0 != 2) goto L7;
            int r2 = r9.findPointerIndex(this.activePointerId);
            if (r2 >= 0) goto L22;
            return;
        L22:
            float r10 = r9.getY(r2);
            float r3 = r10 - this.lastY;
            this.lastY = r10;
            float r11 = r8.getTranslationY();
            if (r11 <= 0.0f) goto L35;
            if (r3 >= 0.0f) goto L32;
            float r12 = RangesKt.coerceAtLeast(r11 + r3, 0.0f);
            r8.setTranslationY(r12);
            if (r12 == 0.0f) goto L30;
            r1 = 0;
        L30:
            if (r1 == 0) goto L50;
        L31:
            this.isIntercepting = false;
            this.isPulling = false;
            setOverscrollActive(false);
            return;
        L50:
            return;
        L32:
            float r7 = RangesKt.coerceAtMost(r11 + (r3 * (1.0f - RangesKt.coerceIn(r11 / this.maxDistance, 0.0f, 0.85f))), this.maxDistance);
        L33:
            r8.setTranslationY(r7);
            return;
        L35:
            if (r11 < 0.0f) goto L37;
            return;
        L37:
            if (r3 <= 0.0f) goto L44;
            float r13 = RangesKt.coerceAtMost(r11 + r3, 0.0f);
            r8.setTranslationY(r13);
            if (r13 == 0.0f) goto L42;
            r1 = 0;
        L42:
            if (r1 != 0) goto L31;
            return;
        L44:
            r7 = RangesKt.coerceAtLeast(r11 + (r3 * (1.0f - RangesKt.coerceIn(Math.abs(r11) / this.maxDistance, 0.0f, 0.85f))), -this.maxDistance);
            goto L33
        L7:
            if (r0 == 3) goto L45;
            if (r0 != 6) goto L55;
            int r14 = r9.getActionIndex();
            if (r9.getPointerId(r14) != this.activePointerId) goto L47;
            if (r14 == 0) goto L17;
            r1 = 0;
        L17:
            if (r1 >= r9.getPointerCount()) goto L48;
            this.activePointerId = r9.getPointerId(r1);
            this.lastY = r9.getY(r1);
            return;
        L48:
            return;
        L47:
            return;
        }

        public final void setPulling(boolean r1) {
            this.isPulling = r1;
        }

        public final void springBack() {
            RecyclerView r0 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.recyclerViewRef.get(), RecyclerView.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.getTranslationY() != 0.0f) goto L8;
            boolean r1 = true;
        L9:
            if (r1 == true) goto L11;
            r0.animate().translationY(0.0f).setDuration(400).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new OvershootInterpolator(0.8f), TimeInterpolator.class, "com.obric.memorydata.plugin")).withEndAction(new $$Lambda$BounceEdgeEffectFactory$TouchHelper$Of5YxpeFZGdVEkI69P2LUGURGcg(this)).start();
            return;
        L11:
            setOverscrollActive(false);
            return;
        L8:
            r1 = false;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"LBounceEdgeEffectFactory$BounceEdgeEffect;", "Landroid/widget/EdgeEffect;", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "direction", "", "maxDistance", "touchHelper", "LBounceEdgeEffectFactory$TouchHelper;", "<init>", "(Ljava/lang/ref/WeakReference;IILBounceEdgeEffectFactory$TouchHelper;)V", "onPull", "", "deltaDistance", "", "displacement", "handlePull", "onRelease", "onAbsorb", "velocity", "draw", "", "canvas", "Landroid/graphics/Canvas;", "isFinished", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a extends EdgeEffect {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<RecyclerView> f5a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6b;
        private final int c;
        private final TouchHelper d;

        public a(WeakReference<RecyclerView> r4, int r5, int r6, TouchHelper r7) {
            Intrinsics.checkNotNullParameter(r4, "recyclerViewRef");
            Intrinsics.checkNotNullParameter(r7, "touchHelper");
            RecyclerView r0 = r4.get();
            Intrinsics.checkNotNull(r0);
            super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((RecyclerView) ZeusTransformUtils.preCheckCast(r0, RecyclerView.class, "com.obric.memorydata.plugin")).getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            this.f5a = r4;
            this.f6b = r5;
            this.c = r6;
            this.d = r7;
        }

        private final void a(float r10) {
            RecyclerView r0 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f5a.get(), RecyclerView.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            this.d.setPulling(true);
            r0.animate().cancel();
            if (this.f6b != 3) goto L8;
            int r1 = -1;
        L9:
            float r4 = r0.getTranslationY();
            float r5 = r4 + (((r1 * r0.getHeight()) * r10) * (1.0f - RangesKt.coerceIn(Math.abs(r4) / this.c, 0.0f, 0.85f)));
            int r11 = this.f6b;
            if (r11 == 1) goto L14;
            if (r11 != 3) goto L15;
            r5 = RangesKt.coerceIn(r5, -this.c, 0.0f);
        L15:
            r0.setTranslationY(r5);
            return;
        L14:
            r5 = RangesKt.coerceIn(r5, 0.0f, this.c);
            goto L15
        L8:
            r1 = 1;
            goto L9
        }

        private static final void a(a r0) {
            r0.d.springBack();
        }

        public static /* synthetic */ void lambda$priL7nt2_Xudx_ZKzyfD_cRDse0(a r0) {
            a(r0);
        }

        @Override // android.widget.EdgeEffect
        public boolean draw(Canvas r1) {
            return false;
        }

        @Override // android.widget.EdgeEffect
        public boolean isFinished() {
            RecyclerView r2 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f5a.get(), RecyclerView.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L5;
            Float r3 = Float.valueOf(r2.getTranslationY());
        L7:
            return Intrinsics.areEqual(r3, 0.0f);
        L5:
            r3 = null;
            goto L7
        }

        @Override // android.widget.EdgeEffect
        public void onAbsorb(int r5) {
            RecyclerView r0 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f5a.get(), RecyclerView.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            return;
        L6:
            if (this.f6b != 3) goto L8;
            int r1 = -1;
        L9:
            float r6 = (r1 * RangesKt.coerceAtMost(Math.abs(r5), 10000)) * 0.03f;
            int r2 = this.c;
            float r7 = RangesKt.coerceIn(r6, -r2, r2);
            r0.animate().cancel();
            r0.animate().translationY(r7).setDuration(180).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin")).withEndAction(new $$Lambda$BounceEdgeEffectFactory$a$priL7nt2_Xudx_ZKzyfD_cRDse0(this)).start();
            return;
        L8:
            r1 = 1;
            goto L9
        }

        @Override // android.widget.EdgeEffect
        public void onPull(float r1) {
            a(r1);
        }

        @Override // android.widget.EdgeEffect
        public void onPull(float r1, float r2) {
            a(r1);
        }

        @Override // android.widget.EdgeEffect
        public void onRelease() {
            RecyclerView r0 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f5a.get(), RecyclerView.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.getTranslationY() != 0.0f) goto L8;
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            return;
        L11:
            if (this.d.isPulling() == true) goto L15;
            this.d.springBack();
            return;
        L15:
            return;
        L8:
            r1 = false;
            goto L9
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BounceEdgeEffectFactory() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public BounceEdgeEffectFactory(int r1, ViewPager2 r2) {
        this.maxOverscrollDistanceVerticalPx = r1;
        this.viewPager2 = r2;
        if (r2 == null) goto L5;
        WeakReference<ViewPager2> r3 = new WeakReference(r2);
    L6:
        this.viewPager2Ref = r3;
        this.allowViewPager2Fling = true;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public /* synthetic */ BounceEdgeEffectFactory(int r1, ViewPager2 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = BDVideoUploaderBase.KeyIsDynamicSliceHighSize;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }

    public static final /* synthetic */ TouchHelper access$getTouchHelper$p(BounceEdgeEffectFactory r0) {
        return r0.touchHelper;
    }

    public static final /* synthetic */ WeakReference access$getViewPager2Ref$p(BounceEdgeEffectFactory r0) {
        return r0.viewPager2Ref;
    }

    private static final boolean createEdgeEffect$lambda$4(BounceEdgeEffectFactory r0) {
        return r0.allowViewPager2Fling;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [BounceEdgeEffectFactory$createScrollListener$1] */
    private final AnonymousClass1 createScrollListener() {
        return new AnonymousClass1(this);
    }

    /* JADX INFO: renamed from: lambda$5uWaxqyekkr9bI-pTmDpYRQC3pE, reason: not valid java name */
    public static /* synthetic */ boolean m0lambda$5uWaxqyekkr9bIpTmDpYRQC3pE(BounceEdgeEffectFactory r0) {
        return createEdgeEffect$lambda$4(r0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
    public EdgeEffect createEdgeEffect(RecyclerView r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "recyclerView");
        WeakReference<RecyclerView> r0 = this.recyclerViewRef;
        if (r0 == null) goto L5;
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r0.get(), RecyclerView.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == r7) goto L15;
        if (r1 == null) goto L14;
        TouchHelper r2 = this.touchHelper;
        if (r2 == null) goto L11;
        r1.removeOnItemTouchListener((RecyclerView.OnItemTouchListener) ZeusTransformUtils.preCheckCast(r2, RecyclerView.OnItemTouchListener.class, "com.obric.memorydata.plugin"));
    L11:
        RecyclerView.OnScrollListener r3 = this.scrollListener;
        if (r3 == null) goto L14;
        r1.removeOnScrollListener(r3);
    L14:
        this.recyclerViewRef = new WeakReference(r7);
        WeakReference<RecyclerView> r4 = this.recyclerViewRef;
        Intrinsics.checkNotNull(r4);
        TouchHelper r5 = new TouchHelper(r4, this.maxOverscrollDistanceVerticalPx, this.viewPager2Ref, new $$Lambda$BounceEdgeEffectFactory$5uWaxqyekkr9bIpTmDpYRQC3pE(this));
        this.touchHelper = r5;
        Intrinsics.checkNotNull(r5);
        r7.addOnItemTouchListener((RecyclerView.OnItemTouchListener) ZeusTransformUtils.preCheckCast(r5, RecyclerView.OnItemTouchListener.class, "com.obric.memorydata.plugin"));
        RecyclerView.OnScrollListener r6 = (RecyclerView.OnScrollListener) ZeusTransformUtils.preCheckCast(createScrollListener(), RecyclerView.OnScrollListener.class, "com.obric.memorydata.plugin");
        this.scrollListener = r6;
        Intrinsics.checkNotNull(r6);
        r7.addOnScrollListener(r6);
    L15:
        WeakReference<RecyclerView> r9 = this.recyclerViewRef;
        Intrinsics.checkNotNull(r9);
        int r10 = this.maxOverscrollDistanceVerticalPx;
        TouchHelper r11 = this.touchHelper;
        Intrinsics.checkNotNull(r11);
        return (EdgeEffect) ZeusTransformUtils.preCheckCast(new a(r9, r8, r10, r11), EdgeEffect.class, "com.obric.memorydata.plugin");
    L5:
        r1 = null;
        goto L6
    }

    public final boolean getAllowViewPager2Fling() {
        return this.allowViewPager2Fling;
    }

    public final void release() {
        WeakReference<RecyclerView> r0 = this.recyclerViewRef;
        if (r0 == null) goto L12;
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r0.get(), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L12;
        TouchHelper r2 = this.touchHelper;
        if (r2 == null) goto L9;
        r1.removeOnItemTouchListener((RecyclerView.OnItemTouchListener) ZeusTransformUtils.preCheckCast(r2, RecyclerView.OnItemTouchListener.class, "com.obric.memorydata.plugin"));
    L9:
        RecyclerView.OnScrollListener r3 = this.scrollListener;
        if (r3 == null) goto L12;
        r1.removeOnScrollListener(r3);
    L12:
        WeakReference<RecyclerView> r4 = this.recyclerViewRef;
        if (r4 == null) goto L19;
        RecyclerView r5 = (RecyclerView) ZeusTransformUtils.preCheckCast(r4.get(), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L19;
        ViewPropertyAnimator r6 = r5.animate();
        if (r6 == null) goto L19;
        r6.cancel();
    L19:
        WeakReference<RecyclerView> r7 = this.recyclerViewRef;
        if (r7 == null) goto L22;
        r7.clear();
    L22:
        WeakReference<ViewPager2> r8 = this.viewPager2Ref;
        if (r8 == null) goto L25;
        r8.clear();
    L25:
        this.recyclerViewRef = null;
        this.touchHelper = null;
        this.scrollListener = null;
        ViewPager2 r9 = this.viewPager2;
        if (r9 == null) goto L29;
        r9.setUserInputEnabled(true);
        return;
    }

    public final void setAllowViewPager2Fling(boolean r3) {
        this.allowViewPager2Fling = r3;
        TouchHelper r0 = this.touchHelper;
        if (r0 == null) goto L5;
        boolean r1 = r0.isOverscrollActive();
    L6:
        if (r1 == true) goto L13;
        WeakReference<ViewPager2> r2 = this.viewPager2Ref;
        if (r2 == null) goto L14;
        ViewPager2 r4 = (ViewPager2) ZeusTransformUtils.preCheckCast(r2.get(), ViewPager2.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L15;
        r4.setUserInputEnabled(r3);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
