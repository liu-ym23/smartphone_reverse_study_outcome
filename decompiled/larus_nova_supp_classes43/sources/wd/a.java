package wd;

import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a implements g {
    public a() {
    }

    @Override // wd.e
    @Deprecated(message = "使用 onViewWillDetach 替代", replaceWith = @ReplaceWith(expression = "onViewWillDetach()", imports = {}))
    public final void onHide() {
    }

    @Override // wd.e
    @Deprecated(message = "使用 onViewAttached 替代", replaceWith = @ReplaceWith(expression = "onViewAttached()", imports = {}))
    public final void onShow() {
    }

    @Override // wd.e
    public final void onUnload() {
    }

    @Override // wd.e
    public final void onViewAttached(c r10) {
        Intrinsics.checkNotNullParameter(r10, "viewContainerLayoutParam");
    }

    @Override // wd.e
    public final void onViewDetached() {
    }

    @Override // wd.e
    public final void onViewWillAttach(c r10) {
        Intrinsics.checkNotNullParameter(r10, "viewContainerLayoutParam");
    }

    @Override // wd.e
    public final void onViewWillDetach() {
    }
}
