package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.u0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import r27.a;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftReceiverViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftReceiverViewState$Mode;", "mode$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getMode", "()Lcom/bytedance/android/anya/r0;", "mode", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/NewReceiverPanelStatus;", "showNewReceiverPanel$delegate", "getShowNewReceiverPanel", "showNewReceiverPanel", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "receiver$delegate", "getReceiver", "receiver", "Lcom/bytedance/android/anya/u0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftReceiverStateMachineState;", "receiverState$delegate", "getReceiverState", "()Lcom/bytedance/android/anya/u0;", "receiverState", "<init>", "()V", "Mode", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftReceiverViewState extends MVIState<GiftReceiverViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty mode$delegate;
    private final ReadOnlyProperty receiver$delegate;
    private final ReadOnlyProperty receiverState$delegate;
    private final ReadOnlyProperty showNewReceiverPanel$delegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftReceiverViewState$Mode;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "IDLE", "Receiver", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode IDLE = null;
        public static final Mode Receiver = null;

        static {
            Mode r1 = new Mode("IDLE", 0);
            IDLE = r1;
            Mode r2 = new Mode("Receiver", 1);
            Receiver = r2;
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
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftReceiverViewState.class, "mode", "getMode()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverViewState.class, "showNewReceiverPanel", "getShowNewReceiverPanel()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverViewState.class, "receiver", "getReceiver()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverViewState.class, "receiverState", "getReceiverState()Lcom/bytedance/android/anya/SubStateProperty;", 0))};
    }

    public final r0<GiftReceiverViewState, Mode> getMode() {
        return (r0) this.mode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftReceiverViewState, IBaseUser> getReceiver() {
        return (r0) this.receiver$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final u0<GiftReceiverViewState, GiftReceiverStateMachineState> getReceiverState() {
        return (u0) this.receiverState$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftReceiverViewState, NewReceiverPanelStatus> getShowNewReceiverPanel() {
        return (r0) this.showNewReceiverPanel$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public GiftReceiverViewState() {
        Mode r0 = Mode.IDLE;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.mode$delegate = r1;
        NewReceiverPanelStatus r5 = NewReceiverPanelStatus.Idle;
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        r r8 = new r(r5, r6, r7);
        ((c) r8).a = r4[1].getName();
        r7.invoke(r8);
        this.showNewReceiverPanel$delegate = r8;
        vh7.c r9 = f.c(IBaseUser.class);
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        r r13 = new r(r9, r10, r11);
        ((c) r13).a = r4[2].getName();
        r11.invoke(r13);
        this.receiver$delegate = r13;
        Function1 r14 = ((MVIState) this).propertyChangeCallback;
        Function1 r15 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r16 = new SubStatePropertyImpl(GiftReceiverStateMachineState.class, null, r14, r15);
        ((c) r16).a = r4[3].getName();
        r15.invoke(r16);
        this.receiverState$delegate = r16;
    }
}
