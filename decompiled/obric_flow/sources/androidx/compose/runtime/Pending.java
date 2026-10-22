package androidx.compose.runtime;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0006J\u001e\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006J\u0016\u0010-\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006J\u000e\u00102\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0004R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012RW\u0010\u0013\u001a>\u0012\u0004\u0012\u00020\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0014j\b\u0012\u0004\u0012\u00020\u0004`\u00150\u000ej\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0014j\b\u0012\u0004\u0012\u00020\u0004`\u0015`\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Landroidx/compose/runtime/Pending;", "", "keyInfos", "", "Landroidx/compose/runtime/KeyInfo;", "startIndex", "", "(Ljava/util/List;I)V", "groupIndex", "getGroupIndex", "()I", "setGroupIndex", "(I)V", "groupInfos", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupInfo;", "Lkotlin/collections/HashMap;", "getKeyInfos", "()Ljava/util/List;", "keyMap", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "getKeyMap", "()Ljava/util/HashMap;", "keyMap$delegate", "Lkotlin/Lazy;", "getStartIndex", "used", "", "getUsed", "usedKeys", "getNext", STGroup.DICT_KEY, "dataKey", "nodePositionOf", "keyInfo", "recordUsed", "", "registerInsert", "", "insertIndex", "registerMoveNode", "from", "to", "count", "registerMoveSlot", "slotPositionOf", "updateNodeCount", "group", "newCount", "updatedNodeCountOf", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/Pending\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4563:1\n1#2:4564\n1855#3,2:4565\n1855#3,2:4567\n1855#3,2:4569\n1855#3,2:4571\n1855#3,2:4573\n*S KotlinDebug\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/Pending\n*L\n155#1:4565,2\n161#1:4567,2\n171#1:4569,2\n177#1:4571,2\n197#1:4573,2\n*E\n"})
final class Pending {
    private int groupIndex;
    private final HashMap<Integer, GroupInfo> groupInfos;
    private final List<KeyInfo> keyInfos;
    private final Lazy keyMap$delegate;
    private final int startIndex;
    private final List<KeyInfo> usedKeys;

    public Pending(List<KeyInfo> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "keyInfos");
        this.keyInfos = r10;
        this.startIndex = r11;
        if (r11 < 0) goto L10;
        this.usedKeys = new ArrayList();
        HashMap<Integer, GroupInfo> r12 = new HashMap();
        int r13 = r10.size();
        int r5 = 0;
        int r14 = 0;
    L5:
        if (r5 >= r13) goto L7;
        KeyInfo r15 = this.keyInfos.get(r5);
        r12.put(Integer.valueOf(r15.getLocation()), new GroupInfo(r5, r14, r15.getNodes()));
        r14 = r14 + r15.getNodes();
        r5 = r5 + 1;
        goto L5
    L7:
        this.groupInfos = r12;
        this.keyMap$delegate = LazyKt.lazy(new Pending$keyMap$2(this));
        return;
    L10:
        throw new IllegalArgumentException("Invalid start index");
    }

    public final int getGroupIndex() {
        return this.groupIndex;
    }

    public final List<KeyInfo> getKeyInfos() {
        return this.keyInfos;
    }

    public final HashMap<Object, LinkedHashSet<KeyInfo>> getKeyMap() {
        return (HashMap) this.keyMap$delegate.getValue();
    }

    public final KeyInfo getNext(int r5, Object r10) {
        if (r10 == null) goto L4;
        Object r11 = new JoinedKey(Integer.valueOf(r5), r10);
    L6:
        return (KeyInfo) ComposerKt.access$pop(getKeyMap(), r11);
    L4:
        r11 = Integer.valueOf(r5);
        goto L6
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final List<KeyInfo> getUsed() {
        return this.usedKeys;
    }

    public final int nodePositionOf(KeyInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "keyInfo");
        GroupInfo r10 = this.groupInfos.get(Integer.valueOf(r5.getLocation()));
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getNodeIndex();
    }

    public final boolean recordUsed(KeyInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "keyInfo");
        return this.usedKeys.add(r5);
    }

    public final void registerInsert(KeyInfo r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "keyInfo");
        this.groupInfos.put(Integer.valueOf(r5.getLocation()), new GroupInfo(-1, r10, 0));
    }

    public final void registerMoveNode(int r5, int r10, int r11) {
        if (r5 <= r10) goto L14;
        Iterator<T> r12 = this.groupInfos.values().iterator();
    L5:
        if (r12.hasNext() == false) goto L50;
        GroupInfo r13 = (GroupInfo) r12.next();
        int r14 = r13.getNodeIndex();
        if (r5 > r14) goto L11;
        if (r14 >= (r5 + r11)) goto L11;
        r13.setNodeIndex((r14 - r5) + r10);
    L11:
        if (r10 > r14) goto L5;
        if (r14 >= r5) goto L5;
        r13.setNodeIndex(r14 + r11);
        goto L5
    L50:
        return;
    L14:
        if (r10 <= r5) goto L27;
        Iterator<T> r15 = this.groupInfos.values().iterator();
    L17:
        if (r15.hasNext() == false) goto L51;
        GroupInfo r16 = (GroupInfo) r15.next();
        int r17 = r16.getNodeIndex();
        if (r5 > r17) goto L24;
        if (r17 >= (r5 + r11)) goto L24;
        r16.setNodeIndex((r17 - r5) + r10);
    L24:
        if ((r5 + 1) > r17) goto L17;
        if (r17 >= r10) goto L17;
        r16.setNodeIndex(r17 - r11);
        goto L17
    L51:
        return;
    }

    public final void registerMoveSlot(int r5, int r10) {
        if (r5 <= r10) goto L12;
        Iterator<T> r11 = this.groupInfos.values().iterator();
    L5:
        if (r11.hasNext() == false) goto L44;
        GroupInfo r12 = (GroupInfo) r11.next();
        int r13 = r12.getSlotIndex();
        if (r13 == r5) goto L8;
        if (r10 > r13) goto L5;
        if (r13 >= r5) goto L5;
        r12.setSlotIndex(r13 + 1);
        goto L5
    L8:
        r12.setSlotIndex(r10);
        goto L5
    L44:
        return;
    L12:
        if (r10 <= r5) goto L23;
        Iterator<T> r14 = this.groupInfos.values().iterator();
    L15:
        if (r14.hasNext() == false) goto L45;
        GroupInfo r15 = (GroupInfo) r14.next();
        int r16 = r15.getSlotIndex();
        if (r16 == r5) goto L18;
        if ((r5 + 1) > r16) goto L15;
        if (r16 >= r10) goto L15;
        r15.setSlotIndex(r16 - 1);
        goto L15
    L18:
        r15.setSlotIndex(r10);
        goto L15
    L45:
        return;
    }

    public final void setGroupIndex(int r5) {
        this.groupIndex = r5;
    }

    public final int slotPositionOf(KeyInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "keyInfo");
        GroupInfo r10 = this.groupInfos.get(Integer.valueOf(r5.getLocation()));
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getSlotIndex();
    }

    public final boolean updateNodeCount(int r5, int r10) {
        GroupInfo r11 = this.groupInfos.get(Integer.valueOf(r5));
        if (r11 == null) goto L18;
        int r12 = r11.getNodeIndex();
        int r13 = r10 - r11.getNodeCount();
        r11.setNodeCount(r10);
        if (r13 == 0) goto L16;
        Iterator<T> r14 = this.groupInfos.values().iterator();
    L8:
        if (r14.hasNext() == false) goto L29;
        GroupInfo r15 = (GroupInfo) r14.next();
        if (r15.getNodeIndex() < r12) goto L8;
        if (Intrinsics.areEqual(r15, r11) == true) goto L8;
        int r16 = r15.getNodeIndex() + r13;
        if (r16 < 0) goto L8;
        r15.setNodeIndex(r16);
        goto L8
    L29:
        return true;
    L16:
        return true;
    L18:
        return false;
    }

    public final int updatedNodeCountOf(KeyInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "keyInfo");
        GroupInfo r10 = this.groupInfos.get(Integer.valueOf(r5.getLocation()));
        if (r10 == null) goto L6;
        return r10.getNodeCount();
    L6:
        return r5.getNodes();
    }
}
