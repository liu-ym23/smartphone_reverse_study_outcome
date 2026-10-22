package vka;

import android.database.Cursor;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n {
    public static final JsonElement a(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "name");
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L5;
    L7:
        return null;
    L5:
        if ((!r3.isJsonNull()) == false) goto L7;
        return r3;
    }

    public static final JsonArray b(Cursor r2, boolean r3) {
        JsonArray r0 = new JsonArray();
        if (r2 != null) goto L5;
        return r0;
    L5:
        if (r3 == false) goto L7;
        Function1 r4 = new l();
    L9:
        if (r2.moveToNext() == false) goto L11;
        r0.add((JsonElement) r4.invoke(r2));
        goto L9
    L11:
        return r0;
    L7:
        r4 = new m();
        goto L9
    }
}
