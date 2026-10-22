package com.obric.assistant.settings.config;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/settings/config/ObricMmtVideoHardwareConfig;", "", "enable", "", "deviceBlacklist", "", "", "<init>", "(ZLjava/util/List;)V", "getEnable", "()Z", "getDeviceBlacklist", "()Ljava/util/List;", "component1", "component2", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMmtVideoHardwareConfig {

    @SerializedName("device_blacklist")
    private final List<String> deviceBlacklist;

    @SerializedName("enable")
    private final boolean enable;

    public ObricMmtVideoHardwareConfig() {
        List r0 = null;
        boolean r2 = false;
        this(r2, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricMmtVideoHardwareConfig copy$default(ObricMmtVideoHardwareConfig r0, boolean r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.deviceBlacklist;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final List<String> component2() {
        return this.deviceBlacklist;
    }

    public final ObricMmtVideoHardwareConfig copy(boolean r2, List<String> r3) {
        return new ObricMmtVideoHardwareConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricMmtVideoHardwareConfig) == true) goto L8;
        return false;
    L8:
        ObricMmtVideoHardwareConfig r6 = (ObricMmtVideoHardwareConfig) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceBlacklist, r6.deviceBlacklist) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        List<String> r2 = this.deviceBlacklist;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricMmtVideoHardwareConfig(enable=" + this.enable + ", deviceBlacklist=" + this.deviceBlacklist + ')';
    }

    public final List<String> getDeviceBlacklist() {
        return this.deviceBlacklist;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public ObricMmtVideoHardwareConfig(boolean r1, List<String> r2) {
        this.enable = r1;
        this.deviceBlacklist = r2;
    }

    public /* synthetic */ ObricMmtVideoHardwareConfig(boolean r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        this(r1, r2);
    }
}
