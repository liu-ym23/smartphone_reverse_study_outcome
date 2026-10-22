package com.bytedance.bpea.entry.api.appjump;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class AppJumpEntry$startActivityIfNeededUnsafe$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Intent $intent;
    final /* synthetic */ int $requestCode;
    final /* synthetic */ Activity $this_startActivityIfNeededUnsafe;

    public AppJumpEntry$startActivityIfNeededUnsafe$1(Activity r1, Intent r2, int r3) {
        this.$this_startActivityIfNeededUnsafe = r1;
        this.$intent = r2;
        this.$requestCode = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m1544invoke() {
        return this.$this_startActivityIfNeededUnsafe.startActivityIfNeeded(this.$intent, this.$requestCode);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m1544invoke());
    }
}
