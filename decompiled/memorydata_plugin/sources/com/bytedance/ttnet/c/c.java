package com.bytedance.ttnet.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3217b;
    public int c;
    public List<String> d;
    public String e;

    public c(int r3, int r4, int r5, List<String> r6, String r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.f3216a = r3;
        this.f3217b = r4;
        this.c = r5;
        this.d = r8;
        this.e = r7;
    }
}
