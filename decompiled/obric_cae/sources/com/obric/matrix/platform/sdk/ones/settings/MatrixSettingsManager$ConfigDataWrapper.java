package com.obric.matrix.platform.sdk.ones.settings;

import androidx.annotation.Keep;
import he.e;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
@Keep
final class MatrixSettingsManager$ConfigDataWrapper {
    private final Object config_data;

    public MatrixSettingsManager$ConfigDataWrapper() {
        e r8 = null;
        this(r8, 1, r8);
    }

    public static /* synthetic */ MatrixSettingsManager$ConfigDataWrapper copy$default(MatrixSettingsManager$ConfigDataWrapper r8, Object r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r8.config_data;
    L6:
        return r8.copy(r10);
    }

    public final Object component1() {
        return this.config_data;
    }

    public final MatrixSettingsManager$ConfigDataWrapper copy(Object r8) {
        return new MatrixSettingsManager$ConfigDataWrapper(r8);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MatrixSettingsManager$ConfigDataWrapper) == true) goto L9;
        return false;
    L9:
        if (i.a(this.config_data, ((MatrixSettingsManager$ConfigDataWrapper) r8).config_data) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final Object getConfig_data() {
        return this.config_data;
    }

    public int hashCode() {
        Object r8 = this.config_data;
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.hashCode();
    }

    public String toString() {
        return "ConfigDataWrapper(config_data=" + this.config_data + ')';
    }

    public MatrixSettingsManager$ConfigDataWrapper(Object r8) {
        this.config_data = r8;
    }

    public /* synthetic */ MatrixSettingsManager$ConfigDataWrapper(Object r8, int r10, e r11) {
        if ((r10 & 1) == 0) goto L5;
        r8 = null;
    L5:
        this(r8);
    }
}
