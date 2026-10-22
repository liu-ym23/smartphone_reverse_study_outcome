package com.bytedance.android.live.recharge.model.diamond;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/model/diamond/b;", "Lvh7/c;", "Lcom/bytedance/android/live/recharge/model/diamond/d;", "getGemExchangeCouponInfo", "()Lcom/bytedance/android/live/recharge/model/diamond/d;", "getGemExchangeCouponInfo$annotations", "()V", "gemExchangeCouponInfo", "Companion", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.c<b> {
    public static final a Companion = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.model.diamond.b$b, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0065b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "allow_gem_exchange_coupon")
    d getGemExchangeCouponInfo();
}
