package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: loaded from: classes3.dex */
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final OverridingUtil overridingUtil;

    public NewKotlinTypeCheckerImpl(KotlinTypeRefiner r5, KotlinTypePreparator r10) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(r10, "kotlinTypePreparator");
        this.kotlinTypeRefiner = r5;
        this.kotlinTypePreparator = r10;
        this.overridingUtil = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(KotlinType r10, KotlinType r11) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        KotlinTypeRefiner r5 = getKotlinTypeRefiner();
        return equalTypes(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(false, false, null, getKotlinTypePreparator(), r5, 6, null), r10.unwrap(), r11.unwrap());
    }

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

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(KotlinType r10, KotlinType r11) {
        Intrinsics.checkNotNullParameter(r10, "subtype");
        Intrinsics.checkNotNullParameter(r11, "supertype");
        KotlinTypeRefiner r5 = getKotlinTypeRefiner();
        return isSubtypeOf(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(true, false, null, getKotlinTypePreparator(), r5, 6, null), r10.unwrap(), r11.unwrap());
    }

    public final boolean equalTypes(TypeCheckerState r5, UnwrappedType r10, UnwrappedType r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        return AbstractTypeChecker.INSTANCE.equalTypes(r5, r10, r11);
    }

    public final boolean isSubtypeOf(TypeCheckerState r10, UnwrappedType r11, UnwrappedType r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "subType");
        Intrinsics.checkNotNullParameter(r12, "superType");
        return AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, r10, r11, r12, false, 8, null);
    }

    public /* synthetic */ NewKotlinTypeCheckerImpl(KotlinTypeRefiner r5, KotlinTypePreparator r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = KotlinTypePreparator.Default.INSTANCE;
    L5:
        this(r5, r10);
    }
}
