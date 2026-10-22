package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public final class CapturedTypeConstructorKt {
    public static final /* synthetic */ TypeProjection access$createCapturedIfNeeded(TypeProjection r10, TypeParameterDescriptor r11) {
        return createCapturedIfNeeded(r10, r11);
    }

    private static final TypeProjection createCapturedIfNeeded(final TypeProjection r10, TypeParameterDescriptor r11) {
        if (r11 != null) goto L4;
    L15:
        return r10;
    L4:
        if (r10.getProjectionKind() == Variance.INVARIANT) goto L15;
        if (r11.getVariance() != r10.getProjectionKind()) goto L14;
        if (r10.isStarProjection() == false) goto L12;
        StorageManager r12 = LockBasedStorageManager.NO_LOCKS;
        Intrinsics.checkNotNullExpressionValue(r12, "NO_LOCKS");
        return new TypeProjectionImpl(new LazyWrappedType(r12, new AnonymousClass1(r10)));
    L12:
        return new TypeProjectionImpl(r10.getType());
    L14:
        return new TypeProjectionImpl(createCapturedType(r10));
    }

    public static final KotlinType createCapturedType(TypeProjection r10) {
        Intrinsics.checkNotNullParameter(r10, "typeProjection");
        return new CapturedType(r10, null, false, null, 14, null);
    }

    public static final boolean isCaptured(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getConstructor() instanceof CapturedTypeConstructor;
    }

    public static final TypeSubstitution wrapWithCapturingSubstitution(final TypeSubstitution r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof IndexedParametersSubstitution) == false) goto L10;
        IndexedParametersSubstitution r12 = (IndexedParametersSubstitution) r10;
        TypeParameterDescriptor[] r13 = r12.getParameters();
        List r14 = ArraysKt.zip(r12.getArguments(), r12.getParameters());
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        Pair r17 = (Pair) r16.next();
        r15.add(createCapturedIfNeeded((TypeProjection) r17.getFirst(), (TypeParameterDescriptor) r17.getSecond()));
        goto L6
    L8:
        Object[] r18 = r15.toArray(new TypeProjection[0]);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new IndexedParametersSubstitution(r13, (TypeProjection[]) r18, r11);
    L10:
        return new AnonymousClass2(r10, r11);
    }

    public static /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = true;
    L6:
        return wrapWithCapturingSubstitution(r10, r11);
    }
}
