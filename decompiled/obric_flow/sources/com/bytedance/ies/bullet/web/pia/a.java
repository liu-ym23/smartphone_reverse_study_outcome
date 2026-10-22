package com.bytedance.ies.bullet.web.pia;

import com.bytedance.forest.model.t;
import com.bytedance.forest.model.w;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.pia.core.bridge.methods.l0;
import com.bytedance.pia.core.plugins.PreloadPlugin;
import com.bytedance.pia.core.tracing.EventName;
import com.lynx.tasm.ui.image.f0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements dh.c, fh.c, com.bytedance.forest.interceptor.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0 f6220c;

    public a() {
        this.f6219b = MD5Utils.stringToMd5("pia_preload") + '-' + hashCode() + '-' + System.currentTimeMillis();
    }

    @Override // dh.c
    public final void a(String r5, Map r10) {
        Intrinsics.checkNotNullParameter(r5, "mainUrl");
        Intrinsics.checkNotNullParameter(r10, "subResource");
        zm.c r11 = com.bytedance.ies.bullet.forest.f.f5397a;
        com.bytedance.ies.bullet.forest.f.i(new JSONObject(r10), this.f6219b);
    }

    @Override // dh.c
    public final void b(fh.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        f0.h("PiaCore", 60, "[Forest] [Preload] set listener.", false);
        com.bytedance.forest.interceptor.b.b(this);
        this.f6220c = (l0) r5;
    }

    @Override // com.bytedance.forest.interceptor.a
    public final void c(w r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        if (this.f6220c != null) goto L7;
        f0.n(4, "PiaCore", "[Forest] [Preload] " + r10.f4441q.getOriginUrl() + " finished but no perf listener injected");
        return;
    L7:
        if (r10.f4441q.isPreload() == false) goto L27;
        String r5 = r10.f4441q.getGroupId();
        if (r5 != null) goto L16;
        Object r11 = r10.f4441q.getCustomParams().get("rl_container_uuid");
        if ((r11 instanceof String) == false) goto L14;
        r5 = (String) r11;
        goto L16
    L14:
        r5 = null;
    L16:
        if (Intrinsics.areEqual(r5, this.f6219b) == true) goto L18;
        return;
    L18:
        ConcurrentHashMap r12 = r10.f4431c;
        Long r13 = (Long) r12.get("res_load_start");
        long r14 = 0;
        if (r13 == null) goto L21;
        long r15 = r13.longValue();
    L22:
        Long r16 = (Long) r12.get("res_load_finish");
        if (r16 == null) goto L25;
        r14 = r16.longValue();
    L25:
        f0.h("PiaCore", 60, "[Forest] [Preload] " + r10.f4441q.getOriginUrl() + " finished, perf=[" + r15 + ", " + r14 + ']', false);
        l0 r17 = this.f6220c;
        Intrinsics.checkNotNull(r17);
        String r18 = r10.f4441q.getOriginUrl();
        r17.getClass();
        nh.d r19 = ((PreloadPlugin) r17.f7000b).f20236b;
        com.google.common.reflect.w r20 = r19.f20247r;
        EventName r21 = EventName.f7098l;
        r20.getClass();
        com.bytedance.pia.core.tracing.d r22 = new com.bytedance.pia.core.tracing.d(r20, r21, r15);
        r22.d.put("url", r18);
        r22.a();
        EventName r23 = EventName.f7099m;
        com.google.common.reflect.w r24 = r19.f20247r;
        r24.getClass();
        com.bytedance.pia.core.tracing.d r25 = new com.bytedance.pia.core.tracing.d(r24, r23, r14);
        r25.d.put("url", r18);
        r25.a();
        return;
    L21:
        r15 = 0;
        goto L22
    }

    @Override // com.bytedance.forest.interceptor.a
    public final void d(String r5, t r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "requestParams");
    }

    @Override // fh.c
    public final void release() {
        f0.h("PiaCore", 60, "[Forest] [Preload] release preloader.", false);
        com.bytedance.forest.interceptor.b.e(this);
        this.f6220c = null;
    }
}
