package com.ss.android.lark.officesdk.api;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/api/OfficeSDKDriveErrorCodes;", "", "<init>", "()V", "HOST_CAPABILITY_NOT_CONFIGURED", "", "LOGIN_FAILED", "LOGOUT_FAILED", "TIMEOUT", "HOST_USER_CHANGED", "HOST_USER_OFFLINE", "HOST_USER_SESSION_DISPOSED", "NOT_SUPPORTED", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKDriveErrorCodes {
    public static final String HOST_CAPABILITY_NOT_CONFIGURED = "hostCapabilityNotConfigured";
    public static final String HOST_USER_CHANGED = "hostUserChanged";
    public static final String HOST_USER_OFFLINE = "hostUserOffline";
    public static final String HOST_USER_SESSION_DISPOSED = "hostUserSessionDisposed";
    public static final OfficeSDKDriveErrorCodes INSTANCE = null;
    public static final String LOGIN_FAILED = "loginFailed";
    public static final String LOGOUT_FAILED = "logoutFailed";
    public static final String NOT_SUPPORTED = "notSupported";
    public static final String TIMEOUT = "timeout";

    static {
        INSTANCE = new OfficeSDKDriveErrorCodes();
    }

    private OfficeSDKDriveErrorCodes() {
    }
}
