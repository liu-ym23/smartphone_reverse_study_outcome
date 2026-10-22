package com.bytedance.android.live.room.discovery.drawer.processor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, Constants.OperatorKey.MSG);
        ALogger.i("LiveDrawerLog", r1);
    }
}
