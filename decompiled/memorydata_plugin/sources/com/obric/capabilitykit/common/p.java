package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CallHistoryEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class p implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f7518a = null;

    static {
        f7518a = new p();
    }

    private p() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, CallHistoryEntity.class) == false) goto L24;
        CallHistoryEntity r1 = (CallHistoryEntity) ZeusTransformUtils.preCheckCast(r2, CallHistoryEntity.class, "com.obric.memorydata.plugin");
        int r3 = ((((r1.getTelephones().hashCode() + 0) * 31) + r1.getCallType().name().hashCode()) * 31) + Integer.hashCode(r1.getDuration());
        String r0 = r1.getTag();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        int r4 = (((r3 * 31) + Boolean.hashCode(r1.isAIPickup())) * 31) + Boolean.hashCode(r1.getHasTranscript());
        String r5 = r1.getTranscript();
        if (r5 == null) goto L10;
        r4 = (r4 * 31) + r5.hashCode();
    L10:
        List<String> r6 = r1.getCarriers();
        if (r6 == null) goto L13;
        r4 = (r4 * 31) + r6.hashCode();
    L13:
        List<String> r7 = r1.getTodoList();
        if (r7 == null) goto L16;
        r4 = (r4 * 31) + r7.hashCode();
    L16:
        String r8 = r1.getTranscriptTitle();
        if (r8 == null) goto L19;
        r4 = (r4 * 31) + r8.hashCode();
    L19:
        String r9 = r1.getSourceNumber();
        if (r9 != null) goto L22;
        return r4;
    L22:
        return (r4 * 31) + r9.hashCode();
    L24:
        throw new IllegalStateException("Check failed.".toString());
    }
}
