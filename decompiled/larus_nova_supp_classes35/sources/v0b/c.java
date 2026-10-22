package v0b;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Callback {
    public final /* synthetic */ f a;
    public final /* synthetic */ VFSPath b;

    public c(a r1, VFSPath r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(Call r2, IOException r3) {
        Intrinsics.checkNotNullParameter(r2, "call");
        Intrinsics.checkNotNullParameter(r3, "e");
        f r4 = this.a;
        if (r4 == null) goto L5;
        r4.c(r3);
    L5:
        j.b("CML_TAG_D_DownloadHelper", "onFailure err:" + r3);
    }

    public final void onResponse(Call r18, Response r19) {
        Intrinsics.checkNotNullParameter(r18, "call");
        Intrinsics.checkNotNullParameter(r19, "response");
        if (r19.code() == 200) goto L9;
        String r2 = r19.code() + r19.message();
        f r3 = this.a;
        if (r3 == null) goto L7;
        r3.c(new Exception(r2));
    L7:
        j.b("CML_TAG_D_DownloadHelper", "onResponse err response:" + r19);
        return;
    L9:
        String r4 = r19.header("Content-Length");
        if (r4 != null) goto L12;
        r4 = "-1";
    L12:
        long r5 = CastLongProtector.parseLong(r4);
        OutputStream r6 = null;
        InputStream r7 = null;
        VFSPath r8 = this.b;     // Catch: Throwable -> L48 IOException -> L50
        if (r8 == null) goto L19;
        VFSFile r9 = r8.toFile();     // Catch: Throwable -> L48 IOException -> L50
        if (r9 == null) goto L19;
        OutputStream r10 = r9.newOutputStream();     // Catch: Throwable -> L48 IOException -> L50
    L62:
        ResponseBody r0 = r19.body();     // Catch: Throwable -> L44 IOException -> L46
        if (r0 == null) goto L23;
        r7 = r0.byteStream();     // Catch: Throwable -> L44 IOException -> L46
    L23:
        if (r7 == null) goto L40;
        f r1 = this.a;     // Catch: Throwable -> L44 IOException -> L46
        byte[] r11 = new byte[ChameleonContainerUtils.MAX_URL_LENGTH];     // Catch: Throwable -> L44 IOException -> L46
        int r12 = 0;
        int r13 = 0;
    L25:
        int r14 = r7.read(r11, 0, ChameleonContainerUtils.MAX_URL_LENGTH);     // Catch: Throwable -> L44 IOException -> L46
        int r15 = -1;
        if (r14 == (-1)) goto L37;
        r12 = r12 + r14;     // Catch: Throwable -> L44 IOException -> L46
        if (r5 == (-1)) goto L31;
        r15 = (int) ((r12 * 100.0f) / r5);     // Catch: Throwable -> L44 IOException -> L46
    L31:
        if (r15 == r13) goto L35;
        if (r1 == null) goto L34;
        r1.a(r15);     // Catch: Throwable -> L44 IOException -> L46
    L34:
        r13 = r15;
    L35:
        if (r10 == null) goto L25;
        r10.write(r11, 0, r14);     // Catch: Throwable -> L44 IOException -> L46
        goto L25
    L37:
        r7.close();     // Catch: Throwable -> L44 IOException -> L46
        if (r10 == null) goto L40;
        r10.close();     // Catch: Throwable -> L44 IOException -> L46
    L40:
        d.a(r10);
        f r16 = this.a;
        if (r16 == null) goto L69;
        r16.b(this.b);
        return;
    L69:
        return;
    L46:
        e = e;
        r6 = r10;
    L51:
        f r17 = this.a;     // Catch: Throwable -> L48
        if (r17 == null) goto L54;
        r17.c(e);     // Catch: Throwable -> L48
    L54:
        j.e("CML_TAG_D_DownloadHelper", "onResponse err:" + e);     // Catch: Throwable -> L48
        d.a(r6);
        return;
    L44:
        th = th;
    L58:
        d.a(r10);
        throw th;
    L19:
        r10 = null;
    L48:
        th = th;
        r10 = null;
    L50:
        e = e;
        goto L51
    }
}
