package ai;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f310c;

    public /* synthetic */ z(int r5) {
        this.f310c = r5;
    }

    @Override // ai.b0
    public final d a(Executor r5) {
        switch(this.f310c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new m(r5);
    L7:
        return new m(r5);
    }

    @Override // ai.b0
    public final Executor b() {
        switch(this.f310c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new a0();
    L7:
        return new y(0);
    }
}
