package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "lark_security_deep_clean_config")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/entity/LogoutDeepEraserRemoteConfig;", "Ljava/io/Serializable;", "<init>", "()V", "logoutEraserConfig", "Lcom/ss/android/lark/passport/signinsdk_api/entity/LogoutDeepEraserWhitelistItem;", "getLogoutEraserConfig", "()Lcom/ss/android/lark/passport/signinsdk_api/entity/LogoutDeepEraserWhitelistItem;", "setLogoutEraserConfig", "(Lcom/ss/android/lark/passport/signinsdk_api/entity/LogoutDeepEraserWhitelistItem;)V", "deepEraserConfig", "getDeepEraserConfig", "setDeepEraserConfig", "disableEncryptLog", "", "getDisableEncryptLog", "()Z", "setDisableEncryptLog", "(Z)V", "disableCacheSizeReport", "getDisableCacheSizeReport", "setDisableCacheSizeReport", "disableExternalDir", "getDisableExternalDir", "setDisableExternalDir", "toString", "", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class LogoutDeepEraserRemoteConfig implements Serializable {

    @SerializedName("deep_eraser_config")
    private LogoutDeepEraserWhitelistItem deepEraserConfig;

    @SerializedName("disable_cache_size_report")
    private boolean disableCacheSizeReport;

    @SerializedName("disable_encrypt_log")
    private boolean disableEncryptLog;

    @SerializedName("disable_external_dir")
    private boolean disableExternalDir;

    @SerializedName("logout_config")
    private LogoutDeepEraserWhitelistItem logoutEraserConfig;

    public LogoutDeepEraserRemoteConfig() {
    }

    public String toString() {
        return "LogoutDeepEraserRemoteConfig(logoutEraserConfig=" + this.logoutEraserConfig + ", deepEraserConfig=" + this.deepEraserConfig + ", disableEncryptLog=" + this.disableEncryptLog + ", disableCacheSizeReport=" + this.disableCacheSizeReport + ')';
    }

    public final LogoutDeepEraserWhitelistItem getDeepEraserConfig() {
        return this.deepEraserConfig;
    }

    public final boolean getDisableCacheSizeReport() {
        return this.disableCacheSizeReport;
    }

    public final boolean getDisableEncryptLog() {
        return this.disableEncryptLog;
    }

    public final boolean getDisableExternalDir() {
        return this.disableExternalDir;
    }

    public final LogoutDeepEraserWhitelistItem getLogoutEraserConfig() {
        return this.logoutEraserConfig;
    }

    public final void setDeepEraserConfig(LogoutDeepEraserWhitelistItem r1) {
        this.deepEraserConfig = r1;
    }

    public final void setDisableCacheSizeReport(boolean r1) {
        this.disableCacheSizeReport = r1;
    }

    public final void setDisableEncryptLog(boolean r1) {
        this.disableEncryptLog = r1;
    }

    public final void setDisableExternalDir(boolean r1) {
        this.disableExternalDir = r1;
    }

    public final void setLogoutEraserConfig(LogoutDeepEraserWhitelistItem r1) {
        this.logoutEraserConfig = r1;
    }
}
