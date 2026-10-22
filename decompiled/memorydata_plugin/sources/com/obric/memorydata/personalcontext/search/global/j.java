package com.obric.memorydata.personalcontext.search.global;

import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/ReactAgentSearchMetrics;", "", "<init>", "()V", "copyToResponse", "", "packageResponse", "Lorg/json/JSONObject;", ChatMessage.TYPE_RESPONSE, "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f12337a = null;

    static {
        f12337a = new j();
    }

    private j() {
    }

    public final void a(JSONObject r10, GlobalAssistantSearchResponse r11) {
        Intrinsics.checkNotNullParameter(r10, "packageResponse");
        Intrinsics.checkNotNullParameter(r11, ChatMessage.TYPE_RESPONSE);
        if (r10.has("search_entity_count") == true) goto L5;
        return;
    L5:
        if (r10.isNull("search_entity_count") == true) goto L36;
        Object r12 = r10.opt("search_entity_count");
        boolean r1 = true;
        Integer r3 = null;
        if (ZeusTransformUtils.instanceOf(r12, Integer.class) == false) goto L18;
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue() >= 0) goto L13;
        r1 = false;
    L13:
        if (r1 == true) goto L16;
        r12 = null;
    L16:
        r3 = (Integer) ZeusTransformUtils.preCheckCast(r12, Integer.class, "com.obric.memorydata.plugin");
    L31:
        if (r3 == null) goto L35;
        r11.addExtra("search_entity_count", Integer.valueOf(r3.intValue()));
        return;
    L35:
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r12, Long.class) == false) goto L31;
        long r5 = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (0 <= r5) goto L22;
    L24:
        r1 = false;
    L25:
        if (r1 == true) goto L28;
        r12 = null;
    L28:
        Long r13 = (Long) ZeusTransformUtils.preCheckCast(r12, Long.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L31;
        r3 = Integer.valueOf((int) r13.longValue());
        goto L31
    L22:
        if (r5 >= 2147483648L) goto L24;
    }
}
