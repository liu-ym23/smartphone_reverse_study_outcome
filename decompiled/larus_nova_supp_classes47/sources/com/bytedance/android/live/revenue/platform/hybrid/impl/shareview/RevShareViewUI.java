package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewLoadError;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.b1;
import com.lynx.tasm.behavior.ui.UIGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\n\u000b\fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/hybrid/impl/shareview/RevShareViewUI;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Landroid/view/ViewGroup;", "", "id", "", "setShareId", "Lf6a/a;", "loadState", "setLoadState", "a", "b", "c", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevShareViewUI extends UIGroup<ViewGroup> {
    public static final /* synthetic */ int h = 0;
    public final Lazy a;
    public final Lazy b;
    public final b1 c;
    public c d;
    public String e;
    public boolean f;
    public ReadableMap g;

    public static final class a {
    }

    public static final class b extends com.lynx.tasm.behavior.ui.view.a {
        public final c a;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void removeViewAt(int r2) {
            this.a.removeViewAt(r2);
        }

        public b(Context r2, RevShareViewUI r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "shareUI");
            super(r2);
            c r4 = r3.d;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("container");
        L5:
            this.a = r4;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void addView(View r3, int r4, ViewGroup.LayoutParams r5) {
            Intrinsics.checkNotNullParameter(r3, "child");
            Intrinsics.checkNotNullParameter(r5, "params");
            if (this.a.getChildCount() == 1) goto L7;
            this.a.addView(r3, r4, new ViewGroup.LayoutParams(-1, -1));
            return;
        L7:
            throw new Error("rev-share-view can only has one child");
        }
    }

    public static final class c extends com.lynx.tasm.behavior.ui.view.a {
        public final Point a;
        public boolean b;
        public final RevShareViewUI c;

        /* JADX WARN: Multi-variable type inference failed */
        public final void requestLayout() {
            super/*android.view.ViewGroup*/.requestLayout();
            RevShareViewUI r0 = this.c;
            if (r0 != null) goto L6;
            return;
        L6:
            if (((ViewGroup) r0.getView()).isLayoutRequested() == true) goto L9;
            this.c.requestLayout();
            return;
        }

        public c(RevShareViewUI r2) {
            Intrinsics.checkNotNullParameter(r2, "shareUI");
            super(r2.getLynxContext());
            this.c = r2;
            this.a = new Point(0, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void dispatchDraw(Canvas r4) {
            Intrinsics.checkNotNullParameter(r4, "canvas");
            super.dispatchDraw(r4);
            if (getChildCount() > 0) goto L5;
            return;
        L5:
            if (this.b == true) goto L9;
            com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r5 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c) this.c.b.getValue();
            Intrinsics.checkNotNull(r5);
            r5.a("share-view-first-draw-end", MapsKt.mapOf(new Pair[]{TuplesKt.to("id", this.c.e), TuplesKt.to("draw_end", Long.valueOf(System.currentTimeMillis()))}));
            this.b = true;
            return;
        }

        public final boolean dispatchTouchEvent(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "ev");
            RevShareViewUI r0 = this.c;
            boolean r1 = r0.c.x(r3, r0);
            if (r1 == true) goto L5;
        L7:
            return r1;
        L5:
            if (this.c.c.e(r3) == true) goto L7;
            super.dispatchTouchEvent(r3);
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onMeasure(int r7, int r8) {
            this.c.measure();
            boolean r1 = false;
            List r9 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(r7), Integer.valueOf(r8)});
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
            Iterator r10 = r9.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            int r3 = ((Number) r10.next()).intValue();
            r0.add(TuplesKt.to(Integer.valueOf(View.MeasureSpec.getMode(r3)), Integer.valueOf(View.MeasureSpec.getSize(r3))));
            goto L4
        L6:
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator r2 = r0.iterator();
        L7:
            int r4 = -1;
            if (r2.hasNext() == false) goto L19;
            Pair r5 = (Pair) r2.next();
            int r6 = ((Number) r5.component1()).intValue();
            int r13 = ((Number) r5.component2()).intValue();
            if (r6 == Integer.MIN_VALUE) goto L17;
            if (r6 == 0) goto L18;
            if (r6 == 1073741824) goto L17;
            throw new Error("unknown measure mode " + r6);
        L18:
            r12.add(Integer.valueOf(r4));
        L17:
            r4 = r13;
            goto L18
        L19:
            int r14 = ((Number) ListProtector.get(r12, 0)).intValue();
            int r15 = ((Number) ListProtector.get(r12, 1)).intValue();
            if (r14 != (-1)) goto L22;
            if (r15 != (-1)) goto L22;
        L34:
            if (r14 != (-1)) goto L37;
            r14 = this.c.getWidth();
        L37:
            if (r15 != (-1)) goto L40;
            r15 = this.c.getHeight();
        L40:
            setMeasuredDimension(r14, r15);
            return;
        L22:
            Point r16 = this.a;
            if (r16.x == r14) goto L25;
        L26:
            RevShareViewUI r17 = this.c;
            int r18 = RevShareViewUI.h;
            Map r19 = r17.getEvents();
            if (r19 != null) goto L29;
        L31:
            jy0.b.a("ShareView", "onNativeSizeChanged failed");
        L32:
            if (r1 == false) goto L34;
            Point r20 = this.a;
            r20.x = r14;
            r20.y = r15;
            goto L34
        L29:
            if (r19.containsKey("nativesizechange") != true) goto L31;
            com.lynx.tasm.event.a r22 = new com.lynx.tasm.event.a(r17.getSign(), "nativesizechange");
            r22.a("width", Integer.valueOf(r14));
            r22.a("height", Integer.valueOf(r15));
            r22.a("now", Long.valueOf(System.currentTimeMillis()));
            r17.getLynxContext().getEventEmitter().sendCustomEvent(r22);
            r1 = true;
            goto L32
        L25:
            if (r16.y == r15) goto L34;
            goto L26
        }

        public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            this.c.layout();
        }
    }

    static {
    }

    public final void destroy() {
        super.destroy();
        release();
    }

    public final void onNodeReload() {
        throw new Error("RevShareViewUI should not be reuse");
    }

    public final void release() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        String r0 = this.e;
        if (r0 == null) goto L11;
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a r1 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a) this.a.getValue();
        com.lynx.tasm.behavior.ui.view.a r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L10:
        r1.Y3(r0, r2);
    L11:
        this.g = null;
    }

    public final void onNodeRemoved() {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.onNodeRemoved();
        release();
    }

    public RevShareViewUI(final LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxContext");
        super(r2);
        this.a = LazyKt.lazy(RevShareViewUI$shareService$2.INSTANCE);
        this.b = LazyKt.lazy(new RevShareViewUI$sharer$2(this, r2));
        this.c = new b1(r2.getLynxUIOwner());
    }

    public final void M(ReadableMap r6) {
        String r0 = r6.getString("state", "");
        int r1 = r6.getInt(Constants.OperatorKey.CODE, 0);
        String r7 = r6.getString("message", "unknown error");
        int r2 = r0.hashCode();
        if (r2 == (-1281977283)) goto L14;
        if (r2 == (-1097519099)) goto L8;
        return;
    L8:
        if (r0.equals("loaded") == false) goto L17;
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a r8 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a) this.a.getValue();
        String r3 = this.e;
        Intrinsics.checkNotNull(r3);
        Result.Companion r4 = Result.Companion;
        c r5 = this.d;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L12:
        r8.li(r3, Result.constructor-impl(r5));
        return;
    L17:
        return;
    L14:
        if (r0.equals("failed") == false) goto L19;
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a r9 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a) this.a.getValue();
        String r10 = this.e;
        Intrinsics.checkNotNull(r10);
        Result.Companion r12 = Result.Companion;
        LoadFailCode.Companion.getClass();
        Object r13 = LoadFailCode.access$getMap$cp().get(Integer.valueOf(r1));
        Intrinsics.checkNotNull(r13);
        r9.li(r10, Result.constructor-impl(ResultKt.createFailure(new ShareViewLoadError((LoadFailCode) r13, r7))));
        return;
    }

    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.d = new c(this);
        return new b(r2, this);
    }

    @LynxProp(name = "load-state")
    public final void setLoadState(f6a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "loadState");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(r2.asMap());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        ReadableMap r4 = (ReadableMap) r3;
        if (r4 != null) goto L14;
        return;
    L14:
        if (this.e != null) goto L17;
        this.g = r4;
        return;
    L17:
        M(r4);
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @LynxProp(name = "share-id")
    public final void setShareId(String r2) {
        String r0 = this.e;
        if (r0 != null) goto L5;
        if (r2 != null) goto L11;
        return;
    L11:
        this.e = r2;
        ReadableMap r3 = this.g;
        if (r3 == null) goto L15;
        M(r3);
        this.g = null;
        return;
    L15:
        return;
    L5:
        if ((!Intrinsics.areEqual(r2, r0)) == true) goto L8;
        return;
    L8:
        throw new Error("share-id cannot be changed");
    }
}
