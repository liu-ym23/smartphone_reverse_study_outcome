package com.larus.bmhome.taskskill;

import android.view.ViewGroup;
import com.larus.platform.api.g0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SkillComponent$k implements com.larus.bmhome.taskskill.view.c {
    public final /* synthetic */ SkillComponent a;

    @Override // com.larus.bmhome.taskskill.view.c
    public final String V7() {
        return this.a.H1;
    }

    @Override // com.larus.bmhome.taskskill.view.c
    public final String a() {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        return r0.h4();
    }

    @Override // com.larus.bmhome.taskskill.view.c
    public final bs8.h b() {
        int r0 = h.a;
        SkillComponent r1 = this.a;
        Regex r2 = SkillComponent.F2;
        com.larus.bmhome.chat.component.cvs.y r3 = r1.d4();
        if (r3 == null) goto L5;
        wc9.e r4 = r3.h();
    L7:
        return h.a(r4);
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.larus.bmhome.taskskill.view.c
    public final void d() {
        Intrinsics.checkNotNullParameter("PcConnectionStatusManager.doWhenDeviceConnected", "caller");
        SkillComponent r0 = this.a;
        Regex r2 = SkillComponent.F2;
        r0.G3("PcConnectionStatusManager.doWhenDeviceConnected");
    }

    @Override // com.larus.bmhome.taskskill.view.c
    public final void g() {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        r0.l4();
    }

    @Override // com.larus.bmhome.taskskill.view.c
    public final ViewGroup getContainerView() {
        return this.a.s.a();
    }

    public SkillComponent$k(SkillComponent r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.taskskill.view.c
    public final void e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "caller");
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        r0.m3(r3);
    }

    @Override // com.larus.bmhome.taskskill.view.c
    public final void f(String r9) {
        Intrinsics.checkNotNullParameter(r9, "deviceId");
        SkillComponent r0 = this.a;
        bs8.a r1 = r0.v1;
        if (r1 == null) goto L5;
        bs8.a r10 = bs8.a.a(r1, null, null, r9, null, null, 111);
    L6:
        r0.v1 = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.larus.bmhome.taskskill.view.c
    public final void c(CharSequence r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "title");
        SkillComponent r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "title");
        ry8.b r0 = (ry8.b) r1.C.getValue();
        if (r0 == null) goto L8;
        g0 r2 = r0.C5();
        if (r2 == null) goto L9;
        r2.Na(r4, r3);
        return;
    L9:
        return;
    }
}
