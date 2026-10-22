package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
public final class PrimitiveTypeUtilKt {
    public static final Collection<KotlinType> getAllSignedLiteralTypes(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return CollectionsKt.listOf(new SimpleType[]{r5.getBuiltIns().getIntType(), r5.getBuiltIns().getLongType(), r5.getBuiltIns().getByteType(), r5.getBuiltIns().getShortType()});
    }
}
