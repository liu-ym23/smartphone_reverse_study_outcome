package ta8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public final class c extends hk9.a {
    public static final /* synthetic */ int e = 0;
    public boolean b;
    public final cb8.a c;
    public final Lazy d;

    public static final class a {
    }

    public static final class b implements cb8.b {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.LinearLayout, java.lang.Object, ta8.c] */
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
        @Override // cb8.b
        public final void a(int r9, int r10) {
            ?? r0 = this.a;
            int r1 = c.e;
            r0.getClass();
            int r2 = 0;
        L3:
            if (r2 >= r10) goto L36;
            String r3 = null;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L13
            int r5 = r9 + r2;     // Catch: Throwable -> L13
            View r6 = r0.getChildAt(r5);     // Catch: Throwable -> L13
            Object r7 = r6.getTag();     // Catch: Throwable -> L13
            if ((r7 instanceof jc8.b) == false) goto L8;
            jc8.b<? extends jc8.a> r8 = (jc8.b) r7;     // Catch: Throwable -> L13
        L9:
            if (r8 == null) goto L29;
            cb8.a r11 = r0.c;     // Catch: Throwable -> L13
            Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L13
            r11.c(r5, r6, r8);     // Catch: Throwable -> L13
            Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        L15:
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L28;
            int r14 = r9 + r2;
            View r15 = r0.getChildAt(r14);
            if (r15 == null) goto L20;
            Object r16 = r15.getTag();
        L22:
            if ((r16 instanceof jc8.b) == false) goto L24;
            jc8.b r17 = (jc8.b) r16;
        L25:
            if (r17 == null) goto L27;
            r3 = r17.c();
        L27:
            FLogger.a.e("BlockContainer", "handleChanged failed, position=" + r14 + ", holder=" + r3 + ", exceptionClass=" + r13.getClass().getSimpleName());
            goto L28
        L24:
            r17 = null;
            goto L25
        L20:
            r16 = null;
        L28:
            r2 = r2 + 1;
            goto L3
        L29:
            return;
        L8:
            r8 = null;
        L13:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L15
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
        @Override // cb8.b
        public final void b(int r9, int r10) {
            hk9.a r0 = this.a;
            int r1 = c.e;
            r0.getClass();
            FLogger.a.i("BlockContainer", "notifyItemRemoved, position: " + r9 + ", count: " + r10);
            int r2 = 0;
        L3:
            if (r2 >= r10) goto L18;
            View r3 = r0.getChildAt(r9);
            if (r3 == null) goto L23;
            Object r4 = r3.getTag();
            String r5 = null;
            if ((r4 instanceof jc8.b) == false) goto L10;
            jc8.b r6 = (jc8.b) r4;
        L11:
            FLogger r7 = FLogger.a;
            StringBuilder r8 = new StringBuilder("notifyItemRemoved, blockPosition: ");
            r8.append(r9);
            r8.append(", holder: ");
            if (r6 == null) goto L14;
            r5 = r6.c();
        L14:
            r8.append(r5);
            r7.i("BlockContainer", r8.toString());
            if (r6 == null) goto L17;
            r6.i();
        L17:
            r0.removeViewAt(r9);
            r2 = r2 + 1;
            goto L3
        L10:
            r6 = null;
            goto L11
        L23:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, android.widget.LinearLayout, java.lang.Object, ta8.c] */
        /* JADX WARN: Type inference failed for: r4v4, types: [db8.a] */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object, jc8.b] */
        /* JADX WARN: Type inference failed for: r4v9, types: [db8.a] */
        /* JADX WARN: Type inference failed for: r5v7, types: [android.view.View, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v9, types: [cb8.a] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // cb8.b
        public final void c(int r10, int r11) {
            ?? r0 = this.a;
            int r1 = c.e;
            r0.getClass();
            FLogger.a.i("BlockContainer", "notifyItemInserted, position: " + r10 + ", count: " + r11);
            int r2 = 0;
        L3:
            if (r2 >= r11) goto L23;
            int r3 = r10 + r2;
            jc8.a r4 = (jc8.a) CollectionsKt.getOrNull(r0.c.b, r3);
            if (r4 != null) goto L7;
            ?? r5 = new db8.a();
        L19:
            FLogger.a.i("BlockContainer", "notifyItemInserted, blockPosition: " + r3 + ", holder: " + r5.c());
            r5.a = r0.c;
            ?? r6 = r5.h(r0);
            Intrinsics.checkNotNullParameter(r6, "view");
            r5.c = r6;
            r6.setTag(r5);
            ViewGroup.LayoutParams r7 = r6.getLayoutParams();
            if (r7 != null) goto L22;
            r7 = new LinearLayout.LayoutParams(-1, -2);
        L22:
            r0.addView(r6, r3, r7);
            r0.c.c(r3, r6, r5);
            r2 = r2 + 1;
            goto L3
        L7:
            Map<Integer, List<IBlockProvider>> r8 = h.a;
            List r9 = h.a(r4.l());
            if (r9 == null) goto L18;
            Iterator r12 = r9.iterator();
        L11:
            if (r12.hasNext() == false) goto L15;
            jc8.b r13 = ((IBlockProvider) r12.next()).t0(r4);
            if (r13 == null) goto L11;
            r5 = r13;
        L16:
            if (r5 == 0) goto L18;
        L15:
            r5 = 0;
        L18:
            r5 = new db8.a();
            goto L19
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
        @Override // cb8.b
        public final void notifyItemMoved(int r9, int r10) {
            hk9.a r0 = this.a;
            int r1 = c.e;
            r0.getClass();
            FLogger r2 = FLogger.a;
            r2.i("BlockContainer", "handleMoved, fromPosition: " + r9 + ", toPosition: " + r10);
            View r3 = r0.getChildAt(r9);
            Object r4 = r3.getTag();
            String r6 = null;
            if ((r4 instanceof jc8.b) == false) goto L5;
            jc8.b r5 = (jc8.b) r4;
        L6:
            StringBuilder r7 = new StringBuilder("handleMoved, blockPosition: ");
            r7.append(r9);
            r7.append(", holder: ");
            if (r5 == null) goto L9;
            r6 = r5.c();
        L9:
            r7.append(r6);
            r2.i("BlockContainer", r7.toString());
            r0.removeViewAt(r9);
            r0.addView(r3, r10);
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    private final b getObserver() {
        return (b) this.d.getValue();
    }

    public final void a() {
        c();
        cb8.a r0 = this.c;
        r0.getClass();
        List<? extends jc8.a> r1 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
        r0.a = CollectionsKt.emptyList();
        ((LinkedHashMap) r0.d).clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
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
    public c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        setOrientation(1);
        cb8.a r4 = new cb8.a();
        this.c = r4;
        this.d = LazyKt.lazy(new ta8.b(this));
        b r0 = getObserver();
        Intrinsics.checkNotNullParameter(r0, "observer");
        if (((ArrayList) r4.c).contains(r0) == true) goto L7;
        ((ArrayList) r4.c).add(r0);
        return;
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
        cb8.a r5 = this.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r3, "clazz");
        r5.d.remove(r3);
        return;
    L5:
        cb8.a r1 = this.c;
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
