package com.ss.android.lark.picker.base.reporter;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchCustomizationInfo;
import com.ss.android.lark.search.dto.info.SearchMessageInfo;
import com.ss.android.lark.search.dto.info.SearchOpenAppInfo;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.utils.y;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0014H\u0002JC\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u0005¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/picker/base/reporter/SearchClickReporter;", "Lcom/ss/android/lark/picker/base/reporter/IReporter;", "<init>", "()V", "TAG", "", "reportSearchResultClickInChat", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "sceneType", AppbrandHostConstants.Schema_BDP_LOG.FIELD_LOCATION, "position", "", "tagForRpt", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "reportClickProfile", "reset", "report", "args", "Lorg/json/JSONObject;", "commonReport", "addSearchPlatformHitPoint", "jSONObject", "reportClickAppShortCut", "Lcom/ss/android/lark/search/dto/info/SearchOpenAppInfo;", "sectionPosition", "subPosition", "appLink", "(Lcom/ss/android/lark/search/dto/info/SearchOpenAppInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SearchClickReporter implements IReporter {
    public static final SearchClickReporter INSTANCE = null;
    public static final String TAG = "SearchClickReporter";

    static {
        INSTANCE = new SearchClickReporter();
    }

    private SearchClickReporter() {
    }

    @JvmStatic
    public static final void reportSearchResultClickInChat(SearchBaseInfo r7, String r8, String r9, Integer r10) {
        reportSearchResultClickInChat$default(r7, r8, r9, r10, null, 16, null);
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public void reset() {
    }

    private final void commonReport(JSONObject r3) {
        if (r3 == null) goto L10;
        r3.put("user_unique_id", y.b(PickerBaseModuleDependency.getDependency().getLoginUserId()));     // Catch: JSONException -> L5
        SafeReporter.INSTANCE.safeSendEvent("asl_search_click", r3);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "add key-value exception for SearchClickReporter report: " + e.getMessage());
        return;
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public String getQueryId(String r1) {
        return IReporter.DefaultImpls.getQueryId(this, r1);
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public void report(JSONObject r4) {
        if (r4 == null) goto L17;
        r4.put("request_timestamp", System.currentTimeMillis());
        if (ChatInSideContext.INSTANCE.inChat() == true) goto L6;
    L15:
        INSTANCE.commonReport(r4);
        return;
    L6:
        if (TextUtils.isEmpty(ChatInSideContext.getChatId()) == true) goto L11;
        if ((!StringsKt.isBlank(ChatInSideContext.getChatId())) == false) goto L11;
        r4.put("chat_id", ChatInSideContext.getChatId());
    L11:
        if (TextUtils.isEmpty(ChatInSideContext.getChatType()) == true) goto L15;
        if ((!StringsKt.isBlank(ChatInSideContext.getChatType())) == false) goto L15;
        r4.put("chat_type", ChatInSideContext.getChatType());
        goto L15
    }

    public final void reportClickProfile(SearchBaseInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        JSONObject r0 = new JSONObject();
    L16:
        Log.e(TAG, "reportClickProfile occurs exception");
        return;
    L5:
        if ((r10 instanceof SearchChatterInfo) == false) goto L8;
        r0.put("result_type", ((SearchChatterInfo) r10).getResultTypeForReport());     // Catch: JSONException -> L16
    L10:
        r0.put(PickerReporterConstants.KEY.CLICK, "profile");     // Catch: JSONException -> L16
        r0.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: JSONException -> L16
        SearchClickReporter r8 = INSTANCE;     // Catch: JSONException -> L16
        r8.addSearchPlatformHitPoint(r10, r0);     // Catch: JSONException -> L16
        r0.put(PickerReporterConstants.KEY.ENTITY_ID, r10.getEntityIdForReport());     // Catch: JSONException -> L16
        r0.put("search_location", r10.getSearchLocation());     // Catch: JSONException -> L16
        IReporter.DefaultImpls.packQueryForClickReporter$default(r8, r0, r10.getQuery(), r10.getFilterStatus(), null, 8, null);     // Catch: JSONException -> L16
        r0.put("impr_id", r10.getImprId());     // Catch: JSONException -> L16
        r0.put("search_session_id", r10.getSession());     // Catch: JSONException -> L16
        if (r10.isPickerShow() == false) goto L13;
        String r11 = "component";
    L14:
        r0.put("scene_type", r11);     // Catch: JSONException -> L16
        r8.report(r0);     // Catch: JSONException -> L16
        return;
    L13:
        r11 = "main";
        goto L14
    L8:
        if ((r10 instanceof SearchChatInfo) == false) goto L20;
        r0.put("result_type", "groups");     // Catch: JSONException -> L16
        goto L10
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public Object safeValue(Object r1) {
        return IReporter.DefaultImpls.safeValue(this, r1);
    }

    private final void addSearchPlatformHitPoint(SearchBaseInfo r4, JSONObject r5) {
        if (r4 == null) goto L19;
        String r0 = r4.getBid();
        boolean r1 = false;
        if (r0 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L20;
        String r3 = r4.getEntityType();
        if (r3 != null) goto L14;
    L15:
        r1 = true;
    L16:
        if (r1 == true) goto L21;
        r5.put("Bid", r4.getBid());
        r5.put("EntityType", r4.getEntityType());
        return;
    L21:
        return;
    L14:
        if (r3.length() != 0) goto L16;
    L20:
        return;
    L6:
        if (r0.length() == 0) goto L9;
        r2 = false;
        goto L10
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public void packGrammarParamsForReporter(JSONObject r1, String r2, String r3) {
        IReporter.DefaultImpls.packGrammarParamsForReporter(this, r1, r2, r3);
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public void packQueryForClickReporter(JSONObject r1, String r2, String r3, String r4) {
        IReporter.DefaultImpls.packQueryForClickReporter(this, r1, r2, r3, r4);
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public void packQueryForScreenReporter(JSONObject r1, String r2, String r3, String r4) {
        IReporter.DefaultImpls.packQueryForScreenReporter(this, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final void reportSearchResultClickInChat(SearchBaseInfo r9, String r10, String r11, Integer r12, String r13) {
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L37
        r7.put(PickerReporterConstants.KEY.CLICK, "result_click");     // Catch: JSONException -> L37
        if (r9 == null) goto L42;
        SearchClickReporter r8 = INSTANCE;     // Catch: JSONException -> L37
        r8.addSearchPlatformHitPoint(r9, r7);     // Catch: JSONException -> L37
        if ((r9 instanceof SearchOpenAppInfo) == false) goto L11;
        if (((SearchOpenAppInfo) r9).isAvailable() == true) goto L11;
        String r0 = "openplatform_ecosystem_application_detail_view";
    L14:
        r7.put(PickerReporterConstants.KEY.TARGET, r0);     // Catch: JSONException -> L37
        r7.put(PickerReporterConstants.KEY.ENTITY_ID, r9.getEntityIdForReport());     // Catch: JSONException -> L37
        r7.put("result_type", r9.getResultTypeForReport());     // Catch: JSONException -> L37
        if (r13 == null) goto L17;
        r7.put("tag", r13);     // Catch: JSONException -> L37
    L17:
        if (r12 == null) goto L19;
        r7.put("pos", r12.intValue());     // Catch: JSONException -> L37
    L19:
        r7.put("result_click_action", "none");     // Catch: JSONException -> L37
        if ((r9 instanceof SearchOpenSearchInfo) == false) goto L24;
        r7.put("slash_id", ((SearchOpenSearchInfo) r9).getSlashId());     // Catch: JSONException -> L37
    L33:
        if (r11 == null) goto L35;
        r7.put("search_location", r11);     // Catch: JSONException -> L37
    L35:
        IReporter.DefaultImpls.packQueryForClickReporter$default(r8, r7, r9.getQuery(), r9.getFilterStatus(), null, 8, null);     // Catch: JSONException -> L37
        r7.put("impr_id", r9.getImprId());     // Catch: JSONException -> L37
        r7.put("search_session_id", r9.getSession());     // Catch: JSONException -> L37
        r7.put("scene_type", r8.safeValue(r10));     // Catch: JSONException -> L37
        r8.report(r7);     // Catch: JSONException -> L37
        return;
    L24:
        if ((r9 instanceof SearchCustomizationInfo) == false) goto L27;
        r7.put("slash_id", ((SearchCustomizationInfo) r9).getDataSourceId());     // Catch: JSONException -> L37
        goto L33
    L27:
        if ((r9 instanceof SearchMessageInfo) == false) goto L33;
        if (((SearchMessageInfo) r9).getThreadMessageType() != Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE) goto L31;
        String r14 = "False";
    L32:
        r7.put("is_thread", r14);     // Catch: JSONException -> L37
        goto L33
    L31:
        r14 = "True";
    L11:
        if ((r9 instanceof SearchSpaceInfo) == false) goto L13;
        r0 = "ccm_docs_page_view";
        goto L14
    L13:
        r0 = "none";
        goto L14
    L42:
        return;
    L37:
        e = move-exception;
        Log.e(TAG, "add key-value exception for reportSearchResultClickInChat: " + e.getMessage());
    }

    public final void reportClickAppShortCut(SearchOpenAppInfo r10, String r11, Integer r12, Integer r13, Integer r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r15, "appLink");
        JSONObject r1 = new JSONObject();
        r1.put(PickerReporterConstants.KEY.CLICK, "result_click");     // Catch: JSONException -> L18
        r1.put("sub_result_type", "apps_shortcut");     // Catch: JSONException -> L18
        if (r12 == null) goto L6;
        r1.put("pos", r12.intValue());     // Catch: JSONException -> L18
    L6:
        if (r13 == null) goto L8;
        r1.put("section_pos", r13.intValue());     // Catch: JSONException -> L18
    L8:
        if (r14 == null) goto L10;
        r1.put("sub_entity_pos", r14.intValue());     // Catch: JSONException -> L18
    L10:
        r1.put("sub_entity_id", y.b(r15));     // Catch: JSONException -> L18
        SearchClickReporter r16 = INSTANCE;     // Catch: JSONException -> L18
        r16.addSearchPlatformHitPoint(r10, r1);     // Catch: JSONException -> L18
        r1.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: JSONException -> L18
        r1.put(PickerReporterConstants.KEY.ENTITY_ID, r10.getEntityIdForReport());     // Catch: JSONException -> L18
        r1.put("result_type", r10.getResultTypeForReport());     // Catch: JSONException -> L18
        r1.put("tag", r10.getTagForReport());     // Catch: JSONException -> L18
        r1.put("result_click_action", "none");     // Catch: JSONException -> L18
        r1.put("search_location", r10.getSearchLocation());     // Catch: JSONException -> L18
        IReporter.DefaultImpls.packQueryForClickReporter$default(r16, r1, r10.getQuery(), r10.getFilterStatus(), null, 8, null);     // Catch: JSONException -> L18
        r16.packGrammarParamsForReporter(r1, r10.getFilterStatus(), r10.getGrammarType());     // Catch: JSONException -> L18
        r1.put("impr_id", r10.getImprId());     // Catch: JSONException -> L18
        r1.put("scene_type", r16.safeValue(r11));     // Catch: JSONException -> L18
        r1.put("search_session_id", r10.getSession());     // Catch: JSONException -> L18
        r1.put("request_timestamp", System.currentTimeMillis());     // Catch: JSONException -> L18
        Map r17 = r10.getExtraParams();     // Catch: JSONException -> L18
        if (r17 == null) goto L16;
        Iterator r18 = r17.entrySet().iterator();     // Catch: JSONException -> L18
    L14:
        if (r18.hasNext() == false) goto L16;
        Map.Entry r19 = (Map.Entry) r18.next();     // Catch: JSONException -> L18
        r1.put((String) r19.getKey(), r19.getValue());     // Catch: JSONException -> L18
    L16:
        INSTANCE.commonReport(r1);     // Catch: JSONException -> L18
        return;
    L18:
        Log.e(TAG, "reportClickProfile occurs exception");
    }

    public static /* synthetic */ void reportSearchResultClickInChat$default(SearchBaseInfo r0, String r1, String r2, Integer r3, String r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L5;
        r4 = null;
    L5:
        reportSearchResultClickInChat(r0, r1, r2, r3, r4);
    }
}
