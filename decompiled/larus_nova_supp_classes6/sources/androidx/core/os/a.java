package androidx.core.os;

import android.os.ProfilingResult;
import java.util.function.Consumer;
import kotlinx.coroutines.channels.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ k a;

    public /* synthetic */ a(k r1) {
        this.a = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r2) {
        Profiling.registerForAllProfilingResults.1.a(this.a, (ProfilingResult) r2);
    }
}
