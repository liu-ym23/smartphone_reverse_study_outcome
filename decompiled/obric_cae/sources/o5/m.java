package o5;

import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDLocationCallback f9711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BDLocationException f9712b;

    public m(x r8, BDLocationException r10) {
        this.f9711a = r8;
        this.f9712b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9711a.onError(this.f9712b);
    }
}
