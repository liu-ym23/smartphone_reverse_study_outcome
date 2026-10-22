package com.bytedance.android.live.browser.service;

import com.bytedance.android.livesdk.w6;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AnnieLiveResourceServiceImpl$mPrefetchChannels$2 extends Lambda implements Function0<List<String>> {
    public static final AnnieLiveResourceServiceImpl$mPrefetchChannels$2 INSTANCE = null;

    static {
        INSTANCE = new AnnieLiveResourceServiceImpl$mPrefetchChannels$2();
    }

    public AnnieLiveResourceServiceImpl$mPrefetchChannels$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<String> m528invoke() {
        ArrayList r0 = new ArrayList();
        r0.addAll(TTLiveWebOfflineConfig.DOUYIN_CHANNEL_LIST);
        r0.addAll((List) w6.a.getValue());
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m528invoke();
    }
}
