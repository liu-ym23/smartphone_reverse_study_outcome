package com.obric.widget.host;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/widget/host/WidgetPerfEvent;", "", "name", "", "hostId", STGroup.DICT_KEY, "Lcom/obric/widget/host/WidgetInstanceKey;", "timestampMs", "", "values", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/widget/host/WidgetInstanceKey;JLjava/util/Map;)V", "getName", "()Ljava/lang/String;", "getHostId", "getKey", "()Lcom/obric/widget/host/WidgetInstanceKey;", "getTimestampMs", "()J", "getValues", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetPerfEvent {
    private final String hostId;
    private final WidgetInstanceKey key;
    private final String name;
    private final long timestampMs;
    private final Map<String, Object> values;

    public WidgetPerfEvent(String r5, String r10, WidgetInstanceKey r11, long r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "hostId");
        Intrinsics.checkNotNullParameter(r13, "values");
        this.name = r5;
        this.hostId = r10;
        this.key = r11;
        this.timestampMs = r12;
        this.values = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetPerfEvent copy$default(WidgetPerfEvent r5, String r10, String r11, WidgetInstanceKey r12, long r13, Map r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = r5.name;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = r5.hostId;
    L8:
        String r17 = r11;
        if ((r15 & 4) == 0) goto L11;
        r12 = r5.key;
    L11:
        WidgetInstanceKey r18 = r12;
        if ((r15 & 8) == 0) goto L14;
        r13 = r5.timestampMs;
    L14:
        long r19 = r13;
        if ((r15 & 16) == 0) goto L17;
        r14 = r5.values;
    L17:
        String r20 = r10;
        return r5.copy(r20, r17, r18, r19, r14);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.hostId;
    }

    public final WidgetInstanceKey component3() {
        return this.key;
    }

    public final long component4() {
        return this.timestampMs;
    }

    public final Map<String, Object> component5() {
        return this.values;
    }

    public final WidgetPerfEvent copy(String r10, String r11, WidgetInstanceKey r12, long r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "hostId");
        Intrinsics.checkNotNullParameter(r14, "values");
        return new WidgetPerfEvent(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetPerfEvent) == true) goto L8;
        return false;
    L8:
        WidgetPerfEvent r11 = (WidgetPerfEvent) r10;
        if (Intrinsics.areEqual(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hostId, r11.hostId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r11.key) == true) goto L18;
        return false;
    L18:
        if (this.timestampMs == r11.timestampMs) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.values, r11.values) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getHostId() {
        return this.hostId;
    }

    public final WidgetInstanceKey getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final Map<String, Object> getValues() {
        return this.values;
    }

    public int hashCode() {
        int r5 = a.c(this.name.hashCode() * 31, 31, this.hostId);
        WidgetInstanceKey r10 = this.key;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = androidx.room.jarjarred.org.antlr.runtime.a.e((r5 + r11) * 31, this.timestampMs, 31);
        return this.values.hashCode() + r12;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public String toString() {
        String r5 = this.name;
        String r10 = this.hostId;
        WidgetInstanceKey r11 = this.key;
        long r12 = this.timestampMs;
        Map<String, Object> r13 = this.values;
        StringBuilder r14 = a.y("WidgetPerfEvent(name=", r5, ", hostId=", r10, ", key=");
        r14.append(r11);
        r14.append(", timestampMs=");
        r14.append(r12);
        r14.append(", values=");
        r14.append(r13);
        r14.append(")");
        return r14.toString();
    }

    public /* synthetic */ WidgetPerfEvent(String r10, String r11, WidgetInstanceKey r12, long r13, Map r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 4) == 0) goto L5;
        r12 = null;
    L5:
        WidgetInstanceKey r5 = r12;
        if ((r15 & 8) == 0) goto L8;
        r13 = System.currentTimeMillis();
    L8:
        long r17 = r13;
        if ((r15 & 16) == 0) goto L11;
        r14 = MapsKt.emptyMap();
    L11:
        this(r10, r11, r5, r17, r14);
    }
}
