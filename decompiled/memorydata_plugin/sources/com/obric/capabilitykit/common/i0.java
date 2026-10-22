package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class i0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f7504a = null;

    static {
        f7504a = new i0();
    }

    private i0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, ProactiveMemoryEntity.class) == false) goto L12;
        ProactiveMemoryEntity r1 = (ProactiveMemoryEntity) ZeusTransformUtils.preCheckCast(r2, ProactiveMemoryEntity.class, "com.obric.memorydata.plugin");
        int r3 = r1.getContent().hashCode() + 0;
        String r0 = r1.getTitle();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        Integer r4 = r1.getProductType();
        if (r4 != null) goto L10;
        return r3;
    L10:
        return (r3 * 31) + Integer.hashCode(r4.intValue());
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
