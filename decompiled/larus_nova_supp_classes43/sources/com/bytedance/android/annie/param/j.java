package com.bytedance.android.annie.param;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final j b = null;
    public final /* synthetic */ i a;

    static {
        b = new j();
    }

    public final k a() {
        this.a.getClass();
        k r0 = i.b;
        if (r0 == null) goto L5;
        Gson r1 = new Gson();
        return (k) GsonProtectorUtils.fromJson(r1, GsonProtectorUtils.toJson(r1, r0), k.class);
    L5:
        return null;
    }

    public final boolean b() {
        this.a.getClass();
        k r0 = i.b;
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (Intrinsics.areEqual(r0.f(), "") == true) goto L13;
        k r1 = i.b;
        if (r1 == null) goto L9;
        String r10 = r1.A();
    L11:
        if (Intrinsics.areEqual(r10, "0") == true) goto L13;
        return true;
    L9:
        r10 = null;
        goto L11
    }

    public j() {
        this.a = i.a;
    }
}
