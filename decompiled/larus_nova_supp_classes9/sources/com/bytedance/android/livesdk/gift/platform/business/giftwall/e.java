package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ GiftWallPreRequestManager a;

    public e(GiftWallPreRequestManager r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        ExtraResponse r5 = (ExtraResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        final JsonObject r6 = (JsonObject) r5.data;
        final GiftWallPreRequestManager r0 = this.a;
        r0.getClass();
        f r1 = f.a;
        Function0<Unit> r2 = new GiftWallPreRequestManager$convertRareGiftImageUrl$1(r0, r6);
        r1.getClass();
        f.b(r2);
        return r6;
    }
}
