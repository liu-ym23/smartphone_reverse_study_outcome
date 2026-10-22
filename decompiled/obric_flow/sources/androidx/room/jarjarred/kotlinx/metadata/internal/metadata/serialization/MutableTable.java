package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u00010\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\u0014\b\u0002\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\u00022\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00022\u0006\u0010\u000e\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u00028\u0002H$¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0015J\r\u0010\u0016\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0017R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/MutableTable;", "Element", "Landroidx/room/jarjarred/kotlinx/metadata/internal/protobuf/GeneratedMessageLite$Builder;", "Table", "Landroidx/room/jarjarred/kotlinx/metadata/internal/protobuf/GeneratedMessageLite;", "TableBuilder", "", "()V", "interner", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/Interner;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/TableElementWrapper;", "addElement", "", "builder", "element", "(Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;)V", "createTableBuilder", "()Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;", "get", "", "type", "(Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;)I", "serialize", "()Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite;", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class MutableTable<Element extends GeneratedMessageLite.Builder<?, Element>, Table extends GeneratedMessageLite, TableBuilder extends GeneratedMessageLite.Builder<Table, TableBuilder>> {
    private final Interner<TableElementWrapper<Element>> interner;

    public MutableTable() {
        this.interner = new Interner(null, 1, null);
    }

    public abstract void addElement(TableBuilder r5, Element r10);

    public abstract TableBuilder createTableBuilder();

    public final int get(Element r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return this.interner.intern(new TableElementWrapper(r5));
    }

    public final Table serialize() {
        if (this.interner.isEmpty() == false) goto L5;
        return null;
    L5:
        GeneratedMessageLite.Builder r5 = createTableBuilder();
        Iterator<TableElementWrapper<Element>> r10 = this.interner.getAllInternedObjects().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        addElement(r5, r10.next().getBuilder());
        goto L7
    L9:
        MessageLite r11 = r5.build();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type Table of org.jetbrains.kotlin.metadata.serialization.MutableTable");
        return (Table) r11;
    }
}
