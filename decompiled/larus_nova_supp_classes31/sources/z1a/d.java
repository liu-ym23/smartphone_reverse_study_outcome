package z1a;

import com.larus.common.apphost.AppHost;
import com.larus.update.IBitsUpdateImpl;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class d implements yhc.d {
    public /* synthetic */ d() {
    }

    public final WeakReference getCurrentActivity() {
        int r0 = IBitsUpdateImpl.h;
        return new WeakReference(AppHost.a.a().getCurrentActivity());
    }
}
