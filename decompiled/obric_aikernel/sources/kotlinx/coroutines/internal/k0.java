package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f10557a = 0;

    static {
        f10557a = Runtime.getRuntime().availableProcessors();
    }

    public static final int a() {
        return f10557a;
    }

    public static final String b(String r10) {
        return System.getProperty(r10);
    L4:
        return null;
    }
}
