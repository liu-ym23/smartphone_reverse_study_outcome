package d0;

import android.content.ContentResolver;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f16541b;

    public /* synthetic */ e0(ContentResolver r5, int r10) {
        this.f16540a = r10;
        this.f16541b = r5;
    }

    @Override // d0.s
    public final r a(z r5) {
        switch(this.f16540a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new f0(this);
    L7:
        return new f0(this);
    L9:
        return new f0(this);
    }
}
