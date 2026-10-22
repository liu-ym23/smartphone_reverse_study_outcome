package com.obric.widget.host.runtime;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetInstanceRecordKey;", "", "instanceId", "", "<init>", "(I)V", "getInstanceId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class WidgetInstanceRecordKey {
    public static final Companion Companion = null;
    private final int instanceId;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetInstanceRecordKey$Companion;", "", "<init>", "()V", "from", "Lcom/obric/widget/host/runtime/WidgetInstanceRecordKey;", "snapshot", "Lcom/obric/widget/host/runtime/WidgetInstanceSnapshot;", "record", "Lcom/obric/widget/host/runtime/WidgetInstanceRecord;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final WidgetInstanceRecordKey from(WidgetInstanceSnapshot r5) {
            Intrinsics.checkNotNullParameter(r5, "snapshot");
            return new WidgetInstanceRecordKey(r5.getHostWidgetInstanceId());
        }

        private Companion() {
        }

        public final WidgetInstanceRecordKey from(WidgetInstanceRecord r5) {
            Intrinsics.checkNotNullParameter(r5, "record");
            return new WidgetInstanceRecordKey(r5.getHostWidgetInstanceId());
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetInstanceRecordKey(int r5) {
        this.instanceId = r5;
    }

    public static /* synthetic */ WidgetInstanceRecordKey copy$default(WidgetInstanceRecordKey r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.instanceId;
    L6:
        return r5.copy(r10);
    }

    public final int component1() {
        return this.instanceId;
    }

    public final WidgetInstanceRecordKey copy(int r5) {
        return new WidgetInstanceRecordKey(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetInstanceRecordKey) == true) goto L9;
        return false;
    L9:
        if (this.instanceId == ((WidgetInstanceRecordKey) r5).instanceId) goto L11;
        return false;
    L11:
        return true;
    }

    public final int getInstanceId() {
        return this.instanceId;
    }

    public int hashCode() {
        return Integer.hashCode(this.instanceId);
    }

    public String toString() {
        return j0.h(this.instanceId, "WidgetInstanceRecordKey(instanceId=", ")");
    }
}
