package c8;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f640m;

    public b(String r10, PackageResourceManager.PresmConfig r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "config");
        super(r10, r11, null, 4, null);
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String A() {
        return "aikernel-pkg";
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String B() {
        return "aikernel-pkgs";
    }

    @Override // c8.d
    public boolean g0() {
        if (this.f640m == true) goto L6;
        this.f640m = super.g0();
    L6:
        return this.f640m;
    }
}
