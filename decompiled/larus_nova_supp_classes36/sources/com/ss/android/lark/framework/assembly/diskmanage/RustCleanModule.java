package com.ss.android.lark.framework.assembly.diskmanage;

import android.content.Context;
import com.bytedance.lark.rustclient.api.h;
import com.suite.lark.platform.component.storage.clean.CleanRequest;
import com.suite.lark.platform.component.storage.clean.j;
import com.suite.lark.platform.component.storage.clean.m;
import com.suite.lark.platform.component.storage.clean.n;
import com.suite.lark.platform.component.storage.clean.request.LogoutAllRequest;
import com.suite.lark.platform.component.storage.clean.request.RemoteClearRequest;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RustCleanModule implements j {
    public final h a;

    public static final class a implements m<RustResource> {
        public final h a;

        @Override // com.suite.lark.platform.component.storage.clean.m
        public final Class<RustResource> a() {
            return RustResource.class;
        }

        public a(h r2) {
            Intrinsics.checkNotNullParameter(r2, "rustClient");
            this.a = r2;
        }
    }

    @Inject
    public RustCleanModule(h r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    public static final void c(RustCleanModule r1, CleanRequest.a r2) {
        r1.getClass();
        new ArrayList(CollectionsKt.collectionSizeOrDefault(null, 10));
        throw null;
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void a(Context r2, com.suite.lark.platform.component.storage.clean.h r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "registry");
        r3.a(new a(this.a));
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void b(Context r5, n r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "registry");
        Function1<CleanRequest.a<?, ?, ?>, Unit> r7 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new RustCleanModule$registerResource$1(this), 1);
        HashMap<Class<CleanRequest.a<?, ?, ?>>, ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>>> r1 = r6.a;
        ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>> r3 = r1.get(LogoutAllRequest.a.class);
        if (r3 != null) goto L5;
        r3 = new ArrayList();
        r1.put(LogoutAllRequest.a.class, r3);
    L5:
        r3.add(r7);
        Function1<CleanRequest.a<?, ?, ?>, Unit> r8 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new RustCleanModule$registerResource$2(this), 1);
        HashMap<Class<CleanRequest.a<?, ?, ?>>, ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>>> r9 = r6.a;
        ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>> r2 = r9.get(RemoteClearRequest.a.class);
        if (r2 != null) goto L8;
        r2 = new ArrayList();
        r9.put(RemoteClearRequest.a.class, r2);
    L8:
        r2.add(r8);
    }
}
