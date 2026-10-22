package com.bytedance.android.live.browser.jsbridge.protobuf;

import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import java.io.BufferedReader;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class FileContentUtilKt {
    public static final Map<String, BufferedReader> a(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "relativePath");
        return MapsKt.toMap(SequencesKt.mapNotNull(CollectionsKt.asSequence(TTLiveWebOfflineConfig.DOUYIN_CHANNEL_LIST), new FileContentUtilKt$readerMapFromAllChannels$1(r2)));
    }
}
