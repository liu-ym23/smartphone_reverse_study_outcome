package com.obric.aikernel.res.metadata.data.a;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/dynamic/RuntimeResource;", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", ActivityLifecycle.NAME, "", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "version", "(Ljava/lang/String;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;Ljava/lang/String;)V", "checkIsAvail", "", "checkResource", "fastMode", "isAvailable", "resourceIsAvailable", "resourceIsReady", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class d extends com.obric.aikernel.res.metadata.data.d {
    public d(String r2, PackageResourceManager.PresmConfig r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "version");
        super(r2, r4, r3);
    }

    public /* synthetic */ d(String r1, PackageResourceManager.PresmConfig r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "0";
    L5:
        this(r1, r2, r3);
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean c(boolean r1) {
        return true;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean d() {
        return g();
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean e() {
        return true;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean f() {
        return true;
    }

    public boolean g() {
        c r1 = u().getDynamicResProxy();
        Intrinsics.checkNotNull(r1);
        return c.a.a(r1, getType(), s(), t(), null, null, 24, null);
    }
}
