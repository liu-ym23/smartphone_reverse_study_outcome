package com.bytedance.android.livesdk.dslservice.gecko;

import android.os.SystemClock;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v26.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class GeckoUtils {
    public static final ConcurrentHashMap<String, a> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(String r9, String r10, String r11, Function3 r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r9, "tag");
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r13, "onError");
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        ConcurrentHashMap<String, a> r1 = a;
        r8.element = r1.get(r11);
        b r2 = new b(r12, r13);
        a r14 = (a) r8.element;
        if (r14 != null) goto L5;
        a r15 = new a(r11);
        r8.element = r15;
        r1.put(r11, r15);
        a r16 = (a) r8.element;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r2, "geckoRequestCallback");
        r16.a.add(r2);
        long r5 = SystemClock.uptimeMillis();
        boolean r17 = OfflineResourceClient.a;
        GeckoUtils$loadAsyncFromGecko$1 r18 = new GeckoUtils$loadAsyncFromGecko$1(r9, r10, r5, r11, r8);
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r18, "callback");
        l r19 = new l();
        v26.a r110 = new v26.a(false);
        r110.a(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.CDN}));
        Unit r111 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r19.b = r110;
        OfflineResourceClient.b(r11, r19, r18);
        return;
    L5:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r2, "geckoRequestCallback");
        r14.a.add(r2);
    }
}
