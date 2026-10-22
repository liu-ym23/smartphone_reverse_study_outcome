package com.obric.memorydata.memory;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/InAppAutoMemoryGate;", "", "<init>", "()V", "CONFIG_KEY", "", "isCloudEnabled", "", "isUserEligible", "isFrameworkSupported", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10115a = null;

    static {
        f10115a = new e();
    }

    private e() {
    }

    public final boolean a() {
        JSONObject r2 = SettingsManager.INSTANCE.getJson("obric_memd_in_app_settings");
        if (r2 != null) goto L5;
        return true;
    L5:
        JSONObject r0 = r2.optJSONObject("obric_memd_in_app_settings");
        if (r0 == null) goto L10;
        r2 = r0;
    L10:
        return !Intrinsics.areEqual(r2.opt("auto_memory_enabled"), false);
    }

    public final boolean b() {
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L5;
    L7:
        return false;
    L5:
        if (UserSettings.INSTANCE.isEnterpriseAccount() == true) goto L7;
        return true;
    }

    public final boolean c() {
        return com.obric.aiagent.product.a.a.b();
    }
}
