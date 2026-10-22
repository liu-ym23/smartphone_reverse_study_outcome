package o82;

import com.bytedance.android.livesdk.interactivity.interactive.utils.MovingType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[MovingType.values().length];
        a = r0;
        r0[MovingType.MOVE_TO_LEFT.ordinal()] = 1;
        r0[MovingType.MOVE_TO_RIGHT.ordinal()] = 2;
        MovingType r1 = MovingType.STOP;
        r0[r1.ordinal()] = 3;
        MovingType r4 = MovingType.DEFAULT;
        r0[r4.ordinal()] = 4;
        int[] r2 = new int[MovingType.values().length];
        b = r2;
        r2[MovingType.MOVE_TO_TOP.ordinal()] = 1;
        r2[MovingType.MOVE_TO_BOTTOM.ordinal()] = 2;
        r2[r1.ordinal()] = 3;
        r2[r4.ordinal()] = 4;
    }
}
