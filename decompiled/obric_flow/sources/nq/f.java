package nq;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static void a(Context r5, e r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "config");
        if (MatrixTeaManager.access$getInstance$cp() == null) goto L5;
    L16:
        MatrixTeaManager r11 = MatrixTeaManager.access$getInstance$cp();
        Intrinsics.checkNotNull(r11);
        r11.bindService();
        return;
    L5:
        monitor-enter(MatrixTeaManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (MatrixTeaManager.access$getInstance$cp() != null) goto L11;
        MatrixTeaManager.access$setInstance$cp(new MatrixTeaManager(r5, r10, null));     // Catch: Throwable -> L9
    L11:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(MatrixTeaManager.class);
        goto L16
    }
}
