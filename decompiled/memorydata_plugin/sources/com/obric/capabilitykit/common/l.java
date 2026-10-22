package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class l implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f7510a = null;

    static {
        f7510a = new l();
    }

    private l() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        int r2 = ((((((r3.getId().hashCode() + 0) * 31) + Long.hashCode(r3.getCreateTime())) * 31) + Integer.hashCode(r3.getType())) * 31) + r3.get_packageName().hashCode();
        String r4 = r3.getExtraData();
        if (r4 != null) goto L5;
        return r2;
    L5:
        return (r2 * 31) + r4.hashCode();
    }
}
