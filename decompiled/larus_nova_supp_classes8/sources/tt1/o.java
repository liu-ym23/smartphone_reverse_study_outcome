package tt1;

import android.app.Activity;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o {
    public Disposable a;
    public Disposable b;
    public WeakReference<Activity> c;

    public o() {
    }

    public final WeakReference<Activity> getActivity() {
        return this.c;
    }
}
