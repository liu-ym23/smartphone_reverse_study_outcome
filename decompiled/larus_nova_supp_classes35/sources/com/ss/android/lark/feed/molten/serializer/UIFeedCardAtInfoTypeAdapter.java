package com.ss.android.lark.feed.molten.serializer;

import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/UIFeedCardAtInfoTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard$AtInfo;", "atTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/lark/pb/feed/v1/AtInfo$AtType;", "<init>", "(Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIFeedCardAtInfoTypeAdapter extends JsonTreeTypeAdapter<UIFeedCard.AtInfo> {
    public final TypeAdapter<AtInfo.AtType> a;

    public UIFeedCardAtInfoTypeAdapter(WireEnumTypeAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "atTypeAdapter");
        this.a = r2;
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final UIFeedCard.AtInfo a(JsonObject r7) {
        Intrinsics.checkNotNullParameter(r7, "json");
        UIFeedCard.AtInfo r0 = new UIFeedCard.AtInfo(a.l(r7, "id"), a.l(r7, "avatarKey"), a.l(r7, "localizedUserName"));
        Long r1 = a.f(r7, "atDisplayTime");
        long r2 = 0;
        if (r1 == null) goto L5;
        long r4 = r1.longValue();
    L6:
        r0.setAtDisplayTime(r4);
        Long r3 = a.f(r7, "atRankTime");
        if (r3 == null) goto L9;
        r2 = r3.longValue();
    L9:
        r0.setAtRankTime(r2);
        r0.setAtContent(a.l(r7, "atContent"));
        AtInfo.AtType r8 = (AtInfo.AtType) a.k(r7, "atType", this.a);
        if (r8 == null) goto L12;
        r0.setAtType(r8);
    L12:
        return r0;
    L5:
        r4 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(UIFeedCard.AtInfo r4) {
        UIFeedCard.AtInfo r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "value");
        JsonObject r0 = new JsonObject();
        a.j(r0, "id", r5.getId());
        a.j(r0, "avatarKey", r5.getAvatarKey());
        a.j(r0, "localizedUserName", r5.getLocalizedUserName());
        a.h(r0, "atDisplayTime", Long.valueOf(r5.getAtDisplayTime()));
        a.h(r0, "atRankTime", Long.valueOf(r5.getAtRankTime()));
        a.j(r0, "atContent", r5.getAtContent());
        a.i(r0, "atType", r5.getAtType(), this.a);
        return r0;
    }
}
