package com.bytedance.ies.web.jsbridge2;

import ai.j0;
import android.net.Uri;
import android.text.TextUtils;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c5.a f6269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f6270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f6271c;
    public final Set d;
    public final LinkedHashSet e;
    public final boolean f;
    public final u g;

    public c(d r5, u r10) {
        this.f6270b = new ConcurrentHashMap();
        this.f6271c = new ConcurrentHashMap();
        new ArrayList();
        this.d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.g = r10;
        this.f6269a = new c5.a(r5.f6276i, r5.f6277j, r5.f6280m);
        this.e = r5.g;
        this.f = r5.f;
        t r11 = new t();
        r11.a("config", Boolean.FALSE);
        r11.b("label_create_call_handler", r5.f6278k);
    }

    public final String a() {
        if (this.f6270b.isEmpty() == false) goto L5;
    L15:
        u r5 = this.g;
        if (r5 != null) goto L18;
        return "not_registered_2empty";
    L18:
        if (r5.d == false) goto L24;
        return "not_registered_2_release_empty";
    L24:
        return "not_registered_2empty";
    L5:
        if (this.f6271c.isEmpty() == true) goto L15;
        u r10 = this.g;
        if (r10 != null) goto L10;
        return "not_registered_2_re";
    L10:
        if (r10.d == false) goto L23;
        return "not_registered_2_release";
    L23:
        return "not_registered_2_re";
    }

    public final t9.a b(l r14, zm.c r15) {
        f r5 = (f) this.f6270b.get(r14.d);
        String r10 = (String) r15.f23470b;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L6:
        String r11 = this.g.b();
        if (TextUtils.isEmpty(r11) == true) goto L10;
        r15.f23470b = r11;
        t r12 = new t();
        r12.a("url", r11);
        r12.b("label_call_new_url", (CopyOnWriteArrayList) r14.f6296l);
    L10:
        if (r5 == null) goto L109;
        CopyOnWriteArrayList r13 = (CopyOnWriteArrayList) r14.f6296l;
        c5.a r16 = this.f6269a;
        boolean r17 = this.f;
        String r18 = (String) r15.f23470b;
        monitor-enter(r16);
        t r19 = new t();     // Catch: Throwable -> L21
        r19.a("url", r18);     // Catch: Throwable -> L21
        r19.a("enable_permission_check", Boolean.valueOf(r17));     // Catch: Throwable -> L21
        r19.a("method_name", r5.f6281a);     // Catch: Throwable -> L21
        r19.a("method_class", r5.getClass().getSimpleName());     // Catch: Throwable -> L21
        r19.a("method_permission_group", r5.f6282b);     // Catch: Throwable -> L21
        r19.b("label_permission_checker", r13);     // Catch: Throwable -> L21
        Uri r20 = Uri.parse(r18);     // Catch: Throwable -> L21
        if (r16.f1118b == true) goto L16;
    L23:
        String r21 = r20.getHost();     // Catch: Throwable -> L21
        boolean r22 = ((LinkedHashSet) r16.d).contains(r5.f6281a);     // Catch: Throwable -> L21
        t r23 = new t();     // Catch: Throwable -> L21
        if (r22 == false) goto L26;
        String r110 = PermissionGroup.f6261a.toString();     // Catch: Throwable -> L21
    L27:
        r23.a("call_permission_group", r110);     // Catch: Throwable -> L21
        r23.a("public_method_set", (LinkedHashSet) r16.d);     // Catch: Throwable -> L21
        r23.b("label_permission_public_method", r13);     // Catch: Throwable -> L21
        if (r21 != null) goto L37;
        t r24 = new t();     // Catch: Throwable -> L21
        r24.a("host", "null");     // Catch: Throwable -> L21
        r24.b("label_permission_checker_null_host", r13);     // Catch: Throwable -> L21
        if (r22 == false) goto L33;
        PermissionGroup r25 = PermissionGroup.f6261a;     // Catch: Throwable -> L21
    L34:
        monitor-exit(r16);
    L67:
        if (r25 != null) goto L89;
        String r26 = "permission_empty_1";
        if (TextUtils.isEmpty((String) r15.f23470b) == false) goto L71;
    L72:
        r26 = "about_blank_1";
    L73:
        t r27 = new t();
        r27.a("reason", "permission_empty_1");
        r27.b("label_call_handler_reject", (CopyOnWriteArrayList) r14.f6296l);
        String r111 = (String) r15.f23470b;
        String r28 = r14.d;
        CopyOnWriteArrayList r29 = (CopyOnWriteArrayList) r14.f6296l;
        Iterator r30 = this.e.iterator();
    L75:
        if (r30.hasNext() == false) goto L77;
        i r31 = (i) r30.next();
        m r32 = o.d;
        CopyOnWriteArrayList r33 = this.g.f6314h;
        r31.d(r111, r28, 1, r26, new z(r29));
        goto L75
    L77:
        Iterator r112 = this.e.iterator();
    L79:
        if (r112.hasNext() == false) goto L87;
        ((i) r112.next()).getClass();     // Catch: Throwable -> L83 AbstractMethodError -> L85
    L85:
        e = move-exception;
        new StringBuilder("onRejected AbstractMethodError").append(e.getMessage());
    L83:
        th = move-exception;
        new StringBuilder("onRejected error").append(th.getMessage());
        goto L79
    L87:
        r14.toString();
        throw new JsBridgeException(-1, "Permission denied");
    L71:
        if ("about:blank".equals((String) r15.f23470b) == false) goto L73;
    L89:
        new t().b("label_pre_handle_origin_url", (CopyOnWriteArrayList) r14.f6296l);
        if ((r5 instanceof f) == false) goto L109;
        r14.toString();
        o.d.a();
        String r34 = r14.d;
        c5.a r113 = new c5.a(r34, new com.lynx.animax.player.b(4, this, false, r14));
        ce.d r114 = new ce.d();
        r114.f1180c = r34;
        r114.d = new JSONObject(r14.e);
        r114.f1179b = r14.f;
        r114.f1178a = r14.f6291c;
        r114.e = 0;
        r114.f = (String) r14.f6292h;
        r114.g = (String) r14.f6293i;
        r114.f1183j = true;
        r114.f1182i = r25.toString();
        JSONObject r115 = new JSONObject();
        r114.toString();
        r5.f6283c.a(r114, r115);     // Catch: Exception -> L118
    L94:
        if (r114.f1183j == true) goto L96;
        r114.toString();
    L105:
        return new t9.a();
    L96:
        String r116 = r115.toString();
        boolean r117 = r113.f1118b;
        String r35 = (String) r113.f1119c;
        if (r117 == true) goto L99;
        StringBuilder r36 = j0.x("Jsb async call already finished: ", r35, ", stub: ");
        r36.append(r113.hashCode());
        new IllegalStateException(r36.toString());
    L99:
        if (r116 == null) goto L103;
        com.lynx.animax.player.b r118 = (com.lynx.animax.player.b) r113.d;
        u r37 = ((c) r118.f9658c).g;
        if (r37 == null) goto L103;
        r37.e(r116, (l) r118.f9657b);
    L103:
        r113.f1118b = false;
        goto L105
    L33:
        r25 = null;
        goto L34
    L37:
        if (r5.f6282b == PermissionGroup.d) goto L49;
        Iterator r38 = ((LinkedHashSet) r16.f1119c).iterator();     // Catch: Throwable -> L21
    L40:
        if (r38.hasNext() == false) goto L48;
        String r119 = (String) r38.next();     // Catch: Throwable -> L21
        if (r20.getHost().equals(r119) == true) goto L45;
        if (r21.endsWith("." + r119) == false) goto L40;
    L45:
        t r39 = new t();     // Catch: Throwable -> L21
        PermissionGroup r40 = PermissionGroup.f6263c;     // Catch: Throwable -> L21
        r39.a("call_permission_group", r40.toString());     // Catch: Throwable -> L21
        r39.a("host", r21);     // Catch: Throwable -> L21
        r39.a("safe_host_set", (LinkedHashSet) r16.f1119c);     // Catch: Throwable -> L21
        r39.b("label_permission_checker_safe_host", r13);     // Catch: Throwable -> L21
        monitor-exit(r16);     // Catch: Throwable -> L21
        r25 = r40;
        goto L67
    L48:
        t r41 = new t();     // Catch: Throwable -> L21
        r41.a("call_permission_group", "null");     // Catch: Throwable -> L21
        r41.a("host", r21);     // Catch: Throwable -> L21
        r41.a("safe_host_set", (LinkedHashSet) r16.f1119c);     // Catch: Throwable -> L21
        r41.b("label_permission_checker_safe_host", r13);     // Catch: Throwable -> L21
    L49:
        if (r17 == false) goto L57;
        monitor-enter(r16);     // Catch: Throwable -> L21
        t r42 = new t();     // Catch: Throwable -> L54
        r42.a("call_permission_group", "null");     // Catch: Throwable -> L54
        r42.a("config", "null");     // Catch: Throwable -> L54
        r42.b("label_permission_checker_null_config", r13);     // Catch: Throwable -> L54
        monitor-exit(r16);     // Catch: Throwable -> L21
        goto L57
    L54:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L57:
        if (r22 == false) goto L59;
        PermissionGroup r43 = PermissionGroup.f6261a;     // Catch: Throwable -> L21
    L60:
        t r44 = new t();     // Catch: Throwable -> L21
        if (r43 != null) goto L63;
        String r45 = "null";
    L64:
        r44.a("call_permission_group", r45);     // Catch: Throwable -> L21
        r44.b("label_permission_checker_result", r13);     // Catch: Throwable -> L21
        monitor-exit(r16);     // Catch: Throwable -> L21
        r25 = r43;
        goto L67
    L63:
        r45 = r43.toString();     // Catch: Throwable -> L21
        goto L64
    L59:
        r43 = null;
        goto L60
    L26:
        r110 = "null";
        goto L27
    L16:
        if ("http".equalsIgnoreCase(r20.getScheme()) == true) goto L23;
        if (IIvyAIPackageResourceService.SCHEMA.equalsIgnoreCase(r20.getScheme()) == true) goto L23;
        monitor-exit(r16);
        r25 = null;
    L21:
        th = move-exception;
        throw th;
    L109:
        if (this.f6271c.get(r14.d) != null) goto L117;
        t r46 = new t();
        r46.a("reason", a());
        r46.b("label_call_handler_reject", (CopyOnWriteArrayList) r14.f6296l);
        String r120 = (String) r15.f23470b;
        String r47 = r14.d;
        String r48 = a();
        CopyOnWriteArrayList r49 = (CopyOnWriteArrayList) r14.f6296l;
        Iterator r121 = this.e.iterator();
    L112:
        if (r121.hasNext() == false) goto L114;
        i r50 = (i) r121.next();
        m r51 = o.d;
        CopyOnWriteArrayList r52 = this.g.f6314h;
        r50.d(r120, r47, 2, r48, new z(r49));
        goto L112
    L114:
        StringBuilder r122 = new StringBuilder("Received call: ");
        r122.append(r14);
        r122.append(", but not registered.");
        return null;
    L117:
        throw new ClassCastException();
    L5:
        if ("about:blank".equals(r10) == false) goto L10;
        goto L6
    }
}
