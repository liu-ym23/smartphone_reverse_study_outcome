package com.ss.ugc.effectplatform.download;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "progress", "", "contentLength", "", "invoke"}, k = 3, mv = {1, 1, 16})
final class EffectWriteDisk$execWrite$zipPath$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ e $listener;

    public EffectWriteDisk$execWrite$zipPath$1(e r1) {
        this.$listener = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke(((Number) r3).intValue(), ((Number) r4).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r2, long r3) {
        e r0 = this.$listener;
        if (r0 == null) goto L6;
        r0.onProgress(r2, r3);
        return;
    }
}
