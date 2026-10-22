package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.data.AIPackage;
import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends DistConfig {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5042f;

    public f(String r10, k r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "json");
        Intrinsics.checkNotNullParameter(r12, "packageVersion");
        super("package", r10, r11);
        this.f5042f = r12;
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
        if (Intrinsics.areEqual(this.f5042f, "debug") == false) goto L5;
    L8:
        return true;
    L5:
        if (new AIPackage(g(), this.f5042f, r10.getConfig()).n() == true) goto L8;
        return false;
    }
}
