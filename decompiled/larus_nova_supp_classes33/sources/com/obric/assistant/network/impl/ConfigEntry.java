package com.obric.assistant.network.impl;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/network/impl/ConfigEntry;", "", "key", "", "value", "operateCursor", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getKey", "()Ljava/lang/String;", "getValue", "getOperateCursor", "()J", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfigEntry {

    @SerializedName("Key")
    private final String key;

    @SerializedName("OperateCursor")
    private final long operateCursor;

    @SerializedName("Value")
    private final String value;

    public ConfigEntry() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ ConfigEntry copy$default(ConfigEntry r0, String r1, String r2, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.key;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.value;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.operateCursor;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final long component3() {
        return this.operateCursor;
    }

    public final ConfigEntry copy(String r2, String r3, long r4) {
        return new ConfigEntry(r2, r3, r4);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ConfigEntry) == true) goto L8;
        return false;
    L8:
        ConfigEntry r9 = (ConfigEntry) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r9.value) == true) goto L15;
        return false;
    L15:
        if (this.operateCursor == r9.operateCursor) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.value;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        long r6 = this.operateCursor;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ConfigEntry(key=" + this.key + ", value=" + this.value + ", operateCursor=" + this.operateCursor + ')';
    }

    public final String getKey() {
        return this.key;
    }

    public final long getOperateCursor() {
        return this.operateCursor;
    }

    public final String getValue() {
        return this.value;
    }

    public ConfigEntry(String r1, String r2, long r3) {
        this.key = r1;
        this.value = r2;
        this.operateCursor = r3;
    }

    public /* synthetic */ ConfigEntry(String r2, String r3, long r4, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
