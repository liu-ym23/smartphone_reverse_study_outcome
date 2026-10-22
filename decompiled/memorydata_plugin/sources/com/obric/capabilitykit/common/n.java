package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class n implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f7514a = null;

    static {
        f7514a = new n();
    }

    private n() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, AuditoryRecordingEntity.class) == false) goto L24;
        AuditoryRecordingEntity r1 = (AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r2, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin");
        int r3 = ((((((r1.getName().hashCode() + 0) * 31) + Integer.hashCode(r1.getState())) * 31) + r1.getFile().hashCode()) * 31) + Integer.hashCode(r1.getDuration());
        FileEntity r0 = r1.getTranscript();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        String r4 = r1.getSummary();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.hashCode();
    L10:
        List<String> r5 = r1.getTodoList();
        if (r5 == null) goto L13;
        r3 = (r3 * 31) + r5.hashCode();
    L13:
        List<Integer> r6 = r1.getMarkers();
        if (r6 == null) goto L16;
        r3 = (r3 * 31) + r6.hashCode();
    L16:
        String r7 = r1.getSourceAppName();
        if (r7 == null) goto L19;
        r3 = (r3 * 31) + r7.hashCode();
    L19:
        String r8 = r1.getSourceAppPackage();
        if (r8 != null) goto L22;
        return r3;
    L22:
        return (r3 * 31) + r8.hashCode();
    L24:
        throw new IllegalStateException("Check failed.".toString());
    }
}
