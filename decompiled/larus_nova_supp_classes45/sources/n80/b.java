package n80;

import android.os.Looper;
import android.view.View;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends Observable<Object> {
    public final View a;

    public static final class a extends qtc.a implements View.OnClickListener {
        public final View b;
        public final Observer<? super Object> c;

        public final void b() {
            this.b.setOnClickListener(null);
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (isDisposed() == true) goto L6;
            this.c.onNext(n80.a.a);
            return;
        }

        public a(View r1, Observer<? super Object> r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public b(View r1) {
        this.a = r1;
    }

    public final void subscribeActual(Observer<? super Object> r4) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        r4.onError(new IllegalStateException("Expected to be called on the main thread but was " + ThreadMethodProxy.currentThread().getName()));
        boolean r0 = false;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        a r1 = new a(this.a, r4);
        r4.onSubscribe(r1);
        this.a.setOnClickListener(r1);
        return;
    L5:
        r0 = true;
        goto L6
    }
}
