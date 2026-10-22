package ls9;

import com.larus.bmhome.taskskill.service.IPcDevicePanelService;
import com.larus.project.create.CreateProjectPanelFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i implements IPcDevicePanelService.b {
    public final /* synthetic */ CreateProjectPanelFragment a;

    public final void a() {
        CreateProjectPanelFragment r0 = this.a;
        int r1 = CreateProjectPanelFragment.m;
        r0.aa0("cancel");
    }

    public final void b() {
        CreateProjectPanelFragment r0 = this.a;
        r0.f = null;
        r0.g = null;
        r0.Z90();
        this.a.aa0("cancel");
    }

    public i(CreateProjectPanelFragment r1) {
        this.a = r1;
    }

    public final void c(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "folderName");
        Intrinsics.checkNotNullParameter(r5, "folderPath");
        FLogger.a.i("CreateProjectPanel", "onFolderSelected nameLength=" + r4.length());
        CreateProjectPanelFragment r0 = this.a;
        r0.f = r4;
        r0.g = r5;
        r0.Z90();
        this.a.aa0("success");
    }
}
