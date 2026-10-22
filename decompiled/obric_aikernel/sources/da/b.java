package da;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8519a = null;

    static {
        f8519a = new b();
    }

    private b() {
    }

    public final float a(float r10, float r11, float r12) {
        return (r10 - r11) / (r12 - r11);
    }

    public final float b(float r10, float r11, float r12) {
        if (r11 != r12) goto L7;
        return 0.0f;
    L7:
        return (r10 - r11) / (r12 - r11);
    }
}
