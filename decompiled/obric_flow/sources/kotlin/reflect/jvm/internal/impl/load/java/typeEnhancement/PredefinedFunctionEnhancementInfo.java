package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PredefinedFunctionEnhancementInfo {
    private final List<TypeEnhancementInfo> parametersInfo;
    private final TypeEnhancementInfo returnTypeInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public PredefinedFunctionEnhancementInfo() {
        Object[] r5 = 0 == true ? 1 : 0;
        this(null, r5, 3, 0 == true ? 1 : 0);
    }

    public final List<TypeEnhancementInfo> getParametersInfo() {
        return this.parametersInfo;
    }

    public final TypeEnhancementInfo getReturnTypeInfo() {
        return this.returnTypeInfo;
    }

    public PredefinedFunctionEnhancementInfo(TypeEnhancementInfo r5, List<TypeEnhancementInfo> r10) {
        Intrinsics.checkNotNullParameter(r10, "parametersInfo");
        this.returnTypeInfo = r5;
        this.parametersInfo = r10;
    }

    public /* synthetic */ PredefinedFunctionEnhancementInfo(TypeEnhancementInfo r5, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = CollectionsKt.emptyList();
    L8:
        this(r5, r10);
    }
}
