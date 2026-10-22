package io.noties.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class g implements h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pattern f16381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16382b;
    private final boolean c;
    private final String d;
    private final h.a e;

    public g(Pattern r3, boolean r4, boolean r5, String r6, h.a r7) {
        h.a r8 = (h.a) ZeusTransformUtils.wrapperContextForParams(r7, h.a.class, "com.obric.memorydata.plugin");
        this.f16381a = r3;
        this.f16382b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
    }

    @Override // io.noties.a.h.c
    public Pattern a() {
        return this.f16381a;
    }

    @Override // io.noties.a.h.c
    public boolean b() {
        return this.f16382b;
    }

    @Override // io.noties.a.h.c
    public boolean c() {
        return this.c;
    }

    @Override // io.noties.a.h.c
    public String d() {
        return this.d;
    }

    @Override // io.noties.a.h.c
    public h.a e() {
        return this.e;
    }

    public String toString() {
        return k.a(this);
    }
}
