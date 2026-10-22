package androidx.compose.runtime;

import ai.j0;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0015J\u000e\u0010-\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020/J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4JW\u00100\u001a\u0002012\u0006\u0010)\u001a\u0002052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0000¢\u0006\u0004\b4\u00106J\u0006\u00107\u001a\u00020\u001aJ\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u0012\u0010:\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020\u001eH\u0016J\u0012\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u0015H\u0002J\u0016\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u0010\u0010B\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u0015H\u0002J\u001d\u0010C\u001a\n\u0012\u0004\u0012\u00020=\u0018\u0001092\u0006\u0010D\u001a\u00020\u0015H\u0000¢\u0006\u0002\bEJ\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030GH\u0096\u0002J\u000e\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J\u0006\u0010J\u001a\u000203J\u0006\u0010K\u001a\u000205J\u000e\u0010L\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001509H\u0002J:\u0010N\u001a\u0002HO\"\u0004\b\u0000\u0010O2!\u0010P\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002HO0QH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010TJO\u0010U\u001a\u0002012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0000¢\u0006\u0004\bV\u0010WJ\u001f\u0010X\u001a\u0004\u0018\u00010\u001e2\u0006\u0010>\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020\u0015H\u0000¢\u0006\u0002\bZJ\u001d\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e092\u0006\u0010>\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\\J\u0006\u0010]\u001a\u000201J:\u0010^\u001a\u0002HO\"\u0004\b\u0000\u0010O2!\u0010P\u001a\u001d\u0012\u0013\u0012\u001105¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b()\u0012\u0004\u0012\u0002HO0QH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010TJ \u0010_\u001a\u00020\u0015*\u00060`j\u0002`a2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\u0015H\u0002R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006c"}, d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "()V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime_release", "()Ljava/util/ArrayList;", "setAnchors$runtime_release", "(Ljava/util/ArrayList;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "<set-?>", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "isEmpty", "", "()Z", "readers", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "version", "getVersion$runtime_release", "setVersion$runtime_release", "(I)V", "writer", "getWriter$runtime_release", "anchor", "index", "anchorIndex", "asString", "", "close", "", "reader", "Landroidx/compose/runtime/SlotReader;", "close$runtime_release", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "containsMark", "dataIndexes", "", "find", "identityToFind", "findEffectiveRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "group", "groupContainsAnchor", "groupIndex", "groupSizes", "invalidateGroup", "invalidateGroupsWithKey", "target", "invalidateGroupsWithKey$runtime_release", "iterator", "", "keys", "nodes", "openReader", "openWriter", "ownsAnchor", "parentIndexes", "read", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setTo", "setTo$runtime_release", "([II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "slot", "slotIndex", "slot$runtime_release", "slotsOf", "slotsOf$runtime_release", "verifyWellFormed", "write", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SlotTable.kt\nandroidx/compose/runtime/SlotTableKt\n+ 5 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,3471:1\n146#1,8:3514\n162#1,4:3522\n167#1,3:3532\n4548#2,5:3472\n4548#2,5:3477\n4548#2,5:3482\n4548#2,5:3494\n4548#2,5:3499\n4548#2,5:3504\n4548#2,5:3509\n1#3:3487\n3351#4,6:3488\n33#5,6:3526\n33#5,6:3535\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n*L\n310#1:3514,8\n338#1:3522,4\n338#1:3532,3\n190#1:3472,5\n191#1:3477,5\n207#1:3482,5\n221#1:3494,5\n241#1:3499,5\n242#1:3504,5\n251#1:3509,5\n209#1:3488,6\n340#1:3526,6\n484#1:3535,6\n*E\n"})
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    private ArrayList<Anchor> anchors;
    private int[] groups;
    private int groupsSize;
    private int readers;
    private Object[] slots;
    private int slotsSize;
    private int version;
    private boolean writer;

    public SlotTable() {
        this.groups = new int[0];
        this.slots = new Object[0];
        this.anchors = new ArrayList();
    }

    private final List<Integer> dataIndexes() {
        return SlotTableKt.access$dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final int emitGroup(StringBuilder r10, int r11, int r12) {
        int r5 = 0;
    L3:
        if (r5 >= r12) goto L5;
        r10.append(' ');
        r5 = r5 + 1;
        goto L3
    L5:
        r10.append("Group(");
        r10.append(r11);
        r10.append(") key=");
        r10.append(SlotTableKt.access$key(this.groups, r11));
        int r13 = SlotTableKt.access$groupSize(this.groups, r11);
        r10.append(", nodes=");
        r10.append(SlotTableKt.access$nodeCount(this.groups, r11));
        r10.append(", size=");
        r10.append(r13);
        if (SlotTableKt.access$hasMark(this.groups, r11) == false) goto L9;
        r10.append(", mark");
    L9:
        if (SlotTableKt.access$containsMark(this.groups, r11) == false) goto L11;
        r10.append(", contains mark");
    L11:
        int r14 = emitGroup$dataIndex(this, r11);
        int r15 = r11 + 1;
        int r16 = emitGroup$dataIndex(this, r15);
        if (r14 < 0) goto L33;
        if (r14 > r16) goto L33;
        if (r16 > this.slotsSize) goto L33;
        if (SlotTableKt.access$hasObjectKey(this.groups, r11) == false) goto L20;
        r10.append(" objectKey=" + this.slots[SlotTableKt.access$objectKeyIndex(this.groups, r11)]);
    L20:
        if (SlotTableKt.access$isNode(this.groups, r11) == false) goto L23;
        r10.append(" node=" + this.slots[SlotTableKt.access$nodeIndex(this.groups, r11)]);
    L23:
        if (SlotTableKt.access$hasAux(this.groups, r11) == false) goto L25;
        r10.append(" aux=" + this.slots[SlotTableKt.access$auxIndex(this.groups, r11)]);
    L25:
        int r17 = SlotTableKt.access$slotAnchor(this.groups, r11);
        if (r17 >= r16) goto L34;
        r10.append(", slots=[");
        r10.append(r17);
        r10.append(": ");
        int r18 = r17;
    L28:
        if (r18 >= r16) goto L32;
        if (r18 == r17) goto L31;
        r10.append(", ");
    L31:
        r10.append(String.valueOf(this.slots[r18]));
        r18 = r18 + 1;
        goto L28
    L32:
        r10.append("]");
    L34:
        r10.append('\n');
        int r19 = r11 + r13;
    L35:
        if (r15 >= r19) goto L37;
        r15 = r15 + emitGroup(r10, r15, r12 + 1);
        goto L35
    L37:
        return r13;
    L33:
        r10.append(", *invalid data offsets " + r14 + '-' + r16 + '*');
        goto L34
    }

    private static final int emitGroup$dataIndex(SlotTable r5, int r10) {
        if (r10 < r5.groupsSize) goto L6;
        return r5.slotsSize;
    L6:
        return SlotTableKt.access$dataAnchor(r5.groups, r10);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int r5) {
    L2:
        if (r5 <= 0) goto L11;
        Iterator<Object> r10 = new DataIterator(this, r5).iterator();
    L5:
        if (r10.hasNext() == false) goto L10;
        Object r11 = r10.next();
        if ((r11 instanceof RecomposeScopeImpl) == false) goto L5;
        return (RecomposeScopeImpl) r11;
    L10:
        r5 = SlotTableKt.access$parentAnchor(this.groups, r5);
        goto L2
    L11:
        return null;
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.access$groupSizes(this.groups, this.groupsSize * 5);
    }

    private final boolean invalidateGroup(int r5) {
    L3:
        if (r5 < 0) goto L14;
        Iterator<Object> r10 = new DataIterator(this, r5).iterator();
    L6:
        if (r10.hasNext() == false) goto L13;
        Object r11 = r10.next();
        if ((r11 instanceof RecomposeScopeImpl) == false) goto L6;
        RecomposeScopeImpl r12 = (RecomposeScopeImpl) r11;
        r12.setRequiresRecompose(true);
        if (r12.invalidateForResult(null) != InvalidationResult.IGNORED) goto L12;
        return false;
    L12:
        return true;
    L13:
        r5 = SlotTableKt.access$parentAnchor(this.groups, r5);
        goto L3
    L14:
        return false;
    }

    private static final void invalidateGroupsWithKey$lambda$14$scanGroup(SlotReader r5, int r10, List<Anchor> r11, Ref.BooleanRef r12, SlotTable r13, List<RecomposeScopeImpl> r14) {
        if (r5.getGroupKey() != r10) goto L12;
        r11.add(SlotReader.anchor$default(r5, 0, 1, null));
        if (r12.element == false) goto L10;
        RecomposeScopeImpl r15 = r13.findEffectiveRecomposeScope(r5.getCurrentGroup());
        if (r15 == null) goto L9;
        r14.add(r15);
        goto L10
    L9:
        r12.element = false;
        r14.clear();
    L10:
        r5.skipGroup();
        return;
    L12:
        r5.startGroup();
    L14:
        if (r5.isGroupEnd() == true) goto L16;
        invalidateGroupsWithKey$lambda$14$scanGroup(r5, r10, r11, r12, r13, r14);
        goto L14
    L16:
        r5.endGroup();
    }

    private final List<Integer> keys() {
        return SlotTableKt.access$keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.access$nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.access$parentAnchors(this.groups, this.groupsSize * 5);
    }

    private static final int verifyWellFormed$validateGroup(Ref.IntRef r10, SlotTable r11, int r12, int r13) {
        int r5 = r10.element;
        int r14 = r5 + 1;
        r10.element = r14;
        int r15 = SlotTableKt.access$parentAnchor(r11.groups, r5);
        if (r15 != r12) goto L61;
        int r16 = SlotTableKt.access$groupSize(r11.groups, r5) + r5;
        if (r16 > r11.groupsSize) goto L60;
        if (r16 > r13) goto L58;
        int r17 = SlotTableKt.access$dataAnchor(r11.groups, r5);
        if (r5 < (r11.groupsSize - 1)) goto L10;
        int r18 = r11.slotsSize;
    L12:
        if (r18 > r11.slots.length) goto L56;
        if (r17 > r18) goto L54;
        if (SlotTableKt.access$slotAnchor(r11.groups, r5) > r18) goto L52;
        boolean r19 = SlotTableKt.access$isNode(r11.groups, r5);
        boolean r20 = SlotTableKt.access$hasObjectKey(r11.groups, r5);
        if ((r18 - r17) < ((SlotTableKt.access$hasAux(r11.groups, r5) ? 1 : 0) + ((r20 ? 1 : 0) + (r19 ? 1 : 0)))) goto L50;
        boolean r110 = SlotTableKt.access$isNode(r11.groups, r5);
        if (r110 == true) goto L21;
    L25:
        int r21 = 0;
    L27:
        if (r10.element >= r16) goto L29;
        r21 = r21 + verifyWellFormed$validateGroup(r10, r11, r5, r16);
        goto L27
    L29:
        int r22 = SlotTableKt.access$nodeCount(r11.groups, r5);
        int r23 = SlotTableKt.access$groupSize(r11.groups, r5);
        if (r22 != r21) goto L47;
        int r24 = r10.element - r5;
        if (r23 == r24) goto L34;
        StringBuilder r25 = j0.v("Incorrect slot count detected at ", r5, r23, ", expected ", ", received ");
        r25.append(r24);
        throw new IllegalStateException(r25.toString().toString());
    L34:
        if (SlotTableKt.access$containsAnyMark(r11.groups, r5) == false) goto L41;
        if (r5 <= 0) goto L41;
        if (SlotTableKt.access$containsMark(r11.groups, r12) == true) goto L41;
        throw new IllegalStateException(("Expected group " + r12 + " to record it contains a mark because " + r5 + " does").toString());
    L41:
        if (r110 == false) goto L44;
        return 1;
    L44:
        return r21;
    L47:
        StringBuilder r26 = j0.v("Incorrect node count detected at ", r5, r22, ", expected ", ", received ");
        r26.append(r21);
        throw new IllegalStateException(r26.toString().toString());
    L21:
        if (r11.slots[SlotTableKt.access$nodeIndex(r11.groups, r5)] != null) goto L25;
        throw new IllegalStateException(j0.g(r5, "No node recorded for a node group at ").toString());
    L50:
        throw new IllegalStateException(j0.g(r5, "Not enough slots added for group ").toString());
    L52:
        throw new IllegalStateException(j0.g(r5, "Slots start out of range at ").toString());
    L54:
        throw new IllegalStateException(j0.g(r5, "Invalid data anchor at ").toString());
    L56:
        throw new IllegalStateException(j0.h(r5, "Slots for ", " extend past the end of the slot table").toString());
    L10:
        r18 = SlotTableKt.access$dataAnchor(r11.groups, r14);
        goto L12
    L58:
        throw new IllegalStateException(j0.g(r5, "A group extends past its parent group at ").toString());
    L60:
        throw new IllegalStateException(j0.g(r5, "A group extends past the end of the table at ").toString());
    L61:
        StringBuilder r27 = j0.v("Invalid parent index detected at ", r5, r12, ", expected parent index to be ", " found ");
        r27.append(r15);
        throw new IllegalStateException(r27.toString().toString());
    }

    public final Anchor anchor(int r5) {
        if (this.writer == true) goto L15;
        if (r5 < 0) goto L13;
        int r10 = this.groupsSize;
        if (r5 >= r10) goto L13;
        ArrayList<Anchor> r11 = this.anchors;
        int r12 = SlotTableKt.access$search(r11, r5, r10);
        if (r12 >= 0) goto L11;
        Anchor r13 = new Anchor(r5);
        r11.add(-(r12 + 1), r13);
        return r13;
    L11:
        return r11.get(r12);
    L13:
        throw new IllegalArgumentException("Parameter index is out of range");
    L15:
        throw j0.z("use active SlotWriter to create an anchor location instead ");
    }

    public final int anchorIndex(Anchor r5) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        if (this.writer == true) goto L11;
        if (r5.getValid() == false) goto L9;
        return r5.getLocation$runtime_release();
    L9:
        throw new IllegalArgumentException("Anchor refers to a group that was removed");
    L11:
        throw j0.z("Use active SlotWriter to determine anchor location instead");
    }

    public final String asString() {
        if (this.writer == true) goto L14;
        StringBuilder r5 = new StringBuilder();
        r5.append(toString());
        r5.append('\n');
        int r10 = this.groupsSize;
        if (r10 <= 0) goto L10;
        int r11 = 0;
    L8:
        if (r11 >= r10) goto L12;
        r11 = r11 + emitGroup(r5, r11, 0);
    L12:
        return r5.toString();
    L10:
        r5.append("<EMPTY>");
        goto L12
    L14:
        return toString();
    }

    public final void close$runtime_release(SlotReader r5) {
        Intrinsics.checkNotNullParameter(r5, "reader");
        if (r5.getTable$runtime_release() == this) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L12;
        this.readers--;
        return;
    L12:
        throw j0.z("Unexpected reader close()");
    L5:
        if (this.readers <= 0) goto L7;
        r10 = true;
        goto L8
    }

    public final boolean containsMark() {
        if (this.groupsSize > 0) goto L5;
        return false;
    L5:
        if (SlotTableKt.access$containsMark(this.groups, 0) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "identityToFind");
        int r5 = 0;
        int r11 = 0;
        return new SlotTableGroup(this, r5, r11, 4, null).find(r10);
    }

    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final int getVersion$runtime_release() {
        return this.version;
    }

    public final boolean getWriter$runtime_release() {
        return this.writer;
    }

    public final boolean groupContainsAnchor(int r5, Anchor r10) {
        Intrinsics.checkNotNullParameter(r10, "anchor");
        if (this.writer == true) goto L22;
        if (r5 >= 0) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L20;
        if (ownsAnchor(r10) == false) goto L18;
        int r12 = SlotTableKt.access$groupSize(this.groups, r5) + r5;
        int r13 = r10.getLocation$runtime_release();
        if (r5 > r13) goto L18;
        if (r13 >= r12) goto L18;
        return true;
    L18:
        return false;
    L20:
        throw j0.z("Invalid group index");
    L7:
        if (r5 >= this.groupsSize) goto L9;
        r11 = true;
        goto L10
    L22:
        throw j0.z("Writer is active");
    }

    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release(int r12) {
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        r13.element = true;
        SlotReader r14 = openReader();
        invalidateGroupsWithKey$lambda$14$scanGroup(r14, r12, r10, r13, this, r11);     // Catch: Throwable -> L21
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r14.close();
        SlotWriter r16 = openWriter();
        r16.startGroup();     // Catch: Throwable -> L10
        int r17 = r10.size();     // Catch: Throwable -> L10
        int r5 = 0;
    L6:
        if (r5 >= r17) goto L13;
        Anchor r18 = (Anchor) r10.get(r5);     // Catch: Throwable -> L10
        if (r18.toIndexFor(r16) < r16.getCurrentGroup()) goto L12;
        r16.seek(r18);     // Catch: Throwable -> L10
        r16.bashGroup$runtime_release();     // Catch: Throwable -> L10
    L12:
        r5 = r5 + 1;     // Catch: Throwable -> L10
        goto L6
    L13:
        r16.skipToGroupEnd();     // Catch: Throwable -> L10
        r16.endGroup();     // Catch: Throwable -> L10
        r16.close();
        if (r13.element == true) goto L31;
        return null;
    L31:
        return r11;
    L10:
        th = move-exception;
        r16.close();
        throw th;
    L21:
        th = move-exception;
        r14.close();
        throw th;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        if (this.groupsSize != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public final SlotReader openReader() {
        if (this.writer == true) goto L7;
        this.readers++;
        return new SlotReader(this);
    L7:
        throw new IllegalStateException("Cannot read while a writer is pending");
    }

    public final SlotWriter openWriter() {
        if (this.writer == true) goto L14;
        if (this.readers > 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L12;
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    L12:
        throw j0.z("Cannot start a writer when a reader is pending");
    L7:
        r5 = false;
        goto L8
    L14:
        throw j0.z("Cannot start a writer when another writer is pending");
    }

    public final boolean ownsAnchor(Anchor r5) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        if (r5.getValid() == false) goto L9;
        int r10 = SlotTableKt.access$search(this.anchors, r5.getLocation$runtime_release(), this.groupsSize);
        if (r10 < 0) goto L9;
        if (Intrinsics.areEqual(this.anchors.get(r10), r5) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final <T> T read(Function1<? super SlotReader, ? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        SlotReader r10 = openReader();
        T r11 = r5.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.close();
        InlineMarker.finallyEnd(1);
        return r11;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.close();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final void setAnchors$runtime_release(ArrayList<Anchor> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.anchors = r5;
    }

    public final void setTo$runtime_release(int[] r5, int r10, Object[] r11, int r12, ArrayList<Anchor> r13) {
        Intrinsics.checkNotNullParameter(r5, "groups");
        Intrinsics.checkNotNullParameter(r11, "slots");
        Intrinsics.checkNotNullParameter(r13, "anchors");
        this.groups = r5;
        this.groupsSize = r10;
        this.slots = r11;
        this.slotsSize = r12;
        this.anchors = r13;
    }

    public final void setVersion$runtime_release(int r5) {
        this.version = r5;
    }

    public final Object slot$runtime_release(int r5, int r10) {
        int r11 = SlotTableKt.access$slotAnchor(this.groups, r5);
        int r12 = r5 + 1;
        if (r12 >= this.groupsSize) goto L5;
        int r13 = SlotTableKt.access$dataAnchor(this.groups, r12);
    L6:
        int r14 = r13 - r11;
        if (r10 < 0) goto L12;
        if (r10 >= r14) goto L12;
        return this.slots[r11 + r10];
    L12:
        return Composer.Companion.getEmpty();
    L5:
        r13 = this.slots.length;
        goto L6
    }

    public final List<Object> slotsOf$runtime_release(int r5) {
        int r10 = SlotTableKt.access$dataAnchor(this.groups, r5);
        int r11 = r5 + 1;
        if (r11 >= this.groupsSize) goto L5;
        int r12 = SlotTableKt.access$dataAnchor(this.groups, r11);
    L7:
        return ArraysKt.toList(this.slots).subList(r10, r12);
    L5:
        r12 = this.slots.length;
        goto L7
    }

    public final void verifyWellFormed() {
        Ref.IntRef r5 = new Ref.IntRef();
        int r10 = -1;
        if (this.groupsSize <= 0) goto L11;
    L4:
        int r11 = r5.element;
        int r12 = this.groupsSize;
        if (r11 >= r12) goto L7;
        verifyWellFormed$validateGroup(r5, this, -1, SlotTableKt.access$groupSize(this.groups, r11) + r11);
        goto L4
    L7:
        if (r11 == r12) goto L11;
        throw new IllegalStateException(("Incomplete group at root " + r5.element + " expected to be " + this.groupsSize).toString());
    L11:
        int r13 = this.slotsSize;
        int r14 = this.slots.length;
    L12:
        if (r13 >= r14) goto L18;
        if (this.slots[r13] != null) goto L17;
        r13 = r13 + 1;
        goto L12
    L17:
        throw new IllegalStateException(j0.g(r13, "Non null value in the slot gap at index ").toString());
    L18:
        ArrayList<Anchor> r15 = this.anchors;
        int r16 = r15.size();
        int r17 = 0;
    L19:
        if (r17 >= r16) goto L30;
        int r18 = r15.get(r17).toIndexFor(this);
        if (r18 < 0) goto L29;
        if (r18 > this.groupsSize) goto L29;
        if (r10 >= r18) goto L27;
        r17 = r17 + 1;
        r10 = r18;
        goto L19
    L27:
        throw new IllegalArgumentException("Anchor is out of order");
    L29:
        throw new IllegalArgumentException("Invalid anchor, location out of bound");
    }

    public final <T> T write(Function1<? super SlotWriter, ? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        SlotWriter r10 = openWriter();
        T r11 = r5.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.close();
        InlineMarker.finallyEnd(1);
        return r11;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.close();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final void close$runtime_release(SlotWriter r10, int[] r11, int r12, Object[] r13, int r14, ArrayList<Anchor> r15) {
        Intrinsics.checkNotNullParameter(r10, "writer");
        Intrinsics.checkNotNullParameter(r11, "groups");
        Intrinsics.checkNotNullParameter(r13, "slots");
        Intrinsics.checkNotNullParameter(r15, "anchors");
        if (r10.getTable$runtime_release() != this) goto L9;
        if (this.writer == false) goto L9;
        this.writer = false;
        setTo$runtime_release(r11, r12, r13, r14, r15);
        return;
    L9:
        throw new IllegalArgumentException("Unexpected writer close()");
    }
}
