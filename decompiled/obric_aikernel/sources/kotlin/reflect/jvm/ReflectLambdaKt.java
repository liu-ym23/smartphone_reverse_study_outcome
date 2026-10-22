package kotlin.reflect.jvm;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.EmptyContainerForLocal;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectLambdaKt {
    @ExperimentalReflectionOnLambdas
    public static final <R> KFunction<R> reflect(Function<? extends R> r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Metadata r10 = (Metadata) r12.getClass().getAnnotation(Metadata.class);
        if (r10 != null) goto L5;
        return null;
    L5:
        String[] r11 = r10.d1();
        boolean r13 = true;
        if (r11.length != 0) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == false) goto L12;
        r11 = null;
    L12:
        if (r11 != null) goto L14;
        return null;
    L14:
        Pair<JvmNameResolver, ProtoBuf.Function> r15 = JvmProtoBufUtil.readFunctionDataFrom(r11, r10.d2());
        JvmNameResolver r16 = r15.component1();
        ProtoBuf.Function r17 = r15.component2();
        int[] r18 = r10.mv();
        if ((r10.xi() & 8) != 0) goto L18;
        r13 = false;
    L18:
        JvmMetadataVersion r19 = new JvmMetadataVersion(r18, r13);
        Class<?> r20 = r12.getClass();
        ProtoBuf.TypeTable r110 = r17.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r110, "proto.typeTable");
        return new KFunctionImpl(EmptyContainerForLocal.INSTANCE, (SimpleFunctionDescriptor) UtilKt.deserializeToDescriptor(r20, r17, r16, new TypeTable(r110), r19, ReflectLambdaKt$reflect$descriptor$1.INSTANCE));
    L8:
        r14 = false;
        goto L9
    }
}
