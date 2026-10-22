package com.obric.memorydata.database.entity;

import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.obric.memorydata.database.entity.do, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u001a\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, d2 = {"getValAsStringList", "", "", "uriValue", "jsonKey", "parseValue", "Lcom/google/gson/JsonElement;", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Cdo {
    public static final List<String> a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "uriValue");
        Intrinsics.checkNotNullParameter(r2, "jsonKey");
        JsonElement r3 = b(r1, r2);
        if (r3 == null) goto L6;
        return com.obric.memorydata.utils.ab.a(r3, String.class);
    L6:
        return CollectionsKt.emptyList();
    }

    private static final JsonElement b(String r4, String r5) {
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return null;
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L11;
        r2 = false;
    L11:
        if (r2 == false) goto L14;
        return null;
    L14:
        return com.obric.memorydata.utils.ab.a(r4).get(r5);
    L5:
        r0 = false;
        goto L6
    }
}
