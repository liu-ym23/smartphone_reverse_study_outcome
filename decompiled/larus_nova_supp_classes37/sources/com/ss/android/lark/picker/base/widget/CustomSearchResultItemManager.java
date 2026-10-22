package com.ss.android.lark.picker.base.widget;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItemManager;", "", "<init>", "()V", "items", "", "Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItem;", "attach", "", "customItem", "clear", "applyToResponse", "response", "Lcom/ss/android/lark/search/dto/SearchResponse;", "isFromSpotlight", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class CustomSearchResultItemManager {
    private final List<CustomSearchResultItem> items;

    public final void clear() {
        if ((!this.items.isEmpty()) == false) goto L5;
        Log.i("CustomSearchResultItemManager", "clear custom search result items: count=" + this.items.size());
    L5:
        this.items.clear();
    }

    public CustomSearchResultItemManager() {
        this.items = new ArrayList();
    }

    public final void attach(final CustomSearchResultItem r3) {
        Intrinsics.checkNotNullParameter(r3, "customItem");
        CollectionsKt.removeAll(this.items, new AnonymousClass1(r3));
        this.items.add(r3);
        StringBuilder r0 = new StringBuilder("attach custom search result item: hasItemId=");
        r0.append(!StringsKt.isBlank(r3.getItem().getId()));
        r0.append(", itemType=");
        r0.append(r3.getItem().getType());
        r0.append(", insertPosition=");
        r0.append(r3.getInsertPosition());
        r0.append(", total=");
        r0.append(this.items.size());
        Log.i("CustomSearchResultItemManager", r0.toString());
    }

    public final void applyToResponse(SearchResponse r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "response");
        if (this.items.isEmpty() == false) goto L6;
        return;
    L6:
        if (r7 == false) goto L9;
        Log.i("CustomSearchResultItemManager", "skip custom search result items for spotlight response: customCount=" + this.items.size());
        return;
    L9:
        String r8 = r6.getQuery();
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        List r1 = r6.getInfoList();
        if (r1 != null) goto L15;
        r1 = CollectionsKt.emptyList();
    L15:
        List<SearchBaseInfo> r2 = CustomSearchResultItemManagerKt.mergeCustomSearchResultItems(r1, this.items, r8);
        if (r2 != r6.getInfoList()) goto L18;
        return;
    L18:
        Log.i("CustomSearchResultItemManager", "apply custom search result items: originalSize=" + r1.size() + ", customCount=" + this.items.size() + ", resultSize=" + r2.size() + ", queryLength=" + r8.length());
        r6.setInfoList(r2);
    }

    public static /* synthetic */ void applyToResponse$default(CustomSearchResultItemManager r0, SearchResponse r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.applyToResponse(r1, r2);
    }
}
