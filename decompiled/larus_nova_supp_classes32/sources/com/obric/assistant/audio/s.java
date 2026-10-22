package com.obric.assistant.audio;

import com.larus.media.MediaOccupyStrategy;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s {
    public static final Lazy a = null;
    public static final Map<String, MediaOccupyStrategy> b = null;
    public static final Set<String> c = null;

    static {
        a = LazyKt.lazy(new r());
        MediaOccupyStrategy r1 = MediaOccupyStrategy.INTERRUPT;
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to("com.autonavi.minimap", MediaOccupyStrategy.PAUSE), TuplesKt.to("com.luna.music", r1), TuplesKt.to("com.obric.recorder", r1), TuplesKt.to("com.tencent.mm", r1), TuplesKt.to("com.ss.android.lark", r1), TuplesKt.to("com.android.server.telecom", r1), TuplesKt.to("com.tencent.qqmusic", r1), TuplesKt.to("com.ss.android.ugc.aweme", r1)});
        c = SetsKt.setOf("com.ss.android.ugc.aweme");
    }
}
