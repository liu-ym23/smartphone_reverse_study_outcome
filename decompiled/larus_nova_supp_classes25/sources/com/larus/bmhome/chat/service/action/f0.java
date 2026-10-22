package com.larus.bmhome.chat.service.action;

import android.view.View;
import com.larus.bmhome.taskskill.service.IProjectCreatePanelService;
import com.larus.im.internal.jni.bean.OmniMoveConversationToProjectRequest;
import kotlin.jvm.internal.Intrinsics;
import tx9.p3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f0 implements IProjectCreatePanelService.a {
    public final /* synthetic */ com.larus.bmhome.chat.api.i a;
    public final /* synthetic */ z b;
    public final /* synthetic */ View c;
    public final /* synthetic */ wh8.a d;
    public final /* synthetic */ String e;

    public final void c() {
    }

    public final void d(boolean r1) {
    }

    public final void a(boolean r8) {
        com.larus.bmhome.chat.api.i r0 = this.a;
        p3.g(r0.c, null, r8, "cancel", r0.b, 2);
    }

    public final void b(com.larus.bmhome.taskskill.service.a r14) {
        Intrinsics.checkNotNullParameter(r14, "project");
        String r1 = this.a.c;
        String r0 = r14.f;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        p3.g(r1, null, true ^ r2, "success", this.a.b, 2);
        z r9 = this.b;
        View r12 = this.c;
        wh8.a r10 = this.d;
        String r11 = this.e;
        String r8 = r14.a;
        r9.getClass();
        com.larus.im.service.v.a.getClass();
        com.larus.im.service.v.a.a().c(new OmniMoveConversationToProjectRequest(r11, r8), new e0(r8, r9, r10, r11, r12));
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public f0(com.larus.bmhome.chat.api.i r1, z r2, View r3, wh8.a r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
