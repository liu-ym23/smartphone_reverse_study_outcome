package z1a;

import com.larus.applog.api.IApplog;
import com.larus.update.IBitsUpdateImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class b implements yhc.e {
    public /* synthetic */ b() {
    }

    public final void onEvent(String r2, JSONObject r3) {
        int r0 = IBitsUpdateImpl.h;
        IApplog.Companion r1 = IApplog.a;
        Intrinsics.checkNotNull(r2);
        r1.reportEvent(r2, r3);
    }
}
