package com.larus.bmhome.chat.component.bottom.attachment;

import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AttachmentUtil {
    public static final AttachmentUtil a = null;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/network/http/HttpExtKt$httpPost2$2", "Lcom/google/gson/reflect/TypeToken;", "network_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<HashMap<String, ic8.g>> {
        public a() {
        }
    }

    static {
        a = new AttachmentUtil();
    }

    public AttachmentUtil() {
    }

    public final Object a(List<String> r9, Continuation<? super ic8.g> r10) {
        if ((r10 instanceof AttachmentUtil$getAudioParseResult$1) == false) goto L7;
        AttachmentUtil$getAudioParseResult$1 r0 = (AttachmentUtil$getAudioParseResult$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AttachmentUtil$getAudioParseResult$1 r7 = r0;
        Object r11 = r7.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (List) r7.L$0;
        ResultKt.throwOnFailure(r11);
    L17:
        com.larus.network.http.y r12 = (com.larus.network.http.a) r11;
        if ((r12 instanceof com.larus.network.http.y) == false) goto L24;
        String r13 = (String) CollectionsKt.firstOrNull(r9);
        if (r13 == null) goto L24;
        HashMap r14 = (HashMap) ((com.larus.network.http.a) r12).b;
        if (r14 == null) goto L24;
        return (ic8.g) r14.get(r13);
    L24:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        JSONObject r4 = new JSONObject();
        r4.put("uris", new JSONArray(r9));
        r4.put("status_only", false);
        Map r5 = MapsKt.emptyMap();
        Type r15 = new a().getType();
        r7.L$0 = r9;
        r7.label = 1;
        r11 = HttpExtKt.m("AISDK", r15, "/alice/resource/get_audio_parse_result", r4, r5, false, r7);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new AttachmentUtil$getAudioParseResult$1(this, r10);
        goto L8
    }
}
