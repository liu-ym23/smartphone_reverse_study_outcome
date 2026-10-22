package com.bytedance.ies.bullet.prefetchv2;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5844c;
    public final ArrayList d;

    public e(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        this.f5842a = "";
        this.f5843b = "";
        this.f5844c = "";
        this.d = new ArrayList();
        this.f5842a = r5.optString("type");
        this.f5843b = r5.optString(STGroup.DICT_KEY);
        this.f5844c = r5.optString("operator");
        JSONArray r10 = r5.optJSONArray("value");
        if (r10 == null) goto L10;
        ArrayList r11 = new ArrayList();
        int r12 = r10.length();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        r11.add(r10.optString(r13));
        r13 = r13 + 1;
        goto L5
    L7:
        this.d = r11;
        return;
    }
}
