package androidx.compose.runtime;

import ai.j0;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\nJ\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020?J\u000e\u0010A\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\u0006\u0010B\u001a\u00020?J\u0006\u0010C\u001a\u00020?J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EJO\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020\n28\u0010I\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020?0JH\u0000¢\u0006\u0002\bNJ\u0010\u0010O\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u0010\u0010P\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u0018\u0010P\u001a\u0004\u0018\u00010\u00012\u0006\u0010H\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010;\u001a\u00020<J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010Q\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\u000e\u0010R\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\b\u0010S\u001a\u0004\u0018\u00010\u0001J\u0010\u0010T\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010U\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010V\u001a\u00020?2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010W\u001a\u00020?2\u0006\u0010=\u001a\u00020\nJ\u0006\u0010X\u001a\u00020\nJ\u0006\u0010Y\u001a\u00020?J\u0006\u0010Z\u001a\u00020?J\u0006\u0010[\u001a\u00020?J\b\u0010\\\u001a\u00020]H\u0016J\u0016\u0010^\u001a\u0004\u0018\u00010\u0001*\u00020%2\u0006\u0010=\u001a\u00020\nH\u0002J\u0016\u0010T\u001a\u0004\u0018\u00010\u0001*\u00020%2\u0006\u0010=\u001a\u00020\nH\u0002J\u0016\u0010_\u001a\u0004\u0018\u00010\u0001*\u00020%2\u0006\u0010=\u001a\u00020\nH\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u001e\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0011\u0010 \u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0011\u0010\"\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b(\u0010\tR\u0011\u0010)\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b)\u0010\tR\u0011\u0010*\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b*\u0010\tR\u0011\u0010+\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b,\u0010\rR\u001e\u0010-\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\rR\u0011\u0010/\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b0\u0010\rR\u0011\u00101\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b2\u0010\rR\u0011\u00103\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b4\u0010\rR\u0018\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000106X\u0082\u0004¢\u0006\u0004\n\u0002\u00107R\u000e\u00108\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006`"}, d2 = {"Landroidx/compose/runtime/SlotReader;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "<set-?>", "", "closed", "getClosed", "()Z", "", "currentEnd", "getCurrentEnd", "()I", "currentGroup", "getCurrentGroup", "currentSlot", "currentSlotEnd", "emptyCount", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupEnd", "getGroupEnd", "groupKey", "getGroupKey", "groupNode", "getGroupNode", "groupObjectKey", "getGroupObjectKey", "groupSize", "getGroupSize", "groupSlotCount", "getGroupSlotCount", "groupSlotIndex", "getGroupSlotIndex", "groups", "", "groupsSize", "inEmpty", "getInEmpty", "isGroupEnd", "isNode", "nodeCount", "getNodeCount", "parent", "getParent", "parentNodes", "getParentNodes", "size", "getSize", "slot", "getSlot", "slots", "", "[Ljava/lang/Object;", "slotsSize", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "index", "beginEmpty", "", "close", "containsMark", "endEmpty", "endGroup", "extractKeys", "", "Landroidx/compose/runtime/KeyInfo;", "forEachData", "group", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "forEachData$runtime_release", "get", "groupGet", "hasMark", "hasObjectKey", "next", "node", "parentOf", "reposition", "restoreParent", "skipGroup", "skipToGroupEnd", "startGroup", "startNode", "toString", "", "aux", "objectKey", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 SlotTable.kt\nandroidx/compose/runtime/SlotTableKt\n*L\n1#1,3471:1\n1#2:3472\n4548#3,5:3473\n4548#3,5:3478\n4548#3,5:3483\n4548#3,5:3488\n4548#3,5:3493\n3351#4,6:3498\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotReader\n*L\n963#1:3473,5\n973#1:3478,5\n981#1:3483,5\n1000#1:3488,5\n1014#1:3493,5\n1065#1:3498,6\n*E\n"})
public final class SlotReader {
    private boolean closed;
    private int currentEnd;
    private int currentGroup;
    private int currentSlot;
    private int currentSlotEnd;
    private int emptyCount;
    private final int[] groups;
    private final int groupsSize;
    private int parent;
    private final Object[] slots;
    private final int slotsSize;
    private final SlotTable table;

    public SlotReader(SlotTable r5) {
        Intrinsics.checkNotNullParameter(r5, "table");
        this.table = r5;
        this.groups = r5.getGroups();
        int r10 = r5.getGroupsSize();
        this.groupsSize = r10;
        this.slots = r5.getSlots();
        this.slotsSize = r5.getSlotsSize();
        this.currentEnd = r10;
        this.parent = -1;
    }

    public static /* synthetic */ Anchor anchor$default(SlotReader r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.currentGroup;
    L6:
        return r5.anchor(r10);
    }

    private final Object aux(int[] r5, int r10) {
        if (SlotTableKt.access$hasAux(r5, r10) == false) goto L6;
        return this.slots[SlotTableKt.access$auxIndex(r5, r10)];
    L6:
        return Composer.Companion.getEmpty();
    }

    private final Object objectKey(int[] r5, int r10) {
        if (SlotTableKt.access$hasObjectKey(r5, r10) == true) goto L7;
        return null;
    L7:
        return this.slots[SlotTableKt.access$objectKeyIndex(r5, r10)];
    }

    public final Anchor anchor(int r5) {
        ArrayList<Anchor> r10 = this.table.getAnchors$runtime_release();
        int r11 = SlotTableKt.access$search(r10, r5, this.groupsSize);
        if (r11 >= 0) goto L6;
        Anchor r12 = new Anchor(r5);
        r10.add(-(r11 + 1), r12);
        return r12;
    L6:
        return r10.get(r11);
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void close() {
        this.closed = true;
        this.table.close$runtime_release(this);
    }

    public final boolean containsMark(int r5) {
        return SlotTableKt.access$containsMark(this.groups, r5);
    }

    public final void endEmpty() {
        int r5 = this.emptyCount;
        if (r5 <= 0) goto L7;
        this.emptyCount = r5 - 1;
        return;
    L7:
        throw new IllegalArgumentException("Unbalanced begin/end empty");
    }

    public final void endGroup() {
        if (this.emptyCount == 0) goto L5;
        return;
    L5:
        if (this.currentGroup != this.currentEnd) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L15;
        int r10 = SlotTableKt.access$parentAnchor(this.groups, this.parent);
        this.parent = r10;
        if (r10 >= 0) goto L12;
        int r11 = this.groupsSize;
    L13:
        this.currentEnd = r11;
        return;
    L12:
        r11 = r10 + SlotTableKt.access$groupSize(this.groups, r10);
        goto L13
    L15:
        throw j0.z("endGroup() not called at the end of a group");
    L7:
        r5 = false;
        goto L8
    }

    public final List<KeyInfo> extractKeys() {
        ArrayList r5 = new ArrayList();
        if (this.emptyCount <= 0) goto L5;
        return r5;
    L5:
        int r10 = this.currentGroup;
        int r11 = 0;
    L7:
        if (r10 >= this.currentEnd) goto L14;
        int r12 = SlotTableKt.access$key(this.groups, r10);
        Object r13 = objectKey(this.groups, r10);
        if (SlotTableKt.access$isNode(this.groups, r10) == false) goto L12;
        int r14 = 1;
    L13:
        r5.add(new KeyInfo(r12, r13, r10, r14, r11));
        r10 = r10 + SlotTableKt.access$groupSize(this.groups, r10);
        r11 = r11 + 1;
        goto L7
    L12:
        r14 = SlotTableKt.access$nodeCount(this.groups, r10);
        goto L13
    L14:
        return r5;
    }

    public final void forEachData$runtime_release(int r5, Function2<? super Integer, Object, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        int r11 = SlotTableKt.access$slotAnchor(this.groups, r5);
        int r12 = r5 + 1;
        if (r12 >= this.table.getGroupsSize()) goto L5;
        int r13 = SlotTableKt.access$dataAnchor(this.table.getGroups(), r12);
    L6:
        int r14 = r11;
    L7:
        if (r14 >= r13) goto L9;
        r10.mo2invoke(Integer.valueOf(r14 - r11), this.slots[r14]);
        r14 = r14 + 1;
        goto L7
    L9:
        return;
    L5:
        r13 = this.table.getSlotsSize();
        goto L6
    }

    public final Object get(int r5) {
        int r10 = this.currentSlot + r5;
        if (r10 >= this.currentSlotEnd) goto L6;
        return this.slots[r10];
    L6:
        return Composer.Companion.getEmpty();
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentEnd() {
        return this.currentEnd;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final Object getGroupAux() {
        int r5 = this.currentGroup;
        if (r5 >= this.currentEnd) goto L6;
        return aux(this.groups, r5);
    L6:
        return 0;
    }

    public final int getGroupEnd() {
        return this.currentEnd;
    }

    public final int getGroupKey() {
        int r5 = this.currentGroup;
        if (r5 < this.currentEnd) goto L7;
        return 0;
    L7:
        return SlotTableKt.access$key(this.groups, r5);
    }

    public final Object getGroupNode() {
        int r5 = this.currentGroup;
        if (r5 < this.currentEnd) goto L7;
        return null;
    L7:
        return node(this.groups, r5);
    }

    public final Object getGroupObjectKey() {
        int r5 = this.currentGroup;
        if (r5 < this.currentEnd) goto L7;
        return null;
    L7:
        return objectKey(this.groups, r5);
    }

    public final int getGroupSize() {
        return SlotTableKt.access$groupSize(this.groups, this.currentGroup);
    }

    public final int getGroupSlotCount() {
        int r5 = this.currentGroup;
        int r10 = SlotTableKt.access$slotAnchor(this.groups, r5);
        int r11 = r5 + 1;
        if (r11 >= this.groupsSize) goto L5;
        int r12 = SlotTableKt.access$dataAnchor(this.groups, r11);
    L7:
        return r12 - r10;
    L5:
        r12 = this.slotsSize;
        goto L7
    }

    public final int getGroupSlotIndex() {
        return this.currentSlot - SlotTableKt.access$slotAnchor(this.groups, this.parent);
    }

    public final boolean getInEmpty() {
        if (this.emptyCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getNodeCount() {
        return SlotTableKt.access$nodeCount(this.groups, this.currentGroup);
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getParentNodes() {
        int r5 = this.parent;
        if (r5 >= 0) goto L7;
        return 0;
    L7:
        return SlotTableKt.access$nodeCount(this.groups, r5);
    }

    public final int getSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        return this.currentSlot - SlotTableKt.access$slotAnchor(this.groups, this.parent);
    }

    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    public final Object groupAux(int r5) {
        return aux(this.groups, r5);
    }

    public final int groupEnd(int r5) {
        return SlotTableKt.access$groupSize(this.groups, r5) + r5;
    }

    public final Object groupGet(int r5) {
        return groupGet(this.currentGroup, r5);
    }

    public final int groupKey(int r5) {
        return SlotTableKt.access$key(this.groups, r5);
    }

    public final Object groupObjectKey(int r5) {
        return objectKey(this.groups, r5);
    }

    public final int groupSize(int r5) {
        return SlotTableKt.access$groupSize(this.groups, r5);
    }

    public final boolean hasMark(int r5) {
        return SlotTableKt.access$hasMark(this.groups, r5);
    }

    public final boolean hasObjectKey(int r5) {
        return SlotTableKt.access$hasObjectKey(this.groups, r5);
    }

    public final boolean isGroupEnd() {
        if (getInEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.currentGroup == this.currentEnd) goto L8;
        return false;
    }

    public final boolean isNode() {
        return SlotTableKt.access$isNode(this.groups, this.currentGroup);
    }

    public final Object next() {
        if (this.emptyCount > 0) goto L10;
        int r5 = this.currentSlot;
        if (r5 >= this.currentSlotEnd) goto L10;
        Object[] r10 = this.slots;
        this.currentSlot = r5 + 1;
        return r10[r5];
    L10:
        return Composer.Companion.getEmpty();
    }

    public final Object node(int r5) {
        if (SlotTableKt.access$isNode(this.groups, r5) == true) goto L7;
        return null;
    L7:
        return node(this.groups, r5);
    }

    public final int nodeCount(int r5) {
        return SlotTableKt.access$nodeCount(this.groups, r5);
    }

    public final int parent(int r5) {
        return SlotTableKt.access$parentAnchor(this.groups, r5);
    }

    public final int parentOf(int r5) {
        if (r5 < 0) goto L8;
        if (r5 >= this.groupsSize) goto L8;
        return SlotTableKt.access$parentAnchor(this.groups, r5);
    L8:
        throw new IllegalArgumentException(j0.g(r5, "Invalid group index ").toString());
    }

    public final void reposition(int r5) {
        if (this.emptyCount != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L18;
        this.currentGroup = r5;
        if (r5 >= this.groupsSize) goto L10;
        int r11 = SlotTableKt.access$parentAnchor(this.groups, r5);
    L11:
        this.parent = r11;
        if (r11 >= 0) goto L14;
        this.currentEnd = this.groupsSize;
    L15:
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        return;
    L14:
        this.currentEnd = SlotTableKt.access$groupSize(this.groups, r11) + r11;
        goto L15
    L10:
        r11 = -1;
        goto L11
    L18:
        throw j0.z("Cannot reposition while in an empty region");
    L5:
        r10 = false;
        goto L6
    }

    public final void restoreParent(int r5) {
        int r10 = SlotTableKt.access$groupSize(this.groups, r5) + r5;
        int r11 = this.currentGroup;
        if (r11 < r5) goto L6;
        if (r11 > r10) goto L6;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L10;
        this.parent = r5;
        this.currentEnd = r10;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        return;
    L10:
        ComposerKt.composeRuntimeError(("Index " + r5 + " is not a parent of " + r11).toString());
        throw new KotlinNothingValueException();
    L6:
        r12 = false;
        goto L7
    }

    public final int skipGroup() {
        int r5 = 1;
        if (this.emptyCount != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L14;
        if (SlotTableKt.access$isNode(this.groups, this.currentGroup) == true) goto L11;
        r5 = SlotTableKt.access$nodeCount(this.groups, this.currentGroup);
    L11:
        int r11 = this.currentGroup;
        this.currentGroup = SlotTableKt.access$groupSize(this.groups, r11) + r11;
        return r5;
    L14:
        throw j0.z("Cannot skip while in an empty region");
    L5:
        r10 = false;
        goto L6
    }

    public final void skipToGroupEnd() {
        if (this.emptyCount != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        this.currentGroup = this.currentEnd;
        return;
    L10:
        throw j0.z("Cannot skip the enclosing group while in an empty region");
    L5:
        r5 = false;
        goto L6
    }

    public final void startGroup() {
        if (this.emptyCount <= 0) goto L5;
        return;
    L5:
        if (SlotTableKt.access$parentAnchor(this.groups, this.currentGroup) != this.parent) goto L12;
        int r5 = this.currentGroup;
        this.parent = r5;
        this.currentEnd = SlotTableKt.access$groupSize(this.groups, r5) + r5;
        int r10 = this.currentGroup;
        int r11 = r10 + 1;
        this.currentGroup = r11;
        this.currentSlot = SlotTableKt.access$slotAnchor(this.groups, r10);
        if (r10 < (this.groupsSize - 1)) goto L9;
        int r12 = this.slotsSize;
    L10:
        this.currentSlotEnd = r12;
        return;
    L9:
        r12 = SlotTableKt.access$dataAnchor(this.groups, r11);
        goto L10
    L12:
        throw new IllegalArgumentException("Invalid slot table detected");
    }

    public final void startNode() {
        if (this.emptyCount <= 0) goto L5;
        return;
    L5:
        if (SlotTableKt.access$isNode(this.groups, this.currentGroup) == false) goto L8;
        startGroup();
        return;
    L8:
        throw new IllegalArgumentException("Expected a node group");
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("SlotReader(current=");
        r5.append(this.currentGroup);
        r5.append(", key=");
        r5.append(getGroupKey());
        r5.append(", parent=");
        r5.append(this.parent);
        r5.append(", end=");
        return j0.n(r5, this.currentEnd, ')');
    }

    private final Object node(int[] r5, int r10) {
        if (SlotTableKt.access$isNode(r5, r10) == false) goto L6;
        return this.slots[SlotTableKt.access$nodeIndex(r5, r10)];
    L6:
        return Composer.Companion.getEmpty();
    }

    public final Object groupGet(int r5, int r10) {
        int r11 = SlotTableKt.access$slotAnchor(this.groups, r5);
        int r12 = r5 + 1;
        if (r12 >= this.groupsSize) goto L5;
        int r13 = SlotTableKt.access$dataAnchor(this.groups, r12);
    L6:
        int r14 = r11 + r10;
        if (r14 >= r13) goto L10;
        return this.slots[r14];
    L10:
        return Composer.Companion.getEmpty();
    L5:
        r13 = this.slotsSize;
        goto L6
    }

    public final int groupKey(Anchor r5) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        if (r5.getValid() == true) goto L7;
        return 0;
    L7:
        return SlotTableKt.access$key(this.groups, this.table.anchorIndex(r5));
    }

    public final boolean isNode(int r5) {
        return SlotTableKt.access$isNode(this.groups, r5);
    }
}
