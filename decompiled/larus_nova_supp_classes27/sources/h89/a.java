package h89;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.browser.plugin.o;
import com.larus.drive.sdk.impl.plugins.actionbar.DriveActionBarAdaptationPlugin;
import com.larus.drive.sdk.impl.plugins.more.DriveBizMorePanelConfigPlugin;
import com.larus.drive.sdk.impl.plugins.share.DriveSharePermissionPlugin;
import com.larus.drive.sdk.impl.plugins.titlebar.AiFilePreviewTitleMenuPlugin;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements o {

    /* JADX INFO: renamed from: h89.a$a, reason: collision with other inner class name */
    public static final class C0128a {
    }

    static {
    }

    public a() {
    }

    public final n a(PluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        FLogger.a.i("DrivePluginProvider", "getPluginList: create drive host plugins");
        return new n(new n.a[]{n.h(new DriveActionBarAdaptationPlugin(), true), n.h(new AiFilePreviewTitleMenuPlugin(), true), n.h(new DriveBizMorePanelConfigPlugin(), true), n.h(new DriveSharePermissionPlugin(), z2.a.f4())});
    }
}
