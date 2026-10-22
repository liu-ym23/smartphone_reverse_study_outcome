package com.bytedance.android.live.effect.beauty.presets;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 implements ILiveEffectComposerManager.j {
    public final /* synthetic */ LiveBeautyPresetsFragment a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ List c;

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.j
    public final void a(long r7, Map<String, Long> r9) {
        Intrinsics.checkNotNullParameter(r9, "restoreCompletePanelMap");
        ALogger.e("LiveBeautyPresetsFragment", "onRestoreComplete:restoreCompleteTime:" + r7);
        if (((AtomicBoolean) this.b.element).compareAndSet(false, true) == false) goto L5;
        this.a.x.clear();
        LiveBeautyPresetsFragment.S90(this.a, this.c);
    L5:
        UtilityKotlinExtentionsKt.s(0, false, false, new LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1$onRestoreComplete$1(this), 7);
    }

    public LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1(LiveBeautyPresetsFragment r1, Ref.ObjectRef r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
