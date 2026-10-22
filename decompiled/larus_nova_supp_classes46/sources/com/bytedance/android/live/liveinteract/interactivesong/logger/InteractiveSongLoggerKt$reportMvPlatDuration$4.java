package com.bytedance.android.live.liveinteract.interactivesong.logger;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final class InteractiveSongLoggerKt$reportMvPlatDuration$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Map $logMap;

    public InteractiveSongLoggerKt$reportMvPlatDuration$4(Map r1) {
        this.$logMap = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m145invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m145invoke() {
        this.$logMap.put("sing_stage_effect_type", "official_mv");
    }
}
