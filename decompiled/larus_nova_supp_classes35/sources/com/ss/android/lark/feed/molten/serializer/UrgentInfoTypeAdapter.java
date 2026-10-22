package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.biz.im.api.UrgentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/UrgentInfoTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/biz/im/api/UrgentInfo;", "<init>", "()V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrgentInfoTypeAdapter extends JsonTreeTypeAdapter<UrgentInfo> {
    public UrgentInfoTypeAdapter() {
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final UrgentInfo a(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "json");
        UrgentInfo r0 = new UrgentInfo();
        r0.setId(a.l(r4, "id"));
        r0.setMessageId(a.l(r4, "messageId"));
        Long r1 = a.f(r4, "sendTime");
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        r0.setSendTime(r2);
        Boolean r3 = a.c(r4, "isClosed");
        boolean r5 = false;
        if (r3 == null) goto L9;
        boolean r6 = r3.booleanValue();
    L10:
        r0.setClosed(r6);
        Boolean r7 = a.c(r4, "isMuted");
        if (r7 == null) goto L13;
        r5 = r7.booleanValue();
    L13:
        r0.setMuted(r5);
        return r0;
    L9:
        r6 = false;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(UrgentInfo r4) {
        UrgentInfo r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "value");
        JsonObject r0 = new JsonObject();
        a.j(r0, "id", r5.getId());
        a.j(r0, "messageId", r5.getMessageId());
        a.h(r0, "sendTime", Long.valueOf(r5.getSendTime()));
        a.g(r0, "isClosed", Boolean.valueOf(r5.isClosed()));
        a.g(r0, "isMuted", Boolean.valueOf(r5.isMuted()));
        return r0;
    }
}
