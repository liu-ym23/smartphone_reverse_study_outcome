package com.obric.memorydata.database.entity;

import com.google.gson.reflect.TypeToken;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/entity/AssistantChatContentListConverter;", "", "<init>", "()V", "fromContentList", "", Params.CONTENT, "", "Lcom/obric/memorydata/database/entity/AssistantChatContent;", "toContentList", "json", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends AssistantChatContent>> {
        public a() {
        }
    }

    public p() {
    }

    public final String a(List<AssistantChatContent> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        String r3 = GsonUtil.INSTANCE.toJson(r1);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public final List<AssistantChatContent> a(String r3) {
        GsonUtil r2 = GsonUtil.INSTANCE;
        List<AssistantChatContent> r4 = null;
        if (r3 != null) goto L5;
    L13:
        if (r4 == null) goto L15;
        return r4;
    L15:
        return CollectionsKt.emptyList();
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L13;
        r4 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r3, new a().getType()), List.class, "com.obric.memorydata.plugin");
        goto L13
    L7:
        r0 = false;
        goto L8
    }
}
