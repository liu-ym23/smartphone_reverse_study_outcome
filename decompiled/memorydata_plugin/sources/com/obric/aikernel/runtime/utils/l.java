package com.obric.aikernel.runtime.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\u001f\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0007J\b\u0010\u0019\u001a\u00020\u0006H\u0007J\b\u0010\u001a\u001a\u00020\u0006H\u0007J\b\u0010\u001b\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/obric/aikernel/runtime/utils/SecurityUtils;", "", "()V", "ASSISTANT_API_BEGIN_VERSION", "", "ASSISTANT_KEY_MANAGER", "", "ASSISTANT_ROT_PROVISION_MANAGER", "HOST_TYPE_APP", "getHOST_TYPE_APP", "()Ljava/lang/String;", "HOST_TYPE_PLUGIN", "getHOST_TYPE_PLUGIN", "OBRIC_FILE_ENCRYPT", "OBRIC_KEY_MANAGER", "OBRIC_ROT_PROVISION_MANAGER", "cachedUseAssistantApi", "", "Ljava/lang/Boolean;", "getObricApiVersion", "invokeVersionMethod", "className", "methodLabel", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "resolveFileEncryptClassName", "resolveKeyManagerClassName", "resolveRotProvisionManagerClassName", "useAssistantApi", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f6234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f6235b = null;
    private static final String c = null;

    static {
        f6234a = new l();
        f6235b = "App";
        c = com.obric.memorydata.BuildConfig.BUILD_PRODUCT_TYPE;
    }

    private l() {
    }

    public final String a() {
        return f6235b;
    }

    public final String b() {
        return c;
    }
}
