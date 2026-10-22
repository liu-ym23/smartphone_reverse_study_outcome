package com.obric.widget.host.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRefreshAffectedResult;", "", "acceptedCount", "", "updatedWidgetIds", "", "", "<init>", "(ILjava/util/List;)V", "getAcceptedCount", "()I", "getUpdatedWidgetIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetRefreshAffectedResult {
    private final int acceptedCount;
    private final List<String> updatedWidgetIds;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetRefreshAffectedResult() {
        int r5 = 0;
        this(r5, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetRefreshAffectedResult copy$default(WidgetRefreshAffectedResult r5, int r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.acceptedCount;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.updatedWidgetIds;
    L9:
        return r5.copy(r10, r11);
    }

    public final int component1() {
        return this.acceptedCount;
    }

    public final List<String> component2() {
        return this.updatedWidgetIds;
    }

    public final WidgetRefreshAffectedResult copy(int r5, List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "updatedWidgetIds");
        return new WidgetRefreshAffectedResult(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetRefreshAffectedResult) == true) goto L8;
        return false;
    L8:
        WidgetRefreshAffectedResult r10 = (WidgetRefreshAffectedResult) r5;
        if (this.acceptedCount == r10.acceptedCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.updatedWidgetIds, r10.updatedWidgetIds) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getAcceptedCount() {
        return this.acceptedCount;
    }

    public final List<String> getUpdatedWidgetIds() {
        return this.updatedWidgetIds;
    }

    public int hashCode() {
        int r5 = Integer.hashCode(this.acceptedCount) * 31;
        return this.updatedWidgetIds.hashCode() + r5;
    }

    public String toString() {
        return "WidgetRefreshAffectedResult(acceptedCount=" + this.acceptedCount + ", updatedWidgetIds=" + this.updatedWidgetIds + ")";
    }

    public WidgetRefreshAffectedResult(int r5, List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "updatedWidgetIds");
        this.acceptedCount = r5;
        this.updatedWidgetIds = r10;
    }

    public /* synthetic */ WidgetRefreshAffectedResult(int r5, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = CollectionsKt.emptyList();
    L8:
        this(r5, r10);
    }
}
