package com.bytedance.android.live.lynx.element.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.d;
import cqa.h;
import dqa.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00020\u0007\"\u00020\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/lynx/element/pullrefresh/RefreshFooterView;", "Landroid/widget/RelativeLayout;", "Lcqa/d;", "Ldqa/b;", "getSpinnerStyle", "Landroid/view/View;", "getView", "", "", "colors", "", "setPrimaryColors", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RefreshFooterView extends RelativeLayout implements d {
    public RefreshFooterView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RefreshFooterView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean a() {
        return false;
    }

    public final boolean c(boolean r1) {
        return true;
    }

    public final void d(float r1, int r2, int r3) {
    }

    public final void e(h r2, RefreshState r3, RefreshState r4) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
    }

    public View getView() {
        return this;
    }

    public void setPrimaryColors(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
    }

    public b getSpinnerStyle() {
        return b.d;
    }

    public final int j(SmartRefreshLayout r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        ALogger.i("lol", "RefreshFooterView -> onFinish");
        return 0;
    }

    public RefreshFooterView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public final void f(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        ALogger.i("lol", "RefreshFooterView -> onStartAnimator");
    }

    public final void g(SmartRefreshLayout.j r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "kernel");
        ALogger.i("lol", "RefreshFooterView -> onInitialized");
    }

    public final void i(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        ALogger.i("lol", "RefreshFooterView -> onReleased");
    }

    public /* synthetic */ RefreshFooterView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b(boolean r1, float r2, int r3, int r4, int r5) {
        ALogger.i("lol", "RefreshFooterView -> onMoving");
    }
}
