package com.larus.project;

import com.larus.bmhome.taskskill.service.IProjectCreatePanelService;
import com.larus.platform.model.SlashMentionConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t implements IProjectCreatePanelService.a {
    public final /* synthetic */ TaskProjectFragment a;

    public final void a(boolean r1) {
    }

    public final void c() {
    }

    public final void d(boolean r1) {
    }

    public t(TaskProjectFragment r1) {
        this.a = r1;
    }

    public final void b(com.larus.bmhome.taskskill.service.a r11) {
        Intrinsics.checkNotNullParameter(r11, SlashMentionConfig.SLASH_CONTENT_PROJECT);
        TaskProjectFragment r0 = this.a;
        String r2 = r11.a;
        String r3 = r11.b;
        String r1 = r11.f;
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        i r9 = new i(r2, r3, r4, r11.e, r11.f, r11.c, r11.d);
        int r12 = TaskProjectFragment.w;
        TaskProjectFragment.W90(r0, r0.ia0(r9));
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}
