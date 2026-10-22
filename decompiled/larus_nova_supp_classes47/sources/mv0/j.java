package mv0;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements qs0.h {
    public static final j a = null;

    public j() {
    }

    static {
        a = new j();
    }

    @Override // qs0.h
    public final String getCurrentPlayModes() {
        return com.bytedance.android.live.liveinteract.utils.w.a();
    }

    @Override // qs0.h
    public final void M0(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        com.bytedance.android.live.liveinteract.utils.w.b(r2);
    }
}
