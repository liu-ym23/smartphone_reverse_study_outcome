package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.chat.entity.chat.ChatTeamInfo;
import com.ss.android.lark.chat.entity.chat.TeamChatType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ChatTeamInfoTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/chat/entity/chat/ChatTeamInfo;", "teamChatTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/chat/entity/chat/TeamChatType;", "<init>", "(Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTeamInfoTypeAdapter extends JsonTreeTypeAdapter<ChatTeamInfo> {
    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final ChatTeamInfo a(JsonObject r6) {
        Intrinsics.checkNotNullParameter(r6, "json");
        Long r1 = a.f(r6, "teamId");
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        TeamChatType r3 = (TeamChatType) a.k(r6, "teamChatType", null);
        if (r3 != null) goto L9;
        r3 = (TeamChatType) a.d(TeamChatType.class);
    L9:
        Boolean r7 = a.c(r6, "discoverable");
        if (r7 == null) goto L12;
        boolean r8 = r7.booleanValue();
    L14:
        return new ChatTeamInfo(r2, r3, r8);
    L12:
        r8 = false;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(ChatTeamInfo r5) {
        ChatTeamInfo r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        JsonObject r0 = new JsonObject();
        a.h(r0, "teamId", Long.valueOf(r6.teamId));
        a.i(r0, "teamChatType", r6.teamChatType, null);
        a.g(r0, "discoverable", Boolean.valueOf(r6.discoverable));
        return r0;
    }
}
