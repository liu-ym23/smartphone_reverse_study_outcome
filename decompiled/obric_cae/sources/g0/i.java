package g0;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Callable<k.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f7517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7518d;

    public i(String r8, Context r10, f r11, int r12) {
        this.f7515a = r8;
        this.f7516b = r10;
        this.f7517c = r11;
        this.f7518d = r12;
    }

    @Override // java.util.concurrent.Callable
    public final k.a call() {
        return k.a(this.f7515a, this.f7516b, this.f7517c, this.f7518d);
    L5:
        return new k.a(-3);
    }
}
