package com.obric.matrix.platform.sdk.ones.settings;

import androidx.annotation.Keep;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
final class MatrixSettingsManager$ConfigDataWrapper {
    private final Object config_data;

    public MatrixSettingsManager$ConfigDataWrapper() {
        DefaultConstructorMarker r10 = null;
        this(r10, 1, r10);
    }

    public MatrixSettingsManager$ConfigDataWrapper(Object r10) {
        this.config_data = r10;
    }

    public /* synthetic */ MatrixSettingsManager$ConfigDataWrapper(Object r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }

    public static /* synthetic */ MatrixSettingsManager$ConfigDataWrapper copy$default(MatrixSettingsManager$ConfigDataWrapper r10, Object r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.config_data;
    L6:
        return r10.copy(r11);
    }

    public final Object component1() {
        return this.config_data;
    }

    public final MatrixSettingsManager$ConfigDataWrapper copy(Object r10) {
        return new MatrixSettingsManager$ConfigDataWrapper(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MatrixSettingsManager$ConfigDataWrapper) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.config_data, ((MatrixSettingsManager$ConfigDataWrapper) r10).config_data) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final Object getConfig_data() {
        return this.config_data;
    }

    public int hashCode() {
        Object r10 = this.config_data;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    public String toString() {
        return "ConfigDataWrapper(config_data=" + this.config_data + ')';
    }
}
