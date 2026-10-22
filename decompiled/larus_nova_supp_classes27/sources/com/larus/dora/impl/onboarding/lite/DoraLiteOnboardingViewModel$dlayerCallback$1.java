package com.larus.dora.impl.onboarding.lite;

import androidx.lifecycle.ViewModelKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraLiteOnboardingViewModel$dlayerCallback$1 implements b59.b {
    public final AtomicBoolean a;
    public final /* synthetic */ DoraLiteOnboardingViewModel b;

    public DoraLiteOnboardingViewModel$dlayerCallback$1(DoraLiteOnboardingViewModel r2) {
        this.b = r2;
        this.a = new AtomicBoolean(false);
    }

    @Override // b59.b
    public final void c(byte[] r9) {
        StringBuilder r0 = new StringBuilder("onTTSData: ");
        if (r9 == null) goto L5;
        Integer r2 = Integer.valueOf(r9.length);
    L6:
        r0.append(r2);
        g49.d.d("DoraOnboardingViewModel", r0.toString());
        if (r9 != null) goto L9;
        return;
    L9:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.b), null, null, new DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSData$1(this, this.b, r9, null), 3, null);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // b59.b
    public final void d(int r10) {
        g49.d.d("DoraOnboardingViewModel", "onTTSState: state=" + r10);
        if (r10 == 0) goto L17;
        if (r10 == 1) goto L16;
        if (r10 != 2) goto L7;
    L12:
        com.larus.call_plugins_doubao_common.manager.r r11 = DoraLiteOnboardingViewModel.access$getMediaManager$p(this.b);
        if (r11 == null) goto L15;
        com.larus.call_plugins_doubao_common.manager.n0.b(r11);
    L15:
        DoraLiteOnboardingViewModel.access$onTTSPlayEnd(this.b);
        return;
    L7:
        if (r10 == 3) goto L12;
        if (r10 != 4) goto L25;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.b), null, null, new DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSState$5(this.b, null), 3, null);
        return;
    L25:
        return;
    L16:
        DoraLiteOnboardingViewModel.access$loopTTSData(this.b);
        return;
    L17:
        DoraLiteOnboardingViewModel.access$getTtsDataCacheList$p(this.b).clear();
        this.a.set(true);
        DoraLiteOnboardingViewModel.access$setMediaManager$p(this.b, new com.larus.call_plugins_doubao_common.manager.r(new e0(), new f0(), new g0(), new h0()));
        com.larus.call_plugins_doubao_common.manager.r r12 = DoraLiteOnboardingViewModel.access$getMediaManager$p(this.b);
        if (r12 == null) goto L24;
        r12.a(2, null);
        return;
    }
}
