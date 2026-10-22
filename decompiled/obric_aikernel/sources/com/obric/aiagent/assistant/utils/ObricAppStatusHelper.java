package com.obric.aiagent.assistant.utils;

import android.content.Context;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ObricAppStatusHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricAppStatusHelper f4360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f4361b = null;

    static {
        f4360a = new ObricAppStatusHelper();
        f4361b = LazyKt.lazy(ObricAppStatusHelper$statusUtility$2.INSTANCE);
    }

    private ObricAppStatusHelper() {
    }

    public final ObricAppStatus a(Context r10) {
        if (r10 == null) goto L4;
        AppEnableStatus r11 = b().a(r10, IAIKernelManager.PACKAGE_NAME_ASSIST);
        if (r11 != AppEnableStatus.NoInstalled) goto L10;
        return ObricAppStatus.NoInstalledError;
    L10:
        if (r11 != AppEnableStatus.AppDisabled) goto L14;
        return ObricAppStatus.AppDisabledError;
    L14:
        if (Intrinsics.areEqual(b().b(r10), IAIKernelManager.PACKAGE_NAME_ASSIST) == true) goto L18;
        return ObricAppStatus.NotRoleAssistant;
    L18:
        return ObricAppStatus.Success;
    L4:
        return ObricAppStatus.Unknown;
    }

    public final a b() {
        return (a) f4361b.getValue();
    }
}
