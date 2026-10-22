package p50;

import android.graphics.Bitmap;
import android.net.Uri;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements Runnable {
    public final /* synthetic */ Function4 a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ Bitmap c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public b(Function4 r1, Uri r2, Bitmap r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.invoke(this.b, this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
