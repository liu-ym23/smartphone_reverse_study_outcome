package com.ss.android.lark.chat.message.menu.v2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@AppConfig(key = "message_menu_list_normal")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003JI\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/NormalMessageActionListConfig;", BuildConfig.FLAVOR, "mobileConfig", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/message/menu/v2/ActionGroup;", "mobilePartialConfig", BuildConfig.FLAVOR, "pcFloatingConfig", "Lcom/ss/android/lark/chat/message/menu/v2/PCActionGroup;", "pcRightConfig", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getMobileConfig", "()Ljava/util/List;", "getMobilePartialConfig", "getPcFloatingConfig", "getPcRightConfig", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NormalMessageActionListConfig {

    @SerializedName("mobile_config")
    private final List<ActionGroup> mobileConfig;

    @SerializedName("mobile_partial_config")
    private final List<String> mobilePartialConfig;

    @SerializedName("pc_floating_config")
    private final List<PCActionGroup> pcFloatingConfig;

    @SerializedName("pc_right_config")
    private final List<PCActionGroup> pcRightConfig;

    public NormalMessageActionListConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NormalMessageActionListConfig copy$default(NormalMessageActionListConfig r0, List r1, List r2, List r3, List r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.mobileConfig;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.mobilePartialConfig;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.pcFloatingConfig;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.pcRightConfig;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final List<ActionGroup> component1() {
        return this.mobileConfig;
    }

    public final List<String> component2() {
        return this.mobilePartialConfig;
    }

    public final List<PCActionGroup> component3() {
        return this.pcFloatingConfig;
    }

    public final List<PCActionGroup> component4() {
        return this.pcRightConfig;
    }

    public final NormalMessageActionListConfig copy(List<ActionGroup> r2, List<String> r3, List<PCActionGroup> r4, List<PCActionGroup> r5) {
        Intrinsics.checkNotNullParameter(r2, "mobileConfig");
        Intrinsics.checkNotNullParameter(r3, "mobilePartialConfig");
        Intrinsics.checkNotNullParameter(r4, "pcFloatingConfig");
        Intrinsics.checkNotNullParameter(r5, "pcRightConfig");
        return new NormalMessageActionListConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NormalMessageActionListConfig) == true) goto L8;
        return false;
    L8:
        NormalMessageActionListConfig r6 = (NormalMessageActionListConfig) r5;
        if (Intrinsics.areEqual(this.mobileConfig, r6.mobileConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mobilePartialConfig, r6.mobilePartialConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pcFloatingConfig, r6.pcFloatingConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pcRightConfig, r6.pcRightConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.mobileConfig.hashCode() * 31) + this.mobilePartialConfig.hashCode()) * 31) + this.pcFloatingConfig.hashCode()) * 31) + this.pcRightConfig.hashCode();
    }

    public String toString() {
        return "NormalMessageActionListConfig(mobileConfig=" + this.mobileConfig + ", mobilePartialConfig=" + this.mobilePartialConfig + ", pcFloatingConfig=" + this.pcFloatingConfig + ", pcRightConfig=" + this.pcRightConfig + ')';
    }

    public final List<ActionGroup> getMobileConfig() {
        return this.mobileConfig;
    }

    public final List<String> getMobilePartialConfig() {
        return this.mobilePartialConfig;
    }

    public final List<PCActionGroup> getPcFloatingConfig() {
        return this.pcFloatingConfig;
    }

    public final List<PCActionGroup> getPcRightConfig() {
        return this.pcRightConfig;
    }

    public NormalMessageActionListConfig(List<ActionGroup> r2, List<String> r3, List<PCActionGroup> r4, List<PCActionGroup> r5) {
        Intrinsics.checkNotNullParameter(r2, "mobileConfig");
        Intrinsics.checkNotNullParameter(r3, "mobilePartialConfig");
        Intrinsics.checkNotNullParameter(r4, "pcFloatingConfig");
        Intrinsics.checkNotNullParameter(r5, "pcRightConfig");
        this.mobileConfig = r2;
        this.mobilePartialConfig = r3;
        this.pcFloatingConfig = r4;
        this.pcRightConfig = r5;
    }

    public /* synthetic */ NormalMessageActionListConfig(List r1, List r2, List r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = new ArrayList();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = new ArrayList();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = new ArrayList();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = new ArrayList();
    L14:
        this(r1, r2, r3, r4);
    }
}
