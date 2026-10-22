package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.PrmContext;
import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends DistConfig {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f5038f;

    public c(String r10, k r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "json");
        super("lib", r10, r11);
        this.f5038f = StringsKt.startsWith$default(r10, "native_", false, 2, null);
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public void a(File r11, File r12) {
        Intrinsics.checkNotNullParameter(r11, "downloadRoot");
        Intrinsics.checkNotNullParameter(r12, "targetRoot");
        File r10 = new File(new File(r11, new b(g(), f(), 0, false, 12, null).m()), "checker_v2.json");
        if (r10.exists() == false) goto L6;
        com.obric.aikernel.res.utils.a r13 = com.obric.aikernel.res.utils.a.f5222a;
        String r14 = new File(r12, "checker_v2.json").getPath();
        Intrinsics.checkNotNullExpressionValue(r14, "File(targetRoot, BaseMetadata.CHECKER_FILE).path");
        r13.e(r10, r14);
        return;
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public List<b> d() {
        return CollectionsKt.listOf(new b(g(), f(), 0, false, 12, null));
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public boolean j(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        com.obric.aikernel.res.metadata.data.e r11 = new com.obric.aikernel.res.metadata.data.e(g(), i(), r10.getConfig());
        if (r11.n() == false) goto L5;
    L16:
        return true;
    L5:
        if (Intrinsics.areEqual(e(), "debug") == false) goto L15;
        DistConfig r12 = r11.s();
        if (r12 == null) goto L11;
        k r13 = r12.f();
        if (r13 == null) goto L11;
        String r14 = a.d(r13, "md5");
    L13:
        if (Intrinsics.areEqual(r14, a.d(f(), "md5")) == true) goto L15;
    L11:
        r14 = null;
    L15:
        return false;
    }

    public final boolean k() {
        return this.f5038f;
    }
}
