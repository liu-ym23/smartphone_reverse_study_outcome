package com.larus.bmhome.chat.list.cell.nested_file;

import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.bean.AudioFileDetail;
import com.larus.bmhome.chat.bean.GetAudioFileDetailData;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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

    public final Object b(List<String> r9, Continuation<? super ic8.g> r10) {
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
        if ((r12 instanceof com.larus.network.http.y) == false) goto L25;
        String r13 = (String) CollectionsKt.firstOrNull(r9);
        if (r13 == null) goto L27;
        HashMap r14 = (HashMap) ((com.larus.network.http.a) r12).b;
        if (r14 != null) goto L24;
        return null;
    L24:
        return (ic8.g) r14.get(r13);
    L27:
        return null;
    L25:
        boolean r15 = r12 instanceof com.larus.network.http.f;
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        JSONObject r4 = new JSONObject();
        r4.put("uris", new JSONArray(r9));
        r4.put("status_only", false);
        Map r5 = MapsKt.emptyMap();
        Type r16 = new a().getType();
        r7.L$0 = r9;
        r7.label = 1;
        r11 = HttpExtKt.m("AISDK", r16, "/alice/resource/get_audio_parse_result", r4, r5, false, r7);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new AttachmentUtil$getAudioParseResult$1(this, r10);
        goto L8
    }

    public final Object a(String r16, String r17, List<String> r18, Continuation<? super HashMap<String, AudioFileDetail>> r19) {
        if ((r19 instanceof AttachmentUtil$getAudioDetailUrl$1) == false) goto L7;
        AttachmentUtil$getAudioDetailUrl$1 r1 = (AttachmentUtil$getAudioDetailUrl$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        AttachmentUtil$getAudioDetailUrl$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L17:
        com.larus.network.http.y r5 = (com.larus.network.http.a) r0;
        if ((r5 instanceof com.larus.network.http.y) == false) goto L23;
        GetAudioFileDetailData r6 = (GetAudioFileDetailData) ((com.larus.network.http.a) r5).b;
        if (r6 != null) goto L22;
        return null;
    L22:
        return r6.a();
    L23:
        boolean r7 = r5 instanceof com.larus.network.http.f;
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        JSONObject r8 = new JSONObject();
        r8.put("bot_id", r16);
        r8.put("user_id", r17);
        r8.put("uris", new JSONArray(r18));
        Unit r9 = Unit.INSTANCE;
        r13.label = 1;
        r0 = HttpExtKt.k("AISDK", GetAudioFileDetailData.class, "/alice/resource/get_audio_file_detail", r8, null, null, false, null, null, null, r13, 1008);
        if (r0 != r3) goto L17;
        return r3;
    L7:
        r1 = new AttachmentUtil$getAudioDetailUrl$1(this, r19);
        goto L8
    }
}
