package com.bytedance.ai.ex.widget.jsb;

import com.bytedance.ai.ex.widget.donate.EntityType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toAppEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/bytedance/ai/ex/widget/jsb/AbsAddBizEntityMethodIDL$AddBizEntityMethodParamModel;", "widget-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AddBizEntityMethodKt {
    public static final AppEntity toAppEntity(AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        EntityType r10 = EntityType.Companion.fromValue(r5.getEntityTpe());
        if (r10 == null) goto L12;
        Gson r11 = new Gson();
        JsonObject r12 = JsonParser.parseString(r5.getEntityParams()).getAsJsonObject();
        if (r12.get("type") != null) goto L8;
        r12.addProperty("type", Integer.valueOf(r10.getCode()));
    L8:
        if (r12.get("id") != null) goto L11;
        r12.addProperty("id", String.valueOf(System.currentTimeMillis()));
    L11:
        return (AppEntity) r11.fromJson(r12, r10.getType());
    L12:
        return null;
    }
}
