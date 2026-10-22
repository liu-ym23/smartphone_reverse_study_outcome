package com.larus.bmhome.block.pipeline.api;

import java.util.List;
import kc8.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class IBlockPipelineTask$a {
    public static void a(f r1, List r2, List r3) {
        Intrinsics.checkNotNullParameter(r1, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r2, "sourceBlockList");
        Intrinsics.checkNotNullParameter(r3, "bizModelList");
    }

    public static void b(f r1, List r2) {
        Intrinsics.checkNotNullParameter(r1, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r2, "bizModelList");
    }

    public static void c(f r1, List r2) {
        Intrinsics.checkNotNullParameter(r1, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r2, "blockList");
    }
}
