package oi;

import com.lynx.tasm.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f20583c = null;
    public static final List d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f20584b;

    static {
        f20583c = CollectionsKt.mutableListOf(new Class[]{c.class, b.class});
        d = CollectionsKt.mutableListOf(new Class[]{e.class, c.class, b.class});
    }

    public d(ArrayList r5) {
        this.f20584b = r5;
    }

    @Override // oi.a
    public final String a() {
        return "PermissionConfigLoaderChain";
    }

    @Override // oi.a
    public final void b(ib.d r5) {
    }

    @Override // oi.a
    public final JSONObject c() {
        ArrayList r10 = this.f20584b;
        Iterator r5 = r10.iterator();     // Catch: Throwable -> L13
    L5:
        if (r5.hasNext() == false) goto L15;
        a r11 = (a) r5.next();     // Catch: Throwable -> L13
        JSONObject r12 = r11.c();     // Catch: Throwable -> L13
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L13
        r13.append("PermissionConfigLoaderChain: loaderList size:");     // Catch: Throwable -> L13
        r13.append(r10.size());     // Catch: Throwable -> L13
        r13.append(" loader=");     // Catch: Throwable -> L13
        r13.append(r11.a());     // Catch: Throwable -> L13
        r13.append(" resp==null: ");     // Catch: Throwable -> L13
        if (r12 != null) goto L9;
        boolean r14 = true;
    L10:
        r13.append(r14);     // Catch: Throwable -> L13
        ki.a.a(r13.toString());     // Catch: Throwable -> L13
        if (r12 == null) goto L5;
        String r15 = r11.a();     // Catch: Throwable -> L13
    L16:
        if (r12 == null) goto L26;
        ib.d r16 = qi.a.f21515a;     // Catch: Throwable -> L13
        qi.a.f21515a = p.f10926c;     // Catch: Throwable -> L13
        if (p.f10926c == null) goto L24;
        ul.d r17 = jm.c.f18359c;     // Catch: Throwable -> L13
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("geckoConfigs");     // Catch: Throwable -> L13
        r17 = null;
    L23:
        String r18 = ((ul.c) CollectionsKt.first(r17.getAppConfigs())).getAccessKey(zm.p.a());     // Catch: Throwable -> L13
    L25:
        com.bytedance.sdk.xbridge.cn.auth.e.d(r12, r18, r15);     // Catch: Throwable -> L13
        i.a.k();     // Catch: Throwable -> L13
    L32:
        return null;
    L24:
        r18 = null;
        goto L25
    L26:
        ki.a.a("PermissionConfigLoaderChain: finalResp is null");     // Catch: Throwable -> L13
        goto L32
    L9:
        r14 = false;
        goto L10
    L15:
        r15 = null;
        r12 = null;
    L13:
        th = move-exception;
        String r19 = th.getMessage();
        if (r19 != null) goto L31;
        r19 = "unknown error";
    L31:
        ki.a.a("PermissionConfigLoaderChain: load error, e=".concat(r19));
        goto L32
    }
}
