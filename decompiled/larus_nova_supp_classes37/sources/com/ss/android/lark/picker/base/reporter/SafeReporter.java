package com.ss.android.lark.picker.base.reporter;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/base/reporter/SafeReporter;", "", "<init>", "()V", "TAG", "", "safeSendEvent", "", "eventKey", "param", "Lorg/json/JSONObject;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SafeReporter {
    public static final SafeReporter INSTANCE = null;
    private static final String TAG = "LarkSearch.Common.SearchNewHitPoint";

    static {
        INSTANCE = new SafeReporter();
    }

    private SafeReporter() {
    }

    public final void safeSendEvent(String r4, JSONObject r5) {
        if (r4 == null) goto L7;
        if (r5 == null) goto L7;
        Statistics.sendEvent(r4, r5);     // Catch: Exception -> L9
        Log.d(TAG, "eventKey:" + r4 + " param:" + r5);     // Catch: Exception -> L9
        return;
    L7:
        Log.e(TAG, "wtf!!!");     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.e(e.getMessage());
    }
}
