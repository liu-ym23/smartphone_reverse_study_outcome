package com.ss.android.lark.picker.base.widget;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J$\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0014JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\fHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItem;", "", "item", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "matcher", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", AppbrandHostConstants.Schema_Meta.NAME, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY, "", "insertPosition", "", "<init>", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)V", "getItem", "()Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getMatcher", "()Lkotlin/jvm/functions/Function1;", "getInsertPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItem;", "equals", "other", "hashCode", "toString", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class CustomSearchResultItem {
    private final Integer insertPosition;
    private final SearchBaseInfo item;
    private final Function1<String, Boolean> matcher;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomSearchResultItem copy$default(CustomSearchResultItem r0, SearchBaseInfo r1, Function1 r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.item;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.matcher;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.insertPosition;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final SearchBaseInfo component1() {
        return this.item;
    }

    public final Function1<String, Boolean> component2() {
        return this.matcher;
    }

    public final Integer component3() {
        return this.insertPosition;
    }

    public final CustomSearchResultItem copy(SearchBaseInfo r2, Function1<? super String, Boolean> r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "matcher");
        return new CustomSearchResultItem(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CustomSearchResultItem) == true) goto L8;
        return false;
    L8:
        CustomSearchResultItem r6 = (CustomSearchResultItem) r5;
        if (Intrinsics.areEqual(this.item, r6.item) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.matcher, r6.matcher) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.insertPosition, r6.insertPosition) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.item.hashCode() * 31) + this.matcher.hashCode()) * 31;
        Integer r1 = this.insertPosition;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "CustomSearchResultItem(item=" + this.item + ", matcher=" + this.matcher + ", insertPosition=" + this.insertPosition + ')';
    }

    public final Integer getInsertPosition() {
        return this.insertPosition;
    }

    public final SearchBaseInfo getItem() {
        return this.item;
    }

    public final Function1<String, Boolean> getMatcher() {
        return this.matcher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomSearchResultItem(SearchBaseInfo r2, Function1<? super String, Boolean> r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "matcher");
        this.item = r2;
        this.matcher = r3;
        this.insertPosition = r4;
    }

    public /* synthetic */ CustomSearchResultItem(SearchBaseInfo r1, Function1 r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = AnonymousClass1.INSTANCE;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }
}
