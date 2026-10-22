package q8a;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import com.lynx.xelement.scroll.coordinator.childitem.ScrollCoordinatorNestedScrollView;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends HorizontalScrollView {
    public final /* synthetic */ ScrollCoordinatorNestedScrollView a;

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.a.f == true) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r2);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.FrameLayout, com.lynx.xelement.scroll.coordinator.childitem.ScrollCoordinatorNestedScrollView] */
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
    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        ScrollCoordinatorNestedScrollView r0 = this.a;
        if (r0.f == false) goto L12;
        r0.e(r5);
        if (r5.getAction() != 0) goto L8;
        ScrollCoordinatorNestedScrollView r1 = this.a;
        r1.f(r1.q);
    L8:
        if (r5.getAction() != 1) goto L11;
        ?? r2 = this.a;
        r2.n = r2.getScrollY();
        r2.o = r2.c.getScrollX();
        r2.postDelayed(r2.m, r2.p);
    L11:
        return super.onTouchEvent(r5);
    L12:
        return false;
    }

    public d(ScrollCoordinatorNestedScrollView r1, Context r2) {
        this.a = r1;
        super(r2);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        ScrollCoordinatorNestedScrollView r5 = this.a;
        if (r1 != r5.e) goto L6;
        return;
    L6:
        if (r5.i == true) goto L8;
    L13:
        r5.f(r5.q);
        Iterator<ScrollCoordinatorNestedScrollView.a> r6 = r5.k.iterator();
    L15:
        if (r6.hasNext() == false) goto L18;
        r6.next().onScrollChanged();
    L18:
        if (this.a.e == getScrollX()) goto L23;
        ScrollCoordinatorNestedScrollView r7 = this.a;
        r7.e = getScrollX();
        return;
    L23:
        return;
    L8:
        if (r5.j == true) goto L13;
        r5.j = true;
        r5.f(1);
        Iterator<ScrollCoordinatorNestedScrollView.a> r8 = r5.k.iterator();
    L11:
        if (r8.hasNext() == false) goto L18;
        r8.next().a();
        goto L11
    }
}
