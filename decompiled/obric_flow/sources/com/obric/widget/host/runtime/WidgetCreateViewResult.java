package com.obric.widget.host.runtime;

import ai.j0;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003Jo\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001J\u0013\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0007HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u00062"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetCreateViewResult;", "", "view", "Landroid/view/View;", "snapshotResult", "Lcom/obric/widget/host/runtime/WidgetSnapshotQueryResult;", "primePayloadLength", "", "primeUpdateDurationMs", "", "needsAsyncPayloadUpdate", "", "mainInternalQueryDurationMs", "mainSetupDurationMs", "mainSdkCreateDurationMs", "mainPostCreateDurationMs", "createDurationMs", "<init>", "(Landroid/view/View;Lcom/obric/widget/host/runtime/WidgetSnapshotQueryResult;IJZJJJJJ)V", "getView", "()Landroid/view/View;", "getSnapshotResult", "()Lcom/obric/widget/host/runtime/WidgetSnapshotQueryResult;", "getPrimePayloadLength", "()I", "getPrimeUpdateDurationMs", "()J", "getNeedsAsyncPayloadUpdate", "()Z", "getMainInternalQueryDurationMs", "getMainSetupDurationMs", "getMainSdkCreateDurationMs", "getMainPostCreateDurationMs", "getCreateDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetCreateViewResult {
    private final long createDurationMs;
    private final long mainInternalQueryDurationMs;
    private final long mainPostCreateDurationMs;
    private final long mainSdkCreateDurationMs;
    private final long mainSetupDurationMs;
    private final boolean needsAsyncPayloadUpdate;
    private final int primePayloadLength;
    private final long primeUpdateDurationMs;
    private final WidgetSnapshotQueryResult snapshotResult;
    private final View view;

    public WidgetCreateViewResult(View r5, WidgetSnapshotQueryResult r10, int r11, long r12, boolean r13, long r14, long r15, long r16, long r17, long r18) {
        Intrinsics.checkNotNullParameter(r10, "snapshotResult");
        this.view = r5;
        this.snapshotResult = r10;
        this.primePayloadLength = r11;
        this.primeUpdateDurationMs = r12;
        this.needsAsyncPayloadUpdate = r13;
        this.mainInternalQueryDurationMs = r14;
        this.mainSetupDurationMs = r15;
        this.mainSdkCreateDurationMs = r16;
        this.mainPostCreateDurationMs = r17;
        this.createDurationMs = r18;
    }

    public static /* synthetic */ WidgetCreateViewResult copy$default(WidgetCreateViewResult r16, View r17, WidgetSnapshotQueryResult r18, int r19, long r20, boolean r22, long r23, long r25, long r27, long r29, long r31, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        View r5 = r16.view;
    L7:
        if ((r33 & 2) == 0) goto L9;
        WidgetSnapshotQueryResult r10 = r16.snapshotResult;
    L11:
        if ((r33 & 4) == 0) goto L13;
        int r11 = r16.primePayloadLength;
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r12 = r16.primeUpdateDurationMs;
    L19:
        if ((r33 & 16) == 0) goto L21;
        boolean r13 = r16.needsAsyncPayloadUpdate;
    L23:
        if ((r33 & 32) == 0) goto L25;
        long r14 = r16.mainInternalQueryDurationMs;
    L27:
        if ((r33 & 64) == 0) goto L29;
        long r15 = r16.mainSetupDurationMs;
    L31:
        if ((r33 & 128) == 0) goto L33;
        long r110 = r16.mainSdkCreateDurationMs;
    L35:
        if ((r33 & 256) == 0) goto L37;
        long r111 = r16.mainPostCreateDurationMs;
    L38:
        long r210 = r111;
        if ((r33 & 512) == 0) goto L41;
        long r112 = r16.createDurationMs;
    L43:
        return r16.copy(r5, r10, r11, r12, r13, r14, r15, r110, r210, r112);
    L41:
        r112 = r31;
        goto L43
    L37:
        r111 = r29;
        goto L38
    L33:
        r110 = r27;
        goto L35
    L29:
        r15 = r25;
        goto L31
    L25:
        r14 = r23;
        goto L27
    L21:
        r13 = r22;
        goto L23
    L17:
        r12 = r20;
        goto L19
    L13:
        r11 = r19;
        goto L15
    L9:
        r10 = r18;
        goto L11
    L5:
        r5 = r17;
        goto L7
    }

    public final View component1() {
        return this.view;
    }

    public final long component10() {
        return this.createDurationMs;
    }

    public final WidgetSnapshotQueryResult component2() {
        return this.snapshotResult;
    }

    public final int component3() {
        return this.primePayloadLength;
    }

    public final long component4() {
        return this.primeUpdateDurationMs;
    }

    public final boolean component5() {
        return this.needsAsyncPayloadUpdate;
    }

    public final long component6() {
        return this.mainInternalQueryDurationMs;
    }

    public final long component7() {
        return this.mainSetupDurationMs;
    }

    public final long component8() {
        return this.mainSdkCreateDurationMs;
    }

    public final long component9() {
        return this.mainPostCreateDurationMs;
    }

    public final WidgetCreateViewResult copy(View r19, WidgetSnapshotQueryResult r20, int r21, long r22, boolean r24, long r25, long r27, long r29, long r31, long r33) {
        Intrinsics.checkNotNullParameter(r20, "snapshotResult");
        return new WidgetCreateViewResult(r19, r20, r21, r22, r24, r25, r27, r29, r31, r33);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetCreateViewResult) == true) goto L8;
        return false;
    L8:
        WidgetCreateViewResult r11 = (WidgetCreateViewResult) r10;
        if (Intrinsics.areEqual(this.view, r11.view) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.snapshotResult, r11.snapshotResult) == true) goto L15;
        return false;
    L15:
        if (this.primePayloadLength == r11.primePayloadLength) goto L18;
        return false;
    L18:
        if (this.primeUpdateDurationMs == r11.primeUpdateDurationMs) goto L21;
        return false;
    L21:
        if (this.needsAsyncPayloadUpdate == r11.needsAsyncPayloadUpdate) goto L24;
        return false;
    L24:
        if (this.mainInternalQueryDurationMs == r11.mainInternalQueryDurationMs) goto L27;
        return false;
    L27:
        if (this.mainSetupDurationMs == r11.mainSetupDurationMs) goto L30;
        return false;
    L30:
        if (this.mainSdkCreateDurationMs == r11.mainSdkCreateDurationMs) goto L33;
        return false;
    L33:
        if (this.mainPostCreateDurationMs == r11.mainPostCreateDurationMs) goto L36;
        return false;
    L36:
        if (this.createDurationMs == r11.createDurationMs) goto L38;
        return false;
    L38:
        return true;
    }

    public final long getCreateDurationMs() {
        return this.createDurationMs;
    }

    public final long getMainInternalQueryDurationMs() {
        return this.mainInternalQueryDurationMs;
    }

    public final long getMainPostCreateDurationMs() {
        return this.mainPostCreateDurationMs;
    }

    public final long getMainSdkCreateDurationMs() {
        return this.mainSdkCreateDurationMs;
    }

    public final long getMainSetupDurationMs() {
        return this.mainSetupDurationMs;
    }

    public final boolean getNeedsAsyncPayloadUpdate() {
        return this.needsAsyncPayloadUpdate;
    }

    public final int getPrimePayloadLength() {
        return this.primePayloadLength;
    }

    public final long getPrimeUpdateDurationMs() {
        return this.primeUpdateDurationMs;
    }

    public final WidgetSnapshotQueryResult getSnapshotResult() {
        return this.snapshotResult;
    }

    public final View getView() {
        return this.view;
    }

    public int hashCode() {
        View r5 = this.view;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = this.snapshotResult.hashCode();
        int r12 = (r11 + (r10 * 31)) * 31;
        int r13 = androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.c(this.primePayloadLength, r12, 31), this.primeUpdateDurationMs, 31), 31, this.needsAsyncPayloadUpdate), this.mainInternalQueryDurationMs, 31), this.mainSetupDurationMs, 31), this.mainSdkCreateDurationMs, 31), this.mainPostCreateDurationMs, 31);
        return Long.hashCode(this.createDurationMs) + r13;
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public String toString() {
        View r5 = this.view;
        WidgetSnapshotQueryResult r10 = this.snapshotResult;
        int r11 = this.primePayloadLength;
        long r12 = this.primeUpdateDurationMs;
        boolean r13 = this.needsAsyncPayloadUpdate;
        long r14 = this.mainInternalQueryDurationMs;
        long r15 = this.mainSetupDurationMs;
        long r16 = this.mainSdkCreateDurationMs;
        long r17 = this.mainPostCreateDurationMs;
        long r18 = this.createDurationMs;
        StringBuilder r19 = new StringBuilder("WidgetCreateViewResult(view=");
        r19.append(r5);
        r19.append(", snapshotResult=");
        r19.append(r10);
        r19.append(", primePayloadLength=");
        r19.append(r11);
        r19.append(", primeUpdateDurationMs=");
        r19.append(r12);
        r19.append(", needsAsyncPayloadUpdate=");
        r19.append(r13);
        r19.append(", mainInternalQueryDurationMs=");
        r19.append(r14);
        kotlin.collections.a.o(r19, ", mainSetupDurationMs=", r15, ", mainSdkCreateDurationMs=");
        r19.append(r16);
        kotlin.collections.a.o(r19, ", mainPostCreateDurationMs=", r17, ", createDurationMs=");
        return j0.o(r19, r18, ")");
    }
}
