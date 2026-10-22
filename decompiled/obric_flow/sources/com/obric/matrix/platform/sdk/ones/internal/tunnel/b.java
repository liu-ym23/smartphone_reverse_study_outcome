package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.database.ContentObserver;
import android.net.Uri;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f11902b;

    public b() {
        Intrinsics.checkNotNullParameter("/location/status", "myPath");
        super(null);
        this.f11901a = "/location/status";
        this.f11902b = LazyKt.lazy(new MatrixEventObserver$myUri$2(this));
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r5, Uri r10) {
        super.onChange(r5, r10);
        Intrinsics.checkNotNullParameter("MatrixEventObserver", "tag");
        Intrinsics.checkNotNullParameter("onChange, ignore! uri: [" + r10 + "], registered: [false]", "msg");
    }
}
