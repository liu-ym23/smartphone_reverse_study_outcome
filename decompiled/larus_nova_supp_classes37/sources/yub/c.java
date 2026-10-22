package yub;

import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.officesdk.minutes.service.fileupload.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements y {
    public final /* synthetic */ a.c a;

    public c(k r1) {
        this.a = r1;
    }

    public final void f(y.a r2, y.a r3) {
        Intrinsics.checkNotNullParameter(r2, "oldState");
        Intrinsics.checkNotNullParameter(r3, "newState");
        this.a.a(d.c(r2), d.c(r3));
    }
}
