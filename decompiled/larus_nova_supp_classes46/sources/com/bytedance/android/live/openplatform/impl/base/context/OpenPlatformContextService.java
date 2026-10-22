package com.bytedance.android.live.openplatform.impl.base.context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.openplatform.impl.base.utils.a;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0017J\b\u0010\f\u001a\u00020\u0003H\u0017J\t\u0010\r\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\r\u0010\u0011\u001a\u00020\u0003*\u00020\u000eH\u0096\u0001R\u001a\u0010\u0013\u001a\u00020\u00128\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Landroidx/lifecycle/LifecycleEventObserver;", "", "", "init$liveopenplatform_impl_saasRelease", "()V", "init", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "onDestroy", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "getOpenPlatformContext", "()Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OpenPlatformContextService implements LifecycleEventObserver {
    private final /* synthetic */ a $$delegate_0;
    private final OpenPlatformContext openPlatformContext;

    public void autoDispose(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.$$delegate_0.a(r2);
    }

    public void dispose() {
        this.$$delegate_0.b();
    }

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.$$delegate_0.c(r2);
    }

    public final void init$liveopenplatform_impl_saasRelease() {
        this.openPlatformContext.getLifecycle().addObserver(this);
    }

    public final OpenPlatformContext getOpenPlatformContext() {
        return this.openPlatformContext;
    }

    public void onDestroy() {
        dispose();
    }

    public OpenPlatformContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        this.$$delegate_0 = new a();
        this.openPlatformContext = r2;
    }

    public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3 != Lifecycle.Event.ON_DESTROY) goto L6;
        onDestroy();
        r2.getLifecycle().removeObserver(this);
        return;
    }
}
