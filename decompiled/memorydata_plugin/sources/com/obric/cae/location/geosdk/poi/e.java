package com.obric.cae.location.geosdk.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends LinkedHashMap<String, a.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f7222a;

    public e(a r3) {
        this.f7222a = r3;
        super(16, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry<String, a.j> r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        if (size() <= this.f7222a.j) goto L5;
        return true;
    L5:
        return false;
    }
}
