package com.bytedance.android.ec.core.event.eventdumper.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventBatch;", "Ljava/io/Serializable;", a.KEY_RESULT, "Lcom/bytedance/android/ec/core/event/eventdumper/model/Result;", "dumpedEventList", "", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEvent;", "(Lcom/bytedance/android/ec/core/event/eventdumper/model/Result;Ljava/util/List;)V", "getDumpedEventList", "()Ljava/util/List;", "setDumpedEventList", "(Ljava/util/List;)V", "getResult", "()Lcom/bytedance/android/ec/core/event/eventdumper/model/Result;", "setResult", "(Lcom/bytedance/android/ec/core/event/eventdumper/model/Result;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DumpedEventBatch implements Serializable {

    @SerializedName("event_list")
    private List<DumpedEvent> dumpedEventList;

    @SerializedName(a.KEY_RESULT)
    private Result result;

    /* JADX WARN: Multi-variable type inference failed */
    public DumpedEventBatch() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DumpedEventBatch copy$default(DumpedEventBatch r0, Result r1, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.result;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.dumpedEventList;
    L9:
        return r0.copy(r1, r10);
    }

    public final Result component1() {
        return this.result;
    }

    public final List<DumpedEvent> component2() {
        return this.dumpedEventList;
    }

    public final DumpedEventBatch copy(Result r10, List<DumpedEvent> r11) {
        return new DumpedEventBatch(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof DumpedEventBatch) == false) goto L10;
        DumpedEventBatch r11 = (DumpedEventBatch) r10;
        if (Intrinsics.areEqual(this.result, r11.result) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dumpedEventList, r11.dumpedEventList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Result r0 = this.result;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        List<DumpedEvent> r12 = this.dumpedEventList;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "DumpedEventBatch(result=" + this.result + ", dumpedEventList=" + this.dumpedEventList + ")";
    }

    public final List<DumpedEvent> getDumpedEventList() {
        return this.dumpedEventList;
    }

    public final Result getResult() {
        return this.result;
    }

    public final void setDumpedEventList(List<DumpedEvent> r1) {
        this.dumpedEventList = r1;
    }

    public final void setResult(Result r1) {
        this.result = r1;
    }

    public DumpedEventBatch(Result r1, List<DumpedEvent> r10) {
        this.result = r1;
        this.dumpedEventList = r10;
    }

    public /* synthetic */ DumpedEventBatch(Result r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
