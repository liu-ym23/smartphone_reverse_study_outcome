package g0;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Callable<k.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f7512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7513d;

    public g(String r8, Context r10, f r11, int r12) {
        this.f7510a = r8;
        this.f7511b = r10;
        this.f7512c = r11;
        this.f7513d = r12;
    }

    @Override // java.util.concurrent.Callable
    public final k.a call() {
        return k.a(this.f7510a, this.f7511b, this.f7512c, this.f7513d);
    }
}
