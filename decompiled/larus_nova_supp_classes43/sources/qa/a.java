package qa;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.base.i0;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t36.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements i0 {
    public final Scenes a;
    public final String b;
    public final String c;
    public final KitType d;
    public final String e;
    public final j f;
    public Context g;
    public final m16.b h;
    public final Map<String, Object> i;

    public final void release() {
        this.g = null;
        m16.b r0 = this.h;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public final Context getContext() {
        return this.g;
    }

    public a(Scenes r10, String r11, String r12, Bundle r13, String r14, KitType r15, j r16) {
        Intrinsics.checkNotNullParameter(r10, "scenes");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r13, "bundle");
        Intrinsics.checkNotNullParameter(r14, "originSchema");
        Intrinsics.checkNotNullParameter(r15, "kitType");
        Intrinsics.checkNotNullParameter(r16, "schemaModelUnion");
        this.h = new m16.b();
        this.i = new LinkedHashMap();
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.e = r14;
        this.d = r15;
        this.f = r16;
    }
}
