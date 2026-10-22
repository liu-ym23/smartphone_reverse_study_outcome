package androidx.compose.runtime;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u001c\n\u0002\b\n\u001a\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001c\u001a\u00020\u001b*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f*\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\u0001H\u0002\u001a;\u0010!\u001a\u00020\"*\u0012\u0012\u0004\u0012\u00020\"0#j\b\u0012\u0004\u0012\u00020\"`$2\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0(H\u0082\b\u001a\u0014\u0010)\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0014\u0010*\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f*\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\u0001H\u0002\u001a\u0014\u0010,\u001a\u00020\u001b*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0014\u0010-\u001a\u00020\u001b*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0014\u0010.\u001a\u00020\u001b*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001aD\u0010/\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u00101\u001a\u00020\u001b*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0014\u00100\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f*\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\u0001H\u0002\u001a,\u00106\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020\"0#j\b\u0012\u0004\u0012\u00020\"`$2\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0001H\u0002\u001a\u0014\u00107\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f*\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\u0001H\u0002\u001a\u0014\u00109\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0014\u0010:\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0014\u00104\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f*\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\u0001H\u0002\u001a,\u0010<\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020\"0#j\b\u0012\u0004\u0012\u00020\"`$2\u0006\u0010=\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0001H\u0002\u001a \u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f*\u00020\u00172\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010@H\u0002\u001a\u0014\u0010A\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u001c\u0010B\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u001bH\u0002\u001a\u001c\u0010C\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u0001H\u0002\u001a\u001c\u0010E\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0002\u001a\u001c\u0010F\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\u001c\u0010G\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u001bH\u0002\u001a\u001c\u0010H\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\u001c\u0010I\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Aux_Mask", "", "Aux_Shift", "ContainsMark_Mask", "DataAnchor_Offset", "GroupInfo_Offset", "Group_Fields_Size", "Key_Offset", "Mark_Mask", "MinGroupGrowthSize", "MinSlotsGrowthSize", "NodeBit_Mask", "NodeCount_Mask", "ObjectKey_Mask", "ObjectKey_Shift", "ParentAnchor_Offset", "Size_Offset", "Slots_Shift", "parentAnchorPivot", "countOneBits", "value", "addAux", "", "", "address", "auxIndex", "containsAnyMark", "", "containsMark", "dataAnchor", "dataAnchors", "", "len", "getOrAdd", "Landroidx/compose/runtime/Anchor;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "index", "effectiveSize", "block", "Lkotlin/Function0;", "groupInfo", "groupSize", "groupSizes", "hasAux", "hasMark", "hasObjectKey", "initGroup", STGroup.DICT_KEY, "isNode", "hasDataKey", "hasData", "parentAnchor", "keys", "locationOf", "nodeCount", "nodeCounts", "nodeIndex", "objectKeyIndex", "parentAnchors", "search", "location", "slice", "indices", "", "slotAnchor", "updateContainsMark", "updateDataAnchor", "anchor", "updateGroupKey", "updateGroupSize", "updateMark", "updateNodeCount", "updateParentAnchor", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotTableKt\n+ 2 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3471:1\n82#2,3:3472\n33#2,4:3475\n85#2,2:3479\n38#2:3481\n87#2:3482\n1#3:3483\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotTableKt\n*L\n3274#1:3472,3\n3274#1:3475,4\n3274#1:3479,2\n3274#1:3481\n3274#1:3482\n*E\n"})
public final class SlotTableKt {
    private static final int Aux_Mask = 268435456;
    private static final int Aux_Shift = 28;
    private static final int ContainsMark_Mask = 67108864;
    private static final int DataAnchor_Offset = 4;
    private static final int GroupInfo_Offset = 1;
    private static final int Group_Fields_Size = 5;
    private static final int Key_Offset = 0;
    private static final int Mark_Mask = 134217728;
    private static final int MinGroupGrowthSize = 32;
    private static final int MinSlotsGrowthSize = 32;
    private static final int NodeBit_Mask = 1073741824;
    private static final int NodeCount_Mask = 67108863;
    private static final int ObjectKey_Mask = 536870912;
    private static final int ObjectKey_Shift = 29;
    private static final int ParentAnchor_Offset = 2;
    private static final int Size_Offset = 3;
    private static final int Slots_Shift = 28;
    private static final int parentAnchorPivot = -2;

