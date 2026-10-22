package com.obric.memorydata.memory.ui.automemory;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTaskRootLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabBounds", "Landroid/graphics/Rect;", "hitRect", "Landroid/graphics/RectF;", "activeTabLayout", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTaskTabLayout;", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "findTaskTabLayout", "isLoadingOverlayVisible", "isInsideTabRoundedBounds", "tabLayout", "Landroid/view/View;", "x", "", "y", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryTaskRootLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f10605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f10606b;
    private AutoMemoryTaskTabLayout c;

    public AutoMemoryTaskRootLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AutoMemoryTaskRootLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public AutoMemoryTaskRootLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f10605a = new Rect();
        this.f10606b = new RectF();
    }

    public /* synthetic */ AutoMemoryTaskRootLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final AutoMemoryTaskTabLayout a() {
        AutoMemoryTaskTabLayout r3 = (AutoMemoryTaskTabLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.task_tab_container, OaidModel.KEY_ID, "task_tab_container")), AutoMemoryTaskTabLayout.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L15;
        if (r3.isShown() == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L15;
        return r3;
    L7:
        if (r3.getWidth() <= 0) goto L11;
        if (r3.getHeight() <= 0) goto L11;
        r1 = true;
    L15:
        return null;
    }

    private final boolean a(View r5, float r6, float r7) {
        this.f10605a.set(0, 0, r5.getWidth(), r5.getHeight());
        offsetDescendantRectToMyCoords(r5, this.f10605a);
        this.f10606b.set(this.f10605a);
        if (this.f10606b.contains(r6, r7) == true) goto L5;
        return false;
    L5:
        float r8 = Math.min(this.f10606b.width(), this.f10606b.height()) / 2.0f;
        float r0 = RangesKt.coerceIn(r6, this.f10606b.left + r8, this.f10606b.right - r8);
        float r9 = r6 - r0;
        float r10 = r7 - RangesKt.coerceIn(r7, this.f10606b.top + r8, this.f10606b.bottom - r8);
        if (((r9 * r9) + (r10 * r10)) > (r8 * r8)) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean b() {
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.task_loading_overlay, OaidModel.KEY_ID, "task_loading_overlay"));
        if (r3 == null) goto L8;
        if (r3.isShown() != true) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        int r0 = r8.getActionMasked();
        if (r0 == 0) goto L41;
        if (r0 != 1) goto L6;
        AutoMemoryTaskTabLayout r1 = this.c;
        if (r1 == null) goto L35;
        r1.b(a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), r8.getX(), r8.getY()));
        this.c = null;
        ViewParent r7 = getParent();
        if (r7 == null) goto L39;
        r7.requestDisallowInterceptTouchEvent(false);
    L39:
        return true;
    L35:
        return super.dispatchTouchEvent(r8);
    L6:
        if (r0 != 2) goto L8;
        AutoMemoryTaskTabLayout r2 = this.c;
        if (r2 == null) goto L29;
        r2.a(a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), r8.getX(), r8.getY()));
        return true;
    L29:
        return super.dispatchTouchEvent(r8);
    L8:
        if (r0 != 3) goto L10;
        AutoMemoryTaskTabLayout r3 = this.c;
        if (r3 == null) goto L21;
        r3.a();
        this.c = null;
        ViewParent r9 = getParent();
        if (r9 == null) goto L25;
        r9.requestDisallowInterceptTouchEvent(false);
    L25:
        return true;
    L21:
        return super.dispatchTouchEvent(r8);
    L10:
        if (r0 != 5) goto L56;
        AutoMemoryTaskTabLayout r4 = this.c;
        if (r4 == null) goto L15;
        r4.b();
        return true;
    L15:
        return super.dispatchTouchEvent(r8);
    L56:
        return super.dispatchTouchEvent(r8);
    L41:
        if (b() == true) goto L43;
        AutoMemoryTaskTabLayout r5 = a();
        if (r5 == null) goto L56;
        if (a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), r8.getX(), r8.getY()) == false) goto L56;
        this.c = r5;
        if (r5.a(r8.getX() - this.f10605a.left, r8.getY() - this.f10605a.top, false) == false) goto L54;
        ViewParent r10 = getParent();
        if (r10 == null) goto L53;
        r10.requestDisallowInterceptTouchEvent(true);
    L53:
        return true;
    L54:
        this.c = null;
        goto L56
    L43:
        return super.dispatchTouchEvent(r8);
    }
}
