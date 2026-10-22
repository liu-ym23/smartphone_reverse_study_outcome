package com.bytedance.android.annie.card.web.resource;

import com.bytedance.android.annie.card.base.c;
import com.bytedance.android.annie.card.base.d;
import com.bytedance.android.annie.service.resource.g;
import com.bytedance.android.annie.service.resource.h;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class WebResourceProvider implements d {
    public static final boolean f = false;
    public static final Lazy<Boolean> g = null;
    public static final List<String> h = null;
    public static final Set<String> i = null;
    public static final Lazy<Collection<String>> j = null;
    public final g a;
    public volatile boolean b;
    public final ConcurrentHashMap<String, h> c;
    public c d;
    public String e;

    public static final class a {
    }

    static {
        f = AnnieConfigSettingKeys.DISABLE_WEB_VIEW_RETRY_RESOURCE.a().booleanValue();
        g = LazyKt.lazy(WebResourceProvider$Companion$forceUseForest$2.INSTANCE);
        h = CollectionsKt.mutableListOf(new String[]{".js", ".html", ".css"});
        i = SetsKt.setOf(new String[]{".js", ".html", ".css", ".json", ".ico", ".jpeg", ".webp", ".jpg", ".png", ".gif", ".wott", ".svg", ".ttf"});
        j = LazyKt.lazy(WebResourceProvider$Companion$AVAILABLE_SUFFIX_ALLOW_LIST$2.INSTANCE);
    }

    @Override // com.bytedance.android.annie.card.base.d
    public final ConcurrentHashMap<String, h> a() {
        return this.c;
    }

    public WebResourceProvider(g r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.a = r10;
        this.c = new ConcurrentHashMap();
    }
}
