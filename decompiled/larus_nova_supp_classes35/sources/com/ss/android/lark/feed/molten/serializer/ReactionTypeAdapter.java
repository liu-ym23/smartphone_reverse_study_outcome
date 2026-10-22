package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ReactionTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/chat/entity/reaction/Reaction;", "<init>", "()V", "stringListAdapter", "Lcom/ss/android/lark/feed/molten/serializer/ListTypeAdapter;", BuildConfig.FLAVOR, "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactionTypeAdapter extends JsonTreeTypeAdapter<Reaction> {
    public final ListTypeAdapter<String> a;

    public ReactionTypeAdapter() {
        this.a = new ListTypeAdapter(new ReactionTypeAdapter$stringListAdapter$1());
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final Reaction a(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "json");
        Reaction r0 = new Reaction();
        r0.setType(a.l(r4, IPortraitService.TYPE));
        Integer r1 = a.e(r4, "count");
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        r0.setCount(r2);
        r0.setChatterIds(a.b(r4, "chatterIds", this.a));
        r0.setMessageId(a.l(r4, "messageId"));
        return r0;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(Reaction r5) {
        Reaction r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        JsonObject r0 = new JsonObject();
        a.j(r0, IPortraitService.TYPE, r6.getType());
        a.h(r0, "count", Integer.valueOf(r6.getCount()));
        a.a(r0, "chatterIds", r6.getChatterIds(), this.a);
        a.j(r0, "messageId", r6.getMessageId());
        return r0;
    }
}