    public static final /* synthetic */ void access$addAux(int[] r5, int r10) {
        addAux(r5, r10);
    }

    public static final /* synthetic */ int access$auxIndex(int[] r5, int r10) {
        return auxIndex(r5, r10);
    }

    public static final /* synthetic */ boolean access$containsAnyMark(int[] r5, int r10) {
        return containsAnyMark(r5, r10);
    }

    public static final /* synthetic */ boolean access$containsMark(int[] r5, int r10) {
        return containsMark(r5, r10);
    }

    public static final /* synthetic */ int access$countOneBits(int r5) {
        return countOneBits(r5);
    }

    public static final /* synthetic */ int access$dataAnchor(int[] r5, int r10) {
        return dataAnchor(r5, r10);
    }

    public static final /* synthetic */ List access$dataAnchors(int[] r5, int r10) {
        return dataAnchors(r5, r10);
    }

    public static final /* synthetic */ int access$groupInfo(int[] r5, int r10) {
        return groupInfo(r5, r10);
    }

    public static final /* synthetic */ int access$groupSize(int[] r5, int r10) {
        return groupSize(r5, r10);
    }

    public static final /* synthetic */ List access$groupSizes(int[] r5, int r10) {
        return groupSizes(r5, r10);
    }

    public static final /* synthetic */ boolean access$hasAux(int[] r5, int r10) {
        return hasAux(r5, r10);
    }

    public static final /* synthetic */ boolean access$hasMark(int[] r5, int r10) {
        return hasMark(r5, r10);
    }

    public static final /* synthetic */ boolean access$hasObjectKey(int[] r5, int r10) {
        return hasObjectKey(r5, r10);
    }

