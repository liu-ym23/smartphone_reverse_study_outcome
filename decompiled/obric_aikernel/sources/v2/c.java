package v2;

import java.util.concurrent.Callable;
import w2.d;

/* JADX INFO: loaded from: classes.dex */
public class c implements Callable<Void> {
    public c() {
    }

    public Void a() {
        d.a();
        return null;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return a();
    }
}
