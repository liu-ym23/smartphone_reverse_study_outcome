package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveRoomStatesAndAVResourceUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    public static boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    static {
        a = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableLiveAudioAndVideoOpt$2.INSTANCE);
        b = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableLiveAudioAndVideoOptV2$2.INSTANCE);
        c = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableLiveAudioAndVideoLogReport$2.INSTANCE);
        d = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableLiveAudioAndVideoApiOpt$2.INSTANCE);
        e = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableLivePreviewStreamMachineOpt$2.INSTANCE);
        f = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableSensitiveEventInRoomOpt$2.INSTANCE);
        g = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enablePrivacyFacadeOpt$2.INSTANCE);
    }

    public static boolean c() {
        if (((Boolean) b.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (a() == false) goto L7;
        return true;
    }

    public static boolean b() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) d.getValue()).booleanValue() == false) goto L7;
        return true;
    }
}
