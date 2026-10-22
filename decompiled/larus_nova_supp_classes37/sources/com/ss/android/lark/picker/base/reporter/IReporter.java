package com.ss.android.lark.picker.base.reporter;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0016J4\u0010\t\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u000e\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J4\u0010\u0010\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/base/reporter/IReporter;", "", "reset", "", "report", "args", "Lorg/json/JSONObject;", "safeValue", "value", "packQueryForClickReporter", AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY, "", "filterStatus", "recFilterSelectedStatus", "packGrammarParamsForReporter", "grammarType", "packQueryForScreenReporter", "recFilterStatus", "getQueryId", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface IReporter {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class DefaultImpls {
        public static Object safeValue(IReporter r0, Object r1) {
            if (r1 != null) goto L5;
            return "none";
        L5:
            return r1;
        }

        public static String getQueryId(IReporter r0, String r1) {
            Intrinsics.checkNotNullParameter(r1, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
            if (TextUtils.isEmpty(r1) == false) goto L7;
            return "6cb9acc00ffb4016dd5fe3a5d98e0bc5b94c285e";
        L7:
            return y.b(r1);
        }

        public static void packGrammarParamsForReporter(IReporter r2, JSONObject r3, String r4, String r5) {
            if (r3 == null) goto L18;
            if (r5 != null) goto L16;
        L10:
            boolean r0 = true;
        L11:
            if (r0 == true) goto L19;
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L8
            r1.put("filter_status", r2.safeValue(r4));     // Catch: JSONException -> L8
            r1.put("source", r2.safeValue(r5));     // Catch: JSONException -> L8
            r3.put("selected_rec_filter", r1);     // Catch: JSONException -> L8
            return;
        L8:
            e = move-exception;
            Log.e(SearchClickReporter.TAG, "add key-value exception for packGrammarParamsForReporter: " + e.getMessage());
            return;
        L19:
            return;
        L16:
            if (r5.length() == 0) goto L10;
            r0 = false;
            goto L11
        }

        public static void packQueryForClickReporter(IReporter r2, JSONObject r3, String r4, String r5, String r6) {
            if (r3 == null) goto L20;
            if (r4 != null) goto L17;
            r4 = "";
        L17:
            r3.put("query_length", r4.length());     // Catch: JSONException -> L13
            r3.put("query_id", r2.getQueryId(r4));     // Catch: JSONException -> L13
            if (TextUtils.isEmpty(r5) == false) goto L9;
            r3.put("is_filter", "False");     // Catch: JSONException -> L13
        L16:
            return;
        L9:
            r3.put("is_filter", "True");     // Catch: JSONException -> L13
            r3.put("filter_status", r5);     // Catch: JSONException -> L13
            if (TextUtils.isEmpty(r6) == true) goto L16;
            r3.put("selected_rec_filter", r6);     // Catch: JSONException -> L13
        L13:
            e = move-exception;
            Log.e(SearchClickReporter.TAG, "add key-value exception for packQueryForClickReporter: " + e.getMessage());
            return;
        }

        public static void packQueryForScreenReporter(IReporter r2, JSONObject r3, String r4, String r5, String r6) {
            if (r3 == null) goto L19;
            if (r4 != null) goto L17;
            r4 = "";
        L17:
            r3.put("query_length", r4.length());     // Catch: JSONException -> L14
            r3.put("query_id", r2.getQueryId(r4));     // Catch: JSONException -> L14
            if (TextUtils.isEmpty(r5) == false) goto L9;
            r3.put("is_filter", "False");     // Catch: JSONException -> L14
        L11:
            if (TextUtils.isEmpty(r6) == true) goto L20;
            r3.put("rec_filter", r6);     // Catch: JSONException -> L14
            return;
        L20:
            return;
        L9:
            r3.put("is_filter", "True");     // Catch: JSONException -> L14
            r3.put("filter_status", r5);     // Catch: JSONException -> L14
        L14:
            e = move-exception;
            Log.e(SearchClickReporter.TAG, "add key-value exception for packQueryForScreenReporter: " + e.getMessage());
            return;
        }

        public static /* synthetic */ void packGrammarParamsForReporter$default(IReporter r1, JSONObject r2, String r3, String r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 2) == 0) goto L7;
            r3 = "";
        L7:
            if ((r5 & 4) == 0) goto L9;
            r4 = "";
        L9:
            r1.packGrammarParamsForReporter(r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: packGrammarParamsForReporter");
        }

        public static /* synthetic */ void packQueryForClickReporter$default(IReporter r0, JSONObject r1, String r2, String r3, String r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 4) == 0) goto L7;
            r3 = "";
        L7:
            if ((r5 & 8) == 0) goto L9;
            r4 = null;
        L9:
            r0.packQueryForClickReporter(r1, r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: packQueryForClickReporter");
        }

        public static /* synthetic */ void packQueryForScreenReporter$default(IReporter r0, JSONObject r1, String r2, String r3, String r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 4) == 0) goto L7;
            r3 = "";
        L7:
            if ((r5 & 8) == 0) goto L9;
            r4 = null;
        L9:
            r0.packQueryForScreenReporter(r1, r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: packQueryForScreenReporter");
        }
    }

    String getQueryId(String r1);

    void packGrammarParamsForReporter(JSONObject r1, String r2, String r3);

    void packQueryForClickReporter(JSONObject r1, String r2, String r3, String r4);

    void packQueryForScreenReporter(JSONObject r1, String r2, String r3, String r4);

    void report(JSONObject r1);

    void reset();

    Object safeValue(Object r1);
}
