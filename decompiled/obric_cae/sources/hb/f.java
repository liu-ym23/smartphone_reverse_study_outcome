package hb;

import com.obric.cae.libs.useraware.ApWakeEvent;

/* JADX INFO: loaded from: classes2.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ f[] f8027a = null;

    static {
        f8027a = new f[]{new f("OUI_ANIMATION_DURATION_SHORT_1", 0, 15791), new f("OUI_ANIMATION_DURATION_SHORT_2", 1, 3948), new f("OUI_ANIMATION_DURATION_SHORT_3", 2, 1755), new f("OUI_ANIMATION_DURATION_SHORT_4", 3, 987), new f("OUI_ANIMATION_DURATION_MEDIUM_1", 4, 632), new f("OUI_ANIMATION_DURATION_MEDIUM_2", 5, 439), new f("OUI_ANIMATION_DURATION_MEDIUM_3", 6, 322), new f("OUI_ANIMATION_DURATION_MEDIUM_4", 7, 247), new f("OUI_ANIMATION_DURATION_LONG_1", 8, 195), new f("OUI_ANIMATION_DURATION_LONG_2", 9, 158), new f("OUI_ANIMATION_DURATION_LONG_3", 10, ApWakeEvent.ACCELERATING_END), new f("OUI_ANIMATION_DURATION_LONG_4", 11, 110), new f("OUI_ANIMATION_DURATION_VERY_LONG_1", 12, 81), new f("OUI_ANIMATION_DURATION_VERY_LONG_2", 13, 62), new f("OUI_ANIMATION_DURATION_VERY_LONG_3", 14, 49), new f("OUI_ANIMATION_DURATION_VERY_LONG_4", 15, 39)};
    }

    public f(String r8, int r10, int r11) {
        super(r8, r10);
    }

    public static f valueOf(String r8) {
        return (f) Enum.valueOf(f.class, r8);
    }

    public static f[] values() {
        return (f[]) f8027a.clone();
    }
}
