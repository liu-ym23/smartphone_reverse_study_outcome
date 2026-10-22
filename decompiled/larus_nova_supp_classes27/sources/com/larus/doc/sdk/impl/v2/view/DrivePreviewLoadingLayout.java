package com.larus.doc.sdk.impl.v2.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.dependency.LoadingLayoutScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yx4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/view/DrivePreviewLoadingLayout;", "Lcom/bytedance/ee/bear/dependency/ILoadingLayout;", "<init>", "()V", "loadingRootView", "Landroid/view/View;", "attachLoadingView", "", "frameLayout", "Landroid/widget/FrameLayout;", "showLoading", "hideLoading", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewLoadingLayout implements d {
    private View loadingRootView;

    public DrivePreviewLoadingLayout() {
    }

    public void detachLoadingView() {
    }

    public void hideLoading() {
        View r0 = this.loadingRootView;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public void showLoading() {
        View r0 = this.loadingRootView;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r1 = this.loadingRootView;
        if (r1 == null) goto L9;
        r1.bringToFront();
        return;
    }

    public LoadingLayoutScope getScope() {
        return LoadingLayoutScope.CONTENT;
    }

    public void attachLoadingView(FrameLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "frameLayout");
        if (this.loadingRootView == null) goto L5;
        return;
    L5:
        this.loadingRootView = LayoutInflater.from(r4.getContext()).inflate(2131562811, r4, true);
        hideLoading();
    }
}
