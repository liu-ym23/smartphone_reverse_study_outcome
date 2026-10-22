package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes3.dex */
final class StartedLazily implements m1 {
    public StartedLazily() {
    }

    @Override // kotlinx.coroutines.flow.m1
    public c<SharingCommand> a(p1<Integer> r10) {
        return e.v(new StartedLazily$command$1(r10, null));
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
