package com.larus.bmhome.chat.component.title;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.IMConnectState;
import com.larus.ui.arch.component.internal.attach.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k0 implements Observer {
    public final /* synthetic */ ChatTitleComponent a;
    public final /* synthetic */ LiveData b;

    public /* synthetic */ k0(ChatTitleComponent r1, LiveData r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r10) {
        final ChatTitleComponent r0 = this.a;
        LiveData r1 = this.b;
        int r2 = ChatTitleComponent.P1;
        Intrinsics.checkNotNullParameter((IMConnectState) r10, "it");
        com.larus.bmhome.auth.c1 r11 = (com.larus.bmhome.auth.c1) AuthModelDelegate.b.B().getValue();
        if (r11 == null) goto L5;
        com.larus.bmhome.auth.j0 r12 = (com.larus.bmhome.auth.j0) r11.d;
    L6:
        if (r12 == null) goto L40;
        Job r13 = r0.X;
        if (r13 == null) goto L11;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L11:
        IMConnectState r14 = (IMConnectState) r1.getValue();
        if (r14 != null) goto L14;
        int r15 = -1;
    L15:
        if (r15 != 1) goto L17;
        com.larus.platform.api.g0 r16 = r0.n;
        if (r16 == null) goto L33;
        r16.setStatus("");
    L33:
        r0.B4();
        r0.i5();
        FLogger.a.i(r0.d4(), "IMConnectState.CONNECTED, from IInstantMessenger");
        return;
    L17:
        if (r15 == 2) goto L26;
        if (r15 != 3) goto L41;
        Runnable r17 = new b1(r0);
        if (r0.V0 == false) goto L24;
        r0.V0 = false;
        r0.X = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new ChatTitleComponent$initConnectStateObserver$1$2$1(r0, r17, null), 3, null);
        return;
    L24:
        r17.run();
        return;
    L41:
        return;
    L26:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L37;
        FLogger.a.i(r0.d4(), "IMConnectState.DISCONNECTED, from IInstantMessenger");
        com.larus.platform.api.g0 r18 = r0.n;
        if (r18 == null) goto L38;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        r18.setStatus(a.b(r0, r0).getString(2131906741));
        return;
    L38:
        return;
    L37:
        return;
    L14:
        r15 = ChatTitleComponent$a.a[r14.ordinal()];
        goto L15
    L40:
        return;
    L5:
        r12 = null;
        goto L6
    }
}
