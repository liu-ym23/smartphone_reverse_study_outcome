package mh0;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[DynamicUpdateType.values().length];
        a = r0;
        r0[DynamicUpdateType.AUDIOCHAT_STAGE.ordinal()] = 1;
        r0[DynamicUpdateType.SUBTITLE.ordinal()] = 2;
        int[] r1 = new int[DynamicGetType.values().length];
        b = r1;
        r1[DynamicGetType.SUBTITLE.ordinal()] = 1;
    }
}
