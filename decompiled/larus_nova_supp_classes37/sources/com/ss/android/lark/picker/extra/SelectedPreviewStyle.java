package com.ss.android.lark.picker.extra;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle;", "", "<init>", "()V", "PreviewList", "SelectedNumber", "Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle$PreviewList;", "Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle$SelectedNumber;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class SelectedPreviewStyle {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle$PreviewList;", "Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class PreviewList extends SelectedPreviewStyle {
        public static final PreviewList INSTANCE = null;

        static {
            INSTANCE = new PreviewList();
        }

        private PreviewList() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle$SelectedNumber;", "Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle;", "updateListener", "Lcom/ss/android/lark/picker/extra/OnNumberUpdateListener;", "<init>", "(Lcom/ss/android/lark/picker/extra/OnNumberUpdateListener;)V", "getUpdateListener", "()Lcom/ss/android/lark/picker/extra/OnNumberUpdateListener;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class SelectedNumber extends SelectedPreviewStyle {
        private final OnNumberUpdateListener updateListener;

        public static /* synthetic */ SelectedNumber copy$default(SelectedNumber r0, OnNumberUpdateListener r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.updateListener;
        L6:
            return r0.copy(r1);
        }

        public final OnNumberUpdateListener component1() {
            return this.updateListener;
        }

        public final SelectedNumber copy(OnNumberUpdateListener r2) {
            Intrinsics.checkNotNullParameter(r2, "updateListener");
            return new SelectedNumber(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof SelectedNumber) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.updateListener, ((SelectedNumber) r4).updateListener) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.updateListener.hashCode();
        }

        public String toString() {
            return "SelectedNumber(updateListener=" + this.updateListener + ')';
        }

        public final OnNumberUpdateListener getUpdateListener() {
            return this.updateListener;
        }

        public SelectedNumber(OnNumberUpdateListener r2) {
            Intrinsics.checkNotNullParameter(r2, "updateListener");
            super(null);
            this.updateListener = r2;
        }
    }

    private SelectedPreviewStyle() {
    }

    public /* synthetic */ SelectedPreviewStyle(DefaultConstructorMarker r1) {
        this();
    }
}
