package mlb;

import android.graphics.Bitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ d.a b;

    public static final class a implements d.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ d.a b;

        @Override // mlb.d.a
        public final void a(ArrayList<QRCodeResultInfo> r3) {
            Intrinsics.checkNotNullParameter(r3, "resultList");
            b.b.put(this.a, r3);
            b.b(this.b, r3);
        }

        @Override // mlb.d.a
        public final void onError(String r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            b.b.put(this.a, new ArrayList());
            b.a(this.b, r4);
        }

        public a(String r1, d.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public c(String r1, d.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = com.ss.android.lark.imageqrcode.utils.a.a;     // Catch: Throwable -> L6
        Bitmap r1 = com.ss.android.lark.imageqrcode.utils.a.a(this.a);     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        b.f(r1, new a(this.a, this.b));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
