package com.obric.widget.host;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/widget/host/CreateOptions;", "", "instanceId", "", "config", "Lcom/obric/widget/host/WidgetConfig;", "restoreData", "<init>", "(Ljava/lang/String;Lcom/obric/widget/host/WidgetConfig;Ljava/lang/Object;)V", "getInstanceId", "()Ljava/lang/String;", "getConfig", "()Lcom/obric/widget/host/WidgetConfig;", "getRestoreData", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CreateOptions {
    private final WidgetConfig config;
    private final String instanceId;
    private final Object restoreData;

    public CreateOptions() {
        String r5 = null;
        WidgetConfig r10 = null;
        Object r11 = null;
        this(r5, r10, r11, 7, null);
    }

    public static /* synthetic */ CreateOptions copy$default(CreateOptions r5, String r10, WidgetConfig r11, Object r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.instanceId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.config;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.restoreData;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.instanceId;
    }

    public final WidgetConfig component2() {
        return this.config;
    }

    public final Object component3() {
        return this.restoreData;
    }

    public final CreateOptions copy(String r5, WidgetConfig r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        return new CreateOptions(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreateOptions) == true) goto L8;
        return false;
    L8:
        CreateOptions r10 = (CreateOptions) r5;
        if (Intrinsics.areEqual(this.instanceId, r10.instanceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.config, r10.config) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.restoreData, r10.restoreData) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final WidgetConfig getConfig() {
        return this.config;
    }

    public final String getInstanceId() {
        return this.instanceId;
    }

    public final Object getRestoreData() {
        return this.restoreData;
    }

    public int hashCode() {
        String r5 = this.instanceId;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (this.config.hashCode() + (r11 * 31)) * 31;
        Object r13 = this.restoreData;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public String toString() {
        return "CreateOptions(instanceId=" + this.instanceId + ", config=" + this.config + ", restoreData=" + this.restoreData + ")";
    }

    public CreateOptions(String r5, WidgetConfig r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.instanceId = r5;
        this.config = r10;
        this.restoreData = r11;
    }

    public /* synthetic */ CreateOptions(String r11, WidgetConfig r12, Object r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = new WidgetConfig(false, null, null, null, null, null, 63, null);
    L9:
        if ((r14 & 4) == 0) goto L11;
        r13 = null;
    L11:
        this(r11, r12, r13);
    }
}
