package com.larus.account.base.multi;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.network.http.HttpExtKt;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MultiAccountProfileRepository {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public MultiAccountProfileRepository() {
    }

    public static final k a(String r5) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L17;
        JSONObject r1 = new JSONObject(r5);
        if (r1.optLong("code", 0) != 0) goto L17;
        JSONObject r6 = r1.optJSONObject("sec_user_datas");
        if (r6 != null) goto L18;
        r6 = r1.optJSONObject("datas");
        if (r6 == null) goto L17;
    L18:
        Type r2 = new h().getType();
        return new k((Map) GsonProtectorUtils.fromJson(HttpExtKt.f, r6.toString(), r2));
    L17:
        return null;
    L4:
        if (r5.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static Object b(List r3, Continuation r4) {
        if (r3.isEmpty() == false) goto L6;
        return null;
    L6:
        return BuildersKt.withContext(Dispatchers.getIO(), new MultiAccountProfileRepository$fetchProfileMulti$2(r3, null), r4);
    }
}
