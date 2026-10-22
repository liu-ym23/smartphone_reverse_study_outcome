package hb;

/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ e[] f8026a = null;

    static {
        f8026a = new e[]{new e("OUI_ANIMATION_BOUNCE_SMOOTH", 0, 1.0f), new e("OUI_ANIMATION_BOUNCE_SNAPPY_1", 1, 0.95f), new e("OUI_ANIMATION_BOUNCE_SNAPPY_2", 2, 0.9f), new e("OUI_ANIMATION_BOUNCE_SNAPPY_3", 3, 0.85f), new e("OUI_ANIMATION_BOUNCE_SNAPPY_4", 4, 0.8f), new e("OUI_ANIMATION_BOUNCE_BOUNCY_1", 5, 0.75f), new e("OUI_ANIMATION_BOUNCE_BOUNCY_2", 6, 0.7f), new e("OUI_ANIMATION_BOUNCE_BOUNCY_3", 7, 0.65f), new e("OUI_ANIMATION_BOUNCE_BOUNCY_4", 8, 0.6f)};
    }

    public e(String r8, int r10, float r11) {
        super(r8, r10);
    }

    public static e valueOf(String r8) {
        return (e) Enum.valueOf(e.class, r8);
    }

    public static e[] values() {
        return (e[]) f8026a.clone();
    }
}
