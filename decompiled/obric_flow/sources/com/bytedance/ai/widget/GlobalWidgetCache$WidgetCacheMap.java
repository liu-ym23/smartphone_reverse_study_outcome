package com.bytedance.ai.widget;

import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/ai/widget/GlobalWidgetCache$WidgetCacheMap", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/ai/widget/contianer/f;", "Lkotlin/collections/LinkedHashMap;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalWidgetCache$WidgetCacheMap extends LinkedHashMap<String, com.bytedance.ai.widget.contianer.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1 f2913b;

    public GlobalWidgetCache$WidgetCacheMap(int r5) {
        super(r5);
        this.f2912a = r5;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r5) {
        if ((r5 instanceof String) == true) goto L7;
        return false;
    L7:
        return super.containsKey((String) r5);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r5) {
        if ((r5 instanceof com.bytedance.ai.widget.contianer.f) == true) goto L7;
        return false;
    L7:
        return super.containsValue((com.bytedance.ai.widget.contianer.f) r5);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r5) {
        if ((r5 instanceof String) == true) goto L7;
        return null;
    L7:
        return (com.bytedance.ai.widget.contianer.f) super.get((String) r5);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r5, Object r10) {
        if ((r5 instanceof String) == true) goto L6;
        return r10;
    L6:
        return (com.bytedance.ai.widget.contianer.f) super.getOrDefault((String) r5, (com.bytedance.ai.widget.contianer.f) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object r5) {
        if ((r5 instanceof String) == true) goto L7;
        return null;
    L7:
        return (com.bytedance.ai.widget.contianer.f) super.remove((String) r5);
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry<String, com.bytedance.ai.widget.contianer.f> r10) {
        if (size() <= this.f2912a) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L26;
        Lazy r11 = c.f2935a;
        StringBuilder r12 = new StringBuilder("remove eldest widget ");
        com.bytedance.ai.widget.contianer.f r13 = null;
        if (r10 == null) goto L10;
        com.bytedance.ai.widget.contianer.f r14 = r10.getValue();
    L11:
        r12.append(r14);
        String r15 = r12.toString();
        Intrinsics.checkNotNullParameter("WidgetGlobalCache", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L14;
        r16.d("WidgetGlobalCache", r15);
    L14:
        Function1 r17 = this.f2913b;
        if (r17 == null) goto L20;
        if (r10 == null) goto L18;
        com.bytedance.ai.widget.contianer.f r18 = r10.getValue();
    L19:
        r17.invoke(r18);
        goto L20
    L18:
        r18 = null;
    L20:
        if (r10 == null) goto L22;
        r13 = r10.getValue();
    L22:
        if (r13 == null) goto L24;
        ((WidgetContainer) r13).k();
    L24:
        if (r13 == null) goto L26;
        ((AppletWidgetContainer) r13).u();
        goto L26
    L10:
        r14 = null;
    L26:
        return r5;
    L5:
        r5 = false;
        goto L6
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r5, Object r10) {
        if ((r5 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r10 instanceof com.bytedance.ai.widget.contianer.f) == true) goto L9;
        return false;
    L9:
        return super.remove((String) r5, (com.bytedance.ai.widget.contianer.f) r10);
    }
}
