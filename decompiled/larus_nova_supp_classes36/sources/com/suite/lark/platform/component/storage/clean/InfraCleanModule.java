package com.suite.lark.platform.component.storage.clean;

import android.content.Context;
import com.suite.lark.platform.component.storage.clean.request.RemoteClearRequest;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InfraCleanModule implements j {

    public static final class a {
    }

    static {
    }

    @Inject
    public InfraCleanModule() {
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void a(Context r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "registry");
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void b(final Context r3, n r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "registry");
        Function1<CleanRequest.a<?, ?, ?>, Unit> r5 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new InfraCleanModule$registerResource$1(r3, this), 1);
        HashMap<Class<CleanRequest.a<?, ?, ?>>, ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>>> r6 = r4.a;
        ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>> r1 = r6.get(RemoteClearRequest.a.class);
        if (r1 != null) goto L5;
        r1 = new ArrayList();
        r6.put(RemoteClearRequest.a.class, r1);
    L5:
        r1.add(r5);
    }
}
