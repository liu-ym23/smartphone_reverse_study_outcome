package com.tom_roush.fontbox.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ab implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f15969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f15970b;
    private final List<String> c;

    public ab(d r3, i r4, List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.f15969a = r3;
        this.f15970b = r4;
        this.c = r6;
    }

    @Override // com.tom_roush.fontbox.f.c
    public int a(int r3) {
        int r0 = this.f15969a.a(r3);
        String[] r4 = y.a(r3);
        return this.f15970b.a(r0, r4, this.c);
    }

    @Override // com.tom_roush.fontbox.f.c
    public List<Integer> b(int r2) {
        return this.f15969a.b(this.f15970b.a(r2));
    }
}
