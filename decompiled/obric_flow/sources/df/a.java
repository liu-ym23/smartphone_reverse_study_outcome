package df;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16643a = null;

    static {
        f16643a = new a();
    }

    @Override // java.lang.Runnable
    public final void run() {
        File r5 = com.lynx.tasm.behavior.utils.d.e;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
    L5:
        File[] r10 = r5.listFiles();
        if (r10 == null) goto L10;
        int r11 = r10.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L12;
        com.bytedance.geckox.utils.d.j(r10[r12]);
        r12 = r12 + 1;
        goto L8
    L12:
        return;
    }
}
