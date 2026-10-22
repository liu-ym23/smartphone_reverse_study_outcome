package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmAISummaryLayoutData;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import com.ss.android.lark.utils.e0;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(OfficeWebView r3, Message r4) {
        String r5 = e0.c(r4);
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r6 = String.format("LarkWebViewJavaScriptBridge.nativeCallBack(%s);", Arrays.copyOf(new Object[]{r5}, 1));
        lvb.a.a("MmSummaryNativeToJSHelper", "[evaluateJavascript] script=" + r6);
        r3.evaluateJavascript(r6, null);
    }

    public static void b(OfficeWebView r5, MmAISummaryLayoutData r6) {
        Intrinsics.checkNotNullParameter(r6, "fishBoneData");
        if (r5 != null) goto L5;
        return;
    L5:
        Message r0 = new Message();
        r0.setCallbackID("minutes.pushMeetingAILayoutData");
        JSONObject r1 = new JSONObject();
        r1.put("type", r6.getType().getValue());
        r1.put("timestamp", r6.getTimeStamp());
        r0.setData(r1.toString());
        a(r5, r0);
    }
}
