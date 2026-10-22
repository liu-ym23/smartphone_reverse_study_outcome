package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"succeed", BuildConfig.FLAVOR, "dressId", BuildConfig.FLAVOR, "assetId", BuildConfig.FLAVOR, "path", "invoke"}, k = 3, mv = {1, 4, 3})
public final class Mp4EnhancedEnterPlayer$playAnim$3 extends Lambda implements Function3<String, Long, String, Unit> {
    final /* synthetic */ Mp4EnhancedEnterPlayer$playAnim$1 $finished$1;
    final /* synthetic */ k32.a $msg;

    public Mp4EnhancedEnterPlayer$playAnim$3(Mp4EnhancedEnterPlayer$playAnim$1 r1, k32.a r2) {
        this.$finished$1 = r1;
        this.$msg = r2;
        super(3);
    }

    public final void invoke(String r5, long r6, String r8) {
        Intrinsics.checkNotNullParameter(r5, "dressId");
        Intrinsics.checkNotNullParameter(r8, "path");
        ALogger.e("Mp4EnhancedEnterPlayer", "[Succeed] dressId=" + r5 + " assetId=" + r6 + " path=" + r8);
        this.$finished$1.m659invoke();
        RevenueUtils.b.e(RevenueUtils.i, this.$msg, "user_enter_finish", UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("enter_type", 9), TuplesKt.to("dress_id", r5), TuplesKt.to("resource_id", Long.valueOf(r6))}));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
        invoke((String) r3, ((Number) r4).longValue(), (String) r5);
        return Unit.INSTANCE;
    }
}
