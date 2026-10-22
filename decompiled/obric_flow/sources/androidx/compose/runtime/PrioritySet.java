package androidx.compose.runtime;

import ai.j0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/PrioritySet;", "", "list", "", "", "(Ljava/util/List;)V", "add", "", "value", "isEmpty", "", "isNotEmpty", "peek", "takeMax", "validateHeap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/PrioritySet\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,3471:1\n4548#2,5:3472\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/PrioritySet\n*L\n3420#1:3472,5\n*E\n"})
public final class PrioritySet {
    private final List<Integer> list;

    /* JADX WARN: Multi-variable type inference failed */
    public PrioritySet() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void add(int r10) {
        if (this.list.isEmpty() == false) goto L5;
    L9:
        int r5 = this.list.size();
        this.list.add(Integer.valueOf(r10));
    L10:
        if (r5 <= 0) goto L14;
        int r11 = ((r5 + 1) >>> 1) - 1;
        int r12 = this.list.get(r11).intValue();
        if (r10 <= r12) goto L14;
        this.list.set(r5, Integer.valueOf(r12));
        r5 = r11;
    L14:
        this.list.set(r5, Integer.valueOf(r10));
        return;
    L5:
        if (this.list.get(0).intValue() != r10) goto L7;
        return;
    L7:
        if (((Number) j0.e(this.list, 1)).intValue() != r10) goto L9;
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.list.isEmpty();
    }

    public final int peek() {
        return ((Number) CollectionsKt.first(this.list)).intValue();
    }

    public final int takeMax() {
        if (this.list.size() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L24;
        int r10 = this.list.get(0).intValue();
    L9:
        if (this.list.isEmpty() == true) goto L22;
        if (this.list.get(0).intValue() != r10) goto L22;
        List<Integer> r11 = this.list;
        r11.set(0, (Integer) CollectionsKt.last(r11));
        List<Integer> r12 = this.list;
        r12.remove(r12.size() - 1);
        int r13 = this.list.size();
        int r14 = this.list.size() >>> 1;
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L9;
        int r16 = this.list.get(r15).intValue();
        int r17 = (r15 + 1) * 2;
        int r18 = r17 - 1;
        int r19 = this.list.get(r18).intValue();
        if (r17 >= r13) goto L20;
        int r110 = this.list.get(r17).intValue();
        if (r110 <= r19) goto L20;
        if (r110 <= r16) goto L9;
        this.list.set(r15, Integer.valueOf(r110));
        this.list.set(r17, Integer.valueOf(r16));
        r15 = r17;
    L20:
        if (r19 <= r16) goto L9;
        this.list.set(r15, Integer.valueOf(r19));
        this.list.set(r18, Integer.valueOf(r16));
        r15 = r18;
    L22:
        return r10;
    L24:
        throw j0.z("Set is empty");
    L5:
        r5 = false;
        goto L6
    }

    public final void validateHeap() {
        int r5 = this.list.size();
        int r10 = r5 / 2;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L15;
        int r12 = r11 + 1;
        int r13 = r12 * 2;
        if (this.list.get(r11).intValue() < this.list.get(r13 - 1).intValue()) goto L14;
        if (r13 >= r5) goto L12;
        if (this.list.get(r11).intValue() >= this.list.get(r13).intValue()) goto L12;
        throw new IllegalStateException("Check failed.");
    L12:
        r11 = r12;
        goto L3
    L14:
        throw new IllegalStateException("Check failed.");
    }

    public PrioritySet(List<Integer> r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        this.list = r5;
    }

    public /* synthetic */ PrioritySet(List r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = new ArrayList();
    L5:
        this(r5);
    }
}
