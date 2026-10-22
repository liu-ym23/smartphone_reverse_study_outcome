package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;

/* JADX INFO: loaded from: classes3.dex */
public final class ClassicTypeCheckerStateKt {
    public static final TypeCheckerState createClassicTypeCheckerState(boolean r10, boolean r11, ClassicTypeSystemContext r12, KotlinTypePreparator r13, KotlinTypeRefiner r14) {
        Intrinsics.checkNotNullParameter(r12, "typeSystemContext");
        Intrinsics.checkNotNullParameter(r13, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(r14, "kotlinTypeRefiner");
        return new TypeCheckerState(r10, r11, true, r12, r13, r14);
    }

    public static /* synthetic */ TypeCheckerState createClassicTypeCheckerState$default(boolean r10, boolean r11, ClassicTypeSystemContext r12, KotlinTypePreparator r13, KotlinTypeRefiner r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r11 = true;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r12 = SimpleClassicTypeSystemContext.INSTANCE;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r13 = KotlinTypePreparator.Default.INSTANCE;
    L12:
        if ((r15 & 16) == 0) goto L15;
        r14 = KotlinTypeRefiner.Default.INSTANCE;
    L15:
        return createClassicTypeCheckerState(r10, r11, r12, r13, r14);
    }
}
