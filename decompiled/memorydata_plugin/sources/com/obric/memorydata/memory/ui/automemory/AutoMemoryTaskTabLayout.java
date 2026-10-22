package com.obric.memorydata.memory.ui.automemory;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.obric.oui.tab.OTabLayoutBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010&\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010'\u001a\u00020\u0015H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTaskTabLayout;", "Lcom/obric/oui/tab/OTabLayoutBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeTabIndex", "forwardingTouch", "", "clickCanceled", "startContainerTouch", "x", "", "y", "requireInsideBounds", "startContainerTouch$memory_obricRelease", "updateContainerTouch", "", "inside", "updateContainerTouch$memory_obricRelease", "finishContainerTouch", "finishContainerTouch$memory_obricRelease", "cancelContainerTouch", "cancelContainerTouch$memory_obricRelease", "cancelContainerClick", "cancelContainerClick$memory_obricRelease", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "performTabClick", "index", "setActiveTabPressed", "pressed", "findTabIndexByX", "isInsideRoundedBounds", "resetForwardingState", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryTaskTabLayout extends OTabLayoutBase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f10607b = null;
    private int A;
    private boolean B;
    private boolean C;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTaskTabLayout$Companion;", "", "<init>", "()V", "INVALID_TAB_INDEX", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10607b = new a(null);
    }

    public AutoMemoryTaskTabLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AutoMemoryTaskTabLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public AutoMemoryTaskTabLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.A = -1;
        a(0, 6);
    }

    public /* synthetic */ AutoMemoryTaskTabLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final boolean a(float r4, float r5) {
        if (getWidth() > 0) goto L5;
        return false;
    L5:
        if (getHeight() > 0) goto L8;
        return false;
    L8:
        if (r4 >= 0.0f) goto L10;
        return false;
    L10:
        if (r5 >= 0.0f) goto L12;
        return false;
    L12:
        if (r4 <= getWidth()) goto L14;
        return false;
    L14:
        if (r5 > getHeight()) goto L26;
        float r0 = Math.min(getWidth(), getHeight()) / 2.0f;
        float r6 = r4 - RangesKt.coerceIn(r4, r0, getWidth() - r0);
        float r7 = r5 - RangesKt.coerceIn(r5, r0, getHeight() - r0);
        if (((r6 * r6) + (r7 * r7)) > (r0 * r0)) goto L24;
        return true;
    L24:
        return false;
    L26:
        return false;
    }

    public static /* synthetic */ boolean a(AutoMemoryTaskTabLayout r0, float r1, float r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        return r0.a(r1, r2, r3);
    }

    private final int b(float r7) {
        int r0 = getTabCount();
        int r1 = -1;
        if (r0 > 0) goto L5;
        return -1;
    L5:
        float r8 = (r7 + getScrollX()) - getTabContainer().getLeft();
        float r2 = Float.MAX_VALUE;
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L19;
        View r4 = f(r3);
        if (r4 == null) goto L18;
        if (r8 >= r4.getLeft()) goto L13;
    L15:
        float r5 = Math.abs(r8 - ((r4.getLeft() + r4.getRight()) / 2.0f));
        if (r5 >= r2) goto L18;
        r1 = r3;
        r2 = r5;
        goto L18
    L13:
        if (r8 >= r4.getRight()) goto L15;
        return r3;
    L18:
        r3 = r3 + 1;
        goto L6
    L19:
        return r1;
    }

    private final void g(int r4) {
        if (r4 != (-1)) goto L5;
        return;
    L5:
        View r0 = f(r4);
        boolean r1 = true;
        if (r0 != null) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == true) goto L14;
        e(r4);
        return;
    L14:
        return;
    L8:
        if (r0.performClick() != true) goto L10;
        goto L10
    }

    private final void h() {
        this.A = -1;
        this.B = false;
        this.C = false;
    }

    private final void setActiveTabPressed(boolean r2) {
        View r1 = f(this.A);
        if (r1 == null) goto L6;
        r1.setPressed(r2);
        return;
    }

    public final void a() {
        if (this.B == true) goto L5;
        return;
    L5:
        setActiveTabPressed(false);
        h();
    }

    public final void a(boolean r2) {
        if (this.B == true) goto L6;
        return;
    L6:
        if (this.C == true) goto L9;
        if (r2 == false) goto L9;
        boolean r3 = true;
    L10:
        setActiveTabPressed(r3);
        return;
    L9:
        r3 = false;
        goto L10
    }

    public final boolean a(float r2, float r3, boolean r4) {
        if (r4 == true) goto L5;
    L8:
        int r5 = b(r2);
        this.A = r5;
        if (r5 != (-1)) goto L11;
        return false;
    L11:
        this.B = true;
        this.C = false;
        setActiveTabPressed(true);
        return true;
    L5:
        if (a(r2, r3) == true) goto L8;
        h();
        return false;
    }

    public final void b() {
        if (this.B == true) goto L5;
        return;
    L5:
        setActiveTabPressed(false);
        this.C = true;
    }

    public final void b(boolean r2) {
        if (this.B == true) goto L5;
        return;
    L5:
        setActiveTabPressed(false);
        if (this.C == true) goto L9;
        if (r2 == false) goto L9;
        g(this.A);
    L9:
        h();
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        int r0 = r10.getActionMasked();
        if (r0 == 0) goto L34;
        if (r0 == 1) goto L29;
        if (r0 == 2) goto L24;
        if (r0 == 3) goto L19;
        if (r0 == 5) goto L14;
        return super.dispatchTouchEvent(r10);
    L14:
        if (this.B == true) goto L16;
        return false;
    L16:
        b();
        return true;
    L19:
        if (this.B == true) goto L21;
        return false;
    L21:
        a();
        return true;
    L24:
        if (this.B == true) goto L26;
        return false;
    L26:
        a(a(r10.getX(), r10.getY()));
        return true;
    L29:
        if (this.B == true) goto L31;
        return false;
    L31:
        b(a(r10.getX(), r10.getY()));
        return true;
    L34:
        if (a(this, r10.getX(), r10.getY(), false, 4, null) == true) goto L38;
        if (super.dispatchTouchEvent(r10) == true) goto L38;
        return false;
    L38:
        return true;
    }
}
