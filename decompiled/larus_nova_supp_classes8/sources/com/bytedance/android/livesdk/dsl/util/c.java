package com.bytedance.android.livesdk.dsl.util;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/android/livesdk/dsl/util/c$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "dslservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<HashMap<String, Object>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/dsl/util/c$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "dslservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<HashMap<String, String>> {
        public b() {
        }
    }

    static {
    }

    public static HashMap g(String r2) {
        return (HashMap) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r2, new a().getType());
    }

    public static HashMap h(String r2) {
        return (HashMap) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r2, new b().getType());
    }

    public static Map a(Map r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r0 = null;
        if (r1 == null) goto L12;
        Object r3 = r1.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        if ((r3 instanceof Map) == false) goto L11;
        r0 = r3;
    L11:
        return (Map) r0;
    L12:
        return null;
    }

    public static boolean b(Map r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r1 == null) goto L7;
        Object r3 = r1.get(r2);
        if (r3 == null) goto L7;
        return com.bytedance.android.ecom.arch.slice.render.util.b.a(r3);
    L7:
        return false;
    }

    public static String c(Map r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "key");
        List r10 = StringsKt.split$default(r9, new String[]{"."}, false, 0, 6, null);
        if (r8 == null) goto L7;
        if (r8.isEmpty() != true) goto L7;
    L8:
        return null;
    L7:
        if (r10.isEmpty() == true) goto L8;
        if (r10.size() == 1) goto L12;
        Iterator r2 = r10.iterator();
        int r3 = 0;
        Map r4 = null;
    L15:
        if (r2.hasNext() == false) goto L30;
        Object r5 = r2.next();
        int r6 = r3 + 1;
        if (r3 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        String r7 = (String) r5;
        if (r3 != 0) goto L24;
        Map r11 = a(r8, r7);
    L22:
        r4 = r11;
        r3 = r6;
        goto L15
    L24:
        if (r3 == (r10.size() - 1)) goto L25;
        r11 = a(r4, r7);
        goto L22
    L25:
        if (r4 != null) goto L27;
        return null;
    L27:
        return d(r4, r7);
    L30:
        return null;
    L12:
        return d(r8, (String) CollectionsKt.first(r10));
    }

    public static String d(Map r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r1 == null) goto L7;
        Object r3 = r1.get(r2);
        if (r3 == null) goto L7;
        return com.bytedance.android.ecom.arch.slice.render.util.b.r(r3);
    L7:
        return null;
    }

    public static Map e(Map r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r0 = null;
        if (r1 == null) goto L5;
        Object r3 = r1.get(r2);
    L7:
        if ((r3 instanceof Map) == false) goto L11;
        r0 = r3;
    L11:
        return (Map) r0;
    L5:
        r3 = null;
        goto L7
    }

    public static Object f(List r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$safeGet");
        int r0 = r1.size();
        if (r2 < 0) goto L7;
        if (r0 <= r2) goto L7;
        return ListProtector.get(r1, r2);
    L7:
        return null;
    }
}
