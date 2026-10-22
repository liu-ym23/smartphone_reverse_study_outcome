package com.bytedance.android.annie.protobuf;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.resource.f;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final Map a(final com.bytedance.android.annie.service.prefetch.b r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "loader");
        Intrinsics.checkNotNullParameter(r11, "relativePath");
        return MapsKt.toMap(SequencesKt.mapNotNull(CollectionsKt.asSequence(((f) Annie.getService$default(f.class, null, 2, null)).r()), new FileContentUtilKt$readerMapFromPrefetchChannels$1(r10, r11)));
    }
}
