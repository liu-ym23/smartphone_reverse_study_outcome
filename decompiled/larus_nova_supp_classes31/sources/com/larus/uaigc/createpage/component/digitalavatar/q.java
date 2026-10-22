package com.larus.uaigc.createpage.component.digitalavatar;

import com.larus.common_ui.dialog.p0;
import tx9.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q implements p0 {
    public final /* synthetic */ DigitalAvatarComponent a;
    public final /* synthetic */ String b;

    public final void confirm() {
        r0.f("replica", "confirm_delete_replica");
        DigitalAvatarComponent.m3(this.a, this.b);
    }

    public q(DigitalAvatarComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
