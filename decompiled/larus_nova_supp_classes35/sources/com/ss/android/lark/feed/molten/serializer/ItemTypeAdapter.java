package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.chat.entity.Item;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ItemTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/chat/entity/Item;", "itemTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/chat/entity/Item$Type;", "<init>", "(Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemTypeAdapter extends JsonTreeTypeAdapter<Item> {
    public final TypeAdapter<Item.Type> a;

    public ItemTypeAdapter(TypeAdapter<Item.Type> r2) {
        Intrinsics.checkNotNullParameter(r2, "itemTypeAdapter");
        this.a = r2;
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final Item a(JsonObject r14) {
        Intrinsics.checkNotNullParameter(r14, "json");
        Long r1 = a.f(r14, "id");
        if (r1 == null) goto L5;
        long r4 = r1.longValue();
    L6:
        String r2 = a.l(r14, "entityId");
        if (r2 != null) goto L9;
        r2 = BuildConfig.FLAVOR;
    L9:
        String r6 = r2;
        Item.Type r3 = (Item.Type) a.k(r14, "entityType", this.a);
        if (r3 != null) goto L12;
        r3 = (Item.Type) a.d(Item.Type.class);
    L12:
        Item.Type r7 = r3;
        Long r8 = a.f(r14, "parentId");
        Long r9 = a.f(r14, "orderWeight");
        String r10 = a.l(r14, "nameWeight");
        Long r5 = a.f(r14, Keys.API_RETURN_KEY_VERSION);
        if (r5 == null) goto L15;
        long r11 = r5.longValue();
    L16:
        Boolean r15 = a.c(r14, "isHidden");
        if (r15 == null) goto L19;
        boolean r16 = r15.booleanValue();
    L21:
        return new Item(r4, r6, r7, r8, r9, r10, r11, r16);
    L19:
        r16 = false;
        goto L21
    L15:
        r11 = 0;
        goto L16
    L5:
        r4 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(Item r5) {
        Item r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        JsonObject r0 = new JsonObject();
        a.h(r0, "id", Long.valueOf(r6.getId()));
        a.j(r0, "entityId", r6.getEntityId());
        a.i(r0, "entityType", r6.getEntityType(), this.a);
        a.h(r0, "parentId", r6.getParentId());
        a.h(r0, "orderWeight", r6.getOrderWeight());
        a.j(r0, "nameWeight", r6.getNameWeight());
        a.h(r0, Keys.API_RETURN_KEY_VERSION, Long.valueOf(r6.getVersion()));
        a.g(r0, "isHidden", Boolean.valueOf(r6.isHidden()));
        return r0;
    }
}
