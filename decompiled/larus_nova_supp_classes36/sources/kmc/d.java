package kmc;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements vlc.c, g {
    public final /* synthetic */ vlc.c a;
    public final /* synthetic */ g b;

    @Override // vlc.c
    public final boolean a() {
        return this.a.a();
    }

    @Override // vlc.g
    public final void b(String r2, Throwable r3) {
        this.b.b(r2, r3);
    }

    @Override // vlc.g
    public final void d(long r7, JSONObject r9, JSONObject r10, JSONObject r11) {
        this.b.d(r7, r9, r10, r11);
    }

    @Override // vlc.g
    public final void e(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        this.b.e(r2, r3, r4, r5);
    }

    @Override // vlc.c
    public final void log(String r2, String r3) {
        this.a.log(r2, r3);
    }

    public d(vlc.c r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        Intrinsics.checkNotNullParameter(r3, "monitor");
        this.a = r2;
        this.b = r3;
    }
}
