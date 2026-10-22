package ce8;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements d {
    public final ExecutorService a;
    public final ExecutorCoroutineDispatcher b;

    public o() {
        ExecutorService r0 = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("l/UtilAbility"));
        this.a = r0;
        this.b = ExecutorsKt.from(r0);
    }

    @Override // ce8.d
    public final ExecutorCoroutineDispatcher fi() {
        return this.b;
    }
}
