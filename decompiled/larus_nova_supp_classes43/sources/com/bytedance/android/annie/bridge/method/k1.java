package com.bytedance.android.annie.bridge.method;

import com.bytedance.forest.Forest;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k1<T, R> implements Function {
    public final /* synthetic */ e7.p0 a;
    public final /* synthetic */ n1 b;

    public k1(e7.p0 r1, n1 r10) {
        this.a = r1;
        this.b = r10;
    }

    public final Object apply(Object r10) {
        Intrinsics.checkNotNullParameter((Integer) r10, "it");
        com.bytedance.ies.bullet.forest.f r11 = ForestLoader.a;
        Forest r0 = ForestLoader.d();
        String r1 = this.a.b();
        JsonObject r12 = this.a.c();
        if (r12 == null) goto L5;
        JSONObject r13 = new JSONObject(r12.toString());
    L6:
        m16.b r14 = this.b.a;
        if (r14 == null) goto L12;
        BulletContext r15 = (BulletContext) r14.c(BulletContext.class);
        if (r15 == null) goto L12;
        String r16 = r15.getSessionId();
        if (r16 == null) goto L12;
    L13:
        String r17 = r16;
        if (Intrinsics.areEqual(this.a.a(), "web") == false) goto L16;
        PreloadType r18 = PreloadType.WEB;
    L18:
        return Integer.valueOf(ForestLoader.j(r0, r1, r13, "jsb", r17, r18, null, false, 192));
    L16:
        r18 = PreloadType.LYNX;
    L12:
        r16 = "";
        goto L13
    L5:
        r13 = null;
        goto L6
    }
}
