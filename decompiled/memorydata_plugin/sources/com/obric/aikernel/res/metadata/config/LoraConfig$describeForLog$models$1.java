package com.obric.aikernel.res.metadata.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "model", "Lcom/obric/aikernel/res/metadata/config/ModelConfig;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class LoraConfig$describeForLog$models$1 extends Lambda implements Function1<h, CharSequence> {
    public static final LoraConfig$describeForLog$models$1 INSTANCE = null;

    static {
        INSTANCE = new LoraConfig$describeForLog$models$1();
    }

    LoraConfig$describeForLog$models$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(h r12) {
        Intrinsics.checkNotNullParameter(r12, "model");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r12.a() + '@' + r12.c() + ":downloads=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12.e(), Iterable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(LoraConfig$describeForLog$models$1$downloads$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 25, null), CharSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ CharSequence invoke(h r3) {
        return invoke2((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin"));
    }
}
