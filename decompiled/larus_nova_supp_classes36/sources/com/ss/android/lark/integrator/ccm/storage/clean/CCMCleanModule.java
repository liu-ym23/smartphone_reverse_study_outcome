package com.ss.android.lark.integrator.ccm.storage.clean;

import android.content.Context;
import ay4.d;
import com.bytedance.ee.bear.diskmanager.dirs.CCMLarkDir;
import com.ss.android.lark.diskmanage.Biz;
import com.suite.lark.platform.component.storage.clean.CleanRequest;
import com.suite.lark.platform.component.storage.clean.h;
import com.suite.lark.platform.component.storage.clean.j;
import com.suite.lark.platform.component.storage.clean.n;
import com.suite.lark.platform.component.storage.clean.request.LogoutAllRequest;
import com.suite.lark.platform.component.storage.clean.request.RemoteClearRequest;
import com.suite.lark.platform.component.storage.clean.resource.FileCleanResource;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CCMCleanModule implements j {
    public static final Biz a = null;
    public static String b;

    public static final class a {
    }

    @Inject
    public CCMCleanModule() {
    }

    static {
        a = Biz.DOCS;
    }

    public static final void c(CCMCleanModule r3, CleanRequest.a r4) {
        r3.getClass();
        String r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("CCM_INTERNAL_FILES");
        r0 = null;
    L5:
        FileCleanResource r5 = new FileCleanResource(d.a().z(r0).subPath("docs").subPath("clip").toString(), a);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "res");
        throw null;
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void a(Context r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "registry");
        r3.a(new com.ss.android.lark.integrator.ccm.storage.clean.a());
    }

    @Override // com.suite.lark.platform.component.storage.clean.j
    public final void b(final Context r6, n r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "registry");
        b = ((CCMLarkDir) CCMLarkDir.c.getValue()).a(r6);
        ((CCMLarkDir) CCMLarkDir.b.getValue()).a(r6);
        ((CCMLarkDir) CCMLarkDir.d.getValue()).a(r6);
        ((CCMLarkDir) CCMLarkDir.e.getValue()).a(r6);
        Function1<CleanRequest.a<?, ?, ?>, Unit> r0 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new CCMCleanModule$registerResource$1(this, r6), 1);
        HashMap<Class<CleanRequest.a<?, ?, ?>>, ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>>> r2 = r7.a;
        ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>> r4 = r2.get(LogoutAllRequest.a.class);
        if (r4 != null) goto L5;
        r4 = new ArrayList();
        r2.put(LogoutAllRequest.a.class, r4);
    L5:
        r4.add(r0);
        Function1<CleanRequest.a<?, ?, ?>, Unit> r8 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new CCMCleanModule$registerResource$2(this, r6), 1);
        HashMap<Class<CleanRequest.a<?, ?, ?>>, ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>>> r9 = r7.a;
        ArrayList<Function1<CleanRequest.a<?, ?, ?>, Unit>> r1 = r9.get(RemoteClearRequest.a.class);
        if (r1 != null) goto L8;
        r1 = new ArrayList();
        r9.put(RemoteClearRequest.a.class, r1);
    L8:
        r1.add(r8);
    }
}
