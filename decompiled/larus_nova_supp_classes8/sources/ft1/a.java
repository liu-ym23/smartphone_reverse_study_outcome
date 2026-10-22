package ft1;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements ICrashCallback {
    public static final /* synthetic */ int a = 0;

    public final void onCrash(CrashType r1, String r2, Thread r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    static {
    }
}
