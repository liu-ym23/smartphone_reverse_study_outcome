package ad2;

import android.net.Uri;
import bytedance.io.BdFileSystem;
import com.bytedance.android.live.core.utils.s1;
import com.ss.bduploader.BDMediaDataReader;
import java.io.BufferedInputStream;
import java.io.InputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 implements BDMediaDataReader {
    public InputStream a;
    public BufferedInputStream b;
    public final Uri c;
    public final long d;

    public static final class a {
    }

    static {
    }

    public final int close(int r2) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        BufferedInputStream r4 = this.b;     // Catch: Throwable -> L8
        if (r4 == null) goto L5;
        r4.close();     // Catch: Throwable -> L8
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(r5);     // Catch: Throwable -> L8
        return 0;
    L5:
        r5 = null;
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return 0;
    }

    public final int open(int r2) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(BdFileSystem.getInputStream(s1.getContext(), this.c));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r4) == false) goto L9;
        r4 = null;
    L9:
        InputStream r5 = (InputStream) r4;
        this.a = r5;
        if (r5 == null) goto L12;
        return 1;
    L12:
        return -1;
    L4:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public d0(Uri r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "filePath");
        this.c = r2;
        this.d = r3;
    }

    public final long getValue(int r1, int r2) {
        if (r2 == 0) goto L4;
        return 0;
    L4:
        return this.d;
    }

    public final int read(int r3, long r4, byte[] r6, int r7) {
        if (this.a != null) goto L7;
        return -1;
    L7:
        if (r4 <= this.d) goto L10;
        return 0;
    L10:
        BufferedInputStream r5 = new BufferedInputStream(this.a);
        this.b = r5;
        return r5.read(r6);
    }
}
