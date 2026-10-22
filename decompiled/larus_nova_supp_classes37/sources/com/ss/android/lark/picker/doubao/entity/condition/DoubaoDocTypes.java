package com.ss.android.lark.picker.doubao.entity.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0017\b\u0004\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes;", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocCondition;", "types", "", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocType;", "<init>", "(Ljava/util/Set;)V", "getTypes", "()Ljava/util/Set;", "NONE", "NEW", "ALL", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes$ALL;", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes$NEW;", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes$NONE;", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class DoubaoDocTypes implements DoubaoDocCondition {
    private final Set<DoubaoDocType> types;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes$ALL;", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class ALL extends DoubaoDocTypes {
        public static final ALL INSTANCE = null;

        static {
            INSTANCE = new ALL();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof ALL) == true) goto L9;
            return false;
        L9:
            ALL r4 = (ALL) r3;
            return true;
        }

        public int hashCode() {
            return -2075247408;
        }

        public String toString() {
            return "ALL";
        }

        private ALL() {
            super(ArraysKt.toSet(DoubaoDocType.values()), null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes$NEW;", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes;", "types", "", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocType;", "<init>", "(Ljava/util/Set;)V", "getTypes", "()Ljava/util/Set;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class NEW extends DoubaoDocTypes {
        private final Set<DoubaoDocType> types;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NEW copy$default(NEW r0, Set r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.types;
        L6:
            return r0.copy(r1);
        }

        public final Set<DoubaoDocType> component1() {
            return this.types;
        }

        public final NEW copy(Set<? extends DoubaoDocType> r2) {
            Intrinsics.checkNotNullParameter(r2, "types");
            return new NEW(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof NEW) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.types, ((NEW) r4).types) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.types.hashCode();
        }

        public String toString() {
            return "NEW(types=" + this.types + ')';
        }

        @Override // com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocTypes
        public Set<DoubaoDocType> getTypes() {
            return this.types;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NEW(Set<? extends DoubaoDocType> r2) {
            Intrinsics.checkNotNullParameter(r2, "types");
            super(r2, null);
            this.types = r2;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes$NONE;", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class NONE extends DoubaoDocTypes {
        public static final NONE INSTANCE = null;

        static {
            INSTANCE = new NONE();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof NONE) == true) goto L9;
            return false;
        L9:
            NONE r4 = (NONE) r3;
            return true;
        }

        public int hashCode() {
            return 92230089;
        }

        public String toString() {
            return "NONE";
        }

        private NONE() {
            super(SetsKt.emptySet(), null);
        }
    }

    public /* synthetic */ DoubaoDocTypes(Set r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public Set<DoubaoDocType> getTypes() {
        return this.types;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DoubaoDocTypes(Set<? extends DoubaoDocType> r1) {
        this.types = r1;
    }
}
