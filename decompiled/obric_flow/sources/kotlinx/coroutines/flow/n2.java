package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes3.dex */
public final class n2 implements l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18898a;

    public /* synthetic */ n2(int r5) {
        this.f18898a = r5;
    }

    @Override // kotlinx.coroutines.flow.l2
    public final g a(kotlinx.coroutines.flow.internal.y r5) {
        switch(this.f18898a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new t(SharingCommand.START, 0);
    L7:
        return new f2(new StartedLazily$command$1(r5, null));
    }

    public final String toString() {
        switch(this.f18898a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return "SharingStarted.Eagerly";
    L6:
        return "SharingStarted.Lazily";
    }
}
