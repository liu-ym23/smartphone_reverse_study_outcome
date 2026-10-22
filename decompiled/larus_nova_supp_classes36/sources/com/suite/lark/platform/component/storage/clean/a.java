package com.suite.lark.platform.component.storage.clean;

import android.content.Context;
import com.suite.lark.platform.component.storage.clean.request.ResetAllRequest;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements j {
    public final Provider<Set<l>> a;

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void b(Context r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "registry");
    }

    @Inject
    public a(Provider<Set<l>> r2) {
        Intrinsics.checkNotNullParameter(r2, "eraserProvider");
        this.a = r2;
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void a(Context r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "registry");
        Iterator r4 = ((Iterable) this.a.get()).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.a(((l) r4.next()).a());
        goto L4
    L6:
        r3.a(new uoc.c());
        r3.a(new uoc.a());
        r3.a(new ResetAllRequest.b());
        r3.a(new uoc.e());
        r3.a(new uoc.d());
        r3.a(new uoc.b());
    }
}
