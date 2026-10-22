package com.ss.android.lark.framework.assembly.emoji_office;

import a6c.a;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.utils.ApiUtils;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import qpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class StickerCoreDependencyImpl$resourceDependency$1 implements a {
    public StickerCoreDependencyImpl$resourceDependency$1() {
    }

    public final Map<String, c6c.a> b(Map<String, ? extends Resource> r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r7 == null) goto L14;
        Iterator r1 = CollectionsKt.filterNotNull(r7.keySet()).iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        String r2 = (String) r1.next();
        Resource r3 = r7.get(r2);
        if (r3 == null) goto L10;
        c6c.a r4 = new c6c.a(r3.a, r3.b);
    L11:
        if (r4 == null) goto L6;
        r0.put(r2, r4);
        goto L6
    L10:
        r4 = null;
    L14:
        return r0;
    }

    public final Map<String, c6c.a> a(String r6, List<String> r7) {
        ArrayList r0 = new ArrayList();
        if (r7 != null) goto L5;
        r7 = CollectionsKt.emptyList();
    L5:
        Iterator<String> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        String r1 = r8.next();
        if (r6 != null) goto L11;
        String r3 = "";
    L12:
        r0.add(new ResourceRequestBaseSet(r1, r3, null, null));
        goto L7
    L11:
        r3 = r6;
        goto L12
    L14:
        return b(((e) ApiUtils.getApi(e.class)).synGetResources(r0));
    }

    public Map<String, c6c.a> getResources(String r6, List<String> r7) {
        ArrayList r0 = new ArrayList();
        if (r7 != null) goto L5;
        r7 = CollectionsKt.emptyList();
    L5:
        Iterator<String> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        String r1 = r8.next();
        if (r6 != null) goto L11;
        String r3 = "";
    L12:
        r0.add(new ResourceRequestBaseSet(r1, r3, null, null));
        goto L7
    L11:
        r3 = r6;
        goto L12
    L14:
        return b(((e) ApiUtils.getApi(e.class)).getResources(r0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getResources(String r6, List<String> r7, final IGetDataCallback<Map<String, c6c.a>> r8) {
        ArrayList r0 = new ArrayList();
        if (r7 != null) goto L5;
        r7 = CollectionsKt.emptyList();
    L5:
        Iterator<String> r9 = r7.iterator();
    L7:
        if (r9.hasNext() == false) goto L13;
        String r1 = r9.next();
        if (r6 != null) goto L11;
        String r3 = "";
    L12:
        r0.add(new ResourceRequestBaseSet(r1, r3, null, null));
        goto L7
    L11:
        r3 = r6;
        goto L12
    L13:
        ((e) ApiUtils.getApi(e.class)).getResources(r0, -99, new StickerCoreDependencyImpl$resourceDependency$1$getResources$1(r8, this));
    }
}
