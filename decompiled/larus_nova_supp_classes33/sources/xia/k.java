package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k implements c {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof RecordingEntity) == false) goto L33;
        RecordingEntity r4 = (RecordingEntity) r3;
        int r0 = ((((r4.getName().hashCode() + 0) * 31) + r4.getFile().hashCode()) * 31) + r4.getDuration();
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
        if (r8 == null) goto L22;
        r0 = (r0 * 31) + r8.hashCode();
    L22:
        String r9 = r4.getSourceDevice();
        if (r9 == null) goto L25;
        r0 = (r0 * 31) + r9.hashCode();
    L25:
        String r10 = r4.getRecordType();
        if (r10 == null) goto L28;
        r0 = (r0 * 31) + r10.hashCode();
    L28:
        String r11 = r4.getRecordStatus();
        if (r11 != null) goto L31;
        return r0;
    L31:
        return (r0 * 31) + r11.hashCode();
    L33:
        throw new IllegalStateException("Check failed.".toString());
    }
}
