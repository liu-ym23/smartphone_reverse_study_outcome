package com.obric.memorydata.union.build.export;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MemoryBuildDataPackageConfig$buildStringInClause$joined$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final MemoryBuildDataPackageConfig$buildStringInClause$joined$1 INSTANCE = null;

    static {
        INSTANCE = new MemoryBuildDataPackageConfig$buildStringInClause$joined$1();
    }

    MemoryBuildDataPackageConfig$buildStringInClause$joined$1() {
        super(1, StringsKt.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ String invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }
}
