package com.bytedance.ttnet.priority;

import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<String> f3306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f3307b;
    private Set<String> c;

    public g() {
        this.f3306a = new CopyOnWriteArraySet();
        this.f3307b = new CopyOnWriteArraySet();
        this.c = new CopyOnWriteArraySet();
    }

    private boolean a(Set<String> r2, String r3, Request.Builder r4, int r5, int r6) {
        if (TTHttpCallPriorityControl.a((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin"), r3) == false) goto L6;
        r4.priorityLevel(r5);
        r4.requestPriorityLevel(r6);
        return true;
    L6:
        return false;
    }

    public Request a(Request r10) {
        Request.Builder r6 = r10.newBuilder();
        if (a(this.f3306a, r10.getPath(), r6, 3, 4) == false) goto L7;
        return r6.build();
    L7:
        if (a(this.c, r10.getPath(), r6, -1, 1) == true) goto L9;
        int r0 = r10.getPriorityLevel();
        if (r0 < 3) goto L14;
        r0 = 1;
    L14:
        if (r0 > (-1)) goto L16;
        r0 = 0;
    L16:
        int r4 = r0;
        int r1 = r10.getRequestPriorityLevel();
        if (r1 < 4) goto L19;
        r1 = 3;
    L19:
        if (r1 < 1) goto L22;
        r1 = 2;
    L22:
        if (a(this.f3307b, r10.getPath(), r6, r4, r1) == false) goto L26;
        return r6.build();
    L26:
        return r6.priorityLevel(1).requestPriorityLevel(3).build();
    L9:
        return r6.build();
    }

    public void a(JSONObject r2) {
        this.f3306a = TTHttpCallPriorityControl.a(r2, "high");
        this.f3307b = TTHttpCallPriorityControl.a(r2, "normal");
        this.c = TTHttpCallPriorityControl.a(r2, "low");
    }
}
