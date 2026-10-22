package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0012\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\rH\u0016J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010)H\u0096\u0002J\b\u0010*\u001a\u00020+H\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0010¨\u0006,"}, d2 = {"Landroidx/compose/runtime/SlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "table", "Landroidx/compose/runtime/SlotTable;", "group", "", "version", "(Landroidx/compose/runtime/SlotTable;II)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "data", "", "getData", "getGroup", "()I", "groupSize", "getGroupSize", "identity", "getIdentity", "()Ljava/lang/Object;", "isEmpty", "", "()Z", STGroup.DICT_KEY, "getKey", "node", "getNode", "slotsSize", "getSlotsSize", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "getTable", "()Landroidx/compose/runtime/SlotTable;", "getVersion", "find", "identityToFind", "iterator", "", "validateRead", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotTableGroup\n+ 2 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n*L\n1#1,3471:1\n146#2,8:3472\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotTableGroup\n*L\n3044#1:3472,8\n*E\n"})
final class SlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {
    private final int group;
    private final SlotTable table;
    private final int version;

    public SlotTableGroup(SlotTable r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "table");
        this.table = r5;
        this.group = r10;
        this.version = r11;
    }

    private final void validateRead() {
        if (this.table.getVersion$runtime_release() != this.version) goto L6;
        return;
    L6:
        throw new ConcurrentModificationException();
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "identityToFind");
        if ((r5 instanceof Anchor) == false) goto L5;
        Anchor r10 = (Anchor) r5;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        if (this.table.ownsAnchor(r10) == false) goto L16;
        int r11 = this.table.anchorIndex(r10);
        int r12 = this.group;
        if (r11 >= r12) goto L12;
        return null;
    L12:
        if ((r11 - r12) < SlotTableKt.access$groupSize(this.table.getGroups(), this.group)) goto L14;
        return null;
    L14:
        return new SlotTableGroup(this.table, r11, this.version);
    L16:
        return null;
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Iterable<Object> getData() {
        return new DataIterator(this.table, this.group);
    }

    public final int getGroup() {
        return this.group;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getGroupSize() {
        return SlotTableKt.access$groupSize(this.table.getGroups(), this.group);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getIdentity() {
        validateRead();
        SlotReader r5 = this.table.openReader();
        Anchor r10 = r5.anchor(this.group);     // Catch: Throwable -> L6
        r5.close();
        return r10;
    L6:
        th = move-exception;
        r5.close();
        throw th;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getKey() {
        if (SlotTableKt.access$hasObjectKey(this.table.getGroups(), this.group) == false) goto L6;
        Object r5 = this.table.getSlots()[SlotTableKt.access$objectKeyIndex(this.table.getGroups(), this.group)];
        Intrinsics.checkNotNull(r5);
        return r5;
    L6:
        return Integer.valueOf(SlotTableKt.access$key(this.table.getGroups(), this.group));
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getNode() {
        if (SlotTableKt.access$isNode(this.table.getGroups(), this.group) == true) goto L7;
        return null;
    L7:
        return this.table.getSlots()[SlotTableKt.access$nodeIndex(this.table.getGroups(), this.group)];
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getSlotsSize() {
        int r5 = this.group + getGroupSize();
        if (r5 >= this.table.getGroupsSize()) goto L5;
        int r10 = SlotTableKt.access$dataAnchor(this.table.getGroups(), r5);
    L7:
        return r10 - SlotTableKt.access$dataAnchor(this.table.getGroups(), this.group);
    L5:
        r10 = this.table.getSlotsSize();
        goto L7
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public String getSourceInfo() {
        if (SlotTableKt.access$hasAux(this.table.getGroups(), this.group) == false) goto L8;
        Object r5 = this.table.getSlots()[SlotTableKt.access$auxIndex(this.table.getGroups(), this.group)];
        if ((r5 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r5;
    L8:
        return null;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        if (SlotTableKt.access$groupSize(this.table.getGroups(), this.group) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        validateRead();
        SlotTable r5 = this.table;
        int r10 = this.group;
        return new GroupIterator(r5, r10 + 1, SlotTableKt.access$groupSize(r5.getGroups(), this.group) + r10);
    }

    public /* synthetic */ SlotTableGroup(SlotTable r5, int r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = r5.getVersion$runtime_release();
    L5:
        this(r5, r10, r11);
    }
}
