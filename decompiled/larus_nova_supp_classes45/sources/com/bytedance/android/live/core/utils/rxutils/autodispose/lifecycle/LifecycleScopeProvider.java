package com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle;

import com.bytedance.android.live.core.utils.rxutils.autodispose.ScopeProvider;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import m80.a;
import m80.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface LifecycleScopeProvider<E> extends ScopeProvider {

    /* JADX INFO: renamed from: com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleScopeProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<E> {
        public static CompletableSource $default$requestScope(LifecycleScopeProvider r0) {
            return e.a(r0);
        }
    }

    @CheckReturnValue
    a<E> correspondingEvents();

    @CheckReturnValue
    Observable<E> lifecycle();

    E peekLifecycle();

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ScopeProvider
    CompletableSource requestScope();
}
