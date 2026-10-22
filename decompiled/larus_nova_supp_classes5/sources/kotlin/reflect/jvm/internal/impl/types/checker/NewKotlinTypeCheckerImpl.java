package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final OverridingUtil overridingUtil;

    public KotlinTypePreparator getKotlinTypePreparator() {
        return this.kotlinTypePreparator;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    public NewKotlinTypeCheckerImpl(KotlinTypeRefiner r2, KotlinTypePreparator r3) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(r3, "kotlinTypePreparator");
        this.kotlinTypeRefiner = r2;
        this.kotlinTypePreparator = r3;
        this.overridingUtil = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(KotlinType r9, KotlinType r10) {
        Intrinsics.checkNotNullParameter(r9, "a");
        Intrinsics.checkNotNullParameter(r10, "b");
        KotlinTypeRefiner r5 = getKotlinTypeRefiner();
        return equalTypes(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(false, false, null, getKotlinTypePreparator(), r5, 6, null), r9.unwrap(), r10.unwrap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(KotlinType r9, KotlinType r10) {
        Intrinsics.checkNotNullParameter(r9, "subtype");
        Intrinsics.checkNotNullParameter(r10, "supertype");
        KotlinTypeRefiner r5 = getKotlinTypeRefiner();
        return isSubtypeOf(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(true, false, null, getKotlinTypePreparator(), r5, 6, null), r9.unwrap(), r10.unwrap());
    }

    public final boolean equalTypes(TypeCheckerState r2, UnwrappedType r3, UnwrappedType r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "a");
        Intrinsics.checkNotNullParameter(r4, "b");
        return AbstractTypeChecker.INSTANCE.equalTypes(r2, r3, r4);
    }

    public final boolean isSubtypeOf(TypeCheckerState r9, UnwrappedType r10, UnwrappedType r11) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "subType");
        Intrinsics.checkNotNullParameter(r11, "superType");
        return AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, r9, r10, r11, false, 8, null);
    }

    public /* synthetic */ NewKotlinTypeCheckerImpl(KotlinTypeRefiner r1, KotlinTypePreparator r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = KotlinTypePreparator.Default.INSTANCE;
    L5:
        this(r1, r2);
    }
}
