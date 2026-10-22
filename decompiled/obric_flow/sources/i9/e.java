package i9;

import ai.j0;
import android.text.TextUtils;
import com.bytedance.crash.n;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f17534c;
    public final long d;
    public final long e;
    public final long f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f17535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final File f17536i;

    public e(File r10, File r11, long r12) {
        this.f17533b = null;
        this.f17534c = new ArrayList();
        this.f17535h = null;
        this.f17532a = r12;
        this.f17536i = r10;
        JSONArray r13 = cl.a.d(-1, r11);
        int r5 = 0;
    L4:
        if (r5 >= r13.length()) goto L20;
        String r14 = r13.optString(r5);
        if (TextUtils.isEmpty(r14) == true) goto L19;
        String[] r15 = r14.split("\\s+");
        if (r15.length != 4) goto L19;
        d r16 = new d();
        this.f17534c.add(r16);
        r16.f17529a = f.b(r15[0], -1);
        r16.f17530b = f.b(r15[1], -1);
        r16.f17531c = f.b(r15[2], -1);
        String r17 = r15[3];
        r16.d = r17;
        if (r5 == 0) goto L16;
        if (m.k(n.f4057a, r17) == false) goto L19;
    L16:
        if (m.k(n.f4057a, r17) == false) goto L18;
        this.f17533b = r17;
    L18:
        this.d = r16.f17529a;
        this.e = r16.f17530b;
        this.f = r16.f17531c;
        this.g = r16.d;
    L19:
        r5 = r5 + 1;
        goto L4
    L20:
        if (r10 != null) goto L22;
        return;
    L22:
        if (new File(r10, "hasJavaCrash").exists() == false) goto L25;
        this.f17535h = "java";
    L25:
        if (new File(r10, "hasNativeCrash").exists() == false) goto L32;
        String r18 = "native";
        if (this.f17535h == null) goto L30;
        r18 = j0.q(new StringBuilder(), this.f17535h, "native");
    L30:
        this.f17535h = r18;
    L32:
        if (new File(r10, "hashAnrCrash").exists() == false) goto L41;
        this.f17535h = "anr";
        return;
    }
}
