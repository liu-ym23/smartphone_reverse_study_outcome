package com.ss.android.lark.picker.base.widget.utils;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchLoadingFooterInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0015\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/utils/PickerDataUtils;", "", "<init>", "()V", "TAG", "", "ERROR_CODE_SERVER_ERROR", "", "ERROR_CODE_OFFLINE", "ERROR_CODE_NETWORK", "ERROR_CODE_TIMEOUT", "mergeSearchResultLists", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "oldData", "newData", "isNetSearchError", "", "errorCode", "(Ljava/lang/Integer;)Z", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickerDataUtils {
    private static final int ERROR_CODE_NETWORK = 100053;
    private static final int ERROR_CODE_OFFLINE = 100052;
    private static final int ERROR_CODE_SERVER_ERROR = 100012;
    private static final int ERROR_CODE_TIMEOUT = 100054;
    public static final PickerDataUtils INSTANCE = null;
    private static final String TAG = "PickerDataUtils";

    static {
        INSTANCE = new PickerDataUtils();
    }

    private PickerDataUtils() {
    }

    public final boolean isNetSearchError(Integer r3) {
        if (r3 != null) goto L5;
    L6:
        if (r3 != null) goto L9;
    L10:
        if (r3 != null) goto L13;
    L14:
        if (r3 != null) goto L17;
    L19:
        return false;
    L17:
        if (r3.intValue() != ERROR_CODE_TIMEOUT) goto L19;
    L20:
        return true;
    L13:
        if (r3.intValue() == ERROR_CODE_NETWORK) goto L20;
    L9:
        if (r3.intValue() == ERROR_CODE_OFFLINE) goto L20;
    L5:
        if (r3.intValue() == ERROR_CODE_SERVER_ERROR) goto L20;
        goto L6
    }

    public final List<SearchBaseInfo> mergeSearchResultLists(List<? extends SearchBaseInfo> r6, List<? extends SearchBaseInfo> r7) {
        Intrinsics.checkNotNullParameter(r6, "oldData");
        Intrinsics.checkNotNullParameter(r7, "newData");
        ArrayList r0 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r1 = r8.next();
        if ((!(((SearchBaseInfo) r1) instanceof SearchLoadingFooterInfo)) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        List<SearchBaseInfo> r9 = CollectionsKt.toMutableList(r0);
        List<SearchBaseInfo> r2 = r9;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        r3.add(((SearchBaseInfo) r4.next()).getId());
        goto L10
    L12:
        StringBuilder r5 = new StringBuilder("old: ");
        r5.append(r3);
        r5.append(" , new: ");
        List<? extends SearchBaseInfo> r10 = r7;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        r11.add(((SearchBaseInfo) r12.next()).getId());
        goto L14
    L16:
        r5.append(r11);
        Log.i(TAG, r5.toString());
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r10.iterator();
    L18:
        if (r14.hasNext() == false) goto L22;
        Object r15 = r14.next();
        if ((!r3.contains(((SearchBaseInfo) r15).getId())) == false) goto L18;
        r13.add(r15);
        goto L18
    L22:
        CollectionsKt.addAll(r9, r13);
        return r9;
    }
}
