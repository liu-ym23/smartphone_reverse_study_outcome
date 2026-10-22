package com.bytedance.bpea.entry.api.appjump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class AppJumpEntry$startActivityForResultByActCompatUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ Bundle $options;
    final /* synthetic */ int $requestCode;

    public AppJumpEntry$startActivityForResultByActCompatUnsafe$1(Activity r1, Intent r2, int r3, Bundle r4) {
        this.$activity = r1;
        this.$intent = r2;
        this.$requestCode = r3;
        this.$options = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1537invoke() {
        ActivityCompat.startActivityForResult(this.$activity, this.$intent, this.$requestCode, this.$options);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1537invoke();
        return Unit.INSTANCE;
    }
}
