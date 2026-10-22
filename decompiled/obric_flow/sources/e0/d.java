package e0;

import android.content.Context;
import android.net.Uri;
import d0.r;
import d0.s;
import d0.z;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class d implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f16729b;

    public d(Context r5, Class r10) {
        this.f16728a = r5;
        this.f16729b = r10;
    }

    @Override // d0.s
    public final r a(z r5) {
        Class r10 = this.f16729b;
        r r11 = r5.b(File.class, r10);
        r r12 = r5.b(Uri.class, r10);
        return new f(this.f16728a, r11, r12, r10);
    }
}
