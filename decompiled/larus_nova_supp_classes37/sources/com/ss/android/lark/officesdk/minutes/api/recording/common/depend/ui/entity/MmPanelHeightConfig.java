package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "Ljava/io/Serializable;", "<init>", "()V", "ScreenTopMargin", "Fixed", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig$Fixed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig$ScreenTopMargin;", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class MmPanelHeightConfig implements Serializable {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig$Fixed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "heightPx", "", "isExpanded", "", "<init>", "(IZ)V", "getHeightPx", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Fixed extends MmPanelHeightConfig {
        private final int heightPx;
        private final boolean isExpanded;

        public static /* synthetic */ Fixed copy$default(Fixed r0, int r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.heightPx;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.isExpanded;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.heightPx;
        }

        public final boolean component2() {
            return this.isExpanded;
        }

        public final Fixed copy(int r2, boolean r3) {
            return new Fixed(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Fixed) == true) goto L8;
            return false;
        L8:
            Fixed r6 = (Fixed) r5;
            if (this.heightPx == r6.heightPx) goto L12;
            return false;
        L12:
            if (this.isExpanded == r6.isExpanded) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.heightPx * 31;
            if (this.isExpanded == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public String toString() {
            return "Fixed(heightPx=" + this.heightPx + ", isExpanded=" + this.isExpanded + ')';
        }

        public final int getHeightPx() {
            return this.heightPx;
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }

        public Fixed(int r2, boolean r3) {
            super(null);
            this.heightPx = r2;
            this.isExpanded = r3;
        }

        public /* synthetic */ Fixed(int r1, boolean r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = true;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig$ScreenTopMargin;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "marginPx", "", "isExpanded", "", "<init>", "(IZ)V", "getMarginPx", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class ScreenTopMargin extends MmPanelHeightConfig {
        private final boolean isExpanded;
        private final int marginPx;

        public static /* synthetic */ ScreenTopMargin copy$default(ScreenTopMargin r0, int r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.marginPx;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.isExpanded;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.marginPx;
        }

        public final boolean component2() {
            return this.isExpanded;
        }

        public final ScreenTopMargin copy(int r2, boolean r3) {
            return new ScreenTopMargin(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ScreenTopMargin) == true) goto L8;
            return false;
        L8:
            ScreenTopMargin r6 = (ScreenTopMargin) r5;
            if (this.marginPx == r6.marginPx) goto L12;
            return false;
        L12:
            if (this.isExpanded == r6.isExpanded) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.marginPx * 31;
            if (this.isExpanded == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public String toString() {
            return "ScreenTopMargin(marginPx=" + this.marginPx + ", isExpanded=" + this.isExpanded + ')';
        }

        public final int getMarginPx() {
            return this.marginPx;
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }

        public ScreenTopMargin(int r2, boolean r3) {
            super(null);
            this.marginPx = r2;
            this.isExpanded = r3;
        }

        public /* synthetic */ ScreenTopMargin(int r1, boolean r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = true;
        L5:
            this(r1, r2);
        }
    }

    private MmPanelHeightConfig() {
    }

    public /* synthetic */ MmPanelHeightConfig(DefaultConstructorMarker r1) {
        this();
    }
}
