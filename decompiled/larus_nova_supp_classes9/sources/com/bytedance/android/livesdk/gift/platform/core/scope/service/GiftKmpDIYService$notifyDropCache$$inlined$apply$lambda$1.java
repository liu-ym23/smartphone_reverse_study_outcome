package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke", "com/bytedance/android/livesdk/gift/platform/core/scope/service/GiftKmpDIYService$notifyDropCache$2$1"}, k = 3, mv = {1, 5, 1})
final class GiftKmpDIYService$notifyDropCache$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ArrayList $diskCardList$inlined;
    final /* synthetic */ long $giftId$inlined;
    final /* synthetic */ v0 this$0;

    public GiftKmpDIYService$notifyDropCache$$inlined$apply$lambda$1(v0 r1, ArrayList r2, long r3) {
        this.this$0 = r1;
        this.$diskCardList$inlined = r2;
        this.$giftId$inlined = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m314invoke() {
        this.this$0.a(this.$diskCardList$inlined, this.$giftId$inlined);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m314invoke();
        return Unit.INSTANCE;
    }
}
