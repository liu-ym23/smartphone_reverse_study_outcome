package com.ss.android.lark.picker.base.reporter;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.setting.SearchArgsSetting;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\nJ\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0005J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/picker/base/reporter/SearchConsistencyReporter;", "", "<init>", "()V", "TAG", "", "SEARCH_CONTEXT_ID", "SEARCH_ID_LIST", "mContextID", "mStart", "", "mIdList", "", "mLimit", "mCanReport", "", "beginReport", "", "contextID", "start", "addOnScreenID", "position", "id", "report", "reset", "idListSize", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SearchConsistencyReporter {
    public static final SearchConsistencyReporter INSTANCE = null;
    private static final String SEARCH_CONTEXT_ID = "context_id";
    private static final String SEARCH_ID_LIST = "id_list";
    public static final String TAG = "LarkSearch.Common.SearchConsistencyReporter";
    private static boolean mCanReport;
    private static String mContextID;
    private static List<String> mIdList;
    private static int mLimit;
    private static int mStart;

    private SearchConsistencyReporter() {
    }

    static {
        INSTANCE = new SearchConsistencyReporter();
        mContextID = "";
        mIdList = new ArrayList();
        mLimit = 5;
        SettingManager.getInstance().get(SearchArgsSetting.class, new AnonymousClass1());
    }

    private final int idListSize() {
        return mIdList.size();
    }

    private final void report() {
        JSONObject r0 = new JSONObject();
        r0.put(SEARCH_CONTEXT_ID, mContextID);
        JSONArray r1 = new JSONArray();
        Iterator<String> r2 = mIdList.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.put(r2.next());
        goto L4
    L6:
        r0.put(SEARCH_ID_LIST, r1);
        Log.i(TAG, r0.toString());
        Statistics.sendEvent("search_top_n", r0);
    }

    private final void reset() {
        Log.d(TAG, "reset " + mContextID);
        mContextID = "";
        mIdList.clear();
    }

    public static final /* synthetic */ int access$getMLimit$p() {
        return mLimit;
    }

    public static final /* synthetic */ void access$setMLimit$p(int r0) {
        mLimit = r0;
    }

    public final void addOnScreenID(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "id");
        if (mCanReport == true) goto L6;
        return;
    L6:
        if (r3 >= mStart) goto L8;
        return;
    L8:
        if (idListSize() >= mLimit) goto L14;
        Log.d(TAG, "addOnScreenID, position: " + r3 + ", id: " + r4);
        mIdList.add(r4);
        if (idListSize() < mLimit) goto L15;
        report();
        mCanReport = false;
        return;
    L15:
        return;
    }

    public final void beginReport(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "contextID");
        mCanReport = true;
        Log.d(TAG, "setContextID " + r3 + " start " + r4);
        reset();
        mContextID = r3;
        mStart = r4;
    }
}
