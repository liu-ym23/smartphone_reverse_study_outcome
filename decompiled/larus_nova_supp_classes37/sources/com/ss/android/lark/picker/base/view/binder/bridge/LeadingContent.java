package com.ss.android.lark.picker.base.view.binder.bridge;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "", "<init>", "()V", "Avatar", "Icon", "Initial", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Avatar;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Icon;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Initial;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class LeadingContent {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Avatar;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "key", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Avatar extends LeadingContent {
        private final String id;
        private final String key;

        public static /* synthetic */ Avatar copy$default(Avatar r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.key;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.id;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.key;
        }

        public final String component2() {
            return this.id;
        }

        public final Avatar copy(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "id");
            return new Avatar(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Avatar) == true) goto L8;
            return false;
        L8:
            Avatar r6 = (Avatar) r5;
            if (Intrinsics.areEqual(this.key, r6.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.id, r6.id) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.id.hashCode();
        }

        public String toString() {
            return "Avatar(key=" + this.key + ", id=" + this.id + ')';
        }

        public final String getId() {
            return this.id;
        }

        public final String getKey() {
            return this.key;
        }

        public Avatar(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "id");
            super(null);
            this.key = r2;
            this.id = r3;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Icon;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "resId", "", "<init>", "(I)V", "getResId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Icon extends LeadingContent {
        private final int resId;

        public static /* synthetic */ Icon copy$default(Icon r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.resId;
        L6:
            return r0.copy(r1);
        }

        public final int component1() {
            return this.resId;
        }

        public final Icon copy(int r2) {
            return new Icon(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Icon) == true) goto L9;
            return false;
        L9:
            if (this.resId == ((Icon) r4).resId) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.resId;
        }

        public String toString() {
            return "Icon(resId=" + this.resId + ')';
        }

        public final int getResId() {
            return this.resId;
        }

        public Icon(int r2) {
            super(null);
            this.resId = r2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Initial;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Initial extends LeadingContent {
        private final String text;

        public static /* synthetic */ Initial copy$default(Initial r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.text;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.text;
        }

        public final Initial copy(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            return new Initial(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Initial) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.text, ((Initial) r4).text) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "Initial(text=" + this.text + ')';
        }

        public final String getText() {
            return this.text;
        }

        public Initial(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            super(null);
            this.text = r2;
        }
    }

    private LeadingContent() {
    }

    public /* synthetic */ LeadingContent(DefaultConstructorMarker r1) {
        this();
    }
}
