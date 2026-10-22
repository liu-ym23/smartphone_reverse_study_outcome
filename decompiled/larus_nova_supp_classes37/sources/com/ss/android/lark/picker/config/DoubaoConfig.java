package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@PickerMaker
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/picker/config/DoubaoConfig;", "", "<init>", "()V", "bottomBarConfig", "Lcom/ss/android/lark/picker/config/DoubaoConfig$BottomBarConfig;", "getBottomBarConfig", "()Lcom/ss/android/lark/picker/config/DoubaoConfig$BottomBarConfig;", "setBottomBarConfig", "(Lcom/ss/android/lark/picker/config/DoubaoConfig$BottomBarConfig;)V", "onBottomBarActionListener", "Lcom/ss/android/lark/picker/config/DoubaoConfig$OnBottomBarActionListener;", "getOnBottomBarActionListener", "()Lcom/ss/android/lark/picker/config/DoubaoConfig$OnBottomBarActionListener;", "setOnBottomBarActionListener", "(Lcom/ss/android/lark/picker/config/DoubaoConfig$OnBottomBarActionListener;)V", "BottomBarConfig", "OnBottomBarActionListener", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoConfig {
    private BottomBarConfig bottomBarConfig;
    private transient OnBottomBarActionListener onBottomBarActionListener;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/android/lark/picker/config/DoubaoConfig$BottomBarConfig;", "", "selectedTextTemplate", "", "actionText", "showWhenEmpty", "", "showSelectedAvatarList", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getSelectedTextTemplate", "()Ljava/lang/String;", "setSelectedTextTemplate", "(Ljava/lang/String;)V", "getActionText", "setActionText", "getShowWhenEmpty", "()Z", "setShowWhenEmpty", "(Z)V", "getShowSelectedAvatarList", "setShowSelectedAvatarList", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class BottomBarConfig {
        private String actionText;
        private String selectedTextTemplate;
        private boolean showSelectedAvatarList;
        private boolean showWhenEmpty;

        public BottomBarConfig() {
            this(null, null, false, false, 15, null);
        }

        public static /* synthetic */ BottomBarConfig copy$default(BottomBarConfig r0, String r1, String r2, boolean r3, boolean r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.selectedTextTemplate;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.actionText;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.showWhenEmpty;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.showSelectedAvatarList;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.selectedTextTemplate;
        }

        public final String component2() {
            return this.actionText;
        }

        public final boolean component3() {
            return this.showWhenEmpty;
        }

        public final boolean component4() {
            return this.showSelectedAvatarList;
        }

        public final BottomBarConfig copy(String r2, String r3, boolean r4, boolean r5) {
            return new BottomBarConfig(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof BottomBarConfig) == true) goto L8;
            return false;
        L8:
            BottomBarConfig r6 = (BottomBarConfig) r5;
            if (Intrinsics.areEqual(this.selectedTextTemplate, r6.selectedTextTemplate) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.actionText, r6.actionText) == true) goto L15;
            return false;
        L15:
            if (this.showWhenEmpty == r6.showWhenEmpty) goto L18;
            return false;
        L18:
            if (this.showSelectedAvatarList == r6.showSelectedAvatarList) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r0 = this.selectedTextTemplate;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.actionText;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            int r5 = (r3 + r1) * 31;
            int r6 = 1231;
            if (this.showWhenEmpty == false) goto L13;
            int r7 = 1231;
        L14:
            int r8 = (r5 + r7) * 31;
            if (this.showSelectedAvatarList == true) goto L19;
            r6 = 1237;
        L19:
            return r8 + r6;
        L13:
            r7 = 1237;
            goto L14
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "BottomBarConfig(selectedTextTemplate=" + this.selectedTextTemplate + ", actionText=" + this.actionText + ", showWhenEmpty=" + this.showWhenEmpty + ", showSelectedAvatarList=" + this.showSelectedAvatarList + ')';
        }

        public final String getActionText() {
            return this.actionText;
        }

        public final String getSelectedTextTemplate() {
            return this.selectedTextTemplate;
        }

        public final boolean getShowSelectedAvatarList() {
            return this.showSelectedAvatarList;
        }

        public final boolean getShowWhenEmpty() {
            return this.showWhenEmpty;
        }

        public final void setActionText(String r1) {
            this.actionText = r1;
        }

        public final void setSelectedTextTemplate(String r1) {
            this.selectedTextTemplate = r1;
        }

        public final void setShowSelectedAvatarList(boolean r1) {
            this.showSelectedAvatarList = r1;
        }

        public final void setShowWhenEmpty(boolean r1) {
            this.showWhenEmpty = r1;
        }

        public BottomBarConfig(String r1, String r2, boolean r3, boolean r4) {
            this.selectedTextTemplate = r1;
            this.actionText = r2;
            this.showWhenEmpty = r3;
            this.showSelectedAvatarList = r4;
        }

        public /* synthetic */ BottomBarConfig(String r2, String r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = false;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = false;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/config/DoubaoConfig$OnBottomBarActionListener;", "", "onActionClick", "", "selectedItems", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface OnBottomBarActionListener {
        void onActionClick(List<? extends SearchBaseInfo> r1);
    }

    public DoubaoConfig() {
    }

    public final BottomBarConfig getBottomBarConfig() {
        return this.bottomBarConfig;
    }

    public final OnBottomBarActionListener getOnBottomBarActionListener() {
        return this.onBottomBarActionListener;
    }

    public final void setBottomBarConfig(BottomBarConfig r1) {
        this.bottomBarConfig = r1;
    }

    public final void setOnBottomBarActionListener(OnBottomBarActionListener r1) {
        this.onBottomBarActionListener = r1;
    }
}
