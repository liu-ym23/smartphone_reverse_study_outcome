package com.bytedance.android.annie.container.fragment;

import android.net.Uri;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Map<String, WeakReference<IHybridComponent>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static String a(String r10) {
        String r0 = "";
        if (r10 != null) goto L5;
        return "";
    L5:
        Uri r11 = UriProtector.parse(r10);
        String r1 = UriProtector.getQueryParameter(r11, "card_cache_key");
        String r12 = null;
        if (r1 != null) goto L8;
    L13:
        String r13 = UriProtector.getQueryParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r13 == null) goto L17;
        r0 = r13;
    L17:
        Uri r14 = UriProtector.parse(r0);
        StringBuilder r15 = new StringBuilder();
        if (r14 == null) goto L20;
        String r16 = r14.getHost();
    L21:
        r15.append(r16);
        if (r14 == null) goto L24;
        r12 = r14.getPath();
    L24:
        r15.append(r12);
        r15.append("?&room_id=");
        r15.append(UriProtector.getQueryParameter(r11, com.bytedance.android.ec.core.event.a.KEY_ROOM_ID));
        return r15.toString();
    L20:
        r16 = null;
        goto L21
    L8:
        if (com.bytedance.forest.utils.h.a(r1) == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        return r1;
    }

    public static IHybridComponent b(String r1) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        Map<String, WeakReference<IHybridComponent>> r0 = a;
        r0.size();
        WeakReference r10 = (WeakReference) ((LinkedHashMap) r0).get(r1);
        if (r10 == null) goto L7;
        IHybridComponent r11 = (IHybridComponent) r10.get();
        if (r11 == null) goto L7;
        r11.toString();
        return r11;
    L7:
        return null;
    }

    public static void d(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Map<String, WeakReference<IHybridComponent>> r0 = a;
        WeakReference r1 = (WeakReference) ((LinkedHashMap) r0).get(r10);
        if (r1 == null) goto L7;
        IHybridComponent r11 = (IHybridComponent) r1.get();
        if (r11 == null) goto L7;
        r11.release();
    L7:
        r0.remove(r10);
        r0.size();
    }

    public static void c(String r10, IHybridComponent r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "component");
        Objects.toString(r11);
        Map<String, WeakReference<IHybridComponent>> r0 = a;
        r0.put(r10, new WeakReference(r11));
        r0.size();
    }
}
