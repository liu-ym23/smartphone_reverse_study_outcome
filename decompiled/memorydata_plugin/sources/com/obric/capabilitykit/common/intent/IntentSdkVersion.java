package com.obric.capabilitykit.common.intent;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentSdkVersion;", "", "()V", "CURRENT_SDK_VERSION", "", "DOWNLOAD_APP_INTENT_V2_MIN_VERSION", "META_DATA_KEY", "", "UNKNOWN_VERSION", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntentSdkVersion {
    public static final int CURRENT_SDK_VERSION = 2;
    public static final int DOWNLOAD_APP_INTENT_V2_MIN_VERSION = 2;
    public static final IntentSdkVersion INSTANCE = null;
    public static final String META_DATA_KEY = "obric.intent.sdk.version";
    public static final int UNKNOWN_VERSION = 0;

    static {
        INSTANCE = new IntentSdkVersion();
    }

    private IntentSdkVersion() {
    }
}
