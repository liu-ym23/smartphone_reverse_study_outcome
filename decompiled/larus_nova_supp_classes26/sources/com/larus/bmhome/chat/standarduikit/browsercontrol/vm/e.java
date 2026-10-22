package com.larus.bmhome.chat.standarduikit.browsercontrol.vm;

import com.larus.network.http.HttpExtKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(String r12, Continuation r13) {
        JSONObject r3 = new JSONObject();
        r3.put("tool_call_id", r12);
        r3.put("action", 1);
        Unit r14 = Unit.INSTANCE;
        Object r15 = HttpExtKt.k("Basic", Object.class, "/alice/general_task/control_browser/useraction", r3, null, null, false, null, null, null, r13, 1008);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r15;
    L6:
        return Unit.INSTANCE;
    }
}
