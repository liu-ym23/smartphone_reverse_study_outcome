package com.obric.assistant.voice;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final ContentScene a;
    public final String b;
    public final long c;
    public ContentStatus d;
    public AppEvent e;
    public OAutoEvent f;
    public ComplexEvent g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String a() {
        JSONObject r0 = new JSONObject();
        r0.put("scene", this.a.getStr());
        r0.put("content", this.b);
        AppEvent r1 = this.e;
        if (r1 == null) goto L5;
        r0.put("appEvent", GsonProtectorUtils.toJson(new Gson(), r1));
    L5:
        OAutoEvent r2 = this.f;
        if (r2 == null) goto L8;
        r0.put("oautoEvent", GsonProtectorUtils.toJson(new Gson(), r2));
    L8:
        ComplexEvent r3 = this.g;
        if (r3 == null) goto L12;
        r0.put("complexEvent", GsonProtectorUtils.toJson(new Gson(), r3));
    L12:
        return r0.toString();
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("scene ");
        r0.append(this.a);
        r0.append(" content ");
        r0.append(this.b.length());
        r0.append(" status ");
        r0.append(this.d);
        r0.append(" payload is [ appEvent? ");
        boolean r2 = true;
        if (this.e == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(" --  oautoEvent ");
        if (this.f == null) goto L9;
        boolean r3 = true;
    L10:
        r0.append(r3);
        r0.append(" -- complexEvent ");
        if (this.g != null) goto L14;
        r2 = false;
    L14:
        r0.append(r2);
        r0.append(" -- content = ");
        r0.append(this.b);
        r0.append(" ]");
        return r0.toString();
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public a(ContentScene r4, String r5) {
        long r0 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "content");
        this.a = r4;
        this.b = r5;
        this.c = r0;
        this.d = ContentStatus.INIT;
    }
}
