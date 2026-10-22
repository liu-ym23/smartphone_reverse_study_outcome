package com.bytedance.android.live.impl.service;

import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import j40.c0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class FeedFeatureManager implements z90.b {
    public static final List<String> a = null;
    public static final Lazy b = null;
    public static final FeedFeatureManager c = null;

    public FeedFeatureManager() {
    }

    static {
        c = new FeedFeatureManager();
        a = c0.a.getValue().getFeedFeatureProducerList();
        b = LazyKt.lazy(FeedFeatureManager$producer$2.INSTANCE);
    }

    public static JSONObject b(String r11) {
        Intrinsics.checkNotNullParameter(r11, "featureName");
        List<String> r2 = a;
        if (r2 != null) goto L5;
        return null;
    L5:
        final String r4 = StringsKt.removePrefix(r11, "aweme_");
        Iterator<String> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L25;
        String r5 = r3.next();
        if (StringsKt.startsWith$default(r4, r5 + '_', false, 2, null) == false) goto L7;
        String r6 = StringsKt.removePrefix(r4, r5 + '_');
        Intrinsics.checkNotNullParameter(r5, "producerName");
        Intrinsics.checkNotNullParameter(r6, "featureName");
        IMiddlewareHostAction.ILiveFeedFeatureProducer r1 = (IMiddlewareHostAction.ILiveFeedFeatureProducer) b.getValue();
        if (r1 == null) goto L13;
        final JSONObject r7 = r1.getDictFeature(r5, r6, null);
    L19:
        boolean r8 = com.bytedance.android.live.impl.utils.a.a;     // Catch: Exception -> L16
        com.bytedance.android.live.impl.utils.a.c("LFM-FeedFeatureManager", new FeedFeatureManager$getFeature$1(r4, r7));     // Catch: Exception -> L16
        z90.a.C0301a.a(FeatureManager.u, r11, r7);     // Catch: Exception -> L16
        return r7;
    L16:
        e = move-exception;
        boolean r9 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeedFeatureManager", new FeedFeatureManager$getFeature$2(r4, e), null);
        return null;
    L13:
        r7 = null;
        goto L19
    L25:
        return null;
    }

    public static Object a(String r11, Object r12) {
        Intrinsics.checkNotNullParameter(r11, "featureName");
        List<String> r1 = a;
        if (r1 != null) goto L5;
        return null;
    L5:
        final String r3 = StringsKt.removePrefix(r11, "aweme_");
        if ((r12 instanceof Number) == false) goto L20;
        Iterator<String> r13 = r1.iterator();
    L9:
        if (r13.hasNext() == false) goto L84;
        String r0 = r13.next();
        if (StringsKt.startsWith$default(r3, r0 + '_', false, 2, null) == false) goto L9;
        final Number r14 = c(r0, StringsKt.removePrefix(r3, r0 + '_'));     // Catch: Exception -> L16
        boolean r2 = com.bytedance.android.live.impl.utils.a.a;     // Catch: Exception -> L16
        com.bytedance.android.live.impl.utils.a.c("LFM-FeedFeatureManager", new FeedFeatureManager$getFeature$3(r3, r14));     // Catch: Exception -> L16
        z90.a.C0301a.a(FeatureManager.u, r11, r14);     // Catch: Exception -> L16
        if ((r14 instanceof Object) == true) goto L76;
        return null;
    L76:
        return r14;
    L16:
        e = move-exception;
        boolean r15 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeedFeatureManager", new FeedFeatureManager$getFeature$4(r3, e), null);
        return null;
    L84:
        return null;
    L20:
        if ((r12 instanceof String) == false) goto L38;
        Iterator<String> r16 = r1.iterator();
    L23:
        if (r16.hasNext() == false) goto L85;
        String r4 = r16.next();
        if (StringsKt.startsWith$default(r3, r4 + '_', false, 2, null) == false) goto L23;
        String r17 = StringsKt.removePrefix(r3, r4 + '_');     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r4, "producerName");     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r17, "featureName");     // Catch: Exception -> L34
        IMiddlewareHostAction.ILiveFeedFeatureProducer r5 = (IMiddlewareHostAction.ILiveFeedFeatureProducer) b.getValue();     // Catch: Exception -> L34
        if (r5 == null) goto L29;
        final String r18 = r5.getStringFeature(r4, r17, null);     // Catch: Exception -> L34
    L30:
        boolean r6 = com.bytedance.android.live.impl.utils.a.a;     // Catch: Exception -> L34
        com.bytedance.android.live.impl.utils.a.c("LFM-FeedFeatureManager", new FeedFeatureManager$getFeature$5(r3, r18));     // Catch: Exception -> L34
        z90.a.C0301a.a(FeatureManager.u, r11, r18);     // Catch: Exception -> L34
        if ((r18 instanceof Object) == true) goto L78;
        return null;
    L78:
        return r18;
    L29:
        r18 = null;
    L34:
        e = move-exception;
        boolean r19 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeedFeatureManager", new FeedFeatureManager$getFeature$6(r3, e), null);
        return null;
    L85:
        return null;
    L38:
        if ((r12 instanceof JSONObject) == true) goto L64;
        Iterator<String> r110 = r1.iterator();
    L48:
        if (r110.hasNext() == false) goto L86;
        String r7 = r110.next();
        if (StringsKt.startsWith$default(r3, r7 + '_', false, 2, null) == false) goto L48;
        String r111 = StringsKt.removePrefix(r3, r7 + '_');     // Catch: Exception -> L59
        Intrinsics.checkNotNullParameter(r7, "producerName");     // Catch: Exception -> L59
        Intrinsics.checkNotNullParameter(r111, "featureName");     // Catch: Exception -> L59
        IMiddlewareHostAction.ILiveFeedFeatureProducer r8 = (IMiddlewareHostAction.ILiveFeedFeatureProducer) b.getValue();     // Catch: Exception -> L59
        if (r8 == null) goto L54;
        final Object r112 = r8.getFeature(r7, r111, null);     // Catch: Exception -> L59
    L55:
        boolean r9 = com.bytedance.android.live.impl.utils.a.a;     // Catch: Exception -> L59
        com.bytedance.android.live.impl.utils.a.c("LFM-FeedFeatureManager", new FeedFeatureManager$getFeature$8(r3, r112));     // Catch: Exception -> L59
        z90.a.C0301a.a(FeatureManager.u, r11, r112);     // Catch: Exception -> L59
        if ((r112 instanceof Object) == true) goto L82;
        return null;
    L82:
        return r112;
    L54:
        r112 = null;
    L59:
        e = move-exception;
        boolean r113 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeedFeatureManager", new FeedFeatureManager$getFeature$9(r3, e), null);
        return null;
    L86:
        return null;
    L64:
        JSONObject r114 = b(r11);     // Catch: Exception -> L43
        if ((r114 instanceof Object) == true) goto L80;
        return null;
    L80:
        return r114;
    L43:
        e = move-exception;
        boolean r115 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeedFeatureManager", new FeedFeatureManager$getFeature$7(r3), e);
        return null;
    }

    public static Number c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "producerName");
        Intrinsics.checkNotNullParameter(r3, "featureName");
        IMiddlewareHostAction.ILiveFeedFeatureProducer r0 = (IMiddlewareHostAction.ILiveFeedFeatureProducer) b.getValue();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getNumericFeature(r2, r3, null);
    }
}
