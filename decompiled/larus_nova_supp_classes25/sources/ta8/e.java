package ta8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import cb8.v1;
import cb8.w1;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc8.h;
import jc8.l;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e extends hk9.a {
    public boolean b;
    public final v1 c;
    public boolean d;
    public boolean e;
    public final Set<View> f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c implements w1 {
        public final /* synthetic */ e a;

        @Override // cb8.w1
        public final void d() {
            e r0 = this.a;
            r0.d = true;
            r0.e = false;
            r0.f.clear();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.LinearLayout, ta8.e] */
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
        @Override // cb8.w1
        public final void e() {
            ?? r0 = this.a;
            boolean r1 = r0.e;
            int r2 = 0;
            r0.d = false;
            r0.e = false;
            if (r1 == false) goto L34;
            int r3 = r0.c.b.size();
            FLogger.a.i("ExperimentalBlockContainer", "reconcileChildrenWithCurrentModels, childCount: " + r0.getChildCount() + ", modelCount: " + r3);
        L6:
            if (r0.getChildCount() <= r3) goto L8;
            r0.f(r0.getChildCount() - 1);
        L8:
            if (r2 >= r3) goto L34;
            View r4 = r0.getChildAt(r2);
            if (r4 != null) goto L12;
        L30:
            if (r4 == null) goto L32;
            r0.removeViewAt(r2);
        L32:
            r0.d(r2);
        L33:
            r2 = r2 + 1;
            goto L8
        L12:
            if (r4.getTag() == b.a) goto L30;
            Object r5 = r4.getTag();
            String r6 = null;
            if ((r5 instanceof jc8.b) == false) goto L17;
            jc8.b r7 = (jc8.b) r5;
        L18:
            jc8.a r8 = (jc8.a) CollectionsKt.getOrNull(r0.c.b, r2);
            if (r7 == null) goto L29;
            String r9 = r7.b;
            if (r8 == null) goto L24;
            r6 = r8.h();
        L24:
            if (Intrinsics.areEqual(r9, r6) == false) goto L29;
            if (r0.f.remove(r4) == false) goto L33;
            r0.c(r2, r4, r7);
        L29:
            r0.f(r2);
            r0.d(r2);
            goto L33
        L17:
            r7 = null;
        L34:
            this.a.f.clear();
        }

        public c(e r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.LinearLayout, ta8.e] */
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
        @Override // cb8.w1
        public final void a(int r9, int r10) {
            ?? r0 = this.a;
            boolean r1 = r0.d;
            if (r1 == false) goto L5;
            r0.e = true;
        L5:
            int r3 = 0;
            if (r1 == false) goto L21;
            int r2 = 0;
        L8:
            if (r2 >= r10) goto L33;
            View r5 = r0.getChildAt(r9 + r2);
            if (r5 == null) goto L20;
            if (r5.getTag() != b.a) goto L14;
            boolean r6 = true;
        L15:
            if (r6 == false) goto L18;
            r5 = null;
        L18:
            if (r5 == null) goto L20;
            r0.f.add(r5);
            goto L20
        L14:
            r6 = false;
        L20:
            r2 = r2 + 1;
            goto L8
        L33:
            return;
        L21:
            if (r3 >= r10) goto L42;
            int r4 = r9 + r3;
            View r7 = r0.getChildAt(r4);
            if (r7 == null) goto L32;
            Object r8 = r7.getTag();
            if ((r8 instanceof jc8.b) == false) goto L28;
            jc8.b r11 = (jc8.b) r8;
        L29:
            if (r11 == null) goto L32;
            r0.c(r4, r7, r11);
            goto L32
        L28:
            r11 = null;
        L32:
            r3 = r3 + 1;
            goto L21
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.LinearLayout, java.lang.Object, ta8.e] */
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
        @Override // cb8.w1
        public final void b(int r10, int r11) {
            ?? r0 = this.a;
            if (r0.d == false) goto L5;
            r0.e = true;
        L5:
            r0.getClass();
            FLogger.a.i("ExperimentalBlockContainer", "notifyItemRemoved, position: " + r10 + ", count: " + r11);
            int r1 = 0;
        L6:
            if (r1 >= r11) goto L21;
            View r2 = r0.getChildAt(r10);
            if (r2 == null) goto L26;
            r0.f.remove(r2);
            Object r4 = r2.getTag();
            String r6 = null;
            if ((r4 instanceof jc8.b) == false) goto L13;
            jc8.b r5 = (jc8.b) r4;
        L14:
            FLogger r7 = FLogger.a;
            StringBuilder r8 = new StringBuilder("notifyItemRemoved, blockPosition: ");
            r8.append(r10);
            r8.append(", holder: ");
            if (r5 == null) goto L17;
            r6 = r5.c();
        L17:
            r8.append(r6);
            r7.i("ExperimentalBlockContainer", r8.toString());
            if (r5 == null) goto L20;
            r5.i();
        L20:
            r0.removeView(r2);
            r1 = r1 + 1;
            goto L6
        L13:
            r5 = null;
            goto L14
        L26:
            return;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.LinearLayout, ta8.e] */
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
        @Override // cb8.w1
        public final void c(int r9, int r10) {
            ?? r0 = this.a;
            boolean r1 = r0.d;
            if (r1 == false) goto L5;
            r0.e = true;
        L5:
            if (r1 == false) goto L11;
            FLogger.a.i("ExperimentalBlockContainer", "notifyItemInserted, position: " + r9 + ", count: " + r10);
            int r2 = 0;
        L7:
            if (r2 >= r10) goto L9;
            int r4 = r9 + r2;
            FLogger.a.i("ExperimentalBlockContainer", "notifyItemInserted, add placeholder, blockPosition: " + r4);
            View r5 = new View(r0.getContext());
            r5.setTag(b.a);
            r0.addView(r5, RangesKt.coerceIn(r4, 0, r0.getChildCount()), new LinearLayout.LayoutParams(-1, 0));
            r2 = r2 + 1;
            goto L7
        L9:
            return;
        L11:
            throw new IllegalStateException("Inserted event must be dispatched within DiffUtil updates".toString());
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.LinearLayout, java.lang.Object, ta8.e] */
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
        @Override // cb8.w1
        public final void notifyItemMoved(int r9, int r10) {
            ?? r0 = this.a;
            if (r0.d == false) goto L5;
            r0.e = true;
        L5:
            r0.getClass();
            FLogger r1 = FLogger.a;
            r1.i("ExperimentalBlockContainer", "handleMoved, fromPosition: " + r9 + ", toPosition: " + r10);
            View r2 = r0.getChildAt(r9);
            if (r2 == null) goto L17;
            Object r4 = r2.getTag();
            String r6 = null;
            if ((r4 instanceof jc8.b) == false) goto L11;
            jc8.b r5 = (jc8.b) r4;
        L12:
            StringBuilder r7 = new StringBuilder("handleMoved, blockPosition: ");
            r7.append(r9);
            r7.append(", holder: ");
            if (r5 == null) goto L15;
            r6 = r5.c();
        L15:
            r7.append(r6);
            r1.i("ExperimentalBlockContainer", r7.toString());
            r0.removeViewAt(r9);
            r0.addView(r2, RangesKt.coerceIn(r10, 0, r0.getChildCount()));
            return;
        L11:
            r5 = null;
            goto L12
        }
    }

    static {
    }

    private final c getObserver() {
        return (c) this.g.getValue();
    }

    public final void a() {
        e();
        v1 r0 = this.c;
        r0.getClass();
        List<? extends jc8.a> r1 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
        r0.a = CollectionsKt.emptyList();
        ((LinkedHashMap) r0.d).clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        Iterator r0 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = ((View) r0.next()).getTag();
        if ((r1 instanceof jc8.b) == false) goto L8;
        jc8.b r2 = (jc8.b) r1;
    L9:
        if (r2 == null) goto L4;
        r2.i();
        goto L4
    L8:
        r2 = null;
        goto L9
    L11:
        removeAllViews();
    }

    public boolean getLayoutFromBottom() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        setOrientation(1);
        v1 r4 = new v1();
        this.c = r4;
        this.f = new LinkedHashSet();
        this.g = LazyKt.lazy(new d(this));
        c r0 = getObserver();
        Intrinsics.checkNotNullParameter(r0, "observer");
        if (((ArrayList) r4.c).contains(r0) == true) goto L7;
        ((ArrayList) r4.c).add(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(int r6) {
        jc8.a r0 = (jc8.a) CollectionsKt.getOrNull(this.c.b, r6);
        if (r0 != null) goto L5;
        jc8.b<? extends jc8.a> r1 = new db8.a();
    L17:
        FLogger.a.i("ExperimentalBlockContainer", "createAndBindViewAt, blockPosition: " + r6 + ", holder: " + r1.c());
        r1.a = this.c;
        View r2 = r1.h(this);
        Intrinsics.checkNotNullParameter(r2, "view");
        r1.c = r2;
        r2.setTag(r1);
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 != null) goto L20;
        r3 = new LinearLayout.LayoutParams(-1, -2);
    L20:
        addView(r2, RangesKt.coerceIn(r6, 0, getChildCount()), r3);
        this.c.c(r6, r2, r1);
        return;
    L5:
        Map<Integer, List<IBlockProvider>> r4 = h.a;
        List r5 = h.a(r0.l());
        if (r5 == null) goto L16;
        Iterator r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        jc8.b<? extends jc8.a> r8 = ((IBlockProvider) r7.next()).t0(r0);
        if (r8 == null) goto L9;
        r1 = r8;
    L14:
        if (r1 == null) goto L16;
    L13:
        r1 = null;
    L16:
        r1 = new db8.a();
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(int r3) {
        View r0 = getChildAt(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        this.f.remove(r0);
        Object r1 = r0.getTag();
        if ((r1 instanceof jc8.b) == false) goto L8;
        jc8.b r2 = (jc8.b) r1;
    L9:
        if (r2 == null) goto L11;
        r2.i();
    L11:
        removeViewAt(r3);
        return;
    L8:
        r2 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLayoutFromBottom(boolean r2) {
        if (this.b == r2) goto L6;
        this.b = r2;
        requestLayout();
        return;
    }

    public final void b(Class<?> r3, l r4) {
        Intrinsics.checkNotNullParameter(r3, "clz");
        if (r4 != null) goto L5;
        v1 r5 = this.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r3, "clazz");
        r5.d.remove(r3);
        return;
    L5:
        v1 r1 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "clz");
        Intrinsics.checkNotNullParameter(r4, "data");
        r1.d.put(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r11, int r12) {
        if (getLayoutFromBottom() == true) goto L6;
        super/*android.widget.LinearLayout*/.onMeasure(r11, r12);
        return;
    L6:
        int r1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r2 = getPaddingTop() + getPaddingBottom();
        int r3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r11), 1073741824);
        int r5 = getChildCount();
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L15;
        View r7 = getChildAt(r6);
        Intrinsics.checkNotNull(r7);
        if (r7.getVisibility() != 8) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
        measureChild(r7, r3, r1);
        r2 = r2 + r7.getMeasuredHeight();
    L14:
        r6 = r6 + 1;
        goto L7
    L11:
        r8 = false;
        goto L12
    L15:
        int r13 = View.MeasureSpec.getSize(r11);
        int r0 = View.MeasureSpec.getMode(r12);
        if (r0 == Integer.MIN_VALUE) goto L20;
        if (r0 != 1073741824) goto L21;
        r2 = View.MeasureSpec.getSize(r12);
    L21:
        setMeasuredDimension(r13, r2);
        return;
    L20:
        r2 = RangesKt.coerceAtMost(r2, View.MeasureSpec.getSize(r12));
        goto L21
    }

    public final void c(int r4, View r5, jc8.b<? extends jc8.a> r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        this.c.c(r4, r5, r6);     // Catch: Throwable -> L4
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L12;
        FLogger.a.e("ExperimentalBlockContainer", "bind changed view failed, position: " + r4 + ", holder: " + r6.c(), r8);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        if (getLayoutFromBottom() == true) goto L7;
        super/*android.widget.LinearLayout*/.onLayout(r4, r5, r6, r7, r8);
        return;
    L7:
        if (getChildCount() == 0) goto L19;
        int r9 = getPaddingLeft();
        int r10 = getWidth() - getPaddingRight();
        int r11 = getHeight() - getPaddingBottom();
        int r12 = getChildCount() - 1;
    L11:
        if ((-1) >= r12) goto L23;
        View r0 = getChildAt(r12);
        Intrinsics.checkNotNull(r0);
        if (r0.getVisibility() != 8) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == true) goto L18;
        int r2 = r11 - r0.getMeasuredHeight();
        r0.layout(r9, r2, r10, r11);
        r11 = r2;
    L18:
        r12 = r12 - 1;
        goto L11
    L15:
        r1 = false;
        goto L16
    L23:
        return;
    }
}
