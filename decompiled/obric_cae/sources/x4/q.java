package x4;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class q extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile j0 f13540b;

    public q(j0 r8) {
        this.f13540b = r8;
        this.f13539a = r8.f13465c;
    }

    @Override // x4.p
    public final void b(String r8, s r10) {
        if (r10 == null) goto L7;
        SharedPreferences r11 = r10.a(this.f13540b);
        if (r11 == null) goto L7;
        r11.edit().putString("device_token", r8).apply();
    L7:
        v0.a(this.f13539a).c(this.f13540b.a(), "device_token", r8);
    }
}
