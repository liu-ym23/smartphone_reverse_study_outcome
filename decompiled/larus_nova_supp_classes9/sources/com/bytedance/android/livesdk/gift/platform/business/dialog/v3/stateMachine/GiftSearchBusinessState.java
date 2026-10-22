package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.r;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vz1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState;", "Lcom/bytedance/android/anya/r;", "<init>", "()V", "GiftCombo", "GiftSelected", "Idle", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState$GiftCombo;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState$GiftSelected;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState$Idle;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class GiftSearchBusinessState implements r {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState$GiftCombo;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState;", BuildConfig.FLAVOR, "position", "I", "getPosition", "()I", "comboNum", "getComboNum", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "currentStatus", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "getCurrentStatus", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "Lvz1/e;", "iconModel", "Lvz1/e;", "getIconModel", "()Lvz1/e;", "<init>", "(IILcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;Lvz1/e;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GiftCombo extends GiftSearchBusinessState {
        private final int comboNum;
        private final ComboState currentStatus;
        private final e iconModel;
        private final int position;

        public final int getComboNum() {
            return this.comboNum;
        }

        public final ComboState getCurrentStatus() {
            return this.currentStatus;
        }

        public final e getIconModel() {
            return this.iconModel;
        }

        public final int getPosition() {
            return this.position;
        }

        public GiftCombo(int r2, int r3, ComboState r4, e r5) {
            Intrinsics.checkNotNullParameter(r4, "currentStatus");
            super(null);
            this.position = r2;
            this.comboNum = r3;
            this.currentStatus = r4;
            this.iconModel = r5;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState$GiftSelected;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState;", BuildConfig.FLAVOR, "selectedPosition", "I", "getSelectedPosition", "()I", "Lvz1/e;", "iconModel", "Lvz1/e;", "getIconModel", "()Lvz1/e;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "selectedStatus", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "getSelectedStatus", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "selectedVisualStatus", "getSelectedVisualStatus", "<init>", "(ILvz1/e;Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GiftSelected extends GiftSearchBusinessState {
        private final e iconModel;
        private final int selectedPosition;
        private final SelectedStatus selectedStatus;
        private final int selectedVisualStatus;

        public final e getIconModel() {
            return this.iconModel;
        }

        public final int getSelectedPosition() {
            return this.selectedPosition;
        }

        public final SelectedStatus getSelectedStatus() {
            return this.selectedStatus;
        }

        public final int getSelectedVisualStatus() {
            return this.selectedVisualStatus;
        }

        public GiftSelected(int r2, e r3, SelectedStatus r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "selectedStatus");
            super(null);
            this.selectedPosition = r2;
            this.iconModel = r3;
            this.selectedStatus = r4;
            this.selectedVisualStatus = r5;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState$Idle;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState;", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Idle extends GiftSearchBusinessState {
        public Idle() {
            super(null);
        }
    }

    private GiftSearchBusinessState() {
    }

    public /* synthetic */ GiftSearchBusinessState(DefaultConstructorMarker r1) {
        this();
    }
}
