package com.bytedance.awemeopen.infra.plugs.settings.update;

import com.bytedance.awemeopen.infra.base.task.AoPool;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ2\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/settings/update/MainSettingsProviderImpl;", "", "()V", "clearMockSettings", "", "bdpAppId", "", "key", "isSettingMocked", "", "setMockSettings", "settings", "Lorg/json/JSONObject;", "updateSettings", "params", "", "force", "from", "ao_plugin_settings_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MainSettingsProviderImpl {
    public static final MainSettingsProviderImpl INSTANCE = null;

    static {
        INSTANCE = new MainSettingsProviderImpl();
    }

    private MainSettingsProviderImpl() {
    }

    public final void clearMockSettings(String r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "bdpAppId");
        final BdpMainSettingsUpdater r4 = BdpMainSettingsUpdater.l.a(r2);
        AoPool.a(new BdpMainSettingsUpdater$clearMockSettings$1(r3, r4));
    }

    public final boolean isSettingMocked(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "bdpAppId");
        Intrinsics.checkNotNullParameter(r4, "key");
        BdpMainSettingsUpdater r5 = BdpMainSettingsUpdater.l.a(r3);
        Intrinsics.checkNotNullParameter(r4, "key");
        return r5.f().containsKey(r4);
    }

    public final void setMockSettings(String r3, final String r4, final JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, "bdpAppId");
        Intrinsics.checkNotNullParameter(r4, "key");
        final BdpMainSettingsUpdater r6 = BdpMainSettingsUpdater.l.a(r3);
        Intrinsics.checkNotNullParameter(r4, "key");
        AoPool.a(new BdpMainSettingsUpdater$mockSettings$1(r5, r6, r4));
    }

    public final void updateSettings(String r3, final Map<String, String> r4, final boolean r5, final String r6) {
        Intrinsics.checkNotNullParameter(r3, "bdpAppId");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r6, "from");
        final BdpMainSettingsUpdater r7 = BdpMainSettingsUpdater.l.a(r3);
        Intrinsics.checkNotNullParameter(r4, "queryParams");
        Intrinsics.checkNotNullParameter(r6, "from");
        AoPool.a(new BdpMainSettingsUpdater$updateSettings$1(r7, r5, r6, r4));
    }
}
