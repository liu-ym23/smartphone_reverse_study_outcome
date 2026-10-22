package com.bytedance.android.anniex.scene.next.element;

import android.net.Uri;
import com.bytedance.android.anniex.scene.handler.idle.TaskType;
import com.bytedance.android.anniex.scene.handler.idle.b;
import com.bytedance.android.anniex.scene.handler.idle.c;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ResPreloadElement implements wa.a<xa.a> {
    public static final int a = 0;
    public static final ResPreloadElement$Companion$preloadUrlMap$1 b = null;

    public static final class a {
    }

    public ResPreloadElement() {
    }

    static {
        int r0 = ((Number) SwitchCenter.d0.getValue()).intValue();
        a = r0;
        b = new ResPreloadElement$Companion$preloadUrlMap$1(r0);
    }

    public static final void b(ResPreloadElement r10, HashSet r11) {
        r10.getClass();
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L15;
        final String r1 = (String) r12.next();
        Uri r13 = UriProtector.parse(r1);
        if (Intrinsics.areEqual(r13.getScheme(), "http") == false) goto L8;
    L11:
        boolean r14 = GeckoXAdapter.Companion.canParsed(r13);
    L12:
        if (r14 == true) goto L13;
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.f("PredictManager", "forest can not parsed url:" + r1, null, 12);
        goto L4
    L13:
        b.put(r1, Boolean.TRUE);
        f r16 = ForestLoader.a;
        ForestLoader.f(null, r1, "ttnet", Scene.LYNX_TEMPLATE, null, null, true, null, new ResPreloadElement$forestPreloadUrls$1$1(r1), 161);
        goto L4
    L8:
        if (Intrinsics.areEqual(r13.getScheme(), "https") == true) goto L11;
        r14 = true;
        goto L12
    }

    public static final void c(ResPreloadElement r10, HashSet r11) {
        r10.getClass();
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L16;
        String r13 = (String) r12.next();
        Uri r14 = UriProtector.parse(r13);     // Catch: Exception -> L14
        if (Intrinsics.areEqual(r14.getScheme(), "http") == true) goto L12;
        if (Intrinsics.areEqual(r14.getScheme(), "https") == true) goto L12;
        HybridLogger r15 = HybridLogger.a;     // Catch: Exception -> L14
        HybridLogger.f("PredictManager", "Skipping non-HTTP/HTTPS URL: " + r13, null, 12);     // Catch: Exception -> L14
    L12:
        String r16 = r14.getScheme() + "://" + r14.getHost();     // Catch: Exception -> L14
        vq7.a.a(r16);     // Catch: Exception -> L14
        HybridLogger r17 = HybridLogger.a;     // Catch: Exception -> L14
        HybridLogger.f("PredictManager", "Preconnect to domain: " + r16, null, 12);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        HybridLogger r18 = HybridLogger.a;
        HybridLogger.i("PredictManager", "Error processing URL for preconnect: " + r13 + ", error: " + e.getMessage(), null, 12);
        goto L4
    }

    public static final Pair d(ResPreloadElement r10, List r11) {
        r10.getClass();
        HashSet r12 = new HashSet();
        HashSet r0 = new HashSet();
        int r1 = ((Number) SwitchCenter.f0.getValue()).intValue();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r11.iterator();
    L3:
        boolean r15 = false;
        if (r14.hasNext() == false) goto L10;
        Object r16 = r14.next();
        if (((xa.a) r16).b.size() > r1) goto L8;
        r15 = true;
    L8:
        if (r15 == false) goto L3;
        r13.add(r16);
        goto L3
    L10:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r13.iterator();
    L12:
        if (r18.hasNext() == false) goto L14;
        CollectionsKt.addAll(r17, ((xa.a) r18.next()).b);
        goto L12
    L14:
        Iterator r19 = r17.iterator();
    L16:
        if (r19.hasNext() == false) goto L22;
        String r20 = (String) r19.next();
        if (StringsKt.endsWith$default(r20, ".html", false, 2, null) == true) goto L19;
        r12.add(r20);
        goto L16
    L19:
        r0.add(r20);
        goto L16
    L22:
        return new Pair(r12, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wa.a
    public final b a(String r10, final List r11) {
        Intrinsics.checkNotNullParameter(r10, "currentSceneId");
        Intrinsics.checkNotNullParameter(r11, "input");
        if (((ArrayList) r11).isEmpty() == false) goto L6;
        return null;
    L6:
        c.a r0 = new c.a();
        Intrinsics.checkNotNullParameter(r10, "group");
        r0.a = r10;
        r0.c = 100;
        r0.d = 10000;
        r0.e = 0;
        r0.f = false;
        r0.g = r11;
        Intrinsics.checkNotNullParameter("view_pre_create", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        r0.b = "view_pre_create";
        Function1<List<? extends xa.a>, Unit> r12 = new ResPreloadElement$createTaskForPrediction$1(this, r11);
        Intrinsics.checkNotNullParameter(r12, "r");
        r0.h = r12;
        return r0.a(TaskType.NEXT_THRESHOLD_PREDICT);
    }
}
