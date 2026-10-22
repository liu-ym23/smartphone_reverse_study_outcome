package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.c;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final String a;
    public final StateFlowImpl b;
    public final b1 c;
    public final C0042a d;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.a$a, reason: collision with other inner class name */
    public static final class C0042a implements NetworkLevelListener {
        public final /* synthetic */ a a;

        public C0042a(a r1) {
            this.a = r1;
        }

        public final void a(NetworkLevelListener.NetworkLevel r4) {
            boolean r5 = !c.b(r4);
            if (((Boolean) this.a.b.getValue()).booleanValue() == r5) goto L6;
            lvb.a.e(this.a.a, "onNetworkLevelChanged: isAvailable=" + r5);
            this.a.b.setValue(Boolean.valueOf(r5));
            return;
        }
    }

    public final void a() {
        Object r0 = LarkNetworkLevelManager.d;
        NetworkLevelListener.NetworkLevel r1 = LarkNetworkLevelManager.a.a().getCurNetWorkLevel();
        Intrinsics.checkNotNull(r1);
        boolean r2 = !c.b(r1);
        this.b.setValue(Boolean.valueOf(r2));
        lvb.a.e(this.a, "start: isAvailable=" + r2);
        LarkNetworkLevelManager.a.a().w0(this.d);
    }

    public a() {
        this.a = "MmNetworkMonitor";
        StateFlowImpl r0 = j1.a(Boolean.FALSE);
        this.b = r0;
        this.c = e.b(r0);
        this.d = new C0042a(this);
    }
}
