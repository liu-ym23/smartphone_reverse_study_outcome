package com.obric.assistant.interaction.impl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/obric/assistant/interaction/impl/ObricShowOnLockedServiceImpl$shouldAllowByDoraDowngrade$1$1", "Lcom/obric/assistant/IDoraAuthTrustCallback;", "onNotDowngrade", "", "onDowngradeToNoneAuth", "onDowngradeToVoicePrint", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricShowOnLockedServiceImpl$shouldAllowByDoraDowngrade$1$1 implements com.obric.assistant.i {
    final /* synthetic */ CountDownLatch $latch;
    final /* synthetic */ AtomicBoolean $result;
    final /* synthetic */ boolean $voicePassed;

    public void onDowngradeToNoneAuth() {
        this.$result.set(true);
        this.$latch.countDown();
    }

    public void onDowngradeToVoicePrint() {
        this.$result.set(this.$voicePassed);
        this.$latch.countDown();
    }

    public void onNotDowngrade() {
        this.$result.set(false);
        this.$latch.countDown();
    }

    public ObricShowOnLockedServiceImpl$shouldAllowByDoraDowngrade$1$1(AtomicBoolean r1, CountDownLatch r2, boolean r3) {
        this.$result = r1;
        this.$latch = r2;
        this.$voicePassed = r3;
    }
}
