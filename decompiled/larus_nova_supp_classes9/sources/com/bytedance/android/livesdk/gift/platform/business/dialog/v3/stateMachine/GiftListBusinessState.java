package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.r;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vz1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState;", "Lcom/bytedance/android/anya/r;", "<init>", "()V", "GiftCombo", "GiftSelected", "Idle", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$GiftCombo;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$GiftSelected;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$Idle;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class GiftListBusinessState implements r {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$GiftCombo;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState;", BuildConfig.FLAVOR, "selectedPagePosition", "I", "getSelectedPagePosition", "()I", "position", "getPosition", "comboNum", "getComboNum", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "currentStatus", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "getCurrentStatus", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "Lvz1/e;", "iconModel", "Lvz1/e;", "getIconModel", "()Lvz1/e;", "selectCounterPosition", "getSelectCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "<init>", "(IIILcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;Lvz1/e;II)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GiftCombo extends GiftListBusinessState {
        private final int comboNum;
        private final ComboState currentStatus;
        private final e iconModel;
        private final int position;
        private final int selectCounterPosition;
        private final int selectedPagePosition;
        private final int topicPagerPosition;

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

        public final int getSelectCounterPosition() {
            return this.selectCounterPosition;
        }

        public final int getSelectedPagePosition() {
            return this.selectedPagePosition;
        }

        public final int getTopicPagerPosition() {
            return this.topicPagerPosition;
        }

        public GiftCombo(int r2, int r3, int r4, ComboState r5, e r6, int r7, int r8) {
            Intrinsics.checkNotNullParameter(r5, "currentStatus");
            super(null);
            this.selectedPagePosition = r2;
            this.position = r3;
            this.comboNum = r4;
            this.currentStatus = r5;
            this.iconModel = r6;
            this.selectCounterPosition = r7;
            this.topicPagerPosition = r8;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$GiftSelected;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState;", BuildConfig.FLAVOR, "selectedPagePosition", "I", "getSelectedPagePosition", "()I", "selectedPosition", "getSelectedPosition", "Lvz1/e;", "iconModel", "Lvz1/e;", "getIconModel", "()Lvz1/e;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "selectedStatus", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "getSelectedStatus", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "selectCounterPosition", "getSelectCounterPosition", "topicPagerPosition", "getTopicPagerPosition", BuildConfig.FLAVOR, "selectedTopicId", "J", "getSelectedTopicId", "()J", "visualStatus", "getVisualStatus", "<init>", "(IILvz1/e;Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;IIJI)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GiftSelected extends GiftListBusinessState {
        private final e iconModel;
        private final int selectCounterPosition;
        private final int selectedPagePosition;
        private final int selectedPosition;
        private final SelectedStatus selectedStatus;
        private final long selectedTopicId;
        private final int topicPagerPosition;
        private final int visualStatus;

        public final e getIconModel() {
            return this.iconModel;
        }

        public final int getSelectCounterPosition() {
            return this.selectCounterPosition;
        }

        public final int getSelectedPagePosition() {
            return this.selectedPagePosition;
        }

        public final int getSelectedPosition() {
            return this.selectedPosition;
        }

        public final SelectedStatus getSelectedStatus() {
            return this.selectedStatus;
        }

        public final long getSelectedTopicId() {
            return this.selectedTopicId;
        }

        public final int getTopicPagerPosition() {
            return this.topicPagerPosition;
        }

        public final int getVisualStatus() {
            return this.visualStatus;
        }

        public GiftSelected(int r2, int r3, e r4, SelectedStatus r5, int r6, int r7, long r8, int r10) {
            Intrinsics.checkNotNullParameter(r5, "selectedStatus");
            super(null);
            this.selectedPagePosition = r2;
            this.selectedPosition = r3;
            this.iconModel = r4;
            this.selectedStatus = r5;
            this.selectCounterPosition = r6;
            this.topicPagerPosition = r7;
            this.selectedTopicId = r8;
            this.visualStatus = r10;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$Idle;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState;", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Idle extends GiftListBusinessState {
        public Idle() {
            super(null);
        }
    }

    private GiftListBusinessState() {
    }

    public /* synthetic */ GiftListBusinessState(DefaultConstructorMarker r1) {
        this();
    }
}
