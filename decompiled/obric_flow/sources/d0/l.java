package d0;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class l implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f16557b;

    public /* synthetic */ l(Context r5, int r10) {
        this.f16556a = r10;
        this.f16557b = r5;
    }

    @Override // d0.s
    public final r a(z r5) {
        switch(this.f16556a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new n(this.f16557b, 2);
    L7:
        return new n(this.f16557b, 1);
    L9:
        return new n(this.f16557b, 0);
    }
}
