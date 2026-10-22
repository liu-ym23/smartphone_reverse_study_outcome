package tcb;

import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a<T> implements Callable<T> {
    public abstract T a() throws Exception;

    @Override // java.util.concurrent.Callable
    public final T call() throws Exception {
        return a();
    L4:
        e = move-exception;
        Log.e("ExceptionDetectorCallab", BuildConfig.FLAVOR + e.getStackTrace(), e, true);
        return null;
    }

    public a() {
    }
}
