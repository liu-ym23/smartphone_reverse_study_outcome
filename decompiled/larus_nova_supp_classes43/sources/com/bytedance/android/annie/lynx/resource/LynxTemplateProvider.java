package com.bytedance.android.annie.lynx.resource;

import android.net.Uri;
import android.os.AsyncTask;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.service.preload.PreLoadUtils;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxEnv;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LynxTemplateProvider extends d8a.b implements com.bytedance.android.annie.card.base.d {
    public final com.bytedance.android.annie.service.resource.g a;
    public volatile boolean b;
    public final ConcurrentHashMap<String, com.bytedance.android.annie.service.resource.h> c;
    public final d8a.b d;
    public c e;
    public com.bytedance.android.annie.card.base.c f;
    public String g;

    @Override // com.bytedance.android.annie.card.base.d
    public final ConcurrentHashMap<String, com.bytedance.android.annie.service.resource.h> a() {
        return this.c;
    }

    public LynxTemplateProvider(com.bytedance.android.annie.service.resource.g r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.a = r10;
        this.c = new ConcurrentHashMap();
        if (com.bytedance.android.annie.ng.g.b().c.c == false) goto L7;
        ConcurrentHashMap<String, d8.b> r0 = e8.d.a;
        f8.d r11 = e8.d.a(r10.f).f;
        if (r11 == null) goto L7;
        d8a.b r12 = r11.provide();
    L8:
        if (r12 != null) goto L10;
        r12 = LynxEnv.inst().getTemplateProvider();
    L10:
        this.d = r12;
        return;
    L7:
        r12 = null;
        goto L8
    }

    public final void loadTemplate(String r10, d8a.b.a r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        c r0 = this.e;
        if (r0 == null) goto L18;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        Object r12 = Result.constructor-impl(UriProtector.parse(r10));     // Catch: Throwable -> L6
    L8:
        String r13 = null;
        if (Result.isFailure-impl(r12) == false) goto L11;
        r12 = null;
    L11:
        Uri r14 = (Uri) r12;
        if (r14 == null) goto L14;
        r13 = r14.getPath();
    L14:
        if (r13 != null) goto L16;
        r13 = "";
    L16:
        r0.b(r10, r13);
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        if (this.b == false) goto L24;
        c r16 = this.e;
        if (r16 == null) goto L50;
        r16.a(new com.bytedance.android.annie.card.web.resource.a(false, "cdn", 0, false));
        return;
    L50:
        return;
    L24:
        if (this.a.a == false) goto L26;
    L29:
        LinkedHashMap r17 = new LinkedHashMap();
        com.bytedance.android.annie.card.base.c r18 = this.f;
        if (r18 == null) goto L32;
        r18.b(r10, AnnieResType.LYNX_TEMPLATE, IHybridComponent.HybridType.LYNX, r17);
    L32:
        PreLoadUtils r19 = PreLoadUtils.a;
        String r20 = this.g;
        r19.getClass();
        boolean r21 = CollectionsKt.contains(((com.bytedance.android.annie.service.preload.b) PreLoadUtils.b.getValue()).b, r20);
        String r22 = this.g;
        if (r22 != null) goto L35;
    L38:
        boolean r23 = true;
    L39:
        if (r23 == true) goto L43;
        if (r21 == false) goto L43;
        r10 = this.g;
        Intrinsics.checkNotNull(r10);
    L43:
        String r24 = r10;
        if (AnnieConfigSettingKeys.FOREST_LOAD_RESOURCE_IN_MAIN.a().booleanValue() == false) goto L46;
        b(r24, r11, true, r17, r21);
        return;
    L46:
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new g(this, r24, r11, r17, r21));
        return;
    L35:
        if (StringsKt.isBlank(r22) == true) goto L38;
        r23 = false;
        goto L39
    L26:
        if (AnnieConfigSettingKeys.OFFLINE_SWITCH.a().booleanValue() == false) goto L29;
        this.d.loadTemplate(r10, new f(this, r11));
    }

    public final void b(final String r10, final d8a.b.a r11, boolean r12, Map<String, Object> r13, boolean r14) {
        RequestConfig r0 = new RequestConfig(AnnieResType.LYNX_TEMPLATE);
        r0.c = n.c(IHybridComponent.HybridType.LYNX);
        r0.f = r12;
        r0.g = r14;
        com.bytedance.android.annie.service.resource.g r15 = this.a;
        r0.l = r15.e;
        if (r15.c == false) goto L5;
        r0.h = r15.d;
    L5:
        r0.a().putAll(r13);
        com.bytedance.android.annie.service.resource.h r16 = n.g(r10, r0, new LynxTemplateProvider$realLoadResource$2(this, r10, r11));
        if (r16 == null) goto L9;
        this.c.put(r10, r16);
        return;
    }
}
