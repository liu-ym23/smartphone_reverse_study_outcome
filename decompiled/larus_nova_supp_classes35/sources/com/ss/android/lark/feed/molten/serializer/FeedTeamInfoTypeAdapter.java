package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.biz.im.api.FeedTeamInfo;
import com.ss.android.lark.chat.entity.chat.TeamChatType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/FeedTeamInfoTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/biz/im/api/FeedTeamInfo;", "teamChatTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/chat/entity/chat/TeamChatType;", "<init>", "(Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedTeamInfoTypeAdapter extends JsonTreeTypeAdapter<FeedTeamInfo> {
    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final FeedTeamInfo a(JsonObject r8) {
        Intrinsics.checkNotNullParameter(r8, "json");
        Long r1 = a.f(r8, "teamId");
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        long r3 = r2;
        String r4 = a.l(r8, "teamName");
        if (r4 != null) goto L9;
        r4 = BuildConfig.FLAVOR;
    L9:
        String r5 = r4;
        TeamChatType r6 = (TeamChatType) a.k(r8, "teamChatType", null);
        if (r6 != null) goto L13;
        r6 = (TeamChatType) a.d(TeamChatType.class);
    L13:
        return new FeedTeamInfo(r3, r5, r6, a.f(r8, "orderWeight"));
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(FeedTeamInfo r5) {
        FeedTeamInfo r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        JsonObject r0 = new JsonObject();
        a.h(r0, "teamId", Long.valueOf(r6.teamId));
        a.j(r0, "teamName", r6.teamName);
        a.i(r0, "teamChatType", r6.teamChatType, null);
        a.h(r0, "orderWeight", r6.orderWeight);
        return r0;
    }
}
