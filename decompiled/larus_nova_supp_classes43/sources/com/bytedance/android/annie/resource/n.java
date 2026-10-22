package com.bytedance.android.annie.resource;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.web.resource.ForestWebHelper;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n {
    public static final y9.m a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IHybridComponent.HybridType.values().length];
            r0[IHybridComponent.HybridType.LYNX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[IHybridComponent.HybridType.H5.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = AnnieConfigSettingKeys.FOREST_MEM_CACHE_CONFIG.a();
    }

    @JvmStatic
    public static final String a(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return ((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).t1(r10);
    }

    @JvmStatic
    public static final boolean c(IHybridComponent.HybridType r1) {
        Intrinsics.checkNotNullParameter(r1, "containerType");
        int r10 = a.a[r1.ordinal()];
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L8;
        return a.c();
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return a.a();
    }

    @JvmStatic
    public static final boolean f(String r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return e(r1, AnnieConfigSettingKeys.GECKO_LOADER_TTNET_ENGINE_DISALLOW_LIST.a());
    }

    @JvmStatic
    public static final boolean i(boolean r0) {
        if (r0 == true) goto L4;
    L6:
        return false;
    L4:
        if (AnnieConfigSettingKeys.LIVE_HYBRID_ENABLE_FOREST_SESSION.a().booleanValue() == false) goto L6;
        return true;
    }

    @JvmStatic
    public static final com.bytedance.android.annie.service.resource.d b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return ((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).b1(r10, r11);
    }

    @JvmStatic
    public static final String d(String r10, RequestConfig r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "config");
        com.bytedance.android.annie.service.resource.e r0 = (com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null);
        if (r0.l(r10) == false) goto L12;
        com.bytedance.android.annie.service.resource.h r12 = r0.o0(r10, r11);
        if (r12 == null) goto L13;
        o r13 = r12.b();
        if (r13 == null) goto L14;
        String r14 = r13.a;
        if (r14 != null) goto L11;
        return null;
    L11:
        return "file://".concat(r14);
    L14:
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    public static boolean e(String r10, List r11) {
        Iterator r12 = r11.iterator();
    L3:
        Object r13 = null;
        if (r12.hasNext() == false) goto L8;
        Object r0 = r12.next();
        if (StringsKt.contains$default(r10, (String) r0, false, 2, null) == false) goto L3;
        r13 = r0;
    L8:
        if (r13 == null) goto L14;
        return true;
    L14:
        return false;
    }

    @JvmStatic
    public static final com.bytedance.android.annie.service.resource.h h(String r10, RequestConfig r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "config");
        return ((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).o0(r10, r11);
    }

    @JvmStatic
    public static final com.bytedance.android.annie.service.resource.h g(String r10, RequestConfig r11, Function1<? super com.bytedance.android.annie.service.resource.i, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r12, "callback");
        return ((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).x(r10, r11, r12);
    }

    @JvmStatic
    public static final boolean j(String r10, IHybridComponent.HybridType r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "containerType");
        if (r10 != null) goto L6;
        return false;
    L6:
        if ((Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null) instanceof com.bytedance.android.annie.service.resource.b) == false) goto L9;
        return false;
    L9:
        if (AnnieConfigSettingKeys.FORCE_USE_FOREST.a().booleanValue() == false) goto L12;
        return true;
    L12:
        if (AnnieConfigSettingKeys.DISABLE_FOREST_LOADER.a().booleanValue() == false) goto L14;
        return false;
    L14:
        int[] r1 = a.a;
        int r13 = r1[r11.ordinal()];
        if (r13 == 1) goto L22;
        if (r13 == 2) goto L19;
    L24:
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        if (Intrinsics.areEqual(r12, "forest") == false) goto L30;
        return true;
    L30:
        if (Intrinsics.areEqual(r12, "default") == false) goto L32;
        return false;
    L32:
        int r14 = r1[r11.ordinal()];
        if (r14 == 1) goto L59;
        if (r14 == 2) goto L37;
    L61:
        return false;
    L37:
        if (e(r10, AnnieConfigSettingKeys.GECKO_LOADER_WHITE_LIST.a()) == false) goto L39;
        return true;
    L39:
        Iterator<String> r15 = ForestWebHelper.a().b().iterator();
    L41:
        if (r15.hasNext() == false) goto L54;
        if (StringsKt.contains$default(r10, r15.next(), false, 2, null) == false) goto L41;
        if (ForestWebHelper.a().a() <= 0) goto L41;
        Boolean r16 = Boolean.TRUE;
        if (ForestWebHelper.a().a() != 3) goto L49;
    L52:
        boolean r17 = true;
    L53:
        Pair r18 = new Pair(r16, Boolean.valueOf(r17));
    L56:
        if (((Boolean) r18.getFirst()).booleanValue() == false) goto L61;
        return true;
    L49:
        if (ForestWebHelper.a().a() == 4) goto L52;
        r17 = false;
        goto L53
    L54:
        Boolean r19 = Boolean.FALSE;
        r18 = new Pair(r19, r19);
        goto L56
    L59:
        if (e(r10, AnnieConfigSettingKeys.GECKO_LOADER_WHITE_LIST_LYNX.a()) == false) goto L61;
        return true;
    L19:
        if (e(r10, AnnieConfigSettingKeys.GECKO_LOADER_DISALLOW_LIST.a()) == false) goto L24;
        return false;
    L22:
        if (e(r10, AnnieConfigSettingKeys.GECKO_LOADER_DISALLOW_LIST_LYNX.a()) == false) goto L24;
        return false;
    }
}
