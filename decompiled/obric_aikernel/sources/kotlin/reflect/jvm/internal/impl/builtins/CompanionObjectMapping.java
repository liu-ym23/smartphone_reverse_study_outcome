package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class CompanionObjectMapping {
    public static final CompanionObjectMapping INSTANCE = null;
    private static final Set<ClassId> classIds = null;

    static {
        INSTANCE = new CompanionObjectMapping();
        Set<PrimitiveType> r10 = PrimitiveType.NUMBER_TYPES;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(StandardNames.getPrimitiveFqName((PrimitiveType) r12.next()));
        goto L4
    L6:
        FqName r13 = StandardNames.FqNames.string.toSafe();
        Intrinsics.checkNotNullExpressionValue(r13, "string.toSafe()");
        List r14 = CollectionsKt.plus(r11, r13);
        FqName r15 = StandardNames.FqNames._boolean.toSafe();
        Intrinsics.checkNotNullExpressionValue(r15, "_boolean.toSafe()");
        List r16 = CollectionsKt.plus(r14, r15);
        FqName r17 = StandardNames.FqNames._enum.toSafe();
        Intrinsics.checkNotNullExpressionValue(r17, "_enum.toSafe()");
        List r18 = CollectionsKt.plus(r16, r17);
        LinkedHashSet r19 = new LinkedHashSet();
        Iterator r20 = r18.iterator();
    L8:
        if (r20.hasNext() == false) goto L10;
        r19.add(ClassId.topLevel((FqName) r20.next()));
        goto L8
    L10:
        classIds = r19;
    }

    private CompanionObjectMapping() {
    }

    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        return classIds;
    }

    public final Set<ClassId> getClassIds() {
        return classIds;
    }
}
