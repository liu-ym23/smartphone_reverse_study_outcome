package com.obric.assistant.relative;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/relative/RelativeResult;", "", "status", "", "extra", "Lcom/obric/assistant/relative/Extra;", "<init>", "(Ljava/lang/String;Lcom/obric/assistant/relative/Extra;)V", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "getExtra", "()Lcom/obric/assistant/relative/Extra;", "setExtra", "(Lcom/obric/assistant/relative/Extra;)V", "component1", "component2", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RelativeResult {

    @SerializedName("extra")
    private Extra extra;

    @SerializedName("status")
    private String status;

    /* JADX WARN: Multi-variable type inference failed */
    public RelativeResult() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RelativeResult copy$default(RelativeResult r0, String r1, Extra r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.extra;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.status;
    }

    public final Extra component2() {
        return this.extra;
    }

    public final RelativeResult copy(String r2, Extra r3) {
        return new RelativeResult(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RelativeResult) == true) goto L8;
        return false;
    L8:
        RelativeResult r6 = (RelativeResult) r5;
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.status;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Extra r4 = this.extra;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RelativeResult(status=" + this.status + ", extra=" + this.extra + ')';
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setExtra(Extra r1) {
        this.extra = r1;
    }

    public final void setStatus(String r1) {
        this.status = r1;
    }

    public RelativeResult(String r1, Extra r2) {
        this.status = r1;
        this.extra = r2;
    }

    public /* synthetic */ RelativeResult(String r1, Extra r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
