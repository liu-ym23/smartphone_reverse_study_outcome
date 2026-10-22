package o61;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l61.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final Keva a = null;
    public static k61.a b;
    public static n61.a c;
    public static boolean d;
    public static final PropertyOwner<Boolean> e = null;
    public static final PropertyOwner f = null;
    public static final PropertyOwner<Boolean> g = null;
    public static final PropertyOwner h = null;
    public static final Set<b> i = null;
    public static final Set<String> j = null;
    public static final PropertyOwner<String> k = null;
    public static final PropertyOwner l = null;
    public static boolean m;

    static {
        Keva r0 = Keva.getRepo("exp_app_store");
        a = r0;
        List r1 = StringsKt.split$default(r0.getString("normal_fluency_info", ""), new String[]{","}, false, 0, 6, null);
        boolean r2 = false;
        if (r1 != null) goto L5;
    L38:
        PropertyOwner<Boolean> r3 = new PropertyOwner(Boolean.valueOf(r2));
        e = r3;
        f = r3;
        PropertyOwner<Boolean> r4 = new PropertyOwner(Boolean.FALSE);
        g = r4;
        h = r4;
        i = new LinkedHashSet();
        j = new LinkedHashSet();
        PropertyOwner<String> r5 = new PropertyOwner(b());
        k = r5;
        l = r5;
        m = true;
        return;
    L5:
        if (r1.size() < 2) goto L7;
        boolean r6 = true;
    L8:
        Long r7 = null;
        if (r6 == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L38;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L15
        Object r9 = Result.constructor-impl(Boolean.valueOf(Boolean.parseBoolean((String) ListProtector.get(r1, 0))));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r9) == false) goto L21;
        r9 = null;
    L21:
        if (Intrinsics.areEqual((Boolean) r9, Boolean.TRUE) == false) goto L38;
        Long r10 = StringsKt.toLongOrNull((String) ListProtector.get(r1, 1));
        if (r10 != null) goto L25;
    L37:
        r2 = !r2;
        goto L38
    L25:
        if (r10.longValue() <= 0) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == false) goto L30;
        r7 = r10;
    L30:
        if (r7 == null) goto L37;
        if (Long.valueOf(System.currentTimeMillis() - r7.longValue()).longValue() < (PlatformExpUtils.c().j() * ((long) 86400000))) goto L34;
        boolean r13 = true;
    L35:
        if (r13 != true) goto L37;
        r2 = true;
        goto L37
    L34:
        r13 = false;
        goto L35
    L27:
        r12 = false;
    L15:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L7:
        r6 = false;
        goto L8
    }

    public static String b() {
        if (d == false) goto L16;
        Set<b> r0 = i;
        if (r0.isEmpty() == false) goto L7;
        return "当前性能状态优秀，无需优化。重启APP后将关闭流畅看播";
    L7:
        StringBuilder r1 = new StringBuilder("当前性能状态一般，已为你优化");
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r3 = r0.iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        r2.add(((b) r3.next()).getDesc());
        goto L9
    L11:
        Set r4 = CollectionsKt.toMutableSet(r2);
        String r5 = CollectionsKt.joinToString$default(CollectionsKt.take(r4, 5), "、", null, null, 0, null, null, 62, null);
        StringBuilder r6 = new StringBuilder();
        r6.append(r5);
        if (r4.size() <= 5) goto L14;
        String r7 = "等" + r4.size() + 20010;
    L15:
        r6.append(r7);
        r1.append(r6.toString());
        r1.append("功能。重启APP后将关闭流畅看播");
        return r1.toString();
    L14:
        r7 = "";
        goto L15
    L16:
        return "开启后，基于性能状态，为你自动优化动画和功能表现，减少性能负载、耗能，提升看播的流畅度";
    }

    public static void a(boolean r2) {
        ILiveExpMiddlewareService r0 = (ILiveExpMiddlewareService) k.f(ILiveExpMiddlewareService.class);
        if (r0 == null) goto L5;
        r0.shouldResetPerfBySwitchClose(!r2);
    L5:
        g.a(Boolean.valueOf(r2));
    }

    public static void c(boolean r4) {
        ILiveExpMiddlewareService r0 = (ILiveExpMiddlewareService) k.f(ILiveExpMiddlewareService.class);
        if (r0 == null) goto L5;
        r0.shouldResetPerfBySwitchClose(!r4);
    L5:
        Keva r1 = a;
        StringBuilder r2 = new StringBuilder();
        r2.append(r4);
        r2.append(',');
        r2.append(System.currentTimeMillis());
        r1.storeString("normal_fluency_info", r2.toString());
        e.a(Boolean.valueOf(r4));
    }

    public static void d(b r1) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        i.remove(r1);
        k.a(b());
    }
}
