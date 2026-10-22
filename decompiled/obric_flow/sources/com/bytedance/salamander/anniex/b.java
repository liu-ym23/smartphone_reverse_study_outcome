package com.bytedance.salamander.anniex;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.rts.foundation.RTSArrayKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static ArrayList a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObj");
        ArrayList r10 = new ArrayList();
        Iterator<String> r11 = r5.keys();
        if (r11 != null) goto L5;
    L7:
        return r10;
    L5:
        if (r11.hasNext() == false) goto L7;
        RTSArrayKt.push(r10, r11.next());
        goto L5
    }

    public static JSONObject b(String r5, JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "jsonObj");
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        JSONObject r12 = r10.optJSONObject(r5);
        if (r12 != null) goto L5;
        return r11;
    L5:
        return r12;
    }
}
