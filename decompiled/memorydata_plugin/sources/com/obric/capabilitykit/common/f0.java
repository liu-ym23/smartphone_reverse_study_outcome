package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/NoteEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f7497a = null;

    static {
        f7497a = new f0();
    }

    private f0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, NoteEntity.class) == false) goto L18;
        NoteEntity r1 = (NoteEntity) ZeusTransformUtils.preCheckCast(r2, NoteEntity.class, "com.obric.memorydata.plugin");
        int r3 = ((r1.getTitle().hashCode() + 0) * 31) + r1.getText().hashCode();
        FormatModeEnum r0 = r1.getFormatMode();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.name().hashCode();
    L7:
        String r4 = r1.getNoteFolder();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.hashCode();
    L10:
        int r5 = (r3 * 31) + Boolean.hashCode(r1.isFavorite());
        List<FileEntity> r6 = r1.getFiles();
        if (r6 == null) goto L13;
        r5 = (r5 * 31) + r6.hashCode();
    L13:
        List<RecordingEntity> r7 = r1.getRecordings();
        if (r7 != null) goto L16;
        return r5;
    L16:
        return (r5 * 31) + r7.hashCode();
    L18:
        throw new IllegalStateException("Check failed.".toString());
    }
}
