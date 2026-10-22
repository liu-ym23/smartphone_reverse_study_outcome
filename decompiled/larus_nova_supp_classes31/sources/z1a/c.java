package z1a;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.update.IBitsUpdateImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class c implements yhc.j {
    public final /* synthetic */ IBitsUpdateImpl a;

    public /* synthetic */ c(IBitsUpdateImpl r1) {
        this.a = r1;
    }

    public final void a(Context r3) {
        IBitsUpdateImpl r0 = this.a;
        int r1 = IBitsUpdateImpl.h;
        Intrinsics.checkNotNullParameter(r3, "it");
        r0.c = true;
        AppHost.a.a().finishAllActivities();
    }
}
