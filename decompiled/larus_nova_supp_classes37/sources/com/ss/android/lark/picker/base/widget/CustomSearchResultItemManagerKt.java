package com.ss.android.lark.picker.base.widget;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u001f\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"TAG", "", "mergeCustomSearchResultItems", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "original", "", "customItems", "Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItem;", AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY, "resolveCustomSearchResultInsertIndex", "", "currentSize", "insertPosition", "(ILjava/lang/Integer;)I", "picker-base_release"}, k = 2, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class CustomSearchResultItemManagerKt {
    private static final String TAG = "CustomSearchResultItemManager";

    private static final int resolveCustomSearchResultInsertIndex(int r1, Integer r2) {
        int r0 = 0;
        if (r2 == null) goto L6;
        r0 = RangesKt.coerceAtLeast(r2.intValue() - 1, 0);
    L6:
        return RangesKt.coerceAtMost(r0, r1);
    }

    public static final List<SearchBaseInfo> mergeCustomSearchResultItems(List<? extends SearchBaseInfo> r10, List<CustomSearchResultItem> r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "original");
        Intrinsics.checkNotNullParameter(r11, "customItems");
        Intrinsics.checkNotNullParameter(r12, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
        ArrayList r0 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        Object r1 = r13.next();
        if (((Boolean) ((CustomSearchResultItem) r1).getMatcher().invoke(r12)).booleanValue() == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L16;
        if (TypeIntrinsics.isMutableList(r10) == false) goto L14;
        return r10;
    L14:
        return CollectionsKt.toMutableList(r10);
    L16:
        if (TypeIntrinsics.isMutableList(r10) == false) goto L18;
        List<? extends SearchBaseInfo> r14 = r10;
    L19:
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r3 = r0.iterator();
    L21:
        if (r3.hasNext() == false) goto L23;
        r2.add(((CustomSearchResultItem) r3.next()).getItem().getId());
        goto L21
    L23:
        final Set r4 = CollectionsKt.toSet(r2);
        int r5 = r14.size();
        CollectionsKt.removeAll(r14, new AnonymousClass1(r4));
        int r6 = r5 - r14.size();
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r0.iterator();
    L25:
        if (r8.hasNext() == false) goto L30;
        Object r9 = r8.next();
        Integer r15 = Integer.valueOf(resolveCustomSearchResultInsertIndex(r14.size(), ((CustomSearchResultItem) r9).getInsertPosition()));
        Object r16 = r7.get(r15);
        if (r16 != null) goto L29;
        r16 = new ArrayList();
        r7.put(r15, r16);
    L29:
        ((List) r16).add(r9);
        goto L25
    L30:
        Iterator r17 = MapsKt.toSortedMap(r7).entrySet().iterator();
        int r18 = 0;
    L32:
        if (r17.hasNext() == false) goto L38;
        Map.Entry r19 = (Map.Entry) r17.next();
        Integer r20 = (Integer) r19.getKey();
        List r21 = (List) r19.getValue();
        int r22 = r20.intValue() + r18;
        Intrinsics.checkNotNull(r21);
        List r23 = r21;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r25 = r23.iterator();
    L35:
        if (r25.hasNext() == false) goto L37;
        r24.add(((CustomSearchResultItem) r25.next()).getItem());
        goto L35
    L37:
        r14.addAll(r22, r24);
        r18 = r18 + r21.size();
        goto L32
    L38:
        Log.i(TAG, "merge custom search result items: originalSize=" + r10.size() + ", matchedCount=" + r0.size() + ", duplicateCount=" + r6 + ", resultSize=" + r14.size() + ", queryLength=" + r12.length());
        return r14;
    L18:
        r14 = CollectionsKt.toMutableList(r10);
        goto L19
    }
}
