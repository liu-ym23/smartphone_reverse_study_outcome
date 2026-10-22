package ls9;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.taskskill.service.IProjectCreatePanelService;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.internal.jni.bean.OmniProjectFolderInput;
import com.larus.project.create.ProjectCreatePanelServiceImpl;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k implements IIMCallback<OmniProject> {
    public final /* synthetic */ ProjectCreatePanelServiceImpl a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ IProjectCreatePanelService.a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ List<OmniProjectFolderInput> e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r8) {
        Intrinsics.checkNotNullParameter(r8, "error");
        ProjectCreatePanelServiceImpl r1 = this.a;
        Fragment r2 = this.b;
        IProjectCreatePanelService.a r3 = this.c;
        String r4 = "code=" + r8.getCode() + " msg=" + r8.getTips();
        String r5 = this.d;
        if (this.e == null) goto L5;
        boolean r6 = true;
    L6:
        ProjectCreatePanelServiceImpl.d(r1, r2, r3, r4, r5, r6);
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final void onSuccess(Object r13) {
        OmniProject r14 = (OmniProject) r13;
        String r1 = null;
        if (r14 == null) goto L9;
        String r2 = r14.projectId;
        if (r2 == null) goto L9;
        if ((!StringsKt.isBlank(r2)) == false) goto L9;
        String r5 = r2;
    L10:
        boolean r3 = false;
        if (r5 != null) goto L17;
        ProjectCreatePanelServiceImpl r6 = this.a;
        Fragment r7 = this.b;
        IProjectCreatePanelService.a r8 = this.c;
        String r10 = this.d;
        if (this.e == null) goto L15;
        boolean r11 = true;
    L16:
        ProjectCreatePanelServiceImpl.d(r6, r7, r8, "empty projectId", r10, r11);
        return;
    L15:
        r11 = false;
        goto L16
    L17:
        FLogger.a.i("ProjectCreatePanelService", "createProject success projectId=".concat(r5));
        ProjectCreatePanelServiceImpl r4 = this.a;
        String r9 = this.d;
        if (this.e == null) goto L20;
        r3 = true;
    L20:
        int r12 = ProjectCreatePanelServiceImpl.a;
        r4.getClass();
        ProjectCreatePanelServiceImpl.e(r9, r3, "success");
        IProjectCreatePanelService.a r15 = this.c;
        String r16 = r14.name;
        if (r16 != null) goto L23;
    L28:
        String r17 = this.f;
    L29:
        r15.b(new com.larus.bmhome.taskskill.service.a(r5, r17, this.g, this.h, this.i, this.j));
        return;
    L23:
        if ((true ^ StringsKt.isBlank(r16)) == false) goto L25;
        r1 = r16;
    L25:
        if (r1 == null) goto L28;
        r17 = r1;
    L9:
        r5 = null;
        goto L10
    }

    public k(ProjectCreatePanelServiceImpl r1, Fragment r2, IProjectCreatePanelService.a r3, String r4, List<OmniProjectFolderInput> r5, String r6, String r7, String r8, String r9, String r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
