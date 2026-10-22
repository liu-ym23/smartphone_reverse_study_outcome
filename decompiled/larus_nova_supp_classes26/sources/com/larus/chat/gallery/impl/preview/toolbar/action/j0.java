package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j0 {
    public static final Object a(List<String> r12, Continuation<? super a<SignImgWmData>> r13) {
        JSONObject r3 = new JSONObject();
        r3.put("uris", new JSONArray(r12));
        Unit r14 = Unit.INSTANCE;
        return HttpExtKt.k("Social", SignImgWmData.class, "/creativity/tool/sign_img_wm", r3, null, null, false, null, null, null, r13, 1008);
    }
}
