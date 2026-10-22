package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends KTypeProjection>> {
    final /* synthetic */ Function0<Type> $computeJavaType;
    final /* synthetic */ KTypeImpl this$0;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[Variance.values().length];
            r10[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    KTypeImpl$arguments$2(KTypeImpl r10, Function0<? extends Type> r11) {
        this.this$0 = r10;
        this.$computeJavaType = r11;
        super(0);
    }

    public static final /* synthetic */ List access$invoke$lambda$0(Lazy r10) {
        return invoke$lambda$0(r10);
    }

    private static final List<Type> invoke$lambda$0(Lazy<? extends List<? extends Type>> r10) {
        return (List) r10.getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends KTypeProjection> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends KTypeProjection> invoke2() {
        List<TypeProjection> r10 = this.this$0.getType().getArguments();
        if (r10.isEmpty() == true) goto L5;
        LazyThreadSafetyMode r11 = LazyThreadSafetyMode.PUBLICATION;
        final KTypeImpl r12 = this.this$0;
        final Lazy r13 = LazyKt.lazy(r11, new KTypeImpl$arguments$2$parameterizedTypeArguments$2(r12));
        Function0<Type> r14 = this.$computeJavaType;
        final KTypeImpl r15 = this.this$0;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        final int r17 = 0;
        Iterator<T> r18 = r10.iterator();
    L8:
        if (r18.hasNext() == false) goto L31;
        Object r19 = r18.next();
        int r20 = r17 + 1;
        if (r17 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        TypeProjection r21 = (TypeProjection) r19;
        if (r21.isStarProjection() == false) goto L15;
        KTypeProjection r22 = KTypeProjection.Companion.getSTAR();
    L30:
        r16.add(r22);
        r17 = r20;
        goto L8
    L15:
        KotlinType r23 = r21.getType();
        Intrinsics.checkNotNullExpressionValue(r23, "typeProjection.type");
        if (r14 != null) goto L18;
        Function0<Type> r24 = null;
    L19:
        KTypeImpl r25 = new KTypeImpl(r23, r24);
        Variance r26 = r21.getProjectionKind();
        int r27 = WhenMappings.$EnumSwitchMapping$0[r26.ordinal()];
        if (r27 != 1) goto L22;
        r22 = KTypeProjection.Companion.invariant(r25);
        goto L30
    L22:
        if (r27 != 2) goto L24;
        r22 = KTypeProjection.Companion.contravariant(r25);
        goto L30
    L24:
        if (r27 != 3) goto L27;
        r22 = KTypeProjection.Companion.covariant(r25);
        goto L30
    L27:
        throw new NoWhenBranchMatchedException();
    L18:
        r24 = new KTypeImpl$arguments$2$1$type$1(r15, r17, r13);
        goto L19
    L31:
        return r16;
    L5:
        return CollectionsKt.emptyList();
    }
}
