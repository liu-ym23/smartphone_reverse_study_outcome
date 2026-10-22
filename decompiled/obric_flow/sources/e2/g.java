package e2;

import com.bytedance.ai.bridge.system.vibrate.AbsVibrateShortMethodIDL;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f16750a = null;

    static {
        int[] r5 = new int[AbsVibrateShortMethodIDL.VibrateType.values().length];
        r5[AbsVibrateShortMethodIDL.VibrateType.HEAVY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r5[AbsVibrateShortMethodIDL.VibrateType.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r5[AbsVibrateShortMethodIDL.VibrateType.LIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f16750a = r5;
    }
}
