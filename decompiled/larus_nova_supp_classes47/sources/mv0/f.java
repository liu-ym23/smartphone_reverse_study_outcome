package mv0;

import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements l71.c {
    public static final f a = null;

    public f() {
    }

    static {
        a = new f();
    }

    @Override // l71.c
    public final void enqueueEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        IExternalBrowserService r0 = jc1.k.f(IExternalBrowserService.class);
        if (r0 == null) goto L6;
        r0.enqueueEvent(r2, r3);
        return;
    }
}
