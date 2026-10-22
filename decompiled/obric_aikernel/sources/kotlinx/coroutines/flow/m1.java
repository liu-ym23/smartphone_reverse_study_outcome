package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes3.dex */
public interface m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10504a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f10505a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final m1 f10506b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final m1 f10507c = null;

        static {
            f10505a = new a();
            f10506b = new n1();
            f10507c = new StartedLazily();
        }

        private a() {
        }

        public final m1 a() {
            return f10506b;
        }

        public final m1 b() {
            return f10507c;
        }
    }

    static {
        f10504a = a.f10505a;
    }

    c<SharingCommand> a(p1<Integer> r10);
}
