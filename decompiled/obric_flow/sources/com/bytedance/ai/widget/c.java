package com.bytedance.ai.widget;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f2935a = null;

    static {
        f2935a = LazyKt.lazy(new a3.f(19));
        new Handler(Looper.getMainLooper());
        com.bytedance.ai.resource.j r5 = com.bytedance.ai.resource.j.f2734a;
        a r10 = new a();
        Intrinsics.checkNotNullParameter(r10, "listener");
        com.bytedance.ai.resource.j.f2735b.add(r10);
    }

    public static final void a(Function1 r5) {
        Lazy r10 = f2935a;
        GlobalWidgetCache$WidgetCacheMap r11 = (GlobalWidgetCache$WidgetCacheMap) r10.getValue();
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<Map.Entry<String, com.bytedance.ai.widget.contianer.f>> r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry<String, com.bytedance.ai.widget.contianer.f> r14 = r13.next();
        if (((Boolean) r5.invoke(r14)).booleanValue() == false) goto L4;
        r12.put(r14.getKey(), r14.getValue());
        goto L4
    L8:
        Iterator r15 = r12.keySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L14;
        String r16 = (String) r15.next();
        com.bytedance.ai.widget.contianer.f r17 = (com.bytedance.ai.widget.contianer.f) ((GlobalWidgetCache$WidgetCacheMap) r10.getValue()).remove(r16);
        if (r17 == null) goto L10;
        ((WidgetContainer) r17).k();
        ((AppletWidgetContainer) r17).u();
        goto L10
    }
}
