package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/RecordingEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class j0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f7507a = null;

    static {
        f7507a = new j0();
    }

    private j0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, RecordingEntity.class) == false) goto L33;
        RecordingEntity r1 = (RecordingEntity) ZeusTransformUtils.preCheckCast(r2, RecordingEntity.class, "com.obric.memorydata.plugin");
        int r3 = ((((r1.getName().hashCode() + 0) * 31) + r1.getFile().hashCode()) * 31) + Integer.hashCode(r1.getDuration());
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
        if (r8 == null) goto L22;
        r3 = (r3 * 31) + r8.hashCode();
    L22:
        String r9 = r1.getSourceDevice();
        if (r9 == null) goto L25;
        r3 = (r3 * 31) + r9.hashCode();
    L25:
        String r10 = r1.getRecordType();
        if (r10 == null) goto L28;
        r3 = (r3 * 31) + r10.hashCode();
    L28:
        String r11 = r1.getRecordStatus();
        if (r11 != null) goto L31;
        return r3;
    L31:
        return (r3 * 31) + r11.hashCode();
    L33:
        throw new IllegalStateException("Check failed.".toString());
    }
}
