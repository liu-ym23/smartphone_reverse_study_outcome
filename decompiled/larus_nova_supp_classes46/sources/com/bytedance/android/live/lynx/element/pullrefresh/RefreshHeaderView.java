package com.bytedance.android.live.lynx.element.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.e;
import cqa.h;
import dqa.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0000H\u0016J\u0014\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u00020\u0006\"\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/lynx/element/pullrefresh/RefreshHeaderView;", "Landroid/widget/RelativeLayout;", "Lcqa/e;", "Ldqa/b;", "getSpinnerStyle", "getView", "", "", "colors", "", "setPrimaryColors", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RefreshHeaderView extends RelativeLayout implements e {
    public RefreshHeaderView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RefreshHeaderView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean a() {
        return false;
    }

    public final void d(float r1, int r2, int r3) {
    }

    public final void e(h r2, RefreshState r3, RefreshState r4) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
    }

    /* JADX INFO: renamed from: getView, reason: collision with other method in class */
    public RefreshHeaderView m510getView() {
        return this;
    }

    public void setPrimaryColors(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
    }

    public /* bridge */ /* synthetic */ View getView() {
        return m510getView();
    }

    public b getSpinnerStyle() {
        return b.d;
    }

    public final int j(SmartRefreshLayout r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        ALogger.i("lol", "RefreshHeaderView -> onFinish");
        return 0;
    }

    public RefreshHeaderView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public final void f(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        ALogger.i("lol", "RefreshHeaderView -> onStartAnimator");
    }

    public final void g(SmartRefreshLayout.j r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "kernel");
        ALogger.i("lol", "RefreshHeaderView -> onInitialized");
    }

    public final void i(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        ALogger.i("lol", "RefreshHeaderView -> onReleased");
    }

    public /* synthetic */ RefreshHeaderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b(boolean r1, float r2, int r3, int r4, int r5) {
        ALogger.i("lol", "RefreshHeaderView -> onMoving");
    }
}
