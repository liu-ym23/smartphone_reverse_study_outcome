package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t implements c {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof AuditoryRecordingEntity) == false) goto L24;
        AuditoryRecordingEntity r4 = (AuditoryRecordingEntity) r3;
        int r0 = ((((((r4.getName().hashCode() + 0) * 31) + r4.getState()) * 31) + r4.getFile().hashCode()) * 31) + r4.getDuration();
        FileEntity r1 = r4.getTranscript();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.hashCode();
    L7:
        String r2 = r4.getSummary();
        if (r2 == null) goto L10;
        r0 = (r0 * 31) + r2.hashCode();
    L10:
        List r5 = r4.getTodoList();
        if (r5 == null) goto L13;
        r0 = (r0 * 31) + r5.hashCode();
    L13:
        List r6 = r4.getMarkers();
        if (r6 == null) goto L16;
        r0 = (r0 * 31) + r6.hashCode();
    L16:
        String r7 = r4.getSourceAppName();
        if (r7 == null) goto L19;
        r0 = (r0 * 31) + r7.hashCode();
    L19:
        String r8 = r4.getSourceAppPackage();
        if (r8 != null) goto L22;
        return r0;
    L22:
        return (r0 * 31) + r8.hashCode();
    L24:
        throw new IllegalStateException("Check failed.".toString());
    }
}
