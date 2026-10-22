package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eRA\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0000\u0012\u001e\u0012\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\u0004\u0012\u00020\u00070\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopMarketingViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lkotlin/Pair;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftMarketingInfo$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getGiftMarketingInfo", "()Lcom/bytedance/android/anya/r0;", "giftMarketingInfo", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTopMarketingViewState extends MVIState<GiftTopMarketingViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty giftMarketingInfo$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTopMarketingViewState.class, "giftMarketingInfo", "getGiftMarketingInfo()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftTopMarketingViewState, Pair<Map<String, Object>, Boolean>> getGiftMarketingInfo() {
        return (r0) this.giftMarketingInfo$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public GiftTopMarketingViewState() {
        Pair r0 = new Pair(MapsKt.emptyMap(), Boolean.FALSE);
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        ((c) r1).a = $$delegatedProperties[0].getName();
        r3.invoke(r1);
        this.giftMarketingInfo$delegate = r1;
    }
}
