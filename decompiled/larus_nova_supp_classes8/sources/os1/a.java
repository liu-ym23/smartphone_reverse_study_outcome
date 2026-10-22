package os1;

import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[EXTERNAL_CONFIG_TYPE.values().length];
        a = r0;
        r0[EXTERNAL_CONFIG_TYPE.Gesture.ordinal()] = 1;
        r0[EXTERNAL_CONFIG_TYPE.Component.ordinal()] = 2;
        r0[EXTERNAL_CONFIG_TYPE.OrientationChange.ordinal()] = 3;
        r0[EXTERNAL_CONFIG_TYPE.LongPressPanel.ordinal()] = 4;
        r0[EXTERNAL_CONFIG_TYPE.Service.ordinal()] = 5;
    }
}
