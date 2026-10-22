package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
public final class PrimitiveTypeUtilKt {
    public static final Collection<KotlinType> getAllSignedLiteralTypes(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.listOf(new SimpleType[]{r10.getBuiltIns().getIntType(), r10.getBuiltIns().getLongType(), r10.getBuiltIns().getByteType(), r10.getBuiltIns().getShortType()});
    }
}
