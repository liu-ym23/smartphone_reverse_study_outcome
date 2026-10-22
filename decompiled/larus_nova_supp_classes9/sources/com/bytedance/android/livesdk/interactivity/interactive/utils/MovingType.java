package com.bytedance.android.livesdk.interactivity.interactive.utils;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/utils/MovingType;", BuildConfig.FLAVOR, "DEFAULT", "MOVE_TO_LEFT", "MOVE_TO_RIGHT", "STOP", "MOVE_TO_TOP", "MOVE_TO_BOTTOM", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MovingType extends Enum<MovingType> {
    public static final MovingType DEFAULT = null;
    public static final MovingType MOVE_TO_BOTTOM = null;
    public static final MovingType MOVE_TO_LEFT = null;
    public static final MovingType MOVE_TO_RIGHT = null;
    public static final MovingType MOVE_TO_TOP = null;
    public static final MovingType STOP = null;
    public static final /* synthetic */ MovingType[] a = null;

    static {
        MovingType r1 = new MovingType("DEFAULT", 0);
        DEFAULT = r1;
        MovingType r2 = new MovingType("MOVE_TO_LEFT", 1);
        MOVE_TO_LEFT = r2;
        MovingType r3 = new MovingType("MOVE_TO_RIGHT", 2);
        MOVE_TO_RIGHT = r3;
        MovingType r4 = new MovingType("STOP", 3);
        STOP = r4;
        MovingType r5 = new MovingType("MOVE_TO_TOP", 4);
        MOVE_TO_TOP = r5;
        MovingType r6 = new MovingType("MOVE_TO_BOTTOM", 5);
        MOVE_TO_BOTTOM = r6;
        a = new MovingType[]{r1, r2, r3, r4, r5, r6};
    }

    public static MovingType valueOf(String r1) {
        return (MovingType) a.a(MovingType.class, r1);
    }

    public static MovingType[] values() {
        return (MovingType[]) a.clone();
    }

    public MovingType(String r1, int r2) {
        super(r1, r2);
    }
}