    public static final /* synthetic */ void access$initGroup(int[] r5, int r10, int r11, boolean r12, boolean r13, boolean r14, int r15, int r16) {
        initGroup(r5, r10, r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ boolean access$isNode(int[] r5, int r10) {
        return isNode(r5, r10);
    }

    public static final /* synthetic */ int access$key(int[] r5, int r10) {
        return key(r5, r10);
    }

    public static final /* synthetic */ List access$keys(int[] r5, int r10) {
        return keys(r5, r10);
    }

    public static final /* synthetic */ int access$locationOf(ArrayList r5, int r10, int r11) {
        return locationOf(r5, r10, r11);
    }

    public static final /* synthetic */ int access$nodeCount(int[] r5, int r10) {
        return nodeCount(r5, r10);
    }

    public static final /* synthetic */ List access$nodeCounts(int[] r5, int r10) {
        return nodeCounts(r5, r10);
    }

    public static final /* synthetic */ int access$nodeIndex(int[] r5, int r10) {
        return nodeIndex(r5, r10);
    }

    public static final /* synthetic */ int access$objectKeyIndex(int[] r5, int r10) {
        return objectKeyIndex(r5, r10);
    }

    public static final /* synthetic */ int access$parentAnchor(int[] r5, int r10) {
        return parentAnchor(r5, r10);
    }

    public static final /* synthetic */ List access$parentAnchors(int[] r5, int r10) {
        return parentAnchors(r5, r10);
    }

    public static final /* synthetic */ int access$search(ArrayList r5, int r10, int r11) {
        return search(r5, r10, r11);
    }

    public static final /* synthetic */ int access$slotAnchor(int[] r5, int r10) {
        return slotAnchor(r5, r10);
    }

    public static final /* synthetic */ void access$updateContainsMark(int[] r5, int r10, boolean r11) {
        updateContainsMark(r5, r10, r11);
    }

    public static final /* synthetic */ void access$updateDataAnchor(int[] r5, int r10, int r11) {
        updateDataAnchor(r5, r10, r11);
    }

    public static final /* synthetic */ void access$updateGroupSize(int[] r5, int r10, int r11) {
        updateGroupSize(r5, r10, r11);
    }

    public static final /* synthetic */ void access$updateMark(int[] r5, int r10, boolean r11) {
        updateMark(r5, r10, r11);
    }

    public static final /* synthetic */ void access$updateNodeCount(int[] r5, int r10, int r11) {
        updateNodeCount(r5, r10, r11);
    }

    public static final /* synthetic */ void access$updateParentAnchor(int[] r5, int r10, int r11) {
        updateParentAnchor(r5, r10, r11);
    }

    private static final void addAux(int[] r5, int r10) {
        int r11 = (r10 * 5) + 1;
        r5[r11] = r5[r11] | Aux_Mask;
    }

    private static final int auxIndex(int[] r5, int r10) {
        int r11 = r10 * 5;
        if (r11 >= r5.length) goto L7;
        int r12 = r5[r11 + 4];
        return countOneBits(r5[r11 + 1] >> 29) + r12;
    L7:
        return r5.length;
    }

    private static final boolean containsAnyMark(int[] r5, int r10) {
        if ((r5[(r10 * 5) + 1] & 201326592) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean containsMark(int[] r5, int r10) {
        if ((r5[(r10 * 5) + 1] & 67108864) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final int countOneBits(int r5) {
        switch(r5) {
            case 0: goto L6;
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L10;
            case 6: goto L10;
            default: goto L4;
        };
    L4:
        return 3;
    L6:
        return 0;
    L8:
        return 1;
    L10:
        return 2;
    }

    private static final int dataAnchor(int[] r5, int r10) {
        return r5[(r10 * 5) + 4];
    }

    private static final List<Integer> dataAnchors(int[] r5, int r10) {
        return slice(r5, RangesKt.step(RangesKt.until(4, r10), 5));
    }

    public static /* synthetic */ List dataAnchors$default(int[] r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.length;
    L6:
        return dataAnchors(r5, r10);
    }

    private static final Anchor getOrAdd(ArrayList<Anchor> r5, int r10, int r11, Function0<Anchor> r12) {
        int r13 = access$search(r5, r10, r11);
        if (r13 >= 0) goto L6;
        Anchor r14 = r12.invoke();
        r5.add(-(r13 + 1), r14);
        return r14;
    L6:
        return r5.get(r13);
    }

    private static final int groupInfo(int[] r5, int r10) {
        return r5[(r10 * 5) + 1];
    }

    private static final int groupSize(int[] r5, int r10) {
        return r5[(r10 * 5) + 3];
    }

    private static final List<Integer> groupSizes(int[] r5, int r10) {
        return slice(r5, RangesKt.step(RangesKt.until(3, r10), 5));
    }

    public static /* synthetic */ List groupSizes$default(int[] r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.length;
    L6:
        return groupSizes(r5, r10);
    }

    private static final boolean hasAux(int[] r5, int r10) {
        if ((r5[(r10 * 5) + 1] & Aux_Mask) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean hasMark(int[] r5, int r10) {
        if ((r5[(r10 * 5) + 1] & Mark_Mask) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean hasObjectKey(int[] r5, int r10) {
        if ((r5[(r10 * 5) + 1] & ObjectKey_Mask) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final void initGroup(int[] r5, int r10, int r11, boolean r12, boolean r13, boolean r14, int r15, int r16) {
        if (r12 == false) goto L5;
        int r17 = 1073741824;
    L6:
        if (r13 == false) goto L8;
        int r18 = ObjectKey_Mask;
    L9:
        if (r14 == false) goto L11;
        int r19 = Aux_Mask;
    L12:
        int r20 = r10 * 5;
        r5[r20] = r11;
        r5[r20 + 1] = (r17 | r18) | r19;
        r5[r20 + 2] = r15;
        r5[r20 + 3] = 0;
        r5[r20 + 4] = r16;
        return;
    L11:
        r19 = 0;
        goto L12
    L8:
        r18 = 0;
        goto L9
    L5:
        r17 = 0;
        goto L6
    }

    private static final boolean isNode(int[] r5, int r10) {
        if ((r5[(r10 * 5) + 1] & 1073741824) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final int key(int[] r5, int r10) {
        return r5[r10 * 5];
    }

    private static final List<Integer> keys(int[] r5, int r10) {
        return slice(r5, RangesKt.step(RangesKt.until(0, r10), 5));
    }

    public static /* synthetic */ List keys$default(int[] r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.length;
    L6:
        return keys(r5, r10);
    }

    private static final int locationOf(ArrayList<Anchor> r5, int r10, int r11) {
        int r12 = search(r5, r10, r11);
        if (r12 < 0) goto L6;
        return r12;
    L6:
        return -(r12 + 1);
    }

    private static final int nodeCount(int[] r5, int r10) {
        return r5[(r10 * 5) + 1] & NodeCount_Mask;
    }

    private static final List<Integer> nodeCounts(int[] r5, int r10) {
        List<Integer> r11 = slice(r5, RangesKt.step(RangesKt.until(1, r10), 5));
        ArrayList r12 = new ArrayList(r11.size());
        int r13 = r11.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(Integer.valueOf(r11.get(r14).intValue() & NodeCount_Mask));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    public static /* synthetic */ List nodeCounts$default(int[] r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.length;
    L6:
        return nodeCounts(r5, r10);
    }

    private static final int nodeIndex(int[] r5, int r10) {
        return r5[(r10 * 5) + 4];
    }

    private static final int objectKeyIndex(int[] r5, int r10) {
        int r11 = r10 * 5;
        return r5[r11 + 4] + countOneBits(r5[r11 + 1] >> 30);
    }

    private static final int parentAnchor(int[] r5, int r10) {
        return r5[(r10 * 5) + 2];
    }

    private static final List<Integer> parentAnchors(int[] r5, int r10) {
        return slice(r5, RangesKt.step(RangesKt.until(2, r10), 5));
    }

    public static /* synthetic */ List parentAnchors$default(int[] r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.length;
    L6:
        return parentAnchors(r5, r10);
    }

    private static final int search(ArrayList<Anchor> r5, int r10, int r11) {
        int r12 = r5.size() - 1;
        int r13 = 0;
    L3:
        if (r13 > r12) goto L14;
        int r14 = (r13 + r12) >>> 1;
        int r15 = r5.get(r14).getLocation$runtime_release();
        if (r15 >= 0) goto L7;
        r15 = r15 + r11;
    L7:
        int r16 = Intrinsics.compare(r15, r10);
        if (r16 < 0) goto L9;
        if (r16 <= 0) goto L12;
        r12 = r14 - 1;
        goto L3
    L12:
        return r14;
    L9:
        r13 = r14 + 1;
        goto L3
    L14:
        return -(r13 + 1);
    }

    private static final List<Integer> slice(int[] r5, Iterable<Integer> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<Integer> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(Integer.valueOf(r5[r12.next().intValue()]));
        goto L4
    L6:
        return r11;
    }

    private static final int slotAnchor(int[] r5, int r10) {
        int r11 = r10 * 5;
        return r5[r11 + 4] + countOneBits(r5[r11 + 1] >> 28);
    }

    private static final void updateContainsMark(int[] r5, int r10, boolean r11) {
        int r12 = (r10 * 5) + 1;
        if (r11 == false) goto L5;
        r5[r12] = r5[r12] | 67108864;
        return;
    L5:
        r5[r12] = r5[r12] & (-67108865);
    }

    private static final void updateDataAnchor(int[] r5, int r10, int r11) {
        r5[(r10 * 5) + 4] = r11;
    }

    private static final void updateGroupKey(int[] r5, int r10, int r11) {
        r5[r10 * 5] = r11;
    }

    private static final void updateGroupSize(int[] r5, int r10, int r11) {
        if (r11 < 0) goto L4;
        boolean r12 = true;
    L5:
        ComposerKt.runtimeCheck(r12);
        r5[(r10 * 5) + 3] = r11;
        return;
    L4:
        r12 = false;
        goto L5
    }

    private static final void updateMark(int[] r5, int r10, boolean r11) {
        int r12 = (r10 * 5) + 1;
        if (r11 == false) goto L5;
        r5[r12] = r5[r12] | Mark_Mask;
        return;
    L5:
        r5[r12] = r5[r12] & (-134217729);
    }

    private static final void updateNodeCount(int[] r5, int r10, int r11) {
        if (r11 >= 0) goto L5;
    L7:
        boolean r12 = false;
    L8:
        ComposerKt.runtimeCheck(r12);
        int r13 = (r10 * 5) + 1;
        r5[r13] = r11 | (r5[r13] & (-67108864));
        return;
    L5:
        if (r11 >= NodeCount_Mask) goto L7;
        r12 = true;
        goto L8
    }

    private static final void updateParentAnchor(int[] r5, int r10, int r11) {
        r5[(r10 * 5) + 2] = r11;
    }
}
