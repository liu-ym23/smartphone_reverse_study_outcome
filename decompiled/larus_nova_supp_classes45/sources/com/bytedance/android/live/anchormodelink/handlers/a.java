package com.bytedance.android.live.anchormodelink.handlers;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements iy.e {
    public final JsonObject a;

    /* JADX INFO: renamed from: com.bytedance.android.live.anchormodelink.handlers.a$a, reason: collision with other inner class name */
    public static final class C0008a {
    }

    static {
    }

    @Override // iy.e
    public final void onStart() {
    }

    @Override // iy.e
    public final void onStop() {
    }

    public a() {
        this.a = new JsonObject();
    }

    @Override // iy.e
    public final JsonObject C(my.b r5) {
        Intrinsics.checkNotNullParameter(r5, "getStatusData");
        jy0.b.d("DynamicCenterBasicHandler", "type: " + r5.getType() + ", extraInfo=" + r5.b);
        if (b.b[r5.getType().ordinal()] != 1) goto L15;
        JsonObject r6 = r5.b;
        if (r6 != null) goto L8;
        return null;
    L8:
        JsonElement r7 = r6.get("key");
        if (r7 == null) goto L11;
        String r8 = r7.getAsString();
    L12:
        if (r8 == null) goto L15;
        JsonElement r0 = this.a.get(r8);
        JsonObject r2 = new JsonObject();
        r2.add("value", r0);
        jy0.b.d("DynamicCenterBasicHandler", "getLinkMicStatus key=" + r8 + ", result=" + r2);
        return r2;
    L11:
        r8 = null;
    L15:
        return null;
    }

    @Override // iy.e
    public final boolean a(DynamicCenterUpdateType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r2 != DynamicCenterUpdateType.common_set_data) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // iy.e
    public final boolean c(DynamicCenterGetType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r2 != DynamicCenterGetType.common_get_data) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // iy.e
    public final void b(my.c r5, k r6) {
        Intrinsics.checkNotNullParameter(r5, "updateStatus");
        Intrinsics.checkNotNullParameter(r6, "updateCallback");
        jy0.b.d("DynamicCenterBasicHandler", "type: " + r5.getType() + ", extraInfo=" + r5.b);
        if (b.a[r5.getType().ordinal()] != 1) goto L14;
        JsonObject r7 = r5.b;
        if (r7 == null) goto L14;
        JsonElement r0 = r7.get("key");
        if (r0 == null) goto L10;
        String r1 = r0.getAsString();
    L11:
        JsonElement r8 = r7.get("data");
        if (r1 == null) goto L14;
        this.a.add(r1, r8);
        goto L14
    L10:
        r1 = null;
    L14:
        r6.a(1, "", null);
    }
}
