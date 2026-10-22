package com.bytedance.applog.et_verify;

import android.content.Context;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class EventVerify$1 implements Runnable {
    final /* synthetic */ EventVerify this$0;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$loginEtUrlStr;

    public void com_bytedance_applog_et_verify_EventVerify$1__run$___twin___() {
        JSONObject r2 = null;
        String r3 = EventVerify.access$000(this.this$0).getNetClient().get(this.val$loginEtUrlStr, null);     // Catch: Exception -> L5
    L7:
        EventVerify.access$000(this.this$0).t0.k(6, null, "login et resp: {}", new Object[]{r3});
        if (TextUtils.isEmpty(r3) == true) goto L21;
        r2 = new JSONObject(r3);     // Catch: JSONException -> L11
    L12:
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.optInt("status") != 200) goto L23;
        this.this$0.setEnable(true, this.val$context);
        return;
    L23:
        return;
    L21:
        return;
    L5:
        e = move-exception;
        EventVerify.access$000(this.this$0).t0.o(6, "login et failed", e, new Object[0]);
        r3 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_applog_et_verify_EventVerify$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_applog_et_verify_EventVerify$1_com_larus_apm_impl_protector_RunnableLancet_run(EventVerify$1 r1) {
        r1.com_bytedance_applog_et_verify_EventVerify$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public EventVerify$1(EventVerify r1, String r2, Context r3) {
        this.this$0 = r1;
        this.val$loginEtUrlStr = r2;
        this.val$context = r3;
    }
}
