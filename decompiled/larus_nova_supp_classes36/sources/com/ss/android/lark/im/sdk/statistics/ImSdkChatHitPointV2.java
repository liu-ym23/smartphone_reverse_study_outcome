package com.ss.android.lark.im.sdk.statistics;

import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkChatHitPointV2 {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ImSdkChatHitPointV2$statistics$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(String r3, String r4, Map<String, ? extends Object> r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r3, "click");
        Intrinsics.checkNotNullParameter(r4, "target");
        Intrinsics.checkNotNullParameter(r5, "chatParams");
        JSONObject r7 = new JSONObject(r5).put("click", r3).put("target", r4);
        if (r6 == null) goto L8;
        Iterator<Map.Entry<String, ? extends Object>> r8 = r6.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r9 = r8.next();
        r7.put(r9.getKey(), r9.getValue());
    L8:
        Log.d("ChatHitPointNew", "IM_CHAT_MAIN_CLICK, params:" + r7);
        ((o5c.b) a.getValue()).sendEvent("im_chat_main_click", r7);
    }
}
