package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTypeTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeTable.kt\norg/jetbrains/kotlin/metadata/deserialization/TypeTable\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1559#2:37\n1590#2,4:38\n*S KotlinDebug\n*F\n+ 1 TypeTable.kt\norg/jetbrains/kotlin/metadata/deserialization/TypeTable\n*L\n26#1:37\n26#1:38,4\n*E\n"})
public final class TypeTable {
    private final List<ProtoBuf.Type> types;

    public TypeTable(ProtoBuf.TypeTable r10) {
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        List<ProtoBuf.Type> r5 = r10.getTypeList();
        if (r10.hasFirstNullable() == false) goto L15;
        int r11 = r10.getFirstNullable();
        List<ProtoBuf.Type> r12 = r10.getTypeList();
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r14 = r12.iterator();
        int r15 = 0;
    L6:
        if (r14.hasNext() == false) goto L14;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ProtoBuf.Type r18 = (ProtoBuf.Type) r16;
        if (r15 < r11) goto L13;
        r18 = r18.toBuilder().setNullable(true).build();
    L13:
        r13.add(r18);
        r15 = r17;
        goto L6
    L14:
        r5 = r13;
    L15:
        this.types = r5;
    }

    public final ProtoBuf.Type get(int r5) {
        return this.types.get(r5);
    }
}
