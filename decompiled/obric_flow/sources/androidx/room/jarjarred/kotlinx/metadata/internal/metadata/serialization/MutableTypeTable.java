package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0014¨\u0006\u000b"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/MutableTypeTable;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/MutableTable;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type$Builder;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeTable;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeTable$Builder;", "()V", "addElement", "", "builder", "element", "createTableBuilder", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MutableTypeTable extends MutableTable<ProtoBuf.Type.Builder, ProtoBuf.TypeTable, ProtoBuf.TypeTable.Builder> {
    public MutableTypeTable() {
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.MutableTable
    public /* bridge */ /* synthetic */ void addElement(GeneratedMessageLite.Builder r5, GeneratedMessageLite.Builder r10) {
        addElement((ProtoBuf.TypeTable.Builder) r5, (ProtoBuf.Type.Builder) r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.MutableTable
    public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder createTableBuilder() {
        return createTableBuilder();
    }

    public void addElement(ProtoBuf.TypeTable.Builder r5, ProtoBuf.Type.Builder r10) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        Intrinsics.checkNotNullParameter(r10, "element");
        r5.addType(r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.MutableTable
    public ProtoBuf.TypeTable.Builder createTableBuilder() {
        return ProtoBuf.TypeTable.newBuilder();
    }
}
