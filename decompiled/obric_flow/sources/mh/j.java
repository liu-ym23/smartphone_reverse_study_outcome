package mh;

import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements dh.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f20107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20108b;

    public j(String r10, HashMap r11) {
        if (r11 == null) goto L5;
        this.f20107a = new HashMap(r11);
    L6:
        boolean r5 = false;
        if (r10.lastIndexOf("</body>") == (-1)) goto L9;
        boolean r12 = true;
    L11:
        if (r10.lastIndexOf("</html>") == (-1)) goto L13;
        r5 = true;
    L13:
        if (r12 == true) goto L17;
        if (r5 == true) goto L17;
        this.f20108b = r10.concat("</body></html>");
        return;
    L17:
        if (r5 == true) goto L20;
        this.f20108b = r10.concat("</html>");
        return;
    L20:
        this.f20108b = r10;
        return;
    L9:
        r12 = false;
        goto L11
    L5:
        this.f20107a = new HashMap();
        goto L6
    }

    @Override // dh.f
    public final LoadFrom a() {
        return LoadFrom.f6956b;
    }

    @Override // dh.f
    public final Map b() {
        return this.f20107a;
    }

    @Override // dh.f
    public final String c() {
        return "OK";
    }

    @Override // dh.f
    public final String d() {
        return "UTF-8";
    }

    @Override // dh.f
    public final String e() {
        return "text/html";
    }

    @Override // dh.f
    public final InputStream getData() {
        return new ByteArrayInputStream(this.f20108b.getBytes());
    }

    @Override // dh.f
    public final int getStatusCode() {
        return 200;
    }
}
