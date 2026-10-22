package qa;

import ai.j0;
import android.app.Application;
import android.text.TextUtils;
import c2.c;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.d;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f21499a;

    public b(Application r5, String r10, File r11) {
        if (r5 == null) goto L11;
        if (TextUtils.isEmpty(r10) == true) goto L9;
        this.f21499a = new c(r10, r11);
        return;
    L9:
        throw new RuntimeException("access key is empty");
    L11:
        throw new RuntimeException("context is null");
    }

    public final String a(String r10) {
        c r5 = this.f21499a;
        r5.getClass();
        if (TextUtils.isEmpty(r10) == true) goto L54;
        String r11 = r10.trim();
        int r12 = r11.indexOf("/");
        if (r12 == (-1)) goto L52;
        String r13 = r11.substring(0, r12);
        HashMap r14 = r5.f1112b;
        monitor-enter(r14);
        a r15 = (a) r5.f1112b.get(r13);     // Catch: Throwable -> L11
        if (r15 != null) goto L13;
        r15 = new a(r5.f1113c, r5.d, r13);     // Catch: Throwable -> L11
        r5.f1112b.put(r13, r15);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r14);     // Catch: Throwable -> L11
        String r16 = r15.f21498c;
        monitor-enter(r15);
    L21:
        th = move-exception;
        throw th;
    L17:
        if (r15.f == null) goto L23;
        i4.a r17 = r15.f;     // Catch: Throwable -> L21
        monitor-exit(r15);
    L31:
        String r18 = r10.substring(r15.f21498c.length() + 1);
        File r19 = (File) r17.f17502b;
        File r20 = new File(r19, j0.q(new StringBuilder("res"), File.separator, r18));
        if (r20.getCanonicalPath().startsWith(r19.getCanonicalPath()) == false) goto L42;
        com.bytedance.geckox.c r21 = com.bytedance.geckox.b.f4736a;
        if (r20.exists() == false) goto L40;
        d.d(r20);     // Catch: Throwable -> L37
    L37:
        d.f(r20, (String) r17.f17503c, (String) r17.d, r18);
        d.j(r19);
        throw new IOException("file was broken");
    L40:
        return r20.getCanonicalFile().getAbsolutePath();
    L42:
        throw new IOException("file not found");
    L23:
        File r22 = r15.a(r16);     // Catch: Throwable -> L21
        if (r22 == null) goto L45;
        File r23 = new File(r22, "res");     // Catch: Throwable -> L21
        if (r23.exists() == false) goto L44;
        if (r23.isDirectory() == false) goto L44;
        r15.f = new i4.a(r22, 18);     // Catch: Throwable -> L21
        r15.f.f17503c = r15.f21496a;     // Catch: Throwable -> L21
        r15.f.d = r16;     // Catch: Throwable -> L21
        f.k(r15.f21496a, r16, Long.valueOf(Long.parseLong(r22.getName())), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Throwable -> L21
        r17 = r15.f;     // Catch: Throwable -> L21
        monitor-exit(r15);
    L44:
        throw new RuntimeException("can not find res, dir:" + r22.getAbsolutePath());     // Catch: Throwable -> L21
    L45:
        f.k(r15.f21496a, r16, null, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Throwable -> L21
        throw new FileNotFoundException(td.d.b("channel no exist，channel:", r16));     // Catch: Throwable -> L21
    L11:
        th = move-exception;
        throw th;
    L52:
        throw new RuntimeException("channel is needed：".concat(r11));
    L54:
        throw new RuntimeException("relativePath is empty");
    }

    public final void b() {
        c r5 = this.f21499a;
        HashMap r10 = r5.f1112b;
        monitor-enter(r10);
        Iterator r11 = r5.f1112b.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r11.hasNext() == false) goto L10;
        ((a) r11.next()).b();     // Catch: Throwable -> L8
        goto L6
    L10:
        r5.f1112b.clear();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final Long c(String r5) {
        c r10 = this.f21499a;
        r10.getClass();
        HashMap r11 = new HashMap();
        HashMap r12 = r10.f1112b;
        monitor-enter(r12);
        Collection r13 = r10.f1112b.values();     // Catch: Throwable -> L8
        if (r13 != null) goto L10;
        monitor-exit(r12);     // Catch: Throwable -> L8
    L16:
        return (Long) r11.get(r5);
    L10:
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L8
    L12:
        if (r14.hasNext() == false) goto L14;
        a r15 = (a) r14.next();     // Catch: Throwable -> L8
        r11.put(r15.f21498c, r15.e);     // Catch: Throwable -> L8
        goto L12
    L14:
        monitor-exit(r12);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public final void finalize() {
        super.finalize();
        GeckoLogger.a("gecko loader finalize lock");
        b();
    }
}
