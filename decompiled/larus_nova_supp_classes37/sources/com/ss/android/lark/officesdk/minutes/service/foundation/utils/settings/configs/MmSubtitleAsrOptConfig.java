package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "vc_subtitle_asr_opt_switch")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmSubtitleAsrOptConfig;", "Ljava/io/Serializable;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "toString", "", "component1", "copy", "equals", "other", "", "hashCode", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSubtitleAsrOptConfig implements Serializable {
    private final boolean enabled;

    public MmSubtitleAsrOptConfig() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ MmSubtitleAsrOptConfig copy$default(MmSubtitleAsrOptConfig r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.enabled;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final MmSubtitleAsrOptConfig copy(boolean r2) {
        return new MmSubtitleAsrOptConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MmSubtitleAsrOptConfig) == true) goto L9;
        return false;
    L9:
        if (this.enabled == ((MmSubtitleAsrOptConfig) r4).enabled) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.enabled == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "enabled=" + this.enabled;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public MmSubtitleAsrOptConfig(boolean r1) {
        this.enabled = r1;
    }

    public /* synthetic */ MmSubtitleAsrOptConfig(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}
