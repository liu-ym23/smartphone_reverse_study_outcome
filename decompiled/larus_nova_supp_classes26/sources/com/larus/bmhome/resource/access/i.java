package com.larus.bmhome.resource.access;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i extends DelegatingResourceNode {
    public i(List<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "dependsOn");
        super("post_process", ResourcePhase.POST_PROCESS, r8, false, 24);
    }
}
