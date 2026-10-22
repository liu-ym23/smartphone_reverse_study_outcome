package com.larus.bmhome.chat.component.bottom.core.inputtext.project;

import com.larus.bmhome.taskskill.service.IProjectCreatePanelService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements IProjectCreatePanelService.a {
    public final /* synthetic */ ProjectPanelController a;

    public final void a(boolean r1) {
    }

    public final void c() {
    }

    public final void d(boolean r1) {
    }

    public e(ProjectPanelController r1) {
        this.a = r1;
    }

    public final void b(com.larus.bmhome.taskskill.service.a r12) {
        Intrinsics.checkNotNullParameter(r12, "project");
        if (this.a.c() == true) goto L5;
        return;
    L5:
        be8.a r0 = (be8.a) this.a.d.invoke();
        if (r0 == null) goto L15;
        String r2 = r12.a;
        String r3 = r12.b;
        String r1 = r12.f;
        if (r1 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        r0.UF(new be8.f(r2, r3, r4, r12.e, r12.f, r12.c, r12.d, 128), null);
        goto L15
    L10:
        if (r1.length() == 0) goto L13;
        r4 = false;
    L15:
        this.a.g.invoke();
    }
}
