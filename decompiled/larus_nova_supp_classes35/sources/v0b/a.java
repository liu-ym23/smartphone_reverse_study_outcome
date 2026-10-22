package v0b;

import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleonv2.debug.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.h;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements f {
    public final /* synthetic */ f a;
    public final /* synthetic */ ChameleonConfig b;

    @Override // v0b.f
    public final void onStart() {
        f r0 = this.a;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    @Override // v0b.f
    public final void a(int r2) {
        f r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // v0b.f
    public final void b(VFSPath r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        f r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // v0b.f
    public final void c(Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        VFSFiles.b.getClass();     // Catch: IOException -> L5
        h r0 = VFSFiles.b(true);     // Catch: IOException -> L5
        int r1 = e.a;     // Catch: IOException -> L5
        e.b(r0.t(e.e(this.b)));     // Catch: IOException -> L5
    L7:
        f r2 = this.a;
        if (r2 == null) goto L13;
        r2.c(r4);
        return;
    L13:
        return;
    L5:
        e = move-exception;
        j.b("CML_TAG_D_Downloader", "onDownloadError:" + e);
        goto L7
    }

    public a(g r1, ChameleonConfig r2) {
        this.a = r1;
        this.b = r2;
    }
}
