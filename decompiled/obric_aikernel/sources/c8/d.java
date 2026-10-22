package c8;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends com.obric.aikernel.res.metadata.data.b {
    public d(String r10, PackageResourceManager.PresmConfig r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r12, "version");
        super(r10, r12, r11);
    }

    public /* synthetic */ d(String r10, PackageResourceManager.PresmConfig r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = NetConst.NOT_ENCRYPT_VERISON_CODE;
    L5:
        this(r10, r11, r12);
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean H() {
        return g0();
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean Z() {
        return true;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean a0() {
        return true;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean b(boolean r10) {
        return true;
    }

    public boolean g0() {
        c r10 = q().getDynamicResProxy();
        Intrinsics.checkNotNull(r10);
        return c.a.a(r10, A(), w(), D(), null, null, 24, null);
    }
}
