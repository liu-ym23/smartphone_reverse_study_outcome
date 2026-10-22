package com.suite.lark.platform.component.storage.clean;

import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class e implements k {
    public static final /* synthetic */ int b = 0;
    public final Set<j> a;

    public static final class a {
    }

    static {
    }

    @Override // com.suite.lark.platform.component.storage.clean.k
    public final Set<j> a() {
        return this.a;
    }

    @Inject
    public e(Set<j> r2) {
        Intrinsics.checkNotNullParameter(r2, "cleanModules");
        this.a = r2;
    }
}
