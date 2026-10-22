package io.noties.markwon.scrollable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/noties/markwon/scrollable/ScrollableSpanTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allowScrollVertical", "", "downOnScrollableArea", "lastX", "", "lastY", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "requestDisallowViewPager2Intercept", "", "disallow", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public class ScrollableSpanTextView extends AppCompatTextView {
    private boolean allowScrollVertical;
    private boolean downOnScrollableArea;
    private float lastX;
    private float lastY;

    public ScrollableSpanTextView(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
    }

    public ScrollableSpanTextView(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin"), 0, 4, null);
    }

    public ScrollableSpanTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "context");
        super(r6, r7, r5);
    }

    public /* synthetic */ ScrollableSpanTextView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = (AttributeSet) ZeusTransformUtils.preCheckCast(null, AttributeSet.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void requestDisallowViewPager2Intercept(boolean r3) {
        ViewParent r2 = getParent();
    L4:
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L12;
        if (ZeusTransformUtils.instanceOf(r2, a.class) == true) goto L7;
        r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin")).getParent();
        goto L4
    L7:
        r2.requestDisallowInterceptTouchEvent(r3);
        return;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L38;
        boolean r1 = false;
        if (r7.getActionMasked() != 0) goto L19;
        b[] r0 = (b[]) ZeusTransformUtils.preCheckCast(c.f16666a.a(r7, (TextView) ZeusTransformUtils.preCheckCast(this, TextView.class, "com.obric.memorydata.plugin"), b.class), b[].class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L36;
        int r3 = r0.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L13;
        if (r0[r4].d() == true) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        r1 = true;
    L13:
        if (r1 != true) goto L36;
        ViewParent r2 = getParent();
        if (r2 == null) goto L17;
        r2.requestDisallowInterceptTouchEvent(true);
    L17:
        this.downOnScrollableArea = true;
    L36:
        this.lastX = r7.getX();
        this.lastY = r7.getY();
        goto L38
    L19:
        if (r7.getActionMasked() != 2) goto L31;
        float r5 = r7.getX() - this.lastX;
        float r6 = r7.getY() - this.lastY;
        if (this.allowScrollVertical == true) goto L36;
        if (this.downOnScrollableArea == false) goto L36;
        if (Math.abs(r6) <= Math.abs(r5)) goto L36;
        ViewParent r8 = getParent();
        if (r8 == null) goto L29;
        r8.requestDisallowInterceptTouchEvent(false);
    L29:
        requestDisallowViewPager2Intercept(true);
        this.allowScrollVertical = true;
        goto L36
    L31:
        if (r7.getActionMasked() != 1) goto L36;
        ViewParent r9 = getParent();
        if (r9 == null) goto L35;
        r9.requestDisallowInterceptTouchEvent(false);
    L35:
        this.downOnScrollableArea = false;
        this.allowScrollVertical = false;
    L38:
        return super.dispatchTouchEvent(r7);
    }
}
