package io.reactivex.disposables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes6.dex */
final class ActionDisposable extends ReferenceDisposable<io.reactivex.b.a> {
    private static final long serialVersionUID = -8219729196779211169L;

    ActionDisposable(io.reactivex.b.a r3) {
        super((io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.b.a.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(io.reactivex.b.a r2) {
        ((io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r2, io.reactivex.b.a.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw ExceptionHelper.a(th);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* synthetic */ void onDisposed(io.reactivex.b.a r3) {
        onDisposed2((io.reactivex.b.a) ZeusTransformUtils.preCheckCast(r3, io.reactivex.b.a.class, "com.obric.memorydata.plugin"));
    }
}
