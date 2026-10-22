package com.obric.oui.popover;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.oui.c.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/FakeAnchorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FakeAnchorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14307a = null;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/popover/FakeAnchorView$Companion;", "", "()V", "TAG", "", "addFakeAnchorView", "Lcom/obric/oui/popover/FakeAnchorView;", "context", "Landroid/content/Context;", "width", "", "height", "rootView", "Landroid/view/ViewGroup;", "posX", "posY", "addInvisibleViewAtPosition", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "dialog", "Landroid/app/Dialog;", "parent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final FakeAnchorView a(Context r6, int r7, int r8, ViewGroup r9, int r10, int r11) {
            FakeAnchorView r12 = new FakeAnchorView((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), null, 2, 0 == true ? 1 : 0);
            r12.setBackgroundColor(0);
            r12.setAlpha(0.0f);
            r9.addView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(r7, r8), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            int[] r0 = new int[2];
            r9.getLocationOnScreen(r0);
            int r13 = r10 - r0[0];
            int r14 = r11 - r0[1];
            r12.setX(r13);
            r12.setY(r14);
            r12.measure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), View.MeasureSpec.makeMeasureSpec(r8, 1073741824));
            r12.layout(0, 0, r7, r8);
            com.obric.oui.c.a.b.b("FakeAnchorView", "w: " + r12.getMeasuredWidth() + ", h: " + r12.getMeasuredHeight());
            return r12;
        }

        public final View a(Activity r10, int r11, int r12, int r13, int r14) {
            Activity r15 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "activity");
            ViewGroup r6 = h.f13408a.a(r15);
            if (r6 == null) goto L7;
            return (View) ZeusTransformUtils.preCheckCast(a((Context) ZeusTransformUtils.preCheckCast(r15, Context.class, "com.obric.memorydata.plugin"), r13, r14, r6, r11, r12), View.class, "com.obric.memorydata.plugin");
        L7:
            throw new Exception("rootView is null");
        }
    }

    static {
        f14307a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FakeAnchorView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public FakeAnchorView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
    }

    public /* synthetic */ FakeAnchorView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }
}
