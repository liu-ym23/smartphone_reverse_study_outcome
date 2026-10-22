package ga8;

import com.bytedance.keva.Keva;
import com.larus.avlink.simulInterpret.settings.TimbreCloneFragment;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ia8.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements p0 {
    public final /* synthetic */ TimbreCloneFragment a;
    public final /* synthetic */ boolean b;

    public final void confirm() {
        TimbreCloneFragment r0 = this.a;
        boolean r1 = this.b;
        int r2 = TimbreCloneFragment.i;
        r0.getClass();
        if (r1 == false) goto L5;
        Keva r3 = DoraConfig.a;
        Intrinsics.checkNotNullParameter("clone", "speaker");
        DoraConfig.a.storeString("key_timbre_clone", "clone");
    L6:
        o.a = false;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L12;
        SessionService r5 = r4.d();
        if (r5 == null) goto L13;
        r5.o(5, 8);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        Keva r6 = DoraConfig.a;
        Intrinsics.checkNotNullParameter("", "speaker");
        DoraConfig.a.storeString("key_timbre_clone", "");
        goto L6
    }

    public f(TimbreCloneFragment r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
