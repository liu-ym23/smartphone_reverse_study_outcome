package com.obric.memorydata.memory.inapptrace;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class InAppEvidenceArchiveStore$summary$bytes$1 extends FunctionReferenceImpl implements Function1<File, Boolean> {
    public static final InAppEvidenceArchiveStore$summary$bytes$1 INSTANCE = null;

    static {
        INSTANCE = new InAppEvidenceArchiveStore$summary$bytes$1();
    }

    InAppEvidenceArchiveStore$summary$bytes$1() {
        super(1, File.class, "isFile", "isFile()Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(File r1) {
        Intrinsics.checkNotNullParameter(r1, "p0");
        return Boolean.valueOf(r1.isFile());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(File r3) {
        return invoke2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"));
    }
}
