package com.bytedance.bpea.entry.api.appjump;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class AppJumpEntry$startActivityByCxtCompatUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ Bundle $options;

    public AppJumpEntry$startActivityByCxtCompatUnsafe$1(Context r1, Intent r2, Bundle r3) {
        this.$context = r1;
        this.$intent = r2;
        this.$options = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1536invoke() {
        ContextCompat.startActivity(this.$context, this.$intent, this.$options);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1536invoke();
        return Unit.INSTANCE;
    }
}
