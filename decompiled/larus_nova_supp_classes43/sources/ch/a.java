package ch;

import com.bytedance.android.ec.core.hybrid.model.ECFloatWindowDetailResponse;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.widgets.LynxTaskBanner;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.g;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LynxTaskBanner a;

    public a(LynxTaskBanner r1) {
        this.a = r1;
    }

    public final void accept(Object r14) {
        ECFloatWindowDetailResponse r15 = (ECFloatWindowDetailResponse) r14;
        if (r15 != null) goto L5;
        return;
    L5:
        if (((g) r15).statusCode == 0) goto L7;
        return;
    L7:
        if (r15.a() == null) goto L66;
        LynxTaskBanner r0 = this.a;
        String r16 = u0.d(r15.a());
        Map<String, Object> r1 = this.a.getInitData();
        r0.getClass();
        JSONObject r10 = new JSONObject(r16);     // Catch: JSONException -> L11
    L12:
        String r17 = r10.optString("resource");
        if (r17 == null) goto L67;
        Object r11 = r1.get("task_request_params");
        Object r12 = null;
        if ((r11 instanceof JSONObject) == true) goto L18;
        r11 = null;
    L18:
        JSONObject r13 = (JSONObject) r11;
        Object r18 = r1.get("extra");
        if ((r18 instanceof JSONObject) == true) goto L21;
        r18 = null;
    L21:
        JSONObject r19 = (JSONObject) r18;
        Pair[] r20 = new Pair[8];
        r20[0] = TuplesKt.to("taskEnterFrom", r0.c);
        r20[1] = TuplesKt.to("taskType", r0.d);
        r20[2] = TuplesKt.to("uniqueID", r10.optString("uniqueID"));
        if (r19 == null) goto L24;
        r19.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r10.optInt(com.bytedance.android.ec.core.event.a.KEY_DURATION));
        Unit r21 = Unit.INSTANCE;
    L25:
        r20[3] = TuplesKt.to("extra", r19);
        JSONObject r22 = new JSONObject();
        Object r23 = r1.get(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA);
        if ((r23 instanceof JSONObject) == true) goto L28;
        r23 = null;
    L28:
        JSONObject r24 = (JSONObject) r23;
        if (r24 == null) goto L34;
        Iterator<String> r25 = r24.keys();
    L32:
        if (r25.hasNext() == false) goto L34;
        String r26 = r25.next();
        r22.put(r26, r24.get(r26));
    L34:
        Object r27 = r1.get(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME);
        if ((r27 instanceof String) == true) goto L37;
        r27 = null;
    L37:
        String r28 = (String) r27;
        if (r28 == null) goto L40;
        r22.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r28);
    L40:
        Object r29 = r1.get(com.bytedance.android.ec.core.event.a.KEY_SOURCE_PAGE);
        if ((r29 instanceof String) == true) goto L43;
        r29 = null;
    L43:
        String r30 = (String) r29;
        if (r30 == null) goto L46;
        r22.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_PAGE, r30);
    L46:
        Object r31 = r1.get(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID);
        if ((r31 instanceof String) == true) goto L49;
        r31 = null;
    L49:
        String r32 = (String) r31;
        if (r32 == null) goto L52;
        r22.put(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r32);
    L52:
        Object r33 = r1.get(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID);
        if ((r33 instanceof String) == false) goto L56;
        r12 = r33;
    L56:
        String r34 = (String) r12;
        if (r34 == null) goto L59;
        r22.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r34);
    L59:
        Unit r35 = Unit.INSTANCE;
        r20[4] = TuplesKt.to("logExtra", r22);
        r20[5] = TuplesKt.to("taskRequestParams", r13);
        r20[6] = TuplesKt.to("containerID", r0.a);
        r20[7] = TuplesKt.to("data", r10);
        r0.b = ECLiveHybridUtil.b(r0.getContext(), r17, MapsKt.mapOf(r20), r0, null, null, null, false, null, null, false, 4080);
        return;
    L24:
        r19 = null;
        goto L25
    L67:
        return;
    L11:
        r10 = new JSONObject();
        goto L12
    }
}
