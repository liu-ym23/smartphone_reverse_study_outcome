package r5;

import android.os.FileObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends FileObserver {
    public final /* synthetic */ a a;

    public e(a r1, String r10) {
        this.a = r1;
        super(r10, 1536);
    }

    @Override // android.os.FileObserver
    public final void onEvent(int r1, String r10) {
        if (r1 != 512) goto L5;
    L7:
        d r11 = f.a;
        a r12 = this.a;
        Intrinsics.checkNotNullParameter(r12, "info");
        String r13 = r12.b;
        d r14 = f.a;
        if (r14 == null) goto L10;
        a r15 = r14.remove(r13);
    L10:
        f.b.remove(r13);
        return;
    L5:
        if (r1 == 1024) goto L7;
    }
}
