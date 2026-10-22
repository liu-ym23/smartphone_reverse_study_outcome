package com.bytedance.android.livesdk.interactivity.service.richcontent.config;

import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.LiveImageResourceLoader;
import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.LiveNinePatchResourceLoader;
import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.g;
import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.h;
import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.l;
import ek6.d;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import ob2.e;
import ob2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LiveRichContentConfig implements ak6.b.a {
    public final a a;
    public final LiveImageResourceLoader b;
    public final LiveNinePatchResourceLoader c;
    public final Map<Class<? extends ek6.b>, hk6.b<? extends ek6.b>> d;
    public final Map<Class<? extends d>, ik6.a<? extends d>> e;
    public final List<ik6.c> f;
    public final LiveRichContentConfig$executorServiceProvider$1 g;

    /* JADX WARN: Type inference failed for: r0v18, types: [com.bytedance.android.livesdk.interactivity.service.richcontent.config.LiveRichContentConfig$executorServiceProvider$1] */
    public LiveRichContentConfig() {
        this.a = a.a;
        LiveImageResourceLoader r0 = new LiveImageResourceLoader();
        this.b = r0;
        LiveNinePatchResourceLoader r1 = new LiveNinePatchResourceLoader();
        this.c = r1;
        this.d = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ob2.d.class, new g()), TuplesKt.to(ob2.c.class, r0), TuplesKt.to(ob2.a.class, new com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.a()), TuplesKt.to(ob2.g.class, new l()), TuplesKt.to(e.class, new h()), TuplesKt.to(f.class, r1), TuplesKt.to(ob2.b.class, new com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.b())});
        this.e = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(jb2.d.class, new kb2.b()), TuplesKt.to(jb2.c.class, new kb2.a()), TuplesKt.to(jb2.e.class, new kb2.c()), TuplesKt.to(jb2.f.class, new kb2.d())});
        this.f = CollectionsKt.mutableListOf(new ik6.c[]{new nb2.a()});
        this.g = new LiveRichContentConfig$executorServiceProvider$1();
    }

    public final List<ik6.c> a() {
        return this.f;
    }

    public final Map<Class<? extends ek6.b>, hk6.b<? extends ek6.b>> b() {
        return this.d;
    }

    public final Map<Class<? extends d>, ik6.a<? extends d>> c() {
        return this.e;
    }
}
