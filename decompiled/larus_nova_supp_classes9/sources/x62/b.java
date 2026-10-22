package x62;

import android.text.SpannableStringBuilder;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Observer<? super CharSequence> r0 = this.a.b;     // Catch: Throwable -> L9
        if (r0 == null) goto L12;
        CharSequence r2 = this.a.c.getText();     // Catch: Throwable -> L9
        if (r2 != null) goto L7;
        r2 = BuildConfig.FLAVOR;
    L7:
        r0.onNext(new SpannableStringBuilder(r2));     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
