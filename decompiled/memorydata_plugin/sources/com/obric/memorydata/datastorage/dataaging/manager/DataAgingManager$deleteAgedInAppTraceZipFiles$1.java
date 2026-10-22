package com.obric.memorydata.datastorage.dataaging.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class DataAgingManager$deleteAgedInAppTraceZipFiles$1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public static final DataAgingManager$deleteAgedInAppTraceZipFiles$1 INSTANCE = null;

    static {
        INSTANCE = new DataAgingManager$deleteAgedInAppTraceZipFiles$1();
    }

    DataAgingManager$deleteAgedInAppTraceZipFiles$1() {
        super(1, StringsKt.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r1 = true;
    L7:
        return Boolean.valueOf(r1);
    L5:
        r1 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }
}
