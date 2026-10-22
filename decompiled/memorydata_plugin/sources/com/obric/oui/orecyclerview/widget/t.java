package com.obric.oui.orecyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper;", "Lcom/obric/oui/orecyclerview/widget/ItemTouchHelper;", "adapter", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "callback", "Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback;", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback;)V", "callbackImpl", "Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$CallbackImpl;", "getCallbackImpl", "()Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$CallbackImpl;", "registerDragHandle", "", "viewHolder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "handle", "Landroid/view/View;", "setDragScale", "scale", "", "setLongPressDragEnabled", "enabled", "", "unregisterDragHandle", "Callback", "CallbackImpl", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class t extends l {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback;", "", "onCheckCanDrag", "", "viewHolder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onDragging", "", TypedValues.CycleType.S_WAVE_OFFSET, "onEndDrag", "onPositionChange", "fromPosition", "toPosition", "onStartDrag", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a(RecyclerView.v r1);

        boolean a(RecyclerView.v r1, int r2);

        void b(RecyclerView.v r1);

        void b(RecyclerView.v r1, int r2);
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001bH\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001bH\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0016\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\rH\u0002J\u0012\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u001bH\u0002J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J@\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\r2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u0016H\u0016J \u00104\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\r2\u0006\u00105\u001a\u00020\rH\u0016J\b\u00106\u001a\u00020\u0016H\u0016J\u001a\u00107\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u00102\u001a\u00020\u0011H\u0016J\u0018\u00108\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u00109\u001a\u00020\u0011H\u0016J\u000e\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u000fJ\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u0016J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\rH\u0002J\u0012\u0010?\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$CallbackImpl;", "Lcom/obric/oui/orecyclerview/widget/ItemTouchHelper$Callback;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "adapter", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "callback", "Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback;", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback;)V", "cachedRootLoc", "", "cachedRvLoc", "cachedViewLoc", "currentDragViewHolder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "dragScale", "", "dragStartY", "", "dropAnimators", "Ljava/util/WeakHashMap;", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "isLongPressDragEnabled", "", "lastTouchBottom", "Ljava/lang/Float;", "lastTouchTop", "mirrorViews", "Landroid/view/View;", "pickUpAnimators", "recoverRatios", "animateDrop", "", "viewHolder", "mirrorView", "animatePickUp", "clearView", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "createMirrorView", "dp2px", "dp", "findAdapterForViewHolder", "getCurrentCoordinate", "view", "getMovementFlags", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", TypedValues.AttributesType.S_TARGET, "onPreDraw", "onSelectedChanged", "onSwiped", "direction", "setDragScale", "scale", "setLongPressDragEnabled", "enabled", "startTrackingDragPosition", "stopTrackingDragPosition", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b extends l.a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RecyclerView.Adapter<?> f14233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f14234b;
        private int c;
        private RecyclerView.v d;
        private float e;
        private Float f;
        private Float g;
        private final int[] h;
        private final int[] i;
        private final int[] j;
        private final WeakHashMap<RecyclerView.v, Float> k;
        private final WeakHashMap<RecyclerView.v, com.obric.common.oea.foundation.animation.d.d> l;
        private final WeakHashMap<RecyclerView.v, com.obric.common.oea.foundation.animation.d.d> m;
        private final WeakHashMap<RecyclerView.v, View> n;

        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J0\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0014¨\u0006\u000e"}, d2 = {"com/obric/oui/orecyclerview/widget/ODragItemTouchHelper$CallbackImpl$createMirrorView$mirrorGroup$1", "Landroid/view/ViewGroup;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "", "t", "r", "b", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a extends ViewGroup {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f14235a;

            a(View r3, Context r4) {
                Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
                this.f14235a = r3;
                super(r5);
            }

            @Override // android.view.ViewGroup, android.view.View
            public void dispatchDraw(Canvas r2) {
                Intrinsics.checkNotNullParameter(r2, "canvas");
                this.f14235a.draw(r2);
            }

            @Override // android.view.ViewGroup, android.view.View
            public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            }
        }

        private final float a(int r1) {
            return r1 * Resources.getSystem().getDisplayMetrics().density;
        }

        public static final /* synthetic */ float a(b r0) {
            return r0.e;
        }

        private final void a(RecyclerView.v r18, final View r19) {
            View r3 = r18.c;
            Intrinsics.checkNotNullExpressionValue(r3, "viewHolder.itemView");
            r3.setScaleX(this.e);
            r3.setScaleY(this.e);
            r3.setVisibility(4);
            Float r13 = Float.valueOf(1.0f);
            r19.setAlpha(1.0f);
            r19.setScaleX(1.0f);
            r19.setScaleY(1.0f);
            ((Map) ZeusTransformUtils.preCheckCast(this.l, Map.class, "com.obric.memorydata.plugin")).put(r18, com.obric.common.oea.foundation.animation.builder.a.a(com.obric.common.oea.foundation.animation.builder.a.C0372a.a(com.obric.common.oea.foundation.animation.builder.a.C0372a.a(com.obric.common.oea.foundation.animation.builder.b.a(r19, 0.0f, 1, null), AnimationProperty.FloatProperty.SCALE_X, r13, this.e, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 16, null), AnimationProperty.FloatProperty.SCALE_Y, r13, this.e, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 16, null).a((Function2) ZeusTransformUtils.preCheckCast(new ODragItemTouchHelper$CallbackImpl$animatePickUp$1(r19, this), Function2.class, "com.obric.memorydata.plugin")).b(), null, null, 3, null));
        }

        private final int[] a(View r2) {
            if (r2 == null) goto L6;
            r2.getLocationOnScreen(this.j);
        L6:
            return this.j;
        }

        public static final /* synthetic */ WeakHashMap b(b r0) {
            return r0.n;
        }

        private final void b(RecyclerView.v r10) {
            View r0 = r10.c;
            Intrinsics.checkNotNullExpressionValue(r0, "viewHolder.itemView");
            a r3 = new a(r0, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            r3.setClipChildren(false);
            r3.setClipToPadding(false);
            ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.getRootView().findViewById(R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L8;
            View r5 = r0.getRootView();
            if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L7;
            r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
            goto L8
        L7:
            r4 = null;
        L8:
            if (r4 == null) goto L12;
            r4.setClipChildren(false);
            r4.setClipToPadding(false);
            r4.addView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), new ViewGroup.LayoutParams(r0.getWidth(), r0.getHeight()));
            int[] r6 = new int[2];
            r0.getLocationOnScreen(r6);
            int[] r1 = new int[2];
            r4.getLocationOnScreen(r1);
            r3.setX(r6[0] - r1[0]);
            r3.setY(r6[1] - r1[1]);
            ((Map) ZeusTransformUtils.preCheckCast(this.n, Map.class, "com.obric.memorydata.plugin")).put(r10, r3);
            return;
        }

        private final void b(final RecyclerView.v r27, final View r28) {
            final View r3 = r27.c;
            Intrinsics.checkNotNullExpressionValue(r3, "viewHolder.itemView");
            r3.setScaleX(this.e);
            r3.setScaleY(this.e);
            r3.setAlpha(1.0f);
            r3.setVisibility(0);
            r28.setAlpha(0.0f);
            r28.setScaleX(this.e);
            r28.setScaleY(this.e);
            ((Map) ZeusTransformUtils.preCheckCast(this.m, Map.class, "com.obric.memorydata.plugin")).put(r27, com.obric.common.oea.foundation.animation.builder.a.a(com.obric.common.oea.foundation.animation.builder.a.C0372a.a(com.obric.common.oea.foundation.animation.builder.a.C0372a.a(com.obric.common.oea.foundation.animation.builder.b.a(r3, 0.0f, 1, null), AnimationProperty.FloatProperty.SCALE_X, Float.valueOf(this.e), 1.0f, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 16, null), AnimationProperty.FloatProperty.SCALE_Y, Float.valueOf(this.e), 1.0f, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 16, null).a((Function2) ZeusTransformUtils.preCheckCast(new ODragItemTouchHelper$CallbackImpl$animateDrop$1(r3, r28, this, r27), Function2.class, "com.obric.memorydata.plugin")).b(), null, null, 3, null));
        }

        private final void c(RecyclerView.v r3) {
            this.d = r3;
            this.c = a(r3.c)[1];
            r3.c.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
        }

        private final void d(RecyclerView.v r3) {
            if (r3 == null) goto L11;
            View r4 = r3.c;
            if (r4 == null) goto L11;
            ViewTreeObserver r5 = r4.getViewTreeObserver();
            if (r5 == null) goto L11;
            r5.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
        L11:
            this.d = null;
        }

        private final RecyclerView.Adapter<?> e(RecyclerView.v r5) {
            if (ZeusTransformUtils.instanceOf(this.f14233a, ConcatAdapter.class) == false) goto L16;
            int r6 = r5.p();
            if (r6 == (-1)) goto L13;
            int r0 = 0;
            Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.v>> r4 = ((ConcatAdapter) ZeusTransformUtils.preCheckCast(this.f14233a, ConcatAdapter.class, "com.obric.memorydata.plugin")).a().iterator();
        L8:
            if (r4.hasNext() == false) goto L19;
            RecyclerView.Adapter<?> r1 = (RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r4.next(), RecyclerView.Adapter.class, "com.obric.memorydata.plugin");
            if (r6 < (r1.d() + r0)) goto L11;
            r0 = r0 + r1.d();
            goto L8
        L11:
            return r1;
        L19:
            return null;
        L13:
            return null;
        L16:
            return this.f14233a;
        }

        @Override // com.obric.oui.orecyclerview.widget.l.a
        public int a(RecyclerView r2, RecyclerView.v r3) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            Intrinsics.checkNotNullParameter(r3, "viewHolder");
            if (e(r3) != null) goto L7;
            return l.a.b(0, 0);
        L7:
            if (this.f14234b.a(r3, r3.p()) == false) goto L9;
            int r1 = 3;
        L11:
            return l.a.b(r1, 0);
        L9:
            r1 = 0;
            goto L11
        }

        @Override // com.obric.oui.orecyclerview.widget.l.a
        public void a(Canvas r17, RecyclerView r18, RecyclerView.v r19, float r20, float r21, int r22, boolean r23) {
            Intrinsics.checkNotNullParameter(r17, "c");
            Intrinsics.checkNotNullParameter(r18, "recyclerView");
            Intrinsics.checkNotNullParameter(r19, "viewHolder");
            if (r22 != 2) goto L41;
            float r1 = r19.c.getTop() + r21;
            float r5 = r19.c.getBottom() + r21;
            View r7 = null;
            if (r23 == false) goto L26;
            float r9 = a(40);
            float r10 = r18.getPaddingTop();
            float r11 = r18.getPaddingBottom();
            float r12 = r18.getHeight();
            if (r1 >= r10) goto L13;
            float r13 = r10 - r9;
            Float r14 = this.f;
            if (r14 != null) goto L11;
            float r15 = r10;
        L12:
            float r2 = com.obric.common.oea.style.scene.a.a.f7769a.a(r10, r13, r15, r1);
            float r16 = r2 - r19.c.getTop();
            this.f = Float.valueOf(r2);
        L14:
            float r110 = r12 - r11;
            if (r5 <= r110) goto L21;
            float r24 = r9 + r110;
            Float r3 = this.g;
            if (r3 != null) goto L19;
            float r4 = r110;
        L20:
            float r6 = com.obric.common.oea.style.scene.a.a.f7769a.a(r110, r24, r4, r5);
            r16 = r6 - r19.c.getBottom();
            this.g = Float.valueOf(r6);
        L23:
            if (Math.abs(r21) <= 0.001f) goto L25;
            ((Map) ZeusTransformUtils.preCheckCast(this.k, Map.class, "com.obric.memorydata.plugin")).put(r19, Float.valueOf(r16 / r21));
        L30:
            View r8 = (View) ZeusTransformUtils.preCheckCast(this.n.get(r19), View.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L40;
            r18.getLocationOnScreen(this.h);
            ViewParent r25 = r8.getParent();
            if (ZeusTransformUtils.instanceOf(r25, View.class) == false) goto L36;
            r7 = (View) ZeusTransformUtils.preCheckCast(r25, View.class, "com.obric.memorydata.plugin");
        L36:
            if (r7 == null) goto L39;
            r7.getLocationOnScreen(this.i);
        L39:
            float r26 = (this.h[0] + r19.c.getLeft()) + r20;
            float r27 = (this.h[1] + r19.c.getTop()) + r16;
            r8.setX(r26 - this.i[0]);
            r8.setY(r27 - this.i[1]);
        L40:
            float r28 = r16;
        L42:
            super.a(r17, r18, r19, r20, r28, r22, r23);
            return;
        L25:
            this.k.remove(r19);
            goto L30
        L19:
            r4 = r3.floatValue();
            goto L20
        L21:
            this.g = null;
            goto L23
        L11:
            r15 = r14.floatValue();
            goto L12
        L13:
            this.f = null;
            r16 = r21;
            goto L14
        L26:
            Float r29 = (Float) ZeusTransformUtils.preCheckCast(this.k.get(r19), Float.class, "com.obric.memorydata.plugin");
            if (r29 != null) goto L29;
            r29 = Float.valueOf(1.0f);
        L29:
            r16 = ((Number) ZeusTransformUtils.preCheckCast(r29, Number.class, "com.obric.memorydata.plugin")).floatValue() * r21;
            goto L30
        L41:
            r28 = r21;
            goto L42
        }

        @Override // com.obric.oui.orecyclerview.widget.l.a
        public void a(RecyclerView.v r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "viewHolder");
        }

        @Override // com.obric.oui.orecyclerview.widget.l.a
        public void b(RecyclerView.v r6, int r7) {
            super.b(r6, r7);
            if (r7 != 0) goto L5;
            d(this.d);
            return;
        L5:
            if (r7 != 2) goto L34;
            if (r6 == null) goto L35;
            com.obric.common.oea.foundation.animation.d.d r8 = (com.obric.common.oea.foundation.animation.d.d) ZeusTransformUtils.preCheckCast(this.l.get(r6), com.obric.common.oea.foundation.animation.d.d.class, "com.obric.memorydata.plugin");
            ViewGroup r3 = null;
            if (r8 == null) goto L13;
            com.obric.common.oea.foundation.animation.d.d.a(r8, false, 1, null);
        L13:
            com.obric.common.oea.foundation.animation.d.d r9 = (com.obric.common.oea.foundation.animation.d.d) ZeusTransformUtils.preCheckCast(this.m.get(r6), com.obric.common.oea.foundation.animation.d.d.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L17;
            com.obric.common.oea.foundation.animation.d.d.a(r9, false, 1, null);
        L17:
            View r10 = (View) ZeusTransformUtils.preCheckCast(this.n.get(r6), View.class, "com.obric.memorydata.plugin");
            if (r10 == null) goto L26;
            ViewParent r0 = r10.getParent();
            if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L23;
            r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin");
        L23:
            if (r3 == null) goto L26;
            r3.removeView(r10);
        L26:
            this.n.remove(r6);
            b(r6);
            View r11 = (View) ZeusTransformUtils.preCheckCast(this.n.get(r6), View.class, "com.obric.memorydata.plugin");
            if (r11 == null) goto L30;
            a(r6, r11);
        L30:
            c(r6);
            this.f14234b.a(r6);
            return;
        L35:
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.l.a
        public void c(RecyclerView r3, RecyclerView.v r4) {
            Intrinsics.checkNotNullParameter(r3, "recyclerView");
            Intrinsics.checkNotNullParameter(r4, "viewHolder");
            super.c(r3, r4);
            View r5 = (View) ZeusTransformUtils.preCheckCast(this.n.get(r4), View.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L5;
            b(r4, r5);
        L6:
            this.f14234b.b(r4);
            this.k.remove(r4);
            return;
        L5:
            r4.c.setVisibility(0);
            goto L6
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            RecyclerView.v r0 = this.d;
            if (r0 == null) goto L8;
            int r2 = a(r0.c)[1];
            int r3 = Math.abs(r2 - this.c);
            a r4 = this.f14234b;
            if (r2 != 0) goto L7;
            r4.b(r0, 0);
            goto L8
        L7:
            r4.b(r0, r3);
        L8:
            return true;
        }
    }
}
