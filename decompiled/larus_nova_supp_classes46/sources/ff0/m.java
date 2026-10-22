package ff0;

import android.util.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r8) {
        d r0 = d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "extra_lip_sync_config_result", -1, Log.getStackTraceString((Throwable) r8), null, 16);
    }
}
