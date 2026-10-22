package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class TypeTable {
    private final List<ProtoBuf$Type> types;

    public TypeTable(ProtoBuf$TypeTable r6) {
        Intrinsics.checkNotNullParameter(r6, "typeTable");
        List<ProtoBuf$Type> r0 = r6.getTypeList();
        if (r6.hasFirstNullable() == false) goto L15;
        int r1 = r6.getFirstNullable();
        List<ProtoBuf$Type> r7 = r6.getTypeList();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
        int r3 = 0;
    L6:
        if (r8.hasNext() == false) goto L14;
        Object r4 = r8.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ProtoBuf$Type r9 = (ProtoBuf$Type) r4;
        if (r3 < r1) goto L13;
        r9 = r9.mo380toBuilder().setNullable(true).build();
    L13:
        r2.add(r9);
        r3 = r5;
        goto L6
    L14:
        r0 = r2;
    L15:
        this.types = r0;
    }

    public final ProtoBuf$Type get(int r2) {
        return (ProtoBuf$Type) ListProtector.get(this.types, r2);
    }
}
