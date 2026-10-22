package io.noties.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class i implements h.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<? extends h.b> f16385b;
    private final String c;
    private final String d;
    private final boolean e;
    private final boolean f;

    public i(String r3, List<? extends h.b> r4, String r5, String r6, boolean r7, boolean r8) {
        List<? extends h.b> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f16384a = r3;
        this.f16385b = r9;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }

    @Override // io.noties.a.h.b
    public int a() {
        return this.d.length();
    }

    @Override // io.noties.a.h.b
    public final boolean b() {
        return true;
    }

    @Override // io.noties.a.h.d
    public String c() {
        return this.f16384a;
    }

    @Override // io.noties.a.h.d
    public List<? extends h.b> d() {
        return this.f16385b;
    }

    @Override // io.noties.a.h.d
    public String e() {
        return this.c;
    }

    @Override // io.noties.a.h.d
    public boolean f() {
        return this.e;
    }

    public String toString() {
        return "SyntaxImpl{type='" + this.f16384a + "', children=" + this.f16385b + ", alias='" + this.c + "', matchedString='" + this.d + "', greedy=" + this.e + ", tokenized=" + this.f + '}';
    }
}
