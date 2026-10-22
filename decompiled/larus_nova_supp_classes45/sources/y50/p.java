package y50;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class p {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveMode.values().length];
        LiveMode r1 = LiveMode.VIDEO;
        r0[r1.ordinal()] = 1;
        LiveMode r2 = LiveMode.AUDIO;
        r0[r2.ordinal()] = 2;
        LiveMode r4 = LiveMode.SCREEN_RECORD;
        r0[r4.ordinal()] = 3;
        LiveMode r6 = LiveMode.THIRD_PARTY;
        r0[r6.ordinal()] = 4;
        LiveMode r8 = LiveMode.MEDIA;
        r0[r8.ordinal()] = 5;
        r0[LiveMode.ACQUAINTANCE.ordinal()] = 6;
        r0[LiveMode.OFFICIAL_ACTIVITY.ordinal()] = 7;
        int[] r3 = new int[LiveMode.values().length];
        a = r3;
        r3[r1.ordinal()] = 1;
        r3[r4.ordinal()] = 2;
        r3[r6.ordinal()] = 3;
        r3[r2.ordinal()] = 4;
        r3[r8.ordinal()] = 5;
    }
}
