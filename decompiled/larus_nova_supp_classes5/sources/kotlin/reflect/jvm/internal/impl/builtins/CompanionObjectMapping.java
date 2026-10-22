package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class CompanionObjectMapping {
    public static final CompanionObjectMapping INSTANCE = null;
    private static final Set<ClassId> classIds = null;

    private CompanionObjectMapping() {
    }

    static {
        INSTANCE = new CompanionObjectMapping();
        Set<PrimitiveType> r0 = PrimitiveType.NUMBER_TYPES;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(StandardNames.getPrimitiveFqName((PrimitiveType) r2.next()));
        goto L4
    L6:
        List r3 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(r1, StandardNames.FqNames.string.toSafe()), StandardNames.FqNames._boolean.toSafe()), StandardNames.FqNames._enum.toSafe());
        LinkedHashSet r4 = new LinkedHashSet();
        ClassId.Companion r5 = ClassId.Companion;
        Iterator r6 = r3.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r4.add(r5.topLevel((FqName) r6.next()));
        goto L8
    L10:
        classIds = r4;
    }

    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        return classIds;
    }

    public final Set<ClassId> getClassIds() {
        return classIds;
    }
}
