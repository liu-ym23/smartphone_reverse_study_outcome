package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/flow/passport/ui/widget/layout/BaseContainerLayout;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewLifecycle", "Landroidx/lifecycle/Lifecycle;", "getViewLifecycle", "()Landroidx/lifecycle/Lifecycle;", "viewLifecycle$delegate", "Lkotlin/Lazy;", "lifecycle", "getLifecycle", "inflateFullLayout", "", "layoutId", "inflateCommonLayout", "Lcom/ss/android/lark/flow/passport/ui/widget/layout/CommonContainerLayout;", "partialLayoutRes", "flow-passport-ui_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class BaseContainerLayout extends FrameLayout implements LifecycleOwner {
    public final Lazy a;

    public BaseContainerLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseContainerLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Lifecycle getViewLifecycle() {
        return (Lifecycle) this.a.getValue();
    }

    public Lifecycle getLifecycle() {
        return getViewLifecycle();
    }

    public final void a(int r5) {
        ViewStub r0 = (ViewStub) findViewById(2131392946);
        ViewGroup.LayoutParams r1 = getLayoutParams();
        if (r1 == null) goto L5;
        ((FrameLayout.LayoutParams) r1).gravity = 1;
    L6:
        r0.setLayoutResource(r5);
        r0.inflate();
        return;
    L5:
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup.LayoutParams r2 = getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r2).gravity = 1;
        goto L6
    }

    public BaseContainerLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new BaseContainerLayout$viewLifecycle$2(this));
        View.inflate(r2, 2131564874, this);
        if (getId() != (-1)) goto L6;
        setId(2131386496);
        return;
    }

    public /* synthetic */ BaseContainerLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
