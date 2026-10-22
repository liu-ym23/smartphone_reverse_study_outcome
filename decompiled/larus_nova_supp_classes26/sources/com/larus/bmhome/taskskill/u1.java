package com.larus.bmhome.taskskill;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u1 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ SkillComponent a;
    public final /* synthetic */ a b;

    public final void confirm() {
        k2.b("confirm");
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        r0.getClass();
        String r2 = AccountService.a.getSecUserId();
        if ((!StringsKt.isBlank(r2)) == true) goto L6;
        r2 = null;
    L6:
        if (r2 == null) goto L9;
        ((Keva) r0.Q1.getValue()).storeBoolean("presented_".concat(r2), true);
    L9:
        this.a.h3(RemoteControlAuthorizationMode.FULL_ACCESS, this.b);
    }

    public u1(SkillComponent r1, a r2) {
        this.a = r1;
        this.b = r2;
    }
}
