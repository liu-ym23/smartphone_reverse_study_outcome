package ff0;

import android.util.Log;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements ObservableOnSubscribe {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void subscribe(ObservableEmitter<Boolean> r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        PolarisFileWrapper r1 = new PolarisFileWrapper(new PolarisFileWrapper(s1.getContext().getExternalFilesDir(null), "hamlet_avatar"), "lip_sync_config");     // Catch: Throwable -> L5
        int r2 = n.a;     // Catch: Throwable -> L5
        n.a(s1.getContext(), "lip_sync_config", r1);     // Catch: Throwable -> L5
        d r0 = d.a;     // Catch: Throwable -> L5
        com.bytedance.android.live.liveinteract.utils.j.a(1, "extra_lip_sync_config_result", 0, null, null, 24);     // Catch: Throwable -> L5
        r9.onNext(Boolean.TRUE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d r3 = d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "extra_lip_sync_config_result", -1, Log.getStackTraceString(th), null, 16);
        r9.onNext(Boolean.FALSE);
    }
}
