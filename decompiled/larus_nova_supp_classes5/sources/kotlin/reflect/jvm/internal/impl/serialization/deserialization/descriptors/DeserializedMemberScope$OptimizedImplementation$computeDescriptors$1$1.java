package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 implements Function0 {
    final /* synthetic */ ByteArrayInputStream $inputStream;
    final /* synthetic */ Parser $parser;
    final /* synthetic */ DeserializedMemberScope this$0;

    public DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(Parser r1, ByteArrayInputStream r2, DeserializedMemberScope r3) {
        this.$parser = r1;
        this.$inputStream = r2;
        this.this$0 = r3;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final MessageLite m384invoke() {
        return (MessageLite) this.$parser.parseDelimitedFrom(this.$inputStream, this.this$0.getC().getComponents().getExtensionRegistryLite());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m384invoke();
    }
}
