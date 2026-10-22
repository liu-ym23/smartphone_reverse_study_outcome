package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.biz.im.api.MuteUrgentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/MuteUrgentInfoTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/biz/im/api/MuteUrgentInfo;", "<init>", "()V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MuteUrgentInfoTypeAdapter extends JsonTreeTypeAdapter<MuteUrgentInfo> {
    public MuteUrgentInfoTypeAdapter() {
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final MuteUrgentInfo a(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        return new MuteUrgentInfo(a.f(r5, "rankTime"), a.f(r5, "displayTime"), a.l(r5, "urgentContent"));
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(MuteUrgentInfo r4) {
        MuteUrgentInfo r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "value");
        JsonObject r0 = new JsonObject();
        a.h(r0, "rankTime", r5.getRankTime());
        a.h(r0, "displayTime", r5.getDisplayTime());
        a.j(r0, "urgentContent", r5.getUrgentContent());
        return r0;
    }
}
