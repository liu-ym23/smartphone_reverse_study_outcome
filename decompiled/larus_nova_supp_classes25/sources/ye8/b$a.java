package ye8;

import android.content.Context;
import android.net.Uri;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import ic8.n0;
import ns8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b$a {
    public static /* synthetic */ void a(b r7, Context r8, String r9, String r10, AbsDownloadListener r11) {
        r7.c(r8, r9, r10, false, null, r11);
    }

    public static /* synthetic */ n0 c(b r8, String r9, boolean r10, ns8.a r11, b r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        ns8.a r5 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        b r6 = null;
    L11:
        return r8.f(r9, r10, r5, r6, false);
    L9:
        r6 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public static /* synthetic */ n0 b(b r9, Uri r10, boolean r11, ns8.a r12, String r13, b r14, int r15) {
        if ((r15 & 4) == 0) goto L5;
        ns8.a r5 = null;
    L7:
        if ((r15 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r15 & 16) == 0) goto L13;
        b r7 = null;
    L15:
        return r9.e(r10, r11, r5, r6, r7, false);
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}
