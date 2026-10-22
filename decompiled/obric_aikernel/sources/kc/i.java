package kc;

import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.s;
import okhttp3.x;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10179a = null;

    static {
        f10179a = new i();
    }

    private i() {
    }

    private final boolean b(x r10, Proxy.Type r11) {
        if (r10.f() == false) goto L5;
    L7:
        return false;
    L5:
        if (r11 != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public final String a(x r10, Proxy.Type r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "proxyType");
        StringBuilder r12 = new StringBuilder();
        r12.append(r10.g());
        r12.append(' ');
        i r13 = f10179a;
        boolean r14 = r13.b(r10, r11);
        s r15 = r10.l();
        if (r14 == false) goto L5;
        r12.append(r15);
    L6:
        r12.append(" HTTP/1.1");
        String r16 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");
        return r16;
    L5:
        r12.append(r13.c(r15));
        goto L6
    }

    public final String c(s r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        String r11 = r10.d();
        String r12 = r10.f();
        if (r12 != null) goto L5;
        return r11;
    L5:
        return r11 + '?' + r12;
    }
}
