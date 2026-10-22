package com.bytedance.android.ec.core.event.eventdumper.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventKey;", "Ljava/io/Serializable;", "keyName", "", "isDeclared", "", "(Ljava/lang/String;Z)V", "()Z", "setDeclared", "(Z)V", "getKeyName", "()Ljava/lang/String;", "setKeyName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DumpedEventKey implements Serializable {

    @SerializedName("is_declared")
    private boolean isDeclared;

    @SerializedName("key_name")
    private String keyName;

    public DumpedEventKey() {
        String r10 = null;
        this(r10, false, 3, r10);
    }

    public static /* synthetic */ DumpedEventKey copy$default(DumpedEventKey r0, String r1, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.keyName;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.isDeclared;
    L9:
        return r0.copy(r1, r10);
    }

    public final String component1() {
        return this.keyName;
    }

    public final boolean component2() {
        return this.isDeclared;
    }

    public final DumpedEventKey copy(String r10, boolean r11) {
        return new DumpedEventKey(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof DumpedEventKey) == false) goto L10;
        DumpedEventKey r11 = (DumpedEventKey) r10;
        if (Intrinsics.areEqual(this.keyName, r11.keyName) == true) goto L8;
        return false;
    L8:
        if (this.isDeclared == r11.isDeclared) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String r0 = this.keyName;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r10 = r1 * 31;
        boolean r11 = this.isDeclared;
        ?? r12 = r11;
        if (r11 == false) goto L10;
        r12 = 1;
    L10:
        return r10 + r12;
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "DumpedEventKey(keyName=" + this.keyName + ", isDeclared=" + this.isDeclared + ")";
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public final boolean isDeclared() {
        return this.isDeclared;
    }

    public final void setDeclared(boolean r1) {
        this.isDeclared = r1;
    }

    public final void setKeyName(String r1) {
        this.keyName = r1;
    }

    public DumpedEventKey(String r1, boolean r10) {
        this.keyName = r1;
        this.isDeclared = r10;
    }

    public /* synthetic */ DumpedEventKey(String r1, boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = false;
    L8:
        this(r1, r10);
    }
}
