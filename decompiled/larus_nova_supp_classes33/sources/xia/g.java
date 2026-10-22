package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g implements c {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof NoteEntity) == false) goto L22;
        NoteEntity r4 = (NoteEntity) r3;
        int r0 = ((r4.getTitle().hashCode() + 0) * 31) + r4.getText().hashCode();
        FormatModeEnum r1 = r4.getFormatMode();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.name().hashCode();
    L7:
        String r2 = r4.getNoteFolder();
        if (r2 == null) goto L10;
        r0 = (r0 * 31) + r2.hashCode();
    L10:
        int r5 = r0 * 31;
        if (r4.isFavorite() == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = r5 + r6;
        List r8 = r4.getFiles();
        if (r8 == null) goto L17;
        r7 = (r7 * 31) + r8.hashCode();
    L17:
        List r9 = r4.getRecordings();
        if (r9 != null) goto L20;
        return r7;
    L20:
        return (r7 * 31) + r9.hashCode();
    L13:
        r6 = 1237;
        goto L14
    L22:
        throw new IllegalStateException("Check failed.".toString());
    }
}
