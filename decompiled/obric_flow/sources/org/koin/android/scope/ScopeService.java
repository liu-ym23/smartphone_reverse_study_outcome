package org.koin.android.scope;

import android.app.Service;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lorg/koin/android/scope/ScopeService;", "Landroid/app/Service;", "Lorg/koin/android/scope/a;", "<init>", "()V", "koin-android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ScopeService extends Service implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f20990a;

    public ScopeService() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.f20990a = LazyKt.lazy(new ServiceExtKt$serviceScope$1(this));
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        if (t() == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Required value was null.");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        Intrinsics.checkNotNullParameter(this, "<this>");
        t().a();
    }

    @Override // org.koin.android.scope.a
    public final org.koin.core.scope.a t() {
        return (org.koin.core.scope.a) this.f20990a.getValue();
    }
}
