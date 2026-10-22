package com.larus.common.account.platform.larklogin;

import com.larus.platform.service.h1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class LarkEntryActivityKt$handleLarkEntry$3 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public LarkEntryActivityKt$handleLarkEntry$3(Object r8) {
        super(1, r8, h1.class, "handleOfficeSdkPassportAppLink", "handleOfficeSdkPassportAppLink(Ljava/lang/String;)Z", 0);
    }

    public final Boolean invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return Boolean.valueOf(((h1) ((CallableReference) this).receiver).a(r2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
