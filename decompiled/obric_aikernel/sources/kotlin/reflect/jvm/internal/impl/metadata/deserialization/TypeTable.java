package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeTable {
    private final List<ProtoBuf.Type> types;

    public TypeTable(ProtoBuf.TypeTable r10) {
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        List<ProtoBuf.Type> r11 = r10.getTypeList();
        if (r10.hasFirstNullable() == false) goto L15;
        int r12 = r10.getFirstNullable();
        List<ProtoBuf.Type> r13 = r10.getTypeList();
        Intrinsics.checkNotNullExpressionValue(r13, "typeTable.typeList");
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        int r15 = 0;
        Iterator<T> r16 = r13.iterator();
    L6:
        if (r16.hasNext() == false) goto L14;
        Object r17 = r16.next();
        int r18 = r15 + 1;
        if (r15 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ProtoBuf.Type r19 = (ProtoBuf.Type) r17;
        if (r15 < r12) goto L13;
        r19 = r19.toBuilder().setNullable(true).build();
    L13:
        r14.add(r19);
        r15 = r18;
        goto L6
    L14:
        r11 = r14;
    L15:
        Intrinsics.checkNotNullExpressionValue(r11, "run {\n        val origin… else originalTypes\n    }");
        this.types = r11;
    }

    public final ProtoBuf.Type get(int r10) {
        return this.types.get(r10);
    }
}
