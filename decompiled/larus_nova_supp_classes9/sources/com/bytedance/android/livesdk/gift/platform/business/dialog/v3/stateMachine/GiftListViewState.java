package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.u0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListViewState$Mode;", "mode$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getMode", "()Lcom/bytedance/android/anya/r0;", "mode", "Lcom/bytedance/android/anya/u0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftVerticalState;", "verticalStyleState$delegate", "getVerticalStyleState", "()Lcom/bytedance/android/anya/u0;", "verticalStyleState", "<init>", "()V", "Mode", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftListViewState extends MVIState<GiftListViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty mode$delegate;
    private final ReadOnlyProperty verticalStyleState$delegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListViewState$Mode;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "LandscapeStyle", "VerticalStyle", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode LandscapeStyle = null;
        public static final Mode VerticalStyle = null;

        static {
            Mode r1 = new Mode("LandscapeStyle", 0);
            LandscapeStyle = r1;
            Mode r2 = new Mode("VerticalStyle", 1);
            VerticalStyle = r2;
            $VALUES = new Mode[]{r1, r2};
        }

        public static Mode valueOf(String r1) {
            return (Mode) a.a(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftListViewState.class, "mode", "getMode()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftListViewState.class, "verticalStyleState", "getVerticalStyleState()Lcom/bytedance/android/anya/SubStateProperty;", 0))};
    }

    public final r0<GiftListViewState, Mode> getMode() {
        return (r0) this.mode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final u0<GiftListViewState, GiftVerticalState> getVerticalStyleState() {
        return (u0) this.verticalStyleState$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public GiftListViewState() {
        Mode r0 = Mode.VerticalStyle;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.mode$delegate = r1;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r7 = new SubStatePropertyImpl(GiftVerticalState.class, null, r5, r6);
        ((c) r7).a = r4[1].getName();
        r6.invoke(r7);
        this.verticalStyleState$delegate = r7;
    }
}
