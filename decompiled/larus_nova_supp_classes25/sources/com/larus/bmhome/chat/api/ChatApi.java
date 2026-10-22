package com.larus.bmhome.chat.api;

import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.resp.DeleteFileResourceResponse;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.chat.resp.MessagePreHandleResponse;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.service.AccountService;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatApi {
    public static final Lazy<ChatApi> a = null;

    public static final class a {
        public static ChatApi a() {
            return (ChatApi) ChatApi.a.getValue();
        }
    }

    public ChatApi() {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new g());
    }

    public static Object d(Continuation r3) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ChatApi$requireCheckLimit$2(null), r3);
    }

    public static Object a(List r12, Continuation r13) {
        JSONObject r3 = new JSONObject();
        JSONArray r4 = new JSONArray();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Pair r5 = (Pair) r14.next();
        JSONObject r6 = new JSONObject();
        r6.put("uri", r5.getFirst());
        r6.put("data_type", r5.getSecond());
        r4.put(r6);
        goto L4
    L6:
        Unit r15 = Unit.INSTANCE;
        r3.put("uris", r4);
        return HttpExtKt.k("Message", DeleteFileResourceResponse.class, "/alice/resource/delete_files", r3, null, null, false, null, null, null, r13, 1008);
    }

    public static Object c(String r11, String r12, Continuation r13) {
        FlowDowngradeServiceDelegate r0 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r4 = new JSONObject();
        r4.put("bot_id", StringsKt.toLongOrNull(r11));
        r4.put("user_id", StringsKt.toLongOrNull(AccountService.a.getUserId()));
        Unit r14 = Unit.INSTANCE;
        return IFlowDowngradeService.a.b(r0, "Basic", SuggestedActionData.class, "/biz/suggested_action/get", r4, null, false, null, MapsKt.mapOf(TuplesKt.to("source", r12)), r13, 1008);
    }

    public static Object e(List r12, String r13, Continuation r14) {
        JSONObject r3 = new JSONObject();
        r3.put("uris", new JSONArray(r12));
        r3.put("type", r13);
        Unit r15 = Unit.INSTANCE;
        return HttpExtKt.k("Message", FileUrlRespData.class, "/alice/message/get_file_url", r3, null, null, false, null, null, null, r14, 1008);
    }

    public static Object f(String r3, String r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ChatApi$requirePushContent$2(r3, r4, null), r5);
    }

    public static Object b(UplinkFileEntity r12, String r13, String r14, String r15, String r16, Continuation r17) {
        JSONObject r3 = new JSONObject();
        String r4 = zd9.i.c(r12, UplinkFileEntity.Companion.serializer());
        if (r4 == null) goto L5;
        JSONObject r5 = new JSONObject(r4);
    L6:
        r3.put("uplink_entity", r5);
        r3.put("conversation_id", r13);
        r3.put("bot_id", r14);
        r3.put("section_id", r15);
        r3.put("local_message_id", r16);
        Unit r6 = Unit.INSTANCE;
        return HttpExtKt.k("Message", MessagePreHandleResponse.class, "/alice/message/pre_handle_v2", r3, null, null, false, null, null, null, r17, 1008);
    L5:
        r5 = null;
        goto L6
    }
}
