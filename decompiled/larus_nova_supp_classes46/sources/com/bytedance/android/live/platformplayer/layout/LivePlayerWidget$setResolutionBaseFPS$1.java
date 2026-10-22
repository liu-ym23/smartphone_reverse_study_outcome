package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LivePlayerWidget$setResolutionBaseFPS$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $currentResolutionFPS;

    public LivePlayerWidget$setResolutionBaseFPS$1(int r1) {
        this.$currentResolutionFPS = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m838invoke() {
        IFeatureService r0 = jc1.k.f(IFeatureService.class);
        if (r0 == null) goto L8;
        z90.a r1 = r0.getFeatureManager();
        if (r1 == null) goto L9;
        r1.i("current_resolution_base_fps", Integer.valueOf(this.$currentResolutionFPS), FeatureType.MONITOR);
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m838invoke();
        return Unit.INSTANCE;
    }
}
