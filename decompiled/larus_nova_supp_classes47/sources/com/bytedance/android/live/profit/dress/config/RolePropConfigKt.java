package com.bytedance.android.live.profit.dress.config;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RolePropConfigKt {
    public static final String a(s r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$describe");
        return "PropConfig(playValueIcon=" + r2.getPlayValueIcon() + ", linkmicEffect=" + r2.getLinkmicEffect() + ", beautyEffectId=" + r2.getBeautyEffectId() + ", staticLinkmicImg=" + r2.getStaticLinkmicImg() + ')';
    }

    public static final <K, V> String b(Map<K, ? extends V> r10, final Function1<? super V, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$describe");
        Intrinsics.checkNotNullParameter(r12, "valueTransformer");
        return SequencesKt.joinToString$default(MapsKt.asSequence(r10), null, "{", "}", 0, null, new RolePropConfigKt$describe$1(r12), 25, null);
    }
}
