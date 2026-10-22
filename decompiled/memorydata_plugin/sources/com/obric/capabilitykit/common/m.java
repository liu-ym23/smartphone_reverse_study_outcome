package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppInfoEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class m implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f7512a = null;

    static {
        f7512a = new m();
    }

    private m() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, AppInfoEntity.class) == false) goto L15;
        AppInfoEntity r1 = (AppInfoEntity) ZeusTransformUtils.preCheckCast(r2, AppInfoEntity.class, "com.obric.memorydata.plugin");
        int r3 = ((((((r1.getAppName().hashCode() + 0) * 31) + r1.getAppPackageName().hashCode()) * 31) + Integer.hashCode(r1.getAppStatus())) * 31) + Boolean.hashCode(r1.isExactMatch());
        String r0 = r1.getIcon();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        String r4 = r1.getOpenStoreDetailDeeplink();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.hashCode();
    L10:
        String r5 = r1.getPackageSize();
        if (r5 != null) goto L13;
        return r3;
    L13:
        return (r3 * 31) + r5.hashCode();
    L15:
        throw new IllegalStateException("Check failed.".toString());
    }
}
