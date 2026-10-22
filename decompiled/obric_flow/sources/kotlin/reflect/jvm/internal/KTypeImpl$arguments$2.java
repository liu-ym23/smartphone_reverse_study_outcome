package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nKTypeImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KTypeImpl.kt\nkotlin/reflect/jvm/internal/KTypeImpl$arguments$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,136:1\n1559#2:137\n1590#2,4:138\n*S KotlinDebug\n*F\n+ 1 KTypeImpl.kt\nkotlin/reflect/jvm/internal/KTypeImpl$arguments$2\n*L\n81#1:137\n81#1:138,4\n*E\n"})
public final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends KTypeProjection>> {
    final /* synthetic */ Function0<Type> $computeJavaType;
    final /* synthetic */ KTypeImpl this$0;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Variance.values().length];
            r5[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KTypeImpl$arguments$2(KTypeImpl r5, Function0<? extends Type> r10) {
        this.this$0 = r5;
        this.$computeJavaType = r10;
        super(0);
    }

    public static final /* synthetic */ List access$invoke$lambda$0(Lazy r5) {
        return invoke$lambda$0(r5);
    }

    private static final List<Type> invoke$lambda$0(Lazy<? extends List<? extends Type>> r5) {
        return (List) r5.getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends KTypeProjection> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends KTypeProjection> invoke2() {
        List<TypeProjection> r5 = this.this$0.getType().getArguments();
        if (r5.isEmpty() == true) goto L5;
        LazyThreadSafetyMode r10 = LazyThreadSafetyMode.PUBLICATION;
        final KTypeImpl r11 = this.this$0;
        final Lazy r12 = LazyKt.lazy(r10, new KTypeImpl$arguments$2$parameterizedTypeArguments$2(r11));
        Function0<Type> r13 = this.$computeJavaType;
        final KTypeImpl r14 = this.this$0;
        ArrayList r15 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r16 = r5.iterator();
        final int r17 = 0;
    L8:
        if (r16.hasNext() == false) goto L31;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        TypeProjection r20 = (TypeProjection) r18;
        if (r20.isStarProjection() == false) goto L15;
        KTypeProjection r21 = KTypeProjection.Companion.getSTAR();
    L30:
        r15.add(r21);
        r17 = r19;
        goto L8
    L15:
        KotlinType r22 = r20.getType();
        if (r13 != null) goto L18;
        Function0<Type> r23 = null;
    L19:
        KTypeImpl r24 = new KTypeImpl(r22, r23);
        Variance r25 = r20.getProjectionKind();
        int r26 = WhenMappings.$EnumSwitchMapping$0[r25.ordinal()];
        if (r26 != 1) goto L22;
        r21 = KTypeProjection.Companion.invariant(r24);
        goto L30
    L22:
        if (r26 != 2) goto L24;
        r21 = KTypeProjection.Companion.contravariant(r24);
        goto L30
    L24:
        if (r26 != 3) goto L27;
        r21 = KTypeProjection.Companion.covariant(r24);
        goto L30
    L27:
        throw new NoWhenBranchMatchedException();
    L18:
        r23 = new KTypeImpl$arguments$2$1$type$1(r14, r17, r12);
        goto L19
    L31:
        return r15;
    L5:
        return CollectionsKt.emptyList();
    }
}
