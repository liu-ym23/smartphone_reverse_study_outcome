package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/TypeTable;", "", "typeTable", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeTable;", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$TypeTable;)V", "types", "", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type;", "getTypes", "()Ljava/util/List;", "get", "index", "", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public final List<ProtoBuf.Type> getTypes() {
        return this.types;
    }
}
