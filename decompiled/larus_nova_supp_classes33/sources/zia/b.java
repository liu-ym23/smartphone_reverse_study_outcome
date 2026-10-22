package zia;

import com.obric.capabilitykit.search.IAppEntityChangeCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ IAppEntityChangeCallback a;
    public final /* synthetic */ Throwable b;

    public /* synthetic */ b(IAppEntityChangeCallback r1, Throwable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAppEntityChangeCallback r0 = this.a;
        Throwable r1 = this.b;
        Intrinsics.checkNotNullParameter(r0, "$callback");
        Intrinsics.checkNotNullParameter(r1, "$e");
        String r2 = r1.getMessage();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.onError(1, r2);
    }
}
