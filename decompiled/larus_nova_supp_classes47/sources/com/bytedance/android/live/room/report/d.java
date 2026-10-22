package com.bytedance.android.live.room.report;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        ALogger.e("ReportServiceTrack", r2);
        LocalTestManager.a(new Class[]{wy.a.class});
    }
}
