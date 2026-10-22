package com.larus.uaigc.createpage.component.digitalavatar;

import android.content.Context;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common_ui.dialog.p0;
import com.larus.home.impl.sdk.l1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g3;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.k2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import tx9.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t implements p0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ DigitalAvatarComponent b;

    public final void confirm() {
        r0.f("replica", "confirm_delete_replica");
        if (this.a != 0) goto L5;
        t19.s r0 = t19.s.a;
        Context r1 = this.b.getContext();
        r0.getClass();
        t19.s.s(r1, 2131908831);
        return;
    L5:
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L12;
        r2.H();
        VideoPortraitConfig r3 = l1.a.a();
        if (r3 == null) goto L12;
        boolean r4 = true;
        if (r3.getEnableVideoAvatar() != true) goto L12;
    L13:
        if (r4 == false) goto L15;
        DigitalAvatarComponent r5 = this.b;
        int r6 = DigitalAvatarComponent.C;
        r5.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r5), null, null, new DigitalAvatarComponent$regenerateVideoAvatar$1(r5, null), 3, null);
        return;
    L15:
        final DigitalAvatarComponent r7 = this.b;
        Function0 r8 = new s(r7);
        int r9 = DigitalAvatarComponent.C;
        r7.getClass();
        k2 r10 = k2.a;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        g3.a.a(com.larus.ui.arch.component.internal.attach.a.b(r7, r7), null, false, null, false, new c(r8), 30);
        return;
    L12:
        r4 = false;
        goto L13
    }

    public t(int r1, DigitalAvatarComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
