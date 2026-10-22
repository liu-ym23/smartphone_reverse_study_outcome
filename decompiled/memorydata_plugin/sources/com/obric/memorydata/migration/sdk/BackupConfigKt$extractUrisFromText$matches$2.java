package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class BackupConfigKt$extractUrisFromText$matches$2 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public static final BackupConfigKt$extractUrisFromText$matches$2 INSTANCE = null;

    static {
        INSTANCE = new BackupConfigKt$extractUrisFromText$matches$2();
    }

    BackupConfigKt$extractUrisFromText$matches$2() {
        super(1, StringsKt.class, "isNotBlank", "isNotBlank(Ljava/lang/CharSequence;)Z", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return Boolean.valueOf(!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }
}
