package com.obric.matrix.platform.sdk.ones.settings;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0083\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0015\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"com/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager$ConfigDataWrapper", "", "component1", "config_data", "Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager$ConfigDataWrapper;", "copy", "", "toString", "", "hashCode", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "equals", "Ljava/lang/Object;", "getConfig_data", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
final class MatrixSettingsManager$ConfigDataWrapper {
    private final Object config_data;

    public MatrixSettingsManager$ConfigDataWrapper() {
        DefaultConstructorMarker r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ MatrixSettingsManager$ConfigDataWrapper copy$default(MatrixSettingsManager$ConfigDataWrapper r0, Object r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.config_data;
    L6:
        return r0.copy(r1);
    }

    public final Object component1() {
        return this.config_data;
    }

    public final MatrixSettingsManager$ConfigDataWrapper copy(Object r2) {
        return new MatrixSettingsManager$ConfigDataWrapper(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MatrixSettingsManager$ConfigDataWrapper) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.config_data, ((MatrixSettingsManager$ConfigDataWrapper) r4).config_data) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Object r0 = this.config_data;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ConfigDataWrapper(config_data=" + this.config_data + ')';
    }

    public final Object getConfig_data() {
        return this.config_data;
    }

    public MatrixSettingsManager$ConfigDataWrapper(Object r1) {
        this.config_data = r1;
    }

    public /* synthetic */ MatrixSettingsManager$ConfigDataWrapper(Object r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
