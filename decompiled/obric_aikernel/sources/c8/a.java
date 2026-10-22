package c8;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f639m;

    public a(String r10, PackageResourceManager.PresmConfig r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "config");
        super(r10, r11, null, 4, null);
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String A() {
        return "aikernel-lora";
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String B() {
        return "aikernel-loras";
    }

    @Override // c8.d
    public boolean g0() {
        RequestParams r10 = new RequestParams(null, null, 3, null);
        e8.b.a(r10, w());
        if (this.f639m == true) goto L6;
        c r11 = q().getDynamicResProxy();
        Intrinsics.checkNotNull(r11);
        this.f639m = r11.a(A(), "vlm_local", D(), r10, w());
    L6:
        return this.f639m;
    }
}
