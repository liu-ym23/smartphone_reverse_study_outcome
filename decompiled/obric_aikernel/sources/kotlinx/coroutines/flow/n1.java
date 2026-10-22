package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes3.dex */
final class n1 implements m1 {
    public n1() {
    }

    @Override // kotlinx.coroutines.flow.m1
    public c<SharingCommand> a(p1<Integer> r10) {
        return e.x(SharingCommand.START);
    }

    public String toString() {
        return "SharingStarted.Eagerly";
    }
}
