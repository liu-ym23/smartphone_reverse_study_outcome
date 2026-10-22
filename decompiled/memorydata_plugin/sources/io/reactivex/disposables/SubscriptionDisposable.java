package io.reactivex.disposables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
final class SubscriptionDisposable extends ReferenceDisposable<d> {
    private static final long serialVersionUID = -707001650852963139L;

    SubscriptionDisposable(d r3) {
        super((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* synthetic */ void onDisposed(d r3) {
        onDisposed2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(d r2) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin")).cancel();
    }
}
