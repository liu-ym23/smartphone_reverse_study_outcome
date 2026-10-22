package androidx.compose.runtime;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b \n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b9\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u009f\u00012\u00020\u0001:\u0002\u009f\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nJ\u000e\u00105\u001a\u0002022\u0006\u00104\u001a\u00020\nJ\u0010\u00106\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\nJ\u000e\u00108\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0007J\r\u00109\u001a\u000202H\u0000¢\u0006\u0002\b:J\u0006\u0010;\u001a\u000202J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J\b\u0010>\u001a\u000202H\u0002J\u0006\u0010?\u001a\u000202J\u0010\u0010@\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J\u0010\u0010A\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J \u0010B\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010D\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u0010\u0010E\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0002J(\u0010F\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010H\u001a\u00020\nJ\u0006\u0010I\u001a\u000202J\u000e\u0010J\u001a\u0002022\u0006\u00106\u001a\u00020\u0007J\u000e\u0010J\u001a\u0002022\u0006\u00107\u001a\u00020\nJ \u0010K\u001a\u0002022\u0006\u0010\"\u001a\u00020\n2\u0006\u0010H\u001a\u00020\n2\u0006\u0010L\u001a\u00020\nH\u0002J\u0010\u0010M\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u0010\u0010N\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u000e\u0010O\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u0010\u0010P\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u000e\u0010Q\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010SJ\u0006\u0010T\u001a\u00020UJ\u000e\u0010V\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u0016\u0010W\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010X\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u0010\u0010Y\u001a\u0002022\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\u0010\u0010[\u001a\u0002022\u0006\u0010&\u001a\u00020\nH\u0002J\u000e\u0010\\\u001a\u0002022\u0006\u0010]\u001a\u00020\nJ\u0018\u0010^\u001a\u0002022\u0006\u0010&\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020\n0`H\u0002J\u0010\u0010a\u001a\u0002022\b\b\u0002\u0010=\u001a\u00020\nJ \u0010b\u001a\u0002022\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J&\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00070`2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u00020\n2\b\b\u0002\u0010f\u001a\u00020\u000eJ\u000e\u0010g\u001a\u0002022\u0006\u0010h\u001a\u00020\nJ\u0010\u0010i\u001a\u0002022\u0006\u00107\u001a\u00020\nH\u0002J$\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00070`2\u0006\u0010h\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u00020\nJ\u0018\u0010k\u001a\u0002022\u0006\u00107\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J$\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00070`2\u0006\u00106\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\n2\u0006\u0010m\u001a\u00020\u0000J\u0010\u0010n\u001a\u0004\u0018\u00010\u00012\u0006\u00106\u001a\u00020\u0007J\u0010\u0010n\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u0010\u0010o\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u0018\u0010p\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u0010G\u001a\u00020\nH\u0002J\b\u0010q\u001a\u000202H\u0002J\u0018\u0010r\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\u0006\u0010s\u001a\u00020\u000eJ\u0018\u0010t\u001a\u00020\u000e2\u0006\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\nH\u0002J \u0010w\u001a\u0002022\u0006\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J\u0006\u0010x\u001a\u000202J\b\u0010y\u001a\u00020\nH\u0002J\b\u0010z\u001a\u000202H\u0002J\u000e\u0010{\u001a\u0002022\u0006\u00106\u001a\u00020\u0007J\u0010\u0010|\u001a\u0002022\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\u001a\u0010|\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\n2\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\b\u0010}\u001a\u0004\u0018\u00010\u0001J\u0006\u0010~\u001a\u00020\nJ\u0006\u0010\u007f\u001a\u000202J\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\nJ\u001a\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010\u0081\u0001\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u001a\u0010\u0082\u0001\u001a\u0002022\u0006\u0010]\u001a\u00020\n2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0001J%\u0010\u0082\u0001\u001a\u0002022\u0006\u0010]\u001a\u00020\n2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010\u0085\u0001\u001a\u000202J\u000f\u0010\u0085\u0001\u001a\u0002022\u0006\u0010]\u001a\u00020\nJ\u001a\u0010\u0085\u0001\u001a\u0002022\u0006\u0010]\u001a\u00020\n2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0001J/\u0010\u0085\u0001\u001a\u0002022\u0006\u0010]\u001a\u00020\n2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020\u000e2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010\u0087\u0001\u001a\u0002022\u0006\u0010]\u001a\u00020\n2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0001J$\u0010\u0087\u0001\u001a\u0002022\u0006\u0010]\u001a\u00020\n2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010n\u001a\u0004\u0018\u00010\u0001J\t\u0010\u0088\u0001\u001a\u00020UH\u0016J\u0013\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u008a\u0001\u001a\u0002022\u0007\u0010\u008b\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u008d\u0001\u001a\u0002022\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u008e\u0001\u001a\u0002022\u0006\u0010=\u001a\u00020\nH\u0002J\u0019\u0010\u008f\u0001\u001a\u0002022\u0006\u0010=\u001a\u00020\n2\u0006\u0010|\u001a\u00020%H\u0002J\u0019\u0010\u0090\u0001\u001a\u0002022\u0006\u00106\u001a\u00020\u00072\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u0090\u0001\u001a\u0002022\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0091\u0001\u001a\u0002022\u0006\u00107\u001a\u00020\n2\b\u0010Z\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010\u0092\u0001\u001a\u0002022\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\u000f\u0010\u0093\u0001\u001a\u000202H\u0000¢\u0006\u0003\b\u0094\u0001J\u000f\u0010\u0095\u0001\u001a\u000202H\u0000¢\u0006\u0003\b\u0096\u0001J\u0015\u0010\u0097\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0014\u0010D\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0013\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\n0`*\u00020\u001cH\u0002J\u001b\u0010\u0099\u0001\u001a\u000202*\b0\u009a\u0001j\u0003`\u009b\u00012\u0006\u00107\u001a\u00020\nH\u0002J\u0015\u0010\u009c\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0014\u0010\"\u001a\u00020\n*\u00020\u001c2\u0006\u00107\u001a\u00020\nH\u0002J\u0015\u0010\u009d\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u001d\u0010\u009e\u0001\u001a\u000202*\u00020\u001c2\u0006\u00103\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u001f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\fR\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010)X\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006 \u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "capacity", "", "getCapacity", "()I", "<set-?>", "", "closed", "getClosed", "()Z", "currentGroup", "getCurrentGroup", "currentGroupEnd", "currentSlot", "currentSlotEnd", "endStack", "Landroidx/compose/runtime/IntStack;", "groupGapLen", "groupGapStart", "groups", "", "insertCount", "isGroupEnd", "isNode", "nodeCount", "nodeCountStack", "parent", "getParent", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "size", "getSize$runtime_release", "slots", "", "[Ljava/lang/Object;", "slotsGapLen", "slotsGapOwner", "slotsGapStart", "startStack", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "addToGroupSizeAlongSpine", "", "address", "amount", "advanceBy", "anchor", "index", "anchorIndex", "bashGroup", "bashGroup$runtime_release", "beginInsert", "childContainsAnyMarks", "group", "clearSlotGap", "close", "containsAnyGroupMarks", "containsGroupMark", "dataAnchorToDataIndex", "gapLen", "dataIndex", "dataIndexToDataAddress", "dataIndexToDataAnchor", "gapStart", "endGroup", "endInsert", "ensureStarted", "fixParentAnchorsFor", "firstChild", "groupAux", "groupIndexToAddress", "groupKey", "groupObjectKey", "groupSize", "groupSlots", "", "groupsAsString", "", "indexInCurrentGroup", "indexInGroup", "indexInParent", "insertAux", "value", "insertGroups", "insertParentGroup", STGroup.DICT_KEY, "insertSlots", "keys", "", "markGroup", "moveAnchors", "originalLocation", "newLocation", "moveFrom", "removeSourceGroup", "moveGroup", "offset", "moveGroupGapTo", "moveIntoGroupFrom", "moveSlotGapTo", "moveTo", "writer", "node", "parentAnchorToIndex", "parentIndexToAnchor", "recalculateMarks", "removeAnchors", "removeGroup", "removeGroups", "start", "len", "removeSlots", "reset", "restoreCurrentGroupEnd", "saveCurrentGroupEnd", "seek", "set", "skip", "skipGroup", "skipToGroupEnd", "slot", "groupIndex", "startData", "aux", "objectKey", "startGroup", "dataKey", "startNode", "toString", "update", "updateAnchors", "previousGapStart", "newGapStart", "updateAux", "updateContainsMark", "updateContainsMarkNow", "updateNode", "updateNodeOfGroup", "updateParentNode", "verifyDataAnchors", "verifyDataAnchors$runtime_release", "verifyParentAnchors", "verifyParentAnchors$runtime_release", "auxIndex", "dataIndexes", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nodeIndex", "slotIndex", "updateDataIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotWriter\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n+ 5 SlotTable.kt\nandroidx/compose/runtime/SlotTableKt\n+ 6 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,3471:1\n4548#2,5:3472\n4548#2,5:3477\n4548#2,5:3482\n4548#2,5:3487\n4548#2,5:3493\n4548#2,5:3498\n4548#2,5:3503\n4548#2,5:3508\n4548#2,5:3513\n4548#2,5:3518\n4548#2,5:3523\n4548#2,5:3528\n4548#2,5:3533\n4548#2,5:3538\n4548#2,5:3543\n4548#2,5:3548\n4548#2,5:3553\n4548#2,5:3558\n4548#2,5:3571\n4548#2,5:3590\n4548#2,5:3595\n4548#2,5:3600\n1#3:3492\n162#4,8:3563\n162#4,8:3576\n3351#5,6:3584\n33#6,6:3605\n82#6,3:3611\n33#6,4:3614\n85#6,2:3618\n38#6:3620\n87#6:3621\n231#6,3:3622\n64#6,4:3625\n234#6,2:3629\n69#6:3631\n236#6:3632\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotWriter\n*L\n1361#1:3472,5\n1385#1:3477,5\n1398#1:3482,5\n1401#1:3487,5\n1441#1:3493,5\n1456#1:3498,5\n1503#1:3503,5\n1508#1:3508,5\n1548#1:3513,5\n1559#1:3518,5\n1686#1:3523,5\n1762#1:3528,5\n1767#1:3533,5\n1799#1:3538,5\n1842#1:3543,5\n1843#1:3548,5\n1856#1:3553,5\n1950#1:3558,5\n2235#1:3571,5\n2522#1:3590,5\n2534#1:3595,5\n2731#1:3600,5\n2217#1:3563,8\n2307#1:3576,8\n2327#1:3584,6\n2827#1:3605,6\n2997#1:3611,3\n2997#1:3614,4\n2997#1:3618,2\n2997#1:3620\n2997#1:3621\n3000#1:3622,3\n3000#1:3625,4\n3000#1:3629,2\n3000#1:3631\n3000#1:3632\n*E\n"})
public final class SlotWriter {
    public static final Companion Companion = null;
    private ArrayList<Anchor> anchors;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private final IntStack endStack;
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private final IntStack nodeCountStack;
    private int parent;
    private PrioritySet pendingRecalculateMarks;
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private final IntStack startStack;
    private final SlotTable table;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotWriter$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,3471:1\n1#2:3472\n4548#3,5:3473\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotWriter$Companion\n*L\n2109#1:3473,5\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ List access$moveGroup(Companion r5, SlotWriter r10, int r11, SlotWriter r12, boolean r13, boolean r14, boolean r15) {
            return r5.moveGroup(r10, r11, r12, r13, r14, r15);
        }

        private final List<Anchor> moveGroup(SlotWriter r22, int r23, SlotWriter r24, boolean r25, boolean r26, boolean r27) {
            int r5 = r22.groupSize(r23);
            int r10 = r23 + r5;
            int r11 = SlotWriter.access$dataIndex(r22, r23);
            int r12 = SlotWriter.access$dataIndex(r22, r10);
            int r13 = r12 - r11;
            boolean r14 = SlotWriter.access$containsAnyGroupMarks(r22, r23);
            SlotWriter.access$insertGroups(r24, r5);
            SlotWriter.access$insertSlots(r24, r13, r24.getCurrentGroup());
            if (SlotWriter.access$getGroupGapStart$p(r22) >= r10) goto L6;
            SlotWriter.access$moveGroupGapTo(r22, r10);
        L6:
            if (SlotWriter.access$getSlotsGapStart$p(r22) >= r12) goto L8;
            SlotWriter.access$moveSlotGapTo(r22, r12, r10);
        L8:
            int[] r15 = SlotWriter.access$getGroups$p(r24);
            int r16 = r24.getCurrentGroup();
            ArraysKt.a(r16 * 5, r23 * 5, SlotWriter.access$getGroups$p(r22), r15, r10 * 5);
            Object[] r17 = SlotWriter.access$getSlots$p(r24);
            int r18 = SlotWriter.access$getCurrentSlot$p(r24);
            ArraysKt.copyInto(SlotWriter.access$getSlots$p(r22), r17, r18, r11, r12);
            int r19 = r24.getParent();
            SlotTableKt.access$updateParentAnchor(r15, r16, r19);
            int r110 = r16 - r23;
            int r111 = r16 + r5;
            int r112 = r18 - SlotWriter.access$dataIndex(r24, r15, r16);
            int r113 = SlotWriter.access$getSlotsGapOwner$p(r24);
            int r20 = SlotWriter.access$getSlotsGapLen$p(r24);
            int r114 = r17.length;
            int r21 = r113;
            int r115 = r16;
        L9:
            boolean r116 = false;
            int r117 = 0;
            boolean r118 = false;
            if (r115 >= r111) goto L22;
            if (r115 == r16) goto L14;
            SlotTableKt.access$updateParentAnchor(r15, r115, SlotTableKt.access$parentAnchor(r15, r115) + r110);
        L14:
            int r119 = SlotWriter.access$dataIndex(r24, r15, r115) + r112;
            if (r21 >= r115) goto L17;
        L16:
            int r120 = r112;
            SlotTableKt.access$updateDataAnchor(r15, r115, SlotWriter.access$dataIndexToDataAnchor(r24, r119, r117, r20, r114));
            if (r115 != r21) goto L21;
            r21 = r21 + 1;
        L21:
            r115 = r115 + 1;
            r112 = r120;
            r111 = r111;
            goto L9
        L17:
            r117 = SlotWriter.access$getSlotsGapStart$p(r24);
            goto L16
        L22:
            int r28 = r111;
            SlotWriter.access$setSlotsGapOwner$p(r24, r21);
            int r29 = SlotTableKt.access$locationOf(SlotWriter.access$getAnchors$p(r22), r23, r22.getSize$runtime_release());
            int r30 = SlotTableKt.access$locationOf(SlotWriter.access$getAnchors$p(r22), r10, r22.getSize$runtime_release());
            if (r29 >= r30) goto L28;
            ArrayList r31 = SlotWriter.access$getAnchors$p(r22);
            ArrayList r121 = new ArrayList(r30 - r29);
            int r122 = r29;
        L25:
            if (r122 >= r30) goto L27;
            Anchor r123 = (Anchor) r31.get(r122);
            r123.setLocation$runtime_release(r123.getLocation$runtime_release() + r110);
            r121.add(r123);
            r122 = r122 + 1;
            goto L25
        L27:
            SlotWriter.access$getAnchors$p(r24).addAll(SlotTableKt.access$locationOf(SlotWriter.access$getAnchors$p(r24), r24.getCurrentGroup(), r24.getSize$runtime_release()), r121);
            r31.subList(r29, r30).clear();
            List<Anchor> r124 = r121;
        L29:
            int r32 = r22.parent(r23);
            int r33 = 1;
            if (r27 == false) goto L42;
            if (r25 == false) goto L41;
            if (r32 < 0) goto L35;
            r118 = true;
        L35:
            if (r118 == false) goto L37;
            r22.startGroup();
            r22.advanceBy(r32 - r22.getCurrentGroup());
            r22.startGroup();
        L37:
            r22.advanceBy(r23 - r22.getCurrentGroup());
            boolean r34 = r22.removeGroup();
            if (r118 == false) goto L40;
            r22.skipToGroupEnd();
            r22.endGroup();
            r22.skipToGroupEnd();
            r22.endGroup();
        L40:
            r116 = r34;
            goto L42
        L41:
            r116 = SlotWriter.access$removeGroups(r22, r23, r5);
            SlotWriter.access$removeSlots(r22, r11, r13, r23 - 1);
        L42:
            if (r116 == true) goto L54;
            int r35 = SlotWriter.access$getNodeCount$p(r24);
            if (SlotTableKt.access$isNode(r15, r16) == true) goto L47;
            r33 = SlotTableKt.access$nodeCount(r15, r16);
        L47:
            SlotWriter.access$setNodeCount$p(r24, r35 + r33);
            if (r26 == false) goto L50;
            SlotWriter.access$setCurrentGroup$p(r24, r28);
            SlotWriter.access$setCurrentSlot$p(r24, r18 + r13);
        L50:
            if (r14 == false) goto L52;
            SlotWriter.access$updateContainsMark(r24, r19);
        L52:
            return r124;
        L54:
            throw j0.z("Unexpectedly removed anchors");
        L28:
            r124 = CollectionsKt.emptyList();
            goto L29
        }

        public static /* synthetic */ List moveGroup$default(Companion r10, SlotWriter r11, int r12, SlotWriter r13, boolean r14, boolean r15, boolean r16, int r17, Object r18) {
            if ((r17 & 32) == 0) goto L6;
            r16 = true;
        L6:
            return r10.moveGroup(r11, r12, r13, r14, r15, r16);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SlotWriter$groupSlots$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"androidx/compose/runtime/SlotWriter$groupSlots$1", "", "", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", "next", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {
        final /* synthetic */ int $end;
        private int current;
        final /* synthetic */ SlotWriter this$0;

        public AnonymousClass1(int r5, int r10, SlotWriter r11) {
            this.$end = r10;
            this.this$0 = r11;
            this.current = r5;
        }

        public final int getCurrent() {
            return this.current;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.current >= this.$end) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext() == false) goto L5;
            Object[] r5 = SlotWriter.access$getSlots$p(this.this$0);
            SlotWriter r10 = this.this$0;
            int r11 = this.current;
            this.current = r11 + 1;
            return r5[SlotWriter.access$dataIndexToDataAddress(r10, r11)];
        L5:
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setCurrent(int r5) {
            this.current = r5;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SlotWriter(SlotTable r5) {
        Intrinsics.checkNotNullParameter(r5, "table");
        this.table = r5;
        this.groups = r5.getGroups();
        this.slots = r5.getSlots();
        this.anchors = r5.getAnchors$runtime_release();
        this.groupGapStart = r5.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - r5.getGroupsSize();
        this.currentGroupEnd = r5.getGroupsSize();
        this.slotsGapStart = r5.getSlotsSize();
        this.slotsGapLen = this.slots.length - r5.getSlotsSize();
        this.slotsGapOwner = r5.getGroupsSize();
        this.startStack = new IntStack();
        this.endStack = new IntStack();
        this.nodeCountStack = new IntStack();
        this.parent = -1;
    }

    public static final /* synthetic */ boolean access$containsAnyGroupMarks(SlotWriter r5, int r10) {
        return r5.containsAnyGroupMarks(r10);
    }

    public static final /* synthetic */ int access$dataIndex(SlotWriter r5, int r10) {
        return r5.dataIndex(r10);
    }

    public static final /* synthetic */ int access$dataIndexToDataAddress(SlotWriter r5, int r10) {
        return r5.dataIndexToDataAddress(r10);
    }

    public static final /* synthetic */ int access$dataIndexToDataAnchor(SlotWriter r5, int r10, int r11, int r12, int r13) {
        return r5.dataIndexToDataAnchor(r10, r11, r12, r13);
    }

    public static final /* synthetic */ ArrayList access$getAnchors$p(SlotWriter r5) {
        return r5.anchors;
    }

    public static final /* synthetic */ int access$getCurrentSlot$p(SlotWriter r5) {
        return r5.currentSlot;
    }

    public static final /* synthetic */ int access$getGroupGapStart$p(SlotWriter r5) {
        return r5.groupGapStart;
    }

    public static final /* synthetic */ int[] access$getGroups$p(SlotWriter r5) {
        return r5.groups;
    }

    public static final /* synthetic */ int access$getNodeCount$p(SlotWriter r5) {
        return r5.nodeCount;
    }

    public static final /* synthetic */ Object[] access$getSlots$p(SlotWriter r5) {
        return r5.slots;
    }

    public static final /* synthetic */ int access$getSlotsGapLen$p(SlotWriter r5) {
        return r5.slotsGapLen;
    }

    public static final /* synthetic */ int access$getSlotsGapOwner$p(SlotWriter r5) {
        return r5.slotsGapOwner;
    }

    public static final /* synthetic */ int access$getSlotsGapStart$p(SlotWriter r5) {
        return r5.slotsGapStart;
    }

    public static final /* synthetic */ void access$insertGroups(SlotWriter r5, int r10) {
        r5.insertGroups(r10);
    }

    public static final /* synthetic */ void access$insertSlots(SlotWriter r5, int r10, int r11) {
        r5.insertSlots(r10, r11);
    }

    public static final /* synthetic */ void access$moveGroupGapTo(SlotWriter r5, int r10) {
        r5.moveGroupGapTo(r10);
    }

    public static final /* synthetic */ void access$moveSlotGapTo(SlotWriter r5, int r10, int r11) {
        r5.moveSlotGapTo(r10, r11);
    }

    public static final /* synthetic */ boolean access$removeGroups(SlotWriter r5, int r10, int r11) {
        return r5.removeGroups(r10, r11);
    }

    public static final /* synthetic */ void access$removeSlots(SlotWriter r5, int r10, int r11, int r12) {
        r5.removeSlots(r10, r11, r12);
    }

    public static final /* synthetic */ void access$setCurrentGroup$p(SlotWriter r5, int r10) {
        r5.currentGroup = r10;
    }

    public static final /* synthetic */ void access$setCurrentSlot$p(SlotWriter r5, int r10) {
        r5.currentSlot = r10;
    }

    public static final /* synthetic */ void access$setNodeCount$p(SlotWriter r5, int r10) {
        r5.nodeCount = r10;
    }

    public static final /* synthetic */ void access$setSlotsGapOwner$p(SlotWriter r5, int r10) {
        r5.slotsGapOwner = r10;
    }

    public static final /* synthetic */ void access$updateContainsMark(SlotWriter r5, int r10) {
        r5.updateContainsMark(r10);
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.currentGroup;
    L6:
        return r5.anchor(r10);
    }

    private final int auxIndex(int[] r5, int r10) {
        int r11 = dataIndex(r5, r10);
        return SlotTableKt.access$countOneBits(SlotTableKt.access$groupInfo(r5, r10) >> 29) + r11;
    }

    private final boolean childContainsAnyMarks(int r5) {
        int r10 = r5 + 1;
        int r11 = groupSize(r5) + r5;
    L3:
        if (r10 >= r11) goto L9;
        if (SlotTableKt.access$containsAnyMark(this.groups, groupIndexToAddress(r10)) == true) goto L6;
        r10 = r10 + groupSize(r10);
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private final void clearSlotGap() {
        int r5 = this.slotsGapStart;
        int r10 = this.slotsGapLen + r5;
        ArraysKt.fill(this.slots, null, r5, r10);
    }

    private final boolean containsAnyGroupMarks(int r5) {
        if (r5 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (SlotTableKt.access$containsAnyMark(this.groups, groupIndexToAddress(r5)) == false) goto L6;
        return true;
    }

    private final boolean containsGroupMark(int r5) {
        if (r5 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (SlotTableKt.access$containsMark(this.groups, groupIndexToAddress(r5)) == false) goto L6;
        return true;
    }

    private final int dataAnchorToDataIndex(int r5, int r10, int r11) {
        if (r5 < 0) goto L4;
        return r5;
    L4:
        return ((r11 - r10) + r5) + 1;
    }

    private final int dataIndex(int r5) {
        return dataIndex(this.groups, groupIndexToAddress(r5));
    }

    private final int dataIndexToDataAddress(int r5) {
        if (r5 >= this.slotsGapStart) goto L6;
        return r5;
    L6:
        return r5 + this.slotsGapLen;
    }

    private final int dataIndexToDataAnchor(int r5, int r10, int r11, int r12) {
        if (r5 > r10) goto L4;
        return r5;
    L4:
        return -(((r12 - r11) - r5) + 1);
    }

    private final List<Integer> dataIndexes(int[] r10) {
        int r5 = 0;
        List r11 = SlotTableKt.dataAnchors$default(this.groups, 0, 1, null);
        List r12 = CollectionsKt.plus(CollectionsKt.slice(r11, RangesKt.until(0, this.groupGapStart)), CollectionsKt.slice(r11, RangesKt.until(this.groupGapStart + this.groupGapLen, r10.length / 5)));
        ArrayList r13 = new ArrayList(r12.size());
        int r14 = r12.size();
    L3:
        if (r5 >= r14) goto L5;
        r13.add(Integer.valueOf(dataAnchorToDataIndex(((Number) r12.get(r5)).intValue(), this.slotsGapLen, this.slots.length)));
        r5 = r5 + 1;
        goto L3
    L5:
        return r13;
    }

    private final void fixParentAnchorsFor(int r5, int r10, int r11) {
        int r12 = parentIndexToAnchor(r5, this.groupGapStart);
    L3:
        if (r11 >= r10) goto L5;
        SlotTableKt.access$updateParentAnchor(this.groups, groupIndexToAddress(r11), r12);
        int r13 = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(r11)) + r11;
        fixParentAnchorsFor(r11, r13, r11 + 1);
        r11 = r13;
        goto L3
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    private final void groupAsString(StringBuilder r10, int r11) {
        int r5 = groupIndexToAddress(r11);
        r10.append("Group(");
        if (r11 >= 10) goto L6;
        r10.append(' ');
    L6:
        if (r11 >= 100) goto L9;
        r10.append(' ');
    L9:
        if (r11 >= 1000) goto L11;
        r10.append(' ');
    L11:
        r10.append(r11);
        if (r5 == r11) goto L14;
        r10.append("(");
        r10.append(r5);
        r10.append(")");
    L14:
        r10.append('#');
        r10.append(SlotTableKt.access$groupSize(this.groups, r5));
        boolean r12 = groupAsString$isStarted(this, r11);
        if (r12 == false) goto L17;
        r10.append('?');
    L17:
        r10.append('^');
        r10.append(parentAnchorToIndex(SlotTableKt.access$parentAnchor(this.groups, r5)));
        r10.append(": key=");
        r10.append(SlotTableKt.access$key(this.groups, r5));
        r10.append(", nodes=");
        r10.append(SlotTableKt.access$nodeCount(this.groups, r5));
        if (r12 == false) goto L20;
        r10.append('?');
    L20:
        r10.append(", dataAnchor=");
        r10.append(SlotTableKt.access$dataAnchor(this.groups, r5));
        r10.append(", parentAnchor=");
        r10.append(SlotTableKt.access$parentAnchor(this.groups, r5));
        if (SlotTableKt.access$isNode(this.groups, r5) == false) goto L23;
        r10.append(", node=" + this.slots[dataIndexToDataAddress(nodeIndex(this.groups, r5))]);
    L23:
        int r13 = slotIndex(this.groups, r5);
        int r14 = dataIndex(this.groups, r5 + 1);
        if (r14 <= r13) goto L31;
        r10.append(", [");
        int r15 = r13;
    L26:
        if (r15 >= r14) goto L30;
        if (r15 == r13) goto L29;
        r10.append(", ");
    L29:
        r10.append(String.valueOf(this.slots[dataIndexToDataAddress(r15)]));
        r15 = r15 + 1;
        goto L26
    L30:
        r10.append(']');
    L31:
        r10.append(")");
    }

    private static final boolean groupAsString$isStarted(SlotWriter r5, int r10) {
        if (r10 < r5.currentGroup) goto L5;
    L11:
        return false;
    L5:
        if (r10 != r5.parent) goto L7;
    L10:
        return true;
    L7:
        if (r5.startStack.indexOf(r10) >= 0) goto L10;
        if (groupAsString$isStarted(r5, r5.parent(r10)) == false) goto L11;
        goto L10
    }

    private final int groupIndexToAddress(int r5) {
        if (r5 >= this.groupGapStart) goto L6;
        return r5;
    L6:
        return r5 + this.groupGapLen;
    }

    private final void insertGroups(int r12) {
        if (r12 <= 0) goto L25;
        int r5 = this.currentGroup;
        moveGroupGapTo(r5);
        int r10 = this.groupGapStart;
        int r11 = this.groupGapLen;
        int[] r13 = this.groups;
        int r14 = r13.length / 5;
        int r15 = r14 - r11;
        int r16 = 0;
        if (r11 >= r12) goto L6;
        int r17 = Math.max(Math.max(r14 * 2, r15 + r12), 32);
        int[] r18 = new int[r17 * 5];
        int r19 = r17 - r15;
        ArraysKt.a(0, 0, r13, r18, r10 * 5);
        ArraysKt.a((r10 + r19) * 5, (r11 + r10) * 5, r13, r18, r14 * 5);
        this.groups = r18;
        r11 = r19;
    L6:
        int r20 = this.currentGroupEnd;
        if (r20 < r10) goto L9;
        this.currentGroupEnd = r20 + r12;
    L9:
        int r21 = r10 + r12;
        this.groupGapStart = r21;
        this.groupGapLen = r11 - r12;
        if (r15 <= 0) goto L12;
        int r22 = dataIndex(r5 + r12);
    L14:
        if (this.slotsGapOwner < r10) goto L17;
        r16 = this.slotsGapStart;
    L17:
        int r23 = dataIndexToDataAnchor(r22, r16, this.slotsGapLen, this.slots.length);
        int r24 = r10;
    L18:
        if (r24 >= r21) goto L20;
        SlotTableKt.access$updateDataAnchor(this.groups, r24, r23);
        r24 = r24 + 1;
        goto L18
    L20:
        int r25 = this.slotsGapOwner;
        if (r25 < r10) goto L26;
        this.slotsGapOwner = r25 + r12;
        return;
    L26:
        return;
    L12:
        r22 = 0;
        goto L14
    }

    private final void insertSlots(int r10, int r11) {
        if (r10 <= 0) goto L15;
        moveSlotGapTo(this.currentSlot, r11);
        int r12 = this.slotsGapStart;
        int r5 = this.slotsGapLen;
        if (r5 >= r10) goto L9;
        Object[] r13 = this.slots;
        int r14 = r13.length;
        int r15 = r14 - r5;
        int r16 = Math.max(Math.max(r14 * 2, r15 + r10), 32);
        Object[] r17 = new Object[r16];
        int r18 = 0;
    L6:
        if (r18 >= r16) goto L8;
        r17[r18] = null;
        r18 = r18 + 1;
        goto L6
    L8:
        int r19 = r16 - r15;
        ArraysKt.copyInto(r13, r17, 0, 0, r12);
        ArraysKt.copyInto(r13, r17, r12 + r19, r5 + r12, r14);
        this.slots = r17;
        r5 = r19;
    L9:
        int r20 = this.currentSlotEnd;
        if (r20 < r12) goto L12;
        this.currentSlotEnd = r20 + r10;
    L12:
        this.slotsGapStart = r12 + r10;
        this.slotsGapLen = r5 - r10;
        return;
    }

    private final List<Integer> keys() {
        int r5 = 0;
        List r10 = SlotTableKt.keys$default(this.groups, 0, 1, null);
        ArrayList r11 = new ArrayList(r10.size());
        int r12 = r10.size();
    L3:
        if (r5 >= r12) goto L10;
        Object r13 = r10.get(r5);
        ((Number) r13).intValue();
        int r14 = this.groupGapStart;
        if (r5 >= r14) goto L7;
    L8:
        r11.add(r13);
    L9:
        r5 = r5 + 1;
        goto L3
    L7:
        if (r5 < (r14 + this.groupGapLen)) goto L9;
    L10:
        return r11;
    }

    public static /* synthetic */ void markGroup$default(SlotWriter r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = r5.parent;
    L5:
        r5.markGroup(r10);
    }

    private final void moveAnchors(int r10, int r11, int r12) {
        int r13 = r12 + r10;
        int r5 = getSize$runtime_release();
        int r14 = SlotTableKt.access$locationOf(this.anchors, r10, r5);
        ArrayList r15 = new ArrayList();
        if (r14 >= 0) goto L5;
    L10:
        int r16 = r11 - r10;
        int r17 = r15.size();
        int r18 = 0;
    L11:
        if (r18 >= r17) goto L17;
        Anchor r19 = (Anchor) r15.get(r18);
        int r20 = anchorIndex(r19) + r16;
        if (r20 < this.groupGapStart) goto L15;
        r19.setLocation$runtime_release(-(r5 - r20));
    L16:
        int r21 = SlotTableKt.access$locationOf(this.anchors, r20, r5);
        this.anchors.add(r21, r19);
        r18 = r18 + 1;
        goto L11
    L15:
        r19.setLocation$runtime_release(r20);
        goto L16
    L17:
        return;
    L5:
        if (r14 >= this.anchors.size()) goto L10;
        Anchor r22 = this.anchors.get(r14);
        int r23 = anchorIndex(r22);
        if (r23 < r10) goto L10;
        if (r23 >= r13) goto L10;
        r15.add(r22);
        this.anchors.remove(r14);
        goto L5
    }

    public static /* synthetic */ List moveFrom$default(SlotWriter r5, SlotTable r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = true;
    L6:
        return r5.moveFrom(r10, r11, r12);
    }

    private final void moveGroupGapTo(int r10) {
        int r5 = this.groupGapLen;
        int r11 = this.groupGapStart;
        if (r11 != r10) goto L5;
    L26:
        this.groupGapStart = r10;
        return;
    L5:
        if (this.anchors.isEmpty() == true) goto L7;
        updateAnchors(r11, r10);
    L7:
        if (r5 <= 0) goto L12;
        int[] r12 = this.groups;
        int r13 = r10 * 5;
        int r14 = r5 * 5;
        int r15 = r11 * 5;
        if (r10 >= r11) goto L11;
        ArraysKt.a(r14 + r13, r13, r12, r12, r15);
        goto L12
    L11:
        ArraysKt.a(r15, r15 + r14, r12, r12, r13 + r14);
    L12:
        if (r10 >= r11) goto L14;
        r11 = r10 + r5;
    L14:
        int r16 = getCapacity();
        if (r11 >= r16) goto L17;
        boolean r17 = true;
    L18:
        ComposerKt.runtimeCheck(r17);
    L19:
        if (r11 >= r16) goto L26;
        int r18 = SlotTableKt.access$parentAnchor(this.groups, r11);
        int r19 = parentIndexToAnchor(parentAnchorToIndex(r18), r10);
        if (r19 == r18) goto L23;
        SlotTableKt.access$updateParentAnchor(this.groups, r11, r19);
    L23:
        r11 = r11 + 1;
        if (r11 != r10) goto L19;
        r11 = r11 + r5;
        goto L19
    L17:
        r17 = false;
        goto L18
    }

    private final void moveSlotGapTo(int r10, int r11) {
        int r5 = this.slotsGapLen;
        int r12 = this.slotsGapStart;
        int r13 = this.slotsGapOwner;
        if (r12 == r10) goto L8;
        Object[] r14 = this.slots;
        if (r10 >= r12) goto L7;
        ArraysKt.copyInto(r14, r14, r10 + r5, r10, r12);
        goto L8
    L7:
        ArraysKt.copyInto(r14, r14, r12, r12 + r5, r10 + r5);
    L8:
        int r15 = Math.min(r11 + 1, getSize$runtime_release());
        if (r13 == r15) goto L37;
        int r16 = this.slots.length - r5;
        if (r15 >= r13) goto L24;
        int r17 = groupIndexToAddress(r15);
        int r18 = groupIndexToAddress(r13);
        int r19 = this.groupGapStart;
    L13:
        if (r17 >= r18) goto L36;
        int r20 = SlotTableKt.access$dataAnchor(this.groups, r17);
        if (r20 < 0) goto L17;
        boolean r21 = true;
    L18:
        if (r21 == false) goto L23;
        SlotTableKt.access$updateDataAnchor(this.groups, r17, -((r16 - r20) + 1));
        r17 = r17 + 1;
        if (r17 != r19) goto L13;
        r17 = r17 + this.groupGapLen;
        goto L13
    L23:
        throw j0.z("Unexpected anchor value, expected a positive anchor");
    L17:
        r21 = false;
    L36:
        this.slotsGapOwner = r15;
        goto L37
    L24:
        int r22 = groupIndexToAddress(r13);
        int r23 = groupIndexToAddress(r15);
    L25:
        if (r22 >= r23) goto L36;
        int r24 = SlotTableKt.access$dataAnchor(this.groups, r22);
        if (r24 >= 0) goto L29;
        boolean r25 = true;
    L30:
        if (r25 == false) goto L35;
        SlotTableKt.access$updateDataAnchor(this.groups, r22, (r24 + r16) + 1);
        r22 = r22 + 1;
        if (r22 != this.groupGapStart) goto L25;
        r22 = r22 + this.groupGapLen;
        goto L25
    L35:
        throw j0.z("Unexpected anchor value, expected a negative anchor");
    L29:
        r25 = false;
    L37:
        this.slotsGapStart = r10;
    }

    private final int nodeIndex(int[] r5, int r10) {
        return dataIndex(r5, r10);
    }

    private final int parentAnchorToIndex(int r5) {
        if (r5 <= (-2)) goto L6;
        return r5;
    L6:
        return (getSize$runtime_release() + r5) + 2;
    }

    private final int parentIndexToAnchor(int r5, int r10) {
        if (r5 >= r10) goto L5;
        return r5;
    L5:
        return -((getSize$runtime_release() - r5) + 2);
    }

    private final void recalculateMarks() {
        PrioritySet r5 = this.pendingRecalculateMarks;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isNotEmpty() == false) goto L9;
        updateContainsMarkNow(r5.takeMax(), r5);
        goto L5
    }

    private final boolean removeAnchors(int r10, int r11) {
        int r12 = r11 + r10;
        int r5 = SlotTableKt.access$locationOf(this.anchors, r12, getCapacity() - this.groupGapLen);
        if (r5 < this.anchors.size()) goto L5;
        r5 = r5 - 1;
    L5:
        int r13 = r5 + 1;
        boolean r14 = false;
        int r15 = 0;
    L6:
        if (r5 < 0) goto L15;
        Anchor r16 = this.anchors.get(r5);
        int r17 = anchorIndex(r16);
        if (r17 < r10) goto L15;
        if (r17 >= r12) goto L14;
        r16.setLocation$runtime_release(Integer.MIN_VALUE);
        if (r15 != 0) goto L13;
        r15 = r5 + 1;
    L13:
        r13 = r5;
    L14:
        r5 = r5 - 1;
    L15:
        if (r13 >= r15) goto L17;
        r14 = true;
    L17:
        if (r14 == false) goto L19;
        this.anchors.subList(r13, r15).clear();
    L19:
        return r14;
    }

    private final boolean removeGroups(int r5, int r10) {
        boolean r11 = false;
        if (r10 <= 0) goto L16;
        ArrayList<Anchor> r12 = this.anchors;
        moveGroupGapTo(r5);
        if (r12.isEmpty() == true) goto L7;
        r11 = removeAnchors(r5, r10);
    L7:
        this.groupGapStart = r5;
        this.groupGapLen += r10;
        int r13 = this.slotsGapOwner;
        if (r13 <= r5) goto L10;
        this.slotsGapOwner = Math.max(r5, r13 - r10);
    L10:
        int r14 = this.currentGroupEnd;
        if (r14 < this.groupGapStart) goto L14;
        this.currentGroupEnd = r14 - r10;
    L14:
        if (containsGroupMark(this.parent) == false) goto L16;
        updateContainsMark(this.parent);
    L16:
        return r11;
    }

    private final void removeSlots(int r5, int r10, int r11) {
        if (r10 <= 0) goto L7;
        int r12 = this.slotsGapLen;
        int r13 = r5 + r10;
        moveSlotGapTo(r13, r11);
        this.slotsGapStart = r5;
        this.slotsGapLen = r12 + r10;
        ArraysKt.fill(this.slots, null, r5, r13);
        int r14 = this.currentSlotEnd;
        if (r14 < r5) goto L8;
        this.currentSlotEnd = r14 - r10;
        return;
    L8:
        return;
    }

    private final int restoreCurrentGroupEnd() {
        int r5 = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = r5;
        return r5;
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int slotIndex(int[] r5, int r10) {
        if (r10 < getCapacity()) goto L6;
        return this.slots.length - this.slotsGapLen;
    L6:
        return dataAnchorToDataIndex(SlotTableKt.access$slotAnchor(r5, r10), this.slotsGapLen, this.slots.length);
    }

    private final void updateAnchors(int r5, int r10) {
        int r11 = this.groupGapLen;
        int r12 = getCapacity() - r11;
        if (r5 >= r10) goto L12;
        int r13 = SlotTableKt.access$locationOf(this.anchors, r5, r12);
    L6:
        if (r13 >= this.anchors.size()) goto L18;
        Anchor r14 = this.anchors.get(r13);
        int r15 = r14.getLocation$runtime_release();
        if (r15 >= 0) goto L24;
        int r16 = r15 + r12;
        if (r16 >= r10) goto L25;
        r14.setLocation$runtime_release(r16);
        r13 = r13 + 1;
        goto L6
    L25:
        return;
    L24:
        return;
    L18:
        return;
    L12:
        int r17 = SlotTableKt.access$locationOf(this.anchors, r10, r12);
    L14:
        if (r17 >= this.anchors.size()) goto L27;
        Anchor r18 = this.anchors.get(r17);
        int r19 = r18.getLocation$runtime_release();
        if (r19 < 0) goto L26;
        r18.setLocation$runtime_release(-(r12 - r19));
        r17 = r17 + 1;
        goto L14
    L26:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateContainsMark(int r5) {
        if (r5 < 0) goto L8;
        PrioritySet r10 = this.pendingRecalculateMarks;
        if (r10 != null) goto L6;
        List r11 = null;
        r10 = new PrioritySet(r11, 1, 0 == true ? 1 : 0);
        this.pendingRecalculateMarks = r10;
    L6:
        r10.add(r5);
        return;
    }

    private final void updateContainsMarkNow(int r5, PrioritySet r10) {
        int r11 = groupIndexToAddress(r5);
        boolean r12 = childContainsAnyMarks(r5);
        if (SlotTableKt.access$containsMark(this.groups, r11) == r12) goto L8;
        SlotTableKt.access$updateContainsMark(this.groups, r11, r12);
        int r13 = parent(r5);
        if (r13 < 0) goto L9;
        r10.add(r13);
        return;
    L9:
        return;
    }

    private final void updateDataIndex(int[] r5, int r10, int r11) {
        SlotTableKt.access$updateDataAnchor(r5, r10, dataIndexToDataAnchor(r11, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    private final void updateNodeOfGroup(int r5, Object r10) {
        int r11 = groupIndexToAddress(r5);
        int[] r12 = this.groups;
        if (r11 < r12.length) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L11;
        this.slots[dataIndexToDataAddress(nodeIndex(this.groups, r11))] = r10;
        return;
    L11:
        ComposerKt.composeRuntimeError(("Updating the node of a group at " + r5 + " that was not created with as a node group").toString());
        throw new KotlinNothingValueException();
    L5:
        if (SlotTableKt.access$isNode(r12, r11) == false) goto L7;
        r13 = true;
        goto L8
    }

    public final void addToGroupSizeAlongSpine(int r5, int r10) {
    L2:
        if (r5 <= 0) goto L4;
        int[] r11 = this.groups;
        SlotTableKt.access$updateGroupSize(r11, r5, SlotTableKt.access$groupSize(r11, r5) + r10);
        r5 = groupIndexToAddress(parentAnchorToIndex(SlotTableKt.access$parentAnchor(this.groups, r5)));
        goto L2
    }

    public final void advanceBy(int r5) {
        boolean r10 = false;
        if (r5 < 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L24;
        if (this.insertCount > 0) goto L22;
        if (r5 != 0) goto L11;
        return;
    L11:
        int r12 = this.currentGroup + r5;
        if (r12 >= this.parent) goto L14;
    L16:
        if (r10 == false) goto L19;
        this.currentGroup = r12;
        int r13 = dataIndex(this.groups, groupIndexToAddress(r12));
        this.currentSlot = r13;
        this.currentSlotEnd = r13;
        return;
    L19:
        ComposerKt.composeRuntimeError(("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')').toString());
        throw new KotlinNothingValueException();
    L14:
        if (r12 > this.currentGroupEnd) goto L16;
        r10 = true;
        goto L16
    L22:
        throw new IllegalStateException("Cannot call seek() while inserting");
    L24:
        throw j0.z("Cannot seek backwards");
    L5:
        r11 = false;
        goto L6
    }

    public final Anchor anchor(int r5) {
        ArrayList<Anchor> r10 = this.anchors;
        int r11 = SlotTableKt.access$search(r10, r5, getSize$runtime_release());
        if (r11 >= 0) goto L10;
        if (r5 <= this.groupGapStart) goto L8;
        r5 = -(getSize$runtime_release() - r5);
    L8:
        Anchor r12 = new Anchor(r5);
        r10.add(-(r11 + 1), r12);
        return r12;
    L10:
        return r10.get(r11);
    }

    public final int anchorIndex(Anchor r5) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        int r10 = r5.getLocation$runtime_release();
        if (r10 < 0) goto L5;
        return r10;
    L5:
        return r10 + getSize$runtime_release();
    }

    public final void bashGroup$runtime_release() {
        startGroup();
    L4:
        if (isGroupEnd() == true) goto L6;
        insertParentGroup(-3);
        skipGroup();
        goto L4
    L6:
        endGroup();
    }

    public final void beginInsert() {
        int r5 = this.insertCount;
        this.insertCount = r5 + 1;
        if (r5 != 0) goto L6;
        saveCurrentGroupEnd();
        return;
    }

    public final void close() {
        this.closed = true;
        if (this.startStack.isEmpty() == false) goto L5;
        moveGroupGapTo(getSize$runtime_release());
        moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
        clearSlotGap();
        recalculateMarks();
    L5:
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors);
    }

    public final int endGroup() {
        int r5 = 1;
        int r10 = 0;
        if (this.insertCount <= 0) goto L5;
        boolean r11 = true;
    L6:
        int r12 = this.currentGroup;
        int r13 = this.currentGroupEnd;
        int r14 = this.parent;
        int r15 = groupIndexToAddress(r14);
        int r16 = this.nodeCount;
        int r17 = r12 - r14;
        boolean r18 = SlotTableKt.access$isNode(this.groups, r15);
        if (r11 == false) goto L13;
        SlotTableKt.access$updateGroupSize(this.groups, r15, r17);
        SlotTableKt.access$updateNodeCount(this.groups, r15, r16);
        int r19 = this.nodeCountStack.pop();
        if (r18 == true) goto L12;
        r5 = r16;
    L12:
        this.nodeCount = r19 + r5;
        this.parent = parent(this.groups, r14);
    L43:
        return r16;
    L13:
        if (r12 == r13) goto L16;
        r5 = 0;
    L16:
        if (r5 == 0) goto L45;
        int r20 = SlotTableKt.access$groupSize(this.groups, r15);
        int r21 = SlotTableKt.access$nodeCount(this.groups, r15);
        SlotTableKt.access$updateGroupSize(this.groups, r15, r17);
        SlotTableKt.access$updateNodeCount(this.groups, r15, r16);
        int r22 = this.startStack.pop();
        restoreCurrentGroupEnd();
        this.parent = r22;
        int r23 = parent(this.groups, r14);
        int r24 = this.nodeCountStack.pop();
        this.nodeCount = r24;
        if (r23 != r22) goto L23;
        if (r18 == true) goto L22;
        r10 = r16 - r21;
    L22:
        this.nodeCount = r24 + r10;
        goto L43
    L23:
        int r25 = r17 - r20;
        if (r18 == false) goto L26;
        int r26 = 0;
    L27:
        if (r25 != 0) goto L29;
        if (r26 != 0) goto L29;
    L42:
        this.nodeCount += r26;
    L29:
        if (r23 == 0) goto L42;
        if (r23 == r22) goto L42;
        if (r26 != 0) goto L33;
        if (r25 == 0) goto L42;
    L33:
        int r27 = groupIndexToAddress(r23);
        if (r25 == 0) goto L36;
        SlotTableKt.access$updateGroupSize(this.groups, r27, SlotTableKt.access$groupSize(this.groups, r27) + r25);
    L36:
        if (r26 == 0) goto L39;
        int[] r28 = this.groups;
        SlotTableKt.access$updateNodeCount(r28, r27, SlotTableKt.access$nodeCount(r28, r27) + r26);
    L39:
        if (SlotTableKt.access$isNode(this.groups, r27) == false) goto L41;
        r26 = 0;
    L41:
        r23 = parent(this.groups, r23);
        goto L29
    L26:
        r26 = r16 - r21;
        goto L27
    L45:
        throw j0.z("Expected to be at the end of a group");
    L5:
        r11 = false;
        goto L6
    }

    public final void endInsert() {
        int r5 = this.insertCount;
        if (r5 <= 0) goto L16;
        int r10 = r5 - 1;
        this.insertCount = r10;
        if (r10 == 0) goto L7;
        return;
    L7:
        if (this.nodeCountStack.getSize() != this.startStack.getSize()) goto L9;
        boolean r11 = true;
    L10:
        if (r11 == false) goto L13;
        restoreCurrentGroupEnd();
        return;
    L13:
        throw j0.z("startGroup/endGroup mismatch while inserting");
    L9:
        r11 = false;
        goto L10
    L16:
        throw new IllegalStateException("Unbalanced begin/end insert");
    }

    public final void ensureStarted(int r5) {
        boolean r10 = false;
        if (this.insertCount > 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L19;
        int r12 = this.parent;
        if (r12 == r5) goto L17;
        if (r5 >= r12) goto L11;
    L13:
        if (r10 == false) goto L15;
        int r13 = this.currentGroup;
        int r14 = this.currentSlot;
        int r15 = this.currentSlotEnd;
        this.currentGroup = r5;
        startGroup();
        this.currentGroup = r13;
        this.currentSlot = r14;
        this.currentSlotEnd = r15;
        return;
    L15:
        ComposerKt.composeRuntimeError(("Started group at " + r5 + " must be a subgroup of the group at " + r12).toString());
        throw new KotlinNothingValueException();
    L11:
        if (r5 >= this.currentGroupEnd) goto L13;
        r10 = true;
        goto L13
    L17:
        return;
    L19:
        throw j0.z("Cannot call ensureStarted() while inserting");
    L5:
        r11 = false;
        goto L6
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    public final Object groupAux(int r5) {
        int r10 = groupIndexToAddress(r5);
        if (SlotTableKt.access$hasAux(this.groups, r10) == false) goto L6;
        return this.slots[auxIndex(this.groups, r10)];
    L6:
        return Composer.Companion.getEmpty();
    }

    public final int groupKey(int r5) {
        return SlotTableKt.access$key(this.groups, groupIndexToAddress(r5));
    }

    public final Object groupObjectKey(int r5) {
        int r10 = groupIndexToAddress(r5);
        if (SlotTableKt.access$hasObjectKey(this.groups, r10) == true) goto L7;
        return null;
    L7:
        return this.slots[SlotTableKt.access$objectKeyIndex(this.groups, r10)];
    }

    public final int groupSize(int r5) {
        return SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(r5));
    }

    public final Iterator<Object> groupSlots() {
        int r5 = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] r10 = this.groups;
        int r11 = this.currentGroup;
        return new AnonymousClass1(r5, dataIndex(r10, groupIndexToAddress(groupSize(r11) + r11)), this);
    }

    public final String groupsAsString() {
        StringBuilder r5 = new StringBuilder();
        int r10 = getSize$runtime_release();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L6;
        groupAsString(r5, r11);
        r5.append('\n');
        r11 = r11 + 1;
        goto L3
    L6:
        return r5.toString();
    }

    public final boolean indexInCurrentGroup(int r5) {
        return indexInGroup(r5, this.currentGroup);
    }

    public final boolean indexInGroup(int r5, int r10) {
        if (r10 != this.parent) goto L6;
        int r11 = this.currentGroupEnd;
    L13:
        if (r5 <= r10) goto L17;
        if (r5 >= r11) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L6:
        if (r10 <= this.startStack.peekOr(0)) goto L9;
        int r12 = groupSize(r10);
    L8:
        r11 = r12 + r10;
        goto L13
    L9:
        int r13 = this.startStack.indexOf(r10);
        if (r13 >= 0) goto L12;
        r12 = groupSize(r10);
        goto L8
    L12:
        r11 = (getCapacity() - this.groupGapLen) - this.endStack.peek(r13);
        goto L13
    }

    public final boolean indexInParent(int r5) {
        int r10 = this.parent;
        if (r5 > r10) goto L5;
    L6:
        if (r10 != 0) goto L9;
        if (r5 != 0) goto L9;
    L8:
        return true;
    L9:
        return false;
    L5:
        if (r5 < this.currentGroupEnd) goto L8;
        goto L6
    }

    public final void insertAux(Object r10) {
        if (this.insertCount < 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L23;
        int r11 = this.parent;
        int r12 = groupIndexToAddress(r11);
        if (SlotTableKt.access$hasAux(this.groups, r12) == true) goto L21;
        insertSlots(1, r11);
        int r13 = auxIndex(this.groups, r12);
        int r14 = dataIndexToDataAddress(r13);
        int r15 = this.currentSlot;
        if (r15 <= r13) goto L18;
        int r16 = r15 - r13;
        if (r16 >= 3) goto L17;
        if (r16 <= 1) goto L15;
        Object[] r17 = this.slots;
        r17[r14 + 2] = r17[r14 + 1];
    L15:
        Object[] r18 = this.slots;
        r18[r14 + 1] = r18[r14];
        goto L18
    L17:
        throw new IllegalStateException("Moving more than two slot not supported");
    L18:
        SlotTableKt.access$addAux(this.groups, r12);
        this.slots[r14] = r10;
        this.currentSlot++;
        return;
    L21:
        throw j0.z("Group already has auxiliary data");
    L23:
        throw j0.z("Cannot insert auxiliary data when not inserting");
    L5:
        r5 = false;
        goto L6
    }

    public final void insertParentGroup(int r17) {
        int r5 = 0;
        if (this.insertCount != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L16;
        if (isGroupEnd() == false) goto L10;
        beginInsert();
        startGroup(r17);
        endGroup();
        endInsert();
        return;
    L10:
        int r11 = this.currentGroup;
        int r12 = parent(this.groups, r11);
        int r13 = groupSize(r12) + r12;
        int r14 = r13 - r11;
        int r15 = r11;
    L11:
        if (r15 >= r13) goto L13;
        int r16 = groupIndexToAddress(r15);
        r5 = r5 + SlotTableKt.access$nodeCount(this.groups, r16);
        r15 = r15 + SlotTableKt.access$groupSize(this.groups, r16);
        goto L11
    L13:
        int r18 = SlotTableKt.access$dataAnchor(this.groups, groupIndexToAddress(r11));
        beginInsert();
        insertGroups(1);
        endInsert();
        int r19 = groupIndexToAddress(r11);
        SlotTableKt.access$initGroup(this.groups, r19, r17, false, false, false, r12, r18);
        SlotTableKt.access$updateGroupSize(this.groups, r19, r14 + 1);
        SlotTableKt.access$updateNodeCount(this.groups, r19, r5);
        addToGroupSizeAlongSpine(groupIndexToAddress(r12), 1);
        fixParentAnchorsFor(r12, r13, r11);
        this.currentGroup = r13;
        return;
    L16:
        throw j0.z("Writer cannot be inserting");
    L5:
        r10 = false;
        goto L6
    }

    public final boolean isGroupEnd() {
        if (this.currentGroup != this.currentGroupEnd) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNode() {
        int r5 = this.currentGroup;
        if (r5 < this.currentGroupEnd) goto L5;
    L7:
        return false;
    L5:
        if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress(r5)) == false) goto L7;
        return true;
    }

    public final void markGroup(int r5) {
        int r10 = groupIndexToAddress(r5);
        if (SlotTableKt.access$hasMark(this.groups, r10) == true) goto L8;
        SlotTableKt.access$updateMark(this.groups, r10, true);
        if (SlotTableKt.access$containsMark(this.groups, r10) == true) goto L9;
        updateContainsMark(parent(r5));
        return;
    L9:
        return;
    }

    public final List<Anchor> moveFrom(SlotTable r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "table");
        if (this.insertCount <= 0) goto L5;
        boolean r5 = true;
    L6:
        ComposerKt.runtimeCheck(r5);
        if (r11 == 0) goto L9;
    L16:
        SlotWriter r13 = r10.openWriter();
        List<Anchor> r14 = Companion.access$moveGroup(Companion, r13, r11, this, true, true, r12);     // Catch: Throwable -> L20
        r13.close();
        return r14;
    L20:
        th = move-exception;
        r13.close();
        throw th;
    L9:
        if (this.currentGroup != 0) goto L16;
        if (this.table.getGroupsSize() != 0) goto L16;
        if (SlotTableKt.access$groupSize(r10.getGroups(), r11) != r10.getGroupsSize()) goto L16;
        int[] r15 = this.groups;
        Object[] r16 = this.slots;
        ArrayList<Anchor> r17 = this.anchors;
        int[] r18 = r10.getGroups();
        int r19 = r10.getGroupsSize();
        Object[] r20 = r10.getSlots();
        int r21 = r10.getSlotsSize();
        this.groups = r18;
        this.slots = r20;
        this.anchors = r10.getAnchors$runtime_release();
        this.groupGapStart = r19;
        this.groupGapLen = (r18.length / 5) - r19;
        this.slotsGapStart = r21;
        this.slotsGapLen = r20.length - r21;
        this.slotsGapOwner = r19;
        r10.setTo$runtime_release(r15, 0, r16, 0, r17);
        return this.anchors;
    L5:
        r5 = false;
        goto L6
    }

    public final void moveGroup(int r18) {
        if (this.insertCount != 0) goto L40;
        if (r18 < 0) goto L7;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L38;
        if (r18 != 0) goto L12;
        return;
    L12:
        int r10 = this.currentGroup;
        int r11 = this.parent;
        int r12 = this.currentGroupEnd;
        int r13 = r18;
        int r14 = r10;
    L13:
        if (r13 <= 0) goto L19;
        r14 = r14 + SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(r14));
        if (r14 > r12) goto L18;
        r13 = r13 - 1;
        goto L13
    L18:
        throw j0.z("Parameter offset is out of bounds");
    L19:
        int r15 = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(r14));
        int r16 = this.currentSlot;
        int r17 = dataIndex(this.groups, groupIndexToAddress(r14));
        int r19 = r14 + r15;
        int r20 = dataIndex(this.groups, groupIndexToAddress(r19));
        int r110 = r20 - r17;
        insertSlots(r110, Math.max(this.currentGroup - 1, 0));
        insertGroups(r15);
        int[] r111 = this.groups;
        int r112 = groupIndexToAddress(r19) * 5;
        ArraysKt.a(groupIndexToAddress(r10) * 5, r112, r111, r111, (r15 * 5) + r112);
        if (r110 <= 0) goto L22;
        Object[] r113 = this.slots;
        ArraysKt.copyInto(r113, r113, r16, dataIndexToDataAddress(r17 + r110), dataIndexToDataAddress(r20 + r110));
    L22:
        int r21 = r17 + r110;
        int r22 = r21 - r16;
        int r23 = this.slotsGapStart;
        int r114 = this.slotsGapLen;
        int r115 = this.slots.length;
        int r116 = this.slotsGapOwner;
        int r117 = r10 + r15;
        int r24 = r10;
    L23:
        if (r24 >= r117) goto L29;
        int r25 = groupIndexToAddress(r24);
        int r118 = r23;
        int r26 = dataIndex(r111, r25) - r22;
        int r119 = r22;
        if (r116 >= r25) goto L27;
        int r27 = 0;
    L28:
        updateDataIndex(r111, r25, dataIndexToDataAnchor(r26, r27, r114, r115));
        r24 = r24 + 1;
        r23 = r118;
        r22 = r119;
        goto L23
    L27:
        r27 = r118;
        goto L28
    L29:
        moveAnchors(r19, r10, r15);
        if (removeGroups(r19, r15) == true) goto L36;
        fixParentAnchorsFor(r11, this.currentGroupEnd, r10);
        if (r110 <= 0) goto L46;
        removeSlots(r21, r110, r19 - 1);
        return;
    L46:
        return;
    L36:
        throw j0.z("Unexpectedly removed anchors");
    L38:
        throw j0.z("Parameter offset is out of bounds");
    L7:
        r5 = false;
        goto L9
    L40:
        throw j0.z("Cannot move a group while inserting");
    }

    public final List<Anchor> moveIntoGroupFrom(int r13, SlotTable r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "table");
        if (this.insertCount > 0) goto L7;
        boolean r5 = true;
        if (groupSize(this.currentGroup + r13) != 1) goto L7;
    L8:
        ComposerKt.runtimeCheck(r5);
        int r10 = this.currentGroup;
        int r11 = this.currentSlot;
        int r12 = this.currentSlotEnd;
        advanceBy(r13);
        startGroup();
        beginInsert();
        SlotWriter r16 = r14.openWriter();
        List<Anchor> r17 = Companion.moveGroup$default(Companion, r16, r15, this, false, true, false, 32, null);     // Catch: Throwable -> L12
        r16.close();
        endInsert();
        endGroup();
        this.currentGroup = r10;
        this.currentSlot = r11;
        this.currentSlotEnd = r12;
        return r17;
    L12:
        th = move-exception;
        r16.close();
        throw th;
    L7:
        r5 = false;
        goto L8
    }

    public final List<Anchor> moveTo(Anchor r17, int r18, SlotWriter r19) {
        Intrinsics.checkNotNullParameter(r17, "anchor");
        Intrinsics.checkNotNullParameter(r19, "writer");
        boolean r10 = true;
        if (r19.insertCount <= 0) goto L5;
        boolean r5 = true;
    L6:
        ComposerKt.runtimeCheck(r5);
        if (this.insertCount != 0) goto L9;
        boolean r11 = true;
    L10:
        ComposerKt.runtimeCheck(r11);
        ComposerKt.runtimeCheck(r17.getValid());
        int r12 = anchorIndex(r17) + r18;
        int r13 = this.currentGroup;
        if (r13 <= r12) goto L13;
    L15:
        boolean r14 = false;
    L16:
        ComposerKt.runtimeCheck(r14);
        int r15 = parent(r12);
        int r16 = groupSize(r12);
        if (isNode(r12) == false) goto L19;
        int r110 = 1;
    L20:
        List<Anchor> r20 = Companion.moveGroup$default(Companion, this, r12, r19, false, false, false, 32, null);
        updateContainsMark(r15);
        if (r110 <= 0) goto L23;
        boolean r21 = true;
    L24:
        if (r15 < r13) goto L32;
        int r22 = groupIndexToAddress(r15);
        int[] r23 = this.groups;
        SlotTableKt.access$updateGroupSize(r23, r22, SlotTableKt.access$groupSize(r23, r22) - r16);
        if (r21 == false) goto L31;
        if (SlotTableKt.access$isNode(this.groups, r22) == false) goto L30;
        r21 = false;
        goto L31
    L30:
        int[] r24 = this.groups;
        SlotTableKt.access$updateNodeCount(r24, r22, SlotTableKt.access$nodeCount(r24, r22) - r110);
    L31:
        r15 = parent(r15);
        goto L24
    L32:
        if (r21 == true) goto L34;
    L38:
        return r20;
    L34:
        if (this.nodeCount >= r110) goto L37;
        r10 = false;
    L37:
        ComposerKt.runtimeCheck(r10);
        this.nodeCount -= r110;
        goto L38
    L23:
        r21 = false;
        goto L24
    L19:
        r110 = nodeCount(r12);
        goto L20
    L13:
        if (r12 >= this.currentGroupEnd) goto L15;
        r14 = true;
        goto L16
    L9:
        r11 = false;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    public final Object node(int r5) {
        int r10 = groupIndexToAddress(r5);
        if (SlotTableKt.access$isNode(this.groups, r10) == true) goto L7;
        return null;
    L7:
        return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, r10))];
    }

    public final int nodeCount(int r5) {
        return SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress(r5));
    }

    public final int parent(int r5) {
        return parent(this.groups, r5);
    }

    public final boolean removeGroup() {
        if (this.insertCount != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L17;
        int r10 = this.currentGroup;
        int r11 = this.currentSlot;
        int r12 = skipGroup();
        PrioritySet r13 = this.pendingRecalculateMarks;
        if (r13 != null) goto L10;
    L14:
        boolean r14 = removeGroups(r10, this.currentGroup - r10);
        removeSlots(r11, this.currentSlot - r11, r10 - 1);
        this.currentGroup = r10;
        this.currentSlot = r11;
        this.nodeCount -= r12;
        return r14;
    L10:
        if (r13.isNotEmpty() == false) goto L14;
        if (r13.peek() < r10) goto L14;
        r13.takeMax();
        goto L10
    L17:
        throw j0.z("Cannot remove group while inserting");
    L5:
        r5 = false;
        goto L6
    }

    public final void reset() {
        if (this.insertCount != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
        return;
    L10:
        throw j0.z("Cannot reset when inserting");
    L5:
        r5 = false;
        goto L6
    }

    public final void seek(Anchor r5) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        advanceBy(r5.toIndexFor(this) - this.currentGroup);
    }

    public final void set(Object r5) {
        int r10 = this.currentSlot;
        if (r10 > this.currentSlotEnd) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L10;
        this.slots[dataIndexToDataAddress(r10 - 1)] = r5;
        return;
    L10:
        throw j0.z("Writing to an invalid slot");
    L5:
        r11 = false;
        goto L6
    }

    public final Object skip() {
        if (this.insertCount <= 0) goto L5;
        insertSlots(1, this.parent);
    L5:
        Object[] r5 = this.slots;
        int r10 = this.currentSlot;
        this.currentSlot = r10 + 1;
        return r5[dataIndexToDataAddress(r10)];
    }

    public final int skipGroup() {
        int r5 = groupIndexToAddress(this.currentGroup);
        int r10 = this.currentGroup;
        int r11 = SlotTableKt.access$groupSize(this.groups, r5) + r10;
        this.currentGroup = r11;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(r11));
        if (SlotTableKt.access$isNode(this.groups, r5) == false) goto L6;
        return 1;
    L6:
        return SlotTableKt.access$nodeCount(this.groups, r5);
    }

    public final void skipToGroupEnd() {
        int r5 = this.currentGroupEnd;
        this.currentGroup = r5;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(r5));
    }

    public final Object slot(Anchor r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        return slot(anchorIndex(r5), r10);
    }

    public final void startData(int r5, Object r10, Object r11) {
        startGroup(r5, r10, false, r11);
    }

    public final void startGroup() {
        if (this.insertCount != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        Composer.Companion r10 = Composer.Companion;
        startGroup(0, r10.getEmpty(), false, r10.getEmpty());
        return;
    L10:
        throw j0.z("Key must be supplied when inserting");
    L5:
        r5 = false;
        goto L6
    }

    public final void startNode(int r5, Object r10) {
        startGroup(r5, r10, true, Composer.Companion.getEmpty());
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    public final Object update(Object r5) {
        Object r10 = skip();
        set(r5);
        return r10;
    }

    public final void updateAux(Object r5) {
        int r10 = groupIndexToAddress(this.currentGroup);
        if (SlotTableKt.access$hasAux(this.groups, r10) == false) goto L7;
        this.slots[dataIndexToDataAddress(auxIndex(this.groups, r10))] = r5;
        return;
    L7:
        throw j0.z("Updating the data of a group that was not created with a data slot");
    }

    public final void updateNode(Object r5) {
        updateNodeOfGroup(this.currentGroup, r5);
    }

    public final void updateParentNode(Object r5) {
        updateNodeOfGroup(this.parent, r5);
    }

    public final void verifyDataAnchors$runtime_release() {
        int r5 = this.slotsGapOwner;
        int r10 = this.slots.length - this.slotsGapLen;
        int r11 = getSize$runtime_release();
        int r12 = 0;
        int r13 = 0;
        boolean r14 = false;
    L3:
        if (r12 >= r11) goto L18;
        int r15 = groupIndexToAddress(r12);
        int r16 = SlotTableKt.access$dataAnchor(this.groups, r15);
        int r17 = dataIndex(this.groups, r15);
        if (r17 < r13) goto L16;
        if (r17 > r10) goto L15;
        if (r16 >= 0) goto L13;
        if (r14 == true) goto L13;
        if (r5 != r12) goto L12;
        r14 = true;
        goto L13
    L12:
        throw new IllegalStateException(j0.f(r5, r12, "Expected the slot gap owner to be ", " found gap at ").toString());
    L13:
        r12 = r12 + 1;
        r13 = r17;
        goto L3
    L15:
        throw new IllegalStateException(j0.f(r17, r12, "Data index, ", ", out of bound at ").toString());
    L16:
        StringBuilder r18 = j0.v("Data index out of order at ", r12, r13, ", previous = ", ", current = ");
        r18.append(r17);
        throw new IllegalStateException(r18.toString().toString());
    }

    public final void verifyParentAnchors$runtime_release() {
        int r5 = this.groupGapStart;
        int r10 = this.groupGapLen;
        int r11 = getCapacity();
        int r12 = 0;
    L4:
        if (r12 >= r5) goto L10;
        if (SlotTableKt.access$parentAnchor(this.groups, r12) <= (-2)) goto L9;
        r12 = r12 + 1;
        goto L4
    L9:
        throw new IllegalStateException(j0.g(r12, "Expected a start relative anchor at ").toString());
    L10:
        int r13 = r10 + r5;
    L11:
        if (r13 >= r11) goto L22;
        int r14 = SlotTableKt.access$parentAnchor(this.groups, r13);
        if (parentAnchorToIndex(r14) >= r5) goto L18;
        if (r14 > (-2)) goto L19;
        throw new IllegalStateException(j0.g(r13, "Expected a start relative anchor at ").toString());
    L19:
        r13 = r13 + 1;
        goto L11
    L18:
        if (r14 <= (-2)) goto L19;
        throw new IllegalStateException(j0.g(r13, "Expected an end relative anchor at ").toString());
    }

    public static final /* synthetic */ int access$dataIndex(SlotWriter r5, int[] r10, int r11) {
        return r5.dataIndex(r10, r11);
    }

    private final int dataIndex(int[] r5, int r10) {
        if (r10 < getCapacity()) goto L6;
        return this.slots.length - this.slotsGapLen;
    L6:
        return dataAnchorToDataIndex(SlotTableKt.access$dataAnchor(r5, r10), this.slotsGapLen, this.slots.length);
    }

    public final boolean isNode(int r5) {
        return SlotTableKt.access$isNode(this.groups, groupIndexToAddress(r5));
    }

    public final int parent(Anchor r5) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        if (r5.getValid() == true) goto L7;
        return -1;
    L7:
        return parent(this.groups, anchorIndex(r5));
    }

    public final Object slot(int r5, int r10) {
        int r11 = groupIndexToAddress(r5);
        int r12 = slotIndex(this.groups, r11);
        int r13 = dataIndex(this.groups, groupIndexToAddress(r5 + 1));
        int r14 = r10 + r12;
        if (r12 > r14) goto L8;
        if (r14 >= r13) goto L8;
        int r15 = dataIndexToDataAddress(r14);
        return this.slots[r15];
    L8:
        return Composer.Companion.getEmpty();
    }

    public final void startData(int r5, Object r10) {
        startGroup(r5, Composer.Companion.getEmpty(), false, r10);
    }

    public final void startNode(int r5, Object r10, Object r11) {
        startGroup(r5, r10, true, r11);
    }

    public final void updateNode(Anchor r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        updateNodeOfGroup(r5.toIndexFor(this), r10);
    }

    private final int parent(int[] r5, int r10) {
        return parentAnchorToIndex(SlotTableKt.access$parentAnchor(r5, groupIndexToAddress(r10)));
    }

    public final Object node(Anchor r5) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        return node(r5.toIndexFor(this));
    }

    public final Object set(int r5, Object r10) {
        int r11 = groupIndexToAddress(this.currentGroup);
        int r12 = slotIndex(this.groups, r11);
        boolean r13 = true;
        int r14 = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
        int r15 = r12 + r5;
        if (r15 < r12) goto L6;
        if (r15 >= r14) goto L6;
    L7:
        if (r13 == false) goto L10;
        int r16 = dataIndexToDataAddress(r15);
        Object[] r17 = this.slots;
        Object r18 = r17[r16];
        r17[r16] = r10;
        return r18;
    L10:
        StringBuilder r19 = j0.s(r5, "Write to an invalid slot index ", " for group ");
        r19.append(this.currentGroup);
        ComposerKt.composeRuntimeError(r19.toString().toString());
        throw new KotlinNothingValueException();
    L6:
        r13 = false;
        goto L7
    }

    public final void startGroup(int r5) {
        Composer.Companion r10 = Composer.Companion;
        startGroup(r5, r10.getEmpty(), false, r10.getEmpty());
    }

    public final void startGroup(int r5, Object r10) {
        startGroup(r5, r10, false, Composer.Companion.getEmpty());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startGroup(int r16, Object r17, boolean r18, Object r19) {
        if (this.insertCount <= 0) goto L5;
        Object[] r5 = true;
    L6:
        this.nodeCountStack.push(this.nodeCount);
        if (r5 == false) goto L28;
        insertGroups(1);
        int r12 = this.currentGroup;
        int r10 = groupIndexToAddress(r12);
        Composer.Companion r11 = Composer.Companion;
        if (r17 == r11.getEmpty()) goto L11;
        int r13 = 1;
    L12:
        if (r18 == false) goto L14;
    L16:
        int r14 = 0;
    L17:
        SlotTableKt.access$initGroup(this.groups, r10, r16, r18, r13, r14, this.parent, this.currentSlot);
        this.currentSlotEnd = this.currentSlot;
        int r15 = ((r18 ? 1 : 0) + r13) + r14;
        if (r15 <= 0) goto L27;
        insertSlots(r15, r12);
        Object[] r20 = this.slots;
        int r21 = this.currentSlot;
        if (r18 == false) goto L22;
        r20[r21] = r19;
        r21 = r21 + 1;
    L22:
        if (r13 == 0) goto L24;
        r20[r21] = r17;
        r21 = r21 + 1;
    L24:
        if (r14 == 0) goto L26;
        r20[r21] = r19;
        r21 = r21 + 1;
    L26:
        this.currentSlot = r21;
    L27:
        this.nodeCount = 0;
        int r22 = r12 + 1;
        this.parent = r12;
        this.currentGroup = r22;
    L34:
        this.currentGroupEnd = r22;
        return;
    L14:
        if (r19 == r11.getEmpty()) goto L16;
        r14 = 1;
        goto L17
    L11:
        r13 = 0;
        goto L12
    L28:
        this.startStack.push(this.parent);
        saveCurrentGroupEnd();
        int r23 = this.currentGroup;
        int r24 = groupIndexToAddress(r23);
        if (Intrinsics.areEqual(r19, Composer.Companion.getEmpty()) == true) goto L33;
        if (r18 == false) goto L32;
        updateNode(r19);
        goto L33
    L32:
        updateAux(r19);
    L33:
        this.currentSlot = slotIndex(this.groups, r24);
        this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
        this.nodeCount = SlotTableKt.access$nodeCount(this.groups, r24);
        this.parent = r23;
        this.currentGroup = r23 + 1;
        r22 = r23 + SlotTableKt.access$groupSize(this.groups, r24);
        goto L34
    L5:
        r5 = false;
        goto L6
    }

    public final void ensureStarted(Anchor r5) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        ensureStarted(r5.toIndexFor(this));
    }
}
