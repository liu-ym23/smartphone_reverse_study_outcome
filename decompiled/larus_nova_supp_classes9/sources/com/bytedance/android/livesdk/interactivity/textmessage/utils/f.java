package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final HashMap<String, List<String>> a = null;

    public interface a {
        void onFailure();

        void onSuccess();
    }

    static {
        HashMap<String, List<String>> r0 = new HashMap();
        a = r0;
        r0.put("models", CollectionsKt.arrayListOf(new String[]{"tt_matting"}));
    }
}
