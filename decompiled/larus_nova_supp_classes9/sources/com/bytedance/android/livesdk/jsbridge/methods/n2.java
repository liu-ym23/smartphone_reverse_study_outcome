package com.bytedance.android.livesdk.jsbridge.methods;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n2 implements v80.b.b {
    public final /* synthetic */ o2 a;

    public n2(o2 r1) {
        this.a = r1;
    }

    public final void a(boolean r4, int r5, String r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r7, "extra");
        if (r4 == false) goto L5;
        o2 r8 = this.a;
        JSONObject r9 = new JSONObject();
        r9.put("err_code", 0);
        r9.put("ext_data", r7);
        Unit r10 = Unit.INSTANCE;
        r8.finishWithResult(r9);
        return;
    L5:
        o2 r11 = this.a;
        JSONObject r2 = new JSONObject();
        r2.put("err_code", r5);
        r2.put("msg", r6);
        r2.put("ext_data", r7);
        Unit r13 = Unit.INSTANCE;
        r11.finishWithResult(r2);
    }
}
