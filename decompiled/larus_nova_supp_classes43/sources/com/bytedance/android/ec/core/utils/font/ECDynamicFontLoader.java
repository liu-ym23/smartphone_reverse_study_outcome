package com.bytedance.android.ec.core.utils.font;

import android.content.Context;
import android.graphics.Typeface;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECDynamicFontLoader implements e {
    public static final /* synthetic */ int d = 0;
    public final ConcurrentHashMap<String, Typeface> a;
    public final Lazy b;
    public final Map<String, String> c;

    public static final class a {
    }

    static {
    }

    public ECDynamicFontLoader(String r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r10, "fontName");
        Intrinsics.checkNotNullParameter(r11, "fontResConfig");
        this.c = r11;
        this.a = new ConcurrentHashMap();
        this.b = LazyKt.lazy(new ECDynamicFontLoader$liveForest$2(this));
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, String> r13 = r12.next();
        b(r13.getKey(), r13.getValue());
        goto L4
    }

    @Override // com.bytedance.android.ec.core.utils.font.e
    public final Typeface a(Context r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r12 = (RangesKt.coerceIn(r11, 100, IServerListener.WHAT_BYTELINK_SINK_ERROR) / 100) * 100;
        if (this.c.containsKey(String.valueOf(r12)) == false) goto L5;
        String r13 = String.valueOf(r12);
    L28:
        Typeface r14 = this.a.get(r13);
        if (r14 == null) goto L36;
        return r14;
    L36:
        String r15 = this.c.get(r13);     // Catch: Throwable -> L35
        if (r15 == null) goto L45;
        return b(r13, r15);
    L45:
        return null;
    L46:
        return null;
    L5:
        Set<String> r16 = this.c.keySet();
        ArrayList r1 = new ArrayList();
        Iterator<T> r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L11;
        Integer r18 = StringsKt.toIntOrNull((String) r17.next());
        if (r18 == null) goto L7;
        r1.add(r18);
        goto L7
    L11:
        Iterator r19 = r1.iterator();
        if (r19.hasNext() == true) goto L14;
        Object r20 = null;
    L23:
        Integer r21 = (Integer) r20;
        if (r21 == null) goto L27;
        r13 = String.valueOf(r21.intValue());
        if (r13 != null) goto L28;
    L27:
        r13 = String.valueOf(r12);
        goto L28
    L14:
        r20 = r19.next();
        if (r19.hasNext() == false) goto L23;
        int r22 = Math.abs(((Number) r20).intValue() - r12);
    L18:
        Object r23 = r19.next();
        int r24 = Math.abs(((Number) r23).intValue() - r12);
        if (r22 <= r24) goto L22;
        r20 = r23;
        r22 = r24;
    L22:
        if (r19.hasNext() == true) goto L18;
        goto L23
    }

    public final Typeface b(String r10, String r11) {
        RequestParams r0 = new RequestParams(0);
        Boolean r1 = Boolean.TRUE;
        r0.v = r1;
        com.bytedance.android.ec.sdk.helper.d r12 = com.bytedance.android.ec.sdk.helper.d.b;
        if (r12.getIECHostAppInfo().isDebug() == false) goto L5;
    L8:
        String r13 = "36723dc3e85a23e701d1697d57de07ed";
    L9:
        r0.b = r13;
        r0.s = 5;
        r0.u = r1;
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = null;
        ((Forest) this.b.getValue()).fetchResourceAsync(r11, r0, new ECDynamicFontLoader$fetchResourceAsync$1(r14));
        String r15 = (String) r14.element;
        if (r15 != null) goto L12;
        return null;
    L12:
        if (TypeFaceOptimizer.getSwitch() == false) goto L20;
        if (r15 == null) goto L20;
        if (TypeFaceLancet.cache.contains(r15) == false) goto L17;
        Typeface r16 = (Typeface) TypeFaceLancet.cache.get(r15);
    L21:
        if (r16 == null) goto L23;
        this.a.put(r10, r16);
    L23:
        return r16;
    L17:
        Typeface r17 = Typeface.createFromFile(r15);
        if (r17 == null) goto L20;
        TypeFaceLancet.cache.put(r15, r17);
        r16 = r17;
    L20:
        r16 = Typeface.createFromFile(r15);
        goto L21
    L5:
        if (r12.getIECHostAppInfo().isLocalTest() == true) goto L8;
        r13 = "5fb33cde3ebff01c8433ddc22aac0816";
        goto L9
    }
}
