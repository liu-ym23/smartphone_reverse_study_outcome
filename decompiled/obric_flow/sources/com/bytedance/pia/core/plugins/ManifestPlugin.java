package com.bytedance.pia.core.plugins;

import ai.p;
import android.app.Application;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.i;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.l;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import nh.c;
import nh.d;
import zg.b;

/* JADX INFO: loaded from: classes2.dex */
public class ManifestPlugin extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f7045c;

    public ManifestPlugin(d r5) {
        super(r5);
        this.f7045c = new AtomicReference(null);
    }

    @Override // nh.c
    public final String c() {
        return "manifest";
    }

    @Override // nh.c
    public final void e(String r10, Object... r11) {
        if ("event-on-manifest-in-html-ready".equals(r10) == false) goto L19;
        boolean r12 = false;
        Object r13 = r11[0];
        if ((r13 instanceof JsonObject) == false) goto L20;
        d r5 = this.f20236b;
        if (r5.d.e() == false) goto L9;
        r5.f20245p.h((JsonObject) r13);
    L9:
        Lazy r14 = Settings.B;
        String r15 = r5.f;
        Intrinsics.checkNotNullParameter(r15, "url");
        Application r16 = b.f23438a;
        Pair r17 = (Pair) l.f7154a.get("openManifestCacheInt");
        if (r17 != null) goto L12;
    L14:
        boolean r18 = com.bytedance.pia.core.setting.d.f7088a;
    L15:
        if (r12 == false) goto L17;
        Intrinsics.checkNotNullParameter(r15, "url");
    L17:
        h((JsonObject) r13);
        return;
    L12:
        if (((Number) r17.getFirst()).intValue() != 5000) goto L14;
        r12 = ((Boolean) r17.getSecond()).booleanValue();
        goto L15
    L20:
        return;
    }

    @Override // nh.c
    public final void f() {
        d r5 = this.f20236b;
        String r10 = r5.f;
        Lazy r11 = Settings.B;
        Intrinsics.checkNotNullParameter(r10, "url");
        Application r12 = b.f23438a;
        Pair r13 = (Pair) l.f7154a.get("openManifestCacheInt");
        if (r13 != null) goto L5;
    L7:
        boolean r14 = com.bytedance.pia.core.setting.d.f7088a;
        boolean r15 = false;
    L8:
        if (r15 == false) goto L10;
        Intrinsics.checkNotNullParameter(r10, "url");
    L10:
        Intrinsics.checkNotNullParameter(r5.f, "url");
        if (r5.d.e() == false) goto L33;
        p r16 = r5.f20245p;
        r16.getClass();
        Object r17 = i.a().fromJson(((JsonObject) r16.f288c).get("manifest"), JsonObject.class);     // Catch: Throwable -> L16
    L18:
        JsonObject r18 = (JsonObject) r17;
        if (r18 == null) goto L34;
    L25:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Manifest] Get cached manifest version failed:", "message");
        j.x("[Manifest] Get cached manifest version failed:", th);
        return;
    L22:
        if (r18.get("version").getAsString().equals(r5.d.c()) == false) goto L32;
        r18.add("from", new JsonPrimitive("cache"));     // Catch: Throwable -> L25
        h(r18);     // Catch: Throwable -> L25
        return;
    L32:
        return;
    L34:
        return;
    L16:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[PageStorage]Get page info error:", "message");
        j.x("[PageStorage]Get page info error:", th);
        r17 = null;
        goto L18
    L33:
        return;
    L5:
        if (((Number) r13.getFirst()).intValue() != 5000) goto L7;
        r15 = ((Boolean) r13.getSecond()).booleanValue();
        goto L8
    }

    public final void h(JsonObject r5) {
        if (r5 == null) goto L17;
        AtomicReference r10 = this.f7045c;
    L6:
        if (r10.compareAndSet(null, r5) == true) goto L7;
        if (r10.get() == null) goto L6;
        return;
    L7:
        j.A("[manifest] use manifest:" + r5);
        d r11 = this.f20236b;
        r11.g("event-on-manifest-ready", new Object[]{r5});
        c r12 = r11.j("pia_props");
        if ((r12 instanceof PiaPropsPlugin) == false) goto L13;
        ((PiaPropsPlugin) r12).f7046c.add("getManifest", new JsonPrimitive(r5.toString()));
        return;
    L13:
        return;
    }
}
