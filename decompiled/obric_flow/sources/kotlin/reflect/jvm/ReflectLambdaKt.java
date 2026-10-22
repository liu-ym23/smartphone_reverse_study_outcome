package kotlin.reflect.jvm;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nreflectLambda.kt\nKotlin\n*S Kotlin\n*F\n+ 1 reflectLambda.kt\nkotlin/reflect/jvm/ReflectLambdaKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
public final class ReflectLambdaKt {
    @ExperimentalReflectionOnLambdas
    public static final <R> KFunction<R> reflect(Function<? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Metadata r5 = (Metadata) r10.getClass().getAnnotation(Metadata.class);
        if (r5 != null) goto L5;
        return null;
    L5:
        String[] r11 = r5.d1();
        if (r11.length != 0) goto L8;
        r11 = null;
    L8:
        if (r11 != null) goto L10;
        return null;
    L10:
        Pair<JvmNameResolver, ProtoBuf.Function> r12 = JvmProtoBufUtil.readFunctionDataFrom(r11, r5.d2());
        JvmNameResolver r13 = r12.component1();
        ProtoBuf.Function r14 = r12.component2();
        int[] r15 = r5.mv();
        if ((r5.xi() & 8) == 0) goto L13;
        boolean r16 = true;
    L15:
        return new KFunctionImpl(EmptyContainerForLocal.INSTANCE, (SimpleFunctionDescriptor) UtilKt.deserializeToDescriptor(r10.getClass(), r14, r13, new TypeTable(r14.getTypeTable()), new JvmMetadataVersion(r15, r16), ReflectLambdaKt$reflect$descriptor$1.INSTANCE));
    L13:
        r16 = false;
        goto L15
    }
}
