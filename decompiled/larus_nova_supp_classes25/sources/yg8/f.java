package yg8;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements IIMCallback<Boolean> {
    public f() {
    }

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        s r3 = s.a;
        Application r0 = AppHost.a.getApplication();
        r3.getClass();
        s.s(r0, 2131905463);
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        ((Boolean) r1).booleanValue();
    }
}
