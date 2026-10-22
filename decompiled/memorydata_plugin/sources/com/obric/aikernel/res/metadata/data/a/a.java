package com.obric.aikernel.res.metadata.data.a;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.ParamsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/dynamic/AIKernelLoraDynamicPackage;", "Lcom/obric/aikernel/res/metadata/data/dynamic/RuntimeResource;", ActivityLifecycle.NAME, "", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "(Ljava/lang/String;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)V", "isAvail", "", "checkIsAvail", "getType", "getTypeRootPath", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6084a;

    public a(String r8, PackageResourceManager.PresmConfig r9) {
        Intrinsics.checkNotNullParameter(r8, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r9, "config");
        super(r8, r9, null, 4, null);
    }

    @Override // com.obric.aikernel.res.metadata.data.a.d
    public boolean g() {
        RequestParams r4 = new RequestParams(null, null, 3, null);
        ParamsKt.setLora(r4, s());
        if (this.f6084a == true) goto L6;
        c r0 = u().getDynamicResProxy();
        Intrinsics.checkNotNull(r0);
        this.f6084a = r0.a(getType(), "vlm_local", t(), r4, s());
    L6:
        return this.f6084a;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String getType() {
        return "aikernel-lora";
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String h() {
        return "aikernel-loras";
    }
}
