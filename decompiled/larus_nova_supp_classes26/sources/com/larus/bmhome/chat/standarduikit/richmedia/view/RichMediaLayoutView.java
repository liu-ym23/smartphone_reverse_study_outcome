package com.larus.bmhome.chat.standarduikit.richmedia.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.h0;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import fn8.a0;
import fn8.b0;
import fn8.c0;
import fn8.x;
import fn8.z;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001\u0019B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0006\u0010\u0015\u001a\u00020\u0013J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaLayoutView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaLayoutViewInput;", "Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaLayoutViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "output", "exposureCheckPosted", "", "richMediaAdapter", "Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaLayoutAdapter;", "recyclerView", "Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaLayoutView$RichMediaRecyclerView;", "bindData", "", "input", "recycle", "onWindowFocusChanged", "hasWindowFocus", "requestExposureCheck", "RichMediaRecyclerView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichMediaLayoutView extends FrameLayout {
    public static final /* synthetic */ int e = 0;
    public c0 a;
    public boolean b;
    public final RichMediaLayoutAdapter c;
    public final a d;

    public static final class a extends RecyclerView {
        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean requestChildRectangleOnScreen(View r3, Rect r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "child");
            if (r4 != null) goto L5;
            return false;
        L5:
            Rect r0 = new Rect(r4);
            offsetDescendantRectToMyCoords(r3, r0);
            ViewParent r6 = getParent();
            if (r6 != null) goto L8;
            return false;
        L8:
            if (r6.requestChildRectangleOnScreen(this, r0, r5) != true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public final void b() {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        this.d.postOnAnimation(new z(this));
    }

    public RichMediaLayoutView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == false) goto L6;
        b();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaLayoutView$a] */
    public RichMediaLayoutView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        RichMediaLayoutAdapter r6 = new RichMediaLayoutAdapter();
        this.c = r6;
        ?? r0 = new a(r4);
        r0.setLayoutManager(new LinearLayoutManager(r4, 0, false));
        r0.setAdapter(r6);
        r0.setItemAnimator(null);
        r0.setOverScrollMode(2);
        r0.setNestedScrollingEnabled(false);
        r0.setClipToPadding(false);
        ExposureTrackerExtKt.b(r0);
        ExposeXTrackerExtKt.c(r0);
        r0.addOnScrollListener(new RichMediaLayoutView$recyclerView$1$1(this));
        r0.addItemDecoration(new RichMediaLayoutView$recyclerView$1$2());
        this.d = r0;
        setClipChildren(false);
        setClipToPadding(false);
        addView(r0, new FrameLayout.LayoutParams(-1, -2));
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
    public final void a(b0 r7, final h0.b r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "output");
        this.a = r8;
        setOnLongClickListener(new a0(r8));
        this.d.setPaddingRelative(RangesKt.coerceAtLeast(r7.b, 0), this.d.getPaddingTop(), RangesKt.coerceAtLeast(r7.c, 0), this.d.getPaddingBottom());
        if (r7.a.isEmpty() == false) goto L6;
        setVisibility(8);
        RichMediaLayoutAdapter r9 = this.c;
        List<x> r0 = CollectionsKt.emptyList();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "newItems");
        r9.a = r0;
        r9.b = r8;
        r9.notifyDataSetChanged();
        return;
    L6:
        setVisibility(0);
        RecyclerView r1 = this.d;
        Iterator<T> r2 = r7.a.iterator();
        if (r2.hasNext() == false) goto L17;
        int r3 = ((x) r2.next()).g.getHeight();
    L10:
        if (r2.hasNext() == false) goto L14;
        int r4 = ((x) r2.next()).g.getHeight();
        if (r3 >= r4) goto L10;
        r3 = r4;
        goto L10
    L14:
        r1.setLayoutParams(new FrameLayout.LayoutParams(-1, r3));
        RichMediaLayoutAdapter r5 = this.c;
        List<x> r10 = r7.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "newItems");
        r5.a = r10;
        r5.b = r8;
        r5.notifyDataSetChanged();
        b();
        return;
    L17:
        throw new NoSuchElementException();
    }
}
