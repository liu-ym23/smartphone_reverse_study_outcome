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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"failed", BuildConfig.FLAVOR, "reason", BuildConfig.FLAVOR, "dressId", "assetId", "invoke"}, k = 3, mv = {1, 4, 3})
public final class Mp4EnhancedEnterPlayer$playAnim$2 extends Lambda implements Function3<String, String, String, Unit> {
    final /* synthetic */ Mp4EnhancedEnterPlayer$playAnim$1 $finished$1;
    final /* synthetic */ k32.a $msg;

    public Mp4EnhancedEnterPlayer$playAnim$2(Mp4EnhancedEnterPlayer$playAnim$1 r1, k32.a r2) {
        this.$finished$1 = r1;
        this.$msg = r2;
        super(3);
    }

    public final void invoke(String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        ALogger.e("Mp4EnhancedEnterPlayer", "[Failed] " + r6);
        this.$finished$1.m659invoke();
        RevenueUtils.b r0 = RevenueUtils.i;
        k32.a r1 = this.$msg;
        JSONObject r9 = UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("enter_type", 9), TuplesKt.to("dress_id", r7), TuplesKt.to("resource_id", r8)});
        r0.getClass();
        RevenueUtils.b.d(r1, "user_enter_play", true, r6, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((String) r1, (String) r2, (String) r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void invoke$default(Mp4EnhancedEnterPlayer$playAnim$2 r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.invoke(r2, r3, r4);
    }
}
