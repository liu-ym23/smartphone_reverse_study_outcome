package qi;

import com.bytedance.sdk.xbridge.cn.auth.e;
import ib.d;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import li.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f21515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f21516b = null;

    static {
        f21516b = new ConcurrentHashMap();
    }

    public static ni.a a(String r5) {
        ConcurrentHashMap r10 = f21516b;
        ni.a r11 = (ni.a) r10.get(r5);
        ConcurrentHashMap r12 = e.f7342a;
        Intrinsics.checkNotNullParameter(r5, "namespace");
        ConcurrentHashMap r13 = e.f7344c;
        if (r13.get(r5) == null) goto L11;
        Object r14 = r13.get(r5);
        Intrinsics.checkNotNull(r14);
        if (((Boolean) r14).booleanValue() == true) goto L11;
        if (e.f7343b.get(r5) == null) goto L11;
        throw new ClassCastException();
    L11:
        f r15 = (f) e.f7342a.get(r5);
        if (r15 == null) goto L14;
        LinkedHashMap r16 = r15.f19655a;
    L15:
        if (r16 == null) goto L24;
        if (r11 == null) goto L18;
        Intrinsics.checkNotNullParameter(r16, "config");
        r11.f20263a = r16;
        ki.a.a("update config for namespace: ".concat(r5));
        goto L24
    L18:
        if (f21515a == null) goto L20;
        int r17 = 128;
    L21:
        ni.a r18 = new ni.a(r5, r17, r16);
        r10.put(r5, r18);
        ki.a.a("create config for namespace: ".concat(r5));
        return r18;
    L20:
        r17 = 32;
    L24:
        return r11;
    L14:
        r16 = null;
        goto L15
    }
}
