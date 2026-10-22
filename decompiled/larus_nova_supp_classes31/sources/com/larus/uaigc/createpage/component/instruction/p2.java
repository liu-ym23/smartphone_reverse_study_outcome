package com.larus.uaigc.createpage.component.instruction;

import android.content.Context;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g3;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p2 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ DigitalAvatarInstructionBizAdapter b;

    public final void confirm() {
        tx9.r0.f("replica", "confirm_delete_replica");
        if (this.a != 0) goto L5;
        t19.s r0 = t19.s.a;
        Context r1 = DigitalAvatarInstructionBizAdapter.C(this.b);
        r0.getClass();
        t19.s.s(r1, 2131908831);
        return;
    L5:
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L12;
        r2.H();
        VideoPortraitConfig r3 = com.larus.home.impl.sdk.l1.a.a();
        if (r3 == null) goto L12;
        boolean r4 = true;
        if (r3.getEnableVideoAvatar() != true) goto L12;
    L13:
        if (r4 == false) goto L15;
        this.b.I();
        return;
    L15:
        final DigitalAvatarInstructionBizAdapter r5 = this.b;
        Function0 r6 = new o2(r5);
        r5.getClass();
        com.larus.platform.service.k2 r7 = com.larus.platform.service.k2.a;
        g3.a.a(((vp8.g) r5).g, null, true, null, false, new i2(r6), 26);
        return;
    L12:
        r4 = false;
        goto L13
    }

    public p2(int r1, DigitalAvatarInstructionBizAdapter r2) {
        this.a = r1;
        this.b = r2;
    }
}
