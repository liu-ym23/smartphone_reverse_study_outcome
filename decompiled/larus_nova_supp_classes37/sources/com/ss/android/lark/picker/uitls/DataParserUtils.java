package com.ss.android.lark.picker.uitls;

import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/picker/uitls/DataParserUtils;", "", "<init>", "()V", "TAG", "", "appendDeniedReason", "", "result", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "denyReasons", "", "Lcom/bytedance/lark/pb/basic/v1/DeniedReason;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DataParserUtils {
    public static final DataParserUtils INSTANCE = null;
    private static final String TAG = "DataParserUtils";

    static {
        INSTANCE = new DataParserUtils();
    }

    private DataParserUtils() {
    }

    public final void appendDeniedReason(List<? extends SearchBaseInfo> r4, Map<String, ? extends DeniedReason> r5) {
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r5, "denyReasons");
        Sequence r6 = SequencesKt.filter(CollectionsKt.asSequence(r4), DataParserUtils$appendDeniedReason$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        SearchChatterInfo r0 = (SearchChatterInfo) r7.next();
        DeniedReason r1 = r5.get(r0.getId());     // Catch: NumberFormatException -> L10
        if (r1 == null) goto L4;
        r0.setDeniedReason(r1.getValue());     // Catch: NumberFormatException -> L10
        r0.setDeniedReasons(CollectionsKt.listOf(r1));     // Catch: NumberFormatException -> L10
    L10:
        Log.e(TAG, "parse deny reason error, cause chatter id:" + r0.getId() + " is error");
        goto L4
    }
}
