package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.WriteMode;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final a d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f19384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jk.a f19385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k6.a f19386c;

    static {
        d = new a(new i(false, false, false, false, false, true, "    ", false, false, "type", false, true, false), kotlinx.serialization.modules.b.f19457a);
    }

    public b(i r5, jk.a r10) {
        this.f19384a = r5;
        this.f19385b = r10;
        this.f19386c = new k6.a(10);
    }

    public final l a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "string");
        n r5 = n.f19442a;
        Intrinsics.checkNotNullParameter(r5, "deserializer");
        Intrinsics.checkNotNullParameter(r10, "string");
        bi.e r11 = new bi.e(r10, 3);
        Object r12 = new kotlinx.serialization.json.internal.n(this, WriteMode.OBJ, r11, n.f19443b, null).w(r5);
        if (r11.i() == 10) goto L5;
        bi.e.q(r11, "Expected EOF after parsing, but had " + r10.charAt(r11.f930b - 1) + " instead", 0, null, 6);
        throw null;
    L5:
        return (l) r12;
    }
}
