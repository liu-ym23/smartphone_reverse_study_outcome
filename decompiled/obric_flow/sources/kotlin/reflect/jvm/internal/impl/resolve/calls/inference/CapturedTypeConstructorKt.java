package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCapturedTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CapturedTypeConstructor.kt\norg/jetbrains/kotlin/resolve/calls/inference/CapturedTypeConstructorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,153:1\n1549#2:154\n1620#2,3:155\n37#3,2:158\n*S KotlinDebug\n*F\n+ 1 CapturedTypeConstructor.kt\norg/jetbrains/kotlin/resolve/calls/inference/CapturedTypeConstructorKt\n*L\n125#1:154\n125#1:155,3\n127#1:158,2\n*E\n"})
public final class CapturedTypeConstructorKt {
    public static final /* synthetic */ TypeProjection access$createCapturedIfNeeded(TypeProjection r5, TypeParameterDescriptor r10) {
        return createCapturedIfNeeded(r5, r10);
    }

    private static final TypeProjection createCapturedIfNeeded(final TypeProjection r5, TypeParameterDescriptor r10) {
        if (r10 != null) goto L4;
    L15:
        return r5;
    L4:
        if (r5.getProjectionKind() == Variance.INVARIANT) goto L15;
        if (r10.getVariance() != r5.getProjectionKind()) goto L14;
        if (r5.isStarProjection() == false) goto L12;
        return new TypeProjectionImpl(new LazyWrappedType(LockBasedStorageManager.NO_LOCKS, new AnonymousClass1(r5)));
    L12:
        return new TypeProjectionImpl(r5.getType());
    L14:
        return new TypeProjectionImpl(createCapturedType(r5));
    }

    public static final KotlinType createCapturedType(TypeProjection r10) {
        Intrinsics.checkNotNullParameter(r10, "typeProjection");
        CapturedTypeConstructor r5 = null;
        boolean r11 = false;
        TypeAttributes r12 = null;
        return new CapturedType(r10, r5, r11, r12, 14, null);
    }

    public static final boolean isCaptured(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getConstructor() instanceof CapturedTypeConstructor;
    }

    public static final TypeSubstitution wrapWithCapturingSubstitution(final TypeSubstitution r5, final boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof IndexedParametersSubstitution) == false) goto L10;
        IndexedParametersSubstitution r11 = (IndexedParametersSubstitution) r5;
        TypeParameterDescriptor[] r12 = r11.getParameters();
        List r13 = ArraysKt.zip(r11.getArguments(), r11.getParameters());
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator r15 = r13.iterator();
    L6:
        if (r15.hasNext() == false) goto L12;
        Pair r16 = (Pair) r15.next();
        r14.add(createCapturedIfNeeded((TypeProjection) r16.getFirst(), (TypeParameterDescriptor) r16.getSecond()));
        goto L6
    L12:
        return new IndexedParametersSubstitution(r12, (TypeProjection[]) r14.toArray(new TypeProjection[0]), r10);
    L10:
        return new AnonymousClass2(r5, r10);
    }

    public static /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution r5, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = true;
    L6:
        return wrapWithCapturingSubstitution(r5, r10);
    }
}
