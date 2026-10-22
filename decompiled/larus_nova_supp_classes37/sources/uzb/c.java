package uzb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.passport.base.core.log.PassportLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static Object a(JSONObject r3, Class r4) {
        if (r3 != null) goto L10;
        return null;
    L10:
        return JSON.parseObject(r3.toJSONString(), r4);
    L7:
        th = move-exception;
        PassportLog.c("JsonUtils", "parseObject failed, from JSON to Class:" + r4, th);
        return null;
    }
}
