package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mvb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "vc_hardware_function_config")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmHardwareFunctionConfigSetting;", "", "d1204", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmD1204FunctionConfigSetting;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmD1204FunctionConfigSetting;)V", "getD1204", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmD1204FunctionConfigSetting;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmHardwareFunctionConfigSetting {

    @SerializedName("d1204")
    private final a d1204;

    public MmHardwareFunctionConfigSetting() {
        a r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ MmHardwareFunctionConfigSetting copy$default(MmHardwareFunctionConfigSetting r0, a r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.d1204;
    L6:
        return r0.copy(r1);
    }

    public final a component1() {
        return this.d1204;
    }

    public final MmHardwareFunctionConfigSetting copy(a r2) {
        Intrinsics.checkNotNullParameter(r2, "d1204");
        return new MmHardwareFunctionConfigSetting(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MmHardwareFunctionConfigSetting) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.d1204, ((MmHardwareFunctionConfigSetting) r4).d1204) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.d1204.hashCode();
    }

    public String toString() {
        return "MmHardwareFunctionConfigSetting(d1204=" + this.d1204 + ')';
    }

    public final a getD1204() {
        return this.d1204;
    }

    public MmHardwareFunctionConfigSetting(a r2) {
        Intrinsics.checkNotNullParameter(r2, "d1204");
        this.d1204 = r2;
    }

    public /* synthetic */ MmHardwareFunctionConfigSetting(a r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new a(0);
    L5:
        this(r1);
    }
}
