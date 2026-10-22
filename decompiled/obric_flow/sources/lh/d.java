package lh;

import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements dh.f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f19621h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19624c;
    public final String d;
    public final Map e;
    public final LoadFrom f;
    public final InputStream g;

    static {
        f19621h = Charset.defaultCharset().name();
    }

    public d(String r5, String r10, int r11, String r12, Map r13, LoadFrom r14, InputStream r15) {
        if (r5 != null) goto L5;
    L6:
        r5 = "text/html";
    L7:
        this.f19622a = r5;
        if (r10 != null) goto L10;
    L11:
        r10 = f19621h;
    L12:
        this.f19623b = r10;
        this.f19624c = r11;
        if (r12 != null) goto L15;
    L16:
        r12 = "";
    L17:
        this.d = r12;
        if (r13 != null) goto L20;
        this.e = new HashMap();
    L21:
        this.f = r14;
        this.g = r15;
        return;
    L20:
        this.e = r13;
        goto L21
    L15:
        if (r12.isEmpty() == false) goto L17;
    L10:
        if (r10.isEmpty() == false) goto L12;
    L5:
        if (r5.isEmpty() == false) goto L7;
        goto L6
    }

    @Override // dh.f
    public final LoadFrom a() {
        return this.f;
    }

    @Override // dh.f
    public final Map b() {
        return this.e;
    }

    @Override // dh.f
    public final String c() {
        return this.d;
    }

    @Override // dh.f
    public final String d() {
        return this.f19623b;
    }

    @Override // dh.f
    public final String e() {
        return this.f19622a;
    }

    @Override // dh.f
    public final InputStream getData() {
        return this.g;
    }

    @Override // dh.f
    public final int getStatusCode() {
        return this.f19624c;
    }
}
