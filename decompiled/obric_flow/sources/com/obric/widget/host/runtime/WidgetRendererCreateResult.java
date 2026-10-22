package com.obric.widget.host.runtime;

import ai.j0;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\""}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRendererCreateResult;", "", "view", "Landroid/view/View;", "internalQueryDurationMs", "", "setupDurationMs", "sdkCreateDurationMs", "postCreateDurationMs", "createDurationMs", "<init>", "(Landroid/view/View;JJJJJ)V", "getView", "()Landroid/view/View;", "getInternalQueryDurationMs", "()J", "getSetupDurationMs", "getSdkCreateDurationMs", "getPostCreateDurationMs", "getCreateDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetRendererCreateResult {
    private final long createDurationMs;
    private final long internalQueryDurationMs;
    private final long postCreateDurationMs;
    private final long sdkCreateDurationMs;
    private final long setupDurationMs;
    private final View view;

    public WidgetRendererCreateResult(View r5, long r10, long r11, long r12, long r13, long r14) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.view = r5;
        this.internalQueryDurationMs = r10;
        this.setupDurationMs = r11;
        this.sdkCreateDurationMs = r12;
        this.postCreateDurationMs = r13;
        this.createDurationMs = r14;
    }

    public static /* synthetic */ WidgetRendererCreateResult copy$default(WidgetRendererCreateResult r12, View r13, long r14, long r16, long r18, long r20, long r22, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        View r5 = r12.view;
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r10 = r12.internalQueryDurationMs;
    L11:
        if ((r24 & 4) == 0) goto L13;
        long r11 = r12.setupDurationMs;
    L15:
        if ((r24 & 8) == 0) goto L17;
        long r15 = r12.sdkCreateDurationMs;
    L19:
        if ((r24 & 16) == 0) goto L21;
        long r17 = r12.postCreateDurationMs;
    L23:
        if ((r24 & 32) == 0) goto L25;
        long r19 = r12.createDurationMs;
    L27:
        return r12.copy(r5, r10, r11, r15, r17, r19);
    L25:
        r19 = r22;
        goto L27
    L21:
        r17 = r20;
        goto L23
    L17:
        r15 = r18;
        goto L19
    L13:
        r11 = r16;
        goto L15
    L9:
        r10 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public final View component1() {
        return this.view;
    }

    public final long component2() {
        return this.internalQueryDurationMs;
    }

    public final long component3() {
        return this.setupDurationMs;
    }

    public final long component4() {
        return this.sdkCreateDurationMs;
    }

    public final long component5() {
        return this.postCreateDurationMs;
    }

    public final long component6() {
        return this.createDurationMs;
    }

    public final WidgetRendererCreateResult copy(View r14, long r15, long r17, long r19, long r21, long r23) {
        Intrinsics.checkNotNullParameter(r14, "view");
        return new WidgetRendererCreateResult(r14, r15, r17, r19, r21, r23);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetRendererCreateResult) == true) goto L8;
        return false;
    L8:
        WidgetRendererCreateResult r11 = (WidgetRendererCreateResult) r10;
        if (Intrinsics.areEqual(this.view, r11.view) == true) goto L12;
        return false;
    L12:
        if (this.internalQueryDurationMs == r11.internalQueryDurationMs) goto L15;
        return false;
    L15:
        if (this.setupDurationMs == r11.setupDurationMs) goto L18;
        return false;
    L18:
        if (this.sdkCreateDurationMs == r11.sdkCreateDurationMs) goto L21;
        return false;
    L21:
        if (this.postCreateDurationMs == r11.postCreateDurationMs) goto L24;
        return false;
    L24:
        if (this.createDurationMs == r11.createDurationMs) goto L26;
        return false;
    L26:
        return true;
    }

    public final long getCreateDurationMs() {
        return this.createDurationMs;
    }

    public final long getInternalQueryDurationMs() {
        return this.internalQueryDurationMs;
    }

    public final long getPostCreateDurationMs() {
        return this.postCreateDurationMs;
    }

    public final long getSdkCreateDurationMs() {
        return this.sdkCreateDurationMs;
    }

    public final long getSetupDurationMs() {
        return this.setupDurationMs;
    }

    public final View getView() {
        return this.view;
    }

    public int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e(this.view.hashCode() * 31, this.internalQueryDurationMs, 31), this.setupDurationMs, 31), this.sdkCreateDurationMs, 31), this.postCreateDurationMs, 31);
        return Long.hashCode(this.createDurationMs) + r5;
    }

    public String toString() {
        View r5 = this.view;
        long r10 = this.internalQueryDurationMs;
        long r11 = this.setupDurationMs;
        long r12 = this.sdkCreateDurationMs;
        long r13 = this.postCreateDurationMs;
        long r14 = this.createDurationMs;
        StringBuilder r15 = new StringBuilder("WidgetRendererCreateResult(view=");
        r15.append(r5);
        r15.append(", internalQueryDurationMs=");
        r15.append(r10);
        kotlin.collections.a.o(r15, ", setupDurationMs=", r11, ", sdkCreateDurationMs=");
        r15.append(r12);
        kotlin.collections.a.o(r15, ", postCreateDurationMs=", r13, ", createDurationMs=");
        return j0.o(r15, r14, ")");
    }
}
