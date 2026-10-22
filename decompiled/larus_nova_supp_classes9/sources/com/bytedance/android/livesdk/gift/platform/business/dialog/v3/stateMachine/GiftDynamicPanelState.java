package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R5\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0000\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDynamicPanelState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "showParams$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getShowParams", "()Lcom/bytedance/android/anya/r0;", "showParams", BuildConfig.FLAVOR, "needHideOperation$delegate", "getNeedHideOperation", "needHideOperation", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftDynamicPanelState extends MVIState<GiftDynamicPanelState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty needHideOperation$delegate;
    private final ReadOnlyProperty showParams$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftDynamicPanelState.class, "showParams", "getShowParams()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDynamicPanelState.class, "needHideOperation", "getNeedHideOperation()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftDynamicPanelState, Boolean> getNeedHideOperation() {
        return (r0) this.needHideOperation$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftDynamicPanelState, Map<String, Object>> getShowParams() {
        return (r0) this.showParams$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public GiftDynamicPanelState() {
        Map r0 = MapsKt.emptyMap();
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.showParams$delegate = r1;
        Boolean r5 = Boolean.FALSE;
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        r r8 = new r(r5, r6, r7);
        ((c) r8).a = r4[1].getName();
        r7.invoke(r8);
        this.needHideOperation$delegate = r8;
    }
}
