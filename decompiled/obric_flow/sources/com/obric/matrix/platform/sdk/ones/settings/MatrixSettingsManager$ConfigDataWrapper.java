package com.obric.matrix.platform.sdk.ones.settings;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0083\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"com/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager$ConfigDataWrapper", "", "config_data", "<init>", "(Ljava/lang/Object;)V", "component1", "()Ljava/lang/Object;", "Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager$ConfigDataWrapper;", "copy", "(Ljava/lang/Object;)Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager$ConfigDataWrapper;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getConfig_data", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class MatrixSettingsManager$ConfigDataWrapper {
    private final Object config_data;

    public MatrixSettingsManager$ConfigDataWrapper() {
        DefaultConstructorMarker r5 = null;
        this(r5, 1, r5);
    }

    public static /* synthetic */ MatrixSettingsManager$ConfigDataWrapper copy$default(MatrixSettingsManager$ConfigDataWrapper r5, Object r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.config_data;
    L6:
        return r5.copy(r10);
    }

    public final Object component1() {
        return this.config_data;
    }

    public final MatrixSettingsManager$ConfigDataWrapper copy(Object r5) {
        return new MatrixSettingsManager$ConfigDataWrapper(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MatrixSettingsManager$ConfigDataWrapper) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.config_data, ((MatrixSettingsManager$ConfigDataWrapper) r5).config_data) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final Object getConfig_data() {
        return this.config_data;
    }

    public int hashCode() {
        Object r5 = this.config_data;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    public String toString() {
        return "ConfigDataWrapper(config_data=" + this.config_data + ')';
    }

    public MatrixSettingsManager$ConfigDataWrapper(Object r5) {
        this.config_data = r5;
    }

    public /* synthetic */ MatrixSettingsManager$ConfigDataWrapper(Object r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
