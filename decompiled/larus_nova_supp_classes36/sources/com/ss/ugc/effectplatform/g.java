package com.ss.ugc.effectplatform;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public static List a(final j r2, List r3) {
        if (r3 == null) goto L4;
        final String r1 = "760.0.0.269-alpha.24";
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r3), new EffectPlatformEncryptorKt$decryptList$1(r2, r1)), EffectPlatformEncryptorKt$decryptList$2.INSTANCE));
    L4:
        return null;
    }
}
