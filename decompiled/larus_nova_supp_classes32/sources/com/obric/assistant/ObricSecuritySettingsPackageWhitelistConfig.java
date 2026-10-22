package com.obric.assistant;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0010\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/ObricSecuritySettingsPackageWhitelistConfig;", NameKeys.UnloadStrategy_No_Strategy, "appListSignatures", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/NotificationSignatureWhiteItem;", "globalWhiteListSignatureCheckEnabled", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getAppListSignatures", "()Ljava/util/List;", "getGlobalWhiteListSignatureCheckEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/obric/assistant/ObricSecuritySettingsPackageWhitelistConfig;", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSecuritySettingsPackageWhitelistConfig {

    @SerializedName("app_list_signatures")
    private final List<NotificationSignatureWhiteItem> appListSignatures;

    @SerializedName("global_white_list_signature_check_enabled")
    @JsonAdapter(ObricBoolean01Adapter.class)
    private final Boolean globalWhiteListSignatureCheckEnabled;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricSecuritySettingsPackageWhitelistConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricSecuritySettingsPackageWhitelistConfig copy$default(ObricSecuritySettingsPackageWhitelistConfig r0, List r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.appListSignatures;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.globalWhiteListSignatureCheckEnabled;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<NotificationSignatureWhiteItem> component1() {
        return this.appListSignatures;
    }

    public final Boolean component2() {
        return this.globalWhiteListSignatureCheckEnabled;
    }

    public final ObricSecuritySettingsPackageWhitelistConfig copy(List<NotificationSignatureWhiteItem> r2, Boolean r3) {
        return new ObricSecuritySettingsPackageWhitelistConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricSecuritySettingsPackageWhitelistConfig) == true) goto L8;
        return false;
    L8:
        ObricSecuritySettingsPackageWhitelistConfig r6 = (ObricSecuritySettingsPackageWhitelistConfig) r5;
        if (Intrinsics.areEqual(this.appListSignatures, r6.appListSignatures) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.globalWhiteListSignatureCheckEnabled, r6.globalWhiteListSignatureCheckEnabled) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<NotificationSignatureWhiteItem> r0 = this.appListSignatures;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.globalWhiteListSignatureCheckEnabled;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricSecuritySettingsPackageWhitelistConfig(appListSignatures=" + this.appListSignatures + ", globalWhiteListSignatureCheckEnabled=" + this.globalWhiteListSignatureCheckEnabled + ')';
    }

    public final List<NotificationSignatureWhiteItem> getAppListSignatures() {
        return this.appListSignatures;
    }

    public final Boolean getGlobalWhiteListSignatureCheckEnabled() {
        return this.globalWhiteListSignatureCheckEnabled;
    }

    public ObricSecuritySettingsPackageWhitelistConfig(List<NotificationSignatureWhiteItem> r1, Boolean r2) {
        this.appListSignatures = r1;
        this.globalWhiteListSignatureCheckEnabled = r2;
    }

    public /* synthetic */ ObricSecuritySettingsPackageWhitelistConfig(List r1, Boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = Boolean.FALSE;
    L8:
        this(r1, r2);
    }
}
