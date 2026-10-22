package com.larus.uaigc.api;

import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.platform.model.upload.UploadDataType;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o {
    public static final Object a(List<String> r12, boolean r13, Continuation<? super a<s>> r14) {
        JSONObject r3 = new JSONObject();
        r3.put("urls", new JSONArray(r12));
        r3.put("need_resource_meta", r13);
        Unit r15 = Unit.INSTANCE;
        return HttpExtKt.k("Social", s.class, "/alice/resource/explain_resource_urls", r3, null, null, false, null, null, null, r14, 1008);
    }

    public static final Object b(List<String> r12, UploadDataType r13, Continuation<? super a<FileUrlRespData>> r14) {
        JSONObject r3 = new JSONObject();
        r3.put("uris", new JSONArray(r12));
        r3.put("type", r13.getType());
        Unit r15 = Unit.INSTANCE;
        return HttpExtKt.k("Social", FileUrlRespData.class, "/alice/message/get_file_url", r3, null, null, false, null, null, null, r14, 1008);
    }
}
