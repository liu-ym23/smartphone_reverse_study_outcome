package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.enums.CountdownStatusEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CountdownEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class u implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f7523a = null;

    static {
        f7523a = new u();
    }

    private u() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if (ZeusTransformUtils.instanceOf(r3, CountdownEntity.class) == false) goto L12;
        CountdownEntity r2 = (CountdownEntity) ZeusTransformUtils.preCheckCast(r3, CountdownEntity.class, "com.obric.memorydata.plugin");
        int r4 = Long.hashCode(r2.getCountdownSeconds()) + 0;
        String r0 = r2.getLabel();
        if (r0 == null) goto L7;
        r4 = (r4 * 31) + r0.hashCode();
    L7:
        CountdownStatusEnum r5 = r2.getStatus();
        if (r5 != null) goto L10;
        return r4;
    L10:
        return (r4 * 31) + r5.name().hashCode();
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
