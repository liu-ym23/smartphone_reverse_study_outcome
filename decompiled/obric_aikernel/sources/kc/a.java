package kc;

import com.bytedance.apm6.util.constant.NetConst;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.a0;
import okhttp3.l;
import okhttp3.m;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;
import okio.n;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBridgeInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BridgeInterceptor.kt\nokhttp3/internal/http/BridgeInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,117:1\n1864#2,3:118\n*S KotlinDebug\n*F\n+ 1 BridgeInterceptor.kt\nokhttp3/internal/http/BridgeInterceptor\n*L\n111#1:118,3\n*E\n"})
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f10159a;

    public a(m r10) {
        Intrinsics.checkNotNullParameter(r10, "cookieJar");
        this.f10159a = r10;
    }

    private final String b(List<l> r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator<T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L12;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        l r16 = (l) r14;
        if (r13 <= 0) goto L11;
        r11.append("; ");
    L11:
        r11.append(r16.e());
        r11.append('=');
        r11.append(r16.g());
        r13 = r15;
        goto L4
    L12:
        String r17 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "StringBuilder().apply(builderAction).toString()");
        return r17;
    }

    @Override // okhttp3.t
    public z a(t.a r13) {
        Intrinsics.checkNotNullParameter(r13, "chain");
        x r10 = r13.a();
        x.a r11 = r10.h();
        y r12 = r10.a();
        if (r12 == null) goto L11;
        u r14 = r12.b();
        if (r14 == null) goto L7;
        r11.d(NetConst.KEY_CONTENT_TYPE, r14.toString());
    L7:
        long r15 = r12.a();
        if (r15 == (-1)) goto L10;
        r11.d("Content-Length", String.valueOf(r15));
        r11.h("Transfer-Encoding");
        goto L11
    L10:
        r11.d("Transfer-Encoding", "chunked");
        r11.h("Content-Length");
    L11:
        boolean r16 = false;
        if (r10.d("Host") != null) goto L15;
        r11.d("Host", hc.e.S(r10.l(), false, 1, null));
    L15:
        if (r10.d("Connection") != null) goto L18;
        r11.d("Connection", "Keep-Alive");
    L18:
        if (r10.d(NetConst.KEY_ACCEPT_ENCODING) == null) goto L20;
    L22:
        List<l> r17 = this.f10159a.b(r10.l());
        if ((!r17.isEmpty()) == false) goto L26;
        r11.d("Cookie", b(r17));
    L26:
        if (r10.d("User-Agent") != null) goto L28;
        r11.d("User-Agent", hc.f.a());
    L28:
        z r18 = r13.b(r11.b());
        e.f(this.f10159a, r10.l(), r18.v());
        z.a r19 = r18.F().r(r10);
        if (r16 == false) goto L38;
        if (StringsKt.equals(NetConst.GZIP, z.s(r18, NetConst.KEY_CONTENT_ENCODING, null, 2, null), true) == false) goto L38;
        if (e.b(r18) == false) goto L38;
        a0 r20 = r18.a();
        if (r20 == null) goto L38;
        n r21 = new n(r20.k());
        r19.k(r18.v().e().g(NetConst.KEY_CONTENT_ENCODING).g("Content-Length").e());
        r19.b(new h(z.s(r18, NetConst.KEY_CONTENT_TYPE, null, 2, null), -1, okio.t.b(r21)));
    L38:
        return r19.c();
    L20:
        if (r10.d("Range") != null) goto L22;
        r11.d(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);
        r16 = true;
        goto L22
    }
}
