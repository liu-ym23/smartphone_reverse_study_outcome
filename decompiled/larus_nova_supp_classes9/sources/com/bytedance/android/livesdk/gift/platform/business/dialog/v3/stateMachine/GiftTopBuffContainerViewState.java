package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopBuffContainerViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowBuffCardData;", "showCard$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getShowCard", "()Lcom/bytedance/android/anya/r0;", "showCard", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTopBuffContainerViewState extends MVIState<GiftTopBuffContainerViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty showCard$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTopBuffContainerViewState.class, "showCard", "getShowCard()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftTopBuffContainerViewState, ShowBuffCardData> getShowCard() {
        return (r0) this.showCard$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public GiftTopBuffContainerViewState() {
        ShowBuffCardData r13 = new ShowBuffCardData(false, null, 0, null, null, null, 0, null, null, null, 1023, null);
        Function1 r1 = ((MVIState) this).propertyChangeCallback;
        Function1 r2 = ((MVIState) this).propertyAddedCallback;
        r r0 = new r(r13, r1, r2);
        ((c) r0).a = $$delegatedProperties[0].getName();
        r2.invoke(r0);
        this.showCard$delegate = r0;
    }
}
