package com.bytedance.android.live.broadcast.api.monitor;

import com.bytedance.android.live.core.utils.v;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class VideoProbeLogUtil$isDebug$2 extends Lambda implements Function0<Boolean> {
    public static final VideoProbeLogUtil$isDebug$2 INSTANCE = null;

    static {
        INSTANCE = new VideoProbeLogUtil$isDebug$2();
    }

    public VideoProbeLogUtil$isDebug$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m51invoke() {
        if (LocalTestManager.c(new Class[]{wy.a.class}) == false) goto L5;
        return true;
    L5:
        if (v.a() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m51invoke());
    }
}
